package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class z extends CrashlyticsReport.e.AbstractC0438e {

    /* renamed from: a, reason: collision with root package name */
    private final int f31756a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31757b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31758c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f31759d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.AbstractC0438e.a {

        /* renamed from: a, reason: collision with root package name */
        private int f31760a;

        /* renamed from: b, reason: collision with root package name */
        private String f31761b;

        /* renamed from: c, reason: collision with root package name */
        private String f31762c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f31763d;

        /* renamed from: e, reason: collision with root package name */
        private byte f31764e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e.a
        public CrashlyticsReport.e.AbstractC0438e a() {
            String str;
            String str2;
            if (this.f31764e == 3 && (str = this.f31761b) != null && (str2 = this.f31762c) != null) {
                return new z(this.f31760a, str, str2, this.f31763d);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f31764e & 1) == 0) {
                sb2.append(" platform");
            }
            if (this.f31761b == null) {
                sb2.append(" version");
            }
            if (this.f31762c == null) {
                sb2.append(" buildVersion");
            }
            if ((this.f31764e & 2) == 0) {
                sb2.append(" jailbroken");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e.a
        public CrashlyticsReport.e.AbstractC0438e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f31762c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e.a
        public CrashlyticsReport.e.AbstractC0438e.a c(boolean z10) {
            this.f31763d = z10;
            this.f31764e = (byte) (this.f31764e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e.a
        public CrashlyticsReport.e.AbstractC0438e.a d(int i11) {
            this.f31760a = i11;
            this.f31764e = (byte) (this.f31764e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e.a
        public CrashlyticsReport.e.AbstractC0438e.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f31761b = str;
            return this;
        }
    }

    private z(int i11, String str, String str2, boolean z10) {
        this.f31756a = i11;
        this.f31757b = str;
        this.f31758c = str2;
        this.f31759d = z10;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e
    public String b() {
        return this.f31758c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e
    public int c() {
        return this.f31756a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e
    public String d() {
        return this.f31757b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0438e
    public boolean e() {
        return this.f31759d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.AbstractC0438e)) {
            return false;
        }
        CrashlyticsReport.e.AbstractC0438e abstractC0438e = (CrashlyticsReport.e.AbstractC0438e) obj;
        return this.f31756a == abstractC0438e.c() && this.f31757b.equals(abstractC0438e.d()) && this.f31758c.equals(abstractC0438e.b()) && this.f31759d == abstractC0438e.e();
    }

    public int hashCode() {
        return ((((((this.f31756a ^ 1000003) * 1000003) ^ this.f31757b.hashCode()) * 1000003) ^ this.f31758c.hashCode()) * 1000003) ^ (this.f31759d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f31756a + ", version=" + this.f31757b + ", buildVersion=" + this.f31758c + ", jailbroken=" + this.f31759d + "}";
    }
}
