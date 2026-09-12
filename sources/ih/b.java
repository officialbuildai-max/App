package ih;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f65364a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f65365b = LazyKt.b(new Function0() { // from class: ih.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV p11;
            p11 = b.p();
            return p11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static String f65366c;

    /* renamed from: d, reason: collision with root package name */
    private static String f65367d;

    /* renamed from: e, reason: collision with root package name */
    private static String f65368e;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV p() {
        return MMKV.I("vshow");
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        if (context instanceof Application) {
            String string = m().getString("apkgaid", "");
            if (TextUtils.isEmpty(string)) {
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                jh.b.f66140c.a(context, intent);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("gid has get gid ");
                sb2.append(string);
            }
        }
    }

    public final String c() {
        if (TextUtils.isEmpty(f65366c)) {
            f65366c = m().getString("apkandroidid", "");
        }
        String str = f65366c;
        if (TextUtils.isEmpty(str)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Application a11 = Utils.a();
                str = Settings.System.getString(a11 != null ? a11.getContentResolver() : null, "android_id");
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        return str == null ? "" : str;
    }

    public final String d() {
        String BRAND = Build.BRAND;
        Intrinsics.g(BRAND, "BRAND");
        return BRAND;
    }

    public final String e() {
        return StringsKt.Q(StringsKt.Q(ArraysKt.e(Build.SUPPORTED_ABIS), "[", "", false, 4, null), "]", "", false, 4, null);
    }

    public final String f() {
        String country = Locale.getDefault().getCountry();
        Intrinsics.g(country, "getCountry(...)");
        return country;
    }

    public final String g() {
        Application a11 = Utils.a();
        Object systemService = a11 != null ? a11.getSystemService("phone") : null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        String simCountryIso = telephonyManager != null ? telephonyManager.getSimCountryIso() : null;
        if (simCountryIso == null || simCountryIso.length() == 0) {
            if (telephonyManager != null) {
                return telephonyManager.getNetworkCountryIso();
            }
            return null;
        }
        if (telephonyManager != null) {
            return telephonyManager.getSimCountryIso();
        }
        return null;
    }

    public final String h() {
        String str;
        if (TextUtils.isEmpty(f65368e)) {
            f65368e = m().getString("apkdeviceid", "");
        }
        String valueOf = String.valueOf(f65368e);
        if (TextUtils.isEmpty(f65366c)) {
            f65366c = m().getString("apkandroidid", "");
        }
        String valueOf2 = String.valueOf(f65366c);
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        if (!TextUtils.isEmpty(valueOf2)) {
            String d11 = lh.a.f68965a.d(valueOf2);
            r(d11);
            return d11;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Application a11 = Utils.a();
            str = Settings.System.getString(a11 != null ? a11.getContentResolver() : null, "android_id");
            Intrinsics.g(str, "getString(...)");
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th3) {
            valueOf2 = str;
            th = th3;
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th));
            str = valueOf2;
            if (TextUtils.isEmpty(str)) {
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "toString(...)");
            String d12 = lh.a.f68965a.d(uuid);
            r(d12);
            return d12;
        }
        if (TextUtils.isEmpty(str) && !Intrinsics.c(str, "9774d56d682e549c")) {
            String d13 = lh.a.f68965a.d(str);
            r(d13);
            q(str);
            return d13;
        }
        String uuid2 = UUID.randomUUID().toString();
        Intrinsics.g(uuid2, "toString(...)");
        String d122 = lh.a.f68965a.d(uuid2);
        r(d122);
        return d122;
    }

    public final String i() {
        if (TextUtils.isEmpty(f65367d)) {
            f65367d = m().getString("apkgaid", "");
        }
        String valueOf = String.valueOf(f65367d);
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        String c11 = c();
        if (!TextUtils.isEmpty(c11)) {
            return c11;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        return uuid;
    }

    public final String j() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.e(language);
        return language;
    }

    public final ActivityManager.MemoryInfo k(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("activity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public final String l() {
        String MODEL = Build.MODEL;
        Intrinsics.g(MODEL, "MODEL");
        return MODEL;
    }

    public final MMKV m() {
        return (MMKV) f65365b.getValue();
    }

    public final String n() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.g(RELEASE, "RELEASE");
        return RELEASE;
    }

    public final String o() {
        Object systemService = Utils.a().getSystemService("phone");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String simOperator = ((TelephonyManager) systemService).getSimOperator();
        Intrinsics.g(simOperator, "getSimOperator(...)");
        return simOperator;
    }

    public final void q(String androidId) {
        Intrinsics.h(androidId, "androidId");
        m().putString("apkandroidid", androidId);
    }

    public final void r(String deviceId) {
        Intrinsics.h(deviceId, "deviceId");
        m().putString("apkdeviceid", deviceId);
    }

    public final void s(String gid) {
        Intrinsics.h(gid, "gid");
        m().putString("apkgaid", gid);
    }
}
