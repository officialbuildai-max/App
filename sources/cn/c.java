package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.InfoExtendView;
import com.transsion.moviedetail.view.MovieDetailShareView;

/* loaded from: classes5.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17394a;

    /* renamed from: b, reason: collision with root package name */
    public final AppBarLayout f17395b;

    /* renamed from: c, reason: collision with root package name */
    public final CoordinatorLayout f17396c;

    /* renamed from: d, reason: collision with root package name */
    public final InfoExtendView f17397d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f17398e;

    /* renamed from: f, reason: collision with root package name */
    public final ShapeableImageView f17399f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f17400g;

    /* renamed from: h, reason: collision with root package name */
    public final MovieDetailShareView f17401h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f17402i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f17403j;

    /* renamed from: k, reason: collision with root package name */
    public final RecyclerView f17404k;

    /* renamed from: l, reason: collision with root package name */
    public final Space f17405l;

    /* renamed from: m, reason: collision with root package name */
    public final Toolbar f17406m;

    /* renamed from: n, reason: collision with root package name */
    public final CollapsingToolbarLayout f17407n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f17408o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f17409p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f17410q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f17411r;

    private c(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout, InfoExtendView infoExtendView, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView2, MovieDetailShareView movieDetailShareView, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, RecyclerView recyclerView, Space space, Toolbar toolbar, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f17394a = constraintLayout;
        this.f17395b = appBarLayout;
        this.f17396c = coordinatorLayout;
        this.f17397d = infoExtendView;
        this.f17398e = appCompatImageView;
        this.f17399f = shapeableImageView;
        this.f17400g = appCompatImageView2;
        this.f17401h = movieDetailShareView;
        this.f17402i = appCompatImageView3;
        this.f17403j = appCompatImageView4;
        this.f17404k = recyclerView;
        this.f17405l = space;
        this.f17406m = toolbar;
        this.f17407n = collapsingToolbarLayout;
        this.f17408o = textView;
        this.f17409p = appCompatTextView;
        this.f17410q = appCompatTextView2;
        this.f17411r = appCompatTextView3;
    }

    public static c a(View view) {
        int i11 = R$id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) g4.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.cdl;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
            if (coordinatorLayout != null) {
                i11 = R$id.infoExtendView;
                InfoExtendView infoExtendView = (InfoExtendView) g4.b.a(view, i11);
                if (infoExtendView != null) {
                    i11 = R$id.ivBack;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivCoverSmall;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                        if (shapeableImageView != null) {
                            i11 = R$id.ivDownload;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.ivShare;
                                MovieDetailShareView movieDetailShareView = (MovieDetailShareView) g4.b.a(view, i11);
                                if (movieDetailShareView != null) {
                                    i11 = R$id.iv_staff;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView3 != null) {
                                        i11 = R$id.iv_want_see;
                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView4 != null) {
                                            i11 = R$id.f46969rv;
                                            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                            if (recyclerView != null) {
                                                i11 = R$id.f46970sp;
                                                Space space = (Space) g4.b.a(view, i11);
                                                if (space != null) {
                                                    i11 = R$id.toolbar;
                                                    Toolbar toolbar = (Toolbar) g4.b.a(view, i11);
                                                    if (toolbar != null) {
                                                        i11 = R$id.toolbar_layout;
                                                        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) g4.b.a(view, i11);
                                                        if (collapsingToolbarLayout != null) {
                                                            i11 = R$id.tv_filmography;
                                                            TextView textView = (TextView) g4.b.a(view, i11);
                                                            if (textView != null) {
                                                                i11 = R$id.tv_staff_desc;
                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView != null) {
                                                                    i11 = R$id.tv_staff_name;
                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView2 != null) {
                                                                        i11 = R$id.tvTitle;
                                                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                        if (appCompatTextView3 != null) {
                                                                            return new c((ConstraintLayout) view, appBarLayout, coordinatorLayout, infoExtendView, appCompatImageView, shapeableImageView, appCompatImageView2, movieDetailShareView, appCompatImageView3, appCompatImageView4, recyclerView, space, toolbar, collapsingToolbarLayout, textView, appCompatTextView, appCompatTextView2, appCompatTextView3);
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

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_movie_staff, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17394a;
    }
}
