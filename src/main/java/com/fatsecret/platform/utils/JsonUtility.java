package com.fatsecret.platform.utils;

import org.json.JSONObject;

public class JsonUtility {

    public static String getPropertyValue (JSONObject jsonObject, String propertyName) {
        return ((jsonObject.has(propertyName) && !jsonObject.isNull(propertyName))) ? jsonObject.getString(propertyName) : null;
    }

}
