package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zztx extends zzatu implements zzavg {
    private static final zztx zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private String zzh = "";

    static {
        zztx zztxVar = new zztx();
        zzb = zztxVar;
        zzatu.zzaE(zztx.class, zztxVar);
    }

    private zztx() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzf", "zzg", zztw.zza, "zzh"});
        }
        if (i12 == 3) {
            return new zztx();
        }
        if (i12 == 4) {
            return new zztv(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zztx.class) {
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
