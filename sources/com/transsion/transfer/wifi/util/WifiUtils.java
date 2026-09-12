package com.transsion.transfer.wifi.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.R$string;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class WifiUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final WifiUtils f56083a = new WifiUtils();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f56084b = LazyKt.b(new Function0() { // from class: com.transsion.transfer.wifi.util.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            WifiManager u11;
            u11 = WifiUtils.u();
            return u11;
        }
    });

    private WifiUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        String simpleName = WifiUtils.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(String str) {
        return p(Utils.a(), str);
    }

    private final boolean p(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = new Regex("\"").replace(str, "");
        if (context == null) {
            return false;
        }
        String string = context.getString(R$string.wifi_ap_prefix);
        Intrinsics.g(string, "getString(...)");
        if (!StringsKt.W(replace, string, false, 2, null)) {
            String string2 = context.getString(R$string.wifi_direct_prefix);
            Intrinsics.g(string2, "getString(...)");
            if (!StringsKt.W(replace, string2, false, 2, null)) {
                String string3 = context.getString(R$string.wifi_ap_prefix_old);
                Intrinsics.g(string3, "getString(...)");
                if (!StringsKt.W(replace, string3, false, 2, null)) {
                    String string4 = context.getString(R$string.wifi_local_ap_prefix);
                    Intrinsics.g(string4, "getString(...)");
                    if (!StringsKt.W(replace, string4, false, 2, null)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiManager u() {
        Object systemService = Utils.a().getApplicationContext().getSystemService("wifi");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        return (WifiManager) systemService;
    }

    public final String d(String ssid) {
        Intrinsics.h(ssid, "ssid");
        if (TextUtils.isEmpty(ssid)) {
            return "";
        }
        int length = ssid.length() - 1;
        if (length < 0) {
            return ssid;
        }
        if (ssid.charAt(0) == '\"' && ssid.charAt(length) == '\"') {
            return ssid;
        }
        return "\"" + ssid + "\"";
    }

    public final WifiP2pConfig f(lv.a aVar, WifiP2pDevice wifiP2pDevice) {
        String str;
        WifiP2pConfig.Builder networkName;
        WifiP2pConfig.Builder passphrase;
        String o11;
        WpsInfo wpsInfo;
        WifiP2pConfig build = null;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                j.a();
                WifiP2pConfig.Builder a11 = com.transsion.transfer.wifi.create.adapter.d.a();
                String str2 = "";
                if (aVar != null) {
                    str = aVar.p();
                    if (str == null) {
                    }
                    networkName = a11.setNetworkName(str);
                    if (aVar != null && (o11 = aVar.o()) != null) {
                        str2 = o11;
                    }
                    passphrase = networkName.setPassphrase(str2);
                    build = passphrase.build();
                }
                str = "";
                networkName = a11.setNetworkName(str);
                if (aVar != null) {
                    str2 = o11;
                }
                passphrase = networkName.setPassphrase(str2);
                build = passphrase.build();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            WifiP2pConfig wifiP2pConfig = new WifiP2pConfig();
            wifiP2pConfig.deviceAddress = wifiP2pDevice != null ? wifiP2pDevice.deviceAddress : null;
            build = wifiP2pConfig;
        }
        if (build != null && (wpsInfo = build.wps) != null) {
            wpsInfo.setup = 0;
        }
        return build;
    }

    public final String g(InetAddress inetAddress) {
        String hostAddress;
        return (inetAddress == null || inetAddress.isLoopbackAddress() || (hostAddress = inetAddress.getHostAddress()) == null || !StringsKt.W(hostAddress, "192.168", false, 2, null)) ? "" : hostAddress;
    }

    public final Object h(Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new WifiUtils$getCorrectP2pAddress$2(null), continuation);
    }

    public final NetworkInfo.DetailedState i() {
        Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getDetailedState();
        }
        return null;
    }

    public final synchronized String j() {
        try {
            String ssid = m().getConnectionInfo().getSSID();
            if (ssid.length() < 3 || m().getConnectionInfo().getSupplicantState() == SupplicantState.DISCONNECTED) {
                return "";
            }
            Intrinsics.e(ssid);
            String substring = ssid.substring(1, ssid.length() - 1);
            Intrinsics.g(substring, "substring(...)");
            if (StringsKt.c0(substring, "unknown ssid", false, 2, null)) {
                try {
                    Object systemService = Utils.a().getSystemService("connectivity");
                    Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        Intrinsics.g(extraInfo, "getExtraInfo(...)");
                        substring = extraInfo;
                    }
                } catch (Exception unused) {
                    g.d(g.f56093a, e() + " --> getCurrentSSID() --> getCurrentSSID->Current SSID:" + substring, false, 2, null);
                }
            }
            return substring;
        } catch (Exception e11) {
            g.d(g.f56093a, e() + " --> getCurrentSSID() --> getCurrentSSID Exception = " + e11, false, 2, null);
            return "";
        }
    }

    public final long k() {
        long j11;
        try {
            DhcpInfo dhcpInfo = m().getDhcpInfo();
            Intrinsics.g(dhcpInfo, "getDhcpInfo(...)");
            j11 = dhcpInfo.gateway;
        } catch (Exception e11) {
            g.d(g.f56093a, e() + " --> getGateway() --> 获取ip异常 it = :" + e11, false, 2, null);
        }
        if (j11 != 0) {
            return j11;
        }
        return 0L;
    }

    public final String l() {
        Object obj;
        String hostAddress;
        Object obj2 = "";
        try {
            Result.Companion companion = Result.INSTANCE;
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && StringsKt.W(hostAddress, "192.168", false, 2, null)) {
                        String hostAddress2 = nextElement.getHostAddress();
                        return hostAddress2 == null ? "" : hostAddress2;
                    }
                }
            }
            obj = Result.m1185constructorimpl("");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(obj);
        if (m1188exceptionOrNullimpl == null) {
            obj2 = obj;
        } else {
            g.d(g.f56093a, "WifiUtils --> getLocalIP() --> 获取IP异常 -- it = " + m1188exceptionOrNullimpl, false, 2, null);
        }
        return (String) obj2;
    }

    public final WifiManager m() {
        return (WifiManager) f56084b.getValue();
    }

    public final boolean n() {
        return m().is5GHzBandSupported();
    }

    public final boolean q() {
        return m().isP2pSupported();
    }

    public final boolean r(Context context) {
        Intrinsics.h(context, "context");
        return Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29;
    }

    public final boolean s() {
        return Build.VERSION.SDK_INT < 29;
    }

    public final String t(long j11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((int) (j11 & 255));
        stringBuffer.append('.');
        stringBuffer.append((int) ((j11 >> 8) & 255));
        stringBuffer.append('.');
        stringBuffer.append((int) ((j11 >> 16) & 255));
        stringBuffer.append('.');
        stringBuffer.append((int) ((j11 >> 24) & 255));
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.g(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    public final void v(AppCompatActivity appCompatActivity) {
        Object m1185constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + (appCompatActivity != null ? appCompatActivity.getPackageName() : null)));
            if (appCompatActivity != null) {
                appCompatActivity.startActivity(intent);
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            m1185constructorimpl = Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f56093a, f56083a.e() + " --> openManageWriteSetting() --> it = " + m1188exceptionOrNullimpl, false, 2, null);
    }

    public final void w(AppCompatActivity appCompatActivity) {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        if (appCompatActivity != null) {
            appCompatActivity.startActivity(intent);
        }
    }

    public final void x() {
        Object m1185constructorimpl;
        NetworkInfo activeNetworkInfo;
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = Utils.a().getApplicationContext().getApplicationContext().getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                WifiUtils wifiUtils = f56083a;
                WifiInfo connectionInfo = wifiUtils.m().getConnectionInfo();
                Intrinsics.g(connectionInfo, "getConnectionInfo(...)");
                String ssid = connectionInfo.getSSID();
                Intrinsics.g(ssid, "getSSID(...)");
                if (wifiUtils.o(ssid)) {
                    wifiUtils.m().removeNetwork(connectionInfo.getNetworkId());
                    g.b(g.f56093a, wifiUtils.e() + " --> removeMbNet() --> success", false, 2, null);
                }
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        g.b(g.f56093a, f56083a.e() + " --> removeMbNet() --> 异常 it = " + m1188exceptionOrNullimpl, false, 2, null);
    }
}
