package com.google.android.libraries.places.internal;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzamd extends zzatu implements zzavg {
    private static final zzamd zzb;
    private static volatile zzavn zze;
    private String zzf = "";
    private zzauc zzg = zzatu.zzax();

    static {
        zzamd zzamdVar = new zzamd();
        zzb = zzamdVar;
        zzatu.zzaE(zzamd.class, zzamdVar);
    }

    private zzamd() {
    }

    public static zzamd zzc() {
        return zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzf", "zzg", zzamj.class});
        }
        if (i12 == 3) {
            return new zzamd();
        }
        zzalz zzalzVar = null;
        if (i12 == 4) {
            return new zzamc(zzalzVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzamd.class) {
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

    public final String zzd() {
        return this.zzf;
    }

    public final List zze() {
        return this.zzg;
    }
}
