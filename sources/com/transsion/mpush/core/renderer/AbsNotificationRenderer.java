package com.transsion.mpush.core.renderer;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.transsion.mpush.R$string;
import com.transsion.mpush.api.INotificationRenderer;
import com.transsion.mpush.api.IPushImageLoader;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.config.MsgShowStatus;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public abstract class AbsNotificationRenderer extends i implements INotificationRenderer {

    /* renamed from: d, reason: collision with root package name */
    public static final a f47599d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private final n0 f47600c = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements IPushImageLoader.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocalPushMessage f47601a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbsNotificationRenderer f47602b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f47603c;

        b(LocalPushMessage localPushMessage, AbsNotificationRenderer absNotificationRenderer, Context context) {
            this.f47601a = localPushMessage;
            this.f47602b = absNotificationRenderer;
            this.f47603c = context;
        }

        @Override // com.transsion.mpush.api.IPushImageLoader.Callback
        public void onFailed(Exception exc) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【渲染层】图片加载失败，消息ID：" + this.f47601a.getMessageId() + "，异常：" + exc, false, 4, null);
            AbsNotificationRenderer.A(this.f47602b, this.f47603c, this.f47601a, null, null, 8, null);
        }

        @Override // com.transsion.mpush.api.IPushImageLoader.Callback
        public void onSuccess(Bitmap bitmap) {
            Intrinsics.h(bitmap, "bitmap");
            a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【渲染层】图片加载成功，消息ID：" + this.f47601a.getMessageId() + "，图片尺寸：" + bitmap.getWidth() + "x" + bitmap.getHeight()}, false, 4, null);
            AbsNotificationRenderer.A(this.f47602b, this.f47603c, this.f47601a, bitmap, null, 8, null);
        }
    }

    public static /* synthetic */ void A(AbsNotificationRenderer absNotificationRenderer, Context context, LocalPushMessage localPushMessage, Bitmap bitmap, Object obj, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: internalShow");
        }
        if ((i11 & 8) != 0) {
            obj = null;
        }
        absNotificationRenderer.z(context, localPushMessage, bitmap, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(AbsNotificationRenderer absNotificationRenderer, Context context, String str) {
        absNotificationRenderer.r(context, str);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(AbsNotificationRenderer absNotificationRenderer, Context context, String str) {
        absNotificationRenderer.r(context, str);
        return Unit.f67184a;
    }

    public void C(Context context, LocalPushMessage message, String str, Exception e11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        Intrinsics.h(e11, "e");
    }

    public void D(NotificationCompat.m builder, LocalPushMessage message, Bitmap bitmap) {
        Intrinsics.h(builder, "builder");
        Intrinsics.h(message, "message");
    }

    public void E(Context context, LocalPushMessage message, String str, String str2) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        ln.b.f69110a.k(context, message, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(Context context, LocalPushMessage msgBean) {
        Intrinsics.h(context, "context");
        Intrinsics.h(msgBean, "msgBean");
        kotlinx.coroutines.k.d(this.f47600c, null, null, new AbsNotificationRenderer$updateMsgStatus$1(msgBean, context, null), 3, null);
    }

    @Override // com.transsion.mpush.core.renderer.i
    public void l(final Context context) {
        Intrinsics.h(context, "context");
        final String t11 = t();
        d(context, t11, new Function0() { // from class: com.transsion.mpush.core.renderer.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit G;
                G = AbsNotificationRenderer.G(AbsNotificationRenderer.this, context, t11);
                return G;
            }
        });
    }

    public void q(Context context, RemoteViews remoteViews, RemoteViews remoteViews2, LocalPushMessage message, Bitmap bitmap, Object obj) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(Context context, String channelId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(channelId, "channelId");
        c(context, channelId, u(), 4, context.getString(R$string.push_channel_standard_desc));
    }

    public PendingIntent s(Context context, LocalPushMessage message) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        return null;
    }

    @Override // com.transsion.mpush.api.INotificationRenderer
    public void show(Context context, LocalPushMessage message) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.l(c0856a, "M_PUSH_SDK", "【渲染层】开始渲染通知，消息ID：" + message.getMessageId() + "，消息类型：" + message.getStyle() + "，标题：" + message.getTitle(), false, 4, null);
        String x10 = x(message);
        int y10 = y(context, message);
        if (x10 == null || x10.length() == 0) {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "【渲染层】消息无图片，直接展示，消息ID：" + message.getMessageId(), false, 4, null);
            A(this, context, message, null, null, 8, null);
            return;
        }
        a.C0856a.r(c0856a, "M_PUSH_SDK", new String[]{"【渲染层】开始加载图片，消息ID：" + message.getMessageId() + "，图片URL：" + x10}, false, 4, null);
        ln.a.f69101a.f().loadImage(context, x10, Integer.valueOf(y10), new b(message, this, context));
    }

    protected String t() {
        return "push_sdk_standard_channel";
    }

    protected String u() {
        String string = Utils.a().getString(R$string.push_channel_standard_name);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public Integer v(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        return null;
    }

    public Integer w(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        return null;
    }

    protected String x(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        List imageArray = message.getImageArray();
        if (imageArray.isEmpty()) {
            return null;
        }
        return (String) imageArray.get(0);
    }

    protected int y(Context context, LocalPushMessage message) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        return Intrinsics.c(message.getStyle(), LocalPushMessage.STYLE_VERTICAL_TYPE) ? a0.a(100.0f) : y.e() - a0.a(80.0f);
    }

    public final void z(final Context context, LocalPushMessage message, Bitmap bitmap, Object obj) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        RemoteViews remoteViews3;
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "M_PUSH_SDK", "[AbsNotificationRenderer] internalShow -> Start. Bitmap Present: " + (bitmap != null), false, 4, null);
        final String t11 = t();
        try {
            String d11 = d(context, t11, new Function0() { // from class: com.transsion.mpush.core.renderer.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit B;
                    B = AbsNotificationRenderer.B(AbsNotificationRenderer.this, context, t11);
                    return B;
                }
            });
            try {
                NotificationCompat.m J = a(context, d11).J(g());
                Intrinsics.g(J, "setSmallIcon(...)");
                RemoteViews remoteViews4 = null;
                if (message.isRefresh()) {
                    a.C0856a.f(c0856a, "M_PUSH_SDK", "【渲染层】静默刷新模式，关闭声音和震动，消息ID：" + message.getMessageId(), false, 4, null);
                    J.F(true);
                    J.t(0);
                    remoteViews4 = null;
                    J.K(null);
                    J.N(new long[]{0});
                } else {
                    J.t(-1);
                }
                Integer v11 = v(message);
                Integer w11 = w(message);
                if (v11 == null && w11 == null) {
                    remoteViews = remoteViews4;
                    a.C0856a.f(c0856a, "M_PUSH_SDK", "【渲染层】使用默认样式，消息ID：" + message.getMessageId(), false, 4, null);
                    D(J, message, bitmap);
                } else {
                    remoteViews = remoteViews4;
                    a.C0856a.r(c0856a, "M_PUSH_SDK", new String[]{"【渲染层】使用自定义布局，消息ID：" + message.getMessageId() + "，收起态ID：" + v11 + "，展开态ID：" + w11}, false, 4, null);
                    String packageName = context.getPackageName();
                    if (v11 != null) {
                        RemoteViews remoteViews5 = new RemoteViews(packageName, v11.intValue());
                        J.s(remoteViews5);
                        remoteViews2 = remoteViews5;
                    } else {
                        remoteViews2 = remoteViews;
                    }
                    if (w11 != null) {
                        RemoteViews remoteViews6 = new RemoteViews(packageName, w11.intValue());
                        J.r(remoteViews6);
                        remoteViews3 = remoteViews6;
                    } else {
                        remoteViews3 = remoteViews;
                    }
                    J.L(new NotificationCompat.o());
                    q(context, remoteViews2, remoteViews3, message, bitmap, obj);
                }
                PendingIntent s11 = s(context, message);
                if (s11 == null) {
                    int e11 = e(message.getMessageId());
                    s11 = i.n(this, context, b(context, message, e11, d11), e11, false, 8, null);
                }
                J.o(s11);
                int e12 = e(message.getMessageId());
                a.C0856a.l(c0856a, "M_PUSH_SDK", "【渲染层】通知发送成功，消息ID：" + message.getMessageId() + "，通知ID：" + e12, false, 4, null);
                i(context, e12, J);
                if (message.getMessageId() != null) {
                    F(context, message);
                }
                a.C0856a.f(c0856a, "M_PUSH_SDK", "[AbsNotificationRenderer] internalShow ->refresh msg can:" + message.isRefresh(), false, 4, null);
                if (message.isRefresh()) {
                    return;
                }
                E(context, message, d11, bitmap == null ? MsgShowStatus.STATUS_IMG_ERROR : remoteViews);
                if (ln.a.f69101a.i().getEnableRefresh()) {
                    Intent intent = new Intent("com.transsion.mpush.action.NEW_MESSAGE");
                    intent.putExtra("message", message);
                    r1.a.b(context).d(intent);
                    a.C0856a.f(c0856a, "M_PUSH_SDK", "[AbsNotificationRenderer] internalShow -> Broadcast sent for refresh", false, 4, null);
                }
            } catch (Exception e13) {
                e = e13;
                t11 = d11;
                a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "[AbsNotificationRenderer] internalShow -> Failed: " + e, false, 4, null);
                e.printStackTrace();
                C(context, message, t11, e);
            }
        } catch (Exception e14) {
            e = e14;
        }
    }
}
