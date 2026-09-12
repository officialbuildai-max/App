package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.y;
import java.util.List;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final com.mbridge.msdk.thrid.okio.f f38044a = com.mbridge.msdk.thrid.okio.f.c("\"\\");

    /* renamed from: b, reason: collision with root package name */
    private static final com.mbridge.msdk.thrid.okio.f f38045b = com.mbridge.msdk.thrid.okio.f.c("\t ,=");

    public static int a(String str, int i11) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public static int a(String str, int i11, String str2) {
        while (i11 < str.length() && str2.indexOf(str.charAt(i11)) == -1) {
            i11++;
        }
        return i11;
    }

    public static long a(p pVar) {
        return a(pVar.b(HttpHeaders.CONTENT_LENGTH));
    }

    public static long a(y yVar) {
        return a(yVar.m());
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(com.mbridge.msdk.thrid.okhttp.k kVar, q qVar, p pVar) {
        if (kVar == com.mbridge.msdk.thrid.okhttp.k.f38326a) {
            return;
        }
        List<com.mbridge.msdk.thrid.okhttp.j> a11 = com.mbridge.msdk.thrid.okhttp.j.a(qVar, pVar);
        if (a11.isEmpty()) {
            return;
        }
        kVar.a(qVar, a11);
    }

    public static int b(String str, int i11) {
        char charAt;
        while (i11 < str.length() && ((charAt = str.charAt(i11)) == ' ' || charAt == '\t')) {
            i11++;
        }
        return i11;
    }

    public static boolean b(y yVar) {
        if (yVar.r().e().equals("HEAD")) {
            return false;
        }
        int k11 = yVar.k();
        return (((k11 >= 100 && k11 < 200) || k11 == 204 || k11 == 304) && a(yVar) == -1 && !"chunked".equalsIgnoreCase(yVar.b("Transfer-Encoding"))) ? false : true;
    }
}
