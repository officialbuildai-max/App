package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.r;
import java.util.List;

/* loaded from: classes3.dex */
final class k extends r {

    /* renamed from: a, reason: collision with root package name */
    private final long f24364a;

    /* renamed from: b, reason: collision with root package name */
    private final long f24365b;

    /* renamed from: c, reason: collision with root package name */
    private final ClientInfo f24366c;

    /* renamed from: d, reason: collision with root package name */
    private final Integer f24367d;

    /* renamed from: e, reason: collision with root package name */
    private final String f24368e;

    /* renamed from: f, reason: collision with root package name */
    private final List f24369f;

    /* renamed from: g, reason: collision with root package name */
    private final QosTier f24370g;

    /* loaded from: classes3.dex */
    static final class b extends r.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f24371a;

        /* renamed from: b, reason: collision with root package name */
        private Long f24372b;

        /* renamed from: c, reason: collision with root package name */
        private ClientInfo f24373c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f24374d;

        /* renamed from: e, reason: collision with root package name */
        private String f24375e;

        /* renamed from: f, reason: collision with root package name */
        private List f24376f;

        /* renamed from: g, reason: collision with root package name */
        private QosTier f24377g;

        @Override // com.google.android.datatransport.cct.internal.r.a
        public r a() {
            String str = "";
            if (this.f24371a == null) {
                str = " requestTimeMs";
            }
            if (this.f24372b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f24371a.longValue(), this.f24372b.longValue(), this.f24373c, this.f24374d, this.f24375e, this.f24376f, this.f24377g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.r.a
        public r.a b(ClientInfo clientInfo) {
            this.f24373c = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.r.a
        public r.a c(List list) {
            this.f24376f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.r.a
        r.a d(Integer num) {
            this.f24374d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.r.a
        r.a e(String str) {
            this.f24375e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.r.a
        public r.a f(QosTier qosTier) {
            this.f24377g = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.r.a
        public r.a g(long j11) {
            this.f24371a = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.r.a
        public r.a h(long j11) {
            this.f24372b = Long.valueOf(j11);
            return this;
        }
    }

    private k(long j11, long j12, ClientInfo clientInfo, Integer num, String str, List list, QosTier qosTier) {
        this.f24364a = j11;
        this.f24365b = j12;
        this.f24366c = clientInfo;
        this.f24367d = num;
        this.f24368e = str;
        this.f24369f = list;
        this.f24370g = qosTier;
    }

    @Override // com.google.android.datatransport.cct.internal.r
    public ClientInfo b() {
        return this.f24366c;
    }

    @Override // com.google.android.datatransport.cct.internal.r
    public List c() {
        return this.f24369f;
    }

    @Override // com.google.android.datatransport.cct.internal.r
    public Integer d() {
        return this.f24367d;
    }

    @Override // com.google.android.datatransport.cct.internal.r
    public String e() {
        return this.f24368e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f24364a == rVar.g() && this.f24365b == rVar.h() && ((clientInfo = this.f24366c) != null ? clientInfo.equals(rVar.b()) : rVar.b() == null) && ((num = this.f24367d) != null ? num.equals(rVar.d()) : rVar.d() == null) && ((str = this.f24368e) != null ? str.equals(rVar.e()) : rVar.e() == null) && ((list = this.f24369f) != null ? list.equals(rVar.c()) : rVar.c() == null)) {
            QosTier qosTier = this.f24370g;
            if (qosTier == null) {
                if (rVar.f() == null) {
                    return true;
                }
            } else if (qosTier.equals(rVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.r
    public QosTier f() {
        return this.f24370g;
    }

    @Override // com.google.android.datatransport.cct.internal.r
    public long g() {
        return this.f24364a;
    }

    @Override // com.google.android.datatransport.cct.internal.r
    public long h() {
        return this.f24365b;
    }

    public int hashCode() {
        long j11 = this.f24364a;
        long j12 = this.f24365b;
        int i11 = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        ClientInfo clientInfo = this.f24366c;
        int hashCode = (i11 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f24367d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f24368e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f24369f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f24370g;
        return hashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f24364a + ", requestUptimeMs=" + this.f24365b + ", clientInfo=" + this.f24366c + ", logSource=" + this.f24367d + ", logSourceName=" + this.f24368e + ", logEvents=" + this.f24369f + ", qosTier=" + this.f24370g + "}";
    }
}
