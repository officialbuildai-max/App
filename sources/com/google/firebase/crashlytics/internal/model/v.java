package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class v extends CrashlyticsReport.e.d.AbstractC0436d {

    /* renamed from: a, reason: collision with root package name */
    private final String f31739a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.AbstractC0436d.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31740a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0436d.a
        public CrashlyticsReport.e.d.AbstractC0436d a() {
            String str = this.f31740a;
            if (str != null) {
                return new v(str);
            }
            throw new IllegalStateException("Missing required properties: content");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0436d.a
        public CrashlyticsReport.e.d.AbstractC0436d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f31740a = str;
            return this;
        }
    }

    private v(String str) {
        this.f31739a = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0436d
    public String b() {
        return this.f31739a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.e.d.AbstractC0436d) {
            return this.f31739a.equals(((CrashlyticsReport.e.d.AbstractC0436d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f31739a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f31739a + "}";
    }
}
