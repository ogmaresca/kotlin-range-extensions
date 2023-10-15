package com.ogm.kotlin.range.extensions

import kotlin.random.Random

/**
 * Create a random string of length [length], with all characters within
 * [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * @throws [IllegalStateException] If the range is empty.
 */
fun ClosedRange<Char>.randomString(length: Int, random: Random = Random.Default): String {
	require(length >= 0) { "length must be greater than zero" }
	return when (length) {
		0 -> ""
		else -> StringBuilder().let { sb ->
			repeat(length) { sb.append(random(random)) }
		}.toString()
	}
}

/**
 * Create a string of length [length], with all characters being a random character within
 * [ClosedRange.start] and [ClosedRange.endInclusive], inclusive.
 * If the range is empty, then null will be returned instead.
 */
fun ClosedRange<Char>.randomStringOrNull(length: Int, random: Random = Random.Default): String? =
	takeUnless { it.isEmpty() }?.randomString(length, random)

/**
 * Create a string of length [Iterable.count], with all characters being a random character within the
 * [ClosedRange.start] and [ClosedRange.endInclusive] of the index, inclusive.
 * @throws [IllegalStateException] If any of the ranges are empty.
 */
fun Iterable<ClosedRange<Char>>.randomString(random: Random = Random.Default): String = StringBuilder().apply {
	this@randomString.forEach { append(it.toCharRange().random(random)) }
}.toString()
