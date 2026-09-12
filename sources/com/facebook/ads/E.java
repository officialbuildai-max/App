package com.facebook.ads;

import android.app.Activity;
import android.view.View;

/* loaded from: classes.dex */
class E implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f24143a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f24144b;

    E(String str, Activity activity) {
        this.f24144b = str;
        this.f24143a = activity;
    }

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);
}
