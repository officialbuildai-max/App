package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f19233a;

    /* renamed from: b, reason: collision with root package name */
    private final p1 f19234b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public q1(Context context, t0 t0Var, n0 n0Var) {
        this.f19233a = context;
        this.f19234b = new p1(this, null, n0Var, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q1(Context context, v vVar, c cVar, n0 n0Var) {
        this.f19233a = context;
        this.f19234b = new p1(this, vVar, cVar, n0Var, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final t0 c() {
        p1.a(this.f19234b);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final v d() {
        return p1.b(this.f19234b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(boolean z10) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        this.f19233a.getApplicationContext().getPackageName();
        intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f19234b.c(this.f19233a, intentFilter, null, null);
    }
}
