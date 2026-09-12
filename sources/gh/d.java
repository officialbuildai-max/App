package gh;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.tranpay.R$id;

/* loaded from: classes4.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63737a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f63738b;

    /* renamed from: c, reason: collision with root package name */
    public final View f63739c;

    /* renamed from: d, reason: collision with root package name */
    public final View f63740d;

    /* renamed from: e, reason: collision with root package name */
    public final View f63741e;

    private d(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, View view2, View view3) {
        this.f63737a = constraintLayout;
        this.f63738b = constraintLayout2;
        this.f63739c = view;
        this.f63740d = view2;
        this.f63741e = view3;
    }

    public static d a(View view) {
        View a11;
        View a12;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.view1;
        View a13 = g4.b.a(view, i11);
        if (a13 == null || (a11 = g4.b.a(view, (i11 = R$id.view2))) == null || (a12 = g4.b.a(view, (i11 = R$id.view3))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new d(constraintLayout, constraintLayout, a13, a11, a12);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63737a;
    }
}
