package ho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;

/* loaded from: classes6.dex */
public final class q implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64818a;

    /* renamed from: b, reason: collision with root package name */
    public final BLTextView f64819b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f64820c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f64821d;

    /* renamed from: e, reason: collision with root package name */
    public final BLTextView f64822e;

    /* renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f64823f;

    private q(ConstraintLayout constraintLayout, BLTextView bLTextView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, BLTextView bLTextView2, ConstraintLayout constraintLayout2) {
        this.f64818a = constraintLayout;
        this.f64819b = bLTextView;
        this.f64820c = appCompatTextView;
        this.f64821d = appCompatTextView2;
        this.f64822e = bLTextView2;
        this.f64823f = constraintLayout2;
    }

    public static q a(View view) {
        int i11 = R$id.interceptPremium;
        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
        if (bLTextView != null) {
            i11 = R$id.interceptTip;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.interceptTitle;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.interceptWatchAd;
                    BLTextView bLTextView2 = (BLTextView) g4.b.a(view, i11);
                    if (bLTextView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new q(constraintLayout, bLTextView, appCompatTextView, appCompatTextView2, bLTextView2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static q c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.video_resolution_ratio_intercept_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64818a;
    }
}
