package com.ogm.kotlin.range.extensions

import kotlin.jvm.JvmInline

@JvmInline
value class UShortRange internal constructor(
	private val value: UIntRange,
) : ClosedRange<UShort>, Iterable<UShort> {
	constructor(start: UShort, endInclusive: UShort) : this(start..endInclusive)

	override val start: UShort get() = value.first.toUShort()
	override val endInclusive: UShort get() = value.last.toUShort()

	override fun toString(): String = "$start..$endInclusive"

	override fun iterator() = UShortProgression(value).iterator()

	companion object {
		val EMPTY = UShortRange(UShort.MAX_VALUE, UShort.MIN_VALUE)
	}
}
