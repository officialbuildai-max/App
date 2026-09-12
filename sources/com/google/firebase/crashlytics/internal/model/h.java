package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes4.dex */
final class h extends CrashlyticsReport.e {

    /* renamed from: a, reason: collision with root package name */
    private final String f31576a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31577b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31578c;

    /* renamed from: d, reason: collision with root package name */
    private final long f31579d;

    /* renamed from: e, reason: collision with root package name */
    private final Long f31580e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f31581f;

    /* renamed from: g, reason: collision with root package name */
    private final CrashlyticsReport.e.a f31582g;

    /* renamed from: h, reason: collision with root package name */
    private final CrashlyticsReport.e.f f31583h;

    /* renamed from: i, reason: collision with root package name */
    private final CrashlyticsReport.e.AbstractC0438e f31584i;

    /* renamed from: j, reason: collision with root package name */
    private final CrashlyticsReport.e.c f31585j;

    /* renamed from: k, reason: collision with root package name */
    private final List f31586k;

    /* renamed from: l, reason: collision with root package name */
    private final int f31587l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.b {

        /* renamed from: a, reason: collision with root package name */
        private String f31588a;

        /* renamed from: b, reason: collision with root package name */
        private String f31589b;

        /* renamed from: c, reason: collision with root package name */
        private String f31590c;

        /* renamed from: d, reason: collision with root package name */
        private long f31591d;

        /* renamed from: e, reason: collision with root package name */
        private Long f31592e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f31593f;

        /* renamed from: g, reason: collision with root package name */
        private CrashlyticsReport.e.a f31594g;

        /* renamed from: h, reason: collision with root package name */
        private CrashlyticsReport.e.f f31595h;

        /* renamed from: i, reason: collision with root package name */
        private CrashlyticsReport.e.AbstractC0438e f31596i;

        /* renamed from: j, reason: collision with root package name */
        private CrashlyticsReport.e.c f31597j;

        /* renamed from: k, reason: collision with root package name */
        private List f31598k;

        /* renamed from: l, reason: collision with root package name */
        private int f31599l;

        /* renamed from: m, reason: collision with root package name */
        private byte f31600m;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(CrashlyticsReport.e eVar) {
            this.f31588a = eVar.g();
            this.f31589b = eVar.i();
            this.f31590c = eVar.c();
            this.f31591d = eVar.l();
            this.f31592e = eVar.e();
            this.f31593f = eVar.n();
            this.f31594g = eVar.b();
            this.f31595h = eVar.m();
            this.f31596i = eVar.k();
            this.f31597j = eVar.d();
            this.f31598k = eVar.f();
            this.f31599l = eVar.h();
            this.f31600m = (byte) 7;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e a() {
            String str;
            String str2;
            CrashlyticsReport.e.a aVar;
            if (this.f31600m == 7 && (str = this.f31588a) != null && (str2 = this.f31589b) != null && (aVar = this.f31594g) != null) {
                return new h(str, str2, this.f31590c, this.f31591d, this.f31592e, this.f31593f, aVar, this.f31595h, this.f31596i, this.f31597j, this.f31598k, this.f31599l);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31588a == null) {
                sb2.append(" generator");
            }
            if (this.f31589b == null) {
                sb2.append(" identifier");
            }
            if ((this.f31600m & 1) == 0) {
                sb2.append(" startedAt");
            }
            if ((this.f31600m & 2) == 0) {
                sb2.append(" crashed");
            }
            if (this.f31594g == null) {
                sb2.append(" app");
            }
            if ((this.f31600m & 4) == 0) {
                sb2.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b b(CrashlyticsReport.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f31594g = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b c(String str) {
            this.f31590c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b d(boolean z10) {
            this.f31593f = z10;
            this.f31600m = (byte) (this.f31600m | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b e(CrashlyticsReport.e.c cVar) {
            this.f31597j = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b f(Long l11) {
            this.f31592e = l11;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b g(List list) {
            this.f31598k = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f31588a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b i(int i11) {
            this.f31599l = i11;
            this.f31600m = (byte) (this.f31600m | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b j(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f31589b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b l(CrashlyticsReport.e.AbstractC0438e abstractC0438e) {
            this.f31596i = abstractC0438e;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b m(long j11) {
            this.f31591d = j11;
            this.f31600m = (byte) (this.f31600m | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b n(CrashlyticsReport.e.f fVar) {
            this.f31595h = fVar;
            return this;
        }
    }

    private h(String str, String str2, String str3, long j11, Long l11, boolean z10, CrashlyticsReport.e.a aVar, CrashlyticsReport.e.f fVar, CrashlyticsReport.e.AbstractC0438e abstractC0438e, CrashlyticsReport.e.c cVar, List list, int i11) {
        this.f31576a = str;
        this.f31577b = str2;
        this.f31578c = str3;
        this.f31579d = j11;
        this.f31580e = l11;
        this.f31581f = z10;
        this.f31582g = aVar;
        this.f31583h = fVar;
        this.f31584i = abstractC0438e;
        this.f31585j = cVar;
        this.f31586k = list;
        this.f31587l = i11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public CrashlyticsReport.e.a b() {
        return this.f31582g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public String c() {
        return this.f31578c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public CrashlyticsReport.e.c d() {
        return this.f31585j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public Long e() {
        return this.f31580e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l11;
        CrashlyticsReport.e.f fVar;
        CrashlyticsReport.e.AbstractC0438e abstractC0438e;
        CrashlyticsReport.e.c cVar;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e)) {
            return false;
        }
        CrashlyticsReport.e eVar = (CrashlyticsReport.e) obj;
        return this.f31576a.equals(eVar.g()) && this.f31577b.equals(eVar.i()) && ((str = this.f31578c) != null ? str.equals(eVar.c()) : eVar.c() == null) && this.f31579d == eVar.l() && ((l11 = this.f31580e) != null ? l11.equals(eVar.e()) : eVar.e() == null) && this.f31581f == eVar.n() && this.f31582g.equals(eVar.b()) && ((fVar = this.f31583h) != null ? fVar.equals(eVar.m()) : eVar.m() == null) && ((abstractC0438e = this.f31584i) != null ? abstractC0438e.equals(eVar.k()) : eVar.k() == null) && ((cVar = this.f31585j) != null ? cVar.equals(eVar.d()) : eVar.d() == null) && ((list = this.f31586k) != null ? list.equals(eVar.f()) : eVar.f() == null) && this.f31587l == eVar.h();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public List f() {
        return this.f31586k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public String g() {
        return this.f31576a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public int h() {
        return this.f31587l;
    }

    public int hashCode() {
        int hashCode = (((this.f31576a.hashCode() ^ 1000003) * 1000003) ^ this.f31577b.hashCode()) * 1000003;
        String str = this.f31578c;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j11 = this.f31579d;
        int i11 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        Long l11 = this.f31580e;
        int hashCode3 = (((((i11 ^ (l11 == null ? 0 : l11.hashCode())) * 1000003) ^ (this.f31581f ? 1231 : 1237)) * 1000003) ^ this.f31582g.hashCode()) * 1000003;
        CrashlyticsReport.e.f fVar = this.f31583h;
        int hashCode4 = (hashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        CrashlyticsReport.e.AbstractC0438e abstractC0438e = this.f31584i;
        int hashCode5 = (hashCode4 ^ (abstractC0438e == null ? 0 : abstractC0438e.hashCode())) * 1000003;
        CrashlyticsReport.e.c cVar = this.f31585j;
        int hashCode6 = (hashCode5 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List list = this.f31586k;
        return ((hashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f31587l;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public String i() {
        return this.f31577b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public CrashlyticsReport.e.AbstractC0438e k() {
        return this.f31584i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public long l() {
        return this.f31579d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public CrashlyticsReport.e.f m() {
        return this.f31583h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public boolean n() {
        return this.f31581f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public CrashlyticsReport.e.b o() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f31576a + ", identifier=" + this.f31577b + ", appQualitySessionId=" + this.f31578c + ", startedAt=" + this.f31579d + ", endedAt=" + this.f31580e + ", crashed=" + this.f31581f + ", app=" + this.f31582g + ", user=" + this.f31583h + ", os=" + this.f31584i + ", device=" + this.f31585j + ", events=" + this.f31586k + ", generatorType=" + this.f31587l + "}";
    }
}
