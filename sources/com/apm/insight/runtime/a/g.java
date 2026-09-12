package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes2.dex */
public final class g extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context, b bVar, d dVar) {
        super(CrashType.CUSTOM_JAVA, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a a11 = super.a(aVar);
        Header a12 = Header.a(this.f19850b);
        Header.a(a12);
        Header.b(a12);
        a12.c();
        a12.d();
        a12.e();
        a11.a(a12);
        return a11;
    }
}
