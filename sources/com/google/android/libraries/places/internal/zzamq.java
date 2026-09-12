package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzamq extends zzatu implements zzavg {
    private static final zzamq zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzaxp zzg;
    private double zzh;

    static {
        zzamq zzamqVar = new zzamq();
        zzb = zzamqVar;
        zzatu.zzaE(zzamq.class, zzamqVar);
    }

    private zzamq() {
    }

    public static zzamp zza() {
        return (zzamp) zzb.zzar();
    }

    public static /* synthetic */ zzamq zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzamq zzamqVar, zzaxp zzaxpVar) {
        zzaxpVar.getClass();
        zzamqVar.zzg = zzaxpVar;
        zzamqVar.zzf |= 1;
    }

    public static /* synthetic */ void zze(zzamq zzamqVar, double d11) {
        zzamqVar.zzh = d11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0000", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzamq();
        }
        zzamo zzamoVar = null;
        if (i12 == 4) {
            return new zzamp(zzamoVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzamq.class) {
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
