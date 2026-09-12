package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.RoundedArrowImageView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63830a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f63831b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f63832c;

    /* renamed from: d, reason: collision with root package name */
    public final RoundedArrowImageView f63833d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f63834e;

    private h(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, RoundedArrowImageView roundedArrowImageView, ConstraintLayout constraintLayout3) {
        this.f63830a = constraintLayout;
        this.f63831b = constraintLayout2;
        this.f63832c = appCompatImageView;
        this.f63833d = roundedArrowImageView;
        this.f63834e = constraintLayout3;
    }

    public static h a(View view) {
        int i11 = R$id.bubble_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.iv_ges;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_rounded;
                RoundedArrowImageView roundedArrowImageView = (RoundedArrowImageView) g4.b.a(view, i11);
                if (roundedArrowImageView != null) {
                    i11 = R$id.iv_search_container;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                    if (constraintLayout2 != null) {
                        return new h((ConstraintLayout) view, constraintLayout, appCompatImageView, roundedArrowImageView, constraintLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.dialog_search_guide, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63830a;
    }
}
