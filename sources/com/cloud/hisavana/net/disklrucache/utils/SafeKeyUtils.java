package com.cloud.hisavana.net.disklrucache.utils;

import android.util.Log;
import android.util.LruCache;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.sdk.commonutil.util.c;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class SafeKeyUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache f21497a = new LruCache(1000);

    private static String a(ImageCacheURL imageCacheURL) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
            messageDigest.update(imageCacheURL.a());
            return DiskLruCacheUtil.j(messageDigest.digest());
        } catch (Exception e11) {
            c.netLog("calculateHexStringDigest: " + Log.getStackTraceString(e11));
            return "";
        }
    }

    public static String b(ImageCacheURL imageCacheURL) {
        String str;
        LruCache lruCache = f21497a;
        synchronized (lruCache) {
            str = (String) lruCache.get(imageCacheURL);
        }
        if (str == null) {
            str = a(imageCacheURL);
        }
        synchronized (lruCache) {
            lruCache.put(imageCacheURL, str);
        }
        return str;
    }
}
