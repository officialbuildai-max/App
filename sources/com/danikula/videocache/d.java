package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f24082d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f24083e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a, reason: collision with root package name */
    public final String f24084a;

    /* renamed from: b, reason: collision with root package name */
    public final long f24085b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f24086c;

    public d(String str) {
        long a11 = a(str);
        this.f24085b = Math.max(0L, a11);
        this.f24086c = a11 >= 0;
        this.f24084a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f24082d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String b(String str) {
        Matcher matcher = f24083e.matcher(str);
        return matcher.find() ? matcher.group(1) : str;
    }

    public static d c(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb2.toString());
            }
            sb2.append(readLine);
            sb2.append('\n');
        }
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f24085b + ", partial=" + this.f24086c + ", uri='" + this.f24084a + "'}";
    }
}
