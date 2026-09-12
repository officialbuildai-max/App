package com.google.android.libraries.places.internal;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzbkg {
    private static final long zza = TimeUnit.SECONDS.toNanos(1);

    public static Boolean zza(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
    }

    public static Double zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' in '%s' is not a number", obj, str, map));
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a double", obj, str));
        }
    }

    public static Integer zzc(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof Double)) {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
        }
        Double d11 = (Double) obj;
        int intValue = d11.intValue();
        if (intValue == d11.doubleValue()) {
            return Integer.valueOf(intValue);
        }
        throw new ClassCastException("Number expected to be integer: ".concat(String.valueOf(d11)));
    }

    public static Long zzd(Map map, String str) {
        boolean z10;
        int i11;
        String zze = zze(map, str);
        if (zze == null) {
            return null;
        }
        try {
            if (zze.isEmpty() || zze.charAt(zze.length() - 1) != 's') {
                throw new ParseException("Invalid duration string: ".concat(zze), 0);
            }
            if (zze.charAt(0) == '-') {
                zze = zze.substring(1);
                z10 = true;
            } else {
                z10 = false;
            }
            String substring = zze.substring(0, zze.length() - 1);
            String str2 = "";
            int indexOf = substring.indexOf(46);
            if (indexOf != -1) {
                str2 = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
            }
            long parseLong = Long.parseLong(substring);
            if (str2.isEmpty()) {
                i11 = 0;
            } else {
                i11 = 0;
                for (int i12 = 0; i12 < 9; i12++) {
                    i11 *= 10;
                    if (i12 < str2.length()) {
                        if (str2.charAt(i12) < '0' || str2.charAt(i12) > '9') {
                            throw new ParseException("Invalid nanoseconds.", 0);
                        }
                        i11 += str2.charAt(i12) - '0';
                    }
                }
            }
            if (parseLong < 0) {
                throw new ParseException("Invalid duration string: ".concat(zze), 0);
            }
            if (z10) {
                parseLong = -parseLong;
                i11 = -i11;
            }
            long j11 = i11;
            try {
                long j12 = zza;
                if (j11 <= (-j12) || j11 >= j12) {
                    long j13 = j11 / j12;
                    int i13 = zzajm.zza;
                    long j14 = parseLong + j13;
                    if (!((parseLong ^ j13) < 0) && !(((parseLong ^ j14) > 0 ? 1 : ((parseLong ^ j14) == 0 ? 0 : -1)) >= 0)) {
                        throw new ArithmeticException("overflow: checkedAdd(" + parseLong + ", " + j13 + ")");
                    }
                    i11 = (int) (j11 % j12);
                    parseLong = j14;
                }
                if (parseLong > 0 && i11 < 0) {
                    parseLong--;
                    i11 = (int) (i11 + j12);
                }
                if (parseLong < 0 && i11 > 0) {
                    parseLong++;
                    i11 = (int) (i11 - j12);
                }
                if (parseLong >= -315576000000L && parseLong <= 315576000000L) {
                    long j15 = i11;
                    if (j15 >= -999999999 && j15 < j12 && ((parseLong >= 0 && i11 >= 0) || (parseLong <= 0 && i11 <= 0))) {
                        long nanos = TimeUnit.SECONDS.toNanos(parseLong);
                        long j16 = nanos + j15;
                        if (!(((nanos ^ j15) < 0) | ((nanos ^ j16) >= 0))) {
                            j16 = ((j16 >>> 63) ^ 1) + Long.MAX_VALUE;
                        }
                        return Long.valueOf(j16);
                    }
                }
                throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(parseLong), Integer.valueOf(i11)));
            } catch (IllegalArgumentException unused) {
                throw new ParseException("Duration value is out of range.", 0);
            }
        } catch (ParseException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static String zze(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    public static List zzf(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!(list.get(i11) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i11), Integer.valueOf(i11), list));
            }
        }
        return list;
    }

    public static List zzg(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    public static List zzh(Map map, String str) {
        List zzg = zzg(map, str);
        if (zzg == null) {
            return null;
        }
        zzf(zzg);
        return zzg;
    }

    public static List zzi(Map map, String str) {
        List zzg = zzg(map, str);
        if (zzg == null) {
            return null;
        }
        for (int i11 = 0; i11 < zzg.size(); i11++) {
            if (!(zzg.get(i11) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", zzg.get(i11), Integer.valueOf(i11), zzg));
            }
        }
        return zzg;
    }

    public static Map zzj(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }
}
