package org.collatztrees;

import org.collatztrees.functions.BinaryOp;
import org.collatztrees.functions.Function;
import org.collatztrees.functions.UnaryOp;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NodeTest {
    private final long[] kOver2 = new long[]{0L, 12L};
    private final long[] a = new long[]{0L, 11L};
    private final long[] dAppliedToA = new long[]{0L, 20L};
    private final long[] uAppliedToA = new long[]{0L, 7L};

    private final Function u = mock(Function.class);
    private final Function d = mock(Function.class);
    private final BinaryOp lessThan = mock(BinaryOp.class);
    private final BinaryOp equalTo = mock(BinaryOp.class);
    private final UnaryOp mod3Equals2 = mock(UnaryOp.class);

    private final Node start = new Node(a, kOver2, u, d, lessThan, equalTo, mod3Equals2);

    @Test public void aLessThanKOver2(){
        when(lessThan.apply(a, kOver2)).thenReturn(true);
        when(d.apply(a)).thenReturn(dAppliedToA);
        when(mod3Equals2.apply(a)).thenReturn(false);

        Node[] children = start.calculateImmediateChildren();

        assertThat(children).containsOnly(nodeFrom(dAppliedToA, kOver2));
    }

    @Test public void aEquals2Mod3AndLessThanKOver2(){
        when(lessThan.apply(a, kOver2)).thenReturn(true);
        when(d.apply(a)).thenReturn(dAppliedToA);
        when(mod3Equals2.apply(a)).thenReturn(true);
        when(u.apply(a)).thenReturn(uAppliedToA);

        Node[] children = start.calculateImmediateChildren();

        assertThat(children).containsOnly(nodeFrom(dAppliedToA, kOver2), nodeFrom(uAppliedToA, kOver2));
    }

    @Test public void aEquals2Mod3AndGreaterThanKOver2(){
        when(lessThan.apply(a, kOver2)).thenReturn(false);
        when(mod3Equals2.apply(a)).thenReturn(true);
        when(u.apply(a)).thenReturn(uAppliedToA);

        Node[] children = start.calculateImmediateChildren();

        assertThat(children).containsOnly(nodeFrom(uAppliedToA, kOver2));
    }

    private Node nodeFrom(long[] a, long[] kOver2) {
        return new Node(a, kOver2, null, null, null, null, null);
    }
}
