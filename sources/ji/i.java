package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hisavana.mediation.ad.TSplashView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f66241a;

    /* renamed from: b, reason: collision with root package name */
    public final TSplashView f66242b;

    private i(ConstraintLayout constraintLayout, TSplashView tSplashView) {
        this.f66241a = constraintLayout;
        this.f66242b = tSplashView;
    }

    public static i a(View view) {
        int i11 = R$id.splash_ad;
        TSplashView tSplashView = (TSplashView) g4.b.a(view, i11);
        if (tSplashView != null) {
            return new i((ConstraintLayout) view, tSplashView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_bidding_hisavana_splash, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66241a;
    }
}
