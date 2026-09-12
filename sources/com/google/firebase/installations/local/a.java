package com.google.firebase.installations.local;

import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.b;

/* loaded from: classes4.dex */
final class a extends com.google.firebase.installations.local.b {

    /* renamed from: b, reason: collision with root package name */
    private final String f31964b;

    /* renamed from: c, reason: collision with root package name */
    private final PersistedInstallation.RegistrationStatus f31965c;

    /* renamed from: d, reason: collision with root package name */
    private final String f31966d;

    /* renamed from: e, reason: collision with root package name */
    private final String f31967e;

    /* renamed from: f, reason: collision with root package name */
    private final long f31968f;

    /* renamed from: g, reason: collision with root package name */
    private final long f31969g;

    /* renamed from: h, reason: collision with root package name */
    private final String f31970h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends b.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31971a;

        /* renamed from: b, reason: collision with root package name */
        private PersistedInstallation.RegistrationStatus f31972b;

        /* renamed from: c, reason: collision with root package name */
        private String f31973c;

        /* renamed from: d, reason: collision with root package name */
        private String f31974d;

        /* renamed from: e, reason: collision with root package name */
        private Long f31975e;

        /* renamed from: f, reason: collision with root package name */
        private Long f31976f;

        /* renamed from: g, reason: collision with root package name */
        private String f31977g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(com.google.firebase.installations.local.b bVar) {
            this.f31971a = bVar.d();
            this.f31972b = bVar.g();
            this.f31973c = bVar.b();
            this.f31974d = bVar.f();
            this.f31975e = Long.valueOf(bVar.c());
            this.f31976f = Long.valueOf(bVar.h());
            this.f31977g = bVar.e();
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b a() {
            String str = "";
            if (this.f31972b == null) {
                str = " registrationStatus";
            }
            if (this.f31975e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f31976f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f31971a, this.f31972b, this.f31973c, this.f31974d, this.f31975e.longValue(), this.f31976f.longValue(), this.f31977g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a b(String str) {
            this.f31973c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a c(long j11) {
            this.f31975e = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a d(String str) {
            this.f31971a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a e(String str) {
            this.f31977g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a f(String str) {
            this.f31974d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a g(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f31972b = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a h(long j11) {
            this.f31976f = Long.valueOf(j11);
            return this;
        }
    }

    private a(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j11, long j12, String str4) {
        this.f31964b = str;
        this.f31965c = registrationStatus;
        this.f31966d = str2;
        this.f31967e = str3;
        this.f31968f = j11;
        this.f31969g = j12;
        this.f31970h = str4;
    }

    @Override // com.google.firebase.installations.local.b
    public String b() {
        return this.f31966d;
    }

    @Override // com.google.firebase.installations.local.b
    public long c() {
        return this.f31968f;
    }

    @Override // com.google.firebase.installations.local.b
    public String d() {
        return this.f31964b;
    }

    @Override // com.google.firebase.installations.local.b
    public String e() {
        return this.f31970h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.firebase.installations.local.b)) {
            return false;
        }
        com.google.firebase.installations.local.b bVar = (com.google.firebase.installations.local.b) obj;
        String str3 = this.f31964b;
        if (str3 != null ? str3.equals(bVar.d()) : bVar.d() == null) {
            if (this.f31965c.equals(bVar.g()) && ((str = this.f31966d) != null ? str.equals(bVar.b()) : bVar.b() == null) && ((str2 = this.f31967e) != null ? str2.equals(bVar.f()) : bVar.f() == null) && this.f31968f == bVar.c() && this.f31969g == bVar.h()) {
                String str4 = this.f31970h;
                if (str4 == null) {
                    if (bVar.e() == null) {
                        return true;
                    }
                } else if (str4.equals(bVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.b
    public String f() {
        return this.f31967e;
    }

    @Override // com.google.firebase.installations.local.b
    public PersistedInstallation.RegistrationStatus g() {
        return this.f31965c;
    }

    @Override // com.google.firebase.installations.local.b
    public long h() {
        return this.f31969g;
    }

    public int hashCode() {
        String str = this.f31964b;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f31965c.hashCode()) * 1000003;
        String str2 = this.f31966d;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f31967e;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j11 = this.f31968f;
        int i11 = (hashCode3 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f31969g;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        String str4 = this.f31970h;
        return i12 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.local.b
    public b.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f31964b + ", registrationStatus=" + this.f31965c + ", authToken=" + this.f31966d + ", refreshToken=" + this.f31967e + ", expiresInSecs=" + this.f31968f + ", tokenCreationEpochInSecs=" + this.f31969g + ", fisError=" + this.f31970h + "}";
    }
}
