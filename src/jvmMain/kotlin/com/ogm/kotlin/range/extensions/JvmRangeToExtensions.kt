package com.ogm.kotlin.range.extensions

import java.time.LocalDate

fun ClosedRange<LocalDate>.toLocalDateRange(): LocalDateRange = when (this) {
	is LocalDateRange -> this
	else -> start..endInclusive
}

// TODO support for every custom range
