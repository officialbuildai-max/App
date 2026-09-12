package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzabk extends zzatu implements zzavg {
    private static final zzabk zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;

    static {
        zzabk zzabkVar = new zzabk();
        zzb = zzabkVar;
        zzatu.zzaE(zzabk.class, zzabkVar);
    }

    private zzabk() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ဇ\u0004\u0006᠌\u0005", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzabj.zza});
        }
        if (i12 == 3) {
            return new zzabk();
        }
        if (i12 == 4) {
            return new zzabi(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzabk.class) {
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
