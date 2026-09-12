package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SplashSignal extends AbsFeedBackForH5 {

    /* renamed from: h, reason: collision with root package name */
    private static String f37656h = "SplashSignal";

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f37657i = 0;

    /* renamed from: g, reason: collision with root package name */
    private b f37658g;

    public void getFileInfo(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a(obj, new JSONObject(str));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        if (obj != null) {
            try {
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
            } catch (Throwable th2) {
                o0.b(f37656h, "handlerH5Exception", th2);
            }
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            c.b(obj, new JSONObject(str));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public void init(Object obj, String str) {
        o0.b(f37656h, "initialize" + str);
        b bVar = this.f37658g;
        if (bVar != null) {
            bVar.init(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof b)) {
                return;
            }
            this.f37658g = (b) windVaneWebView.getObject();
        } catch (Throwable th2) {
            o0.b(f37656h, "initialize", th2);
        }
    }

    public void install(Object obj, String str) {
        b bVar = this.f37658g;
        if (bVar != null) {
            bVar.install(obj, str);
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            o0.b(f37656h, "onSignalCommunication");
            b bVar = this.f37658g;
            if (bVar != null) {
                bVar.c(obj, str);
            }
        } catch (Throwable th2) {
            o0.b(f37656h, "onSignalCommunication", th2);
        }
    }

    public void openURL(Object obj, String str) {
        o0.b(f37656h, "openURL" + str);
        b bVar = this.f37658g;
        if (bVar != null) {
            bVar.openURL(obj, str);
        }
    }

    public void pauseCountDown(Object obj, String str) {
        try {
            o0.b(f37656h, "pauseCountDown");
            b bVar = this.f37658g;
            if (bVar != null) {
                bVar.e(obj, str);
            }
        } catch (Throwable th2) {
            o0.b(f37656h, "pauseCountDown", th2);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, optInt);
            } catch (Throwable th2) {
                o0.b(f37656h, "readyStatus", th2);
            }
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            o0.b(f37656h, "reportUrls");
            b bVar = this.f37658g;
            if (bVar != null) {
                bVar.reportUrls(obj, str);
            }
        } catch (Throwable th2) {
            o0.b(f37656h, "reportUrls", th2);
        }
    }

    public void resetCountdown(Object obj, String str) {
        o0.b(f37656h, "resetCountdown" + str);
        b bVar = this.f37658g;
        if (bVar != null) {
            bVar.a(obj, str);
        }
    }

    public void resumeCountDown(Object obj, String str) {
        try {
            o0.b(f37656h, "resumeCountDown");
            b bVar = this.f37658g;
            if (bVar != null) {
                bVar.f(obj, str);
            }
        } catch (Throwable th2) {
            o0.b(f37656h, "resumeCountDown", th2);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            o0.b(f37656h, "sendImpressions");
            b bVar = this.f37658g;
            if (bVar != null) {
                bVar.d(obj, str);
            }
        } catch (Throwable th2) {
            o0.b(f37656h, "sendImpressions", th2);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        o0.b(f37656h, "toggleCloseBtn" + str);
        b bVar = this.f37658g;
        if (bVar != null) {
            bVar.toggleCloseBtn(obj, str);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        o0.b(f37656h, "triggerCloseBtn" + str);
        b bVar = this.f37658g;
        if (bVar != null) {
            bVar.triggerCloseBtn(obj, str);
        }
    }
}
