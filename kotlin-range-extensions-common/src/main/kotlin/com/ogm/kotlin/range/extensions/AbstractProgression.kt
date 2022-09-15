package com.ogm.kotlin.range.extensions

import kotlin.jvm.JvmName

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
				val modulo = endInclusive.abs() % step
				if (modulo.compareTo(zeroStep()) == 0) {
					endInclusive
				} else {
					endInclusive - modulo
				}
			}
		} else {
			if (start <= endInclusive) {
				endInclusive
			} else {
				val modulo = endInclusive.abs() % -step
				if (modulo.compareTo(zeroStep()) == 0) {
					endInclusive
				} else {
					endInclusive + (step - modulo)
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

	protected abstract operator fun T.plus(right: TStep): T
	@JvmName("valueMinusStep")
	protected abstract operator fun T.minus(right: TStep): T
	@JvmName("valueMinusValue")
	protected abstract operator fun T.minus(right: T): T
	@JvmName("stepMinusStep")
	protected abstract operator fun TStep.minus(right: TStep): TStep
	protected abstract operator fun T.rem(right: TStep): TStep
	protected abstract fun zeroValue(): T
	protected abstract fun zeroStep(): TStep

	@JvmName("valueUnaryMinus")
	private operator fun T.unaryMinus() = zeroValue() - this
	@JvmName("stepUnaryMinus")
	private operator fun TStep.unaryMinus() = zeroStep() - this

	private fun T.abs() = if (this > zeroValue()) this else -this

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
				next += step
			}
			return value
		}
	}
}
