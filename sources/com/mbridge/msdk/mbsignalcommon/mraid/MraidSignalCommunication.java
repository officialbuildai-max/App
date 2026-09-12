package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MraidSignalCommunication extends BaseMraidSignalCommunication {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f36557h = 0;

    /* renamed from: g, reason: collision with root package name */
    private b f36558g;

    public void close(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b, "close");
        }
        try {
            o0.b("MraidSignalCommunication", "MRAID close");
            b bVar = this.f36558g;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable th2) {
            o0.b("MraidSignalCommunication", "MRAID close", th2);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("shouldUseCustomClose");
            o0.b("MraidSignalCommunication", "MRAID expand " + optString + " " + optString2);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.f36558g == null) {
                return;
            }
            this.f36558g.expand(optString, optString2.toLowerCase().equals("true"));
        } catch (Throwable th2) {
            o0.b("MraidSignalCommunication", "MRAID expand", th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.f36558g = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.f36558g = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof b)) {
                return;
            }
            this.f36558g = (b) windVaneWebView.getMraidObject();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            windVaneWebView = aVar.f36595b;
            a.a().b(aVar.f36595b, MRAIDPresenter.OPEN);
        } else {
            windVaneWebView = null;
        }
        try {
            String optString = new JSONObject(str).optString("url");
            o0.b("MraidSignalCommunication", "MRAID Open " + optString);
            if (this.f36558g == null || TextUtils.isEmpty(optString)) {
                return;
            }
            if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= com.mbridge.msdk.click.utils.a.f34500c || !com.mbridge.msdk.click.utils.a.a(this.f36558g.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.utils.a.f34498a)) {
                this.f36558g.open(optString);
            }
        } catch (Throwable th2) {
            o0.b("MraidSignalCommunication", "MRAID Open", th2);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        String str2;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b, MRAIDPresenter.SET_ORIENTATION_PROPERTIES);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("allowOrientationChange");
            String optString2 = jSONObject.optString("forceOrientation");
            o0.b("MraidSignalCommunication", "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.f36558g == null) {
                return;
            }
            optString.toLowerCase().equals("true");
            String lowerCase = optString2.toLowerCase();
            int hashCode = lowerCase.hashCode();
            if (hashCode == 729267099) {
                str2 = "portrait";
            } else if (hashCode != 1430647483) {
                return;
            } else {
                str2 = TmcStartParams.KEY_LANDSCAPE;
            }
            lowerCase.equals(str2);
        } catch (Throwable th2) {
            o0.b("MraidSignalCommunication", "MRAID setOrientationProperties", th2);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b, "unload");
        }
        try {
            o0.b("MraidSignalCommunication", "MRAID unload");
            b bVar = this.f36558g;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable th2) {
            o0.b("MraidSignalCommunication", "MRAID unload", th2);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b, "useCustomClose");
        }
        try {
            String optString = new JSONObject(str).optString("shouldUseCustomClose");
            o0.b("MraidSignalCommunication", "MRAID useCustomClose " + optString);
            if (TextUtils.isEmpty(optString) || this.f36558g == null) {
                return;
            }
            this.f36558g.useCustomClose(optString.toLowerCase().equals("true"));
        } catch (Throwable th2) {
            o0.b("MraidSignalCommunication", "MRAID useCustomClose", th2);
        }
    }
}
