package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.ArcConstraintLayout;

/* loaded from: classes6.dex */
public final class d0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f66171a;

    /* renamed from: b, reason: collision with root package name */
    public final ArcConstraintLayout f66172b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f66173c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f66174d;

    private d0(FrameLayout frameLayout, ArcConstraintLayout arcConstraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.f66171a = frameLayout;
        this.f66172b = arcConstraintLayout;
        this.f66173c = appCompatImageView;
        this.f66174d = appCompatTextView;
    }

    public static d0 a(View view) {
        int i11 = R$id.ArcViewGroup;
        ArcConstraintLayout arcConstraintLayout = (ArcConstraintLayout) g4.b.a(view, i11);
        if (arcConstraintLayout != null) {
            i11 = R$id.ivIndicator;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tvSwipeTip;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new d0((FrameLayout) view, arcConstraintLayout, appCompatImageView, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static d0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.ad_view_swipe_up_or_tap_for_details_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f66171a;
    }
}
