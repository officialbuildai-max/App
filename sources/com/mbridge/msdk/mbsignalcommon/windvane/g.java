package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;

/* loaded from: classes5.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    protected Context f36618a;

    /* renamed from: b, reason: collision with root package name */
    protected Object f36619b;

    /* renamed from: c, reason: collision with root package name */
    protected WindVaneWebView f36620c;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.f36618a = context;
        this.f36620c = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.f36619b = obj;
        this.f36620c = windVaneWebView;
    }
}
