package com.transsion.shorttv.base.widget.toast.core;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import gs.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements gs.a {

    /* renamed from: a, reason: collision with root package name */
    private ToastImpl f53026a;

    /* renamed from: b, reason: collision with root package name */
    private View f53027b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f53028c;

    /* renamed from: d, reason: collision with root package name */
    private int f53029d;

    /* renamed from: e, reason: collision with root package name */
    private int f53030e;

    /* renamed from: f, reason: collision with root package name */
    private int f53031f;

    /* renamed from: g, reason: collision with root package name */
    private int f53032g;

    /* renamed from: h, reason: collision with root package name */
    private float f53033h;

    /* renamed from: i, reason: collision with root package name */
    private float f53034i;

    public b(Activity activity) {
        this.f53026a = new ToastImpl(activity, this);
    }

    @Override // gs.a
    public boolean a() {
        return this.f53028c == null;
    }

    public TextView b(View view) {
        return a.C0796a.a(this, view);
    }

    @Override // gs.a
    public void cancel() {
        ToastImpl toastImpl = this.f53026a;
        if (toastImpl != null) {
            toastImpl.e();
        }
    }

    @Override // gs.a
    public int getDuration() {
        return this.f53030e;
    }

    @Override // gs.a
    public int getGravity() {
        return this.f53029d;
    }

    @Override // gs.a
    public float getHorizontalMargin() {
        return this.f53033h;
    }

    @Override // gs.a
    public float getVerticalMargin() {
        return this.f53034i;
    }

    @Override // gs.a
    public View getView() {
        return this.f53027b;
    }

    @Override // gs.a
    public int getXOffset() {
        return this.f53031f;
    }

    @Override // gs.a
    public int getYOffset() {
        return this.f53032g;
    }

    @Override // gs.a
    public void setDuration(int i11) {
        this.f53030e = i11;
    }

    @Override // gs.a
    public void setGravity(int i11, int i12, int i13) {
        this.f53029d = i11;
        this.f53031f = i12;
        this.f53032g = i13;
    }

    @Override // gs.a
    public void setMargin(float f11, float f12) {
        this.f53033h = f11;
        this.f53034i = f12;
    }

    @Override // gs.a
    public void setText(CharSequence charSequence) {
        TextView textView = this.f53028c;
        if (textView == null) {
            return;
        }
        Intrinsics.e(textView);
        textView.setText(charSequence);
    }

    @Override // gs.a
    public void setView(View view) {
        this.f53027b = view;
        if (view == null) {
            this.f53028c = null;
        } else {
            Intrinsics.e(view);
            this.f53028c = b(view);
        }
    }

    @Override // gs.a
    public void show() {
        ToastImpl toastImpl = this.f53026a;
        if (toastImpl != null) {
            toastImpl.h();
        }
    }
}
