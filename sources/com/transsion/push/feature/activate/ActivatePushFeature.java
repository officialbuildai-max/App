package com.transsion.push.feature.activate;

import android.content.Context;
import android.content.SharedPreferences;
import com.blankj.utilcode.util.c0;
import com.cloud.tmc.integration.net.UrlKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.ad.ps.activate.PSActivateManager;
import com.transsion.ad.ps.activate.PsActivateBean;
import com.transsion.ad.scene.d;
import com.transsion.lib.push.R$string;
import com.transsion.mpush.api.IPushFeature;
import com.transsion.mpush.api.LocalPushMessage;
import ih.b;
import java.util.Calendar;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class ActivatePushFeature implements IPushFeature {

    /* renamed from: d, reason: collision with root package name */
    public static final a f50868d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Context f50869a;

    /* renamed from: b, reason: collision with root package name */
    private final n0 f50870b = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* renamed from: c, reason: collision with root package name */
    private final ActivateNotificationRenderer f50871c = new ActivateNotificationRenderer();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Context context) {
            Intrinsics.h(context, "context");
            long j11 = context.getSharedPreferences("activate_push_prefs", 0).getLong("key_activate_show_time", 0L);
            return j11 != 0 && c0.f(j11);
        }

        public final void b(Context context) {
            Intrinsics.h(context, "context");
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【激活广告推送】记录展示时间", false, 4, null);
            SharedPreferences sharedPreferences = context.getSharedPreferences("activate_push_prefs", 0);
            Intrinsics.g(sharedPreferences, "getSharedPreferences(...)");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("key_activate_show_time", System.currentTimeMillis());
            edit.apply();
        }
    }

    private final boolean b(String str) {
        com.transsion.baseui.util.a aVar = com.transsion.baseui.util.a.f43556a;
        Context context = this.f50869a;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        return aVar.c(context, str);
    }

    private final boolean c() {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonObject b11 = d.f42258a.b("ActivatePushScene");
        int asInt = (b11 == null || (jsonElement2 = b11.get("pushStart")) == null) ? 13 : jsonElement2.getAsInt();
        int asInt2 = (b11 == null || (jsonElement = b11.get("pushSlot")) == null) ? 4 : jsonElement.getAsInt();
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "PushRegisterManager", "【激活广告推送】时间窗口配置：startHour=" + asInt + ", timeSpan=" + asInt2, false, 4, null);
        if (asInt2 <= 0) {
            a.C0856a.f(c0856a, "PushRegisterManager", "【激活广告推送】推送时间跨度为 0，已禁用", false, 4, null);
            return false;
        }
        if (asInt2 >= 24) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        int i11 = (calendar.get(11) * 60) + calendar.get(12);
        int i12 = asInt * 60;
        int i13 = (asInt2 * 60) + i12;
        a.C0856a.f(c0856a, "PushRegisterManager", "【激活广告推送】当前时间 " + calendar.get(11) + ":" + calendar.get(12) + "，转换为分钟：" + i11 + "，窗口：" + i12 + ".." + (i13 <= 1440 ? i13 : i13 % 1440), false, 4, null);
        if (i13 <= 1440) {
            if (i12 > i11 || i11 >= i13) {
                return false;
            }
        } else if (i11 < i12 && i11 >= i13 % 1440) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        Object obj;
        a aVar = f50868d;
        Context context = this.f50869a;
        Context context2 = null;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        if (aVar.a(context)) {
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【激活广告推送】当天已展示，跳过", false, 4, null);
            return;
        }
        if (!c()) {
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【激活广告推送】不在推送时间段内，跳过", false, 4, null);
            return;
        }
        PSActivateManager pSActivateManager = PSActivateManager.f42225a;
        if (!pSActivateManager.d()) {
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【激活广告推送】无可用广告，跳过间隔限制请求广告", false, 4, null);
            f(this, MapsKt.l(TuplesKt.a("reason", "no_ad"), TuplesKt.a("trigger_source", "4")), null, null, 6, null);
            pSActivateManager.f(true);
            return;
        }
        int i11 = 0;
        while (i11 < 10) {
            i11++;
            PsActivateBean b11 = PSActivateManager.f42225a.b();
            if (b11 == null) {
                break;
            }
            if (b(b11.getPackageName())) {
                a.C0856a.r(lg.a.f68962a, "PushRegisterManager", new String[]{"【激活广告推送】有可用广告，准备展示，应用：" + b11.getAppName()}, false, 4, null);
                Pair a11 = TuplesKt.a("reason", "ad_available");
                Pair a12 = TuplesKt.a("trigger_source", "4");
                String packageName = b11.getPackageName();
                if (packageName == null) {
                    packageName = "";
                }
                Pair a13 = TuplesKt.a("packageName", packageName);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    obj = Result.m1185constructorimpl(b.f65364a.i());
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    obj = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Map l11 = MapsKt.l(a11, a12, a13, TuplesKt.a(UrlKt.KEY_MINI_GAID, Result.m1191isFailureimpl(obj) ? "" : obj));
                Context context3 = this.f50869a;
                if (context3 == null) {
                    Intrinsics.z("context");
                    context3 = null;
                }
                String string = context3.getString(R$string.notification_activate_title, b11.getAppName());
                Context context4 = this.f50869a;
                if (context4 == null) {
                    Intrinsics.z("context");
                    context4 = null;
                }
                LocalPushMessage e11 = e(l11, string, context4.getString(R$string.notification_activate_content, b11.getAppName()));
                ActivateNotificationRenderer activateNotificationRenderer = this.f50871c;
                Context context5 = this.f50869a;
                if (context5 == null) {
                    Intrinsics.z("context");
                } else {
                    context2 = context5;
                }
                activateNotificationRenderer.T(context2, e11, b11);
                return;
            }
            a.C0856a.r(lg.a.f68962a, "PushRegisterManager", new String[]{"【激活广告推送】应用未安装，跳过：" + b11.getAppName()}, false, 4, null);
        }
        a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【激活广告推送】有广告但全部未安装，跳过间隔限制请求广告", false, 4, null);
        f(this, MapsKt.l(TuplesKt.a("reason", "ad_unavailable"), TuplesKt.a("trigger_source", "4")), null, null, 6, null);
        PSActivateManager.f42225a.f(true);
    }

    private final LocalPushMessage e(Map map, String str, String str2) {
        LocalPushMessage localPushMessage = new LocalPushMessage(0, null, null, null, null, null, null, null, null, null, 0L, 0, 0L, false, false, null, false, 0, 262143, null);
        localPushMessage.setMessageId("activate_push_message_" + System.currentTimeMillis());
        localPushMessage.setSource("activate_push");
        localPushMessage.setType("activate_push");
        localPushMessage.setExtraMap(new JSONObject(map).toString());
        if (str != null) {
            localPushMessage.setTitle(str);
        }
        if (str2 != null) {
            localPushMessage.setDesc(str2);
        }
        localPushMessage.setDeeplink("oneroom://com.community.oneroom?type=/main/tab&channel=activate_push&utm_source=activate_push");
        ln.b bVar = ln.b.f69110a;
        Context context = this.f50869a;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        bVar.j(context, localPushMessage);
        return localPushMessage;
    }

    static /* synthetic */ LocalPushMessage f(ActivatePushFeature activatePushFeature, Map map, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        return activatePushFeature.e(map, str, str2);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void destroy() {
        o0.d(this.f50870b, null, 1, null);
        this.f50871c.N();
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void init(Context context) {
        Intrinsics.h(context, "context");
        this.f50869a = context;
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onMessageReceive(String str, Object obj) {
        IPushFeature.DefaultImpls.onMessageReceive(this, str, obj);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onTrigger(int i11) {
        if (i11 != 4) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【激活广告推送】收到 TIMER 触发", false, 4, null);
        k.d(this.f50870b, null, null, new ActivatePushFeature$onTrigger$1(this, null), 3, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public boolean refreshMessage(Object message) {
        Intrinsics.h(message, "message");
        return false;
    }
}
