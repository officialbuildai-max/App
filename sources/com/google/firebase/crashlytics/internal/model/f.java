package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes4.dex */
final class f extends CrashlyticsReport.d {

    /* renamed from: a, reason: collision with root package name */
    private final List f31568a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31569b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.d.a {

        /* renamed from: a, reason: collision with root package name */
        private List f31570a;

        /* renamed from: b, reason: collision with root package name */
        private String f31571b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.a
        public CrashlyticsReport.d a() {
            List list = this.f31570a;
            if (list != null) {
                return new f(list, this.f31571b);
            }
            throw new IllegalStateException("Missing required properties: files");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.a
        public CrashlyticsReport.d.a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null files");
            }
            this.f31570a = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.a
        public CrashlyticsReport.d.a c(String str) {
            this.f31571b = str;
            return this;
        }
    }

    private f(List list, String str) {
        this.f31568a = list;
        this.f31569b = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d
    public List b() {
        return this.f31568a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d
    public String c() {
        return this.f31569b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d)) {
            return false;
        }
        CrashlyticsReport.d dVar = (CrashlyticsReport.d) obj;
        if (this.f31568a.equals(dVar.b())) {
            String str = this.f31569b;
            if (str == null) {
                if (dVar.c() == null) {
                    return true;
                }
            } else if (str.equals(dVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f31568a.hashCode() ^ 1000003) * 1000003;
        String str = this.f31569b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f31568a + ", orgId=" + this.f31569b + "}";
    }
}
