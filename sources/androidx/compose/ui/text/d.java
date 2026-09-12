package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a */
    private static final AnnotatedString f6161a = new AnnotatedString("", null, null, 6, null);

    public static final boolean f(int i11, int i12, int i13, int i14) {
        if (i11 > i13 || i14 > i12) {
            return false;
        }
        if (i12 == i14) {
            if ((i13 == i14) != (i11 == i12)) {
                return false;
            }
        }
        return true;
    }

    public static final List g(List list, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException(("start (" + i11 + ") should be less than or equal to end (" + i12 + ')').toString());
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            AnnotatedString.c cVar = (AnnotatedString.c) obj;
            if (k(i11, i12, cVar.f(), cVar.d())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i14 = 0; i14 < size2; i14++) {
            AnnotatedString.c cVar2 = (AnnotatedString.c) arrayList.get(i14);
            arrayList2.add(new AnnotatedString.c(cVar2.e(), Math.max(i11, cVar2.f()) - i11, Math.min(i12, cVar2.d()) - i11, cVar2.g()));
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return arrayList2;
    }

    public static final List h(AnnotatedString annotatedString, int i11, int i12) {
        List b11;
        if (i11 == i12 || (b11 = annotatedString.b()) == null) {
            return null;
        }
        if (i11 == 0 && i12 >= annotatedString.i().length()) {
            return b11;
        }
        ArrayList arrayList = new ArrayList(b11.size());
        int size = b11.size();
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = b11.get(i13);
            AnnotatedString.c cVar = (AnnotatedString.c) obj;
            if (k(i11, i12, cVar.f(), cVar.d())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i14 = 0; i14 < size2; i14++) {
            AnnotatedString.c cVar2 = (AnnotatedString.c) arrayList.get(i14);
            arrayList2.add(new AnnotatedString.c(cVar2.e(), RangesKt.m(cVar2.f(), i11, i12) - i11, RangesKt.m(cVar2.d(), i11, i12) - i11, cVar2.g()));
        }
        return arrayList2;
    }

    public static final List i(AnnotatedString annotatedString, int i11, int i12) {
        List f11;
        if (i11 == i12 || (f11 = annotatedString.f()) == null) {
            return null;
        }
        if (i11 == 0 && i12 >= annotatedString.i().length()) {
            return f11;
        }
        ArrayList arrayList = new ArrayList(f11.size());
        int size = f11.size();
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = f11.get(i13);
            AnnotatedString.c cVar = (AnnotatedString.c) obj;
            if (k(i11, i12, cVar.f(), cVar.d())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i14 = 0; i14 < size2; i14++) {
            AnnotatedString.c cVar2 = (AnnotatedString.c) arrayList.get(i14);
            arrayList2.add(new AnnotatedString.c(cVar2.e(), RangesKt.m(cVar2.f(), i11, i12) - i11, RangesKt.m(cVar2.d(), i11, i12) - i11));
        }
        return arrayList2;
    }

    public static final List j(AnnotatedString annotatedString, int i11, int i12) {
        List h11;
        if (i11 == i12 || (h11 = annotatedString.h()) == null) {
            return null;
        }
        if (i11 == 0 && i12 >= annotatedString.i().length()) {
            return h11;
        }
        ArrayList arrayList = new ArrayList(h11.size());
        int size = h11.size();
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = h11.get(i13);
            AnnotatedString.c cVar = (AnnotatedString.c) obj;
            if (k(i11, i12, cVar.f(), cVar.d())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i14 = 0; i14 < size2; i14++) {
            AnnotatedString.c cVar2 = (AnnotatedString.c) arrayList.get(i14);
            arrayList2.add(new AnnotatedString.c(cVar2.e(), RangesKt.m(cVar2.f(), i11, i12) - i11, RangesKt.m(cVar2.d(), i11, i12) - i11));
        }
        return arrayList2;
    }

    public static final boolean k(int i11, int i12, int i13, int i14) {
        return Math.max(i11, i13) < Math.min(i12, i14) || f(i11, i12, i13, i14) || f(i13, i14, i11, i12);
    }

    public static final List l(AnnotatedString annotatedString, r rVar) {
        int length = annotatedString.i().length();
        List f11 = annotatedString.f();
        if (f11 == null) {
            f11 = CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        int size = f11.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            AnnotatedString.c cVar = (AnnotatedString.c) f11.get(i11);
            r rVar2 = (r) cVar.a();
            int b11 = cVar.b();
            int c11 = cVar.c();
            if (b11 != i12) {
                arrayList.add(new AnnotatedString.c(rVar, i12, b11));
            }
            arrayList.add(new AnnotatedString.c(rVar.l(rVar2), b11, c11));
            i11++;
            i12 = c11;
        }
        if (i12 != length) {
            arrayList.add(new AnnotatedString.c(rVar, i12, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.c(rVar, 0, 0));
        }
        return arrayList;
    }

    public static final AnnotatedString m(AnnotatedString annotatedString, int i11, int i12) {
        String str;
        if (i11 != i12) {
            str = annotatedString.i().substring(i11, i12);
            Intrinsics.g(str, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str = "";
        }
        return new AnnotatedString(str, j(annotatedString, i11, i12), null, null, 12, null);
    }
}
