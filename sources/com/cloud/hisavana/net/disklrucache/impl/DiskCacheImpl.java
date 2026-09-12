package com.cloud.hisavana.net.disklrucache.impl;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.disklrucache.DiskCacheWriteLocker;
import com.cloud.hisavana.net.disklrucache.DiskLruCache;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.net.disklrucache.utils.SafeKeyUtils;
import com.cloud.sdk.commonutil.util.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class DiskCacheImpl implements IDiskCache {

    /* renamed from: a, reason: collision with root package name */
    private final DiskCacheWriteLocker f21480a = new DiskCacheWriteLocker();

    /* renamed from: b, reason: collision with root package name */
    private DiskLruCache f21481b;

    /* renamed from: c, reason: collision with root package name */
    private File f21482c;

    /* renamed from: d, reason: collision with root package name */
    private final long f21483d;

    /* renamed from: e, reason: collision with root package name */
    private int f21484e;

    /* JADX INFO: Access modifiers changed from: protected */
    public DiskCacheImpl(File file, long j11, int i11) {
        this.f21482c = file;
        this.f21483d = j11;
        this.f21484e = i11;
    }

    private DiskLruCache g() {
        DiskLruCache diskLruCache = this.f21481b;
        if (diskLruCache == null) {
            synchronized (DiskCacheImpl.class) {
                try {
                    diskLruCache = this.f21481b;
                    if (diskLruCache == null) {
                        File d11 = DiskLruCacheUtil.d(this.f21484e);
                        if (Log.isLoggable("ADSDK", 3)) {
                            c.netLog(" ----- getDiskLruCache: directory = " + this.f21482c + " , cacheFile = " + d11);
                        }
                        File file = this.f21482c;
                        if (file != null) {
                            d11 = file;
                        }
                        this.f21482c = d11;
                        diskLruCache = DiskLruCache.T(d11, 1, 1, this.f21483d);
                        this.f21481b = diskLruCache;
                    }
                } finally {
                }
            }
        }
        return diskLruCache;
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public void a(ImageCacheURL imageCacheURL) {
        try {
            g().d0(SafeKeyUtils.b(imageCacheURL));
        } catch (Exception unused) {
        }
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public String b(ImageCacheURL imageCacheURL, byte[] bArr) {
        String str = "";
        this.f21480a.a(imageCacheURL);
        String b11 = SafeKeyUtils.b(imageCacheURL);
        OutputStream outputStream = null;
        try {
            try {
            } catch (IOException unused) {
                c.netLog("put: fail");
            }
            if (g().v(b11) != null) {
                return null;
            }
            DiskLruCache.Editor t11 = this.f21481b.t(b11);
            if (t11 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + b11);
            }
            try {
                outputStream = t11.g(0);
                outputStream.write(bArr);
                outputStream.flush();
                t11.f();
                this.f21481b.flush();
                str = DiskLruCacheUtil.e(imageCacheURL.c(), this.f21484e);
                if (Log.isLoggable("ADSDK", 3)) {
                    c.netLog("url :" + imageCacheURL.c() + " cacheToDisk with buff: " + str);
                }
                return str;
            } finally {
                t11.b();
            }
        } finally {
            DiskLruCacheUtil.b(null);
            this.f21480a.b(imageCacheURL);
        }
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public File c(ImageCacheURL imageCacheURL) {
        return h(imageCacheURL);
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public String d(ImageCacheURL imageCacheURL, Response response) {
        return (response == null || response.body() == null) ? "" : e(imageCacheURL, response.body().byteStream());
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public String e(ImageCacheURL imageCacheURL, InputStream inputStream) {
        String str = "";
        if (imageCacheURL == null || inputStream == null) {
            return "";
        }
        this.f21480a.a(imageCacheURL);
        String b11 = SafeKeyUtils.b(imageCacheURL);
        try {
            try {
            } catch (Exception unused) {
                c.netLog("put: fail");
                DiskLruCacheUtil.b(null);
            }
            if (g().v(b11) != null) {
                DiskLruCacheUtil.b(null);
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                this.f21480a.b(imageCacheURL);
                return null;
            }
            DiskLruCache.Editor t11 = this.f21481b.t(b11);
            if (t11 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + b11);
            }
            try {
                OutputStream g11 = t11.g(0);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    g11.write(bArr, 0, read);
                }
                g11.flush();
                t11.f();
                this.f21481b.flush();
                str = DiskLruCacheUtil.e(imageCacheURL.c(), this.f21484e);
                if (Log.isLoggable("ADSDK", 3)) {
                    c.netLog("url :" + imageCacheURL.c() + " cacheToDisk with response: " + str);
                }
                t11.b();
                DiskLruCacheUtil.b(g11);
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
                this.f21480a.b(imageCacheURL);
                return str;
            } catch (Throwable th2) {
                t11.b();
                throw th2;
            }
        } catch (Throwable th3) {
            DiskLruCacheUtil.b(null);
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            this.f21480a.b(imageCacheURL);
            throw th3;
        }
    }

    @Override // com.cloud.hisavana.net.disklrucache.impl.IDiskCache
    public boolean f(String str) {
        try {
            return g().v(SafeKeyUtils.b(new ImageCacheURL(str))) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    protected File h(ImageCacheURL imageCacheURL) {
        File d11;
        if (TextUtils.isEmpty(imageCacheURL.c()) || (d11 = DiskLruCacheUtil.d(this.f21484e)) == null) {
            return null;
        }
        String str = SafeKeyUtils.b(imageCacheURL) + ".0";
        try {
            g().v(str);
        } catch (Exception unused) {
        }
        return new File(d11 + File.separator + str);
    }
}
