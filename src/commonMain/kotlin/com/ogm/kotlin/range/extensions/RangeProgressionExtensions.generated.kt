/** Generated file */

package com.ogm.kotlin.range.extensions

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Short>.step(step: Short = 1): ShortProgression = ShortProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [OpenEndRange.start] to [OpenEndRange.endExclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun OpenEndRange<Short>.step(step: Short = 1): ShortProgression = ShortProgression.fromOpenEndRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<UShort>.step(step: Short = 1): UShortProgression = UShortProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [OpenEndRange.start] to [OpenEndRange.endExclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun OpenEndRange<UShort>.step(step: Short = 1): UShortProgression = UShortProgression.fromOpenEndRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Byte>.step(step: Byte = 1): ByteProgression = ByteProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [OpenEndRange.start] to [OpenEndRange.endExclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun OpenEndRange<Byte>.step(step: Byte = 1): ByteProgression = ByteProgression.fromOpenEndRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<UByte>.step(step: Byte = 1): UByteProgression = UByteProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [OpenEndRange.start] to [OpenEndRange.endExclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun OpenEndRange<UByte>.step(step: Byte = 1): UByteProgression = UByteProgression.fromOpenEndRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Double>.step(step: Double = 1.0): DoubleProgression = DoubleProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [OpenEndRange.start] to [OpenEndRange.endExclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun OpenEndRange<Double>.step(step: Double = 1.0): DoubleProgression = DoubleProgression.fromOpenEndRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Float>.step(step: Float = 1.0F): FloatProgression = FloatProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [OpenEndRange.start] to [OpenEndRange.endExclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun OpenEndRange<Float>.step(step: Float = 1.0F): FloatProgression = FloatProgression.fromOpenEndRange(this, step)

/**
 * Create an [Iterable] from [ClosedRange.start] to [ClosedRange.endInclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun ClosedRange<Char>.step(step: Int = 1): CharProgression = CharProgression.fromClosedRange(this, step)

/**
 * Create an [Iterable] from [OpenEndRange.start] to [OpenEndRange.endExclusive], with each
 * value having a value of the size of [step] after the last value.
 * @throws [NoSuchElementException] If the range is empty.
 */
fun OpenEndRange<Char>.step(step: Int = 1): CharProgression = CharProgression.fromOpenEndRange(this, step)
