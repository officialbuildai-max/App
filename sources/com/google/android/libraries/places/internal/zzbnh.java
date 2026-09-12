package com.google.android.libraries.places.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbnh extends zzbbk {
    final /* synthetic */ zzbnj zza;
    private final zzbnj zzb;
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbnh(zzbnj zzbnjVar, zzbnj zzbnjVar2) {
        this.zza = zzbnjVar;
        this.zzb = zzbnjVar2;
    }

    @Override // com.google.android.libraries.places.internal.zzbbk
    public final zzbbe zza(zzbbf zzbbfVar) {
        zzbbd zzbbdVar;
        if (this.zzc.compareAndSet(false, true)) {
            zzbbdVar = this.zza.zzg;
            zzbdw zzb = zzbbdVar.zzb();
            final zzbnj zzbnjVar = this.zzb;
            Objects.requireNonNull(zzbnjVar);
            zzb.zzc(new Runnable() { // from class: com.google.android.libraries.places.internal.zzbng
                @Override // java.lang.Runnable
                public final void run() {
                    zzbnj.this.zzd();
                }
            });
            zzb.zzb();
        }
        return zzbbe.zzc();
    }
}
