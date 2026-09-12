package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzvl extends zzatu implements zzavg {
    private static final zzvl zzb;
    private static volatile zzavn zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private zzst zzi;
    private int zzj;

    static {
        zzvl zzvlVar = new zzvl();
        zzb = zzvlVar;
        zzatu.zzaE(zzvl.class, zzvlVar);
    }

    private zzvl() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဂ\u0001\u0003ဉ\u0002\u0004င\u0003", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i12 == 3) {
            return new zzvl();
        }
        if (i12 == 4) {
            return new zzvk(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzvl.class) {
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
