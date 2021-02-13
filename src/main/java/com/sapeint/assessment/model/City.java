/*
 * Copyright (c) 2021 Payoneer Germany GmbH. All rights reserved.
 */
package com.sapeint.assessment.model;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {

	UUID id;

	String name;

	String country;
}
