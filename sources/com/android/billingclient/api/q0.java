package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzio;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziv;
import com.google.android.gms.internal.play_billing.zziz;

/* loaded from: classes2.dex */
final class q0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    private final zzio f19231a;

    /* renamed from: b, reason: collision with root package name */
    private final s0 f19232b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(Context context, zzio zzioVar) {
        this.f19232b = new s0(context);
        this.f19231a = zzioVar;
    }

    @Override // com.android.billingclient.api.n0
    public final void a(zzhy zzhyVar) {
        if (zzhyVar == null) {
            return;
        }
        try {
            zziu zzv = zziv.zzv();
            zzio zzioVar = this.f19231a;
            if (zzioVar != null) {
                zzv.zzk(zzioVar);
            }
            zzv.zzi(zzhyVar);
            this.f19232b.a((zziv) zzv.zzc());
        } catch (Throwable unused) {
            zzb.zzk("BillingLogger", "Unable to log.");
        }
    }

    @Override // com.android.billingclient.api.n0
    public final void b(zziz zzizVar) {
        if (zzizVar == null) {
            return;
        }
        try {
            zziu zzv = zziv.zzv();
            zzio zzioVar = this.f19231a;
            if (zzioVar != null) {
                zzv.zzk(zzioVar);
            }
            zzv.zzl(zzizVar);
            this.f19232b.a((zziv) zzv.zzc());
        } catch (Throwable unused) {
            zzb.zzk("BillingLogger", "Unable to log.");
        }
    }

    @Override // com.android.billingclient.api.n0
    public final void c(zzic zzicVar) {
        if (zzicVar == null) {
            return;
        }
        try {
            zziu zzv = zziv.zzv();
            zzio zzioVar = this.f19231a;
            if (zzioVar != null) {
                zzv.zzk(zzioVar);
            }
            zzv.zzj(zzicVar);
            this.f19232b.a((zziv) zzv.zzc());
        } catch (Throwable unused) {
            zzb.zzk("BillingLogger", "Unable to log.");
        }
    }
}
