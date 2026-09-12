package com.mbridge.msdk.scheme.applet;

import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.exception.a;
import com.mbridge.msdk.foundation.same.net.utils.d;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.scheme.report.AppletsReport;
import com.mbridge.msdk.scheme.request.AppletSchemeRequest;
import com.mbridge.msdk.scheme.response.AppletSchemeResponse;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class AppletsModel implements Serializable {
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_0 = "0";
    private static final String DYNAMIC_VIEW_WX_IS_REDIRECT_1 = "1";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_EVENT_CALLBACK = "event_callback";
    private static final String DYNAMIC_VIEW_WX_QUERY_PARAM_INSTALL_CALLBACK = "install_callback";
    public static final int REQUEST_TYPE_CLICK = 1;
    public static final int REQUEST_TYPE_SHOW = 0;
    private static String TAG = "AppletsModel";
    private static final String URL_ENCODE_UTF_8 = "UTF-8";
    private static final String WX_MINIPROGRAM = "wx_miniprogram";
    private static final int WX_SCHEME_REQUEST_ERROR_CODE_44993 = 44993;
    private volatile IAppletSchemeCallBack appletSchemeCallBack;
    private final CampaignEx campaignEx;
    private String deepLink = "";
    private volatile boolean isRequestSuccess = false;
    private boolean isRequestTimesMaxPerDay = false;
    private volatile boolean isRequesting = false;
    private boolean isSupportWxScheme = false;
    private boolean isUserClick = false;
    private int lastRequestType = -1;
    private Map<String, String> params;
    private String reBuildClickUrl;
    private final String requestId;
    private final String unitID;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class DefaultAppletSchemeResponse extends AppletSchemeResponse {
        private AppletsModel appletsModel;

        public DefaultAppletSchemeResponse(AppletsModel appletsModel) {
            this.appletsModel = appletsModel;
        }

        @Override // com.mbridge.msdk.scheme.response.AppletSchemeResponse, com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
        public void onError(a aVar) {
            super.onError(aVar);
            AppletsModel appletsModel = this.appletsModel;
            if (appletsModel == null) {
                return;
            }
            appletsModel.changeRequestingState(false);
            this.appletsModel.handlerSchemeRequestNetworkError(aVar);
        }

        @Override // com.mbridge.msdk.scheme.response.AppletSchemeResponse, com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
        public void onSuccess(e<JSONObject> eVar) {
            super.onSuccess(eVar);
            AppletsModel appletsModel = this.appletsModel;
            if (appletsModel == null) {
                return;
            }
            appletsModel.changeRequestingState(false);
            if (eVar == null || eVar.f35482c == null) {
                this.appletsModel.handlerRequestNetworkError();
                return;
            }
            try {
                this.appletsModel.handlerSchemeRequestResult(eVar);
            } catch (SchemeRequestException e11) {
                this.appletsModel.handlerSchemeRequestFailed(-2, e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SchemeRequestException extends Exception {
        public SchemeRequestException(String str) {
            super(str);
        }
    }

    public AppletsModel(CampaignEx campaignEx, String str, String str2) {
        this.campaignEx = campaignEx;
        this.unitID = str;
        this.requestId = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeRequestingState(boolean z10) {
        this.isRequesting = z10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:11|(8:12|13|(4:15|16|(2:44|45)(10:20|21|22|23|(2:34|35)|27|28|(1:30)|31|32)|33)(1:52)|46|47|48|(1:50)|51)|53|54|55|(14:101|58|59|60|(9:94|63|64|65|(4:87|68|69|70)|67|68|69|70)|62|63|64|65|(0)|67|68|69|70)|57|58|59|60|(0)|62|63|64|65|(0)|67|68|69|70) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x00fc, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b(com.mbridge.msdk.scheme.applet.AppletsModel.TAG, "create wechat app request param failed ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00dc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00e0, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00e2, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b(com.mbridge.msdk.scheme.applet.AppletsModel.TAG, "create wechat app request param failed ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0127, code lost:
    
        if (r0 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0129, code lost:
    
        r0 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0139, code lost:
    
        r8.put(r18, r0);
        r8.put(r17, "0");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0145, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0147, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.a(com.mbridge.msdk.scheme.applet.AppletsModel.TAG, "query: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a3, code lost:
    
        r19.reBuildClickUrl = reCreateClickUrl("app" + com.cloud.tmc.kernel.utils.UrlUtils.EQUAL_MARK + r1 + com.cloud.tmc.kernel.utils.UrlUtils.AND_MARK + "path" + com.cloud.tmc.kernel.utils.UrlUtils.EQUAL_MARK + r2 + com.cloud.tmc.kernel.utils.UrlUtils.AND_MARK + r18 + com.cloud.tmc.kernel.utils.UrlUtils.EQUAL_MARK + r0 + com.cloud.tmc.kernel.utils.UrlUtils.AND_MARK + com.mbridge.msdk.MBridgeConstans.DYNAMIC_VIEW_WX_CLICKID + com.cloud.tmc.kernel.utils.UrlUtils.EQUAL_MARK + r3 + com.cloud.tmc.kernel.utils.UrlUtils.AND_MARK + r17 + com.cloud.tmc.kernel.utils.UrlUtils.EQUAL_MARK + "1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x012e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0131, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0133, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b(com.mbridge.msdk.scheme.applet.AppletsModel.TAG, "create wechat app request param failed ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0110, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0114, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0116, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b(com.mbridge.msdk.scheme.applet.AppletsModel.TAG, "create wechat app request param failed ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00f6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00fa, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, java.lang.String> getAppletsParamsAndBuildRequest(com.mbridge.msdk.foundation.entity.CampaignEx r20) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.scheme.applet.AppletsModel.getAppletsParamsAndBuildRequest(com.mbridge.msdk.foundation.entity.CampaignEx):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerRequestNetworkError() {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            o0.a(TAG, "handlerRequestNetworkError response or result is null");
        }
        try {
            this.appletSchemeCallBack.onNetworkError(1, "response or result is null", this.reBuildClickUrl);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, "handler request network error exception ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().d(), "response or result is null", this.unitID, this.requestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestFailed(int i11, String str) {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            o0.a(TAG, String.format("handlerSchemeRequestFailed network error by code %s and %s", String.valueOf(i11), str));
        }
        try {
            this.appletSchemeCallBack.onAppletSchemeRequestFailed(i11, str, this.reBuildClickUrl);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, "handler wx scheme failed exception  ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().d(), String.format("network error by code %s and %s", String.valueOf(i11), str), this.unitID, this.requestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestNetworkError(a aVar) {
        int i11;
        String str;
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (aVar != null) {
            i11 = aVar.f35483a;
            str = aVar.getMessage();
            if (i11 == 10) {
                str = "request timeout";
            }
        } else {
            i11 = -1;
            str = "unKnown";
        }
        if (MBridgeConstans.DEBUG) {
            o0.a(TAG, String.format("handlerSchemeRequestNetworkError network error by code %s and %s", String.valueOf(i11), str));
        }
        try {
            this.appletSchemeCallBack.onNetworkError(i11, "network error: " + str, this.reBuildClickUrl);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, "handler wx scheme network error exception ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().d(), String.format("network error by code %s and %s", String.valueOf(i11), str), this.unitID, this.requestId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerSchemeRequestResult(e<JSONObject> eVar) throws SchemeRequestException {
        JSONObject jSONObject = eVar.f35482c;
        if (MBridgeConstans.DEBUG) {
            o0.a("AppletsModel", "result: " + jSONObject.toString());
        }
        if (jSONObject.has("wx_scheme")) {
            String optString = jSONObject.optString("wx_scheme", "");
            if (TextUtils.isEmpty(optString)) {
                throw new SchemeRequestException("wx_scheme value is null");
            }
            this.isRequestSuccess = true;
            handlerSchemeRequestSuccess(optString);
            return;
        }
        int optInt = jSONObject.optInt("error_code", -1);
        String optString2 = jSONObject.optString(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG, "");
        if (optInt == WX_SCHEME_REQUEST_ERROR_CODE_44993) {
            this.isRequestTimesMaxPerDay = true;
        }
        handlerSchemeRequestFailed(optInt, optString2);
    }

    private void handlerSchemeRequestStart() {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        try {
            this.appletSchemeCallBack.onAppletSchemeRequestStart();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, "handler wx scheme start exception ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().d(), "start load wx scheme", this.unitID, this.requestId);
    }

    private void handlerSchemeRequestSuccess(String str) {
        if (this.appletSchemeCallBack == null) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            o0.a(TAG, "handlerSchemeRequestSuccess: " + str);
        }
        try {
            this.deepLink = str;
            this.appletSchemeCallBack.onAppletSchemeRequestSuccess(str);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, "handler wx scheme success exception ", e11);
            }
        }
        AppletsReport.reportAppletsLoadState(c.m().d(), "request wx scheme success", this.unitID, this.requestId);
    }

    private boolean isCanRequestByClickUrl(String str) {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx == null) {
                return false;
            }
            String clickURL = campaignEx.getClickURL();
            if (TextUtils.isEmpty(clickURL)) {
                return false;
            }
            return TextUtils.equals(z0.a(clickURL, "wx_miniprogram"), str);
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            o0.b(TAG, "query wx_miniprogram from click url exception ", e11);
            return false;
        }
    }

    private boolean isCanRequestByLinkType() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null) {
            return false;
        }
        int linkType = campaignEx.getLinkType();
        return linkType == 8 || linkType == 9;
    }

    private boolean isCanRequestByTemplateUrl(String str) {
        CampaignEx.c rewardTemplateMode;
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null && (rewardTemplateMode = campaignEx.getRewardTemplateMode()) != null && !TextUtils.isEmpty(rewardTemplateMode.e())) {
                return TextUtils.equals(z0.a(rewardTemplateMode.e(), MBridgeConstans.DYNAMIC_VIEW_REQ_WX_URL), str);
            }
            return false;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            o0.b(TAG, "query reqwxurl from template url exception ", e11);
            return false;
        }
    }

    private String reCreateClickUrl(String str) {
        return d.h().f35518b + UrlUtils.QUESTION_MARK + str;
    }

    public boolean can(int i11) {
        if (isRequesting() || !canRequestWxScheme(i11)) {
            return false;
        }
        if (this.lastRequestType == -1) {
            return true;
        }
        if (isRequestSuccess()) {
            return false;
        }
        int i12 = this.lastRequestType;
        return (i12 == 0 && i11 == 1) || (i12 == 1 && i11 == 1 && this.isUserClick);
    }

    public boolean canRequestWxScheme(int i11) {
        if (isSupportWxScheme()) {
            return i11 != 0 ? i11 == 1 : isCanRequestByTemplateUrl("2");
        }
        return false;
    }

    public void clearRequestState() {
        this.isRequestSuccess = false;
        this.isRequesting = false;
        this.appletSchemeCallBack = null;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getReBuildClickUrl() {
        return this.reBuildClickUrl;
    }

    public boolean isRequestSuccess() {
        return this.isRequestSuccess;
    }

    public boolean isRequestTimesMaxPerDay() {
        return this.isRequestTimesMaxPerDay;
    }

    public boolean isRequesting() {
        return this.isRequesting;
    }

    public boolean isSupportWxScheme() {
        if (!this.isSupportWxScheme) {
            this.isSupportWxScheme = isCanRequestByClickUrl("1") && isCanRequestByLinkType();
        }
        return this.isSupportWxScheme;
    }

    public void requestWxAppletsScheme(int i11, IAppletSchemeCallBack iAppletSchemeCallBack) {
        if (this.campaignEx == null || TextUtils.isEmpty(this.unitID)) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            o0.b(TAG, "start request wx scheme");
        }
        this.isRequesting = true;
        if (iAppletSchemeCallBack != null) {
            this.appletSchemeCallBack = iAppletSchemeCallBack;
        }
        handlerSchemeRequestStart();
        AppletSchemeRequest appletSchemeRequest = new AppletSchemeRequest(c.m().d());
        if (this.params == null) {
            this.params = getAppletsParamsAndBuildRequest(this.campaignEx);
        }
        if (this.params == null) {
            return;
        }
        if (isRequestTimesMaxPerDay()) {
            handlerSchemeRequestFailed(WX_SCHEME_REQUEST_ERROR_CODE_44993, "get wxscheme failed : request times is max");
        } else {
            this.lastRequestType = i11;
            appletSchemeRequest.get(1, d.h().f35518b, this.params, new DefaultAppletSchemeResponse(this), "applets_model", 60000L);
        }
    }

    public void setAppletSchemeCallBack(IAppletSchemeCallBack iAppletSchemeCallBack) {
        this.appletSchemeCallBack = iAppletSchemeCallBack;
    }

    public void setRequestingFinish() {
        this.isRequesting = false;
    }

    public void setUserClick(boolean z10) {
        this.isUserClick = z10;
    }
}
