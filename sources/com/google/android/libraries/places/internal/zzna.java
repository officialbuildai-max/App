package com.google.android.libraries.places.internal;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzna {
    private final zznf zza = zznf.zza();
    private boolean zzb;
    private long zzc;

    zzna() {
    }

    public static zzna zzb() {
        return new zzna();
    }

    private final long zze() {
        if (this.zzb) {
            return System.nanoTime() - this.zzc;
        }
        return 0L;
    }

    public final String toString() {
        String str;
        long zze = zze();
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(zze, timeUnit2) <= 0) {
            timeUnit = TimeUnit.HOURS;
            if (timeUnit.convert(zze, timeUnit2) <= 0) {
                timeUnit = TimeUnit.MINUTES;
                if (timeUnit.convert(zze, timeUnit2) <= 0) {
                    timeUnit = TimeUnit.SECONDS;
                    if (timeUnit.convert(zze, timeUnit2) <= 0) {
                        timeUnit = TimeUnit.MILLISECONDS;
                        if (timeUnit.convert(zze, timeUnit2) <= 0) {
                            timeUnit = TimeUnit.MICROSECONDS;
                            if (timeUnit.convert(zze, timeUnit2) <= 0) {
                                timeUnit = timeUnit2;
                            }
                        }
                    }
                }
            }
        }
        String format = String.format(Locale.ROOT, "%.4g", Double.valueOf(zze / timeUnit2.convert(1L, timeUnit)));
        switch (zzmz.zza[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        return format + " " + str;
    }

    public final long zza(TimeUnit timeUnit) {
        return timeUnit.convert(zze(), TimeUnit.NANOSECONDS);
    }

    public final zzna zzc() {
        this.zzb = false;
        return this;
    }

    public final zzna zzd() {
        zzmt.zzp(!this.zzb, "This stopwatch is already running.");
        this.zzb = true;
        this.zzc = System.nanoTime();
        return this;
    }
}
