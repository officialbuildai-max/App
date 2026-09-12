package com.transsion.postdetail.control;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.view.Lifecycle;
import androidx.view.u;
import ao.e;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.g;
import com.transsion.player.shorttv.preload.q;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.ui.adapter.l;
import com.transsion.postdetail.ui.view.ShortTvImmVideoItemView;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class a extends SubjectVideoPagerChangeControl {

    /* renamed from: o, reason: collision with root package name */
    public static final C0643a f48892o = new C0643a(null);

    /* renamed from: com.transsion.postdetail.control.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0643a {
        private C0643a() {
        }

        public /* synthetic */ C0643a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Subject subject) {
            String url;
            ShortTVItem shortTVFirstEp;
            Media video;
            Video videoAddress = (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress();
            if (subject == null || !subject.getBuiltIn()) {
                if (videoAddress != null) {
                    return videoAddress.getUrl();
                }
                return null;
            }
            if (videoAddress == null || (url = videoAddress.getUrl()) == null) {
                return null;
            }
            if (!StringsKt.W(url, "main/", false, 2, null)) {
                return url;
            }
            String absolutePath = DownloadEsHelper.f59542m.a().g().getAbsolutePath();
            String title = subject.getTitle();
            if (title == null) {
                title = "";
            }
            String str = absolutePath + "/" + (title + ".mp4");
            videoAddress.setUrl(str);
            return str;
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48893a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f48893a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Fragment fragment, l lVar, g gVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager) {
        super(fragment, lVar, gVar, oRPlayerView, pagerLayoutManager);
        Intrinsics.h(fragment, "fragment");
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl, cs.a
    public void e(boolean z10, int i11, View view) {
        super.e(z10, i11, view);
        if (view instanceof ShortTvImmVideoItemView) {
            ((ShortTvImmVideoItemView) view).onPlayerReset();
        }
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void g(List datas) {
        g k11;
        g k12;
        Media video;
        Intrinsics.h(datas, "datas");
        super.g(datas);
        Iterator it = datas.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Subject subject = (Subject) it.next();
            ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
            Video videoAddress = (shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress();
            a.C0856a c0856a = lg.a.f68962a;
            String url = videoAddress != null ? videoAddress.getUrl() : null;
            Integer width = videoAddress != null ? videoAddress.getWidth() : null;
            Integer height = videoAddress != null ? videoAddress.getHeight() : null;
            Integer duration = videoAddress != null ? videoAddress.getDuration() : null;
            a.C0856a.f(c0856a, "ShortTvImmVideoPlayer", "play url=" + url + "  width:" + width + ",height:" + height + ", duration: " + duration + ", builtIn = " + Boolean.valueOf(subject.getBuiltIn()), false, 4, null);
            String a11 = f48892o.a(subject);
            if (a11 != null && (k12 = k()) != null) {
                ShortTVItem shortTVFirstEp2 = subject.getShortTVFirstEp();
                boolean addDataSource = k12.addDataSource(new e(shortTVFirstEp2 != null ? shortTVFirstEp2.getId() : null, a11, 0, null, null, 28, null));
                if (!z10) {
                    z10 = addDataSource;
                }
            }
        }
        if (!z10 || (k11 = k()) == null) {
            return;
        }
        k11.prepare();
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void n(int i11) {
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl, androidx.view.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        if (b.f48893a[event.ordinal()] == 1) {
            com.transsion.baselib.report.l.f43413a.u(this);
            v(null);
            j().getLifecycle().d(this);
            g k11 = k();
            if (k11 != null) {
                k11.release();
            }
        }
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    protected void q(int i11, View view) {
        super.q(i11, view);
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void s(int i11) {
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void t(Subject item, Video video) {
        Intrinsics.h(item, "item");
        Intrinsics.h(video, "video");
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    protected void u() {
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    protected void w() {
        g k11 = k();
        if (k11 != null) {
            k11.pause();
        }
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    protected void x(ShortTvImmVideoItemView view, Subject subject) {
        ShortTVItem shortTVFirstEp;
        Media video;
        Intrinsics.h(view, "view");
        Video videoAddress = (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress();
        a.C0856a.f(lg.a.f68962a, "ShortTvImmVideoPlayer", "play url=" + (videoAddress != null ? videoAddress.getUrl() : null) + "  width:" + (videoAddress != null ? videoAddress.getWidth() : null) + ",height:" + (videoAddress != null ? videoAddress.getHeight() : null) + ", duration: " + (videoAddress != null ? videoAddress.getDuration() : null) + ", builtIn = " + (subject != null ? Boolean.valueOf(subject.getBuiltIn()) : null), false, 4, null);
        String a11 = f48892o.a(subject);
        if (a11 == null) {
            g k11 = k();
            if (k11 != null) {
                k11.pause();
                return;
            }
            return;
        }
        g k12 = k();
        if (k12 != null) {
            k12.seekTo(q.f48593a.G(a11), 0L);
        }
        g k13 = k();
        if (k13 != null) {
            k13.play();
        }
        view.setVideoUrl(a11);
    }
}
