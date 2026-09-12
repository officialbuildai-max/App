package ln;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import androidx.core.app.t;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.mpush.api.IPushReportInterceptor;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.api.PermanentPushMessage;
import com.transsion.mpush.core.config.MsgShowStatus;
import com.transsion.mpush.core.config.PushMsgSource;
import com.transsion.mpush.core.config.PushMsgType;
import com.transsion.push.PushConstants;
import com.transsion.push.PushManager;
import hj.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f69110a = new b();

    private b() {
    }

    private final boolean a(Context context) {
        try {
            return t.d(context).a();
        } catch (Exception unused) {
            return true;
        }
    }

    private final Map b(Context context, LocalPushMessage localPushMessage) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String messageId = localPushMessage.getMessageId();
        if (messageId == null) {
            messageId = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, messageId);
        String source = localPushMessage.getSource();
        if (source == null) {
            source = "";
        }
        linkedHashMap.put(EventConstants.KEY_SOURCE, source);
        String type = localPushMessage.getType();
        if (type == null) {
            type = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_TYPE, type);
        String style = localPushMessage.getStyle();
        if (style == null) {
            style = "";
        }
        linkedHashMap.put(TtmlNode.TAG_STYLE, style);
        String deeplink = localPushMessage.getDeeplink();
        linkedHashMap.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, deeplink != null ? deeplink : "");
        linkedHashMap.put("are_notify_enabled", a(context) ? "1" : "0");
        linkedHashMap.put("module_name", "notification");
        linkedHashMap.put("is_permanent", "false");
        return linkedHashMap;
    }

    private final Map c(Context context, PermanentPushMessage permanentPushMessage) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String subjectId = permanentPushMessage.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, subjectId);
        linkedHashMap.put(EventConstants.KEY_SOURCE, PushMsgSource.SOURCE_PUSH);
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_TYPE, PushMsgType.PERMANENT.getType());
        linkedHashMap.put(TtmlNode.TAG_STYLE, "1");
        String deeplink = permanentPushMessage.getDeeplink();
        linkedHashMap.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, deeplink != null ? deeplink : "");
        linkedHashMap.put("are_notify_enabled", a(context) ? "1" : "0");
        linkedHashMap.put("module_name", "notification");
        linkedHashMap.put("is_permanent", "true");
        return linkedHashMap;
    }

    private final void f(Object obj, Map map) {
        try {
            IPushReportInterceptor g11 = a.f69101a.g();
            if (g11 != null) {
                if (g11.intercept(obj, map)) {
                    return;
                }
            }
        } catch (Exception e11) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "PushSdkTracker interceptor failed: " + e11, false, 4, null);
            e11.printStackTrace();
        }
        try {
            i.f64628a.s("notification", PushMsgSource.SOURCE_PUSH, map);
        } catch (Exception e12) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "PushSdkTracker report failed: " + e12, false, 4, null);
            e12.printStackTrace();
        }
    }

    public final void d(String str, boolean z10) {
        Long x10;
        PushManager.getInstance().trackShow((str == null || (x10 = StringsKt.x(str)) == null) ? 0L : x10.longValue(), z10 ? 0 : 7);
    }

    public final String e(Context context) {
        Intrinsics.h(context, "context");
        try {
            Object systemService = context.getSystemService("power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            Object systemService2 = context.getSystemService("keyguard");
            KeyguardManager keyguardManager = systemService2 instanceof KeyguardManager ? (KeyguardManager) systemService2 : null;
            if (powerManager != null && keyguardManager != null) {
                return !powerManager.isInteractive() ? "1" : keyguardManager.isKeyguardLocked() ? "2" : "3";
            }
            return "0";
        } catch (Exception unused) {
            return TmcConstants.COLD_OPEN_TYPE;
        }
    }

    public final void g(Context context, LocalPushMessage message, String str, String str2) {
        Long x10;
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        if (Intrinsics.c(str2, PushMsgSource.SOURCE_FCM_PUSH)) {
            PushManager pushManager = PushManager.getInstance();
            String messageId = message.getMessageId();
            pushManager.trackClick((messageId == null || (x10 = StringsKt.x(messageId)) == null) ? 0L : x10.longValue());
            return;
        }
        Map b11 = b(context, message);
        b11.put(EventConstants.KEY_ACTION, "click");
        if (str == null) {
            str = "push_sdk_default_channel";
        }
        b11.put("channel_id", str);
        b11.put("screen_status", e(context));
        if (str2 != null && str2.length() != 0) {
            b11.put(EventConstants.KEY_SOURCE, str2);
        }
        b11.put("is_permanent", "false");
        f(message, b11);
    }

    public final void h(Context context, PermanentPushMessage message, String str, String str2) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        Map c11 = c(context, message);
        c11.put(EventConstants.KEY_ACTION, "click");
        if (str == null) {
            str = "push_sdk_permanent_channel";
        }
        c11.put("channel_id", str);
        c11.put("screen_status", e(context));
        if (str2 != null && str2.length() != 0) {
            c11.put(EventConstants.KEY_SOURCE, str2);
        }
        c11.put("is_permanent", "true");
        f(message, c11);
    }

    public final void i(Context context, PermanentPushMessage message, String str, boolean z10) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        Map c11 = c(context, message);
        c11.put(EventConstants.KEY_ACTION, "exposure");
        if (str == null) {
            str = "";
        }
        c11.put("channel_id", str);
        c11.put(TrackingKey.SHOW_STATUS, !a(context) ? MsgShowStatus.STATUS_NOTIFY_CLOSE : !z10 ? MsgShowStatus.STATUS_IMG_ERROR : MsgShowStatus.STATUS_OK);
        c11.put("screen_status", e(context));
        f(message, c11);
    }

    public final void j(Context context, LocalPushMessage message) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        Map b11 = b(context, message);
        b11.put(EventConstants.KEY_ACTION, "receive");
        f(message, b11);
    }

    public final void k(Context context, LocalPushMessage message, String str, String str2) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        Map b11 = b(context, message);
        b11.put(EventConstants.KEY_ACTION, "exposure");
        if (str == null) {
            str = "";
        }
        b11.put("channel_id", str);
        if (!a(context)) {
            str2 = MsgShowStatus.STATUS_NOTIFY_CLOSE;
        } else if (str2 == null || str2.length() == 0) {
            str2 = MsgShowStatus.STATUS_OK;
        }
        b11.put(TrackingKey.SHOW_STATUS, str2);
        b11.put("screen_status", e(context));
        b11.put("is_permanent", "false");
        f(message, b11);
    }
}
