package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeCrashCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, b bVar, d dVar) {
        super(CrashType.NATIVE, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final int a() {
        return NativeCrashCollector.a();
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(int i11, com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a a11 = super.a(i11, aVar);
        if (i11 == 0) {
            Header a12 = Header.a(this.f19850b);
            a12.c();
            a11.a(a12);
            com.apm.insight.a.a(a11, a12, this.f19849a);
        } else if (i11 == 1) {
            Header d11 = a11.d();
            d11.d();
            d11.e();
        } else if (i11 == 2) {
            Header.a(a11.d());
        }
        return a11;
    }

    @Override // com.apm.insight.runtime.a.c
    protected final boolean c() {
        return false;
    }
}
