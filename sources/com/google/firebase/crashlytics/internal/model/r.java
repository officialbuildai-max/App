package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes4.dex */
final class r extends CrashlyticsReport.e.d.a.b.AbstractC0431e {

    /* renamed from: a, reason: collision with root package name */
    private final String f31699a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31700b;

    /* renamed from: c, reason: collision with root package name */
    private final List f31701c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a {

        /* renamed from: a, reason: collision with root package name */
        private String f31702a;

        /* renamed from: b, reason: collision with root package name */
        private int f31703b;

        /* renamed from: c, reason: collision with root package name */
        private List f31704c;

        /* renamed from: d, reason: collision with root package name */
        private byte f31705d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e a() {
            String str;
            List list;
            if (this.f31705d == 1 && (str = this.f31702a) != null && (list = this.f31704c) != null) {
                return new r(str, this.f31703b, list);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31702a == null) {
                sb2.append(" name");
            }
            if ((1 & this.f31705d) == 0) {
                sb2.append(" importance");
            }
            if (this.f31704c == null) {
                sb2.append(" frames");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f31704c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a c(int i11) {
            this.f31703b = i11;
            this.f31705d = (byte) (this.f31705d | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a
        public CrashlyticsReport.e.d.a.b.AbstractC0431e.AbstractC0432a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f31702a = str;
            return this;
        }
    }

    private r(String str, int i11, List list) {
        this.f31699a = str;
        this.f31700b = i11;
        this.f31701c = list;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e
    public List b() {
        return this.f31701c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e
    public int c() {
        return this.f31700b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0431e
    public String d() {
        return this.f31699a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.AbstractC0431e)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.AbstractC0431e abstractC0431e = (CrashlyticsReport.e.d.a.b.AbstractC0431e) obj;
        return this.f31699a.equals(abstractC0431e.d()) && this.f31700b == abstractC0431e.c() && this.f31701c.equals(abstractC0431e.b());
    }

    public int hashCode() {
        return ((((this.f31699a.hashCode() ^ 1000003) * 1000003) ^ this.f31700b) * 1000003) ^ this.f31701c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f31699a + ", importance=" + this.f31700b + ", frames=" + this.f31701c + "}";
    }
}
