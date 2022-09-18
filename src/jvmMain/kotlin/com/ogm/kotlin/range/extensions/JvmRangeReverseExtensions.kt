package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.LocalDate

@JvmName("reversedBigInteger")
fun ClosedRange<BigInteger>.reversed(): BigIntegerRange = endInclusive..start

@JvmName("reversedLocalDate")
fun ClosedRange<LocalDate>.reversed(): LocalDateRange = endInclusive..start

// TODO support for every custom range
