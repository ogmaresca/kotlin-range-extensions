package com.ogm.kotlin.range.extensions

abstract class AbstractToLongProgression<T : Comparable<T>, TStep : Comparable<TStep>> protected constructor(
	start: T,
	endInclusive: T,
	step: TStep,
	longStep: Long,
	zeroStep: TStep,
	private val converter: AbstractToLongProgressionConverter<T>,
) : AbstractProgression<T, TStep>(start, endInclusive, step, zeroStep) {
	private val longProgression =
		(converter.toLong(start)..converter.toLong(endInclusive)).step(longStep)

	override val last
		get() = converter.toValue(longProgression.last)

	override fun iterator(): Iterator<T> = ToLongProgressionIterator(longProgression.iterator())

	protected interface AbstractToLongProgressionConverter<T : Comparable<T>> {
		fun toLong(value: T): Long
		fun toValue(value: Long): T
	}

	open inner class ToLongProgressionIterator(private val longIterator: LongIterator) : Iterator<T> {
		override fun hasNext() = longIterator.hasNext()

		override fun next() = converter.toValue(longIterator.next())
	}
}
