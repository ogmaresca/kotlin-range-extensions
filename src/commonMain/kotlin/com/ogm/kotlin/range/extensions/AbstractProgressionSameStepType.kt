package com.ogm.kotlin.range.extensions

abstract class AbstractProgressionSameStepType<T : Comparable<T>> protected constructor(
	start: T,
	endInclusive: T,
	step: T,
) : AbstractProgression<T, T>(start, endInclusive, step) {
	override fun valuePlusStep(left: T, right: T) = left + right
	override fun valueMinus(left: T, right: T) = left - right
	override fun valueMinusStep(left: T, right: T) = left - right
	override fun stepMinus(left: T, right: T) = left - right
	override fun valueModuloStep(left: T, right: T) = left % right
	override fun zeroValue() = zero()
	override fun zeroStep() = zero()

	protected abstract operator fun T.plus(right: T): T
	protected abstract operator fun T.minus(right: T): T
	protected abstract operator fun T.rem(right: T): T
	protected abstract fun zero(): T
}
