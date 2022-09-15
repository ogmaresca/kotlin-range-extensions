package com.ogm.kotlin.range.extensions

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
open class FloatProgression protected constructor(
	start: Float,
	endInclusive: Float,
	step: Float,
) : AbstractProgressionSameStepType<Float>(start, endInclusive, step) {
	override fun Float.plus(right: Float): Float = this + right

	override fun Float.minus(right: Float): Float = this - right

	override fun Float.rem(right: Float): Float = this % right

	override fun zero(): Float = 0.0.toFloat()

	companion object {
		fun fromClosedRange(rangeStart: Float, rangeEnd: Float, step: Float) =
			FloatProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<Float>, step: Float) =
			fromClosedRange(range.start, range.endInclusive, step)
	}
}
