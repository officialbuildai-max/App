package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* loaded from: classes4.dex */
final class b extends TokenResult {

    /* renamed from: a, reason: collision with root package name */
    private final String f31989a;

    /* renamed from: b, reason: collision with root package name */
    private final long f31990b;

    /* renamed from: c, reason: collision with root package name */
    private final TokenResult.ResponseCode f31991c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.installations.remote.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0445b extends TokenResult.a {

        /* renamed from: a, reason: collision with root package name */
        private String f31992a;

        /* renamed from: b, reason: collision with root package name */
        private Long f31993b;

        /* renamed from: c, reason: collision with root package name */
        private TokenResult.ResponseCode f31994c;

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult a() {
            String str = "";
            if (this.f31993b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f31992a, this.f31993b.longValue(), this.f31994c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a b(TokenResult.ResponseCode responseCode) {
            this.f31994c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a c(String str) {
            this.f31992a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a d(long j11) {
            this.f31993b = Long.valueOf(j11);
            return this;
        }
    }

    private b(String str, long j11, TokenResult.ResponseCode responseCode) {
        this.f31989a = str;
        this.f31990b = j11;
        this.f31991c = responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.ResponseCode b() {
        return this.f31991c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String c() {
        return this.f31989a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public long d() {
        return this.f31990b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f31989a;
        if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
            if (this.f31990b == tokenResult.d()) {
                TokenResult.ResponseCode responseCode = this.f31991c;
                if (responseCode == null) {
                    if (tokenResult.b() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f31989a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j11 = this.f31990b;
        int i11 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f31991c;
        return i11 ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f31989a + ", tokenExpirationTimestamp=" + this.f31990b + ", responseCode=" + this.f31991c + "}";
    }
}
