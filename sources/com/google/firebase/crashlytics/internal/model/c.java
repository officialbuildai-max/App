package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes4.dex */
final class c extends CrashlyticsReport.a {

    /* renamed from: a, reason: collision with root package name */
    private final int f31539a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31540b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31541c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31542d;

    /* renamed from: e, reason: collision with root package name */
    private final long f31543e;

    /* renamed from: f, reason: collision with root package name */
    private final long f31544f;

    /* renamed from: g, reason: collision with root package name */
    private final long f31545g;

    /* renamed from: h, reason: collision with root package name */
    private final String f31546h;

    /* renamed from: i, reason: collision with root package name */
    private final List f31547i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.a.b {

        /* renamed from: a, reason: collision with root package name */
        private int f31548a;

        /* renamed from: b, reason: collision with root package name */
        private String f31549b;

        /* renamed from: c, reason: collision with root package name */
        private int f31550c;

        /* renamed from: d, reason: collision with root package name */
        private int f31551d;

        /* renamed from: e, reason: collision with root package name */
        private long f31552e;

        /* renamed from: f, reason: collision with root package name */
        private long f31553f;

        /* renamed from: g, reason: collision with root package name */
        private long f31554g;

        /* renamed from: h, reason: collision with root package name */
        private String f31555h;

        /* renamed from: i, reason: collision with root package name */
        private List f31556i;

        /* renamed from: j, reason: collision with root package name */
        private byte f31557j;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a a() {
            String str;
            if (this.f31557j == 63 && (str = this.f31549b) != null) {
                return new c(this.f31548a, str, this.f31550c, this.f31551d, this.f31552e, this.f31553f, this.f31554g, this.f31555h, this.f31556i);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f31557j & 1) == 0) {
                sb2.append(" pid");
            }
            if (this.f31549b == null) {
                sb2.append(" processName");
            }
            if ((this.f31557j & 2) == 0) {
                sb2.append(" reasonCode");
            }
            if ((this.f31557j & 4) == 0) {
                sb2.append(" importance");
            }
            if ((this.f31557j & 8) == 0) {
                sb2.append(" pss");
            }
            if ((this.f31557j & 16) == 0) {
                sb2.append(" rss");
            }
            if ((this.f31557j & 32) == 0) {
                sb2.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b b(List list) {
            this.f31556i = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b c(int i11) {
            this.f31551d = i11;
            this.f31557j = (byte) (this.f31557j | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b d(int i11) {
            this.f31548a = i11;
            this.f31557j = (byte) (this.f31557j | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f31549b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b f(long j11) {
            this.f31552e = j11;
            this.f31557j = (byte) (this.f31557j | 8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b g(int i11) {
            this.f31550c = i11;
            this.f31557j = (byte) (this.f31557j | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b h(long j11) {
            this.f31553f = j11;
            this.f31557j = (byte) (this.f31557j | 16);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b i(long j11) {
            this.f31554g = j11;
            this.f31557j = (byte) (this.f31557j | 32);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.b
        public CrashlyticsReport.a.b j(String str) {
            this.f31555h = str;
            return this;
        }
    }

    private c(int i11, String str, int i12, int i13, long j11, long j12, long j13, String str2, List list) {
        this.f31539a = i11;
        this.f31540b = str;
        this.f31541c = i12;
        this.f31542d = i13;
        this.f31543e = j11;
        this.f31544f = j12;
        this.f31545g = j13;
        this.f31546h = str2;
        this.f31547i = list;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public List b() {
        return this.f31547i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public int c() {
        return this.f31542d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public int d() {
        return this.f31539a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public String e() {
        return this.f31540b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.a)) {
            return false;
        }
        CrashlyticsReport.a aVar = (CrashlyticsReport.a) obj;
        if (this.f31539a == aVar.d() && this.f31540b.equals(aVar.e()) && this.f31541c == aVar.g() && this.f31542d == aVar.c() && this.f31543e == aVar.f() && this.f31544f == aVar.h() && this.f31545g == aVar.i() && ((str = this.f31546h) != null ? str.equals(aVar.j()) : aVar.j() == null)) {
            List list = this.f31547i;
            if (list == null) {
                if (aVar.b() == null) {
                    return true;
                }
            } else if (list.equals(aVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public long f() {
        return this.f31543e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public int g() {
        return this.f31541c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public long h() {
        return this.f31544f;
    }

    public int hashCode() {
        int hashCode = (((((((this.f31539a ^ 1000003) * 1000003) ^ this.f31540b.hashCode()) * 1000003) ^ this.f31541c) * 1000003) ^ this.f31542d) * 1000003;
        long j11 = this.f31543e;
        int i11 = (hashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f31544f;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        long j13 = this.f31545g;
        int i13 = (i12 ^ ((int) (j13 ^ (j13 >>> 32)))) * 1000003;
        String str = this.f31546h;
        int hashCode2 = (i13 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f31547i;
        return hashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public long i() {
        return this.f31545g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    public String j() {
        return this.f31546h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f31539a + ", processName=" + this.f31540b + ", reasonCode=" + this.f31541c + ", importance=" + this.f31542d + ", pss=" + this.f31543e + ", rss=" + this.f31544f + ", timestamp=" + this.f31545g + ", traceFile=" + this.f31546h + ", buildIdMappingForArch=" + this.f31547i + "}";
    }
}
