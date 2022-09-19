package com.ogm.kotlin.range.extensions

import java.time.Instant

infix fun Instant.until(that: Instant) = this..that.minusNanos(1)

infix fun Instant.downTo(that: Instant) = that..this
