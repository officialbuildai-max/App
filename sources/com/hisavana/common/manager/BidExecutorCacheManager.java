package com.hisavana.common.manager;

import com.hisavana.common.base.BaseAd;
import com.hisavana.common.utils.AdLogUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class BidExecutorCacheManager {
    private static final String TAG = "InmobiBidCacheManager";
    private static BidExecutorCacheManager sInstance;
    private final Map<String, BaseAd> bidCache = new HashMap();

    public static synchronized BidExecutorCacheManager getInstance() {
        BidExecutorCacheManager bidExecutorCacheManager;
        synchronized (BidExecutorCacheManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new BidExecutorCacheManager();
                }
                bidExecutorCacheManager = sInstance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bidExecutorCacheManager;
    }

    public BaseAd removeData(String str) {
        AdLogUtil.Log().d(TAG, "removeBidData " + str);
        return this.bidCache.remove(str);
    }

    public void saveBidData(String str, BaseAd baseAd) {
        this.bidCache.put(str, baseAd);
    }
}
