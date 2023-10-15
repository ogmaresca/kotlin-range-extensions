/** Generated file */

package com.ogm.kotlin.range.extensions


fun ClosedRange<Long>.asLongRange(): LongRange = if (this is LongRange) {
	this
} else {
	(start..endInclusive)
}

@JvmName("toLongOpenEndRange")
fun ClosedRange<Long>.toOpenEndRange(): LongRange = if (this is LongRange) {
	this
} else {
	(start..<calculateEndExclusive())
}

fun OpenEndRange<Long>.asOpenLongRange(): LongRange = if (this is LongRange) {
	this
} else {
	(start..endExclusive)
}

@JvmName("toLongClosedRange")
fun OpenEndRange<Long>.toClosedRange(): LongRange = if (this is LongRange) {
	this
} else {
	(start..calculateEndInclusive())
}

fun ClosedRange<ULong>.asULongRange(): ULongRange = if (this is ULongRange) {
	this
} else {
	(start..endInclusive)
}

@JvmName("toULongOpenEndRange")
fun ClosedRange<ULong>.toOpenEndRange(): ULongRange = if (this is ULongRange) {
	this
} else {
	(start..<calculateEndExclusive())
}

fun OpenEndRange<ULong>.asOpenULongRange(): ULongRange = if (this is ULongRange) {
	this
} else {
	(start..endExclusive)
}

@JvmName("toULongClosedRange")
fun OpenEndRange<ULong>.toClosedRange(): ULongRange = if (this is ULongRange) {
	this
} else {
	(start..calculateEndInclusive())
}

fun ClosedRange<Int>.asIntRange(): IntRange = if (this is IntRange) {
	this
} else {
	(start..endInclusive)
}

@JvmName("toIntOpenEndRange")
fun ClosedRange<Int>.toOpenEndRange(): IntRange = if (this is IntRange) {
	this
} else {
	(start..<calculateEndExclusive())
}

fun OpenEndRange<Int>.asOpenIntRange(): IntRange = if (this is IntRange) {
	this
} else {
	(start..endExclusive)
}

@JvmName("toIntClosedRange")
fun OpenEndRange<Int>.toClosedRange(): IntRange = if (this is IntRange) {
	this
} else {
	(start..calculateEndInclusive())
}

fun ClosedRange<UInt>.asUIntRange(): UIntRange = if (this is UIntRange) {
	this
} else {
	(start..endInclusive)
}

@JvmName("toUIntOpenEndRange")
fun ClosedRange<UInt>.toOpenEndRange(): UIntRange = if (this is UIntRange) {
	this
} else {
	(start..<calculateEndExclusive())
}

fun OpenEndRange<UInt>.asOpenUIntRange(): UIntRange = if (this is UIntRange) {
	this
} else {
	(start..endExclusive)
}

@JvmName("toUIntClosedRange")
fun OpenEndRange<UInt>.toClosedRange(): UIntRange = if (this is UIntRange) {
	this
} else {
	(start..calculateEndInclusive())
}

fun ClosedRange<Short>.asShortRange(): ShortRange = if (this is ShortRange) {
	this
} else {
	ShortRange(start..endInclusive)
}

@JvmName("toShortOpenEndRange")
fun ClosedRange<Short>.toOpenEndRange(): ShortRange = if (this is ShortRange) {
	this
} else {
	ShortRange(start..<calculateEndExclusive())
}

fun OpenEndRange<Short>.asOpenShortRange(): ShortRange = if (this is ShortRange) {
	this
} else {
	ShortRange(start..endExclusive)
}

@JvmName("toShortClosedRange")
fun OpenEndRange<Short>.toClosedRange(): ShortRange = if (this is ShortRange) {
	this
} else {
	ShortRange(start..calculateEndInclusive())
}

fun ClosedRange<UShort>.asUShortRange(): UShortRange = if (this is UShortRange) {
	this
} else {
	UShortRange(start..endInclusive)
}

@JvmName("toUShortOpenEndRange")
fun ClosedRange<UShort>.toOpenEndRange(): UShortRange = if (this is UShortRange) {
	this
} else {
	UShortRange(start..<calculateEndExclusive())
}

fun OpenEndRange<UShort>.asOpenUShortRange(): UShortRange = if (this is UShortRange) {
	this
} else {
	UShortRange(start..endExclusive)
}

@JvmName("toUShortClosedRange")
fun OpenEndRange<UShort>.toClosedRange(): UShortRange = if (this is UShortRange) {
	this
} else {
	UShortRange(start..calculateEndInclusive())
}

fun ClosedRange<Byte>.asByteRange(): ByteRange = if (this is ByteRange) {
	this
} else {
	ByteRange(start..endInclusive)
}

@JvmName("toByteOpenEndRange")
fun ClosedRange<Byte>.toOpenEndRange(): ByteRange = if (this is ByteRange) {
	this
} else {
	ByteRange(start..<calculateEndExclusive())
}

fun OpenEndRange<Byte>.asOpenByteRange(): ByteRange = if (this is ByteRange) {
	this
} else {
	ByteRange(start..endExclusive)
}

@JvmName("toByteClosedRange")
fun OpenEndRange<Byte>.toClosedRange(): ByteRange = if (this is ByteRange) {
	this
} else {
	ByteRange(start..calculateEndInclusive())
}

fun ClosedRange<UByte>.asUByteRange(): UByteRange = if (this is UByteRange) {
	this
} else {
	UByteRange(start..endInclusive)
}

@JvmName("toUByteOpenEndRange")
fun ClosedRange<UByte>.toOpenEndRange(): UByteRange = if (this is UByteRange) {
	this
} else {
	UByteRange(start..<calculateEndExclusive())
}

fun OpenEndRange<UByte>.asOpenUByteRange(): UByteRange = if (this is UByteRange) {
	this
} else {
	UByteRange(start..endExclusive)
}

@JvmName("toUByteClosedRange")
fun OpenEndRange<UByte>.toClosedRange(): UByteRange = if (this is UByteRange) {
	this
} else {
	UByteRange(start..calculateEndInclusive())
}

fun ClosedRange<Char>.asCharRange(): CharRange = if (this is CharRange) {
	this
} else {
	(start..endInclusive)
}

@JvmName("toCharOpenEndRange")
fun ClosedRange<Char>.toOpenEndRange(): CharRange = if (this is CharRange) {
	this
} else {
	(start..<calculateEndExclusive())
}

fun OpenEndRange<Char>.asOpenCharRange(): CharRange = if (this is CharRange) {
	this
} else {
	(start..endExclusive)
}

@JvmName("toCharClosedRange")
fun OpenEndRange<Char>.toClosedRange(): CharRange = if (this is CharRange) {
	this
} else {
	(start..calculateEndInclusive())
}
