package com.ogm.kotlin.range.extensions

fun <T : Comparable<T>> ClosedRange<T>.reversed(): ClosedRange<T> = endInclusive..start

@JvmName("reversedLong")
fun ClosedRange<Long>.reversed(): LongRange = endInclusive..start

@JvmName("reversedULong")
fun ClosedRange<ULong>.reversed(): ULongRange = endInclusive..start

@JvmName("reversedInt")
fun ClosedRange<Int>.reversed(): IntRange = endInclusive..start

@JvmName("reversedUInt")
fun ClosedRange<UInt>.reversed(): UIntRange = endInclusive..start

@JvmName("reversedShort")
fun ClosedRange<Short>.reversed(): ShortRange = (endInclusive..start).toShortRange()

@JvmName("reversedUShort")
fun ClosedRange<UShort>.reversed(): UShortRange = (endInclusive..start).toUShortRange()

@JvmName("reversedByte")
fun ClosedRange<Byte>.reversed(): ByteRange = (endInclusive..start).toByteRange()

@JvmName("reversedUByte")
fun ClosedRange<UByte>.reversed(): UByteRange = (endInclusive..start).toUByteRange()

@JvmName("reversedDouble")
fun ClosedRange<Double>.reversed(): ClosedFloatingPointRange<Double> = endInclusive..start

@JvmName("reversedFloat")
fun ClosedRange<Float>.reversed(): ClosedFloatingPointRange<Float> = endInclusive..start

@JvmName("reversedChar")
fun ClosedRange<Char>.reversed(): CharRange = endInclusive..start

// TODO support for every custom range
