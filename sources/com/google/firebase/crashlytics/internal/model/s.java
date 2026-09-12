package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class s extends CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b {

    /* renamed from: a, reason: collision with root package name */
    private final long f31706a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31707b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31708c;

    /* renamed from: d, reason: collision with root package name */
    private final long f31709d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31710e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a {

        /* renamed from: a, reason: collision with root package name */
        private long f31711a;

        /* renamed from: b, reason: collision with root package name */
        private String f31712b;

        /* renamed from: c, reason: collision with root package name */
        private String f31713c;

        /* renamed from: d, reason: collision with root package name */
        private long f31714d;

        /* renamed from: e, reason: collision with root package name */
        private int f31715e;

        /* renamed from: f, reason: collision with root package name */
        private byte f31716f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b a() {
            String str;
            if (this.f31716f == 7 && (str = this.f31712b) != null) {
                return new s(this.f31711a, str, this.f31713c, this.f31714d, this.f31715e);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f31716f & 1) == 0) {
                sb2.append(" pc");
            }
            if (this.f31712b == null) {
                sb2.append(" symbol");
            }
            if ((this.f31716f & 2) == 0) {
                sb2.append(" offset");
            }
            if ((this.f31716f & 4) == 0) {
                sb2.append(" importance");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a b(String str) {
            this.f31713c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a c(int i11) {
            this.f31715e = i11;
            this.f31716f = (byte) (this.f31716f | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a d(long j11) {
            this.f31714d = j11;
            this.f31716f = (byte) (this.f31716f | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a e(long j11) {
            this.f31711a = j11;
            this.f31716f = (byte) (this.f31716f | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b.AbstractC0434a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f31712b = str;
            return this;
        }
    }

    private s(long j11, String str, String str2, long j12, int i11) {
        this.f31706a = j11;
        this.f31707b = str;
        this.f31708c = str2;
        this.f31709d = j12;
        this.f31710e = i11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b
    public String b() {
        return this.f31708c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b
    public int c() {
        return this.f31710e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b
    public long d() {
        return this.f31709d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b
    public long e() {
        return this.f31706a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b abstractC0433b = (CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b) obj;
        return this.f31706a == abstractC0433b.e() && this.f31707b.equals(abstractC0433b.f()) && ((str = this.f31708c) != null ? str.equals(abstractC0433b.b()) : abstractC0433b.b() == null) && this.f31709d == abstractC0433b.d() && this.f31710e == abstractC0433b.c();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0433b
    public String f() {
        return this.f31707b;
    }

    public int hashCode() {
        long j11 = this.f31706a;
        int hashCode = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.f31707b.hashCode()) * 1000003;
        String str = this.f31708c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j12 = this.f31709d;
        return ((hashCode2 ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.f31710e;
    }

    public String toString() {
        return "Frame{pc=" + this.f31706a + ", symbol=" + this.f31707b + ", file=" + this.f31708c + ", offset=" + this.f31709d + ", importance=" + this.f31710e + "}";
    }
}
