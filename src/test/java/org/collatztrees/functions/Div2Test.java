package org.collatztrees.functions;

import org.collatztrees.Numbers;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class Div2Test {
    @Test
    public void small() throws Exception {
        assertThat(new Div2().apply(new long[]{0L, 100L})).isEqualTo(new long[]{0L, 50L});
    }

    @Test
    public void big() throws Exception {
        assertThat(new Div2().apply(new long[]{80L, 100L})).isEqualTo(new long[]{40L, 50L});
    }

    @Test
    public void transition() throws Exception {
        assertThat(new Div2().apply(new long[]{81L, 100L})).isEqualTo(new long[]{40L, 50L + (Numbers.largeNumberOverlap/2)});
        assertThat(new Div2().apply(new long[]{83L, 100L})).isEqualTo(new long[]{41L, 50L + (Numbers.largeNumberOverlap/2)});
    }
}
