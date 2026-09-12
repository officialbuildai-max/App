package kk;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.task.treasure.TreasureAdView;

/* loaded from: classes6.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ScrollView f66959a;

    /* renamed from: b, reason: collision with root package name */
    public final TreasureAdView f66960b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f66961c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f66962d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f66963e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f66964f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f66965g;

    /* renamed from: h, reason: collision with root package name */
    public final ShapeableImageView f66966h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f66967i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f66968j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f66969k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f66970l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f66971m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f66972n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f66973o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f66974p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f66975q;

    /* renamed from: r, reason: collision with root package name */
    public final View f66976r;

    /* renamed from: s, reason: collision with root package name */
    public final View f66977s;

    private e(ScrollView scrollView, TreasureAdView treasureAdView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ShapeableImageView shapeableImageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view, View view2) {
        this.f66959a = scrollView;
        this.f66960b = treasureAdView;
        this.f66961c = constraintLayout;
        this.f66962d = constraintLayout2;
        this.f66963e = appCompatImageView;
        this.f66964f = appCompatImageView2;
        this.f66965g = appCompatImageView3;
        this.f66966h = shapeableImageView;
        this.f66967i = linearLayout;
        this.f66968j = linearLayout2;
        this.f66969k = textView;
        this.f66970l = textView2;
        this.f66971m = appCompatTextView;
        this.f66972n = textView3;
        this.f66973o = textView4;
        this.f66974p = textView5;
        this.f66975q = textView6;
        this.f66976r = view;
        this.f66977s = view2;
    }

    public static e a(View view) {
        View a11;
        View a12;
        int i11 = R$id.cardView;
        TreasureAdView treasureAdView = (TreasureAdView) g4.b.a(view, i11);
        if (treasureAdView != null) {
            i11 = R$id.clMemberModule;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.clPayModule;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                if (constraintLayout2 != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivLittleTop;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.ivPremium;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView3 != null) {
                                i11 = R$id.ivTop;
                                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                if (shapeableImageView != null) {
                                    i11 = R$id.llContent;
                                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                    if (linearLayout != null) {
                                        i11 = R$id.llOrModule;
                                        LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                                        if (linearLayout2 != null) {
                                            i11 = R$id.tvMoneyDes;
                                            TextView textView = (TextView) g4.b.a(view, i11);
                                            if (textView != null) {
                                                i11 = R$id.tvMoneyNum;
                                                TextView textView2 = (TextView) g4.b.a(view, i11);
                                                if (textView2 != null) {
                                                    i11 = R$id.tvOr;
                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView != null) {
                                                        i11 = R$id.tvPremium;
                                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                                        if (textView3 != null) {
                                                            i11 = R$id.tvTitle1;
                                                            TextView textView4 = (TextView) g4.b.a(view, i11);
                                                            if (textView4 != null) {
                                                                i11 = R$id.tvTitle2;
                                                                TextView textView5 = (TextView) g4.b.a(view, i11);
                                                                if (textView5 != null) {
                                                                    i11 = R$id.tvTitle3;
                                                                    TextView textView6 = (TextView) g4.b.a(view, i11);
                                                                    if (textView6 != null && (a11 = g4.b.a(view, (i11 = R$id.viewLineL))) != null && (a12 = g4.b.a(view, (i11 = R$id.viewLineR))) != null) {
                                                                        return new e((ScrollView) view, treasureAdView, constraintLayout, constraintLayout2, appCompatImageView, appCompatImageView2, appCompatImageView3, shapeableImageView, linearLayout, linearLayout2, textView, textView2, appCompatTextView, textView3, textView4, textView5, textView6, a11, a12);
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

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f66959a;
    }
}
