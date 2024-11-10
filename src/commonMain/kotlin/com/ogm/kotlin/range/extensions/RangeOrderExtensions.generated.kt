/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Convert this [OpenEndRange] to be in ascending order.
 * Ex: convert `10..<1` to `2..<11`
 */
@JvmName("toAscendingOrderLongOpenEndRange")
fun OpenEndRange<Long>.toAscendingOrder(): OpenEndRange<Long> = if (descendingOrderRange) {
	(endExclusive + 1L)..<(start + 1L)
} else {
	this
}

/**
 * Convert this [LongRange] to be in ascending order.
 * Ex: convert `10..1` to `1..10`
 */
@JvmName("toAscendingOrderLongClosedRange")
fun LongRange.toAscendingOrder(): LongRange = if (descendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in descending order.
 * Ex: convert `1..<10` to `9..<0`
 */
@JvmName("toDescendingOrderLongOpenEndRange")
fun OpenEndRange<Long>.toDescendingOrder(): OpenEndRange<Long> = if (ascendingOrderRange) {
	(endExclusive - 1L)..<(start - 1L)
} else {
	this
}

/**
 * Convert this [LongRange] to be in descending order.
 * Ex: convert `1..10` to `10..1`
 */
@JvmName("toDescendingOrderLongClosedRange")
fun LongRange.toDescendingOrder(): LongRange = if (ascendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in ascending order.
 * Ex: convert `10..<1` to `2..<11`
 */
@JvmName("toAscendingOrderULongOpenEndRange")
fun OpenEndRange<ULong>.toAscendingOrder(): OpenEndRange<ULong> = if (descendingOrderRange) {
	(endExclusive + 1UL)..<(start + 1UL)
} else {
	this
}

/**
 * Convert this [ULongRange] to be in ascending order.
 * Ex: convert `10..1` to `1..10`
 */
@JvmName("toAscendingOrderULongClosedRange")
fun ULongRange.toAscendingOrder(): ULongRange = if (descendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in descending order.
 * Ex: convert `1..<10` to `9..<0`
 */
@JvmName("toDescendingOrderULongOpenEndRange")
fun OpenEndRange<ULong>.toDescendingOrder(): OpenEndRange<ULong> = if (ascendingOrderRange) {
	(endExclusive - 1UL)..<(start - 1UL)
} else {
	this
}

/**
 * Convert this [ULongRange] to be in descending order.
 * Ex: convert `1..10` to `10..1`
 */
@JvmName("toDescendingOrderULongClosedRange")
fun ULongRange.toDescendingOrder(): ULongRange = if (ascendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in ascending order.
 * Ex: convert `10..<1` to `2..<11`
 */
@JvmName("toAscendingOrderIntOpenEndRange")
fun OpenEndRange<Int>.toAscendingOrder(): OpenEndRange<Int> = if (descendingOrderRange) {
	(endExclusive + 1)..<(start + 1)
} else {
	this
}

/**
 * Convert this [IntRange] to be in ascending order.
 * Ex: convert `10..1` to `1..10`
 */
@JvmName("toAscendingOrderIntClosedRange")
fun IntRange.toAscendingOrder(): IntRange = if (descendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in descending order.
 * Ex: convert `1..<10` to `9..<0`
 */
@JvmName("toDescendingOrderIntOpenEndRange")
fun OpenEndRange<Int>.toDescendingOrder(): OpenEndRange<Int> = if (ascendingOrderRange) {
	(endExclusive - 1)..<(start - 1)
} else {
	this
}

/**
 * Convert this [IntRange] to be in descending order.
 * Ex: convert `1..10` to `10..1`
 */
@JvmName("toDescendingOrderIntClosedRange")
fun IntRange.toDescendingOrder(): IntRange = if (ascendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in ascending order.
 * Ex: convert `10..<1` to `2..<11`
 */
@JvmName("toAscendingOrderUIntOpenEndRange")
fun OpenEndRange<UInt>.toAscendingOrder(): OpenEndRange<UInt> = if (descendingOrderRange) {
	(endExclusive + 1U)..<(start + 1U)
} else {
	this
}

/**
 * Convert this [UIntRange] to be in ascending order.
 * Ex: convert `10..1` to `1..10`
 */
@JvmName("toAscendingOrderUIntClosedRange")
fun UIntRange.toAscendingOrder(): UIntRange = if (descendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in descending order.
 * Ex: convert `1..<10` to `9..<0`
 */
@JvmName("toDescendingOrderUIntOpenEndRange")
fun OpenEndRange<UInt>.toDescendingOrder(): OpenEndRange<UInt> = if (ascendingOrderRange) {
	(endExclusive - 1U)..<(start - 1U)
} else {
	this
}

/**
 * Convert this [UIntRange] to be in descending order.
 * Ex: convert `1..10` to `10..1`
 */
@JvmName("toDescendingOrderUIntClosedRange")
fun UIntRange.toDescendingOrder(): UIntRange = if (ascendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in ascending order.
 * Ex: convert `10..<1` to `2..<11`
 */
@JvmName("toAscendingOrderDoubleOpenEndRange")
fun OpenEndRange<Double>.toAscendingOrder(): OpenEndRange<Double> = if (descendingOrderRange) {
	(endExclusive + 1.0)..<(start + 1.0)
} else {
	this
}

/**
 * Convert this [ClosedFloatingPointRange<Double>] to be in ascending order.
 * Ex: convert `10..1` to `1..10`
 */
@JvmName("toAscendingOrderDoubleClosedRange")
fun ClosedFloatingPointRange<Double>.toAscendingOrder(): ClosedFloatingPointRange<Double> = if (descendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in descending order.
 * Ex: convert `1..<10` to `9..<0`
 */
@JvmName("toDescendingOrderDoubleOpenEndRange")
fun OpenEndRange<Double>.toDescendingOrder(): OpenEndRange<Double> = if (ascendingOrderRange) {
	(endExclusive - 1.0)..<(start - 1.0)
} else {
	this
}

/**
 * Convert this [ClosedFloatingPointRange<Double>] to be in descending order.
 * Ex: convert `1..10` to `10..1`
 */
@JvmName("toDescendingOrderDoubleClosedRange")
fun ClosedFloatingPointRange<Double>.toDescendingOrder(): ClosedFloatingPointRange<Double> = if (ascendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in ascending order.
 * Ex: convert `10..<1` to `2..<11`
 */
@JvmName("toAscendingOrderFloatOpenEndRange")
fun OpenEndRange<Float>.toAscendingOrder(): OpenEndRange<Float> = if (descendingOrderRange) {
	(endExclusive + 1.0F)..<(start + 1.0F)
} else {
	this
}

/**
 * Convert this [ClosedFloatingPointRange<Float>] to be in ascending order.
 * Ex: convert `10..1` to `1..10`
 */
@JvmName("toAscendingOrderFloatClosedRange")
fun ClosedFloatingPointRange<Float>.toAscendingOrder(): ClosedFloatingPointRange<Float> = if (descendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in descending order.
 * Ex: convert `1..<10` to `9..<0`
 */
@JvmName("toDescendingOrderFloatOpenEndRange")
fun OpenEndRange<Float>.toDescendingOrder(): OpenEndRange<Float> = if (ascendingOrderRange) {
	(endExclusive - 1.0F)..<(start - 1.0F)
} else {
	this
}

/**
 * Convert this [ClosedFloatingPointRange<Float>] to be in descending order.
 * Ex: convert `1..10` to `10..1`
 */
@JvmName("toDescendingOrderFloatClosedRange")
fun ClosedFloatingPointRange<Float>.toDescendingOrder(): ClosedFloatingPointRange<Float> = if (ascendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in ascending order.
 * Ex: convert `10..<1` to `2..<11`
 */
@JvmName("toAscendingOrderCharOpenEndRange")
fun OpenEndRange<Char>.toAscendingOrder(): OpenEndRange<Char> = if (descendingOrderRange) {
	(endExclusive + 1)..<(start + 1)
} else {
	this
}

/**
 * Convert this [CharRange] to be in ascending order.
 * Ex: convert `10..1` to `1..10`
 */
@JvmName("toAscendingOrderCharClosedRange")
fun CharRange.toAscendingOrder(): CharRange = if (descendingOrder) {
	endInclusive..start
} else {
	this
}

/**
 * Convert this [OpenEndRange] to be in descending order.
 * Ex: convert `1..<10` to `9..<0`
 */
@JvmName("toDescendingOrderCharOpenEndRange")
fun OpenEndRange<Char>.toDescendingOrder(): OpenEndRange<Char> = if (ascendingOrderRange) {
	(endExclusive - 1)..<(start - 1)
} else {
	this
}

/**
 * Convert this [CharRange] to be in descending order.
 * Ex: convert `1..10` to `10..1`
 */
@JvmName("toDescendingOrderCharClosedRange")
fun CharRange.toDescendingOrder(): CharRange = if (ascendingOrder) {
	endInclusive..start
} else {
	this
}
