package org.collatztrees;

import org.collatztrees.functions.*;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class NodeIntegrationTest {
    @Test
    public void forKEquals8mod54TheTreeShouldHave3Nodes(){
        long[] k = new long[]{0L, 62L};
        Node start = new Node(k, new U(), new D(), new LessThan(), new EqualTo(), new Mod3Equals2(), new Div2());

        int count = start.size();
        assertThat(count).isEqualTo(3);
    }

    @Test public void forKEquals8mod54TheTreeShouldNotContainKOver2(){
        long[] k = new long[]{0L, 62L};
        Node start = new Node(k, new U(), new D(), new LessThan(), new EqualTo(), new Mod3Equals2(), new Div2());
        assertThat(start.containsKOver2()).isFalse();
    }
}
