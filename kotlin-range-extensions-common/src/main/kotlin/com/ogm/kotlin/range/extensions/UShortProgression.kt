package com.ogm.kotlin.range.extensions

import kotlin.jvm.JvmInline

@JvmInline
value class UShortProgression private constructor(
	private val value: UIntProgression,
) : Iterable<UShort> {
	val first get() = value.first.toUShort()
	val last get() = value.last.toUShort()
	val step get() = value.step.toUShort()

	override fun iterator(): Iterator<UShort> = UShortProgressionIterator(value.iterator())

	/**
	 * Checks if the progression is empty.
	 */
	fun isEmpty() = value.isEmpty()

	override fun toString() = value.toString()

	companion object {
		/**
		 * Creates UShortProgression within the specified bounds of a closed range.
		 *
		 * The progression starts with the [rangeStart] value and goes toward the [rangeEnd] value not excluding it, with the specified [step].
		 * In order to go backwards the [step] must be negative.
		 *
		 * [step] must be greater than `Short.MIN_VALUE` and not equal to zero.
		 */
		fun fromClosedRange(rangeStart: UShort, rangeEnd: UShort, step: Short) =
			UShortProgression(UIntProgression.fromClosedRange(rangeStart.toUInt(), rangeEnd.toUInt(), step.toInt()))
	}

	@JvmInline
	private value class UShortProgressionIterator(private val value: Iterator<UInt>) : Iterator<UShort> {
		override fun hasNext() = value.hasNext()
		override fun next() = value.next().toUShort()
	}
}
