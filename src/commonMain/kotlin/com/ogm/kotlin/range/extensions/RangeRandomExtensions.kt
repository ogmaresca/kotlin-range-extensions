package com.ogm.kotlin.range.extensionsvalueMinusStep

import com.ogm.kotlin.range.extensions.mapToDoubleRange
import com.ogm.kotlin.range.extensions.toCharRange
import kotlin.jvm.JvmName
import kotlin.random.Random
import kotlin.random.nextUInt

fun Random.nextUShort(range: ClosedRange<UShort>): UShort {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextUInt(range.start.toUInt(), range.endInclusive.toUInt() + 1u).toUShort()
}

@JvmName("randomUShort")
fun ClosedRange<UShort>.random(random: Random = Random.Default): UShort = try {
	random.nextUShort(this)
} catch(e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

@JvmName("randomOrNullUShort")
fun ClosedRange<UShort>.randomOrNull(random: Random = Random.Default): UShort? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomDouble")
fun ClosedRange<Double>.random(random: Random = Random.Default): Double = try {
	random.nextDouble(start, endInclusive + Double.MIN_VALUE)
} catch(e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

@JvmName("randomOrNullDouble")
fun ClosedRange<Double>.randomOrNull(random: Random = Random.Default): Double? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomFloat")
fun ClosedRange<Float>.random(random: Random = Random.Default): Float = try {
	mapToDoubleRange { it.toDouble() }.random(random).toFloat()
} catch(e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

@JvmName("randomOrNullFloat")
fun ClosedRange<Float>.randomOrNull(random: Random = Random.Default): Float? =
	takeUnless { it.isEmpty() }?.random(random)

fun ClosedRange<Char>.randomString(length: Int, random: Random = Random.Default): String {
	require(length >= 0) { "length must be greater than zero" }
	return when (length) {
		0 -> ""
		else -> StringBuilder().apply {
			repeat(length) { append(random(random)) }
		}.toString()
	}
}

fun ClosedRange<Char>.randomStringOrNull(length: Int, random: Random = Random.Default): String? =
	takeUnless { it.isEmpty() }?.randomString(length, random)

fun Iterable<ClosedRange<Char>>.randomString(random: Random = Random.Default): String = StringBuilder().apply {
	this@randomString.forEach { append(it.toCharRange().random(random)) }
}.toString()

// TODO support for every custom range
