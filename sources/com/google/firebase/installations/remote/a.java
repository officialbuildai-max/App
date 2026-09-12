package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

/* loaded from: classes4.dex */
final class a extends InstallationResponse {

    /* renamed from: a, reason: collision with root package name */
    private final String f31979a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31980b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31981c;

    /* renamed from: d, reason: collision with root package name */
    private final TokenResult f31982d;

    /* renamed from: e, reason: collision with root package name */
    private final InstallationResponse.ResponseCode f31983e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends InstallationResponse.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31984a;

        /* renamed from: b, reason: collision with root package name */
        private String f31985b;

        /* renamed from: c, reason: collision with root package name */
        private String f31986c;

        /* renamed from: d, reason: collision with root package name */
        private TokenResult f31987d;

        /* renamed from: e, reason: collision with root package name */
        private InstallationResponse.ResponseCode f31988e;

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse a() {
            return new a(this.f31984a, this.f31985b, this.f31986c, this.f31987d, this.f31988e);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a b(TokenResult tokenResult) {
            this.f31987d = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a c(String str) {
            this.f31985b = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a d(String str) {
            this.f31986c = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a e(InstallationResponse.ResponseCode responseCode) {
            this.f31988e = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a f(String str) {
            this.f31984a = str;
            return this;
        }
    }

    private a(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.f31979a = str;
        this.f31980b = str2;
        this.f31981c = str3;
        this.f31982d = tokenResult;
        this.f31983e = responseCode;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public TokenResult b() {
        return this.f31982d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String c() {
        return this.f31980b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String d() {
        return this.f31981c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public InstallationResponse.ResponseCode e() {
        return this.f31983e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f31979a;
        if (str != null ? str.equals(installationResponse.f()) : installationResponse.f() == null) {
            String str2 = this.f31980b;
            if (str2 != null ? str2.equals(installationResponse.c()) : installationResponse.c() == null) {
                String str3 = this.f31981c;
                if (str3 != null ? str3.equals(installationResponse.d()) : installationResponse.d() == null) {
                    TokenResult tokenResult = this.f31982d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.b()) : installationResponse.b() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f31983e;
                        if (responseCode == null) {
                            if (installationResponse.e() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.e())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String f() {
        return this.f31979a;
    }

    public int hashCode() {
        String str = this.f31979a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f31980b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f31981c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.f31982d;
        int hashCode4 = (hashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f31983e;
        return hashCode4 ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f31979a + ", fid=" + this.f31980b + ", refreshToken=" + this.f31981c + ", authToken=" + this.f31982d + ", responseCode=" + this.f31983e + "}";
    }
}
