package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.Duration

internal val NANOS_PER_SECOND = BigInteger.valueOf(Duration.ofSeconds(1).nano - 1L)

internal val BIG_INTEGER_MAX_LONG_VALUE = BigInteger.valueOf(Long.MAX_VALUE)
