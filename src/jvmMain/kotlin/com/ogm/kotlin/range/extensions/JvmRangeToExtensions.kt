package com.ogm.kotlin.range.extensions

import java.math.BigDecimal
import java.math.BigInteger
import java.time.LocalDate

fun ClosedRange<BigInteger>.toBigIntegerRange(): BigIntegerRange = when (this) {
	is BigIntegerRange -> this
	else -> start..endInclusive
}

fun ClosedRange<BigDecimal>.toBigDecimalRange(): BigDecimalRange = when (this) {
	is BigDecimalRange -> this
	else -> start..endInclusive
}

fun ClosedRange<LocalDate>.toLocalDateRange(): LocalDateRange = when (this) {
	is LocalDateRange -> this
	else -> start..endInclusive
}

// TODO support for every custom range
