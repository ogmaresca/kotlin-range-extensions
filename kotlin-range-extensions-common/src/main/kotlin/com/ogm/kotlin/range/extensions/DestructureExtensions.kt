package com.ogm.kotlin.range.extensions

operator fun <T : Comparable<T>> ClosedRange<T>.component1(): T = start
operator fun <T : Comparable<T>> ClosedRange<T>.component2(): T = endInclusive
