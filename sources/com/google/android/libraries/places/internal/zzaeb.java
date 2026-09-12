package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaeb extends zzatu implements zzavg {
    private static final zzaeb zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;

    static {
        zzaeb zzaebVar = new zzaeb();
        zzb = zzaebVar;
        zzatu.zzaE(zzaeb.class, zzaebVar);
    }

    private zzaeb() {
    }

    public static zzaea zza() {
        return (zzaea) zzb.zzar();
    }

    public static /* synthetic */ void zzd(zzaeb zzaebVar, int i11) {
        zzaebVar.zzf |= 1;
        zzaebVar.zzg = i11;
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
            return new zzaeb();
        }
        if (i12 == 4) {
            return new zzaea(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaeb.class) {
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
