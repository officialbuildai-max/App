package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
final class zzbq extends zzac {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzbp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbq(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(getSouthwest(), i11);
        parcel.writeParcelable(getNortheast(), i11);
    }
}
