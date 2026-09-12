package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72996a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f72997b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f72998c;

    /* renamed from: d, reason: collision with root package name */
    public final View f72999d;

    private p(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.f72996a = constraintLayout;
        this.f72997b = appCompatTextView;
        this.f72998c = appCompatTextView2;
        this.f72999d = view;
    }

    public static p a(View view) {
        View a11;
        int i11 = R$id.tvCancel;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.tvClear;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null && (a11 = g4.b.a(view, (i11 = R$id.tvLine))) != null) {
                return new p((ConstraintLayout) view, appCompatTextView, appCompatTextView2, a11);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f72996a;
    }
}
