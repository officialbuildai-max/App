package com.transsion.push.config;

import android.os.Build;
import android.text.TextUtils;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.ITopicListener;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.bean.PushRequest;
import com.transsion.push.bean.PushResponse;
import com.transsion.push.bean.SelfDestroyInfo;
import com.transsion.push.utils.NotificationAssistUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.e;
import com.transsion.push.utils.e0;
import com.transsion.push.utils.f0;
import com.transsion.push.utils.l;
import com.transsion.push.utils.n;
import com.transsion.push.utils.v;
import com.transsion.push.utils.z;
import java.util.ArrayList;
import java.util.Locale;
import sk.b;
import sk.c;

/* loaded from: classes6.dex */
public final class a {
    private PushRequest.ReportContentData a() {
        PushRequest.ReportContentData reportContentData = new PushRequest.ReportContentData();
        Locale locale = Locale.getDefault();
        reportContentData.vaid = AthenaAnalytics.H(qk.a.a(), true);
        reportContentData.gaid = DeviceInfo.e();
        reportContentData.sdkVersion = "2.0.2.01";
        reportContentData.sdkVersionCode = 17004;
        reportContentData.pkg = e.f();
        reportContentData.confVersion = v.a();
        reportContentData.whitelistVersion = f0.b();
        if (z.e()) {
            reportContentData.platVer = z.c();
        }
        boolean booleanValue = ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_IS_REPORT_DETAIL, Boolean.TRUE)).booleanValue();
        if (TextUtils.isEmpty(reportContentData.clientId)) {
            booleanValue = true;
        }
        reportContentData.withDetail = booleanValue;
        if (booleanValue) {
            reportContentData.aid = DeviceInfo.c();
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                str = str.toUpperCase().replace(" ", "");
            }
            reportContentData.brand = str;
            reportContentData.androidVersion = Build.VERSION.RELEASE;
            reportContentData.cid = 0;
            reportContentData.lac = 0;
            reportContentData.language = locale.getLanguage() == null ? null : locale.getLanguage().toLowerCase();
            reportContentData.mcc = e.d();
            reportContentData.mnc = e.e();
            String str2 = Build.MODEL;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.toUpperCase().replace(" ", "");
            }
            reportContentData.model = str2;
            reportContentData.network = n.a();
            reportContentData.osVersion = String.valueOf(Build.VERSION.SDK_INT);
            reportContentData.appVersion = e.g(qk.a.a());
            reportContentData.appVersionCode = com.transsion.core.utils.a.b();
            reportContentData.token = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, "");
            reportContentData.country = locale.getCountry() != null ? locale.getCountry().toUpperCase() : null;
        }
        z.h(reportContentData);
        reportContentData.appId = PushUtils.e();
        reportContentData.appKey = PushUtils.f();
        reportContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
        reportContentData.noticeEnable = NotificationAssistUtils.isOpenNotification(qk.a.a()) ? 1 : 2;
        return reportContentData;
    }

    private PushRequest.SelfDestroyContentData b() {
        PushRequest.SelfDestroyContentData selfDestroyContentData = new PushRequest.SelfDestroyContentData();
        selfDestroyContentData.appId = PushUtils.e();
        selfDestroyContentData.appKey = PushUtils.f();
        selfDestroyContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
        selfDestroyContentData.sdkVersion = "2.0.2.01";
        selfDestroyContentData.sdkVersionCode = 17004;
        selfDestroyContentData.appVersion = e.g(qk.a.a());
        selfDestroyContentData.appVersionCode = com.transsion.core.utils.a.b();
        selfDestroyContentData.confVersion = v.a();
        selfDestroyContentData.whitelistVersion = f0.b();
        return selfDestroyContentData;
    }

    private PushRequest.TopicContentData c(String str, String str2) {
        PushRequest.TopicContentData topicContentData = new PushRequest.TopicContentData();
        topicContentData.clientId = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, "");
        topicContentData.gaid = DeviceInfo.e();
        topicContentData.appId = PushUtils.e();
        topicContentData.appKey = PushUtils.f();
        topicContentData.appVersion = com.transsion.core.utils.a.c();
        topicContentData.appVersionCode = com.transsion.core.utils.a.b();
        topicContentData.sdkVersion = "2.0.2.01";
        topicContentData.sdkVersionCode = 17004;
        if (!TextUtils.isEmpty(str)) {
            topicContentData.topics = new ArrayList<>();
            if (str.contains(",")) {
                for (String str3 : str.split(",")) {
                    topicContentData.topics.add(str3.toLowerCase());
                }
            } else {
                topicContentData.topics.add(str.toLowerCase());
            }
        }
        topicContentData.action = str2;
        return topicContentData;
    }

    private void d(ITopicListener iTopicListener, String str) {
        if (iTopicListener != null) {
            iTopicListener.onFail(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SelfDestroyInfo e() {
        try {
            PushRequest.SelfDestroyContentData b11 = b();
            PushLogUtils.LOG.g("get self-destroying request data: " + b11.toString());
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String c11 = bVar.c(bVar.e(com.transsion.json.b.b(b11)));
            String c12 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c11;
            pushRequest.key = c12;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String d11 = z.d();
            if (TextUtils.isEmpty(d11)) {
                return null;
            }
            String str = d11 + PushUtils.e() + PushConstants.CONFIG_URL_PATH;
            PushLogUtils.LOG.g("self-destroying request url:" + str);
            byte[] c13 = l.c(str, bytes);
            if (c13 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return null;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(c13), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse self-destroying BaseResponse failed");
                return null;
            }
            if (pushResponse.status != 200) {
                PushLogUtils.LOG.i("self-destroying BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
                return null;
            }
            PushResponse.SignedEncryptedData signedEncryptedData = pushResponse.data;
            if (signedEncryptedData == null) {
                PushLogUtils.LOG.i("parse self-destroying signedResponse failed");
                return null;
            }
            if (!cVar.g(e0.a(bVar.a(signedEncryptedData.data)), bVar.a(signedEncryptedData.sign))) {
                PushLogUtils.LOG.i("self-destroying verify signature failed");
                return null;
            }
            SelfDestroyInfo selfDestroyInfo = (SelfDestroyInfo) com.transsion.json.b.a(new String(bVar.d(bVar.a(signedEncryptedData.data))), SelfDestroyInfo.class);
            if (selfDestroyInfo != null) {
                return selfDestroyInfo;
            }
            PushLogUtils.LOG.i("parse self-destroying info failed");
            return null;
        } catch (Exception e11) {
            PushLogUtils.LOG.z("self-destroying Exception: " + e11.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigInfo f() {
        String str;
        try {
            PushRequest.ReportContentData a11 = a();
            PushLogUtils.LOG.g("get config request data: " + a11.toString());
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String c11 = bVar.c(bVar.e(com.transsion.json.b.b(a11)));
            String c12 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c11;
            pushRequest.key = c12;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String d11 = z.d();
            if (TextUtils.isEmpty(d11)) {
                return null;
            }
            if (z.e()) {
                str = d11 + PushConstants.TPMS_URL_PATH;
            } else {
                str = d11 + PushUtils.e() + PushConstants.UPDATE_URL_PATH;
            }
            PushLogUtils.LOG.g("request url:" + str);
            byte[] c13 = l.c(str, bytes);
            if (c13 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return null;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(c13), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse syncActive BaseResponse failed");
                return null;
            }
            if (pushResponse.status != 200) {
                PushLogUtils.LOG.i("syncActive BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
                return null;
            }
            PushResponse.SignedEncryptedData signedEncryptedData = pushResponse.data;
            if (signedEncryptedData == null) {
                PushLogUtils.LOG.i("parse syncActive signedResponse failed");
                return null;
            }
            if (!cVar.g(e0.a(bVar.a(signedEncryptedData.data)), bVar.a(signedEncryptedData.sign))) {
                PushLogUtils.LOG.i("syncActive verify signature failed");
                return null;
            }
            ConfigInfo configInfo = (ConfigInfo) com.transsion.json.b.a(new String(bVar.d(bVar.a(signedEncryptedData.data))), ConfigInfo.class);
            if (configInfo != null) {
                return configInfo;
            }
            PushLogUtils.LOG.i("parse syncActive reportResponse failed");
            return null;
        } catch (Exception e11) {
            PushLogUtils.LOG.i("syncActive Exception: " + e11.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, ITopicListener iTopicListener) {
        PushRequest.TopicContentData c11 = c(str, str2);
        PushLogUtils.LOG.g("topics request data: " + c11.toString());
        b bVar = new b();
        c cVar = new c(PushConstants.RSA_PUB_KEY);
        PushRequest pushRequest = new PushRequest();
        try {
            String c12 = bVar.c(bVar.e(com.transsion.json.b.b(c11)));
            String c13 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c12;
            pushRequest.key = c13;
            byte[] bytes = com.transsion.json.b.b(pushRequest).getBytes();
            String d11 = z.d();
            if (TextUtils.isEmpty(d11)) {
                return;
            }
            String str3 = d11 + PushUtils.e() + PushConstants.TOPICS_URL_PATH;
            PushLogUtils.LOG.g("topics request url:" + str3);
            byte[] c14 = l.c(str3, bytes);
            if (c14 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                d(iTopicListener, "the response data is empty");
                return;
            }
            PushResponse pushResponse = (PushResponse) com.transsion.json.b.a(new String(c14), PushResponse.class);
            if (pushResponse == null) {
                PushLogUtils.LOG.i("parse topics BaseResponse failed");
                d(iTopicListener, "parse topics BaseResponse failed");
                return;
            }
            if (pushResponse.status == 200) {
                if (iTopicListener != null) {
                    iTopicListener.onSuccess();
                    return;
                }
                return;
            }
            PushLogUtils.LOG.i("topics BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
            d(iTopicListener, "topics BaseResponse status error, status:" + pushResponse.status + ", " + pushResponse.message);
        } catch (Exception e11) {
            PushLogUtils.LOG.z("topics Exception: " + e11.getMessage());
            d(iTopicListener, "topics Exception: " + e11.getMessage());
        }
    }
}
