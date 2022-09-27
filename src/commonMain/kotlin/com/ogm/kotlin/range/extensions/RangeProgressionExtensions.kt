package com.ogm.kotlin.range.extensions

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Short>.step(step: Short = 1) = ShortProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<UShort>.step(step: Short = 1) = UShortProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Byte>.step(step: Byte = 1) = ByteProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<UByte>.step(step: Byte = 1) = UByteProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Double>.step(step: Double) = DoubleProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Float>.step(step: Float) = FloatProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Char>.step(step: Int) = CharProgression.fromClosedRange(start, endInclusive, step)

// TODO support for every custom range
