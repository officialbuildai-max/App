package androidx.collection;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class d {
    public static final void a(b bVar, int i11) {
        Intrinsics.h(bVar, "<this>");
        bVar.m(new int[i11]);
        bVar.l(new Object[i11]);
    }

    public static final int b(b bVar, int i11) {
        Intrinsics.h(bVar, "<this>");
        try {
            return n.a.a(bVar.e(), bVar.h(), i11);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(b bVar, Object obj, int i11) {
        Intrinsics.h(bVar, "<this>");
        int h11 = bVar.h();
        if (h11 == 0) {
            return -1;
        }
        int b11 = b(bVar, i11);
        if (b11 < 0 || Intrinsics.c(obj, bVar.c()[b11])) {
            return b11;
        }
        int i12 = b11 + 1;
        while (i12 < h11 && bVar.e()[i12] == i11) {
            if (Intrinsics.c(obj, bVar.c()[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = b11 - 1; i13 >= 0 && bVar.e()[i13] == i11; i13--) {
            if (Intrinsics.c(obj, bVar.c()[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    public static final int d(b bVar) {
        Intrinsics.h(bVar, "<this>");
        return c(bVar, null, 0);
    }
}
