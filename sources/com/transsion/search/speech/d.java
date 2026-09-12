package com.transsion.search.speech;

import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f52266a = new d();

    private d() {
    }

    public final String a(int i11) {
        StringBuffer stringBuffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuffer stringBuffer2 = new StringBuffer();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        int length = stringBuffer.length();
        for (int i12 = 0; i12 < i11; i12++) {
            stringBuffer2.append(stringBuffer.charAt(current.nextInt(length)));
        }
        String stringBuffer3 = stringBuffer2.toString();
        Intrinsics.g(stringBuffer3, "toString(...)");
        return stringBuffer3;
    }
}
