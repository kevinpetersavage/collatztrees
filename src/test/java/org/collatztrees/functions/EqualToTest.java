package org.collatztrees.functions;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class EqualToTest {
    @Test
    public void shouldSayEqualIsEqual() throws Exception {
        long[] a = new long[]{100L, 10000L};
        long[] b = new long[]{100L, 10000L};

        assertThat(new EqualTo().apply(a, b)).isTrue();
        assertThat(new EqualTo().apply(a, a)).isTrue();
    }

    @Test
    public void shouldSayNotEqualNotEqual() throws Exception {
        long[] a = new long[]{100L, 10000L};
        long[] b = new long[]{100L, 20000L};
        long[] c = new long[]{200L, 10000L};
        long[] d = new long[]{200L, 20000L};

        assertThat(new EqualTo().apply(a, b)).isFalse();
        assertThat(new EqualTo().apply(a, c)).isFalse();
        assertThat(new EqualTo().apply(a, d)).isFalse();
    }
}
