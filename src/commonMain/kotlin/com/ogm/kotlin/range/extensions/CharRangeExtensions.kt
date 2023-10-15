package com.ogm.kotlin.range.extensions

val CharRange.Companion.UPPER_CASE_ASCII_LETTERS
	get() = 'A'..'Z'

val CharRange.Companion.LOWER_CASE_ASCII_LETTERS
	get() = 'a'..'z'

val CharRange.Companion.ASCII_NUMBERS
	get() = '0'..'9'
