package com.mbridge.msdk.advanced.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class NetWorkStateReceiver extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    private static final String f34092c = "NetWorkStateReceiver";

    /* renamed from: a, reason: collision with root package name */
    private WebView f34093a;

    /* renamed from: b, reason: collision with root package name */
    private int f34094b;

    public NetWorkStateReceiver(WebView webView) {
        this.f34093a = webView;
    }

    public void a() {
        this.f34093a = null;
    }

    public void a(WebView webView, int i11) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i11);
                f.a().a(webView, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th2) {
                o0.a(f34092c, th2.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a(this.f34093a, 0);
                return;
            }
            if (!com.mbridge.msdk.foundation.same.a.f35408z) {
                a(this.f34093a, 0);
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                a(this.f34093a, 0);
                return;
            }
            if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTING && activeNetworkInfo.getState() != NetworkInfo.State.DISCONNECTING) {
                if (activeNetworkInfo.getType() == 1) {
                    a(this.f34093a, 9);
                    return;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    a(this.f34093a, 0);
                    return;
                }
                int networkType = telephonyManager.getNetworkType();
                this.f34094b = networkType;
                int c11 = k0.c(networkType);
                this.f34094b = c11;
                a(this.f34093a, c11);
            }
        } catch (Throwable th2) {
            o0.a(f34092c, th2.getMessage());
        }
    }
}
