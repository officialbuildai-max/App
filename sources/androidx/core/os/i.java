package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    private static final i f8244b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    private final k f8245a;

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Locale[] f8246a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }
    }

    private i(k kVar) {
        this.f8245a = kVar;
    }

    public static i a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? j(b.a(localeArr)) : new i(new j(localeArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static i c(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i11 = 0; i11 < length; i11++) {
            localeArr[i11] = a.a(split[i11]);
        }
        return a(localeArr);
    }

    public static i e() {
        return f8244b;
    }

    public static i j(LocaleList localeList) {
        return new i(new p(localeList));
    }

    public Locale d(int i11) {
        return this.f8245a.get(i11);
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && this.f8245a.equals(((i) obj).f8245a);
    }

    public boolean f() {
        return this.f8245a.isEmpty();
    }

    public int g() {
        return this.f8245a.size();
    }

    public String h() {
        return this.f8245a.a();
    }

    public int hashCode() {
        return this.f8245a.hashCode();
    }

    public Object i() {
        return this.f8245a.b();
    }

    public String toString() {
        return this.f8245a.toString();
    }
}
