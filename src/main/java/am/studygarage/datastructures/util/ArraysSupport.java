package am.studygarage.datastructures.util;

public final class ArraysSupport {
    public static final int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

    /**
     * Calculates a new array length given an array's current length, a preferred
     * growth value, and a minimum growth value.  If the preferred growth value
     * is less than the minimum growth value, the minimum growth value is used in
     * its place.  If the sum of the current length and the preferred growth
     * value does not exceed {@link #MAX_ARRAY_LENGTH}, that sum is returned.
     * If the sum of the current length and the minimum growth value does not
     * exceed {@code MAX_ARRAY_LENGTH}, then {@code MAX_ARRAY_LENGTH} is returned.
     * If the sum does not overflow an int, then {@code Integer.MAX_VALUE} is
     * returned.  Otherwise, {@code OutOfMemoryError} is thrown.
     *
     * @param oldLength   current length of the array (must be non negative)
     * @param minGrowth   minimum required growth of the array length (must be
     *                    positive)
     * @param prefGrowth  preferred growth of the array length (ignored, if less
     *                    then {@code minGrowth})
     * @return the new length of the array
     * @throws OutOfMemoryError if increasing {@code oldLength} by
     *                    {@code minGrowth} overflows.
     */
    public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        // assert oldLength >= 0
        // assert minGrowth > 0

        int newLength = Math.max(minGrowth, prefGrowth) + oldLength;
        if (newLength - MAX_ARRAY_LENGTH <= 0) {
            return newLength;
        }
        return hugeLength(oldLength, minGrowth);
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) { // overflow
            throw new OutOfMemoryError("Required array length too large");
        }
        if (minLength <= MAX_ARRAY_LENGTH) {
            return MAX_ARRAY_LENGTH;
        }
        return Integer.MAX_VALUE;
    }

    private ArraysSupport() {

    }
}
