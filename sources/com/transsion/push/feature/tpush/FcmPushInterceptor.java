package com.transsion.push.feature.tpush;

import com.therouter.TheRouter;
import com.transsion.mpush.api.IFcmMessageInterceptor;
import com.transsion.push.feature.sport.SportsNotificationRenderer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import zg.c;

/* loaded from: classes6.dex */
public final class FcmPushInterceptor implements IFcmMessageInterceptor {

    /* renamed from: c, reason: collision with root package name */
    public static final a f50897c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f50898a = LazyKt.b(new Function0() { // from class: com.transsion.push.feature.tpush.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SportsNotificationRenderer j11;
            j11 = FcmPushInterceptor.j();
            return j11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f50899b = LazyKt.b(new Function0() { // from class: com.transsion.push.feature.tpush.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.push.feature.sport.a g11;
            g11 = FcmPushInterceptor.g();
            return g11;
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

    private final com.transsion.push.feature.sport.a d() {
        return (com.transsion.push.feature.sport.a) this.f50899b.getValue();
    }

    private final SportsNotificationRenderer e() {
        return (SportsNotificationRenderer) this.f50898a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(9:5|6|7|8|(1:(2:11|12)(2:22|23))(2:24|(2:31|32)(2:28|(1:30)))|13|(1:21)(1:17)|18|19))|35|6|7|8|(0)(0)|13|(1:15)|21|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0035, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0095, code lost:
    
        r11.printStackTrace();
        e().J(r9, r10, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(android.content.Context r9, com.transsion.mpush.api.LocalPushMessage r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.transsion.push.feature.tpush.FcmPushInterceptor$handleSportsMessage$1
            if (r0 == 0) goto L14
            r0 = r11
            com.transsion.push.feature.tpush.FcmPushInterceptor$handleSportsMessage$1 r0 = (com.transsion.push.feature.tpush.FcmPushInterceptor$handleSportsMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.push.feature.tpush.FcmPushInterceptor$handleSportsMessage$1 r0 = new com.transsion.push.feature.tpush.FcmPushInterceptor$handleSportsMessage$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r7 = 0
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r9 = r4.L$1
            r10 = r9
            com.transsion.mpush.api.LocalPushMessage r10 = (com.transsion.mpush.api.LocalPushMessage) r10
            java.lang.Object r9 = r4.L$0
            android.content.Context r9 = (android.content.Context) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Exception -> L35
            goto L6b
        L35:
            r11 = move-exception
            goto L95
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            kotlin.ResultKt.b(r11)
            com.transsion.mpush.core.utils.c r11 = com.transsion.mpush.core.utils.c.f47679a
            java.lang.String r1 = r10.getDeeplink()
            java.lang.String r3 = "id"
            java.lang.String r3 = r11.e(r1, r3)
            if (r3 == 0) goto La2
            int r11 = r3.length()
            if (r11 != 0) goto L57
            goto La2
        L57:
            com.transsion.push.feature.sport.a r1 = r8.d()     // Catch: java.lang.Exception -> L35
            r4.L$0 = r9     // Catch: java.lang.Exception -> L35
            r4.L$1 = r10     // Catch: java.lang.Exception -> L35
            r4.label = r2     // Catch: java.lang.Exception -> L35
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = com.transsion.push.feature.sport.a.C0647a.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L35
            if (r11 != r0) goto L6b
            return r0
        L6b:
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r11.getCode()     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = "0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r1)     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto L8d
            java.lang.Object r0 = r11.getData()     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto L8d
            com.transsion.push.feature.sport.SportsNotificationRenderer r0 = r8.e()     // Catch: java.lang.Exception -> L35
            java.lang.Object r11 = r11.getData()     // Catch: java.lang.Exception -> L35
            com.transsion.push.feature.sport.ServerMatchListItemData r11 = (com.transsion.push.feature.sport.ServerMatchListItemData) r11     // Catch: java.lang.Exception -> L35
            r0.J(r9, r10, r11)     // Catch: java.lang.Exception -> L35
            goto L9f
        L8d:
            com.transsion.push.feature.sport.SportsNotificationRenderer r11 = r8.e()     // Catch: java.lang.Exception -> L35
            r11.J(r9, r10, r7)     // Catch: java.lang.Exception -> L35
            goto L9f
        L95:
            r11.printStackTrace()
            com.transsion.push.feature.sport.SportsNotificationRenderer r11 = r8.e()
            r11.J(r9, r10, r7)
        L9f:
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        La2:
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.feature.tpush.FcmPushInterceptor.f(android.content.Context, com.transsion.mpush.api.LocalPushMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.push.feature.sport.a g() {
        return (com.transsion.push.feature.sport.a) c.f79537e.a().h(com.transsion.push.feature.sport.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SportsNotificationRenderer j() {
        return new SportsNotificationRenderer();
    }

    public final void h() {
        IRefreshConfig iRefreshConfig = (IRefreshConfig) TheRouter.d(IRefreshConfig.class, new Object[0]);
        if (iRefreshConfig != null) {
            iRefreshConfig.a();
        }
    }

    public final void i(boolean z10) {
        k.d(o0.a(y0.b()), null, null, new FcmPushInterceptor$onLogRetrieve$1(z10, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.mpush.api.IFcmMessageInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object intercept(android.content.Context r12, java.lang.String r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.feature.tpush.FcmPushInterceptor.intercept(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
