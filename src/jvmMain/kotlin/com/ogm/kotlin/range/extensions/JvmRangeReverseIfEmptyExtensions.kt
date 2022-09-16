package com.ogm.kotlin.range.extensions

import java.time.LocalDate

@JvmName("reverseIfEmptyLocalDate")
fun ClosedRange<LocalDate>.reverseIfEmpty(): LocalDateRange = if (isEmpty()) {
	reverse()
} else {
	toLocalDateRange()
}

// TODO support for every custom range
