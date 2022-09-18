package com.ogm.kotlin.range.extensions

import java.time.Period
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PeriodComparableWrapperTests {
	init {
		Assertions.setMaxStackTraceElementsDisplayed(1_000)
	}

	@Test
	fun compareToDaysTest() {
		val value = Period.ofDays(60).toComparable()

		(-1_000..0).forEach {
			assertThat(value).isGreaterThan(Period.ofDays(it).toComparable())
			assertThat(value).isGreaterThan(Period.ofMonths(it).toComparable())
			assertThat(value).isGreaterThan(Period.ofYears(it).toComparable())
		}

		(1..59).forEach {
			assertThat(value).isGreaterThan(Period.ofDays(it).toComparable())
			assertThat(value).isLessThan(Period.ofMonths(it).toComparable())
			assertThat(value).isLessThan(Period.ofYears(it).toComparable())
		}

		(60..60).forEach {
			assertThat(value).isEqualByComparingTo(Period.ofDays(it).toComparable())
			assertThat(value).isLessThan(Period.ofMonths(it).toComparable())
			assertThat(value).isLessThan(Period.ofYears(it).toComparable())
		}

		(61..1_000).forEach {
			assertThat(value).isLessThan(Period.ofDays(it).toComparable())
			assertThat(value).isLessThan(Period.ofMonths(it).toComparable())
			assertThat(value).isLessThan(Period.ofYears(it).toComparable())
		}
	}

	@Test
	fun compareToMonthsTest() {
		val value = Period.ofYears(2).plusMonths(6).toComparable()

		(-1_000..1).forEach {
			assertThat(value).isGreaterThan(Period.ofDays(it).toComparable())
			assertThat(value).isGreaterThan(Period.ofMonths(it).toComparable())
			assertThat(value).isGreaterThan(Period.ofYears(it).toComparable())

			(1L..11L).forEach { months ->
				assertThat(value).isGreaterThan(Period.ofYears(it).plusMonths(months).toComparable())
			}
		}

		(2..2).forEach {
			assertThat(value).isGreaterThan(Period.ofDays(it).toComparable())
			assertThat(value).isGreaterThan(Period.ofMonths(it).toComparable())
			assertThat(value).isGreaterThan(Period.ofYears(it).toComparable())

			(1L..5L).forEach { months ->
				assertThat(value).isGreaterThan(Period.ofYears(it).plusMonths(months).toComparable())
			}

			assertThat(value).isEqualByComparingTo(Period.ofYears(2).plusMonths(6).toComparable())

			(7L..11L).forEach { months ->
				assertThat(value).isLessThan(Period.ofYears(it).plusMonths(months).toComparable())
			}
		}

		(3..29).forEach {
			assertThat(value).isGreaterThan(Period.ofDays(it).toComparable())
			assertThat(value).isGreaterThan(Period.ofMonths(it).toComparable())
			assertThat(value).isLessThan(Period.ofYears(it).toComparable())

			(1L..11L).forEach { months ->
				assertThat(value).isLessThan(Period.ofYears(it).plusMonths(months).toComparable())
			}
		}

		(30..30).forEach {
			assertThat(value).isGreaterThan(Period.ofDays(it).toComparable())
			assertThat(value).isEqualByComparingTo(Period.ofMonths(it).toComparable())
			assertThat(value).isLessThan(Period.ofYears(it).toComparable())

			(1L..11L).forEach { months ->
				assertThat(value).isLessThan(Period.ofYears(it).plusMonths(months).toComparable())
			}
		}

		(31..1_000).forEach {
			assertThat(value).isGreaterThan(Period.ofDays(it).toComparable())
			assertThat(value).isLessThan(Period.ofMonths(it).toComparable())
			assertThat(value).isLessThan(Period.ofYears(it).toComparable())

			(1L..11L).forEach { months ->
				assertThat(value).isLessThan(Period.ofYears(it).plusMonths(months).toComparable())
			}
		}
	}

	@Test
	fun toStringTest() {
		assertThat(Period.of(27, 9, 3).toString()).isEqualTo("P27Y9M3D")
	}

	@Test
	fun constantsTest() {
		assertThat(PeriodComparableWrapper.ZERO).isEqualTo(Period.ZERO.toComparable())
	}

	@Test
	fun chronoPeriodImplementationTest() {
		assertThat(Period.ofDays(1).toComparable().multipliedBy(5)).isEqualTo(Period.ofDays(5))
	}
}
