package wm;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes6.dex */
public final class r implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f77980a;

    private r(ConstraintLayout constraintLayout) {
        this.f77980a = constraintLayout;
    }

    public static r a(View view) {
        if (view != null) {
            return new r((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77980a;
    }
}
