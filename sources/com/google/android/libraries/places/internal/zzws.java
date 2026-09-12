package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzws extends zzatu implements zzavg {
    private static final zzws zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;

    static {
        zzws zzwsVar = new zzws();
        zzb = zzwsVar;
        zzatu.zzaE(zzws.class, zzwsVar);
    }

    private zzws() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzf", "zzg", zzwr.zza});
        }
        if (i12 == 3) {
            return new zzws();
        }
        if (i12 == 4) {
            return new zzwq(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzws.class) {
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
