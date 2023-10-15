package com.ogm.kotlin.range.extensions

fun CharProgression.Companion.fromClosedRange(range: ClosedRange<Char>, step: Int) =
	fromOpenEndRange(range.start, range.endInclusive, step)

fun CharProgression.Companion.fromOpenEndRange(rangeStart: Char, rangeEnd: Char, step: Int) =
	fromClosedRange(rangeStart, rangeEnd - 1, step)

fun CharProgression.Companion.fromOpenEndRange(range: OpenEndRange<Char>, step: Int) =
	fromOpenEndRange(range.start, range.endExclusive, step)
