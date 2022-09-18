package com.ogm.kotlin.range.extensions

import java.time.LocalDate
import java.time.Period
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

	@Suppress("CAST_NEVER_SUCCEEDS")
	@Test
	fun progressionTest() {
		assertThat((now.minusDays(10)..now.plusDays(10)).step(Period.ofDays(2)))
			.satisfies {
				assertThat((it as LocalDateProgression).isEmpty()).isFalse
				assertThat((it as LocalDateProgression).first).isEqualTo(now.minusDays(10))
				assertThat((it as LocalDateProgression).last).isEqualTo(now.plusDays(10))
				assertThat(it.toString()).isEqualTo(
					"${now.minusDays(10)}..${now.plusDays(10)} step P2D"
				)
				assertThat(it.hashCode()).isNotIn(-1, 0)
			}.containsExactly(
				now.minusDays(10),
				now.minusDays(8),
				now.minusDays(6),
				now.minusDays(4),
				now.minusDays(2),
				now,
				now.plusDays(2),
				now.plusDays(4),
				now.plusDays(6),
				now.plusDays(8),
				now.plusDays(10),
			)

		assertThat((now.minusDays(10)..now.plusDays(10)).step(Period.ofDays(3)))
			.satisfies {
				assertThat((it as LocalDateProgression).isEmpty()).isFalse
				assertThat((it as LocalDateProgression).first).isEqualTo(now.minusDays(10))
				assertThat((it as LocalDateProgression).last).isEqualTo(now.plusDays(8))
				assertThat(it.toString()).isEqualTo(
					"${now.minusDays(10)}..${now.plusDays(8)} step P3D"
				)
				assertThat(it.hashCode()).isNotIn(-1, 0)
			}.containsExactly(
				now.minusDays(10),
				now.minusDays(7),
				now.minusDays(4),
				now.minusDays(1),
				now.plusDays(2),
				now.plusDays(5),
				now.plusDays(8),
			)

		assertThat(
			(now.minusMonths(10)..now.plusMonths(10))
				.step(Period.ofMonths(2).plusDays(2)),
		).satisfies {
			val expectedLast = now.plusMonths(8).plusDays(18)
			assertThat((it as LocalDateProgression).isEmpty()).isFalse
			assertThat((it as LocalDateProgression).first).isEqualTo(now.minusMonths(10))
			assertThat((it as LocalDateProgression).last).isEqualTo(expectedLast)
			assertThat(it.toString()).isEqualTo(
				"${now.minusMonths(10)}..$expectedLast step P2M2D"
			)
			assertThat(it.hashCode()).isNotIn(-1, 0)
		}.containsExactly(
			now.minusMonths(10),
			now.minusMonths(8).plusDays(2),
			now.minusMonths(6).plusDays(4),
			now.minusMonths(4).plusDays(6),
			now.minusMonths(2).plusDays(8),
			now.plusDays(10),
			now.plusMonths(2).plusDays(12),
			now.plusMonths(4).plusDays(14),
			now.plusMonths(6).plusDays(16),
			now.plusMonths(8).plusDays(18),
		)

		assertThat((now.minusDays(10)..now.plusDays(10)).step(Period.ofDays(-1)))
			.satisfies {
				assertThat((it as LocalDateProgression).isEmpty()).isTrue
				assertThat((it as LocalDateProgression).first).isEqualTo(now.minusDays(10))
				assertThat((it as LocalDateProgression).last).isEqualTo(now.plusDays(10))
				assertThat(it.toString()).isEqualTo(
					"${now.minusDays(10)} downTo ${now.plusDays(10)} step P-1D"
				)
				assertThat(it.hashCode()).isEqualTo(-1)
			}

		assertThatExceptionOfType(NoSuchElementException::class.java).isThrownBy {
			(now..now.minusDays(1)).step(Period.ofDays(1)).iterator().next()
		}

		assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
			(now..now.minusDays(1)).step(Period.ofDays(0)).iterator().next()
		}

		assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
			(now..now.minusDays(1)).step(Period.ofMonths(0)).iterator().next()
		}
	}

	@Suppress("CAST_NEVER_SUCCEEDS")
	@Test
	fun negativeProgressionTest() {
		assertThat((now.plusDays(10) downTo now.minusDays(10)).step(Period.ofDays(2)))
			.satisfies {
				assertThat((it as LocalDateProgression).isEmpty()).isFalse
				assertThat((it as LocalDateProgression).first).isEqualTo(now.minusDays(10))
				assertThat((it as LocalDateProgression).last).isEqualTo(now.plusDays(10))
				assertThat(it.toString()).isEqualTo(
					"${now.minusDays(10)}..${now.plusDays(10)} step P2D"
				)
				assertThat(it.hashCode()).isNotIn(-1, 0)
			}.containsExactly(
				now.minusDays(10),
				now.minusDays(8),
				now.minusDays(6),
				now.minusDays(4),
				now.minusDays(2),
				now,
				now.plusDays(2),
				now.plusDays(4),
				now.plusDays(6),
				now.plusDays(8),
				now.plusDays(10),
			)

		assertThat((now.plusDays(10) downTo now.minusDays(10)).step(Period.ofDays(3)))
			.satisfies {
				assertThat((it as LocalDateProgression).isEmpty()).isFalse
				assertThat((it as LocalDateProgression).first).isEqualTo(now.minusDays(10))
				assertThat((it as LocalDateProgression).last).isEqualTo(now.plusDays(8))
				assertThat(it.toString()).isEqualTo(
					"${now.minusDays(10)}..${now.plusDays(8)} step P3D"
				)
				assertThat(it.hashCode()).isNotIn(-1, 0)
			}.containsExactly(
				now.minusDays(10),
				now.minusDays(7),
				now.minusDays(4),
				now.minusDays(1),
				now.plusDays(2),
				now.plusDays(5),
				now.plusDays(8),
			)

		assertThat(
			(now.plusMonths(10) downTo now.minusMonths(10))
				.step(Period.ofMonths(2).plusDays(2)),
		).satisfies {
			val expectedLast = now.plusMonths(8).plusDays(18)
			assertThat((it as LocalDateProgression).isEmpty()).isFalse
			assertThat((it as LocalDateProgression).first).isEqualTo(now.minusMonths(10))
			assertThat((it as LocalDateProgression).last).isEqualTo(expectedLast)
			assertThat(it.toString()).isEqualTo(
				"${now.minusMonths(10)}..$expectedLast step P2M2D"
			)
			assertThat(it.hashCode()).isNotIn(-1, 0)
		}.containsExactly(
			now.minusMonths(10),
			now.minusMonths(8).plusDays(2),
			now.minusMonths(6).plusDays(4),
			now.minusMonths(4).plusDays(6),
			now.minusMonths(2).plusDays(8),
			now.plusDays(10),
			now.plusMonths(2).plusDays(12),
			now.plusMonths(4).plusDays(14),
			now.plusMonths(6).plusDays(16),
			now.plusMonths(8).plusDays(18),
		)

		assertThat((now.plusDays(10) downTo now.minusDays(10)).step(Period.ofDays(-1)))
			.satisfies {
				assertThat((it as LocalDateProgression).isEmpty()).isTrue
				assertThat((it as LocalDateProgression).first).isEqualTo(now.minusDays(10))
				assertThat((it as LocalDateProgression).last).isEqualTo(now.plusDays(10))
				assertThat(it.toString()).isEqualTo(
					"${now.minusDays(10)} downTo ${now.plusDays(10)} step P-1D"
				)
				assertThat(it.hashCode()).isEqualTo(-1)
			}

		assertThatExceptionOfType(NoSuchElementException::class.java).isThrownBy {
			(now.minusDays(1) downTo now).step(Period.ofDays(1)).iterator().next()
		}

		assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
			(now.minusDays(1) downTo now).step(Period.ofDays(0)).iterator().next()
		}

		assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
			(now.minusDays(1) downTo now).step(Period.ofMonths(0)).iterator().next()
		}
	}

	@Test
	fun mapToTest() {
		assertThat((-1L..1L).mapToLocalDate { now.plusDays(it) }.toString())
			.isEqualTo("${now.minusDays(1)}..${now.plusDays(1)}")
	}

	@Test
	fun randomTest() {
		val range = now..now.plusDays(10)
		repeat(1_000_000) {
			assertThat(range.random()).isAfterOrEqualTo(now).isBeforeOrEqualTo(now.plusDays(10))
		}

		assertThatExceptionOfType(IllegalStateException::class.java)
			.isThrownBy { LocalDateRange.EMPTY.random() }
	}

	@Test
	fun randomOrNullTest() {
		val range = now..now.plusDays(10)
		repeat(1_000_000) {
			assertThat(range.randomOrNull())
				.isNotNull
				.isAfterOrEqualTo(now)
				.isBeforeOrEqualTo(now.plusDays(10))
		}

		assertThat(LocalDateRange.EMPTY.randomOrNull()).isNull()
	}

	@Test
	fun toRangeTest() {
		val range = (now..now.plusDays(1)).mapRange { it }
		assertThat(range).isExactlyInstanceOf(Class.forName("kotlin.ranges.ComparableRange"))
		assertThat(range.toLocalDateRange()).isExactlyInstanceOf(LocalDateRange::class.java)
	}

	@Test
	fun reversedTest() {
		assertThat((now..now.plusDays(1)).reversed().toString())
			.isEqualTo("${now.plusDays(1)}..$now")
	}

	@Test
	fun reversedIfEmptyTest() {
		assertThat((now..now.plusDays(1)).reversedIfEmpty().toString())
			.isEqualTo("$now..${now.plusDays(1)}")
		assertThat((now.plusDays(1)..now).reversedIfEmpty().toString())
			.isEqualTo("$now..${now.plusDays(1)}")
	}

	@Test
	fun equalsTest() {
		assertThat(now..now.plusDays(1)).isEqualTo(now..now.plusDays(1))
		assertThat(now..now.plusDays(1)).isNotEqualTo(now..now.plusDays(2))
		assertThat(now..now.plusDays(1)).isNotEqualTo(now..now)
		assertThat(now..now.plusDays(1)).isNotEqualTo(now.plusDays(1)..now)
	}

	@Test
	fun progressionEqualsTest() {
		assertThat((now..now.plusDays(1)).step(Period.ofDays(2)))
			.isEqualTo((now..now.plusDays(1)).step(Period.ofDays(2)))
		assertThat((now..now.plusDays(1)).step(Period.ofDays(2)))
			.isNotEqualTo((now..now.plusDays(1)).step(Period.ofDays(1)))
		assertThat((now..now.plusDays(2)).step(Period.ofDays(2)))
			.isNotEqualTo((now..now.plusDays(1)).step(Period.ofDays(2)))
		assertThat((now..now).step(Period.ofDays(2)))
			.isEqualTo((now..now.plusDays(1)).step(Period.ofDays(2)))
		assertThat((now.plusDays(1)..now).step(Period.ofDays(2)))
			.isNotEqualTo((now..now.plusDays(1)).step(Period.ofDays(2)))
	}
}
