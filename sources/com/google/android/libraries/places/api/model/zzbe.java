package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.OpeningHours;
import java.util.List;

/* loaded from: classes4.dex */
final class zzbe extends zzr {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbe(@Nullable OpeningHours.HoursType hoursType, List list, List list2, List list3) {
        super(hoursType, list, list2, list3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(getHoursType(), i11);
        parcel.writeList(getPeriods());
        parcel.writeList(getSpecialDays());
        parcel.writeList(getWeekdayText());
    }
}
