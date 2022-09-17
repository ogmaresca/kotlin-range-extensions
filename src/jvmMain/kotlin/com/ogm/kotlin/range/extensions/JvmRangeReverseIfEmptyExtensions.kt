package com.ogm.kotlin.range.extensions

import java.math.BigInteger
import java.time.LocalDate

@JvmName("reverseIfEmptyBigInteger")
fun ClosedRange<BigInteger>.reverseIfEmpty(): BigIntegerRange = if (isEmpty()) {
	reverse()
} else {
	toBigIntegerRange()
}

@JvmName("reverseIfEmptyLocalDate")
fun ClosedRange<LocalDate>.reverseIfEmpty(): LocalDateRange = if (isEmpty()) {
	reverse()
} else {
	toLocalDateRange()
}

// TODO support for every custom range
