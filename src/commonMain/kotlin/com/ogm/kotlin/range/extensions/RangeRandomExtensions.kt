package com.ogm.kotlin.range.extensions

import kotlin.random.Random
import kotlin.random.nextUInt

fun Random.nextShort(range: ClosedRange<Short>): Short {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextInt(range.start.toInt(), range.endInclusive.toInt() + 1).toShort()
}

fun Random.nextUShort(range: ClosedRange<UShort>): UShort {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextUInt(range.start.toUInt(), range.endInclusive.toUInt() + 1u).toUShort()
}

fun Random.nextByte(range: ClosedRange<Byte>): Byte {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextInt(range.start.toInt(), range.endInclusive.toInt() + 1).toByte()
}

fun Random.nextUByte(range: ClosedRange<UByte>): UByte {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextUInt(range.start.toUInt(), range.endInclusive.toUInt() + 1u).toUByte()
}

@JvmName("randomShort")
fun ClosedRange<Short>.random(random: Random = Random.Default): Short = try {
	random.nextShort(this)
} catch(e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

@JvmName("randomOrNullShort")
fun ClosedRange<Short>.randomOrNull(random: Random = Random.Default): Short? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomUShort")
fun ClosedRange<UShort>.random(random: Random = Random.Default): UShort = try {
	random.nextUShort(this)
} catch(e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

@JvmName("randomOrNullUShort")
fun ClosedRange<UShort>.randomOrNull(random: Random = Random.Default): UShort? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomByte")
fun ClosedRange<Byte>.random(random: Random = Random.Default): Byte = try {
	random.nextByte(this)
} catch(e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

@JvmName("randomOrNullByte")
fun ClosedRange<Byte>.randomOrNull(random: Random = Random.Default): Byte? =
	takeUnless { it.isEmpty() }?.random(random)

@JvmName("randomUByte")
fun ClosedRange<UByte>.random(random: Random = Random.Default): UByte = try {
	random.nextUByte(this)
} catch(e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

@JvmName("randomOrNullUByte")
fun ClosedRange<UByte>.randomOrNull(random: Random = Random.Default): UByte? =
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

@JvmName("randomChar")
fun ClosedRange<Char>.random(random: Random = Random.Default): Char = try {
	Char(mapToIntRange { it.code }.random(random))
} catch(e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

fun ClosedRange<Char>.randomString(length: Int, random: Random = Random.Default): String {
	require(length >= 0) { "length must be greater than zero" }
	return when (length) {
		0 -> ""
		else -> StringBuilder().let { sb ->
			repeat(length) { sb.append(random(random)) }
		}.toString()
	}
}

fun ClosedRange<Char>.randomStringOrNull(length: Int, random: Random = Random.Default): String? =
	takeUnless { it.isEmpty() }?.randomString(length, random)

fun Iterable<ClosedRange<Char>>.randomString(random: Random = Random.Default): String = StringBuilder().apply {
	this@randomString.forEach { append(it.toCharRange().random(random)) }
}.toString()

// TODO support for every custom range
