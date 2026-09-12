package bw;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import javax.crypto.spec.IvParameterSpec;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.mvel2.ast.ASTNode;

/* loaded from: classes6.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f17032a = "";

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f17033b = "";

    public static String a(Context context) {
        Intrinsics.h(context, "context");
        String language = context.getResources().getConfiguration().locale.getLanguage();
        Intrinsics.g(language, "getLanguage(...)");
        String upperCase = language.toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    public static final void b(Application it) {
        Intrinsics.h(it, "$it");
        try {
            String id2 = AdvertisingIdClient.getAdvertisingIdInfo(it).getId();
            if (TextUtils.isEmpty(id2)) {
                return;
            }
            Intrinsics.e(id2);
            f17032a = id2;
            h hVar = i.f17023b;
            hVar.a(it).b("KV_UPGRADE_GAID_VALUE", f17032a);
            IvParameterSpec ivParameterSpec = c.f17018a;
            String packageName = it.getPackageName();
            Intrinsics.g(packageName, "getPackageName(...)");
            String b11 = c.b(id2, packageName);
            if (TextUtils.isEmpty(b11)) {
                return;
            }
            Intrinsics.e(b11);
            f17033b = b11;
            hVar.a(it).b("KV_UPGRADE_GAID_ENCRYPT_VALUE", f17033b);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void c(String pkgName, int i11, int i12, Function0 callback) {
        String str;
        Intrinsics.h(pkgName, "pkgName");
        Intrinsics.h(callback, "callback");
        Application application = xv.a.f78570a;
        Application application2 = null;
        if (application == null) {
            Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            application = null;
        }
        PackageManager packageManager = application.getPackageManager();
        if (packageManager != null) {
            boolean z10 = true;
            if (i11 == 0 || i11 == 1) {
                str = "&iad=" + i11;
            } else {
                str = "&su=" + i11;
            }
            try {
                StringBuilder sb2 = new StringBuilder("palmplay://thirdlauncher.com/?entryType=AppDetail&packageName=");
                sb2.append(pkgName);
                sb2.append("&_source=ps_updatesdk&backFloatball=");
                if (i12 != 1) {
                    z10 = false;
                }
                sb2.append(z10);
                sb2.append(str);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb2.toString()));
                intent.addFlags(ASTNode.DEOP);
                intent.putExtra("currentUpdateTime", e());
                if (intent.resolveActivity(packageManager) != null) {
                    Application application3 = xv.a.f78570a;
                    if (application3 != null) {
                        application2 = application3;
                    } else {
                        Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                    }
                    application2.startActivity(intent);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            callback.invoke();
        }
    }

    public static boolean d() {
        Application application = xv.a.f78570a;
        if (application == null) {
            Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            application = null;
        }
        return new Intent("android.intent.action.VIEW", Uri.parse("palmplay://thirdlauncher.com/?entryType=AppDetail")).resolveActivity(application.getPackageManager()) != null;
    }

    public static String e() {
        String str;
        String fileName = j.f17027b;
        Intrinsics.h(fileName, "fileName");
        try {
            Application application = xv.a.f78570a;
            if (application == null) {
                Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                application = null;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(application.getResources().getAssets().open(fileName));
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                    }
                    str = sb2.toString();
                    Intrinsics.g(str, "toString(...)");
                    bufferedReader.close();
                    inputStreamReader.close();
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th3) {
                    ExceptionsKt.a(th2, th3);
                }
                throw th2;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            str = "";
        }
        byte[] decode = Base64.decode(str, 0);
        String valueOf = String.valueOf(System.currentTimeMillis());
        byte[] bArr = j.f17026a;
        byte[] bytes = valueOf.getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
        Intrinsics.e(decode);
        String encodeToString = Base64.encodeToString(j.a(bytes, decode), 0);
        Intrinsics.g(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    public static vv.b f(Context context) {
        String str;
        String str2;
        List l11;
        List l12;
        String str3 = "";
        Intrinsics.h(context, "context");
        Context applicationContext = context.getApplicationContext();
        vv.b bVar = new vv.b("", null, "", 0L, "", "", "", "", "", "", "", "1", "");
        PackageManager packageManager = applicationContext.getPackageManager();
        String packageName = applicationContext.getPackageName();
        Intrinsics.e(packageName);
        Intrinsics.h(packageName, "<set-?>");
        bVar.f77571a = packageName;
        String BRAND = Build.BRAND;
        Intrinsics.g(BRAND, "BRAND");
        Intrinsics.h(BRAND, "<set-?>");
        bVar.f77579i = BRAND;
        String MODEL = Build.MODEL;
        Intrinsics.g(MODEL, "MODEL");
        Intrinsics.h(MODEL, "<set-?>");
        bVar.f77581k = MODEL;
        try {
            if (TextUtils.isEmpty(MODEL)) {
                str = "";
            } else {
                Intrinsics.e(MODEL);
                if (StringsKt.c0(MODEL, " ", false, 2, null)) {
                    List<String> split = new Regex(" ").split(MODEL, 0);
                    if (!split.isEmpty()) {
                        ListIterator<String> listIterator = split.listIterator(split.size());
                        while (listIterator.hasPrevious()) {
                            if (listIterator.previous().length() != 0) {
                                l12 = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    l12 = CollectionsKt.l();
                    str2 = ((String[]) l12.toArray(new String[0]))[r0.length - 1];
                } else if (StringsKt.c0(MODEL, "-", false, 2, null)) {
                    List<String> split2 = new Regex("-").split(MODEL, 0);
                    if (!split2.isEmpty()) {
                        ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() != 0) {
                                l11 = CollectionsKt.K0(split2, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    l11 = CollectionsKt.l();
                    str2 = ((String[]) l11.toArray(new String[0]))[r0.length - 1];
                } else {
                    str2 = MODEL;
                }
                str = str2.toUpperCase(Locale.ROOT);
                Intrinsics.g(str, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            }
            StringBuilder sb2 = new StringBuilder();
            String BRAND2 = Build.BRAND;
            Intrinsics.g(BRAND2, "BRAND");
            String upperCase = BRAND2.toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            sb2.append(upperCase);
            sb2.append('_');
            sb2.append(str);
            MODEL = sb2.toString();
        } catch (Exception unused) {
            Intrinsics.e(MODEL);
        }
        Intrinsics.h(MODEL, "<set-?>");
        bVar.f77580j = MODEL;
        String h11 = h();
        Intrinsics.h(h11, "<set-?>");
        bVar.f77582l = h11;
        Application application = xv.a.f78570a;
        if (application == null) {
            Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
            application = null;
        }
        try {
            Object systemService = application.getSystemService("phone");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            String simCountryIso = ((TelephonyManager) systemService).getSimCountryIso();
            Intrinsics.g(simCountryIso, "getSimCountryIso(...)");
            str3 = simCountryIso;
        } catch (Exception unused2) {
        }
        Intrinsics.h(str3, "<set-?>");
        bVar.f77578h = str3;
        String locale = Locale.getDefault().toString();
        Intrinsics.g(locale, "toString(...)");
        Intrinsics.h(locale, "<set-?>");
        bVar.f77583m = locale;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            Intrinsics.g(applicationInfo, "getApplicationInfo(...)");
            Drawable drawable = packageManager.getDrawable(packageName, applicationInfo.icon, null);
            CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
            Intrinsics.f(applicationLabel, "null cannot be cast to non-null type kotlin.String");
            String str4 = (String) applicationLabel;
            long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
            String str5 = packageInfo.versionName;
            Intrinsics.h(str4, "<set-?>");
            bVar.f77573c = str4;
            bVar.f77572b = drawable;
            bVar.f77574d = longVersionCode;
            Intrinsics.e(str5);
            Intrinsics.h(str5, "<set-?>");
            bVar.f77575e = str5;
            Intrinsics.e(applicationContext);
            String a11 = a(applicationContext);
            Intrinsics.h(a11, "<set-?>");
            bVar.f77576f = a11;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
        }
        g();
        return bVar;
    }

    public static String g() {
        if (TextUtils.isEmpty(f17032a)) {
            final Application application = xv.a.f78570a;
            if (application == null) {
                Intrinsics.z(MimeTypes.BASE_TYPE_APPLICATION);
                application = null;
            }
            new Thread(new Runnable() { // from class: bw.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.b(application);
                }
            }).start();
            h hVar = i.f17023b;
            f17032a = hVar.a(application).a("KV_UPGRADE_GAID_VALUE", "");
            f17033b = hVar.a(application).a("KV_UPGRADE_GAID_ENCRYPT_VALUE", "");
        }
        String msg = "gaid : " + f17032a;
        Intrinsics.h("UpgradeSdkManager", "tag");
        Intrinsics.h(msg, "msg");
        long currentTimeMillis = System.currentTimeMillis();
        if (!g.f17021a && currentTimeMillis - g.f17022b >= 5000) {
            g.f17022b = currentTimeMillis;
            if (Log.isLoggable("upgradeSdkLog", 3)) {
                g.f17021a = true;
            }
        }
        boolean z10 = yv.f.f79190o.a().f79195d;
        return f17032a;
    }

    public static String h() {
        String str;
        int i11;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, "ro.system.build.version.release");
            Intrinsics.f(invoke, "null cannot be cast to non-null type kotlin.String");
            str = (String) invoke;
        } catch (Exception e11) {
            e11.printStackTrace();
            str = "";
        }
        if (str == null || str.length() == 0) {
            i11 = -1;
        } else if (Character.isDigit(str.charAt(0))) {
            i11 = Integer.parseInt(str);
        } else {
            Locale locale = Locale.getDefault();
            Intrinsics.g(locale, "getDefault(...)");
            String upperCase = str.toUpperCase(locale);
            Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(locale)");
            i11 = upperCase.charAt(0) - 'G';
        }
        return String.valueOf(i11);
    }

    public static long i() {
        try {
            PackageInfo packageInfo = qk.a.a().getPackageManager().getPackageInfo(MiniAppIpcConfig.PALM_STORE_PACKAGE_NAME, 0);
            Intrinsics.g(packageInfo, "getPackageInfo(...)");
            return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return -1L;
        }
    }
}
