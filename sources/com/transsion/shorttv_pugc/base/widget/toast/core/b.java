package com.transsion.shorttv_pugc.base.widget.toast.core;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import lt.a;

/* loaded from: classes6.dex */
public final class b implements lt.a {

    /* renamed from: a, reason: collision with root package name */
    private ToastImpl f54006a;

    /* renamed from: b, reason: collision with root package name */
    private View f54007b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f54008c;

    /* renamed from: d, reason: collision with root package name */
    private int f54009d;

    /* renamed from: e, reason: collision with root package name */
    private int f54010e;

    /* renamed from: f, reason: collision with root package name */
    private int f54011f;

    /* renamed from: g, reason: collision with root package name */
    private int f54012g;

    /* renamed from: h, reason: collision with root package name */
    private float f54013h;

    /* renamed from: i, reason: collision with root package name */
    private float f54014i;

    public b(Activity activity) {
        this.f54006a = new ToastImpl(activity, this);
    }

    @Override // lt.a
    public boolean a() {
        return this.f54008c == null;
    }

    public TextView b(View view) {
        return a.C0861a.a(this, view);
    }

    @Override // lt.a
    public void cancel() {
        ToastImpl toastImpl = this.f54006a;
        if (toastImpl != null) {
            toastImpl.e();
        }
    }

    @Override // lt.a
    public int getDuration() {
        return this.f54010e;
    }

    @Override // lt.a
    public int getGravity() {
        return this.f54009d;
    }

    @Override // lt.a
    public float getHorizontalMargin() {
        return this.f54013h;
    }

    @Override // lt.a
    public float getVerticalMargin() {
        return this.f54014i;
    }

    @Override // lt.a
    public View getView() {
        return this.f54007b;
    }

    @Override // lt.a
    public int getXOffset() {
        return this.f54011f;
    }

    @Override // lt.a
    public int getYOffset() {
        return this.f54012g;
    }

    @Override // lt.a
    public void setDuration(int i11) {
        this.f54010e = i11;
    }

    @Override // lt.a
    public void setGravity(int i11, int i12, int i13) {
        this.f54009d = i11;
        this.f54011f = i12;
        this.f54012g = i13;
    }

    @Override // lt.a
    public void setMargin(float f11, float f12) {
        this.f54013h = f11;
        this.f54014i = f12;
    }

    @Override // lt.a
    public void setText(CharSequence charSequence) {
        TextView textView = this.f54008c;
        if (textView == null) {
            return;
        }
        Intrinsics.e(textView);
        textView.setText(charSequence);
    }

    @Override // lt.a
    public void setView(View view) {
        this.f54007b = view;
        if (view == null) {
            this.f54008c = null;
        } else {
            Intrinsics.e(view);
            this.f54008c = b(view);
        }
    }

    @Override // lt.a
    public void show() {
        ToastImpl toastImpl = this.f54006a;
        if (toastImpl != null) {
            toastImpl.h();
        }
    }
}
