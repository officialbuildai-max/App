package com.transsion.mbtools;

import android.os.Build;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class MD5HashProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final MD5HashProvider f46278a = new MD5HashProvider();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f46279b = LazyKt.b(new Function0<String>() { // from class: com.transsion.mbtools.MD5HashProvider$SYSTEM_SALT$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String ID = Build.ID;
            Intrinsics.g(ID, "ID");
            String substring = ID.substring(0, 4);
            Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.g(MANUFACTURER, "MANUFACTURER");
            return substring + StringsKt.u1(MANUFACTURER);
        }
    });

    private MD5HashProvider() {
    }

    private final String b() {
        return (String) f46279b.getValue();
    }

    public final String a(String content) {
        Intrinsics.h(content, "content");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = (b() + content).getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] hashBytes = messageDigest.digest(bytes);
        StringBuilder sb2 = new StringBuilder();
        Intrinsics.g(hashBytes, "hashBytes");
        for (byte b11 : hashBytes) {
            sb2.append(CharsKt.f((b11 & 255) >> 4, 16));
            sb2.append(CharsKt.f(b11 & 15, 16));
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
