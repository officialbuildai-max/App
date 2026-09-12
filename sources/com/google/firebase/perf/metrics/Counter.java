package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class Counter implements Parcelable {
    public static final Parcelable.Creator<Counter> CREATOR = new a();
    private final AtomicLong count;
    private final String name;

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Counter createFromParcel(Parcel parcel) {
            return new Counter(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Counter[] newArray(int i11) {
            return new Counter[i11];
        }
    }

    private Counter(Parcel parcel) {
        this.name = parcel.readString();
        this.count = new AtomicLong(parcel.readLong());
    }

    /* synthetic */ Counter(Parcel parcel, a aVar) {
        this(parcel);
    }

    public Counter(@NonNull String str) {
        this.name = str;
        this.count = new AtomicLong(0L);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCount() {
        return this.count.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String getName() {
        return this.name;
    }

    public void increment(long j11) {
        this.count.addAndGet(j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCount(long j11) {
        this.count.set(j11);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.name);
        parcel.writeLong(this.count.get());
    }
}
