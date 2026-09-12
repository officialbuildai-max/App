package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;

/* loaded from: classes6.dex */
public final class s implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66297a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f66298b;

    /* renamed from: c, reason: collision with root package name */
    public final NativeWrapperAdView f66299c;

    private s(LinearLayout linearLayout, Button button, NativeWrapperAdView nativeWrapperAdView) {
        this.f66297a = linearLayout;
        this.f66298b = button;
        this.f66299c = nativeWrapperAdView;
    }

    public static s a(View view) {
        int i11 = R$id.btnLoadNativeAd;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            i11 = R$id.nativeView;
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) g4.b.a(view, i11);
            if (nativeWrapperAdView != null) {
                return new s((LinearLayout) view, button, nativeWrapperAdView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_native_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f66297a;
    }
}
