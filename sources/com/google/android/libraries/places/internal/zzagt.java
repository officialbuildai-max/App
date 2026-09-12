package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzagt extends zzatu implements zzavg {
    private static final zzagt zzb;
    private static volatile zzavn zze;

    static {
        zzagt zzagtVar = new zzagt();
        zzb = zzagtVar;
        zzatu.zzaE(zzagt.class, zzagtVar);
    }

    private zzagt() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0000", null);
        }
        if (i12 == 3) {
            return new zzagt();
        }
        if (i12 == 4) {
            return new zzags(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzagt.class) {
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
