package com.ogm.kotlin.range.extensions

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
open class DoubleProgression protected constructor(
	start: Double,
	endInclusive: Double,
	step: Double,
) : AbstractProgressionSameStepType<Double>(start, endInclusive, step) {
	override fun Double.plus(right: Double): Double = this@plus + right

	override fun Double.minus(right: Double): Double = this@minus - right

	override fun Double.rem(right: Double): Double = this@rem % right

	override fun zero(): Double = 0.0

	companion object {
		fun fromClosedRange(rangeStart: Double, rangeEnd: Double, step: Double) =
			DoubleProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<Double>, step: Double) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
