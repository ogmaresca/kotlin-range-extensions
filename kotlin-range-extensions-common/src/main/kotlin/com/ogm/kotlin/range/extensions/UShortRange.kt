package com.ogm.kotlin.range.extensions

data class UShortRange(
	override val start: UShort,
	override val endInclusive: UShort,
) : ClosedRange<UShort>, Iterable<UShort> {
	override fun isEmpty(): Boolean = start > endInclusive

	override fun equals(other: Any?) = when (other) {
		is UShortRange -> other.start == start && other.endInclusive == endInclusive && other.endInclusive == endInclusive
		else -> false
	}

	override fun hashCode() = if (isEmpty()) {
		-1
	} else {
		(31 * start.hashCode()) + (29 * endInclusive.hashCode())
	}

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = UShortProgression.fromClosedRange(start, endInclusive, 1).iterator()

	companion object {
		/** An empty range of values of type Long. */
		val EMPTY = UShortRange(UShort.MAX_VALUE, UShort.MIN_VALUE)
	}
}

operator fun UShort.rangeTo(that: UShort) = UShortRange(this, that)
