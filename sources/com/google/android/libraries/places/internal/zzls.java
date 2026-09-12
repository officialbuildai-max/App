package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* loaded from: classes4.dex */
public final class zzls implements zzlr {
    private final zzkg zza;
    private final zzkb zzb;

    public zzls(zzkg zzkgVar, zzkb zzkbVar) {
        this.zza = zzkgVar;
        this.zzb = zzkbVar;
    }

    @Override // com.google.android.libraries.places.internal.zzlr
    public final void zza(zzlq zzlqVar) {
        zzafs zza = zzafv.zza();
        zza.zzg(zzlqVar.zzz());
        zza.zzd(zzlqVar.zzx());
        zza.zze(zzlqVar.zzy());
        zza.zzj(zzlqVar.zzd());
        zza.zzc(zzlqVar.zzb());
        zza.zzb(zzlqVar.zza());
        zza.zzk(zzlqVar.zze());
        zza.zzh(zzlqVar.zzk().length());
        zza.zzl(zzlqVar.zzg());
        zza.zzf(zzlqVar.zzc());
        zza.zzi(zzlqVar.zzA());
        zza.zza(zzlqVar.zzf());
        if (zzlqVar.zzi() == zzkr.FRAGMENT) {
            zza.zzn(2);
        } else if (zzlqVar.zzi() == zzkr.INTENT) {
            zza.zzn(3);
        } else {
            zza.zzn(1);
        }
        if (zzlqVar.zzj() == AutocompleteActivityMode.FULLSCREEN) {
            zza.zzm(2);
        } else if (zzlqVar.zzj() == AutocompleteActivityMode.OVERLAY) {
            zza.zzm(1);
        }
        zzafv zzafvVar = (zzafv) zza.zzt();
        zzagb zzb = zzkh.zzb(this.zzb, 2, 2);
        zzb.zzn(10);
        zzb.zzc(zzafvVar);
        this.zza.zza(zzkh.zza((zzagi) zzb.zzt()));
    }
}
