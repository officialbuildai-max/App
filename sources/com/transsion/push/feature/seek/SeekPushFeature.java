package com.transsion.push.feature.seek;

import android.content.Context;
import com.transsion.mpush.api.INotificationRenderer;
import com.transsion.mpush.api.IPushFeature;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.config.PushMsgType;
import com.transsion.mpush.core.utils.PushPreference;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class SeekPushFeature implements IPushFeature {

    /* renamed from: d, reason: collision with root package name */
    public static final a f50875d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Context f50876a;

    /* renamed from: b, reason: collision with root package name */
    private final n0 f50877b = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* renamed from: c, reason: collision with root package name */
    private INotificationRenderer f50878c = new b();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Context context) {
            Intrinsics.h(context, "context");
            long j11 = context.getSharedPreferences("seek_push_prefs", 0).getLong("key_seek_show_time", 0L);
            if (j11 == 0) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j11);
            Calendar calendar2 = Calendar.getInstance();
            return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }

        public final void b(Context context) {
            Intrinsics.h(context, "context");
            context.getSharedPreferences("seek_push_prefs", 0).edit().putLong("key_seek_show_time", System.currentTimeMillis()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i11) {
        Object obj;
        String title;
        String desc;
        a aVar = f50875d;
        Context context = this.f50876a;
        Context context2 = null;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        if (aVar.a(context)) {
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【求片推送】当天已展示，跳过", false, 4, null);
            return;
        }
        PushPreference pushPreference = PushPreference.f47662a;
        Context context3 = this.f50876a;
        if (context3 == null) {
            Intrinsics.z("context");
            context3 = null;
        }
        List h11 = pushPreference.h(context3);
        List list = h11;
        if (list == null || list.isEmpty()) {
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【求片推送】seekingItems 缓存为空", false, 4, null);
            return;
        }
        Iterator it = h11.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            LocalPushMessage localPushMessage = (LocalPushMessage) obj;
            if (localPushMessage != null && localPushMessage.getDeeplink() != null && (((title = localPushMessage.getTitle()) != null && title.length() != 0) || ((desc = localPushMessage.getDesc()) != null && desc.length() != 0))) {
                break;
            }
        }
        LocalPushMessage localPushMessage2 = (LocalPushMessage) obj;
        if (localPushMessage2 == null) {
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【求片推送】无有效消息", false, 4, null);
            return;
        }
        localPushMessage2.setType(PushMsgType.SUBJECT_SEEKING.getType());
        a.C0856a.r(lg.a.f68962a, "PushRegisterManager", new String[]{"【求片推送】准备展示，消息ID：" + localPushMessage2.getMessageId() + "，标题：" + localPushMessage2.getTitle()}, false, 4, null);
        ln.b bVar = ln.b.f69110a;
        Context context4 = this.f50876a;
        if (context4 == null) {
            Intrinsics.z("context");
            context4 = null;
        }
        bVar.j(context4, localPushMessage2);
        INotificationRenderer iNotificationRenderer = this.f50878c;
        Context context5 = this.f50876a;
        if (context5 == null) {
            Intrinsics.z("context");
        } else {
            context2 = context5;
        }
        iNotificationRenderer.show(context2, localPushMessage2);
    }

    private final void c() {
        Object m1185constructorimpl;
        INotificationRenderer iNotificationRenderer = this.f50878c;
        Context context = null;
        b bVar = iNotificationRenderer instanceof b ? (b) iNotificationRenderer : null;
        if (bVar == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context2 = this.f50876a;
            if (context2 == null) {
                Intrinsics.z("context");
            } else {
                context = context2;
            }
            bVar.l(context);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "PushRegisterManager", "【求片推送】预创建通知渠道失败：" + m1188exceptionOrNullimpl, false, 4, null);
        }
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void destroy() {
        o0.d(this.f50877b, null, 1, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void init(Context context) {
        Intrinsics.h(context, "context");
        this.f50876a = context;
        c();
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onMessageReceive(String str, Object obj) {
        IPushFeature.DefaultImpls.onMessageReceive(this, str, obj);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onTrigger(int i11) {
        if (i11 == 4 || i11 == 1 || i11 == 2) {
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【求片推送】收到触发事件，触发源：" + i11, false, 4, null);
            k.d(this.f50877b, null, null, new SeekPushFeature$onTrigger$1(this, i11, null), 3, null);
        }
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public boolean refreshMessage(Object message) {
        Intrinsics.h(message, "message");
        if (!(message instanceof LocalPushMessage)) {
            return false;
        }
        LocalPushMessage localPushMessage = (LocalPushMessage) message;
        if (!Intrinsics.c(localPushMessage.getType(), PushMsgType.SUBJECT_SEEKING.getType())) {
            return false;
        }
        INotificationRenderer iNotificationRenderer = this.f50878c;
        Context context = this.f50876a;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        iNotificationRenderer.show(context, localPushMessage);
        return true;
    }
}
