package com.cloud.h5update.utils;

import com.cloud.h5update.utils.h;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f21385a = new i();

    private i() {
    }

    private final String a(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.g(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            sb2.append(charArray[(b11 >> 4) & 15]);
            sb2.append(charArray[b11 & 15]);
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "r.toString()");
        return sb3;
    }

    public final String b(File file) {
        h.a aVar = h.f21378a;
        String str = "";
        if (!aVar.r(file)) {
            return "";
        }
        InputStream inputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                inputStream = aVar.n(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    Intrinsics.e(inputStream);
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                byte[] digest = messageDigest.digest();
                Intrinsics.g(digest, "digest.digest()");
                str = a(digest);
                h.f21378a.e(inputStream);
            } catch (Exception e11) {
                gg.b.f63690a.e(e11);
                h.f21378a.e(inputStream);
            }
            return str;
        } catch (Throwable th2) {
            h.f21378a.e(inputStream);
            throw th2;
        }
    }
}
