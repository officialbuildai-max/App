package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes4.dex */
final class n extends CrashlyticsReport.e.d.a.b {

    /* renamed from: a, reason: collision with root package name */
    private final List f31662a;

    /* renamed from: b, reason: collision with root package name */
    private final CrashlyticsReport.e.d.a.b.c f31663b;

    /* renamed from: c, reason: collision with root package name */
    private final CrashlyticsReport.a f31664c;

    /* renamed from: d, reason: collision with root package name */
    private final CrashlyticsReport.e.d.a.b.AbstractC0429d f31665d;

    /* renamed from: e, reason: collision with root package name */
    private final List f31666e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0427b {

        /* renamed from: a, reason: collision with root package name */
        private List f31667a;

        /* renamed from: b, reason: collision with root package name */
        private CrashlyticsReport.e.d.a.b.c f31668b;

        /* renamed from: c, reason: collision with root package name */
        private CrashlyticsReport.a f31669c;

        /* renamed from: d, reason: collision with root package name */
        private CrashlyticsReport.e.d.a.b.AbstractC0429d f31670d;

        /* renamed from: e, reason: collision with root package name */
        private List f31671e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0427b
        public CrashlyticsReport.e.d.a.b a() {
            List list;
            CrashlyticsReport.e.d.a.b.AbstractC0429d abstractC0429d = this.f31670d;
            if (abstractC0429d != null && (list = this.f31671e) != null) {
                return new n(this.f31667a, this.f31668b, this.f31669c, abstractC0429d, list);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31670d == null) {
                sb2.append(" signal");
            }
            if (this.f31671e == null) {
                sb2.append(" binaries");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0427b
        public CrashlyticsReport.e.d.a.b.AbstractC0427b b(CrashlyticsReport.a aVar) {
            this.f31669c = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0427b
        public CrashlyticsReport.e.d.a.b.AbstractC0427b c(List list) {
            if (list == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f31671e = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0427b
        public CrashlyticsReport.e.d.a.b.AbstractC0427b d(CrashlyticsReport.e.d.a.b.c cVar) {
            this.f31668b = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0427b
        public CrashlyticsReport.e.d.a.b.AbstractC0427b e(CrashlyticsReport.e.d.a.b.AbstractC0429d abstractC0429d) {
            if (abstractC0429d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f31670d = abstractC0429d;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0427b
        public CrashlyticsReport.e.d.a.b.AbstractC0427b f(List list) {
            this.f31667a = list;
            return this;
        }
    }

    private n(List list, CrashlyticsReport.e.d.a.b.c cVar, CrashlyticsReport.a aVar, CrashlyticsReport.e.d.a.b.AbstractC0429d abstractC0429d, List list2) {
        this.f31662a = list;
        this.f31663b = cVar;
        this.f31664c = aVar;
        this.f31665d = abstractC0429d;
        this.f31666e = list2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    public CrashlyticsReport.a b() {
        return this.f31664c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    public List c() {
        return this.f31666e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    public CrashlyticsReport.e.d.a.b.c d() {
        return this.f31663b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    public CrashlyticsReport.e.d.a.b.AbstractC0429d e() {
        return this.f31665d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b bVar = (CrashlyticsReport.e.d.a.b) obj;
        List list = this.f31662a;
        if (list != null ? list.equals(bVar.f()) : bVar.f() == null) {
            CrashlyticsReport.e.d.a.b.c cVar = this.f31663b;
            if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                CrashlyticsReport.a aVar = this.f31664c;
                if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                    if (this.f31665d.equals(bVar.e()) && this.f31666e.equals(bVar.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    public List f() {
        return this.f31662a;
    }

    public int hashCode() {
        List list = this.f31662a;
        int hashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        CrashlyticsReport.e.d.a.b.c cVar = this.f31663b;
        int hashCode2 = (hashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        CrashlyticsReport.a aVar = this.f31664c;
        return ((((hashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.f31665d.hashCode()) * 1000003) ^ this.f31666e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f31662a + ", exception=" + this.f31663b + ", appExitInfo=" + this.f31664c + ", signal=" + this.f31665d + ", binaries=" + this.f31666e + "}";
    }
}
