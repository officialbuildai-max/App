package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class u0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63067a;

    /* renamed from: b, reason: collision with root package name */
    public final TnTextView f63068b;

    private u0(ConstraintLayout constraintLayout, TnTextView tnTextView) {
        this.f63067a = constraintLayout;
        this.f63068b = tnTextView;
    }

    public static u0 a(View view) {
        int i11 = R$id.bottomDescription;
        TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
        if (tnTextView != null) {
            return new u0((ConstraintLayout) view, tnTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static u0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_device_management_description, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63067a;
    }
}
