package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzabb extends zzatu implements zzavg {
    private static final zzabb zzb;
    private static volatile zzavn zze;
    private int zzf;
    private String zzg = "";
    private int zzh;
    private long zzi;

    static {
        zzabb zzabbVar = new zzabb();
        zzb = zzabbVar;
        zzatu.zzaE(zzabb.class, zzabbVar);
    }

    private zzabb() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဂ\u0002", new Object[]{"zzf", "zzg", "zzh", zzaba.zza, "zzi"});
        }
        if (i12 == 3) {
            return new zzabb();
        }
        if (i12 == 4) {
            return new zzaaz(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzabb.class) {
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
