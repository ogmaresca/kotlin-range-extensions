package com.ogm.kotlin.range.extensions

import java.math.BigDecimal
import java.math.BigInteger
import java.time.LocalDate

fun <T : Comparable<T>> ClosedRange<T>.mapToBigInteger(block: (T) -> BigInteger): BigIntegerRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToBigDecimal(block: (T) -> BigDecimal): BigDecimalRange =
	block(start)..block(endInclusive)

fun <T : Comparable<T>> ClosedRange<T>.mapToLocalDate(block: (T) -> LocalDate): LocalDateRange =
	block(start)..block(endInclusive)

// TODO support for every custom range
