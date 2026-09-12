package com.squareup.okhttp.internal.http;

/* loaded from: classes5.dex */
public abstract class c {
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

    public static int b(String str, int i11, String str2) {
        while (i11 < str.length() && str2.indexOf(str.charAt(i11)) == -1) {
            i11++;
        }
        return i11;
    }

    public static int c(String str, int i11) {
        char charAt;
        while (i11 < str.length() && ((charAt = str.charAt(i11)) == ' ' || charAt == '\t')) {
            i11++;
        }
        return i11;
    }
}
