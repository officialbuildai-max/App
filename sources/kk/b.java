package kk;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.commercialization.R$id;

/* loaded from: classes6.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66918a;

    /* renamed from: b, reason: collision with root package name */
    public final CardView f66919b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f66920c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f66921d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f66922e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f66923f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f66924g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f66925h;

    /* renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f66926i;

    /* renamed from: j, reason: collision with root package name */
    public final NativeWrapperAdView f66927j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f66928k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f66929l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f66930m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f66931n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f66932o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f66933p;

    /* renamed from: q, reason: collision with root package name */
    public final View f66934q;

    /* renamed from: r, reason: collision with root package name */
    public final View f66935r;

    private b(LinearLayout linearLayout, CardView cardView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout3, NativeWrapperAdView nativeWrapperAdView, TextView textView, TextView textView2, AppCompatTextView appCompatTextView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2) {
        this.f66918a = linearLayout;
        this.f66919b = cardView;
        this.f66920c = constraintLayout;
        this.f66921d = constraintLayout2;
        this.f66922e = appCompatImageView;
        this.f66923f = appCompatImageView2;
        this.f66924g = appCompatTextView;
        this.f66925h = appCompatImageView3;
        this.f66926i = constraintLayout3;
        this.f66927j = nativeWrapperAdView;
        this.f66928k = textView;
        this.f66929l = textView2;
        this.f66930m = appCompatTextView2;
        this.f66931n = textView3;
        this.f66932o = textView4;
        this.f66933p = textView5;
        this.f66934q = view;
        this.f66935r = view2;
    }

    public static b a(View view) {
        View a11;
        View a12;
        int i11 = R$id.cardView;
        CardView cardView = (CardView) g4.b.a(view, i11);
        if (cardView != null) {
            i11 = R$id.change_group;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.cl2MemberInfo;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                if (constraintLayout2 != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivIcon;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.ivPremium;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.ivRefresh;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R$id.llContent;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) g4.b.a(view, i11);
                                    if (constraintLayout3 != null) {
                                        i11 = R$id.nativeWrapperAdView;
                                        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) g4.b.a(view, i11);
                                        if (nativeWrapperAdView != null) {
                                            i11 = R$id.tvGetAd;
                                            TextView textView = (TextView) g4.b.a(view, i11);
                                            if (textView != null) {
                                                i11 = R$id.tvGetAdSec;
                                                TextView textView2 = (TextView) g4.b.a(view, i11);
                                                if (textView2 != null) {
                                                    i11 = R$id.tvOr;
                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView2 != null) {
                                                        i11 = R$id.tvTips;
                                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                                        if (textView3 != null) {
                                                            i11 = R$id.tvTipsSec;
                                                            TextView textView4 = (TextView) g4.b.a(view, i11);
                                                            if (textView4 != null) {
                                                                i11 = R$id.tvTryMore;
                                                                TextView textView5 = (TextView) g4.b.a(view, i11);
                                                                if (textView5 != null && (a11 = g4.b.a(view, (i11 = R$id.viewLineL))) != null && (a12 = g4.b.a(view, (i11 = R$id.viewLineR))) != null) {
                                                                    return new b((LinearLayout) view, cardView, constraintLayout, constraintLayout2, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatImageView3, constraintLayout3, nativeWrapperAdView, textView, textView2, appCompatTextView2, textView3, textView4, textView5, a11, a12);
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
    public LinearLayout getRoot() {
        return this.f66918a;
    }
}
