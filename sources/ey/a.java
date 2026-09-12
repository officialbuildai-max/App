package ey;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.activate.ui.LongVodActivateAdView;

/* loaded from: classes7.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f62179a;

    /* renamed from: b, reason: collision with root package name */
    public final LongVodActivateAdView f62180b;

    /* renamed from: c, reason: collision with root package name */
    public final CardView f62181c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f62182d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f62183e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f62184f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f62185g;

    /* renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f62186h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f62187i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f62188j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f62189k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f62190l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f62191m;

    /* renamed from: n, reason: collision with root package name */
    public final View f62192n;

    /* renamed from: o, reason: collision with root package name */
    public final View f62193o;

    private a(LinearLayout linearLayout, LongVodActivateAdView longVodActivateAdView, CardView cardView, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView2, TextView textView3, TextView textView4, View view, View view2) {
        this.f62179a = linearLayout;
        this.f62180b = longVodActivateAdView;
        this.f62181c = cardView;
        this.f62182d = constraintLayout;
        this.f62183e = appCompatImageView;
        this.f62184f = appCompatImageView2;
        this.f62185g = appCompatTextView;
        this.f62186h = constraintLayout2;
        this.f62187i = textView;
        this.f62188j = textView2;
        this.f62189k = appCompatTextView2;
        this.f62190l = textView3;
        this.f62191m = textView4;
        this.f62192n = view;
        this.f62193o = view2;
    }

    public static a a(View view) {
        View a11;
        View a12;
        int i11 = R$id.adView;
        LongVodActivateAdView longVodActivateAdView = (LongVodActivateAdView) g4.b.a(view, i11);
        if (longVodActivateAdView != null) {
            i11 = R$id.cardView;
            CardView cardView = (CardView) g4.b.a(view, i11);
            if (cardView != null) {
                i11 = R$id.cl2MemberInfo;
                ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                if (constraintLayout != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivIcon;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.ivPremium;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.llContent;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                                if (constraintLayout2 != null) {
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
                                                    if (textView4 != null && (a11 = g4.b.a(view, (i11 = R$id.viewLineL))) != null && (a12 = g4.b.a(view, (i11 = R$id.viewLineR))) != null) {
                                                        return new a((LinearLayout) view, longVodActivateAdView, cardView, constraintLayout, appCompatImageView, appCompatImageView2, appCompatTextView, constraintLayout2, textView, textView2, appCompatTextView2, textView3, textView4, a11, a12);
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
        return this.f62179a;
    }
}
