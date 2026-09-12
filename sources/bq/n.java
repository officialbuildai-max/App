package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CheckInAnimationView;
import com.tn.lib.view.ToolBarCheckInAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.publish.view.PublishStateView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16877a;

    /* renamed from: b, reason: collision with root package name */
    public final AppBarLayout f16878b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f16879c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f16880d;

    /* renamed from: e, reason: collision with root package name */
    public final CoordinatorLayout f16881e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f16882f;

    /* renamed from: g, reason: collision with root package name */
    public final ShapeableImageView f16883g;

    /* renamed from: h, reason: collision with root package name */
    public final PublishStateView f16884h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeableImageView f16885i;

    /* renamed from: j, reason: collision with root package name */
    public final ShapeableImageView f16886j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f16887k;

    /* renamed from: l, reason: collision with root package name */
    public final d0 f16888l;

    /* renamed from: m, reason: collision with root package name */
    public final PileLayout f16889m;

    /* renamed from: n, reason: collision with root package name */
    public final ConstraintLayout f16890n;

    /* renamed from: o, reason: collision with root package name */
    public final Toolbar f16891o;

    /* renamed from: p, reason: collision with root package name */
    public final FrameLayout f16892p;

    /* renamed from: q, reason: collision with root package name */
    public final CollapsingToolbarLayout f16893q;

    /* renamed from: r, reason: collision with root package name */
    public final ToolBarCheckInAnimationView f16894r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f16895s;

    /* renamed from: t, reason: collision with root package name */
    public final CheckInAnimationView f16896t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f16897u;

    /* renamed from: v, reason: collision with root package name */
    public final AppCompatTextView f16898v;

    /* renamed from: w, reason: collision with root package name */
    public final ExpandView f16899w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f16900x;

    /* renamed from: y, reason: collision with root package name */
    public final AppCompatTextView f16901y;

    /* renamed from: z, reason: collision with root package name */
    public final ViewPager2 f16902z;

    private n(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, CoordinatorLayout coordinatorLayout, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, PublishStateView publishStateView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, AppCompatImageView appCompatImageView3, d0 d0Var, PileLayout pileLayout, ConstraintLayout constraintLayout3, Toolbar toolbar, FrameLayout frameLayout, CollapsingToolbarLayout collapsingToolbarLayout, ToolBarCheckInAnimationView toolBarCheckInAnimationView, TextView textView, CheckInAnimationView checkInAnimationView, TextView textView2, AppCompatTextView appCompatTextView, ExpandView expandView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ViewPager2 viewPager2) {
        this.f16877a = constraintLayout;
        this.f16878b = appBarLayout;
        this.f16879c = appCompatImageView;
        this.f16880d = constraintLayout2;
        this.f16881e = coordinatorLayout;
        this.f16882f = appCompatImageView2;
        this.f16883g = shapeableImageView;
        this.f16884h = publishStateView;
        this.f16885i = shapeableImageView2;
        this.f16886j = shapeableImageView3;
        this.f16887k = appCompatImageView3;
        this.f16888l = d0Var;
        this.f16889m = pileLayout;
        this.f16890n = constraintLayout3;
        this.f16891o = toolbar;
        this.f16892p = frameLayout;
        this.f16893q = collapsingToolbarLayout;
        this.f16894r = toolBarCheckInAnimationView;
        this.f16895s = textView;
        this.f16896t = checkInAnimationView;
        this.f16897u = textView2;
        this.f16898v = appCompatTextView;
        this.f16899w = expandView;
        this.f16900x = appCompatTextView2;
        this.f16901y = appCompatTextView3;
        this.f16902z = viewPager2;
    }

    public static n a(View view) {
        View a11;
        int i11 = R$id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) g4.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.bg_transparent;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.cl_bar;
                ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                if (constraintLayout != null) {
                    i11 = R$id.content;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
                    if (coordinatorLayout != null) {
                        i11 = R$id.iv_back;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.iv_cover_small;
                            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                            if (shapeableImageView != null) {
                                i11 = R$id.ivPublish;
                                PublishStateView publishStateView = (PublishStateView) g4.b.a(view, i11);
                                if (publishStateView != null) {
                                    i11 = R$id.iv_room_blur_cover;
                                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                                    if (shapeableImageView2 != null) {
                                        i11 = R$id.iv_room_cover;
                                        ShapeableImageView shapeableImageView3 = (ShapeableImageView) g4.b.a(view, i11);
                                        if (shapeableImageView3 != null) {
                                            i11 = R$id.iv_share;
                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                            if (appCompatImageView3 != null && (a11 = g4.b.a(view, (i11 = R$id.ll_tab_room))) != null) {
                                                d0 a12 = d0.a(a11);
                                                i11 = R$id.pl_member_ic;
                                                PileLayout pileLayout = (PileLayout) g4.b.a(view, i11);
                                                if (pileLayout != null) {
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                                    i11 = R$id.toolbar;
                                                    Toolbar toolbar = (Toolbar) g4.b.a(view, i11);
                                                    if (toolbar != null) {
                                                        i11 = R$id.toolbar_frame;
                                                        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                                                        if (frameLayout != null) {
                                                            i11 = R$id.toolbar_layout;
                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) g4.b.a(view, i11);
                                                            if (collapsingToolbarLayout != null) {
                                                                i11 = R$id.toolbarTvCheckIn;
                                                                ToolBarCheckInAnimationView toolBarCheckInAnimationView = (ToolBarCheckInAnimationView) g4.b.a(view, i11);
                                                                if (toolBarCheckInAnimationView != null) {
                                                                    i11 = R$id.toolbar_tv_edit;
                                                                    TextView textView = (TextView) g4.b.a(view, i11);
                                                                    if (textView != null) {
                                                                        i11 = R$id.tvCheckIn;
                                                                        CheckInAnimationView checkInAnimationView = (CheckInAnimationView) g4.b.a(view, i11);
                                                                        if (checkInAnimationView != null) {
                                                                            i11 = R$id.tv_edit;
                                                                            TextView textView2 = (TextView) g4.b.a(view, i11);
                                                                            if (textView2 != null) {
                                                                                i11 = R$id.tv_member_count;
                                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                                if (appCompatTextView != null) {
                                                                                    i11 = R$id.tv_room_info_desc;
                                                                                    ExpandView expandView = (ExpandView) g4.b.a(view, i11);
                                                                                    if (expandView != null) {
                                                                                        i11 = R$id.tv_room_title;
                                                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                        if (appCompatTextView2 != null) {
                                                                                            i11 = R$id.tv_title;
                                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                            if (appCompatTextView3 != null) {
                                                                                                i11 = R$id.view_pager;
                                                                                                ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                                                                if (viewPager2 != null) {
                                                                                                    return new n(constraintLayout2, appBarLayout, appCompatImageView, constraintLayout, coordinatorLayout, appCompatImageView2, shapeableImageView, publishStateView, shapeableImageView2, shapeableImageView3, appCompatImageView3, a12, pileLayout, constraintLayout2, toolbar, frameLayout, collapsingToolbarLayout, toolBarCheckInAnimationView, textView, checkInAnimationView, textView2, appCompatTextView, expandView, appCompatTextView2, appCompatTextView3, viewPager2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16877a;
    }
}
