package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaei extends zzatu implements zzavg {
    private static final zzaei zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;

    static {
        zzaei zzaeiVar = new zzaei();
        zzb = zzaeiVar;
        zzatu.zzaE(zzaei.class, zzaeiVar);
    }

    private zzaei() {
    }

    public static zzaeh zza() {
        return (zzaeh) zzb.zzar();
    }

    public static /* synthetic */ void zzd(zzaei zzaeiVar, int i11) {
        zzaeiVar.zzf |= 1;
        zzaeiVar.zzg = i11;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzaei();
        }
        if (i12 == 4) {
            return new zzaeh(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaei.class) {
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
