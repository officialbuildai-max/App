package com.transsion.postdetail.control;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.view.Lifecycle;
import androidx.view.r;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.transsion.baselib.report.l;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.g;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.adapter.e;
import com.transsion.postdetail.ui.view.ImmVideoItemView;
import com.transsion.postdetail.util.u;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.transsnet.downloader.manager.DownloadEsHelper;
import ej.f;
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
public abstract class VideoPagerChangeControl extends cs.a implements r, l.a {

    /* renamed from: o, reason: collision with root package name */
    public static final a f48876o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f48877a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f48878b;

    /* renamed from: c, reason: collision with root package name */
    private final e f48879c;

    /* renamed from: d, reason: collision with root package name */
    private final g f48880d;

    /* renamed from: e, reason: collision with root package name */
    private final ORPlayerView f48881e;

    /* renamed from: f, reason: collision with root package name */
    private PagerLayoutManager f48882f;

    /* renamed from: g, reason: collision with root package name */
    private String f48883g;

    /* renamed from: h, reason: collision with root package name */
    private final int f48884h;

    /* renamed from: i, reason: collision with root package name */
    private final long f48885i;

    /* renamed from: j, reason: collision with root package name */
    private int f48886j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f48887k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f48888l;

    /* renamed from: m, reason: collision with root package name */
    private View f48889m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f48890n;

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
        public static final /* synthetic */ int[] f48891a;

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
            f48891a = iArr;
        }
    }

    public VideoPagerChangeControl(Fragment fragment, boolean z10, e eVar, g gVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager, String str) {
        Intrinsics.h(fragment, "fragment");
        this.f48877a = fragment;
        this.f48878b = z10;
        this.f48879c = eVar;
        this.f48880d = gVar;
        this.f48881e = oRPlayerView;
        this.f48882f = pagerLayoutManager;
        this.f48883g = str;
        this.f48884h = 3;
        this.f48885i = 3000L;
        this.f48887k = true;
        fragment.getLifecycle().a(this);
        i();
    }

    private final void g() {
        f h02;
        e eVar = this.f48879c;
        if (((eVar == null || (h02 = eVar.h0()) == null) ? null : h02.i()) == LoadMoreStatus.Fail && m.f70597a.e()) {
            a.C0856a.f(lg.a.f68962a, "ImmVideoPlayer", "current is fail, try load more", false, 4, null);
            this.f48879c.h0().w();
        }
    }

    private final void i() {
        l.f43413a.g(this);
    }

    private final void j(int i11) {
        PostSubjectItem postSubjectItem;
        e eVar = this.f48879c;
        if (eVar == null || (postSubjectItem = (PostSubjectItem) eVar.f0(i11 + this.f48884h)) == null) {
            return;
        }
        Media media = postSubjectItem.getMedia();
        Video a11 = u.a(media != null ? media.getVideo() : null);
        if (a11 == null) {
            return;
        }
        p(postSubjectItem, a11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(int i11, View view) {
        ORPlayerView oRPlayerView;
        this.f48889m = view;
        a.C0856a.f(lg.a.f68962a, "ImmVideoPlayer", "on page select position = " + i11, false, 4, null);
        g gVar = this.f48880d;
        if (gVar != null) {
            gVar.reset();
        }
        if (i11 >= 0) {
            e eVar = this.f48879c;
            if ((eVar != null ? eVar.getItemCount() : 0) > i11 && (view instanceof ImmVideoItemView)) {
                ImmVideoItemView immVideoItemView = (ImmVideoItemView) view;
                immVideoItemView.setPosition(Integer.valueOf(i11));
                g gVar2 = this.f48880d;
                if (gVar2 != null && (oRPlayerView = this.f48881e) != null) {
                    immVideoItemView.setPlayer(gVar2, oRPlayerView);
                }
                PagerLayoutManager pagerLayoutManager = this.f48882f;
                if (pagerLayoutManager != null) {
                    immVideoItemView.setPagerLayoutManager(pagerLayoutManager);
                }
                g gVar3 = this.f48880d;
                if (gVar3 != null) {
                    gVar3.setPlayerListener((com.transsion.player.orplayer.f) view);
                }
                e eVar2 = this.f48879c;
                PostSubjectItem postSubjectItem = eVar2 != null ? (PostSubjectItem) eVar2.getItem(i11) : null;
                ORPlayerView oRPlayerView2 = this.f48881e;
                ViewParent parent = oRPlayerView2 != null ? oRPlayerView2.getParent() : null;
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).removeView(this.f48881e);
                }
                immVideoItemView.getPlayerContainer().addView(this.f48881e, new FrameLayout.LayoutParams(-1, -1));
                if (this.f48878b) {
                    this.f48878b = false;
                    immVideoItemView.showCommentDialog();
                }
                immVideoItemView.videoStartPrepare(this.f48883g);
                q(immVideoItemView, postSubjectItem);
                o(i11);
            }
        }
    }

    private final void o(int i11) {
        int i12 = this.f48884h;
        if (i12 > 0 && this.f48879c != null) {
            boolean z10 = false;
            if (1 <= i12) {
                int i13 = 1;
                while (true) {
                    int i14 = i11 + i13;
                    if (i14 < 0 || this.f48879c.getItemCount() <= i14) {
                        break;
                    }
                    PostSubjectItem postSubjectItem = (PostSubjectItem) this.f48879c.f0(i14);
                    if (postSubjectItem != null && !postSubjectItem.getBuiltIn()) {
                        Media media = postSubjectItem.getMedia();
                        Video a11 = u.a(media != null ? media.getVideo() : null);
                        if (a11 != null) {
                            a.C0856a.v(lg.a.f68962a, "ImmVideoPlayer", "try preload position = " + i14 + ", duration = " + a11.getDuration() + ", url = " + a11.getUrl(), false, 4, null);
                            p(postSubjectItem, a11);
                        } else if (i14 == (this.f48884h + i11) - 1) {
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
                j(i11);
            }
        }
    }

    private final void p(PostSubjectItem postSubjectItem, Video video) {
        FirstFrame firstFrame;
        String url;
        String url2 = video.getUrl();
        if (url2 != null) {
            ORPlayerPreloadManager.f48463i.a().j(url2, this.f48885i);
        }
        Media media = postSubjectItem.getMedia();
        if (media == null || (firstFrame = media.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        f.a aVar = ej.f.f62005a;
        b.a aVar2 = jn.b.f66360e;
        f.a.j(aVar, f.a.e(aVar, url, aVar2.a(), false, true, 4, null), url, aVar2.a(), null, 8, null);
    }

    @Override // cs.a
    public void d(View view) {
        PagerLayoutManager pagerLayoutManager = this.f48882f;
        if (pagerLayoutManager != null) {
            int findFirstVisibleItemPosition = pagerLayoutManager.findFirstVisibleItemPosition();
            a.C0856a.v(lg.a.f68962a, "ImmVideoPlayer", "onInitComplete, position = " + findFirstVisibleItemPosition + ", ----- currentPosition = " + this.f48886j, false, 4, null);
            if (this.f48886j == findFirstVisibleItemPosition) {
                return;
            }
            if (findFirstVisibleItemPosition != -1) {
                this.f48886j = findFirstVisibleItemPosition;
            }
            m(this.f48886j, view);
        }
    }

    @Override // cs.a
    public void e(boolean z10, int i11, View view) {
        a.C0856a.v(lg.a.f68962a, "ImmVideoPlayer", "onPageRelease, position = " + i11 + ", ----- currentPosition = " + this.f48886j, false, 4, null);
        if (i11 == this.f48886j) {
            g gVar = this.f48880d;
            if (gVar != null) {
                gVar.stop();
            }
            g gVar2 = this.f48880d;
            if (gVar2 != null) {
                gVar2.reset();
            }
            ORPlayerView oRPlayerView = this.f48881e;
            ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).removeView(this.f48881e);
            }
        }
    }

    @Override // cs.a
    public void f(int i11, boolean z10, View view) {
        g();
        a.C0856a.f(lg.a.f68962a, "ImmVideoPlayer", "onPageSelected, position = " + i11 + ", ----- currentPosition = " + this.f48886j, false, 4, null);
        if (this.f48886j != i11 || this.f48888l) {
            this.f48888l = false;
            this.f48886j = i11;
            ImmVideoHelper.a aVar = ImmVideoHelper.f48894h;
            if (aVar.a().n()) {
                aVar.a().t();
            }
            m(i11, view);
        }
    }

    public final int h() {
        return this.f48886j;
    }

    public final void k() {
        if (this.f48887k) {
            this.f48887k = false;
            o(this.f48886j);
        }
    }

    public final void l(boolean z10) {
        this.f48890n = z10;
        if (z10) {
            View view = this.f48889m;
            ImmVideoItemView immVideoItemView = view instanceof ImmVideoItemView ? (ImmVideoItemView) view : null;
            if (immVideoItemView != null) {
                immVideoItemView.app2Background();
            }
        }
    }

    public final void n() {
        this.f48888l = true;
    }

    @Override // com.transsion.baselib.report.l.a
    public void onBackgroundStatusChange(boolean z10) {
        if (z10 && !this.f48890n) {
            View view = this.f48889m;
            ImmVideoItemView immVideoItemView = view instanceof ImmVideoItemView ? (ImmVideoItemView) view : null;
            if (immVideoItemView != null) {
                immVideoItemView.app2Background();
            }
        }
    }

    @Override // androidx.view.r
    public void onStateChanged(androidx.view.u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        int i11 = b.f48891a[event.ordinal()];
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
            this.f48889m = null;
            this.f48877a.getLifecycle().d(this);
            k.d(o0.a(y0.b()), null, null, new VideoPagerChangeControl$onStateChanged$1(null), 3, null);
        }
    }

    protected final void q(ImmVideoItemView view, PostSubjectItem postSubjectItem) {
        String url;
        String url2;
        String str;
        boolean z10;
        Subject subject;
        Media media;
        Intrinsics.h(view, "view");
        Video a11 = u.a((postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getVideo());
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "ImmVideoPlayer", "play url=" + (a11 != null ? a11.getUrl() : null) + "  width:" + (a11 != null ? a11.getWidth() : null) + ",height:" + (a11 != null ? a11.getHeight() : null) + ", duration: " + (a11 != null ? a11.getDuration() : null) + ", builtIn = " + (postSubjectItem != null ? Boolean.valueOf(postSubjectItem.getBuiltIn()) : null), false, 4, null);
        g gVar = this.f48880d;
        if (gVar != null) {
            if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
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
        if (postSubjectItem == null || !postSubjectItem.getBuiltIn()) {
            if (a11 == null || (url = a11.getUrl()) == null) {
                return;
            }
            g gVar2 = this.f48880d;
            if (gVar2 != null) {
                gVar2.setDataSource(new ao.e(url, url, 0, null, null, 28, null));
            }
            g gVar3 = this.f48880d;
            if (gVar3 != null) {
                gVar3.prepare();
            }
            view.setVideoUrl(url);
            ORPlayerPreloadManager.f48463i.a().g(url);
            return;
        }
        if (a11 == null || (url2 = a11.getUrl()) == null) {
            return;
        }
        if (StringsKt.W(url2, "main/", false, 2, null)) {
            String absolutePath = DownloadEsHelper.f59542m.a().g().getAbsolutePath();
            String title = postSubjectItem.getTitle();
            if (title == null) {
                Subject subject2 = postSubjectItem.getSubject();
                String title2 = subject2 != null ? subject2.getTitle() : null;
                title = title2 == null ? "" : title2;
            }
            String str2 = absolutePath + "/" + (title + ".mp4");
            a11.setUrl(str2);
            str = str2;
        } else {
            str = url2;
        }
        a.C0856a.f(c0856a, "ImmVideoPlayer", "play url= " + str, false, 4, null);
        g gVar4 = this.f48880d;
        if (gVar4 != null) {
            gVar4.setDataSource(new ao.e(str, str, 0, null, null, 28, null));
        }
        g gVar5 = this.f48880d;
        if (gVar5 != null) {
            gVar5.prepare();
        }
        view.setVideoUrl(url2);
    }
}
