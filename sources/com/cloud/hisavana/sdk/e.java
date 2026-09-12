package com.cloud.hisavana.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.l4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f22479a;

    /* renamed from: b, reason: collision with root package name */
    private final q3 f22480b;

    /* renamed from: c, reason: collision with root package name */
    private List f22481c;

    /* renamed from: d, reason: collision with root package name */
    private com.cloud.hisavana.sdk.api.listener.f f22482d;

    /* renamed from: h, reason: collision with root package name */
    private boolean f22486h;

    /* renamed from: i, reason: collision with root package name */
    private String f22487i;

    /* renamed from: j, reason: collision with root package name */
    private String f22488j;

    /* renamed from: l, reason: collision with root package name */
    private List f22490l;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22483e = false;

    /* renamed from: f, reason: collision with root package name */
    private final List f22484f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f22485g = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f22489k = false;

    /* renamed from: m, reason: collision with root package name */
    private final l4.a f22491m = new a();

    /* renamed from: n, reason: collision with root package name */
    Runnable f22492n = new b();

    /* loaded from: classes3.dex */
    class a implements l4.a {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.l4.a
        public void a(TaErrorCode taErrorCode, Bundle bundle) {
            try {
                e.this.o(bundle);
                int h11 = e.this.h(null);
                if (h11 != 1) {
                    e eVar = e.this;
                    eVar.F(h11 < 0 ? Math.abs(h11) : eVar.f22480b.a());
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.cloud.hisavana.sdk.l4.a
        public void a(List list) {
            e.this.f22490l = list;
            e4.b().d("ssp", "onWebRecommendInfoSuccess");
        }

        @Override // com.cloud.hisavana.sdk.l4.a
        public void b(List list, Bundle bundle) {
            try {
                e.this.o(bundle);
                int h11 = e.this.h(list);
                if (h11 != 1) {
                    e eVar = e.this;
                    eVar.F(h11 < 0 ? Math.abs(h11) : eVar.f22480b.a());
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.cloud.hisavana.sdk.l4.a
        public void c(TaErrorCode taErrorCode, Bundle bundle) {
            try {
                if (e.this.f22481c != null && e.this.f22481c.size() > 1) {
                    e.this.f22489k = true;
                }
                e.this.o(bundle);
                int h11 = e.this.h(null);
                if (h11 != 1) {
                    e eVar = e.this;
                    eVar.F(h11 < 0 ? Math.abs(h11) : eVar.f22480b.a());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.K();
        }
    }

    private e(q3 q3Var, com.cloud.hisavana.sdk.api.listener.f fVar) {
        this.f22480b = q3Var;
        this.f22479a = q3Var.i();
        this.f22482d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C() {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.e.C():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i11) {
        for (l4 l4Var : this.f22481c) {
            if (l4Var.b() == 1) {
                l4Var.c(i11);
                l4Var.a(this.f22480b);
                return;
            }
        }
    }

    private void H(List list) {
        List list2 = this.f22481c;
        if (list2 != null) {
            list2.clear();
            l4 l11 = l(y4.class);
            ((y4) l11).k(list);
            this.f22481c.add(l11);
            F(this.f22480b.a());
        }
    }

    private void I() {
        HSScopeHelper.f23249a.f(this.f22492n, this.f22480b.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(List list) {
        H(list);
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.f22485g = true;
        try {
            h(null);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f(AdsDTO adsDTO, AdsDTO adsDTO2) {
        return Double.compare(adsDTO2.getFirstPrice().doubleValue(), adsDTO.getFirstPrice().doubleValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(List list) {
        if (this.f22486h) {
            return 1;
        }
        if (this.f22482d == null) {
            return 2;
        }
        if (list != null && !list.isEmpty()) {
            this.f22484f.addAll(list);
            try {
                ArrayList arrayList = new ArrayList(this.f22484f);
                Collections.sort(arrayList, new Comparator() { // from class: com.cloud.hisavana.sdk.k3
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int f11;
                        f11 = e.f((AdsDTO) obj, (AdsDTO) obj2);
                        return f11;
                    }
                });
                this.f22484f.clear();
                this.f22484f.addAll(arrayList);
            } catch (Throwable unused) {
            }
        }
        boolean y10 = y(this.f22489k);
        if (this.f22483e && !this.f22485g && !y10) {
            return 2;
        }
        int a11 = this.f22480b.a();
        List z10 = z(a11);
        if (!y10 && !this.f22485g) {
            if (z10.isEmpty()) {
                return 2;
            }
            if (z10.size() < a11) {
                return z10.size() - a11;
            }
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            com.cloud.hisavana.sdk.common.util.g0.c(sSPTrackingHelper.p(this.f22480b.n()), "s_req_timeout", false);
            sSPTrackingHelper.x(this.f22484f, this.f22480b);
            q(null, z10);
            return 1;
        }
        SSPTrackingHelper sSPTrackingHelper2 = SSPTrackingHelper.f22035a;
        com.cloud.hisavana.sdk.common.util.g0.c(sSPTrackingHelper2.p(this.f22480b.n()), "s_req_timeout", this.f22485g);
        if (!z10.isEmpty()) {
            sSPTrackingHelper2.x(this.f22484f, this.f22480b);
            q(null, z10);
            return 1;
        }
        if (!this.f22485g && this.f22489k && !y(false)) {
            return 2;
        }
        List list2 = this.f22490l;
        if (list2 == null || list2.isEmpty()) {
            q(TaErrorCode.ERROR_TAKE_AD_RESULT_FAILED, null);
            return 1;
        }
        e4.b().d("AdFetch", "adsList is empty,webPageRecommendInfo is not empty return success");
        q(null, z10);
        return 1;
    }

    private AdxImpBean i(q3 q3Var) {
        AdxImpBean adxImpBean = new AdxImpBean();
        try {
            adxImpBean.adt = q3Var.e();
            adxImpBean.pmid = q3Var.i();
            adxImpBean.mAdCount = q3Var.a();
            adxImpBean.requestId = q3Var.j();
            adxImpBean.requestType = q3Var.k();
            adxImpBean.triggerId = q3Var.n();
            if (q3Var.l() != null) {
                adxImpBean.gameName = q3Var.l().b();
                adxImpBean.gameScene = q3Var.l().c();
                adxImpBean.extInfo = q3Var.l().a();
            }
            adxImpBean.supportEw = q3Var.y();
            adxImpBean.requestTs = Long.valueOf(System.currentTimeMillis());
            adxImpBean.isAutoPlayVideoAd = q3Var.q();
            adxImpBean.offlineAdEnable = q3Var.f().isOfflineAdEnable();
            adxImpBean.cacheAdCount = q3Var.a();
            adxImpBean.mTriggerNetState = q3Var.o();
            adxImpBean.webPageReqInfo = q3Var.p();
        } catch (Throwable unused) {
        }
        return adxImpBean;
    }

    public static e j(q3 q3Var, com.cloud.hisavana.sdk.api.listener.f fVar) {
        return new e(q3Var, fVar);
    }

    private l4 l(Class cls) {
        l4 g0Var;
        if (cls == d1.class) {
            g0Var = new d1();
            g0Var.e(this.f22480b.f().getFillTimeoutDuration().intValue());
        } else {
            g0Var = cls == g0.class ? new g0() : cls == p2.class ? new p2() : cls == y4.class ? new y4() : null;
        }
        if (g0Var != null) {
            g0Var.d(this.f22491m);
        }
        return g0Var;
    }

    private List m(int i11) {
        ArrayList arrayList = new ArrayList();
        boolean isOfflineAdEnable = this.f22480b.f().isOfflineAdEnable();
        ConcurrentHashMap p11 = SSPTrackingHelper.f22035a.p(this.f22480b.n());
        if (this.f22480b.x()) {
            com.cloud.hisavana.sdk.common.util.g0.e(p11, "temp_online_without_req", TaErrorCode.CODE_AD_ONLY_REQ_DEFAULT);
            arrayList.add(l(p2.class));
        } else if (i11 == 1) {
            com.cloud.hisavana.sdk.common.util.g0.e(p11, "temp_online_without_req", TaErrorCode.CODE_AD_NO_NETWORK);
            if (isOfflineAdEnable) {
                arrayList.add(l(g0.class));
            }
            if (Z.f21623a.A()) {
                arrayList.add(l(p2.class));
            }
        } else {
            arrayList.add(l(d1.class));
            if (isOfflineAdEnable) {
                arrayList.add(l(g0.class));
            }
            if (Z.f21623a.A()) {
                arrayList.add(l(p2.class));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            if (bundle.containsKey("offline_ad_status")) {
                this.f22487i = (String) bundle.get("offline_ad_status");
            } else if (bundle.containsKey("default_ad_status")) {
                this.f22488j = (String) bundle.get("default_ad_status");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(TaErrorCode taErrorCode, Bundle bundle) {
        this.f22482d.b(taErrorCode, bundle);
    }

    private void q(final TaErrorCode taErrorCode, final List list) {
        if (this.f22486h) {
            return;
        }
        this.f22486h = true;
        if (!this.f22485g) {
            HSScopeHelper.f23249a.d(this.f22492n);
        }
        if (this.f22482d == null) {
            int errorCode = taErrorCode != null ? taErrorCode.getErrorCode() : 0;
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            q3 q3Var = this.f22480b;
            sSPTrackingHelper.A(errorCode, q3Var, null, this.f22487i, this.f22488j, q3Var.f().getLocalOfflineAdCacheCount(), System.currentTimeMillis() - this.f22480b.g(), 2);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f22480b.g();
        final Bundle bundle = new Bundle();
        com.cloud.hisavana.sdk.common.util.g0.f(bundle, "time_consuming", currentTimeMillis);
        com.cloud.hisavana.sdk.common.util.g0.d(bundle, "cache_offline_ad_count", this.f22480b.f().getLocalOfflineAdCacheCount());
        com.cloud.hisavana.sdk.common.util.g0.g(bundle, "offline_ad_status", this.f22487i);
        com.cloud.hisavana.sdk.common.util.g0.g(bundle, "default_ad_status", this.f22488j);
        if (taErrorCode == null) {
            u(list, currentTimeMillis);
            HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.o3
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.v(list, bundle);
                }
            });
            return;
        }
        if (a7.c.p()) {
            com.cloud.sdk.commonutil.util.q.b("fill_fail，error code is " + taErrorCode.getErrorCode() + ", ad_trigger_status，" + this.f22480b.o(), 3);
            t("fill failed, filltime=" + currentTimeMillis + "error=" + taErrorCode);
        }
        HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.n3
            @Override // java.lang.Runnable
            public final void run() {
                e.this.p(taErrorCode, bundle);
            }
        });
    }

    private void t(String str) {
        if (a7.c.p() && !TextUtils.isEmpty(str)) {
            e4.b().d("AdFetch", str + ", codeSeatId=" + this.f22479a);
        }
    }

    private void u(List list, long j11) {
        if (a7.c.p() && list != null && list.size() > 0) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("fill success:");
                sb2.append("\n");
                sb2.append("fill time: ");
                sb2.append(j11);
                sb2.append("ms");
                sb2.append("\n");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    AdsDTO adsDTO = (AdsDTO) it.next();
                    if (adsDTO != null) {
                        sb2.append("ad_trigger_status: ");
                        sb2.append(this.f22480b.o());
                        sb2.append("，is_offline_ad: ");
                        sb2.append(adsDTO.isOfflineAd());
                        sb2.append("，adCreativeId: ");
                        sb2.append(adsDTO.getAdCreativeId());
                        sb2.append(", source:");
                        sb2.append(adsDTO.getSource());
                        sb2.append("\n");
                    }
                }
                com.cloud.sdk.commonutil.util.q.b(sb2.toString(), 3);
                t(sb2.toString());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(List list, Bundle bundle) {
        List list2 = this.f22490l;
        if (list2 == null || list2.isEmpty()) {
            this.f22482d.d(list, bundle);
        } else {
            this.f22482d.c(list, this.f22490l, bundle, i(this.f22480b));
        }
    }

    private boolean w(ConfigCodeSeatDTO configCodeSeatDTO) {
        int intValue = configCodeSeatDTO.getShowInterval().intValue();
        long lastShowAdTime = configCodeSeatDTO.getLastShowAdTime();
        long currentTimeMillis = System.currentTimeMillis();
        e4.b().d("AdFetch", "calculateDownloadCount, current " + currentTimeMillis + ",lastShowAdTime " + lastShowAdTime + ",showInterval " + intValue);
        return intValue <= 0 || Math.abs(lastShowAdTime - currentTimeMillis) >= ((long) intValue) * 1000;
    }

    private boolean y(boolean z10) {
        List list = this.f22481c;
        if (list == null || list.isEmpty()) {
            return true;
        }
        for (l4 l4Var : this.f22481c) {
            if (!z10 || !(l4Var instanceof d1)) {
                if (l4Var.b() != 3) {
                    return false;
                }
            }
        }
        return true;
    }

    private List z(int i11) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList = new ArrayList();
        if (i11 <= 0) {
            return arrayList;
        }
        try {
            for (AdsDTO adsDTO : this.f22484f) {
                if (adsDTO != null) {
                    if (!hashSet.contains(adsDTO.getAdCreativeId())) {
                        String psPackageName = TextUtils.isEmpty(adsDTO.getPackageName()) ? adsDTO.getPsPackageName() : adsDTO.getPackageName();
                        if (TextUtils.isEmpty(psPackageName) || !hashSet2.contains(psPackageName)) {
                            if (!TextUtils.isEmpty(psPackageName)) {
                                hashSet2.add(psPackageName);
                            }
                            hashSet.add(adsDTO.getAdCreativeId());
                            adsDTO.setShowSourceSize(this.f22480b.f().getShowSourceSize().booleanValue());
                            adsDTO.setPreloadStatus(0);
                            arrayList.add(adsDTO);
                        }
                    }
                }
                if (arrayList.size() >= i11) {
                    break;
                }
            }
        } catch (Throwable th2) {
            e4.b().w("AdFetch", "buildDeduplicatedAdResult error: " + th2.getMessage());
        }
        return arrayList;
    }

    public void D(final List list) {
        HSScopeHelper.f23249a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.l3
            @Override // java.lang.Runnable
            public final void run() {
                e.this.J(list);
            }
        });
    }

    public void E() {
        try {
            if (!this.f22485g) {
                HSScopeHelper.f23249a.d(this.f22492n);
            }
            this.f22482d = null;
        } catch (Throwable unused) {
        }
    }

    public void n() {
        this.f22490l = null;
        HSScopeHelper.f23249a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.m3
            @Override // java.lang.Runnable
            public final void run() {
                e.this.C();
            }
        });
        I();
    }
}
