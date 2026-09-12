package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzai extends zzatu implements zzavg {
    private static final zzai zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp;

    static {
        zzai zzaiVar = new zzai();
        zzb = zzaiVar;
        zzatu.zzaE(zzai.class, zzaiVar);
    }

    private zzai() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b\nင\t", new Object[]{"zzf", "zzg", zzah.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        }
        if (i12 == 3) {
            return new zzai();
        }
        if (i12 == 4) {
            return new zzag(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzai.class) {
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
