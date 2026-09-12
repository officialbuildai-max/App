package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ad.AdInterceptTimerView;
import com.transsion.postdetail.ui.view.AdCountDownView;

/* loaded from: classes6.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f75699a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f75700b;

    /* renamed from: c, reason: collision with root package name */
    public final NativeWrapperAdView f75701c;

    /* renamed from: d, reason: collision with root package name */
    public final AdCountDownView f75702d;

    /* renamed from: e, reason: collision with root package name */
    public final AdInterceptTimerView f75703e;

    /* renamed from: f, reason: collision with root package name */
    public final NativeWrapperAdView f75704f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f75705g;

    /* renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f75706h;

    /* renamed from: i, reason: collision with root package name */
    public final View f75707i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f75708j;

    /* renamed from: k, reason: collision with root package name */
    public final z f75709k;

    /* renamed from: l, reason: collision with root package name */
    public final b0 f75710l;

    /* renamed from: m, reason: collision with root package name */
    public final d0 f75711m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatImageView f75712n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f75713o;

    private l(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, NativeWrapperAdView nativeWrapperAdView, AdCountDownView adCountDownView, AdInterceptTimerView adInterceptTimerView, NativeWrapperAdView nativeWrapperAdView2, FrameLayout frameLayout, ConstraintLayout constraintLayout2, View view, ImageView imageView, z zVar, b0 b0Var, d0 d0Var, AppCompatImageView appCompatImageView2, ImageView imageView2) {
        this.f75699a = constraintLayout;
        this.f75700b = appCompatImageView;
        this.f75701c = nativeWrapperAdView;
        this.f75702d = adCountDownView;
        this.f75703e = adInterceptTimerView;
        this.f75704f = nativeWrapperAdView2;
        this.f75705g = frameLayout;
        this.f75706h = constraintLayout2;
        this.f75707i = view;
        this.f75708j = imageView;
        this.f75709k = zVar;
        this.f75710l = b0Var;
        this.f75711m = d0Var;
        this.f75712n = appCompatImageView2;
        this.f75713o = imageView2;
    }

    public static l a(View view) {
        View a11;
        View a12;
        int i11 = R$id.adCloseView;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.adContainer;
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) g4.b.a(view, i11);
            if (nativeWrapperAdView != null) {
                i11 = R$id.adCountDownView;
                AdCountDownView adCountDownView = (AdCountDownView) g4.b.a(view, i11);
                if (adCountDownView != null) {
                    i11 = R$id.enter_ad_tip;
                    AdInterceptTimerView adInterceptTimerView = (AdInterceptTimerView) g4.b.a(view, i11);
                    if (adInterceptTimerView != null) {
                        i11 = R$id.flLandAd;
                        NativeWrapperAdView nativeWrapperAdView2 = (NativeWrapperAdView) g4.b.a(view, i11);
                        if (nativeWrapperAdView2 != null) {
                            i11 = R$id.flLandAdGroup;
                            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout != null) {
                                i11 = R$id.flPauseAdGroup;
                                ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                                if (constraintLayout != null && (a11 = g4.b.a(view, (i11 = R$id.guideline))) != null) {
                                    i11 = R$id.ivAdPauseClose;
                                    ImageView imageView = (ImageView) g4.b.a(view, i11);
                                    if (imageView != null && (a12 = g4.b.a(view, (i11 = R$id.local_video_land))) != null) {
                                        z a13 = z.a(a12);
                                        i11 = R$id.local_video_middle;
                                        View a14 = g4.b.a(view, i11);
                                        if (a14 != null) {
                                            b0 a15 = b0.a(a14);
                                            i11 = R$id.local_video_portrait;
                                            View a16 = g4.b.a(view, i11);
                                            if (a16 != null) {
                                                d0 a17 = d0.a(a16);
                                                i11 = R$id.rotate;
                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                                if (appCompatImageView2 != null) {
                                                    i11 = R$id.v_top_space;
                                                    ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                                                    if (imageView2 != null) {
                                                        return new l((ConstraintLayout) view, appCompatImageView, nativeWrapperAdView, adCountDownView, adInterceptTimerView, nativeWrapperAdView2, frameLayout, constraintLayout, a11, imageView, a13, a15, a17, appCompatImageView2, imageView2);
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

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_local_video, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75699a;
    }
}
