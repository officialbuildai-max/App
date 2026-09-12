package bd;

import bd.d;

/* loaded from: classes4.dex */
final class b extends d {

    /* renamed from: b, reason: collision with root package name */
    private final String f16421b;

    /* renamed from: c, reason: collision with root package name */
    private final String f16422c;

    /* renamed from: d, reason: collision with root package name */
    private final String f16423d;

    /* renamed from: e, reason: collision with root package name */
    private final String f16424e;

    /* renamed from: f, reason: collision with root package name */
    private final long f16425f;

    /* renamed from: bd.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0154b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        private String f16426a;

        /* renamed from: b, reason: collision with root package name */
        private String f16427b;

        /* renamed from: c, reason: collision with root package name */
        private String f16428c;

        /* renamed from: d, reason: collision with root package name */
        private String f16429d;

        /* renamed from: e, reason: collision with root package name */
        private long f16430e;

        /* renamed from: f, reason: collision with root package name */
        private byte f16431f;

        @Override // bd.d.a
        public d a() {
            if (this.f16431f == 1 && this.f16426a != null && this.f16427b != null && this.f16428c != null && this.f16429d != null) {
                return new b(this.f16426a, this.f16427b, this.f16428c, this.f16429d, this.f16430e);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f16426a == null) {
                sb2.append(" rolloutId");
            }
            if (this.f16427b == null) {
                sb2.append(" variantId");
            }
            if (this.f16428c == null) {
                sb2.append(" parameterKey");
            }
            if (this.f16429d == null) {
                sb2.append(" parameterValue");
            }
            if ((1 & this.f16431f) == 0) {
                sb2.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // bd.d.a
        public d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f16428c = str;
            return this;
        }

        @Override // bd.d.a
        public d.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f16429d = str;
            return this;
        }

        @Override // bd.d.a
        public d.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f16426a = str;
            return this;
        }

        @Override // bd.d.a
        public d.a e(long j11) {
            this.f16430e = j11;
            this.f16431f = (byte) (this.f16431f | 1);
            return this;
        }

        @Override // bd.d.a
        public d.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f16427b = str;
            return this;
        }
    }

    private b(String str, String str2, String str3, String str4, long j11) {
        this.f16421b = str;
        this.f16422c = str2;
        this.f16423d = str3;
        this.f16424e = str4;
        this.f16425f = j11;
    }

    @Override // bd.d
    public String b() {
        return this.f16423d;
    }

    @Override // bd.d
    public String c() {
        return this.f16424e;
    }

    @Override // bd.d
    public String d() {
        return this.f16421b;
    }

    @Override // bd.d
    public long e() {
        return this.f16425f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f16421b.equals(dVar.d()) && this.f16422c.equals(dVar.f()) && this.f16423d.equals(dVar.b()) && this.f16424e.equals(dVar.c()) && this.f16425f == dVar.e();
    }

    @Override // bd.d
    public String f() {
        return this.f16422c;
    }

    public int hashCode() {
        int hashCode = (((((((this.f16421b.hashCode() ^ 1000003) * 1000003) ^ this.f16422c.hashCode()) * 1000003) ^ this.f16423d.hashCode()) * 1000003) ^ this.f16424e.hashCode()) * 1000003;
        long j11 = this.f16425f;
        return hashCode ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f16421b + ", variantId=" + this.f16422c + ", parameterKey=" + this.f16423d + ", parameterValue=" + this.f16424e + ", templateVersion=" + this.f16425f + "}";
    }
}
