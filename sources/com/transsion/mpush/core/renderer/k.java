package com.transsion.mpush.core.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.transsion.mpush.R$string;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.config.MsgShowStatus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public class k extends AbsNotificationRenderer {

    /* renamed from: f, reason: collision with root package name */
    public static final a f47626f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f47627e = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.renderer.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            s J;
            J = k.J();
            return J;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final s I() {
        return (s) this.f47627e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s J() {
        return new s();
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public void C(Context context, LocalPushMessage message, String str, Exception e11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        Intrinsics.h(e11, "e");
        a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【FCM渲染】消息图片加载失败，消息ID：" + message.getMessageId() + "，异常：" + e11, false, 4, null);
        ln.b.f69110a.d(message.getMessageId(), false);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public void D(NotificationCompat.m builder, LocalPushMessage message, Bitmap bitmap) {
        Intrinsics.h(builder, "builder");
        Intrinsics.h(message, "message");
        I().D(builder, message, bitmap);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public void E(Context context, LocalPushMessage message, String str, String str2) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        if (str2 == null) {
            str2 = MsgShowStatus.STATUS_OK;
        }
        boolean isShowStatus = MsgShowStatus.INSTANCE.isShowStatus(str2);
        a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【FCM渲染】消息展示埋点上报，消息ID：" + message.getMessageId() + "，showStatus：" + str2 + "，成功：" + isShowStatus}, false, 4, null);
        ln.b.f69110a.d(message.getMessageId(), isShowStatus);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public void q(Context context, RemoteViews remoteViews, RemoteViews remoteViews2, LocalPushMessage message, Bitmap bitmap, Object obj) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        I().q(context, remoteViews, remoteViews2, message, bitmap, obj);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    protected String t() {
        return "push_sdk_fcm_channel";
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    protected String u() {
        String string = Utils.a().getString(R$string.push_channel_fcm_name);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public Integer v(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        return I().v(message);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public Integer w(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        return I().w(message);
    }
}
