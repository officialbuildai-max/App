package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes4.dex */
final class p extends CrashlyticsReport.e.d.a.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f31681a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31682b;

    /* renamed from: c, reason: collision with root package name */
    private final List f31683c;

    /* renamed from: d, reason: collision with root package name */
    private final CrashlyticsReport.e.d.a.b.c f31684d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31685e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.a.b.c.AbstractC0428a {

        /* renamed from: a, reason: collision with root package name */
        private String f31686a;

        /* renamed from: b, reason: collision with root package name */
        private String f31687b;

        /* renamed from: c, reason: collision with root package name */
        private List f31688c;

        /* renamed from: d, reason: collision with root package name */
        private CrashlyticsReport.e.d.a.b.c f31689d;

        /* renamed from: e, reason: collision with root package name */
        private int f31690e;

        /* renamed from: f, reason: collision with root package name */
        private byte f31691f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0428a
        public CrashlyticsReport.e.d.a.b.c a() {
            String str;
            List list;
            if (this.f31691f == 1 && (str = this.f31686a) != null && (list = this.f31688c) != null) {
                return new p(str, this.f31687b, list, this.f31689d, this.f31690e);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31686a == null) {
                sb2.append(" type");
            }
            if (this.f31688c == null) {
                sb2.append(" frames");
            }
            if ((1 & this.f31691f) == 0) {
                sb2.append(" overflowCount");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0428a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0428a b(CrashlyticsReport.e.d.a.b.c cVar) {
            this.f31689d = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0428a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0428a c(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f31688c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0428a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0428a d(int i11) {
            this.f31690e = i11;
            this.f31691f = (byte) (this.f31691f | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0428a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0428a e(String str) {
            this.f31687b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0428a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0428a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f31686a = str;
            return this;
        }
    }

    private p(String str, String str2, List list, CrashlyticsReport.e.d.a.b.c cVar, int i11) {
        this.f31681a = str;
        this.f31682b = str2;
        this.f31683c = list;
        this.f31684d = cVar;
        this.f31685e = i11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    public CrashlyticsReport.e.d.a.b.c b() {
        return this.f31684d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    public List c() {
        return this.f31683c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    public int d() {
        return this.f31685e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    public String e() {
        return this.f31682b;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.c)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.c cVar2 = (CrashlyticsReport.e.d.a.b.c) obj;
        return this.f31681a.equals(cVar2.f()) && ((str = this.f31682b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f31683c.equals(cVar2.c()) && ((cVar = this.f31684d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f31685e == cVar2.d();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    public String f() {
        return this.f31681a;
    }

    public int hashCode() {
        int hashCode = (this.f31681a.hashCode() ^ 1000003) * 1000003;
        String str = this.f31682b;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f31683c.hashCode()) * 1000003;
        CrashlyticsReport.e.d.a.b.c cVar = this.f31684d;
        return ((hashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f31685e;
    }

    public String toString() {
        return "Exception{type=" + this.f31681a + ", reason=" + this.f31682b + ", frames=" + this.f31683c + ", causedBy=" + this.f31684d + ", overflowCount=" + this.f31685e + "}";
    }
}
