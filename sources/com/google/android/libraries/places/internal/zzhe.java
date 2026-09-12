package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.AuthorAttribution;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalDate;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.SpecialDay;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzhe {
    private final zzhh zza;
    private final zzoa zzb;
    private final zzoa zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhe(zzhh zzhhVar) {
        zznz zznzVar = new zznz();
        zznzVar.zza(zzaov.OPERATIONAL, Place.BusinessStatus.OPERATIONAL);
        zznzVar.zza(zzaov.CLOSED_TEMPORARILY, Place.BusinessStatus.CLOSED_TEMPORARILY);
        zznzVar.zza(zzaov.CLOSED_PERMANENTLY, Place.BusinessStatus.CLOSED_PERMANENTLY);
        this.zzb = zznzVar.zzc();
        zznz zznzVar2 = new zznz();
        zznzVar2.zza(zzapg.ACCESS, OpeningHours.HoursType.ACCESS);
        zznzVar2.zza(zzapg.BREAKFAST, OpeningHours.HoursType.BREAKFAST);
        zznzVar2.zza(zzapg.BRUNCH, OpeningHours.HoursType.BRUNCH);
        zznzVar2.zza(zzapg.DELIVERY, OpeningHours.HoursType.DELIVERY);
        zznzVar2.zza(zzapg.DINNER, OpeningHours.HoursType.DINNER);
        zznzVar2.zza(zzapg.DRIVE_THROUGH, OpeningHours.HoursType.DRIVE_THROUGH);
        zznzVar2.zza(zzapg.HAPPY_HOUR, OpeningHours.HoursType.HAPPY_HOUR);
        zznzVar2.zza(zzapg.KITCHEN, OpeningHours.HoursType.KITCHEN);
        zznzVar2.zza(zzapg.LUNCH, OpeningHours.HoursType.LUNCH);
        zznzVar2.zza(zzapg.ONLINE_SERVICE_HOURS, OpeningHours.HoursType.ONLINE_SERVICE_HOURS);
        zznzVar2.zza(zzapg.PICKUP, OpeningHours.HoursType.PICKUP);
        zznzVar2.zza(zzapg.SENIOR_HOURS, OpeningHours.HoursType.SENIOR_HOURS);
        zznzVar2.zza(zzapg.TAKEOUT, OpeningHours.HoursType.TAKEOUT);
        this.zzc = zznzVar2.zzc();
        this.zza = zzhhVar;
    }

    private final OpeningHours zzb(zzapj zzapjVar) throws ApiException {
        OpeningHours.Builder builder = OpeningHours.builder();
        List zze = zzapjVar.zze();
        ArrayList arrayList = new ArrayList();
        Iterator it = zze.iterator();
        while (true) {
            TimeOfWeek timeOfWeek = null;
            if (!it.hasNext()) {
                break;
            }
            zzape zzapeVar = (zzape) it.next();
            Period.Builder builder2 = Period.builder();
            builder2.setOpen(zzapeVar.zzf() ? zzj(zzapeVar.zzc()) : null);
            if (zzapeVar.zze()) {
                timeOfWeek = zzj(zzapeVar.zza());
            }
            builder2.setClose(timeOfWeek);
            arrayList.add(builder2.build());
        }
        builder.setPeriods(arrayList);
        builder.setWeekdayText(zzapjVar.zzg());
        builder.setHoursType((OpeningHours.HoursType) this.zzc.getOrDefault(zzapjVar.zza(), null));
        List zzf = zzapjVar.zzf();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = zzf.iterator();
        while (it2.hasNext()) {
            try {
                SpecialDay.Builder builder3 = SpecialDay.builder(zzg(((zzapi) it2.next()).zzc()));
                builder3.setExceptional(true);
                arrayList2.add(builder3.build());
            } catch (IllegalArgumentException e11) {
                throw zzc(String.format("Special day is not properly defined: %s", e11.getMessage()));
            }
        }
        builder.setSpecialDays(arrayList2);
        return builder.build();
    }

    private static final ApiException zzc(String str) {
        return new ApiException(new Status(8, "Unexpected server error: ".concat(String.valueOf(str))));
    }

    @Nullable
    private static final String zzd(String str) {
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private static final Place.BooleanPlaceAttributeValue zze(boolean z10, boolean z11) {
        return !z10 ? Place.BooleanPlaceAttributeValue.UNKNOWN : z11 ? Place.BooleanPlaceAttributeValue.TRUE : Place.BooleanPlaceAttributeValue.FALSE;
    }

    private static final LatLng zzf(zzaxp zzaxpVar) {
        return new LatLng(zzaxpVar.zzc(), zzaxpVar.zze());
    }

    private static final LocalDate zzg(zzaxm zzaxmVar) {
        return LocalDate.newInstance(zzaxmVar.zzf(), zzaxmVar.zze(), zzaxmVar.zzc());
    }

    private static final String zzh(String str, String str2) {
        zzsa zzsaVar = new zzsa("a");
        int i11 = zzsc.zza;
        zzsaVar.zzc(zzsc.zza(str, zzsb.zza));
        zzsaVar.zzb(str2);
        return zzsaVar.zza().zza();
    }

    private static final AuthorAttribution zzi(zzalr zzalrVar) throws ApiException {
        String zzd = zzalrVar.zzd();
        if (zzd.isEmpty()) {
            throw zzc("Author name not provided for an AuthorAttribution result.");
        }
        AuthorAttribution.Builder builder = AuthorAttribution.builder(zzd);
        builder.setUri(zzd(zzalrVar.zzf()));
        builder.setPhotoUri(zzd(zzalrVar.zze()));
        return builder.build();
    }

    private static final TimeOfWeek zzj(zzapd zzapdVar) throws ApiException {
        DayOfWeek dayOfWeek;
        int zza = zzapdVar.zza();
        LocalTime newInstance = LocalTime.newInstance(zzapdVar.zzc(), zzapdVar.zzd());
        LocalDate zzg = zzapdVar.zzi() ? zzg(zzapdVar.zzg()) : null;
        switch (zza) {
            case 0:
                dayOfWeek = DayOfWeek.SUNDAY;
                break;
            case 1:
                dayOfWeek = DayOfWeek.MONDAY;
                break;
            case 2:
                dayOfWeek = DayOfWeek.TUESDAY;
                break;
            case 3:
                dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            case 4:
                dayOfWeek = DayOfWeek.THURSDAY;
                break;
            case 5:
                dayOfWeek = DayOfWeek.FRIDAY;
                break;
            case 6:
                dayOfWeek = DayOfWeek.SATURDAY;
                break;
            default:
                throw zzc("Day of week must an integer between 0 and 6");
        }
        TimeOfWeek.Builder builder = TimeOfWeek.builder(dayOfWeek, newInstance);
        builder.setDate(zzg);
        builder.setTruncated(zzapdVar.zzh());
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0397  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.libraries.places.api.model.Place zza(com.google.android.libraries.places.internal.zzaps r18) throws com.google.android.gms.common.api.ApiException {
        /*
            Method dump skipped, instructions count: 1418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzhe.zza(com.google.android.libraries.places.internal.zzaps):com.google.android.libraries.places.api.model.Place");
    }
}
