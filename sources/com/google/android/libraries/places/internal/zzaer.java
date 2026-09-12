package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaer extends zzatu implements zzavg {
    private static final zzaer zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzatz zzg = zzatu.zzau();
    private zzauc zzh = zzatu.zzax();
    private String zzi = "";
    private boolean zzj;
    private int zzk;

    static {
        zzaer zzaerVar = new zzaer();
        zzb = zzaerVar;
        zzatu.zzaE(zzaer.class, zzaerVar);
    }

    private zzaer() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0016\u0002\u001a\u0003ဈ\u0000\u0004ဇ\u0001\u0005ဋ\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i12 == 3) {
            return new zzaer();
        }
        if (i12 == 4) {
            return new zzaeq(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaer.class) {
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
