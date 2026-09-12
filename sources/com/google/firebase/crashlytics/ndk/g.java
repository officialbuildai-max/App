package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.ndk.f;
import java.io.File;

/* loaded from: classes4.dex */
class g implements ob.h {

    /* renamed from: a, reason: collision with root package name */
    private final f f31859a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f31859a = fVar;
    }

    @Override // ob.h
    public File a() {
        return this.f31859a.f31848f;
    }

    @Override // ob.h
    public CrashlyticsReport.a b() {
        f.c cVar = this.f31859a.f31843a;
        if (cVar != null) {
            return cVar.f31858b;
        }
        return null;
    }

    @Override // ob.h
    public File c() {
        return this.f31859a.f31843a.f31857a;
    }

    @Override // ob.h
    public File d() {
        return this.f31859a.f31845c;
    }

    @Override // ob.h
    public File e() {
        return this.f31859a.f31847e;
    }

    @Override // ob.h
    public File f() {
        return this.f31859a.f31849g;
    }

    @Override // ob.h
    public File g() {
        return this.f31859a.f31846d;
    }
}
