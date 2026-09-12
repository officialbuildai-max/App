package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    final a f28918a;

    /* renamed from: b, reason: collision with root package name */
    final a f28919b;

    /* renamed from: c, reason: collision with root package name */
    final a f28920c;

    /* renamed from: d, reason: collision with root package name */
    final a f28921d;

    /* renamed from: e, reason: collision with root package name */
    final a f28922e;

    /* renamed from: f, reason: collision with root package name */
    final a f28923f;

    /* renamed from: g, reason: collision with root package name */
    final a f28924g;

    /* renamed from: h, reason: collision with root package name */
    final Paint f28925h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(xa.b.d(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.f28918a = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f28924g = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f28919b = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f28920c = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a11 = xa.c.a(context, obtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f28921d = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f28922e = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f28923f = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f28925h = paint;
        paint.setColor(a11.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
