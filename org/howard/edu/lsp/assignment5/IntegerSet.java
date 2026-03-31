package org.howard.edu.lsp.assignment5;

/**
 * @author Doron Reid
 */

import java.util.*;

public class IntegerSet {
    private ArrayList<Integer> setA = new ArrayList<>();

    /** 
     * Default Constructor
     * 
     * @param setA
     */
    public IntegerSet() {
        this.setA = new ArrayList<Integer>();
    }

    public void clear() {
        setA.clear();
    }

    public int length() {
        return setA.size();
    }

    public boolean equals(IntegerSet b) {
        if (b == null) return false;

        ArrayList<Integer> list1 = new ArrayList<>(this.setA);
        ArrayList<Integer> list2 = new ArrayList<>(b.setA);

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }

    public boolean contains(int value) {
        return setA.contains(value);
    }

    public int largest() {
        if (setA.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(setA);
    }

    public int smallest() {
        if (setA.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(setA);
    }

    public void add(int item) {
        if (!setA.contains(item)) {
            setA.add(item);
        }
    }

    public void remove(int item) {
        setA.remove(Integer.valueOf(item)); // FIXED (removes value, not index)
    }

    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        result.setA.addAll(this.setA);

        for (int val : intSetb.setA) {
            if (!result.setA.contains(val)) {
                result.setA.add(val);
            }
        }
        return result;
    }

    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : this.setA) {
            if (intSetb.setA.contains(val)) {
                result.add(val);
            }
        }
        return result;
    }

    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : this.setA) {
            if (!intSetb.setA.contains(val)) {
                result.add(val);
            }
        }
        return result;
    }

    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : intSetb.setA) {
            if (!this.setA.contains(val)) {
                result.add(val);
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return setA.isEmpty();
    }

    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(setA);
        Collections.sort(sorted);
        return sorted.toString();
    }
}