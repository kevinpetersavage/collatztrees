package org.collatztrees.functions;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class UTest {
    @Test
    public void small() throws Exception {
        assertThat(new U().apply(new long[]{0L, 101L})).isEqualTo(new long[]{0L, 67L});
    }

    @Test
    public void big() throws Exception {
        assertThat(new U().apply(new long[]{101L, 0L})).isEqualTo(new long[]{67L, 0L});
        assertThat(new U().apply(new long[]{101L, 101L})).isEqualTo(new long[]{67L, 67L});
    }

    @Test
    public void closeTransition() throws Exception {
        assertThat(new U().apply(new long[]{1L, 1L})).isEqualTo(new long[]{0L, 666666666666666667L});
    }

    @Test
    public void farTransition() throws Exception {
        assertThat(new U().apply(new long[]{10L, 1L})).isEqualTo(new long[]{6L, 666666666666666667L});
    }
}
