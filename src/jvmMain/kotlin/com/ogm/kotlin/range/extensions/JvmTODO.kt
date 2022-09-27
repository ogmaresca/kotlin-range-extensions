package com.ogm.kotlin.range.extensions

import java.time.MonthDay
import java.time.Year
import java.time.YearMonth
import java.time.ZoneOffset

object JvmTODO {
	val zoneOffset = ZoneOffset.MIN..ZoneOffset.MAX

	val monthDay = MonthDay.now()..MonthDay.now()
	val year = Year.MIN_VALUE..Year.MAX_VALUE
	val yearMonth = YearMonth.now()..YearMonth.now()
}
