package com.tn.tranpay.device;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.tn.tranpay.TranPay;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zh.b;

/* loaded from: classes4.dex */
public final class TNDeviceHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final TNDeviceHelper f41584a = new TNDeviceHelper();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f41585b = LazyKt.b(new Function0<MMKV>() { // from class: com.tn.tranpay.device.TNDeviceHelper$tranMmkv$2
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.I("tran_v_show");
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static String f41586c;

    /* renamed from: d, reason: collision with root package name */
    private static String f41587d;

    /* renamed from: e, reason: collision with root package name */
    private static String f41588e;

    private TNDeviceHelper() {
    }

    private final MMKV e() {
        Object value = f41585b.getValue();
        Intrinsics.g(value, "<get-tranMmkv>(...)");
        return (MMKV) value;
    }

    public final void a(Context context) {
        Intrinsics.h(context, "context");
        if (!(context instanceof Application)) {
            System.out.println((Object) "please pass in application to avoid Service not registered exception ");
            return;
        }
        String string = e().getString("sdk_ga_id", "");
        if (TextUtils.isEmpty(string)) {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            b.f79546c.a(context, intent);
        } else {
            System.out.println((Object) ("gid has get gid " + string));
        }
    }

    public final String b() {
        if (TextUtils.isEmpty(f41586c)) {
            f41586c = e().getString("sdk_android_id", "");
        }
        String str = f41586c;
        if (TextUtils.isEmpty(str)) {
            try {
                str = Settings.System.getString(TranPay.f41540a.d().getContentResolver(), "android_id");
            } catch (Exception e11) {
                ai.a.e(ai.a.f694a, "Failed to get Android ID: " + e11.getMessage(), null, 2, null);
                str = "";
            }
        }
        return str == null ? "" : str;
    }

    public final String c() {
        String str = "";
        if (TextUtils.isEmpty(f41588e)) {
            f41588e = e().getString("sdk_device_id", "");
        }
        String valueOf = String.valueOf(f41588e);
        if (TextUtils.isEmpty(f41586c)) {
            f41586c = e().getString("sdk_android_id", "");
        }
        String valueOf2 = String.valueOf(f41586c);
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        if (!TextUtils.isEmpty(valueOf2)) {
            String a11 = a.f41589a.a(valueOf2);
            g(a11);
            return a11;
        }
        try {
            String string = Settings.System.getString(TranPay.f41540a.d().getContentResolver(), "android_id");
            Intrinsics.g(string, "{\n            // 使用 Tran…D\n            )\n        }");
            str = string;
        } catch (Exception e11) {
            ai.a.e(ai.a.f694a, "Failed to get Android ID: " + e11.getMessage(), null, 2, null);
        }
        if (!TextUtils.isEmpty(str) && !Intrinsics.c(str, "9774d56d682e549c")) {
            String a12 = a.f41589a.a(str);
            g(a12);
            f(str);
            return a12;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "randomUUID().toString()");
        String a13 = a.f41589a.a(uuid);
        g(a13);
        return a13;
    }

    public final String d() {
        if (TextUtils.isEmpty(f41587d)) {
            f41587d = e().getString("sdk_ga_id", "");
        }
        String valueOf = String.valueOf(f41587d);
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        String b11 = b();
        if (!TextUtils.isEmpty(b11)) {
            return b11;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "randomUUID().toString()");
        return uuid;
    }

    public final void f(String androidId) {
        Intrinsics.h(androidId, "androidId");
        e().putString("sdk_android_id", androidId);
    }

    public final void g(String deviceId) {
        Intrinsics.h(deviceId, "deviceId");
        e().putString("sdk_device_id", deviceId);
    }

    public final void h(String gid) {
        Intrinsics.h(gid, "gid");
        e().putString("sdk_ga_id", gid);
    }
}
