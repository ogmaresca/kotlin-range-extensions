package com.ogm.kotlin.range.extensions

import java.time.ZoneOffset

class ZoneOffsetProgression private constructor(start: ZoneOffset, endInclusive: ZoneOffset, step: Int) :
	AbstractToLongProgression<ZoneOffset, Int>(
		start,
		endInclusive,
		step,
		step.toLong(),
		0,
		ZoneOffsetToLongConverter,
	) {
	private object ZoneOffsetToLongConverter : AbstractToLongProgressionConverter<ZoneOffset> {
		override fun toLong(value: ZoneOffset): Long = value.totalSeconds.toLong()

		override fun toValue(value: Long): ZoneOffset = ZoneOffset.ofTotalSeconds(value.toInt())
	}

	companion object {
		fun fromClosedRange(rangeStart: ZoneOffset, rangeEnd: ZoneOffset, step: Int) = ZoneOffsetProgression(rangeStart, rangeEnd, step)

		fun fromClosedRange(range: ClosedRange<ZoneOffset>, step: Int) = fromClosedRange(range.start, range.endInclusive, step)
	}
}
