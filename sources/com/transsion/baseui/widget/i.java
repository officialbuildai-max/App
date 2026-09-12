package com.transsion.baseui.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes5.dex */
public class i extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    private float f43703a;

    /* renamed from: b, reason: collision with root package name */
    private int f43704b = 0;

    public i(float f11) {
        this.f43703a = f11;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        view.getGlobalVisibleRect(new Rect());
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = this.f43704b;
        outline.setRoundRect(i11 == 1 ? new Rect(0, 0, (int) Math.ceil(measuredWidth + (this.f43703a * 2.0f)), measuredHeight) : i11 == 2 ? new Rect((int) Math.floor(this.f43703a * (-2.0f)), 0, measuredWidth, measuredHeight) : i11 == 3 ? new Rect(0, 0, measuredWidth, (int) Math.ceil(measuredHeight + (this.f43703a * 2.0f))) : i11 == 4 ? new Rect(0, (int) Math.floor(this.f43703a * (-2.0f)), measuredWidth, measuredHeight) : new Rect(0, 0, measuredWidth, measuredHeight), this.f43703a);
    }
}
