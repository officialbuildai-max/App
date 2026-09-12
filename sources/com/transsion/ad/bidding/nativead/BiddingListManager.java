package com.transsion.ad.bidding.nativead;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;

/* loaded from: classes5.dex */
public final class BiddingListManager {

    /* renamed from: b, reason: collision with root package name */
    private n0 f42054b;

    /* renamed from: c, reason: collision with root package name */
    private BiddingNativeManager f42055c;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference f42058f;

    /* renamed from: g, reason: collision with root package name */
    private Function2 f42059g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f42061i;

    /* renamed from: a, reason: collision with root package name */
    private Map f42053a = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private int f42056d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f42057e = -1;

    /* renamed from: h, reason: collision with root package name */
    private final List f42060h = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private String f42062j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f42063k = "";

    /* renamed from: l, reason: collision with root package name */
    private boolean f42064l = true;

    /* renamed from: m, reason: collision with root package name */
    private final long f42065m = 300;

    /* renamed from: n, reason: collision with root package name */
    private final Handler f42066n = new Handler(Looper.getMainLooper());

    /* renamed from: o, reason: collision with root package name */
    private Runnable f42067o = new Runnable() { // from class: com.transsion.ad.bidding.nativead.e
        @Override // java.lang.Runnable
        public final void run() {
            BiddingListManager.n(BiddingListManager.this);
        }
    };

    /* loaded from: classes5.dex */
    public static final class a extends RecyclerView.r {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (BiddingListManager.this.f42064l) {
                RecyclerView.m layoutManager = recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager != null) {
                    BiddingListManager.this.E(linearLayoutManager.findLastVisibleItemPosition());
                }
                GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
                if (gridLayoutManager != null) {
                    BiddingListManager.this.E(gridLayoutManager.findLastVisibleItemPosition());
                }
                if (i11 != 0) {
                    BiddingListManager.this.f42061i = false;
                    return;
                }
                BiddingListManager.this.f42061i = true;
                if (BiddingListManager.this.t() >= BiddingListManager.this.u() && BiddingListManager.this.s() == -1) {
                    BiddingListManager.this.x();
                } else {
                    if (BiddingListManager.this.t() < BiddingListManager.this.u() || BiddingListManager.this.t() - BiddingListManager.this.s() < BiddingListManager.this.v()) {
                        return;
                    }
                    BiddingListManager.this.x();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(BiddingListManager biddingListManager) {
        biddingListManager.q();
    }

    private final String p() {
        String simpleName = BiddingListManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final void q() {
        BiddingNativeManager biddingNativeManager = this.f42055c;
        if ((biddingNativeManager != null ? biddingNativeManager.n0() : null) != null) {
            w();
            return;
        }
        if (this.f42055c != null) {
            oi.a.f71145a.n("ad_n", p() + " --> null != delegate", 3, false);
            return;
        }
        BiddingNativeManager biddingNativeManager2 = new BiddingNativeManager();
        this.f42055c = biddingNativeManager2;
        this.f42060h.add(biddingNativeManager2);
        n0 n0Var = this.f42054b;
        if (n0Var != null) {
            k.d(n0Var, null, null, new BiddingListManager$getDelegate$1$1(biddingNativeManager2, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int u() {
        return com.transsion.ad.scene.a.p(com.transsion.ad.scene.a.f42255a, this.f42062j, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int v() {
        return com.transsion.ad.scene.a.r(com.transsion.ad.scene.a.f42255a, this.f42062j, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        BiddingNativeManager biddingNativeManager = this.f42055c;
        if (biddingNativeManager != null) {
            int i11 = this.f42056d + 1;
            if (i11 - this.f42057e < v()) {
                return;
            }
            this.f42057e = i11;
            n0 n0Var = this.f42054b;
            if (n0Var != null) {
                k.d(n0Var, null, null, new BiddingListManager$insert$1$1(this, biddingNativeManager, null), 3, null);
            }
            oi.a.f71145a.n("ad_n", p() + " --> insert() --> 触发插入广告 --- mLastItemPosition = " + this.f42056d + " -- mLastAdPosition = " + this.f42057e, 3, false);
            this.f42055c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        this.f42066n.removeCallbacks(this.f42067o);
        this.f42066n.postDelayed(this.f42067o, this.f42065m);
    }

    public final void A(n0 n0Var) {
        this.f42054b = n0Var;
    }

    public final void B(Map ctxMap) {
        Intrinsics.h(ctxMap, "ctxMap");
        this.f42053a = ctxMap;
    }

    public final void C(boolean z10) {
        this.f42064l = z10;
    }

    public final void D(Function2 function2) {
        this.f42059g = function2;
    }

    public final void E(int i11) {
        this.f42056d = i11;
    }

    public final void F(RecyclerView recyclerView) {
        this.f42058f = new WeakReference(recyclerView);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new a());
        }
    }

    public final void G(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.f42062j = sceneId;
    }

    public final void H(String sceneSubId) {
        Intrinsics.h(sceneSubId, "sceneSubId");
        this.f42063k = sceneSubId;
    }

    public final void o() {
        y();
        this.f42066n.removeCallbacksAndMessages(null);
        WeakReference weakReference = this.f42058f;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f42059g = null;
    }

    public final Function2 r() {
        return this.f42059g;
    }

    public final int s() {
        return this.f42057e;
    }

    public final int t() {
        return this.f42056d;
    }

    public final void y() {
        oi.a.f71145a.n("ad_n", p() + " --> refresh() --> 资源回收 --> delegateList.forEach{it.destroy()} -- sceneId = " + this.f42062j, 3, false);
        Iterator it = this.f42060h.iterator();
        while (it.hasNext()) {
            ((BiddingNativeManager) it.next()).V();
        }
        this.f42056d = -1;
        this.f42057e = -1;
        BiddingNativeManager biddingNativeManager = this.f42055c;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.f42055c = null;
    }

    public final void z(Function2 function2) {
        this.f42059g = function2;
    }
}
