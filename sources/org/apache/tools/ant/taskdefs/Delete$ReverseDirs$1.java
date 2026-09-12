package org.apache.tools.ant.taskdefs;

import java.util.Comparator;

/* loaded from: classes7.dex */
final class Delete$ReverseDirs$1 implements Comparator {
    Delete$ReverseDirs$1() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo(obj2) * (-1);
    }
}
