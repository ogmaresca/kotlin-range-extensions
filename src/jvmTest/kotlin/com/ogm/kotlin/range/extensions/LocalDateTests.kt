package com.ogm.kotlin.range.extensions

import java.time.LocalDate
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class LocalDateTests {
	private val now = LocalDate.now()

	init {
		Assertions.setMaxStackTraceElementsDisplayed(1_000)
	}

	@Test
	fun emptyRangeTest() {
		assertThat(LocalDateRange.EMPTY.isEmpty()).isTrue
		assertThat(LocalDateRange.EMPTY.start).isAfter(LocalDateRange.EMPTY.endInclusive)
		assertThat(now in LocalDateRange.EMPTY).isFalse
		assertThatExceptionOfType(NoSuchElementException::class.java).isThrownBy {
			LocalDateRange.EMPTY.iterator().next()
		}

		assertThat((now..now.minusDays(1)).isEmpty()).isTrue
		assertThat(now in now..now.minusDays(1)).isFalse
	}

	@Test
	fun rangeTest() {
		val range = now.minusDays(1)..now.plusDays(1)

		(2L..1000L).forEach {
			assertThat(range.contains(now.minusYears(it))).isFalse
			assertThat(range.contains(now.minusMonths(it))).isFalse
			assertThat(range.contains(now.minusWeeks(it))).isFalse
			assertThat(range.contains(now.minusDays(it))).isFalse
			assertThat(range.contains(now.plusYears(it))).isFalse
			assertThat(range.contains(now.plusMonths(it))).isFalse
			assertThat(range.contains(now.plusWeeks(it))).isFalse
			assertThat(range.contains(now.plusDays(it))).isFalse
		}

		assertThat(range.contains(now.minusYears(1))).isFalse
		assertThat(range.contains(now.minusMonths(1))).isFalse
		assertThat(range.contains(now.minusWeeks(1))).isFalse
		assertThat(range.contains(now.minusDays(1))).isTrue
		assertThat(range.contains(now)).isTrue
		assertThat(range.contains(now.plusYears(1))).isFalse
		assertThat(range.contains(now.plusMonths(1))).isFalse
		assertThat(range.contains(now.plusWeeks(1))).isFalse
		assertThat(range.contains(now.plusDays(1))).isTrue


		assertThat(range).containsExactly(now.minusDays(1), now, now.plusDays(1))

		assertThat(range.toString()).isEqualTo("${now.minusDays(1)}..${now.plusDays(1)}")

		assertThat(range).isEqualTo(now.minusDays(1)..now.plusDays(1))
		assertThat(range).isNotEqualTo(now..now.plusDays(1))
		assertThat(range).isNotEqualTo(now.minusDays(1)..now)
		assertThat(range).isNotEqualTo(now..now)
		assertThat(range).isNotEqualTo(now.plusDays(1)..now.minusDays(1))
		assertThat(range).isNotEqualTo(now.minusDays(2)..now.plusDays(1))
		assertThat(range).isNotEqualTo(now.minusDays(1)..now.plusDays(2))
		assertThat(range).isNotEqualTo(now.minusDays(2)..now.plusDays(2))
	}
}
