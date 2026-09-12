package com.transsion.shorttv_pugc.ui.widget;

import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.base.pager.PagerLayoutManager;
import com.transsion.shorttv_pugc.utils.ShortTvExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class u extends gt.a implements androidx.view.r {

    /* renamed from: l, reason: collision with root package name */
    public static final a f54469l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f54470a;

    /* renamed from: b, reason: collision with root package name */
    private final BaseProviderMultiAdapter f54471b;

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.player.orplayer.g f54472c;

    /* renamed from: d, reason: collision with root package name */
    private final ORPlayerView f54473d;

    /* renamed from: e, reason: collision with root package name */
    private PagerLayoutManager f54474e;

    /* renamed from: f, reason: collision with root package name */
    private int f54475f;

    /* renamed from: g, reason: collision with root package name */
    private int f54476g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f54477h;

    /* renamed from: i, reason: collision with root package name */
    private View f54478i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f54479j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f54480k;

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
        public static final /* synthetic */ int[] f54481a;

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
            f54481a = iArr;
        }
    }

    public u(Fragment fragment, BaseProviderMultiAdapter baseProviderMultiAdapter, com.transsion.player.orplayer.g gVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager) {
        Intrinsics.h(fragment, "fragment");
        this.f54470a = fragment;
        this.f54471b = baseProviderMultiAdapter;
        this.f54472c = gVar;
        this.f54473d = oRPlayerView;
        this.f54474e = pagerLayoutManager;
        this.f54477h = true;
        fragment.getLifecycle().a(this);
    }

    private final void e() {
        r6.f h02;
        BaseProviderMultiAdapter baseProviderMultiAdapter = this.f54471b;
        if (((baseProviderMultiAdapter == null || (h02 = baseProviderMultiAdapter.h0()) == null) ? null : h02.i()) == LoadMoreStatus.Fail && nh.m.f70597a.e()) {
            a.C0856a.f(lg.a.f68962a, "ShortTvControl", "current is fail, try load more", false, 4, null);
            this.f54471b.h0().w();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j(int i11, View view) {
        List<Object> data;
        this.f54478i = view;
        a.C0856a.f(lg.a.f68962a, "ShortTvControl", "ep = " + i11, false, 4, null);
        if (i11 < 0) {
            return;
        }
        BaseProviderMultiAdapter baseProviderMultiAdapter = this.f54471b;
        ShorttvModel.UGCVideo uGCVideo = null;
        if (baseProviderMultiAdapter != null && (data = baseProviderMultiAdapter.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((ShorttvModel.UGCVideo) next).getEp() == ShortTvExtKt.l(i11)) {
                    uGCVideo = next;
                    break;
                }
            }
            uGCVideo = uGCVideo;
        }
        this.f54475f = i11;
        if (view instanceof com.transsion.shorttv_pugc.ui.widget.a) {
            ((com.transsion.shorttv_pugc.ui.widget.a) view).onPageSelected(this.f54472c, this.f54473d, uGCVideo);
        }
    }

    @Override // gt.a
    public void a(int i11, boolean z10, View view) {
        a.C0856a.r(lg.a.f68962a, "ShortTvControl", new String[]{"onEachPageSelected, position = " + i11}, false, 4, null);
    }

    @Override // gt.a
    public void b(View view) {
        if (this.f54479j) {
            this.f54479j = false;
            return;
        }
        PagerLayoutManager pagerLayoutManager = this.f54474e;
        if (pagerLayoutManager != null) {
            int findFirstVisibleItemPosition = pagerLayoutManager.findFirstVisibleItemPosition();
            a.C0856a.v(lg.a.f68962a, "ShortTvControl", "onInitComplete, position = " + findFirstVisibleItemPosition + ", ----- currentPosition = " + this.f54475f, false, 4, null);
            if (this.f54475f == findFirstVisibleItemPosition) {
                return;
            }
            if (findFirstVisibleItemPosition != -1) {
                this.f54475f = findFirstVisibleItemPosition;
            }
            j(this.f54475f, view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gt.a
    public void c(boolean z10, int i11, View view) {
        RecyclerView recyclerView;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.v(c0856a, "ShortTvControl", "onPageRelease, position = " + i11 + ", ----- currentPosition = " + this.f54475f, false, 4, null);
        if (i11 == this.f54475f) {
            BaseProviderMultiAdapter baseProviderMultiAdapter = this.f54471b;
            if (baseProviderMultiAdapter != null && (recyclerView = baseProviderMultiAdapter.getRecyclerView()) != null && recyclerView.getScrollState() == 1) {
                a.C0856a.v(c0856a, "ShortTvControl", "onPageRelease, 连续滑动，暂停", false, 4, null);
                com.transsion.player.orplayer.g gVar = this.f54472c;
                if (gVar != null) {
                    gVar.pause();
                }
            }
            if (view instanceof com.transsion.shorttv_pugc.ui.widget.a) {
                ((com.transsion.shorttv_pugc.ui.widget.a) view).onPageRelease(i11);
            }
        }
    }

    @Override // gt.a
    public void d(int i11, boolean z10, View view) {
        e();
        a.C0856a.f(lg.a.f68962a, "ShortTvControl", "onPageSelected, position = " + i11 + ", ----- currentPosition = " + this.f54475f, false, 4, null);
        int i12 = this.f54475f;
        if (i12 == i11 && this.f54480k) {
            return;
        }
        this.f54480k = true;
        this.f54476g = i12;
        this.f54475f = i11;
        j(i11, view);
    }

    public final View f() {
        return this.f54478i;
    }

    public final int g() {
        return this.f54475f;
    }

    public final long h() {
        KeyEvent.Callback callback = this.f54478i;
        com.transsion.shorttv_pugc.ui.widget.a aVar = callback instanceof com.transsion.shorttv_pugc.ui.widget.a ? (com.transsion.shorttv_pugc.ui.widget.a) callback : null;
        if (aVar != null) {
            return aVar.getProgress();
        }
        return 0L;
    }

    public final void i() {
        View view = this.f54478i;
        ShortTvVideoItemView shortTvVideoItemView = view instanceof ShortTvVideoItemView ? (ShortTvVideoItemView) view : null;
        if (shortTvVideoItemView != null) {
            shortTvVideoItemView.onNetConnect();
        }
    }

    public final void k(boolean z10) {
        this.f54479j = z10;
    }

    @Override // androidx.view.r
    public void onStateChanged(androidx.view.u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        if (b.f54481a[event.ordinal()] != 3) {
            return;
        }
        this.f54478i = null;
        this.f54470a.getLifecycle().d(this);
    }
}
