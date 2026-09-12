package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class q extends CrashlyticsReport.e.d.a.b.AbstractC0429d {

    /* renamed from: a, reason: collision with root package name */
    private final String f31692a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31693b;

    /* renamed from: c, reason: collision with root package name */
    private final long f31694c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a {

        /* renamed from: a, reason: collision with root package name */
        private String f31695a;

        /* renamed from: b, reason: collision with root package name */
        private String f31696b;

        /* renamed from: c, reason: collision with root package name */
        private long f31697c;

        /* renamed from: d, reason: collision with root package name */
        private byte f31698d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a
        public CrashlyticsReport.e.d.a.b.AbstractC0429d a() {
            String str;
            String str2;
            if (this.f31698d == 1 && (str = this.f31695a) != null && (str2 = this.f31696b) != null) {
                return new q(str, str2, this.f31697c);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31695a == null) {
                sb2.append(" name");
            }
            if (this.f31696b == null) {
                sb2.append(" code");
            }
            if ((1 & this.f31698d) == 0) {
                sb2.append(" address");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a
        public CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a b(long j11) {
            this.f31697c = j11;
            this.f31698d = (byte) (this.f31698d | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a
        public CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f31696b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a
        public CrashlyticsReport.e.d.a.b.AbstractC0429d.AbstractC0430a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f31695a = str;
            return this;
        }
    }

    private q(String str, String str2, long j11) {
        this.f31692a = str;
        this.f31693b = str2;
        this.f31694c = j11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0429d
    public long b() {
        return this.f31694c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0429d
    public String c() {
        return this.f31693b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0429d
    public String d() {
        return this.f31692a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.AbstractC0429d)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.AbstractC0429d abstractC0429d = (CrashlyticsReport.e.d.a.b.AbstractC0429d) obj;
        return this.f31692a.equals(abstractC0429d.d()) && this.f31693b.equals(abstractC0429d.c()) && this.f31694c == abstractC0429d.b();
    }

    public int hashCode() {
        int hashCode = (((this.f31692a.hashCode() ^ 1000003) * 1000003) ^ this.f31693b.hashCode()) * 1000003;
        long j11 = this.f31694c;
        return hashCode ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f31692a + ", code=" + this.f31693b + ", address=" + this.f31694c + "}";
    }
}
