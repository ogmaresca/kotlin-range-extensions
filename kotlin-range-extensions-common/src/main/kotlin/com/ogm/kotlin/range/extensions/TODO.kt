package com.ogm.kotlin.range.extensions

object TODO {
	val byte = Byte.MIN_VALUE..Byte.MAX_VALUE
	val ubyte = UByte.MIN_VALUE..UByte.MAX_VALUE
	val short = Short.MIN_VALUE..Short.MAX_VALUE
	val ushort = UShort.MIN_VALUE..UShort.MAX_VALUE
	val uint = UInt.MIN_VALUE..UInt.MAX_VALUE
	val ulong = ULong.MIN_VALUE..ULong.MAX_VALUE
	// if(it != Double.NaN) { throw UnsupportedOperationException() }
	// check(it != Double.NaN) { "NaN isn't supported }
	// check(it != Double.NEGATIVE_INFINITY) { "-∞ isn't supported }
	// check(it != Double.POSITIVE_INFINITY) { "∞ isn't supported }
	val double = Double.MIN_VALUE..Double.MAX_VALUE
	// if(it != Float.NaN) { throw UnsupportedOperationException() }
	// check(it != Float.NaN) { "NaN isn't supported }
	// check(it != Float.NEGATIVE_INFINITY) { "-∞ isn't supported }
	// check(it != Float.POSITIVE_INFINITY) { "∞ isn't supported }
	val float = Float.MIN_VALUE..Float.MAX_VALUE
}
