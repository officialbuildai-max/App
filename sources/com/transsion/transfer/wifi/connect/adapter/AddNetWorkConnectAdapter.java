package com.transsion.transfer.wifi.connect.adapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.R$string;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public final class AddNetWorkConnectAdapter extends BaseWifiConnectAdapter {

    /* renamed from: f, reason: collision with root package name */
    private boolean f55967f;

    /* renamed from: g, reason: collision with root package name */
    private int f55968g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f55969h;

    /* renamed from: i, reason: collision with root package name */
    private Network f55970i;

    /* renamed from: m, reason: collision with root package name */
    private List f55974m;

    /* renamed from: e, reason: collision with root package name */
    private int f55966e = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f55971j = 10;

    /* renamed from: k, reason: collision with root package name */
    private int f55972k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f55973l = -1;

    /* renamed from: n, reason: collision with root package name */
    private long f55975n = 1000;

    /* renamed from: o, reason: collision with root package name */
    private final Object f55976o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private int f55977p = 5;

    /* renamed from: q, reason: collision with root package name */
    private int f55978q = 15;

    private final int m(int i11, String str, String str2) {
        g.b(g.f56093a, e() + " --> blindConnect() --> Connect Step 4 No Need Scan Result,Force Connect ", false, 2, null);
        if (i11 != -1) {
            return i11;
        }
        String string = Utils.a().getApplicationContext().getString(R$string.wifi_direct_prefix);
        Intrinsics.g(string, "getString(...)");
        if (StringsKt.W(str, string, false, 2, null)) {
            int v11 = v(str, str2, "PSK");
            if (v11 == -1) {
                v11 = v(str, str2, "EAP");
            }
            return v11 == -1 ? v(str, str2, "WEP") : v11;
        }
        if (TextUtils.isEmpty(str2)) {
            return v(str, str2, "OPEN");
        }
        int v12 = v(str, str2, "PSK");
        if (v12 == -1) {
            v12 = v(str, str2, "EAP");
        }
        return v12 == -1 ? v(str, str2, "WEP") : v12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:12:0x0045, B:14:0x005d, B:15:0x0066, B:16:0x007d, B:18:0x008a, B:20:0x0091, B:24:0x00d4, B:26:0x00da, B:28:0x00e0, B:33:0x00ca, B:35:0x00e3, B:23:0x0095), top: B:11:0x0045, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.connect.adapter.AddNetWorkConnectAdapter.n(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int o(String str, String str2, String str3) {
        int i11 = -1;
        try {
            synchronized (this.f55976o) {
                try {
                    WifiUtils wifiUtils = WifiUtils.f56083a;
                    if (wifiUtils.j().equals(str)) {
                        g.b(g.f56093a, "Current MB SSID had Connected. current SSID = " + wifiUtils.j(), false, 2, null);
                        return 0;
                    }
                    this.f55973l = this.f55972k;
                    WifiConfiguration wifiConfiguration = new WifiConfiguration();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
                    String format = String.format("\"%s\"", Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.g(format, "format(...)");
                    wifiConfiguration.SSID = format;
                    wifiConfiguration.priority = 1000000;
                    com.transsion.transfer.wifi.util.a.f56085a.f(wifiConfiguration, str3, str2);
                    int i12 = 0;
                    int i13 = -1;
                    while (i12 < this.f55977p && !this.f55969h && (i13 = WifiUtils.f56083a.m().addNetwork(wifiConfiguration)) == -1) {
                        try {
                            i12++;
                            try {
                                Thread.sleep(350L);
                            } catch (InterruptedException e11) {
                                g.d(g.f56093a, e() + " --> connectToWifi() --> addNetwork Interrupt = " + e11, false, 2, null);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    g gVar = g.f56093a;
                    g.h(gVar, e() + " --> connectToWifi() --> new network id:" + i13, false, 2, null);
                    try {
                        if (i13 == -1) {
                            g.h(gVar, e() + " --> connectToWifi() --> add ssid to network failure!", false, 2, null);
                            return i13;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            com.transsion.transfer.wifi.util.a.f56085a.g(WifiUtils.f56083a.m(), wifiConfiguration);
                        }
                        WifiUtils wifiUtils2 = WifiUtils.f56083a;
                        if (wifiUtils2.m() != null) {
                            wifiUtils2.m().disconnect();
                        }
                        this.f55972k = i13;
                        int i14 = this.f55973l;
                        if (i14 != -1 && i14 != i13) {
                            wifiUtils2.m().disableNetwork(this.f55973l);
                        }
                        if (!(wifiUtils2.m() != null ? wifiUtils2.m().enableNetwork(i13, true) : false)) {
                            wifiUtils2.m().reassociate();
                        }
                        x();
                        Unit unit = Unit.f67184a;
                        return i13;
                    } catch (Exception e12) {
                        e = e12;
                        i11 = i13;
                        e.printStackTrace();
                        return i11;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Exception e13) {
            e = e13;
        }
    }

    private final Method p(int i11) {
        Class<?>[] parameterTypes;
        WifiUtils wifiUtils = WifiUtils.f56083a;
        if (wifiUtils.m() == null) {
            return null;
        }
        Iterator a11 = ArrayIteratorKt.a(wifiUtils.m().getClass().getDeclaredMethods());
        Method method = null;
        while (a11.hasNext()) {
            Method method2 = (Method) a11.next();
            if (StringsKt.H("connect", method2.getName(), true) && (parameterTypes = method2.getParameterTypes()) != null && parameterTypes.length > 0 && StringsKt.H("int", parameterTypes[0].getName(), true)) {
                method = method2;
            }
        }
        if (method != null) {
            try {
                method.invoke(WifiUtils.f56083a.m(), Integer.valueOf(i11), null);
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }
        return method;
    }

    private final void q() {
        String str;
        boolean z10;
        String o11;
        int i11 = this.f55966e;
        lv.a i12 = i();
        String str2 = "";
        if (i12 == null || (str = i12.p()) == null) {
            str = "";
        }
        lv.a i13 = i();
        if (i13 != null && (o11 = i13.o()) != null) {
            str2 = o11;
        }
        this.f55966e = m(i11, str, str2);
        g gVar = g.f56093a;
        g.b(gVar, e() + " --> doBlindConnect() --> Connect Step 5 No Need Scan Result,Force Connect Result=" + this.f55966e, false, 2, null);
        if (this.f55966e != -1) {
            String j11 = WifiUtils.f56083a.j();
            lv.a i14 = i();
            if (Intrinsics.c(j11, i14 != null ? i14.p() : null)) {
                String e11 = e();
                lv.a i15 = i();
                String p11 = i15 != null ? i15.p() : null;
                g.b(gVar, e11 + " --> doBlindConnect() --> Connect Step 6.0 connected wifi = " + p11 + " -- netId = " + this.f55966e + "  --  isOkRetryConnect:", false, 2, null);
            } else {
                try {
                    Thread.sleep(350L);
                    String e12 = e();
                    lv.a i16 = i();
                    String p12 = i16 != null ? i16.p() : null;
                    g.b(gVar, e12 + " --> doBlindConnect() --> Connect Step 6.1 didn't connect wifi，reEnableNetWork ssid: " + p12 + " -- netId = " + this.f55966e + " ", false, 2, null);
                    w(this.f55966e);
                } catch (InterruptedException e13) {
                    e13.printStackTrace();
                    return;
                }
            }
        } else {
            this.f55974m = null;
        }
        NetworkInfo.DetailedState r11 = r();
        boolean z11 = r11 == null || r11 == NetworkInfo.DetailedState.CONNECTING || r11 == NetworkInfo.DetailedState.AUTHENTICATING;
        for (int i17 = 0; z11 && i17 < this.f55978q && !this.f55969h; i17++) {
            try {
                Thread.sleep(350L);
                NetworkInfo.DetailedState r12 = r();
                if (r12 != null) {
                    z11 = r12 == NetworkInfo.DetailedState.CONNECTING || r12 == NetworkInfo.DetailedState.AUTHENTICATING;
                }
            } catch (InterruptedException e14) {
                e14.printStackTrace();
            }
        }
        WifiUtils wifiUtils = WifiUtils.f56083a;
        String j12 = wifiUtils.j();
        if (TextUtils.isEmpty(j12)) {
            z10 = false;
        } else {
            lv.a i18 = i();
            z10 = Intrinsics.c(j12, i18 != null ? i18.p() : null);
        }
        if (z10) {
            if (this.f55966e != -1) {
                g.b(g.f56093a, e() + " --> doBlindConnect() --> Connect Step 9 addNetSucceed", false, 2, null);
                com.transsion.transfer.wifi.connect.b h11 = h();
                if (h11 != null) {
                    h11.d(this.f55966e);
                    return;
                }
                return;
            }
            g.b(g.f56093a, e() + " --> doBlindConnect() --> Connect Step 9 SHOW_RETRY", false, 2, null);
            com.transsion.transfer.wifi.connect.b h12 = h();
            if (h12 != null) {
                h12.b(2033);
                return;
            }
            return;
        }
        g gVar2 = g.f56093a;
        g.b(gVar2, e() + " --> doBlindConnect() --> Connect Step 9.1 blindConnectCounts：" + this.f55968g, false, 2, null);
        if (this.f55968g >= this.f55977p) {
            g.d(gVar2, e() + " --> doBlindConnect() --> Connect Step 9.1 SHOW_RETRY", false, 2, null);
            com.transsion.transfer.wifi.connect.b h13 = h();
            if (h13 != null) {
                h13.b(2033);
                return;
            }
            return;
        }
        wifiUtils.m().startScan();
        try {
            Thread.sleep(this.f55975n);
        } catch (InterruptedException e15) {
            g.b(g.f56093a, e() + " --> doBlindConnect() --> blindConnectCounts InterruptedException: " + e15, false, 2, null);
        }
        this.f55966e = -1;
        this.f55967f = false;
        this.f55968g++;
        t();
    }

    private final void s() {
        com.transsion.transfer.wifi.util.c cVar = com.transsion.transfer.wifi.util.c.f56087a;
        if (cVar.e()) {
            Context applicationContext = Utils.a().getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            if (cVar.d(applicationContext) < 2097152) {
                g.b(g.f56093a, e() + " --> initParameter() --> Transsion Phone lowMemLimit", false, 2, null);
                this.f55975n = 1500L;
                this.f55978q = 30;
                this.f55971j = 20;
                this.f55977p = 8;
            }
        }
    }

    private final void t() {
        Object m1185constructorimpl;
        g gVar = g.f56093a;
        String e11 = e();
        lv.a i11 = i();
        g.b(gVar, e11 + " --> processWifiConnect() --> Connect Step 2 CONNECTION_INITIALIZED --> ssid = " + (i11 != null ? i11.p() : null) + " --> startScan()", false, 2, null);
        WifiUtils wifiUtils = WifiUtils.f56083a;
        wifiUtils.m().startScan();
        int networkId = wifiUtils.m().getConnectionInfo().getNetworkId();
        List<WifiConfiguration> configuredNetworks = wifiUtils.m().getConfiguredNetworks();
        Intrinsics.g(configuredNetworks, "getConfiguredNetworks(...)");
        g.b(gVar, e() + " --> processWifiConnect() --> Connect Step 2.1  --> currentConnectId = " + networkId + " --> existingConfigs.size = " + configuredNetworks.size(), false, 2, null);
        Iterator<WifiConfiguration> it = configuredNetworks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WifiConfiguration next = it.next();
            String SSID = next.SSID;
            Intrinsics.g(SSID, "SSID");
            String Q = StringsKt.Q(SSID, "\"", "", false, 4, null);
            String str = next.preSharedKey;
            if (!TextUtils.isEmpty(Q)) {
                lv.a i12 = i();
                if (StringsKt.I(i12 != null ? i12.p() : null, Q, false, 2, null)) {
                    this.f55966e = next.networkId;
                    g gVar2 = g.f56093a;
                    g.b(gVar2, e() + " --> processWifiConnect() --> Connect Step 2.2  currentConnectId = " + networkId + " -- netId = " + this.f55966e + " -- pwd = " + str, false, 2, null);
                    String string = Utils.a().getApplicationContext().getString(R$string.wifi_direct_prefix);
                    Intrinsics.g(string, "getString(...)");
                    if (StringsKt.W(Q, string, false, 2, null) && TextUtils.isEmpty(str)) {
                        g.b(gVar2, e() + " --> processWifiConnect() --> Connect Step 2.3  error pwd type save WifiConfiguration SSID = " + Q + ", netId = " + this.f55966e, false, 2, null);
                        this.f55966e = -1;
                        this.f55967f = false;
                    } else {
                        g.b(gVar2, e() + " --> processWifiConnect() --> Connect Step 2.4  reEnableNetWork WifiConfiguration SSID = " + Q + ", netId = " + this.f55966e, false, 2, null);
                        this.f55973l = networkId;
                        WifiUtils.f56083a.m().disconnect();
                        w(this.f55966e);
                        this.f55967f = true;
                    }
                }
            }
        }
        g.b(g.f56093a, e() + " --> processWifiConnect() --> Connect Step 2.4-1  列表遍历结束 --> netId = " + this.f55966e + " -- findOldConfig = " + this.f55967f, false, 2, null);
        if (!this.f55967f) {
            int i13 = this.f55971j;
            for (int i14 = 0; i14 < i13; i14++) {
                List<ScanResult> scanResults = WifiUtils.f56083a.m().getScanResults();
                this.f55974m = scanResults;
                if (scanResults != null) {
                    g gVar3 = g.f56093a;
                    String e12 = e();
                    List list = this.f55974m;
                    g.b(gVar3, e12 + " --> processWifiConnect() --> Connect Step 2.5  Start WifiScan Retry counts:+ i +, ScanResultList Size: " + (list != null ? Integer.valueOf(list.size()) : null), false, 2, null);
                    for (ScanResult scanResult : scanResults) {
                        lv.a i15 = i();
                        if (StringsKt.I(i15 != null ? i15.p() : null, scanResult.SSID, false, 2, null)) {
                            g gVar4 = g.f56093a;
                            g.b(gVar4, e() + " --> processWifiConnect() --> Connect Step 3 Find XShare HotSpot , Start Connect to Target WIFI , SSID = " + scanResult.SSID + " +  capabilities =  " + scanResult.capabilities, false, 2, null);
                            lv.a i16 = i();
                            String p11 = i16 != null ? i16.p() : null;
                            lv.a i17 = i();
                            this.f55966e = o(p11, i17 != null ? i17.o() : null, scanResult.capabilities);
                            g.d(gVar4, e() + " --> processWifiConnect() --> Connect Step 3.1 Connect to Target WIFI Finished -- netId = " + this.f55966e, false, 2, null);
                            if (this.f55966e != -1) {
                                break;
                            }
                        }
                    }
                }
                if (this.f55966e != -1) {
                    break;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Thread.sleep(this.f55975n);
                    if (i14 % 3 == 0) {
                        WifiUtils.f56083a.m().startScan();
                    }
                    m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
                if (m1188exceptionOrNullimpl != null) {
                    g.d(g.f56093a, e() + " --> processWifiConnect() --> CONFIGURED_WIFI InterruptedException --> it = " + m1188exceptionOrNullimpl, false, 2, null);
                    com.transsion.transfer.wifi.connect.b h11 = h();
                    if (h11 != null) {
                        h11.b(2031);
                        return;
                    }
                    return;
                }
            }
        }
        u();
    }

    private final void u() {
        boolean z10;
        g.b(g.f56093a, e() + " --> processWifiScanResult() --> Connect Step 4 processWifiScanResult findOldConfig = " + this.f55967f, false, 2, null);
        if (!this.f55967f) {
            q();
            return;
        }
        NetworkInfo.DetailedState r11 = r();
        boolean z11 = r11 == null || r11 == NetworkInfo.DetailedState.CONNECTING || r11 == NetworkInfo.DetailedState.AUTHENTICATING;
        for (int i11 = 0; z11 && i11 < this.f55978q && !this.f55969h; i11++) {
            try {
                Thread.sleep(350L);
                NetworkInfo.DetailedState r12 = r();
                if (r12 != null) {
                    z11 = r12 == NetworkInfo.DetailedState.CONNECTING || r12 == NetworkInfo.DetailedState.AUTHENTICATING;
                }
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }
        WifiUtils wifiUtils = WifiUtils.f56083a;
        String j11 = wifiUtils.j();
        if (TextUtils.isEmpty(j11)) {
            z10 = false;
        } else {
            lv.a i12 = i();
            z10 = Intrinsics.c(j11, i12 != null ? i12.p() : null);
        }
        if (z10) {
            if (this.f55966e != -1) {
                g.b(g.f56093a, e() + " --> processWifiScanResult() --> Connect Step 7 addNetSucceed", false, 2, null);
                com.transsion.transfer.wifi.connect.b h11 = h();
                if (h11 != null) {
                    h11.d(this.f55966e);
                    return;
                }
                return;
            }
            g.b(g.f56093a, e() + " --> processWifiScanResult() --> Connect Step 7 SHOW_RETRY", false, 2, null);
            com.transsion.transfer.wifi.connect.b h12 = h();
            if (h12 != null) {
                h12.b(2032);
                return;
            }
            return;
        }
        g gVar = g.f56093a;
        g.b(gVar, e() + " --> processWifiScanResult() --> Connect Step 7.1 blindConnectCounts = " + this.f55968g, false, 2, null);
        if (this.f55968g >= this.f55977p) {
            g.d(gVar, e() + " --> processWifiScanResult() --> Connect Step 7.1 SHOW_RETRY", false, 2, null);
            com.transsion.transfer.wifi.connect.b h13 = h();
            if (h13 != null) {
                h13.b(2032);
                return;
            }
            return;
        }
        wifiUtils.m().startScan();
        try {
            Thread.sleep(this.f55975n);
        } catch (InterruptedException e12) {
            g.d(g.f56093a, e() + " --> processWifiScanResult() --> blindConnectCounts InterruptedException: " + e12, false, 2, null);
        }
        this.f55966e = -1;
        this.f55967f = false;
        this.f55968g++;
        q();
    }

    private final int v(String str, String str2, String str3) {
        try {
            g.b(g.f56093a, e() + " --> reConnect() --> ssid:" + str + ", pass:" + str2 + ", type:" + str3, false, 2, null);
            Thread.sleep(300L);
            return o(str, str2, str3);
        } catch (InterruptedException e11) {
            g.d(g.f56093a, e() + " --> reConnect() --> reConnect InterruptedException: " + e11, false, 2, null);
            return -1;
        }
    }

    private final void w(int i11) {
        try {
            this.f55972k = i11;
            j("reEnableNetWork() --> set network id = " + i11);
            int i12 = this.f55973l;
            if (i12 != -1 && i12 != this.f55972k) {
                WifiUtils.f56083a.m().disableNetwork(this.f55973l);
            }
            if (!(Build.VERSION.SDK_INT <= 23 ? p(i11) == null ? WifiUtils.f56083a.m().enableNetwork(i11, true) : false : WifiUtils.f56083a.m().enableNetwork(i11, true))) {
                WifiUtils.f56083a.m().reassociate();
            }
            x();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private final void x() {
        synchronized (this.f55976o) {
            j("removeOldNetwork() --> removeOldNetwork mLastNetworkId = " + this.f55973l + " --> mCurrentNetworkId = " + this.f55972k);
            int i11 = this.f55973l;
            if (i11 != -1 && i11 != this.f55972k) {
                j("removeOldNetwork() --> remove network id:" + i11);
                boolean z10 = false;
                for (int i12 = 0; i12 < 10 && !z10; i12++) {
                    try {
                        z10 = WifiUtils.f56083a.m().removeNetwork(this.f55973l);
                        j("removeOldNetwork() --> removeNetwork Result = " + z10);
                    } catch (Exception unused) {
                    }
                }
                WifiUtils.f56083a.m().saveConfiguration();
            }
            Unit unit = Unit.f67184a;
        }
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void c() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (this.f55970i != null) {
                this.f55970i = null;
            }
            Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ((ConnectivityManager) systemService).bindProcessToNetwork(null);
            g.b(g.f56093a, e() + " --> releaseDefaultNetwork() --> end", false, 2, null);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f56093a, e() + " --> releaseDefaultNetwork() --> it = " + m1188exceptionOrNullimpl, false, 2, null);
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void d() {
        this.f55968g = 0;
        this.f55969h = false;
        g.b(g.f56093a, e() + " --> connect() --> 系统级接入方开始添加网络 = " + i(), false, 2, null);
        n0 g11 = g();
        if (g11 != null) {
            k.d(g11, null, null, new AddNetWorkConnectAdapter$doConnect$1(this, null), 3, null);
        }
    }

    public final NetworkInfo.DetailedState r() {
        Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getDetailedState();
        }
        return null;
    }
}
