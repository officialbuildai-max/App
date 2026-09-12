package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.q;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class j extends q {

    /* renamed from: a, reason: collision with root package name */
    private final long f24346a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f24347b;

    /* renamed from: c, reason: collision with root package name */
    private final ComplianceData f24348c;

    /* renamed from: d, reason: collision with root package name */
    private final long f24349d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f24350e;

    /* renamed from: f, reason: collision with root package name */
    private final String f24351f;

    /* renamed from: g, reason: collision with root package name */
    private final long f24352g;

    /* renamed from: h, reason: collision with root package name */
    private final NetworkConnectionInfo f24353h;

    /* renamed from: i, reason: collision with root package name */
    private final n f24354i;

    /* loaded from: classes3.dex */
    static final class b extends q.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f24355a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f24356b;

        /* renamed from: c, reason: collision with root package name */
        private ComplianceData f24357c;

        /* renamed from: d, reason: collision with root package name */
        private Long f24358d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f24359e;

        /* renamed from: f, reason: collision with root package name */
        private String f24360f;

        /* renamed from: g, reason: collision with root package name */
        private Long f24361g;

        /* renamed from: h, reason: collision with root package name */
        private NetworkConnectionInfo f24362h;

        /* renamed from: i, reason: collision with root package name */
        private n f24363i;

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q a() {
            String str = "";
            if (this.f24355a == null) {
                str = " eventTimeMs";
            }
            if (this.f24358d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f24361g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new j(this.f24355a.longValue(), this.f24356b, this.f24357c, this.f24358d.longValue(), this.f24359e, this.f24360f, this.f24361g.longValue(), this.f24362h, this.f24363i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a b(ComplianceData complianceData) {
            this.f24357c = complianceData;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a c(Integer num) {
            this.f24356b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a d(long j11) {
            this.f24355a = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a e(long j11) {
            this.f24358d = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a f(n nVar) {
            this.f24363i = nVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a g(NetworkConnectionInfo networkConnectionInfo) {
            this.f24362h = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        q.a h(byte[] bArr) {
            this.f24359e = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        q.a i(String str) {
            this.f24360f = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a j(long j11) {
            this.f24361g = Long.valueOf(j11);
            return this;
        }
    }

    private j(long j11, Integer num, ComplianceData complianceData, long j12, byte[] bArr, String str, long j13, NetworkConnectionInfo networkConnectionInfo, n nVar) {
        this.f24346a = j11;
        this.f24347b = num;
        this.f24348c = complianceData;
        this.f24349d = j12;
        this.f24350e = bArr;
        this.f24351f = str;
        this.f24352g = j13;
        this.f24353h = networkConnectionInfo;
        this.f24354i = nVar;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public ComplianceData b() {
        return this.f24348c;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public Integer c() {
        return this.f24347b;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public long d() {
        return this.f24346a;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public long e() {
        return this.f24349d;
    }

    public boolean equals(Object obj) {
        Integer num;
        ComplianceData complianceData;
        String str;
        NetworkConnectionInfo networkConnectionInfo;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f24346a == qVar.d() && ((num = this.f24347b) != null ? num.equals(qVar.c()) : qVar.c() == null) && ((complianceData = this.f24348c) != null ? complianceData.equals(qVar.b()) : qVar.b() == null) && this.f24349d == qVar.e()) {
            if (Arrays.equals(this.f24350e, qVar instanceof j ? ((j) qVar).f24350e : qVar.h()) && ((str = this.f24351f) != null ? str.equals(qVar.i()) : qVar.i() == null) && this.f24352g == qVar.j() && ((networkConnectionInfo = this.f24353h) != null ? networkConnectionInfo.equals(qVar.g()) : qVar.g() == null)) {
                n nVar = this.f24354i;
                if (nVar == null) {
                    if (qVar.f() == null) {
                        return true;
                    }
                } else if (nVar.equals(qVar.f())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public n f() {
        return this.f24354i;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public NetworkConnectionInfo g() {
        return this.f24353h;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public byte[] h() {
        return this.f24350e;
    }

    public int hashCode() {
        long j11 = this.f24346a;
        int i11 = (((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f24347b;
        int hashCode = (i11 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        ComplianceData complianceData = this.f24348c;
        int hashCode2 = complianceData == null ? 0 : complianceData.hashCode();
        long j12 = this.f24349d;
        int hashCode3 = (((((hashCode ^ hashCode2) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f24350e)) * 1000003;
        String str = this.f24351f;
        int hashCode4 = str == null ? 0 : str.hashCode();
        long j13 = this.f24352g;
        int i12 = (((hashCode3 ^ hashCode4) * 1000003) ^ ((int) ((j13 >>> 32) ^ j13))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f24353h;
        int hashCode5 = (i12 ^ (networkConnectionInfo == null ? 0 : networkConnectionInfo.hashCode())) * 1000003;
        n nVar = this.f24354i;
        return hashCode5 ^ (nVar != null ? nVar.hashCode() : 0);
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public String i() {
        return this.f24351f;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public long j() {
        return this.f24352g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f24346a + ", eventCode=" + this.f24347b + ", complianceData=" + this.f24348c + ", eventUptimeMs=" + this.f24349d + ", sourceExtension=" + Arrays.toString(this.f24350e) + ", sourceExtensionJsonProto3=" + this.f24351f + ", timezoneOffsetSeconds=" + this.f24352g + ", networkConnectionInfo=" + this.f24353h + ", experimentIds=" + this.f24354i + "}";
    }
}
