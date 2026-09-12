package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaoa extends zzatu implements zzavg {
    private static final zzaoa zzb;
    private static volatile zzavn zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzaoa zzaoaVar = new zzaoa();
        zzb = zzaoaVar;
        zzatu.zzaE(zzaoa.class, zzaoaVar);
    }

    private zzaoa() {
    }

    public static zzanz zza() {
        return (zzanz) zzb.zzar();
    }

    public static zzaoa zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzaoa zzaoaVar, String str) {
        str.getClass();
        zzaoaVar.zzi = str;
    }

    public static /* synthetic */ void zzg(zzaoa zzaoaVar, String str) {
        str.getClass();
        zzaoaVar.zzg = str;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"zzf", "zzg", "zzh", "zzi"});
        }
        if (i12 == 3) {
            return new zzaoa();
        }
        if (i12 == 4) {
            return new zzanz(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaoa.class) {
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
