package com.ogm.kotlin.range.extensions

import java.time.LocalDate

@JvmName("reverseLocalDate")
fun ClosedRange<LocalDate>.reverse(): LocalDateRange = endInclusive..start

// TODO support for every custom range
