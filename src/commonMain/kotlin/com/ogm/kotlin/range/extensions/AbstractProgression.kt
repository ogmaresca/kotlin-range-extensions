package com.ogm.kotlin.range.extensions

abstract class AbstractProgression<T : Comparable<T>, TStep : Comparable<TStep>> protected constructor(
	start: T,
	endInclusive: T,
	val step: TStep,
	protected val zeroStep: TStep,
) : Iterable<T> {
	init {
		require(step.compareTo(zeroStep) != 0) { "Step must be non-zero()." }
	}

	private val empty = if (step > zeroStep) start > endInclusive else start < endInclusive

	val first: T = start
	abstract val last: T

	fun isEmpty() = empty

	override fun equals(other: Any?) = when (other) {
		is AbstractProgression<*, *> -> other.first == first && other.last == last && other.step == step
		else -> false
	}

	override fun hashCode() = if (isEmpty()) {
		-1
	} else {
		(31 * first.hashCode()) + (29 * last.hashCode()) + (23 * step.hashCode())
	}

	override fun toString(): String = if (step > zeroStep) {
		"$first..$last step $step"
	} else {
		"$first downTo $last step $step"
	}
}
