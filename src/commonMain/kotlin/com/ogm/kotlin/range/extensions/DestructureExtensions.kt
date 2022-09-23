package com.ogm.kotlin.range.extensions

@JvmInline
value class DestructureClosedRange<T : Comparable<T>>(private val range: ClosedRange<T>) {
	operator fun component1(): T = range.start
	operator fun component2(): T = range.endInclusive
}

fun <T : Comparable<T>> ClosedRange<T>.destructure() = DestructureClosedRange(this)
fun <T : Comparable<T>> ClosedRange<T>.toPair(): Pair<T, T> = start to endInclusive
