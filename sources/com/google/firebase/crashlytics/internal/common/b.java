package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b extends a0 {

    /* renamed from: a, reason: collision with root package name */
    private final CrashlyticsReport f31199a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31200b;

    /* renamed from: c, reason: collision with root package name */
    private final File f31201c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport == null) {
            throw new NullPointerException("Null report");
        }
        this.f31199a = crashlyticsReport;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f31200b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f31201c = file;
    }

    @Override // com.google.firebase.crashlytics.internal.common.a0
    public CrashlyticsReport b() {
        return this.f31199a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.a0
    public File c() {
        return this.f31201c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.a0
    public String d() {
        return this.f31200b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f31199a.equals(a0Var.b()) && this.f31200b.equals(a0Var.d()) && this.f31201c.equals(a0Var.c());
    }

    public int hashCode() {
        return ((((this.f31199a.hashCode() ^ 1000003) * 1000003) ^ this.f31200b.hashCode()) * 1000003) ^ this.f31201c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f31199a + ", sessionId=" + this.f31200b + ", reportFile=" + this.f31201c + "}";
    }
}
