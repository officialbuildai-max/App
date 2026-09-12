package com.transsion.shorttv.ui.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.shorttv.ad.playeroverlayad.ShortTvPlayerOverlayAdManager;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lg.a;

/* loaded from: classes6.dex */
public final class ShortTvPagerChangeControl extends cs.a implements androidx.view.r, a1 {

    /* renamed from: o, reason: collision with root package name */
    public static final a f53549o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f53550a;

    /* renamed from: b, reason: collision with root package name */
    private final BaseProviderMultiAdapter f53551b;

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.player.orplayer.g f53552c;

    /* renamed from: d, reason: collision with root package name */
    private final ORPlayerView f53553d;

    /* renamed from: e, reason: collision with root package name */
    private PagerLayoutManager f53554e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f53555f;

    /* renamed from: g, reason: collision with root package name */
    private int f53556g;

    /* renamed from: h, reason: collision with root package name */
    private Integer f53557h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f53558i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f53559j;

    /* renamed from: k, reason: collision with root package name */
    private View f53560k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f53561l;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f53562m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f53563n;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f53564a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f53564a = iArr;
        }
    }

    public ShortTvPagerChangeControl(Fragment fragment, BaseProviderMultiAdapter baseProviderMultiAdapter, com.transsion.player.orplayer.g gVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager) {
        Intrinsics.h(fragment, "fragment");
        this.f53550a = fragment;
        this.f53551b = baseProviderMultiAdapter;
        this.f53552c = gVar;
        this.f53553d = oRPlayerView;
        this.f53554e = pagerLayoutManager;
        this.f53555f = true;
        this.f53558i = true;
        this.f53562m = new Handler(Looper.getMainLooper());
        fragment.getLifecycle().a(this);
    }

    private final void i() {
        r6.f h02;
        BaseProviderMultiAdapter baseProviderMultiAdapter = this.f53551b;
        if (((baseProviderMultiAdapter == null || (h02 = baseProviderMultiAdapter.h0()) == null) ? null : h02.i()) == LoadMoreStatus.Fail && nh.m.f70597a.e()) {
            a.C0856a.f(lg.a.f68962a, "ShortTvControl", "current is fail, try load more", false, 4, null);
            this.f53551b.h0().w();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(int i11, View view) {
        this.f53560k = view;
        boolean z10 = view instanceof ShortTvVideoItemView;
        ShortTvVideoItemView shortTvVideoItemView = z10 ? (ShortTvVideoItemView) view : null;
        if (shortTvVideoItemView != null) {
            shortTvVideoItemView.setCountdownController(this);
        }
        a.C0856a.f(lg.a.f68962a, "ShortTvControl", "on page select position = " + i11, false, 4, null);
        if (i11 < 0) {
            return;
        }
        BaseProviderMultiAdapter baseProviderMultiAdapter = this.f53551b;
        js.k kVar = baseProviderMultiAdapter != null ? (js.k) baseProviderMultiAdapter.f0(i11) : null;
        this.f53556g = i11;
        if (!(kVar instanceof js.e)) {
            com.transsion.player.orplayer.g gVar = this.f53552c;
            if (gVar != null) {
                gVar.pause();
                return;
            }
            return;
        }
        if (view instanceof d) {
            ShortTvVideoItemView shortTvVideoItemView2 = z10 ? (ShortTvVideoItemView) view : null;
            if (shortTvVideoItemView2 != null) {
                shortTvVideoItemView2.setFirstPlayInSession(this.f53555f);
            }
            this.f53555f = false;
            ((d) view).onPageSelected(this.f53552c, this.f53553d, (js.e) kVar);
        }
    }

    @Override // com.transsion.shorttv.ui.widget.a1
    public void a(int i11) {
        b();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i11;
        View view = this.f53560k;
        ShortTvVideoItemView shortTvVideoItemView = view instanceof ShortTvVideoItemView ? (ShortTvVideoItemView) view : null;
        if (shortTvVideoItemView != null) {
            shortTvVideoItemView.updateUnlockCountdownText$shortTvLib_release(Integer.valueOf(i11));
        }
        Runnable runnable = new Runnable() { // from class: com.transsion.shorttv.ui.widget.ShortTvPagerChangeControl$startCountdown$1
            @Override // java.lang.Runnable
            public void run() {
                View view2;
                Handler handler;
                Ref.IntRef intRef2 = Ref.IntRef.this;
                intRef2.element--;
                view2 = this.f53560k;
                ShortTvVideoItemView shortTvVideoItemView2 = view2 instanceof ShortTvVideoItemView ? (ShortTvVideoItemView) view2 : null;
                int i12 = Ref.IntRef.this.element;
                if (i12 > 0) {
                    if (shortTvVideoItemView2 != null) {
                        shortTvVideoItemView2.updateUnlockCountdownText$shortTvLib_release(Integer.valueOf(i12));
                    }
                    handler = this.f53562m;
                    handler.postDelayed(this, 1000L);
                    return;
                }
                this.b();
                if (shortTvVideoItemView2 != null) {
                    shortTvVideoItemView2.watchAdToUnlock$shortTvLib_release(true);
                }
            }
        };
        this.f53563n = runnable;
        Handler handler = this.f53562m;
        Intrinsics.e(runnable);
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.transsion.shorttv.ui.widget.a1
    public void b() {
        View view = this.f53560k;
        ShortTvVideoItemView shortTvVideoItemView = view instanceof ShortTvVideoItemView ? (ShortTvVideoItemView) view : null;
        if (shortTvVideoItemView != null) {
            shortTvVideoItemView.updateUnlockCountdownText$shortTvLib_release(null);
        }
        Runnable runnable = this.f53563n;
        if (runnable != null) {
            this.f53562m.removeCallbacks(runnable);
        }
        this.f53563n = null;
    }

    @Override // cs.a
    public void c(int i11, boolean z10, View view) {
        a.C0856a.r(lg.a.f68962a, "ShortTvControl", new String[]{"onEachPageSelected, position = " + i11}, false, 4, null);
    }

    @Override // cs.a
    public void d(View view) {
        if (this.f53561l) {
            this.f53561l = false;
            return;
        }
        PagerLayoutManager pagerLayoutManager = this.f53554e;
        if (pagerLayoutManager != null) {
            int findFirstVisibleItemPosition = pagerLayoutManager.findFirstVisibleItemPosition();
            a.C0856a.v(lg.a.f68962a, "ShortTvControl", "onInitComplete, position = " + findFirstVisibleItemPosition + ", ----- currentPosition = " + this.f53556g, false, 4, null);
            if (this.f53556g == findFirstVisibleItemPosition) {
                return;
            }
            if (findFirstVisibleItemPosition != -1) {
                this.f53556g = findFirstVisibleItemPosition;
            }
            q(this.f53556g, view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cs.a
    public void e(boolean z10, int i11, View view) {
        RecyclerView recyclerView;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.v(c0856a, "ShortTvControl", "onPageRelease, position = " + i11 + ", ----- currentPosition = " + this.f53556g, false, 4, null);
        if (i11 == this.f53556g) {
            BaseProviderMultiAdapter baseProviderMultiAdapter = this.f53551b;
            if (baseProviderMultiAdapter != null && (recyclerView = baseProviderMultiAdapter.getRecyclerView()) != null && recyclerView.getScrollState() == 1) {
                a.C0856a.v(c0856a, "ShortTvControl", "onPageRelease, 连续滑动，暂停", false, 4, null);
                com.transsion.player.orplayer.g gVar = this.f53552c;
                if (gVar != null) {
                    gVar.pause();
                }
            }
            if (view instanceof d) {
                ((d) view).onPageRelease(i11);
            }
        }
    }

    @Override // cs.a
    public void f(int i11, boolean z10, View view) {
        i();
        a.C0856a.f(lg.a.f68962a, "ShortTvControl", "onPageSelected, position = " + i11 + ", ----- currentPosition = " + this.f53556g, false, 4, null);
        if (this.f53556g != i11 || this.f53559j) {
            b();
            this.f53559j = false;
            Integer valueOf = Integer.valueOf(this.f53556g);
            this.f53557h = valueOf;
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                BaseProviderMultiAdapter baseProviderMultiAdapter = this.f53551b;
                Object obj = baseProviderMultiAdapter != null ? (js.k) baseProviderMultiAdapter.getItem(intValue) : null;
                if (obj != null) {
                    js.e eVar = obj instanceof js.e ? (js.e) obj : null;
                    if (eVar != null) {
                        ShortTvPlayerOverlayAdManager.f52770a.e(eVar.a());
                    }
                }
            }
            this.f53556g = i11;
            q(i11, view);
        }
    }

    public final View j() {
        return this.f53560k;
    }

    public final int k() {
        return this.f53556g;
    }

    public final long l() {
        KeyEvent.Callback callback = this.f53560k;
        d dVar = callback instanceof d ? (d) callback : null;
        if (dVar != null) {
            return dVar.getProgress();
        }
        return 0L;
    }

    public final void m() {
        KeyEvent.Callback callback = this.f53560k;
        d dVar = callback instanceof d ? (d) callback : null;
        if (dVar != null) {
            dVar.onAudioTrackChange();
        }
    }

    public final void n() {
        KeyEvent.Callback callback = this.f53560k;
        d dVar = callback instanceof d ? (d) callback : null;
        if (dVar != null) {
            dVar.onGetDubsInfo();
        }
    }

    public final void o() {
        if (this.f53558i) {
            this.f53558i = false;
        }
    }

    @Override // androidx.view.r
    public void onStateChanged(androidx.view.u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        if (b.f53564a[event.ordinal()] != 3) {
            return;
        }
        b();
        this.f53560k = null;
        this.f53550a.getLifecycle().d(this);
    }

    public final void p() {
        View view = this.f53560k;
        ShortTvVideoItemView shortTvVideoItemView = view instanceof ShortTvVideoItemView ? (ShortTvVideoItemView) view : null;
        if (shortTvVideoItemView != null) {
            shortTvVideoItemView.onNetConnect();
        }
    }

    public final void r(boolean z10) {
        this.f53561l = z10;
    }

    public final void s(int i11) {
        this.f53556g = i11;
    }

    public final void t(ShortTvVideoItemView view, int i11, js.e item) {
        Intrinsics.h(view, "view");
        Intrinsics.h(item, "item");
        view.updateShortTvInfo(this.f53552c, this.f53553d, item);
    }
}
