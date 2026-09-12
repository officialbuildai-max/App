package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;

/* loaded from: classes4.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f28912a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f28913b;

    /* renamed from: c, reason: collision with root package name */
    private final ColorStateList f28914c;

    /* renamed from: d, reason: collision with root package name */
    private final ColorStateList f28915d;

    /* renamed from: e, reason: collision with root package name */
    private final int f28916e;

    /* renamed from: f, reason: collision with root package name */
    private final ab.n f28917f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i11, ab.n nVar, Rect rect) {
        androidx.core.util.i.d(rect.left);
        androidx.core.util.i.d(rect.top);
        androidx.core.util.i.d(rect.right);
        androidx.core.util.i.d(rect.bottom);
        this.f28912a = rect;
        this.f28913b = colorStateList2;
        this.f28914c = colorStateList;
        this.f28915d = colorStateList3;
        this.f28916e = i11;
        this.f28917f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context, int i11) {
        androidx.core.util.i.b(i11 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i11, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a11 = xa.c.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList a12 = xa.c.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList a13 = xa.c.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ab.n m11 = ab.n.b(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        obtainStyledAttributes.recycle();
        return new a(a11, a12, a13, dimensionPixelSize, m11, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f28912a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f28912a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView) {
        e(textView, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        ab.i iVar = new ab.i();
        ab.i iVar2 = new ab.i();
        iVar.setShapeAppearanceModel(this.f28917f);
        iVar2.setShapeAppearanceModel(this.f28917f);
        if (colorStateList == null) {
            colorStateList = this.f28914c;
        }
        iVar.d0(colorStateList);
        iVar.m0(this.f28916e, this.f28915d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f28913b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f28913b.withAlpha(30), iVar, iVar2);
        Rect rect = this.f28912a;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
