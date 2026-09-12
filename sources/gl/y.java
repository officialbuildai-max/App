package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class y implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63987a;

    /* renamed from: b, reason: collision with root package name */
    public final View f63988b;

    /* renamed from: c, reason: collision with root package name */
    public final m0 f63989c;

    /* renamed from: d, reason: collision with root package name */
    public final Guideline f63990d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f63991e;

    /* renamed from: f, reason: collision with root package name */
    public final SwipeRefreshLayout f63992f;

    private y(ConstraintLayout constraintLayout, View view, m0 m0Var, Guideline guideline, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        this.f63987a = constraintLayout;
        this.f63988b = view;
        this.f63989c = m0Var;
        this.f63990d = guideline;
        this.f63991e = recyclerView;
        this.f63992f = swipeRefreshLayout;
    }

    public static y a(View view) {
        View a11;
        int i11 = R$id.sub_operation_header_bg;
        View a12 = g4.b.a(view, i11);
        if (a12 != null && (a11 = g4.b.a(view, (i11 = R$id.sub_operation_loading))) != null) {
            m0 a13 = m0.a(a11);
            i11 = R$id.sub_operation_main_guide;
            Guideline guideline = (Guideline) g4.b.a(view, i11);
            if (guideline != null) {
                i11 = R$id.sub_operation_main_recycler;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.sub_operation_main_refresh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
                    if (swipeRefreshLayout != null) {
                        return new y((ConstraintLayout) view, a12, a13, guideline, recyclerView, swipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_sub_tab, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63987a;
    }
}
