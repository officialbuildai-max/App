package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16809a;

    /* renamed from: b, reason: collision with root package name */
    public final FragmentContainerView f16810b;

    private c(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.f16809a = constraintLayout;
        this.f16810b = fragmentContainerView;
    }

    public static c a(View view) {
        int i11 = R$id.container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) g4.b.a(view, i11);
        if (fragmentContainerView != null) {
            return new c((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_hot_rooms, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16809a;
    }
}
