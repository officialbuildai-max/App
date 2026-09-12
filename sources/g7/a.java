package g7;

import com.cloud.hisavana.sdk.Z;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f63467a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f63468b;

    public static boolean a() {
        return c() != 0;
    }

    public static String b() {
        return c() != 0 ? "https://minproject.test.sunnbird.com/close-report/index.html" : "https://minproject.sunnbird.com/close-report/index.html";
    }

    public static int c() {
        return f63467a;
    }

    public static String d() {
        return "/hisavana/traffic-dispatch/v1/consumer-not-login/cloudcontrol/query/getCloudControlDataOffline";
    }

    public static String e() {
        int c11 = c();
        return c11 != 0 ? c11 != 2 ? c11 != 3 ? c11 != 4 ? "https://api.test.hisavana.com" : "https://api.fat1.hisavana.com" : "https://easymock.tmctool.com/mockurl/66f0d16c89ca3154e5a973ea" : "https://api-fat0101.eagllwin.com" : "https://cc-api.hisavana.com";
    }

    public static String f() {
        return c() == 0 ? "https://dcdn-api.hisavana.com" : "https://dcdn-api.test.hisavana.com";
    }

    public static String g() {
        return c() != 0 ? Z.f21623a.y() : Z.f21623a.x();
    }

    public static String h() {
        int c11 = c();
        return c11 != 0 ? c11 != 4 ? "https://api.test.eagllwin.com" : "https://api.fat1.eagllwin.com" : "https://api.eagllwin.com";
    }

    public static String i() {
        return "/hisavana/traffic-dispatch/v1/consumer-not-login/addispatch/query/getAdData";
    }

    public static String j() {
        int c11 = c();
        return c11 != 0 ? c11 != 2 ? c11 != 3 ? c11 != 4 ? "https://api.test.hisavana.com" : "https://api.fat1.hisavana.com" : "https://easymock.tmctool.com/mockurl/66f0d16c89ca3154e5a973ea" : "https://api-fat0101.eagllwin.com" : "https://api.hisavana.com";
    }

    public static boolean k() {
        return f63468b;
    }
}
