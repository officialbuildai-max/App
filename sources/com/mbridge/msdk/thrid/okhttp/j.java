package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.DatesKt;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f38313j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f38314k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f38315l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f38316m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    private final String f38317a;

    /* renamed from: b, reason: collision with root package name */
    private final String f38318b;

    /* renamed from: c, reason: collision with root package name */
    private final long f38319c;

    /* renamed from: d, reason: collision with root package name */
    private final String f38320d;

    /* renamed from: e, reason: collision with root package name */
    private final String f38321e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f38322f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f38323g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f38324h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f38325i;

    private j(String str, String str2, long j11, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f38317a = str;
        this.f38318b = str2;
        this.f38319c = j11;
        this.f38320d = str3;
        this.f38321e = str4;
        this.f38322f = z10;
        this.f38323g = z11;
        this.f38325i = z12;
        this.f38324h = z13;
    }

    private static int a(String str, int i11, int i12, boolean z10) {
        while (i11 < i12) {
            char charAt = str.charAt(i11);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z10)) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    private static long a(String str, int i11, int i12) {
        int a11 = a(str, i11, i12, false);
        Matcher matcher = f38316m.matcher(str);
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        while (a11 < i12) {
            int a12 = a(str, a11 + 1, i12, true);
            matcher.region(a11, a12);
            if (i14 == -1 && matcher.usePattern(f38316m).matches()) {
                i14 = Integer.parseInt(matcher.group(1));
                i17 = Integer.parseInt(matcher.group(2));
                i18 = Integer.parseInt(matcher.group(3));
            } else if (i15 == -1 && matcher.usePattern(f38315l).matches()) {
                i15 = Integer.parseInt(matcher.group(1));
            } else {
                if (i16 == -1) {
                    Pattern pattern = f38314k;
                    if (matcher.usePattern(pattern).matches()) {
                        i16 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i13 == -1 && matcher.usePattern(f38313j).matches()) {
                    i13 = Integer.parseInt(matcher.group(1));
                }
            }
            a11 = a(str, a12 + 1, i12, false);
        }
        if (i13 >= 70 && i13 <= 99) {
            i13 += 1900;
        }
        if (i13 >= 0 && i13 <= 69) {
            i13 += 2000;
        }
        if (i13 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i16 == -1) {
            throw new IllegalArgumentException();
        }
        if (i15 < 1 || i15 > 31) {
            throw new IllegalArgumentException();
        }
        if (i14 < 0 || i14 > 23) {
            throw new IllegalArgumentException();
        }
        if (i17 < 0 || i17 > 59) {
            throw new IllegalArgumentException();
        }
        if (i18 < 0 || i18 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(com.mbridge.msdk.thrid.okhttp.internal.c.f37970p);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i13);
        gregorianCalendar.set(2, i16 - 1);
        gregorianCalendar.set(5, i15);
        gregorianCalendar.set(11, i14);
        gregorianCalendar.set(12, i17);
        gregorianCalendar.set(13, i18);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    static j a(long j11, q qVar, String str) {
        long j12;
        j jVar;
        String str2;
        String substring;
        int length = str.length();
        char c11 = ';';
        int a11 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, 0, length, ';');
        char c12 = '=';
        int a12 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, 0, a11, '=');
        if (a12 == a11) {
            return null;
        }
        String d11 = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, 0, a12);
        if (d11.isEmpty() || com.mbridge.msdk.thrid.okhttp.internal.c.c(d11) != -1) {
            return null;
        }
        String d12 = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, a12 + 1, a11);
        if (com.mbridge.msdk.thrid.okhttp.internal.c.c(d12) != -1) {
            return null;
        }
        int i11 = a11 + 1;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        String str3 = null;
        boolean z13 = true;
        long j13 = -1;
        long j14 = 253402300799999L;
        String str4 = null;
        while (i11 < length) {
            int a13 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i11, length, c11);
            int a14 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i11, a13, c12);
            String d13 = com.mbridge.msdk.thrid.okhttp.internal.c.d(str, i11, a14);
            String d14 = a14 < a13 ? com.mbridge.msdk.thrid.okhttp.internal.c.d(str, a14 + 1, a13) : "";
            if (d13.equalsIgnoreCase("expires")) {
                try {
                    j14 = a(d14, 0, d14.length());
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (d13.equalsIgnoreCase("max-age")) {
                j13 = b(d14);
            } else {
                if (d13.equalsIgnoreCase("domain")) {
                    str3 = a(d14);
                    z13 = false;
                } else if (d13.equalsIgnoreCase("path")) {
                    str4 = d14;
                } else if (d13.equalsIgnoreCase("secure")) {
                    z10 = true;
                } else if (d13.equalsIgnoreCase("httponly")) {
                    z11 = true;
                }
                i11 = a13 + 1;
                c11 = ';';
                c12 = '=';
            }
            z12 = true;
            i11 = a13 + 1;
            c11 = ';';
            c12 = '=';
        }
        if (j13 == Long.MIN_VALUE) {
            j12 = Long.MIN_VALUE;
        } else if (j13 != -1) {
            long j15 = j11 + (j13 <= 9223372036854775L ? j13 * 1000 : Long.MAX_VALUE);
            j12 = (j15 < j11 || j15 > DatesKt.MAX_DATE) ? 253402300799999L : j15;
        } else {
            j12 = j14;
        }
        String g11 = qVar.g();
        if (str3 == null) {
            str2 = g11;
            jVar = null;
        } else {
            if (!a(g11, str3)) {
                return null;
            }
            jVar = null;
            str2 = str3;
        }
        if (g11.length() != str2.length() && PublicSuffixDatabase.a().a(str2) == null) {
            return jVar;
        }
        if (str4 == null || !str4.startsWith("/")) {
            String c13 = qVar.c();
            int lastIndexOf = c13.lastIndexOf(47);
            substring = lastIndexOf != 0 ? c13.substring(0, lastIndexOf) : "/";
        } else {
            substring = str4;
        }
        return new j(d11, d12, j12, str2, substring, z10, z11, z13, z12);
    }

    public static j a(q qVar, String str) {
        return a(System.currentTimeMillis(), qVar, str);
    }

    private static String a(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String a11 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str);
        if (a11 != null) {
            return a11;
        }
        throw new IllegalArgumentException();
    }

    public static List<j> a(q qVar, p pVar) {
        List<String> c11 = pVar.c("Set-Cookie");
        int size = c11.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            j a11 = a(qVar, c11.get(i11));
            if (a11 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a11);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.mbridge.msdk.thrid.okhttp.internal.c.d(str);
    }

    private static long b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e11) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e11;
        }
    }

    public String a() {
        return this.f38317a;
    }

    String a(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f38317a);
        sb2.append('=');
        sb2.append(this.f38318b);
        if (this.f38324h) {
            if (this.f38319c == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(com.mbridge.msdk.thrid.okhttp.internal.http.d.a(new Date(this.f38319c)));
            }
        }
        if (!this.f38325i) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.f38320d);
        }
        sb2.append("; path=");
        sb2.append(this.f38321e);
        if (this.f38322f) {
            sb2.append("; secure");
        }
        if (this.f38323g) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }

    public String b() {
        return this.f38318b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f38317a.equals(this.f38317a) && jVar.f38318b.equals(this.f38318b) && jVar.f38320d.equals(this.f38320d) && jVar.f38321e.equals(this.f38321e) && jVar.f38319c == this.f38319c && jVar.f38322f == this.f38322f && jVar.f38323g == this.f38323g && jVar.f38324h == this.f38324h && jVar.f38325i == this.f38325i;
    }

    public int hashCode() {
        int hashCode = (((((((this.f38317a.hashCode() + 527) * 31) + this.f38318b.hashCode()) * 31) + this.f38320d.hashCode()) * 31) + this.f38321e.hashCode()) * 31;
        long j11 = this.f38319c;
        return ((((((((hashCode + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (!this.f38322f ? 1 : 0)) * 31) + (!this.f38323g ? 1 : 0)) * 31) + (!this.f38324h ? 1 : 0)) * 31) + (!this.f38325i ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }
}
