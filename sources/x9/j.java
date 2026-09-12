package x9;

import android.net.Uri;
import com.google.android.exoplayer2.o1;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import x9.k;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final long f78233a;

    /* renamed from: b, reason: collision with root package name */
    public final o1 f78234b;

    /* renamed from: c, reason: collision with root package name */
    public final ImmutableList f78235c;

    /* renamed from: d, reason: collision with root package name */
    public final long f78236d;

    /* renamed from: e, reason: collision with root package name */
    public final List f78237e;

    /* renamed from: f, reason: collision with root package name */
    public final List f78238f;

    /* renamed from: g, reason: collision with root package name */
    public final List f78239g;

    /* renamed from: h, reason: collision with root package name */
    private final i f78240h;

    /* loaded from: classes4.dex */
    public static class b extends j implements w9.e {

        /* renamed from: i, reason: collision with root package name */
        final k.a f78241i;

        public b(long j11, o1 o1Var, List list, k.a aVar, List list2, List list3, List list4) {
            super(j11, o1Var, list, aVar, list2, list3, list4);
            this.f78241i = aVar;
        }

        @Override // w9.e
        public long a(long j11, long j12) {
            return this.f78241i.h(j11, j12);
        }

        @Override // w9.e
        public long b(long j11, long j12) {
            return this.f78241i.d(j11, j12);
        }

        @Override // w9.e
        public long c(long j11, long j12) {
            return this.f78241i.f(j11, j12);
        }

        @Override // w9.e
        public i d(long j11) {
            return this.f78241i.k(this, j11);
        }

        @Override // w9.e
        public long e(long j11, long j12) {
            return this.f78241i.i(j11, j12);
        }

        @Override // w9.e
        public long f(long j11) {
            return this.f78241i.g(j11);
        }

        @Override // w9.e
        public boolean g() {
            return this.f78241i.l();
        }

        @Override // w9.e
        public long getTimeUs(long j11) {
            return this.f78241i.j(j11);
        }

        @Override // w9.e
        public long h() {
            return this.f78241i.e();
        }

        @Override // w9.e
        public long i(long j11, long j12) {
            return this.f78241i.c(j11, j12);
        }

        @Override // x9.j
        public String j() {
            return null;
        }

        @Override // x9.j
        public w9.e k() {
            return this;
        }

        @Override // x9.j
        public i l() {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends j {

        /* renamed from: i, reason: collision with root package name */
        public final Uri f78242i;

        /* renamed from: j, reason: collision with root package name */
        public final long f78243j;

        /* renamed from: k, reason: collision with root package name */
        private final String f78244k;

        /* renamed from: l, reason: collision with root package name */
        private final i f78245l;

        /* renamed from: m, reason: collision with root package name */
        private final m f78246m;

        public c(long j11, o1 o1Var, List list, k.e eVar, List list2, List list3, List list4, String str, long j12) {
            super(j11, o1Var, list, eVar, list2, list3, list4);
            this.f78242i = Uri.parse(((x9.b) list.get(0)).f78180a);
            i c11 = eVar.c();
            this.f78245l = c11;
            this.f78244k = str;
            this.f78243j = j12;
            this.f78246m = c11 != null ? null : new m(new i(null, 0L, j12));
        }

        @Override // x9.j
        public String j() {
            return this.f78244k;
        }

        @Override // x9.j
        public w9.e k() {
            return this.f78246m;
        }

        @Override // x9.j
        public i l() {
            return this.f78245l;
        }
    }

    private j(long j11, o1 o1Var, List list, k kVar, List list2, List list3, List list4) {
        com.google.android.exoplayer2.util.a.a(!list.isEmpty());
        this.f78233a = j11;
        this.f78234b = o1Var;
        this.f78235c = ImmutableList.copyOf((Collection) list);
        this.f78237e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f78238f = list3;
        this.f78239g = list4;
        this.f78240h = kVar.a(this);
        this.f78236d = kVar.b();
    }

    public static j n(long j11, o1 o1Var, List list, k kVar, List list2, List list3, List list4, String str) {
        if (kVar instanceof k.e) {
            return new c(j11, o1Var, list, (k.e) kVar, list2, list3, list4, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j11, o1Var, list, (k.a) kVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public abstract String j();

    public abstract w9.e k();

    public abstract i l();

    public i m() {
        return this.f78240h;
    }
}
