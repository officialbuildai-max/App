package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.AdTagView;
import com.transsion.ad.view.SwipeUpOrTapForDetailsView;

/* loaded from: classes6.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f66210a;

    /* renamed from: b, reason: collision with root package name */
    public final AdTagView f66211b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeUpOrTapForDetailsView f66212c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f66213d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f66214e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f66215f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f66216g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f66217h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f66218i;

    private g(ConstraintLayout constraintLayout, AdTagView adTagView, SwipeUpOrTapForDetailsView swipeUpOrTapForDetailsView, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, FrameLayout frameLayout3, AppCompatTextView appCompatTextView) {
        this.f66210a = constraintLayout;
        this.f66211b = adTagView;
        this.f66212c = swipeUpOrTapForDetailsView;
        this.f66213d = constraintLayout2;
        this.f66214e = frameLayout;
        this.f66215f = frameLayout2;
        this.f66216g = linearLayout;
        this.f66217h = frameLayout3;
        this.f66218i = appCompatTextView;
    }

    public static g a(View view) {
        int i11 = R$id.adIcon;
        AdTagView adTagView = (AdTagView) g4.b.a(view, i11);
        if (adTagView != null) {
            i11 = R$id.arcEdgeLayout;
            SwipeUpOrTapForDetailsView swipeUpOrTapForDetailsView = (SwipeUpOrTapForDetailsView) g4.b.a(view, i11);
            if (swipeUpOrTapForDetailsView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R$id.container;
                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.flVolumeContainer;
                    FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.llControl;
                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.movieBoxLayout;
                            FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout3 != null) {
                                i11 = R$id.tvCountDown;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    return new g(constraintLayout, adTagView, swipeUpOrTapForDetailsView, constraintLayout, frameLayout, frameLayout2, linearLayout, frameLayout3, appCompatTextView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_splash, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66210a;
    }
}
