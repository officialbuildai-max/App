package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, b bVar, d dVar) {
        super(CrashType.LAUNCH, context, bVar, dVar);
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
            try {
                a11.d().f().put("launch_did", com.apm.insight.i.a.a(this.f19850b));
            } catch (Throwable unused) {
            }
        } else if (i11 == 5) {
            Header.b(a11.d());
        }
        return a11;
    }
}
