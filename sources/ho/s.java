package ho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.GradientTextView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;

/* loaded from: classes6.dex */
public final class s implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64830a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64831b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f64832c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f64833d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f64834e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f64835f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f64836g;

    /* renamed from: h, reason: collision with root package name */
    public final NativeWrapperAdView f64837h;

    /* renamed from: i, reason: collision with root package name */
    public final GradientTextView f64838i;

    /* renamed from: j, reason: collision with root package name */
    public final GradientTextView f64839j;

    /* renamed from: k, reason: collision with root package name */
    public final GradientTextView f64840k;

    private s(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, LinearLayout linearLayout3, NativeWrapperAdView nativeWrapperAdView, GradientTextView gradientTextView, GradientTextView gradientTextView2, GradientTextView gradientTextView3) {
        this.f64830a = constraintLayout;
        this.f64831b = appCompatImageView;
        this.f64832c = appCompatImageView2;
        this.f64833d = linearLayout;
        this.f64834e = linearLayout2;
        this.f64835f = frameLayout;
        this.f64836g = linearLayout3;
        this.f64837h = nativeWrapperAdView;
        this.f64838i = gradientTextView;
        this.f64839j = gradientTextView2;
        this.f64840k = gradientTextView3;
    }

    public static s a(View view) {
        int i11 = R$id.ivRefresh;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivRefreshV;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.llBtnH;
                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                if (linearLayout != null) {
                    i11 = R$id.llBtnV;
                    LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                    if (linearLayout2 != null) {
                        i11 = R$id.llChange;
                        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                        if (frameLayout != null) {
                            i11 = R$id.llChangeV;
                            LinearLayout linearLayout3 = (LinearLayout) g4.b.a(view, i11);
                            if (linearLayout3 != null) {
                                i11 = R$id.nativeWrapperAdView;
                                NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) g4.b.a(view, i11);
                                if (nativeWrapperAdView != null) {
                                    i11 = R$id.tvInstall;
                                    GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                                    if (gradientTextView != null) {
                                        i11 = R$id.tvInstallV;
                                        GradientTextView gradientTextView2 = (GradientTextView) g4.b.a(view, i11);
                                        if (gradientTextView2 != null) {
                                            i11 = R$id.tvTryMore;
                                            GradientTextView gradientTextView3 = (GradientTextView) g4.b.a(view, i11);
                                            if (gradientTextView3 != null) {
                                                return new s((ConstraintLayout) view, appCompatImageView, appCompatImageView2, linearLayout, linearLayout2, frameLayout, linearLayout3, nativeWrapperAdView, gradientTextView, gradientTextView2, gradientTextView3);
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

    public static s c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.view_resolution_ad_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64830a;
    }
}
