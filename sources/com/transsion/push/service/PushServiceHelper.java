package com.transsion.push.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.core.utils.f;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.config.PushRepository;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.BitmapDownloadUtils;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.PushUtils;
import com.transsion.push.utils.e;
import com.transsion.push.utils.u;
import com.transsion.push.utils.v;
import com.transsion.push.utils.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes6.dex */
public final class PushServiceHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f50957a = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements BitmapDownloadUtils.a {
        a() {
        }

        @Override // com.transsion.push.utils.BitmapDownloadUtils.a
        public void a(PushMessage pushMessage, HashMap hashMap) {
            PushServiceHelper.k(pushMessage, hashMap);
        }
    }

    private static List b(String str, NotificationManager notificationManager) {
        Bundle bundle;
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && (bundle = notification.extras) != null && bundle.getBoolean(PushConstants.EXTRA_PUSH_FROM_TPUSH_NOTI)) {
                if (notification.getGroup() == null && TextUtils.isEmpty(str)) {
                    arrayList.add(statusBarNotification);
                } else if (notification.getGroup() != null && notification.getGroup().equals(str)) {
                    arrayList.add(statusBarNotification);
                }
            }
        }
        return arrayList;
    }

    public static void c(PushMessage pushMessage, NotificationManager notificationManager) {
        int i11;
        List b11;
        if (pushMessage == null || notificationManager == null) {
            return;
        }
        try {
            i11 = Integer.parseInt(pushMessage.groupMaxCount);
        } catch (Exception unused) {
            i11 = 0;
        }
        if (i11 <= 0 || (b11 = b(pushMessage.groupId, notificationManager)) == null || b11.size() < i11) {
            return;
        }
        int size = b11.size() - i11;
        l(b11);
        for (int i12 = 0; i12 <= size; i12++) {
            try {
                notificationManager.cancel(((StatusBarNotification) b11.get((b11.size() - 1) - i12)).getId());
            } catch (Exception e11) {
                PushLogUtils.LOG.i("handle max limit message fail, e:" + e11.getMessage());
            }
        }
    }

    public static boolean d() {
        return qk.a.a() != null && Settings.Global.getInt(qk.a.a().getContentResolver(), "auto_time", 0) == 1;
    }

    private static void e() {
        try {
            if (PushRepository.getInstance().isReported()) {
                return;
            }
            PushRepository.getInstance().syncActive();
            PushLogUtils.LOG.g(" active reporting");
        } catch (Exception e11) {
            PushLogUtils.LOG.i("handle sync active exception,e:" + e11.getMessage());
        }
    }

    public static void f(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_PUSH_SERVICE_TYPE);
        PushLogUtils.LOG.g("PushJobIntentService ---> onHandleWork, type:" + stringExtra);
        if (stringExtra == null) {
            return;
        }
        char c11 = 65535;
        switch (stringExtra.hashCode()) {
            case -1952558746:
                if (stringExtra.equals(PushConstants.PUSH_SERVICE_TYPE_SYNC_CONFIG)) {
                    c11 = 0;
                    break;
                }
                break;
            case 3237136:
                if (stringExtra.equals("init")) {
                    c11 = 1;
                    break;
                }
                break;
            case 110541305:
                if (stringExtra.equals("token")) {
                    c11 = 2;
                    break;
                }
                break;
            case 711171229:
                if (stringExtra.equals(PushConstants.PUSH_SERVICE_TYPE_FORCE_UPDATE)) {
                    c11 = 3;
                    break;
                }
                break;
            case 954925063:
                if (stringExtra.equals("message")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                h(intent);
                return;
            case 1:
                return;
            case 2:
                j(intent);
                return;
            case 3:
                e();
                return;
            case 4:
                i(intent);
                return;
            default:
                PushLogUtils.LOG.z("service type error");
                return;
        }
    }

    private static void g() {
        Tracker.getInstance().trackActiveSyncProcess();
        PushLogUtils.LOG.g("onHandleSyncActive");
        if (PushUtils.p()) {
            PushLogUtils.LOG.g("onHandleSyncActive force update");
            e();
            return;
        }
        try {
            if (PushUtils.r()) {
                PushLogUtils.LOG.g("tpms sync");
                if (u.b(qk.a.a())) {
                    u.c(qk.a.a());
                    PushRepository.getInstance().saveTpmsReportTime(System.currentTimeMillis() + 86400000);
                }
            }
            if (!PushUtils.q() || u.b(qk.a.a())) {
                return;
            }
            PushRepository.getInstance().syncActive();
        } catch (Exception e11) {
            PushLogUtils.LOG.i("handle sync active exception,e:" + e11.getMessage());
        }
    }

    private static void h(Intent intent) {
        if (intent == null) {
            return;
        }
        g();
    }

    private static void i(Intent intent) {
        PushLogUtils.LOG.g("onHandleTargetMessage--->");
        if (intent == null) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(0L, "intent_null");
            PushLogUtils.LOG.g("onHandleTargetMessage---> intent is null");
            return;
        }
        PushMessage i11 = PushUtils.i(intent);
        if (i11 == null) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(0L, "msg_null");
            PushLogUtils.LOG.g("onHandleTargetMessage---> message is null");
            return;
        }
        if (v.h()) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i11.messageId, "self_destroy");
            PushLogUtils.LOG.z("push self-destroying");
            return;
        }
        if (!PushUtils.a(i11, 1)) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i11.messageId, "check_fail");
            PushLogUtils.LOG.g("onHandleTargetMessage---> checkMessage return ");
            return;
        }
        if (PushUtils.u(i11)) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i11.messageId, "msg_retreat");
            PushLogUtils.LOG.g("onHandleTargetMessage---> retraceMessage return, retrace msgId:" + i11.retraceMsgId);
            return;
        }
        PushUtils.z(i11);
        Tracker.getInstance().trackTarget(i11.messageId, i11.type, i11.timeStamp, i11.rpkg, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, i11);
        PushUtils.y(i11.messageId);
        PushLogUtils.LOG.g("onHandleTargetMessage---> type:" + i11.type);
        int i12 = i11.type;
        if (i12 != 1) {
            if (i12 == 2) {
                m(i11);
                return;
            } else if (i12 != 5 && i12 != 6) {
                if (i12 != 7) {
                    PushLogUtils.LOG.z("Display message, message type is not supported");
                    return;
                }
                return;
            }
        }
        if (i11.sdkShow == 0) {
            PushLogUtils.LOG.g("sdkShow no show");
            if (PushManager.getInstance().getPushListener() != null) {
                PushManager.getInstance().getPushListener().onPushReceive(i11.messageId, i11, i11.priority);
            }
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i11.messageId, "sdk_show_fail");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            PushLogUtils.LOG.g("message ignoreExpire? " + i11.ignoreExpire);
            PushLogUtils.LOG.g("isTimeAutomatic: " + d());
            PushLogUtils.LOG.g("message schedule time: " + i11.getTimeStamp());
            PushLogUtils.LOG.g("message delay: " + (currentTimeMillis - Long.parseLong(i11.getTimeStamp())));
            PushLogUtils.LOG.g("message ttl: " + (i11.getMsgTtl() * 1000));
            if (i11.ignoreExpire == 0) {
                PushLogUtils.LOG.g("message expiration check");
                if (d() && currentTimeMillis - Long.parseLong(i11.getTimeStamp()) > i11.getMsgTtl() * 1000) {
                    PushLogUtils.LOG.g("message expired, no show");
                    Tracker.getInstance().trackShow(i11.messageId, i11.type, i11.timeStamp, true, DescriptorProtos$Edition.EDITION_PROTO3_VALUE);
                    return;
                }
            }
        } catch (Exception unused) {
        }
        if (!PushManager.getInstance().getNotificationSwitch()) {
            Tracker.getInstance().trackHandleMsgErrorInfoeye(i11.messageId, "noti_off");
            PushLogUtils.LOG.g("notification switch is off, do not show noti");
        } else if (BitmapDownloadUtils.a(i11)) {
            BitmapDownloadUtils.b(i11, new a());
        } else {
            k(i11, null);
        }
    }

    private static void j(Intent intent) {
        Tracker.getInstance().trackTokenUpdateProcess("start");
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_TOKEN);
        if (TextUtils.isEmpty(stringExtra)) {
            PushLogUtils.LOG.z("Initialize token to empty");
            return;
        }
        try {
            if (qk.a.a() == null) {
                return;
            }
            synchronized (f50957a) {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Initialize push_token， packageName:");
                    sb2.append(e.f());
                    sb2.append(", token：");
                    sb2.append(stringExtra);
                    if (stringExtra.equals((String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, "")) && !TextUtils.isEmpty((CharSequence) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_CLIENT_ID, ""))) {
                        Tracker.getInstance().trackTokenUpdateProcess("same");
                        PushLogUtils.LOG.g("token does not need to report without modification");
                        PushUtils.w();
                        f.e(PushConstants.SP_FILENAME).o(PushConstants.SP_KEY_UPDATE_TOKEN_TIME, System.currentTimeMillis());
                        return;
                    }
                    Tracker.getInstance().trackTokenUpdateProcess("update");
                    PushLogUtils.LOG.g("token updated, do network request");
                    try {
                        f.e(PushConstants.SP_FILENAME).o(PushConstants.SP_KEY_UPDATE_TOKEN_TIME, System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                    PushRepository.getInstance().updateNewToken(stringExtra);
                    e();
                    try {
                        u.b(qk.a.a());
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(PushMessage pushMessage, HashMap hashMap) {
        PushLogUtils.LOG.g("display messages，message：" + pushMessage);
        if (pushMessage == null) {
            return;
        }
        try {
            z.g(pushMessage, hashMap);
        } catch (Exception e11) {
            PushLogUtils.LOG.i("Notification show exception:" + e11.getMessage());
        }
    }

    private static void l(List list) {
        Collections.sort(list, new Comparator<StatusBarNotification>() { // from class: com.transsion.push.service.PushServiceHelper.2
            @Override // java.util.Comparator
            public int compare(StatusBarNotification statusBarNotification, StatusBarNotification statusBarNotification2) {
                return (int) (statusBarNotification2.getPostTime() - statusBarNotification.getPostTime());
            }
        });
    }

    private static synchronized void m(PushMessage pushMessage) {
        synchronized (PushServiceHelper.class) {
            try {
                try {
                    if (TextUtils.isEmpty(pushMessage.packageName)) {
                        pushMessage.packageName = com.transsion.core.utils.a.a();
                    }
                    if (pushMessage.packageName.equals(com.transsion.core.utils.a.a())) {
                        if (PushManager.getInstance().getPushListener() != null) {
                            PushManager.getInstance().getPushListener().onMessageReceive(pushMessage.messageId, pushMessage.transData, pushMessage.priority);
                        } else {
                            Log.e(PushLogUtils.TAG, "tpush listener is not registered");
                        }
                    }
                } catch (Exception e11) {
                    PushLogUtils.LOG.i("transmitMessage---> e:" + e11.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
