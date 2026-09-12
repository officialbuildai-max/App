package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63872a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f63873b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f63874c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f63875d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f63876e;

    /* renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f63877f;

    /* renamed from: g, reason: collision with root package name */
    public final TnTextView f63878g;

    /* renamed from: h, reason: collision with root package name */
    public final View f63879h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f63880i;

    /* renamed from: j, reason: collision with root package name */
    public final BlurredSectorView f63881j;

    private k(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, TnTextView tnTextView, View view, TextView textView, BlurredSectorView blurredSectorView) {
        this.f63872a = constraintLayout;
        this.f63873b = frameLayout;
        this.f63874c = appCompatImageView;
        this.f63875d = appCompatImageView2;
        this.f63876e = frameLayout2;
        this.f63877f = constraintLayout2;
        this.f63878g = tnTextView;
        this.f63879h = view;
        this.f63880i = textView;
        this.f63881j = blurredSectorView;
    }

    public static k a(View view) {
        View a11;
        int i11 = R$id.bottom_op_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.bottom_op_mb_logo;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.bottom_op_search_appstore;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.bottom_op_search_gamestore;
                    FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.bottom_op_search_liner;
                        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                        if (constraintLayout != null) {
                            i11 = R$id.bottom_op_search_text;
                            TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                            if (tnTextView != null && (a11 = g4.b.a(view, (i11 = R$id.divider_line))) != null) {
                                i11 = R$id.subscription_title;
                                TextView textView = (TextView) g4.b.a(view, i11);
                                if (textView != null) {
                                    i11 = R$id.trending_bottom_bg;
                                    BlurredSectorView blurredSectorView = (BlurredSectorView) g4.b.a(view, i11);
                                    if (blurredSectorView != null) {
                                        return new k((ConstraintLayout) view, frameLayout, appCompatImageView, appCompatImageView2, frameLayout2, constraintLayout, tnTextView, a11, textView, blurredSectorView);
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

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_bottom_op_subscription, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63872a;
    }
}
