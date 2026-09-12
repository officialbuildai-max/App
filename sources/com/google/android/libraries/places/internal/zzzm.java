package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzzm extends zzatu implements zzavg {
    private static final zzzm zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzh;
    private String zzg = "";
    private zzauc zzi = zzatu.zzax();

    static {
        zzzm zzzmVar = new zzzm();
        zzb = zzzmVar;
        zzatu.zzaE(zzzm.class, zzzmVar);
    }

    private zzzm() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002င\u0001\u0003\u001b", new Object[]{"zzf", "zzg", "zzh", "zzi", zzzl.class});
        }
        if (i12 == 3) {
            return new zzzm();
        }
        if (i12 == 4) {
            return new zzzj(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzzm.class) {
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
