package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class w extends CrashlyticsReport.e.d.AbstractC0437e {

    /* renamed from: a, reason: collision with root package name */
    private final CrashlyticsReport.e.d.AbstractC0437e.b f31741a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31742b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31743c;

    /* renamed from: d, reason: collision with root package name */
    private final long f31744d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.AbstractC0437e.a {

        /* renamed from: a, reason: collision with root package name */
        private CrashlyticsReport.e.d.AbstractC0437e.b f31745a;

        /* renamed from: b, reason: collision with root package name */
        private String f31746b;

        /* renamed from: c, reason: collision with root package name */
        private String f31747c;

        /* renamed from: d, reason: collision with root package name */
        private long f31748d;

        /* renamed from: e, reason: collision with root package name */
        private byte f31749e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.a
        public CrashlyticsReport.e.d.AbstractC0437e a() {
            CrashlyticsReport.e.d.AbstractC0437e.b bVar;
            String str;
            String str2;
            if (this.f31749e == 1 && (bVar = this.f31745a) != null && (str = this.f31746b) != null && (str2 = this.f31747c) != null) {
                return new w(bVar, str, str2, this.f31748d);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31745a == null) {
                sb2.append(" rolloutVariant");
            }
            if (this.f31746b == null) {
                sb2.append(" parameterKey");
            }
            if (this.f31747c == null) {
                sb2.append(" parameterValue");
            }
            if ((1 & this.f31749e) == 0) {
                sb2.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.a
        public CrashlyticsReport.e.d.AbstractC0437e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f31746b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.a
        public CrashlyticsReport.e.d.AbstractC0437e.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f31747c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.a
        public CrashlyticsReport.e.d.AbstractC0437e.a d(CrashlyticsReport.e.d.AbstractC0437e.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null rolloutVariant");
            }
            this.f31745a = bVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e.a
        public CrashlyticsReport.e.d.AbstractC0437e.a e(long j11) {
            this.f31748d = j11;
            this.f31749e = (byte) (this.f31749e | 1);
            return this;
        }
    }

    private w(CrashlyticsReport.e.d.AbstractC0437e.b bVar, String str, String str2, long j11) {
        this.f31741a = bVar;
        this.f31742b = str;
        this.f31743c = str2;
        this.f31744d = j11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e
    public String b() {
        return this.f31742b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e
    public String c() {
        return this.f31743c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e
    public CrashlyticsReport.e.d.AbstractC0437e.b d() {
        return this.f31741a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0437e
    public long e() {
        return this.f31744d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.AbstractC0437e)) {
            return false;
        }
        CrashlyticsReport.e.d.AbstractC0437e abstractC0437e = (CrashlyticsReport.e.d.AbstractC0437e) obj;
        return this.f31741a.equals(abstractC0437e.d()) && this.f31742b.equals(abstractC0437e.b()) && this.f31743c.equals(abstractC0437e.c()) && this.f31744d == abstractC0437e.e();
    }

    public int hashCode() {
        int hashCode = (((((this.f31741a.hashCode() ^ 1000003) * 1000003) ^ this.f31742b.hashCode()) * 1000003) ^ this.f31743c.hashCode()) * 1000003;
        long j11 = this.f31744d;
        return hashCode ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f31741a + ", parameterKey=" + this.f31742b + ", parameterValue=" + this.f31743c + ", templateVersion=" + this.f31744d + "}";
    }
}
