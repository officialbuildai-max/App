package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class q0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62980a;

    /* renamed from: b, reason: collision with root package name */
    public final AppBarLayout f62981b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f62982c;

    /* renamed from: d, reason: collision with root package name */
    public final ExpandView f62983d;

    /* renamed from: e, reason: collision with root package name */
    public final BLFrameLayout f62984e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f62985f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f62986g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f62987h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeableImageView f62988i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f62989j;

    /* renamed from: k, reason: collision with root package name */
    public final View f62990k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f62991l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f62992m;

    /* renamed from: n, reason: collision with root package name */
    public final MagicIndicator f62993n;

    /* renamed from: o, reason: collision with root package name */
    public final PileLayout f62994o;

    /* renamed from: p, reason: collision with root package name */
    public final LinearLayout f62995p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f62996q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f62997r;

    /* renamed from: s, reason: collision with root package name */
    public final RoomJoinAnimationView f62998s;

    /* renamed from: t, reason: collision with root package name */
    public final RoomJoinAnimationView f62999t;

    /* renamed from: u, reason: collision with root package name */
    public final View f63000u;

    /* renamed from: v, reason: collision with root package name */
    public final View f63001v;

    /* renamed from: w, reason: collision with root package name */
    public final TnTextView f63002w;

    /* renamed from: x, reason: collision with root package name */
    public final ViewPager2 f63003x;

    private q0(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, ExpandView expandView, BLFrameLayout bLFrameLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView3, View view, ImageView imageView, LinearLayout linearLayout, MagicIndicator magicIndicator, PileLayout pileLayout, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, RoomJoinAnimationView roomJoinAnimationView, RoomJoinAnimationView roomJoinAnimationView2, View view2, View view3, TnTextView tnTextView, ViewPager2 viewPager2) {
        this.f62980a = constraintLayout;
        this.f62981b = appBarLayout;
        this.f62982c = constraintLayout2;
        this.f62983d = expandView;
        this.f62984e = bLFrameLayout;
        this.f62985f = frameLayout;
        this.f62986g = appCompatImageView;
        this.f62987h = appCompatImageView2;
        this.f62988i = shapeableImageView;
        this.f62989j = appCompatImageView3;
        this.f62990k = view;
        this.f62991l = imageView;
        this.f62992m = linearLayout;
        this.f62993n = magicIndicator;
        this.f62994o = pileLayout;
        this.f62995p = linearLayout2;
        this.f62996q = appCompatTextView;
        this.f62997r = appCompatTextView2;
        this.f62998s = roomJoinAnimationView;
        this.f62999t = roomJoinAnimationView2;
        this.f63000u = view2;
        this.f63001v = view3;
        this.f63002w = tnTextView;
        this.f63003x = viewPager2;
    }

    public static q0 a(View view) {
        View a11;
        View a12;
        View a13;
        int i11 = R$id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) g4.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.cl_top_content;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.ev_room_des;
                ExpandView expandView = (ExpandView) g4.b.a(view, i11);
                if (expandView != null) {
                    i11 = R$id.fl_tab;
                    BLFrameLayout bLFrameLayout = (BLFrameLayout) g4.b.a(view, i11);
                    if (bLFrameLayout != null) {
                        i11 = R$id.flTabBg;
                        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                        if (frameLayout != null) {
                            i11 = R$id.iv_back;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView != null) {
                                i11 = R$id.iv_publish;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView2 != null) {
                                    i11 = R$id.iv_room_cover;
                                    ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                    if (shapeableImageView != null) {
                                        i11 = R$id.iv_share;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView3 != null && (a11 = g4.b.a(view, (i11 = R$id.iv_top_bg))) != null) {
                                            i11 = R$id.iv_top_bg_mask;
                                            ImageView imageView = (ImageView) g4.b.a(view, i11);
                                            if (imageView != null) {
                                                i11 = R$id.ll_header_root;
                                                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                if (linearLayout != null) {
                                                    i11 = R$id.magic_indicator;
                                                    MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                                                    if (magicIndicator != null) {
                                                        i11 = R$id.pl_member_ic;
                                                        PileLayout pileLayout = (PileLayout) g4.b.a(view, i11);
                                                        if (pileLayout != null) {
                                                            i11 = R$id.titleContainer;
                                                            LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                                                            if (linearLayout2 != null) {
                                                                i11 = R$id.tv_member;
                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView != null) {
                                                                    i11 = R$id.tv_title;
                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView2 != null) {
                                                                        i11 = R$id.v_join;
                                                                        RoomJoinAnimationView roomJoinAnimationView = (RoomJoinAnimationView) g4.b.a(view, i11);
                                                                        if (roomJoinAnimationView != null) {
                                                                            i11 = R$id.v_join_collapsed;
                                                                            RoomJoinAnimationView roomJoinAnimationView2 = (RoomJoinAnimationView) g4.b.a(view, i11);
                                                                            if (roomJoinAnimationView2 != null && (a12 = g4.b.a(view, (i11 = R$id.v_title_bar_bg))) != null && (a13 = g4.b.a(view, (i11 = R$id.v_top_bg_color))) != null) {
                                                                                i11 = R$id.videoCountText;
                                                                                TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                                                                                if (tnTextView != null) {
                                                                                    i11 = R$id.view_pager;
                                                                                    ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                                                    if (viewPager2 != null) {
                                                                                        return new q0((ConstraintLayout) view, appBarLayout, constraintLayout, expandView, bLFrameLayout, frameLayout, appCompatImageView, appCompatImageView2, shapeableImageView, appCompatImageView3, a11, imageView, linearLayout, magicIndicator, pileLayout, linearLayout2, appCompatTextView, appCompatTextView2, roomJoinAnimationView, roomJoinAnimationView2, a12, a13, tnTextView, viewPager2);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static q0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_user_profile, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62980a;
    }
}
