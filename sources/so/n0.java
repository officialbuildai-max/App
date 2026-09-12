package so;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class n0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f75750a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f75751b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f75752c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f75753d;

    private n0(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f75750a = constraintLayout;
        this.f75751b = constraintLayout2;
        this.f75752c = appCompatTextView;
        this.f75753d = appCompatTextView2;
    }

    public static n0 a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.rating_name;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.tv_rating;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                return new n0(constraintLayout, constraintLayout, appCompatTextView, appCompatTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75750a;
    }
}
