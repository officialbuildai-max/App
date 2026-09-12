package com.google.android.material.carousel;

import com.google.android.material.carousel.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final f f28690a;

    /* renamed from: b, reason: collision with root package name */
    private final List f28691b;

    /* renamed from: c, reason: collision with root package name */
    private final List f28692c;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f28693d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f28694e;

    /* renamed from: f, reason: collision with root package name */
    private final float f28695f;

    /* renamed from: g, reason: collision with root package name */
    private final float f28696g;

    private g(f fVar, List list, List list2) {
        this.f28690a = fVar;
        this.f28691b = Collections.unmodifiableList(list);
        this.f28692c = Collections.unmodifiableList(list2);
        float f11 = ((f) list.get(list.size() - 1)).c().f28682a - fVar.c().f28682a;
        this.f28695f = f11;
        float f12 = fVar.j().f28682a - ((f) list2.get(list2.size() - 1)).j().f28682a;
        this.f28696g = f12;
        this.f28693d = m(f11, list, true);
        this.f28694e = m(f12, list2, false);
    }

    private f a(List list, float f11, float[] fArr) {
        float[] o11 = o(list, f11, fArr);
        return o11[0] >= 0.5f ? (f) list.get((int) o11[2]) : (f) list.get((int) o11[1]);
    }

    private static int b(f fVar, float f11) {
        for (int i11 = fVar.i(); i11 < fVar.g().size(); i11++) {
            if (f11 == ((f.c) fVar.g().get(i11)).f28684c) {
                return i11;
            }
        }
        return fVar.g().size() - 1;
    }

    private static int c(f fVar) {
        for (int i11 = 0; i11 < fVar.g().size(); i11++) {
            if (!((f.c) fVar.g().get(i11)).f28686e) {
                return i11;
            }
        }
        return -1;
    }

    private static int d(f fVar, float f11) {
        for (int b11 = fVar.b() - 1; b11 >= 0; b11--) {
            if (f11 == ((f.c) fVar.g().get(b11)).f28684c) {
                return b11;
            }
        }
        return 0;
    }

    private static int e(f fVar) {
        for (int size = fVar.g().size() - 1; size >= 0; size--) {
            if (!((f.c) fVar.g().get(size)).f28686e) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g f(b bVar, f fVar, float f11, float f12, float f13) {
        return new g(fVar, p(bVar, fVar, f11, f12), n(bVar, fVar, f11, f13));
    }

    private static float[] m(float f11, List list, boolean z10) {
        int size = list.size();
        float[] fArr = new float[size];
        int i11 = 1;
        while (i11 < size) {
            int i12 = i11 - 1;
            f fVar = (f) list.get(i12);
            f fVar2 = (f) list.get(i11);
            fArr[i11] = i11 == size + (-1) ? 1.0f : fArr[i12] + ((z10 ? fVar2.c().f28682a - fVar.c().f28682a : fVar.j().f28682a - fVar2.j().f28682a) / f11);
            i11++;
        }
        return fArr;
    }

    private static List n(b bVar, f fVar, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        int e11 = e(fVar);
        float a11 = bVar.d() ? bVar.a() : bVar.b();
        if (r(bVar, fVar) || e11 == -1) {
            if (f12 > 0.0f) {
                arrayList.add(u(fVar, f12, a11, false, f11));
            }
            return arrayList;
        }
        int i11 = e11 - fVar.i();
        float f13 = fVar.c().f28683b - (fVar.c().f28685d / 2.0f);
        if (i11 <= 0 && fVar.h().f28687f > 0.0f) {
            arrayList.add(v(fVar, f13 - fVar.h().f28687f, a11));
            return arrayList;
        }
        float f14 = 0.0f;
        int i12 = 0;
        while (i12 < i11) {
            f fVar2 = (f) arrayList.get(arrayList.size() - 1);
            int i13 = e11 - i12;
            float f15 = f14 + ((f.c) fVar.g().get(i13)).f28687f;
            int i14 = i13 + 1;
            int i15 = i12;
            f t11 = t(fVar2, e11, i14 < fVar.g().size() ? d(fVar2, ((f.c) fVar.g().get(i14)).f28684c) + 1 : 0, f13 - f15, fVar.b() + i12 + 1, fVar.i() + i12 + 1, a11);
            if (i15 == i11 - 1 && f12 > 0.0f) {
                t11 = u(t11, f12, a11, false, f11);
            }
            arrayList.add(t11);
            i12 = i15 + 1;
            f14 = f15;
        }
        return arrayList;
    }

    private static float[] o(List list, float f11, float[] fArr) {
        int size = list.size();
        float f12 = fArr[0];
        int i11 = 1;
        while (i11 < size) {
            float f13 = fArr[i11];
            if (f11 <= f13) {
                return new float[]{oa.a.b(0.0f, 1.0f, f12, f13, f11), i11 - 1, i11};
            }
            i11++;
            f12 = f13;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List p(b bVar, f fVar, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        int c11 = c(fVar);
        float a11 = bVar.d() ? bVar.a() : bVar.b();
        int i11 = 1;
        if (q(fVar) || c11 == -1) {
            if (f12 > 0.0f) {
                arrayList.add(u(fVar, f12, a11, true, f11));
            }
            return arrayList;
        }
        int b11 = fVar.b() - c11;
        float f13 = fVar.c().f28683b - (fVar.c().f28685d / 2.0f);
        if (b11 <= 0 && fVar.a().f28687f > 0.0f) {
            arrayList.add(v(fVar, f13 + fVar.a().f28687f, a11));
            return arrayList;
        }
        int i12 = 0;
        float f14 = 0.0f;
        while (i12 < b11) {
            f fVar2 = (f) arrayList.get(arrayList.size() - i11);
            int i13 = c11 + i12;
            int size = fVar.g().size() - i11;
            float f15 = f14 + ((f.c) fVar.g().get(i13)).f28687f;
            int i14 = i13 - i11;
            int b12 = i14 >= 0 ? b(fVar2, ((f.c) fVar.g().get(i14)).f28684c) - i11 : size;
            int i15 = i12;
            f t11 = t(fVar2, c11, b12, f13 + f15, (fVar.b() - i12) - 1, (fVar.i() - i12) - 1, a11);
            if (i15 == b11 - 1 && f12 > 0.0f) {
                t11 = u(t11, f12, a11, true, f11);
            }
            arrayList.add(t11);
            i12 = i15 + 1;
            f14 = f15;
            i11 = 1;
        }
        return arrayList;
    }

    private static boolean q(f fVar) {
        return fVar.a().f28683b - (fVar.a().f28685d / 2.0f) >= 0.0f && fVar.a() == fVar.d();
    }

    private static boolean r(b bVar, f fVar) {
        int b11 = bVar.b();
        if (bVar.d()) {
            b11 = bVar.a();
        }
        return fVar.h().f28683b + (fVar.h().f28685d / 2.0f) <= ((float) b11) && fVar.h() == fVar.k();
    }

    private static f s(List list, float f11, float[] fArr) {
        float[] o11 = o(list, f11, fArr);
        return f.m((f) list.get((int) o11[1]), (f) list.get((int) o11[2]), o11[0]);
    }

    private static f t(f fVar, int i11, int i12, float f11, int i13, int i14, float f12) {
        ArrayList arrayList = new ArrayList(fVar.g());
        arrayList.add(i12, (f.c) arrayList.remove(i11));
        f.b bVar = new f.b(fVar.f(), f12);
        int i15 = 0;
        while (i15 < arrayList.size()) {
            f.c cVar = (f.c) arrayList.get(i15);
            float f13 = cVar.f28685d;
            bVar.e(f11 + (f13 / 2.0f), cVar.f28684c, f13, i15 >= i13 && i15 <= i14, cVar.f28686e, cVar.f28687f);
            f11 += cVar.f28685d;
            i15++;
        }
        return bVar.i();
    }

    private static f u(f fVar, float f11, float f12, boolean z10, float f13) {
        ArrayList arrayList = new ArrayList(fVar.g());
        f.b bVar = new f.b(fVar.f(), f12);
        float l11 = f11 / fVar.l();
        float f14 = z10 ? f11 : 0.0f;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            f.c cVar = (f.c) arrayList.get(i11);
            if (cVar.f28686e) {
                bVar.e(cVar.f28683b, cVar.f28684c, cVar.f28685d, false, true, cVar.f28687f);
            } else {
                boolean z11 = i11 >= fVar.b() && i11 <= fVar.i();
                float f15 = cVar.f28685d - l11;
                float b11 = d.b(f15, fVar.f(), f13);
                float f16 = (f15 / 2.0f) + f14;
                float f17 = f16 - cVar.f28683b;
                bVar.f(f16, b11, f15, z11, false, cVar.f28687f, z10 ? f17 : 0.0f, z10 ? 0.0f : f17);
                f14 += f15;
            }
            i11++;
        }
        return bVar.i();
    }

    private static f v(f fVar, float f11, float f12) {
        return t(fVar, 0, 0, f11, fVar.b(), fVar.i(), f12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f g() {
        return this.f28690a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f h() {
        return (f) this.f28692c.get(r0.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map i(int i11, int i12, int i13, boolean z10) {
        float f11 = this.f28690a.f();
        HashMap hashMap = new HashMap();
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i14 >= i11) {
                break;
            }
            int i16 = z10 ? (i11 - i14) - 1 : i14;
            if (i16 * f11 * (z10 ? -1 : 1) > i13 - this.f28696g || i14 >= i11 - this.f28692c.size()) {
                Integer valueOf = Integer.valueOf(i16);
                List list = this.f28692c;
                hashMap.put(valueOf, (f) list.get(d1.a.b(i15, 0, list.size() - 1)));
                i15++;
            }
            i14++;
        }
        int i17 = 0;
        for (int i18 = i11 - 1; i18 >= 0; i18--) {
            int i19 = z10 ? (i11 - i18) - 1 : i18;
            if (i19 * f11 * (z10 ? -1 : 1) < i12 + this.f28695f || i18 < this.f28691b.size()) {
                Integer valueOf2 = Integer.valueOf(i19);
                List list2 = this.f28691b;
                hashMap.put(valueOf2, (f) list2.get(d1.a.b(i17, 0, list2.size() - 1)));
                i17++;
            }
        }
        return hashMap;
    }

    public f j(float f11, float f12, float f13) {
        return k(f11, f12, f13, false);
    }

    f k(float f11, float f12, float f13, boolean z10) {
        float b11;
        List list;
        float[] fArr;
        float f14 = this.f28695f + f12;
        float f15 = f13 - this.f28696g;
        float f16 = l().a().f28688g;
        float f17 = h().h().f28689h;
        if (this.f28695f == f16) {
            f14 += f16;
        }
        if (this.f28696g == f17) {
            f15 -= f17;
        }
        if (f11 < f14) {
            b11 = oa.a.b(1.0f, 0.0f, f12, f14, f11);
            list = this.f28691b;
            fArr = this.f28693d;
        } else {
            if (f11 <= f15) {
                return this.f28690a;
            }
            b11 = oa.a.b(0.0f, 1.0f, f15, f13, f11);
            list = this.f28692c;
            fArr = this.f28694e;
        }
        return z10 ? a(list, b11, fArr) : s(list, b11, fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f l() {
        return (f) this.f28691b.get(r0.size() - 1);
    }
}
