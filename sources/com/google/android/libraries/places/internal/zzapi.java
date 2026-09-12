package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzapi extends zzatu implements zzavg {
    private static final zzapi zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzaxm zzg;

    static {
        zzapi zzapiVar = new zzapi();
        zzb = zzapiVar;
        zzatu.zzaE(zzapi.class, zzapiVar);
    }

    private zzapi() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzapi();
        }
        if (i12 == 4) {
            return new zzaph(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzapi.class) {
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

    public final zzaxm zzc() {
        zzaxm zzaxmVar = this.zzg;
        return zzaxmVar == null ? zzaxm.zzh() : zzaxmVar;
    }
}
