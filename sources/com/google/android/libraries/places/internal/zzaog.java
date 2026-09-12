package com.google.android.libraries.places.internal;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzaog extends zzatu implements zzavg {
    private static final zzaog zzb;
    private static volatile zzavn zze;
    private int zzg;
    private int zzh;
    private String zzf = "";
    private zzauc zzi = zzatu.zzax();

    static {
        zzaog zzaogVar = new zzaog();
        zzb = zzaogVar;
        zzatu.zzaE(zzaog.class, zzaogVar);
    }

    private zzaog() {
    }

    public final int zza() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u001b", new Object[]{"zzf", "zzg", "zzh", "zzi", zzalr.class});
        }
        if (i12 == 3) {
            return new zzaog();
        }
        if (i12 == 4) {
            return new zzaof(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaog.class) {
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

    public final int zzc() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzi;
    }
}
