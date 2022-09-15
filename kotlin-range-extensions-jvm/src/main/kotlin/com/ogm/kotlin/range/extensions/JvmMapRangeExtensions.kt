package com.ogm.kotlin.range.extensions

import java.time.LocalDate

fun <T : Comparable<T>> ClosedRange<T>.mapToLocalDate(block: (T) -> LocalDate): LocalDateRange =
	block(start)..block(endInclusive)

// TODO support for every custom range
