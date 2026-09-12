package com.transsion.transfer.wifi.util;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f56085a = new a();

    private a() {
    }

    public final int a(WifiConfiguration wifiConfig) {
        Intrinsics.h(wifiConfig, "wifiConfig");
        try {
            return wifiConfig.getClass().getDeclaredField("numAssociation").getInt(wifiConfig);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final String b(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return "OPEN";
        }
        String str2 = "WEP";
        if (!StringsKt.c0(str, "WEP", false, 2, null)) {
            str2 = "PSK";
            if (!StringsKt.c0(str, "PSK", false, 2, null) && !StringsKt.c0(str, "WPA", false, 2, null)) {
                str2 = "EAP";
                if (!StringsKt.c0(str, "EAP", false, 2, null)) {
                    str2 = "OTHER";
                    if (!StringsKt.c0(str, "OTHER", false, 2, null)) {
                        return "OPEN";
                    }
                }
            }
        }
        return str2;
    }

    public final boolean c(String str) {
        int length = str != null ? str.length() : 0;
        if (length != 10 && length != 26 && length != 58) {
            return false;
        }
        Intrinsics.e(str);
        return new Regex("[0-9A-Fa-f]*").matches(str);
    }

    public final void d(WifiConfiguration wifiConfig) {
        Intrinsics.h(wifiConfig, "wifiConfig");
        try {
            Field declaredField = wifiConfig.getClass().getDeclaredField("numNoInternetAccessReports");
            declaredField.setAccessible(true);
            declaredField.setInt(wifiConfig, 1);
        } catch (Exception unused) {
        }
    }

    public final void e(WifiManager wifiManager, WifiConfiguration wifiConfig) {
        Intrinsics.h(wifiManager, "wifiManager");
        Intrinsics.h(wifiConfig, "wifiConfig");
        try {
            int i11 = 0;
            for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                a aVar = f56085a;
                Intrinsics.e(wifiConfiguration);
                int a11 = aVar.a(wifiConfiguration);
                if (a11 > i11) {
                    i11 = a11;
                }
            }
            Field declaredField = wifiConfig.getClass().getDeclaredField("numAssociation");
            declaredField.setAccessible(true);
            declaredField.setInt(wifiConfig, i11);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void f(WifiConfiguration config, String str, String str2) {
        Intrinsics.h(config, "config");
        config.allowedAuthAlgorithms.clear();
        config.allowedGroupCiphers.clear();
        config.allowedKeyManagement.clear();
        config.allowedPairwiseCiphers.clear();
        config.allowedProtocols.clear();
        String b11 = b(str);
        switch (b11.hashCode()) {
            case 68404:
                if (b11.equals("EAP")) {
                    config.allowedProtocols.set(1);
                    config.allowedProtocols.set(0);
                    config.allowedGroupCiphers.set(0);
                    config.allowedGroupCiphers.set(1);
                    config.allowedGroupCiphers.set(2);
                    config.allowedGroupCiphers.set(3);
                    config.allowedPairwiseCiphers.set(1);
                    config.allowedPairwiseCiphers.set(2);
                    config.allowedKeyManagement.set(2);
                    config.allowedKeyManagement.set(3);
                    WifiUtils wifiUtils = WifiUtils.f56083a;
                    Intrinsics.e(str2);
                    config.preSharedKey = wifiUtils.d(str2);
                    break;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
                String format = String.format("\"%s\"", Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.g(format, "format(...)");
                config.preSharedKey = format;
                break;
            case 79528:
                if (b11.equals("PSK")) {
                    config.hiddenSSID = true;
                    config.allowedAuthAlgorithms.set(0);
                    config.allowedProtocols.set(1);
                    config.allowedProtocols.set(0);
                    config.allowedKeyManagement.set(1);
                    config.allowedPairwiseCiphers.set(2);
                    config.allowedPairwiseCiphers.set(1);
                    config.allowedGroupCiphers.set(0);
                    config.allowedGroupCiphers.set(1);
                    config.allowedGroupCiphers.set(3);
                    config.allowedGroupCiphers.set(2);
                    WifiUtils wifiUtils2 = WifiUtils.f56083a;
                    Intrinsics.e(str2);
                    config.preSharedKey = wifiUtils2.d(str2);
                    config.status = 2;
                    break;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f67412a;
                String format2 = String.format("\"%s\"", Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.g(format2, "format(...)");
                config.preSharedKey = format2;
                break;
            case 85826:
                if (b11.equals("WEP")) {
                    config.hiddenSSID = true;
                    config.wepTxKeyIndex = 0;
                    config.allowedKeyManagement.set(0);
                    config.allowedAuthAlgorithms.set(1);
                    config.allowedPairwiseCiphers.set(2);
                    config.allowedPairwiseCiphers.set(1);
                    config.allowedGroupCiphers.set(0);
                    config.allowedGroupCiphers.set(1);
                    config.status = 2;
                    if (!f56085a.c(str2)) {
                        String[] strArr = config.wepKeys;
                        WifiUtils wifiUtils3 = WifiUtils.f56083a;
                        Intrinsics.e(str2);
                        strArr[0] = wifiUtils3.d(str2);
                        break;
                    } else {
                        config.wepKeys[0] = str2;
                        break;
                    }
                }
                StringCompanionObject stringCompanionObject22 = StringCompanionObject.f67412a;
                String format22 = String.format("\"%s\"", Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.g(format22, "format(...)");
                config.preSharedKey = format22;
                break;
            case 2432586:
                if (b11.equals("OPEN")) {
                    config.allowedKeyManagement.set(0);
                    break;
                }
                StringCompanionObject stringCompanionObject222 = StringCompanionObject.f67412a;
                String format222 = String.format("\"%s\"", Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.g(format222, "format(...)");
                config.preSharedKey = format222;
                break;
            default:
                StringCompanionObject stringCompanionObject2222 = StringCompanionObject.f67412a;
                String format2222 = String.format("\"%s\"", Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.g(format2222, "format(...)");
                config.preSharedKey = format2222;
                break;
        }
        config.status = 2;
    }

    public final int g(WifiManager wifiManager, WifiConfiguration config) {
        Intrinsics.h(wifiManager, "wifiManager");
        Intrinsics.h(config, "config");
        a aVar = f56085a;
        aVar.e(wifiManager, config);
        aVar.d(config);
        return wifiManager.updateNetwork(config);
    }
}
