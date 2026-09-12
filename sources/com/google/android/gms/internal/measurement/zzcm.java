package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public abstract class zzcm {
    public static final zzcm zza;
    static final zzcm zzb;

    static {
        zzcl zza2 = new zzcd().zza("").zza(false).zza(zzco.ALL_CHECKS);
        zzcn zzcnVar = zzcn.READ_AND_WRITE;
        zza = zza2.zza(zzcnVar).zza();
        zzb = new zzcd().zza("").zza(false).zza(zzco.NO_CHECKS).zza(zzcnVar).zza();
        new zzcd().zza("").zza(false).zza(zzco.SKIP_COMPLIANCE_CHECK).zza(zzcnVar).zza();
    }

    public abstract zzcc zza();

    public abstract zzcb zzb();

    public abstract zzco zzc();

    public abstract zzcn zzd();

    public abstract String zze();

    public abstract boolean zzf();
}
