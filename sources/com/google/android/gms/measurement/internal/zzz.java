package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzz extends zzaa {
    private zzfo.zze zzg;
    private final /* synthetic */ zzt zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(zzt zztVar, String str, int i11, zzfo.zze zzeVar) {
        super(str, i11);
        this.zzh = zztVar;
        this.zzg = zzeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final int zza() {
        return this.zzg.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zza(Long l11, Long l12, zzfy.zzo zzoVar, boolean z10) {
        Object[] objArr = com.google.android.gms.internal.measurement.zzoe.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbn);
        boolean zzf = this.zzg.zzf();
        boolean zzg = this.zzg.zzg();
        boolean zzh = this.zzg.zzh();
        Object[] objArr2 = zzf || zzg || zzh;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z10 && objArr2 != true) {
            this.zzh.zzj().zzp().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zzi() ? Integer.valueOf(this.zzg.zza()) : null);
            return true;
        }
        zzfo.zzc zzb = this.zzg.zzb();
        boolean zzf2 = zzb.zzf();
        if (zzoVar.zzk()) {
            if (zzb.zzh()) {
                bool = zzaa.zza(zzaa.zza(zzoVar.zzc(), zzb.zzc()), zzf2);
            } else {
                this.zzh.zzj().zzu().zza("No number filter for long property. property", this.zzh.zzi().zzc(zzoVar.zzg()));
            }
        } else if (zzoVar.zzi()) {
            if (zzb.zzh()) {
                bool = zzaa.zza(zzaa.zza(zzoVar.zza(), zzb.zzc()), zzf2);
            } else {
                this.zzh.zzj().zzu().zza("No number filter for double property. property", this.zzh.zzi().zzc(zzoVar.zzg()));
            }
        } else if (!zzoVar.zzm()) {
            this.zzh.zzj().zzu().zza("User property has no value, property", this.zzh.zzi().zzc(zzoVar.zzg()));
        } else if (zzb.zzj()) {
            bool = zzaa.zza(zzaa.zza(zzoVar.zzh(), zzb.zzd(), this.zzh.zzj()), zzf2);
        } else if (!zzb.zzh()) {
            this.zzh.zzj().zzu().zza("No string or number filter defined. property", this.zzh.zzi().zzc(zzoVar.zzg()));
        } else if (zzoo.zzb(zzoVar.zzh())) {
            bool = zzaa.zza(zzaa.zza(zzoVar.zzh(), zzb.zzc()), zzf2);
        } else {
            this.zzh.zzj().zzu().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzi().zzc(zzoVar.zzg()), zzoVar.zzh());
        }
        this.zzh.zzj().zzp().zza("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.zzc = Boolean.TRUE;
        if (zzh && !bool.booleanValue()) {
            return true;
        }
        if (!z10 || this.zzg.zzf()) {
            this.zzd = bool;
        }
        if (bool.booleanValue() && objArr2 != false && zzoVar.zzl()) {
            long zzd = zzoVar.zzd();
            if (l11 != null) {
                zzd = l11.longValue();
            }
            if (objArr != false && this.zzg.zzf() && !this.zzg.zzg() && l12 != null) {
                zzd = l12.longValue();
            }
            if (this.zzg.zzg()) {
                this.zzf = Long.valueOf(zzd);
            } else {
                this.zze = Long.valueOf(zzd);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final boolean zzc() {
        return true;
    }
}
