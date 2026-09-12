package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66270a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f66271b;

    private n(LinearLayout linearLayout, Button button) {
        this.f66270a = linearLayout;
        this.f66271b = button;
    }

    public static n a(View view) {
        int i11 = R$id.btnLoadInterstitialAd;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            return new n((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_interstitial_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f66270a;
    }
}
