package com.ogm.kotlin.range.extensions

fun ClosedRange<Long>.step(step: Long = 1L) = LongProgression.fromClosedRange(start, endInclusive, step)

fun ClosedRange<ULong>.step(step: Long = 1L) = ULongProgression.fromClosedRange(start, endInclusive, step)

fun ClosedRange<Int>.step(step: Int = 1) = IntProgression.fromClosedRange(start, endInclusive, step)

fun ClosedRange<UInt>.step(step: Int = 1) = UIntProgression.fromClosedRange(start, endInclusive, step)

fun ClosedRange<UShort>.step(step: Short = 1) = UShortProgression.fromClosedRange(this, step)

fun ClosedRange<Double>.step(step: Double) = DoubleProgression.fromClosedRange(this, step)

fun ClosedRange<Float>.step(step: Float) = FloatProgression.fromClosedRange(this, step)

fun ClosedRange<Char>.step(step: Int) = CharProgression.fromClosedRange(start, endInclusive, step)

// TODO support for every custom range
