package com.mbridge.msdk.foundation.tools;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

/* loaded from: classes5.dex */
class a1 {

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final char[] f35736a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        /* renamed from: b, reason: collision with root package name */
        static final SecureRandom f35737b = new SecureRandom();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", null);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), null)).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i11) {
        int length = (iArr.length >> 1) - 1;
        int i12 = 0;
        while (i12 <= length) {
            int i13 = (i12 + length) >>> 1;
            int i14 = iArr[i13 << 1];
            if (i14 < i11) {
                i12 = i13 + 1;
            } else {
                if (i14 <= i11) {
                    return i13;
                }
                length = i13 - 1;
            }
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) {
        try {
            if (file.exists()) {
                b(file);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file, byte[] bArr, int i11) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i12 = 0;
        while (i12 < i11) {
            try {
                int read = randomAccessFile.read(bArr, i12, i11 - i12);
                if (read < 0) {
                    break;
                } else {
                    i12 += read;
                }
            } finally {
                a(randomAccessFile);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(File file, byte[] bArr) {
        File file2;
        try {
            file2 = new File(file.getParent(), file.getName() + ".tmp");
        } catch (Exception unused) {
        }
        if (!d(file2)) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            randomAccessFile.setLength(bArr.length);
            randomAccessFile.write(bArr);
            a(randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        } catch (Throwable th2) {
            a(randomAccessFile);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        byte[] bArr = new byte[16];
        a.f35737b.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i11 = 0; i11 < 16; i11++) {
            byte b11 = bArr[i11];
            int i12 = i11 << 1;
            char[] cArr2 = a.f35736a;
            cArr[i12] = cArr2[(b11 >> 4) & 15];
            cArr[i12 + 1] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    private static void b(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                b(file2);
            }
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(File file) throws IOException {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) == 0) {
            int i11 = (int) length;
            byte[] bArr = new byte[i11];
            a(file, bArr, i11);
            return bArr;
        }
        throw new IllegalArgumentException("file too large, path:" + file.getPath());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(File file) throws IOException {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        return parentFile != null && (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
    }
}
