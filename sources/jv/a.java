package jv;

import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class a {
    public static final String a(String str) {
        Intrinsics.h(str, "<this>");
        String decode = URLDecoder.decode(str, "UTF-8");
        Intrinsics.g(decode, "decode(...)");
        return decode;
    }

    public static final String b(String str) {
        Intrinsics.h(str, "<this>");
        String encode = URLEncoder.encode(str, "UTF-8");
        Intrinsics.g(encode, "encode(...)");
        return encode;
    }
}
