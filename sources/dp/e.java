package dp;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.y;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.baselib.report.l;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.g;
import com.transsion.player.p007enum.ScaleMode;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.adapter.i;
import com.transsion.postdetail.video.PostFeedVideoView;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Iterator;
import java.util.List;
import ko.l0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;
import nh.m;
import so.g0;

/* loaded from: classes6.dex */
public final class e extends RecyclerView.r implements a, com.transsion.player.orplayer.f, l.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f61504a;

    /* renamed from: b, reason: collision with root package name */
    private final Fragment f61505b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView f61506c;

    /* renamed from: d, reason: collision with root package name */
    private final i f61507d;

    /* renamed from: e, reason: collision with root package name */
    private final String f61508e;

    /* renamed from: f, reason: collision with root package name */
    private final String f61509f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f61510g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f61511h;

    /* renamed from: i, reason: collision with root package name */
    private final int f61512i;

    /* renamed from: j, reason: collision with root package name */
    private final int f61513j;

    /* renamed from: k, reason: collision with root package name */
    private g f61514k;

    /* renamed from: l, reason: collision with root package name */
    private PostFeedVideoView f61515l;

    /* renamed from: m, reason: collision with root package name */
    private com.transsion.postdetail.layer.b f61516m;

    /* renamed from: n, reason: collision with root package name */
    private int f61517n;

    /* renamed from: o, reason: collision with root package name */
    private String f61518o;

    /* renamed from: p, reason: collision with root package name */
    private int f61519p;

    /* renamed from: q, reason: collision with root package name */
    private long f61520q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f61521r;

    /* renamed from: s, reason: collision with root package name */
    private g0 f61522s;

    /* renamed from: t, reason: collision with root package name */
    private int f61523t;

    /* renamed from: u, reason: collision with root package name */
    private float f61524u;

    public e(Context context, Fragment fragment, RecyclerView recyclerView, i iVar, String pageName, String subpageName, boolean z10) {
        Intrinsics.h(context, "context");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(subpageName, "subpageName");
        this.f61504a = context;
        this.f61505b = fragment;
        this.f61506c = recyclerView;
        this.f61507d = iVar;
        this.f61508e = pageName;
        this.f61509f = subpageName;
        this.f61510g = z10;
        this.f61512i = dk.a.b(82);
        this.f61513j = dk.a.b(56);
        this.f61517n = -1;
        this.f61519p = y.a();
        this.f61521r = true;
        this.f61524u = 1.0f;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this);
        }
        l.f43413a.g(this);
        o();
        if (recyclerView != null) {
            recyclerView.postDelayed(new Runnable() { // from class: dp.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(e.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e eVar) {
        eVar.h();
    }

    private final void h() {
        PostSubjectItem postSubjectItem;
        List<Object> data;
        RecyclerView recyclerView = this.f61506c;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || !m.f70597a.e()) {
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        IntProgression p11 = this.f61523t > 0 ? RangesKt.p(findLastVisibleItemPosition, findFirstVisibleItemPosition) : new IntRange(findFirstVisibleItemPosition, findLastVisibleItemPosition);
        int first = p11.getFirst();
        int last = p11.getLast();
        int step = p11.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(first);
            if (findViewByPosition != null) {
                Rect rect = new Rect();
                findViewByPosition.getGlobalVisibleRect(rect);
                int height = findViewByPosition.getHeight();
                int f11 = RangesKt.f(rect.bottom - (height / 2), rect.top);
                int i11 = (this.f61519p - this.f61512i) / 2;
                int b11 = i11 - dk.a.b(200);
                int b12 = dk.a.b(250) + i11;
                i iVar = this.f61507d;
                if (first >= ((iVar == null || (data = iVar.getData()) == null) ? 0 : data.size())) {
                    return;
                }
                i iVar2 = this.f61507d;
                if (iVar2 != null && (postSubjectItem = (PostSubjectItem) iVar2.getItem(first)) != null) {
                    if (Intrinsics.c(this.f61518o, postSubjectItem.getPostId())) {
                        a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "triggerVideoPlay position:" + first + " same ~ return", false, 4, null);
                        return;
                    }
                    if (postSubjectItem.isVideo()) {
                        View p02 = this.f61507d.p0(first, R$id.layout_content_video);
                        FrameLayout frameLayout = p02 instanceof FrameLayout ? (FrameLayout) p02 : null;
                        if (frameLayout == null) {
                            a.C0856a.l(lg.a.f68962a, "PostFeedVideo", "triggerVideoPlay itemVideoContainer is null", false, 4, null);
                        } else {
                            a.C0856a.r(lg.a.f68962a, "PostFeedVideo", new String[]{StringsKt.n("\n                checkActiveItemPosition position:" + first + ",  \n                    top:" + rect.top + ", bottom:" + rect.bottom + "\n                    screenCenterTop：" + b11 + "   screenCenterBottom：" + b12 + "\n                    itemHeight:" + height + " viewCenter:" + f11 + ", screenCenter:" + i11 + "\n            ")}, false, 4, null);
                            if (Math.abs(i11 - f11) < dk.a.b(Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE)) {
                                p(first, postSubjectItem, frameLayout);
                                return;
                            }
                        }
                    }
                }
            }
            if (first == last) {
                return;
            } else {
                first += step;
            }
        }
    }

    private final void i(RecyclerView recyclerView) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        while (true) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition != null) {
                findViewByPosition.getGlobalVisibleRect(new Rect());
                if (r3.bottom - r3.top <= findViewByPosition.getHeight() * 0.5f) {
                    m(findFirstVisibleItemPosition);
                }
            }
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return;
            } else {
                findFirstVisibleItemPosition++;
            }
        }
    }

    private final void j(Context context) {
        if (this.f61514k == null) {
            PostFeedVideoView postFeedVideoView = new PostFeedVideoView(context);
            postFeedVideoView.updateMute(this.f61521r);
            postFeedVideoView.setMuteClickCallback(new Function1() { // from class: dp.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k11;
                    k11 = e.k(e.this, ((Boolean) obj).booleanValue());
                    return k11;
                }
            });
            postFeedVideoView.setRemovePlayerCallback(new Function0() { // from class: dp.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit l11;
                    l11 = e.l(e.this);
                    return l11;
                }
            });
            this.f61515l = postFeedVideoView;
            g s11 = l0.f67091a.s();
            a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "createPlayer----", false, 4, null);
            s11.addPlayerListener(this);
            PostFeedVideoView postFeedVideoView2 = this.f61515l;
            s11.setSurfaceView(postFeedVideoView2 != null ? postFeedVideoView2.getSurfaceView() : null);
            s11.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
            this.f61514k = s11;
        }
        if (this.f61516m == null) {
            com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
            g gVar = this.f61514k;
            Intrinsics.e(gVar);
            bVar.v(gVar);
            bVar.u(this.f61508e);
            bVar.z(this.f61509f);
            this.f61516m = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(e eVar, boolean z10) {
        a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "volume click isMute:" + z10, false, 4, null);
        eVar.f61521r = z10;
        g gVar = eVar.f61514k;
        if (gVar != null) {
            gVar.setVolume(z10 ? 0.0f : eVar.f61524u);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(e eVar) {
        eVar.n();
        return Unit.f67184a;
    }

    private final void m(int i11) {
        List<Object> data;
        try {
            Result.Companion companion = Result.INSTANCE;
            PostFeedVideoView postFeedVideoView = this.f61515l;
            if ((postFeedVideoView != null ? postFeedVideoView.getParent() : null) != null && this.f61517n == i11) {
                i iVar = this.f61507d;
                if (i11 >= ((iVar == null || (data = iVar.getData()) == null) ? 0 : data.size())) {
                    return;
                }
                i iVar2 = this.f61507d;
                PostSubjectItem postSubjectItem = iVar2 != null ? (PostSubjectItem) iVar2.getItem(i11) : null;
                if (postSubjectItem != null && postSubjectItem.isVideo()) {
                    a.C0856a c0856a = lg.a.f68962a;
                    Group group = postSubjectItem.getGroup();
                    String name = group != null ? group.getName() : null;
                    a.C0856a.f(c0856a, "PostFeedVideo", "position：" + i11 + " --已隐藏超过50%, 移除播放器, " + name + ", " + postSubjectItem.getContent(), false, 4, null);
                    n();
                }
                Result.m1185constructorimpl(Unit.f67184a);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final void n() {
        AppCompatImageView appCompatImageView;
        BLTextView bLTextView;
        ShapeableImageView shapeableImageView;
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        g0 g0Var = this.f61522s;
        if (g0Var != null && (shapeableImageView = g0Var.f75654d) != null) {
            jg.c.k(shapeableImageView);
        }
        g0 g0Var2 = this.f61522s;
        if (g0Var2 != null && (bLTextView = g0Var2.f75656f) != null) {
            jg.c.k(bLTextView);
        }
        g0 g0Var3 = this.f61522s;
        if (g0Var3 != null && (appCompatImageView = g0Var3.f75655e) != null) {
            jg.c.k(appCompatImageView);
        }
        this.f61522s = null;
        PostFeedVideoView postFeedVideoView = this.f61515l;
        ViewParent parent = postFeedVideoView != null ? postFeedVideoView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f61515l);
        }
        g gVar = this.f61514k;
        if (gVar != null) {
            gVar.stop();
        }
        g gVar2 = this.f61514k;
        if (gVar2 != null) {
            gVar2.reset();
        }
        g gVar3 = this.f61514k;
        if (gVar3 != null) {
            gVar3.clearScreen();
        }
        this.f61517n = -1;
        this.f61518o = null;
        ep.c.f62095a.a();
    }

    private final void o() {
        Boolean m12;
        Boolean bool;
        boolean z10 = true;
        if (!Intrinsics.c(this.f61511h, Boolean.TRUE)) {
            ConfigBean c11 = sm.f.f75530c.a().c("sa_post_video_auto_play", true);
            String value = c11 != null ? c11.getValue() : null;
            if (value == null || value.length() == 0) {
                bool = Boolean.FALSE;
            } else {
                Boolean m13 = StringsKt.m1(value);
                bool = Boolean.valueOf(m13 != null ? m13.booleanValue() : false);
            }
            this.f61511h = bool;
        }
        ConfigBean c12 = sm.f.f75530c.a().c("room_home_video_play_mute", true);
        String value2 = c12 != null ? c12.getValue() : null;
        if (value2 != null && value2.length() != 0 && (m12 = StringsKt.m1(value2)) != null) {
            z10 = m12.booleanValue();
        }
        this.f61521r = z10;
        a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "----------------initConfig, isOpen:" + this.f61511h + "+------+isVideoMute:" + z10, false, 4, null);
    }

    private final void p(int i11, PostSubjectItem postSubjectItem, FrameLayout frameLayout) {
        List<Video> video;
        AppCompatImageView appCompatImageView;
        FrameLayout frameLayout2;
        a.C0856a c0856a = lg.a.f68962a;
        Group group = postSubjectItem.getGroup();
        Object obj = null;
        String name = group != null ? group.getName() : null;
        a.C0856a.r(c0856a, "PostFeedVideo", new String[]{"-------> triggerVideoPlay 播放视频:" + i11 + ", roomName:" + name + ", " + postSubjectItem.getContent()}, false, 4, null);
        n();
        j(this.f61504a);
        g0 a11 = g0.a(frameLayout);
        this.f61522s = a11;
        if (a11 != null && (frameLayout2 = a11.f75652b) != null) {
            frameLayout2.addView(this.f61515l);
        }
        g0 g0Var = this.f61522s;
        if (g0Var != null && (appCompatImageView = g0Var.f75655e) != null) {
            jg.c.g(appCompatImageView);
        }
        this.f61517n = i11;
        this.f61518o = postSubjectItem.getPostId();
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            bVar.g();
        }
        com.transsion.postdetail.layer.b bVar2 = this.f61516m;
        if (bVar2 != null) {
            bVar2.a(0, 0);
        }
        com.transsion.postdetail.layer.b bVar3 = this.f61516m;
        if (bVar3 != null) {
            bVar3.x(postSubjectItem.getPostId(), postSubjectItem);
        }
        Media media = postSubjectItem.getMedia();
        if (media == null || (video = media.getVideo()) == null) {
            return;
        }
        Iterator<T> it = video.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String url = ((Video) next).getUrl();
            if (!(url == null || url.length() == 0)) {
                obj = next;
                break;
            }
        }
        Video video2 = (Video) obj;
        if (video2 != null) {
            Integer duration = video2.getDuration();
            if (duration != null) {
                int intValue = duration.intValue();
                PostFeedVideoView postFeedVideoView = this.f61515l;
                if (postFeedVideoView != null) {
                    postFeedVideoView.setDurationTime(intValue * 1000);
                }
            }
            a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "triggerVideoPlay updateMute:" + this.f61521r, false, 4, null);
            PostFeedVideoView postFeedVideoView2 = this.f61515l;
            if (postFeedVideoView2 != null) {
                postFeedVideoView2.updateMute(this.f61521r);
            }
            String url2 = video2.getUrl();
            if (url2 != null) {
                com.transsion.postdetail.layer.b bVar4 = this.f61516m;
                if (bVar4 != null) {
                    bVar4.A(url2);
                }
                g gVar = this.f61514k;
                if (gVar != null) {
                    gVar.setDataSource(new ao.e(url2, url2, 0, null, null, 28, null));
                }
                g gVar2 = this.f61514k;
                if (gVar2 != null) {
                    gVar2.prepare();
                }
            }
        }
    }

    @Override // dp.a
    public void a() {
        a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "onSetFirstData--checkActiveItemPosition", false, 4, null);
        h();
    }

    @Override // dp.a
    public void b() {
        g gVar;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "PostFeedVideo", "onPagePause--", false, 4, null);
        g gVar2 = this.f61514k;
        if (gVar2 != null) {
            gVar2.pause();
        }
        String str = this.f61518o;
        if (str == null || (gVar = this.f61514k) == null) {
            return;
        }
        long currentPosition = gVar.getCurrentPosition();
        if (currentPosition > 0) {
            a.C0856a.v(c0856a, "PostFeedVideo", "==feedvideo savePlayProgress:" + currentPosition, false, 4, null);
            ep.c.f62095a.c(str, currentPosition);
        }
    }

    @Override // dp.a
    public void c() {
        Long b11;
        o();
        String str = this.f61518o;
        if (str != null && (b11 = ep.c.f62095a.b(str)) != null) {
            long longValue = b11.longValue();
            if (longValue > 0) {
                a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "==onPageResume seekTo:" + longValue, false, 4, null);
                g gVar = this.f61514k;
                if (gVar != null) {
                    gVar.seekTo(longValue);
                }
            }
        }
        a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "onPageResume play", false, 4, null);
        g gVar2 = this.f61514k;
        if (gVar2 != null) {
            gVar2.play();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        f.a.c(this, eVar);
    }

    @Override // com.transsion.baselib.report.l.a
    public void onBackgroundStatusChange(boolean z10) {
        com.transsion.postdetail.layer.b bVar;
        if (z10 && (bVar = this.f61516m) != null) {
            bVar.d(true);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e eVar) {
        f.a.e(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        f.a.h(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e eVar) {
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            bVar.h();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e eVar) {
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        f.a.o(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // dp.a
    public void onPageDestroy() {
        a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "onPageDestroy", false, 4, null);
        RecyclerView recyclerView = this.f61506c;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this);
        }
        g gVar = this.f61514k;
        this.f61514k = null;
        if (gVar != null) {
            gVar.removePlayerListener(this);
        }
        if (gVar != null) {
            gVar.release();
        }
        PostFeedVideoView postFeedVideoView = this.f61515l;
        ViewParent parent = postFeedVideoView != null ? postFeedVideoView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f61515l);
        }
        this.f61515l = null;
        ep.c.f62095a.a();
        l.f43413a.u(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e eVar) {
        Intrinsics.h(errorInfo, "errorInfo");
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            bVar.k(errorInfo);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        f.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        f.a.v(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e eVar) {
        Float volume;
        a.C0856a.v(lg.a.f68962a, "PostFeedVideo", "----------onPrepare Position:" + this.f61517n + "， isVideoMute：" + this.f61521r, false, 4, null);
        g gVar = this.f61514k;
        if (gVar != null) {
            gVar.setLooping(true);
        }
        g gVar2 = this.f61514k;
        if (gVar2 != null) {
            gVar2.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        }
        PostFeedVideoView postFeedVideoView = this.f61515l;
        if (postFeedVideoView != null) {
            g gVar3 = this.f61514k;
            postFeedVideoView.setProgressMax(gVar3 != null ? (int) gVar3.getDuration() : 100);
        }
        if (!this.f61505b.isResumed() || this.f61505b.isHidden()) {
            g gVar4 = this.f61514k;
            if (gVar4 != null) {
                gVar4.pause();
            }
        } else {
            g gVar5 = this.f61514k;
            if (gVar5 != null) {
                gVar5.play();
            }
        }
        if (!this.f61521r) {
            g gVar6 = this.f61514k;
            this.f61524u = (gVar6 == null || (volume = gVar6.getVolume()) == null) ? 1.0f : volume.floatValue();
        }
        g gVar7 = this.f61514k;
        if (gVar7 != null) {
            gVar7.setVolume(this.f61521r ? 0.0f : 1.0f);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long j11, ao.e eVar) {
        PostFeedVideoView postFeedVideoView = this.f61515l;
        if (postFeedVideoView != null) {
            postFeedVideoView.setProgress((int) j11);
        }
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            bVar.l(j11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        BLTextView bLTextView;
        ShapeableImageView shapeableImageView;
        a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "-----onRenderFirstFrame Position:" + this.f61517n, false, 4, null);
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            bVar.m();
        }
        PostFeedVideoView postFeedVideoView = this.f61515l;
        if (postFeedVideoView != null) {
            postFeedVideoView.setProgress(0);
        }
        g0 g0Var = this.f61522s;
        if (g0Var != null && (shapeableImageView = g0Var.f75654d) != null) {
            jg.c.g(shapeableImageView);
        }
        g0 g0Var2 = this.f61522s;
        if (g0Var2 == null || (bLTextView = g0Var2.f75656f) == null) {
            return;
        }
        jg.c.g(bLTextView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (Intrinsics.c(this.f61511h, Boolean.TRUE) && i11 == 0) {
            h();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        if (Intrinsics.c(this.f61511h, Boolean.TRUE)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f61520q < 100) {
                return;
            }
            this.f61520q = currentTimeMillis;
            i(recyclerView);
            this.f61523t = i12;
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        f.a.C(this, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c cVar) {
        f.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        f.a.E(this, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(ao.e eVar) {
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            bVar.n();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        a.C0856a.f(lg.a.f68962a, "PostFeedVideo", "-----onVideoStart Position:" + this.f61517n, false, 4, null);
        com.transsion.postdetail.layer.b bVar = this.f61516m;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }
}
