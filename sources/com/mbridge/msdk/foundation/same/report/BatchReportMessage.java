package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f35571a;

    /* renamed from: b, reason: collision with root package name */
    private long f35572b;

    /* renamed from: c, reason: collision with root package name */
    private String f35573c;

    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<BatchReportMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchReportMessage createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchReportMessage[] newArray(int i11) {
            return new BatchReportMessage[i11];
        }
    }

    protected BatchReportMessage(Parcel parcel) {
        this.f35573c = parcel.readString();
        this.f35571a = parcel.readString();
        this.f35572b = parcel.readLong();
    }

    public BatchReportMessage(String str, String str2, long j11) {
        this.f35573c = str;
        this.f35571a = str2;
        this.f35572b = j11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.f35571a;
    }

    public long getTimestamp() {
        return this.f35572b;
    }

    public String getUuid() {
        return this.f35573c;
    }

    public void setReportMessage(String str) {
        this.f35571a = str;
    }

    public void setTimestamp(long j11) {
        this.f35572b = j11;
    }

    public void setUuid(String str) {
        this.f35573c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f35573c);
        parcel.writeString(this.f35571a);
        parcel.writeLong(this.f35572b);
    }
}
