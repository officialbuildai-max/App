package com.transsion.version.update;

import android.app.Activity;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.transsion.push.PushConstants;
import com.transsion.version.update.dialog.UpdateDialog;
import com.transsion.web.api.WebConstants;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes7.dex */
public final class UpdateVersionRequest {

    /* renamed from: a, reason: collision with root package name */
    private final String f57648a = "update";

    /* renamed from: b, reason: collision with root package name */
    private n0 f57649b = o0.a(y0.b());

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f57650c = LazyKt.b(new Function0() { // from class: com.transsion.version.update.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a g11;
            g11 = UpdateVersionRequest.g();
            return g11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private RemoteVersionInfo f57651d;

    private final boolean f(NoticeConfig noticeConfig) {
        String str;
        int notifyTimes = noticeConfig != null ? noticeConfig.getNotifyTimes() : 3;
        long notifyInterval = noticeConfig != null ? noticeConfig.getNotifyInterval() : 24L;
        if (noticeConfig == null || (str = noticeConfig.getUpdateVersionName()) == null) {
            str = "";
        }
        d dVar = d.f57653a;
        String string = dVar.b().getString("showed_target_version_name", "");
        boolean z10 = false;
        int i11 = dVar.b().getInt("update_dialog_showed_times", 0);
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.f57648a, "checkShowUpdateDialog 之前已展示版本 " + string + "   计划版本 " + str + " 已展示次数 " + i11, false, 4, null);
        if (!Intrinsics.c(string, str)) {
            dVar.b().putInt("update_dialog_showed_times", 0);
            i11 = 0;
        }
        long j11 = 60;
        boolean z11 = ((notifyInterval * j11) * j11) * ((long) 1000) < System.currentTimeMillis() - dVar.b().getLong("update_dialog_show_timestamp", 0L);
        if (i11 < notifyTimes && z11) {
            z10 = true;
        }
        a.C0856a.f(c0856a, this.f57648a, "checkShowUpdateDialog 检查结果为 " + z10 + " 已展示次数 " + i11 + " 提醒次数 " + notifyTimes + " 间隔时长为 " + notifyInterval + " 小时 间隔时长是否合格 " + z11, false, 4, null);
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a g() {
        return (a) zg.c.f79537e.a().h(a.class);
    }

    private final boolean i() {
        d dVar = d.f57653a;
        boolean z10 = dVar.b().getBoolean("NEW_USER_FIRST_LAUNCH", true);
        if (z10) {
            dVar.b().putBoolean("NEW_USER_FIRST_LAUNCH", false);
        }
        return z10;
    }

    private final void j(String str, RemoteVersionInfo remoteVersionInfo) {
        NoticeConfig noticeConfig;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EventConstants.KEY_ACTION, "check");
        String str2 = null;
        linkedHashMap.put("check_result", String.valueOf(remoteVersionInfo != null ? Boolean.valueOf(remoteVersionInfo.getHasUpdate()) : null));
        linkedHashMap.put(PushConstants.PUSH_SERVICE_TYPE_FORCE_UPDATE, String.valueOf(remoteVersionInfo != null ? Boolean.valueOf(remoteVersionInfo.getForceUpdate()) : null));
        if (remoteVersionInfo != null && (noticeConfig = remoteVersionInfo.getNoticeConfig()) != null) {
            str2 = noticeConfig.getUpdateVersionName();
        }
        linkedHashMap.put("target_version_name", String.valueOf(str2));
        linkedHashMap.put(WebConstants.PAGE_FROM, str);
        e.f57661a.b(linkedHashMap);
    }

    private final void k(Activity activity, final RemoteVersionInfo remoteVersionInfo, final String str, boolean z10, String str2) {
        boolean isInPictureInPictureMode;
        if (activity instanceof FragmentActivity) {
            UpdateDialog a11 = UpdateDialog.INSTANCE.a(remoteVersionInfo, z10, new Function1() { // from class: com.transsion.version.update.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit m11;
                    m11 = UpdateVersionRequest.m(str, remoteVersionInfo, ((Boolean) obj).booleanValue());
                    return m11;
                }
            });
            if (!(Build.VERSION.SDK_INT >= 24 ? f.a((FragmentActivity) activity) : false)) {
                FragmentActivity fragmentActivity = (FragmentActivity) activity;
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                String simpleName = UpdateDialog.class.getSimpleName();
                if (!fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed() && !supportFragmentManager.T0() && !a11.isAdded() && supportFragmentManager.k0(simpleName) == null) {
                    a11.k0(activity, simpleName);
                }
            }
        } else {
            fx.h a12 = fx.h.f63165g.a(activity, remoteVersionInfo, z10, new Function1() { // from class: com.transsion.version.update.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit n11;
                    n11 = UpdateVersionRequest.n(str, remoteVersionInfo, ((Boolean) obj).booleanValue());
                    return n11;
                }
            });
            isInPictureInPictureMode = activity.isInPictureInPictureMode();
            if (!isInPictureInPictureMode) {
                a12.g(activity);
            }
        }
        e.f57661a.c(str, z10, "mb", str2);
    }

    static /* synthetic */ void l(UpdateVersionRequest updateVersionRequest, Activity activity, RemoteVersionInfo remoteVersionInfo, String str, boolean z10, String str2, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str2 = "";
        }
        updateVersionRequest.k(activity, remoteVersionInfo, str, z10, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(String str, RemoteVersionInfo remoteVersionInfo, boolean z10) {
        e.f57661a.a(str, z10, "mb");
        if (z10) {
            new hx.a().a(str, Utils.a(), remoteVersionInfo);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(String str, RemoteVersionInfo remoteVersionInfo, boolean z10) {
        e.f57661a.a(str, z10, "mb");
        if (z10) {
            new hx.a().a(str, Utils.a(), remoteVersionInfo);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(final Activity activity, final String str, final RemoteVersionInfo remoteVersionInfo, final boolean z10) {
        String str2;
        if (!UpdateManager.f57641f.a().d()) {
            l(this, activity, remoteVersionInfo, str, z10, null, 16, null);
            return;
        }
        NoticeConfig noticeConfig = remoteVersionInfo.getNoticeConfig();
        if (noticeConfig == null || (str2 = noticeConfig.getUpdateVersionName()) == null) {
            str2 = "";
        }
        gx.a.f64149a.a(str, z10, activity, str2, new Function1() { // from class: com.transsion.version.update.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p11;
                p11 = UpdateVersionRequest.p(UpdateVersionRequest.this, activity, remoteVersionInfo, str, z10, (String) obj);
                return p11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(UpdateVersionRequest updateVersionRequest, Activity activity, RemoteVersionInfo remoteVersionInfo, String str, boolean z10, String errorMsg) {
        Intrinsics.h(errorMsg, "errorMsg");
        updateVersionRequest.k(activity, remoteVersionInfo, str, z10, errorMsg);
        return Unit.f67184a;
    }

    public final a h() {
        return (a) this.f57650c.getValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|(1:(3:10|11|12)(2:44|45))(3:46|47|(1:49)(1:50))|13|(1:15)(1:43)|16|(2:20|(6:24|(1:26)|27|(1:(1:40))(1:31)|32|33))|41|42))|53|6|7|(0)(0)|13|(0)(0)|16|(3:18|20|(9:22|24|(0)|27|(1:29)|(0)|40|32|33))|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x003a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0110, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:11:0x0033, B:13:0x0065, B:15:0x0069, B:16:0x006f, B:18:0x0077, B:20:0x007d, B:22:0x008b, B:24:0x0091, B:26:0x0097, B:27:0x00a6, B:29:0x00ac, B:31:0x00b2, B:32:0x010b, B:38:0x00cd, B:40:0x00d7, B:47:0x0048), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:11:0x0033, B:13:0x0065, B:15:0x0069, B:16:0x006f, B:18:0x0077, B:20:0x007d, B:22:0x008b, B:24:0x0091, B:26:0x0097, B:27:0x00a6, B:29:0x00ac, B:31:0x00b2, B:32:0x010b, B:38:0x00cd, B:40:0x00d7, B:47:0x0048), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(android.app.Activity r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.version.update.UpdateVersionRequest.q(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
