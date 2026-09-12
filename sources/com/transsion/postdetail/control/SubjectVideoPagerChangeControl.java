package com.transsion.postdetail.control;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.r;
import androidx.view.u;
import ao.e;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.transsion.baselib.report.l;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.g;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.view.ShortTvImmVideoItemView;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.transsnet.downloader.manager.DownloadEsHelper;
import ej.f;
import hj.i;
import in.d;
import java.util.List;
import jn.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import nh.m;
import r6.f;

/* loaded from: classes6.dex */
public class SubjectVideoPagerChangeControl extends cs.a implements r, l.a {

    /* renamed from: n, reason: collision with root package name */
    public static final a f48861n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f48862a;

    /* renamed from: b, reason: collision with root package name */
    private final com.transsion.postdetail.ui.adapter.l f48863b;

    /* renamed from: c, reason: collision with root package name */
    private final g f48864c;

    /* renamed from: d, reason: collision with root package name */
    private final ORPlayerView f48865d;

    /* renamed from: e, reason: collision with root package name */
    private PagerLayoutManager f48866e;

    /* renamed from: f, reason: collision with root package name */
    private final int f48867f;

    /* renamed from: g, reason: collision with root package name */
    private final long f48868g;

    /* renamed from: h, reason: collision with root package name */
    private int f48869h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f48870i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f48871j;

    /* renamed from: k, reason: collision with root package name */
    private View f48872k;

