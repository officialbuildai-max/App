package com.transsion.push.feature.activate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.a0;
import com.transsion.ad.ps.activate.PsActivateBean;
import com.transsion.lib.push.R$id;
import com.transsion.lib.push.R$layout;
import com.transsion.lib.push.R$string;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.renderer.AbsNotificationRenderer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class ActivateNotificationRenderer extends AbsNotificationRenderer {

    /* renamed from: f, reason: collision with root package name */
    public static final a f50866f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final n0 f50867e = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void L(Context context, RemoteViews remoteViews, PsActivateBean psActivateBean, LocalPushMessage localPushMessage, Bitmap bitmap) {
        String title;
        String title2;
        String str;
        int i11 = R$id.notification_title_tv;
        int i12 = R$string.notification_activate_title;
        if (psActivateBean == null || (title = psActivateBean.getAppName()) == null) {
            title = localPushMessage.getTitle();
        }
        remoteViews.setTextViewText(i11, context.getString(i12, title));
        int i13 = R$id.notification_content_tv;
        int i14 = R$string.notification_activate_content;
        if (psActivateBean == null || (title2 = psActivateBean.getAppName()) == null) {
            title2 = localPushMessage.getTitle();
        }
        remoteViews.setTextViewText(i13, context.getString(i14, title2));
        int i15 = R$id.btn_activate_cta;
        if (psActivateBean == null || (str = psActivateBean.getButtonText()) == null) {
            str = "OPEN";
        }
        remoteViews.setTextViewText(i15, str);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R$id.iv_activate_icon, bitmap);
        }
    }

    private final Bitmap M(Bitmap bitmap, float f11) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), f11, f11, paint);
        return createBitmap;
    }

    private final String O(String str, String str2) {
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("clickArea", str2);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.e(jSONObject2);
            return jSONObject2;
        } catch (Exception unused) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("clickArea", str2);
            String jSONObject4 = jSONObject3.toString();
            Intrinsics.e(jSONObject4);
            return jSONObject4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(final Context context, LocalPushMessage localPushMessage, Bitmap bitmap, Object obj) {
        String d11 = d(context, "push_sdk_activate_channel", new Function0() { // from class: com.transsion.push.feature.activate.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Q;
                Q = ActivateNotificationRenderer.Q(ActivateNotificationRenderer.this, context);
                return Q;
            }
        });
        NotificationCompat.m a11 = a(context, d11);
        a11.J(g());
        if (localPushMessage.isRefresh()) {
            a11.F(true);
            a11.t(0);
            a11.K(null);
            a11.N(new long[]{0});
        } else {
            a11.t(-1);
        }
        a11.q(localPushMessage.getTitle());
        a11.p(localPushMessage.getDesc());
        int intValue = v(localPushMessage).intValue();
        int intValue2 = w(localPushMessage).intValue();
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), intValue);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), intValue2);
        a11.s(remoteViews);
        a11.r(remoteViews2);
        a11.L(new NotificationCompat.o());
        q(context, remoteViews, remoteViews2, localPushMessage, bitmap, obj);
        int e11 = e(localPushMessage.getMessageId());
        PendingIntent s11 = s(context, localPushMessage);
        if (s11 == null) {
            Intent b11 = b(context, localPushMessage, e11, d11);
            PsActivateBean psActivateBean = obj instanceof PsActivateBean ? (PsActivateBean) obj : null;
            String packageName = psActivateBean != null ? psActivateBean.getPackageName() : null;
            if (packageName != null) {
                S(b11, packageName, "content", localPushMessage);
            }
            s11 = m(context, b11, e11, false);
        }
        a11.o(s11);
        i(context, e11, a11);
        F(context, localPushMessage);
        E(context, localPushMessage, d11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(ActivateNotificationRenderer activateNotificationRenderer, Context context) {
        activateNotificationRenderer.r(context, "push_sdk_activate_channel");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap R(Bitmap bitmap, int i11) {
        if (bitmap == null) {
            return null;
        }
        float f11 = i11;
        float min = Math.min(f11 / bitmap.getWidth(), f11 / bitmap.getHeight());
        return min >= 1.0f ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), true);
    }

    private final void S(Intent intent, String str, String str2, LocalPushMessage localPushMessage) {
        LocalPushMessage copy;
        String O = O(localPushMessage.getExtraMap(), str2);
        intent.putExtra("target_package_name", str);
        intent.putExtra("clickArea", str2);
        intent.putExtra("msg_extra_map", O);
        String deeplink = localPushMessage.getDeeplink();
        if (deeplink != null) {
            intent.putExtra("deeplink", deeplink);
        }
        copy = localPushMessage.copy((r38 & 1) != 0 ? localPushMessage.id : 0, (r38 & 2) != 0 ? localPushMessage.messageId : null, (r38 & 4) != 0 ? localPushMessage.title : null, (r38 & 8) != 0 ? localPushMessage.desc : null, (r38 & 16) != 0 ? localPushMessage.deeplink : null, (r38 & 32) != 0 ? localPushMessage.imageList : null, (r38 & 64) != 0 ? localPushMessage.pushTime : null, (r38 & 128) != 0 ? localPushMessage.source : null, (r38 & 256) != 0 ? localPushMessage.style : null, (r38 & 512) != 0 ? localPushMessage.type : null, (r38 & 1024) != 0 ? localPushMessage.receiveTime : 0L, (r38 & 2048) != 0 ? localPushMessage.msgStatus : 0, (r38 & 4096) != 0 ? localPushMessage.showTime : 0L, (r38 & 8192) != 0 ? localPushMessage.forceShow : false, (r38 & 16384) != 0 ? localPushMessage.hasScreenOn : false, (r38 & 32768) != 0 ? localPushMessage.extraMap : O, (r38 & 65536) != 0 ? localPushMessage.builtIn : false, (r38 & 131072) != 0 ? localPushMessage.permanentMsgStatus : 0);
        intent.putExtra("push_message", copy);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public void E(Context context, LocalPushMessage message, String str, String str2) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        super.E(context, message, str, str2);
        ActivatePushFeature.f50868d.b(context);
    }

    public final void N() {
        o0.d(this.f50867e, null, 1, null);
    }

    public final void T(Context context, LocalPushMessage message, PsActivateBean adBean) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        Intrinsics.h(adBean, "adBean");
        String iconUrl = adBean.getIconUrl();
        if (iconUrl == null || iconUrl.length() == 0) {
            P(context, message, null, adBean);
        } else {
            k.d(this.f50867e, null, null, new ActivateNotificationRenderer$show$1(this, context, iconUrl, message, adBean, null), 3, null);
        }
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public void q(Context context, RemoteViews remoteViews, RemoteViews remoteViews2, LocalPushMessage message, Bitmap bitmap, Object obj) {
        String packageName;
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        PsActivateBean psActivateBean = obj instanceof PsActivateBean ? (PsActivateBean) obj : null;
        Bitmap M = bitmap != null ? M(bitmap, a0.a(8.0f)) : null;
        if (remoteViews != null) {
            L(context, remoteViews, psActivateBean, message, M);
        }
        if (remoteViews2 != null) {
            L(context, remoteViews2, psActivateBean, message, M);
        }
        if (psActivateBean == null || (packageName = psActivateBean.getPackageName()) == null) {
            return;
        }
        int e11 = e(message.getMessageId()) + 1;
        Intent b11 = b(context, message, e11, t());
        S(b11, packageName, "button", message);
        PendingIntent m11 = m(context, b11, e11, false);
        if (remoteViews != null) {
            remoteViews.setOnClickPendingIntent(R$id.btn_activate_cta, m11);
        }
        if (remoteViews2 != null) {
            remoteViews2.setOnClickPendingIntent(R$id.btn_activate_cta, m11);
        }
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer, com.transsion.mpush.api.INotificationRenderer
    public void show(Context context, LocalPushMessage message) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        a.C0856a.z(lg.a.f68962a, "ActivateNotificationRenderer", "不应直接调用，请使用 show(context, message, adBean)", false, 4, null);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    protected String t() {
        return "push_sdk_activate_channel";
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    protected String u() {
        return "激活广告推送";
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public Integer v(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        return Integer.valueOf(R$layout.notification_activate);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public Integer w(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        return Integer.valueOf(R$layout.notification_activate);
    }
}
