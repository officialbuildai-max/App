package com.transsion.mpush.core.features;

import android.content.Context;
import android.graphics.Bitmap;
import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.mpush.api.INotificationRenderer;
import com.transsion.mpush.api.IPushFeature;
import com.transsion.mpush.api.IPushImageLoader;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.config.PushConfig;
import com.transsion.mpush.core.config.PushMsgType;
import com.transsion.mpush.core.interceptor.LocalFrequencyController;
import com.transsion.mpush.core.net.PushNetworkApi;
import com.transsion.mpush.core.net.SdkPullMsgResp;
import com.transsion.mpush.core.renderer.i;
import com.transsion.mpush.core.renderer.s;
import com.transsion.mpush.core.utils.PushPreference;
import com.transsion.mpush.core.utils.b;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import zg.c;

/* loaded from: classes6.dex */
public final class LocalPushFeature implements IPushFeature {

    /* renamed from: g, reason: collision with root package name */
    public static final a f47578g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Context f47579a;

    /* renamed from: e, reason: collision with root package name */
    private volatile List f47583e;

    /* renamed from: b, reason: collision with root package name */
    private final n0 f47580b = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* renamed from: c, reason: collision with root package name */
    private INotificationRenderer f47581c = new s();

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f47582d = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.features.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PushNetworkApi i11;
            i11 = LocalPushFeature.i();
            return i11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f47584f = true;

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
        final /* synthetic */ String f47585a;

        b(String str) {
            this.f47585a = str;
        }

