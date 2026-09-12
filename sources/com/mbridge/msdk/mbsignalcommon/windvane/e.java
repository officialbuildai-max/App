package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import com.mbridge.msdk.interstitial.signalcommon.interstitial;
import com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin;
import com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal;
import com.mbridge.msdk.splash.signal.SplashSignal;
import com.mbridge.msdk.video.signal.communication.RewardSignal;
import com.mbridge.msdk.video.signal.communication.VideoCommunication;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, Class> f36613d = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private Context f36614a;

    /* renamed from: b, reason: collision with root package name */
    private Object f36615b;

    /* renamed from: c, reason: collision with root package name */
    private WindVaneWebView f36616c;

    public e(Context context, WindVaneWebView windVaneWebView) {
        this.f36614a = context;
        this.f36616c = windVaneWebView;
        a();
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = f36613d.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!g.class.isAssignableFrom(cls)) {
                return null;
            }
            g gVar = (g) cls.newInstance();
            gVar.initialize(context, windVaneWebView);
            gVar.initialize(this.f36615b, windVaneWebView);
            return gVar;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public Object a(String str) {
        if (f36613d == null) {
            f36613d = new HashMap<>();
        }
        return a(str, this.f36616c, this.f36614a);
    }

    public void a() {
        try {
            int i11 = interstitial.f35998i;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f36486a, interstitial.class);
        } catch (ClassNotFoundException unused) {
        }
        try {
            int i12 = RewardSignal.f39556i;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f36487b, RewardSignal.class);
        } catch (ClassNotFoundException unused2) {
        }
        try {
            int i13 = VideoCommunication.f39582j;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f36488c, VideoCommunication.class);
        } catch (ClassNotFoundException unused3) {
        }
        try {
            int i14 = MraidSignalCommunication.f36557h;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f36490e, MraidSignalCommunication.class);
        } catch (ClassNotFoundException unused4) {
        }
        try {
            int i15 = BannerSignalPlugin.f36545i;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f36491f, BannerSignalPlugin.class);
        } catch (ClassNotFoundException unused5) {
        }
        try {
            int i16 = SplashSignal.f37657i;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f36492g, SplashSignal.class);
        } catch (ClassNotFoundException unused6) {
        }
        try {
            int i17 = WebGLCheckSignal.f36569g;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f36493h, WebGLCheckSignal.class);
        } catch (ClassNotFoundException unused7) {
        }
        try {
            if (com.mbridge.msdk.util.b.a()) {
                Class<?> cls = Class.forName("com.mbridge.msdk.mbsignalcommon.confirmation.bridge.ConfirmationJsBridgePlugin");
                a(cls.getSimpleName(), cls);
            }
        } catch (Exception unused8) {
        }
    }

    public void a(Context context) {
        this.f36614a = context;
    }

    public void a(Object obj) {
        this.f36615b = obj;
    }

    public void a(String str, Class cls) {
        if (f36613d == null) {
            f36613d = new HashMap<>();
        }
        f36613d.put(str, cls);
    }
}
