package wm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.member.R$id;

/* loaded from: classes6.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f77919a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f77920b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f77921c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f77922d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f77923e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f77924f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f77925g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f77926h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f77927i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f77928j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f77929k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f77930l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f77931m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f77932n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f77933o;

    /* renamed from: p, reason: collision with root package name */
    public final View f77934p;

    private l(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view) {
        this.f77919a = frameLayout;
        this.f77920b = linearLayout;
        this.f77921c = linearLayout2;
        this.f77922d = textView;
        this.f77923e = textView2;
        this.f77924f = appCompatTextView;
        this.f77925g = textView3;
        this.f77926h = textView4;
        this.f77927i = textView5;
        this.f77928j = textView6;
        this.f77929k = textView7;
        this.f77930l = textView8;
        this.f77931m = textView9;
        this.f77932n = textView10;
        this.f77933o = textView11;
        this.f77934p = view;
    }

    public static l a(View view) {
        View a11;
        int i11 = R$id.llDiscount;
        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
        if (linearLayout != null) {
            i11 = R$id.llTime;
            LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
            if (linearLayout2 != null) {
                i11 = R$id.tvBillingPeriod;
                TextView textView = (TextView) g4.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tvDiscount;
                    TextView textView2 = (TextView) g4.b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.tvDiscountPrice;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tvEndsIn;
                            TextView textView3 = (TextView) g4.b.a(view, i11);
                            if (textView3 != null) {
                                i11 = R$id.tvHour;
                                TextView textView4 = (TextView) g4.b.a(view, i11);
                                if (textView4 != null) {
                                    i11 = R$id.tvLater;
                                    TextView textView5 = (TextView) g4.b.a(view, i11);
                                    if (textView5 != null) {
                                        i11 = R$id.tvMinute;
                                        TextView textView6 = (TextView) g4.b.a(view, i11);
                                        if (textView6 != null) {
                                            i11 = R$id.tvOriginalPrice;
                                            TextView textView7 = (TextView) g4.b.a(view, i11);
                                            if (textView7 != null) {
                                                i11 = R$id.tvPremiumDesc;
                                                TextView textView8 = (TextView) g4.b.a(view, i11);
                                                if (textView8 != null) {
                                                    i11 = R$id.tvRenew;
                                                    TextView textView9 = (TextView) g4.b.a(view, i11);
                                                    if (textView9 != null) {
                                                        i11 = R$id.tvSecond;
                                                        TextView textView10 = (TextView) g4.b.a(view, i11);
                                                        if (textView10 != null) {
                                                            i11 = R$id.tvTitle;
                                                            TextView textView11 = (TextView) g4.b.a(view, i11);
                                                            if (textView11 != null && (a11 = g4.b.a(view, (i11 = R$id.viewStar))) != null) {
                                                                return new l((FrameLayout) view, linearLayout, linearLayout2, textView, textView2, appCompatTextView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, a11);
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
    public FrameLayout getRoot() {
        return this.f77919a;
    }
}
