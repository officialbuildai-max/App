package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes4.dex */
final class y extends CrashlyticsReport.e.d.f {

    /* renamed from: a, reason: collision with root package name */
    private final List f31754a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends CrashlyticsReport.e.d.f.a {

        /* renamed from: a, reason: collision with root package name */
        private List f31755a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.f.a
        public CrashlyticsReport.e.d.f a() {
            List list = this.f31755a;
            if (list != null) {
                return new y(list);
            }
            throw new IllegalStateException("Missing required properties: rolloutAssignments");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.f.a
        public CrashlyticsReport.e.d.f.a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null rolloutAssignments");
            }
            this.f31755a = list;
            return this;
        }
    }

    private y(List list) {
        this.f31754a = list;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.f
    public List b() {
        return this.f31754a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.e.d.f) {
            return this.f31754a.equals(((CrashlyticsReport.e.d.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f31754a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f31754a + "}";
    }
}
