package com.ogm.kotlin.range.extensions

fun <T : Comparable<T>, R : Comparable<R>> ClosedRange<T>.mapRange(block: (T) -> R): ClosedRange<R> =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToLongRange(block: (T) -> Long): LongRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToIntRange(block: (T) -> Int): IntRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToUIntRange(block: (T) -> Int): IntRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToUShortRange(block: (T) -> Int): IntRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToDoubleRange(block: (T) -> Double): ClosedFloatingPointRange<Double> =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToFloatRange(block: (T) -> Float): ClosedFloatingPointRange<Float> =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToCharRange(block: (T) -> Char): CharRange =
	block(start)..block(endInclusive)

// TODO support for every custom range
