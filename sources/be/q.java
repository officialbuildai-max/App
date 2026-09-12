package be;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.interfacz.QueryPriceListener;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.mediation.R$string;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.handler.DispatcherHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class q {

    /* renamed from: o, reason: collision with root package name */
    public static final be.b f16514o = new be.b();

    /* renamed from: b, reason: collision with root package name */
    public Handler f16516b;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16523i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f16524j;

    /* renamed from: k, reason: collision with root package name */
    public CloudControlConfig.CodeSeat f16525k;

    /* renamed from: l, reason: collision with root package name */
    public String f16526l;

    /* renamed from: m, reason: collision with root package name */
    public i f16527m;

    /* renamed from: n, reason: collision with root package name */
    public AdCache f16528n;

    /* renamed from: a, reason: collision with root package name */
    public QueryPriceListener f16515a = null;

    /* renamed from: c, reason: collision with root package name */
    public List f16517c = null;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f16518d = new AtomicInteger();

    /* renamed from: e, reason: collision with root package name */
    public final List f16519e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final List f16520f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final List f16521g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List f16522h = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16529a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, boolean z10) {
            super(looper);
            this.f16529a = z10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 101) {
                return;
            }
            AdLogUtil.Log().d("QueryPriceCenter", "receive MSG_QUERY_TIME_OUT message");
            if (this.f16529a) {
                q.this.j(true);
            } else {
                q.this.k(true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements QueryPriceListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f16531a;

        public b(Network network) {
            this.f16531a = network;
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceFailed() {
            q.this.f16518d.decrementAndGet();
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(ComConstants.transferSourceToStr(this.f16531a.getSource().intValue()) + " query price failed; ", RecordTestInfo.LOG_CODE9);
            }
            if (q.this.f16523i) {
                q.this.j(false);
            } else {
                q.this.k(false, null);
            }
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceSuccess(List list) {
            Network network;
            q.this.f16518d.decrementAndGet();
            if (list == null || list.size() <= 0 || list.get(0) == null || (network = (Network) list.get(0)) == null) {
                return;
            }
            AdLogUtil.Log().d("QueryPriceCenter", "receive query price result: " + list.toString());
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(ComConstants.transferSourceToStr(network.getSource().intValue()) + " price" + network.getPrice() + ";", RecordTestInfo.LOG_CODE9);
            }
            if (!q.f16514o.b(network.getCodeSeatId(), network)) {
                AdLogUtil.Log().w("QueryPriceCenter", "add price to price pool failed");
                q.this.h(network, false);
            } else if (q.this.f16523i) {
                q.this.j(false);
            } else {
                q.this.k(false, network.getCodeSeatId());
            }
        }
    }

    public q(i iVar, CloudControlConfig.CodeSeat codeSeat, boolean z10) {
        this.f16523i = false;
        if (codeSeat == null) {
            return;
        }
        this.f16525k = codeSeat;
        this.f16524j = codeSeat.getCodeSeatType();
        this.f16526l = codeSeat.getCodeSeatId();
        this.f16523i = z10;
        this.f16527m = iVar;
        this.f16528n = AdCacheManager.getCache(this.f16524j.intValue());
        this.f16516b = new a(Looper.getMainLooper(), z10);
    }

    public final BaseQueryPrice b(Network network) {
        if (network == null) {
            return null;
        }
        IBaseAdSummary f11 = o.a().f(network.getSource().intValue());
        BaseQueryPrice queryPrice = f11 != null ? f11.getQueryPrice() : null;
        if (queryPrice != null && this.f16524j.intValue() == 4) {
            queryPrice.setOrientation(this.f16527m.F());
        }
        return queryPrice;
    }

    public final Network c(String str) {
        AdCache adCache = this.f16528n;
        double maxPrice = adCache == null ? 0.0d : adCache.getMaxPrice(str, this.f16527m.J());
        AdLogUtil.Log().d("QueryPriceCenter", "*----> currently max price ad in ad pool is: " + maxPrice);
        Network a11 = f16514o.a(str);
        if (a11 == null) {
            return null;
        }
        AdLogUtil.Log().d("QueryPriceCenter", "*----> get cached, code seat id: +" + a11.getCodeSeatId() + " price: " + a11.getPrice());
        if (a11.getPrice().doubleValue() < maxPrice) {
            return null;
        }
        AdLogUtil.Log().d("QueryPriceCenter", "*----> getQueryPriceWinner --> winner network is: " + a11);
        return a11;
    }

    public List d(QueryPriceListener queryPriceListener) {
        BaseQueryPrice b11;
        this.f16515a = queryPriceListener;
        if (this.f16519e.isEmpty()) {
            AdLogUtil.Log().d("QueryPriceCenter", "Auciton failed due to query price list is empty");
            QueryPriceListener queryPriceListener2 = this.f16515a;
            if (queryPriceListener2 != null) {
                queryPriceListener2.onQueryPriceFailed();
            }
            return null;
        }
        Iterator it = this.f16519e.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Network network = (Network) it.next();
            if (network != null && (b11 = b(network)) != null) {
                b11.setQueryPriceListener(new b(network));
                if (i11 >= 5) {
                    AdLogUtil.Log().d("QueryPriceCenter", "Auciton count exceed the max thrshold: 5");
                    break;
                }
                AdLogUtil.Log().w("QueryPriceCenter", "*----> start query price,network id: " + network.getCodeSeatId());
                network.setAdt(this.f16524j.intValue());
                b11.setTrackingBundle(DispatcherHandler.a(this.f16527m, network, this.f16523i ? 2 : 1, this.f16525k));
                if (this.f16524j.intValue() == 2) {
                    b11.setBannerSize(this.f16527m.r());
                }
                RecordTestInfo.record("queryPrice,codeSeatId:" + network.getCodeSeatId());
                this.f16518d.addAndGet(1);
                b11.queryPrice(com.cloud.sdk.commonutil.util.e.a(), network);
                if (this.f16517c == null) {
                    this.f16517c = new ArrayList();
                }
                this.f16517c.add(b11);
                i11++;
            }
        }
        AdLogUtil.Log().d("QueryPriceCenter", "QueryPriceCenter --> startQueryPrice --> mDoingQueryCount.get() = " + this.f16518d.get());
        this.f16516b.removeMessages(101);
        this.f16516b.sendEmptyMessageDelayed(101, 2000L);
        return null;
    }

    public void h(Network network, boolean z10) {
        if (network == null || network.getBidInfo() == null) {
            return;
        }
        if (z10) {
            AdLogUtil.Log().d("QueryPriceCenter", "send auction success to network server!");
            network.getBidInfo().notifyWin();
        } else {
            AdLogUtil.Log().d("QueryPriceCenter", "send auction failed to network server!");
            network.getBidInfo().notifyLoss();
        }
    }

    public final void i(List list) {
        ArrayList caches;
        Network a11;
        if (LogSwitch.isDebug) {
            StringBuilder sb2 = new StringBuilder();
            for (Network network : this.f16519e) {
                if (network != null) {
                    sb2.append(ComConstants.transferSourceToStr(network.getSource().intValue()) + "，");
                }
            }
            StringBuilder sb3 = new StringBuilder();
            for (Network network2 : this.f16520f) {
                if (network2 != null) {
                    sb3.append(ComConstants.transferSourceToStr(network2.getSource().intValue()) + " -$ " + network2.getPrice() + "，");
                }
            }
            StringBuilder sb4 = new StringBuilder();
            for (Network network3 : this.f16521g) {
                if (network3 != null) {
                    sb4.append(ComConstants.transferSourceToStr(network3.getSource().intValue()) + " -$ " + network3.getPrice() + "，");
                }
            }
            AdLogUtil.Log().d("QueryPriceCenter", "*----> mQueryPriceNetworkList is: " + ((Object) sb2) + ",\n *----> mWaterfallNetworkList is: " + ((Object) sb3) + ",\n mHistroyPriceList is: " + ((Object) sb4));
            String format = String.format(com.cloud.sdk.commonutil.util.e.a().getString(R$string.hisavana_log_msg2), sb3.toString(), sb2.toString(), sb4.toString());
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(format, RecordTestInfo.LOG_CODE2);
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Network network4 = (Network) it.next();
                if (network4 != null && AdUtil.isQueryPriceNetwork(network4) && (a11 = f16514o.a(network4.getCodeSeatId())) != null) {
                    sb5.append(ComConstants.transferSourceToStr(network4.getSource().intValue()));
                    sb5.append(" price:");
                    sb5.append(a11.getPrice());
                }
            }
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(sb5.toString(), RecordTestInfo.LOG_CODE3);
            }
            AdCache adCache = this.f16528n;
            if (adCache == null) {
                caches = null;
            } else {
                String str = this.f16526l;
                i iVar = this.f16527m;
                caches = adCache.getCaches(str, Integer.MAX_VALUE, false, iVar != null && iVar.J());
            }
            if (!LogSwitch.isDebug || caches == null || caches.isEmpty()) {
                return;
            }
            RecordTestInfo.LogMsg(RecordTestInfo.getLogMsg(caches), RecordTestInfo.LOG_CODE4);
        }
    }

    public final void j(boolean z10) {
        Network c11;
        AdLogUtil.Log().e("QueryPriceCenter", "checkToGetWinnerPreload --> 竞价超时时间内 是否还有正在竞价的任务 --> mDoingQueryCount.get() = " + this.f16518d.get() + " ----- timeOut = " + z10 + "----- ispreload = " + this.f16523i);
        if (this.f16515a == null) {
            return;
        }
        if (z10 || this.f16518d.get() <= 0) {
            ArrayList arrayList = new ArrayList();
            for (Network network : this.f16519e) {
                if (network != null && (c11 = c(network.getCodeSeatId())) != null) {
                    AdLogUtil.Log().w("QueryPriceCenter", "*---->checkToGetWinnerPreload ----- winnerNetwork = " + c11);
                    arrayList.add(c11);
                }
            }
            AdLogUtil.Log().w("QueryPriceCenter", "*---->end query price,checkToGetWinnerPreload ----- winnerList.size() = " + arrayList.size());
            if (arrayList.isEmpty()) {
                this.f16515a.onQueryPriceFailed();
            } else {
                this.f16515a.onQueryPriceSuccess(arrayList);
            }
            this.f16515a = null;
            this.f16516b.removeMessages(101);
        }
    }

    public final void k(boolean z10, String str) {
        AdLogUtil.Log().e("QueryPriceCenter", "checkToGetWinner --> 竞价超时时间内 是否还有正在竞价的任务 --> mDoingQueryCount.get() = " + this.f16518d.get() + " ----- timeOut = " + z10 + "----- ispreload = " + this.f16523i + "，codeSeatId：" + str);
        if (z10) {
            this.f16515a = null;
        }
        if (this.f16515a == null || TextUtils.isEmpty(str)) {
            return;
        }
        Network c11 = c(str);
        AdLogUtil.Log().w("QueryPriceCenter", "*---->end query price,checkToGetWinner ----- winnerNetworks = " + c11);
        if (c11 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(c11);
            this.f16515a.onQueryPriceSuccess(arrayList);
        } else {
            this.f16515a.onQueryPriceFailed();
        }
        if (this.f16518d.get() <= 0) {
            this.f16516b.removeMessages(101);
        }
    }

    public void l() {
        this.f16519e.clear();
        this.f16520f.clear();
        this.f16521g.clear();
        this.f16522h.clear();
        List<Network> networks = this.f16525k.getNetworks();
        if (networks == null) {
            return;
        }
        for (Network network : networks) {
            if (network != null) {
                network.setAdt(this.f16524j.intValue());
                int networkType = AdUtil.getNetworkType(network);
                if (networkType == 1) {
                    this.f16522h.add(network);
                } else if (networkType == 2) {
                    this.f16520f.add(network);
                } else if (networkType == 3) {
                    if (this.f16523i) {
                        this.f16519e.add(network);
                    } else {
                        Network c11 = c(network.getCodeSeatId());
                        if (c11 == null) {
                            if (network.getSource().intValue() == 9) {
                                this.f16528n.removeCodeSeatCache(network.getCodeSeatId());
                            }
                            this.f16519e.add(network);
                        } else {
                            this.f16521g.add(c11);
                        }
                    }
                }
            }
        }
        i(networks);
    }

    public void n() {
        this.f16515a = null;
        Handler handler = this.f16516b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List list = this.f16517c;
        if (list != null && list.size() > 0) {
            for (BaseQueryPrice baseQueryPrice : this.f16517c) {
                if (baseQueryPrice != null) {
                    baseQueryPrice.destroy();
                }
            }
        }
        this.f16517c = null;
    }

    public List o() {
        return this.f16522h;
    }

    public List p() {
        AdLogUtil.Log().d("QueryPriceCenter", "*----> getHistoryPriceList  " + this.f16521g);
        return this.f16521g;
    }

    public List q() {
        return this.f16519e;
    }

    public List r() {
        return this.f16520f;
    }
}
