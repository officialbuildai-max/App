package com.google.android.gms.measurement.internal;

import java.util.List;

/* loaded from: classes4.dex */
final class zzhr implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzhl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhr(zzhl zzhlVar) {
        this.zza = zzhlVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z10, boolean z11) {
        int i11 = zzht.zza[zzsVar.ordinal()];
        zzgq zzo = i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? this.zza.zzj().zzo() : this.zza.zzj().zzp() : z10 ? this.zza.zzj().zzw() : !z11 ? this.zza.zzj().zzv() : this.zza.zzj().zzu() : z10 ? this.zza.zzj().zzn() : !z11 ? this.zza.zzj().zzm() : this.zza.zzj().zzg() : this.zza.zzj().zzc();
        int size = list.size();
        if (size == 1) {
            zzo.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzo.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzo.zza(str);
        } else {
            zzo.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
