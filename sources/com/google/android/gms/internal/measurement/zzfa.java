package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzfa extends zzdy.zza {
    private final /* synthetic */ zzdk zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzdy zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfa(zzdy zzdyVar, zzdk zzdkVar, int i11) {
        super(zzdyVar);
        this.zzc = zzdkVar;
        this.zzd = i11;
        this.zze = zzdyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdy.zza
    final void zza() throws RemoteException {
        zzdj zzdjVar;
        zzdjVar = this.zze.zzj;
        ((zzdj) Preconditions.checkNotNull(zzdjVar)).getTestFlag(this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzdy.zza
    protected final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
