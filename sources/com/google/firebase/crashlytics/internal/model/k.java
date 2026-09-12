package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class k extends CrashlyticsReport.e.c {

    /* renamed from: a, reason: collision with root package name */
    private final int f31615a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31616b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31617c;

    /* renamed from: d, reason: collision with root package name */
    private final long f31618d;

    /* renamed from: e, reason: collision with root package name */
    private final long f31619e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f31620f;

    /* renamed from: g, reason: collision with root package name */
    private final int f31621g;

    /* renamed from: h, reason: collision with root package name */
    private final String f31622h;

    /* renamed from: i, reason: collision with root package name */
    private final String f31623i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.c.a {

        /* renamed from: a, reason: collision with root package name */
        private int f31624a;

        /* renamed from: b, reason: collision with root package name */
        private String f31625b;

        /* renamed from: c, reason: collision with root package name */
        private int f31626c;

        /* renamed from: d, reason: collision with root package name */
        private long f31627d;

        /* renamed from: e, reason: collision with root package name */
        private long f31628e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f31629f;

        /* renamed from: g, reason: collision with root package name */
        private int f31630g;

        /* renamed from: h, reason: collision with root package name */
        private String f31631h;

        /* renamed from: i, reason: collision with root package name */
        private String f31632i;

        /* renamed from: j, reason: collision with root package name */
        private byte f31633j;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c a() {
            String str;
            String str2;
            String str3;
            if (this.f31633j == 63 && (str = this.f31625b) != null && (str2 = this.f31631h) != null && (str3 = this.f31632i) != null) {
                return new k(this.f31624a, str, this.f31626c, this.f31627d, this.f31628e, this.f31629f, this.f31630g, str2, str3);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f31633j & 1) == 0) {
                sb2.append(" arch");
            }
            if (this.f31625b == null) {
                sb2.append(" model");
            }
            if ((this.f31633j & 2) == 0) {
                sb2.append(" cores");
            }
            if ((this.f31633j & 4) == 0) {
                sb2.append(" ram");
            }
            if ((this.f31633j & 8) == 0) {
                sb2.append(" diskSpace");
            }
            if ((this.f31633j & 16) == 0) {
                sb2.append(" simulator");
            }
            if ((this.f31633j & 32) == 0) {
                sb2.append(" state");
            }
            if (this.f31631h == null) {
                sb2.append(" manufacturer");
            }
            if (this.f31632i == null) {
                sb2.append(" modelClass");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a b(int i11) {
            this.f31624a = i11;
            this.f31633j = (byte) (this.f31633j | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a c(int i11) {
            this.f31626c = i11;
            this.f31633j = (byte) (this.f31633j | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a d(long j11) {
            this.f31628e = j11;
            this.f31633j = (byte) (this.f31633j | 8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f31631h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f31625b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f31632i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a h(long j11) {
            this.f31627d = j11;
            this.f31633j = (byte) (this.f31633j | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a i(boolean z10) {
            this.f31629f = z10;
            this.f31633j = (byte) (this.f31633j | 16);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a j(int i11) {
            this.f31630g = i11;
            this.f31633j = (byte) (this.f31633j | 32);
            return this;
        }
    }

    private k(int i11, String str, int i12, long j11, long j12, boolean z10, int i13, String str2, String str3) {
        this.f31615a = i11;
        this.f31616b = str;
        this.f31617c = i12;
        this.f31618d = j11;
        this.f31619e = j12;
        this.f31620f = z10;
        this.f31621g = i13;
        this.f31622h = str2;
        this.f31623i = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public int b() {
        return this.f31615a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public int c() {
        return this.f31617c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public long d() {
        return this.f31619e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public String e() {
        return this.f31622h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.c)) {
            return false;
        }
        CrashlyticsReport.e.c cVar = (CrashlyticsReport.e.c) obj;
        return this.f31615a == cVar.b() && this.f31616b.equals(cVar.f()) && this.f31617c == cVar.c() && this.f31618d == cVar.h() && this.f31619e == cVar.d() && this.f31620f == cVar.j() && this.f31621g == cVar.i() && this.f31622h.equals(cVar.e()) && this.f31623i.equals(cVar.g());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public String f() {
        return this.f31616b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public String g() {
        return this.f31623i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public long h() {
        return this.f31618d;
    }

    public int hashCode() {
        int hashCode = (((((this.f31615a ^ 1000003) * 1000003) ^ this.f31616b.hashCode()) * 1000003) ^ this.f31617c) * 1000003;
        long j11 = this.f31618d;
        int i11 = (hashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f31619e;
        return ((((((((i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ (this.f31620f ? 1231 : 1237)) * 1000003) ^ this.f31621g) * 1000003) ^ this.f31622h.hashCode()) * 1000003) ^ this.f31623i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public int i() {
        return this.f31621g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public boolean j() {
        return this.f31620f;
    }

    public String toString() {
        return "Device{arch=" + this.f31615a + ", model=" + this.f31616b + ", cores=" + this.f31617c + ", ram=" + this.f31618d + ", diskSpace=" + this.f31619e + ", simulator=" + this.f31620f + ", state=" + this.f31621g + ", manufacturer=" + this.f31622h + ", modelClass=" + this.f31623i + "}";
    }
}
