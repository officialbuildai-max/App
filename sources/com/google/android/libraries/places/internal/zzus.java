package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzus extends zzatu implements zzavg {
    private static final zzus zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzuu zzh;
    private zzuw zzi;
    private zzali zzj;
    private zzvc zzk;
    private zzvi zzl;
    private zzve zzm;
    private zzuy zzn;
    private byte zzo = 2;
    private int zzg = 1;

    static {
        zzus zzusVar = new zzus();
        zzb = zzusVar;
        zzatu.zzaE(zzus.class, zzusVar);
    }

    private zzus() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzo);
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0001\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007", new Object[]{"zzf", "zzg", zzur.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i12 == 3) {
            return new zzus();
        }
        if (i12 == 4) {
            return new zzuq(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            this.zzo = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzus.class) {
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
