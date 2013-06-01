package org.collatztrees.functions;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class LessThanTest {
    @Test
    public void small() throws Exception {
        assertThat(new LessThan().apply(new long[]{0L, 100L}, new long[]{0L, 200L})).isTrue();
        assertThat(new LessThan().apply(new long[]{0L, 200L}, new long[]{0L, 200L})).isFalse();
        assertThat(new LessThan().apply(new long[]{0L, 300L}, new long[]{0L, 200L})).isFalse();
    }

    @Test
    public void big() throws Exception {
        assertThat(new LessThan().apply(new long[]{100L, 0L}, new long[]{200L, 0L})).isTrue();
        assertThat(new LessThan().apply(new long[]{200L, 0L}, new long[]{200L, 0L})).isFalse();
        assertThat(new LessThan().apply(new long[]{300L, 0L}, new long[]{200L, 0L})).isFalse();
    }

    @Test
    public void requiresBoth() throws Exception {
        assertThat(new LessThan().apply(new long[]{200L, 100L}, new long[]{200L, 200L})).isTrue();
        assertThat(new LessThan().apply(new long[]{200L, 200L}, new long[]{200L, 200L})).isFalse();
        assertThat(new LessThan().apply(new long[]{200L, 300L}, new long[]{200L, 200L})).isFalse();
    }
}
