package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zziz;
import com.google.android.gms.internal.play_billing.zzl;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Object f19133a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f19134b = false;

    /* renamed from: c, reason: collision with root package name */
    private j f19135c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ i f19136d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f0(i iVar, j jVar, e0 e0Var) {
        this.f19136d = iVar;
        this.f19135c = jVar;
    }

    private final void c(n nVar) {
        synchronized (this.f19133a) {
            try {
                j jVar = this.f19135c;
                if (jVar != null) {
                    jVar.a(nVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object a() {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.f0.a():java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        n0 n0Var;
        this.f19136d.f19143a = 0;
        this.f19136d.f19149g = null;
        n0Var = this.f19136d.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 6, nVar));
        c(nVar);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Handler F;
        Future K;
        n I;
        n0 n0Var;
        zzb.zzj("BillingClient", "Billing service connected.");
        this.f19136d.f19149g = zzl.zzr(iBinder);
        Callable callable = new Callable() { // from class: com.android.billingclient.api.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                f0.this.a();
                return null;
            }
        };
        Runnable runnable = new Runnable() { // from class: com.android.billingclient.api.zzam
            @Override // java.lang.Runnable
            public final void run() {
                f0.this.b();
            }
        };
        i iVar = this.f19136d;
        F = iVar.F();
        K = iVar.K(callable, 30000L, runnable, F);
        if (K == null) {
            i iVar2 = this.f19136d;
            I = iVar2.I();
            n0Var = iVar2.f19148f;
            n0Var.a(m0.a(25, 6, I));
            c(I);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        n0 n0Var;
        zzb.zzk("BillingClient", "Billing service disconnected.");
        n0Var = this.f19136d.f19148f;
        n0Var.b(zziz.zzw());
        this.f19136d.f19149g = null;
        this.f19136d.f19143a = 0;
        synchronized (this.f19133a) {
            try {
                j jVar = this.f19135c;
                if (jVar != null) {
                    jVar.b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
