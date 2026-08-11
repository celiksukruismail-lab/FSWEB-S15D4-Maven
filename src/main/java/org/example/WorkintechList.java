package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WorkintechList<E extends Comparable<? super E>> extends ArrayList<E> {

    @Override
    public boolean add(E element) {
        return !contains(element) && super.add(element);
    }

    @Override
    public void add(int index, E element) {
        if (!contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> elements) {
        boolean changed = false;
        for (E element : elements) {
            changed |= add(element);
        }
        return changed;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> elements) {
        boolean changed = false;
        int currentIndex = index;
        for (E element : elements) {
            if (!contains(element)) {
                super.add(currentIndex++, element);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public E set(int index, E element) {
        E currentElement = get(index);
        if (!currentElement.equals(element) && contains(element)) {
            return currentElement;
        }
        return super.set(index, element);
    }

    public void sort() {
        Collections.sort(this);
    }

    @Override
    public boolean remove(Object element) {
        boolean removed = super.remove(element);
        if (removed) {
            sort();
        }
        return removed;
    }
}
