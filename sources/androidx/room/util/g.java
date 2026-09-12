package androidx.room.util;

import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class g {
    public static final boolean a(RoomDatabase.d dVar, int i11, int i12) {
        Intrinsics.h(dVar, "<this>");
        Map e11 = dVar.e();
        if (!e11.containsKey(Integer.valueOf(i11))) {
            return false;
        }
        Map map = (Map) e11.get(Integer.valueOf(i11));
        if (map == null) {
            map = MapsKt.h();
        }
        return map.containsKey(Integer.valueOf(i12));
    }

    public static final List b(RoomDatabase.d dVar, int i11, int i12) {
        Intrinsics.h(dVar, "<this>");
        if (i11 == i12) {
            return CollectionsKt.l();
        }
        return c(dVar, new ArrayList(), i12 > i11, i11, i12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
    
        return r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0009  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List c(androidx.room.RoomDatabase.d r5, java.util.List r6, boolean r7, int r8, int r9) {
        /*
        L0:
            if (r7 == 0) goto L5
            if (r8 >= r9) goto L5b
            goto L7
        L5:
            if (r8 <= r9) goto L5b
        L7:
            if (r7 == 0) goto Le
            kotlin.Pair r0 = r5.f(r8)
            goto L12
        Le:
            kotlin.Pair r0 = r5.g(r8)
        L12:
            r1 = 0
            if (r0 != 0) goto L16
            return r1
        L16:
            java.lang.Object r2 = r0.component1()
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r0 = r0.component2()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L26:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L53
            java.lang.Object r3 = r0.next()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r7 == 0) goto L3f
            int r4 = r8 + 1
            if (r4 > r3) goto L26
            if (r3 > r9) goto L26
            goto L43
        L3f:
            if (r9 > r3) goto L26
            if (r3 >= r8) goto L26
        L43:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            java.lang.Object r8 = r2.get(r8)
            kotlin.jvm.internal.Intrinsics.e(r8)
            r6.add(r8)
            r8 = 1
            goto L56
        L53:
            r0 = 0
            r3 = r8
            r8 = r0
        L56:
            if (r8 != 0) goto L59
            return r1
        L59:
            r8 = r3
            goto L0
        L5b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.g.c(androidx.room.RoomDatabase$d, java.util.List, boolean, int, int):java.util.List");
    }

    public static final boolean d(androidx.room.c cVar, int i11, int i12) {
        Intrinsics.h(cVar, "<this>");
        if (i11 > i12 && cVar.f14663l) {
            return false;
        }
        Set c11 = cVar.c();
        if (cVar.f14662k) {
            return c11 == null || !c11.contains(Integer.valueOf(i11));
        }
        return false;
    }
}
