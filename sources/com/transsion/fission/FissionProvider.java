package com.transsion.fission;

import android.content.Context;
import com.transsion.fissionapi.IFissionProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes.dex */
public final class FissionProvider implements IFissionProvider {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f44192a = LazyKt.b(new Function0() { // from class: com.transsion.fission.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xk.b m11;
            m11 = FissionProvider.m();
            return m11;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final xk.b l() {
        return (xk.b) this.f44192a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xk.b m() {
        return (xk.b) zg.c.f79537e.a().h(xk.b.class);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void a(String inviteCode) {
        Intrinsics.h(inviteCode, "inviteCode");
        l.f44205a.c(inviteCode);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void b(boolean z10) {
        defpackage.c.f17040a.b().putBoolean("kv_task_is_exists", z10);
        a.C0856a.g(lg.a.f68962a, "updatePalmPayTask() ---> isExists = " + z10, false, 2, null);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void c(boolean z10) {
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public String d() {
        return k.f44199a.c();
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void e(Context context) {
        Intrinsics.h(context, "context");
        new zk.b(context).show();
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public boolean enable() {
        FissionConfig d11 = k.f44199a.d();
        String htmlUrl = d11 != null ? d11.getHtmlUrl() : null;
        return !(htmlUrl == null || htmlUrl.length() == 0);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void f(int i11) {
        if (defpackage.c.f17040a.b().getBoolean("kv_task_is_exists", false)) {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new FissionProvider$finishPalmPayTask$1(i11, this, null), 3, null);
        }
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public boolean g() {
        defpackage.c cVar = defpackage.c.f17040a;
        return cVar.b().getBoolean("kv_task_is_exists", false) && !cVar.b().getBoolean("kv_task_is_finished", false);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public String h() {
        return l.f44205a.a();
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void i(boolean z10) {
    }
}
