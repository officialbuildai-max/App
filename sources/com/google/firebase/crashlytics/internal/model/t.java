package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes4.dex */
final class t extends CrashlyticsReport.e.d.a.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f31717a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31718b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31719c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f31720d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.a.c.AbstractC0435a {

        /* renamed from: a, reason: collision with root package name */
        private String f31721a;

        /* renamed from: b, reason: collision with root package name */
        private int f31722b;

        /* renamed from: c, reason: collision with root package name */
        private int f31723c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f31724d;

        /* renamed from: e, reason: collision with root package name */
        private byte f31725e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c.AbstractC0435a
        public CrashlyticsReport.e.d.a.c a() {
            String str;
            if (this.f31725e == 7 && (str = this.f31721a) != null) {
                return new t(str, this.f31722b, this.f31723c, this.f31724d);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f31721a == null) {
                sb2.append(" processName");
            }
            if ((this.f31725e & 1) == 0) {
                sb2.append(" pid");
            }
            if ((this.f31725e & 2) == 0) {
                sb2.append(" importance");
            }
            if ((this.f31725e & 4) == 0) {
                sb2.append(" defaultProcess");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c.AbstractC0435a
        public CrashlyticsReport.e.d.a.c.AbstractC0435a b(boolean z10) {
            this.f31724d = z10;
            this.f31725e = (byte) (this.f31725e | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c.AbstractC0435a
        public CrashlyticsReport.e.d.a.c.AbstractC0435a c(int i11) {
            this.f31723c = i11;
            this.f31725e = (byte) (this.f31725e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c.AbstractC0435a
        public CrashlyticsReport.e.d.a.c.AbstractC0435a d(int i11) {
            this.f31722b = i11;
            this.f31725e = (byte) (this.f31725e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c.AbstractC0435a
        public CrashlyticsReport.e.d.a.c.AbstractC0435a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f31721a = str;
            return this;
        }
    }

    private t(String str, int i11, int i12, boolean z10) {
        this.f31717a = str;
        this.f31718b = i11;
        this.f31719c = i12;
        this.f31720d = z10;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c
    public int b() {
        return this.f31719c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c
    public int c() {
        return this.f31718b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c
    public String d() {
        return this.f31717a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.c
    public boolean e() {
        return this.f31720d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.c)) {
            return false;
        }
        CrashlyticsReport.e.d.a.c cVar = (CrashlyticsReport.e.d.a.c) obj;
        return this.f31717a.equals(cVar.d()) && this.f31718b == cVar.c() && this.f31719c == cVar.b() && this.f31720d == cVar.e();
    }

    public int hashCode() {
        return ((((((this.f31717a.hashCode() ^ 1000003) * 1000003) ^ this.f31718b) * 1000003) ^ this.f31719c) * 1000003) ^ (this.f31720d ? 1231 : 1237);
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f31717a + ", pid=" + this.f31718b + ", importance=" + this.f31719c + ", defaultProcess=" + this.f31720d + "}";
    }
}
