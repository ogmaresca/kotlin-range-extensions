package com.ogm.kotlin.range.extensions

import java.math.BigDecimal
import java.math.BigInteger
import java.time.LocalDate

@JvmName("reversedIfEmptyBigInteger")
fun ClosedRange<BigInteger>.reversedIfEmpty(): BigIntegerRange = if (isEmpty()) {
	reversed()
} else {
	toBigIntegerRange()
}

@JvmName("reversedIfEmptyBigDecimal")
fun ClosedRange<BigDecimal>.reversedIfEmpty(): BigDecimalRange = if (isEmpty()) {
	reversed()
} else {
	toBigDecimalRange()
}

@JvmName("reversedIfEmptyLocalDate")
fun ClosedRange<LocalDate>.reversedIfEmpty(): LocalDateRange = if (isEmpty()) {
	reversed()
} else {
	toLocalDateRange()
}

// TODO support for every custom range
