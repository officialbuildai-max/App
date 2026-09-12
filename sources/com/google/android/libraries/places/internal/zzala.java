package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzala extends zzatu implements zzavg {
    private static final zzala zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg = 1;
    private int zzh = 1;
    private int zzi;

    static {
        zzala zzalaVar = new zzala();
        zzb = zzalaVar;
        zzatu.zzaE(zzala.class, zzalaVar);
    }

    private zzala() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002", new Object[]{"zzf", "zzg", zzakz.zza, "zzh", zzaky.zza, "zzi"});
        }
        if (i12 == 3) {
            return new zzala();
        }
        if (i12 == 4) {
            return new zzakx(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzala.class) {
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
