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
import com.tn.lib.view.MemberGuideBannerView;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.wrapperad.view.cardpage.NativeCardPageView;
import com.transsnet.downloader.widget.DownloadView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f66545a;

    /* renamed from: b, reason: collision with root package name */
    public final BubbleTextView f66546b;

    /* renamed from: c, reason: collision with root package name */
    public final AppBarLayout f66547c;

    /* renamed from: d, reason: collision with root package name */
    public final DownloadView f66548d;

    /* renamed from: e, reason: collision with root package name */
    public final CoordinatorLayout f66549e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f66550f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f66551g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f66552h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f66553i;

    /* renamed from: j, reason: collision with root package name */
    public final MemberGuideBannerView f66554j;

    /* renamed from: k, reason: collision with root package name */
    public final FrameLayout f66555k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatImageView f66556l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatImageView f66557m;

    /* renamed from: n, reason: collision with root package name */
    public final ho.h f66558n;

    /* renamed from: o, reason: collision with root package name */
    public final MagicIndicator f66559o;

    /* renamed from: p, reason: collision with root package name */
    public final NativeCardPageView f66560p;

    /* renamed from: q, reason: collision with root package name */
    public final ViewPager2 f66561q;

    /* renamed from: r, reason: collision with root package name */
    public final FrameLayout f66562r;

    /* renamed from: s, reason: collision with root package name */
    public final FrameLayout f66563s;

    /* renamed from: t, reason: collision with root package name */
    public final CollapsingToolbarLayout f66564t;

    /* renamed from: u, reason: collision with root package name */
    public final GradientTextView f66565u;

    /* renamed from: v, reason: collision with root package name */
    public final View f66566v;

    /* renamed from: w, reason: collision with root package name */
    public final View f66567w;

    private i(ConstraintLayout constraintLayout, BubbleTextView bubbleTextView, AppBarLayout appBarLayout, DownloadView downloadView, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, MemberGuideBannerView memberGuideBannerView, FrameLayout frameLayout5, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ho.h hVar, MagicIndicator magicIndicator, NativeCardPageView nativeCardPageView, ViewPager2 viewPager2, FrameLayout frameLayout6, FrameLayout frameLayout7, CollapsingToolbarLayout collapsingToolbarLayout, GradientTextView gradientTextView, View view, View view2) {
        this.f66545a = constraintLayout;
        this.f66546b = bubbleTextView;
        this.f66547c = appBarLayout;
        this.f66548d = downloadView;
        this.f66549e = coordinatorLayout;
        this.f66550f = frameLayout;
        this.f66551g = frameLayout2;
        this.f66552h = frameLayout3;
        this.f66553i = frameLayout4;
        this.f66554j = memberGuideBannerView;
        this.f66555k = frameLayout5;
        this.f66556l = appCompatImageView;
        this.f66557m = appCompatImageView2;
        this.f66558n = hVar;
        this.f66559o = magicIndicator;
        this.f66560p = nativeCardPageView;
        this.f66561q = viewPager2;
        this.f66562r = frameLayout6;
        this.f66563s = frameLayout7;
        this.f66564t = collapsingToolbarLayout;
        this.f66565u = gradientTextView;
        this.f66566v = view;
        this.f66567w = view2;
    }

    public static i a(View view) {
        View a11;
        View a12;
        View a13;
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
                            i11 = R$id.fl_full_player_container;
                            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout2 != null) {
                                i11 = R$id.fl_player;
                                FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                                if (frameLayout3 != null) {
                                    i11 = R$id.flPortraitPremium;
                                    FrameLayout frameLayout4 = (FrameLayout) g4.b.a(view, i11);
                                    if (frameLayout4 != null) {
                                        i11 = R$id.flPremiumGroup;
                                        MemberGuideBannerView memberGuideBannerView = (MemberGuideBannerView) g4.b.a(view, i11);
                                        if (memberGuideBannerView != null) {
                                            i11 = R$id.game_container;
                                            FrameLayout frameLayout5 = (FrameLayout) g4.b.a(view, i11);
                                            if (frameLayout5 != null) {
                                                i11 = R$id.ivBack;
                                                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                                if (appCompatImageView != null) {
                                                    i11 = R$id.iv_publish;
                                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                                    if (appCompatImageView2 != null && (a11 = g4.b.a(view, (i11 = R$id.layout_sync_adjust))) != null) {
                                                        ho.h a14 = ho.h.a(a11);
                                                        i11 = R$id.magic_indicator;
                                                        MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                                                        if (magicIndicator != null) {
                                                            i11 = R$id.nativeSlideshowView;
                                                            NativeCardPageView nativeCardPageView = (NativeCardPageView) g4.b.a(view, i11);
                                                            if (nativeCardPageView != null) {
                                                                i11 = R$id.rec_view_pager;
                                                                ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                                if (viewPager2 != null) {
                                                                    i11 = R$id.resourceDetectorGroup;
                                                                    FrameLayout frameLayout6 = (FrameLayout) g4.b.a(view, i11);
                                                                    if (frameLayout6 != null) {
                                                                        i11 = R$id.subjectDetailLayout;
                                                                        FrameLayout frameLayout7 = (FrameLayout) g4.b.a(view, i11);
                                                                        if (frameLayout7 != null) {
                                                                            i11 = R$id.toolbar_layout;
                                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) g4.b.a(view, i11);
                                                                            if (collapsingToolbarLayout != null) {
                                                                                i11 = R$id.tv_post;
                                                                                GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                                                                                if (gradientTextView != null && (a12 = g4.b.a(view, (i11 = R$id.v_player_bottom_space))) != null && (a13 = g4.b.a(view, (i11 = R$id.v_top_space))) != null) {
                                                                                    return new i((ConstraintLayout) view, bubbleTextView, appBarLayout, downloadView, coordinatorLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, memberGuideBannerView, frameLayout5, appCompatImageView, appCompatImageView2, a14, magicIndicator, nativeCardPageView, viewPager2, frameLayout6, frameLayout7, collapsingToolbarLayout, gradientTextView, a12, a13);
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

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_video_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66545a;
    }
}
