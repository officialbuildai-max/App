package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.InfoExtendView;

/* loaded from: classes5.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17512a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f17513b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f17514c;

    /* renamed from: d, reason: collision with root package name */
    public final InfoExtendView f17515d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f17516e;

    /* renamed from: f, reason: collision with root package name */
    public final ShapeableImageView f17517f;

    /* renamed from: g, reason: collision with root package name */
    public final View f17518g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f17519h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f17520i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f17521j;

    /* renamed from: k, reason: collision with root package name */
    public final CustomTextViewGroup f17522k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayoutCompat f17523l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f17524m;

    /* renamed from: n, reason: collision with root package name */
    public final CustomTextViewGroup f17525n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatTextView f17526o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f17527p;

    /* renamed from: q, reason: collision with root package name */
    public final CustomTextViewGroup f17528q;

    /* renamed from: r, reason: collision with root package name */
    public final CustomTextViewGroup f17529r;

    /* renamed from: s, reason: collision with root package name */
    public final View f17530s;

    /* renamed from: t, reason: collision with root package name */
    public final View f17531t;

    private p(ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, InfoExtendView infoExtendView, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, View view, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, AppCompatImageView appCompatImageView3, CustomTextViewGroup customTextViewGroup, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, CustomTextViewGroup customTextViewGroup2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, CustomTextViewGroup customTextViewGroup3, CustomTextViewGroup customTextViewGroup4, View view2, View view3) {
        this.f17512a = constraintLayout;
        this.f17513b = frameLayout;
        this.f17514c = frameLayout2;
        this.f17515d = infoExtendView;
        this.f17516e = appCompatImageView;
        this.f17517f = shapeableImageView;
        this.f17518g = view;
        this.f17519h = appCompatImageView2;
        this.f17520i = linearLayout;
        this.f17521j = appCompatImageView3;
        this.f17522k = customTextViewGroup;
        this.f17523l = linearLayoutCompat;
        this.f17524m = appCompatTextView;
        this.f17525n = customTextViewGroup2;
        this.f17526o = appCompatTextView2;
        this.f17527p = appCompatTextView3;
        this.f17528q = customTextViewGroup3;
        this.f17529r = customTextViewGroup4;
        this.f17530s = view2;
        this.f17531t = view3;
    }

    public static p a(View view) {
        View a11;
        View a12;
        View a13;
        int i11 = R$id.fl_starring;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.game_container;
            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout2 != null) {
                i11 = R$id.infoExtendView;
                InfoExtendView infoExtendView = (InfoExtendView) g4.b.a(view, i11);
                if (infoExtendView != null) {
                    i11 = R$id.ivMovieContent;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivMovieCover;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                        if (shapeableImageView != null && (a11 = g4.b.a(view, (i11 = R$id.ivMovieCoverMask))) != null) {
                            i11 = R$id.iv_score;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.ll_score;
                                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                if (linearLayout != null) {
                                    i11 = R$id.tv_close;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView3 != null) {
                                        i11 = R$id.tv_country;
                                        CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) g4.b.a(view, i11);
                                        if (customTextViewGroup != null) {
                                            i11 = R$id.tv_header_toolbar;
                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                                            if (linearLayoutCompat != null) {
                                                i11 = R$id.tvMovieTitle;
                                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView != null) {
                                                    i11 = R$id.tv_restrict;
                                                    CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) g4.b.a(view, i11);
                                                    if (customTextViewGroup2 != null) {
                                                        i11 = R$id.tv_score;
                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView2 != null) {
                                                            i11 = R$id.tv_seasons;
                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView3 != null) {
                                                                i11 = R$id.tv_time;
                                                                CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) g4.b.a(view, i11);
                                                                if (customTextViewGroup3 != null) {
                                                                    i11 = R$id.tv_type;
                                                                    CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) g4.b.a(view, i11);
                                                                    if (customTextViewGroup4 != null && (a12 = g4.b.a(view, (i11 = R$id.v_seasons_line))) != null && (a13 = g4.b.a(view, (i11 = R$id.view_separator))) != null) {
                                                                        return new p((ConstraintLayout) view, frameLayout, frameLayout2, infoExtendView, appCompatImageView, shapeableImageView, a11, appCompatImageView2, linearLayout, appCompatImageView3, customTextViewGroup, linearLayoutCompat, appCompatTextView, customTextViewGroup2, appCompatTextView2, appCompatTextView3, customTextViewGroup3, customTextViewGroup4, a12, a13);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_detail_info_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17512a;
    }
}
