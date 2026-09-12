package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
final class zzbg extends zzt {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbf();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(@Nullable TimeOfWeek timeOfWeek, @Nullable TimeOfWeek timeOfWeek2) {
        super(timeOfWeek, timeOfWeek2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(getOpen(), i11);
        parcel.writeParcelable(getClose(), i11);
    }
}
