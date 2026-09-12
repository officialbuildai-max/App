package com.transsion.ad.bidding.icon;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.mediation.ad.TNativeAd;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class BiddingIconAdManager extends di.a {

    /* renamed from: s, reason: collision with root package name */
    public static final Companion f41991s = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    private String f41995g;

    /* renamed from: h, reason: collision with root package name */
    private di.a f41996h;

    /* renamed from: i, reason: collision with root package name */
    private int f41997i;

    /* renamed from: k, reason: collision with root package name */
    private AdPlans f41999k;

    /* renamed from: l, reason: collision with root package name */
    private AdPlans f42000l;

    /* renamed from: o, reason: collision with root package name */
    private BiddingHiSavanaIconAdManager f42003o;

    /* renamed from: p, reason: collision with root package name */
    private f f42004p;

    /* renamed from: d, reason: collision with root package name */
    private List f41992d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private List f41993e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List f41994f = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private AtomicBoolean f41998j = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f42001m = LazyKt.b(new Function0() { // from class: com.transsion.ad.bidding.icon.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Handler T;
            T = BiddingIconAdManager.T();
            return T;
        }
    });

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f42002n = new Runnable() { // from class: com.transsion.ad.bidding.icon.c
        @Override // java.lang.Runnable
        public final void run() {
            BiddingIconAdManager.H(BiddingIconAdManager.this);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private final Set f42005q = new LinkedHashSet();

    /* renamed from: r, reason: collision with root package name */
    private String f42006r = "";

    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, String str, Map map, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                map = null;
            }
            companion.a(str, map);
        }

        public final void a(String sceneId, Map map) {
            Intrinsics.h(sceneId, "sceneId");
            k.d(o0.a(y0.b()), null, null, new BiddingIconAdManager$Companion$preLoadAd$1(sceneId, map, null), 3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b A[Catch: all -> 0x0034, LOOP:0: B:16:0x0065->B:18:0x006b, LOOP_END, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ee A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fe A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010a A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0116 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0177 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0187 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018e A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019a A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ac A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e5 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0019, B:9:0x002b, B:15:0x0053, B:16:0x0065, B:18:0x006b, B:20:0x007d, B:23:0x00cb, B:27:0x00db, B:29:0x00e1, B:31:0x00e8, B:33:0x00ee, B:34:0x00f8, B:36:0x00fe, B:37:0x0104, B:39:0x010a, B:40:0x0110, B:42:0x0116, B:43:0x011f, B:45:0x0177, B:46:0x0183, B:48:0x0187, B:49:0x018a, B:51:0x018e, B:52:0x0194, B:54:0x019a, B:56:0x019e, B:57:0x01c0, B:60:0x01ac, B:62:0x01b0, B:63:0x01b3, B:66:0x01bb, B:71:0x00e5, B:73:0x0088, B:75:0x0094, B:77:0x009c, B:78:0x00a2, B:82:0x0048, B:84:0x004f, B:85:0x003b, B:87:0x0042), top: B:6:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void F(java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.icon.BiddingIconAdManager.F(java.lang.String):void");
    }

    private final List G(final boolean z10) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f41992d.iterator();
        while (it.hasNext()) {
            arrayList.add(J((TAdNativeInfo) it.next()));
        }
        Iterator it2 = this.f41993e.iterator();
        while (it2.hasNext()) {
            arrayList.add(N((RecommendInfo) it2.next()));
        }
        final Comparator comparator = new Comparator() { // from class: com.transsion.ad.bidding.icon.BiddingIconAdManager$combineAndRetrieveData$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(Double.valueOf(((BiddingWrapperIconBean) t12).getEcpm()), Double.valueOf(((BiddingWrapperIconBean) t11).getEcpm()));
            }
        };
        CollectionsKt.A(arrayList, new Comparator() { // from class: com.transsion.ad.bidding.icon.BiddingIconAdManager$combineAndRetrieveData$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                int compare = comparator.compare(t11, t12);
                if (compare != 0) {
                    return compare;
                }
                boolean z11 = z10;
                int type = ((BiddingWrapperIconBean) t11).getType();
                if (!z11) {
                    type = -type;
                }
                Integer valueOf = Integer.valueOf(type);
                boolean z12 = z10;
                int type2 = ((BiddingWrapperIconBean) t12).getType();
                if (!z12) {
                    type2 = -type2;
                }
                return ComparisonsKt.d(valueOf, Integer.valueOf(type2));
            }
        });
        this.f41992d.clear();
        this.f41993e.clear();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(BiddingIconAdManager biddingIconAdManager) {
        biddingIconAdManager.F("竞价时间到");
    }

    private final BiddingWrapperIconBean J(TAdNativeInfo tAdNativeInfo) {
        return new BiddingWrapperIconBean(2, null, tAdNativeInfo, tAdNativeInfo.getEcpmPrice(), false, 16, null);
    }

    private final Handler L() {
        return (Handler) this.f42001m.getValue();
    }

    private final BiddingWrapperIconBean N(RecommendInfo recommendInfo) {
        Double bidEcpmCent;
        AdPlans adPlans = this.f42000l;
        return new BiddingWrapperIconBean(1, recommendInfo, null, (adPlans == null || (bidEcpmCent = adPlans.getBidEcpmCent()) == null) ? 0.0d : bidEcpmCent.doubleValue(), false, 16, null);
    }

    private final String O() {
        return this.f42006r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P(java.lang.String r18, boolean r19, java.util.List r20, kotlin.coroutines.Continuation r21) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.icon.BiddingIconAdManager.P(java.lang.String, boolean, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean Q() {
        String str;
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b(getSceneId());
        if (b11 == null || (jsonElement = b11.get(TrackingKey.PRIORITY)) == null || (str = jsonElement.getAsString()) == null) {
            str = "hi";
        }
        return TextUtils.equals(str, "hi");
    }

    public static /* synthetic */ Object S(BiddingIconAdManager biddingIconAdManager, String str, boolean z10, int i11, di.a aVar, Map map, Continuation continuation, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            map = null;
        }
        return biddingIconAdManager.R(str, z10, i11, aVar, map, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler T() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(di.a aVar, String str) {
        oi.a.i(oi.a.f71145a, str, 6, false, 4, null);
        if (aVar != null) {
            aVar.i(new TAdErrorCode(1101, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(BiddingIconAdManager biddingIconAdManager) {
        biddingIconAdManager.F("数据都回来了 --> onHiIconAdReady");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(BiddingIconAdManager biddingIconAdManager) {
        biddingIconAdManager.F("数据都回来了 --> onPSDistributionReady");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = BiddingIconAdManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void E(BiddingWrapperIconView iconView) {
        Intrinsics.h(iconView, "iconView");
        this.f42005q.add(iconView);
    }

    public final void I() {
        L().removeCallbacksAndMessages(null);
        this.f41996h = null;
        this.f41992d.clear();
        this.f41993e.clear();
        f fVar = this.f42004p;
        if (fVar != null) {
            fVar.x();
        }
        Iterator it = this.f42005q.iterator();
        while (it.hasNext()) {
            ((BiddingWrapperIconView) it.next()).destroy();
        }
        List list = this.f41994f;
        if (list != null) {
            list.clear();
        }
        BiddingHiSavanaIconAdManager biddingHiSavanaIconAdManager = this.f42003o;
        if (biddingHiSavanaIconAdManager != null) {
            biddingHiSavanaIconAdManager.b();
        }
        oi.a.i(oi.a.f71145a, getClassTag() + " --> sceneId = " + getSceneId() + " --> destroy() --> 资源回收", 0, false, 2, null);
    }

    public final di.a K() {
        return this;
    }

    public final TNativeAd M() {
        BiddingHiSavanaIconAdManager biddingHiSavanaIconAdManager = this.f42003o;
        if (biddingHiSavanaIconAdManager != null) {
            return biddingHiSavanaIconAdManager.d();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(java.lang.String r21, boolean r22, int r23, di.a r24, java.util.Map r25, kotlin.coroutines.Continuation r26) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.icon.BiddingIconAdManager.R(java.lang.String, boolean, int, di.a, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // di.a
    public void e(TAdErrorCode tAdErrorCode, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.e(tAdErrorCode, biddingIntermediateMaterialBean);
        oi.a.i(oi.a.f71145a, getClassTag() + " --> sceneId = " + getSceneId() + " --> onBiddingBuyOutError() --> errorMessage = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), 0, false, 6, null);
    }

    public final String getSceneId() {
        return this.f41995g;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onClick(tAdNativeInfo, additionalInfo);
        ri.c cVar = ri.c.f74658a;
        String O = O();
        String sceneId = getSceneId();
        Integer valueOf = tAdNativeInfo != null ? Integer.valueOf(tAdNativeInfo.getAdSource()) : null;
        AdPlans adPlans = this.f41999k;
        cVar.a((r30 & 1) != 0 ? "" : O, sceneId, "", valueOf, "", 6, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? MapsKt.h() : null, null, (r30 & 512) != 0 ? null : null, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? null : "", adPlans != null ? adPlans.getAdSource() : null);
        di.a aVar = this.f41996h;
        if (aVar != null) {
            aVar.onClick(tAdNativeInfo, additionalInfo);
        }
        oi.a aVar2 = oi.a.f71145a;
        String classTag = getClassTag();
        String sceneId2 = getSceneId();
        AdPlans adPlans2 = this.f41999k;
        oi.a.i(aVar2, classTag + " --> sceneId = " + sceneId2 + " --> onBiddingWrapperAdClick() --> name = " + (adPlans2 != null ? adPlans2.getName() : null), 0, false, 2, null);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadFailure(tAdErrorCode, additionalInfo);
        di.a aVar = this.f41996h;
        if (aVar != null) {
            aVar.onLoadFailure(tAdErrorCode, additionalInfo);
        }
        oi.a.i(oi.a.f71145a, getClassTag() + " --> sceneId = " + getSceneId() + " --> onLoadFailure() --> placementId = " + additionalInfo.getPlacementId() + " --> errorMessage = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), 0, false, 6, null);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        String str;
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShow(tAdNativeInfo, additionalInfo);
        ri.c cVar = ri.c.f74658a;
        String O = O();
        String sceneId = getSceneId();
        AdPlans adPlans = this.f41999k;
        if (adPlans == null || (str = adPlans.getId()) == null) {
            str = "";
        }
        String str2 = str;
        AdPlans adPlans2 = this.f41999k;
        cVar.g((r30 & 1) != 0 ? "" : O, sceneId, str2, 103, "", 6, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? MapsKt.h() : null, null, (r30 & 512) != 0 ? null : null, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? null : null, adPlans2 != null ? adPlans2.getAdSource() : null);
        oi.a aVar = oi.a.f71145a;
        String classTag = getClassTag();
        String sceneId2 = getSceneId();
        AdPlans adPlans3 = this.f41999k;
        oi.a.i(aVar, classTag + " --> sceneId = " + sceneId2 + " --> onBiddingWrapperAdDisplay() --> name = " + (adPlans3 != null ? adPlans3.getName() : null), 0, false, 2, null);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShowError(tAdErrorCode, additionalInfo);
        oi.a aVar = oi.a.f71145a;
        String classTag = getClassTag();
        String sceneId = getSceneId();
        AdPlans adPlans = this.f41999k;
        oi.a.i(aVar, classTag + " --> sceneId = " + sceneId + " --> onIconShowError() --> name = " + (adPlans != null ? adPlans.getName() : null) + ", errorMessage = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), 0, false, 2, null);
    }

    @Override // di.a
    public void q(List tAdNativeInfos) {
        Intrinsics.h(tAdNativeInfos, "tAdNativeInfos");
        super.q(tAdNativeInfos);
        oi.a.i(oi.a.f71145a, getClassTag() + " --> sceneId = " + getSceneId() + " --> onIconAdReady() --> tAdNativeInfos.size = " + tAdNativeInfos.size(), 0, false, 2, null);
        this.f41992d.clear();
        this.f41992d.addAll(tAdNativeInfos);
        if (this.f41993e.isEmpty()) {
            return;
        }
        L().post(new Runnable() { // from class: com.transsion.ad.bidding.icon.d
            @Override // java.lang.Runnable
            public final void run() {
                BiddingIconAdManager.V(BiddingIconAdManager.this);
            }
        });
    }

    @Override // di.a
    public void r(RecommendInfo recommendInfo) {
        String str;
        super.r(recommendInfo);
        ri.c cVar = ri.c.f74658a;
        String O = O();
        String sceneId = getSceneId();
        AdPlans adPlans = this.f42000l;
        if (adPlans == null || (str = adPlans.getId()) == null) {
            str = "";
        }
        cVar.a((r30 & 1) != 0 ? "" : O, sceneId, str, 102, "", 6, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? MapsKt.h() : null, recommendInfo, (r30 & 512) != 0 ? null : null, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? null : "", AdPlanSourceManager.AdPlanEnum.AD_PLAN_AD_SOURCE_HI.getValue());
        com.transsion.ad.strategy.b.f42281a.k(null);
        qi.b bVar = qi.b.f73757a;
        String sceneId2 = getSceneId();
        if (sceneId2 == null) {
            sceneId2 = "";
        }
        AdPlans adPlans2 = this.f42000l;
        bVar.a(recommendInfo, true, sceneId2, adPlans2 != null ? adPlans2.getBidEcpmCent() : null);
        di.a aVar = this.f41996h;
        if (aVar != null) {
            aVar.r(recommendInfo);
        }
        oi.a aVar2 = oi.a.f71145a;
        String classTag = getClassTag();
        String sceneId3 = getSceneId();
        AdPlans adPlans3 = this.f42000l;
        oi.a.i(aVar2, classTag + " --> sceneId = " + sceneId3 + " --> onBiddingWrapperAdClick() --> name = " + (adPlans3 != null ? adPlans3.getName() : null), 0, false, 2, null);
    }

    @Override // di.a
    public void t(RecommendInfo recommendInfo) {
        String str;
        super.t(recommendInfo);
        ri.c cVar = ri.c.f74658a;
        String O = O();
        String sceneId = getSceneId();
        AdPlans adPlans = this.f42000l;
        if (adPlans == null || (str = adPlans.getId()) == null) {
            str = "";
        }
        AdPlans adPlans2 = this.f42000l;
        cVar.g((r30 & 1) != 0 ? "" : O, sceneId, str, 102, "", 6, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? MapsKt.h() : null, recommendInfo, (r30 & 512) != 0 ? null : null, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? null : "", adPlans2 != null ? adPlans2.getAdSource() : null);
        List<BiddingWrapperIconBean> list = this.f41994f;
        if (list != null) {
            for (BiddingWrapperIconBean biddingWrapperIconBean : list) {
                RecommendInfo recommendInfo2 = biddingWrapperIconBean.getRecommendInfo();
                if (Intrinsics.c(recommendInfo2 != null ? Long.valueOf(recommendInfo2.getId()) : null, recommendInfo != null ? Long.valueOf(recommendInfo.getId()) : null)) {
                    biddingWrapperIconBean.setDisplay(true);
                }
            }
        }
        oi.a aVar = oi.a.f71145a;
        String classTag = getClassTag();
        String sceneId2 = getSceneId();
        AdPlans adPlans3 = this.f42000l;
        oi.a.i(aVar, classTag + " --> sceneId = " + sceneId2 + " --> onBiddingWrapperAdDisplay() --> name = " + (adPlans3 != null ? adPlans3.getName() : null), 0, false, 2, null);
    }

    @Override // di.a
    public void u(RecommendInfo recommendInfo) {
        super.u(recommendInfo);
        oi.a aVar = oi.a.f71145a;
        String classTag = getClassTag();
        String sceneId = getSceneId();
        AdPlans adPlans = this.f42000l;
        oi.a.i(aVar, classTag + " --> sceneId = " + sceneId + " --> onIconShowError() --> name = " + (adPlans != null ? adPlans.getName() : null), 0, false, 2, null);
    }

    @Override // di.a
    public void v(List list) {
        super.v(list);
        oi.a.i(oi.a.f71145a, getClassTag() + " --> onPSDistributionReady() --> mSceneId = " + getSceneId() + " --> data.size = " + (list != null ? Integer.valueOf(list.size()) : null), 0, false, 2, null);
        this.f41993e.clear();
        if (list != null) {
            this.f41993e.addAll(list);
        }
        if (this.f41992d.isEmpty()) {
            return;
        }
        L().post(new Runnable() { // from class: com.transsion.ad.bidding.icon.e
            @Override // java.lang.Runnable
            public final void run() {
                BiddingIconAdManager.W(BiddingIconAdManager.this);
            }
        });
    }
}
