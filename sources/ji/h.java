package ji;

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
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.AdTagView;
import com.transsion.ad.view.MemberTagView;

/* loaded from: classes6.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f66219a;

    /* renamed from: b, reason: collision with root package name */
    public final AdTagView f66220b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f66221c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f66222d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f66223e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f66224f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f66225g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f66226h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f66227i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f66228j;

    /* renamed from: k, reason: collision with root package name */
    public final ShapeableImageView f66229k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f66230l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f66231m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f66232n;

    /* renamed from: o, reason: collision with root package name */
    public final ShapeableImageView f66233o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f66234p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f66235q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f66236r;

    /* renamed from: s, reason: collision with root package name */
    public final AppCompatTextView f66237s;

    /* renamed from: t, reason: collision with root package name */
    public final LinearLayoutCompat f66238t;

    /* renamed from: u, reason: collision with root package name */
    public final MemberTagView f66239u;

    /* renamed from: v, reason: collision with root package name */
    public final View f66240v;

    private h(ConstraintLayout constraintLayout, AdTagView adTagView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ShapeableImageView shapeableImageView2, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, LinearLayoutCompat linearLayoutCompat, MemberTagView memberTagView, View view) {
        this.f66219a = constraintLayout;
        this.f66220b = adTagView;
        this.f66221c = constraintLayout2;
        this.f66222d = constraintLayout3;
        this.f66223e = constraintLayout4;
        this.f66224f = frameLayout;
        this.f66225g = frameLayout2;
        this.f66226h = appCompatImageView;
        this.f66227i = appCompatImageView2;
        this.f66228j = linearLayout;
        this.f66229k = shapeableImageView;
        this.f66230l = appCompatTextView;
        this.f66231m = appCompatTextView2;
        this.f66232n = appCompatTextView3;
        this.f66233o = shapeableImageView2;
        this.f66234p = appCompatTextView4;
        this.f66235q = appCompatTextView5;
        this.f66236r = appCompatTextView6;
        this.f66237s = appCompatTextView7;
        this.f66238t = linearLayoutCompat;
        this.f66239u = memberTagView;
        this.f66240v = view;
    }

    public static h a(View view) {
        View a11;
        int i11 = R$id.adIcon;
        AdTagView adTagView = (AdTagView) g4.b.a(view, i11);
        if (adTagView != null) {
            i11 = R$id.clAdEndLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.clAdInfo;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                if (constraintLayout2 != null) {
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                    i11 = R$id.container;
                    FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.flVolumeContainer;
                        FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                        if (frameLayout2 != null) {
                            i11 = R$id.ivAdClose;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView != null) {
                                i11 = R$id.ivClose;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView2 != null) {
                                    i11 = R$id.llMember;
                                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                    if (linearLayout != null) {
                                        i11 = R$id.tvAdAvatar;
                                        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                        if (shapeableImageView != null) {
                                            i11 = R$id.tvAdBtn;
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView != null) {
                                                i11 = R$id.tvAdDesc;
                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView2 != null) {
                                                    i11 = R$id.tvAdTitle;
                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView3 != null) {
                                                        i11 = R$id.tvAvatar;
                                                        ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                                                        if (shapeableImageView2 != null) {
                                                            i11 = R$id.tvBtn;
                                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView4 != null) {
                                                                i11 = R$id.tvCd;
                                                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView5 != null) {
                                                                    i11 = R$id.tvDesc;
                                                                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView6 != null) {
                                                                        i11 = R$id.tvTitle;
                                                                        AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                                        if (appCompatTextView7 != null) {
                                                                            i11 = R$id.viewCd;
                                                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                                                                            if (linearLayoutCompat != null) {
                                                                                i11 = R$id.viewMember;
                                                                                MemberTagView memberTagView = (MemberTagView) g4.b.a(view, i11);
                                                                                if (memberTagView != null && (a11 = g4.b.a(view, (i11 = R$id.viewMemberLiner))) != null) {
                                                                                    return new h(constraintLayout3, adTagView, constraintLayout, constraintLayout2, constraintLayout3, frameLayout, frameLayout2, appCompatImageView, appCompatImageView2, linearLayout, shapeableImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, shapeableImageView2, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, linearLayoutCompat, memberTagView, a11);
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

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_video_unspecified_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66219a;
    }
}
