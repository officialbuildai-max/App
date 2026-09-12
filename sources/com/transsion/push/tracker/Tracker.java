package com.transsion.push.tracker;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.b;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.core.utils.a;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.config.PushRepository;
import com.transsion.push.utils.PushUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class Tracker {

    /* renamed from: c, reason: collision with root package name */
    private static Tracker f50963c;

    /* renamed from: d, reason: collision with root package name */
    private static HashMap f50964d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static HashMap f50965e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private String f50966a;

    /* renamed from: b, reason: collision with root package name */
    private String f50967b;

    /* loaded from: classes.dex */
    public enum KEY {
        INFOEYE_FOR_BROADCAST(0, "infoeye", "hipush_broadcast"),
        INFOEYE_FOR_BROADCAST_GCM(0, "infoeye", "hipush_broadcast_gcm"),
        INFOEYE_FOR_REACH_ERROR(0, "infoeye", "hipush_reach_error"),
        INFOEYE_FOR_TOKEN_INIT(0, "infoeye", "hipush_token_init"),
        INFOEYE_FOR_TOKEN_PROCESS(0, "infoeye", "hipush_token_process"),
        INFOEYE_FOR_SYNC_INIT(0, "infoeye", "hipush_sync_init"),
        INFOEYE_FOR_SYNC_PROCESS(0, "infoeye", "hipush_sync_process"),
        ATHENA_TID_FOR_APP_INIT(10410001, "init"),
        ATHENA_TID_FOR_APP_TOKEN(10410002, "token"),
        ATHENA_TID_FOR_APP_TRIG(10410003, "trig"),
        ATHENA_TID_FOR_APP_REPORT(10410004, "report"),
        ATHENA_TID_FOR_APP_CFG(10410005, "cfg"),
        ATHENA_TID_FOR_APP_MSG(10410006, NotificationCompat.CATEGORY_MESSAGE, "hipush_reach_init"),
        ATHENA_TID_FOR_APP_TARGET(10410007, PushConstants.PUSH_SERVICE_TYPE_ARRIVE, "hipush_reach_process"),
        ATHENA_TID_FOR_APP_SHOW(10410008, PushConstants.PUSH_SERVICE_TYPE_SHOW, "hipush_show"),
        ATHENA_TID_FOR_APP_CLICK(10410009, "click", "hipush_click"),
        ATHENA_TID_FOR_APP_IMG_DOWNLOAD(10410010, "img"),
        ATHENA_TID_FOR_APP_TRACE(10410011, "trace"),
        ATHENA_TID_FOR_APP_UNINSTALL(10410012, "uninstall"),
        ATHENA_TID_FOR_APP_CONVERSION(10410013, PushConstants.PUSH_SERVICE_TYPE_CONVERSION),
        ATHENA_TID_FOR_APP_INSTALL(10410014, "install");

        public String event;
        public String infoeyeEvent;
        public int tid;

        KEY(int i11, String str) {
            this.event = str;
            this.tid = i11;
        }

        KEY(int i11, String str, String str2) {
            this.event = str;
            this.tid = i11;
            this.infoeyeEvent = str2;
        }
    }

    private Tracker() {
        try {
            this.f50966a = a.a();
            this.f50967b = a.c();
        } catch (Exception unused) {
        }
        f50964d.put(IntegrationConstants.NAVIGATION_BAR_ALL_ACTION, 0);
        f50964d.put(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, 1);
        f50964d.put("fail", 2);
        f50965e.put(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, 3);
        f50965e.put("handled", 4);
    }

    private void a(Bundle bundle, PushMessage pushMessage) {
        if (pushMessage != null) {
            bundle.putInt("head_up", c(pushMessage) ? 1 : 0);
            bundle.putString("material_id", pushMessage.materialId);
            bundle.putString("seq", pushMessage.seq);
            bundle.putString("sourceType", pushMessage.sourceType);
            bundle.putString("scheduleDate", pushMessage.scheduleDate);
            bundle.putString("tag", pushMessage.tag);
        }
    }

    private Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(PushConstants.PROVIDER_FIELD_PKG, this.f50966a);
        bundle.putString("ver", this.f50967b);
        bundle.putString(OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_SDK, "2.0.2.01");
        bundle.putString(SafeStringUtils.SP_APPID, PushUtils.e());
        return bundle;
    }

    private boolean c(PushMessage pushMessage) {
        return (pushMessage == null || TextUtils.isEmpty(pushMessage.floatNotice) || !pushMessage.floatNotice.equals("1")) ? false : true;
    }

    public static Tracker getInstance() {
        if (f50963c == null) {
            f50963c = new Tracker();
        }
        return f50963c;
    }

    public void init() {
        AthenaTracker.getInstance().b();
    }

    public void trackActiveSyncInit() {
    }

    public void trackActiveSyncProcess() {
    }

    public void trackBroadcastGcmInfoeye() {
    }

    public void trackBroadcastInfoeye() {
    }

    public void trackClick(long j11) {
        trackClick(j11, PushUtils.m(j11));
        PushUtils.b(j11);
    }

    public void trackClick(long j11, PushMessage pushMessage) {
        Bundle b11 = b();
        b11.putLong("id", j11);
        a(b11, pushMessage);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("trackClick, message is :  ");
        sb2.append(pushMessage);
        AthenaTracker.getInstance().e(KEY.ATHENA_TID_FOR_APP_CLICK, b11);
    }

    public void trackConfig(int i11, int i12) {
        Bundle b11 = b();
        b11.putInt("cfgv", i11);
        b11.putInt("cfgt", i12);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_CFG;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackConversion(long j11) {
        Bundle b11 = b();
        b11.putLong("id", j11);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_CONVERSION;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackHandleMsgErrorInfoeye(long j11, String str) {
    }

    public void trackImg(String str, int i11) {
        Bundle b11 = b();
        b11.putString("url", str);
        b11.putInt("result", i11);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_IMG_DOWNLOAD;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackInit() {
        if (((Boolean) PushRepository.getInstance().getSpValue("init", Boolean.FALSE)).booleanValue()) {
            return;
        }
        Bundle b11 = b();
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_INIT;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
        PushRepository.getInstance().putSpValue("init", Boolean.TRUE);
    }

    public void trackInstall() {
        if (((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_TRACK_INSTALL, Boolean.FALSE)).booleanValue()) {
            return;
        }
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_TRACK_INSTALL, Boolean.TRUE);
        PushTracker.getInstance().i(KEY.ATHENA_TID_FOR_APP_INSTALL, null);
    }

    public void trackMessage(long j11, int i11, String str, String str2, int i12) {
        Bundle b11 = b();
        b11.putLong("id", j11);
        b11.putLong(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
        b11.putLong(b.JSON_KEY_DO, i12);
        b11.putString("pts", str);
        b11.putString("result", str2);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_MSG;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackReport() {
        Bundle b11 = b();
        b11.putString(PushConstants.PROVIDER_FIELD_PKG, this.f50966a);
        b11.putString("ver", this.f50967b);
        b11.putString(OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_SDK, "2.0.2.01");
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_REPORT;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
        try {
            PushTracker.getInstance().i(key, null);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void trackShow(long j11, int i11, String str, boolean z10, int i12) {
        trackShow(j11, i11, str, z10, i12, PushUtils.m(j11));
    }

    public void trackShow(long j11, int i11, String str, boolean z10, int i12, PushMessage pushMessage) {
        Bundle b11 = b();
        b11.putLong("id", j11);
        b11.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
        b11.putBoolean("able", z10);
        b11.putString("pts", str);
        b11.putInt(NotificationCompat.CATEGORY_STATUS, i12);
        b11.putInt(TrackingKey.SHOW_STATUS, i12);
        a(b11, pushMessage);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("trackShow, message is :  ");
        sb2.append(pushMessage);
        AthenaTracker.getInstance().e(KEY.ATHENA_TID_FOR_APP_SHOW, b11);
    }

    public void trackTarget(long j11, int i11, String str, String str2, String str3) {
        Bundle b11 = b();
        b11.putLong("id", j11);
        b11.putLong(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
        b11.putString("pts", str);
        b11.putString("rpkg", str2);
        b11.putString("result", str3);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TARGET;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackTarget(long j11, int i11, String str, String str2, String str3, PushMessage pushMessage) {
        Bundle b11 = b();
        b11.putLong("id", j11);
        b11.putLong(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
        b11.putString("pts", str);
        b11.putString("rpkg", str2);
        b11.putString("result", str3);
        a(b11, pushMessage);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("trackTarget, message is :  ");
        sb2.append(pushMessage);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TARGET;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackToken(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (str.length() > 8) {
            str = str.substring(0, 8);
        }
        Bundle b11 = b();
        b11.putString("token", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TOKEN;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackTokenUpdateInit() {
    }

    public void trackTokenUpdateProcess(String str) {
    }

    public void trackTrace(int i11, String str) {
        Bundle b11 = b();
        b11.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
        b11.putInt("osV", Build.VERSION.SDK_INT);
        b11.putString("data", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TRACE;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackTrigger(int i11) {
        Bundle b11 = b();
        b11.putInt("reason", i11);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TRIG;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void trackUninstall(long j11, String str) {
        Bundle b11 = b();
        b11.putLong("id", j11);
        b11.putString("tpkg", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_UNINSTALL;
        athenaTracker.e(key, b11);
        FirebaseTracker.getInstance().a(key, b11);
    }

    public void tracks() {
        PushTracker.getInstance().tracks();
    }
}
