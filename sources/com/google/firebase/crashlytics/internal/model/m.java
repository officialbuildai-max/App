package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes4.dex */
final class m extends CrashlyticsReport.e.d.a {

    /* renamed from: a, reason: collision with root package name */
    private final CrashlyticsReport.e.d.a.b f31647a;

    /* renamed from: b, reason: collision with root package name */
    private final List f31648b;

    /* renamed from: c, reason: collision with root package name */
    private final List f31649c;

    /* renamed from: d, reason: collision with root package name */
    private final Boolean f31650d;

    /* renamed from: e, reason: collision with root package name */
    private final CrashlyticsReport.e.d.a.c f31651e;

    /* renamed from: f, reason: collision with root package name */
    private final List f31652f;

    /* renamed from: g, reason: collision with root package name */
    private final int f31653g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.a.AbstractC0424a {

        /* renamed from: a, reason: collision with root package name */
        private CrashlyticsReport.e.d.a.b f31654a;

        /* renamed from: b, reason: collision with root package name */
        private List f31655b;

        /* renamed from: c, reason: collision with root package name */
        private List f31656c;

        /* renamed from: d, reason: collision with root package name */
        private Boolean f31657d;

        /* renamed from: e, reason: collision with root package name */
        private CrashlyticsReport.e.d.a.c f31658e;

        /* renamed from: f, reason: collision with root package name */
        private List f31659f;

        /* renamed from: g, reason: collision with root package name */
        private int f31660g;

        /* renamed from: h, reason: collision with root package name */
        private byte f31661h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(CrashlyticsReport.e.d.a aVar) {
            this.f31654a = aVar.f();
            this.f31655b = aVar.e();
            this.f31656c = aVar.g();
            this.f31657d = aVar.c();
            this.f31658e = aVar.d();
            this.f31659f = aVar.b();
            this.f31660g = aVar.h();
            this.f31661h = (byte) 1;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0424a
        public CrashlyticsReport.e.d.a a() {
            CrashlyticsReport.e.d.a.b bVar;
            if (this.f31661h == 1 && (bVar = this.f31654a) != null) {
                return new m(bVar, this.f31655b, this.f31656c, this.f31657d, this.f31658e, this.f31659f, this.f31660g);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31654a == null) {
                sb2.append(" execution");
            }
            if ((1 & this.f31661h) == 0) {
                sb2.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0424a
        public CrashlyticsReport.e.d.a.AbstractC0424a b(List list) {
            this.f31659f = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0424a
        public CrashlyticsReport.e.d.a.AbstractC0424a c(Boolean bool) {
            this.f31657d = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0424a
        public CrashlyticsReport.e.d.a.AbstractC0424a d(CrashlyticsReport.e.d.a.c cVar) {
            this.f31658e = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0424a
        public CrashlyticsReport.e.d.a.AbstractC0424a e(List list) {
            this.f31655b = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0424a
        public CrashlyticsReport.e.d.a.AbstractC0424a f(CrashlyticsReport.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.f31654a = bVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0424a
        public CrashlyticsReport.e.d.a.AbstractC0424a g(List list) {
            this.f31656c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0424a
        public CrashlyticsReport.e.d.a.AbstractC0424a h(int i11) {
            this.f31660g = i11;
            this.f31661h = (byte) (this.f31661h | 1);
            return this;
        }
    }

    private m(CrashlyticsReport.e.d.a.b bVar, List list, List list2, Boolean bool, CrashlyticsReport.e.d.a.c cVar, List list3, int i11) {
        this.f31647a = bVar;
        this.f31648b = list;
        this.f31649c = list2;
        this.f31650d = bool;
        this.f31651e = cVar;
        this.f31652f = list3;
        this.f31653g = i11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public List b() {
        return this.f31652f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public Boolean c() {
        return this.f31650d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public CrashlyticsReport.e.d.a.c d() {
        return this.f31651e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public List e() {
        return this.f31648b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        Boolean bool;
        CrashlyticsReport.e.d.a.c cVar;
        List list3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a)) {
            return false;
        }
        CrashlyticsReport.e.d.a aVar = (CrashlyticsReport.e.d.a) obj;
        return this.f31647a.equals(aVar.f()) && ((list = this.f31648b) != null ? list.equals(aVar.e()) : aVar.e() == null) && ((list2 = this.f31649c) != null ? list2.equals(aVar.g()) : aVar.g() == null) && ((bool = this.f31650d) != null ? bool.equals(aVar.c()) : aVar.c() == null) && ((cVar = this.f31651e) != null ? cVar.equals(aVar.d()) : aVar.d() == null) && ((list3 = this.f31652f) != null ? list3.equals(aVar.b()) : aVar.b() == null) && this.f31653g == aVar.h();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public CrashlyticsReport.e.d.a.b f() {
        return this.f31647a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public List g() {
        return this.f31649c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public int h() {
        return this.f31653g;
    }

    public int hashCode() {
        int hashCode = (this.f31647a.hashCode() ^ 1000003) * 1000003;
        List list = this.f31648b;
        int hashCode2 = (hashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f31649c;
        int hashCode3 = (hashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f31650d;
        int hashCode4 = (hashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        CrashlyticsReport.e.d.a.c cVar = this.f31651e;
        int hashCode5 = (hashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List list3 = this.f31652f;
        return ((hashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f31653g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public CrashlyticsReport.e.d.a.AbstractC0424a i() {
        return new b(this);
    }

    public String toString() {
        return "Application{execution=" + this.f31647a + ", customAttributes=" + this.f31648b + ", internalKeys=" + this.f31649c + ", background=" + this.f31650d + ", currentProcessDetails=" + this.f31651e + ", appProcessDetails=" + this.f31652f + ", uiOrientation=" + this.f31653g + "}";
    }
}
