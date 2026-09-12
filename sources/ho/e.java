package ho;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: classes6.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64695a;

    /* renamed from: b, reason: collision with root package name */
    public final BLTextView f64696b;

    /* renamed from: c, reason: collision with root package name */
    public final BLTextView f64697c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f64698d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f64699e;

    private e(ConstraintLayout constraintLayout, BLTextView bLTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f64695a = constraintLayout;
        this.f64696b = bLTextView;
        this.f64697c = bLTextView2;
        this.f64698d = appCompatTextView;
        this.f64699e = appCompatTextView2;
    }

    public static e a(View view) {
        int i11 = R$id.longVdTvOperator;
        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
        if (bLTextView != null) {
            i11 = R$id.longVdTvPlay;
            BLTextView bLTextView2 = (BLTextView) g4.b.a(view, i11);
            if (bLTextView2 != null) {
                i11 = R$id.longVodTvTips;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.longVodTvTitle;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new e((ConstraintLayout) view, bLTextView, bLTextView2, appCompatTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64695a;
    }
}
