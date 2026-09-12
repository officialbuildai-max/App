package fw;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.usercenter.R$id;

/* loaded from: classes7.dex */
public final class x implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63101a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f63102b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f63103c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f63104d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f63105e;

    private x(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.f63101a = constraintLayout;
        this.f63102b = appCompatTextView;
        this.f63103c = appCompatTextView2;
        this.f63104d = appCompatTextView3;
        this.f63105e = appCompatTextView4;
    }

    public static x a(View view) {
        int i11 = R$id.btn_cancel;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_copy;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.tv_tips;
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView3 != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView4 != null) {
                        return new x((ConstraintLayout) view, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63101a;
    }
}
