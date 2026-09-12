package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.libraries.places.internal.zzmt;
import com.google.android.libraries.places.internal.zznx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class OpeningHours implements Parcelable {

    /* loaded from: classes4.dex */
    public static abstract class Builder {
        @RecentlyNonNull
        public OpeningHours build() {
            OpeningHours zza = zza();
            Iterator<String> it = zza.getWeekdayText().iterator();
            while (it.hasNext()) {
                zzmt.zzp(!TextUtils.isEmpty(it.next()), "WeekdayText must not contain null or empty values.");
            }
            setPeriods(zznx.zzj(zza.getPeriods()));
            setWeekdayText(zznx.zzj(zza.getWeekdayText()));
            setSpecialDays(zznx.zzj(zza.getSpecialDays()));
            return zza();
        }

        @RecentlyNullable
        public abstract HoursType getHoursType();

        @RecentlyNonNull
        public abstract List<Period> getPeriods();

        @RecentlyNonNull
        public abstract List<SpecialDay> getSpecialDays();

        @RecentlyNonNull
        public abstract List<String> getWeekdayText();

        @RecentlyNonNull
        public abstract Builder setHoursType(@Nullable HoursType hoursType);

        @RecentlyNonNull
        public abstract Builder setPeriods(@RecentlyNonNull List<Period> list);

        @RecentlyNonNull
        public abstract Builder setSpecialDays(@RecentlyNonNull List<SpecialDay> list);

        @RecentlyNonNull
        public abstract Builder setWeekdayText(@RecentlyNonNull List<String> list);

        abstract OpeningHours zza();
    }

    /* loaded from: classes4.dex */
    public enum HoursType implements Parcelable {
        ACCESS,
        BREAKFAST,
        BRUNCH,
        DELIVERY,
        DINNER,
        DRIVE_THROUGH,
        HAPPY_HOUR,
        KITCHEN,
        LUNCH,
        ONLINE_SERVICE_HOURS,
        PICKUP,
        SENIOR_HOURS,
        TAKEOUT;


        @RecentlyNonNull
        public static final Parcelable.Creator<HoursType> CREATOR = new zzcc();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i11) {
            parcel.writeString(name());
        }
    }

    @RecentlyNonNull
    public static Builder builder() {
        zzq zzqVar = new zzq();
        zzqVar.setPeriods(new ArrayList());
        zzqVar.setSpecialDays(new ArrayList());
        zzqVar.setWeekdayText(new ArrayList());
        return zzqVar;
    }

    @RecentlyNullable
    public abstract HoursType getHoursType();

    @RecentlyNonNull
    public abstract List<Period> getPeriods();

    @RecentlyNonNull
    public abstract List<SpecialDay> getSpecialDays();

    @RecentlyNonNull
    public abstract List<String> getWeekdayText();
}
