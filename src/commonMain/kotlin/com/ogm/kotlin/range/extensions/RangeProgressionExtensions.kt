package com.ogm.kotlin.range.extensions

fun ClosedRange<Long>.progression(step: Long = 1L) = LongProgression.fromClosedRange(start, endInclusive, step)

fun ClosedRange<ULong>.progression(step: Long = 1L) = ULongProgression.fromClosedRange(start, endInclusive, step)

fun ClosedRange<Int>.progression(step: Int = 1) = IntProgression.fromClosedRange(start, endInclusive, step)

fun ClosedRange<UInt>.progression(step: Int = 1) = UIntProgression.fromClosedRange(start, endInclusive, step)

fun ClosedRange<UShort>.progression(step: Short = 1) = UShortProgression.fromClosedRange(this, step)

fun ClosedRange<Double>.progression(step: Double) = DoubleProgression.fromClosedRange(this, step)

fun ClosedRange<Float>.progression(step: Float) = FloatProgression.fromClosedRange(this, step)

fun ClosedRange<Char>.progression(step: Int) = CharProgression.fromClosedRange(start, endInclusive, step)

// TODO support for every custom range
