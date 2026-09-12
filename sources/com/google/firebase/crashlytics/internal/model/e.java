package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class e extends CrashlyticsReport.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f31564a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31565b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.c.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31566a;

        /* renamed from: b, reason: collision with root package name */
        private String f31567b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c.a
        public CrashlyticsReport.c a() {
            String str;
            String str2 = this.f31566a;
            if (str2 != null && (str = this.f31567b) != null) {
                return new e(str2, str);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31566a == null) {
                sb2.append(" key");
            }
            if (this.f31567b == null) {
                sb2.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c.a
        public CrashlyticsReport.c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f31566a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c.a
        public CrashlyticsReport.c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f31567b = str;
            return this;
        }
    }

    private e(String str, String str2) {
        this.f31564a = str;
        this.f31565b = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c
    public String b() {
        return this.f31564a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c
    public String c() {
        return this.f31565b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.c)) {
            return false;
        }
        CrashlyticsReport.c cVar = (CrashlyticsReport.c) obj;
        return this.f31564a.equals(cVar.b()) && this.f31565b.equals(cVar.c());
    }

    public int hashCode() {
        return ((this.f31564a.hashCode() ^ 1000003) * 1000003) ^ this.f31565b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f31564a + ", value=" + this.f31565b + "}";
    }
}
