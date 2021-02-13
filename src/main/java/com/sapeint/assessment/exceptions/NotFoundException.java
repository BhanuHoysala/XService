/*
 * Copyright (c) 2021 Payoneer Germany GmbH. All rights reserved.
 */
package com.sapeint.assessment.exceptions;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NotFoundException extends Exception {

	public static final String REQUESTED_DATA_NOT_AVAILABLE = "Requested data not found %s";

	public NotFoundException(final String message) {
		super(message);
	}
}

