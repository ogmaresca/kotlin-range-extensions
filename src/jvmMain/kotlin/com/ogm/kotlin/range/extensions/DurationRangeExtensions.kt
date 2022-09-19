package com.ogm.kotlin.range.extensions

import java.time.Duration

infix fun Duration.until(that: Duration) = this..that.minusNanos(1)

infix fun Duration.downTo(that: Duration) = that..this
