package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class a0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66145a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f66146b;

    private a0(LinearLayout linearLayout, Button button) {
        this.f66145a = linearLayout;
        this.f66146b = button;
    }

    public static a0 a(View view) {
        int i11 = R$id.btnLoadSplashAd;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            return new a0((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static a0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_splash_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f66145a;
    }
}
