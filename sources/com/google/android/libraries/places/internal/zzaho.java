package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzaho extends zzatu implements zzavg {
    private static final zzaho zzb;
    private static volatile zzavn zze;
    private zzauc zzf = zzatu.zzax();

    static {
        zzaho zzahoVar = new zzaho();
        zzb = zzahoVar;
        zzatu.zzaE(zzaho.class, zzahoVar);
    }

    private zzaho() {
    }

    public static zzahn zza() {
        return (zzahn) zzb.zzar();
    }

    public static /* synthetic */ void zzd(zzaho zzahoVar, Iterable iterable) {
        zzauc zzaucVar = zzahoVar.zzf;
        if (!zzaucVar.zzc()) {
            zzahoVar.zzf = zzatu.zzay(zzaucVar);
        }
        zzart.zzam(iterable, zzahoVar.zzf);
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzatu.zzaB(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzf"});
        }
        if (i12 == 3) {
            return new zzaho();
        }
        if (i12 == 4) {
            return new zzahn(null);
        }
        if (i12 == 5) {
            return zzb;
        }
        if (i12 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar == null) {
            synchronized (zzaho.class) {
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
