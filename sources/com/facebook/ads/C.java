package com.facebook.ads;

import android.app.Activity;
import org.json.JSONObject;

/* loaded from: classes.dex */
class C implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f24139a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Activity f24140b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ JSONObject f24141c;

    C(B b11, Activity activity, JSONObject jSONObject) {
        this.f24139a = b11;
        this.f24140b = activity;
        this.f24141c = jSONObject;
    }

    @Override // java.lang.Runnable
    public native void run();
}
