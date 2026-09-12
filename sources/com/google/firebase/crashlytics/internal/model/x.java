package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class x extends CrashlyticsReport.e.d.AbstractC0437e.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f31750a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31751b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.AbstractC0437e.b.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31752a;

        /* renamed from: b, reason: collision with root package name */
        private String f31753b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.b.a
        public CrashlyticsReport.e.d.AbstractC0437e.b a() {
            String str;
            String str2 = this.f31752a;
            if (str2 != null && (str = this.f31753b) != null) {
                return new x(str2, str);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31752a == null) {
                sb2.append(" rolloutId");
            }
            if (this.f31753b == null) {
                sb2.append(" variantId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.b.a
        public CrashlyticsReport.e.d.AbstractC0437e.b.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f31752a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.b.a
        public CrashlyticsReport.e.d.AbstractC0437e.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f31753b = str;
            return this;
        }
    }

    private x(String str, String str2) {
        this.f31750a = str;
        this.f31751b = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.b
    public String b() {
        return this.f31750a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.b
    public String c() {
        return this.f31751b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.AbstractC0437e.b)) {
            return false;
        }
        CrashlyticsReport.e.d.AbstractC0437e.b bVar = (CrashlyticsReport.e.d.AbstractC0437e.b) obj;
        return this.f31750a.equals(bVar.b()) && this.f31751b.equals(bVar.c());
    }

    public int hashCode() {
        return ((this.f31750a.hashCode() ^ 1000003) * 1000003) ^ this.f31751b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.f31750a + ", variantId=" + this.f31751b + "}";
    }
}
