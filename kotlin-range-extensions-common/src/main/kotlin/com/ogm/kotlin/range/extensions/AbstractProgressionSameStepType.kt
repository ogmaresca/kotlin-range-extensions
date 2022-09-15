package com.ogm.kotlin.range.extensions

@Suppress("LeakingThis")
abstract class AbstractProgressionSameStepType<T : Comparable<T>> protected constructor(
	start: T,
	endInclusive: T,
	step: T,
) : AbstractProgression<T, T>(start, endInclusive, step) {
	override fun zeroValue() = zero()
	override fun zeroStep() = zero()

	abstract fun zero(): T
}
