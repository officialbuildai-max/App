package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class o extends CrashlyticsReport.e.d.a.b.AbstractC0425a {

    /* renamed from: a, reason: collision with root package name */
    private final long f31672a;

    /* renamed from: b, reason: collision with root package name */
    private final long f31673b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31674c;

    /* renamed from: d, reason: collision with root package name */
    private final String f31675d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a {

        /* renamed from: a, reason: collision with root package name */
        private long f31676a;

        /* renamed from: b, reason: collision with root package name */
        private long f31677b;

        /* renamed from: c, reason: collision with root package name */
        private String f31678c;

        /* renamed from: d, reason: collision with root package name */
        private String f31679d;

        /* renamed from: e, reason: collision with root package name */
        private byte f31680e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a
        public CrashlyticsReport.e.d.a.b.AbstractC0425a a() {
            String str;
            if (this.f31680e == 3 && (str = this.f31678c) != null) {
                return new o(this.f31676a, this.f31677b, str, this.f31679d);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f31680e & 1) == 0) {
                sb2.append(" baseAddress");
            }
            if ((this.f31680e & 2) == 0) {
                sb2.append(" size");
            }
            if (this.f31678c == null) {
                sb2.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a
        public CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a b(long j11) {
            this.f31676a = j11;
            this.f31680e = (byte) (this.f31680e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a
        public CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f31678c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a
        public CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a d(long j11) {
            this.f31677b = j11;
            this.f31680e = (byte) (this.f31680e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a
        public CrashlyticsReport.e.d.a.b.AbstractC0425a.AbstractC0426a e(String str) {
            this.f31679d = str;
            return this;
        }
    }

    private o(long j11, long j12, String str, String str2) {
        this.f31672a = j11;
        this.f31673b = j12;
        this.f31674c = str;
        this.f31675d = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a
    public long b() {
        return this.f31672a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a
    public String c() {
        return this.f31674c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a
    public long d() {
        return this.f31673b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0425a
    public String e() {
        return this.f31675d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.AbstractC0425a)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.AbstractC0425a abstractC0425a = (CrashlyticsReport.e.d.a.b.AbstractC0425a) obj;
        if (this.f31672a == abstractC0425a.b() && this.f31673b == abstractC0425a.d() && this.f31674c.equals(abstractC0425a.c())) {
            String str = this.f31675d;
            if (str == null) {
                if (abstractC0425a.e() == null) {
                    return true;
                }
            } else if (str.equals(abstractC0425a.e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j11 = this.f31672a;
        long j12 = this.f31673b;
        int hashCode = (((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.f31674c.hashCode()) * 1000003;
        String str = this.f31675d;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f31672a + ", size=" + this.f31673b + ", name=" + this.f31674c + ", uuid=" + this.f31675d + "}";
    }
}
