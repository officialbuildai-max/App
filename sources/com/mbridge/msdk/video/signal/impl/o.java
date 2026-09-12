package com.mbridge.msdk.video.signal.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class o extends p {

    /* renamed from: a, reason: collision with root package name */
    private Activity f39907a;

    /* renamed from: b, reason: collision with root package name */
    private MBridgeContainerView f39908b;

    public o(Activity activity, MBridgeContainerView mBridgeContainerView) {
        this.f39907a = activity;
        this.f39908b = mBridgeContainerView;
    }

    private String a(List<CampaignEx> list, String str, String str2, JSONObject jSONObject) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Object parseCamplistToJson = CampaignEx.parseCamplistToJson(list);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("campaignList", parseCamplistToJson);
                    a(jSONObject2);
                    jSONObject2.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    jSONObject2.put("sdk_info", str2);
                    jSONObject2.put("unitSetting", jSONObject);
                    if (com.mbridge.msdk.setting.h.b() != null) {
                        String e11 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
                        if (!TextUtils.isEmpty(e11)) {
                            JSONObject jSONObject3 = new JSONObject(e11);
                            a(jSONObject3, str);
                            String c11 = com.mbridge.msdk.setting.h.b().c(str);
                            if (!TextUtils.isEmpty(c11)) {
                                jSONObject3.put("ivreward", new JSONObject(c11));
                            }
                            jSONObject2.put("appSetting", jSONObject3);
                        }
                    }
                    return jSONObject2.toString();
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        return null;
    }

    private void a(JSONObject jSONObject, String str) {
        try {
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            String obj = w0.a(d11, "MBridge_ConfirmTitle" + str, "").toString();
            String obj2 = w0.a(d11, "MBridge_ConfirmContent" + str, "").toString();
            String obj3 = w0.a(d11, "MBridge_CancelText" + str, "").toString();
            String obj4 = w0.a(d11, "MBridge_ConfirmText" + str, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                jSONObject.put("confirm_title", obj);
            }
            if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put("confirm_description", obj2);
            }
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put("confirm_t", obj3);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_play", obj4);
            }
            if (TextUtils.isEmpty(obj4)) {
                return;
            }
            jSONObject.put("confirm_c_rv", obj4);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private com.mbridge.msdk.videocommon.setting.c b(String str) {
        if (com.mbridge.msdk.videocommon.setting.b.b() == null) {
            return null;
        }
        return com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), str);
    }

    @Override // com.mbridge.msdk.video.signal.impl.g, com.mbridge.msdk.video.signal.i
    public void a(String str) {
        super.a(str);
        try {
            if (this.f39907a != null && !TextUtils.isEmpty(str)) {
                if (str.equals(TmcStartParams.KEY_LANDSCAPE)) {
                    this.f39907a.setRequestedOrientation(0);
                } else if (str.equals("portrait")) {
                    this.f39907a.setRequestedOrientation(1);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.g, com.mbridge.msdk.video.signal.i
    public String b() {
        if (this.f39908b == null) {
            super.b();
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f39908b.getCampaign());
                String unitID = this.f39908b.getUnitID();
                com.mbridge.msdk.videocommon.setting.c b11 = b(unitID);
                JSONObject jSONObject = new JSONObject();
                if (b11 != null) {
                    jSONObject = b11.H();
                }
                o0.a("JSRewardVideoV1", "getEndScreenInfo success campaign = " + this.f39908b.getCampaign());
                return a(arrayList, unitID, "MAL_16.9.71,3.0.1", jSONObject);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return super.b();
    }

    @Override // com.mbridge.msdk.video.signal.impl.g, com.mbridge.msdk.video.signal.i
    public void handlerPlayableException(String str) {
        MBridgeContainerView mBridgeContainerView;
        super.handlerPlayableException(str);
        try {
            if (this.f39907a == null || TextUtils.isEmpty(str) || (mBridgeContainerView = this.f39908b) == null) {
                return;
            }
            mBridgeContainerView.handlerPlayableException(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.g, com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i11) {
        super.notifyCloseBtn(i11);
        MBridgeContainerView mBridgeContainerView = this.f39908b;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.notifyCloseBtn(i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.g, com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i11) {
        super.toggleCloseBtn(i11);
        MBridgeContainerView mBridgeContainerView = this.f39908b;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.toggleCloseBtn(i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.g, com.mbridge.msdk.video.signal.i
    public void triggerCloseBtn(String str) {
        MBridgeContainerView mBridgeContainerView;
        super.triggerCloseBtn(str);
        try {
            if (this.f39907a == null || TextUtils.isEmpty(str) || !str.equals("click") || (mBridgeContainerView = this.f39908b) == null) {
                return;
            }
            mBridgeContainerView.triggerCloseBtn(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
