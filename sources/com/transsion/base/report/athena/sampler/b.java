package com.transsion.base.report.athena.sampler;

import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f43063a = new b();

    private b() {
    }

    public final boolean a(double d11, String deviceId, String batchKey, int i11) {
        Intrinsics.h(deviceId, "deviceId");
        Intrinsics.h(batchKey, "batchKey");
        if (d11 <= 0.0d) {
            return false;
        }
        if (d11 >= 100.0d) {
            return true;
        }
        String str = deviceId + '-' + batchKey;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        return (((digest[3] & 255) | ((((digest[0] & 255) << 24) | ((digest[1] & 255) << 16)) | ((digest[2] & 255) << 8))) & Integer.MAX_VALUE) % i11 < MathKt.c((d11 / 100.0d) * ((double) i11));
    }
}
