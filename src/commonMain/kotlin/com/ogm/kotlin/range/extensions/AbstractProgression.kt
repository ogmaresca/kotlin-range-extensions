package com.ogm.kotlin.range.extensions

@Suppress("LeakingThis")
abstract class AbstractProgression<T : Comparable<T>, TStep : Comparable<TStep>> protected constructor(
	start: T,
	endInclusive: T,
	val step: TStep,
) : Iterable<T> {
	val first = start
	val last: T by lazy {
		if (step > zeroStep()) {
			if (start >= endInclusive) {
				endInclusive
			} else {
				val modulo = valueModuloStep(endInclusive.abs(), step)
				if (modulo.compareTo(zeroStep()) == 0) {
					endInclusive
				} else {
					valueMinusStep(endInclusive, modulo)
				}
			}
		} else {
			if (start <= endInclusive) {
				endInclusive
			} else {
				val modulo = valueModuloStep(endInclusive.abs(), -step)
				if (modulo.compareTo(zeroStep()) == 0) {
					endInclusive
				} else {
					valuePlusStep(endInclusive, stepMinus(step, modulo))
				}
			}
		}
	}

	init {
		require(step.compareTo(zeroStep()) != 0) { "Step must be non-zero()." }
	}

	override fun iterator() = BaseProgressionIterator()

	open fun isEmpty(): Boolean = if (step > zeroStep()) first > last else first < last

	override fun equals(other: Any?) = when (other) {
		is AbstractProgression<*, *> -> other.first == first && other.last == last && other.step == step
		else -> false
	}

	override fun hashCode() = if (isEmpty()) {
		-1
	} else {
		(31 * first.hashCode()) + (29 * last.hashCode()) + (23 * step.hashCode())
	}

	override fun toString(): String = if (step > zeroStep()) {
		"$first..$last step $step"
	} else {
		"$first downTo $last step ${-step}"
	}

	protected abstract fun valuePlusStep(left: T, right: TStep): T
	protected abstract fun valueMinus(left: T, right: T): T
	protected abstract fun valueMinusStep(left: T, right: TStep): T
	protected abstract fun stepMinus(left: TStep, right: TStep): TStep
	protected abstract fun valueModuloStep(left: T, right: TStep): TStep
	protected abstract fun zeroValue(): T
	protected abstract fun zeroStep(): TStep

	private operator fun TStep.unaryMinus() = stepMinus(zeroStep(), this)
	private fun T.abs() = if (this > zeroValue()) this else valueMinus(zeroValue(), this)

	open inner class BaseProgressionIterator : Iterator<T> {
		protected var hasNext: Boolean = if (step > zeroStep()) first <= last else first >= last
		protected var next = if (hasNext) first else last

		override fun hasNext() = hasNext

		override fun next(): T {
			val value = next
			if (value == last) {
				if (!hasNext) throw NoSuchElementException()
				hasNext = false
			} else {
				next = valuePlusStep(next, step)
			}
			return value
		}
	}
}
