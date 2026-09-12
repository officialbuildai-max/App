package fu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLImageView;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: classes7.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62678a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatEditText f62679b;

    /* renamed from: c, reason: collision with root package name */
    public final BLImageView f62680c;

    /* renamed from: d, reason: collision with root package name */
    public final BLImageView f62681d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f62682e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f62683f;

    private k(ConstraintLayout constraintLayout, AppCompatEditText appCompatEditText, BLImageView bLImageView, BLImageView bLImageView2, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView) {
        this.f62678a = constraintLayout;
        this.f62679b = appCompatEditText;
        this.f62680c = bLImageView;
        this.f62681d = bLImageView2;
        this.f62682e = constraintLayout2;
        this.f62683f = appCompatTextView;
    }

    public static k a(View view) {
        int i11 = R$id.et_sync_adjust;
        AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
        if (appCompatEditText != null) {
            i11 = R$id.iv_sync_adjust_minus;
            BLImageView bLImageView = (BLImageView) g4.b.a(view, i11);
            if (bLImageView != null) {
                i11 = R$id.iv_sync_adjust_plus;
                BLImageView bLImageView2 = (BLImageView) g4.b.a(view, i11);
                if (bLImageView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i11 = R$id.tvTitle;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        return new k(constraintLayout, appCompatEditText, bLImageView, bLImageView2, constraintLayout, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static k c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.view_subtitle_sync_adjust_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62678a;
    }
}
