package com.fatsecret.platform.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class FoodCategory {

  private final long id;
  private final String name;
  private final String description;

}
