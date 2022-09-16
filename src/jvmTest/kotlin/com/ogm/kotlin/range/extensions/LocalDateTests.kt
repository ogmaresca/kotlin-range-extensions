package com.ogm.kotlin.range.extensions

import java.time.LocalDate.now
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class LocalDateTests {
	@Test
	fun emptyTest() {
		assertThat(LocalDateRange.EMPTY.isEmpty()).isTrue
		assertThat(LocalDateRange.EMPTY.start).isAfter(LocalDateRange.EMPTY.endInclusive)
		assertThat(now() in LocalDateRange.EMPTY).isFalse
		assertThatExceptionOfType(NoSuchElementException::class.java).isThrownBy {
			LocalDateRange.EMPTY.iterator().next()
		}

		assertThat((now()..now().minusDays(1)).isEmpty()).isTrue
		assertThat(now() in now()..now().minusDays(1)).isFalse
	}
}
