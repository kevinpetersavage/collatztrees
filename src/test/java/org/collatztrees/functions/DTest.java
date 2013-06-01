package org.collatztrees.functions;

import org.junit.Test;

import static org.collatztrees.Numbers.largeNumberOverlap;
import static org.fest.assertions.Assertions.assertThat;

public class DTest {
    @Test
    public void shouldDoubleSmallNumbers() throws Exception {
        assertThat(new D().apply(new long[]{0L,100L})).isEqualTo(new long[]{0L, 200L});
    }

    @Test
    public void shouldDoubleLargeNumbers() throws Exception {
        assertThat(new D().apply(new long[]{100L,100L})).isEqualTo(new long[]{200L, 200L});
    }

    @Test
    public void shouldDoubleOverLapProperly() throws Exception {
        assertThat(new D().apply(new long[]{100L,largeNumberOverlap/2L})).isEqualTo(new long[]{201L, 0L});

    }
}
