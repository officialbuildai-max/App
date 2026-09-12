package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzamj extends zzatu implements zzavg {
    private static final zzamj zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;

    static {
        zzamj zzamjVar = new zzamj();
        zzb = zzamjVar;
        zzatu.zzaE(zzamj.class, zzamjVar);
    }

    private zzamj() {
    }

    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzamj();
        }
        zzalz zzalzVar = null;
        if (i12 == 4) {
            return new zzami(zzalzVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzamj.class) {
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
        return this.zzf;
    }
}
