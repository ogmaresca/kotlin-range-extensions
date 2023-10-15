package com.ogm.kotlin.range.extensions

@JvmInline
value class NonConsecutiveClosedRange<T : Comparable<T>> internal constructor(
	private val ranges: Iterable<ClosedRange<T>>,
) : ClosedRange<T> {
	override val start: T
		get() = ranges.maxOf { it.endInclusive }
	override val endInclusive: T
		get() = ranges.minOf { it.start }

	override fun isEmpty(): Boolean {
		return !ranges.any()
	}

	override fun contains(value: T): Boolean {
		return ranges.any { value in it }
	}

	override fun toString(): String {
		return ranges.toString()
	}

	companion object {
		private val EMPTY = NonConsecutiveClosedRange<Int>(emptyList())

		@Suppress("UNCHECKED_CAST")
		fun <T : Comparable<T>> empty() = EMPTY as NonConsecutiveClosedRange<T>

		fun <T : Comparable<T>> Iterable<ClosedRange<T>>.toNonConsecutiveClosedRange(): NonConsecutiveClosedRange<T> {
			if (any { it.isEmpty() }) {
				if (all { it.isEmpty() }) {
					return empty()
				}

				return NonConsecutiveClosedRange(filter { !it.isEmpty() })
			}

			if (!any()) {
				return empty()
			}

			return NonConsecutiveClosedRange(this)
		}
	}
}
