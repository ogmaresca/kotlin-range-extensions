/** Generated file */

package com.ogm.kotlin.range.extensions

import kotlin.random.Random
import kotlin.random.nextUInt

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextShort(range: ClosedRange<Short>): Short {
	if (range is OpenEndRange<*>) {
		@Suppress("UNCHECKED_CAST")
		return nextShortExclusive(range as OpenEndRange<Short>)
	}

	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextInt(range.start.toInt(), range.calculateEndExclusive().toInt()).toShort()
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextShortExclusive(range: OpenEndRange<Short>): Short {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextInt(range.start.toInt(), range.endExclusive.toInt()).toShort()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomClosedShort")
fun ClosedRange<Short>.random(random: Random = Random.Default): Short = try {
	random.nextShort(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullClosedShort")
fun ClosedRange<Short>.randomOrNull(random: Random = Random.Default): Short? = takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomOpenEndShort")
fun OpenEndRange<Short>.randomExclusive(random: Random = Random.Default): Short = try {
	random.nextShortExclusive(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullOpenEndShort")
fun OpenEndRange<Short>.randomOrNullExclusive(random: Random = Random.Default): Short? = takeUnless { it.isEmpty() }?.randomExclusive(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextUShort(range: ClosedRange<UShort>): UShort {
	if (range is OpenEndRange<*>) {
		@Suppress("UNCHECKED_CAST")
		return nextUShortExclusive(range as OpenEndRange<UShort>)
	}

	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextUInt(range.start.toUInt(), range.calculateEndExclusive().toUInt()).toUShort()
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextUShortExclusive(range: OpenEndRange<UShort>): UShort {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextUInt(range.start.toUInt(), range.endExclusive.toUInt()).toUShort()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomClosedUShort")
fun ClosedRange<UShort>.random(random: Random = Random.Default): UShort = try {
	random.nextUShort(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullClosedUShort")
fun ClosedRange<UShort>.randomOrNull(random: Random = Random.Default): UShort? = takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomOpenEndUShort")
fun OpenEndRange<UShort>.randomExclusive(random: Random = Random.Default): UShort = try {
	random.nextUShortExclusive(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullOpenEndUShort")
fun OpenEndRange<UShort>.randomOrNullExclusive(random: Random = Random.Default): UShort? = takeUnless { it.isEmpty() }?.randomExclusive(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextByte(range: ClosedRange<Byte>): Byte {
	if (range is OpenEndRange<*>) {
		@Suppress("UNCHECKED_CAST")
		return nextByteExclusive(range as OpenEndRange<Byte>)
	}

	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextInt(range.start.toInt(), range.calculateEndExclusive().toInt()).toByte()
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextByteExclusive(range: OpenEndRange<Byte>): Byte {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextInt(range.start.toInt(), range.endExclusive.toInt()).toByte()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomClosedByte")
fun ClosedRange<Byte>.random(random: Random = Random.Default): Byte = try {
	random.nextByte(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullClosedByte")
fun ClosedRange<Byte>.randomOrNull(random: Random = Random.Default): Byte? = takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomOpenEndByte")
fun OpenEndRange<Byte>.randomExclusive(random: Random = Random.Default): Byte = try {
	random.nextByteExclusive(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullOpenEndByte")
fun OpenEndRange<Byte>.randomOrNullExclusive(random: Random = Random.Default): Byte? = takeUnless { it.isEmpty() }?.randomExclusive(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextUByte(range: ClosedRange<UByte>): UByte {
	if (range is OpenEndRange<*>) {
		@Suppress("UNCHECKED_CAST")
		return nextUByteExclusive(range as OpenEndRange<UByte>)
	}

	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextUInt(range.start.toUInt(), range.calculateEndExclusive().toUInt()).toUByte()
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextUByteExclusive(range: OpenEndRange<UByte>): UByte {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextUInt(range.start.toUInt(), range.endExclusive.toUInt()).toUByte()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomClosedUByte")
fun ClosedRange<UByte>.random(random: Random = Random.Default): UByte = try {
	random.nextUByte(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullClosedUByte")
fun ClosedRange<UByte>.randomOrNull(random: Random = Random.Default): UByte? = takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomOpenEndUByte")
fun OpenEndRange<UByte>.randomExclusive(random: Random = Random.Default): UByte = try {
	random.nextUByteExclusive(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullOpenEndUByte")
fun OpenEndRange<UByte>.randomOrNullExclusive(random: Random = Random.Default): UByte? = takeUnless { it.isEmpty() }?.randomExclusive(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextDouble(range: ClosedRange<Double>): Double {
	if (range is OpenEndRange<*>) {
		@Suppress("UNCHECKED_CAST")
		return nextDoubleExclusive(range as OpenEndRange<Double>)
	}

	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextDouble(range.start, range.calculateEndExclusive()).toDouble()
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextDoubleExclusive(range: OpenEndRange<Double>): Double {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextDouble(range.start, range.endExclusive).toDouble()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomClosedDouble")
fun ClosedRange<Double>.random(random: Random = Random.Default): Double = try {
	random.nextDouble(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullClosedDouble")
fun ClosedRange<Double>.randomOrNull(random: Random = Random.Default): Double? = takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomOpenEndDouble")
fun OpenEndRange<Double>.randomExclusive(random: Random = Random.Default): Double = try {
	random.nextDoubleExclusive(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullOpenEndDouble")
fun OpenEndRange<Double>.randomOrNullExclusive(random: Random = Random.Default): Double? = takeUnless { it.isEmpty() }?.randomExclusive(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextFloat(range: ClosedRange<Float>): Float {
	if (range is OpenEndRange<*>) {
		@Suppress("UNCHECKED_CAST")
		return nextFloatExclusive(range as OpenEndRange<Float>)
	}

	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextDouble(range.start.toDouble(), range.calculateEndExclusive().toDouble()).toFloat()
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextFloatExclusive(range: OpenEndRange<Float>): Float {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextDouble(range.start.toDouble(), range.endExclusive.toDouble()).toFloat()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomClosedFloat")
fun ClosedRange<Float>.random(random: Random = Random.Default): Float = try {
	random.nextFloat(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullClosedFloat")
fun ClosedRange<Float>.randomOrNull(random: Random = Random.Default): Float? = takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomOpenEndFloat")
fun OpenEndRange<Float>.randomExclusive(random: Random = Random.Default): Float = try {
	random.nextFloatExclusive(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullOpenEndFloat")
fun OpenEndRange<Float>.randomOrNullExclusive(random: Random = Random.Default): Float? = takeUnless { it.isEmpty() }?.randomExclusive(random)

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextChar(range: ClosedRange<Char>): Char {
	if (range is OpenEndRange<*>) {
		@Suppress("UNCHECKED_CAST")
		return nextCharExclusive(range as OpenEndRange<Char>)
	}

	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextInt(range.start.code, range.calculateEndExclusive().code).toChar()
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun Random.nextCharExclusive(range: OpenEndRange<Char>): Char {
	require(!range.isEmpty()) { "Cannot get random in empty range: $range" }
	return nextInt(range.start.code, range.endExclusive.code).toChar()
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomClosedChar")
fun ClosedRange<Char>.random(random: Random = Random.Default): Char = try {
	random.nextChar(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullClosedChar")
fun ClosedRange<Char>.randomOrNull(random: Random = Random.Default): Char? = takeUnless { it.isEmpty() }?.random(random)

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * @throws [NoSuchElementException] If the range is empty.
 */
@JvmName("randomOpenEndChar")
fun OpenEndRange<Char>.randomExclusive(random: Random = Random.Default): Char = try {
	random.nextCharExclusive(this)
} catch (e: IllegalArgumentException) {
	throw NoSuchElementException(e.message)
}

/**
 * Create a random value between [OpenEndRange.start] and [OpenEndRange.endExclusive], exclusive.
 * If the range is empty, then null will be returned instead.
 */
@JvmName("randomOrNullOpenEndChar")
fun OpenEndRange<Char>.randomOrNullExclusive(random: Random = Random.Default): Char? = takeUnless { it.isEmpty() }?.randomExclusive(random)
