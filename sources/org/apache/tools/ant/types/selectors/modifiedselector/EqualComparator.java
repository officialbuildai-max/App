package org.apache.tools.ant.types.selectors.modifiedselector;

import java.util.Comparator;

/* loaded from: classes7.dex */
public class EqualComparator implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj == null ? obj2 == null ? 1 : 0 : !obj.equals(obj2) ? 1 : 0;
    }

    public String toString() {
        return "EqualComparator";
    }
}
