package com.transsion.startup;

import android.app.Application;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.therouter.TheRouter;
import com.therouter.router.RouteItem;
import com.transsion.baselib.report.l;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.upload.log.UploadLoggerManager;
import com.transsnet.loginapi.bean.UserInfo;
import com.wecloud.load.lib.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import nh.n;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public final class StartupManager implements dz.a, n {

    /* renamed from: g, reason: collision with root package name */
    public static final a f54557g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f54558h = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.startup.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            StartupManager e11;
            e11 = StartupManager.e();
            return e11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private boolean f54559a;

    /* renamed from: c, reason: collision with root package name */
    private Application f54561c;

    /* renamed from: b, reason: collision with root package name */
    private final List f54560b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f54562d = LazyKt.b(new Function0() { // from class: com.transsion.startup.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            yt.a e02;
            e02 = StartupManager.e0();
            return e02;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f54563e = LazyKt.b(new Function0() { // from class: com.transsion.startup.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a E;
            E = StartupManager.E();
            return E;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final n0 f54564f = o0.a(y0.b().plus(l2.b(null, 1, null)));

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StartupManager a() {
            return (StartupManager) StartupManager.f54558h.getValue();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mmkv.a {
        b() {
        }

        @Override // com.tencent.mmkv.a
        public void a(MMKVLogLevel mMKVLogLevel, String str, int i11, String str2, String str3) {
            if (mMKVLogLevel == MMKVLogLevel.LevelError) {
                a.C0856a.l(lg.a.f68962a, "MMKV_HANDLER", "Error: " + str3, false, 4, null);
                return;
            }
            a.C0856a.f(lg.a.f68962a, "MMKV_HANDLER", "Debug: " + str3, false, 4, null);
        }

        @Override // com.tencent.mmkv.a
        public MMKVRecoverStrategic b(String str) {
            a.C0856a.l(lg.a.f68962a, "MMKV_HANDLER", "CRC Check Fail for ID: " + str + ". Discarding...", false, 4, null);
            return MMKVRecoverStrategic.OnErrorDiscard;
        }

        @Override // com.tencent.mmkv.a
        public boolean c() {
            return false;
        }

        @Override // com.tencent.mmkv.a
        public MMKVRecoverStrategic d(String str) {
            a.C0856a.l(lg.a.f68962a, "MMKV_HANDLER", "File Length Error for ID: " + str + ". Discarding...", false, 4, null);
            return MMKVRecoverStrategic.OnErrorDiscard;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements l.a {
        c() {
        }

        @Override // com.transsion.baselib.report.l.a
        public void onBackgroundStatusChange(boolean z10) {
            if (z10) {
                yt.a H = StartupManager.this.H();
                Application application = StartupManager.this.f54561c;
                if (application == null) {
                    Intrinsics.z("app");
                    application = null;
                }
                H.b(application);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements rm.b {
        d() {
        }

        @Override // rm.b
        public void a() {
            StartupManager.this.f54559a = true;
            StartupManager.this.i0();
        }

        @Override // rm.b
        public void b() {
            IFissionProvider iFissionProvider = (IFissionProvider) TheRouter.d(IFissionProvider.class, new Object[0]);
            if (iFissionProvider != null) {
                IFissionProvider.a.a(iFissionProvider, false, 1, null);
            }
            UploadLoggerManager.f56759a.g();
            StartupManager.this.m0();
            StartupManager.this.f54559a = true;
            StartupManager.this.i0();
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements oo.f {
        e() {
        }

        @Override // oo.f
        public void a(String tag, String msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            lg.a.f68962a.p(tag, new String[]{msg}, z10);
        }

        @Override // oo.f
        public void b(String tag, String msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            lg.a.f68962a.c(tag, msg, z10);
        }

        @Override // oo.f
        public void c(String tag, String msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            lg.a.f68962a.u(tag, msg, z10);
        }

        @Override // oo.f
        public void d(String tag, String msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            lg.a.f68962a.i(tag, msg, z10);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements bg.f {
        f() {
        }

        @Override // bg.f
        public void a(RouteItem routeItem, bg.b callback) {
            Object m1185constructorimpl;
            Unit unit;
            Intrinsics.h(routeItem, "routeItem");
            Intrinsics.h(callback, "callback");
            a.C0856a.f(lg.a.f68962a, "TheRouter-Interceptor", "process path :" + routeItem.getPath() + ", extras:" + routeItem.getExtras(), false, 4, null);
            xj.a aVar = new xj.a(callback, routeItem);
            Unit unit2 = null;
            try {
                Result.Companion companion = Result.INSTANCE;
                IPostDetailApi iPostDetailApi = (IPostDetailApi) TheRouter.d(IPostDetailApi.class, new Object[0]);
                if (iPostDetailApi != null) {
                    iPostDetailApi.a(routeItem, aVar);
                    unit = Unit.f67184a;
                } else {
                    unit = null;
                }
                Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
            try {
                IMovieDetailService iMovieDetailService = (IMovieDetailService) TheRouter.d(IMovieDetailService.class, new Object[0]);
                if (iMovieDetailService != null) {
                    iMovieDetailService.a(routeItem, aVar);
                    unit2 = Unit.f67184a;
                }
                Result.m1185constructorimpl(unit2);
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th3));
            }
            try {
                m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(aVar.b()));
            } catch (Throwable th4) {
                Result.Companion companion4 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th4));
            }
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                a.C0856a.f(lg.a.f68962a, "TheRouter-replace", "intercepted  " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends bg.e {
        g() {
        }

        @Override // bg.e
        public String b(String str) {
            a.C0856a.f(lg.a.f68962a, "TheRouter-replace", "replace path :" + str, false, 4, null);
            Uri parse = str != null ? Uri.parse(str) : null;
            if (parse == null || !Intrinsics.c(parse.getScheme(), GifImagePreviewActivity.PICTURE_SAVE)) {
                return str;
            }
            String queryParameter = parse.getQueryParameter(NativeComponentConstants.KEY_COMPONENT_TYPE);
            if (queryParameter == null) {
                queryParameter = "";
            }
            return queryParameter.length() > 0 ? parse.buildUpon().path(queryParameter).build().toString() : str;
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements j.a {
        h() {
        }

        @Override // com.wecloud.load.lib.j.a
        public void a(String eventName, Map data) {
            Intrinsics.h(eventName, "eventName");
            Intrinsics.h(data, "data");
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.e(data.size()));
                for (Object obj : data.entrySet()) {
                    Object key = ((Map.Entry) obj).getKey();
                    Object value = ((Map.Entry) obj).getValue();
                    if (value != null && (r1 = value.toString()) != null) {
                        linkedHashMap.put(key, r1);
                    }
                    String str = "";
                    linkedHashMap.put(key, str);
                }
                hj.i.f64628a.t(eventName, linkedHashMap);
            } catch (Throwable th2) {
                a.C0856a.l(lg.a.f68962a, "StartupManager", "network probe report error: " + th2, false, 4, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class i extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f54567d;

        i(Function1 function1) {
            this.f54567d = function1;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            this.f54567d.invoke(Boolean.FALSE);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            this.f54567d.invoke(Boolean.TRUE);
        }
    }

    private final native void B();

    private final native void C(Context context);

    private final native void D();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native com.transsion.startup.a E();

    private final native String F(List list);

    private final native com.transsion.startup.a G();

    /* JADX INFO: Access modifiers changed from: private */
    public final native yt.a H();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void I();

    private final native void J();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void K();

    private final native void L();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit M(StartupManager startupManager, boolean z10, com.google.firebase.remoteconfig.a aVar);

    private final native void N();

    private final native void O();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void P();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void Q(boolean z10);

    private final native void R();

    private final native void S();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void T();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void U();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void W();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void X();

    private final native void Y();

    private final native void Z(Application application, boolean z10, hj.j jVar, String str, boolean z11);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void a0();

    private final native void b0();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native StartupManager e();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native yt.a e0();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void f0();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void g0();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void h0();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void i0();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void l0(com.google.firebase.remoteconfig.a aVar);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void m0();

    private final native void n0(OkHttpClient okHttpClient);

    /* JADX INFO: Access modifiers changed from: private */
    public final native Object o0(Continuation continuation);

    public final native void A(Context context);

    public final native void V(Application application);

    public final native void c0(Application application);

    public final native boolean d0();

    public final native void j0(int i11, boolean z10);

    public final native void k0(Function0 function0);

    @Override // nh.n
    public native void onConnected();

    @Override // nh.n
    public native void onConnected(Network network, NetworkCapabilities networkCapabilities);

    @Override // nh.n
    public native void onDisconnected();

    @Override // dz.a
    public native void onLogin(UserInfo userInfo);

    @Override // dz.a
    public native void onLogout();

    @Override // dz.a
    public native void onUpdateUserInfo(UserInfo userInfo);

    public final native void p0(List list, Function1 function1);

    public final native void z(Function0 function0);
}
