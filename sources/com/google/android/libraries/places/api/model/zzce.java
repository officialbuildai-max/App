package com.google.android.libraries.places.api.model;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zznz;
import com.google.android.libraries.places.internal.zzoa;
import com.google.android.libraries.places.internal.zzok;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzce {
    public static final /* synthetic */ int zza = 0;
    private static final zzoa zzb;
    private static final LocalTime zzc;

    static {
        zznz zznzVar = new zznz();
        zznzVar.zza(1, DayOfWeek.SUNDAY);
        zznzVar.zza(2, DayOfWeek.MONDAY);
        zznzVar.zza(3, DayOfWeek.TUESDAY);
        zznzVar.zza(4, DayOfWeek.WEDNESDAY);
        zznzVar.zza(5, DayOfWeek.THURSDAY);
        zznzVar.zza(6, DayOfWeek.FRIDAY);
        zznzVar.zza(7, DayOfWeek.SATURDAY);
        zzb = zznzVar.zzc();
        zzc = LocalTime.newInstance(23, 59);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Boolean zza(com.google.android.libraries.places.api.model.Place r14, long r15) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.model.zzce.zza(com.google.android.libraries.places.api.model.Place, long):java.lang.Boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @Deprecated
    public static Boolean zzb(Place place, long j11) {
        Place.BusinessStatus businessStatus = place.getBusinessStatus();
        OpeningHours openingHours = place.getOpeningHours();
        Integer utcOffsetMinutes = place.getUtcOffsetMinutes();
        if (businessStatus != null && businessStatus != Place.BusinessStatus.OPERATIONAL) {
            return Boolean.FALSE;
        }
        if (openingHours == null || utcOffsetMinutes == null) {
            return null;
        }
        List<Period> periods = openingHours.getPeriods();
        if (periods.isEmpty()) {
            return Boolean.FALSE;
        }
        if (zzf(periods)) {
            return Boolean.TRUE;
        }
        for (Period period : periods) {
            if (period.getOpen() == null || period.getClose() == null) {
                return null;
            }
        }
        TimeZone zze = zze(utcOffsetMinutes.intValue());
        if (zze == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(zze);
        calendar.setTimeInMillis(j11);
        DayOfWeek dayOfWeek = (DayOfWeek) zzb.get(Integer.valueOf(calendar.get(7)));
        LocalTime newInstance = LocalTime.newInstance(calendar.get(11), calendar.get(12));
        List list = (List) zzd(periods).get(dayOfWeek);
        if (list == null) {
            return Boolean.FALSE;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((zzok) it.next()).zzd(newInstance)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static Object zzc(Map map, Object obj, Object obj2) {
        return map.containsKey(obj) ? map.get(obj) : obj2;
    }

    private static Map zzd(List list) {
        EnumMap enumMap = new EnumMap(DayOfWeek.class);
        if (!list.isEmpty()) {
            Period period = (Period) list.get(0);
            int i11 = 0;
            while (period != null) {
                TimeOfWeek open = period.getOpen();
                TimeOfWeek close = period.getClose();
                if (open == null || close == null) {
                    i11++;
                    period = i11 >= list.size() ? null : (Period) list.get(i11);
                } else {
                    DayOfWeek day = open.getDay();
                    LocalTime time = open.getTime();
                    if (open.getDay() != close.getDay()) {
                        LocalTime localTime = zzc;
                        List list2 = (List) zzc(enumMap, day, new ArrayList());
                        list2.add(zzok.zzb(time, localTime));
                        enumMap.put((EnumMap) day, (DayOfWeek) list2);
                        TimeOfWeek newInstance = TimeOfWeek.newInstance(DayOfWeek.values()[(day.ordinal() + 1) % 7], LocalTime.newInstance(0, 0));
                        TimeOfWeek close2 = period.getClose();
                        Period.Builder builder = Period.builder();
                        builder.setOpen(newInstance);
                        builder.setClose(close2);
                        period = builder.build();
                    } else {
                        i11++;
                        LocalTime time2 = close.getTime();
                        List list3 = (List) zzc(enumMap, day, new ArrayList());
                        list3.add(zzok.zzc(time, time2));
                        enumMap.put((EnumMap) day, (DayOfWeek) list3);
                        if (i11 < list.size()) {
                            period = (Period) list.get(i11);
                        }
                    }
                }
            }
        }
        return enumMap;
    }

    @Nullable
    private static TimeZone zze(int i11) {
        String[] availableIDs = TimeZone.getAvailableIDs((int) TimeUnit.MINUTES.toMillis(i11));
        if (availableIDs != null && availableIDs.length > 0) {
            return TimeZone.getTimeZone(availableIDs[0]);
        }
        Log.w("Places", String.format("Cannot find timezone that associates with utcOffsetMinutes %d from Place object.", Integer.valueOf(i11)));
        return null;
    }

    private static boolean zzf(List list) {
        if (list.size() != 1) {
            return false;
        }
        Period period = (Period) list.get(0);
        TimeOfWeek open = period.getOpen();
        return period.getClose() == null && open != null && open.getDay() == DayOfWeek.SUNDAY && open.getTime().getHours() == 0 && open.getTime().getMinutes() == 0;
    }
}
