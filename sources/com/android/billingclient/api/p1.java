package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzaf;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzej;
import com.google.android.gms.internal.play_billing.zzhy;
import java.util.List;

/* loaded from: classes2.dex */
public final class p1 extends BroadcastReceiver {

    /* renamed from: a */
    private final v f19225a;

    /* renamed from: b */
    private final n0 f19226b;

    /* renamed from: c */
    private boolean f19227c;

    /* renamed from: d */
    final /* synthetic */ q1 f19228d;

    public /* synthetic */ p1(q1 q1Var, t0 t0Var, n0 n0Var, n1 n1Var) {
        this.f19228d = q1Var;
        this.f19225a = null;
        this.f19226b = n0Var;
    }

    public /* synthetic */ p1(q1 q1Var, v vVar, c cVar, n0 n0Var, n1 n1Var) {
        this.f19228d = q1Var;
        this.f19225a = vVar;
        this.f19226b = n0Var;
    }

    public static /* bridge */ /* synthetic */ t0 a(p1 p1Var) {
        p1Var.getClass();
        return null;
    }

    private final void d(Bundle bundle, n nVar, int i11) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            this.f19226b.a(m0.a(23, i11, nVar));
            return;
        }
        try {
            this.f19226b.a(zzhy.zzx(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzej.zza()));
        } catch (Throwable unused) {
            zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    public final synchronized void c(Context context, IntentFilter intentFilter, String str, IntentFilter intentFilter2) {
        Context context2;
        p1 p1Var;
        p1 p1Var2;
        try {
            if (this.f19227c) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                p1Var2 = this.f19228d.f19234b;
                context.registerReceiver(p1Var2, intentFilter, null, null, 2);
            } else {
                context2 = this.f19228d.f19233a;
                context2.getApplicationContext().getPackageName();
                p1Var = this.f19228d.f19234b;
                context.registerReceiver(p1Var, intentFilter);
            }
            this.f19227c = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        int i11 = 1;
        if (extras == null) {
            zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            n0 n0Var = this.f19226b;
            n nVar = p0.f19208j;
            n0Var.a(m0.a(11, 1, nVar));
            v vVar = this.f19225a;
            if (vVar != null) {
                vVar.a(nVar, null);
                return;
            }
            return;
        }
        n zze = zzb.zze(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        String string = extras.getString("INTENT_SOURCE");
        if (string == "LAUNCH_BILLING_FLOW" || (string != null && string.equals("LAUNCH_BILLING_FLOW"))) {
            i11 = 2;
        }
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List zzi = zzb.zzi(extras);
            if (zze.b() == 0) {
                this.f19226b.c(m0.b(i11));
            } else {
                d(extras, zze, i11);
            }
            this.f19225a.a(zze, zzi);
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            if (zze.b() != 0) {
                d(extras, zze, i11);
                this.f19225a.a(zze, zzaf.zzk());
                return;
            }
            zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
            n0 n0Var2 = this.f19226b;
            n nVar2 = p0.f19208j;
            n0Var2.a(m0.a(77, i11, nVar2));
            this.f19225a.a(nVar2, zzaf.zzk());
        }
    }
}
