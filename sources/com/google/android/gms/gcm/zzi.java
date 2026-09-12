package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzi implements Parcelable.Creator<OneoffTask> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ OneoffTask createFromParcel(Parcel parcel) {
        return new OneoffTask(parcel, (zzi) null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ OneoffTask[] newArray(int i11) {
        return new OneoffTask[i11];
    }
}
