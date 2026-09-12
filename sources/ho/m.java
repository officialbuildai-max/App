package ho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.postdetail.ui.view.AdCountDownView;

/* loaded from: classes6.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f64802a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64803b;

    /* renamed from: c, reason: collision with root package name */
    public final AdCountDownView f64804c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f64805d;

    /* renamed from: e, reason: collision with root package name */
    public final NativeWrapperAdView f64806e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f64807f;

    private m(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AdCountDownView adCountDownView, FrameLayout frameLayout2, NativeWrapperAdView nativeWrapperAdView, AppCompatImageView appCompatImageView2) {
        this.f64802a = frameLayout;
        this.f64803b = appCompatImageView;
        this.f64804c = adCountDownView;
        this.f64805d = frameLayout2;
        this.f64806e = nativeWrapperAdView;
        this.f64807f = appCompatImageView2;
    }

    public static m a(View view) {
        int i11 = R$id.adCloseView;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.adCountDownView;
            AdCountDownView adCountDownView = (AdCountDownView) g4.b.a(view, i11);
            if (adCountDownView != null) {
                i11 = R$id.flContent;
                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.flLandAd;
                    NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) g4.b.a(view, i11);
                    if (nativeWrapperAdView != null) {
                        i11 = R$id.rotate;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            return new m((FrameLayout) view, appCompatImageView, adCountDownView, frameLayout, nativeWrapperAdView, appCompatImageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static m c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.playback_intercept_ad_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f64802a;
    }
}
