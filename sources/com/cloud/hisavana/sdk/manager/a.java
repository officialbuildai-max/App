package com.cloud.hisavana.sdk.manager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.d;
import androidx.browser.customtabs.j;
import com.cloud.hisavana.abtestkit.ABTestKit;
import com.cloud.hisavana.abtestkit.bean.ABVariant;
import com.cloud.hisavana.abtestkit.bean.ABVariantState;
import com.cloud.hisavana.sdk.c1;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.bean.SSPParamSplicedResult;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ABTest;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ClientABTestDTOKt;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigManager;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomTabConfigDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.j3;
import com.cloud.hisavana.sdk.k4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.m;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static boolean f22741g;

    /* renamed from: i, reason: collision with root package name */
    private static volatile long f22743i;

    /* renamed from: l, reason: collision with root package name */
    private static WeakReference f22746l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f22747m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f22748n;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f22749o;

    /* renamed from: p, reason: collision with root package name */
    private static long f22750p;

    /* renamed from: q, reason: collision with root package name */
    private static long f22751q;

    /* renamed from: u, reason: collision with root package name */
    private static androidx.browser.customtabs.f f22755u;

    /* renamed from: v, reason: collision with root package name */
    private static CustomTabsClient f22756v;

    /* renamed from: w, reason: collision with root package name */
    private static j f22757w;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f22758x;

    /* renamed from: a, reason: collision with root package name */
    public static final a f22735a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static Long f22736b = 0L;

    /* renamed from: c, reason: collision with root package name */
    private static Long f22737c = 0L;

    /* renamed from: d, reason: collision with root package name */
    private static Long f22738d = 0L;

    /* renamed from: e, reason: collision with root package name */
    private static Integer f22739e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static Integer f22740f = 0;

    /* renamed from: h, reason: collision with root package name */
    private static Integer f22742h = 0;

    /* renamed from: j, reason: collision with root package name */
    private static String f22744j = "";

    /* renamed from: k, reason: collision with root package name */
    private static String f22745k = "";

    /* renamed from: r, reason: collision with root package name */
    private static long f22752r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static long f22753s = -1;

    /* renamed from: t, reason: collision with root package name */
    private static long f22754t = -1;

    /* renamed from: y, reason: collision with root package name */
    private static final e f22759y = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @DebugMetadata(c = "com.cloud.hisavana.sdk.manager.CustomTabsManager", f = "CustomTabsManager.kt", l = {517}, m = "bindCCTServiceAndCreatSession")
    /* renamed from: com.cloud.hisavana.sdk.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0315a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f22760a;

        /* renamed from: b, reason: collision with root package name */
        boolean f22761b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f22762c;

        /* renamed from: e, reason: collision with root package name */
        int f22764e;

        C0315a(Continuation<? super C0315a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f22762c = obj;
            this.f22764e |= Integer.MIN_VALUE;
            return a.this.h(null, false, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)I"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.cloud.hisavana.sdk.manager.CustomTabsManager$bindCCTServiceAndCreatSession$isBindServiceSuccess$1", f = "CustomTabsManager.kt", l = {518}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<n0, Continuation<? super Integer>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22765a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f22766b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f22766b = context;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n0 n0Var, Continuation<? super Integer> continuation) {
            return ((b) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f22766b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.f22765a;
            if (i11 == 0) {
                ResultKt.b(obj);
                a aVar = a.f22735a;
                Context context = this.f22766b;
                this.f22765a = 1;
                obj = aVar.g(context, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return obj;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends androidx.browser.customtabs.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f22767a;

        c(n nVar) {
            this.f22767a = nVar;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            super.onBindingDied(componentName);
            a.f22735a.j0();
            e4.b().d("CustomTabsManager", "cct onBindingDied");
        }

        @Override // androidx.browser.customtabs.f
        public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
            Intrinsics.h(name, "name");
            Intrinsics.h(client, "client");
            e4.b().d("CustomTabsManager", "onCustomTabsServiceConnected");
            a.f22756v = client;
            try {
                if (this.f22767a.isActive()) {
                    n nVar = this.f22767a;
                    Result.Companion companion = Result.INSTANCE;
                    nVar.resumeWith(Result.m1185constructorimpl(0));
                }
            } catch (Throwable th2) {
                e4.b().d("CustomTabsManager", "cct onCustomTabsServiceConnected", th2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            super.onNullBinding(componentName);
            a.f22735a.j0();
            e4.b().d("CustomTabsManager", "cct onNullBinding");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.h(componentName, "componentName");
            a.f22735a.j0();
            e4.b().d("CustomTabsManager", "cct onServiceDisconnected");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.cloud.hisavana.sdk.manager.CustomTabsManager$bindCustomTabsService$2$2", f = "CustomTabsManager.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22768a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f22769b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f22770c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, n nVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.f22769b = context;
            this.f22770c = nVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((d) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.f22769b, this.f22770c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.f22768a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            try {
                Context context = this.f22769b;
                androidx.browser.customtabs.f fVar = a.f22755u;
                Intrinsics.f(fVar, "null cannot be cast to non-null type androidx.browser.customtabs.CustomTabsServiceConnection");
                boolean a11 = CustomTabsClient.a(context, "com.android.chrome", fVar);
                if (!a11) {
                    n nVar = this.f22770c;
                    Result.Companion companion = Result.INSTANCE;
                    nVar.resumeWith(Result.m1185constructorimpl(Boxing.d(TaErrorCode.CLICK_ERROR_CODE_CCT_BIND_FAILED)));
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bindCustomTabsService, result=");
                sb2.append(a11);
            } catch (Throwable unused) {
            }
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends androidx.browser.customtabs.c {

        /* renamed from: com.cloud.hisavana.sdk.manager.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0316a implements m.b {
            C0316a() {
            }

            @Override // com.cloud.sdk.commonutil.util.m.b
            public void a(String str) {
                a.f22735a.N(str);
            }
        }

        e() {
        }

        @Override // androidx.browser.customtabs.c
        public void onNavigationEvent(int i11, Bundle bundle) {
            switch (i11) {
                case 1:
                    e4.b().d("CustomTabsManager", "onNavigationEvent, NAVIGATION_STARTED");
                    if (a.f22750p == 0) {
                        a.f22750p = System.currentTimeMillis();
                        return;
                    }
                    return;
                case 2:
                    e4.b().d("CustomTabsManager", "onNavigationEvent, NAVIGATION_FINISHED");
                    if (a.f22753s == -1) {
                        a.f22753s = System.currentTimeMillis() - a.f22750p;
                        e4.b().d("CustomTabsManager", "onNavigationEvent, NAVIGATION_FINISHED, time taken: " + a.f22753s + " ms");
                        a.f22735a.H(0, a.f22753s);
                        return;
                    }
                    return;
                case 3:
                    if (a.f22753s == -1 && a.f22754t == -1) {
                        a.f22754t = System.currentTimeMillis() - a.f22750p;
                        a.f22735a.n(TaErrorCode.CCT_LOAD_FAILED, a.f22754t);
                    }
                    e4.b().e("CustomTabsManager", "onNavigationEvent, NAVIGATION_FAILED");
                    return;
                case 4:
                    if (a.f22752r == -1) {
                        a.f22752r = System.currentTimeMillis() - a.f22750p;
                    }
                    e4.b().e("CustomTabsManager", "onNavigationEvent, NAVIGATION_ABORTED");
                    return;
                case 5:
                    e4.b().d("CustomTabsManager", "onNavigationEvent, TAB_SHOWN");
                    a.f22748n = false;
                    if (a.f22747m) {
                        a.f22747m = false;
                        m.k(new C0316a());
                        return;
                    }
                    return;
                case 6:
                    a.f22748n = true;
                    e4.b().d("CustomTabsManager", "onNavigationEvent, TAB_HIDDEN");
                    a.f22735a.N("");
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.cloud.hisavana.sdk.manager.CustomTabsManager$checkAndLaunchCCTLandingPage$1", f = "CustomTabsManager.kt", l = {641, 644, 651, 657}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22771a;

        /* renamed from: b, reason: collision with root package name */
        Object f22772b;

        /* renamed from: c, reason: collision with root package name */
        int f22773c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f22774d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22775e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DownUpPointBean f22776f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f22777g;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.cloud.hisavana.sdk.manager.CustomTabsManager$checkAndLaunchCCTLandingPage$1$1", f = "CustomTabsManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.cloud.hisavana.sdk.manager.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0317a extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f22778a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function1<Integer, Unit> f22779b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.IntRef f22780c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0317a(Function1<? super Integer, Unit> function1, Ref.IntRef intRef, Continuation<? super C0317a> continuation) {
                super(2, continuation);
                this.f22779b = function1;
                this.f22780c = intRef;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                return ((C0317a) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0317a(this.f22779b, this.f22780c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.f();
                if (this.f22778a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f22779b.invoke(Boxing.d(this.f22780c.element));
                return Unit.f67184a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(Context context, AdsDTO adsDTO, DownUpPointBean downUpPointBean, Function1<? super Integer, Unit> function1, Continuation<? super f> continuation) {
            super(2, continuation);
            this.f22774d = context;
            this.f22775e = adsDTO;
            this.f22776f = downUpPointBean;
            this.f22777g = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((f) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.f22774d, this.f22775e, this.f22776f, this.f22777g, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00e2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008b A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:8:0x0014, B:15:0x0029, B:16:0x00bf, B:18:0x00ca, B:22:0x0036, B:23:0x00a1, B:25:0x003e, B:26:0x0077, B:33:0x0088, B:34:0x008b, B:39:0x0045, B:41:0x0063, B:43:0x0069, B:46:0x00ab, B:50:0x00c8), top: B:2:0x000a }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.manager.a.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)I"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.cloud.hisavana.sdk.manager.CustomTabsManager$checkIsNeedBindServiceOrWarmUp$2", f = "CustomTabsManager.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function2<n0, Continuation<? super Integer>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22781a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22782b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f22783c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(AdsDTO adsDTO, Context context, Continuation<? super g> continuation) {
            super(2, continuation);
            this.f22782b = adsDTO;
            this.f22783c = context;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n0 n0Var, Continuation<? super Integer> continuation) {
            return ((g) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.f22782b, this.f22783c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AdsDTO adsDTO;
            String clickUrl;
            String clickUrl2;
            String offlineH5Url;
            IntrinsicsKt.f();
            if (this.f22781a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            a aVar = a.f22735a;
            if (aVar.U(false) && a.f22758x) {
                return Boxing.d(1);
            }
            if (aVar.U(false) && !a.f22758x) {
                return Boxing.d(3);
            }
            int b02 = aVar.b0();
            if (b02 == 7014 || b02 == 7020 || b02 == 7021) {
                e4.b().d("CustomTabsManager", "cct abtest switch state closed checkCCTabTest->" + b02);
                return Boxing.d(2);
            }
            if (!com.cloud.hisavana.sdk.common.util.b.f22230a.f(this.f22782b)) {
                return Boxing.d(2);
            }
            AdsDTO adsDTO2 = this.f22782b;
            if (adsDTO2 != null && adsDTO2.isOfflineAd() && (offlineH5Url = this.f22782b.getOfflineH5Url()) != null && offlineH5Url.length() == 0) {
                e4.b().d("CustomTabsManager", "offline page,not warmup");
                return Boxing.d(2);
            }
            AdsDTO adsDTO3 = this.f22782b;
            if (adsDTO3 != null && adsDTO3.isOfflineAd() && !NetStateManager.checkNetworkState(false)) {
                e4.b().d("CustomTabsManager", "offline page,not warmup");
                return Boxing.d(2);
            }
            AdsDTO adsDTO4 = this.f22782b;
            if ((adsDTO4 != null && (clickUrl2 = adsDTO4.getClickUrl()) != null && clickUrl2.length() == 0) || ((adsDTO = this.f22782b) != null && (clickUrl = adsDTO.getClickUrl()) != null && !StringsKt.W(clickUrl, "http", false, 2, null))) {
                e4.b().d("CustomTabsManager", "not http,not warmup");
                return Boxing.d(2);
            }
            int a11 = aVar.a(this.f22783c, this.f22782b);
            if (a11 == 0) {
                return Boxing.d(4);
            }
            e4.b().d("CustomTabsManager", "cct switch state closed,code: " + a11);
            aVar.o(a11, false);
            return Boxing.d(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.cloud.hisavana.sdk.manager.CustomTabsManager$creatCCTServiceAsyncIfNeeded$1", f = "CustomTabsManager.kt", l = {434, 450}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22784a;

        /* renamed from: b, reason: collision with root package name */
        int f22785b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f22786c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22787d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f22788e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Context context, AdsDTO adsDTO, boolean z10, Continuation<? super h> continuation) {
            super(2, continuation);
            this.f22786c = context;
            this.f22787d = adsDTO;
            this.f22788e = z10;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((h) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h(this.f22786c, this.f22787d, this.f22788e, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x00a8 A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #0 {all -> 0x00b1, blocks: (B:7:0x0012, B:8:0x008c, B:10:0x00a8, B:27:0x004b, B:29:0x0055, B:32:0x0064, B:34:0x006a, B:37:0x0074, B:39:0x0078, B:40:0x0082), top: B:2:0x000a }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.f22785b
                java.lang.String r2 = "CustomTabsManager"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                int r0 = r7.f22784a
                kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> Lb1
                goto L8c
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1f:
                kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L3c
                goto L35
            L23:
                kotlin.ResultKt.b(r8)
                com.cloud.hisavana.sdk.manager.a r8 = com.cloud.hisavana.sdk.manager.a.f22735a     // Catch: java.lang.Throwable -> L3c
                android.content.Context r1 = r7.f22786c     // Catch: java.lang.Throwable -> L3c
                com.cloud.hisavana.sdk.data.bean.response.AdsDTO r5 = r7.f22787d     // Catch: java.lang.Throwable -> L3c
                r7.f22785b = r4     // Catch: java.lang.Throwable -> L3c
                java.lang.Object r8 = com.cloud.hisavana.sdk.manager.a.j(r8, r1, r5, r7)     // Catch: java.lang.Throwable -> L3c
                if (r8 != r0) goto L35
                return r0
            L35:
                java.lang.Number r8 = (java.lang.Number) r8     // Catch: java.lang.Throwable -> L3c
                int r8 = r8.intValue()     // Catch: java.lang.Throwable -> L3c
                goto L3d
            L3c:
                r8 = r3
            L3d:
                if (r8 == r4) goto L82
                if (r8 == r3) goto L78
                r1 = 3
                if (r8 == r1) goto L64
                r1 = 4
                if (r8 == r1) goto L55
                r0 = 5
                if (r8 == r0) goto L4b
                goto L8b
            L4b:
                com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> Lb1
                java.lang.String r1 = "CCT is unenable"
                r0.d(r2, r1)     // Catch: java.lang.Throwable -> Lb1
                goto L8b
            L55:
                com.cloud.hisavana.sdk.manager.a r1 = com.cloud.hisavana.sdk.manager.a.f22735a     // Catch: java.lang.Throwable -> Lb1
                android.content.Context r5 = r7.f22786c     // Catch: java.lang.Throwable -> Lb1
                r7.f22784a = r8     // Catch: java.lang.Throwable -> Lb1
                r7.f22785b = r3     // Catch: java.lang.Throwable -> Lb1
                java.lang.Object r1 = com.cloud.hisavana.sdk.manager.a.l(r1, r5, r4, r7)     // Catch: java.lang.Throwable -> Lb1
                if (r1 != r0) goto L8b
                return r0
            L64:
                androidx.browser.customtabs.CustomTabsClient r0 = com.cloud.hisavana.sdk.manager.a.d()     // Catch: java.lang.Throwable -> Lb1
                if (r0 == 0) goto L73
                r5 = 0
                boolean r0 = r0.e(r5)     // Catch: java.lang.Throwable -> Lb1
                if (r0 == 0) goto L73
                goto L74
            L73:
                r4 = 0
            L74:
                com.cloud.hisavana.sdk.manager.a.R(r4)     // Catch: java.lang.Throwable -> Lb1
                goto L8b
            L78:
                com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> Lb1
                java.lang.String r1 = "CreatCCTServiceAsyncIfNeeded failed now "
                r0.d(r2, r1)     // Catch: java.lang.Throwable -> Lb1
                goto L8b
            L82:
                com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> Lb1
                java.lang.String r1 = "CreatCCTServiceAsyncIfNeeded success now "
                r0.d(r2, r1)     // Catch: java.lang.Throwable -> Lb1
            L8b:
                r0 = r8
            L8c:
                com.cloud.hisavana.sdk.e4 r8 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> Lb1
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb1
                r1.<init>()     // Catch: java.lang.Throwable -> Lb1
                java.lang.String r3 = "bind service end, checkIsNeedBindServiceOrWarmUp is "
                r1.append(r3)     // Catch: java.lang.Throwable -> Lb1
                r1.append(r0)     // Catch: java.lang.Throwable -> Lb1
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb1
                r8.w(r2, r1)     // Catch: java.lang.Throwable -> Lb1
                boolean r8 = r7.f22788e     // Catch: java.lang.Throwable -> Lb1
                if (r8 == 0) goto Lb1
                com.cloud.hisavana.sdk.manager.a r8 = com.cloud.hisavana.sdk.manager.a.f22735a     // Catch: java.lang.Throwable -> Lb1
                android.content.Context r1 = r7.f22786c     // Catch: java.lang.Throwable -> Lb1
                com.cloud.hisavana.sdk.data.bean.response.AdsDTO r2 = r7.f22787d     // Catch: java.lang.Throwable -> Lb1
                com.cloud.hisavana.sdk.manager.a.x(r8, r1, r2, r0)     // Catch: java.lang.Throwable -> Lb1
            Lb1:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.manager.a.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)I"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.cloud.hisavana.sdk.manager.CustomTabsManager$loadURLBySession$2", f = "CustomTabsManager.kt", l = {}, m = "invokeSuspend")
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class i extends SuspendLambda implements Function2<n0, Continuation<? super Integer>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22789a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f22790b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22791c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DownUpPointBean f22792d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Context context, AdsDTO adsDTO, DownUpPointBean downUpPointBean, Continuation<? super i> continuation) {
            super(2, continuation);
            this.f22790b = context;
            this.f22791c = adsDTO;
            this.f22792d = downUpPointBean;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n0 n0Var, Continuation<? super Integer> continuation) {
            return ((i) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new i(this.f22790b, this.f22791c, this.f22792d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i11;
            Context context;
            String str;
            androidx.browser.customtabs.d a11;
            String splicedURL;
            com.cloud.hisavana.sdk.common.util.b bVar;
            IntrinsicsKt.f();
            if (this.f22789a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            try {
                context = this.f22790b;
                boolean z10 = context instanceof Activity;
                boolean z11 = !z10;
                str = "";
                i11 = 0;
                if (z10) {
                    a.f22747m = true;
                    String simpleName = context.getClass().getSimpleName();
                    Intrinsics.g(simpleName, "getSimpleName(...)");
                    a.f22745k = simpleName;
                } else {
                    Activity h11 = m.h();
                    if (h11 != null) {
                        a aVar = a.f22735a;
                        String simpleName2 = h11.getClass().getSimpleName();
                        Intrinsics.g(simpleName2, "getSimpleName(...)");
                        a.f22745k = simpleName2;
                        a.f22747m = true;
                        context = h11;
                        z11 = false;
                    } else {
                        a.f22745k = "";
                    }
                }
                a.f22735a.J(this.f22791c);
                d.b bVar2 = new d.b(a.f22757w);
                try {
                    bVar2.e(2);
                } catch (Throwable unused) {
                }
                bVar2.f(true);
                a11 = bVar2.a();
                Intrinsics.g(a11, "build(...)");
                if (z11) {
                    a11.f2241a.setFlags(ASTNode.DEOP);
                }
                a11.f2241a.setPackage("com.android.chrome");
                a11.f2241a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", true);
                a11.f2241a.putExtra("androidx.browser.customtabs.extra.ACTIVITY_SIDE_SHEET_ENABLE_MAXIMIZATION", false);
                a11.f2241a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_DOWNLOAD_BUTTON", true);
                a11.f2241a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_STAR_BUTTON", true);
                a.f22735a.A(Boxing.d(19));
                SSPParamSplicedResult a12 = com.cloud.hisavana.sdk.common.activity.b.a(this.f22792d, this.f22791c);
                splicedURL = a12.getSplicedURL();
                if (splicedURL == null) {
                    splicedURL = "";
                }
                String originalUrl = a12.getOriginalUrl();
                if (originalUrl != null) {
                    str = originalUrl;
                }
                bVar = com.cloud.hisavana.sdk.common.util.b.f22230a;
            } catch (Exception e11) {
                Log.w("CustomTabsManager", "launchUrl failed,error: " + Log.getStackTraceString(e11));
                i11 = TaErrorCode.CLICK_ERROR_CODE_CCT_LAUNCH_FAILED;
            }
            if (bVar.g(this.f22791c)) {
                AdsDTO adsDTO = this.f22791c;
                if (bVar.h(adsDTO != null ? adsDTO.getRealLandUrl() : null)) {
                    AdsDTO adsDTO2 = this.f22791c;
                    Intrinsics.e(adsDTO2);
                    String realLandUrl = adsDTO2.getRealLandUrl();
                    Intrinsics.g(realLandUrl, "getRealLandUrl(...)");
                    Uri parse = Uri.parse(realLandUrl);
                    Intrinsics.g(parse, "parse(this)");
                    a11.a(context, parse);
                    AdsDTO adsDTO3 = this.f22791c;
                    c1.m(splicedURL, adsDTO3, null, new c1.d(adsDTO3));
                    AthenaTracker.G(str, this.f22791c, Boxing.a(false));
                    return Boxing.d(i11);
                }
            }
            Uri parse2 = Uri.parse(splicedURL);
            Intrinsics.g(parse2, "parse(this)");
            a11.a(context, parse2);
            AthenaTracker.G(str, this.f22791c, Boxing.a(false));
            return Boxing.d(i11);
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int i11, long j11) {
        try {
            long j12 = f22750p - f22751q;
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            Integer valueOf = Integer.valueOf(i11);
            WeakReference weakReference = f22746l;
            sSPTrackingHelper.Q(valueOf, weakReference != null ? (AdsDTO) weakReference.get() : null, Long.valueOf(j12), Long.valueOf(j11), Boolean.valueOf(f22758x), f22744j, Boolean.valueOf(f22752r != -1), f0());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(AdsDTO adsDTO) {
        try {
            f22746l = new WeakReference(adsDTO);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(String str) {
        if (f22748n) {
            if (Intrinsics.c(str, f22745k) || f22749o) {
                m.k(null);
                f22747m = true;
                f22749o = false;
                e4.b().d("CustomTabsManager", "upload finish tracking");
                k0();
                return;
            }
            return;
        }
        if (Intrinsics.c(str, f22745k)) {
            f22749o = true;
            e4.b().d("CustomTabsManager", "isActivityResume true");
            return;
        }
        m.k(null);
        f22747m = true;
        e4.b().d("CustomTabsManager", "isActivityResume " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U(boolean z10) {
        boolean z11 = true;
        boolean z12 = (f22756v == null || f22755u == null) ? false : true;
        if (z12 && z10) {
            e4.b().d("CustomTabsManager", "checkServerIsAvailable: service is connected check alive");
            try {
                j jVar = f22757w;
                if (jVar != null) {
                    jVar.i(OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_TEST, null);
                }
            } catch (Throwable unused) {
                z11 = false;
            }
            e4.b().d("CustomTabsManager", "checkServerIsAvailable: alive ->" + z11);
            CustomTabsClient customTabsClient = f22756v;
            f22757w = customTabsClient != null ? customTabsClient.c(f22759y) : null;
            if (!z11) {
                e4.b().d("CustomTabsManager", "checkServerIsAvailable: service is not connected,need bind");
                f22756v = null;
                f22755u = null;
                f22758x = false;
                return false;
            }
        }
        return z12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        try {
            f22750p = 0L;
            f22753s = -1L;
            f22754t = -1L;
            f22752r = -1L;
            WeakReference weakReference = f22746l;
            if (weakReference != null) {
                weakReference.clear();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(Context context, AdsDTO adsDTO, DownUpPointBean downUpPointBean, Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.c(), new i(context, adsDTO, downUpPointBean, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(Context context, AdsDTO adsDTO, Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.a(), new g(adsDTO, context, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(Context context, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        try {
            f22755u = new c(cancellableContinuationImpl);
            k.d(HSScopeHelper.f23249a.b(), null, null, new d(context, cancellableContinuationImpl, null), 3, null);
        } catch (Throwable th2) {
            Log.e("CustomTabsManager", "bindCustomTabsService: ", th2);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066 A[Catch: all -> 0x009c, TryCatch #0 {all -> 0x009c, blocks: (B:11:0x002e, B:12:0x0062, B:14:0x0066, B:17:0x0070, B:19:0x0074, B:22:0x007e, B:24:0x0080, B:26:0x0084, B:27:0x008a, B:28:0x0097, B:36:0x003d, B:38:0x0043, B:40:0x0049, B:41:0x0050), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(android.content.Context r9, boolean r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.cloud.hisavana.sdk.manager.a.C0315a
            if (r0 == 0) goto L13
            r0 = r11
            com.cloud.hisavana.sdk.manager.a$a r0 = (com.cloud.hisavana.sdk.manager.a.C0315a) r0
            int r1 = r0.f22764e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22764e = r1
            goto L18
        L13:
            com.cloud.hisavana.sdk.manager.a$a r0 = new com.cloud.hisavana.sdk.manager.a$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f22762c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f22764e
            r3 = 7006(0x1b5e, float:9.817E-42)
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3a
            if (r2 != r5) goto L32
            boolean r10 = r0.f22761b
            java.lang.Object r9 = r0.f22760a
            com.cloud.hisavana.sdk.manager.a r9 = (com.cloud.hisavana.sdk.manager.a) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L9c
            goto L62
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            kotlin.ResultKt.b(r11)
            com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomTabConfigDTO r11 = com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigManager.getCustomTabData()     // Catch: java.lang.Throwable -> L9c
            if (r11 == 0) goto L4e
            java.lang.Long r11 = r11.getCctBindTimeout()     // Catch: java.lang.Throwable -> L9c
            if (r11 == 0) goto L4e
            long r6 = r11.longValue()     // Catch: java.lang.Throwable -> L9c
            goto L50
        L4e:
            r6 = 1000(0x3e8, double:4.94E-321)
        L50:
            com.cloud.hisavana.sdk.manager.a$b r11 = new com.cloud.hisavana.sdk.manager.a$b     // Catch: java.lang.Throwable -> L9c
            r11.<init>(r9, r4)     // Catch: java.lang.Throwable -> L9c
            r0.f22760a = r8     // Catch: java.lang.Throwable -> L9c
            r0.f22761b = r10     // Catch: java.lang.Throwable -> L9c
            r0.f22764e = r5     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.e(r6, r11, r0)     // Catch: java.lang.Throwable -> L9c
            if (r11 != r1) goto L62
            return r1
        L62:
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch: java.lang.Throwable -> L9c
            if (r11 == 0) goto L6b
            int r9 = r11.intValue()     // Catch: java.lang.Throwable -> L9c
            goto L6c
        L6b:
            r9 = r3
        L6c:
            if (r9 != 0) goto L97
            if (r10 == 0) goto L80
            androidx.browser.customtabs.CustomTabsClient r10 = com.cloud.hisavana.sdk.manager.a.f22756v     // Catch: java.lang.Throwable -> L9c
            if (r10 == 0) goto L7d
            r0 = 0
            boolean r10 = r10.e(r0)     // Catch: java.lang.Throwable -> L9c
            if (r10 == 0) goto L7d
            goto L7e
        L7d:
            r5 = 0
        L7e:
            com.cloud.hisavana.sdk.manager.a.f22758x = r5     // Catch: java.lang.Throwable -> L9c
        L80:
            androidx.browser.customtabs.CustomTabsClient r10 = com.cloud.hisavana.sdk.manager.a.f22756v     // Catch: java.lang.Throwable -> L9c
            if (r10 == 0) goto L8a
            com.cloud.hisavana.sdk.manager.a$e r11 = com.cloud.hisavana.sdk.manager.a.f22759y     // Catch: java.lang.Throwable -> L9c
            androidx.browser.customtabs.j r4 = r10.c(r11)     // Catch: java.lang.Throwable -> L9c
        L8a:
            com.cloud.hisavana.sdk.manager.a.f22757w = r4     // Catch: java.lang.Throwable -> L9c
            com.cloud.hisavana.sdk.e4 r10 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = "CustomTabsManager"
            java.lang.String r0 = "bindCustomTabsService success now "
            r10.d(r11, r0)     // Catch: java.lang.Throwable -> L9c
        L97:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.d(r9)     // Catch: java.lang.Throwable -> L9c
            return r9
        L9c:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.d(r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.manager.a.h(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        f22756v = null;
        f22757w = null;
        f22755u = null;
        f22758x = false;
        d0();
    }

    private final void k0() {
        long j11 = f22753s;
        int i11 = TaErrorCode.CCT_LOAD_EXIT;
        if (j11 == -1 && f22754t == -1) {
            long j12 = f22752r;
            if (j12 != -1) {
                H(TaErrorCode.CCT_LOAD_ABORTED, j12);
            } else {
                n(TaErrorCode.CCT_LOAD_EXIT, System.currentTimeMillis() - f22750p);
            }
        }
        try {
            long j13 = f22750p - f22751q;
            long currentTimeMillis = System.currentTimeMillis() - f22750p;
            long j14 = f22753s;
            if (j14 != -1) {
                i11 = 0;
            } else {
                j14 = f22754t;
                if (j14 != -1) {
                    i11 = TaErrorCode.CCT_LOAD_FAILED;
                } else {
                    j14 = f22752r;
                    if (j14 != -1) {
                        i11 = 8009;
                    } else {
                        j14 = currentTimeMillis;
                    }
                }
            }
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            Integer valueOf = Integer.valueOf(i11);
            WeakReference weakReference = f22746l;
            sSPTrackingHelper.S(valueOf, weakReference != null ? (AdsDTO) weakReference.get() : null, Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(currentTimeMillis), Boolean.valueOf(f22758x), f22744j, Boolean.valueOf(f22752r != -1), f0());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int i11, long j11) {
        try {
            long j12 = f22750p - f22751q;
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            Integer valueOf = Integer.valueOf(i11);
            WeakReference weakReference = f22746l;
            sSPTrackingHelper.Q(valueOf, weakReference != null ? (AdsDTO) weakReference.get() : null, Long.valueOf(j12), Long.valueOf(j11), Boolean.valueOf(f22758x), f22744j, Boolean.valueOf(f22752r != -1), f0());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Context context, AdsDTO adsDTO, int i11) {
        if (adsDTO == null) {
            return;
        }
        com.cloud.hisavana.sdk.common.util.b bVar = com.cloud.hisavana.sdk.common.util.b.f22230a;
        if (bVar.g(adsDTO)) {
            if (i11 == 5) {
                k4.f22682a.l(context, adsDTO);
                return;
            }
            if (f22757w == null) {
                e4.b().d("CustomTabsManager", "preload h5, mCCTSession is null");
                adsDTO.setPreloadStatus(3);
                return;
            }
            if (!bVar.h(adsDTO.getRealLandUrl())) {
                adsDTO.setPreloadStatus(8);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f22743i <= 2000) {
                e4.b().d("CustomTabsManager", "preload h5, cool down time is 2000ms");
                if (adsDTO.getPreloadStatus() < 2) {
                    adsDTO.setPreloadStatus(2);
                    return;
                }
                return;
            }
            e4.b().d("CustomTabsManager", "start preload h5, url is : " + adsDTO.getRealLandUrl());
            j jVar = f22757w;
            if (jVar != null) {
                String realLandUrl = adsDTO.getRealLandUrl();
                Intrinsics.g(realLandUrl, "getRealLandUrl(...)");
                Uri parse = Uri.parse(realLandUrl);
                Intrinsics.g(parse, "parse(this)");
                jVar.h(parse, null, null);
            }
            adsDTO.setPreloadStatus(5);
            f22743i = currentTimeMillis;
        }
    }

    public final void A(Integer num) {
        f22742h = num;
    }

    public final int E(Context context, AdsDTO adsDTO, DownUpPointBean downUpPointBean) {
        Intrinsics.h(context, "context");
        try {
            String G = G(context);
            A(24);
            SSPParamSplicedResult a11 = com.cloud.hisavana.sdk.common.activity.b.a(downUpPointBean, adsDTO);
            String splicedURL = a11.getSplicedURL();
            String originalUrl = a11.getOriginalUrl();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(splicedURL));
            if (G == null || G.length() <= 0) {
                return TaErrorCode.CLICK_ERROR_CODE_NOT_GET_DEFAULT_BROWSER_PKG;
            }
            intent.setPackage(G);
            intent.addFlags(ASTNode.DEOP);
            context.startActivity(intent);
            AthenaTracker.G(originalUrl, adsDTO, Boolean.FALSE);
            return 0;
        } catch (Throwable unused) {
            return TaErrorCode.CLICK_ERROR_CODE_DEFAULT_BROWSER_LAUNCH_FAILED;
        }
    }

    public final String G(Context context) {
        ActivityInfo activityInfo;
        Intrinsics.h(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.hisavana.com"));
            intent.addCategory("android.intent.category.BROWSABLE");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null) {
                return activityInfo.packageName;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void M(Integer num) {
        f22739e = num;
    }

    public final int a(Context context, AdsDTO adsDTO) {
        ArrayList<Integer> arrayList;
        ArrayList<String> arrayList2;
        ArrayList<String> arrayList3;
        Boolean enableCctSwitch;
        Integer dIntervalTime;
        Boolean enableSplashADcct;
        String clickUrl = adsDTO != null ? adsDTO.getClickUrl() : null;
        if (clickUrl == null) {
            return TaErrorCode.CLICK_ERROR_CODE_NOT_HTTP_URL;
        }
        if (!StringsKt.W(clickUrl, "http://", false, 2, null) && !StringsKt.W(clickUrl, "https://", false, 2, null)) {
            return TaErrorCode.CLICK_ERROR_CODE_NOT_HTTP_URL;
        }
        if (adsDTO != null && adsDTO.getAdType() == 4) {
            CustomTabConfigDTO customTabData = CustomConfigManager.getCustomTabData();
            if (!((customTabData == null || (enableSplashADcct = customTabData.getEnableSplashADcct()) == null) ? false : enableSplashADcct.booleanValue())) {
                return TaErrorCode.CLICK_ERROR_CODE_CCT_SPLASH_NOT_ALLOW;
            }
        }
        int g11 = j7.a.e().g("cct_switch_state", 0);
        if (g11 != 0) {
            long i11 = j7.a.e().i("cct_switch_timestamp", 0L);
            CustomTabConfigDTO customTabData2 = CustomConfigManager.getCustomTabData();
            if (System.currentTimeMillis() - i11 < ((customTabData2 == null || (dIntervalTime = customTabData2.getDIntervalTime()) == null) ? 7 : dIntervalTime.intValue()) * TimeConstants.DAY) {
                return g11;
            }
            j7.a.e().p("cct_switch_state", 0);
            e4.b().d("CustomTabsManager", "checkInstallChromOrEnableCCT: " + g11);
        }
        CustomTabConfigDTO customTabData3 = CustomConfigManager.getCustomTabData();
        boolean z10 = true;
        if (!((customTabData3 == null || (enableCctSwitch = customTabData3.getEnableCctSwitch()) == null) ? true : enableCctSwitch.booleanValue())) {
            return TaErrorCode.CLICK_ERROR_CODE_CCT_CONFIG_CLOSED;
        }
        String str = f22744j;
        if (str.length() == 0) {
            str = f22735a.m(context);
        }
        f22744j = str;
        if (str.length() == 0) {
            e4.b().d("CustomTabsManager", "checkInstallChromOrEnableCCT:");
            return TaErrorCode.CLICK_ERROR_CODE_CCT_NOT_INSTALLED;
        }
        CustomTabConfigDTO customTabData4 = CustomConfigManager.getCustomTabData();
        if (customTabData4 == null || (arrayList = customTabData4.getSysBlackVersion()) == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.contains(Integer.valueOf(Build.VERSION.SDK_INT))) {
            return TaErrorCode.CLICK_ERROR_CODE_CCT_ANDROID_VERSION_BLOCKED;
        }
        String str2 = Build.BRAND;
        e4.b().d("CustomTabsManager", "devide model is -> " + str2);
        CustomTabConfigDTO customTabData5 = CustomConfigManager.getCustomTabData();
        if (customTabData5 == null || (arrayList2 = customTabData5.getWhiteDeviceModel()) == null) {
            arrayList2 = new ArrayList<>();
        }
        if (arrayList2.isEmpty()) {
            CustomTabConfigDTO customTabData6 = CustomConfigManager.getCustomTabData();
            if (customTabData6 == null || (arrayList3 = customTabData6.getBlackDeviceModel()) == null) {
                arrayList3 = new ArrayList<>();
            }
            if (!arrayList3.isEmpty()) {
                if (!arrayList3.isEmpty()) {
                    Iterator<T> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        if (StringsKt.H((String) it.next(), str2, true)) {
                            break;
                        }
                    }
                }
                z10 = false;
                if (z10) {
                    return TaErrorCode.CLICK_ERROR_CODE_CCT_ANDROID_MODEL_BLOCKED;
                }
            }
        } else {
            if (!arrayList2.isEmpty()) {
                Iterator<T> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (StringsKt.H((String) it2.next(), str2, true)) {
                        z10 = false;
                        break;
                    }
                }
            }
            if (z10) {
                return TaErrorCode.CLICK_ERROR_CODE_CCT_ANDROID_MODEL_BLOCKED;
            }
        }
        return 0;
    }

    public final int b(Context context, AdsDTO adsDTO, DownUpPointBean downUpPointBean) {
        Activity h11;
        Intrinsics.h(context, "context");
        try {
            boolean z10 = context instanceof Activity;
            boolean z11 = !z10;
            if (!z10 && (h11 = m.h()) != null) {
                context = h11;
                z11 = false;
            }
            J(adsDTO);
            d.b bVar = new d.b();
            try {
                bVar.e(2);
            } catch (Throwable unused) {
            }
            bVar.f(true);
            androidx.browser.customtabs.d a11 = bVar.a();
            Intrinsics.g(a11, "build(...)");
            if (z11) {
                a11.f2241a.setFlags(ASTNode.DEOP);
            }
            a11.f2241a.setPackage("com.android.chrome");
            a11.f2241a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", true);
            a11.f2241a.putExtra("androidx.browser.customtabs.extra.ACTIVITY_SIDE_SHEET_ENABLE_MAXIMIZATION", false);
            a11.f2241a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_DOWNLOAD_BUTTON", true);
            a11.f2241a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_STAR_BUTTON", true);
            A(23);
            SSPParamSplicedResult a12 = com.cloud.hisavana.sdk.common.activity.b.a(downUpPointBean, adsDTO);
            String splicedURL = a12.getSplicedURL();
            String str = "";
            if (splicedURL == null) {
                splicedURL = "";
            }
            String originalUrl = a12.getOriginalUrl();
            if (originalUrl != null) {
                str = originalUrl;
            }
            Uri parse = Uri.parse(splicedURL);
            Intrinsics.g(parse, "parse(this)");
            a11.a(context, parse);
            j3.a();
            AthenaTracker.G(str, adsDTO, Boolean.FALSE);
            return 0;
        } catch (Exception e11) {
            Log.w("CustomTabsManager", "launchUrl failed,error: " + Log.getStackTraceString(e11));
            return TaErrorCode.CLICK_ERROR_CODE_CCT_LAUNCH_FAILED_NOT_SESSION;
        }
    }

    public final int b0() {
        Map<String, String> info;
        ABTest aBTestData = CustomConfigManager.getABTestData(ClientABTestDTOKt.AB_CUSTOM_TAB);
        if (aBTestData != null) {
            Long layerId = aBTestData.getLayerId();
            ABVariantState aBTestVariant = ABTestKit.getABTestVariant(layerId, aBTestData.getReqInterval(), aBTestData.getSwitch());
            if (aBTestVariant.isOpen()) {
                ABVariantState.Open open = aBTestVariant instanceof ABVariantState.Open ? (ABVariantState.Open) aBTestVariant : null;
                ABVariant variant = open != null ? open.getVariant() : null;
                String str = (variant == null || (info = variant.getInfo()) == null) ? null : info.get("customTabGroup");
                f22736b = variant != null ? variant.getLayerId() : null;
                f22737c = variant != null ? variant.getExpId() : null;
                f22738d = variant != null ? variant.getSubExpId() : null;
                if (StringsKt.I(str, "true", false, 2, null)) {
                    f22740f = 1;
                    return TaErrorCode.CLICK_ERROR_CODE_CCT_ABTEST_HIT;
                }
                f22740f = 2;
                return TaErrorCode.CLICK_ERROR_CODE_CCT_ABTEST_NOT_HIT;
            }
            if (aBTestVariant.isPushAll()) {
                f22741g = true;
                f22736b = layerId;
                f22737c = 0L;
                f22738d = 0L;
                f22740f = 3;
                return TaErrorCode.CLICK_ERROR_CODE_CCT_ABTEST_PUSH_ALL;
            }
            if (aBTestVariant.isClosed()) {
                f22736b = layerId;
                f22737c = 0L;
                f22738d = 0L;
                ABVariantState.Closed closed = aBTestVariant instanceof ABVariantState.Closed ? (ABVariantState.Closed) aBTestVariant : null;
                f22739e = closed != null ? Integer.valueOf(closed.getCode()) : null;
                f22740f = 4;
                return TaErrorCode.CLICK_ERROR_CODE_CCT_ABTEST_CLOSED;
            }
        }
        f22740f = 5;
        return TaErrorCode.CLICK_ERROR_CODE_CCT_ABTEST_NULL;
    }

    public final int c(AdsDTO adsDTO) {
        CustomTabConfigDTO customTabData = CustomConfigManager.getCustomTabData();
        ArrayList<String> openDefaultBycIds = customTabData != null ? customTabData.getOpenDefaultBycIds() : null;
        if (openDefaultBycIds == null || !(!openDefaultBycIds.isEmpty())) {
            return -1;
        }
        String adCreativeId = adsDTO != null ? adsDTO.getAdCreativeId() : null;
        if (adCreativeId == null || adCreativeId.length() <= 0 || openDefaultBycIds.isEmpty()) {
            return -1;
        }
        Iterator<T> it = openDefaultBycIds.iterator();
        while (it.hasNext()) {
            if (StringsKt.H((String) it.next(), adCreativeId, true)) {
                return TaErrorCode.CLICK_ERROR_CODE_CONFIG_CREATIVE_ID_OPEN_DEFAULT;
            }
        }
        return -1;
    }

    public final boolean c0() {
        Boolean enableDefaultBrowserSwitch;
        try {
            CustomTabConfigDTO customTabData = CustomConfigManager.getCustomTabData();
            if (customTabData != null && (enableDefaultBrowserSwitch = customTabData.getEnableDefaultBrowserSwitch()) != null) {
                return enableDefaultBrowserSwitch.booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final Long e0() {
        return f22738d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0085, code lost:
    
        if (r1.intValue() != 0) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle f0() {
        /*
            r7 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.Long r1 = com.cloud.hisavana.sdk.manager.a.f22736b     // Catch: java.lang.Throwable -> L93
            r2 = 0
            r4 = 0
            if (r1 == 0) goto L21
            long r5 = r1.longValue()     // Catch: java.lang.Throwable -> L93
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 == 0) goto L15
            goto L16
        L15:
            r1 = r4
        L16:
            if (r1 == 0) goto L21
            long r5 = r1.longValue()     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = "s_ab_layer_id"
            r0.putLong(r1, r5)     // Catch: java.lang.Throwable -> L93
        L21:
            java.lang.Long r1 = com.cloud.hisavana.sdk.manager.a.f22737c     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L3a
            long r5 = r1.longValue()     // Catch: java.lang.Throwable -> L93
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 == 0) goto L2e
            goto L2f
        L2e:
            r1 = r4
        L2f:
            if (r1 == 0) goto L3a
            long r5 = r1.longValue()     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = "s_ab_exp_id"
            r0.putLong(r1, r5)     // Catch: java.lang.Throwable -> L93
        L3a:
            java.lang.Long r1 = com.cloud.hisavana.sdk.manager.a.f22738d     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L53
            long r5 = r1.longValue()     // Catch: java.lang.Throwable -> L93
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 == 0) goto L47
            goto L48
        L47:
            r1 = r4
        L48:
            if (r1 == 0) goto L53
            long r1 = r1.longValue()     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = "var_id"
            r0.putLong(r3, r1)     // Catch: java.lang.Throwable -> L93
        L53:
            java.lang.Integer r1 = com.cloud.hisavana.sdk.manager.a.f22739e     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L6a
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L5e
            goto L5f
        L5e:
            r1 = r4
        L5f:
            if (r1 == 0) goto L6a
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = "s_ab_reason"
            r0.putInt(r2, r1)     // Catch: java.lang.Throwable -> L93
        L6a:
            boolean r1 = com.cloud.hisavana.sdk.manager.a.f22741g     // Catch: java.lang.Throwable -> L93
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L73
            goto L74
        L73:
            r2 = r4
        L74:
            if (r2 == 0) goto L7c
            java.lang.String r1 = "s_ab_push"
            r2 = 1
            r0.putInt(r1, r2)     // Catch: java.lang.Throwable -> L93
        L7c:
            java.lang.Integer r1 = com.cloud.hisavana.sdk.manager.a.f22740f     // Catch: java.lang.Throwable -> L93
            if (r1 != 0) goto L81
            goto L87
        L81:
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L88
        L87:
            r4 = r1
        L88:
            if (r4 == 0) goto L93
            int r1 = r4.intValue()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = "s_ab_status"
            r0.putInt(r2, r1)     // Catch: java.lang.Throwable -> L93
        L93:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.manager.a.f0():android.os.Bundle");
    }

    public final Integer g0() {
        return f22742h;
    }

    public final Integer h0() {
        return f22740f;
    }

    public final void i0() {
        f22736b = 0L;
        f22737c = 0L;
        f22738d = 0L;
        f22739e = 0;
        f22741g = false;
        f22740f = 0;
        f22742h = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1a
            if (r4 == 0) goto L1c
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L1a
            if (r4 == 0) goto L1c
            java.lang.String r1 = "com.android.chrome"
            r2 = 0
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r1, r2)     // Catch: java.lang.Throwable -> L1a
            if (r4 == 0) goto L1c
            java.lang.String r4 = r4.versionName     // Catch: java.lang.Throwable -> L1a
            if (r4 != 0) goto L1d
            goto L1c
        L1a:
            r4 = move-exception
            goto L22
        L1c:
            r4 = r0
        L1d:
            java.lang.Object r4 = kotlin.Result.m1185constructorimpl(r4)     // Catch: java.lang.Throwable -> L1a
            goto L2c
        L22:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.m1185constructorimpl(r4)
        L2c:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r4)
            if (r1 != 0) goto L33
            r0 = r4
        L33:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.manager.a.m(android.content.Context):java.lang.String");
    }

    public final void o(int i11, boolean z10) {
        int g11 = j7.a.e().g("cct_switch_state", 0);
        if (z10 || !(g11 != 0 || i11 == 7009 || i11 == 7012 || i11 == 7014 || i11 == 7006 || i11 == 7007 || i11 == 7005 || i11 == 7016 || i11 == 7017 || i11 == 7023 || i11 == -1)) {
            j7.a.e().p("cct_switch_state", i11);
            j7.a.e().q("cct_switch_timestamp", System.currentTimeMillis());
        }
    }

    public final void r(Context context, AdsDTO adsDTO, DownUpPointBean downUpPointBean, Function1 onComplete) {
        Intrinsics.h(context, "context");
        Intrinsics.h(onComplete, "onComplete");
        k.d(HSScopeHelper.f23249a.b(), null, null, new f(context, adsDTO, downUpPointBean, onComplete, null), 3, null);
    }

    public final void s(Context context, AdsDTO adsDTO, boolean z10) {
        Intrinsics.h(context, "context");
        e4 b11 = e4.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("preload is ");
        sb2.append(z10);
        sb2.append(", preloadEnable is ");
        sb2.append(adsDTO != null ? adsDTO.getPreloadEnable() : null);
        sb2.append(", realLandUrl is ");
        sb2.append(adsDTO != null ? adsDTO.getRealLandUrl() : null);
        b11.w("CustomTabsManager", sb2.toString());
        if (z10 || !com.cloud.hisavana.sdk.common.util.b.f22230a.g(adsDTO)) {
            CustomTabConfigDTO customTabData = CustomConfigManager.getCustomTabData();
            if (Intrinsics.c(customTabData != null ? customTabData.getEnableWarmUp() : null, Boolean.TRUE) || z10) {
                k.d(HSScopeHelper.f23249a.b(), null, null, new h(context, adsDTO, z10, null), 3, null);
            }
        }
    }
}
