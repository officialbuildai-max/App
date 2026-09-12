package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class u extends CrashlyticsReport.e.d.c {

    /* renamed from: a, reason: collision with root package name */
    private final Double f31726a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31727b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f31728c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31729d;

    /* renamed from: e, reason: collision with root package name */
    private final long f31730e;

    /* renamed from: f, reason: collision with root package name */
    private final long f31731f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.c.a {

        /* renamed from: a, reason: collision with root package name */
        private Double f31732a;

        /* renamed from: b, reason: collision with root package name */
        private int f31733b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f31734c;

        /* renamed from: d, reason: collision with root package name */
        private int f31735d;

        /* renamed from: e, reason: collision with root package name */
        private long f31736e;

        /* renamed from: f, reason: collision with root package name */
        private long f31737f;

        /* renamed from: g, reason: collision with root package name */
        private byte f31738g;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c a() {
            if (this.f31738g == 31) {
                return new u(this.f31732a, this.f31733b, this.f31734c, this.f31735d, this.f31736e, this.f31737f);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f31738g & 1) == 0) {
                sb2.append(" batteryVelocity");
            }
            if ((this.f31738g & 2) == 0) {
                sb2.append(" proximityOn");
            }
            if ((this.f31738g & 4) == 0) {
                sb2.append(" orientation");
            }
            if ((this.f31738g & 8) == 0) {
                sb2.append(" ramUsed");
            }
            if ((this.f31738g & 16) == 0) {
                sb2.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a b(Double d11) {
            this.f31732a = d11;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a c(int i11) {
            this.f31733b = i11;
            this.f31738g = (byte) (this.f31738g | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a d(long j11) {
            this.f31737f = j11;
            this.f31738g = (byte) (this.f31738g | 16);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a e(int i11) {
            this.f31735d = i11;
            this.f31738g = (byte) (this.f31738g | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a f(boolean z10) {
            this.f31734c = z10;
            this.f31738g = (byte) (this.f31738g | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a g(long j11) {
            this.f31736e = j11;
            this.f31738g = (byte) (this.f31738g | 8);
            return this;
        }
    }

    private u(Double d11, int i11, boolean z10, int i12, long j11, long j12) {
        this.f31726a = d11;
        this.f31727b = i11;
        this.f31728c = z10;
        this.f31729d = i12;
        this.f31730e = j11;
        this.f31731f = j12;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public Double b() {
        return this.f31726a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public int c() {
        return this.f31727b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public long d() {
        return this.f31731f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public int e() {
        return this.f31729d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.c)) {
            return false;
        }
        CrashlyticsReport.e.d.c cVar = (CrashlyticsReport.e.d.c) obj;
        Double d11 = this.f31726a;
        if (d11 != null ? d11.equals(cVar.b()) : cVar.b() == null) {
            if (this.f31727b == cVar.c() && this.f31728c == cVar.g() && this.f31729d == cVar.e() && this.f31730e == cVar.f() && this.f31731f == cVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public long f() {
        return this.f31730e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public boolean g() {
        return this.f31728c;
    }

    public int hashCode() {
        Double d11 = this.f31726a;
        int hashCode = ((((((((d11 == null ? 0 : d11.hashCode()) ^ 1000003) * 1000003) ^ this.f31727b) * 1000003) ^ (this.f31728c ? 1231 : 1237)) * 1000003) ^ this.f31729d) * 1000003;
        long j11 = this.f31730e;
        long j12 = this.f31731f;
        return ((hashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f31726a + ", batteryVelocity=" + this.f31727b + ", proximityOn=" + this.f31728c + ", orientation=" + this.f31729d + ", ramUsed=" + this.f31730e + ", diskUsed=" + this.f31731f + "}";
    }
}
