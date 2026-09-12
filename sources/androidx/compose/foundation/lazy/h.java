package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
public abstract class h {
    public static final n a(List list, o oVar, List list2, int i11, int i12, int i13) {
        int index = ((n) CollectionsKt.i0(list)).getIndex();
        int size = list2.size();
        int i14 = -1;
        int i15 = -1;
        int i16 = 0;
        while (i16 < size && ((Number) list2.get(i16)).intValue() <= index) {
            i15 = ((Number) list2.get(i16)).intValue();
            i16++;
            i14 = ((Number) ((i16 < 0 || i16 > CollectionsKt.n(list2)) ? -1 : list2.get(i16))).intValue();
        }
        int size2 = list.size();
        int i17 = Integer.MIN_VALUE;
        int i18 = Integer.MIN_VALUE;
        int i19 = -1;
        for (int i20 = 0; i20 < size2; i20++) {
            n nVar = (n) list.get(i20);
            if (nVar.getIndex() == i15) {
                i17 = nVar.g();
                i19 = i20;
            } else if (nVar.getIndex() == i14) {
                i18 = nVar.g();
            }
        }
        if (i15 == -1) {
            return null;
        }
        n e11 = o.e(oVar, i15, 0L, 2, null);
        e11.c(true);
        int max = i17 != Integer.MIN_VALUE ? Math.max(-i11, i17) : -i11;
        if (i18 != Integer.MIN_VALUE) {
            max = Math.min(max, i18 - e11.getSize());
        }
        e11.r(max, i12, i13);
        if (i19 != -1) {
            list.set(i19, e11);
        } else {
            list.add(0, e11);
        }
        return e11;
    }
}
