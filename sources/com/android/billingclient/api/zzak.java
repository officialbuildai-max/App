package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.n;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzih;
import com.google.android.gms.internal.play_billing.zzii;

/* loaded from: classes2.dex */
final class zzak extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f19293a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i11, Bundle bundle) {
        n0 n0Var;
        n0 n0Var2;
        zzhy zzhyVar;
        n.a c11 = n.c();
        c11.c(i11);
        if (i11 != 0) {
            if (bundle == null) {
                n0Var = this.f19293a.f19148f;
                n0Var.a(m0.a(73, 16, p0.f19208j));
                throw null;
            }
            c11.b(zzb.zzg(bundle, "BillingClient"));
            int i12 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            n0Var2 = this.f19293a.f19148f;
            int zza = i12 != 0 ? zzih.zza(i12) : 23;
            n a11 = c11.a();
            String string = bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS");
            try {
                zzie zzv = zzii.zzv();
                zzv.zzk(a11.b());
                zzv.zzj(a11.a());
                zzv.zzl(zza);
                if (string != null) {
                    zzv.zzi(string);
                }
                zzhx zzv2 = zzhy.zzv();
                zzv2.zzi(zzv);
                zzv2.zzk(16);
                zzhyVar = (zzhy) zzv2.zzc();
            } catch (Exception e11) {
                zzb.zzl("BillingLogger", "Unable to create logging payload", e11);
                zzhyVar = null;
            }
            n0Var2.a(zzhyVar);
        }
        c11.a();
        throw null;
    }
}
