package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public final class zzapw {
    private static volatile zzbcl zza;
    private static volatile zzbcl zzb;
    private static volatile zzbcl zzc;
    private static volatile zzbcl zzd;
    private static volatile zzbcl zze;

    private zzapw() {
    }

    public static zzapv zza(zzayk zzaykVar) {
        return (zzapv) zzbup.zzb(new zzapt(), zzaykVar, zzayj.zza);
    }

    public static zzbcl zzb() {
        zzbcl zzbclVar = zze;
        if (zzbclVar == null) {
            synchronized (zzapw.class) {
                try {
                    zzbclVar = zze;
                    if (zzbclVar == null) {
                        zzbch zza2 = zzbcl.zza(null, null);
                        zza2.zze(zzbcj.UNARY);
                        zza2.zza(zzbcl.zze("google.maps.places.v1.Places", "AutocompletePlaces"));
                        zza2.zzd(true);
                        zza2.zzb(zzbuo.zza(zzaly.zzd()));
                        zza2.zzc(zzbuo.zza(zzamn.zzc()));
                        zzbclVar = zza2.zzf();
                        zze = zzbclVar;
                    }
                } finally {
                }
            }
        }
        return zzbclVar;
    }

    public static zzbcl zzc() {
        zzbcl zzbclVar = zzc;
        if (zzbclVar == null) {
            synchronized (zzapw.class) {
                try {
                    zzbclVar = zzc;
                    if (zzbclVar == null) {
                        zzbch zza2 = zzbcl.zza(null, null);
                        zza2.zze(zzbcj.UNARY);
                        zza2.zza(zzbcl.zze("google.maps.places.v1.Places", "GetPhotoMedia"));
                        zza2.zzd(true);
                        zza2.zzb(zzbuo.zza(zzanx.zzd()));
                        zza2.zzc(zzbuo.zza(zzaoj.zzc()));
                        zzbclVar = zza2.zzf();
                        zzc = zzbclVar;
                    }
                } finally {
                }
            }
        }
        return zzbclVar;
    }

    public static zzbcl zzd() {
        zzbcl zzbclVar = zzd;
        if (zzbclVar == null) {
            synchronized (zzapw.class) {
                try {
                    zzbclVar = zzd;
                    if (zzbclVar == null) {
                        zzbch zza2 = zzbcl.zza(null, null);
                        zza2.zze(zzbcj.UNARY);
                        zza2.zza(zzbcl.zze("google.maps.places.v1.Places", "GetPlace"));
                        zza2.zzd(true);
                        zza2.zzb(zzbuo.zza(zzaoa.zzd()));
                        zza2.zzc(zzbuo.zza(zzaps.zzl()));
                        zzbclVar = zza2.zzf();
                        zzd = zzbclVar;
                    }
                } finally {
                }
            }
        }
        return zzbclVar;
    }

    public static zzbcl zze() {
        zzbcl zzbclVar = zza;
        if (zzbclVar == null) {
            synchronized (zzapw.class) {
                try {
                    zzbclVar = zza;
                    if (zzbclVar == null) {
                        zzbch zza2 = zzbcl.zza(null, null);
                        zza2.zze(zzbcj.UNARY);
                        zza2.zza(zzbcl.zze("google.maps.places.v1.Places", "SearchNearby"));
                        zza2.zzd(true);
                        zza2.zzb(zzbuo.zza(zzaqz.zzd()));
                        zza2.zzc(zzbuo.zza(zzarc.zzc()));
                        zzbclVar = zza2.zzf();
                        zza = zzbclVar;
                    }
                } finally {
                }
            }
        }
        return zzbclVar;
    }

    public static zzbcl zzf() {
        zzbcl zzbclVar = zzb;
        if (zzbclVar == null) {
            synchronized (zzapw.class) {
                try {
                    zzbclVar = zzb;
                    if (zzbclVar == null) {
                        zzbch zza2 = zzbcl.zza(null, null);
                        zza2.zze(zzbcj.UNARY);
                        zza2.zza(zzbcl.zze("google.maps.places.v1.Places", "SearchText"));
                        zza2.zzd(true);
                        zza2.zzb(zzbuo.zza(zzaro.zzd()));
                        zza2.zzc(zzbuo.zza(zzarr.zzc()));
                        zzbclVar = zza2.zzf();
                        zzb = zzbclVar;
                    }
                } finally {
                }
            }
        }
        return zzbclVar;
    }
}
