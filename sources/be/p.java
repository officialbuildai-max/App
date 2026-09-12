package be;

import android.content.Context;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.interfacz.QueryPriceListener;
import com.hisavana.common.interfacz.WrapTAdAllianceListener;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.handler.DispatcherHandler;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class p {

    /* renamed from: b, reason: collision with root package name */
    public final CloudControlConfig.CodeSeat f16501b;

    /* renamed from: c, reason: collision with root package name */
    public final i f16502c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16503d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16504e;

    /* renamed from: f, reason: collision with root package name */
    public final q f16505f;

    /* renamed from: i, reason: collision with root package name */
    public final DispatcherHandler f16508i;

    /* renamed from: a, reason: collision with root package name */
    public final String f16500a = "PreloadHandler";

    /* renamed from: g, reason: collision with root package name */
    public CopyOnWriteArrayList f16506g = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f16507h = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public int f16509j = 1;

    /* loaded from: classes4.dex */
    public class a implements QueryPriceListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16510a;

        public a(Context context) {
            this.f16510a = context;
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceFailed() {
            AdLogUtil.Log().d("PreloadHandler", "receive query price failed");
            p.this.e(this.f16510a, null);
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceSuccess(List list) {
            AdLogUtil.Log().d("PreloadHandler", "CacheHandler --> queryPrice --> receive query price success");
            p.this.e(this.f16510a, list);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends WrapTAdAllianceListener {

        /* renamed from: a, reason: collision with root package name */
        public Iad f16512a;

        public b(Iad iad) {
            this.f16512a = iad;
        }

        public final void a() {
            p.this.f16507h.decrementAndGet();
            if (this.f16512a == null) {
                AdLogUtil.Log().d("PreloadHandler", "mExecuter is null");
                return;
            }
            AdLogUtil.Log().d("PreloadHandler", "*----> request ad success, adSource:" + this.f16512a.getAdSource() + ", ad placementId: " + this.f16512a.getPlacementId() + ",mFlightingAdCount.get() = " + p.this.f16507h.get());
            this.f16512a.setLoadStatus(2);
            if (o.e(this.f16512a)) {
                if (this.f16512a.getNetwork() != null) {
                    this.f16512a.getNetwork().setPrice(Double.valueOf(this.f16512a.getEcpmPrice()));
                }
                ICacheAd iCacheAd = this.f16512a;
                if (iCacheAd instanceof BaseAd) {
                    ((BaseAd) iCacheAd).mBundle.putDouble(TrackingKey.BIDDING_PRICE, iCacheAd.getEcpmPrice());
                } else if (iCacheAd instanceof AdNativeInfo) {
                    ((AdNativeInfo) iCacheAd).getNativeAdWrapper().getAdImpl().mBundle.putDouble(TrackingKey.BIDDING_PRICE, this.f16512a.getEcpmPrice());
                }
                p.this.f16508i.g(p.this.f16506g);
            }
            if (p.this.j() || p.this.f16508i.m(p.this.f16506g)) {
                return;
            }
            p.this.m();
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener, com.hisavana.common.interfacz.TInnerAdListener
        public void onError(TAdErrorCode tAdErrorCode) {
            p.this.f16507h.decrementAndGet();
            Iad iad = this.f16512a;
            if (iad == null) {
                AdLogUtil.Log().d("PreloadHandler", "mExecuter is null");
                return;
            }
            iad.setLoadStatus(3);
            AdLogUtil Log = AdLogUtil.Log();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("*----> request ad fail,error code: ");
            sb2.append(tAdErrorCode != null ? Integer.valueOf(tAdErrorCode.getErrorCode()) : null);
            sb2.append(",adSource:");
            sb2.append(this.f16512a.getAdSource());
            sb2.append(", ad placementId: ");
            sb2.append(this.f16512a.getPlacementId());
            sb2.append(",mFlightingAdCount.get() = ");
            sb2.append(p.this.f16507h.get());
            Log.d("PreloadHandler", sb2.toString());
            if (p.this.j() || p.this.f16508i.m(p.this.f16506g)) {
                return;
            }
            p.this.m();
        }

        @Override // com.hisavana.common.interfacz.TInnerAdListener
        public void onLoad() {
            a();
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener
        public void onLoad(List list) {
            a();
        }
    }

    public p(CloudControlConfig.CodeSeat codeSeat, i iVar) {
        this.f16501b = codeSeat;
        this.f16502c = iVar;
        this.f16503d = codeSeat == null ? "" : codeSeat.getCodeSeatId();
        this.f16504e = codeSeat == null ? -1 : codeSeat.getCodeSeatType().intValue();
        this.f16505f = new q(iVar, codeSeat, true);
        this.f16508i = new DispatcherHandler(codeSeat, iVar);
    }

    public TInnerAdRequestBody a(Iad iad) {
        return new TInnerAdRequestBody.Builder().setAdListener(new b(iad)).build();
    }

    public void c() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f16506g;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Iad iad = (Iad) it.next();
                if (iad != null) {
                    iad.stopLoader();
                }
            }
            this.f16506g.clear();
        }
        q qVar = this.f16505f;
        if (qVar != null) {
            qVar.n();
        }
    }

    public void d(Context context) {
        if (g(this.f16501b)) {
            this.f16507h.set(0);
            this.f16506g.clear();
            this.f16505f.l();
            i(context);
        }
    }

    public final void e(Context context, List list) {
        CopyOnWriteArrayList f11 = this.f16508i.f(context, list, this.f16505f.o(), this.f16505f.r(), true);
        this.f16506g = f11;
        if (f11 == null || f11.isEmpty()) {
            AdLogUtil.Log().d("PreloadHandler", "*----> no ad source can be preload.");
        } else {
            m();
        }
    }

    public final boolean g(CloudControlConfig.CodeSeat codeSeat) {
        int intValue = codeSeat.getPreload().booleanValue() ? codeSeat.getPreloadLogic().intValue() : -1;
        if (intValue == -1) {
            AdLogUtil.Log().w("PreloadHandler", "current code seat id is " + this.f16503d + "preload is close...");
            return false;
        }
        AdCache b11 = this.f16508i.b();
        if (intValue != 1 || b11 == null || !b11.hasAds(codeSeat.getCodeSeatId(), this.f16502c.J())) {
            return true;
        }
        AdLogUtil.Log().w("PreloadHandler", "autoAppend & INSUFFICIENT_APPEND,but adunit:" + this.f16503d + " has cached ad, load/preload/trigger_preload request end");
        return false;
    }

    public final void i(Context context) {
        RecordTestInfo.record("fanbidding queryPrice,codeSeatId:" + this.f16503d);
        this.f16505f.d(new a(context));
    }

    public final boolean j() {
        return this.f16507h.get() > 0;
    }

    public final boolean k(Iad iad) {
        boolean z10 = false;
        if (iad == null) {
            return false;
        }
        TInnerAdRequestBody a11 = a(iad);
        if (AdUtil.requestStatusOff()) {
            this.f16507h.addAndGet(1);
            z10 = this.f16508i.l(iad, 2, this.f16509j, a11, true);
            if (z10) {
                this.f16505f.h(iad.getNetwork(), true);
            }
        } else {
            int loadStatus = iad.getLoadStatus();
            AdLogUtil.Log().d("PreloadHandler", "codeSeatId is" + this.f16503d + ":ad source is " + iad.getAdSource() + ", load status is " + loadStatus);
            if (loadStatus != 1 && loadStatus != 3 && loadStatus != 2) {
                this.f16507h.addAndGet(1);
                z10 = this.f16508i.k(iad, 2, this.f16509j, a11);
                if (loadStatus == 0 && z10) {
                    this.f16505f.h(iad.getNetwork(), true);
                } else if (!z10) {
                    this.f16507h.decrementAndGet();
                }
            }
        }
        return z10;
    }

    public final void m() {
        RecordTestInfo.record("load ad num: 1 with group");
        Iterator it = this.f16506g.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Iad iad = (Iad) it.next();
            if (iad != null) {
                if (o.e(iad)) {
                    if (k(iad)) {
                        i iVar = this.f16502c;
                        iVar.y(iVar.E() + 1);
                    }
                } else if (i11 == 0 && k(iad)) {
                    i iVar2 = this.f16502c;
                    iVar2.y(iVar2.E() + 1);
                    i11++;
                }
            }
        }
    }
}
