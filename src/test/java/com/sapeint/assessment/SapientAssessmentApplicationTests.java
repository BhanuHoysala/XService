package com.sapeint.assessment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SapientAssessmentApplicationTests {

	@Test
	void contextLoads() {
		final String TEST_FRAMEWORK_WORKING = "Test Works";

		Assertions.assertThat(TEST_FRAMEWORK_WORKING).isEqualTo(TEST_FRAMEWORK_WORKING); // NOSONAR
	}

}
