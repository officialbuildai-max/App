package vk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;

/* loaded from: classes6.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f77463a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f77464b;

    private b(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.f77463a = constraintLayout;
        this.f77464b = recyclerView;
    }

    public static b a(View view) {
        int i11 = R$id.education_history_recycler;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            return new b((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_education_history, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77463a;
    }
}
