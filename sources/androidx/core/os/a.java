package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8232a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final int f8233b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f8234c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f8235d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f8236e;

    /* renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0072a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0072a f8237a = new C0072a();

        private C0072a() {
        }

        public final int a(int i11) {
            return SdkExtensions.getExtensionVersion(i11);
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        f8233b = i11 >= 30 ? C0072a.f8237a.a(30) : 0;
        f8234c = i11 >= 30 ? C0072a.f8237a.a(31) : 0;
        f8235d = i11 >= 30 ? C0072a.f8237a.a(33) : 0;
        f8236e = i11 >= 30 ? C0072a.f8237a.a(1000000) : 0;
    }

    private a() {
    }

    public static final boolean a(String codename, String buildCodename) {
        Intrinsics.h(codename, "codename");
        Intrinsics.h(buildCodename, "buildCodename");
        if (Intrinsics.c("REL", buildCodename)) {
            return false;
        }
        Integer b11 = b(buildCodename);
        Integer b12 = b(codename);
        if (b11 != null && b12 != null) {
            return b11.intValue() >= b12.intValue();
        }
        if (b11 != null || b12 != null) {
            return b11 != null;
        }
        Locale locale = Locale.ROOT;
        String upperCase = buildCodename.toUpperCase(locale);
        Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = codename.toUpperCase(locale);
        Intrinsics.g(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    private static final Integer b(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return Intrinsics.c(upperCase, "BAKLAVA") ? 0 : null;
    }

    public static final boolean c() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 34) {
            if (i11 >= 33) {
                String CODENAME = Build.VERSION.CODENAME;
                Intrinsics.g(CODENAME, "CODENAME");
                if (a("UpsideDownCake", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean d() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 35) {
            if (i11 >= 34) {
                String CODENAME = Build.VERSION.CODENAME;
                Intrinsics.g(CODENAME, "CODENAME");
                if (a("VanillaIceCream", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }
}
