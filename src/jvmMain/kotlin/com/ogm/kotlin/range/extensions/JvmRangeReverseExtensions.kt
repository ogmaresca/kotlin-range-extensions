package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.LocalDate

@JvmName("reverseBigInteger")
fun ClosedRange<BigInteger>.reverse(): BigIntegerRange = endInclusive..start

@JvmName("reverseLocalDate")
fun ClosedRange<LocalDate>.reverse(): LocalDateRange = endInclusive..start

// TODO support for every custom range
