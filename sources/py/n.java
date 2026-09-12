package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72972a;

    /* renamed from: b, reason: collision with root package name */
    public final View f72973b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f72974c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f72975d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f72976e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f72977f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f72978g;

    private n(ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f72972a = constraintLayout;
        this.f72973b = view;
        this.f72974c = appCompatImageView;
        this.f72975d = appCompatImageView2;
        this.f72976e = appCompatTextView;
        this.f72977f = appCompatTextView2;
        this.f72978g = appCompatTextView3;
    }

    public static n a(View view) {
        int i11 = R$id.btn_top;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.iv_back;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_icon;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.tvAdWatchAVideo;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_tips;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tv_title;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView3 != null) {
                                return new n((ConstraintLayout) view, a11, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
    public ConstraintLayout getRoot() {
        return this.f72972a;
    }
}
