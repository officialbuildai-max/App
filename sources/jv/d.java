package jv;

import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes7.dex */
public abstract class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static final String b(String str) {
        String str2;
        Intrinsics.h(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.g(bytes, "getBytes(...)");
            byte[] digest = messageDigest.digest(bytes);
            Intrinsics.e(digest);
            str2 = Result.m1185constructorimpl(ArraysKt.o0(digest, "", null, null, 0, null, new Function1() { // from class: jv.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence c11;
                    c11 = d.c(((Byte) obj).byteValue());
                    return c11;
                }
            }, 30, null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            str2 = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (!Result.m1191isFailureimpl(str2)) {
            str = str2;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence c(byte b11) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b11)}, 1));
        Intrinsics.g(format, "format(...)");
        return format;
    }
}
