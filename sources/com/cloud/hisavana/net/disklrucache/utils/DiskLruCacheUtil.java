package com.cloud.hisavana.net.disklrucache.utils;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.DiskCacheProvider;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.utils.StorageUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class DiskLruCacheUtil {

    /* renamed from: c, reason: collision with root package name */
    private static IDiskCache f21492c;

    /* renamed from: d, reason: collision with root package name */
    private static IDiskCache f21493d;

    /* renamed from: e, reason: collision with root package name */
    private static IDiskCache f21494e;

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f21490a = StandardCharsets.US_ASCII;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f21491b = StandardCharsets.UTF_8;

    /* renamed from: f, reason: collision with root package name */
    private static final char[] f21495f = "0123456789abcdef".toCharArray();

    /* renamed from: g, reason: collision with root package name */
    private static final char[] f21496g = new char[64];

    private DiskLruCacheUtil() {
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            int i12 = i11 * 2;
            char[] cArr2 = f21495f;
            cArr[i12] = cArr2[(b11 & 255) >>> 4];
            cArr[i12 + 1] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e11) {
                c.netLog("closeQuietly --> " + Log.getStackTraceString(e11));
            }
        }
    }

    public static void c(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                c(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    public static File d(int i11) {
        return i11 != 3 ? i11 != 4 ? StorageUtils.a(e.a()) : StorageUtils.c(e.a(), true) : StorageUtils.f(e.a(), true);
    }

    public static String e(String str, int i11) {
        File d11;
        if (TextUtils.isEmpty(str) || (d11 = d(i11)) == null) {
            return "";
        }
        return d11 + File.separator + (SafeKeyUtils.b(new ImageCacheURL(str)) + ".0");
    }

    private static IDiskCache f() {
        if (f21494e == null) {
            f21494e = new DiskCacheProvider().b(HttpRequest.f21410a.f() <= 0 ? TmcConstants.LOCAL_FILE_MAX_SIZE : r0.f() * 1024 * 1024, 4);
        }
        return f21494e;
    }

    public static synchronized IDiskCache g(int i11) {
        synchronized (DiskLruCacheUtil.class) {
            if (i11 == 3) {
                return i();
            }
            if (i11 != 4) {
                return h();
            }
            return f();
        }
    }

    private static IDiskCache h() {
        if (f21492c == null) {
            f21492c = new DiskCacheProvider().b(HttpRequest.f21410a.e() <= 0 ? 314572800L : r0.e() * 1024 * 1024, 1);
        }
        return f21492c;
    }

    private static IDiskCache i() {
        if (f21493d == null) {
            f21493d = new DiskCacheProvider().b(HttpRequest.f21410a.i() <= 0 ? 157286400L : r0.i() * 1024 * 1024, 3);
        }
        return f21493d;
    }

    public static String j(byte[] bArr) {
        String a11;
        char[] cArr = f21496g;
        synchronized (cArr) {
            a11 = a(bArr, cArr);
        }
        return a11;
    }
}
