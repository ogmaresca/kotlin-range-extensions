package com.ogm.kotlin.range.extensions

import java.math.BigInteger

// Need to support BigInteger for datetimes after 2262-04-11
abstract class AbstractToBigIntegerProgression<T : Comparable<T>, TStep : Comparable<TStep>> protected constructor(start: T, endInclusive: T, step: TStep, bigIntegerStep: BigInteger, zeroStep: TStep, private val converter: AbstractToBigIntegerProgressionConverter<T>) : AbstractProgression<T, TStep>(start, endInclusive, step, zeroStep) {
	private val bigIntegerProgression = BigIntegerProgression.fromClosedRange(
		converter.toBigInteger(start),
		converter.toBigInteger(endInclusive),
		bigIntegerStep,
	)

	override val last
		get() = converter.toValue(bigIntegerProgression.last)

	override fun iterator(): Iterator<T> = ToBigIntegerProgressionIterator(bigIntegerProgression.iterator())

	protected interface AbstractToBigIntegerProgressionConverter<T : Comparable<T>> {
		fun toBigInteger(value: T): BigInteger
		fun toValue(value: BigInteger): T
	}

	open inner class ToBigIntegerProgressionIterator(private val bigIntegerIterator: BigIntegerProgression.BigIntegerProgressionIterator) : Iterator<T> {
		override fun hasNext() = bigIntegerIterator.hasNext()

		override fun next() = converter.toValue(bigIntegerIterator.next())
	}
}
