package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbno extends zzbbk {
    final /* synthetic */ zzbnp zza;
    private final zzbbj zzb;
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbno(zzbnp zzbnpVar, zzbbj zzbbjVar) {
        this.zza = zzbnpVar;
        this.zzb = zzbbjVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbbk
    public final zzbbe zza(zzbbf zzbbfVar) {
        zzbbd zzbbdVar;
        if (this.zzc.compareAndSet(false, true)) {
            zzbbdVar = this.zza.zzf;
            zzbdw zzb = zzbbdVar.zzb();
            zzb.zzc(new zzbnn(this));
            zzb.zzb();
        }
        return zzbbe.zzc();
    }
}
