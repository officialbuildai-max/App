package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    @NonNull
    private final Month end;
    private final int firstDayOfWeek;
    private final int monthSpan;

    @Nullable
    private Month openAt;

    @NonNull
    private final Month start;

    @NonNull
    private final DateValidator validator;
    private final int yearSpan;

    /* loaded from: classes4.dex */
    public interface DateValidator extends Parcelable {
        boolean isValid(long j11);
    }

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i11) {
            return new CalendarConstraints[i11];
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        static final long f28815f = x.a(Month.b(1900, 0).f28900e);

        /* renamed from: g, reason: collision with root package name */
        static final long f28816g = x.a(Month.b(2100, 11).f28900e);

        /* renamed from: a, reason: collision with root package name */
        private long f28817a;

        /* renamed from: b, reason: collision with root package name */
        private long f28818b;

        /* renamed from: c, reason: collision with root package name */
        private Long f28819c;

        /* renamed from: d, reason: collision with root package name */
        private int f28820d;

        /* renamed from: e, reason: collision with root package name */
        private DateValidator f28821e;

        public b() {
            this.f28817a = f28815f;
            this.f28818b = f28816g;
            this.f28821e = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(CalendarConstraints calendarConstraints) {
            this.f28817a = f28815f;
            this.f28818b = f28816g;
            this.f28821e = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.f28817a = calendarConstraints.start.f28900e;
            this.f28818b = calendarConstraints.end.f28900e;
            this.f28819c = Long.valueOf(calendarConstraints.openAt.f28900e);
            this.f28820d = calendarConstraints.firstDayOfWeek;
            this.f28821e = calendarConstraints.validator;
        }

        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f28821e);
            Month d11 = Month.d(this.f28817a);
            Month d12 = Month.d(this.f28818b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l11 = this.f28819c;
            return new CalendarConstraints(d11, d12, dateValidator, l11 == null ? null : Month.d(l11.longValue()), this.f28820d, null);
        }

        public b b(long j11) {
            this.f28819c = Long.valueOf(j11);
            return this;
        }
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3, int i11) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.firstDayOfWeek = i11;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i11 < 0 || i11 > x.s().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.monthSpan = month.l(month2) + 1;
        this.yearSpan = (month2.f28897b - month.f28897b) + 1;
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i11, a aVar) {
        this(month, month2, dateValidator, month3, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month clamp(Month month) {
        return month.compareTo(this.start) < 0 ? this.start : month.compareTo(this.end) > 0 ? this.end : month;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && androidx.core.util.d.a(this.openAt, calendarConstraints.openAt) && this.firstDayOfWeek == calendarConstraints.firstDayOfWeek && this.validator.equals(calendarConstraints.validator);
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public long getEndMs() {
        return this.end.f28900e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMonthSpan() {
        return this.monthSpan;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    @Nullable
    public Long getOpenAtMs() {
        Month month = this.openAt;
        if (month == null) {
            return null;
        }
        return Long.valueOf(month.f28900e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month getStart() {
        return this.start;
    }

    public long getStartMs() {
        return this.start.f28900e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, Integer.valueOf(this.firstDayOfWeek), this.validator});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isWithinBounds(long j11) {
        if (this.start.g(1) <= j11) {
            Month month = this.end;
            if (j11 <= month.g(month.f28899d)) {
                return true;
            }
        }
        return false;
    }

    void setOpenAt(@Nullable Month month) {
        this.openAt = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
        parcel.writeInt(this.firstDayOfWeek);
    }
}
