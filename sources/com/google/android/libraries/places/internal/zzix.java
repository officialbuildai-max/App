package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalDate;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.android.libraries.places.api.model.SpecialDay;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import com.google.android.libraries.places.internal.zzja;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzix {
    private static final zzoa zza;
    private static final zzoa zzb;
    private static final zzoa zzc;

    static {
        zznz zznzVar = new zznz();
        zznzVar.zza("OPERATIONAL", Place.BusinessStatus.OPERATIONAL);
        zznzVar.zza("CLOSED_TEMPORARILY", Place.BusinessStatus.CLOSED_TEMPORARILY);
        zznzVar.zza("CLOSED_PERMANENTLY", Place.BusinessStatus.CLOSED_PERMANENTLY);
        zza = zznzVar.zzc();
        zznz zznzVar2 = new zznz();
        zznzVar2.zza(PlaceTypes.ACCOUNTING, Place.Type.ACCOUNTING);
        zznzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_1, Place.Type.ADMINISTRATIVE_AREA_LEVEL_1);
        zznzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_2, Place.Type.ADMINISTRATIVE_AREA_LEVEL_2);
        zznzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_3, Place.Type.ADMINISTRATIVE_AREA_LEVEL_3);
        zznzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_4, Place.Type.ADMINISTRATIVE_AREA_LEVEL_4);
        zznzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_5, Place.Type.ADMINISTRATIVE_AREA_LEVEL_5);
        zznzVar2.zza(PlaceTypes.AIRPORT, Place.Type.AIRPORT);
        zznzVar2.zza(PlaceTypes.AMUSEMENT_PARK, Place.Type.AMUSEMENT_PARK);
        zznzVar2.zza(PlaceTypes.AQUARIUM, Place.Type.AQUARIUM);
        zznzVar2.zza(PlaceTypes.ARCHIPELAGO, Place.Type.ARCHIPELAGO);
        zznzVar2.zza(PlaceTypes.ART_GALLERY, Place.Type.ART_GALLERY);
        zznzVar2.zza(PlaceTypes.ATM, Place.Type.ATM);
        zznzVar2.zza(PlaceTypes.BAKERY, Place.Type.BAKERY);
        zznzVar2.zza(PlaceTypes.BANK, Place.Type.BANK);
        zznzVar2.zza(PlaceTypes.BAR, Place.Type.BAR);
        zznzVar2.zza(PlaceTypes.BEAUTY_SALON, Place.Type.BEAUTY_SALON);
        zznzVar2.zza(PlaceTypes.BICYCLE_STORE, Place.Type.BICYCLE_STORE);
        zznzVar2.zza(PlaceTypes.BOOK_STORE, Place.Type.BOOK_STORE);
        zznzVar2.zza(PlaceTypes.BOWLING_ALLEY, Place.Type.BOWLING_ALLEY);
        zznzVar2.zza(PlaceTypes.BUS_STATION, Place.Type.BUS_STATION);
        zznzVar2.zza(PlaceTypes.CAFE, Place.Type.CAFE);
        zznzVar2.zza(PlaceTypes.CAMPGROUND, Place.Type.CAMPGROUND);
        zznzVar2.zza(PlaceTypes.CAR_DEALER, Place.Type.CAR_DEALER);
        zznzVar2.zza(PlaceTypes.CAR_RENTAL, Place.Type.CAR_RENTAL);
        zznzVar2.zza(PlaceTypes.CAR_REPAIR, Place.Type.CAR_REPAIR);
        zznzVar2.zza(PlaceTypes.CAR_WASH, Place.Type.CAR_WASH);
        zznzVar2.zza(PlaceTypes.CASINO, Place.Type.CASINO);
        zznzVar2.zza(PlaceTypes.CEMETERY, Place.Type.CEMETERY);
        zznzVar2.zza(PlaceTypes.CHURCH, Place.Type.CHURCH);
        zznzVar2.zza(PlaceTypes.CITY_HALL, Place.Type.CITY_HALL);
        zznzVar2.zza(PlaceTypes.CLOTHING_STORE, Place.Type.CLOTHING_STORE);
        zznzVar2.zza(PlaceTypes.COLLOQUIAL_AREA, Place.Type.COLLOQUIAL_AREA);
        zznzVar2.zza(PlaceTypes.CONTINENT, Place.Type.CONTINENT);
        zznzVar2.zza(PlaceTypes.CONVENIENCE_STORE, Place.Type.CONVENIENCE_STORE);
        zznzVar2.zza(PlaceTypes.COUNTRY, Place.Type.COUNTRY);
        zznzVar2.zza(PlaceTypes.COURTHOUSE, Place.Type.COURTHOUSE);
        zznzVar2.zza(PlaceTypes.DENTIST, Place.Type.DENTIST);
        zznzVar2.zza(PlaceTypes.DEPARTMENT_STORE, Place.Type.DEPARTMENT_STORE);
        zznzVar2.zza(PlaceTypes.DOCTOR, Place.Type.DOCTOR);
        zznzVar2.zza(PlaceTypes.DRUGSTORE, Place.Type.DRUGSTORE);
        zznzVar2.zza(PlaceTypes.ELECTRICIAN, Place.Type.ELECTRICIAN);
        zznzVar2.zza(PlaceTypes.ELECTRONICS_STORE, Place.Type.ELECTRONICS_STORE);
        zznzVar2.zza(PlaceTypes.EMBASSY, Place.Type.EMBASSY);
        zznzVar2.zza(PlaceTypes.ESTABLISHMENT, Place.Type.ESTABLISHMENT);
        zznzVar2.zza(PlaceTypes.FINANCE, Place.Type.FINANCE);
        zznzVar2.zza(PlaceTypes.FIRE_STATION, Place.Type.FIRE_STATION);
        zznzVar2.zza(PlaceTypes.FLOOR, Place.Type.FLOOR);
        zznzVar2.zza(PlaceTypes.FLORIST, Place.Type.FLORIST);
        zznzVar2.zza(PlaceTypes.FOOD, Place.Type.FOOD);
        zznzVar2.zza(PlaceTypes.FUNERAL_HOME, Place.Type.FUNERAL_HOME);
        zznzVar2.zza(PlaceTypes.FURNITURE_STORE, Place.Type.FURNITURE_STORE);
        zznzVar2.zza(PlaceTypes.GAS_STATION, Place.Type.GAS_STATION);
        zznzVar2.zza(PlaceTypes.GENERAL_CONTRACTOR, Place.Type.GENERAL_CONTRACTOR);
        zznzVar2.zza(PlaceTypes.GEOCODE, Place.Type.GEOCODE);
        zznzVar2.zza("grocery_or_supermarket", Place.Type.GROCERY_OR_SUPERMARKET);
        zznzVar2.zza(PlaceTypes.GYM, Place.Type.GYM);
        zznzVar2.zza(PlaceTypes.HAIR_CARE, Place.Type.HAIR_CARE);
        zznzVar2.zza(PlaceTypes.HARDWARE_STORE, Place.Type.HARDWARE_STORE);
        zznzVar2.zza(PlaceTypes.HEALTH, Place.Type.HEALTH);
        zznzVar2.zza(PlaceTypes.HINDU_TEMPLE, Place.Type.HINDU_TEMPLE);
        zznzVar2.zza(PlaceTypes.HOME_GOODS_STORE, Place.Type.HOME_GOODS_STORE);
        zznzVar2.zza(PlaceTypes.HOSPITAL, Place.Type.HOSPITAL);
        zznzVar2.zza(PlaceTypes.INSURANCE_AGENCY, Place.Type.INSURANCE_AGENCY);
        zznzVar2.zza(PlaceTypes.INTERSECTION, Place.Type.INTERSECTION);
        zznzVar2.zza(PlaceTypes.JEWELRY_STORE, Place.Type.JEWELRY_STORE);
        zznzVar2.zza(PlaceTypes.LAUNDRY, Place.Type.LAUNDRY);
        zznzVar2.zza(PlaceTypes.LAWYER, Place.Type.LAWYER);
        zznzVar2.zza(PlaceTypes.LIBRARY, Place.Type.LIBRARY);
        zznzVar2.zza(PlaceTypes.LIGHT_RAIL_STATION, Place.Type.LIGHT_RAIL_STATION);
        zznzVar2.zza(PlaceTypes.LIQUOR_STORE, Place.Type.LIQUOR_STORE);
        zznzVar2.zza(PlaceTypes.LOCAL_GOVERNMENT_OFFICE, Place.Type.LOCAL_GOVERNMENT_OFFICE);
        zznzVar2.zza(PlaceTypes.LOCALITY, Place.Type.LOCALITY);
        zznzVar2.zza(PlaceTypes.LOCKSMITH, Place.Type.LOCKSMITH);
        zznzVar2.zza(PlaceTypes.LODGING, Place.Type.LODGING);
        zznzVar2.zza(PlaceTypes.MEAL_DELIVERY, Place.Type.MEAL_DELIVERY);
        zznzVar2.zza(PlaceTypes.MEAL_TAKEAWAY, Place.Type.MEAL_TAKEAWAY);
        zznzVar2.zza(PlaceTypes.MOSQUE, Place.Type.MOSQUE);
        zznzVar2.zza(PlaceTypes.MOVIE_RENTAL, Place.Type.MOVIE_RENTAL);
        zznzVar2.zza(PlaceTypes.MOVIE_THEATER, Place.Type.MOVIE_THEATER);
        zznzVar2.zza(PlaceTypes.MOVING_COMPANY, Place.Type.MOVING_COMPANY);
        zznzVar2.zza(PlaceTypes.MUSEUM, Place.Type.MUSEUM);
        zznzVar2.zza(PlaceTypes.NATURAL_FEATURE, Place.Type.NATURAL_FEATURE);
        zznzVar2.zza(PlaceTypes.NEIGHBORHOOD, Place.Type.NEIGHBORHOOD);
        zznzVar2.zza(PlaceTypes.NIGHT_CLUB, Place.Type.NIGHT_CLUB);
        zznzVar2.zza(PlaceTypes.PAINTER, Place.Type.PAINTER);
        zznzVar2.zza(PlaceTypes.PARK, Place.Type.PARK);
        zznzVar2.zza(PlaceTypes.PARKING, Place.Type.PARKING);
        zznzVar2.zza(PlaceTypes.PET_STORE, Place.Type.PET_STORE);
        zznzVar2.zza(PlaceTypes.PHARMACY, Place.Type.PHARMACY);
        zznzVar2.zza(PlaceTypes.PHYSIOTHERAPIST, Place.Type.PHYSIOTHERAPIST);
        zznzVar2.zza(PlaceTypes.PLACE_OF_WORSHIP, Place.Type.PLACE_OF_WORSHIP);
        zznzVar2.zza(PlaceTypes.PLUMBER, Place.Type.PLUMBER);
        zznzVar2.zza(PlaceTypes.PLUS_CODE, Place.Type.PLUS_CODE);
        zznzVar2.zza(PlaceTypes.POINT_OF_INTEREST, Place.Type.POINT_OF_INTEREST);
        zznzVar2.zza(PlaceTypes.POLICE, Place.Type.POLICE);
        zznzVar2.zza(PlaceTypes.POLITICAL, Place.Type.POLITICAL);
        zznzVar2.zza(PlaceTypes.POST_BOX, Place.Type.POST_BOX);
        zznzVar2.zza(PlaceTypes.POST_OFFICE, Place.Type.POST_OFFICE);
        zznzVar2.zza(PlaceTypes.POSTAL_CODE_PREFIX, Place.Type.POSTAL_CODE_PREFIX);
        zznzVar2.zza(PlaceTypes.POSTAL_CODE_SUFFIX, Place.Type.POSTAL_CODE_SUFFIX);
        zznzVar2.zza(PlaceTypes.POSTAL_CODE, Place.Type.POSTAL_CODE);
        zznzVar2.zza(PlaceTypes.POSTAL_TOWN, Place.Type.POSTAL_TOWN);
        zznzVar2.zza(PlaceTypes.PREMISE, Place.Type.PREMISE);
        zznzVar2.zza(PlaceTypes.PRIMARY_SCHOOL, Place.Type.PRIMARY_SCHOOL);
        zznzVar2.zza(PlaceTypes.REAL_ESTATE_AGENCY, Place.Type.REAL_ESTATE_AGENCY);
        zznzVar2.zza(PlaceTypes.RESTAURANT, Place.Type.RESTAURANT);
        zznzVar2.zza(PlaceTypes.ROOFING_CONTRACTOR, Place.Type.ROOFING_CONTRACTOR);
        zznzVar2.zza(PlaceTypes.ROOM, Place.Type.ROOM);
        zznzVar2.zza(PlaceTypes.ROUTE, Place.Type.ROUTE);
        zznzVar2.zza(PlaceTypes.RV_PARK, Place.Type.RV_PARK);
        zznzVar2.zza(PlaceTypes.SCHOOL, Place.Type.SCHOOL);
        zznzVar2.zza(PlaceTypes.SECONDARY_SCHOOL, Place.Type.SECONDARY_SCHOOL);
        zznzVar2.zza(PlaceTypes.SHOE_STORE, Place.Type.SHOE_STORE);
        zznzVar2.zza(PlaceTypes.SHOPPING_MALL, Place.Type.SHOPPING_MALL);
        zznzVar2.zza(PlaceTypes.SPA, Place.Type.SPA);
        zznzVar2.zza(PlaceTypes.STADIUM, Place.Type.STADIUM);
        zznzVar2.zza(PlaceTypes.STORAGE, Place.Type.STORAGE);
        zznzVar2.zza(PlaceTypes.STORE, Place.Type.STORE);
        zznzVar2.zza(PlaceTypes.STREET_ADDRESS, Place.Type.STREET_ADDRESS);
        zznzVar2.zza(PlaceTypes.STREET_NUMBER, Place.Type.STREET_NUMBER);
        zznzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_1, Place.Type.SUBLOCALITY_LEVEL_1);
        zznzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_2, Place.Type.SUBLOCALITY_LEVEL_2);
        zznzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_3, Place.Type.SUBLOCALITY_LEVEL_3);
        zznzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_4, Place.Type.SUBLOCALITY_LEVEL_4);
        zznzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_5, Place.Type.SUBLOCALITY_LEVEL_5);
        zznzVar2.zza(PlaceTypes.SUBLOCALITY, Place.Type.SUBLOCALITY);
        zznzVar2.zza(PlaceTypes.SUBPREMISE, Place.Type.SUBPREMISE);
        zznzVar2.zza(PlaceTypes.SUBWAY_STATION, Place.Type.SUBWAY_STATION);
        zznzVar2.zza(PlaceTypes.SUPERMARKET, Place.Type.SUPERMARKET);
        zznzVar2.zza(PlaceTypes.SYNAGOGUE, Place.Type.SYNAGOGUE);
        zznzVar2.zza(PlaceTypes.TAXI_STAND, Place.Type.TAXI_STAND);
        zznzVar2.zza(PlaceTypes.TOURIST_ATTRACTION, Place.Type.TOURIST_ATTRACTION);
        zznzVar2.zza(PlaceTypes.TOWN_SQUARE, Place.Type.TOWN_SQUARE);
        zznzVar2.zza(PlaceTypes.TRAIN_STATION, Place.Type.TRAIN_STATION);
        zznzVar2.zza(PlaceTypes.TRANSIT_STATION, Place.Type.TRANSIT_STATION);
        zznzVar2.zza(PlaceTypes.TRAVEL_AGENCY, Place.Type.TRAVEL_AGENCY);
        zznzVar2.zza(PlaceTypes.UNIVERSITY, Place.Type.UNIVERSITY);
        zznzVar2.zza(PlaceTypes.VETERINARY_CARE, Place.Type.VETERINARY_CARE);
        zznzVar2.zza(PlaceTypes.ZOO, Place.Type.ZOO);
        zzb = zznzVar2.zzc();
        zznz zznzVar3 = new zznz();
        zznzVar3.zza("ACCESS", OpeningHours.HoursType.ACCESS);
        zznzVar3.zza("BREAKFAST", OpeningHours.HoursType.BREAKFAST);
        zznzVar3.zza("BRUNCH", OpeningHours.HoursType.BRUNCH);
        zznzVar3.zza("DELIVERY", OpeningHours.HoursType.DELIVERY);
        zznzVar3.zza("DINNER", OpeningHours.HoursType.DINNER);
        zznzVar3.zza("DRIVE_THROUGH", OpeningHours.HoursType.DRIVE_THROUGH);
        zznzVar3.zza("HAPPY_HOUR", OpeningHours.HoursType.HAPPY_HOUR);
        zznzVar3.zza("KITCHEN", OpeningHours.HoursType.KITCHEN);
        zznzVar3.zza("LUNCH", OpeningHours.HoursType.LUNCH);
        zznzVar3.zza("ONLINE_SERVICE_HOURS", OpeningHours.HoursType.ONLINE_SERVICE_HOURS);
        zznzVar3.zza("PICKUP", OpeningHours.HoursType.PICKUP);
        zznzVar3.zza("SENIOR_HOURS", OpeningHours.HoursType.SENIOR_HOURS);
        zznzVar3.zza("TAKEOUT", OpeningHours.HoursType.TAKEOUT);
        zzc = zznzVar3.zzc();
    }

    @Nullable
    static LocalDate zza(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return LocalDate.newInstance(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(5, 7)), Integer.parseInt(str.substring(8, 10)));
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException(String.format("Unable to convert %s to LocalDate; date should be in format YYYY-MM-DD.", str), e11);
        }
    }

    static Place.BooleanPlaceAttributeValue zzb(@Nullable Boolean bool) {
        return bool == null ? Place.BooleanPlaceAttributeValue.UNKNOWN : bool.booleanValue() ? Place.BooleanPlaceAttributeValue.TRUE : Place.BooleanPlaceAttributeValue.FALSE;
    }

    @Nullable
    static TimeOfWeek zzc(@Nullable zzja.zzd.zzc zzcVar) {
        DayOfWeek dayOfWeek;
        boolean z10 = true;
        LocalDate localDate = null;
        if (zzcVar == null) {
            return null;
        }
        try {
            Integer zzb2 = zzcVar.zzb();
            zzmt.zzc(zzb2, "Unable to convert Pablo response to TimeOfWeek: The \"day\" field is missing.");
            String zzd = zzcVar.zzd();
            zzmt.zzc(zzd, "Unable to convert Pablo response to TimeOfWeek: The \"time\" field is missing.");
            String format = String.format("Unable to convert %s to LocalTime, must be of format \"hhmm\".", zzd);
            if (zzd.length() != 4) {
                z10 = false;
            }
            zzmt.zzf(z10, format);
            try {
                LocalTime newInstance = LocalTime.newInstance(Integer.parseInt(zzd.substring(0, 2)), Integer.parseInt(zzd.substring(2, 4)));
                try {
                    localDate = zza(zzcVar.zzc());
                } catch (IllegalArgumentException unused) {
                }
                switch (zzb2.intValue()) {
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
                        throw new IllegalArgumentException("pabloDayOfWeek can only be an integer between 0 and 6");
                }
                TimeOfWeek.Builder builder = TimeOfWeek.builder(dayOfWeek, newInstance);
                builder.setDate(localDate);
                builder.setTruncated(Boolean.TRUE.equals(zzcVar.zza()));
                return builder.build();
            } catch (NumberFormatException e11) {
                throw new IllegalArgumentException(format, e11);
            }
        } catch (NullPointerException e12) {
            throw new IllegalArgumentException(e12.getMessage(), e12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zzd(@Nullable List list) {
        return list != null ? list : new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @Deprecated
    public static List zze(List list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        zzoy listIterator = ((zznx) list).listIterator(0);
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            zzoa zzoaVar = zzb;
            if (zzoaVar.containsKey(str)) {
                arrayList.add((Place.Type) zzoaVar.get(str));
            } else {
                z10 = true;
            }
        }
        if (z10) {
            arrayList.add(Place.Type.OTHER);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List zzf(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.google.android.libraries.places.api.model.Place zzg(@androidx.annotation.Nullable com.google.android.libraries.places.internal.zzja r11, @androidx.annotation.Nullable java.util.List r12) throws com.google.android.gms.common.api.ApiException {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzix.zzg(com.google.android.libraries.places.internal.zzja, java.util.List):com.google.android.libraries.places.api.model.Place");
    }

    private static ApiException zzh(String str) {
        return new ApiException(new Status(8, "Unexpected server error: ".concat(String.valueOf(str))));
    }

    @Nullable
    private static LatLng zzi(@Nullable zzja.zzc.zza zzaVar) {
        if (zzaVar == null) {
            return null;
        }
        Double zza2 = zzaVar.zza();
        Double zzb2 = zzaVar.zzb();
        if (zza2 == null || zzb2 == null) {
            return null;
        }
        return new LatLng(zza2.doubleValue(), zzb2.doubleValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private static OpeningHours zzj(@Nullable zzja.zzd zzdVar) {
        ArrayList arrayList;
        LocalDate zza2;
        SpecialDay build;
        Period period;
        if (zzdVar == null) {
            return null;
        }
        OpeningHours.Builder builder = OpeningHours.builder();
        zznx zza3 = zzdVar.zza();
        if (zza3.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            zzoy listIterator = zza3.listIterator(0);
            while (listIterator.hasNext()) {
                zzja.zzd.zza zzaVar = (zzja.zzd.zza) listIterator.next();
                if (zzaVar != null) {
                    Period.Builder builder2 = Period.builder();
                    builder2.setOpen(zzc(zzaVar.zzb()));
                    builder2.setClose(zzc(zzaVar.zza()));
                    period = builder2.build();
                } else {
                    period = null;
                }
                zzk(arrayList, period);
            }
        }
        builder.setPeriods(zzd(arrayList));
        builder.setWeekdayText(zzdVar.zzc());
        builder.setHoursType((OpeningHours.HoursType) zzc.getOrDefault(zzdVar.zzd(), null));
        zznx zzb2 = zzdVar.zzb();
        ArrayList arrayList2 = new ArrayList();
        if (!zzb2.isEmpty()) {
            zzoy listIterator2 = zzb2.listIterator(0);
            while (listIterator2.hasNext()) {
                zzja.zzd.zzb zzbVar = (zzja.zzd.zzb) listIterator2.next();
                if (zzbVar != null) {
                    try {
                        zza2 = zza(zzbVar.zzb());
                    } catch (IllegalArgumentException | NullPointerException unused) {
                    }
                    if (zza2 == null) {
                        throw null;
                        break;
                    }
                    SpecialDay.Builder builder3 = SpecialDay.builder(zza2);
                    builder3.setExceptional(Boolean.TRUE.equals(zzbVar.zza()));
                    build = builder3.build();
                    zzk(arrayList2, build);
                }
                build = null;
                zzk(arrayList2, build);
            }
        }
        builder.setSpecialDays(arrayList2);
        return builder.build();
    }

    private static boolean zzk(Collection collection, @Nullable Object obj) {
        if (obj != null) {
            return collection.add(obj);
        }
        return false;
    }
}
