package bk;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R$id;

/* loaded from: classes5.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16690a;

    /* renamed from: b, reason: collision with root package name */
    public final View f16691b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f16692c;

    private g(ConstraintLayout constraintLayout, View view, FrameLayout frameLayout) {
        this.f16690a = constraintLayout;
        this.f16691b = view;
        this.f16692c = frameLayout;
    }

    public static g a(View view) {
        int i11 = R$id.guideline;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.member_page_container;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                return new g((ConstraintLayout) view, a11, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16690a;
    }
}
