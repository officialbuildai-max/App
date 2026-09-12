package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final float f28669a;

    /* renamed from: b, reason: collision with root package name */
    private final List f28670b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28671c;

    /* renamed from: d, reason: collision with root package name */
    private final int f28672d;

    /* loaded from: classes4.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final float f28673a;

        /* renamed from: b, reason: collision with root package name */
        private final float f28674b;

        /* renamed from: d, reason: collision with root package name */
        private c f28676d;

        /* renamed from: e, reason: collision with root package name */
        private c f28677e;

        /* renamed from: c, reason: collision with root package name */
        private final List f28675c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        private int f28678f = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f28679g = -1;

        /* renamed from: h, reason: collision with root package name */
        private float f28680h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        private int f28681i = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(float f11, float f12) {
            this.f28673a = f11;
            this.f28674b = f12;
        }

        private static float j(float f11, float f12, int i11, int i12) {
            return (f11 - (i11 * f12)) + (i12 * f12);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b a(float f11, float f12, float f13) {
            return d(f11, f12, f13, false, true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b b(float f11, float f12, float f13) {
            return c(f11, f12, f13, false);
        }

        b c(float f11, float f12, float f13, boolean z10) {
            return d(f11, f12, f13, z10, false);
        }

        b d(float f11, float f12, float f13, boolean z10, boolean z11) {
            float f14;
            float f15 = f13 / 2.0f;
            float f16 = f11 - f15;
            float f17 = f15 + f11;
            float f18 = this.f28674b;
            if (f17 > f18) {
                f14 = Math.abs(f17 - Math.max(f17 - f13, f18));
            } else {
                f14 = 0.0f;
                if (f16 < 0.0f) {
                    f14 = Math.abs(f16 - Math.min(f16 + f13, 0.0f));
                }
            }
            return e(f11, f12, f13, z10, z11, f14);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b e(float f11, float f12, float f13, boolean z10, boolean z11, float f14) {
            return f(f11, f12, f13, z10, z11, f14, 0.0f, 0.0f);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b f(float f11, float f12, float f13, boolean z10, boolean z11, float f14, float f15, float f16) {
            if (f13 <= 0.0f) {
                return this;
            }
            if (z11) {
                if (z10) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i11 = this.f28681i;
                if (i11 != -1 && i11 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f28681i = this.f28675c.size();
            }
            c cVar = new c(Float.MIN_VALUE, f11, f12, f13, z11, f14, f15, f16);
            if (z10) {
                if (this.f28676d == null) {
                    this.f28676d = cVar;
                    this.f28678f = this.f28675c.size();
                }
                if (this.f28679g != -1 && this.f28675c.size() - this.f28679g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f13 != this.f28676d.f28685d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f28677e = cVar;
                this.f28679g = this.f28675c.size();
            } else {
                if (this.f28676d == null && cVar.f28685d < this.f28680h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f28677e != null && cVar.f28685d > this.f28680h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f28680h = cVar.f28685d;
            this.f28675c.add(cVar);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b g(float f11, float f12, float f13, int i11) {
            return h(f11, f12, f13, i11, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b h(float f11, float f12, float f13, int i11, boolean z10) {
            if (i11 > 0 && f13 > 0.0f) {
                for (int i12 = 0; i12 < i11; i12++) {
                    c((i12 * f13) + f11, f12, f13, z10);
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f i() {
            if (this.f28676d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f28675c.size(); i11++) {
                c cVar = (c) this.f28675c.get(i11);
                arrayList.add(new c(j(this.f28676d.f28683b, this.f28673a, this.f28678f, i11), cVar.f28683b, cVar.f28684c, cVar.f28685d, cVar.f28686e, cVar.f28687f, cVar.f28688g, cVar.f28689h));
            }
            return new f(this.f28673a, arrayList, this.f28678f, this.f28679g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        final float f28682a;

        /* renamed from: b, reason: collision with root package name */
        final float f28683b;

        /* renamed from: c, reason: collision with root package name */
        final float f28684c;

        /* renamed from: d, reason: collision with root package name */
        final float f28685d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f28686e;

        /* renamed from: f, reason: collision with root package name */
        final float f28687f;

        /* renamed from: g, reason: collision with root package name */
        final float f28688g;

        /* renamed from: h, reason: collision with root package name */
        final float f28689h;

        c(float f11, float f12, float f13, float f14) {
            this(f11, f12, f13, f14, false, 0.0f, 0.0f, 0.0f);
        }

        c(float f11, float f12, float f13, float f14, boolean z10, float f15, float f16, float f17) {
            this.f28682a = f11;
            this.f28683b = f12;
            this.f28684c = f13;
            this.f28685d = f14;
            this.f28686e = z10;
            this.f28687f = f15;
            this.f28688g = f16;
            this.f28689h = f17;
        }

        static c a(c cVar, c cVar2, float f11) {
            return new c(oa.a.a(cVar.f28682a, cVar2.f28682a, f11), oa.a.a(cVar.f28683b, cVar2.f28683b, f11), oa.a.a(cVar.f28684c, cVar2.f28684c, f11), oa.a.a(cVar.f28685d, cVar2.f28685d, f11));
        }
    }

    private f(float f11, List list, int i11, int i12) {
        this.f28669a = f11;
        this.f28670b = Collections.unmodifiableList(list);
        this.f28671c = i11;
        this.f28672d = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f m(f fVar, f fVar2, float f11) {
        if (fVar.f() != fVar2.f()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List g11 = fVar.g();
        List g12 = fVar2.g();
        if (g11.size() != g12.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < fVar.g().size(); i11++) {
            arrayList.add(c.a((c) g11.get(i11), (c) g12.get(i11), f11));
        }
        return new f(fVar.f(), arrayList, oa.a.c(fVar.b(), fVar2.b(), f11), oa.a.c(fVar.i(), fVar2.i(), f11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f n(f fVar, float f11) {
        b bVar = new b(fVar.f(), f11);
        float f12 = (f11 - fVar.j().f28683b) - (fVar.j().f28685d / 2.0f);
        int size = fVar.g().size() - 1;
        while (size >= 0) {
            c cVar = (c) fVar.g().get(size);
            bVar.d(f12 + (cVar.f28685d / 2.0f), cVar.f28684c, cVar.f28685d, size >= fVar.b() && size <= fVar.i(), cVar.f28686e);
            f12 += cVar.f28685d;
            size--;
        }
        return bVar.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a() {
        return (c) this.f28670b.get(this.f28671c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f28671c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        return (c) this.f28670b.get(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        for (int i11 = 0; i11 < this.f28670b.size(); i11++) {
            c cVar = (c) this.f28670b.get(i11);
            if (!cVar.f28686e) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List e() {
        return this.f28670b.subList(this.f28671c, this.f28672d + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f28669a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List g() {
        return this.f28670b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h() {
        return (c) this.f28670b.get(this.f28672d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f28672d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j() {
        return (c) this.f28670b.get(r0.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c k() {
        for (int size = this.f28670b.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f28670b.get(size);
            if (!cVar.f28686e) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        Iterator it = this.f28670b.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (((c) it.next()).f28686e) {
                i11++;
            }
        }
        return this.f28670b.size() - i11;
    }
}
