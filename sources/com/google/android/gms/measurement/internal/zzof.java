package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzof implements zzor {
    final /* synthetic */ zznv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzof(zznv zznvVar) {
        this.zza = zznvVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void zza(String str, String str2, Bundle bundle) {
        zzhy zzhyVar;
        zzhy zzhyVar2;
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzl().zzb(new zzoh(this, str, str2, bundle));
            return;
        }
        zzhyVar = this.zza.zzm;
        if (zzhyVar != null) {
            zzhyVar2 = this.zza.zzm;
            zzhyVar2.zzj().zzg().zza("AppId not known when logging event", str2);
        }
    }
}
