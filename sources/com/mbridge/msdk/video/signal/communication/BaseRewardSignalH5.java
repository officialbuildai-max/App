package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class BaseRewardSignalH5 extends a {

    /* renamed from: a, reason: collision with root package name */
    protected IJSFactory f39553a;

    private String a(int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i11);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
        } catch (Throwable unused) {
            o0.b("JS-Reward-Communication", "code to string is error");
        }
        return "";
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) {
        o0.a("JS-Reward-Communication", "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String optString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(optString)) {
                    d.a(obj, "packageName is empty");
                }
                int i11 = t0.c(c.m().d(), optString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", d.f36550b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i11);
                    jSONObject.put("data", jSONObject2);
                    f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    d.a(obj, e11.getMessage());
                    o0.a("JS-Reward-Communication", e11.getMessage());
                }
            } catch (Throwable th2) {
                d.a(obj, "exception: " + th2.getLocalizedMessage());
                o0.b("JS-Reward-Communication", "cai", th2);
            }
        } catch (JSONException e12) {
            d.a(obj, "exception: " + e12.getLocalizedMessage());
            o0.b("JS-Reward-Communication", "cai", e12);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        String str2;
        try {
            IJSFactory iJSFactory = this.f39553a;
            if (iJSFactory != null) {
                String b11 = iJSFactory.getIJSRewardVideoV1().b();
                if (TextUtils.isEmpty(b11)) {
                    str2 = "";
                    o0.a("JS-Reward-Communication", "getEndScreenInfo failed");
                } else {
                    str2 = Base64.encodeToString(b11.getBytes(), 2);
                    o0.a("JS-Reward-Communication", "getEndScreenInfo success");
                }
                f.a().b(obj, str2);
            }
        } catch (Throwable th2) {
            o0.b("JS-Reward-Communication", "getEndScreenInfo", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f39553a == null || TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString(NotificationCompat.CATEGORY_MESSAGE);
            o0.a("JS-Reward-Communication", "handlerPlayableException,msg:" + str);
            this.f39553a.getIJSRewardVideoV1().handlerPlayableException(optString);
        } catch (Throwable th2) {
            o0.b("JS-Reward-Communication", "setOrientation", th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        if (context instanceof IJSFactory) {
            this.f39553a = (IJSFactory) context;
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        if (obj instanceof IJSFactory) {
            this.f39553a = (IJSFactory) obj;
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        try {
            if (this.f39553a != null) {
                o0.a("JS-Reward-Communication", "install:" + str);
                if (this.f39553a.getJSContainerModule().endCardShowing()) {
                    this.f39553a.getJSCommon().click(3, str);
                } else {
                    this.f39553a.getJSCommon().click(1, str);
                }
            }
        } catch (Throwable th2) {
            o0.b("JS-Reward-Communication", "install", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f39553a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            o0.a("JS-Reward-Communication", "notifyCloseBtn,state:" + str);
            this.f39553a.getIJSRewardVideoV1().notifyCloseBtn(optInt);
        } catch (Throwable th2) {
            o0.b("JS-Reward-Communication", "notifyCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        o0.b("JS-Reward-Communication", "openURL:" + str);
        Context d11 = c.m().d();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (d11 == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                    d11 = windVaneWebView.getContext();
                }
            } catch (Exception e11) {
                o0.b("JS-Reward-Communication", e11.getMessage());
            }
        }
        if (d11 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
            if (optInt == 1) {
                com.mbridge.msdk.click.c.c(d11, optString);
            } else if (optInt == 2) {
                com.mbridge.msdk.click.c.e(d11, optString);
            }
        } catch (JSONException e12) {
            o0.b("JS-Reward-Communication", e12.getMessage());
        } catch (Throwable th2) {
            o0.b("JS-Reward-Communication", th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f39553a == null || TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString("state");
            o0.a("JS-Reward-Communication", "setOrientation,state:" + str);
            this.f39553a.getIJSRewardVideoV1().a(optString);
        } catch (Throwable th2) {
            o0.b("JS-Reward-Communication", "setOrientation", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f39553a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            o0.a("JS-Reward-Communication", "toggleCloseBtn,state:" + str);
            this.f39553a.getIJSRewardVideoV1().toggleCloseBtn(optInt);
        } catch (Throwable th2) {
            o0.b("JS-Reward-Communication", "toggleCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f39553a == null || TextUtils.isEmpty(str)) {
                return;
            }
            f.a().b(obj, a(0));
            this.f39553a.getIJSRewardVideoV1().triggerCloseBtn(new JSONObject(str).optString("state"));
            o0.a("JS-Reward-Communication", "triggerCloseBtn,state:" + str);
        } catch (Throwable th2) {
            o0.b("JS-Reward-Communication", "triggerCloseBtn", th2);
            f.a().b(obj, a(-1));
        }
    }
}
