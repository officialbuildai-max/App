package so;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes6.dex */
public final class o0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final AppCompatTextView f75767a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f75768b;

    private o0(AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f75767a = appCompatTextView;
        this.f75768b = appCompatTextView2;
    }

    public static o0 a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view;
        return new o0(appCompatTextView, appCompatTextView);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppCompatTextView getRoot() {
        return this.f75767a;
    }
}
