package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.i;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
final class b extends i {

    /* renamed from: a, reason: collision with root package name */
    private final String f24405a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f24406b;

    /* renamed from: c, reason: collision with root package name */
    private final h f24407c;

    /* renamed from: d, reason: collision with root package name */
    private final long f24408d;

    /* renamed from: e, reason: collision with root package name */
    private final long f24409e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f24410f;

    /* renamed from: g, reason: collision with root package name */
    private final Integer f24411g;

    /* renamed from: h, reason: collision with root package name */
    private final String f24412h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f24413i;

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f24414j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.datatransport.runtime.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0362b extends i.a {

        /* renamed from: a, reason: collision with root package name */
        private String f24415a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f24416b;

        /* renamed from: c, reason: collision with root package name */
        private h f24417c;

        /* renamed from: d, reason: collision with root package name */
        private Long f24418d;

        /* renamed from: e, reason: collision with root package name */
        private Long f24419e;

        /* renamed from: f, reason: collision with root package name */
        private Map f24420f;

        /* renamed from: g, reason: collision with root package name */
        private Integer f24421g;

        /* renamed from: h, reason: collision with root package name */
        private String f24422h;

        /* renamed from: i, reason: collision with root package name */
        private byte[] f24423i;

        /* renamed from: j, reason: collision with root package name */
        private byte[] f24424j;

        @Override // com.google.android.datatransport.runtime.i.a
        public i d() {
            String str = "";
            if (this.f24415a == null) {
                str = " transportName";
            }
            if (this.f24417c == null) {
                str = str + " encodedPayload";
            }
            if (this.f24418d == null) {
                str = str + " eventMillis";
            }
            if (this.f24419e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f24420f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f24415a, this.f24416b, this.f24417c, this.f24418d.longValue(), this.f24419e.longValue(), this.f24420f, this.f24421g, this.f24422h, this.f24423i, this.f24424j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.i.a
        protected Map e() {
            Map map = this.f24420f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.datatransport.runtime.i.a
        public i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f24420f = map;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a g(Integer num) {
            this.f24416b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f24417c = hVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a i(long j11) {
            this.f24418d = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a j(byte[] bArr) {
            this.f24423i = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a k(byte[] bArr) {
            this.f24424j = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a l(Integer num) {
            this.f24421g = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a m(String str) {
            this.f24422h = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a n(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f24415a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a o(long j11) {
            this.f24419e = Long.valueOf(j11);
            return this;
        }
    }

    private b(String str, Integer num, h hVar, long j11, long j12, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f24405a = str;
        this.f24406b = num;
        this.f24407c = hVar;
        this.f24408d = j11;
        this.f24409e = j12;
        this.f24410f = map;
        this.f24411g = num2;
        this.f24412h = str2;
        this.f24413i = bArr;
        this.f24414j = bArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.datatransport.runtime.i
    public Map c() {
        return this.f24410f;
    }

    @Override // com.google.android.datatransport.runtime.i
    public Integer d() {
        return this.f24406b;
    }

    @Override // com.google.android.datatransport.runtime.i
    public h e() {
        return this.f24407c;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f24405a.equals(iVar.n()) && ((num = this.f24406b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f24407c.equals(iVar.e()) && this.f24408d == iVar.f() && this.f24409e == iVar.o() && this.f24410f.equals(iVar.c()) && ((num2 = this.f24411g) != null ? num2.equals(iVar.l()) : iVar.l() == null) && ((str = this.f24412h) != null ? str.equals(iVar.m()) : iVar.m() == null)) {
            boolean z10 = iVar instanceof b;
            if (Arrays.equals(this.f24413i, z10 ? ((b) iVar).f24413i : iVar.g())) {
                if (Arrays.equals(this.f24414j, z10 ? ((b) iVar).f24414j : iVar.h())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.i
    public long f() {
        return this.f24408d;
    }

    @Override // com.google.android.datatransport.runtime.i
    public byte[] g() {
        return this.f24413i;
    }

    @Override // com.google.android.datatransport.runtime.i
    public byte[] h() {
        return this.f24414j;
    }

    public int hashCode() {
        int hashCode = (this.f24405a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f24406b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f24407c.hashCode()) * 1000003;
        long j11 = this.f24408d;
        int i11 = (hashCode2 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f24409e;
        int hashCode3 = (((i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ this.f24410f.hashCode()) * 1000003;
        Integer num2 = this.f24411g;
        int hashCode4 = (hashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f24412h;
        return ((((hashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f24413i)) * 1000003) ^ Arrays.hashCode(this.f24414j);
    }

    @Override // com.google.android.datatransport.runtime.i
    public Integer l() {
        return this.f24411g;
    }

    @Override // com.google.android.datatransport.runtime.i
    public String m() {
        return this.f24412h;
    }

    @Override // com.google.android.datatransport.runtime.i
    public String n() {
        return this.f24405a;
    }

    @Override // com.google.android.datatransport.runtime.i
    public long o() {
        return this.f24409e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f24405a + ", code=" + this.f24406b + ", encodedPayload=" + this.f24407c + ", eventMillis=" + this.f24408d + ", uptimeMillis=" + this.f24409e + ", autoMetadata=" + this.f24410f + ", productId=" + this.f24411g + ", pseudonymousId=" + this.f24412h + ", experimentIdsClear=" + Arrays.toString(this.f24413i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f24414j) + "}";
    }
}
