package com.mbridge.msdk.splash.view;

import android.content.Context;
import com.iab.omid.library.mmadbridge.adsession.b;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

/* loaded from: classes5.dex */
public class MBSplashWebview extends WindVaneWebView {

    /* renamed from: r, reason: collision with root package name */
    private String f37769r;

    /* renamed from: s, reason: collision with root package name */
    private b f37770s;

    public MBSplashWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void finishAdSession() {
        try {
            b bVar = this.f37770s;
            if (bVar != null) {
                bVar.c();
                this.f37770s = null;
                o0.a("OMSDK", "finish adSession");
            }
        } catch (Exception e11) {
            o0.a("OMSDK", e11.getMessage());
        }
    }

    public b getAdSession() {
        return this.f37770s;
    }

    public String getRequestId() {
        return this.f37769r;
    }

    public void setAdSession(b bVar) {
        this.f37770s = bVar;
    }

    public void setRequestId(String str) {
        this.f37769r = str;
    }
}
