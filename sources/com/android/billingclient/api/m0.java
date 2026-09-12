package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzii;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class m0 {
    public static zzhy a(int i11, int i12, n nVar) {
        try {
            zzhx zzv = zzhy.zzv();
            zzie zzv2 = zzii.zzv();
            zzv2.zzk(nVar.b());
            zzv2.zzj(nVar.a());
            zzv2.zzl(i11);
            zzv.zzi(zzv2);
            zzv.zzk(i12);
            return (zzhy) zzv.zzc();
        } catch (Exception e11) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e11);
            return null;
        }
    }

    public static zzic b(int i11) {
        try {
            zzib zzv = zzic.zzv();
            zzv.zzj(i11);
            return (zzic) zzv.zzc();
        } catch (Exception e11) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e11);
            return null;
        }
    }
}
