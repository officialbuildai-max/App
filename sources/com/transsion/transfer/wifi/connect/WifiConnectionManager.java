package com.transsion.transfer.wifi.connect;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.R$string;
import com.transsion.transfer.wifi.connect.adapter.AddNetWorkConnectAdapter;
import com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter;
import com.transsion.transfer.wifi.connect.adapter.DirectConnectAdapter;
import com.transsion.transfer.wifi.connect.adapter.WifiNetworkSpecifierAdapter;
import com.transsion.transfer.wifi.connect.b;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.f;
import com.transsion.transfer.wifi.util.g;
import java.net.InetAddress;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import kv.c;

/* loaded from: classes6.dex */
public final class WifiConnectionManager implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final WifiConnectionManager f55955a = new WifiConnectionManager();

    /* renamed from: b, reason: collision with root package name */
    private static AppCompatActivity f55956b;

    /* renamed from: c, reason: collision with root package name */
    private static n0 f55957c;

    /* renamed from: d, reason: collision with root package name */
    private static lv.a f55958d;

    /* renamed from: e, reason: collision with root package name */
    private static b f55959e;

    /* renamed from: f, reason: collision with root package name */
    private static DirectConnectAdapter f55960f;

    /* renamed from: g, reason: collision with root package name */
    private static WifiNetworkSpecifierAdapter f55961g;

    /* renamed from: h, reason: collision with root package name */
    private static AddNetWorkConnectAdapter f55962h;

    /* renamed from: i, reason: collision with root package name */
    private static long f55963i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f55964j;

    private WifiConnectionManager() {
    }

    private final void m() {
        g.b(g.f56093a, o() + " --> connect() --> SDK_INT或targetSdkVersion版本 < (Q = 29) Android 10", false, 2, null);
        if (f55962h == null) {
            f55962h = new AddNetWorkConnectAdapter();
        }
        AddNetWorkConnectAdapter addNetWorkConnectAdapter = f55962h;
        if (addNetWorkConnectAdapter != null) {
            BaseWifiConnectAdapter.b(addNetWorkConnectAdapter, null, f55958d, f55957c, this, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o() {
        String simpleName = WifiConnectionManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p(Continuation continuation) {
        return i.g(y0.b(), new WifiConnectionManager$getCorrectAddNetAddress$2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        if (com.transsion.transfer.wifi.util.WifiUtils.f56083a.q() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            r6 = this;
            com.transsion.transfer.wifi.util.g r0 = com.transsion.transfer.wifi.util.g.f56093a
            java.lang.String r1 = r6.o()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " --> innerConnect() --> 建立 Wi-Fi 连接 --> start ...."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 0
            r3 = 2
            r4 = 0
            com.transsion.transfer.wifi.util.g.b(r0, r1, r2, r3, r4)
            lv.a r1 = com.transsion.transfer.wifi.connect.WifiConnectionManager.f55958d
            if (r1 == 0) goto L39
            java.lang.String r1 = r1.p()
            if (r1 == 0) goto L39
            java.lang.String r5 = "DIRECT-"
            boolean r1 = kotlin.text.StringsKt.W(r1, r5, r2, r3, r4)
            r5 = 1
            if (r1 != r5) goto L39
            com.transsion.transfer.wifi.util.WifiUtils r1 = com.transsion.transfer.wifi.util.WifiUtils.f56083a
            boolean r1 = r1.q()
            if (r1 == 0) goto L39
            goto L3a
        L39:
            r5 = r2
        L3a:
            lv.a r1 = com.transsion.transfer.wifi.connect.WifiConnectionManager.f55958d
            if (r1 == 0) goto L43
            java.lang.String r1 = r1.p()
            goto L44
        L43:
            r1 = r4
        L44:
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L6b
            com.transsion.transfer.wifi.util.WifiUtils r0 = com.transsion.transfer.wifi.util.WifiUtils.f56083a
            android.app.Application r1 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r2 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
            boolean r0 = r0.r(r1)
            if (r5 == 0) goto L61
            if (r0 != 0) goto L61
            r6.r()
            goto L88
        L61:
            if (r0 != 0) goto L67
            r6.w()
            goto L88
        L67:
            r6.m()
            goto L88
        L6b:
            java.lang.String r1 = r6.o()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r1 = " --> innerConnect() --> wifiInfoModel.wifiSsid is empty --> return"
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            com.transsion.transfer.wifi.util.g.d(r0, r1, r2, r3, r4)
            r0 = 2000(0x7d0, float:2.803E-42)
            r6.b(r0)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.connect.WifiConnectionManager.q():void");
    }

    private final void r() {
        g.b(g.f56093a, o() + " --> connect() --> 支持(Wi-Fi P2P) 且SDK_INT或targetSdkVersion版本 >= (Q = 29) -- Android 10", false, 2, null);
        Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).bindProcessToNetwork(null);
        if (f55960f == null) {
            f55960f = new DirectConnectAdapter();
        }
        DirectConnectAdapter directConnectAdapter = f55960f;
        if (directConnectAdapter != null) {
            BaseWifiConnectAdapter.b(directConnectAdapter, null, f55958d, f55957c, this, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        f.f56090a.c();
        WifiUtils.f56083a.x();
        DirectConnectAdapter directConnectAdapter = f55960f;
        if (directConnectAdapter != null) {
            directConnectAdapter.k();
        }
        f55960f = null;
        AddNetWorkConnectAdapter addNetWorkConnectAdapter = f55962h;
        if (addNetWorkConnectAdapter != null) {
            addNetWorkConnectAdapter.k();
        }
        f55962h = null;
        WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter = f55961g;
        if (wifiNetworkSpecifierAdapter != null) {
            wifiNetworkSpecifierAdapter.k();
        }
        f55961g = null;
    }

    private final void u(int i11) {
        g.b(g.f56093a, o() + " --> resolveIP(netId: Int) --> 成功建立连接 --> 开始解析IP地址 -- netId = " + i11, false, 2, null);
        n0 n0Var = f55957c;
        if (n0Var != null) {
            k.d(n0Var, y0.c(), null, new WifiConnectionManager$resolveIP$2(null), 2, null);
        }
    }

    private final void v(InetAddress inetAddress) {
        String str;
        g gVar = g.f56093a;
        g.b(gVar, o() + " --> resolveIP(address: InetAddress?) --> 成功建立连接 --> 开始解析IP地址", false, 2, null);
        if (TextUtils.isEmpty(inetAddress != null ? inetAddress.getHostAddress() : null)) {
            n0 n0Var = f55957c;
            if (n0Var != null) {
                k.d(n0Var, y0.c(), null, new WifiConnectionManager$resolveIP$1(null), 2, null);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f55963i;
        g.b(gVar, o() + " --> resolveIP(address: InetAddress?) --> 非系统级应用P2P连接成功耗时 = " + currentTimeMillis + " -- ip = " + (inetAddress != null ? inetAddress.getHostAddress() : null), false, 2, null);
        if (inetAddress == null || (str = inetAddress.getHostAddress()) == null) {
            str = "";
        }
        e(str);
    }

    private final void w() {
        if (Build.VERSION.SDK_INT >= 29) {
            g.b(g.f56093a, o() + " --> connect() --> 不支持(Wi-Fi P2P) 且SDK_INT或targetSdkVersion版本 >= (Q = 29) -- Android 10", false, 2, null);
            if (f55961g == null) {
                f55961g = new WifiNetworkSpecifierAdapter();
            }
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter = f55961g;
            if (wifiNetworkSpecifierAdapter != null) {
                wifiNetworkSpecifierAdapter.a(f55956b, f55958d, f55957c, this);
            }
        }
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void a(Network network) {
        b.a.b(this, network);
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void b(int i11) {
        g.d(g.f56093a, o() + " --> onFail() --> code = " + i11, false, 2, null);
        if (i11 == 2001 || i11 == 2012) {
            c.f68519a.d();
        } else {
            c.f68519a.e(i11);
        }
        n0 n0Var = f55957c;
        if (n0Var != null) {
            k.d(n0Var, null, null, new WifiConnectionManager$onFail$1(i11, null), 3, null);
        }
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void c(InetAddress inetAddress) {
        v(inetAddress);
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void d(int i11) {
        u(i11);
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void e(String ip2) {
        Intrinsics.h(ip2, "ip");
        b.a.c(this, ip2);
        c.f68519a.f(System.currentTimeMillis() - f55963i);
        f55964j = false;
        b bVar = f55959e;
        if (bVar != null) {
            bVar.e(ip2);
        }
    }

    public final void n(AppCompatActivity appCompatActivity, lv.a aVar, n0 n0Var, b bVar) {
        if (f55964j) {
            ToastUtils.s(Utils.a().getResources().getString(R$string.transfer_wifi_connect_error_tip), new Object[0]);
            g.b(g.f56093a, o() + " --> connectWifi() --> 已经有一个任务在连接了，请稍后", false, 2, null);
            return;
        }
        f55964j = true;
        f55963i = System.currentTimeMillis();
        f55957c = n0Var;
        f55958d = aVar;
        f55956b = appCompatActivity;
        f55959e = bVar;
        onStart();
        n0 n0Var2 = f55957c;
        if (n0Var2 != null) {
            k.d(n0Var2, null, null, new WifiConnectionManager$connect$1(null), 3, null);
        }
    }

    @Override // com.transsion.transfer.wifi.connect.b
    public void onStart() {
        c.f68519a.g();
        b bVar = f55959e;
        if (bVar != null) {
            bVar.onStart();
        }
    }

    public final void s() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            g gVar = g.f56093a;
            WifiConnectionManager wifiConnectionManager = f55955a;
            g.h(gVar, wifiConnectionManager.o() + " --> release() --> 接收端开始释放资源", false, 2, null);
            f55959e = null;
            f55957c = null;
            f55964j = false;
            f55963i = 0L;
            wifiConnectionManager.t();
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f56093a, f55955a.o() + " --> release() --> it = " + m1188exceptionOrNullimpl, false, 2, null);
    }
}
