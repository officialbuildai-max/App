package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzanp extends zzatu implements zzavg {
    private static final zzanp zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzauc zzg = zzatu.zzax();
    private zzauc zzh = zzatu.zzax();

    static {
        zzanp zzanpVar = new zzanp();
        zzb = zzanpVar;
        zzatu.zzaE(zzanp.class, zzanpVar);
    }

    private zzanp() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003\u001b", new Object[]{"zzf", "zzg", zzanm.class, "zzh", zzano.class});
        }
        if (i12 == 3) {
            return new zzanp();
        }
        if (i12 == 4) {
            return new zzank(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzanp.class) {
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
