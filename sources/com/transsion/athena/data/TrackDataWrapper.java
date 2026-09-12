package com.transsion.athena.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class TrackDataWrapper implements Parcelable {
    public static final Parcelable.Creator<TrackDataWrapper> CREATOR = new athena();

    /* renamed from: a, reason: collision with root package name */
    private String f42714a;

    /* renamed from: b, reason: collision with root package name */
    private TrackData f42715b;

    /* renamed from: c, reason: collision with root package name */
    private long f42716c;

    /* loaded from: classes5.dex */
    class athena implements Parcelable.Creator<TrackDataWrapper> {
        athena() {
        }

        @Override // android.os.Parcelable.Creator
        public TrackDataWrapper createFromParcel(Parcel parcel) {
            return new TrackDataWrapper(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrackDataWrapper[] newArray(int i11) {
            return new TrackDataWrapper[i11];
        }
    }

    protected TrackDataWrapper(Parcel parcel) {
        this.f42714a = parcel.readString();
        this.f42715b = (TrackData) parcel.readParcelable(TrackData.class.getClassLoader());
        this.f42716c = parcel.readLong();
    }

    public TrackDataWrapper(String str, TrackData trackData, long j11) {
        this.f42714a = str;
        this.f42715b = trackData;
        this.f42716c = j11;
    }

    public String a() {
        String str = this.f42714a;
        return str == null ? "" : str;
    }

    public long b() {
        return this.f42716c;
    }

    public TrackData c() {
        return this.f42715b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f42714a);
        parcel.writeParcelable(this.f42715b, i11);
        parcel.writeLong(this.f42716c);
    }
}
