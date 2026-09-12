package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.PostDetailOperationView;
import com.transsion.postdetail.ui.view.PostDetailSubjectView;

/* loaded from: classes6.dex */
public final class p implements g4.a {
    public final AppCompatTextView A;
    public final View B;
    public final View C;

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f75769a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f75770b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f75771c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f75772d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatSeekBar f75773e;

    /* renamed from: f, reason: collision with root package name */
    public final AppBarLayout f75774f;

    /* renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f75775g;

    /* renamed from: h, reason: collision with root package name */
    public final CoordinatorLayout f75776h;

    /* renamed from: i, reason: collision with root package name */
    public final n0 f75777i;

    /* renamed from: j, reason: collision with root package name */
    public final ConstraintLayout f75778j;

    /* renamed from: k, reason: collision with root package name */
    public final FrameLayout f75779k;

    /* renamed from: l, reason: collision with root package name */
    public final Group f75780l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatImageView f75781m;

    /* renamed from: n, reason: collision with root package name */
    public final ShapeableImageView f75782n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatImageView f75783o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatImageView f75784p;

    /* renamed from: q, reason: collision with root package name */
    public final LinearLayout f75785q;

    /* renamed from: r, reason: collision with root package name */
    public final NineGridVideoView f75786r;

    /* renamed from: s, reason: collision with root package name */
    public final PostDetailOperationView f75787s;

    /* renamed from: t, reason: collision with root package name */
    public final PostDetailSubjectView f75788t;

    /* renamed from: u, reason: collision with root package name */
    public final Toolbar f75789u;

    /* renamed from: v, reason: collision with root package name */
    public final CollapsingToolbarLayout f75790v;

    /* renamed from: w, reason: collision with root package name */
    public final m0 f75791w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f75792x;

    /* renamed from: y, reason: collision with root package name */
    public final o0 f75793y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatTextView f75794z;

    private p(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatSeekBar appCompatSeekBar, AppBarLayout appBarLayout, ConstraintLayout constraintLayout3, CoordinatorLayout coordinatorLayout, n0 n0Var, ConstraintLayout constraintLayout4, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout, NineGridVideoView nineGridVideoView, PostDetailOperationView postDetailOperationView, PostDetailSubjectView postDetailSubjectView, Toolbar toolbar, CollapsingToolbarLayout collapsingToolbarLayout, m0 m0Var, AppCompatTextView appCompatTextView, o0 o0Var, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view, View view2) {
        this.f75769a = constraintLayout;
        this.f75770b = textView;
        this.f75771c = constraintLayout2;
        this.f75772d = appCompatImageView;
        this.f75773e = appCompatSeekBar;
        this.f75774f = appBarLayout;
        this.f75775g = constraintLayout3;
        this.f75776h = coordinatorLayout;
        this.f75777i = n0Var;
        this.f75778j = constraintLayout4;
        this.f75779k = frameLayout;
        this.f75780l = group;
        this.f75781m = appCompatImageView2;
        this.f75782n = shapeableImageView;
        this.f75783o = appCompatImageView3;
        this.f75784p = appCompatImageView4;
        this.f75785q = linearLayout;
        this.f75786r = nineGridVideoView;
        this.f75787s = postDetailOperationView;
        this.f75788t = postDetailSubjectView;
        this.f75789u = toolbar;
        this.f75790v = collapsingToolbarLayout;
        this.f75791w = m0Var;
        this.f75792x = appCompatTextView;
        this.f75793y = o0Var;
        this.f75794z = appCompatTextView2;
        this.A = appCompatTextView3;
        this.B = view;
        this.C = view2;
    }

    public static p a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        View a15;
        int i11 = R$id.ad_audio_time;
        TextView textView = (TextView) g4.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.ad_bottom_controller;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.ad_pause;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ad_seekbar;
                    AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) g4.b.a(view, i11);
                    if (appCompatSeekBar != null) {
                        i11 = R$id.appBar;
                        AppBarLayout appBarLayout = (AppBarLayout) g4.b.a(view, i11);
                        if (appBarLayout != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i11 = R$id.clContent;
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
                            if (coordinatorLayout != null && (a11 = g4.b.a(view, (i11 = R$id.clRating))) != null) {
                                n0 a16 = n0.a(a11);
                                i11 = R$id.contentView;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) g4.b.a(view, i11);
                                if (constraintLayout3 != null) {
                                    i11 = R$id.flContainer;
                                    FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                                    if (frameLayout != null) {
                                        i11 = R$id.groupAudio;
                                        Group group = (Group) g4.b.a(view, i11);
                                        if (group != null) {
                                            i11 = R$id.iv_audio_wave;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                            if (appCompatImageView2 != null) {
                                                i11 = R$id.ivAvatar;
                                                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                                if (shapeableImageView != null) {
                                                    i11 = R$id.ivBack;
                                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                                    if (appCompatImageView3 != null) {
                                                        i11 = R$id.iv_cover;
                                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                                        if (appCompatImageView4 != null) {
                                                            i11 = R$id.llTop;
                                                            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                            if (linearLayout != null) {
                                                                i11 = R$id.nine_grid;
                                                                NineGridVideoView nineGridVideoView = (NineGridVideoView) g4.b.a(view, i11);
                                                                if (nineGridVideoView != null) {
                                                                    i11 = R$id.postDetailOperationView;
                                                                    PostDetailOperationView postDetailOperationView = (PostDetailOperationView) g4.b.a(view, i11);
                                                                    if (postDetailOperationView != null) {
                                                                        i11 = R$id.postDetailSubjectView;
                                                                        PostDetailSubjectView postDetailSubjectView = (PostDetailSubjectView) g4.b.a(view, i11);
                                                                        if (postDetailSubjectView != null) {
                                                                            i11 = R$id.toolbar;
                                                                            Toolbar toolbar = (Toolbar) g4.b.a(view, i11);
                                                                            if (toolbar != null) {
                                                                                i11 = R$id.toolbarLayout;
                                                                                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) g4.b.a(view, i11);
                                                                                if (collapsingToolbarLayout != null && (a12 = g4.b.a(view, (i11 = R$id.tvPostDesc))) != null) {
                                                                                    m0 a17 = m0.a(a12);
                                                                                    i11 = R$id.tvPostTime;
                                                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                                    if (appCompatTextView != null && (a13 = g4.b.a(view, (i11 = R$id.tvPostTitle))) != null) {
                                                                                        o0 a18 = o0.a(a13);
                                                                                        i11 = R$id.tvSubject;
                                                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                        if (appCompatTextView2 != null) {
                                                                                            i11 = R$id.tvTitle;
                                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                            if (appCompatTextView3 != null && (a14 = g4.b.a(view, (i11 = R$id.viewBg))) != null && (a15 = g4.b.a(view, (i11 = R$id.viewTitleLine))) != null) {
                                                                                                return new p(constraintLayout2, textView, constraintLayout, appCompatImageView, appCompatSeekBar, appBarLayout, constraintLayout2, coordinatorLayout, a16, constraintLayout3, frameLayout, group, appCompatImageView2, shapeableImageView, appCompatImageView3, appCompatImageView4, linearLayout, nineGridVideoView, postDetailOperationView, postDetailSubjectView, toolbar, collapsingToolbarLayout, a17, appCompatTextView, a18, appCompatTextView2, appCompatTextView3, a14, a15);
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

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_post_detail_common_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75769a;
    }
}
