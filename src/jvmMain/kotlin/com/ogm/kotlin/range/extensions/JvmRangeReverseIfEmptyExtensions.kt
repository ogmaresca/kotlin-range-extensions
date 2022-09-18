package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.LocalDate

@JvmName("reversedIfEmptyBigInteger")
fun ClosedRange<BigInteger>.reversedIfEmpty(): BigIntegerRange = if (isEmpty()) {
	reversed()
} else {
	toBigIntegerRange()
}

@JvmName("reversedIfEmptyLocalDate")
fun ClosedRange<LocalDate>.reversedIfEmpty(): LocalDateRange = if (isEmpty()) {
	reversed()
} else {
	toLocalDateRange()
}

// TODO support for every custom range