        @Override // com.transsion.mpush.api.IPushImageLoader.Callback
        public void onFailed(Exception exc) {
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "【本地推送】图片预加载失败：" + this.f47585a, false, 4, null);
        }

        @Override // com.transsion.mpush.api.IPushImageLoader.Callback
        public void onSuccess(Bitmap bitmap) {
            Intrinsics.h(bitmap, "bitmap");
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "【本地推送】图片预加载成功：" + this.f47585a, false, 4, null);
        }
    }

    private final PushNetworkApi e() {
        return (PushNetworkApi) this.f47582d.getValue();
    }

    private final boolean f() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(NetworkUtils.n()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        Boolean bool = (Boolean) m1185constructorimpl;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(int r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.features.LocalPushFeature.g(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void h(PushConfig pushConfig) {
        if (pushConfig == null) {
            PushPreference pushPreference = PushPreference.f47662a;
            Context context = this.f47579a;
            if (context == null) {
                Intrinsics.z("context");
                context = null;
            }
            pushConfig = pushPreference.a(context);
        }
        a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【本地推送】网络拉取成功，当前配置时间：startTime=" + (pushConfig != null ? pushConfig.getStartTime() : null) + "，endTime=" + (pushConfig != null ? pushConfig.getEndTime() : null) + "，pushGap=" + (pushConfig != null ? pushConfig.getPushGap() : null)}, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PushNetworkApi i() {
        return (PushNetworkApi) c.f79537e.a().h(PushNetworkApi.class);
    }

    private final List j(String str) {
        PushConfig config;
        try {
            Context context = this.f47579a;
            Context context2 = null;
            if (context == null) {
                Intrinsics.z("context");
                context = null;
            }
            InputStream open = context.getAssets().open(str);
            Intrinsics.g(open, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charsets.UTF_8), 8192);
            try {
                String e11 = TextStreamsKt.e(bufferedReader);
                CloseableKt.a(bufferedReader, null);
                SdkPullMsgResp sdkPullMsgResp = (SdkPullMsgResp) new Gson().fromJson(e11, new TypeToken<SdkPullMsgResp>() { // from class: com.transsion.mpush.core.features.LocalPushFeature$parsePresetFromAsset$type$1
                }.getType());
                if (sdkPullMsgResp == null) {
                    return CollectionsKt.l();
                }
                List<LocalPushMessage> items = sdkPullMsgResp.getItems();
                PushPreference pushPreference = PushPreference.f47662a;
                Context context3 = this.f47579a;
                if (context3 == null) {
                    Intrinsics.z("context");
                    context3 = null;
                }
                if (pushPreference.a(context3) != null && (config = sdkPullMsgResp.getConfig()) != null) {
                    Context context4 = this.f47579a;
                    if (context4 == null) {
                        Intrinsics.z("context");
                    } else {
                        context2 = context4;
                    }
                    pushPreference.o(context2, config);
                }
                LocalFrequencyController localFrequencyController = LocalFrequencyController.f47596a;
                if (items == null) {
                    items = CollectionsKt.l();
                }
                List j11 = localFrequencyController.j(items);
                long currentTimeMillis = System.currentTimeMillis();
                int i11 = 0;
                for (Object obj : j11) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt.u();
                    }
                    LocalPushMessage localPushMessage = (LocalPushMessage) obj;
                    localPushMessage.setBuiltIn(true);
                    localPushMessage.setType(PushMsgType.LOCAL_PUSH.getType());
                    localPushMessage.setReceiveTime(currentTimeMillis - i11);
                    if (localPushMessage.getMsgStatus() == 0) {
                        localPushMessage.setMsgStatus(0);
                    }
                    i11 = i12;
                }
                return j11;
            } finally {
            }
        } catch (Exception e12) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【本地推送】解析预置数据异常，路径：" + str + "，异常：" + e12, false, 4, null);
            e12.printStackTrace();
            return CollectionsKt.l();
        }
    }

    private final void k(List list) {
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LocalPushMessage localPushMessage = (LocalPushMessage) it.next();
            if (!localPushMessage.getBuiltIn() && (str = (String) CollectionsKt.k0(localPushMessage.getImageArray())) != null) {
                IPushImageLoader f11 = ln.a.f69101a.f();
                Context context = this.f47579a;
                if (context == null) {
                    Intrinsics.z("context");
                    context = null;
                }
                f11.loadImage(context, str, null, new b(str));
            }
        }
    }

    private final void l(List list, int i11) {
        LocalFrequencyController localFrequencyController = LocalFrequencyController.f47596a;
        Context context = this.f47579a;
        Context context2 = null;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        LocalPushMessage h11 = localFrequencyController.h(context, list);
        if (h11 == null) {
            return;
        }
        Context context3 = this.f47579a;
        if (context3 == null) {
            Intrinsics.z("context");
        } else {
            context2 = context3;
        }
        if (localFrequencyController.i(context2, h11, i11)) {
            p(h11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(int r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.features.LocalPushFeature.m(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(1:(1:(5:13|14|15|16|17)(2:19|20))(3:21|22|23))(6:28|29|30|(15:32|(1:34)(1:80)|35|(3:37|(1:39)|40)|41|(1:43)|44|(1:46)(1:79)|47|(1:49)(1:78)|50|(1:52)|53|(7:58|(6:61|(1:63)|64|(2:66|67)(1:69)|68|59)|70|71|(1:73)|74|(1:76))|77)(1:81)|16|17))(3:82|83|84))(2:85|(2:87|88)(2:89|(4:91|(1:93)|83|84)(6:94|(1:96)|30|(0)(0)|16|17)))|24|(1:26)(4:27|15|16|17)))|99|6|7|(0)(0)|24|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x003f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0248, code lost:
    
        lg.a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【本地推送】网络拉取异常：" + r0, false, 4, null);
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f4 A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:14:0x003a, B:15:0x01fa, B:22:0x0054, B:24:0x01e9, B:29:0x005c, B:30:0x00c2, B:32:0x00f4, B:34:0x00fc, B:37:0x0106, B:39:0x010c, B:40:0x0110, B:41:0x0113, B:43:0x011c, B:44:0x0120, B:46:0x0128, B:47:0x012e, B:49:0x0139, B:50:0x013f, B:52:0x0143, B:53:0x0147, B:55:0x0153, B:58:0x015b, B:59:0x0191, B:61:0x0197, B:63:0x019f, B:64:0x01a2, B:66:0x01be, B:68:0x01c2, B:71:0x01c8, B:73:0x01ce, B:74:0x01d2, B:77:0x0211, B:81:0x021d, B:94:0x00a4), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x021d A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:14:0x003a, B:15:0x01fa, B:22:0x0054, B:24:0x01e9, B:29:0x005c, B:30:0x00c2, B:32:0x00f4, B:34:0x00fc, B:37:0x0106, B:39:0x010c, B:40:0x0110, B:41:0x0113, B:43:0x011c, B:44:0x0120, B:46:0x0128, B:47:0x012e, B:49:0x0139, B:50:0x013f, B:52:0x0143, B:53:0x0147, B:55:0x0153, B:58:0x015b, B:59:0x0191, B:61:0x0197, B:63:0x019f, B:64:0x01a2, B:66:0x01be, B:68:0x01c2, B:71:0x01c8, B:73:0x01ce, B:74:0x01d2, B:77:0x0211, B:81:0x021d, B:94:0x00a4), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(int r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.features.LocalPushFeature.n(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean o() {
        Context context;
        com.transsion.mpush.core.utils.b bVar = com.transsion.mpush.core.utils.b.f47663a;
        Context context2 = this.f47579a;
        if (context2 == null) {
            Intrinsics.z("context");
            context = null;
        } else {
            context = context2;
        }
        PushPreference pushPreference = PushPreference.f47662a;
        Context context3 = this.f47579a;
        if (context3 == null) {
            Intrinsics.z("context");
            context3 = null;
        }
        PushConfig a11 = pushPreference.a(context3);
        b.d d11 = bVar.d(context, a11 != null ? a11.getStartTime() : null, 480, 60, 30);
        if (d11.d()) {
            return false;
        }
        a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "【本地推送】未到达请求时间，跳过网络拉取，当前：" + bVar.g(d11.b()) + "，散列偏移：" + d11.c() + "s（窗口：-3600s~+1800s），实际请求时间：" + bVar.g(d11.a()) + "，seed来源：" + bVar.u(d11.e()), false, 4, null);
        return true;
    }

    private final void p(LocalPushMessage localPushMessage) {
        if (this.f47584f) {
            INotificationRenderer iNotificationRenderer = this.f47581c;
            Context context = this.f47579a;
            if (context == null) {
                Intrinsics.z("context");
                context = null;
            }
            iNotificationRenderer.show(context, localPushMessage);
            return;
        }
        a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【本地推送】发送处理开关关闭，跳过展示，msgId=" + localPushMessage.getMessageId()}, false, 4, null);
    }

    private final void q() {
        Object m1185constructorimpl;
        Object obj = this.f47581c;
        Context context = null;
        i iVar = obj instanceof i ? (i) obj : null;
        if (iVar == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context2 = this.f47579a;
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
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【本地推送】预创建通知渠道失败：" + m1188exceptionOrNullimpl, false, 4, null);
        }
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void destroy() {
        o0.d(this.f47580b, null, 1, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void init(Context context) {
        Intrinsics.h(context, "context");
        this.f47579a = context;
        q();
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onMessageReceive(String str, Object obj) {
        IPushFeature.DefaultImpls.onMessageReceive(this, str, obj);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onTrigger(int i11) {
        if (!this.f47584f) {
            a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【本地推送】发送处理开关关闭，忽略触发，触发源：" + i11}, false, 4, null);
            return;
        }
        a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【本地推送】收到触发事件，触发源：" + i11 + "，开始处理", false, 4, null);
        k.d(this.f47580b, null, null, new LocalPushFeature$onTrigger$1(this, i11, null), 3, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public boolean refreshMessage(Object message) {
        Intrinsics.h(message, "message");
        if (!this.f47584f) {
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "【本地推送】发送处理开关关闭，忽略刷新消息", false, 4, null);
            return false;
        }
        if (message instanceof LocalPushMessage) {
            LocalPushMessage localPushMessage = (LocalPushMessage) message;
            if (!Intrinsics.c(localPushMessage.getSource(), "2")) {
                p(localPushMessage);
                return true;
            }
        }
        return false;
    }
}
