package bk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;

/* loaded from: classes5.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16659a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f16660b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f16661c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f16662d;

    /* renamed from: e, reason: collision with root package name */
    public final TitleLayout f16663e;

    private b(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, TitleLayout titleLayout) {
        this.f16659a = constraintLayout;
        this.f16660b = constraintLayout2;
        this.f16661c = swipeRefreshLayout;
        this.f16662d = recyclerView;
        this.f16663e = titleLayout;
    }

    public static b a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.mRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
        if (swipeRefreshLayout != null) {
            i11 = R$id.mRv;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.mTitleLayout;
                TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                if (titleLayout != null) {
                    return new b(constraintLayout, constraintLayout, swipeRefreshLayout, recyclerView, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.base_list_fragment_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16659a;
    }
}
