package com.ogm.kotlin.range.extensions

import java.time.LocalDate
import java.time.Period

internal infix fun LocalDate.diff(right: LocalDate) = Period.ofDays((right.toEpochDay() - toEpochDay()).toInt())

internal operator fun LocalDate.minus(right: LocalDate) = this - (right diff this)
