package com.transsion.ga;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.tencent.mmkv.MMKV;
import com.transsion.athena.aidl.AthenaTrackService;
import com.transsion.athena.attribution.ReferrerTask;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import com.transsion.athena.enatha.enatha;
import com.transsion.athena.taaneh.aatnhe;
import com.transsion.athena.taaneh.ehatna;
import com.transsion.core.log.ObjectLogUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class AthenaAnalytics {

    /* renamed from: h, reason: collision with root package name */
    private static volatile AthenaAnalytics f44212h;

    /* renamed from: n, reason: collision with root package name */
    private static List f44218n;

    /* renamed from: o, reason: collision with root package name */
    private static com.transsion.ga.athena f44219o;

    /* renamed from: p, reason: collision with root package name */
    public static int f44220p;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f44221q;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f44222r;

    /* renamed from: a, reason: collision with root package name */
    private com.transsion.athena.enatha.athena f44223a;

    /* renamed from: c, reason: collision with root package name */
    private com.transsion.athena.athena f44225c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f44226d;

    /* renamed from: f, reason: collision with root package name */
    private static b f44210f = new b() { // from class: com.transsion.ga.b
        @Override // com.transsion.ga.AthenaAnalytics.b
        public final String a(String str) {
            String i11;
            i11 = AthenaAnalytics.i(str);
            return i11;
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private static volatile int f44211g = 1;

    /* renamed from: i, reason: collision with root package name */
    private static long f44213i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static volatile int f44214j = -1;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f44215k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static String f44216l = null;

    /* renamed from: m, reason: collision with root package name */
    private static Context f44217m = null;

    /* renamed from: b, reason: collision with root package name */
    ExecutorService f44224b = null;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList f44227e = new CopyOnWriteArrayList();

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class aethna implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private com.transsion.athena.enatha.athena f44228a;

        private aethna(com.transsion.athena.enatha.athena athenaVar) {
            this.f44228a = athenaVar;
        }

        /* synthetic */ aethna(com.transsion.athena.enatha.athena athenaVar, athena athenaVar2) {
            this(athenaVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ehanat.v()) {
                com.transsion.athena.taaneh.anehat.a("Athena is in Test mode，should not release this APK（测试模式）[" + AthenaAnalytics.f44217m.getPackageName() + "]");
                this.f44228a.a(this, 60000L);
                return;
            }
            if (ehanat.t() && ehanat.q()) {
                com.transsion.athena.taaneh.anehat.a("  - Athena is in Release mode with log enabled. Please set AthenaAnalytics.setDebug(false) to release this APK （Debug模式）[" + AthenaAnalytics.f44217m.getPackageName() + "]");
                this.f44228a.a(this, 60000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class anehat implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f44229a;

        /* renamed from: b, reason: collision with root package name */
        private SimpleDateFormat f44230b;

        /* renamed from: c, reason: collision with root package name */
        private String f44231c;

        private anehat(Handler handler) {
            this.f44231c = "";
            this.f44229a = handler;
        }

        /* synthetic */ anehat(Handler handler, athena athenaVar) {
            this(handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AthenaAnalytics.f44215k > 0) {
                if (com.transsion.athena.config.data.model.anehat.c(AthenaAnalytics.f44217m)) {
                    if (this.f44230b == null) {
                        this.f44230b = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
                    }
                    String format = this.f44230b.format(new Date());
                    if (!format.equals(this.f44231c)) {
                        Iterator<Integer> it = com.transsion.athena.data.athena.a().iterator();
                        while (it.hasNext()) {
                            Integer next = it.next();
                            if (next.intValue() != 9999) {
                                AthenaAnalytics.K(next.intValue()).g0("app_heartbeat", null, next.intValue());
                            }
                        }
                        this.f44231c = format;
                    }
                }
                this.f44229a.postDelayed(this, 3600000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class athena implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f44232a;

        athena(boolean z10) {
            this.f44232a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.transsion.athena.taaneh.aethna.f42852a.m().r(this.f44232a);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        String a(String str);
    }

    /* loaded from: classes5.dex */
    public interface c {
    }

    private AthenaAnalytics() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(final String str, final TrackData trackData, final long j11) {
        try {
            if (this.f44225c == null || !this.f44226d) {
                if (V()) {
                    x(str, trackData, j11);
                } else if (this.f44227e.size() < 100) {
                    this.f44227e.add(new TrackDataWrapper(str, trackData, j11));
                }
            } else if (trackData.c() < 524288) {
                this.f44224b.submit(new Runnable() { // from class: com.transsion.ga.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AthenaAnalytics.this.p(str, trackData, j11);
                    }
                });
            } else {
                com.transsion.athena.taaneh.aethna.b("TrackByAidl trackData size is too large, ignored !!");
            }
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    private static boolean B() {
        return f44217m.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") == 0;
    }

    private com.transsion.athena.enatha.athena C() {
        com.transsion.athena.enatha.athena a11;
        if (this.f44223a == null && f44217m != null) {
            if (f44211g == 2 && !com.transsion.athena.taaneh.anehat.c(f44217m)) {
                f44211g = 1;
            }
            Context context = f44217m;
            int i11 = f44211g;
            if (i11 != 1) {
                if (i11 == 2) {
                    a11 = com.transsion.athena.enatha.aethna.a(context);
                } else if (i11 != 3) {
                    a11 = null;
                }
                this.f44223a = a11;
            }
            a11 = enatha.a(context);
            this.f44223a = a11;
        }
        return this.f44223a;
    }

    public static void D(boolean z10) {
        com.transsion.athena.enatha.athena C;
        ehanat.d(z10);
        if (f44212h == null) {
            com.transsion.athena.taaneh.aethna.a("Init method not called.");
        } else {
            if (f44214j != 0 || (C = f44212h.C()) == null || z10) {
                return;
            }
            C.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E() {
        if ((f44211g == 3 || F()) && f44214j == 0) {
            com.transsion.athena.hatnea.athena.a().b();
        }
    }

    private static boolean F() {
        return (f44217m == null || f44212h == null || !ehanat.r()) ? false : true;
    }

    public static String G(Context context) {
        return ehatna.a();
    }

    public static String H(Context context, boolean z10) {
        return z10 ? ehatna.b(context) : ehatna.a();
    }

    public static a I() {
        return null;
    }

    public static Context J() {
        return f44217m;
    }

    public static AthenaAnalytics K(int i11) {
        return L(i11);
    }

    public static AthenaAnalytics L(long j11) {
        if (f44212h == null) {
            synchronized (AthenaAnalytics.class) {
                try {
                    if (f44212h == null) {
                        f44212h = new AthenaAnalytics();
                        if (f44214j == 0) {
                            com.transsion.athena.enatha.athena C = f44212h.C();
                            Handler handler = new Handler(Looper.getMainLooper());
                            w(C);
                            athena athenaVar = null;
                            C.a(new aethna(C, athenaVar), 3000L);
                            z(C);
                            m(handler);
                            handler.postDelayed(new anehat(handler, athenaVar), 3600000L);
                            u(C);
                        } else {
                            AthenaAnalytics athenaAnalytics = f44212h;
                            Context context = f44217m;
                            athenaAnalytics.getClass();
                            try {
                                com.transsion.athena.taaneh.aethna.c("AthenaAnalytics bindTrackService");
                                Intent intent = new Intent(context, (Class<?>) AthenaTrackService.class);
                                intent.setPackage(context.getApplicationInfo().packageName);
                                context.bindService(intent, new g(athenaAnalytics), 1);
                            } catch (Exception e11) {
                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                            }
                        }
                    }
                } finally {
                }
            }
        }
        if (com.transsion.athena.taaneh.anehat.b(j11)) {
            int i11 = (int) j11;
            if (f44214j == 0 && com.transsion.athena.data.athena.a(i11)) {
                Message message = new Message();
                message.what = 400;
                message.arg1 = i11;
                f44212h.C().a(message, 0L);
            } else if (f44214j == 1 && com.transsion.athena.data.athena.a(i11)) {
                com.transsion.athena.taaneh.aethna.a("multi process appid " + i11 + " register successful");
            }
        }
        return f44212h;
    }

    public static b M() {
        return f44210f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N() {
        aatnhe.e(f44217m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O() {
        if (f44215k > 0) {
            AthenaAnalytics athenaAnalytics = f44212h;
            athenaAnalytics.getClass();
            if (!F()) {
                com.transsion.athena.taaneh.aethna.a("Athena SDK isAthenaEnable = false");
                return;
            }
            Iterator<Integer> it = com.transsion.athena.data.athena.a().iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (next.intValue() != 9999) {
                    athenaAnalytics.g0("app_launch", null, next.intValue());
                }
            }
        }
    }

    public static void P(Context context, String str, int i11, boolean z10) {
        Q(context, str, i11, z10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Q(Context context, String str, int i11, boolean z10, boolean z11) {
        int i12;
        String str2;
        if (context == null || i11 < 1000 || i11 > 9999) {
            throw new IllegalArgumentException("The parameter is illegal.");
        }
        if (f44217m == null) {
            f44217m = context.getApplicationContext();
        }
        ehanat.c(z10);
        ehanat.a(str, z11);
        boolean z12 = false;
        if (z11) {
            com.transsion.athena.data.athena.b(i11);
            l(i11, false);
        }
        i.b(f44217m);
        if (f44214j == -1) {
            String str3 = f44216l;
            try {
                try {
                    str2 = context.getApplicationContext().getApplicationInfo().processName;
                } catch (Exception e11) {
                    ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                    str2 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = str2;
                }
                i12 = TextUtils.equals(str3, com.transsion.athena.taaneh.athena.d(context));
            } catch (Exception unused) {
                i12 = 1;
            }
            f44214j = i12 ^ 1;
            if (f44214j == 0 && f44220p == 0 && ehanat.K) {
                f44220p = new Random().nextInt(PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY) + 300;
            }
        }
        K(9999);
        K(i11);
        ehatna.a(context, i11, f44220p);
        int i13 = com.transsion.athena.taaneh.anehat.f42857e;
        try {
            int i14 = MMKV.f40614j;
            z12 = true;
        } catch (ClassNotFoundException unused2) {
        }
        f44222r = z12;
    }

    public static boolean R() {
        return Build.VERSION.SDK_INT >= 29 ? ehanat.J && B() : ehanat.F && y();
    }

    public static boolean S() {
        return f44211g == 3;
    }

    public static boolean T() {
        return Build.VERSION.SDK_INT >= 29 ? ehanat.G && B() : ehanat.C && y();
    }

    public static boolean U() {
        return Build.VERSION.SDK_INT >= 29 ? ehanat.H && B() : ehanat.D && y();
    }

    public static boolean V() {
        return f44221q && f44222r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(19:6|(1:8)|9|(1:11)|12|(1:14)|15|(2:16|17)|(3:19|20|(2:23|21))|24|25|26|(1:28)(1:65)|29|30|31|(3:35|(4:38|(2:43|(3:48|49|50))(3:54|55|56)|51|36)|58)|60|61) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010c, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0128, code lost:
    
        com.transsion.athena.taaneh.aethna.b(r1.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a4, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a5, code lost:
    
        com.transsion.athena.taaneh.aethna.b(r5.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec A[Catch: Exception -> 0x010c, TryCatch #1 {Exception -> 0x010c, blocks: (B:31:0x00cc, B:33:0x00dc, B:35:0x00e2, B:36:0x00e6, B:38:0x00ec, B:40:0x00f8, B:55:0x00fe, B:43:0x010e, B:46:0x0114, B:49:0x011a), top: B:30:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void W() {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ga.AthenaAnalytics.W():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void X() {
        if (f44214j != 0 || f44212h == null || f44212h.C() == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 600;
        f44212h.C().a(obtain, 100L);
    }

    public static void Y(int i11) {
        if (f44217m == null) {
            throw new RuntimeException("init Athena SDK first!");
        }
        int i12 = com.transsion.athena.taaneh.anehat.f42857e;
        try {
            K(i11).C().a((Runnable) ReferrerTask.class.getConstructor(Context.class, Integer.TYPE).newInstance(f44217m, Integer.valueOf(i11)), 3000L);
        } catch (Exception e11) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    public static void Z(short s11, String str) {
        ehanat.a(s11, str);
    }

    public static void a0(int i11, String str) {
        if (i11 < 1000 || i11 > 9999) {
            com.transsion.athena.taaneh.aethna.b("appId %d is illegal", Integer.valueOf(i11));
        } else if (TextUtils.isEmpty(str)) {
            com.transsion.athena.taaneh.aethna.b("sdkVersion can not be null or empty");
        } else {
            ehanat.a(i11, str);
        }
    }

    public static void b0(boolean z10) {
        ehanat.c(z10);
        if (f44214j == 0) {
            if (f44212h == null) {
                com.transsion.athena.taaneh.aethna.a("Init method not called.");
                return;
            }
            com.transsion.athena.enatha.athena C = f44212h.C();
            if (C != null) {
                C.a(new athena(z10));
            }
        }
    }

    public static void c0(int i11) {
        com.transsion.athena.enatha.athena C;
        if (f44214j != 0 || (C = f44212h.C()) == null) {
            return;
        }
        C.a(i11);
    }

    public static void d0(boolean z10) {
        ehanat.f(z10);
    }

    public static void e0(int i11) {
        f44211g = i11;
    }

    public static void f0() {
        if (f44212h != null) {
            AthenaAnalytics athenaAnalytics = f44212h;
            athenaAnalytics.getClass();
            if ((f44211g == 3 || F()) && f44214j == 0 && athenaAnalytics.C() != null) {
                athenaAnalytics.C().e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String i(String str) {
        return str;
    }

    private static void l(long j11, boolean z10) {
        if (f44217m == null) {
            return;
        }
        if (f44215k == 0 || z10) {
            f44215k = j11;
        }
        com.transsion.ga.athena athenaVar = f44219o;
        if (athenaVar != null) {
            athenaVar.d(f44215k);
            return;
        }
        com.transsion.ga.athena athenaVar2 = new com.transsion.ga.athena();
        f44219o = athenaVar2;
        athenaVar2.d(f44215k);
        ((Application) f44217m).registerActivityLifecycleCallbacks(f44219o);
    }

    private static void m(Handler handler) {
        handler.postDelayed(new Runnable() { // from class: com.transsion.ga.c
            @Override // java.lang.Runnable
            public final void run() {
                AthenaAnalytics.O();
            }
        }, 6000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(com.transsion.athena.enatha.athena athenaVar) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            if (Build.VERSION.SDK_INT >= 33) {
                f44217m.registerReceiver(new h(), intentFilter, null, athenaVar.b(), 4);
            } else {
                f44217m.registerReceiver(new h(), intentFilter, null, athenaVar.b());
            }
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str, TrackData trackData, long j11) {
        try {
            this.f44225c.a(str, trackData, j11);
            com.transsion.athena.taaneh.aethna.a(String.format(Locale.getDefault(), "TrackByAidl tid : %d, eventName : %s", Long.valueOf(j11), str));
        } catch (RemoteException e11) {
            com.transsion.athena.taaneh.aethna.b("TrackByAidl " + e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(Class cls) {
        List list;
        return (cls == null || (list = f44218n) == null || !list.contains(Integer.valueOf(cls.hashCode()))) ? false : true;
    }

    public static void s(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        ehanat.d(str, obj);
    }

    private static void u(com.transsion.athena.enatha.athena athenaVar) {
        athenaVar.a(new Runnable() { // from class: com.transsion.ga.f
            @Override // java.lang.Runnable
            public final void run() {
                AthenaAnalytics.N();
            }
        });
    }

    private void v(String str, TrackData trackData, long j11) {
        if (f44214j == 0 || f44211g == 2) {
            C().a(str, trackData, j11);
            return;
        }
        if (f44217m != null) {
            String str2 = ehanat.f42661h;
            try {
                if (!TextUtils.isEmpty("")) {
                    trackData.a().put("scode", "");
                }
                if (this.f44224b == null) {
                    this.f44224b = Executors.newSingleThreadExecutor();
                }
                A(str, trackData, j11);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private static void w(final com.transsion.athena.enatha.athena athenaVar) {
        athenaVar.a(new Runnable() { // from class: com.transsion.ga.d
            @Override // java.lang.Runnable
            public final void run() {
                AthenaAnalytics.n(com.transsion.athena.enatha.athena.this);
            }
        });
    }

    private static void x(String str, TrackData trackData, long j11) {
        try {
            if (trackData.c() > 524288) {
                com.transsion.athena.taaneh.aethna.b("TrackData size is too large, ignored !!");
                return;
            }
            MMKV.J("AthenaKV", 2).u(Process.myPid() + "_" + j11 + "_" + str + "_" + System.currentTimeMillis(), new TrackDataWrapper(str, trackData, j11));
            com.transsion.athena.taaneh.aethna.a(String.format(Locale.getDefault(), "SaveToMMKV tid : %d, eventName : %s", Long.valueOf(j11), str));
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    private static boolean y() {
        return f44217m.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    private static void z(com.transsion.athena.enatha.athena athenaVar) {
        athenaVar.a(new Runnable() { // from class: com.transsion.ga.e
            @Override // java.lang.Runnable
            public final void run() {
                AthenaAnalytics.W();
            }
        }, 6000L);
    }

    public void g0(String str, TrackData trackData, int i11) {
        h0(str, trackData, i11);
    }

    public void h0(String str, TrackData trackData, long j11) {
        int i11 = com.transsion.athena.taaneh.anehat.f42857e;
        int length = String.valueOf(j11).length();
        if ((length != 8 && length != 12 && length != 4) || TextUtils.isEmpty(str)) {
            com.transsion.athena.taaneh.aethna.a("The parameter tid : " + j11 + " or event name : " + str + " is illegal.");
            return;
        }
        if (!com.transsion.athena.data.athena.a(j11)) {
            com.transsion.athena.taaneh.aethna.a("The tid " + j11 + " is not belong the app");
            return;
        }
        try {
            if (trackData != null) {
                v(str, trackData, j11);
            } else {
                v(str, new TrackData(), j11);
            }
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i11, long j11) {
        if (F() && f44214j == 0 && C() != null) {
            Message message = new Message();
            message.what = i11;
            C().a(message, j11);
        }
    }
}
