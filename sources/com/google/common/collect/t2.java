package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;

/* loaded from: classes4.dex */
public abstract class t2 extends n2 implements SortedMap {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(Comparator comparator, Object obj, Object obj2) {
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }
}
