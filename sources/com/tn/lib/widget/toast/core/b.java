package com.tn.lib.widget.toast.core;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import vh.a;

/* loaded from: classes4.dex */
public final class b implements vh.a {

    /* renamed from: a, reason: collision with root package name */
    private ToastImpl f41515a;

    /* renamed from: b, reason: collision with root package name */
    private View f41516b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f41517c;

    /* renamed from: d, reason: collision with root package name */
    private int f41518d;

    /* renamed from: e, reason: collision with root package name */
    private int f41519e;

    /* renamed from: f, reason: collision with root package name */
    private int f41520f;

    /* renamed from: g, reason: collision with root package name */
    private int f41521g;

    /* renamed from: h, reason: collision with root package name */
    private float f41522h;

    /* renamed from: i, reason: collision with root package name */
    private float f41523i;

    public b(Activity activity) {
        this.f41515a = new ToastImpl(activity, this);
    }

    @Override // vh.a
    public boolean a() {
        return this.f41517c == null;
    }

    @Override // vh.a
    public void b(View view) {
        this.f41516b = view;
        if (view == null) {
            this.f41517c = null;
        } else {
            Intrinsics.e(view);
            this.f41517c = d(view);
        }
    }

    @Override // vh.a
    public View c() {
        return this.f41516b;
    }

    @Override // vh.a
    public void cancel() {
        ToastImpl toastImpl = this.f41515a;
        if (toastImpl != null) {
            toastImpl.e();
        }
    }

    public TextView d(View view) {
        return a.C0978a.a(this, view);
    }

    public final void e(View view) {
        Intrinsics.h(view, "view");
        this.f41516b = view;
    }

    @Override // vh.a
    public int getDuration() {
        return this.f41519e;
    }

    @Override // vh.a
    public int getGravity() {
        return this.f41518d;
    }

    @Override // vh.a
    public float getHorizontalMargin() {
        return this.f41522h;
    }

    @Override // vh.a
    public float getVerticalMargin() {
        return this.f41523i;
    }

    @Override // vh.a
    public int getXOffset() {
        return this.f41520f;
    }

    @Override // vh.a
    public int getYOffset() {
        return this.f41521g;
    }

    @Override // vh.a
    public void setDuration(int i11) {
        this.f41519e = i11;
    }

    @Override // vh.a
    public void setGravity(int i11, int i12, int i13) {
        this.f41518d = i11;
        this.f41520f = i12;
        this.f41521g = i13;
    }

    @Override // vh.a
    public void setMargin(float f11, float f12) {
        this.f41522h = f11;
        this.f41523i = f12;
    }

    @Override // vh.a
    public void setText(CharSequence charSequence) {
        TextView textView = this.f41517c;
        if (textView == null) {
            return;
        }
        Intrinsics.e(textView);
        textView.setText(charSequence);
    }

    @Override // vh.a
    public void show() {
        ToastImpl toastImpl = this.f41515a;
        if (toastImpl != null) {
            toastImpl.h();
        }
    }
}
