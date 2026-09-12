package kk;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.commercialization.R$id;

/* loaded from: classes6.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66943a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f66944b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f66945c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f66946d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f66947e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f66948f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f66949g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearLayoutCompat f66950h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayoutCompat f66951i;

    /* renamed from: j, reason: collision with root package name */
    public final h f66952j;

    /* renamed from: k, reason: collision with root package name */
    public final RecyclerView f66953k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f66954l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f66955m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f66956n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f66957o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f66958p;

    private d(LinearLayout linearLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, h hVar, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f66943a = linearLayout;
        this.f66944b = constraintLayout;
        this.f66945c = constraintLayout2;
        this.f66946d = appCompatImageView;
        this.f66947e = appCompatImageView2;
        this.f66948f = appCompatTextView;
        this.f66949g = appCompatImageView3;
        this.f66950h = linearLayoutCompat;
        this.f66951i = linearLayoutCompat2;
        this.f66952j = hVar;
        this.f66953k = recyclerView;
        this.f66954l = textView;
        this.f66955m = textView2;
        this.f66956n = textView3;
        this.f66957o = textView4;
        this.f66958p = textView5;
    }

    public static d a(View view) {
        View a11;
        int i11 = R$id.adGroup;
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
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                                if (linearLayoutCompat != null) {
                                    i11 = R$id.llLine;
                                    LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) g4.b.a(view, i11);
                                    if (linearLayoutCompat2 != null && (a11 = g4.b.a(view, (i11 = R$id.rewarded_layout))) != null) {
                                        h a12 = h.a(a11);
                                        i11 = R$id.f43791rv;
                                        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                        if (recyclerView != null) {
                                            i11 = R$id.tvGetAd;
                                            TextView textView = (TextView) g4.b.a(view, i11);
                                            if (textView != null) {
                                                i11 = R$id.tvGetAdSec;
                                                TextView textView2 = (TextView) g4.b.a(view, i11);
                                                if (textView2 != null) {
                                                    i11 = R$id.tvTips;
                                                    TextView textView3 = (TextView) g4.b.a(view, i11);
                                                    if (textView3 != null) {
                                                        i11 = R$id.tvTipsSec;
                                                        TextView textView4 = (TextView) g4.b.a(view, i11);
                                                        if (textView4 != null) {
                                                            i11 = R$id.tvTryMore;
                                                            TextView textView5 = (TextView) g4.b.a(view, i11);
                                                            if (textView5 != null) {
                                                                return new d((LinearLayout) view, constraintLayout, constraintLayout2, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatImageView3, linearLayoutCompat, linearLayoutCompat2, a12, recyclerView, textView, textView2, textView3, textView4, textView5);
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
        return this.f66943a;
    }
}
