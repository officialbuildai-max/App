package com.transsion.mpush.core.renderer;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.g0;
import com.blankj.utilcode.util.a0;
import com.transsion.mpush.R$string;
import com.transsion.mpush.api.PermanentPushMessage;
import com.transsion.mpush.core.activity.SdkPushClickActivity;
import com.transsion.mpush.core.config.PermanentConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import org.mvel2.ast.ASTNode;

/* loaded from: classes6.dex */
public abstract class AbsPermanentNotificationRenderer extends i {

    /* renamed from: h, reason: collision with root package name */
    public static final a f47604h = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private volatile long f47606d;

    /* renamed from: c, reason: collision with root package name */
    private final n0 f47605c = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* renamed from: e, reason: collision with root package name */
    private volatile String f47607e = "";

    /* renamed from: f, reason: collision with root package name */
    private int f47608f = 600000;

    /* renamed from: g, reason: collision with root package name */
    private final int f47609g = a0.a(100.0f);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(final Context context, List list, List list2, PermanentConfig permanentConfig) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        boolean z10 = true;
        try {
            final String x10 = x();
            d(context, x10, new Function0() { // from class: com.transsion.mpush.core.renderer.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit F;
                    F = AbsPermanentNotificationRenderer.F(AbsPermanentNotificationRenderer.this, context, x10);
                    return F;
                }
            });
            NotificationCompat.m I = a(context, x10).y("PermanentGroup").z(false).E(true).l(false).I(false);
            Intrinsics.g(I, "setShowWhen(...)");
            PermanentPushMessage permanentPushMessage = (PermanentPushMessage) CollectionsKt.k0(list);
            if (permanentPushMessage == null || !permanentPushMessage.getIsRefresh()) {
                I.t(-1);
            } else {
                a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "[AbsPermanentNotificationRenderer] internalShow -> Silent Refresh", false, 4, null);
                I.F(true);
                I.t(0);
                I.K(null);
                I.N(new long[]{0});
            }
            Integer z11 = z(list);
            Integer A = A(list);
            if (z11 == null && A == null) {
                a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "internalShow: using default style", false, 4, null);
                I(I, list, list2, permanentConfig);
            } else {
                a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "internalShow: using custom views collapsed=" + z11 + ", expanded=" + A, false, 4, null);
                String packageName = context.getPackageName();
                if (z11 != null) {
                    remoteViews = new RemoteViews(packageName, z11.intValue());
                    I.s(remoteViews);
                } else {
                    remoteViews = null;
                }
                if (A != null) {
                    RemoteViews remoteViews3 = new RemoteViews(packageName, A.intValue());
                    I.r(remoteViews3);
                    remoteViews2 = remoteViews3;
                } else {
                    remoteViews2 = null;
                }
                I.L(new NotificationCompat.o());
                I.O(1);
                I.G(2);
                if (Build.VERSION.SDK_INT >= 26) {
                    I.t(0);
                }
                s(context, remoteViews, remoteViews2, list, list2, permanentConfig);
            }
            I.o(w(this, context, null, B(), "10010", 2, null));
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【常驻渲染】常驻通知发送成功，通知ID：10010，消息数：" + list.size(), false, 4, null);
            i(context, 10010, I);
            String C = C(list);
            if (!Intrinsics.c(C, this.f47607e)) {
                this.f47607e = C;
                PermanentPushMessage permanentPushMessage2 = (PermanentPushMessage) CollectionsKt.k0(list);
                if (permanentPushMessage2 != null) {
                    List list3 = list2;
                    if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                        Iterator it = list3.iterator();
                        while (it.hasNext()) {
                            if (((Bitmap) it.next()) != null) {
                                break;
                            }
                        }
                    }
                    z10 = false;
                    ln.b.f69110a.i(context, permanentPushMessage2, x10, z10);
                }
            }
            this.f47606d = System.currentTimeMillis();
            PermanentPushMessage permanentPushMessage3 = (PermanentPushMessage) CollectionsKt.k0(list);
            if (permanentPushMessage3 == null || permanentPushMessage3.getIsRefresh() || !ln.a.f69101a.i().getEnableRefresh()) {
                return;
            }
            Intent intent = new Intent("com.transsion.mpush.action.NEW_MESSAGE");
            intent.putExtra("message", permanentPushMessage3);
            r1.a.b(context).d(intent);
        } catch (Exception e11) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "internalShow: failed " + e11, false, 4, null);
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(AbsPermanentNotificationRenderer absPermanentNotificationRenderer, Context context, String str) {
        absPermanentNotificationRenderer.u(context, str);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x008f A[PHI: r0
      0x008f: PHI (r0v10 java.lang.Object) = (r0v9 java.lang.Object), (r0v1 java.lang.Object) binds: [B:17:0x008c, B:10:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object H(com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer r17, android.content.Context r18, java.util.List r19, kotlin.coroutines.Continuation r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer$loadImages$1
            if (r1 == 0) goto L17
            r1 = r0
            com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer$loadImages$1 r1 = (com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer$loadImages$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r5 = r17
            goto L1e
        L17:
            com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer$loadImages$1 r1 = new com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer$loadImages$1
            r5 = r17
            r1.<init>(r5, r0)
        L1e:
            java.lang.Object r0 = r1.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r1.label
            r9 = 2
            r10 = 1
            if (r2 == 0) goto L3e
            if (r2 == r10) goto L3a
            if (r2 != r9) goto L32
            kotlin.ResultKt.b(r0)
            goto L8f
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            kotlin.ResultKt.b(r0)
            goto L82
        L3e:
            kotlin.ResultKt.b(r0)
            int r0 = r19.size()
            r2 = 10
            int r3 = kotlin.ranges.RangesKt.i(r0, r2)
            lg.a$a r11 = lg.a.f68962a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "loadImages: starting load for "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r2 = " images"
            r0.append(r2)
            java.lang.String r13 = r0.toString()
            r15 = 4
            r16 = 0
            java.lang.String r12 = "M_PUSH_SDK"
            r14 = 0
            lg.a.C0856a.f(r11, r12, r13, r14, r15, r16)
            com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer$loadImages$deferredList$1 r0 = new com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer$loadImages$deferredList$1
            r7 = 0
            r2 = r0
            r4 = r19
            r5 = r17
            r6 = r18
            r2.<init>(r3, r4, r5, r6, r7)
            r1.label = r10
            java.lang.Object r0 = kotlinx.coroutines.o0.e(r0, r1)
            if (r0 != r8) goto L82
            return r8
        L82:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            r1.label = r9
            java.lang.Object r0 = kotlinx.coroutines.f.a(r0, r1)
            if (r0 != r8) goto L8f
            return r8
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer.H(com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer, android.content.Context, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(AbsPermanentNotificationRenderer absPermanentNotificationRenderer, Context context, String str) {
        absPermanentNotificationRenderer.u(context, str);
        return Unit.f67184a;
    }

    public static /* synthetic */ PendingIntent w(AbsPermanentNotificationRenderer absPermanentNotificationRenderer, Context context, PermanentPushMessage permanentPushMessage, String str, String str2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPermanentClickIntent");
        }
        if ((i11 & 2) != 0) {
            permanentPushMessage = null;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        return absPermanentNotificationRenderer.v(context, permanentPushMessage, str, str2);
    }

    public Integer A(List messages) {
        Intrinsics.h(messages, "messages");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String B() {
        String mainDeepLink = ln.a.f69101a.i().getMainDeepLink();
        if (mainDeepLink == null || mainDeepLink.length() <= 0) {
            return null;
        }
        return mainDeepLink + "&channel=permanent_push&msgId=111&msg_type=11";
    }

    protected final String C(List messages) {
        Intrinsics.h(messages, "messages");
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        for (Object obj : messages) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            PermanentPushMessage permanentPushMessage = (PermanentPushMessage) obj;
            if (i11 <= 9) {
                sb2.append(permanentPushMessage.getSubjectId());
            }
            i11 = i12;
        }
        com.transsion.mpush.core.utils.c cVar = com.transsion.mpush.core.utils.c.f47679a;
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return cVar.d(sb3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int D() {
        return this.f47609g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object G(Context context, List list, Continuation continuation) {
        return H(this, context, list, continuation);
    }

    public void I(NotificationCompat.m builder, List messages, List bitmaps, PermanentConfig permanentConfig) {
        Intrinsics.h(builder, "builder");
        Intrinsics.h(messages, "messages");
        Intrinsics.h(bitmaps, "bitmaps");
    }

    public final void J(Context context, List messages, PermanentConfig permanentConfig) {
        Intrinsics.h(context, "context");
        Intrinsics.h(messages, "messages");
        if (messages.isEmpty()) {
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "【常驻渲染】消息列表为空，跳过渲染", false, 4, null);
            return;
        }
        String C = C(messages);
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.l(c0856a, "M_PUSH_SDK", "【常驻渲染】开始渲染常驻通知，消息数：" + messages.size() + "，消息ID：" + C, false, 4, null);
        if (!Intrinsics.c(C, this.f47607e) || System.currentTimeMillis() - this.f47606d >= this.f47608f) {
            kotlinx.coroutines.k.d(this.f47605c, null, null, new AbsPermanentNotificationRenderer$show$1(messages, this, context, permanentConfig, null), 3, null);
        } else {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "【常驻渲染】相同内容刷新频率限制，跳过渲染", false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.mpush.core.renderer.i
    public void c(Context context, String channelId, String name, int i11, String str) {
        NotificationChannel notificationChannel;
        Intrinsics.h(context, "context");
        Intrinsics.h(channelId, "channelId");
        Intrinsics.h(name, "name");
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = context.getSystemService("notification");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            notificationChannel = notificationManager.getNotificationChannel(channelId);
            if (notificationChannel != null) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "createNotificationChannel: creating channel " + channelId + " (" + name + ")", false, 4, null);
            g0.a();
            NotificationChannel a11 = m.f.a(channelId, name, i11);
            a11.setDescription(str);
            a11.enableLights(false);
            a11.enableVibration(false);
            a11.setShowBadge(false);
            a11.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(a11);
        }
    }

    @Override // com.transsion.mpush.core.renderer.i
    public void l(final Context context) {
        Intrinsics.h(context, "context");
        final String x10 = x();
        d(context, x10, new Function0() { // from class: com.transsion.mpush.core.renderer.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit K;
                K = AbsPermanentNotificationRenderer.K(AbsPermanentNotificationRenderer.this, context, x10);
                return K;
            }
        });
    }

    public void s(Context context, RemoteViews remoteViews, RemoteViews remoteViews2, List messages, List bitmaps, PermanentConfig permanentConfig) {
        Intrinsics.h(context, "context");
        Intrinsics.h(messages, "messages");
        Intrinsics.h(bitmaps, "bitmaps");
    }

    public final void t(Context context) {
        Intrinsics.h(context, "context");
        androidx.core.app.t.d(context).b(10010);
    }

    protected void u(Context context, String channelId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(channelId, "channelId");
        c(context, channelId, y(context), 4, context.getString(R$string.push_channel_permanent_desc));
    }

    protected final PendingIntent v(Context context, PermanentPushMessage permanentPushMessage, String str, String str2) {
        String subjectId;
        Intrinsics.h(context, "context");
        Intent intent = new Intent(context, (Class<?>) SdkPushClickActivity.class);
        intent.putExtra("msg_id", str2 == null ? permanentPushMessage != null ? permanentPushMessage.getSubjectId() : null : str2);
        intent.putExtra("msg_uri", str == null ? permanentPushMessage != null ? permanentPushMessage.getDeeplink() : null : str);
        intent.putExtra("is_permanent", true);
        intent.putExtra("permanent_id", permanentPushMessage != null ? permanentPushMessage.getSubjectId() : null);
        intent.putExtra("msg_type", 11);
        intent.setFlags(ASTNode.DEOP);
        if (permanentPushMessage != null && (subjectId = permanentPushMessage.getSubjectId()) != null) {
            str2 = subjectId;
        }
        return i.n(this, context, intent, (str2 + str).hashCode(), false, 8, null);
    }

    protected String x() {
        return "push_sdk_permanent";
    }

    protected String y(Context context) {
        Intrinsics.h(context, "context");
        String string = context.getString(R$string.push_channel_permanent_name);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public Integer z(List messages) {
        Intrinsics.h(messages, "messages");
        return null;
    }
}
