package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class w0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73085a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f73086b;

    private w0(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView) {
        this.f73085a = constraintLayout;
        this.f73086b = appCompatTextView;
    }

    public static w0 a(View view) {
        int i11 = R$id.iv_premium;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            return new w0((ConstraintLayout) view, appCompatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73085a;
    }
}
