package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.InputStream;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static char[] f20841a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String a(byte[] bArr, int i11) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i11 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i12 = i11 << 1;
        char[] cArr = new char[i12];
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            byte b11 = bArr[i14];
            int i15 = i13 + 1;
            char[] cArr2 = f20841a;
            cArr[i13] = cArr2[(b11 & 255) >> 4];
            i13 += 2;
            cArr[i15] = cArr2[b11 & 15];
        }
        return new String(cArr, 0, i12);
    }

    public static void a(InputStream inputStream, String str) throws Exception {
        if (str == null) {
            throw new RuntimeException("md5 check failed: md5 == null");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        } else {
                            messageDigest.update(bArr, 0, read);
                        }
                    }
                    try {
                        byte[] digest = messageDigest.digest();
                        String a11 = a(digest, digest.length);
                        if (str.equals(a11)) {
                            return;
                        }
                        throw new RuntimeException("md5 check failed file: local md5:" + a11 + " expect md5:" + str);
                    } catch (Exception e11) {
                        throw new RuntimeException("md5 check failed:" + e11.getMessage(), e11);
                    }
                } catch (Exception e12) {
                    throw new RuntimeException("md5 check failed:" + e12.getMessage(), e12);
                }
            } finally {
                CloseableUtils.close(inputStream);
            }
        } catch (Exception e13) {
            throw new RuntimeException("md5 check failed:" + e13.getMessage(), e13);
        }
    }
}
