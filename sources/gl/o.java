package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63923a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f63924b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f63925c;

    /* renamed from: d, reason: collision with root package name */
    public final SwipeRefreshLayout f63926d;

    private o(LinearLayout linearLayout, f0 f0Var, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        this.f63923a = linearLayout;
        this.f63924b = f0Var;
        this.f63925c = recyclerView;
        this.f63926d = swipeRefreshLayout;
    }

    public static o a(View view) {
        int i11 = R$id.ll_tab_filter;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            f0 a12 = f0.a(a11);
            int i12 = R$id.movie_list;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i12);
            if (recyclerView != null) {
                i12 = R$id.swipe_refresh;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i12);
                if (swipeRefreshLayout != null) {
                    return new o((LinearLayout) view, a12, recyclerView, swipeRefreshLayout);
                }
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_filter, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f63923a;
    }
}
