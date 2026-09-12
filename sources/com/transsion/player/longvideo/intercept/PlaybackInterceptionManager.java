package com.transsion.player.longvideo.intercept;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.MemberSource;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.longvideo.intercept.PlaybackInterceptionManager;
import com.transsion.player.longvideo.intercept.d;
import com.transsion.player.longvideo.ui.LongVodUiType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class PlaybackInterceptionManager {

    /* renamed from: b */
    private boolean f48105b;

    /* renamed from: c */
    private ho.j f48106c;

    /* renamed from: d */
    private go.a f48107d;

    /* renamed from: e */
    private FrameLayout f48108e;

    /* renamed from: f */
    private com.transsion.player.longvideo.intercept.d f48109f;

    /* renamed from: h */
    private String f48111h;

    /* renamed from: j */
    private boolean f48113j;

    /* renamed from: k */
    private boolean f48114k;

    /* renamed from: l */
    private String f48115l;

    /* renamed from: m */
    private String f48116m;

    /* renamed from: n */
    private String f48117n;

    /* renamed from: o */
    private Function0 f48118o;

    /* renamed from: p */
    private BiddingInterstitialManager f48119p;

    /* renamed from: a */
    private LongVodUiType f48104a = LongVodUiType.PORTRAIT;

    /* renamed from: g */
    private int f48110g = 5000;

    /* renamed from: i */
    private boolean f48112i = true;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f48120a;

        static {
            int[] iArr = new int[LongVodUiType.values().length];
            try {
                iArr[LongVodUiType.LAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongVodUiType.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LongVodUiType.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f48120a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements com.transsion.player.longvideo.intercept.d {

        /* renamed from: b */
        final /* synthetic */ PlaybackInterceptAdView f48122b;

        /* renamed from: c */
        final /* synthetic */ com.transsion.player.longvideo.intercept.d f48123c;

        b(PlaybackInterceptAdView playbackInterceptAdView, com.transsion.player.longvideo.intercept.d dVar) {
            this.f48122b = playbackInterceptAdView;
            this.f48123c = dVar;
        }

        public static final void h(PlaybackInterceptAdView playbackInterceptAdView, com.transsion.player.longvideo.intercept.d dVar) {
            playbackInterceptAdView.destroy();
            if (dVar != null) {
                dVar.onComplete();
            }
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void a() {
            d.a.d(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void b() {
            d.a.b(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public go.b c() {
            return d.a.a(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void d() {
            d.a.e(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void e() {
            d.a.g(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void f() {
            d.a.f(this);
            com.transsion.player.longvideo.intercept.d dVar = PlaybackInterceptionManager.this.f48109f;
            if (dVar != null) {
                dVar.f();
            }
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void onComplete() {
            a.C0856a.f(lg.a.f68962a, "premium_p", PlaybackInterceptionManager.this.x() + " --> handlePause() --> 暂停广告展示结束", false, 4, null);
            final PlaybackInterceptAdView playbackInterceptAdView = this.f48122b;
            final com.transsion.player.longvideo.intercept.d dVar = this.f48123c;
            playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.z
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackInterceptionManager.b.h(PlaybackInterceptAdView.this, dVar);
                }
            }, 200L);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements com.transsion.player.longvideo.intercept.d {

        /* renamed from: b */
        final /* synthetic */ PlaybackInterceptAdView f48125b;

        /* renamed from: c */
        final /* synthetic */ com.transsion.player.longvideo.intercept.d f48126c;

        c(PlaybackInterceptAdView playbackInterceptAdView, com.transsion.player.longvideo.intercept.d dVar) {
            this.f48125b = playbackInterceptAdView;
            this.f48126c = dVar;
        }

        public static final void h(PlaybackInterceptAdView playbackInterceptAdView, com.transsion.player.longvideo.intercept.d dVar) {
            playbackInterceptAdView.destroy();
            if (dVar != null) {
                dVar.onComplete();
            }
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void a() {
            d.a.d(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void b() {
            d.a.b(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public go.b c() {
            return d.a.a(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void d() {
            d.a.e(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void e() {
            d.a.g(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void f() {
            d.a.f(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void onComplete() {
            a.C0856a.f(lg.a.f68962a, "premium_p", PlaybackInterceptionManager.this.x() + " --> onCompletion() --> 结束广告展示完成", false, 4, null);
            final PlaybackInterceptAdView playbackInterceptAdView = this.f48125b;
            final com.transsion.player.longvideo.intercept.d dVar = this.f48126c;
            playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.a0
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackInterceptionManager.c.h(PlaybackInterceptAdView.this, dVar);
                }
            }, 200L);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements com.transsion.player.longvideo.intercept.d {

        /* renamed from: b */
        final /* synthetic */ ho.j f48128b;

        /* renamed from: c */
        final /* synthetic */ go.a f48129c;

        d(ho.j jVar, go.a aVar) {
            this.f48128b = jVar;
            this.f48129c = aVar;
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void a() {
            d.a.d(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void b() {
            d.a.b(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public go.b c() {
            return d.a.a(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void d() {
            d.a.e(this);
            PlaybackInterceptionManager.this.f48113j = true;
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void e() {
            d.a.g(this);
            a.C0856a.f(lg.a.f68962a, "premium_p", PlaybackInterceptionManager.this.x() + " --> onProgress() --> 开启分辨率降级 --> 需要判断是否有低分辨率", false, 4, null);
            this.f48128b.f64748o.setPreviewingEnded(this.f48129c, PlaybackInterceptionManager.this.f48115l, PlaybackInterceptionManager.this, this.f48128b.f64743j.f64730g);
            com.transsion.player.longvideo.intercept.d dVar = PlaybackInterceptionManager.this.f48109f;
            if (dVar != null) {
                dVar.e();
            }
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void f() {
            d.a.f(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void onComplete() {
            d.a.c(this);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements com.transsion.player.longvideo.intercept.d {

        /* renamed from: b */
        final /* synthetic */ go.a f48131b;

        /* renamed from: c */
        final /* synthetic */ PlaybackInterceptAdView f48132c;

        /* renamed from: d */
        final /* synthetic */ VideoContentInterceptView f48133d;

        /* renamed from: e */
        final /* synthetic */ com.transsion.player.longvideo.intercept.d f48134e;

        e(go.a aVar, PlaybackInterceptAdView playbackInterceptAdView, VideoContentInterceptView videoContentInterceptView, com.transsion.player.longvideo.intercept.d dVar) {
            this.f48131b = aVar;
            this.f48132c = playbackInterceptAdView;
            this.f48133d = videoContentInterceptView;
            this.f48134e = dVar;
        }

        public static final void h(VideoContentInterceptView videoContentInterceptView, PlaybackInterceptAdView playbackInterceptAdView, com.transsion.player.longvideo.intercept.d dVar, PlaybackInterceptionManager playbackInterceptionManager) {
            if (videoContentInterceptView != null) {
                videoContentInterceptView.setVisibility(8);
            }
            playbackInterceptAdView.setVisibility(8);
            if (dVar != null) {
                dVar.onComplete();
            }
            playbackInterceptionManager.f48112i = false;
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void a() {
            d.a.d(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void b() {
            d.a.b(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public go.b c() {
            return d.a.a(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void d() {
            d.a.e(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void e() {
            d.a.g(this);
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void f() {
            d.a.f(this);
            com.transsion.player.longvideo.intercept.d dVar = PlaybackInterceptionManager.this.f48109f;
            if (dVar != null) {
                dVar.f();
            }
        }

        @Override // com.transsion.player.longvideo.intercept.d
        public void onComplete() {
            PlaybackPremiumTipView playbackPremiumTipView;
            a.C0856a.f(lg.a.f68962a, "premium_p", PlaybackInterceptionManager.this.x() + " --> onRenderFirstFrame() --> 启播广告展示结束", false, 4, null);
            ho.j jVar = PlaybackInterceptionManager.this.f48106c;
            if (jVar != null && (playbackPremiumTipView = jVar.f64748o) != null) {
                playbackPremiumTipView.setPreviewing(this.f48131b, PlaybackInterceptionManager.this);
            }
            this.f48132c.destroy();
            final PlaybackInterceptAdView playbackInterceptAdView = this.f48132c;
            final VideoContentInterceptView videoContentInterceptView = this.f48133d;
            final com.transsion.player.longvideo.intercept.d dVar = this.f48134e;
            final PlaybackInterceptionManager playbackInterceptionManager = PlaybackInterceptionManager.this;
            playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.b0
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackInterceptionManager.e.h(VideoContentInterceptView.this, playbackInterceptAdView, dVar, playbackInterceptionManager);
                }
            }, 200L);
        }
    }

    public static final void A(com.transsion.player.longvideo.intercept.d dVar) {
        if (dVar != null) {
            dVar.onComplete();
        }
    }

    private final void B(go.a aVar, PlaybackInterceptAdView playbackInterceptAdView, LongVodUiType longVodUiType, com.transsion.player.longvideo.intercept.d dVar) {
        Context context = playbackInterceptAdView != null ? playbackInterceptAdView.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            kotlinx.coroutines.k.d(androidx.view.v.a(appCompatActivity), null, null, new PlaybackInterceptionManager$loadLandPauseAd$1$1(appCompatActivity, this, aVar, playbackInterceptAdView, null), 3, null);
        }
    }

    public static final void E(com.transsion.player.longvideo.intercept.d dVar) {
        if (dVar != null) {
            dVar.onComplete();
        }
    }

    public static final void F(com.transsion.player.longvideo.intercept.d dVar) {
        if (dVar != null) {
            dVar.onComplete();
        }
    }

    public static final void I(com.transsion.player.longvideo.intercept.d dVar, PlaybackInterceptionManager playbackInterceptionManager) {
        if (dVar != null) {
            dVar.onComplete();
        }
        playbackInterceptionManager.f48112i = false;
    }

    public static final void J(com.transsion.player.longvideo.intercept.d dVar, PlaybackInterceptionManager playbackInterceptionManager) {
        if (dVar != null) {
            dVar.onComplete();
        }
        playbackInterceptionManager.f48112i = false;
    }

    public static final void K(com.transsion.player.longvideo.intercept.d dVar, PlaybackInterceptionManager playbackInterceptionManager) {
        if (dVar != null) {
            dVar.onComplete();
        }
        playbackInterceptionManager.f48112i = false;
    }

    public static final void L(com.transsion.player.longvideo.intercept.d dVar, PlaybackInterceptionManager playbackInterceptionManager) {
        if (dVar != null) {
            dVar.onComplete();
        }
        playbackInterceptionManager.f48112i = false;
    }

    public static final void U(View view) {
    }

    public static final void V(View view) {
    }

    public static /* synthetic */ void X(PlaybackInterceptionManager playbackInterceptionManager, boolean z10, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        playbackInterceptionManager.W(z10, str, str2, z11);
    }

    public static final Unit Y(PlaybackInterceptionManager playbackInterceptionManager) {
        FrameLayout frameLayout;
        ho.j jVar = playbackInterceptionManager.f48106c;
        if (jVar != null && (frameLayout = jVar.f64736c) != null) {
            frameLayout.setVisibility(8);
        }
        playbackInterceptionManager.f48105b = false;
        return Unit.f67184a;
    }

    public static final Unit Z() {
        return Unit.f67184a;
    }

    public static final Unit a0(PlaybackInterceptionManager playbackInterceptionManager) {
        FrameLayout frameLayout = playbackInterceptionManager.f48108e;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        playbackInterceptionManager.f48105b = false;
        return Unit.f67184a;
    }

    public static final Unit b0() {
        return Unit.f67184a;
    }

    public final String x() {
        String simpleName = PlaybackInterceptionManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public static final void z(com.transsion.player.longvideo.intercept.d dVar) {
        if (dVar != null) {
            dVar.onComplete();
        }
    }

    public final void C() {
        com.transsion.player.longvideo.intercept.d dVar = this.f48109f;
        if (dVar != null) {
            dVar.b();
        }
    }

    public final void D(ao.e eVar, go.a aVar, PlaybackInterceptAdView playbackInterceptAdView, final com.transsion.player.longvideo.intercept.d dVar) {
        Subject m11;
        Integer subjectType;
        Subject m12;
        Integer subjectType2;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "premium_p", x() + " --> onCompletion()", false, 4, null);
        if ((aVar != null && (m12 = aVar.m()) != null && (subjectType2 = m12.getSubjectType()) != null && subjectType2.intValue() == 5) || (aVar != null && (m11 = aVar.m()) != null && (subjectType = m11.getSubjectType()) != null && subjectType.intValue() == 6)) {
            a.C0856a.f(c0856a, "premium_p", "PlaybackInterceptionManager --> onRenderFirstFrame() --> 教育、音乐不展示 -- 结束广告", false, 4, null);
            return;
        }
        if (aVar == null) {
            a.C0856a.f(c0856a, "premium_p", x() + " --> onCompletion() --> bean ==null", false, 4, null);
            if (playbackInterceptAdView != null) {
                playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlaybackInterceptionManager.F(d.this);
                    }
                }, 200L);
                return;
            }
            return;
        }
        if (playbackInterceptAdView != null && playbackInterceptAdView.getVisibility() == 0) {
            playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.w
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackInterceptionManager.E(d.this);
                }
            }, 200L);
        } else {
            if (ak.o.f721a.g() || ak.g.f714a.b() || playbackInterceptAdView == null) {
                return;
            }
            playbackInterceptAdView.loadNativeAd("VideoEndBidScene", this, aVar, new c(playbackInterceptAdView, dVar));
        }
    }

    public final void G(long j11, go.a aVar, com.transsion.player.ui.longvideo.a aVar2, ho.j viewBinding) {
        Intrinsics.h(viewBinding, "viewBinding");
        if (h0.f48193a.d(aVar != null ? aVar.m() : null)) {
            if (this.f48112i) {
                a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onProgress() --> 当前不处理，isStartInterceptWorking = true", false, 4, null);
                return;
            }
            if (this.f48113j) {
                return;
            }
            IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            if (!(iPremiumApi != null ? iPremiumApi.c() : false) && this.f48114k) {
                long j12 = this.f48110g * 1000;
                if (j11 > j12) {
                    a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onProgress() --> 免费观看时长用完，激励拦截 --> preview = " + j12 + " -- progress = " + j11 + " ", false, 4, null);
                    if (aVar2 != null) {
                        aVar2.pause();
                    }
                    new VideoContentInterceptManager().n(aVar, viewBinding, aVar2, this, new d(viewBinding, aVar));
                }
            }
        }
    }

    public final void H(PlaybackInterceptAdView playbackInterceptAdView, VideoContentInterceptView videoContentInterceptView, go.a aVar, final com.transsion.player.longvideo.intercept.d dVar) {
        PlaybackPremiumTipView playbackPremiumTipView;
        if (!h0.f48193a.d(aVar != null ? aVar.m() : null)) {
            a.C0856a.f(lg.a.f68962a, "premium_p", "PlaybackInterceptionManager --> onRenderFirstFrame() --> 非电影电视剧 -- 启播广告", false, 4, null);
            if (playbackInterceptAdView != null) {
                playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlaybackInterceptionManager.I(d.this, this);
                    }
                }, 200L);
                return;
            }
            return;
        }
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi != null ? iPremiumApi.c() : false) {
            a.C0856a.f(lg.a.f68962a, "premium_p", "PlaybackInterceptionManager --> onRenderFirstFrame() --> 当前是会员，不进行拦截", false, 4, null);
            ho.j jVar = this.f48106c;
            if (jVar != null && (playbackPremiumTipView = jVar.f64748o) != null) {
                playbackPremiumTipView.setPremiumTip();
            }
            if (playbackInterceptAdView != null) {
                playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlaybackInterceptionManager.J(d.this, this);
                    }
                }, 200L);
                return;
            }
            return;
        }
        if (aVar == null) {
            a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onRenderFirstFrame() --> bean ==null", false, 4, null);
            if (playbackInterceptAdView != null) {
                playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlaybackInterceptionManager.K(d.this, this);
                    }
                }, 200L);
                return;
            }
            return;
        }
        if (!ak.o.f721a.i() && !ak.g.f714a.b()) {
            if (playbackInterceptAdView != null) {
                playbackInterceptAdView.loadNativeAd("VideoStartBidScene", this, aVar, new e(aVar, playbackInterceptAdView, videoContentInterceptView, dVar));
                return;
            }
            return;
        }
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onRenderFirstFrame() --> 特殊模式", false, 4, null);
        if (playbackInterceptAdView != null) {
            playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.p
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackInterceptionManager.L(d.this, this);
                }
            }, 200L);
        }
    }

    public final void M(LongVodUiType uiType, ho.j viewBinding) {
        Intrinsics.h(uiType, "uiType");
        Intrinsics.h(viewBinding, "viewBinding");
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onUiTypeChanged()", false, 4, null);
        this.f48104a = uiType;
        boolean z10 = this.f48105b;
        String str = this.f48116m;
        if (str == null) {
            str = "";
        }
        String str2 = this.f48117n;
        W(z10, str, str2 != null ? str2 : "", true);
        viewBinding.f64749p.onUiTypeChanged(uiType, viewBinding);
    }

    public final void N(VideoContentInterceptView videoContentInterceptView) {
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onVideoPause()", false, 4, null);
    }

    public final void O(ao.e eVar, VideoContentInterceptView playbackInterceptView, com.transsion.player.ui.longvideo.a playerControl) {
        PlaybackInterceptAdView playbackInterceptAdView;
        Intrinsics.h(playbackInterceptView, "playbackInterceptView");
        Intrinsics.h(playerControl, "playerControl");
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onVideoStart()", false, 4, null);
        BiddingInterstitialManager biddingInterstitialManager = this.f48119p;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
        this.f48119p = null;
        ho.j jVar = this.f48106c;
        if (jVar == null || (playbackInterceptAdView = jVar.f64749p) == null) {
            return;
        }
        playbackInterceptAdView.cannelPauseAd();
    }

    public final void P() {
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onViewPause()", false, 4, null);
    }

    public final void Q() {
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> onViewResume()", false, 4, null);
    }

    public final void R(Function0 function0) {
        this.f48118o = function0;
    }

    public final void S(String str, String str2) {
        this.f48111h = str;
        h0 h0Var = h0.f48193a;
        go.a aVar = this.f48107d;
        this.f48114k = h0Var.e(aVar != null ? aVar.m() : null, str);
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> setCurPlayStream() --> isVipResolutionRatio = " + this.f48114k + " --> resolutions = " + str + " --> msg = " + str2, false, 4, null);
    }

    public final void T(go.a bean, ho.j viewBinding, FrameLayout frameLayout, String str, com.transsion.player.longvideo.intercept.d dVar) {
        Intrinsics.h(bean, "bean");
        Intrinsics.h(viewBinding, "viewBinding");
        this.f48107d = bean;
        this.f48106c = viewBinding;
        this.f48108e = frameLayout;
        this.f48109f = dVar;
        this.f48115l = str;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.intercept.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackInterceptionManager.U(view);
                }
            });
        }
        viewBinding.f64748o.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.intercept.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackInterceptionManager.V(view);
            }
        });
        h0 h0Var = h0.f48193a;
        this.f48110g = h0Var.b(bean.m());
        boolean f11 = h0Var.f(bean.m());
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> setDataSource(设置播放资源) --> previewSeconds = " + this.f48110g + " --> isVipSource = " + f11 + " --> playBean = " + bean + " ", false, 4, null);
        this.f48116m = "";
        this.f48117n = "";
        this.f48113j = false;
        this.f48112i = true;
        this.f48114k = false;
        viewBinding.f64743j.f64730g.setVisibility(8);
        viewBinding.f64747n.setVisibility(8);
        viewBinding.f64749p.setVisibility(8);
        viewBinding.f64749p.destroy();
    }

    public final void W(boolean z10, String sceneId, String traceId, boolean z11) {
        FrameLayout frameLayout;
        int i11;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        Context context;
        View view;
        ho.j jVar;
        FrameLayout frameLayout4;
        FrameLayout frameLayout5;
        Subject m11;
        FrameLayout frameLayout6;
        Context context2;
        View view2;
        FrameLayout frameLayout7;
        Subject m12;
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(traceId, "traceId");
        this.f48105b = z10;
        this.f48116m = sceneId;
        this.f48117n = traceId;
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> setPremiumViewShowState() --> isShowPremiumView = " + this.f48105b + " -- uiType = " + this.f48104a, false, 4, null);
        if (!z10) {
            ho.j jVar2 = this.f48106c;
            if (jVar2 != null && (frameLayout = jVar2.f64736c) != null) {
                frameLayout.setVisibility(8);
            }
            FrameLayout frameLayout8 = this.f48108e;
            if (frameLayout8 != null) {
                frameLayout8.setVisibility(8);
                return;
            }
            return;
        }
        Function0 function0 = this.f48118o;
        if (function0 != null) {
            function0.invoke();
        }
        int i12 = a.f48120a[this.f48104a.ordinal()];
        if (i12 != 1) {
            if (i12 != 2 && i12 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            FrameLayout frameLayout9 = this.f48108e;
            if (frameLayout9 != null && (context2 = frameLayout9.getContext()) != null) {
                IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
                if (iPremiumApi != null) {
                    Function0 function02 = new Function0() { // from class: com.transsion.player.longvideo.intercept.t
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit a02;
                            a02 = PlaybackInterceptionManager.a0(PlaybackInterceptionManager.this);
                            return a02;
                        }
                    };
                    Function0 function03 = new Function0() { // from class: com.transsion.player.longvideo.intercept.u
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit b02;
                            b02 = PlaybackInterceptionManager.b0();
                            return b02;
                        }
                    };
                    MemberSource memberSource = MemberSource.SOURCE_LANDSCAPE_PLAY;
                    String str = this.f48115l;
                    go.a aVar = this.f48107d;
                    view2 = IPremiumApi.a.a(iPremiumApi, context2, 0, function02, function03, memberSource, null, str, traceId, sceneId, (aVar == null || (m12 = aVar.m()) == null) ? null : m12.getSubjectId(), 32, null);
                } else {
                    view2 = null;
                }
                if (view2 != null && (frameLayout7 = this.f48108e) != null && frameLayout7.indexOfChild(view2) == -1) {
                    ViewParent parent = view2.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(view2);
                    }
                    FrameLayout frameLayout10 = this.f48108e;
                    if (frameLayout10 != null) {
                        frameLayout10.addView(view2);
                    }
                }
            }
            ho.j jVar3 = this.f48106c;
            if (jVar3 != null && (frameLayout6 = jVar3.f64736c) != null) {
                frameLayout6.setVisibility(8);
            }
            FrameLayout frameLayout11 = this.f48108e;
            if (frameLayout11 != null) {
                frameLayout11.setVisibility(0);
                return;
            }
            return;
        }
        ho.j jVar4 = this.f48106c;
        if (jVar4 == null || (frameLayout3 = jVar4.f64736c) == null || (context = frameLayout3.getContext()) == null) {
            i11 = 0;
        } else {
            IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            if (iPremiumApi2 != null) {
                Function0 function04 = new Function0() { // from class: com.transsion.player.longvideo.intercept.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit Y;
                        Y = PlaybackInterceptionManager.Y(PlaybackInterceptionManager.this);
                        return Y;
                    }
                };
                Function0 function05 = new Function0() { // from class: com.transsion.player.longvideo.intercept.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit Z;
                        Z = PlaybackInterceptionManager.Z();
                        return Z;
                    }
                };
                MemberSource memberSource2 = MemberSource.SOURCE_LANDSCAPE_PLAY;
                String str2 = this.f48115l;
                go.a aVar2 = this.f48107d;
                i11 = 0;
                view = IPremiumApi.a.a(iPremiumApi2, context, 1, function04, function05, memberSource2, null, str2, traceId, sceneId, (aVar2 == null || (m11 = aVar2.m()) == null) ? null : m11.getSubjectId(), 32, null);
            } else {
                i11 = 0;
                view = null;
            }
            if (view != null && (jVar = this.f48106c) != null && (frameLayout4 = jVar.f64736c) != null && frameLayout4.indexOfChild(view) == -1) {
                ViewParent parent2 = view.getParent();
                ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(view);
                }
                ho.j jVar5 = this.f48106c;
                if (jVar5 != null && (frameLayout5 = jVar5.f64736c) != null) {
                    frameLayout5.addView(view);
                }
            }
        }
        ho.j jVar6 = this.f48106c;
        if (jVar6 != null && (frameLayout2 = jVar6.f64736c) != null) {
            frameLayout2.setVisibility(i11);
        }
        FrameLayout frameLayout12 = this.f48108e;
        if (frameLayout12 != null) {
            frameLayout12.setVisibility(8);
        }
    }

    public final void w() {
        PlaybackPremiumTipView playbackPremiumTipView;
        PlaybackInterceptAdView playbackInterceptAdView;
        a.C0856a.f(lg.a.f68962a, "premium_p", x() + " --> destroy()", false, 4, null);
        ho.j jVar = this.f48106c;
        if (jVar != null && (playbackInterceptAdView = jVar.f64749p) != null) {
            playbackInterceptAdView.destroy();
        }
        ho.j jVar2 = this.f48106c;
        if (jVar2 != null && (playbackPremiumTipView = jVar2.f64748o) != null) {
            playbackPremiumTipView.destroy();
        }
        this.f48118o = null;
    }

    public final void y(go.a aVar, PlaybackInterceptAdView playbackInterceptAdView, LongVodUiType uiType, final com.transsion.player.longvideo.intercept.d dVar) {
        Intrinsics.h(uiType, "uiType");
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "premium_p", x() + " --> handlePause(加载暂停广告)", false, 4, null);
        if (!h0.f48193a.d(aVar != null ? aVar.m() : null)) {
            a.C0856a.f(c0856a, "premium_p", "PlaybackInterceptionManager --> onRenderFirstFrame() --> 非电影电视剧 -- 暂停广告", false, 4, null);
            return;
        }
        if (aVar == null) {
            a.C0856a.f(c0856a, "premium_p", x() + " --> handlePause() --> bean ==null", false, 4, null);
            if (playbackInterceptAdView != null) {
                playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlaybackInterceptionManager.z(d.this);
                    }
                }, 200L);
                return;
            }
            return;
        }
        if (playbackInterceptAdView != null && playbackInterceptAdView.getVisibility() == 0) {
            playbackInterceptAdView.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.q
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackInterceptionManager.A(d.this);
                }
            }, 200L);
            return;
        }
        if (ak.o.f721a.g() || ak.g.f714a.b()) {
            return;
        }
        if (uiType == LongVodUiType.LAND) {
            B(aVar, playbackInterceptAdView, uiType, dVar);
        } else if (playbackInterceptAdView != null) {
            playbackInterceptAdView.loadNativeAd("VerticalPauseScene", this, aVar, new b(playbackInterceptAdView, dVar));
        }
    }
}
