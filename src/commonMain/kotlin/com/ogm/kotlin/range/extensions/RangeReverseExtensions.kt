package com.ogm.kotlin.range.extensions

/**
 * Reverse this [ClosedRange]
 */
fun <T : Comparable<T>> ClosedRange<T>.reversed(): ClosedRange<T> = endInclusive..start
