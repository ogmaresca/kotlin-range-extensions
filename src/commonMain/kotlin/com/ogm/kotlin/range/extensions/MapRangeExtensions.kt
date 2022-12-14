package com.ogm.kotlin.range.extensions

/**
 * Map this [ClosedRange] of [T] to a [ClosedRange] of [R].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>, R : Comparable<R>> ClosedRange<T>.mapRange(block: (T) -> R): ClosedRange<R> =
	block(start)..block(endInclusive)

/**
 * Map this [ClosedRange] of [T] to a [LongRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToLongRange(block: (T) -> Long): LongRange =
	block(start)..block(endInclusive)

/**
 * Map this [ClosedRange] of [T] to a [ULongRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToULongRange(block: (T) -> ULong): ULongRange =
	block(start)..block(endInclusive)

/**
 * Map this [ClosedRange] of [T] to a [IntRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToIntRange(block: (T) -> Int): IntRange =
	block(start)..block(endInclusive)

/**
 * Map this [ClosedRange] of [T] to a [UIntRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToUIntRange(block: (T) -> UInt): UIntRange =
	block(start)..block(endInclusive)

/**
 * Map this [ClosedRange] of [T] to a [ShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToShortRange(block: (T) -> Short): ShortRange =
	(block(start)..block(endInclusive)).toShortRange()

/**
 * Map this [ClosedRange] of [T] to a [UShortRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToUShortRange(block: (T) -> UShort): UShortRange =
	(block(start)..block(endInclusive)).toUShortRange()

/**
 * Map this [ClosedRange] of [T] to a [ByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToByteRange(block: (T) -> Byte): ByteRange =
	(block(start)..block(endInclusive)).toByteRange()

/**
 * Map this [ClosedRange] of [T] to a [UByteRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToUByteRange(block: (T) -> UByte): UByteRange =
	(block(start)..block(endInclusive)).toUByteRange()

/**
 * Map this [ClosedRange] of [T] to a [ClosedDoubleRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToDoubleRange(block: (T) -> Double): ClosedFloatingPointRange<Double> =
	block(start)..block(endInclusive)

/**
 * Map this [ClosedRange] of [T] to a [ClosedFloatRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToFloatRange(block: (T) -> Float): ClosedFloatingPointRange<Float> =
	block(start)..block(endInclusive)

/**
 * Map this [ClosedRange] of [T] to a [CharRange].
 * @see [Iterable.map]
 */
fun <T : Comparable<T>> ClosedRange<T>.mapToCharRange(block: (T) -> Char): CharRange =
	block(start)..block(endInclusive)
