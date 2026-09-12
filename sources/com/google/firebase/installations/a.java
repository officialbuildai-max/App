package com.google.firebase.installations;

import com.google.firebase.installations.f;

/* loaded from: classes4.dex */
final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final String f31930a;

    /* renamed from: b, reason: collision with root package name */
    private final long f31931b;

    /* renamed from: c, reason: collision with root package name */
    private final long f31932c;

    /* loaded from: classes4.dex */
    static final class b extends f.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31933a;

        /* renamed from: b, reason: collision with root package name */
        private Long f31934b;

        /* renamed from: c, reason: collision with root package name */
        private Long f31935c;

        @Override // com.google.firebase.installations.f.a
        public f a() {
            String str = "";
            if (this.f31933a == null) {
                str = " token";
            }
            if (this.f31934b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f31935c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f31933a, this.f31934b.longValue(), this.f31935c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.f.a
        public f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f31933a = str;
            return this;
        }

        @Override // com.google.firebase.installations.f.a
        public f.a c(long j11) {
            this.f31935c = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.installations.f.a
        public f.a d(long j11) {
            this.f31934b = Long.valueOf(j11);
            return this;
        }
    }

    private a(String str, long j11, long j12) {
        this.f31930a = str;
        this.f31931b = j11;
        this.f31932c = j12;
    }

    @Override // com.google.firebase.installations.f
    public String b() {
        return this.f31930a;
    }

    @Override // com.google.firebase.installations.f
    public long c() {
        return this.f31932c;
    }

    @Override // com.google.firebase.installations.f
    public long d() {
        return this.f31931b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f31930a.equals(fVar.b()) && this.f31931b == fVar.d() && this.f31932c == fVar.c();
    }

    public int hashCode() {
        int hashCode = (this.f31930a.hashCode() ^ 1000003) * 1000003;
        long j11 = this.f31931b;
        long j12 = this.f31932c;
        return ((hashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f31930a + ", tokenExpirationTimestamp=" + this.f31931b + ", tokenCreationTimestamp=" + this.f31932c + "}";
    }
}
