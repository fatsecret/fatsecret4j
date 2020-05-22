/*
 * Copyright (C) 2016 Saurabh Rane
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fatsecret.platform.services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * This class helps in building requests for sending them to the fatsecret rest api
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class RequestBuilder {

  /**
   * A value FatSecret API issues to you which helps this API identify you
   */
  final private String APP_KEY;

  /**
   * A secret FatSecret API issues to you which helps this API establish that it really is you
   */
  final private String APP_SECRET;

  /**
   * Request URL
   * <p>
   * The URL to make API calls is http://platform.fatsecret.com/rest/server.api
   */
  final private String APP_URL = "http://platform.fatsecret.com/rest/server.api";

  /**
   * The signature method allowed by FatSecret API
   * <p>
   * They only support "HMAC-SHA1"
   */
  final private String APP_SIGNATURE_METHOD = "HmacSHA1";

  /**
   * The HTTP Method supported by FatSecret API
   * <p>
   * This API only supports GET method
   */
  final private String HTTP_METHOD = "GET";


  /**
   * Constructor to set values for APP_KEY and APP_SECRET
   *
   * @param APP_KEY    a value FatSecret API issues to you which helps this API identify you
   * @param APP_SECRET a secret FatSecret API issues to you which helps this API establish that it
   *                   really is you
   */
  public RequestBuilder(String APP_KEY, String APP_SECRET) {
    this.APP_KEY = APP_KEY;
    this.APP_SECRET = APP_SECRET;
  }

  /**
   * Returns randomly generated nonce value for calling the request.
   *
   * @return the randomly generated value for nonce.
   */
  public String nonce() {
    Random r = new Random();
    StringBuilder n = new StringBuilder();
    for (int i = 0; i < r.nextInt(8) + 2; i++) {
      n.append(r.nextInt(26) + 'a');
    }
    return n.toString();
  }

  /**
   * Returns all the oauth parameters and other parameters.
   *
   * @return an array of parameter values as "key=value" pair
   */
  public String[] generateOauthParams() {
    return new String[]{
        "oauth_consumer_key=" + APP_KEY,
        "oauth_signature_method=HMAC-SHA1",
        "oauth_timestamp=" + System.currentTimeMillis() / 1000,
        "oauth_nonce=" + nonce(),
        "oauth_version=1.0",
        "format=json"
    };
  }

  /**
   * Returns the string generated using params and separator
   *
   * @param params    an array of parameter values as "key=value" pair
   * @param separator a separator for joining
   * @return the string by appending separator after each parameter from params except the last.
   */
  public String join(String[] params, String separator) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < params.length; i++) {
      if (i > 0) {
        b.append(separator);
      }
      b.append(params[i]);
    }
    return b.toString();
  }

  /**
   * Returns string generated using params and "&amp;" for signature base and normalized parameters
   *
   * @param params an array of parameter values as "key=value" pair
   * @return the string by appending separator after each parameter from params except the last.
   */
  public String paramify(String[] params) {
    String[] p = Arrays.copyOf(params, params.length);
    Arrays.sort(p);
    return join(p, "&");
  }

  /**
   * Returns the percent-encoded string for the given url
   *
   * @param url URL which is to be encoded using percent-encoding
   * @return the encoded url
   */
  public String encode(String url) {
    if (url == null) {
      return "";
    }

    try {
      return URLEncoder.encode(url, "utf-8")
          .replace("+", "%20")
          .replace("!", "%21")
          .replace("*", "%2A")
          .replace("\\", "%27")
          .replace("(", "%28")
          .replace(")", "%29");
    } catch (UnsupportedEncodingException wow) {
      throw new RuntimeException(wow.getMessage(), wow);
    }
  }

  /**
   * Returns the signature generated using signature base as text and consumer secret as key
   *
   * @param method http method
   * @param uri    request URL - http://platform.fatsecret.com/rest/server.api (Always remains the
   *               same)
   * @param params an array of parameter values as "key=value" pair
   * @return oauth_signature which will be added to request for calling fatsecret api
   */
  public String sign(String method, String uri, String[] params) {
    String encodedURI = encode(uri);
    String encodedParams = encode(paramify(params));

    String[] p = {method, encodedURI, encodedParams};

    String text = join(p, "&");
    String key = APP_SECRET + "&";
    SecretKey sk = new SecretKeySpec(key.getBytes(), APP_SIGNATURE_METHOD);
    String sign = "";
    try {
      Mac m = Mac.getInstance(APP_SIGNATURE_METHOD);
      m.init(sk);
      sign = encode(new String(Base64.encode(m.doFinal(text.getBytes()), Base64.DEFAULT)).trim());
    } catch (java.security.NoSuchAlgorithmException e) {
      System.out.println("NoSuchAlgorithmException: " + e.getMessage());
    } catch (java.security.InvalidKeyException e) {
      System.out.println("InvalidKeyException: " + e.getMessage());
    }
    return sign;
  }

  /**
   * Returns the rest url which will be sent to fatsecret platform server for searching food items
   * based on search terms and page number
   *
   * @param query        search terms for querying food items
   * @param pageNumber   page Number to search the food items
   * @param countryCode  country code representing the {@link com.fatsecret.platform.model.Country}
   * @param languageCode language code representing the {@link com.fatsecret.platform.model.Language}
   * @return rest url which will be sent to fatsecret platform server for searching food items
   */
  public String buildFoodsSearchUrl(String query, int pageNumber, String countryCode,
      String languageCode) {
    List<String> params = new ArrayList<>(Arrays.asList(generateOauthParams()));
    String[] template = new String[1];
    params.add("method=foods.search");
    params.add("max_results=50");
    params.add("page_number=" + pageNumber);
    params.add("search_expression=" + encode(query));
    params.add("region=" + countryCode);
    params.add("language=" + languageCode);
    params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

    return APP_URL + "?" + paramify(params.toArray(template));
  }

  /**
   * Returns the rest url which will be sent to fatsecret platform server for searching unique food
   * item
   *
   * @param id                   the unique food identifier
   * @param countryCode          country code representing the {@link com.fatsecret.platform.model.Country}
   * @param languageCode         language code representing the {@link com.fatsecret.platform.model.Language}
   * @param includeSubCategories flag to include sub categories in response
   * @return rest url which will be sent to fatsecret platform server for searching unique food item
   */
  public String buildFoodGetUrl(Long id, String countryCode, String languageCode,
      boolean includeSubCategories) {
    List<String> params = new ArrayList<>(Arrays.asList(generateOauthParams()));
    String[] template = new String[1];
    params.add("method=food.get");
    params.add("food_id=" + id);
    params.add("region=" + countryCode);
    params.add("language=" + languageCode);
    params.add("include_sub_categories=" + includeSubCategories);
    params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

    return APP_URL + "?" + paramify(params.toArray(template));
  }

  /**
   * Returns the rest url which will be sent to fatsecret platform server for searching recipes
   *
   * @param query      search terms for querying recipes
   * @param pageNumber page Number to search the recipes
   * @return rest url which will be sent to fatsecret platform server for searching recipes
   */
  public String buildRecipesSearchUrl(String query, int pageNumber) {
    List<String> params = new ArrayList<>(Arrays.asList(generateOauthParams()));
    String[] template = new String[1];
    params.add("method=recipes.search");
    params.add("max_results=50");
    params.add("page_number=" + pageNumber);
    params.add("search_expression=" + encode(query));
    params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

    return APP_URL + "?" + paramify(params.toArray(template));
  }

  /**
   * Returns the rest url which will be sent to fatsecret platform server for searching unique
   * recipe
   *
   * @param id the unique recipe identifier
   * @return rest url which will be sent to fatsecret platform server for searching unique recipe
   */
  public String buildRecipeGetUrl(Long id) {
    List<String> params = new ArrayList<>(Arrays.asList(generateOauthParams()));
    String[] template = new String[1];
    params.add("method=recipe.get");
    params.add("recipe_id=" + id);
    params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

    return APP_URL + "?" + paramify(params.toArray(template));
  }

  /**
   * Returns the rest url which will be sent to fatsecret platform server for searching unique food
   * sub categories.
   *
   * @param foodCategoryId the unique food category identifier
   * @return rest url which will be sent to fatsecret platform server for searching unique food sub
   * categories
   */
  public String buildFoodSubCategoriesGetUrl(Long foodCategoryId) {
    List<String> params = new ArrayList<>(Arrays.asList(generateOauthParams()));
    String[] template = new String[1];
    params.add("method=food_sub_categories.get");
    params.add("food_category_id=" + foodCategoryId);
    params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

    return APP_URL + "?" + paramify(params.toArray(template));
  }

  /**
   * Returns the rest url which will be sent to fatsecret platform server for retrieving all food
   * categories.
   *
   * @return rest url which will be sent to fatsecret platform server for retrieving all food
   * categories
   */
  public String buildFoodCategoriesGetUrl() {
    List<String> params = new ArrayList<>(Arrays.asList(generateOauthParams()));
    String[] template = new String[1];
    params.add("method=food_categories.get");
    params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

    return APP_URL + "?" + paramify(params.toArray(template));
  }
}