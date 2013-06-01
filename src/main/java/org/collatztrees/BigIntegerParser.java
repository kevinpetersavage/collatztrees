package org.collatztrees;

import java.math.BigInteger;

public class BigIntegerParser {
    public long[] parse(BigInteger original) {
        BigInteger largeOverlapAsBigInteger = new BigInteger(String.valueOf(Numbers.largeNumberOverlap));
        BigInteger small = original.mod(largeOverlapAsBigInteger);
        BigInteger large = original.subtract(small).divide(largeOverlapAsBigInteger);

        return new long[] {large.longValue(), small.longValue()};
    }
}
