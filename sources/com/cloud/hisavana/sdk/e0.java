package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.data.bean.inapp.CachedAdInfos;
import com.cloud.hisavana.sdk.data.bean.inapp.DefaultAdDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f22495a = new e0();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f22496b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f22497c = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f22498a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<String> list) {
            super(1);
            this.f22498a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String it) {
            Intrinsics.h(it, "it");
            return Boolean.valueOf(!this.f22498a.contains(it));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/cloud/hisavana/sdk/data/bean/inapp/DefaultAdDTO;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/cloud/hisavana/sdk/data/bean/inapp/DefaultAdDTO;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<DefaultAdDTO, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f22499a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f22499a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(DefaultAdDTO defaultAdDTO) {
            return Boolean.valueOf(Intrinsics.c(defaultAdDTO.getAdCreativeId(), this.f22499a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/cloud/hisavana/sdk/data/bean/inapp/DefaultAdDTO;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/cloud/hisavana/sdk/data/bean/inapp/DefaultAdDTO;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<DefaultAdDTO, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f22500a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i11) {
            super(1);
            this.f22500a = i11;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(DefaultAdDTO defaultAdDTO) {
            return Boolean.valueOf(defaultAdDTO.getAdRequestVersion() >= this.f22500a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/cloud/hisavana/sdk/data/bean/inapp/DefaultAdDTO;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/cloud/hisavana/sdk/data/bean/inapp/DefaultAdDTO;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<DefaultAdDTO, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f22501a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f22502b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, int i11) {
            super(1);
            this.f22501a = str;
            this.f22502b = i11;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(DefaultAdDTO defaultAdDTO) {
            return Boolean.valueOf(Intrinsics.c(defaultAdDTO.getCodeSeatId(), this.f22501a) && defaultAdDTO.getAdRequestVersion() < this.f22502b);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t11, T t12) {
            return ComparisonsKt.d(((DefaultAdDTO) ((Pair) t12).getFirst()).getFirstPrice(), ((DefaultAdDTO) ((Pair) t11).getFirst()).getFirstPrice());
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class f<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f22503a;

        public f(Comparator comparator) {
            this.f22503a = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t11, T t12) {
            int compare = this.f22503a.compare(t11, t12);
            return compare != 0 ? compare : ComparisonsKt.d((Comparable) ((Pair) t12).getSecond(), (Comparable) ((Pair) t11).getSecond());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/cloud/hisavana/sdk/data/bean/inapp/DefaultAdDTO;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/cloud/hisavana/sdk/data/bean/inapp/DefaultAdDTO;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 9, 0})
    /* loaded from: classes3.dex */
    public static final class g extends Lambda implements Function1<DefaultAdDTO, CharSequence> {

        /* renamed from: a, reason: collision with root package name */
        public static final g f22504a = new g();

        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(DefaultAdDTO defaultAdDTO) {
            String codeSeatId = defaultAdDTO.getCodeSeatId();
            Intrinsics.g(codeSeatId, "getCodeSeatId(...)");
            return codeSeatId;
        }
    }

    private e0() {
    }

    private final void c(int i11) {
        Iterator it = f22496b.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.P((List) ((Map.Entry) it.next()).getValue(), new c(i11));
        }
        x2.f23165a.c(i11);
    }

    private final void d(DefaultAdDTO defaultAdDTO) {
        Object putIfAbsent;
        ConcurrentHashMap concurrentHashMap = f22496b;
        String codeSeatId = defaultAdDTO.getCodeSeatId();
        Object obj = concurrentHashMap.get(codeSeatId);
        if (obj == null && (putIfAbsent = concurrentHashMap.putIfAbsent(codeSeatId, (obj = new CopyOnWriteArrayList()))) != null) {
            obj = putIfAbsent;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) obj;
        Intrinsics.e(copyOnWriteArrayList);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : copyOnWriteArrayList) {
            DefaultAdDTO defaultAdDTO2 = (DefaultAdDTO) obj2;
            if (Intrinsics.c(defaultAdDTO2.getCodeSeatId(), defaultAdDTO.getCodeSeatId()) && Intrinsics.c(defaultAdDTO2.getAdCreativeId(), defaultAdDTO.getAdCreativeId())) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.isEmpty()) {
            copyOnWriteArrayList.add(defaultAdDTO);
            return;
        }
        copyOnWriteArrayList.removeAll(CollectionsKt.W0(arrayList));
        DefaultAdDTO defaultAdDTO3 = (DefaultAdDTO) CollectionsKt.i0(arrayList);
        defaultAdDTO.setDisplayedDate(defaultAdDTO3.getDisplayedDate());
        defaultAdDTO.setDisplayedTimes(defaultAdDTO3.getDisplayedTimes());
        copyOnWriteArrayList.add(defaultAdDTO);
    }

    private final void f(String str, String str2) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f22496b.get(str2);
        if (copyOnWriteArrayList != null) {
            CollectionsKt.I(copyOnWriteArrayList, new b(str));
        }
        x2.f23165a.f(str, str2);
    }

    private final void j(ConcurrentHashMap concurrentHashMap, androidx.collection.b bVar) {
        if (concurrentHashMap != null) {
            try {
                com.cloud.hisavana.sdk.common.util.g0.h(concurrentHashMap, "s_default_return_filter", GsonUtil.d(bVar));
            } catch (Throwable unused) {
            }
        }
    }

    public final CachedAdInfos a(int i11, String codeSeatId, int i12, boolean z10, int i13, ConcurrentHashMap concurrentHashMap) {
        ArrayList arrayList;
        Iterator it;
        Object obj;
        String str;
        Intrinsics.h(codeSeatId, "codeSeatId");
        String str2 = "DefaultMemoryCacheHelper";
        e4.b().d("DefaultMemoryCacheHelper", "take local default ad, code seat id is " + codeSeatId);
        b();
        c5 c5Var = new c5();
        androidx.collection.b bVar = new androidx.collection.b();
        ArrayList arrayList2 = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f22496b.get(codeSeatId);
        List U0 = copyOnWriteArrayList != null ? CollectionsKt.U0(copyOnWriteArrayList) : null;
        if (U0 == null || U0.isEmpty()) {
            bVar.add(101);
            j(concurrentHashMap, bVar);
            return new CachedAdInfos(arrayList2, c5Var.toString());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it2 = U0.iterator();
        while (true) {
            String str3 = "Success";
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            DefaultAdDTO defaultAdDTO = (DefaultAdDTO) next;
            if (defaultAdDTO.getAdType() != i11) {
                bVar.add(102);
                str3 = "adType";
            } else if (Intrinsics.c(defaultAdDTO.getCodeSeatId(), codeSeatId)) {
                String filePath = defaultAdDTO.getFilePath();
                if (filePath == null || filePath.length() == 0) {
                    bVar.add(104);
                    str3 = NativeRequestBridge.KEY_FILE_PATH;
                }
            } else {
                bVar.add(103);
                str3 = "codeSeatId";
            }
            Object obj2 = linkedHashMap.get(str3);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(str3, obj2);
            }
            ((List) obj2).add(next);
        }
        Iterator it3 = linkedHashMap.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            String str4 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!Intrinsics.c(str4, "Success")) {
                String s02 = CollectionsKt.s0(list, ", ", null, null, 0, null, g.f22504a, 30, null);
                e4.b().w("DefaultDBManager", "有 " + list.size() + " 个广告过滤失败, " + str4 + ". 广告位ID: [" + s02 + ']');
                it3 = it3;
            }
        }
        List list2 = (List) linkedHashMap.get("Success");
        if (list2 == null) {
            list2 = CollectionsKt.l();
        }
        try {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.v(list2, 10));
            Iterator it4 = list2.iterator();
            while (it4.hasNext()) {
                arrayList3.add(TuplesKt.a((DefaultAdDTO) it4.next(), Double.valueOf(Random.INSTANCE.nextDouble())));
            }
            List I0 = CollectionsKt.I0(arrayList3, new f(new e()));
            arrayList = new ArrayList(CollectionsKt.v(I0, 10));
            Iterator it5 = I0.iterator();
            while (it5.hasNext()) {
                arrayList.add((DefaultAdDTO) ((Pair) it5.next()).getFirst());
            }
        } catch (Exception e11) {
            e4.b().w("DefaultDBManager", "filter default ad error: " + e11.getMessage());
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            j(concurrentHashMap, bVar);
            return new CachedAdInfos(arrayList2, c5Var.toString());
        }
        ArrayList<Pair> arrayList4 = new ArrayList();
        String k11 = j7.a.e().k("ad_internal_black_brands", "itel,tecno,oraimo,infinix");
        String d11 = b0.f21765a.d();
        Iterator it6 = arrayList.iterator();
        int i14 = 0;
        while (it6.hasNext()) {
            DefaultAdDTO defaultAdDTO2 = (DefaultAdDTO) it6.next();
            try {
                obj = GsonUtil.a(defaultAdDTO2.getAdBeanJson(), AdsDTO.class);
                it = it6;
            } catch (Exception e12) {
                e4 b11 = e4.b();
                StringBuilder sb2 = new StringBuilder();
                it = it6;
                sb2.append("parse ad error: ");
                sb2.append(e12.getMessage());
                b11.w(str2, sb2.toString());
                obj = null;
            }
            if (obj != null) {
                if (i13 != 1 || ((AdsDTO) obj).getDefaultAdSupportNetType() == 0) {
                    b0 b0Var = b0.f21765a;
                    AdsDTO adsDTO = (AdsDTO) obj;
                    str = str2;
                    int b12 = b0Var.b(d11, defaultAdDTO2, adsDTO.getPackageName(), null);
                    if (b12 > 0) {
                        bVar.add(Integer.valueOf(b12));
                        c5Var.put(defaultAdDTO2.getAdCreativeId(), Integer.valueOf(b12));
                        if (b12 != 1102 && b12 != 1103 && b12 != 1110) {
                            arrayList4.add(new Pair(defaultAdDTO2.getAdCreativeId(), codeSeatId));
                        }
                    } else if (new File(defaultAdDTO2.getFilePath()).exists()) {
                        boolean g11 = b0Var.g(adsDTO.getCampaignname(), k11);
                        if (z10 && g11) {
                            bVar.add(107);
                            c5Var.put(defaultAdDTO2.getAdCreativeId(), 1110);
                        } else {
                            if (i14 >= i12) {
                                bVar.add(Integer.valueOf(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY));
                            } else {
                                adsDTO.setMatchVulgarBrand(g11);
                                adsDTO.setSource(4);
                                adsDTO.setUuid(com.cloud.hisavana.sdk.common.util.b.f22230a.e(adsDTO, i13));
                                PslinkInfo pslinkInfo = adsDTO.getPslinkInfo();
                                if (pslinkInfo != null) {
                                    Intrinsics.e(pslinkInfo);
                                    pslinkInfo.setShowId(adsDTO.getUuid());
                                }
                                arrayList2.add(obj);
                                i14++;
                            }
                            it6 = it;
                            str2 = str;
                        }
                    } else {
                        bVar.add(106);
                        c5Var.put(defaultAdDTO2.getAdCreativeId(), 1104);
                        if (adsDTO.isFromLocal()) {
                            arrayList4.add(new Pair(defaultAdDTO2.getAdCreativeId(), codeSeatId));
                        }
                    }
                    it6 = it;
                    str2 = str;
                } else {
                    bVar.add(105);
                    c5Var.put(defaultAdDTO2.getAdCreativeId(), 1113);
                }
            }
            str = str2;
            it6 = it;
            str2 = str;
        }
        if (!arrayList4.isEmpty()) {
            for (Pair pair : arrayList4) {
                f22495a.f((String) pair.getFirst(), (String) pair.getSecond());
            }
        }
        j(concurrentHashMap, bVar);
        return new CachedAdInfos(arrayList2, c5Var.toString());
    }

    public final void b() {
        Object putIfAbsent;
        if (f22497c.get()) {
            return;
        }
        List<g2> b11 = x2.f23165a.b();
        f22496b.clear();
        if (b11 == null || b11.isEmpty()) {
            f22497c.set(false);
            return;
        }
        for (g2 g2Var : b11) {
            DefaultAdDTO defaultAdDTO = new DefaultAdDTO();
            defaultAdDTO.setAdCreativeId(g2Var.b());
            defaultAdDTO.setCodeSeatId(g2Var.e());
            defaultAdDTO.setAdType(Integer.valueOf(g2Var.d()));
            defaultAdDTO.setFirstPrice(g2Var.o());
            defaultAdDTO.setAdRequestVersion(g2Var.c());
            defaultAdDTO.setDisplayedTimes(g2Var.l());
            defaultAdDTO.setDisplayedDate(g2Var.k());
            defaultAdDTO.setStartDate(g2Var.p());
            defaultAdDTO.setEndDate(g2Var.m());
            defaultAdDTO.setShowMaxOfDay(g2Var.j());
            defaultAdDTO.setFilePath(g2Var.n());
            defaultAdDTO.setCountryWhite(g2Var.i());
            defaultAdDTO.setCountryBlack(g2Var.h());
            defaultAdDTO.setBrandWhite(g2Var.g());
            defaultAdDTO.setBrandBlack(g2Var.f());
            defaultAdDTO.setAdBeanJson(g2Var.a());
            ConcurrentHashMap concurrentHashMap = f22496b;
            String codeSeatId = defaultAdDTO.getCodeSeatId();
            Object obj = concurrentHashMap.get(codeSeatId);
            if (obj == null && (putIfAbsent = concurrentHashMap.putIfAbsent(codeSeatId, (obj = new CopyOnWriteArrayList()))) != null) {
                obj = putIfAbsent;
            }
            ((CopyOnWriteArrayList) obj).add(defaultAdDTO);
        }
        f22497c.set(true);
    }

    public final void e(String codeSeatId) {
        Intrinsics.h(codeSeatId, "codeSeatId");
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f22496b.get(codeSeatId);
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            int adRequestVersion = ((DefaultAdDTO) it.next()).getAdRequestVersion();
            while (it.hasNext()) {
                int adRequestVersion2 = ((DefaultAdDTO) it.next()).getAdRequestVersion();
                if (adRequestVersion < adRequestVersion2) {
                    adRequestVersion = adRequestVersion2;
                }
            }
            CollectionsKt.I(copyOnWriteArrayList, new d(codeSeatId, adRequestVersion));
        }
        x2.f23165a.e(codeSeatId);
    }

    public final void g(String adCreativeId, String codeSeatId, String filepath) {
        Intrinsics.h(adCreativeId, "adCreativeId");
        Intrinsics.h(codeSeatId, "codeSeatId");
        Intrinsics.h(filepath, "filepath");
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f22496b.get(codeSeatId);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                if (Intrinsics.c(((DefaultAdDTO) obj).getAdCreativeId(), adCreativeId)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                ((DefaultAdDTO) CollectionsKt.i0(arrayList)).setFilePath(filepath);
            }
        }
        x2.f23165a.h(adCreativeId, codeSeatId, filepath);
    }

    public final void h(List codeSeatIds) {
        Intrinsics.h(codeSeatIds, "codeSeatIds");
        Set keySet = f22496b.keySet();
        Intrinsics.g(keySet, "<get-keys>(...)");
        CollectionsKt.G(keySet, new a(codeSeatIds));
        x2.f23165a.i(codeSeatIds);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x014b, code lost:
    
        r7 = r9.getAppInfo();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014f, code lost:
    
        if (r7 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0151, code lost:
    
        kotlin.jvm.internal.Intrinsics.e(r7);
        r8.setAppInfo(r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0167 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:7:0x001c, B:8:0x0025, B:10:0x002b, B:13:0x0034, B:16:0x003a, B:19:0x0041, B:28:0x0048, B:29:0x0061, B:32:0x0069, B:34:0x0072, B:38:0x007f, B:39:0x007b, B:43:0x0083, B:46:0x00da, B:48:0x00de, B:49:0x00e4, B:50:0x00ea, B:52:0x00f0, B:54:0x00fc, B:57:0x0103, B:58:0x010f, B:78:0x0125, B:67:0x014b, B:69:0x0151, B:70:0x0157, B:72:0x0167, B:73:0x016d, B:84:0x0189, B:86:0x019a, B:88:0x01a0, B:90:0x01ad, B:92:0x01b1, B:95:0x00b3, B:98:0x00be, B:99:0x00c5, B:102:0x00d4), top: B:6:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.util.List r17, java.util.List r18, boolean r19, long r20) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.e0.i(java.util.List, java.util.List, boolean, long):void");
    }

    public final DefaultAdDTO k(String str, String str2) {
        Object obj;
        if (str == null || str.length() == 0 || str2 == null) {
            return null;
        }
        if (str2.length() != 0) {
            try {
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f22496b.get(str);
                if (copyOnWriteArrayList == null) {
                    return null;
                }
                Iterator it = copyOnWriteArrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.c(((DefaultAdDTO) obj).getAdCreativeId(), str2)) {
                        break;
                    }
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return (DefaultAdDTO) obj;
    }

    public final String l(String codeSeatId) {
        Intrinsics.h(codeSeatId, "codeSeatId");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        CopyOnWriteArrayList<DefaultAdDTO> copyOnWriteArrayList = (CopyOnWriteArrayList) f22496b.get(codeSeatId);
        if (copyOnWriteArrayList != null) {
            for (DefaultAdDTO defaultAdDTO : copyOnWriteArrayList) {
                String adBeanJson = defaultAdDTO.getAdBeanJson();
                Intrinsics.g(adBeanJson, "getAdBeanJson(...)");
                if (adBeanJson.length() > 0) {
                    sb2.append(defaultAdDTO.getAdBeanJson() + ',');
                }
            }
        }
        if (sb2.length() > 1) {
            sb2.deleteCharAt(StringsKt.i0(sb2));
            sb2.append("]");
        } else {
            StringsKt.q(sb2);
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return sb3;
    }

    public final List m() {
        Enumeration keys = f22496b.keys();
        Intrinsics.g(keys, "keys(...)");
        ArrayList list = Collections.list(keys);
        Intrinsics.g(list, "list(...)");
        return CollectionsKt.U0(list);
    }

    public final void n(String filePath) {
        Intrinsics.h(filePath, "filePath");
        Iterator it = f22496b.entrySet().iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) ((Map.Entry) it.next()).getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                String filePath2 = ((DefaultAdDTO) obj).getFilePath();
                Intrinsics.g(filePath2, "getFilePath(...)");
                if (StringsKt.G(filePath2, filePath + ".0", false, 2, null)) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((DefaultAdDTO) it2.next()).setFilePath("");
            }
        }
        x2.f23165a.j(filePath);
    }

    public final void o(String adCreativeId, String codeSeatId) {
        Intrinsics.h(adCreativeId, "adCreativeId");
        Intrinsics.h(codeSeatId, "codeSeatId");
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f22496b.get(codeSeatId);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                if (Intrinsics.c(((DefaultAdDTO) obj).getAdCreativeId(), adCreativeId)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            DefaultAdDTO defaultAdDTO = (DefaultAdDTO) CollectionsKt.i0(arrayList);
            String d11 = b0.f21765a.d();
            String displayedDate = defaultAdDTO.getDisplayedDate();
            if (displayedDate == null || displayedDate.length() == 0 || Intrinsics.c(defaultAdDTO.getDisplayedDate(), d11)) {
                defaultAdDTO.setDisplayedTimes(defaultAdDTO.getDisplayedTimes() + 1);
            } else {
                defaultAdDTO.setDisplayedTimes(1);
            }
            defaultAdDTO.setDisplayedDate(d11);
            x2 x2Var = x2.f23165a;
            int displayedTimes = defaultAdDTO.getDisplayedTimes();
            String displayedDate2 = defaultAdDTO.getDisplayedDate();
            Intrinsics.g(displayedDate2, "getDisplayedDate(...)");
            x2Var.g(adCreativeId, codeSeatId, displayedTimes, displayedDate2);
        }
    }
}
