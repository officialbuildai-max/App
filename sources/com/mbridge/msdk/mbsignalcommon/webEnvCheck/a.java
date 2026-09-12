package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f36570a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f36571b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f36572c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.mbsignalcommon.webEnvCheck.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0517a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f36573a;

        RunnableC0517a(Context context) {
            this.f36573a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f36570a == null) {
                try {
                    Boolean unused = a.f36570a = Boolean.valueOf(a.a(this.f36573a));
                } catch (Exception unused2) {
                    Boolean unused3 = a.f36570a = Boolean.FALSE;
                }
            }
        }
    }

    private static void a(WebView webView) {
        try {
            webView.destroy();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("MBWebViewChecker", "destroy webview error", e11);
            }
        }
    }

    public static boolean a(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
            webView.setWebViewClient(new b());
        } catch (Exception unused) {
            webView = null;
        }
        if (webView == null) {
            return false;
        }
        a(webView);
        return true;
    }

    public static boolean b(Context context) {
        g gVar;
        try {
            gVar = h.b().b(c.m().b());
        } catch (Exception unused) {
            gVar = null;
        }
        if (gVar != null) {
            f36572c = Boolean.valueOf(gVar.C0());
        } else {
            f36572c = Boolean.FALSE;
        }
        Boolean bool = f36572c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f36570a == null) {
                try {
                    f36570a = Boolean.valueOf(a(context));
                } catch (Exception unused2) {
                    f36570a = Boolean.FALSE;
                }
            }
            if (f36570a == null) {
                f36570a = new Boolean(false);
            }
            return f36570a.booleanValue();
        }
        if (f36570a == null && f36571b == null) {
            f36571b = new Handler(Looper.getMainLooper());
            f36571b.post(new RunnableC0517a(context));
        }
        if (f36570a == null) {
            return true;
        }
        return f36570a.booleanValue();
    }
}
