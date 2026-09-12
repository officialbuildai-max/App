package com.transsion.mpush.core.features;

import android.content.Context;
import com.transsion.mpush.api.IPushFeature;
import com.transsion.mpush.api.PermanentPushMessage;
import com.transsion.mpush.core.config.PermanentConfig;
import com.transsion.mpush.core.db.PushDatabase;
import com.transsion.mpush.core.net.PushNetworkApi;
import com.transsion.mpush.core.renderer.v;
import com.transsion.mpush.core.utils.PushPreference;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lg.a;
import zg.c;

/* loaded from: classes6.dex */
public final class PermanentPushFeature implements IPushFeature {

    /* renamed from: b, reason: collision with root package name */
    private Context f47587b;

    /* renamed from: g, reason: collision with root package name */
    private PermanentConfig f47592g;

    /* renamed from: j, reason: collision with root package name */
    private t1 f47595j;

    /* renamed from: a, reason: collision with root package name */
    private final String f47586a = "PUSH_SHOW";

    /* renamed from: c, reason: collision with root package name */
    private final n0 f47588c = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* renamed from: d, reason: collision with root package name */
    private v f47589d = new v();

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f47590e = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.features.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PushNetworkApi m11;
            m11 = PermanentPushFeature.m();
            return m11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList f47591f = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    private String f47593h = "1";

    /* renamed from: i, reason: collision with root package name */
    private final int f47594i = 10;

