package com.ogm.kotlin.range.extensions

fun ClosedRange<Long>.progression(step: Long = 1L) = LongProgression.fromClosedRange(start, endInclusive, 1)

fun ClosedRange<ULong>.progression(step: Long = 1L) = ULongProgression.fromClosedRange(start, endInclusive, 1)

fun ClosedRange<Int>.progression(step: Int = 1) = IntProgression.fromClosedRange(start, endInclusive, 1)

fun ClosedRange<UInt>.progression(step: Int = 1) = UIntProgression.fromClosedRange(start, endInclusive, 1)

fun ClosedRange<UShort>.progression(step: Short = 1) = UShortProgression.fromClosedRange(start, endInclusive, 1)

fun ClosedRange<Char>.progression(step: Int) = CharProgression.fromClosedRange(start, endInclusive, 1)

// TODO support for every custom range
