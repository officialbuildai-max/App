package com.google.android.libraries.places.internal;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzaxg {
    public static final zzawl zza;
    public static final zzawl zzb;
    public static final zzawl zzc;
    private static final ThreadLocal zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;

    static {
        zzawk zzf2 = zzawl.zzf();
        zzf2.zzb(-62135596800L);
        zzf2.zza(0);
        zza = (zzawl) zzf2.zzt();
        zzawk zzf3 = zzawl.zzf();
        zzf3.zzb(253402300799L);
        zzf3.zza(999999999);
        zzb = (zzawl) zzf3.zzt();
        zzawk zzf4 = zzawl.zzf();
        zzf4.zzb(0L);
        zzf4.zza(0);
        zzc = (zzawl) zzf4.zzt();
        zzd = new zzaxf();
        zze = zzb("now");
        zzf = zzb("getEpochSecond");
        zzg = zzb("getNano");
    }

    public static String zza(zzawl zzawlVar) {
        long zze2 = zzawlVar.zze();
        int zzc2 = zzawlVar.zzc();
        if (zze2 < -62135596800L || zze2 > 253402300799L || zzc2 < 0 || zzc2 >= 1000000000) {
            throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(zze2), Integer.valueOf(zzc2)));
        }
        long zze3 = zzawlVar.zze();
        int zzc3 = zzawlVar.zzc();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((SimpleDateFormat) zzd.get()).format(new Date(zze3 * 1000)));
        if (zzc3 != 0) {
            sb2.append(".");
            sb2.append(zzc3 % 1000000 == 0 ? String.format(Locale.ENGLISH, "%1$03d", Integer.valueOf(zzc3 / 1000000)) : zzc3 % 1000 == 0 ? String.format(Locale.ENGLISH, "%1$06d", Integer.valueOf(zzc3 / 1000)) : String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(zzc3)));
        }
        sb2.append("Z");
        return sb2.toString();
    }

    private static Method zzb(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }
}
