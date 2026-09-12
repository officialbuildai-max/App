package com.mbridge.msdk.thrid.okhttp;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: classes5.dex */
public final class q {

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f38343j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    final String f38344a;

    /* renamed from: b, reason: collision with root package name */
    private final String f38345b;

    /* renamed from: c, reason: collision with root package name */
    private final String f38346c;

    /* renamed from: d, reason: collision with root package name */
    final String f38347d;

    /* renamed from: e, reason: collision with root package name */
    final int f38348e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f38349f;

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f38350g;

    /* renamed from: h, reason: collision with root package name */
    private final String f38351h;

    /* renamed from: i, reason: collision with root package name */
    private final String f38352i;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        String f38353a;

        /* renamed from: d, reason: collision with root package name */
        String f38356d;

        /* renamed from: f, reason: collision with root package name */
        final List<String> f38358f;

        /* renamed from: g, reason: collision with root package name */
        List<String> f38359g;

        /* renamed from: h, reason: collision with root package name */
        String f38360h;

        /* renamed from: b, reason: collision with root package name */
        String f38354b = "";

        /* renamed from: c, reason: collision with root package name */
        String f38355c = "";

        /* renamed from: e, reason: collision with root package name */
        int f38357e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f38358f = arrayList;
            arrayList.add("");
        }

        private static String a(String str, int i11, int i12) {
            return com.mbridge.msdk.thrid.okhttp.internal.c.a(q.a(str, i11, i12, false));
        }

        private void a(String str, int i11, int i12, boolean z10, boolean z11) {
            String a11 = q.a(str, i11, i12, HttpUrl.PATH_SEGMENT_ENCODE_SET, z11, false, false, true, null);
            if (c(a11)) {
                return;
            }
            if (d(a11)) {
                c();
                return;
            }
            if (this.f38358f.get(r11.size() - 1).isEmpty()) {
                this.f38358f.set(r11.size() - 1, a11);
            } else {
                this.f38358f.add(a11);
            }
            if (z10) {
                this.f38358f.add("");
            }
        }

        private static int b(String str, int i11, int i12) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(q.a(str, i11, i12, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private static int c(String str, int i11, int i12) {
            while (i11 < i12) {
                char charAt = str.charAt(i11);
                if (charAt == ':') {
                    return i11;
                }
                if (charAt != '[') {
                    i11++;
                }
                do {
                    i11++;
                    if (i11 < i12) {
                    }
                    i11++;
                } while (str.charAt(i11) != ']');
                i11++;
            }
            return i12;
        }

        private void c() {
            if (!this.f38358f.remove(r0.size() - 1).isEmpty() || this.f38358f.isEmpty()) {
                this.f38358f.add("");
            } else {
                this.f38358f.set(r0.size() - 1, "");
            }
        }

        private boolean c(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private void d(String str, int i11, int i12) {
            if (i11 == i12) {
                return;
            }
            char charAt = str.charAt(i11);
            if (charAt == '/' || charAt == '\\') {
                this.f38358f.clear();
                this.f38358f.add("");
                i11++;
            } else {
                List<String> list = this.f38358f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i13 = i11;
                while (i13 < i12) {
                    i11 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i13, i12, "/\\");
                    boolean z10 = i11 < i12;
                    a(str, i13, i11, z10, true);
                    if (z10) {
                        i13 = i11 + 1;
                    }
                }
                return;
            }
        }

        private boolean d(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int e(String str, int i11, int i12) {
            if (i12 - i11 < 2) {
                return -1;
            }
            char charAt = str.charAt(i11);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i11++;
                    if (i11 >= i12) {
                        break;
                    }
                    char charAt2 = str.charAt(i11);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i11;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int f(String str, int i11, int i12) {
            int i13 = 0;
            while (i11 < i12) {
                char charAt = str.charAt(i11);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i13++;
                i11++;
            }
            return i13;
        }

        public a a(int i11) {
            if (i11 > 0 && i11 <= 65535) {
                this.f38357e = i11;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i11);
        }

        a a(q qVar, String str) {
            int a11;
            int i11;
            int b11 = com.mbridge.msdk.thrid.okhttp.internal.c.b(str, 0, str.length());
            int c11 = com.mbridge.msdk.thrid.okhttp.internal.c.c(str, b11, str.length());
            int e11 = e(str, b11, c11);
            if (e11 != -1) {
                if (str.regionMatches(true, b11, "https:", 0, 6)) {
                    this.f38353a = "https";
                    b11 += 6;
                } else {
                    if (!str.regionMatches(true, b11, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, e11) + "'");
                    }
                    this.f38353a = "http";
                    b11 += 5;
                }
            } else {
                if (qVar == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f38353a = qVar.f38344a;
            }
            int f11 = f(str, b11, c11);
            char c12 = '?';
            char c13 = '#';
            if (f11 >= 2 || qVar == null || !qVar.f38344a.equals(this.f38353a)) {
                boolean z10 = false;
                boolean z11 = false;
                int i12 = b11 + f11;
                while (true) {
                    a11 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i12, c11, "@/\\?#");
                    char charAt = a11 != c11 ? str.charAt(a11) : (char) 65535;
                    if (charAt == 65535 || charAt == c13 || charAt == '/' || charAt == '\\' || charAt == c12) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z10) {
                            i11 = a11;
                            this.f38355c += "%40" + q.a(str, i12, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int a12 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, i12, a11, ':');
                            i11 = a11;
                            String a13 = q.a(str, i12, a12, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z11) {
                                a13 = this.f38354b + "%40" + a13;
                            }
                            this.f38354b = a13;
                            if (a12 != i11) {
                                this.f38355c = q.a(str, a12 + 1, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z10 = true;
                            }
                            z11 = true;
                        }
                        i12 = i11 + 1;
                        c12 = '?';
                        c13 = '#';
                    }
                }
                int c14 = c(str, i12, a11);
                int i13 = c14 + 1;
                if (i13 < a11) {
                    this.f38356d = a(str, i12, c14);
                    int b12 = b(str, i13, a11);
                    this.f38357e = b12;
                    if (b12 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i13, a11) + '\"');
                    }
                } else {
                    this.f38356d = a(str, i12, c14);
                    this.f38357e = q.a(this.f38353a);
                }
                if (this.f38356d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i12, c14) + '\"');
                }
                b11 = a11;
            } else {
                this.f38354b = qVar.f();
                this.f38355c = qVar.b();
                this.f38356d = qVar.f38347d;
                this.f38357e = qVar.f38348e;
                this.f38358f.clear();
                this.f38358f.addAll(qVar.d());
                if (b11 == c11 || str.charAt(b11) == '#') {
                    a(qVar.e());
                }
            }
            int a14 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, b11, c11, "?#");
            d(str, b11, a14);
            if (a14 < c11 && str.charAt(a14) == '?') {
                int a15 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, a14, c11, '#');
                this.f38359g = q.d(q.a(str, a14 + 1, a15, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                a14 = a15;
            }
            if (a14 < c11 && str.charAt(a14) == '#') {
                this.f38360h = q.a(str, 1 + a14, c11, "", true, false, false, false, null);
            }
            return this;
        }

        public a a(String str) {
            this.f38359g = str != null ? q.d(q.a(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public q a() {
            if (this.f38353a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f38356d != null) {
                return new q(this);
            }
            throw new IllegalStateException("host == null");
        }

        int b() {
            int i11 = this.f38357e;
            return i11 != -1 ? i11 : q.a(this.f38353a);
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String a11 = a(str, 0, str.length());
            if (a11 != null) {
                this.f38356d = a11;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        a d() {
            int size = this.f38358f.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f38358f.set(i11, q.a(this.f38358f.get(i11), "[]", true, true, false, true));
            }
            List<String> list = this.f38359g;
            if (list != null) {
                int size2 = list.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    String str = this.f38359g.get(i12);
                    if (str != null) {
                        this.f38359g.set(i12, q.a(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.f38360h;
            if (str2 != null) {
                this.f38360h = q.a(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public a e(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f38353a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f38353a = "https";
            }
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.f38353a;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (!this.f38354b.isEmpty() || !this.f38355c.isEmpty()) {
                sb2.append(this.f38354b);
                if (!this.f38355c.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.f38355c);
                }
                sb2.append('@');
            }
            String str2 = this.f38356d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append(this.f38356d);
                    sb2.append(']');
                } else {
                    sb2.append(this.f38356d);
                }
            }
            if (this.f38357e != -1 || this.f38353a != null) {
                int b11 = b();
                String str3 = this.f38353a;
                if (str3 == null || b11 != q.a(str3)) {
                    sb2.append(':');
                    sb2.append(b11);
                }
            }
            q.b(sb2, this.f38358f);
            if (this.f38359g != null) {
                sb2.append('?');
                q.a(sb2, this.f38359g);
            }
            if (this.f38360h != null) {
                sb2.append('#');
                sb2.append(this.f38360h);
            }
            return sb2.toString();
        }
    }

    q(a aVar) {
        this.f38344a = aVar.f38353a;
        this.f38345b = a(aVar.f38354b, false);
        this.f38346c = a(aVar.f38355c, false);
        this.f38347d = aVar.f38356d;
        this.f38348e = aVar.b();
        this.f38349f = a(aVar.f38358f, false);
        List<String> list = aVar.f38359g;
        this.f38350g = list != null ? a(list, true) : null;
        String str = aVar.f38360h;
        this.f38351h = str != null ? a(str, false) : null;
        this.f38352i = aVar.toString();
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static String a(String str, int i11, int i12, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        int i13 = i11;
        while (i13 < i12) {
            int codePointAt = str.codePointAt(i13);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z13)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z10 && (!z11 || a(str, i13, i12)))) && (codePointAt != 43 || !z12))) {
                    i13 += Character.charCount(codePointAt);
                }
            }
            com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
            cVar.a(str, i11, i13);
            a(cVar, str, i13, i12, str2, z10, z11, z12, z13, charset);
            return cVar.p();
        }
        return str.substring(i11, i12);
    }

    static String a(String str, int i11, int i12, boolean z10) {
        for (int i13 = i11; i13 < i12; i13++) {
            char charAt = str.charAt(i13);
            if (charAt == '%' || (charAt == '+' && z10)) {
                com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
                cVar.a(str, i11, i13);
                a(cVar, str, i13, i12, z10);
                return cVar.p();
            }
        }
        return str.substring(i11, i12);
    }

    static String a(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        return a(str, 0, str.length(), str2, z10, z11, z12, z13, null);
    }

    static String a(String str, boolean z10) {
        return a(str, 0, str.length(), z10);
    }

    private List<String> a(List<String> list, boolean z10) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            String str = list.get(i11);
            arrayList.add(str != null ? a(str, z10) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(com.mbridge.msdk.thrid.okio.c cVar, String str, int i11, int i12, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        com.mbridge.msdk.thrid.okio.c cVar2 = null;
        while (i11 < i12) {
            int codePointAt = str.codePointAt(i11);
            if (!z10 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z12) {
                    cVar.a(z10 ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z13) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z10 || (z11 && !a(str, i11, i12)))))) {
                    if (cVar2 == null) {
                        cVar2 = new com.mbridge.msdk.thrid.okio.c();
                    }
                    if (charset == null || charset.equals(com.mbridge.msdk.thrid.okhttp.internal.c.f37964j)) {
                        cVar2.f(codePointAt);
                    } else {
                        cVar2.a(str, i11, Character.charCount(codePointAt) + i11, charset);
                    }
                    while (!cVar2.f()) {
                        byte readByte = cVar2.readByte();
                        cVar.writeByte(37);
                        char[] cArr = f38343j;
                        cVar.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        cVar.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    cVar.f(codePointAt);
                }
            }
            i11 += Character.charCount(codePointAt);
        }
    }

    static void a(com.mbridge.msdk.thrid.okio.c cVar, String str, int i11, int i12, boolean z10) {
        int i13;
        while (i11 < i12) {
            int codePointAt = str.codePointAt(i11);
            if (codePointAt != 37 || (i13 = i11 + 2) >= i12) {
                if (codePointAt == 43 && z10) {
                    cVar.writeByte(32);
                }
                cVar.f(codePointAt);
            } else {
                int a11 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str.charAt(i11 + 1));
                int a12 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str.charAt(i13));
                if (a11 != -1 && a12 != -1) {
                    cVar.writeByte((a11 << 4) + a12);
                    i11 = i13;
                }
                cVar.f(codePointAt);
            }
            i11 += Character.charCount(codePointAt);
        }
    }

    static void a(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11 += 2) {
            String str = list.get(i11);
            String str2 = list.get(i11 + 1);
            if (i11 > 0) {
                sb2.append('&');
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
        }
    }

    static boolean a(String str, int i11, int i12) {
        int i13 = i11 + 2;
        return i13 < i12 && str.charAt(i11) == '%' && com.mbridge.msdk.thrid.okhttp.internal.c.a(str.charAt(i11 + 1)) != -1 && com.mbridge.msdk.thrid.okhttp.internal.c.a(str.charAt(i13)) != -1;
    }

    public static q b(String str) {
        return new a().a(null, str).a();
    }

    static void b(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append('/');
            sb2.append(list.get(i11));
        }
    }

    static List<String> d(String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 <= str.length()) {
            int indexOf = str.indexOf(38, i11);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i11);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i11, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i11, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i11 = indexOf + 1;
        }
        return arrayList;
    }

    public String a() {
        if (this.f38351h == null) {
            return null;
        }
        return this.f38352i.substring(this.f38352i.indexOf(35) + 1);
    }

    public String b() {
        if (this.f38346c.isEmpty()) {
            return "";
        }
        return this.f38352i.substring(this.f38352i.indexOf(58, this.f38344a.length() + 3) + 1, this.f38352i.indexOf(64));
    }

    public a c(String str) {
        try {
            return new a().a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String c() {
        int indexOf = this.f38352i.indexOf(47, this.f38344a.length() + 3);
        String str = this.f38352i;
        return this.f38352i.substring(indexOf, com.mbridge.msdk.thrid.okhttp.internal.c.a(str, indexOf, str.length(), "?#"));
    }

    public List<String> d() {
        int indexOf = this.f38352i.indexOf(47, this.f38344a.length() + 3);
        String str = this.f38352i;
        int a11 = com.mbridge.msdk.thrid.okhttp.internal.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a11) {
            int i11 = indexOf + 1;
            int a12 = com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f38352i, i11, a11, '/');
            arrayList.add(this.f38352i.substring(i11, a12));
            indexOf = a12;
        }
        return arrayList;
    }

    public q e(String str) {
        a c11 = c(str);
        if (c11 != null) {
            return c11.a();
        }
        return null;
    }

    public String e() {
        if (this.f38350g == null) {
            return null;
        }
        int indexOf = this.f38352i.indexOf(63) + 1;
        String str = this.f38352i;
        return this.f38352i.substring(indexOf, com.mbridge.msdk.thrid.okhttp.internal.c.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && ((q) obj).f38352i.equals(this.f38352i);
    }

    public String f() {
        if (this.f38345b.isEmpty()) {
            return "";
        }
        int length = this.f38344a.length() + 3;
        String str = this.f38352i;
        return this.f38352i.substring(length, com.mbridge.msdk.thrid.okhttp.internal.c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f38347d;
    }

    public boolean h() {
        return this.f38344a.equals("https");
    }

    public int hashCode() {
        return this.f38352i.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f38353a = this.f38344a;
        aVar.f38354b = f();
        aVar.f38355c = b();
        aVar.f38356d = this.f38347d;
        aVar.f38357e = this.f38348e != a(this.f38344a) ? this.f38348e : -1;
        aVar.f38358f.clear();
        aVar.f38358f.addAll(d());
        aVar.a(e());
        aVar.f38360h = a();
        return aVar;
    }

    public int j() {
        return this.f38348e;
    }

    public String k() {
        if (this.f38350g == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        a(sb2, this.f38350g);
        return sb2.toString();
    }

    public String l() {
        return this.f38344a;
    }

    public URI m() {
        String aVar = i().d().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e11) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e11);
            }
        }
    }

    public String toString() {
        return this.f38352i;
    }
}
