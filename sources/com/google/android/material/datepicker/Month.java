package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final int f28896a;

    /* renamed from: b, reason: collision with root package name */
    final int f28897b;

    /* renamed from: c, reason: collision with root package name */
    final int f28898c;

    /* renamed from: d, reason: collision with root package name */
    final int f28899d;

    /* renamed from: e, reason: collision with root package name */
    final long f28900e;

    @NonNull
    private final Calendar firstOfMonth;

    @Nullable
    private String longName;

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i11) {
            return new Month[i11];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar f11 = x.f(calendar);
        this.firstOfMonth = f11;
        this.f28896a = f11.get(2);
        this.f28897b = f11.get(1);
        this.f28898c = f11.getMaximum(7);
        this.f28899d = f11.getActualMaximum(5);
        this.f28900e = f11.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month b(int i11, int i12) {
        Calendar s11 = x.s();
        s11.set(1, i11);
        s11.set(2, i12);
        return new Month(s11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month d(long j11) {
        Calendar s11 = x.s();
        s11.setTimeInMillis(j11);
        return new Month(s11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month e() {
        return new Month(x.q());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f28896a == month.f28896a && this.f28897b == month.f28897b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i11) {
        int i12 = this.firstOfMonth.get(7);
        if (i11 <= 0) {
            i11 = this.firstOfMonth.getFirstDayOfWeek();
        }
        int i13 = i12 - i11;
        return i13 < 0 ? i13 + this.f28898c : i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long g(int i11) {
        Calendar f11 = x.f(this.firstOfMonth);
        f11.set(5, i11);
        return f11.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(long j11) {
        Calendar f11 = x.f(this.firstOfMonth);
        f11.setTimeInMillis(j11);
        return f11.get(5);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f28896a), Integer.valueOf(this.f28897b)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        if (this.longName == null) {
            this.longName = j.l(this.firstOfMonth.getTimeInMillis());
        }
        return this.longName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j() {
        return this.firstOfMonth.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month k(int i11) {
        Calendar f11 = x.f(this.firstOfMonth);
        f11.add(2, i11);
        return new Month(f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l(Month month) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month.f28897b - this.f28897b) * 12) + (month.f28896a - this.f28896a);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f28897b);
        parcel.writeInt(this.f28896a);
    }
}
