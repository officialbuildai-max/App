package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes4.dex */
final class zzaq extends zzf {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(List list) {
        super(list);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeList(asList());
    }
}
