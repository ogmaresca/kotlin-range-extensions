package com.ogm.kotlin.range.extensions

import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoField
import kotlin.random.Random
import kotlin.random.nextLong

internal val NANOS_PER_SECOND = Duration.ofSeconds(1).nano - 1
