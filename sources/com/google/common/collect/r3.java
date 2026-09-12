package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class r3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] a(Object[] objArr, int i11, int i12, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i11, i12, objArr2.getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(Enum r02) {
        return r02.getDeclaringClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] c(Object[] objArr, int i11) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, 0);
        }
        return Arrays.copyOf(objArr, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map d(int i11) {
        return CompactHashMap.createWithExpectedSize(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set e(int i11) {
        return CompactHashSet.createWithExpectedSize(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map f(int i11) {
        return CompactLinkedHashMap.createWithExpectedSize(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set g(int i11) {
        return CompactLinkedHashSet.createWithExpectedSize(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map h() {
        return CompactHashMap.create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map i(int i11) {
        return Maps.s(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapMaker j(MapMaker mapMaker) {
        return mapMaker.l();
    }
}
