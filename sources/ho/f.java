package ho;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.noober.background.view.BLLinearLayout;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: classes6.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLLinearLayout f64700a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64701b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f64702c;

    /* renamed from: d, reason: collision with root package name */
    public final GradientTextView f64703d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f64704e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f64705f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f64706g;

    private f(BLLinearLayout bLLinearLayout, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, GradientTextView gradientTextView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f64700a = bLLinearLayout;
        this.f64701b = appCompatImageView;
        this.f64702c = linearLayoutCompat;
        this.f64703d = gradientTextView;
        this.f64704e = appCompatImageView2;
        this.f64705f = appCompatTextView;
        this.f64706g = appCompatTextView2;
    }

    public static f a(View view) {
        int i11 = R$id.ivMore;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.llButton;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.tvButton;
                GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                if (gradientTextView != null) {
                    i11 = R$id.tvClose;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.tvTips;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tvTitle;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView2 != null) {
                                return new f((BLLinearLayout) view, appCompatImageView, linearLayoutCompat, gradientTextView, appCompatImageView2, appCompatTextView, appCompatTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLLinearLayout getRoot() {
        return this.f64700a;
    }
}
