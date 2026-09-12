package a7;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import bi.k;
import com.cloud.hisavana.net.CommonOkHttpClient;
import com.cloud.hisavana.sdk.Z;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.util.i0;
import com.cloud.hisavana.sdk.common.util.k0;
import com.cloud.hisavana.sdk.d0;
import com.cloud.hisavana.sdk.database.HisavanaContentProvider;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.k1;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.hisavana.sdk.s0;
import com.cloud.hisavana.sdk.v1;
import com.cloud.hisavana.sdk.y;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.sdk.commonutil.util.m;
import com.cloud.sdk.commonutil.util.o;
import com.cloud.tmc.miniapp.ad.AdManager;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f439a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f440b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f441c = true;

    /* renamed from: d, reason: collision with root package name */
    private static AtomicLong f442d = new AtomicLong(0);

    /* renamed from: e, reason: collision with root package name */
    private static int f443e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static int f444f = 10;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f445g = true;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f446h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f447i = true;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f448a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f449b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f450c;

        /* renamed from: d, reason: collision with root package name */
        private int f451d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f452e;

        public a(b bVar) {
            this.f450c = false;
            this.f452e = false;
            this.f448a = bVar.f453a;
            this.f449b = bVar.f454b;
            this.f450c = bVar.f455c;
            this.f451d = bVar.f456d;
            this.f452e = bVar.f457e;
            HSScopeHelper.f23250b = bVar.f458f;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        private boolean f455c;

        /* renamed from: a, reason: collision with root package name */
        private boolean f453a = false;

        /* renamed from: b, reason: collision with root package name */
        private boolean f454b = false;

        /* renamed from: d, reason: collision with root package name */
        private int f456d = 200;

        /* renamed from: e, reason: collision with root package name */
        private boolean f457e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f458f = false;

        public a c() {
            return new a(this);
        }

        public b h(String str) {
            c.f440b = str;
            return this;
        }

        public b i(boolean z10) {
            this.f453a = z10;
            this.f454b = z10;
            e.j(z10);
            e4.b().setLogSwitch(this.f453a);
            com.cloud.sdk.commonutil.util.c.NET_LOG.m().q(this.f453a);
            return this;
        }

        public b j(int i11) {
            this.f456d = i11;
            return this;
        }

        public b k(boolean z10) {
            boolean unused = c.f447i = z10;
            return this;
        }

        public b l(boolean z10) {
            boolean unused = c.f446h = z10;
            return this;
        }

        public b m(long j11) {
            c.f442d.set(j11);
            return this;
        }

        public b n(boolean z10) {
            boolean unused = c.f445g = z10;
            return this;
        }

        public b o(boolean z10) {
            this.f457e = z10;
            return this;
        }

        public b p(boolean z10) {
            this.f455c = z10;
            return this;
        }
    }

    private static void d(a aVar) {
        if (f439a != null || aVar == null) {
            return;
        }
        if (!aVar.f448a) {
            com.cloud.sdk.commonutil.util.c.NET_LOG.m().q(Log.isLoggable("AD_NET_LOG", 3));
        }
        k0.b(aVar.f449b);
        if (!aVar.f448a) {
            aVar.f448a = Log.isLoggable("TA_SDK", 3) || Log.isLoggable("ADSDK", 3);
        }
        f439a = aVar;
        d0.f22409a.c(f439a.f451d);
        DeviceUtil.e();
        AthenaTracker.o(f439a.f448a, e.a());
        NetStateManager.registerMonitorBroadcast();
        e4.b().setLogSwitch(f439a.f448a);
        AthenaTracker.R();
        f();
        l7.c.e();
        HSScopeHelper hSScopeHelper = HSScopeHelper.f23249a;
        hSScopeHelper.i(new Runnable() { // from class: a7.a
            @Override // java.lang.Runnable
            public final void run() {
                c.h();
            }
        });
        hSScopeHelper.g(new Runnable() { // from class: a7.b
            @Override // java.lang.Runnable
            public final void run() {
                c.m();
            }
        });
        s0.b(e.a());
        Z.f21623a.k(f442d.get());
        y.f23172a.O();
        v1.f23105a.d();
    }

    private static void f() {
        try {
            if (e.a().getApplicationContext() instanceof Application) {
                k.c((Application) e.a().getApplicationContext(), false);
                CommonOkHttpClient.f21400a = p();
            }
        } catch (Exception unused) {
            e4.b().e("init NetworkMonitor failure!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h() {
        k1.o().n(1);
        o.n();
        i7.a.s0();
    }

    public static boolean j() {
        return f445g;
    }

    public static boolean k() {
        return f447i;
    }

    public static boolean l() {
        return f446h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m() {
        i0.e(e.a());
    }

    public static int n() {
        return f443e;
    }

    public static void o(Context context, a aVar) {
        if (TextUtils.isEmpty(f440b)) {
            e4.b().e(AdManager.TAG, "AppId is empty, please check your config.");
            return;
        }
        m.j((Application) context.getApplicationContext());
        e.g(context);
        HisavanaContentProvider.h();
        d(aVar);
    }

    public static boolean p() {
        a aVar = f439a;
        if (aVar != null) {
            return aVar.f448a;
        }
        return false;
    }

    public static boolean q() {
        a aVar = f439a;
        if (aVar != null) {
            return aVar.f450c;
        }
        return false;
    }

    public static boolean r() {
        return f441c;
    }

    public static void s(Context context, String str, boolean z10) {
        f440b = str;
        e.g(context);
        HisavanaContentProvider.h();
        DeviceUtil.e();
        AthenaTracker.o(z10, e.a());
        NetStateManager.registerMonitorBroadcast();
        l7.c.e();
    }

    public static void t(int i11) {
        if (i11 < 1 || i11 > 100) {
            return;
        }
        f444f = i11;
    }

    public static void u(boolean z10) {
        f441c = z10;
    }

    public static boolean v() {
        a aVar = f439a;
        if (aVar != null) {
            return aVar.f452e;
        }
        return false;
    }
}
