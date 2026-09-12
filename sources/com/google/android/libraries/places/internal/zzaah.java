package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaah extends zzatu implements zzavg {
    private static final zzaah zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private float zzh;

    static {
        zzaah zzaahVar = new zzaah();
        zzb = zzaahVar;
        zzatu.zzaE(zzaah.class, zzaahVar);
    }

    private zzaah() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ခ\u0001", new Object[]{"zzf", "zzg", zzaaf.zza, "zzh"});
        }
        if (i12 == 3) {
            return new zzaah();
        }
        if (i12 == 4) {
            return new zzaag(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaah.class) {
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
