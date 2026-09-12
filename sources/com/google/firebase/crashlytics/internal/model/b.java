package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class b extends CrashlyticsReport {

    /* renamed from: b, reason: collision with root package name */
    private final String f31514b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31515c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31516d;

    /* renamed from: e, reason: collision with root package name */
    private final String f31517e;

    /* renamed from: f, reason: collision with root package name */
    private final String f31518f;

    /* renamed from: g, reason: collision with root package name */
    private final String f31519g;

    /* renamed from: h, reason: collision with root package name */
    private final String f31520h;

    /* renamed from: i, reason: collision with root package name */
    private final String f31521i;

    /* renamed from: j, reason: collision with root package name */
    private final String f31522j;

    /* renamed from: k, reason: collision with root package name */
    private final CrashlyticsReport.e f31523k;

    /* renamed from: l, reason: collision with root package name */
    private final CrashlyticsReport.d f31524l;

    /* renamed from: m, reason: collision with root package name */
    private final CrashlyticsReport.a f31525m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.crashlytics.internal.model.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0440b extends CrashlyticsReport.b {

        /* renamed from: a, reason: collision with root package name */
        private String f31526a;

        /* renamed from: b, reason: collision with root package name */
        private String f31527b;

        /* renamed from: c, reason: collision with root package name */
        private int f31528c;

        /* renamed from: d, reason: collision with root package name */
        private String f31529d;

        /* renamed from: e, reason: collision with root package name */
        private String f31530e;

        /* renamed from: f, reason: collision with root package name */
        private String f31531f;

        /* renamed from: g, reason: collision with root package name */
        private String f31532g;

        /* renamed from: h, reason: collision with root package name */
        private String f31533h;

        /* renamed from: i, reason: collision with root package name */
        private String f31534i;

        /* renamed from: j, reason: collision with root package name */
        private CrashlyticsReport.e f31535j;

        /* renamed from: k, reason: collision with root package name */
        private CrashlyticsReport.d f31536k;

        /* renamed from: l, reason: collision with root package name */
        private CrashlyticsReport.a f31537l;

        /* renamed from: m, reason: collision with root package name */
        private byte f31538m;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0440b() {
        }

        private C0440b(CrashlyticsReport crashlyticsReport) {
            this.f31526a = crashlyticsReport.m();
            this.f31527b = crashlyticsReport.i();
            this.f31528c = crashlyticsReport.l();
            this.f31529d = crashlyticsReport.j();
            this.f31530e = crashlyticsReport.h();
            this.f31531f = crashlyticsReport.g();
            this.f31532g = crashlyticsReport.d();
            this.f31533h = crashlyticsReport.e();
            this.f31534i = crashlyticsReport.f();
            this.f31535j = crashlyticsReport.n();
            this.f31536k = crashlyticsReport.k();
            this.f31537l = crashlyticsReport.c();
            this.f31538m = (byte) 1;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport a() {
            if (this.f31538m == 1 && this.f31526a != null && this.f31527b != null && this.f31529d != null && this.f31533h != null && this.f31534i != null) {
                return new b(this.f31526a, this.f31527b, this.f31528c, this.f31529d, this.f31530e, this.f31531f, this.f31532g, this.f31533h, this.f31534i, this.f31535j, this.f31536k, this.f31537l);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31526a == null) {
                sb2.append(" sdkVersion");
            }
            if (this.f31527b == null) {
                sb2.append(" gmpAppId");
            }
            if ((1 & this.f31538m) == 0) {
                sb2.append(" platform");
            }
            if (this.f31529d == null) {
                sb2.append(" installationUuid");
            }
            if (this.f31533h == null) {
                sb2.append(" buildVersion");
            }
            if (this.f31534i == null) {
                sb2.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b b(CrashlyticsReport.a aVar) {
            this.f31537l = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b c(String str) {
            this.f31532g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f31533h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f31534i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b f(String str) {
            this.f31531f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b g(String str) {
            this.f31530e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f31527b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f31529d = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b j(CrashlyticsReport.d dVar) {
            this.f31536k = dVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b k(int i11) {
            this.f31528c = i11;
            this.f31538m = (byte) (this.f31538m | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b l(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f31526a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b m(CrashlyticsReport.e eVar) {
            this.f31535j = eVar;
            return this;
        }
    }

    private b(String str, String str2, int i11, String str3, String str4, String str5, String str6, String str7, String str8, CrashlyticsReport.e eVar, CrashlyticsReport.d dVar, CrashlyticsReport.a aVar) {
        this.f31514b = str;
        this.f31515c = str2;
        this.f31516d = i11;
        this.f31517e = str3;
        this.f31518f = str4;
        this.f31519g = str5;
        this.f31520h = str6;
        this.f31521i = str7;
        this.f31522j = str8;
        this.f31523k = eVar;
        this.f31524l = dVar;
        this.f31525m = aVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.a c() {
        return this.f31525m;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String d() {
        return this.f31520h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String e() {
        return this.f31521i;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        CrashlyticsReport.e eVar;
        CrashlyticsReport.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.f31514b.equals(crashlyticsReport.m()) && this.f31515c.equals(crashlyticsReport.i()) && this.f31516d == crashlyticsReport.l() && this.f31517e.equals(crashlyticsReport.j()) && ((str = this.f31518f) != null ? str.equals(crashlyticsReport.h()) : crashlyticsReport.h() == null) && ((str2 = this.f31519g) != null ? str2.equals(crashlyticsReport.g()) : crashlyticsReport.g() == null) && ((str3 = this.f31520h) != null ? str3.equals(crashlyticsReport.d()) : crashlyticsReport.d() == null) && this.f31521i.equals(crashlyticsReport.e()) && this.f31522j.equals(crashlyticsReport.f()) && ((eVar = this.f31523k) != null ? eVar.equals(crashlyticsReport.n()) : crashlyticsReport.n() == null) && ((dVar = this.f31524l) != null ? dVar.equals(crashlyticsReport.k()) : crashlyticsReport.k() == null)) {
            CrashlyticsReport.a aVar = this.f31525m;
            if (aVar == null) {
                if (crashlyticsReport.c() == null) {
                    return true;
                }
            } else if (aVar.equals(crashlyticsReport.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String f() {
        return this.f31522j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String g() {
        return this.f31519g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String h() {
        return this.f31518f;
    }

    public int hashCode() {
        int hashCode = (((((((this.f31514b.hashCode() ^ 1000003) * 1000003) ^ this.f31515c.hashCode()) * 1000003) ^ this.f31516d) * 1000003) ^ this.f31517e.hashCode()) * 1000003;
        String str = this.f31518f;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f31519g;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f31520h;
        int hashCode4 = (((((hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f31521i.hashCode()) * 1000003) ^ this.f31522j.hashCode()) * 1000003;
        CrashlyticsReport.e eVar = this.f31523k;
        int hashCode5 = (hashCode4 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        CrashlyticsReport.d dVar = this.f31524l;
        int hashCode6 = (hashCode5 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        CrashlyticsReport.a aVar = this.f31525m;
        return hashCode6 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String i() {
        return this.f31515c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String j() {
        return this.f31517e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.d k() {
        return this.f31524l;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public int l() {
        return this.f31516d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String m() {
        return this.f31514b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.e n() {
        return this.f31523k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    protected CrashlyticsReport.b o() {
        return new C0440b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f31514b + ", gmpAppId=" + this.f31515c + ", platform=" + this.f31516d + ", installationUuid=" + this.f31517e + ", firebaseInstallationId=" + this.f31518f + ", firebaseAuthenticationToken=" + this.f31519g + ", appQualitySessionId=" + this.f31520h + ", buildVersion=" + this.f31521i + ", displayVersion=" + this.f31522j + ", session=" + this.f31523k + ", ndkPayload=" + this.f31524l + ", appExitInfo=" + this.f31525m + "}";
    }
}
