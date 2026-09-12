package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzxm extends zzatu implements zzavg {
    private static final zzxm zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzst zzg;
    private long zzh;
    private long zzi;

    static {
        zzxm zzxmVar = new zzxm();
        zzb = zzxmVar;
        zzatu.zzaE(zzxm.class, zzxmVar);
    }

    private zzxm() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi"});
        }
        if (i12 == 3) {
            return new zzxm();
        }
        if (i12 == 4) {
            return new zzxl(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzxm.class) {
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
