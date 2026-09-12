package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes5.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16903a;

    /* renamed from: b, reason: collision with root package name */
    public final AppBarLayout f16904b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f16905c;

    /* renamed from: d, reason: collision with root package name */
    public final ExpandView f16906d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f16907e;

    /* renamed from: f, reason: collision with root package name */
    public final Group f16908f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f16909g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f16910h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeableImageView f16911i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f16912j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f16913k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f16914l;

    /* renamed from: m, reason: collision with root package name */
    public final MagicIndicator f16915m;

    /* renamed from: n, reason: collision with root package name */
    public final PileLayout f16916n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatTextView f16917o;

    /* renamed from: p, reason: collision with root package name */
    public final GradientTextView f16918p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f16919q;

    /* renamed from: r, reason: collision with root package name */
    public final RoomJoinAnimationView f16920r;

    /* renamed from: s, reason: collision with root package name */
    public final View f16921s;

    /* renamed from: t, reason: collision with root package name */
    public final ViewPager2 f16922t;

    private o(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, ExpandView expandView, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView3, ImageView imageView, LinearLayout linearLayout, MagicIndicator magicIndicator, PileLayout pileLayout, AppCompatTextView appCompatTextView, GradientTextView gradientTextView, AppCompatTextView appCompatTextView2, RoomJoinAnimationView roomJoinAnimationView, View view, ViewPager2 viewPager2) {
        this.f16903a = constraintLayout;
        this.f16904b = appBarLayout;
        this.f16905c = constraintLayout2;
        this.f16906d = expandView;
        this.f16907e = frameLayout;
        this.f16908f = group;
        this.f16909g = appCompatImageView;
        this.f16910h = appCompatImageView2;
        this.f16911i = shapeableImageView;
        this.f16912j = appCompatImageView3;
        this.f16913k = imageView;
        this.f16914l = linearLayout;
        this.f16915m = magicIndicator;
        this.f16916n = pileLayout;
        this.f16917o = appCompatTextView;
        this.f16918p = gradientTextView;
        this.f16919q = appCompatTextView2;
        this.f16920r = roomJoinAnimationView;
        this.f16921s = view;
        this.f16922t = viewPager2;
    }

    public static o a(View view) {
        View a11;
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
                    FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.group_member;
                        Group group = (Group) g4.b.a(view, i11);
                        if (group != null) {
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
                                        if (appCompatImageView3 != null) {
                                            i11 = R$id.iv_top_bg;
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
                                                            i11 = R$id.tv_member;
                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView != null) {
                                                                i11 = R$id.tv_post;
                                                                GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                                                                if (gradientTextView != null) {
                                                                    i11 = R$id.tv_title;
                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView2 != null) {
                                                                        i11 = R$id.v_join;
                                                                        RoomJoinAnimationView roomJoinAnimationView = (RoomJoinAnimationView) g4.b.a(view, i11);
                                                                        if (roomJoinAnimationView != null && (a11 = g4.b.a(view, (i11 = R$id.v_title_bar_bg))) != null) {
                                                                            i11 = R$id.view_pager;
                                                                            ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                                            if (viewPager2 != null) {
                                                                                return new o((ConstraintLayout) view, appBarLayout, constraintLayout, expandView, frameLayout, group, appCompatImageView, appCompatImageView2, shapeableImageView, appCompatImageView3, imageView, linearLayout, magicIndicator, pileLayout, appCompatTextView, gradientTextView, appCompatTextView2, roomJoinAnimationView, a11, viewPager2);
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

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_detail_new, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16903a;
    }
}
