package com.squareup.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes5.dex */
public abstract class OkHeaders {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator f40489a = new Comparator<String>() { // from class: com.squareup.okhttp.internal.http.OkHeaders.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    static final String f40490b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f40491c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f40492d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f40493e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f40494f;

    static {
        String g11 = com.squareup.okhttp.internal.e.f().g();
        f40490b = g11;
        f40491c = g11 + "-Sent-Millis";
        f40492d = g11 + "-Received-Millis";
        f40493e = g11 + "-Selected-Protocol";
        f40494f = g11 + "-Response-Source";
    }

    public static void a(Request.Builder builder, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if ("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) {
                if (!((List) entry.getValue()).isEmpty()) {
                    builder.addHeader(str, b((List) entry.getValue()));
                }
            }
        }
    }

    private static String b(List list) {
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                sb2.append("; ");
            }
            sb2.append((String) list.get(i11));
        }
        return sb2.toString();
    }

    public static long c(Headers headers) {
        return k(headers.get(HttpHeaders.CONTENT_LENGTH));
    }

    public static long d(Request request) {
        return c(request.headers());
    }

    public static long e(Response response) {
        return c(response.headers());
    }

    public static boolean f(Headers headers) {
        return m(headers).contains("*");
    }

    public static boolean g(Response response) {
        return f(response.headers());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static List i(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (str.equalsIgnoreCase(headers.name(i11))) {
                String value = headers.value(i11);
                int i12 = 0;
                while (i12 < value.length()) {
                    int b11 = c.b(value, i12, " ");
                    String trim = value.substring(i12, b11).trim();
                    int c11 = c.c(value, b11);
                    if (!value.regionMatches(true, c11, "realm=\"", 0, 7)) {
                        break;
                    }
                    int i13 = c11 + 7;
                    int b12 = c.b(value, i13, "\"");
                    String substring = value.substring(i13, b12);
                    i12 = c.c(value, c.b(value, b12 + 1, ",") + 1);
                    arrayList.add(new Challenge(trim, substring));
                }
            }
        }
        return arrayList;
    }

    public static Request j(Authenticator authenticator, Response response, Proxy proxy) {
        return response.code() == 407 ? authenticator.authenticateProxy(proxy, response) : authenticator.authenticate(proxy, response);
    }

    private static long k(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Map l(Headers headers, String str) {
        TreeMap treeMap = new TreeMap(f40489a);
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String name = headers.name(i11);
            String value = headers.value(i11);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(name);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(value);
            treeMap.put(name, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static Set m(Headers headers) {
        Set emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            if ("Vary".equalsIgnoreCase(headers.name(i11))) {
                String value = headers.value(i11);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : value.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    private static Set n(Response response) {
        return m(response.headers());
    }

    public static Headers o(Headers headers, Headers headers2) {
        Set m11 = m(headers2);
        if (m11.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String name = headers.name(i11);
            if (m11.contains(name)) {
                builder.add(name, headers.value(i11));
            }
        }
        return builder.build();
    }

    public static Headers p(Response response) {
        return o(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean q(Response response, Headers headers, Request request) {
        for (String str : n(response)) {
            if (!com.squareup.okhttp.internal.g.h(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }
}
