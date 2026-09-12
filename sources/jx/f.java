package jx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.videodetail.music.widget.MusicDetailListOperateView;
import com.transsnet.downloader.widget.DownloadView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f66490a;

    /* renamed from: b, reason: collision with root package name */
    public final BubbleTextView f66491b;

    /* renamed from: c, reason: collision with root package name */
    public final AppBarLayout f66492c;

    /* renamed from: d, reason: collision with root package name */
    public final DownloadView f66493d;

    /* renamed from: e, reason: collision with root package name */
    public final CoordinatorLayout f66494e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f66495f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f66496g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f66497h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f66498i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f66499j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f66500k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatImageView f66501l;

    /* renamed from: m, reason: collision with root package name */
    public final ho.h f66502m;

    /* renamed from: n, reason: collision with root package name */
    public final MagicIndicator f66503n;

    /* renamed from: o, reason: collision with root package name */
    public final MusicDetailListOperateView f66504o;

    /* renamed from: p, reason: collision with root package name */
    public final ViewPager2 f66505p;

    /* renamed from: q, reason: collision with root package name */
    public final FrameLayout f66506q;

    /* renamed from: r, reason: collision with root package name */
    public final FrameLayout f66507r;

    /* renamed from: s, reason: collision with root package name */
    public final FrameLayout f66508s;

    /* renamed from: t, reason: collision with root package name */
    public final CollapsingToolbarLayout f66509t;

    /* renamed from: u, reason: collision with root package name */
    public final GradientTextView f66510u;

    /* renamed from: v, reason: collision with root package name */
    public final View f66511v;

    private f(ConstraintLayout constraintLayout, BubbleTextView bubbleTextView, AppBarLayout appBarLayout, DownloadView downloadView, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ho.h hVar, MagicIndicator magicIndicator, MusicDetailListOperateView musicDetailListOperateView, ViewPager2 viewPager2, FrameLayout frameLayout6, FrameLayout frameLayout7, FrameLayout frameLayout8, CollapsingToolbarLayout collapsingToolbarLayout, GradientTextView gradientTextView, View view) {
        this.f66490a = constraintLayout;
        this.f66491b = bubbleTextView;
        this.f66492c = appBarLayout;
        this.f66493d = downloadView;
        this.f66494e = coordinatorLayout;
        this.f66495f = frameLayout;
        this.f66496g = frameLayout2;
        this.f66497h = frameLayout3;
        this.f66498i = frameLayout4;
        this.f66499j = frameLayout5;
        this.f66500k = appCompatImageView;
        this.f66501l = appCompatImageView2;
        this.f66502m = hVar;
        this.f66503n = magicIndicator;
        this.f66504o = musicDetailListOperateView;
        this.f66505p = viewPager2;
        this.f66506q = frameLayout6;
        this.f66507r = frameLayout7;
        this.f66508s = frameLayout8;
        this.f66509t = collapsingToolbarLayout;
        this.f66510u = gradientTextView;
        this.f66511v = view;
    }

    public static f a(View view) {
        View a11;
        View a12;
        int i11 = R$id.activity_tip;
        BubbleTextView bubbleTextView = (BubbleTextView) g4.b.a(view, i11);
        if (bubbleTextView != null) {
            i11 = R$id.appBar;
            AppBarLayout appBarLayout = (AppBarLayout) g4.b.a(view, i11);
            if (appBarLayout != null) {
                i11 = R$id.btn_download;
                DownloadView downloadView = (DownloadView) g4.b.a(view, i11);
                if (downloadView != null) {
                    i11 = R$id.cdl;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
                    if (coordinatorLayout != null) {
                        i11 = R$id.fl_bottom_dialog_container;
                        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                        if (frameLayout != null) {
                            i11 = R$id.flFullPlayerContainer;
                            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout2 != null) {
                                i11 = R$id.flMusicContainer;
                                FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                                if (frameLayout3 != null) {
                                    i11 = R$id.flPlayer;
                                    FrameLayout frameLayout4 = (FrameLayout) g4.b.a(view, i11);
                                    if (frameLayout4 != null) {
                                        i11 = R$id.game_container;
                                        FrameLayout frameLayout5 = (FrameLayout) g4.b.a(view, i11);
                                        if (frameLayout5 != null) {
                                            i11 = R$id.ivBack;
                                            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                            if (appCompatImageView != null) {
                                                i11 = R$id.iv_publish;
                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                                if (appCompatImageView2 != null && (a11 = g4.b.a(view, (i11 = R$id.layout_sync_adjust))) != null) {
                                                    ho.h a13 = ho.h.a(a11);
                                                    i11 = R$id.magic_indicator;
                                                    MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                                                    if (magicIndicator != null) {
                                                        i11 = R$id.operateView;
                                                        MusicDetailListOperateView musicDetailListOperateView = (MusicDetailListOperateView) g4.b.a(view, i11);
                                                        if (musicDetailListOperateView != null) {
                                                            i11 = R$id.rec_view_pager;
                                                            ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                            if (viewPager2 != null) {
                                                                i11 = R$id.resourceDetectorGroup;
                                                                FrameLayout frameLayout6 = (FrameLayout) g4.b.a(view, i11);
                                                                if (frameLayout6 != null) {
                                                                    i11 = R$id.subjectDetailLayout;
                                                                    FrameLayout frameLayout7 = (FrameLayout) g4.b.a(view, i11);
                                                                    if (frameLayout7 != null) {
                                                                        i11 = R$id.subjectDetailLayoutV2;
                                                                        FrameLayout frameLayout8 = (FrameLayout) g4.b.a(view, i11);
                                                                        if (frameLayout8 != null) {
                                                                            i11 = R$id.toolbar_layout;
                                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) g4.b.a(view, i11);
                                                                            if (collapsingToolbarLayout != null) {
                                                                                i11 = R$id.tv_post;
                                                                                GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                                                                                if (gradientTextView != null && (a12 = g4.b.a(view, (i11 = R$id.vTopSpace))) != null) {
                                                                                    return new f((ConstraintLayout) view, bubbleTextView, appBarLayout, downloadView, coordinatorLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5, appCompatImageView, appCompatImageView2, a13, magicIndicator, musicDetailListOperateView, viewPager2, frameLayout6, frameLayout7, frameLayout8, collapsingToolbarLayout, gradientTextView, a12);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_music_detail_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66490a;
    }
}
