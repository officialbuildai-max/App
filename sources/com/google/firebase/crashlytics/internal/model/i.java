package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class i extends CrashlyticsReport.e.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f31601a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31602b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31603c;

    /* renamed from: d, reason: collision with root package name */
    private final CrashlyticsReport.e.a.b f31604d;

    /* renamed from: e, reason: collision with root package name */
    private final String f31605e;

    /* renamed from: f, reason: collision with root package name */
    private final String f31606f;

    /* renamed from: g, reason: collision with root package name */
    private final String f31607g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.a.AbstractC0423a {

        /* renamed from: a, reason: collision with root package name */
        private String f31608a;

        /* renamed from: b, reason: collision with root package name */
        private String f31609b;

        /* renamed from: c, reason: collision with root package name */
        private String f31610c;

        /* renamed from: d, reason: collision with root package name */
        private CrashlyticsReport.e.a.b f31611d;

        /* renamed from: e, reason: collision with root package name */
        private String f31612e;

        /* renamed from: f, reason: collision with root package name */
        private String f31613f;

        /* renamed from: g, reason: collision with root package name */
        private String f31614g;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0423a
        public CrashlyticsReport.e.a a() {
            String str;
            String str2 = this.f31608a;
            if (str2 != null && (str = this.f31609b) != null) {
                return new i(str2, str, this.f31610c, this.f31611d, this.f31612e, this.f31613f, this.f31614g);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31608a == null) {
                sb2.append(" identifier");
            }
            if (this.f31609b == null) {
                sb2.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0423a
        public CrashlyticsReport.e.a.AbstractC0423a b(String str) {
            this.f31613f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0423a
        public CrashlyticsReport.e.a.AbstractC0423a c(String str) {
            this.f31614g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0423a
        public CrashlyticsReport.e.a.AbstractC0423a d(String str) {
            this.f31610c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0423a
        public CrashlyticsReport.e.a.AbstractC0423a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f31608a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0423a
        public CrashlyticsReport.e.a.AbstractC0423a f(String str) {
            this.f31612e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0423a
        public CrashlyticsReport.e.a.AbstractC0423a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f31609b = str;
            return this;
        }
    }

    private i(String str, String str2, String str3, CrashlyticsReport.e.a.b bVar, String str4, String str5, String str6) {
        this.f31601a = str;
        this.f31602b = str2;
        this.f31603c = str3;
        this.f31604d = bVar;
        this.f31605e = str4;
        this.f31606f = str5;
        this.f31607g = str6;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    public String b() {
        return this.f31606f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    public String c() {
        return this.f31607g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    public String d() {
        return this.f31603c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    public String e() {
        return this.f31601a;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.e.a.b bVar;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.a)) {
            return false;
        }
        CrashlyticsReport.e.a aVar = (CrashlyticsReport.e.a) obj;
        if (this.f31601a.equals(aVar.e()) && this.f31602b.equals(aVar.h()) && ((str = this.f31603c) != null ? str.equals(aVar.d()) : aVar.d() == null) && ((bVar = this.f31604d) != null ? bVar.equals(aVar.g()) : aVar.g() == null) && ((str2 = this.f31605e) != null ? str2.equals(aVar.f()) : aVar.f() == null) && ((str3 = this.f31606f) != null ? str3.equals(aVar.b()) : aVar.b() == null)) {
            String str4 = this.f31607g;
            if (str4 == null) {
                if (aVar.c() == null) {
                    return true;
                }
            } else if (str4.equals(aVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    public String f() {
        return this.f31605e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    public CrashlyticsReport.e.a.b g() {
        return this.f31604d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    public String h() {
        return this.f31602b;
    }

    public int hashCode() {
        int hashCode = (((this.f31601a.hashCode() ^ 1000003) * 1000003) ^ this.f31602b.hashCode()) * 1000003;
        String str = this.f31603c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        CrashlyticsReport.e.a.b bVar = this.f31604d;
        int hashCode3 = (hashCode2 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        String str2 = this.f31605e;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f31606f;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f31607g;
        return hashCode5 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f31601a + ", version=" + this.f31602b + ", displayVersion=" + this.f31603c + ", organization=" + this.f31604d + ", installationUuid=" + this.f31605e + ", developmentPlatform=" + this.f31606f + ", developmentPlatformVersion=" + this.f31607g + "}";
    }
}
