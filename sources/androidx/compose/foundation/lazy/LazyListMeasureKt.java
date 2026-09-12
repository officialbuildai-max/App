package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.b;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class LazyListMeasureKt {
    private static final List a(List list, List list2, List list3, int i11, int i12, int i13, int i14, int i15, boolean z10, b.k kVar, b.d dVar, boolean z11, o0.e eVar) {
        int i16 = z10 ? i12 : i11;
        boolean z12 = i13 < Math.min(i16, i14);
        if (z12 && i15 != 0) {
            throw new IllegalStateException("non-zero itemsScrollOffset");
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (!z12) {
            int size = list2.size();
            int i17 = i15;
            for (int i18 = 0; i18 < size; i18++) {
                n nVar = (n) list2.get(i18);
                i17 -= nVar.h();
                nVar.r(i17, i11, i12);
                arrayList.add(nVar);
            }
            int size2 = list.size();
            int i19 = i15;
            for (int i20 = 0; i20 < size2; i20++) {
                n nVar2 = (n) list.get(i20);
                nVar2.r(i19, i11, i12);
                arrayList.add(nVar2);
                i19 += nVar2.h();
            }
            int size3 = list3.size();
            for (int i21 = 0; i21 < size3; i21++) {
                n nVar3 = (n) list3.get(i21);
                nVar3.r(i19, i11, i12);
                arrayList.add(nVar3);
                i19 += nVar3.h();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i22 = 0; i22 < size4; i22++) {
                iArr[i22] = ((n) list.get(b(i22, z11, size4))).getSize();
            }
            int[] iArr2 = new int[size4];
            for (int i23 = 0; i23 < size4; i23++) {
                iArr2[i23] = 0;
            }
            if (z10) {
                if (kVar == null) {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                }
                kVar.c(eVar, i16, iArr, iArr2);
            } else {
                if (dVar == null) {
                    throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                }
                dVar.b(eVar, i16, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntProgression Y = ArraysKt.Y(iArr2);
            if (z11) {
                Y = RangesKt.r(Y);
            }
            int first = Y.getFirst();
            int last = Y.getLast();
            int step = Y.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i24 = iArr2[first];
                    n nVar4 = (n) list.get(b(first, z11, size4));
                    if (z11) {
                        i24 = (i16 - i24) - nVar4.getSize();
                    }
                    nVar4.r(i24, i11, i12);
                    arrayList.add(nVar4);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        return arrayList;
    }

    private static final int b(int i11, boolean z10, int i12) {
        return !z10 ? i11 : (i12 - i11) - 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
    
        r5 = (androidx.compose.foundation.lazy.j) r5.get(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List c(java.util.List r18, androidx.compose.foundation.lazy.o r19, int r20, int r21, java.util.List r22, float r23, boolean r24, androidx.compose.foundation.lazy.l r25) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.c(java.util.List, androidx.compose.foundation.lazy.o, int, int, java.util.List, float, boolean, androidx.compose.foundation.lazy.l):java.util.List");
    }

    private static final List d(int i11, o oVar, int i12, List list) {
        int max = Math.max(0, i11 - i12);
        int i13 = i11 - 1;
        ArrayList arrayList = null;
        if (max <= i13) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(o.e(oVar, i13, 0L, 2, null));
                if (i13 == max) {
                    break;
                }
                i13--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i14 = size - 1;
                int intValue = ((Number) list.get(size)).intValue();
                if (intValue < max) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(o.e(oVar, intValue, 0L, 2, null));
                }
                if (i14 < 0) {
                    break;
                }
                size = i14;
            }
        }
        return arrayList == null ? CollectionsKt.l() : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0390  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.m e(int r41, androidx.compose.foundation.lazy.o r42, int r43, int r44, int r45, int r46, int r47, int r48, float r49, long r50, boolean r52, java.util.List r53, androidx.compose.foundation.layout.b.k r54, androidx.compose.foundation.layout.b.d r55, boolean r56, o0.e r57, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r58, int r59, java.util.List r60, boolean r61, boolean r62, androidx.compose.foundation.lazy.l r63, kotlinx.coroutines.n0 r64, final androidx.compose.runtime.i1 r65, androidx.compose.ui.graphics.a4 r66, kotlin.jvm.functions.Function3 r67) {
        /*
            Method dump skipped, instructions count: 1096
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.e(int, androidx.compose.foundation.lazy.o, int, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.b$k, androidx.compose.foundation.layout.b$d, boolean, o0.e, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, androidx.compose.foundation.lazy.l, kotlinx.coroutines.n0, androidx.compose.runtime.i1, androidx.compose.ui.graphics.a4, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.m");
    }
}
