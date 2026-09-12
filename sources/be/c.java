package be;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.interfacz.QueryPriceListener;
import com.hisavana.common.interfacz.WrapTAdAllianceListener;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.common.utils.RunTimer;
import com.hisavana.mediation.R$string;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.handler.DispatcherHandler;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public abstract class c {
    public Bundle A;

    /* renamed from: a, reason: collision with root package name */
    public double f16435a;

    /* renamed from: b, reason: collision with root package name */
    public t f16436b;

    /* renamed from: c, reason: collision with root package name */
    public RunTimer f16437c;

    /* renamed from: e, reason: collision with root package name */
    public final q f16439e;

    /* renamed from: f, reason: collision with root package name */
    public int f16440f;

    /* renamed from: g, reason: collision with root package name */
    public int f16441g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f16442h;

    /* renamed from: i, reason: collision with root package name */
    public Object f16443i;

    /* renamed from: j, reason: collision with root package name */
    public final String f16444j;

    /* renamed from: n, reason: collision with root package name */
    public int f16448n;

    /* renamed from: o, reason: collision with root package name */
    public final CloudControlConfig.CodeSeat f16449o;

    /* renamed from: q, reason: collision with root package name */
    public int f16451q;

    /* renamed from: s, reason: collision with root package name */
    public int f16453s;

    /* renamed from: v, reason: collision with root package name */
    public final DispatcherHandler f16456v;

    /* renamed from: w, reason: collision with root package name */
    public final i f16457w;

    /* renamed from: x, reason: collision with root package name */
    public p f16458x;

    /* renamed from: d, reason: collision with root package name */
    public CopyOnWriteArrayList f16438d = new CopyOnWriteArrayList();

    /* renamed from: k, reason: collision with root package name */
    public int f16445k = 0;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f16446l = new AtomicInteger();

    /* renamed from: m, reason: collision with root package name */
    public boolean f16447m = false;

    /* renamed from: p, reason: collision with root package name */
    public int f16450p = 1;

    /* renamed from: r, reason: collision with root package name */
    public int f16452r = 1;

    /* renamed from: t, reason: collision with root package name */
    public int f16454t = 1;

    /* renamed from: u, reason: collision with root package name */
    public int f16455u = 1;

    /* renamed from: y, reason: collision with root package name */
    public int f16459y = 1;

    /* renamed from: z, reason: collision with root package name */
    public AdCache.AdCacheExpiredWatcher f16460z = new a();

    /* loaded from: classes4.dex */
    public class a implements AdCache.AdCacheExpiredWatcher {
        public a() {
        }

        @Override // com.hisavana.common.bean.AdCache.AdCacheExpiredWatcher
        public void onExpired(ICacheAd iCacheAd) {
            AdLogUtil.Log().d("CacheHandler", "ad expired");
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1001) {
                AdLogUtil.Log().w("CacheHandler", "receive MSG_REQUEST_NEXT_GROUP_WAITING...");
                c.this.g0();
            } else if (i11 == 1002) {
                AdLogUtil.Log().w("CacheHandler", "receive MSG_BIDDING_WAITING...");
                c.this.U(1);
            } else {
                Object obj = message.obj;
                if (obj instanceof Iad) {
                    ((Iad) obj).loadAd();
                }
            }
        }
    }

    /* renamed from: be.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0155c implements QueryPriceListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16463a;

        public C0155c(Context context) {
            this.f16463a = context;
        }

        public final void a(List list) {
            double d11;
            if (list == null || list.isEmpty() || c.this.f0()) {
                return;
            }
            AdLogUtil.Log().d("CacheHandler", "--- load ad mode --- ");
            Iterator it = c.this.f16438d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    d11 = 0.0d;
                    break;
                }
                Iad iad = (Iad) it.next();
                if (iad != null && iad.getLoadStatus() == 0) {
                    d11 = iad.getEcpmPrice();
                    break;
                }
            }
            AdLogUtil.Log().d("CacheHandler", "checkToLoadWaterfallAd priceThreshold --- ," + d11);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Network network = (Network) it2.next();
                Iad d12 = c.this.f16456v.d(this.f16463a, c.this.f16449o, network);
                if (d12 != null) {
                    c.this.f16438d.add(d12);
                    if (network.getPrice().doubleValue() >= d11) {
                        c.this.B(d12, 1);
                    }
                }
            }
            c.this.f16456v.g(c.this.f16438d);
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceFailed() {
            AdLogUtil.Log().d("CacheHandler", "receive query price failed");
            a(null);
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceSuccess(List list) {
            AdLogUtil.Log().d("CacheHandler", "CacheHandler --> queryPrice --> receive query price success");
            a(list);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends WrapTAdAllianceListener {

        /* renamed from: a, reason: collision with root package name */
        public Iad f16465a;

        /* renamed from: b, reason: collision with root package name */
        public Object f16466b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16467c;

        public d(Iad iad, int i11) {
            this.f16465a = iad;
            this.f16467c = i11;
        }

        public final String a() {
            int i11 = c.this.f16448n;
            if (i11 == 0) {
                return null;
            }
            return i11 == 1 ? "PROGRESS_REQUEST" : i11 == 2 ? "PROGRESS_BIDDING" : "PROGRESS_DISPATCHED";
        }

        public final void b(boolean z10) {
            Iad iad = this.f16465a;
            if (iad == null) {
                AdLogUtil.Log().d("CacheHandler", "mExecutor is null");
                return;
            }
            int i11 = 1;
            if (z10 && iad.getNetwork() != null && this.f16465a.getNetwork().getBiddingType().intValue() == 1 && this.f16465a.getNetwork().getPrice().doubleValue() < this.f16465a.getNetwork().getMinPrice().intValue()) {
                c.this.f16438d.remove(this.f16465a);
            }
            boolean e02 = c.this.e0();
            if (!e02) {
                c cVar = c.this;
                if (cVar.f16448n == 2) {
                    i11 = cVar.a(2, true);
                } else {
                    boolean c02 = cVar.c0();
                    AdLogUtil.Log().d("CacheHandler", "mProgress " + c.this.f16448n + " reachTopPrice " + c02);
                    c cVar2 = c.this;
                    if (cVar2.f16448n < 2 && c02) {
                        i11 = cVar2.a(2, true);
                    }
                }
            } else if (z10) {
                i11 = c.this.J();
                c.this.f();
                if (i11 == 0) {
                    c.this.K(5);
                }
            }
            boolean Z = c.this.Z();
            boolean g02 = (c.this.f16455u == 2 || !Z) ? c.this.g0() : false;
            if (Z || g02) {
                return;
            }
            if (e02 || c.this.f16448n == 2) {
                c.this.l(c.v(i11));
            }
        }

        public final void c() {
            c.this.f16446l.decrementAndGet();
            Iad iad = this.f16465a;
            if (iad == null) {
                AdLogUtil.Log().d("CacheHandler", "mExecuter is null");
                return;
            }
            iad.setLoadStatus(2);
            c cVar = c.this;
            cVar.f16447m = cVar.f16448n == 1;
            c.this.n(this.f16465a);
            AdLogUtil.Log().d("CacheHandler", "*----> onLoaded(),mProgress = " + a() + ",mFlightingAdCount.get() = " + c.this.f16446l.get() + ",ad fill adSource:" + this.f16465a.getAdSource() + ", ad placementId: " + this.f16465a.getPlacementId());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ad onAdLoaded,adSource ");
            sb2.append(this.f16465a.getAdSource());
            sb2.append(",id ");
            sb2.append(this.f16465a.getPlacementId());
            MediaLogUtil.d("CacheHandler", sb2.toString());
            c.this.j0();
            AdLogUtil.Log().d("CacheHandler", "onAdLoaded requestCategory " + this.f16467c);
            int i11 = this.f16467c;
            if (i11 == 1) {
                b(true);
            } else {
                if (i11 != 5) {
                    return;
                }
                d();
            }
        }

        public final void d() {
            t tVar = c.this.f16436b;
            if (tVar != null) {
                if (tVar.k() == null && c.this.f16436b.a() == null) {
                    return;
                }
                int J = c.this.J();
                c.this.f();
                if (J == 0) {
                    c.this.K(3);
                } else {
                    c.this.l(c.v(J));
                }
            }
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener, com.hisavana.common.interfacz.TInnerAdListener
        public void onError(TAdErrorCode tAdErrorCode) {
            c.this.f16446l.decrementAndGet();
            Iad iad = this.f16465a;
            if (iad == null) {
                AdLogUtil.Log().d("CacheHandler", "mExecuter is null");
                return;
            }
            iad.setLoadStatus(3);
            AdLogUtil Log = AdLogUtil.Log();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("*----> request ad fail,error code: ");
            sb2.append(tAdErrorCode != null ? Integer.valueOf(tAdErrorCode.getErrorCode()) : null);
            sb2.append(",adSource:");
            sb2.append(this.f16465a.getAdSource());
            sb2.append(", ad placementId: ");
            sb2.append(this.f16465a.getPlacementId());
            sb2.append(",mFlightingAdCount.get() = ");
            sb2.append(c.this.f16446l.get());
            sb2.append(" progress ");
            sb2.append(c.this.f16448n);
            Log.d("CacheHandler", sb2.toString());
            c.this.j0();
            MediaLogUtil.d("CacheHandler", "ad load Error,source " + this.f16465a.getAdSource() + ",id " + this.f16465a.getPlacementId());
            int i11 = this.f16467c;
            if (i11 == 1) {
                AdLogUtil.Log().d("CacheHandler", "onError current is load");
                b(false);
            } else {
                if (i11 != 5) {
                    return;
                }
                d();
            }
        }

        @Override // com.hisavana.common.interfacz.TInnerAdListener
        public void onLoad() {
            this.f16466b = this.f16465a;
            c();
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener
        public void onLoad(List list) {
            this.f16466b = list;
            c();
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener, com.hisavana.common.interfacz.TInnerAdListener
        public void onNativeFeedShow(int i11, TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
            super.onNativeFeedShow(i11, tAdNativeInfo, additionalInfo);
            AdLogUtil.Log().d("CacheHandler", "*----> ad onshow() " + c.this.f16444j);
            if (c.this.Z()) {
                AdLogUtil.Log().d("CacheHandler", "currently have requesting ad,terminate preload flow.");
                return;
            }
            if (!NetStateManager.checkNetworkState(false)) {
                AdLogUtil.Log().d("CacheHandler", "network is disconnect");
                return;
            }
            if (c.this.f16458x == null) {
                c cVar = c.this;
                cVar.f16458x = new p(cVar.f16449o, cVar.f16457w);
            }
            c.this.f16458x.d(com.cloud.sdk.commonutil.util.e.a());
        }

        @Override // com.hisavana.common.interfacz.TInnerAdListener
        public void onSkipClick() {
            t tVar = c.this.f16436b;
            if (tVar != null) {
                tVar.onSkipClick();
            }
        }

        @Override // com.hisavana.common.interfacz.TInnerAdListener
        public void onTimeReach() {
            t tVar = c.this.f16436b;
            if (tVar != null) {
                tVar.onTimeReach();
            }
        }
    }

    public c(CloudControlConfig.CodeSeat codeSeat, i iVar, t tVar) {
        this.f16451q = -1;
        this.f16453s = 0;
        this.f16449o = codeSeat;
        this.f16457w = iVar;
        iVar.y(0);
        this.f16439e = new q(iVar, codeSeat, false);
        this.f16456v = new DispatcherHandler(codeSeat, iVar);
        this.f16442h = new b(Looper.getMainLooper());
        this.f16451q = codeSeat.getCodeSeatType().intValue();
        this.f16436b = tVar;
        this.f16444j = codeSeat.getCodeSeatId();
        G().registerWatcher(this.f16460z);
        this.f16453s = iVar.D();
    }

    public static TAdErrorCode v(int i11) {
        return i11 != 2 ? i11 != 3 ? i11 != 4 ? TAdErrorCode.ERROR_FILL_FAILED_WITH_NO_AD : TAdErrorCode.ERROR_FILL_FAILED_LOW_PRICE : TAdErrorCode.ERROR_FILL_FAILED_SENSITIVE : TAdErrorCode.ERROR_FILL_FAILED_WiTH_EXPIRED;
    }

    public final boolean B(Iad iad, int i11) {
        boolean k11;
        if (iad == null) {
            return false;
        }
        TInnerAdRequestBody d11 = d(iad, i11);
        if (AdUtil.requestStatusOff()) {
            this.f16446l.addAndGet(1);
            k11 = this.f16456v.l(iad, i11, this.f16452r, d11, true);
            if (k11) {
                this.f16439e.h(iad.getNetwork(), true);
            } else {
                this.f16446l.decrementAndGet();
            }
        } else {
            int loadStatus = iad.getLoadStatus();
            if (loadStatus == 1 || loadStatus == 3 || loadStatus == 2) {
                return false;
            }
            this.f16446l.addAndGet(1);
            k11 = this.f16456v.k(iad, i11, this.f16452r, d11);
            if (loadStatus == 0 && k11) {
                this.f16439e.h(iad.getNetwork(), true);
            } else if (!k11) {
                this.f16446l.decrementAndGet();
            }
        }
        return k11;
    }

    public final String D(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? "" : "FAILED" : "SUCCESS" : "LOADING" : "NONE";
    }

    public final void E() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f16438d;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Iad iad = (Iad) it.next();
                if (iad != null) {
                    iad.stopLoader();
                }
            }
            this.f16438d.clear();
        }
        this.f16436b = null;
        this.f16457w.y(0);
        this.f16452r = 0;
        p0();
        this.f16439e.n();
        G().unRegisterWatcher();
        Handler handler = this.f16442h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f16448n = 3;
        AdLogUtil.Log().d("CacheHandler", "----------------->destroy,mUseCache:" + this.f16443i);
        p(this.f16443i);
        this.f16443i = null;
        p pVar = this.f16458x;
        if (pVar != null) {
            pVar.c();
        }
    }

    public void F(Object obj) {
    }

    public abstract AdCache G();

    public boolean I(int i11) {
        if (this.f16436b == null) {
            return false;
        }
        RecordTestInfo.record("load ad num: " + i11 + " with group");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("load next group,mReqCount ");
        sb2.append(i11);
        MediaLogUtil.d("CacheHandler", sb2.toString());
        Iterator it = this.f16438d.iterator();
        int i12 = 0;
        boolean z10 = false;
        while (it.hasNext()) {
            Iad iad = (Iad) it.next();
            if (iad != null) {
                if (o.e(iad)) {
                    if (B(iad, 1)) {
                        i iVar = this.f16457w;
                        iVar.y(iVar.E() + 1);
                        z10 = true;
                    }
                } else if (i12 < i11 && B(iad, 1)) {
                    i iVar2 = this.f16457w;
                    iVar2.y(iVar2.E() + 1);
                    i12++;
                }
            }
        }
        return i12 > 0 || z10;
    }

    public int J() {
        return G().checkCacheStatus(this.f16444j, this.f16457w.J());
    }

    public final void K(int i11) {
        if (this.f16448n == 3) {
            return;
        }
        AdLogUtil.Log().w("CacheHandler", "notify load success");
        this.f16448n = 3;
        t tVar = this.f16436b;
        if (tVar != null) {
            tVar.l(i11);
            p0();
            this.f16436b.p();
        }
    }

    public int M() {
        return 0;
    }

    public void O(int i11) {
        if (i11 > 0) {
            this.f16450p = i11;
        }
    }

    public int P() {
        return 1;
    }

    public void R(int i11) {
        this.f16459y = i11;
    }

    public double S() {
        return this.f16435a;
    }

    public final void U(int i11) {
        a(i11, false);
    }

    public int V() {
        return this.f16453s;
    }

    public final void X(int i11) {
        Iterator it = this.f16438d.iterator();
        while (it.hasNext()) {
            Iad iad = (Iad) it.next();
            if (iad != null) {
                iad.setTimeOut(true);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(TrackingKey.TRIGGER_ID, this.A.getString(TrackingKey.TRIGGER_ID));
        bundle.putLong(TrackingKey.TRIGGER_TS, this.A.getLong(TrackingKey.TRIGGER_TS));
        bundle.putInt("ad_type", this.f16451q);
        bundle.putString(TrackingKey.CLD_APP_ID, a7.c.f440b);
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.A.getString(TrackingKey.CODE_SEAT_ID));
        bundle.putInt(TrackingKey.BID_START_TIME_TYPE, i11);
        bundle.putFloat(TrackingKey.BID_START_DURATION, this.f16441g);
        try {
            bundle.putFloat(TrackingKey.TRIGGER_TO_BID_DURATION, (float) (System.currentTimeMillis() - this.A.getLong(TrackingKey.TRIGGER_TS)));
        } catch (Exception unused) {
        }
        bundle.putString(TrackingKey.CLD_CONFIGURE_ID, j7.a.e().j("cloudControlVersion"));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.A.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.A.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        TrackingManager.trackingStartBid(bundle);
    }

    public final boolean Z() {
        return this.f16446l.get() > 0;
    }

    public final int a(int i11, boolean z10) {
        if (!a0() || e0()) {
            return 1;
        }
        if (this.f16448n < 2) {
            AdLogUtil.Log().w("CacheHandler", "*----> start bidding...");
            RecordTestInfo.record("start bidding,bidStartTimeType:" + i11);
            MediaLogUtil.d("CacheHandler", "startBidding,bidStartTimeType " + i11 + " BIDDING_DURATION_REACHED:1,HIGH_PRICE_RETURN:2");
            X(i11);
            this.f16448n = 2;
            l0();
            k0();
        }
        int J = J();
        f();
        if (J == 0) {
            K(this.f16447m ? 1 : 2);
            AdLogUtil.Log().w("CacheHandler", "startBidding finish take bidding ad,and notifyLoadBest and unit id is " + this.f16444j);
            MediaLogUtil.d("CacheHandler", "bidding success,ad fill*****************");
        } else {
            if (z10 || Z()) {
                AdLogUtil.Log().d("CacheHandler", "startBidding,ad is null but still have ad requesting");
                return J;
            }
            AdLogUtil.Log().w("CacheHandler", "startBidding failed,no ad fill");
            l(v(J));
        }
        return J;
    }

    public final boolean a0() {
        t tVar;
        return (this.f16448n >= 3 || (tVar = this.f16436b) == null || (tVar.k() == null && this.f16436b.a() == null)) ? false : true;
    }

    public final boolean c0() {
        return this.f16456v.m(this.f16438d);
    }

    public TInnerAdRequestBody d(Iad iad, int i11) {
        return new TInnerAdRequestBody.Builder().setAdListener(new d(iad, i11)).build();
    }

    public abstract boolean d0();

    public Object e(boolean z10) {
        return this.f16443i;
    }

    public boolean e0() {
        return this.f16454t == 2;
    }

    public final void f() {
        this.f16435a = G().getMaxPrice(this.f16444j, this.f16457w.J());
    }

    public final boolean f0() {
        return this.f16448n >= 2;
    }

    public void g(Bundle bundle) {
        this.A = bundle;
    }

    public final boolean g0() {
        if (c0()) {
            return false;
        }
        this.f16452r++;
        boolean I = I(this.f16455u == 1 ? this.f16445k : 1);
        if (I) {
            o0();
        }
        return I;
    }

    public final void h0() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f16438d;
        if (copyOnWriteArrayList != null && (!copyOnWriteArrayList.isEmpty() || !this.f16439e.q().isEmpty())) {
            I(this.f16445k);
            AdLogUtil.Log().d("CacheHandler", "start WaitForBidding & startWaitForNextGroupRequest");
            n0();
            o0();
            return;
        }
        AdLogUtil.Log().d("CacheHandler", "*----> no ad source can be load.");
        if (!G().hasAds(this.f16444j, this.f16457w.J()) || e0()) {
            l(TAdErrorCode.ERROR_FILL_FAILED_WiTH_EXPIRED);
        } else {
            U(2);
        }
    }

    public void i0() {
        z(this.f16443i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j0() {
        if (LogSwitch.isDebug) {
            StringBuilder sb2 = new StringBuilder();
            Iterator it = this.f16438d.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                Iad iad = (Iad) it.next();
                if (iad != 0) {
                    if (iad instanceof BaseAd) {
                        i11 = ((BaseAd) iad).mBundle.getInt(TrackingKey.RETURN_TIME);
                    } else if (iad instanceof AdNativeInfo) {
                        i11 = ((AdNativeInfo) iad).getNativeAdWrapper().getAdImpl().mBundle.getInt(TrackingKey.RETURN_TIME);
                    }
                    boolean z10 = iad.getAdSource() == 1;
                    sb2.append(ComConstants.transferSourceToStr(iad.getAdSource()));
                    if (z10 && iad.getNetwork() != null) {
                        sb2.append("-");
                        sb2.append(iad.getMediatorSourceName());
                    }
                    sb2.append("，");
                    sb2.append(D(iad.getLoadStatus()));
                    sb2.append("，returnTime：");
                    sb2.append(i11);
                    sb2.append("\n");
                }
            }
            AdLogUtil.Log().d("CacheHandler", "--- executer list load status--- : " + sb2.toString());
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(sb2.toString(), RecordTestInfo.LOG_CODE6);
            }
        }
    }

    public final void k(t tVar) {
        this.f16436b = tVar;
    }

    public final void k0() {
        Handler handler = this.f16442h;
        if (handler != null) {
            handler.removeMessages(1002);
        }
    }

    public final void l(TAdErrorCode tAdErrorCode) {
        if (this.f16448n == 3) {
            return;
        }
        AdLogUtil.Log().w("CacheHandler", "notify load failed");
        p0();
        this.f16448n = 3;
        y(tAdErrorCode);
    }

    public final void l0() {
        AdLogUtil.Log().w("CacheHandler", "removeWaitForNextGroupRequest...");
        Handler handler = this.f16442h;
        if (handler != null) {
            handler.removeMessages(1001);
        }
    }

    public void m(TInnerAdRequestBody tInnerAdRequestBody, t tVar) {
        WrapTAdAllianceListener adListener;
        if (tInnerAdRequestBody == null || (adListener = tInnerAdRequestBody.getAdListener()) == null) {
            return;
        }
        adListener.setAdListener(tVar);
    }

    public void m0() {
        F(this.f16443i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(Iad iad) {
        int i11;
        if (iad == 0 || !AdUtil.isBiddingNetwork(iad.getNetwork())) {
            return;
        }
        AdLogUtil.Log().d("CacheHandler", "replace cloud price use first price，firstprice：" + iad.getEcpmPrice() + "，cloud price：" + iad.getNetwork().getPrice());
        iad.getNetwork().setPrice(Double.valueOf(iad.getEcpmPrice()));
        if (iad instanceof BaseAd) {
            ((BaseAd) iad).mBundle.putDouble(TrackingKey.BIDDING_PRICE, iad.getEcpmPrice());
        } else if (iad instanceof AdNativeInfo) {
            ((AdNativeInfo) iad).getNativeAdWrapper().getAdImpl().mBundle.putDouble(TrackingKey.BIDDING_PRICE, iad.getEcpmPrice());
        }
        this.f16456v.g(this.f16438d);
        if (iad.isAdxAd() && ((i11 = this.f16453s) == 1 || i11 == 3)) {
            U(2);
            return;
        }
        if (iad.isEwAd()) {
            int i12 = this.f16453s;
            if (i12 == 2 || i12 == 3) {
                U(2);
            }
        }
    }

    public final void n0() {
        if (e0() || this.f16442h == null) {
            return;
        }
        AdLogUtil.Log().d("CacheHandler", "startWaitForBidding...");
        this.f16442h.removeMessages(1002);
        this.f16442h.sendEmptyMessageDelayed(1002, this.f16441g);
    }

    public final void o(RunTimer runTimer) {
        this.f16437c = runTimer;
    }

    public final void o0() {
        Handler handler;
        if (this.f16455u != 1 || (handler = this.f16442h) == null) {
            return;
        }
        handler.removeMessages(1001);
        this.f16442h.sendEmptyMessageDelayed(1001, this.f16440f);
    }

    public abstract void p(Object obj);

    public void p0() {
        if (this.f16437c != null) {
            AdLogUtil.Log().w("LoadHandler", "stop timer");
            this.f16437c.cancelTimeTask();
            this.f16437c = null;
        }
    }

    public boolean q(Context context) {
        this.f16438d.clear();
        this.f16447m = false;
        this.f16446l.set(0);
        boolean z10 = this.f16459y == 2;
        this.f16441g = Math.max((z10 ? this.f16449o.getRealtimeBiddingWaitTime() : this.f16449o.getBiddingWaitTime()).intValue(), 500);
        this.f16440f = Math.max(this.f16449o.getAdRequestTimeInterval().intValue(), 500);
        this.f16445k = this.f16449o.getAdRequestConcurrentCount().intValue() <= 0 ? 1 : this.f16449o.getAdRequestConcurrentCount().intValue();
        this.f16450p = Math.max(1, Math.min(P(), this.f16449o.getAdRequestCount().intValue()));
        this.f16448n = 1;
        this.f16454t = (z10 ? this.f16449o.getRealtimeFillCallbackMode() : this.f16449o.getFillCallbackMode()).intValue();
        this.f16455u = this.f16449o.getRequestIntervalMode().intValue();
        if (LogSwitch.isDebug) {
            String format = String.format(com.cloud.sdk.commonutil.util.e.a().getString(R$string.hisavana_log_msg1), Integer.valueOf(this.f16441g), Integer.valueOf(this.f16440f), Integer.valueOf(this.f16445k), this.f16449o.getAdRequestCount(), this.f16449o.getPreload(), this.f16449o.getAdShowCountLimitDay(), this.f16449o.getAdShowCountLimitHour(), this.f16449o.getAdShowTimeInterval());
            RecordTestInfo.LogMsg(format, RecordTestInfo.LOG_CODE1);
            MediaLogUtil.d("CacheHandler", "prepareForRequest,config " + format);
            AdLogUtil.Log().i("CacheHandler", "*----> WaitBiddingTime:" + this.f16441g + ",WaitNextGroupRequestTime:" + this.f16440f + ",ConcurrentReqCount:" + this.f16445k + ",PoolAppendStrategy:" + this.f16449o.getPreloadLogic() + ",adRequestCount:" + this.f16449o.getAdRequestCount() + " ----- codeSeatId = " + this.f16449o.getCodeSeatId());
        }
        if (this.f16449o.getNetworks() == null || this.f16449o.getNetworks().size() == 0) {
            AdLogUtil.Log().w("CacheHandler", "adUnit:" + this.f16444j + " no networks , load/preload/trigger_preload request end");
            MediaLogUtil.e("CacheHandler", "prepareForRequest,networks is empty");
            return false;
        }
        if (e0() && J() == 0) {
            f();
            AdLogUtil.Log().d("CacheHandler", "-------->quick fill success ");
            K(5);
        }
        this.f16439e.l();
        this.f16438d = this.f16456v.f(context, this.f16439e.p(), this.f16439e.o(), this.f16439e.r(), false);
        x(context);
        h0();
        return true;
    }

    public boolean u(CloudControlConfig.CodeSeat codeSeat, Network network) {
        if (network == null || TextUtils.isEmpty(network.getCodeSeatId())) {
            return false;
        }
        return B(this.f16456v.d(com.cloud.sdk.commonutil.util.e.a(), codeSeat, network), 5);
    }

    public void w() {
        E();
    }

    public final void x(Context context) {
        RecordTestInfo.record("fanbidding queryPrice,codeSeatId:" + this.f16444j);
        this.f16439e.d(new C0155c(context));
    }

    public void y(TAdErrorCode tAdErrorCode) {
        t tVar = this.f16436b;
        if (tVar != null) {
            tVar.onError(tAdErrorCode);
        }
    }

    public void z(Object obj) {
    }
}