    /* renamed from: l, reason: collision with root package name */
    private final String f48873l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f48874m;

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
        public static final /* synthetic */ int[] f48875a;

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
            f48875a = iArr;
        }
    }

    public SubjectVideoPagerChangeControl(Fragment fragment, com.transsion.postdetail.ui.adapter.l lVar, g gVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager) {
        Intrinsics.h(fragment, "fragment");
        this.f48862a = fragment;
        this.f48863b = lVar;
        this.f48864c = gVar;
        this.f48865d = oRPlayerView;
        this.f48866e = pagerLayoutManager;
        this.f48867f = 3;
        this.f48868g = 3000L;
        this.f48870i = true;
        fragment.getLifecycle().a(this);
        m();
        this.f48873l = i.f64628a.i();
    }

    private final void h() {
        f h02;
        com.transsion.postdetail.ui.adapter.l lVar = this.f48863b;
        if (((lVar == null || (h02 = lVar.h0()) == null) ? null : h02.i()) == LoadMoreStatus.Fail && m.f70597a.e()) {
            a.C0856a.f(lg.a.f68962a, "ShortTvImmVideoPlayer", "current is fail, try load more", false, 4, null);
            this.f48863b.h0().w();
        }
    }

    private final Video l(Subject subject) {
        Media video;
        PreVideoAddress videoAddress;
        if (subject == null) {
            return null;
        }
        Trailer trailer = subject.getTrailer();
        if ((trailer != null ? trailer.getVideoAddress() : null) != null) {
            Trailer trailer2 = subject.getTrailer();
            if (trailer2 == null || (videoAddress = trailer2.getVideoAddress()) == null) {
                return null;
            }
            return d.a(videoAddress);
        }
        ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
        if (shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null) {
            return null;
        }
        return video.getVideoAddress();
    }

    private final void m() {
        l.f43413a.g(this);
    }

    @Override // cs.a
    public void d(View view) {
        PagerLayoutManager pagerLayoutManager = this.f48866e;
        if (pagerLayoutManager != null) {
            int findFirstVisibleItemPosition = pagerLayoutManager.findFirstVisibleItemPosition();
            a.C0856a.v(lg.a.f68962a, "ShortTvImmVideoPlayer", "onInitComplete, position = " + findFirstVisibleItemPosition + ", ----- currentPosition = " + this.f48869h, false, 4, null);
            if (this.f48869h == findFirstVisibleItemPosition) {
                return;
            }
            if (findFirstVisibleItemPosition != -1) {
                this.f48869h = findFirstVisibleItemPosition;
            }
            q(this.f48869h, view);
        }
    }

    @Override // cs.a
    public void e(boolean z10, int i11, View view) {
        a.C0856a.v(lg.a.f68962a, "ShortTvImmVideoPlayer", "onPageRelease, position = " + i11 + ", ----- currentPosition = " + this.f48869h, false, 4, null);
        if (i11 == this.f48869h) {
            w();
            ORPlayerView oRPlayerView = this.f48865d;
            ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).removeView(this.f48865d);
            }
        }
    }

    @Override // cs.a
    public void f(int i11, boolean z10, View view) {
        h();
        a.C0856a.f(lg.a.f68962a, "ShortTvImmVideoPlayer", "onPageSelected, position = " + i11 + ", ----- currentPosition = " + this.f48869h, false, 4, null);
        if (this.f48869h != i11 || this.f48871j) {
            this.f48871j = false;
            this.f48869h = i11;
            ImmVideoHelper.a aVar = ImmVideoHelper.f48894h;
            if (aVar.a().n()) {
                aVar.a().t();
            }
            q(i11, view);
        }
    }

    public void g(List data) {
        Intrinsics.h(data, "data");
        com.transsion.postdetail.ui.adapter.l lVar = this.f48863b;
        if (lVar != null) {
            lVar.q(data);
        }
    }

    public final int i() {
        return this.f48869h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Fragment j() {
        return this.f48862a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final g k() {
        return this.f48864c;
    }

    public void n(int i11) {
        Subject subject;
        Video l11;
        com.transsion.postdetail.ui.adapter.l lVar = this.f48863b;
        if (lVar == null || (subject = (Subject) lVar.f0(i11 + this.f48867f)) == null || (l11 = l(subject)) == null) {
            return;
        }
        t(subject, l11);
    }

    public final void o() {
        if (this.f48870i) {
            this.f48870i = false;
            s(this.f48869h);
        }
    }

    @Override // com.transsion.baselib.report.l.a
    public void onBackgroundStatusChange(boolean z10) {
        if (z10 && !this.f48874m) {
            View view = this.f48872k;
            ShortTvImmVideoItemView shortTvImmVideoItemView = view instanceof ShortTvImmVideoItemView ? (ShortTvImmVideoItemView) view : null;
            if (shortTvImmVideoItemView != null) {
                shortTvImmVideoItemView.app2Background();
            }
        }
    }

    @Override // androidx.view.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        int i11 = b.f48875a[event.ordinal()];
        if (i11 == 1) {
            ORPlayerPreloadManager.f48463i.a().h();
            return;
        }
        if (i11 == 2) {
            ORPlayerPreloadManager.f48463i.a().k();
        } else {
            if (i11 != 3) {
                return;
            }
            l.f43413a.u(this);
            this.f48872k = null;
            this.f48862a.getLifecycle().d(this);
            k.d(o0.a(y0.b()), null, null, new SubjectVideoPagerChangeControl$onStateChanged$1(null), 3, null);
        }
    }

    public final void p(boolean z10) {
        this.f48874m = z10;
        if (z10) {
            View view = this.f48872k;
            ShortTvImmVideoItemView shortTvImmVideoItemView = view instanceof ShortTvImmVideoItemView ? (ShortTvImmVideoItemView) view : null;
            if (shortTvImmVideoItemView != null) {
                shortTvImmVideoItemView.app2Background();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void q(int i11, View view) {
        RecyclerView recyclerView;
        ORPlayerView oRPlayerView;
        this.f48872k = view;
        a.C0856a.f(lg.a.f68962a, "ImmVideoPlayer", "on page select position = " + i11, false, 4, null);
        u();
        if (i11 >= 0) {
            com.transsion.postdetail.ui.adapter.l lVar = this.f48863b;
            int i12 = 0;
            if ((lVar != null ? lVar.getItemCount() : 0) > i11 && (view instanceof ShortTvImmVideoItemView)) {
                ShortTvImmVideoItemView shortTvImmVideoItemView = (ShortTvImmVideoItemView) view;
                shortTvImmVideoItemView.setPosition(Integer.valueOf(i11));
                g gVar = this.f48864c;
                if (gVar != null && (oRPlayerView = this.f48865d) != null) {
                    shortTvImmVideoItemView.setPlayer(gVar, oRPlayerView);
                }
                PagerLayoutManager pagerLayoutManager = this.f48866e;
                if (pagerLayoutManager != null) {
                    shortTvImmVideoItemView.setPagerLayoutManager(pagerLayoutManager);
                }
                g gVar2 = this.f48864c;
                if (gVar2 != null) {
                    gVar2.setPlayerListener((com.transsion.player.orplayer.f) view);
                }
                com.transsion.postdetail.ui.adapter.l lVar2 = this.f48863b;
                Subject subject = lVar2 != null ? (Subject) lVar2.getItem(i11) : null;
                ORPlayerView oRPlayerView2 = this.f48865d;
                ViewParent parent = oRPlayerView2 != null ? oRPlayerView2.getParent() : null;
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).removeView(this.f48865d);
                }
                ORPlayerView oRPlayerView3 = this.f48865d;
                Video l11 = l(subject);
                com.transsion.postdetail.ui.adapter.l lVar3 = this.f48863b;
                if (lVar3 != null && (recyclerView = lVar3.getRecyclerView()) != null) {
                    i12 = recyclerView.getHeight();
                }
                shortTvImmVideoItemView.addVideoView(oRPlayerView3, l11, i12);
                shortTvImmVideoItemView.videoStartPrepare(this.f48873l);
                x(shortTvImmVideoItemView, subject);
                s(i11);
            }
        }
    }

    public final void r() {
        this.f48871j = true;
    }

    public void s(int i11) {
        int i12 = this.f48867f;
        if (i12 > 0 && this.f48863b != null) {
            boolean z10 = false;
            if (1 <= i12) {
                int i13 = 1;
                while (true) {
                    int i14 = i11 + i13;
                    if (i14 < 0 || this.f48863b.getItemCount() <= i14) {
                        break;
                    }
                    Subject subject = (Subject) this.f48863b.f0(i14);
                    if (subject != null && !subject.getBuiltIn()) {
                        Video l11 = l(subject);
                        if (l11 != null) {
                            a.C0856a.v(lg.a.f68962a, "ShortTvImmVideoPlayer", "try preload position = " + i14 + ", duration = " + l11.getDuration() + ", url = " + l11.getUrl(), false, 4, null);
                            t(subject, l11);
                        } else if (i14 == (this.f48867f + i11) - 1) {
                            z10 = true;
                        }
                    }
                    if (i13 == i12) {
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            if (z10) {
                n(i11);
            }
        }
    }

    public void t(Subject item, Video video) {
        Media video2;
        Cover cover;
        String url;
        Intrinsics.h(item, "item");
        Intrinsics.h(video, "video");
        String url2 = video.getUrl();
        if (url2 != null) {
            ORPlayerPreloadManager.f48463i.a().j(url2, this.f48868g);
        }
        ShortTVItem shortTVFirstEp = item.getShortTVFirstEp();
        if (shortTVFirstEp == null || (video2 = shortTVFirstEp.getVideo()) == null || (cover = video2.getCover()) == null || (url = cover.getUrl()) == null) {
            return;
        }
        f.a aVar = ej.f.f62005a;
        b.a aVar2 = jn.b.f66360e;
        f.a.j(aVar, f.a.e(aVar, url, aVar2.a(), false, true, 4, null), url, aVar2.a(), null, 8, null);
    }

    protected void u() {
        g gVar = this.f48864c;
        if (gVar != null) {
            gVar.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v(View view) {
        this.f48872k = view;
    }

    protected void w() {
        g gVar = this.f48864c;
        if (gVar != null) {
            gVar.stop();
        }
        g gVar2 = this.f48864c;
        if (gVar2 != null) {
            gVar2.reset();
        }
    }

    protected void x(ShortTvImmVideoItemView view, Subject subject) {
        String url;
        String url2;
        String str;
        boolean z10;
        Intrinsics.h(view, "view");
        Video l11 = l(subject);
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "ImmVideoPlayer", "play url=" + (l11 != null ? l11.getUrl() : null) + "  width:" + (l11 != null ? l11.getWidth() : null) + ",height:" + (l11 != null ? l11.getHeight() : null) + ", duration: " + (l11 != null ? l11.getDuration() : null) + ", builtIn = " + (subject != null ? Boolean.valueOf(subject.getBuiltIn()) : null), false, 4, null);
        g gVar = this.f48864c;
        if (gVar != null) {
            if (subject != null) {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    z10 = true;
                    gVar.setLooping(!z10);
                }
            }
            z10 = false;
            gVar.setLooping(!z10);
        }
        if (subject == null || !subject.getBuiltIn()) {
            if (l11 == null || (url = l11.getUrl()) == null) {
                return;
            }
            g gVar2 = this.f48864c;
            if (gVar2 != null) {
                gVar2.setDataSource(new e(url, url, 0, null, null, 28, null));
            }
            g gVar3 = this.f48864c;
            if (gVar3 != null) {
                gVar3.prepare();
            }
            view.setVideoUrl(url);
            ORPlayerPreloadManager.f48463i.a().g(url);
            return;
        }
        if (l11 == null || (url2 = l11.getUrl()) == null) {
            return;
        }
        if (StringsKt.W(url2, "main/", false, 2, null)) {
            String absolutePath = DownloadEsHelper.f59542m.a().g().getAbsolutePath();
            String title = subject.getTitle();
            if (title == null) {
                title = "";
            }
            String str2 = absolutePath + "/" + (title + ".mp4");
            l11.setUrl(str2);
            str = str2;
        } else {
            str = url2;
        }
        a.C0856a.f(c0856a, "ImmVideoPlayer", "play url= " + str, false, 4, null);
        g gVar4 = this.f48864c;
        if (gVar4 != null) {
            gVar4.setDataSource(new e(str, str, 0, null, null, 28, null));
        }
        g gVar5 = this.f48864c;
        if (gVar5 != null) {
            gVar5.prepare();
        }
        view.setVideoUrl(url2);
    }
}
