package com.hisavana.common.bean;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.utils.AdLogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class AdCache<T extends ICacheAd> {
    private static final int CODE_SEAT_LIMIT_30 = 30;
    private static final int CODE_SEAT_LIMIT_FIVE = 5;
    private static final int CODE_SEAT_LIMIT_TEN = 10;
    private static final String TAG = "AdCache";
    private static final AdCacheComp mComparator = new AdCacheComp();
    private final ConcurrentHashMap<String, Integer> lastExpireReasonMap = new ConcurrentHashMap<>();
    final ConcurrentHashMap<String, CopyOnWriteArrayList<T>> map = new ConcurrentHashMap<>();
    private AdCacheExpiredWatcher watcher;

    /* loaded from: classes4.dex */
    public static class AdCacheComp implements Comparator<ICacheAd> {
        @Override // java.util.Comparator
        public int compare(ICacheAd iCacheAd, ICacheAd iCacheAd2) {
            try {
                if (iCacheAd.isExpired() && !iCacheAd2.isExpired()) {
                    return 1;
                }
                if (!iCacheAd.isExpired() && iCacheAd2.isExpired()) {
                    return -1;
                }
                if (iCacheAd.getEcpmPrice() != iCacheAd2.getEcpmPrice()) {
                    return iCacheAd.getEcpmPrice() > iCacheAd2.getEcpmPrice() ? -1 : 1;
                }
                if (iCacheAd.getValidTimeLimit() - iCacheAd2.getValidTimeLimit() < 0) {
                    return -1;
                }
                return iCacheAd.getValidTimeLimit() - iCacheAd2.getValidTimeLimit() > 0 ? 1 : 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface AdCacheExpiredWatcher {
        void onExpired(ICacheAd iCacheAd);
    }

    private int getCodeSeatLimit(T t11) {
        return (t11 != null && t11.isIconAd()) ? 30 : 5;
    }

    private double getMaxPrice(String str, T t11, boolean z10) {
        if (str == null) {
            return 0.0d;
        }
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0.0d;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (z10 && next.isMatchVulgarBrand()) {
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else {
                    if (t11 == null || t11 != next) {
                        AdLogUtil.Log().d(TAG, "*----> max ad in pool is :" + next.getPlacementId() + ",EcpmPrice is :" + next.getEcpmPrice() + ",AdSource is :" + next.getAdSource() + ",ValidTimeLimit :" + next.getValidTimeLimit());
                        return next.getEcpmPrice();
                    }
                    AdLogUtil.Log().d("ssp_second_price", "*----> getMaxPrice updateSecondPrice()，excludeAd == iteratorAd");
                }
            }
            return 0.0d;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return 0.0d;
        }
    }

    private CopyOnWriteArrayList<T> getOrCreateList(String str) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList != null) {
            return copyOnWriteArrayList;
        }
        CopyOnWriteArrayList<T> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        this.map.put(str, copyOnWriteArrayList2);
        return copyOnWriteArrayList2;
    }

    private T getSupportAd(String str, int i11, boolean z10) {
        AdLogUtil.Log().d(TAG, "getSupportAd " + str + " hisavanaAdSupportFlag " + i11);
        ArrayList<T> caches = getCaches(str, Integer.MAX_VALUE, false, z10);
        if (caches == null) {
            return null;
        }
        Iterator<T> it = caches.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next != null && isAdConformSupportFlag(next, i11)) {
                return next;
            }
        }
        return null;
    }

    private boolean isAdConformSupportFlag(T t11, int i11) {
        if (t11.isOfflineAd()) {
            return false;
        }
        if (i11 == 1) {
            return t11.isAdxAd();
        }
        if (i11 == 2) {
            return t11.isEwAd();
        }
        if (i11 != 3) {
            return false;
        }
        return t11.isAdxAd() || t11.isEwAd();
    }

    private static <T extends ICacheAd> boolean isLowPrice(T t11) {
        return t11.getNetwork() != null && t11.getNetwork().getBiddingType().intValue() == 1 && t11.getNetwork().getPrice().doubleValue() < ((double) t11.getNetwork().getMinPrice().intValue());
    }

    private boolean removeAd(CopyOnWriteArrayList<T> copyOnWriteArrayList, T t11, boolean z10) {
        if (z10) {
            AdLogUtil.Log().d(TAG, "---> Remove ad:" + t11.getPlacementId() + " from cache");
            copyOnWriteArrayList.remove(t11);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
            }
        }
        if (!t11.isExpired()) {
            return false;
        }
        if (!z10) {
            copyOnWriteArrayList.remove(t11);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
            }
        }
        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
        if (adCacheExpiredWatcher != null) {
            adCacheExpiredWatcher.onExpired(t11);
        }
        t11.destroyAd();
        return true;
    }

    public void addCache(String str, @NonNull T t11) {
        String str2;
        if (t11 != null) {
            if (LogSwitch.isDebug) {
                str2 = "add Cache list,AdSource is :" + t11.getAdSource();
            } else {
                str2 = null;
            }
            RecordTestInfo.record(str2);
            t11.detachContext();
        }
        CopyOnWriteArrayList<T> orCreateList = getOrCreateList(str);
        if (orCreateList.size() > getCodeSeatLimit(t11)) {
            orCreateList.remove(orCreateList.size() - 1);
        }
        try {
            ArrayList arrayList = new ArrayList(orCreateList);
            int binarySearch = Collections.binarySearch(arrayList, t11, mComparator);
            if (binarySearch < 0) {
                binarySearch = -(binarySearch + 1);
            }
            arrayList.add(binarySearch, t11);
            orCreateList.clear();
            orCreateList.addAll(arrayList);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("add cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
                RecordTestInfo.record("add Cache list is :" + arrayList.size());
            }
            AdLogUtil.Log().d(TAG, "*----> add Caches list is :" + arrayList.size());
        } catch (Exception e11) {
            AdLogUtil.Log().d(TAG, Log.getStackTraceString(e11));
        }
    }

    public void addCaches(String str, List<T> list) {
        for (T t11 : list) {
            if (t11 != null) {
                if (LogSwitch.isDebug) {
                    RecordTestInfo.record("add Caches list,EcpmPrice is :" + t11.getEcpmPrice());
                }
                t11.detachContext();
            }
        }
        CopyOnWriteArrayList<T> orCreateList = getOrCreateList(str);
        if (list.size() == 0 || orCreateList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(orCreateList);
        int size = (list.size() + arrayList.size()) - getCodeSeatLimit(list.get(0));
        arrayList.addAll(list);
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                int size2 = arrayList.size();
                if (size2 > 0) {
                    arrayList.remove(size2 - 1);
                } else {
                    AdLogUtil.Log().e(TAG, "addCaches,index out of bounds");
                }
            }
        }
        try {
            Collections.sort(arrayList, mComparator);
            orCreateList.clear();
            orCreateList.addAll(arrayList);
            AdLogUtil.Log().d(TAG, "*----> add Caches list is :" + arrayList.size());
            if (LogSwitch.isDebug) {
                RecordTestInfo.record("add Caches list is :" + arrayList.size());
                RecordTestInfo.LogMsg("add caches:" + RecordTestInfo.getLogMsg(list), RecordTestInfo.LOG_CODE10);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0108 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x0015, B:10:0x0019, B:11:0x0022, B:13:0x0028, B:15:0x006f, B:16:0x007a, B:17:0x007f, B:19:0x0085, B:22:0x008e, B:24:0x0095, B:26:0x0099, B:27:0x009c, B:30:0x0108, B:34:0x0110, B:38:0x00bd, B:40:0x00c3, B:41:0x00e1, B:43:0x00e7, B:50:0x012e), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0110 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int checkCacheStatus(java.lang.String r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisavana.common.bean.AdCache.checkCacheStatus(java.lang.String, boolean):int");
    }

    public void clearLastExpireReason(String str) {
        try {
            this.lastExpireReasonMap.remove(str);
        } catch (Exception unused) {
        }
    }

    public ICacheAd getAdBySourceAndUnitID(String str, int i11, boolean z10) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList;
        try {
            copyOnWriteArrayList = this.map.get(str);
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
        }
        if (copyOnWriteArrayList == null) {
            return null;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next.isExpired()) {
                AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                if (adCacheExpiredWatcher != null) {
                    adCacheExpiredWatcher.onExpired(next);
                }
                next.destroyAd();
                copyOnWriteArrayList.remove(next);
            } else if (!z10 || !next.isMatchVulgarBrand()) {
                if (next.getAdSource() == i11 && TextUtils.equals(next.getPlacementId(), str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public int getAdNum(String str) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else {
                    i11++;
                    AdLogUtil.Log().d(TAG, "*----> ad in pool is :" + next.getPlacementId() + ",EcpmPrice is :" + next.getEcpmPrice() + ",AdSource is :" + next.getAdSource() + ",ValidTimeLimit :" + next.getValidTimeLimit());
                }
            }
            return i11;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return 0;
        }
    }

    public int getAdNum(String str, int i11, String str2, boolean z10) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (z10 && next.isMatchVulgarBrand()) {
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (next.getAdSource() == i11 && TextUtils.equals(next.getPlacementId(), str2)) {
                    i12++;
                }
            }
            return i12;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return 0;
        }
    }

    public T getCache(String str, boolean z10, int i11, boolean z11) {
        ArrayList<T> caches;
        T supportAd = getSupportAd(str, i11, z11);
        return (supportAd != null || (caches = getCaches(str, 1, z10, z11)) == null || caches.isEmpty()) ? supportAd : caches.get(0);
    }

    public ArrayList<T> getCaches(@NonNull String str, int i11, boolean z10, int i12, boolean z11) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            ArrayList<T> arrayList = new ArrayList<>();
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                if (LogSwitch.isDebug) {
                    Iterator<T> it2 = copyOnWriteArrayList.iterator();
                    AdLogUtil.Log().d(TAG, "current ad pool size is :" + copyOnWriteArrayList.size());
                    while (it2.hasNext()) {
                        T next = it2.next();
                        AdLogUtil.Log().d(TAG, "ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice() + " isAdx " + next.isAdxAd() + " isEw " + next.isEwAd());
                    }
                }
                while (it.hasNext()) {
                    T next2 = it.next();
                    if (next2 != null) {
                        if (z11 && next2.isMatchVulgarBrand()) {
                            copyOnWriteArrayList.remove(next2);
                            if (LogSwitch.isDebug) {
                                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(next2), RecordTestInfo.LOG_CODE10);
                            }
                            next2.destroyAd();
                        } else {
                            if (isAdConformSupportFlag(next2, i12) && !removeAd(copyOnWriteArrayList, next2, z10)) {
                                arrayList.add(next2);
                            }
                            if (arrayList.size() >= i11) {
                                return arrayList;
                            }
                        }
                    }
                }
                if (arrayList.size() < i11) {
                    arrayList.addAll(getCaches(str, i11 - arrayList.size(), z10, z11));
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return null;
        }
    }

    public ArrayList<T> getCaches(@NonNull String str, int i11, boolean z10, boolean z11) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return new ArrayList<>();
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            if (LogSwitch.isDebug) {
                Iterator<T> it2 = copyOnWriteArrayList.iterator();
                AdLogUtil.Log().d(TAG, "*----> current ad pool size is :" + copyOnWriteArrayList.size());
                while (it2.hasNext()) {
                    T next = it2.next();
                    AdLogUtil.Log().d(TAG, "---> ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice() + " source " + next.getAdSource());
                }
            }
            ArrayList<T> arrayList = null;
            while (it.hasNext()) {
                T next2 = it.next();
                if (next2 != null) {
                    if (z10) {
                        copyOnWriteArrayList.remove(next2);
                        if (LogSwitch.isDebug) {
                            RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(next2), RecordTestInfo.LOG_CODE10);
                        }
                    }
                    if (next2.isExpired()) {
                        if (!z10) {
                            copyOnWriteArrayList.remove(next2);
                            if (LogSwitch.isDebug) {
                                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(next2), RecordTestInfo.LOG_CODE10);
                            }
                        }
                        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                        if (adCacheExpiredWatcher != null) {
                            adCacheExpiredWatcher.onExpired(next2);
                        }
                        next2.destroyAd();
                    } else if (z11 && next2.isMatchVulgarBrand()) {
                        if (!z10) {
                            copyOnWriteArrayList.remove(next2);
                            if (LogSwitch.isDebug) {
                                RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(next2), RecordTestInfo.LOG_CODE10);
                            }
                        }
                        next2.destroyAd();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(next2);
                        if (arrayList.size() >= i11) {
                            break;
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return null;
        }
    }

    public ArrayList<T> getCaches(@NonNull String str, int i11, boolean z10, boolean z11, int i12, boolean z12) {
        try {
            if (!z11) {
                return getCaches(str, i11, z10, i12, z12);
            }
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return null;
            }
            int i13 = i12 > 0 ? 0 : -1;
            if (LogSwitch.isDebug) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                AdLogUtil.Log().d(TAG, "*----> current ad pool size is :" + copyOnWriteArrayList.size());
                while (it.hasNext()) {
                    T next = it.next();
                    AdLogUtil.Log().d(TAG, "---> ad: " + next.getPlacementId() + "，price：" + next.getEcpmPrice());
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = copyOnWriteArrayList.iterator();
            ArrayList<T> arrayList2 = null;
            while (it2.hasNext()) {
                T next2 = it2.next();
                if (next2 != null) {
                    if (next2.isExpired()) {
                        copyOnWriteArrayList.remove(next2);
                        AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                        if (adCacheExpiredWatcher != null) {
                            adCacheExpiredWatcher.onExpired(next2);
                        }
                        next2.destroyAd();
                    } else if (z12 && next2.isMatchVulgarBrand()) {
                        copyOnWriteArrayList.remove(next2);
                        next2.destroyAd();
                        AdLogUtil.Log().d(TAG, "current ad filter by vulgar content");
                    } else if (i13 == -1 || i13 == next2.getAdSource()) {
                        if (i13 == -1) {
                            i13 = next2.getAdSource();
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                        }
                        if (!TextUtils.isEmpty(next2.getFilterSource())) {
                            AdLogUtil.Log().d(TAG, "current filter ------->" + next2.getFilterSource());
                            if (!arrayList.contains(next2.getFilterSource())) {
                                arrayList.add(next2.getFilterSource());
                            }
                        }
                        if (z10) {
                            AdLogUtil.Log().d(TAG, "---> Remove ad:" + next2.getPlacementId() + " from cache");
                            copyOnWriteArrayList.remove(next2);
                        }
                        arrayList2.add(next2);
                        if (arrayList2.size() >= i11) {
                            break;
                        }
                    }
                }
            }
            return (i12 <= 0 || !(arrayList2 == null || arrayList2.isEmpty())) ? arrayList2 : getCaches(str, i11, z10, 0, z12);
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return null;
        }
    }

    public int getLastExpireReason(String str) {
        try {
            Integer num = this.lastExpireReasonMap.get(str);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public double getMaxPrice(String str, boolean z10) {
        return getMaxPrice(str, null, z10);
    }

    public double getNetworkPrice(String str, int i11, String str2) {
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return 0.0d;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (next.isExpired()) {
                    AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                    if (adCacheExpiredWatcher != null) {
                        adCacheExpiredWatcher.onExpired(next);
                    }
                    next.destroyAd();
                    copyOnWriteArrayList.remove(next);
                } else if (next.getAdSource() == i11 && TextUtils.equals(next.getPlacementId(), str2)) {
                    return next.getEcpmPrice();
                }
            }
            return 0.0d;
        } catch (Throwable th2) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
            return 0.0d;
        }
    }

    public int[] getValidAndInvalidAdNum(String str) {
        int[] iArr = {0, 0};
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null) {
            return iArr;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            if (it.next().isExpired()) {
                i12++;
            } else {
                i11++;
            }
        }
        iArr[0] = i11;
        iArr[1] = i12;
        return iArr;
    }

    public boolean hasAd(String str, T t11) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        return copyOnWriteArrayList.contains(t11);
    }

    public boolean hasAds(String str, boolean z10) {
        clearLastExpireReason(str);
        try {
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
            if (copyOnWriteArrayList == null) {
                return false;
            }
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                if (next != null) {
                    try {
                        if (next.isExpired()) {
                            try {
                                int expireReason = next.getExpireReason();
                                if (expireReason != 0 && getLastExpireReason(str) == 0) {
                                    this.lastExpireReasonMap.put(str, Integer.valueOf(expireReason));
                                }
                            } catch (Throwable unused) {
                            }
                            AdCacheExpiredWatcher adCacheExpiredWatcher = this.watcher;
                            if (adCacheExpiredWatcher != null) {
                                adCacheExpiredWatcher.onExpired(next);
                            }
                            next.destroyAd();
                            copyOnWriteArrayList.remove(next);
                        } else if (!z10 || !next.isMatchVulgarBrand()) {
                            clearLastExpireReason(str);
                            return true;
                        }
                    } catch (Throwable th2) {
                        AdLogUtil.Log().e(TAG, Log.getStackTraceString(th2));
                        copyOnWriteArrayList.remove(next);
                    }
                }
            }
            return false;
        } catch (Throwable th3) {
            AdLogUtil.Log().e(TAG, Log.getStackTraceString(th3));
            return false;
        }
    }

    public void registerWatcher(AdCacheExpiredWatcher adCacheExpiredWatcher) {
        this.watcher = adCacheExpiredWatcher;
    }

    public void removeAll() {
        this.map.clear();
    }

    public void removeCache(String str, T t11) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        copyOnWriteArrayList.remove(t11);
        AdLogUtil.Log().d(TAG, "---> Remove ad:" + t11.getPlacementId() + " from cache");
        if (LogSwitch.isDebug) {
            RecordTestInfo.LogMsg("remove cache:" + RecordTestInfo.getLogMsg(t11), RecordTestInfo.LOG_CODE10);
        }
    }

    public void removeCodeSeatCache(String str) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.map.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            AdLogUtil.Log().d(TAG, "---> clear codeSeat cache : " + str);
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("clear codeSeat cache:" + RecordTestInfo.getLogMsg(copyOnWriteArrayList), RecordTestInfo.LOG_CODE10);
            }
        }
    }

    public void unRegisterWatcher() {
        this.watcher = null;
    }
}
