package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.R$string;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";

    /* renamed from: a, reason: collision with root package name */
    final int f30150a;

    /* renamed from: b, reason: collision with root package name */
    int f30151b;

    /* renamed from: c, reason: collision with root package name */
    int f30152c;

    /* renamed from: d, reason: collision with root package name */
    int f30153d;

    /* renamed from: e, reason: collision with root package name */
    int f30154e;
    private final e hourInputValidator;
    private final e minuteInputValidator;

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i11) {
            return new TimeModel[i11];
        }
    }

    public TimeModel() {
        this(0);
    }

    public TimeModel(int i11) {
        this(0, 0, 10, i11);
    }

    public TimeModel(int i11, int i12, int i13, int i14) {
        this.f30151b = i11;
        this.f30152c = i12;
        this.f30153d = i13;
        this.f30150a = i14;
        this.f30154e = g(i11);
        this.minuteInputValidator = new e(59);
        this.hourInputValidator = new e(i14 == 1 ? 23 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, ZERO_LEADING_NUMBER_FORMAT);
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int g(int i11) {
        return i11 >= 12 ? 1 : 0;
    }

    public int c() {
        return this.f30150a == 1 ? R$string.material_hour_24h_suffix : R$string.material_hour_suffix;
    }

    public int d() {
        if (this.f30150a == 1) {
            return this.f30151b % 24;
        }
        int i11 = this.f30151b;
        if (i11 % 12 == 0) {
            return 12;
        }
        return this.f30154e == 1 ? i11 - 12 : i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public e e() {
        return this.hourInputValidator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f30151b == timeModel.f30151b && this.f30152c == timeModel.f30152c && this.f30150a == timeModel.f30150a && this.f30153d == timeModel.f30153d;
    }

    public e f() {
        return this.minuteInputValidator;
    }

    public void h(int i11) {
        if (this.f30150a == 1) {
            this.f30151b = i11;
        } else {
            this.f30151b = (i11 % 12) + (this.f30154e != 1 ? 0 : 12);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f30150a), Integer.valueOf(this.f30151b), Integer.valueOf(this.f30152c), Integer.valueOf(this.f30153d)});
    }

    public void i(int i11) {
        this.f30152c = i11 % 60;
    }

    public void j(int i11) {
        if (i11 != this.f30154e) {
            this.f30154e = i11;
            int i12 = this.f30151b;
            if (i12 < 12 && i11 == 1) {
                this.f30151b = i12 + 12;
            } else {
                if (i12 < 12 || i11 != 0) {
                    return;
                }
                this.f30151b = i12 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f30151b);
        parcel.writeInt(this.f30152c);
        parcel.writeInt(this.f30153d);
        parcel.writeInt(this.f30150a);
    }
}
