package com.ogm.kotlin.range.extensions

import java.math.BigDecimal

data class BigDecimalRange(override val start: BigDecimal, override val endInclusive: BigDecimal, private val open: Boolean = false) :
	ClosedRange<BigDecimal>,
	Iterable<BigDecimal> {
	private val step: BigDecimal
		get() {
			val scale = start.scale().coerceAtMost(endInclusive.scale()).coerceAtLeast(0)
			return BigDecimal.ONE.movePointLeft(scale)
		}

	override fun iterator(): Iterator<BigDecimal> = BigDecimalProgression.fromClosedRange(
		if (open) {
			start..(endInclusive - step)
		} else {
			this
		},
		step,
	).iterator()

	override fun contains(value: BigDecimal): Boolean = start <= value && if (open) endInclusive > value else endInclusive >= value

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = BigDecimal.ONE..BigDecimal.ZERO
	}
}

/**
 * Create a closed [BigDecimalRange] from [this] value to the specified [that] value.
 * The [BigDecimalRange] implements [Iterable], with a step of 1 divided by 10 to the
 * power of the greatest number of decimal place of [this] or [that].
 */
operator fun BigDecimal.rangeTo(that: BigDecimal) = BigDecimalRange(this, that)

/**
 * Create a closed [BigDecimalRange] from [this] value to the specified [that] value.
 * The [BigDecimalRange] implements [Iterable], with a step of 1 divided by 10 to the
 * power of the greatest number of decimal place of [this] or [that].
 */
operator fun BigDecimal.rangeUntil(that: BigDecimal) = BigDecimalRange(this, that)

/**
 * Create an open [BigDecimalRange] from [this] value to the specified [that] value.
 * The [BigDecimalRange] implements [Iterable], with a step of 1 divided by 10 to the
 * power of the greatest number of decimal place of [this] or [that].
 */
infix fun BigDecimal.until(that: BigDecimal) = BigDecimalRange(this, that, true)

/**
 * Create a closed [BigDecimalRange] from [this] value down to the specified [that] value.
 * The [BigDecimalRange] implements [Iterable], with a step of 1 divided by 10 to the
 * power of the greatest number of decimal place of [this] or [that].
 */
infix fun BigDecimal.downTo(that: BigDecimal) = that..this
