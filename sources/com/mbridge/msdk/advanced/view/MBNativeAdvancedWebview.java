package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.IntentFilter;
import com.iab.omid.library.mmadbridge.adsession.b;
import com.mbridge.msdk.advanced.common.NetWorkStateReceiver;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

/* loaded from: classes5.dex */
public class MBNativeAdvancedWebview extends WindVaneWebView {

    /* renamed from: t, reason: collision with root package name */
    private static final String f34307t = "MBNativeAdvancedWebview";

    /* renamed from: r, reason: collision with root package name */
    private b f34308r;

    /* renamed from: s, reason: collision with root package name */
    private NetWorkStateReceiver f34309s;

    public MBNativeAdvancedWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void finishAdSession() {
        try {
            b bVar = this.f34308r;
            if (bVar != null) {
                bVar.c();
                this.f34308r = null;
                o0.a("OMSDK", "finish adSession");
            }
        } catch (Exception e11) {
            o0.a("OMSDK", e11.getMessage());
        }
    }

    public b getAdSession() {
        return this.f34308r;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerNetWorkReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterNetWorkReceiver();
    }

    public void registerNetWorkReceiver() {
        try {
            if (this.f34309s == null) {
                this.f34309s = new NetWorkStateReceiver(this);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getContext().registerReceiver(this.f34309s, intentFilter);
        } catch (Throwable th2) {
            o0.a(f34307t, th2.getMessage());
        }
    }

    public void setAdSession(b bVar) {
        this.f34308r = bVar;
    }

    public void unregisterNetWorkReceiver() {
        try {
            NetWorkStateReceiver netWorkStateReceiver = this.f34309s;
            if (netWorkStateReceiver != null) {
                netWorkStateReceiver.a();
                getContext().unregisterReceiver(this.f34309s);
            }
        } catch (Throwable th2) {
            o0.a(f34307t, th2.getMessage());
        }
    }
}
