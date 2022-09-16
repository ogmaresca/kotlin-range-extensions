package com.ogm.kotlin.range.extensions

import kotlin.jvm.JvmName

fun <T : Comparable<T>> ClosedRange<T>.reverse(): ClosedRange<T> = endInclusive..start

@JvmName("reverseLong")
fun ClosedRange<Long>.reverse(): LongRange = endInclusive..start

@JvmName("reverseULong")
fun ClosedRange<ULong>.reverse(): ULongRange = endInclusive..start

@JvmName("reverseInt")
fun ClosedRange<Int>.reverse(): IntRange = endInclusive..start

@JvmName("reverseUInt")
fun ClosedRange<UInt>.reverse(): UIntRange = endInclusive..start

@JvmName("reverseUShort")
fun ClosedRange<UShort>.reverse(): UShortRange = (endInclusive..start).toUShortRange()

@JvmName("reverseDouble")
fun ClosedRange<Double>.reverse(): ClosedFloatingPointRange<Double> = endInclusive..start

@JvmName("reverseFloat")
fun ClosedRange<Float>.reverse(): ClosedFloatingPointRange<Float> = endInclusive..start

@JvmName("reverseChar")
fun ClosedRange<Char>.reverse(): CharRange = endInclusive..start

// TODO support for every custom range
