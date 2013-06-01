package org.collatztrees;

import org.junit.Test;

import java.math.BigInteger;

import static org.fest.assertions.Assertions.assertThat;

public class BigIntegerParserTest {
    @Test
    public void parsingSmall(){
        assertThat(new BigIntegerParser().parse(BigInteger.ONE)).isEqualTo(new long[]{0L, 1L});
    }

    @Test
    public void parsingBig(){
        assertThat(new BigIntegerParser().parse(BigInteger.TEN.pow(22))).isEqualTo(new long[]{10000L, 0L});
    }

    @Test
    public void parsingMixture(){
        assertThat(new BigIntegerParser().parse(BigInteger.TEN.pow(22).add(BigInteger.ONE))).isEqualTo(new long[]{10000L, 1L});
    }
}
