package com.transsion.mpush.core.features;

import android.content.Context;
import com.transsion.mpush.api.IFcmMessageInterceptor;
import com.transsion.mpush.api.INotificationRenderer;
import com.transsion.mpush.api.IPushFeature;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.config.PushMsgSource;
import com.transsion.mpush.core.fcm.m;
import com.transsion.mpush.core.renderer.i;
import com.transsion.mpush.core.renderer.k;
import kotlin.Result;
import kotlin.ResultKt;
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
public final class FcmPushFeature implements IPushFeature {

    /* renamed from: f, reason: collision with root package name */
    public static final a f47572f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Context f47573a;

    /* renamed from: b, reason: collision with root package name */
    private final n0 f47574b = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* renamed from: c, reason: collision with root package name */
    private INotificationRenderer f47575c = new k();

    /* renamed from: d, reason: collision with root package name */
    private IFcmMessageInterceptor f47576d;

    /* renamed from: e, reason: collision with root package name */
    private Function0 f47577e;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:35|36))(5:37|38|39|(1:41)(2:57|(1:59)(2:60|(1:62)(1:63)))|(4:43|(1:45)|46|47)(3:48|(4:50|(1:52)|53|(1:55)(1:56))|(2:16|17)(2:19|(2:21|22)(7:23|(1:25)(1:33)|26|(1:28)(1:32)|29|30|31))))|12|(1:14)(1:34)|(0)(0)))|66|6|7|(0)(0)|12|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x003e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01f0, code lost:
    
        lg.a.C0856a.l(lg.a.f68962a, "FcmPushFeature", "【FCM推送】消息处理异常，消息ID：" + r2 + "，异常：" + r0, false, 4, null);
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010e A[Catch: Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:11:0x0039, B:12:0x0100, B:16:0x010e, B:19:0x0135, B:21:0x013f, B:23:0x0162, B:25:0x016c, B:26:0x0173, B:28:0x01e7, B:29:0x01ec, B:38:0x004c, B:41:0x0052, B:43:0x0085, B:45:0x008b, B:46:0x0093, B:48:0x00b6, B:50:0x00e6, B:52:0x00ea, B:53:0x00ee, B:57:0x0066, B:59:0x006a, B:60:0x007a, B:62:0x007e), top: B:7:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0135 A[Catch: Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:11:0x0039, B:12:0x0100, B:16:0x010e, B:19:0x0135, B:21:0x013f, B:23:0x0162, B:25:0x016c, B:26:0x0173, B:28:0x01e7, B:29:0x01ec, B:38:0x004c, B:41:0x0052, B:43:0x0085, B:45:0x008b, B:46:0x0093, B:48:0x00b6, B:50:0x00e6, B:52:0x00ea, B:53:0x00ee, B:57:0x0066, B:59:0x006a, B:60:0x007a, B:62:0x007e), top: B:7:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r19, java.lang.Object r20, kotlin.coroutines.Continuation r21) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.features.FcmPushFeature.c(java.lang.String, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void e() {
        Object m1185constructorimpl;
        Object obj = this.f47575c;
        Context context = null;
        i iVar = obj instanceof i ? (i) obj : null;
        if (iVar == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context2 = this.f47573a;
            if (context2 == null) {
                Intrinsics.z("context");
            } else {
                context = context2;
            }
            iVar.l(context);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "FcmPushFeature", "【FCM推送】预创建通知渠道失败：" + m1188exceptionOrNullimpl, false, 4, null);
        }
    }

    public final Function0 b() {
        return this.f47577e;
    }

    public final void d(IFcmMessageInterceptor interceptor) {
        Intrinsics.h(interceptor, "interceptor");
        this.f47576d = interceptor;
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void destroy() {
        o0.d(this.f47574b, null, 1, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void init(Context context) {
        Intrinsics.h(context, "context");
        this.f47573a = context;
        e();
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onMessageReceive(String msgId, Object obj) {
        Intrinsics.h(msgId, "msgId");
        a.C0856a.l(lg.a.f68962a, "FcmPushFeature", "【FCM推送】收到FCM消息，消息ID：" + msgId + "，开始处理", false, 4, null);
        kotlinx.coroutines.k.d(this.f47574b, null, null, new FcmPushFeature$onMessageReceive$1(this, msgId, obj, null), 3, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onTrigger(int i11) {
        if (i11 == 3) {
            a.C0856a.r(lg.a.f68962a, "FcmPushFeature", new String[]{"【FCM推送】NETWORK_CONNECTED，执行 token 校验上报"}, false, 4, null);
            m.f47565a.h();
        }
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public boolean refreshMessage(Object message) {
        Intrinsics.h(message, "message");
        if (!(message instanceof LocalPushMessage)) {
            return false;
        }
        LocalPushMessage localPushMessage = (LocalPushMessage) message;
        if (!Intrinsics.c(localPushMessage.getSource(), PushMsgSource.SOURCE_FCM_PUSH)) {
            return false;
        }
        INotificationRenderer iNotificationRenderer = this.f47575c;
        Context context = this.f47573a;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        iNotificationRenderer.show(context, localPushMessage);
        return true;
    }
}
