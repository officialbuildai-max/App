package qv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.noober.background.view.BLView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;
import com.transsion.ugcvideodetail.widget.UGCLocalVideoDetailInfoView;
import com.transsion.ugcvideodetail.widget.UGCVideoDetailAboutCourseView;
import com.transsion.ugcvideodetail.widget.UGCVideoDetailInfoView;
import com.transsion.ugcvideodetail.widget.UGCVideoDetailPlayListView;
import com.transsion.wrapperad.view.cardpage.NativeCardPageView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73882a;

    /* renamed from: b, reason: collision with root package name */
    public final UGCVideoDetailAboutCourseView f73883b;

    /* renamed from: c, reason: collision with root package name */
    public final AppBarLayout f73884c;

    /* renamed from: d, reason: collision with root package name */
    public final CoordinatorLayout f73885d;

    /* renamed from: e, reason: collision with root package name */
    public final UGCVideoDetailInfoView f73886e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f73887f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f73888g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f73889h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f73890i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f73891j;

    /* renamed from: k, reason: collision with root package name */
    public final UGCLocalVideoDetailInfoView f73892k;

    /* renamed from: l, reason: collision with root package name */
    public final MagicIndicator f73893l;

    /* renamed from: m, reason: collision with root package name */
    public final NativeCardPageView f73894m;

    /* renamed from: n, reason: collision with root package name */
    public final UGCVideoDetailPlayListView f73895n;

    /* renamed from: o, reason: collision with root package name */
    public final CollapsingToolbarLayout f73896o;

    /* renamed from: p, reason: collision with root package name */
    public final BLView f73897p;

    /* renamed from: q, reason: collision with root package name */
    public final View f73898q;

    /* renamed from: r, reason: collision with root package name */
    public final View f73899r;

    /* renamed from: s, reason: collision with root package name */
    public final ViewPager2 f73900s;

    private i(ConstraintLayout constraintLayout, UGCVideoDetailAboutCourseView uGCVideoDetailAboutCourseView, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout, UGCVideoDetailInfoView uGCVideoDetailInfoView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, AppCompatImageView appCompatImageView, LinearLayout linearLayout, UGCLocalVideoDetailInfoView uGCLocalVideoDetailInfoView, MagicIndicator magicIndicator, NativeCardPageView nativeCardPageView, UGCVideoDetailPlayListView uGCVideoDetailPlayListView, CollapsingToolbarLayout collapsingToolbarLayout, BLView bLView, View view, View view2, ViewPager2 viewPager2) {
        this.f73882a = constraintLayout;
        this.f73883b = uGCVideoDetailAboutCourseView;
        this.f73884c = appBarLayout;
        this.f73885d = coordinatorLayout;
        this.f73886e = uGCVideoDetailInfoView;
        this.f73887f = frameLayout;
        this.f73888g = frameLayout2;
        this.f73889h = frameLayout3;
        this.f73890i = appCompatImageView;
        this.f73891j = linearLayout;
        this.f73892k = uGCLocalVideoDetailInfoView;
        this.f73893l = magicIndicator;
        this.f73894m = nativeCardPageView;
        this.f73895n = uGCVideoDetailPlayListView;
        this.f73896o = collapsingToolbarLayout;
        this.f73897p = bLView;
        this.f73898q = view;
        this.f73899r = view2;
        this.f73900s = viewPager2;
    }

    public static i a(View view) {
        View a11;
        View a12;
        int i11 = R$id.aboutCourseView;
        UGCVideoDetailAboutCourseView uGCVideoDetailAboutCourseView = (UGCVideoDetailAboutCourseView) g4.b.a(view, i11);
        if (uGCVideoDetailAboutCourseView != null) {
            i11 = R$id.appBar;
            AppBarLayout appBarLayout = (AppBarLayout) g4.b.a(view, i11);
            if (appBarLayout != null) {
                i11 = R$id.cdl;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
                if (coordinatorLayout != null) {
                    i11 = R$id.detailInfoView;
                    UGCVideoDetailInfoView uGCVideoDetailInfoView = (UGCVideoDetailInfoView) g4.b.a(view, i11);
                    if (uGCVideoDetailInfoView != null) {
                        i11 = R$id.flBottomDialogContainer;
                        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                        if (frameLayout != null) {
                            i11 = R$id.fl_player;
                            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout2 != null) {
                                i11 = R$id.gameContainer;
                                FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                                if (frameLayout3 != null) {
                                    i11 = R$id.ivBack;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView != null) {
                                        i11 = R$id.llDetailContent;
                                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                        if (linearLayout != null) {
                                            i11 = R$id.localDetailInfoView;
                                            UGCLocalVideoDetailInfoView uGCLocalVideoDetailInfoView = (UGCLocalVideoDetailInfoView) g4.b.a(view, i11);
                                            if (uGCLocalVideoDetailInfoView != null) {
                                                i11 = R$id.magicIndicator;
                                                MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                                                if (magicIndicator != null) {
                                                    i11 = R$id.nativeSlideshowView;
                                                    NativeCardPageView nativeCardPageView = (NativeCardPageView) g4.b.a(view, i11);
                                                    if (nativeCardPageView != null) {
                                                        i11 = R$id.playListView;
                                                        UGCVideoDetailPlayListView uGCVideoDetailPlayListView = (UGCVideoDetailPlayListView) g4.b.a(view, i11);
                                                        if (uGCVideoDetailPlayListView != null) {
                                                            i11 = R$id.toolbar_layout;
                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) g4.b.a(view, i11);
                                                            if (collapsingToolbarLayout != null) {
                                                                i11 = R$id.v_player_bottom_space;
                                                                BLView bLView = (BLView) g4.b.a(view, i11);
                                                                if (bLView != null && (a11 = g4.b.a(view, (i11 = R$id.vTabLine))) != null && (a12 = g4.b.a(view, (i11 = R$id.v_top_space))) != null) {
                                                                    i11 = R$id.viewPager;
                                                                    ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                                    if (viewPager2 != null) {
                                                                        return new i((ConstraintLayout) view, uGCVideoDetailAboutCourseView, appBarLayout, coordinatorLayout, uGCVideoDetailInfoView, frameLayout, frameLayout2, frameLayout3, appCompatImageView, linearLayout, uGCLocalVideoDetailInfoView, magicIndicator, nativeCardPageView, uGCVideoDetailPlayListView, collapsingToolbarLayout, bLView, a11, a12, viewPager2);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_video_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73882a;
    }
}
