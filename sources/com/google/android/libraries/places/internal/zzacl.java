package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzacl extends zzatu implements zzavg {
    private static final zzacl zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;

    static {
        zzacl zzaclVar = new zzacl();
        zzb = zzaclVar;
        zzatu.zzaE(zzacl.class, zzaclVar);
    }

    private zzacl() {
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
            return new zzacl();
        }
        if (i12 == 4) {
            return new zzack(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzacl.class) {
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
