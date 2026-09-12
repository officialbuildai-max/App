package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class a0 extends CrashlyticsReport.e.f {

    /* renamed from: a, reason: collision with root package name */
    private final String f31512a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.f.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31513a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.f.a
        public CrashlyticsReport.e.f a() {
            String str = this.f31513a;
            if (str != null) {
                return new a0(str);
            }
            throw new IllegalStateException("Missing required properties: identifier");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.f.a
        public CrashlyticsReport.e.f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f31513a = str;
            return this;
        }
    }

    private a0(String str) {
        this.f31512a = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.f
    public String b() {
        return this.f31512a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.e.f) {
            return this.f31512a.equals(((CrashlyticsReport.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f31512a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f31512a + "}";
    }
}
