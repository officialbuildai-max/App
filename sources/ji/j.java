package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ScrollView f66243a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f66244b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f66245c;

    /* renamed from: d, reason: collision with root package name */
    public final Button f66246d;

    /* renamed from: e, reason: collision with root package name */
    public final Button f66247e;

    /* renamed from: f, reason: collision with root package name */
    public final Button f66248f;

    /* renamed from: g, reason: collision with root package name */
    public final Button f66249g;

    /* renamed from: h, reason: collision with root package name */
    public final Button f66250h;

    /* renamed from: i, reason: collision with root package name */
    public final Button f66251i;

    /* renamed from: j, reason: collision with root package name */
    public final Button f66252j;

    /* renamed from: k, reason: collision with root package name */
    public final Button f66253k;

    /* renamed from: l, reason: collision with root package name */
    public final Button f66254l;

    /* renamed from: m, reason: collision with root package name */
    public final Button f66255m;

    private j(ScrollView scrollView, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12) {
        this.f66243a = scrollView;
        this.f66244b = button;
        this.f66245c = button2;
        this.f66246d = button3;
        this.f66247e = button4;
        this.f66248f = button5;
        this.f66249g = button6;
        this.f66250h = button7;
        this.f66251i = button8;
        this.f66252j = button9;
        this.f66253k = button10;
        this.f66254l = button11;
        this.f66255m = button12;
    }

    public static j a(View view) {
        int i11 = R$id.btnIconAd;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnIrregularAd;
            Button button2 = (Button) g4.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.btnLoadBannerAd;
                Button button3 = (Button) g4.b.a(view, i11);
                if (button3 != null) {
                    i11 = R$id.btnLoadH5Ad;
                    Button button4 = (Button) g4.b.a(view, i11);
                    if (button4 != null) {
                        i11 = R$id.btnLoadInterstitialAd;
                        Button button5 = (Button) g4.b.a(view, i11);
                        if (button5 != null) {
                            i11 = R$id.btnLoadNativeAd;
                            Button button6 = (Button) g4.b.a(view, i11);
                            if (button6 != null) {
                                i11 = R$id.btnLoadNativeAdMultipleFetch;
                                Button button7 = (Button) g4.b.a(view, i11);
                                if (button7 != null) {
                                    i11 = R$id.btnLoadNativeListAd;
                                    Button button8 = (Button) g4.b.a(view, i11);
                                    if (button8 != null) {
                                        i11 = R$id.btnLoadSSPNativeAdFetch;
                                        Button button9 = (Button) g4.b.a(view, i11);
                                        if (button9 != null) {
                                            i11 = R$id.btnLoadSplashAd;
                                            Button button10 = (Button) g4.b.a(view, i11);
                                            if (button10 != null) {
                                                i11 = R$id.btnLoadVideoAd;
                                                Button button11 = (Button) g4.b.a(view, i11);
                                                if (button11 != null) {
                                                    i11 = R$id.btnViewMeasure;
                                                    Button button12 = (Button) g4.b.a(view, i11);
                                                    if (button12 != null) {
                                                        return new j((ScrollView) view, button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12);
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

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_a_example_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f66243a;
    }
}
