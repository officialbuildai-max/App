package a2;

import a2.k;
import android.net.Uri;
import androidx.media3.common.r;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final long f170a;

    /* renamed from: b, reason: collision with root package name */
    public final r f171b;

    /* renamed from: c, reason: collision with root package name */
    public final ImmutableList f172c;

    /* renamed from: d, reason: collision with root package name */
    public final long f173d;

    /* renamed from: e, reason: collision with root package name */
    public final List f174e;

    /* renamed from: f, reason: collision with root package name */
    public final List f175f;

    /* renamed from: g, reason: collision with root package name */
    public final List f176g;

    /* renamed from: h, reason: collision with root package name */
    private final i f177h;

    /* loaded from: classes.dex */
    public static class b extends j implements z1.e {

        /* renamed from: i, reason: collision with root package name */
        final k.a f178i;

        public b(long j11, r rVar, List list, k.a aVar, List list2, List list3, List list4) {
            super(j11, rVar, list, aVar, list2, list3, list4);
            this.f178i = aVar;
        }

        @Override // z1.e
        public long a(long j11, long j12) {
            return this.f178i.h(j11, j12);
        }

        @Override // z1.e
        public long b(long j11, long j12) {
            return this.f178i.d(j11, j12);
        }

        @Override // z1.e
        public long c(long j11, long j12) {
            return this.f178i.f(j11, j12);
        }

        @Override // z1.e
        public i d(long j11) {
            return this.f178i.k(this, j11);
        }

        @Override // z1.e
        public long e(long j11, long j12) {
            return this.f178i.i(j11, j12);
        }

        @Override // z1.e
        public long f(long j11) {
            return this.f178i.g(j11);
        }

        @Override // z1.e
        public boolean g() {
            return this.f178i.l();
        }

        @Override // z1.e
        public long getTimeUs(long j11) {
            return this.f178i.j(j11);
        }

        @Override // z1.e
        public long h() {
            return this.f178i.e();
        }

        @Override // z1.e
        public long i(long j11, long j12) {
            return this.f178i.c(j11, j12);
        }

        @Override // a2.j
        public String j() {
            return null;
        }

        @Override // a2.j
        public z1.e k() {
            return this;
        }

        @Override // a2.j
        public i l() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends j {

        /* renamed from: i, reason: collision with root package name */
        public final Uri f179i;

        /* renamed from: j, reason: collision with root package name */
        public final long f180j;

        /* renamed from: k, reason: collision with root package name */
        private final String f181k;

        /* renamed from: l, reason: collision with root package name */
        private final i f182l;

        /* renamed from: m, reason: collision with root package name */
        private final m f183m;

        public c(long j11, r rVar, List list, k.e eVar, List list2, List list3, List list4, String str, long j12) {
            super(j11, rVar, list, eVar, list2, list3, list4);
            this.f179i = Uri.parse(((a2.b) list.get(0)).f116a);
            i c11 = eVar.c();
            this.f182l = c11;
            this.f181k = str;
            this.f180j = j12;
            this.f183m = c11 != null ? null : new m(new i(null, 0L, j12));
        }

        @Override // a2.j
        public String j() {
            return this.f181k;
        }

        @Override // a2.j
        public z1.e k() {
            return this.f183m;
        }

        @Override // a2.j
        public i l() {
            return this.f182l;
        }
    }

    private j(long j11, r rVar, List list, k kVar, List list2, List list3, List list4) {
        androidx.media3.common.util.a.a(!list.isEmpty());
        this.f170a = j11;
        this.f171b = rVar;
        this.f172c = ImmutableList.copyOf((Collection) list);
        this.f174e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f175f = list3;
        this.f176g = list4;
        this.f177h = kVar.a(this);
        this.f173d = kVar.b();
    }

    public static j n(long j11, r rVar, List list, k kVar, List list2, List list3, List list4, String str) {
        if (kVar instanceof k.e) {
            return new c(j11, rVar, list, (k.e) kVar, list2, list3, list4, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j11, rVar, list, (k.a) kVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public abstract String j();

    public abstract z1.e k();

    public abstract i l();

    public i m() {
        return this.f177h;
    }
}
