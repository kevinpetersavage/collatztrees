package org.collatztrees;

import org.collatztrees.functions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Node {
    private final long[] a;
    private final long[] kOver2;
    private final Function u;
    private final Function d;

    private final BinaryOp lessThan;
    private final BinaryOp equalTo;
    private final UnaryOp mod3Equals2;

    public Node(long[] k, Function u, Function d, BinaryOp lessThan, BinaryOp equalTo, UnaryOp mod3Equals2, Function div2) {
        this(u.apply(k), div2.apply(k), u, d, lessThan, equalTo, mod3Equals2);
    }

    public Node(long[] a, long[] kOver2, Function u, Function d, BinaryOp lessThan, BinaryOp equalTo, UnaryOp mod3Equals2) {
        this.a = a;
        this.kOver2 = kOver2;
        this.u = u;
        this.d = d;
        this.lessThan = lessThan;
        this.equalTo = equalTo;
        this.mod3Equals2 = mod3Equals2;
    }

    public Set<Node> calculateImmediateChildren() {
        Set<Node> children = new HashSet<Node>();
        boolean aLessThanKOver2 = lessThan.apply(a, kOver2);
        if (aLessThanKOver2){
            children.add(from(d));
        }
        if (mod3Equals2.apply(a) && (aLessThanKOver2 || !equalTo.apply(a,kOver2))){
            children.add(from(u));
        }
        return children;
    }

    private Node from(Function function) {
        return new Node(function.apply(a), kOver2, u, d, lessThan, equalTo, mod3Equals2);
    }

    public int size() {
        Set<Node> children = calculateImmediateChildren();
        int count = 1;
        for (Node child : children) {
            count += (child.size());
        }
        return count;
    }

    public boolean containsKOver2(){
        if (a==kOver2){
            return true;
        }
        Set<Node> children = calculateImmediateChildren();
        for (Node child : children) {
            if (child.containsKOver2()){
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!Arrays.equals(a, node.a)) return false;
        if (!Arrays.equals(kOver2, node.kOver2)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a != null ? Arrays.hashCode(a) : 0;
        result = 31 * result + (kOver2 != null ? Arrays.hashCode(kOver2) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "a=" + a +
                ", kOver2=" + kOver2 +
                '}';
    }
}
