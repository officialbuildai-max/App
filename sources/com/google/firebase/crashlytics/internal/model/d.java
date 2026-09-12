package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class d extends CrashlyticsReport.a.AbstractC0421a {

    /* renamed from: a, reason: collision with root package name */
    private final String f31558a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31559b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31560c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.a.AbstractC0421a.AbstractC0422a {

        /* renamed from: a, reason: collision with root package name */
        private String f31561a;

        /* renamed from: b, reason: collision with root package name */
        private String f31562b;

        /* renamed from: c, reason: collision with root package name */
        private String f31563c;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0421a.AbstractC0422a
        public CrashlyticsReport.a.AbstractC0421a a() {
            String str;
            String str2;
            String str3 = this.f31561a;
            if (str3 != null && (str = this.f31562b) != null && (str2 = this.f31563c) != null) {
                return new d(str3, str, str2);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31561a == null) {
                sb2.append(" arch");
            }
            if (this.f31562b == null) {
                sb2.append(" libraryName");
            }
            if (this.f31563c == null) {
                sb2.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0421a.AbstractC0422a
        public CrashlyticsReport.a.AbstractC0421a.AbstractC0422a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f31561a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0421a.AbstractC0422a
        public CrashlyticsReport.a.AbstractC0421a.AbstractC0422a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f31563c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0421a.AbstractC0422a
        public CrashlyticsReport.a.AbstractC0421a.AbstractC0422a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f31562b = str;
            return this;
        }
    }

    private d(String str, String str2, String str3) {
        this.f31558a = str;
        this.f31559b = str2;
        this.f31560c = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0421a
    public String b() {
        return this.f31558a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0421a
    public String c() {
        return this.f31560c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0421a
    public String d() {
        return this.f31559b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.a.AbstractC0421a)) {
            return false;
        }
        CrashlyticsReport.a.AbstractC0421a abstractC0421a = (CrashlyticsReport.a.AbstractC0421a) obj;
        return this.f31558a.equals(abstractC0421a.b()) && this.f31559b.equals(abstractC0421a.d()) && this.f31560c.equals(abstractC0421a.c());
    }

    public int hashCode() {
        return ((((this.f31558a.hashCode() ^ 1000003) * 1000003) ^ this.f31559b.hashCode()) * 1000003) ^ this.f31560c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f31558a + ", libraryName=" + this.f31559b + ", buildId=" + this.f31560c + "}";
    }
}
