package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class l extends CrashlyticsReport.e.d {

    /* renamed from: a, reason: collision with root package name */
    private final long f31634a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31635b;

    /* renamed from: c, reason: collision with root package name */
    private final CrashlyticsReport.e.d.a f31636c;

    /* renamed from: d, reason: collision with root package name */
    private final CrashlyticsReport.e.d.c f31637d;

    /* renamed from: e, reason: collision with root package name */
    private final CrashlyticsReport.e.d.AbstractC0436d f31638e;

    /* renamed from: f, reason: collision with root package name */
    private final CrashlyticsReport.e.d.f f31639f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.b {

        /* renamed from: a, reason: collision with root package name */
        private long f31640a;

        /* renamed from: b, reason: collision with root package name */
        private String f31641b;

        /* renamed from: c, reason: collision with root package name */
        private CrashlyticsReport.e.d.a f31642c;

        /* renamed from: d, reason: collision with root package name */
        private CrashlyticsReport.e.d.c f31643d;

        /* renamed from: e, reason: collision with root package name */
        private CrashlyticsReport.e.d.AbstractC0436d f31644e;

        /* renamed from: f, reason: collision with root package name */
        private CrashlyticsReport.e.d.f f31645f;

        /* renamed from: g, reason: collision with root package name */
        private byte f31646g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(CrashlyticsReport.e.d dVar) {
            this.f31640a = dVar.f();
            this.f31641b = dVar.g();
            this.f31642c = dVar.b();
            this.f31643d = dVar.c();
            this.f31644e = dVar.d();
            this.f31645f = dVar.e();
            this.f31646g = (byte) 1;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d a() {
            String str;
            CrashlyticsReport.e.d.a aVar;
            CrashlyticsReport.e.d.c cVar;
            if (this.f31646g == 1 && (str = this.f31641b) != null && (aVar = this.f31642c) != null && (cVar = this.f31643d) != null) {
                return new l(this.f31640a, str, aVar, cVar, this.f31644e, this.f31645f);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((1 & this.f31646g) == 0) {
                sb2.append(" timestamp");
            }
            if (this.f31641b == null) {
                sb2.append(" type");
            }
            if (this.f31642c == null) {
                sb2.append(" app");
            }
            if (this.f31643d == null) {
                sb2.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b b(CrashlyticsReport.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f31642c = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b c(CrashlyticsReport.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f31643d = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b d(CrashlyticsReport.e.d.AbstractC0436d abstractC0436d) {
            this.f31644e = abstractC0436d;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b e(CrashlyticsReport.e.d.f fVar) {
            this.f31645f = fVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b f(long j11) {
            this.f31640a = j11;
            this.f31646g = (byte) (this.f31646g | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f31641b = str;
            return this;
        }
    }

    private l(long j11, String str, CrashlyticsReport.e.d.a aVar, CrashlyticsReport.e.d.c cVar, CrashlyticsReport.e.d.AbstractC0436d abstractC0436d, CrashlyticsReport.e.d.f fVar) {
        this.f31634a = j11;
        this.f31635b = str;
        this.f31636c = aVar;
        this.f31637d = cVar;
        this.f31638e = abstractC0436d;
        this.f31639f = fVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public CrashlyticsReport.e.d.a b() {
        return this.f31636c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public CrashlyticsReport.e.d.c c() {
        return this.f31637d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public CrashlyticsReport.e.d.AbstractC0436d d() {
        return this.f31638e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public CrashlyticsReport.e.d.f e() {
        return this.f31639f;
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.e.d.AbstractC0436d abstractC0436d;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d)) {
            return false;
        }
        CrashlyticsReport.e.d dVar = (CrashlyticsReport.e.d) obj;
        if (this.f31634a == dVar.f() && this.f31635b.equals(dVar.g()) && this.f31636c.equals(dVar.b()) && this.f31637d.equals(dVar.c()) && ((abstractC0436d = this.f31638e) != null ? abstractC0436d.equals(dVar.d()) : dVar.d() == null)) {
            CrashlyticsReport.e.d.f fVar = this.f31639f;
            if (fVar == null) {
                if (dVar.e() == null) {
                    return true;
                }
            } else if (fVar.equals(dVar.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public long f() {
        return this.f31634a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public String g() {
        return this.f31635b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public CrashlyticsReport.e.d.b h() {
        return new b(this);
    }

    public int hashCode() {
        long j11 = this.f31634a;
        int hashCode = (((((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.f31635b.hashCode()) * 1000003) ^ this.f31636c.hashCode()) * 1000003) ^ this.f31637d.hashCode()) * 1000003;
        CrashlyticsReport.e.d.AbstractC0436d abstractC0436d = this.f31638e;
        int hashCode2 = (hashCode ^ (abstractC0436d == null ? 0 : abstractC0436d.hashCode())) * 1000003;
        CrashlyticsReport.e.d.f fVar = this.f31639f;
        return hashCode2 ^ (fVar != null ? fVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{timestamp=" + this.f31634a + ", type=" + this.f31635b + ", app=" + this.f31636c + ", device=" + this.f31637d + ", log=" + this.f31638e + ", rollouts=" + this.f31639f + "}";
    }
}
