package rp;

import android.content.Context;
import com.transsion.mpush.api.IPushFeature;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class a implements IPushFeature {

    /* renamed from: a, reason: collision with root package name */
    public static final C0935a f74717a = new C0935a(null);

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f74718b;

    /* renamed from: rp.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0935a {
        private C0935a() {
        }

        public /* synthetic */ C0935a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b b() {
            return a.f74718b;
        }

        public final void c(b bVar) {
            a.f74718b = bVar;
        }
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void destroy() {
        f74717a.c(null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void init(Context context) {
        Intrinsics.h(context, "context");
        a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【下载推送】初始化", false, 4, null);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onMessageReceive(String str, Object obj) {
        IPushFeature.DefaultImpls.onMessageReceive(this, str, obj);
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public void onTrigger(int i11) {
        b b11;
        Object m1185constructorimpl;
        if (i11 == 4 && (b11 = f74717a.b()) != null) {
            a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "【下载推送】TIMER 触发，执行下载通知检查", false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                b11.a();
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                a.C0856a.l(lg.a.f68962a, "PushRegisterManager", "【下载推送】timeTask 执行异常：" + m1188exceptionOrNullimpl, false, 4, null);
            }
        }
    }

    @Override // com.transsion.mpush.api.IPushFeature
    public boolean refreshMessage(Object obj) {
        return IPushFeature.DefaultImpls.refreshMessage(this, obj);
    }
}
