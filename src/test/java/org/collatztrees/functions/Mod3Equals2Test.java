package org.collatztrees.functions;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class Mod3Equals2Test {
    @Test
    public void small(){
        assertThat(new Mod3Equals2().apply(new long[]{0L, 100L})).isFalse();
        assertThat(new Mod3Equals2().apply(new long[]{0L, 101L})).isTrue();
        assertThat(new Mod3Equals2().apply(new long[]{0L, 102L})).isFalse();
    }

    @Test
    public void big(){
        assertThat(new Mod3Equals2().apply(new long[]{100L, 100L})).isTrue();
        assertThat(new Mod3Equals2().apply(new long[]{100L, 101L})).isFalse();
        assertThat(new Mod3Equals2().apply(new long[]{100L, 102L})).isFalse();
    }
}
