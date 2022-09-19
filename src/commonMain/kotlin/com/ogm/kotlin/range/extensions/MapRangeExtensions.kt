package com.ogm.kotlin.range.extensions

fun <T : Comparable<T>, R : Comparable<R>> ClosedRange<T>.mapRange(block: (T) -> R): ClosedRange<R> =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToLongRange(block: (T) -> Long): LongRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToULongRange(block: (T) -> ULong): ULongRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToIntRange(block: (T) -> Int): IntRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToUIntRange(block: (T) -> UInt): UIntRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToShortRange(block: (T) -> Short): ShortRange =
	(block(start)..block(endInclusive)).toShortRange()

fun <T : Comparable<T>> ClosedRange<T>.mapToUShortRange(block: (T) -> UShort): UShortRange =
	(block(start)..block(endInclusive)).toUShortRange()

fun <T : Comparable<T>> ClosedRange<T>.mapToByteRange(block: (T) -> Byte): ByteRange =
	(block(start)..block(endInclusive)).toByteRange()

fun <T : Comparable<T>> ClosedRange<T>.mapToUByteRange(block: (T) -> UByte): UByteRange =
	(block(start)..block(endInclusive)).toUByteRange()

fun <T : Comparable<T>> ClosedRange<T>.mapToDoubleRange(block: (T) -> Double): ClosedFloatingPointRange<Double> =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToFloatRange(block: (T) -> Float): ClosedFloatingPointRange<Float> =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToCharRange(block: (T) -> Char): CharRange =
	block(start)..block(endInclusive)

// TODO support for every custom range
