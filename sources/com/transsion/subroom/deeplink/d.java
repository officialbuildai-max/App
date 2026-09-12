package com.transsion.subroom.deeplink;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.therouter.router.Navigator;
import com.transsion.baselib.report.h;
import com.transsion.baselib.report.l;
import com.transsion.subroom.activity.MainActivity;
import com.transsion.subroom.activity.SplashActivity;
import com.transsion.subroom.deeplink.ILaunchApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

/* loaded from: classes6.dex */
public final class d extends androidx.view.b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    public static final a f54729d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f54730b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f54731c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Uri f54733e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0 f54734f;

        b(Uri uri, Function0 function0) {
            this.f54733e = uri;
            this.f54734f = function0;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            d dVar = d.this;
            Uri uri = this.f54733e;
            dVar.l(uri, uri, null, this.f54734f);
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0017 A[Catch: Exception -> 0x000c, TryCatch #0 {Exception -> 0x000c, blocks: (B:12:0x0005, B:4:0x0010, B:6:0x0017, B:9:0x0021), top: B:11:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[Catch: Exception -> 0x000c, TRY_LEAVE, TryCatch #0 {Exception -> 0x000c, blocks: (B:12:0x0005, B:4:0x0010, B:6:0x0017, B:9:0x0021), top: B:11:0x0005 }] */
        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c(com.transsion.subroom.deeplink.ILaunchApi.UrlBean r5) {
            /*
                r4 = this;
                super.c(r5)
                if (r5 == 0) goto Le
                java.lang.String r5 = r5.getUrl()     // Catch: java.lang.Exception -> Lc
                if (r5 != 0) goto L10
                goto Le
            Lc:
                r5 = move-exception
                goto L2f
            Le:
                java.lang.String r5 = ""
            L10:
                boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> Lc
                r1 = 0
                if (r0 == 0) goto L21
                com.transsion.subroom.deeplink.d r5 = com.transsion.subroom.deeplink.d.this     // Catch: java.lang.Exception -> Lc
                android.net.Uri r0 = r4.f54733e     // Catch: java.lang.Exception -> Lc
                kotlin.jvm.functions.Function0 r2 = r4.f54734f     // Catch: java.lang.Exception -> Lc
                com.transsion.subroom.deeplink.d.d(r5, r0, r0, r1, r2)     // Catch: java.lang.Exception -> Lc
                return
            L21:
                com.transsion.subroom.deeplink.d r0 = com.transsion.subroom.deeplink.d.this     // Catch: java.lang.Exception -> Lc
                android.net.Uri r2 = r4.f54733e     // Catch: java.lang.Exception -> Lc
                android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch: java.lang.Exception -> Lc
                kotlin.jvm.functions.Function0 r3 = r4.f54734f     // Catch: java.lang.Exception -> Lc
                com.transsion.subroom.deeplink.d.d(r0, r2, r5, r1, r3)     // Catch: java.lang.Exception -> Lc
                goto L32
            L2f:
                r5.printStackTrace()
            L32:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.deeplink.d.b.c(com.transsion.subroom.deeplink.ILaunchApi$UrlBean):void");
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends bg.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0 f54735a;

        c(Function0 function0) {
            this.f54735a = function0;
        }

        @Override // bg.c
        public void b(Navigator navigator) {
            Intrinsics.h(navigator, "navigator");
            Function0 function0 = this.f54735a;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // bg.c
        public void c(Navigator navigator) {
            Intrinsics.h(navigator, "navigator");
        }

        @Override // bg.c
        public void d(Navigator navigator, int i11) {
            Intrinsics.h(navigator, "navigator");
            Function0 function0 = this.f54735a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f54730b = LazyKt.b(new Function0() { // from class: com.transsion.subroom.deeplink.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILaunchApi j11;
                j11 = d.j();
                return j11;
            }
        });
    }

    private final void e(Uri uri, Function0 function0) {
        ILaunchApi f11 = f();
        String uri2 = uri.toString();
        Intrinsics.g(uri2, "toString(...)");
        ILaunchApi.a.a(f11, uri2, null, 2, null).f(sg.d.f75472a.c()).subscribe(new b(uri, function0));
    }

    private final ILaunchApi f() {
        return (ILaunchApi) this.f54730b.getValue();
    }

    private final void g(Context context, Function0 function0) {
        try {
            Uri uri = this.f54731c;
            String queryParameter = uri != null ? uri.getQueryParameter(TmcConstants.EXTRA_BACK_TO_MINIAPP_DEEPLINK) : null;
            if (queryParameter != null && queryParameter.length() != 0 && context != null) {
                uj.a.f76883a.b(context, queryParameter);
                return;
            }
        } catch (Throwable unused) {
        }
        if (!com.transsion.baselib.helper.b.f43318a.e(this.f54731c)) {
            l(null, this.f54731c, context, function0);
            return;
        }
        Uri uri2 = this.f54731c;
        if (uri2 != null) {
            e(uri2, function0);
        }
    }

    static /* synthetic */ void h(d dVar, Context context, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        dVar.g(context, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILaunchApi j() {
        return (ILaunchApi) zg.c.f79537e.a().h(ILaunchApi.class);
    }

    private final boolean k() {
        for (Activity activity : l.f43413a.m()) {
            if ((activity instanceof SplashActivity) || (activity instanceof MainActivity)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: Exception -> 0x000d, TryCatch #0 {Exception -> 0x000d, blocks: (B:35:0x0006, B:5:0x0013, B:9:0x001b, B:12:0x004f, B:14:0x0067, B:18:0x007e, B:29:0x004c, B:22:0x0033, B:24:0x003b, B:26:0x0047), top: B:34:0x0006, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.net.Uri r7, android.net.Uri r8, android.content.Context r9, kotlin.jvm.functions.Function0 r10) {
        /*
            r6 = this;
            java.lang.String r0 = "show_enter_home"
            java.lang.String r1 = ""
            if (r7 == 0) goto L10
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> Ld
            if (r7 != 0) goto L11
            goto L10
        Ld:
            r7 = move-exception
            goto L82
        L10:
            r7 = r1
        L11:
            if (r8 == 0) goto L1b
            java.lang.String r2 = r8.toString()     // Catch: java.lang.Exception -> Ld
            if (r2 != 0) goto L1a
            goto L1b
        L1a:
            r1 = r2
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld
            r2.<init>()     // Catch: java.lang.Exception -> Ld
            java.lang.String r3 = "toLandingPage short url: "
            r2.append(r3)     // Catch: java.lang.Exception -> Ld
            r2.append(r7)     // Catch: java.lang.Exception -> Ld
            java.lang.String r3 = " whole url "
            r2.append(r3)     // Catch: java.lang.Exception -> Ld
            r2.append(r1)     // Catch: java.lang.Exception -> Ld
            r2 = 0
            if (r8 == 0) goto L4f
            java.lang.String r3 = "inviteCode"
            java.lang.String r3 = r8.getQueryParameter(r3)     // Catch: java.lang.Exception -> L4b
            if (r3 == 0) goto L4f
            java.lang.Class<com.transsion.fissionapi.IFissionProvider> r4 = com.transsion.fissionapi.IFissionProvider.class
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L4b
            java.lang.Object r4 = com.therouter.TheRouter.d(r4, r5)     // Catch: java.lang.Exception -> L4b
            com.transsion.fissionapi.IFissionProvider r4 = (com.transsion.fissionapi.IFissionProvider) r4     // Catch: java.lang.Exception -> L4b
            if (r4 == 0) goto L4f
            r4.a(r3)     // Catch: java.lang.Exception -> L4b
            goto L4f
        L4b:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> Ld
        L4f:
            com.transsion.baselib.report.h r3 = com.transsion.baselib.report.h.f43402a     // Catch: java.lang.Exception -> Ld
            r3.i(r7, r1)     // Catch: java.lang.Exception -> Ld
            yg.b$a r7 = yg.b.f79132a     // Catch: java.lang.Exception -> Ld
            java.lang.String r1 = "X-UtmSource"
            java.lang.String r3 = r3.b()     // Catch: java.lang.Exception -> Ld
            r7.b(r1, r3)     // Catch: java.lang.Exception -> Ld
            com.transsion.baselib.helper.b r7 = com.transsion.baselib.helper.b.f43318a     // Catch: java.lang.Exception -> Ld
            android.net.Uri r7 = r7.g(r8)     // Catch: java.lang.Exception -> Ld
            if (r7 == 0) goto L7c
            boolean r8 = r7.getBooleanQueryParameter(r0, r2)     // Catch: java.lang.Exception -> Ld
            com.therouter.router.Navigator r7 = ak.k.m(r7)     // Catch: java.lang.Exception -> Ld
            com.therouter.router.Navigator r7 = r7.z(r0, r8)     // Catch: java.lang.Exception -> Ld
            com.transsion.subroom.deeplink.d$c r8 = new com.transsion.subroom.deeplink.d$c     // Catch: java.lang.Exception -> Ld
            r8.<init>(r10)     // Catch: java.lang.Exception -> Ld
            r7.u(r9, r8)     // Catch: java.lang.Exception -> Ld
            goto L85
        L7c:
            if (r10 == 0) goto L85
            r10.invoke()     // Catch: java.lang.Exception -> Ld
            goto L85
        L82:
            r7.printStackTrace()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.deeplink.d.l(android.net.Uri, android.net.Uri, android.content.Context, kotlin.jvm.functions.Function0):void");
    }

    private final void m(Context context, boolean z10) {
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        intent.putExtra("from", "deeplink");
        intent.putExtra("without_ad", z10);
        if (!(context instanceof Activity)) {
            intent.addFlags(ASTNode.DEOP);
        }
        context.startActivity(intent);
    }

    public final void i(Context context, Uri uri, Function0 onArrival) {
        Intrinsics.h(context, "context");
        Intrinsics.h(uri, "uri");
        Intrinsics.h(onArrival, "onArrival");
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("withoutMain", false);
        boolean booleanQueryParameter2 = uri.getBooleanQueryParameter("withoutAd", false);
        com.transsion.subroom.deeplink.b.f54727a.b(uri.getBooleanQueryParameter("skipTwiceBack", false));
        h.f43402a.k(uri);
        this.f54731c = uri;
        if (booleanQueryParameter2) {
            hi.b.f64589a.b();
        }
        if (!k()) {
            g(context, onArrival);
        } else {
            if (booleanQueryParameter) {
                g(context, onArrival);
                return;
            }
            b().registerActivityLifecycleCallbacks(this);
            m(context, booleanQueryParameter2);
            onArrival.invoke();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity p02, Bundle bundle) {
        Intrinsics.h(p02, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity p02) {
        Intrinsics.h(p02, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity p02) {
        Intrinsics.h(p02, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity p02) {
        Intrinsics.h(p02, "p0");
        try {
            if (p02 instanceof MainActivity) {
                b().unregisterActivityLifecycleCallbacks(this);
                h(this, p02, null, 2, null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity p02, Bundle p12) {
        Intrinsics.h(p02, "p0");
        Intrinsics.h(p12, "p1");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity p02) {
        Intrinsics.h(p02, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity p02) {
        Intrinsics.h(p02, "p0");
    }
}
