package com.transsion.push.tracker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.net.UrlKt;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.utils.a;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushPointInfo;
import com.transsion.push.bean.PushRequest;
import com.transsion.push.bean.TrackerResponse;
import com.transsion.push.config.PushRepository;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.ThreadManager;
import com.transsion.push.utils.e;
import com.transsion.push.utils.l;
import com.transsion.push.utils.n;
import com.transsion.push.utils.v;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sk.b;
import sk.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PushTracker {

    /* renamed from: b, reason: collision with root package name */
    private static PushTracker f50961b;

    /* renamed from: a, reason: collision with root package name */
    private Context f50962a;

    private PushTracker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject e() {
        JSONObject jSONObject;
        JSONException e11;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e12) {
            jSONObject = null;
            e11 = e12;
        }
        try {
            jSONObject.put("app_id", PushUtils.e());
            jSONObject.put("app_ver", a.c());
            jSONObject.put("app_ver_code", a.b());
            jSONObject.put(UrlKt.KEY_MINI_GAID, DeviceInfo.e());
            jSONObject.put("pkg_name", a.a());
            jSONObject.put("sdk_ver", "2.0.2.01");
            jSONObject.put("sdk_ver_code", 17004);
            jSONObject.put("tz", e.c());
            jSONObject.put(PlaceTypes.COUNTRY, Locale.getDefault().getCountry());
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                str = str.toUpperCase().replace(" ", "");
            }
            jSONObject.put("brand", str);
            jSONObject.put("mcc", e.d());
            jSONObject.put("mnc", e.d());
            jSONObject.put("device_type", e.h(this.f50962a) ? "pad" : "phone");
            jSONObject.put("android_ver", Build.VERSION.RELEASE);
            jSONObject.put("os_ver", Build.VERSION.SDK_INT);
        } catch (JSONException e13) {
            e11 = e13;
            e11.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject f(Tracker.KEY key, Bundle bundle) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e11) {
            e = e11;
        }
        try {
            jSONObject.put("name", key.event);
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("network_type", n.b());
            if (bundle != null && !bundle.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (String str : bundle.keySet()) {
                    jSONObject3.put(str, bundle.get(str));
                }
                jSONObject.put("extra", jSONObject3);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e12) {
            e = e12;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject, List list) {
        if (jSONObject == null || list == null || list.size() <= 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(((PushPointInfo) it.next()).evt));
            }
            jSONObject.put("evt", jSONArray);
            String jSONObject2 = jSONObject.toString();
            PushLogUtils.LOG.g("request body:" + jSONObject2);
            String str = PushManager.getInstance().getTestEnv() ? PushConstants.TEST_POINT_REPORT : PushManager.getInstance().getDebug() ? PushConstants.DEBUG_POINT_REPORT : PushConstants.RELEASE_POINT_REPORT;
            PushLogUtils.LOG.g("request url:" + str);
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String c11 = bVar.c(bVar.e(jSONObject2));
            String c12 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c11;
            pushRequest.key = c12;
            byte[] c13 = l.c(str, com.transsion.json.b.b(pushRequest).getBytes());
            if (c13 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                return;
            }
            TrackerResponse trackerResponse = (TrackerResponse) com.transsion.json.b.a(new String(c13), TrackerResponse.class);
            if (trackerResponse != null && trackerResponse.config != null) {
                PushLogUtils.LOG.g("post points response:" + trackerResponse);
                if (trackerResponse.status == 200) {
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_IMMEDIATELY_TRACK, Boolean.valueOf(trackerResponse.config.reportType == 0));
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_TRACKER_REPORT_INTERVAL, Long.valueOf(trackerResponse.config.reportTime));
                    PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_TRACKER_REPORT_TIME, Long.valueOf(System.currentTimeMillis() + v.f()));
                    pp.a.b().a(list);
                    return;
                }
                PushLogUtils.LOG.i("post points response status error, status:" + trackerResponse.status + ", " + trackerResponse.message);
                return;
            }
            PushLogUtils.LOG.i("parse post points BaseResponse failed");
        } catch (Exception e11) {
            PushLogUtils.LOG.i("post points Exception: " + e11.getMessage());
        }
    }

    public static PushTracker getInstance() {
        if (f50961b == null) {
            f50961b = new PushTracker();
        }
        return f50961b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("evt", jSONArray);
            String jSONObject3 = jSONObject.toString();
            PushLogUtils.LOG.g("request body:" + jSONObject3);
            String str = PushManager.getInstance().getTestEnv() ? PushConstants.TEST_POINT_REPORT : PushManager.getInstance().getDebug() ? PushConstants.DEBUG_POINT_REPORT : PushConstants.RELEASE_POINT_REPORT;
            PushLogUtils.LOG.g("request url:" + str);
            b bVar = new b();
            c cVar = new c(PushConstants.RSA_PUB_KEY);
            PushRequest pushRequest = new PushRequest();
            String c11 = bVar.c(bVar.e(jSONObject3));
            String c12 = bVar.c(cVar.d(bVar.i()));
            pushRequest.data = c11;
            pushRequest.key = c12;
            byte[] c13 = l.c(str, com.transsion.json.b.b(pushRequest).getBytes());
            if (c13 == null) {
                PushLogUtils.LOG.i("the response data is empty");
                pp.a.b().c(jSONObject2.toString());
                return;
            }
            TrackerResponse trackerResponse = (TrackerResponse) com.transsion.json.b.a(new String(c13), TrackerResponse.class);
            if (trackerResponse == null) {
                PushLogUtils.LOG.i("parse post point BaseResponse failed");
                pp.a.b().c(jSONObject2.toString());
                return;
            }
            PushLogUtils.LOG.g("post point response:" + trackerResponse);
            if (trackerResponse.status == 200) {
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_IMMEDIATELY_TRACK, Boolean.valueOf(trackerResponse.config.reportType == 0));
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_TRACKER_REPORT_INTERVAL, Long.valueOf(trackerResponse.config.reportTime));
                return;
            }
            PushLogUtils.LOG.i("post point response status error, status:" + trackerResponse.status + ", " + trackerResponse.message);
            pp.a.b().c(jSONObject2.toString());
        } catch (Exception e11) {
            PushLogUtils.LOG.i("post point Exception: " + e11.getMessage());
            pp.a.b().c(jSONObject2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Tracker.KEY key, final Bundle bundle) {
        boolean booleanValue = ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_START_POINT_REPORT, Boolean.FALSE)).booleanValue();
        PushLogUtils.LOG.g("push tracker isStartPointReport:" + booleanValue + ", key:" + key.event);
        if (booleanValue) {
            ThreadManager.executeInBackground(new Runnable() { // from class: com.transsion.push.tracker.PushTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject f11 = PushTracker.this.f(key, bundle);
                    if (!v.g()) {
                        pp.a.b().c(f11.toString());
                    } else {
                        PushTracker.this.h(PushTracker.this.e(), f11);
                    }
                }
            });
        }
    }

    public void tracks() {
        boolean booleanValue = ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_START_POINT_REPORT, Boolean.FALSE)).booleanValue();
        PushLogUtils.LOG.g("push trackers isStartPointReport:" + booleanValue);
        if (!booleanValue) {
            PushLogUtils.LOG.g("check tracker report");
        } else if (PushUtils.t()) {
            PushLogUtils.LOG.g("check tracker report");
            ThreadManager.executeInBackground(new Runnable() { // from class: com.transsion.push.tracker.PushTracker.2
                @Override // java.lang.Runnable
                public void run() {
                    List d11 = pp.a.b().d();
                    if (d11 == null || d11.size() <= 0) {
                        PushLogUtils.LOG.g("No tracker content reporting");
                    } else {
                        PushTracker.this.g(PushTracker.this.e(), d11);
                    }
                }
            });
        }
    }
}
