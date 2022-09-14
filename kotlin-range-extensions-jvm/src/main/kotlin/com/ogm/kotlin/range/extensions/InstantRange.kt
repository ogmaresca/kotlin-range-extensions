package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoField
import kotlin.random.Random

private val NANOS_PER_SECOND = Duration.ofSeconds(1).nano - 1

fun ClosedRange<Instant>.random(random: Random = Random.Default): Instant {
	require(!isEmpty()) { "Cannot get random in empty range: $this" }

	val epochSecond = mapToLongRange { it.toEpochMilli() }.random(random)

	val startNanos = if (epochSecond == start.epochSecond) start.nano else 0
	val endNanos = if (epochSecond == endInclusive.epochSecond) endInclusive.nano else NANOS_PER_SECOND
	val nanos = (startNanos..endNanos).random(random)

	return Instant.ofEpochSecond(epochSecond).with(ChronoField.NANO_OF_SECOND, nanos.toLong())
}

