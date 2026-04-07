package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    // clear()
    @Test
    void testClearNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    void testClearEdge() {
        IntegerSet set = new IntegerSet();
        set.clear();
        assertTrue(set.isEmpty());
    }

    // length()
    @Test
    void testLengthNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertEquals(2, set.length());
    }

    @Test
    void testLengthEdge() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
    }

    // equals()
    @Test
    void testEqualsDifferentOrder() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1); a.add(2);
        b.add(2); b.add(1);

        assertTrue(a.equals(b));
    }

    @Test
    void testEqualsMismatch() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(2);

        assertFalse(a.equals(b));
    }

    // contains()
    @Test
    void testContainsPresent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
    }

    @Test
    void testContainsAbsent() {
        IntegerSet set = new IntegerSet();
        assertFalse(set.contains(10));
    }

    // largest()
    @Test
    void testLargestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(3);
        assertEquals(3, set.largest());
    }

    @Test
    void testLargestSingle() {
        IntegerSet set = new IntegerSet();
        set.add(7);
        assertEquals(7, set.largest());
    }

    @Test
    void testLargestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(RuntimeException.class, set::largest);
    }

    // smallest()
    @Test
    void testSmallestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(3);
        assertEquals(1, set.smallest());
    }

    @Test
    void testSmallestSingle() {
        IntegerSet set = new IntegerSet();
        set.add(7);
        assertEquals(7, set.smallest());
    }

    @Test
    void testSmallestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(RuntimeException.class, set::smallest);
    }

    // add()
    @Test
    void testAddNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertTrue(set.contains(1));
    }

    @Test
    void testAddDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(1);
        assertEquals(1, set.length());
    }

    // remove()
    @Test
    void testRemoveNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(1);
        assertFalse(set.contains(1));
    }

    @Test
    void testRemoveMissing() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(2);
        assertEquals(1, set.length());
    }

    // union()
    @Test
    void testUnionNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1); b.add(2);

        IntegerSet result = a.union(b);
        assertTrue(result.contains(1) && result.contains(2));
    }

    @Test
    void testUnionWithEmpty() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        IntegerSet result = a.union(b);

        assertTrue(result.contains(1));
    }

    // intersect()
    @Test
    void testIntersectNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1); a.add(2);
        b.add(2);

        IntegerSet result = a.intersect(b);
        assertTrue(result.contains(2));
    }

    @Test
    void testIntersectNoOverlap() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(2);

        IntegerSet result = a.intersect(b);
        assertTrue(result.isEmpty());
    }

    // diff()
    @Test
    void testDiffNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1); a.add(2);
        b.add(2);

        IntegerSet result = a.diff(b);
        assertTrue(result.contains(1));
    }

    @Test
    void testDiffIdentical() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(1);

        IntegerSet result = a.diff(b);
        assertTrue(result.isEmpty());
    }

    // complement()
    @Test
    void testComplementNormal() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(1); b.add(2);

        IntegerSet result = a.complement(b);
        assertTrue(result.contains(2));
    }

    @Test
    void testComplementDisjoint() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(2);

        IntegerSet result = a.complement(b);
        assertTrue(result.contains(2));
    }

    // isEmpty()
    @Test
    void testIsEmptyTrue() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty());
    }

    // toString()
    @Test
    void testToStringNormal() {
        IntegerSet set = new IntegerSet();
        set.add(2); set.add(1);
        assertEquals("[1, 2]", set.toString());
    }

    @Test
    void testToStringEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }
}