    private final void i(PermanentConfig permanentConfig) {
        t1 d11;
        long interval = permanentConfig.getInterval() * 60 * 1000;
        PushPreference pushPreference = PushPreference.f47662a;
        Context context = this.f47587b;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        if (System.currentTimeMillis() - pushPreference.d(context) >= interval) {
            t1 t1Var = this.f47595j;
            if (t1Var != null) {
                t1.a.b(t1Var, null, 1, null);
            }
            d11 = k.d(this.f47588c, null, null, new PermanentPushFeature$checkRequest$1(this, null), 3, null);
            this.f47595j = d11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|8|(1:(2:11|12)(2:75|76))(10:77|(1:79)|80|(1:102)|85|(1:87)(1:101)|88|(1:90)(1:100)|91|(2:93|94)(3:95|96|(1:98)(1:99)))|13|(2:15|(14:17|(19:22|(3:24|(1:26)|27)|28|(4:31|(3:33|34|35)(1:37)|36|29)|38|39|(1:41)|42|43|(3:45|(1:47)|48)|49|(1:51)(1:69)|52|(1:60)|61|(1:63)|64|(1:66)(1:68)|67)|70|43|(0)|49|(0)(0)|52|(3:54|57|60)|61|(0)|64|(0)(0)|67))(1:74)|71|72))|105|6|7|8|(0)(0)|13|(0)(0)|71|72) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0037, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02e6, code lost:
    
        r0.printStackTrace();
        lg.a.C0856a.l(lg.a.f68962a, r24.f47586a, "【常驻推送】网络拉取异常：" + r0, false, 4, null);
        java.util.Collections.shuffle(r24.f47591f);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x017f A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:12:0x0032, B:13:0x014d, B:15:0x017f, B:17:0x0187, B:19:0x0190, B:22:0x0198, B:24:0x01bd, B:26:0x01c8, B:27:0x01cc, B:28:0x01e6, B:29:0x01f9, B:31:0x01ff, B:34:0x020f, B:39:0x0213, B:41:0x0247, B:42:0x024b, B:43:0x0264, B:45:0x026a, B:47:0x0279, B:48:0x027d, B:49:0x0280, B:51:0x0286, B:52:0x028c, B:54:0x0292, B:57:0x029a, B:61:0x02a2, B:63:0x02aa, B:64:0x02ae, B:66:0x02b7, B:67:0x02bc, B:70:0x0259, B:74:0x02c7, B:96:0x012b), top: B:8:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x026a A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:12:0x0032, B:13:0x014d, B:15:0x017f, B:17:0x0187, B:19:0x0190, B:22:0x0198, B:24:0x01bd, B:26:0x01c8, B:27:0x01cc, B:28:0x01e6, B:29:0x01f9, B:31:0x01ff, B:34:0x020f, B:39:0x0213, B:41:0x0247, B:42:0x024b, B:43:0x0264, B:45:0x026a, B:47:0x0279, B:48:0x027d, B:49:0x0280, B:51:0x0286, B:52:0x028c, B:54:0x0292, B:57:0x029a, B:61:0x02a2, B:63:0x02aa, B:64:0x02ae, B:66:0x02b7, B:67:0x02bc, B:70:0x0259, B:74:0x02c7, B:96:0x012b), top: B:8:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0286 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:12:0x0032, B:13:0x014d, B:15:0x017f, B:17:0x0187, B:19:0x0190, B:22:0x0198, B:24:0x01bd, B:26:0x01c8, B:27:0x01cc, B:28:0x01e6, B:29:0x01f9, B:31:0x01ff, B:34:0x020f, B:39:0x0213, B:41:0x0247, B:42:0x024b, B:43:0x0264, B:45:0x026a, B:47:0x0279, B:48:0x027d, B:49:0x0280, B:51:0x0286, B:52:0x028c, B:54:0x0292, B:57:0x029a, B:61:0x02a2, B:63:0x02aa, B:64:0x02ae, B:66:0x02b7, B:67:0x02bc, B:70:0x0259, B:74:0x02c7, B:96:0x012b), top: B:8:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02aa A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:12:0x0032, B:13:0x014d, B:15:0x017f, B:17:0x0187, B:19:0x0190, B:22:0x0198, B:24:0x01bd, B:26:0x01c8, B:27:0x01cc, B:28:0x01e6, B:29:0x01f9, B:31:0x01ff, B:34:0x020f, B:39:0x0213, B:41:0x0247, B:42:0x024b, B:43:0x0264, B:45:0x026a, B:47:0x0279, B:48:0x027d, B:49:0x0280, B:51:0x0286, B:52:0x028c, B:54:0x0292, B:57:0x029a, B:61:0x02a2, B:63:0x02aa, B:64:0x02ae, B:66:0x02b7, B:67:0x02bc, B:70:0x0259, B:74:0x02c7, B:96:0x012b), top: B:8:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02b7 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:12:0x0032, B:13:0x014d, B:15:0x017f, B:17:0x0187, B:19:0x0190, B:22:0x0198, B:24:0x01bd, B:26:0x01c8, B:27:0x01cc, B:28:0x01e6, B:29:0x01f9, B:31:0x01ff, B:34:0x020f, B:39:0x0213, B:41:0x0247, B:42:0x024b, B:43:0x0264, B:45:0x026a, B:47:0x0279, B:48:0x027d, B:49:0x0280, B:51:0x0286, B:52:0x028c, B:54:0x0292, B:57:0x029a, B:61:0x02a2, B:63:0x02aa, B:64:0x02ae, B:66:0x02b7, B:67:0x02bc, B:70:0x0259, B:74:0x02c7, B:96:0x012b), top: B:8:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02c7 A[Catch: Exception -> 0x0037, TRY_LEAVE, TryCatch #0 {Exception -> 0x0037, blocks: (B:12:0x0032, B:13:0x014d, B:15:0x017f, B:17:0x0187, B:19:0x0190, B:22:0x0198, B:24:0x01bd, B:26:0x01c8, B:27:0x01cc, B:28:0x01e6, B:29:0x01f9, B:31:0x01ff, B:34:0x020f, B:39:0x0213, B:41:0x0247, B:42:0x024b, B:43:0x0264, B:45:0x026a, B:47:0x0279, B:48:0x027d, B:49:0x0280, B:51:0x0286, B:52:0x028c, B:54:0x0292, B:57:0x029a, B:61:0x02a2, B:63:0x02aa, B:64:0x02ae, B:66:0x02b7, B:67:0x02bc, B:70:0x0259, B:74:0x02c7, B:96:0x012b), top: B:8:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.features.PermanentPushFeature.k(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PushNetworkApi l() {
        return (PushNetworkApi) this.f47590e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PushNetworkApi m() {
        return (PushNetworkApi) c.f79537e.a().h(PushNetworkApi.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(int i11, Continuation continuation) {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.r(c0856a, this.f47586a, new String[]{"【常驻推送】开始处理触发，触发源：" + i11}, false, 4, null);
        Context context = null;
        if (this.f47591f.isEmpty()) {
            PushDatabase.Companion companion = PushDatabase.INSTANCE;
            Context context2 = this.f47587b;
            if (context2 == null) {
                Intrinsics.z("context");
                context2 = null;
            }
            List all = companion.b(context2).k0().getAll();
            List list = all;
            if (!list.isEmpty()) {
                this.f47591f.addAll(list);
                a.C0856a.r(c0856a, this.f47586a, new String[]{"【常驻推送】从数据库加载 " + all.size() + " 条缓存消息"}, false, 4, null);
            }
        }
        PushPreference pushPreference = PushPreference.f47662a;
        Context context3 = this.f47587b;
        if (context3 == null) {
            Intrinsics.z("context");
        } else {
            context = context3;
        }
        boolean m11 = pushPreference.m(context);
        boolean z10 = this.f47591f.size() < this.f47594i || !m11;
        a.C0856a.r(c0856a, this.f47586a, new String[]{"【常驻推送】检查拉取需求，需要拉取：" + z10 + "，缓存数：" + this.f47591f.size() + "，今日已拉取：" + m11}, false, 4, null);
        if (z10) {
            Object k11 = k(continuation);
            return k11 == IntrinsicsKt.f() ? k11 : Unit.f67184a;
        }
        o();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        PermanentConfig permanentConfig = this.f47592g;
        if (permanentConfig == null) {
            permanentConfig = new PermanentConfig(true, null, 0, null, 12, null);
        }
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.r(c0856a, this.f47586a, new String[]{"【常驻推送】开始展示常驻通知，启用状态：" + permanentConfig.getEnable() + "，消息数：" + this.f47591f.size()}, false, 4, null);
        Context context = null;
        if (!permanentConfig.getEnable()) {
            a.C0856a.f(c0856a, this.f47586a, "【常驻推送】常驻推送未启用，取消通知", false, 4, null);
            v vVar = this.f47589d;
            Context context2 = this.f47587b;
            if (context2 == null) {
                Intrinsics.z("context");
            } else {
                context = context2;
            }
            vVar.t(context);
            return;
        }
        if (!p(permanentConfig)) {
            a.C0856a.f(c0856a, this.f47586a, "【常驻推送】未到展示时间，跳过展示", false, 4, null);
            return;
        }
        if (permanentConfig.getInterval() > 0) {
            i(permanentConfig);
        }
        a.C0856a.r(c0856a, this.f47586a, new String[]{"【常驻推送】调用渲染器展示通知，传递 " + this.f47591f.size() + " 条消息"}, false, 4, null);
        v vVar2 = this.f47589d;
        Context context3 = this.f47587b;
        if (context3 == null) {
            Intrinsics.z("context");
        } else {
            context = context3;
        }
        vVar2.J(context, CollectionsKt.R0(this.f47591f), permanentConfig);
    }

    private final boolean p(PermanentConfig permanentConfig) {
        String startTime = permanentConfig.getStartTime();
        if (startTime == null) {
            return true;
        }
        if (startTime.length() != 0) {
            try {
                List S0 = StringsKt.S0(startTime, new String[]{":"}, false, 0, 6, null);
                if (S0.size() < 2) {
                    return true;
                }
                int parseInt = Integer.parseInt((String) S0.get(0));
                int parseInt2 = Integer.parseInt((String) S0.get(1));
                Calendar calendar = Calendar.getInstance();
                int i11 = calendar.get(11);
                int i12 = calendar.get(12);
                a.C0856a.f(lg.a.f68962a, this.f47586a, "timeReady, cur:" + i11 + ":" + i12 + ",time:" + parseInt, false, 4, null);
                if (i11 > parseInt) {
                    return true;
                }
                if (i11 == parseInt && i12 >= parseInt2) {
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }

    private final void q() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            v vVar = this.f47589d;
            Context context = this.f47587b;
            if (context == null) {
                Intrinsics.z("context");
                context = null;
            }
            vVar.l(context);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, this.f47586a, "【常驻推送】预创建通知渠道失败：" + m1188exceptionOrNullimpl, false, 4, null);
        }
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void destroy() {
        o0.d(this.f47588c, null, 1, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void init(Context context) {
        Intrinsics.h(context, "context");
        this.f47587b = context;
        q();
        PushPreference pushPreference = PushPreference.f47662a;
        this.f47592g = pushPreference.c(context);
        String e11 = pushPreference.e(context);
        if (e11 == null) {
            e11 = "1";
        }
        this.f47593h = e11;
        if (this.f47591f.isEmpty()) {
            k.d(this.f47588c, null, null, new PermanentPushFeature$init$1(context, this, null), 3, null);
        }
    }

    public final void j(String id2) {
        Intrinsics.h(id2, "id");
        k.d(this.f47588c, null, null, new PermanentPushFeature$consumeMessage$1(this, id2, null), 3, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onMessageReceive(String str, Object obj) {
        IPushFeature.DefaultImpls.onMessageReceive(this, str, obj);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onTrigger(int i11) {
        a.C0856a.l(lg.a.f68962a, this.f47586a, "【常驻推送】收到触发事件，触发源：" + i11 + "，开始处理", false, 4, null);
        k.d(this.f47588c, null, null, new PermanentPushFeature$onTrigger$1(this, i11, null), 3, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public boolean refreshMessage(Object message) {
        Object obj;
        Intrinsics.h(message, "message");
        if (!(message instanceof PermanentPushMessage)) {
            return false;
        }
        Iterator it = this.f47591f.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(((PermanentPushMessage) obj).getSubjectId(), ((PermanentPushMessage) message).getSubjectId())) {
                break;
            }
        }
        PermanentPushMessage permanentPushMessage = (PermanentPushMessage) obj;
        if (permanentPushMessage != null) {
            permanentPushMessage.setRefresh(true);
        }
        o();
        return true;
    }
}
