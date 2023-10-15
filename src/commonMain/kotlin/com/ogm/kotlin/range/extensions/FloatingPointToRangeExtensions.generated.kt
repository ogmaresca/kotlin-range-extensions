/** Generated file */

package com.ogm.kotlin.range.extensions


fun ClosedRange<Double>.asDoubleRange(): ClosedFloatingPointRange<Double> = if (this is ClosedFloatingPointRange<*>) {
	@Suppress("UNCHECKED_CAST")
	this as ClosedFloatingPointRange<Double>
} else {
	start..endInclusive
}

@JvmName("toDoubleOpenEndRange")
fun ClosedRange<Double>.toOpenEndRange(): OpenEndRange<Double> = if (this is OpenEndRange<*>) {
	@Suppress("UNCHECKED_CAST")
	this as OpenEndRange<Double>
} else {
	start..<calculateEndExclusive()
}

fun OpenEndRange<Double>.asOpenDoubleRange(): ClosedFloatingPointRange<Double> = toClosedRange()

@JvmName("toDoubleClosedRange")
fun OpenEndRange<Double>.toClosedRange(): ClosedFloatingPointRange<Double> = if (this is ClosedRange<*>) {
	 @Suppress("UNCHECKED_CAST")
	 (this as ClosedRange<Double>).asDoubleRange()
} else {
	start..calculateEndInclusive()
}

fun ClosedRange<Float>.asFloatRange(): ClosedFloatingPointRange<Float> = if (this is ClosedFloatingPointRange<*>) {
	@Suppress("UNCHECKED_CAST")
	this as ClosedFloatingPointRange<Float>
} else {
	start..endInclusive
}

@JvmName("toFloatOpenEndRange")
fun ClosedRange<Float>.toOpenEndRange(): OpenEndRange<Float> = if (this is OpenEndRange<*>) {
	@Suppress("UNCHECKED_CAST")
	this as OpenEndRange<Float>
} else {
	start..<calculateEndExclusive()
}

fun OpenEndRange<Float>.asOpenFloatRange(): ClosedFloatingPointRange<Float> = toClosedRange()

@JvmName("toFloatClosedRange")
fun OpenEndRange<Float>.toClosedRange(): ClosedFloatingPointRange<Float> = if (this is ClosedRange<*>) {
	 @Suppress("UNCHECKED_CAST")
	 (this as ClosedRange<Float>).asFloatRange()
} else {
	start..calculateEndInclusive()
}
