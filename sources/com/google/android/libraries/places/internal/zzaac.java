package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaac extends zzatu implements zzavg {
    private static final zzaua zzb = new zzzx();
    private static final zzaua zze = new zzzy();
    private static final zzaac zzf;
    private static volatile zzavn zzg;
    private int zzh;
    private long zzj;
    private zzauc zzi = zzatu.zzax();
    private zzatz zzk = zzatu.zzau();
    private zzatz zzl = zzatu.zzau();

    static {
        zzaac zzaacVar = new zzaac();
        zzf = zzaacVar;
        zzatu.zzaE(zzaac.class, zzaacVar);
    }

    private zzaac() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzaty zzatyVar = zzuo.zza;
            return zzatu.zzaB(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001\u001b\u0002ဂ\u0000\u0003ࠬ\u0004ࠬ", new Object[]{"zzh", "zzi", zzaab.class, "zzj", "zzk", zzatyVar, "zzl", zzatyVar});
        }
        if (i12 == 3) {
            return new zzaac();
        }
        if (i12 == 4) {
            return new zzzz(null);
        }
        if (i12 == 5) {
            return zzf;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zzg;
        if (zzavnVar == null) {
            synchronized (zzaac.class) {
                try {
                    zzavnVar = zzg;
                    if (zzavnVar == null) {
                        zzavnVar = new zzatp(zzf);
                        zzg = zzavnVar;
                    }
                } finally {
                }
            }
        }
        return zzavnVar;
    }
}
