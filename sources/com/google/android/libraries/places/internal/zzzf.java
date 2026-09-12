package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzzf extends zzatu implements zzavg {
    private static final zzzf zzb;
    private static volatile zzavn zze;
    private int zzf;
    private float zzg;
    private int zzh;

    static {
        zzzf zzzfVar = new zzzf();
        zzb = zzzfVar;
        zzatu.zzaE(zzzf.class, zzzfVar);
    }

    private zzzf() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002င\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzzf();
        }
        if (i12 == 4) {
            return new zzze(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzzf.class) {
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
