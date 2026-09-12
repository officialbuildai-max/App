package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzc extends zzatu implements zzavg {
    private static final zzc zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzco zzg;
    private zzai zzh;
    private zzj zzi;
    private zzl zzj;
    private zzg zzk;
    private zzu zzl;
    private zze zzm;
    private zzp zzn;
    private zzaa zzo;
    private zzy zzp;
    private zzr zzq;
    private zzw zzr;

    static {
        zzc zzcVar = new zzc();
        zzb = zzcVar;
        zzatu.zzaE(zzc.class, zzcVar);
    }

    private zzc() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဉ\u0001\u0002ဉ\u0002\u0003ဉ\u0003\u0004ဉ\u0004\u0005ဉ\u0005\u0006ဉ\u0006\u0007ဉ\u0007\bဉ\b\tဉ\t\nဉ\u0000\u000bဉ\n\fဉ\u000b", new Object[]{"zzf", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzg", "zzq", "zzr"});
        }
        if (i12 == 3) {
            return new zzc();
        }
        if (i12 == 4) {
            return new zzb(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzc.class) {
                try {
                    zzavnVar = zze;
                    if (zzavnVar == null) {
                        zzavnVar = new zzatp(zzb);
                        zze = zzavnVar;
                    }
                } finally {
                }
            }
        }
        return zzavnVar;
    }
}
