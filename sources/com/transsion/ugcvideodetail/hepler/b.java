package com.transsion.ugcvideodetail.hepler;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.tn.lib.pager.PagerLayoutManager;
import com.transsion.baselib.report.l;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.widget.UGCImmVideoItemView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import nh.m;

/* loaded from: classes6.dex */
public final class b extends ch.a implements l.a {

    /* renamed from: k, reason: collision with root package name */
    public static final a f56443k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f56444a;

    /* renamed from: b, reason: collision with root package name */
    private final BaseProviderMultiAdapter f56445b;

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.player.orplayer.g f56446c;

    /* renamed from: d, reason: collision with root package name */
    private final ORPlayerView f56447d;

    /* renamed from: e, reason: collision with root package name */
    private PagerLayoutManager f56448e;

    /* renamed from: f, reason: collision with root package name */
    private int f56449f;

    /* renamed from: g, reason: collision with root package name */
    private int f56450g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f56451h;

    /* renamed from: i, reason: collision with root package name */
    private View f56452i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f56453j;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(Fragment fragment, BaseProviderMultiAdapter baseProviderMultiAdapter, com.transsion.player.orplayer.g gVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager) {
        Intrinsics.h(fragment, "fragment");
        this.f56444a = fragment;
        this.f56445b = baseProviderMultiAdapter;
        this.f56446c = gVar;
        this.f56447d = oRPlayerView;
        this.f56448e = pagerLayoutManager;
        l.f43413a.g(this);
    }

    private final void e() {
        r6.f h02;
        BaseProviderMultiAdapter baseProviderMultiAdapter = this.f56445b;
        if (((baseProviderMultiAdapter == null || (h02 = baseProviderMultiAdapter.h0()) == null) ? null : h02.i()) == LoadMoreStatus.Fail && m.f70597a.e()) {
            a.C0856a.f(lg.a.f68962a, "UGCImmVideoControl", "current is fail, try load more", false, 4, null);
            this.f56445b.h0().w();
        }
    }

    private final void h(int i11, View view) {
        this.f56452i = view;
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoControl", "on page select position = " + i11, false, 4, null);
        if (i11 < 0) {
            return;
        }
        BaseProviderMultiAdapter baseProviderMultiAdapter = this.f56445b;
        UGCImmVideo uGCImmVideo = baseProviderMultiAdapter != null ? (UGCImmVideo) baseProviderMultiAdapter.f0(i11) : null;
        this.f56449f = i11;
        if (uGCImmVideo != null) {
            if (view instanceof UGCImmVideoItemView) {
                ((UGCImmVideoItemView) view).onPageSelected(this.f56446c, this.f56447d, uGCImmVideo);
            }
        } else {
            com.transsion.player.orplayer.g gVar = this.f56446c;
            if (gVar != null) {
                gVar.pause();
            }
        }
    }

    @Override // ch.a
    public void a(int i11, boolean z10, View view) {
        a.C0856a.r(lg.a.f68962a, "UGCImmVideoControl", new String[]{"onEachPageSelected, position = " + i11}, false, 4, null);
    }

    @Override // ch.a
    public void b(View view) {
        if (this.f56453j) {
            this.f56453j = false;
            return;
        }
        PagerLayoutManager pagerLayoutManager = this.f56448e;
        if (pagerLayoutManager != null) {
            int findFirstVisibleItemPosition = pagerLayoutManager.findFirstVisibleItemPosition();
            a.C0856a.v(lg.a.f68962a, "UGCImmVideoControl", "onInitComplete, position = " + findFirstVisibleItemPosition + ", ----- currentPosition = " + this.f56449f, false, 4, null);
            if (this.f56449f == findFirstVisibleItemPosition) {
                return;
            }
            if (findFirstVisibleItemPosition != -1) {
                this.f56449f = findFirstVisibleItemPosition;
            }
            h(this.f56449f, view);
        }
    }

    @Override // ch.a
    public void c(boolean z10, int i11, View view) {
        RecyclerView recyclerView;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.v(c0856a, "UGCImmVideoControl", "onPageRelease, position = " + i11 + ", ----- currentPosition = " + this.f56449f, false, 4, null);
        if (i11 == this.f56449f) {
            BaseProviderMultiAdapter baseProviderMultiAdapter = this.f56445b;
            if (baseProviderMultiAdapter != null && (recyclerView = baseProviderMultiAdapter.getRecyclerView()) != null && recyclerView.getScrollState() == 1) {
                a.C0856a.v(c0856a, "UGCImmVideoControl", "onPageRelease, 连续滑动，暂停", false, 4, null);
                com.transsion.player.orplayer.g gVar = this.f56446c;
                if (gVar != null) {
                    gVar.pause();
                }
            }
            if (view instanceof UGCImmVideoItemView) {
                ((UGCImmVideoItemView) view).onPageRelease(i11);
            }
        }
    }

    @Override // ch.a
    public void d(int i11, boolean z10, View view) {
        e();
        a.C0856a.f(lg.a.f68962a, "UGCImmVideoControl", "onPageSelected, position = " + i11 + ", ----- currentPosition = " + this.f56449f, false, 4, null);
        int i12 = this.f56449f;
        if (i12 != i11 || this.f56451h) {
            this.f56451h = false;
            this.f56450g = i12;
            this.f56449f = i11;
            h(i11, view);
        }
    }

    public final UGCImmVideoItemView f() {
        View view = this.f56452i;
        if (view instanceof UGCImmVideoItemView) {
            return (UGCImmVideoItemView) view;
        }
        return null;
    }

    public final void g() {
        View view = this.f56452i;
        UGCImmVideoItemView uGCImmVideoItemView = view instanceof UGCImmVideoItemView ? (UGCImmVideoItemView) view : null;
        if (uGCImmVideoItemView != null) {
            uGCImmVideoItemView.onPageDestroy();
        }
        l.f43413a.u(this);
    }

    @Override // com.transsion.baselib.report.l.a
    public void onBackgroundStatusChange(boolean z10) {
        if (z10) {
            View view = this.f56452i;
            UGCImmVideoItemView uGCImmVideoItemView = view instanceof UGCImmVideoItemView ? (UGCImmVideoItemView) view : null;
            if (uGCImmVideoItemView != null) {
                uGCImmVideoItemView.app2Background();
            }
        }
    }
}
