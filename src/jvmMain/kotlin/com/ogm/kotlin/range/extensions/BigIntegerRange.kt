package com.ogm.kotlin.range.extensions

import java.math.BigInteger

data class BigIntegerRange(
	override val start: BigInteger,
	override val endInclusive: BigInteger,
) : ClosedRange<BigInteger>, Iterable<BigInteger> {
	override fun iterator(): Iterator<BigInteger> =
		BigIntegerProgression.fromClosedRange(this, BigInteger.valueOf(1L)).iterator()

	override fun toString(): String = "$start..$endInclusive"

	companion object {
		val EMPTY = BigInteger.ONE..BigInteger.ZERO
	}
}

operator fun BigInteger.rangeTo(that: BigInteger) = BigIntegerRange(this, that)

infix fun BigInteger.downTo(that: BigInteger) = that..this
