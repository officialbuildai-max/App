package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.view.filter.popup.PopupFilterView;

/* loaded from: classes6.dex */
public final class s implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63957a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f63958b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f63959c;

    /* renamed from: d, reason: collision with root package name */
    public final PopupFilterView f63960d;

    /* renamed from: e, reason: collision with root package name */
    public final View f63961e;

    /* renamed from: f, reason: collision with root package name */
    public final View f63962f;

    /* renamed from: g, reason: collision with root package name */
    public final SwipeRefreshLayout f63963g;

    private s(LinearLayout linearLayout, g0 g0Var, RecyclerView recyclerView, PopupFilterView popupFilterView, View view, View view2, SwipeRefreshLayout swipeRefreshLayout) {
        this.f63957a = linearLayout;
        this.f63958b = g0Var;
        this.f63959c = recyclerView;
        this.f63960d = popupFilterView;
        this.f63961e = view;
        this.f63962f = view2;
        this.f63963g = swipeRefreshLayout;
    }

    public static s a(View view) {
        View a11;
        View a12;
        int i11 = R$id.ll_tab_movie;
        View a13 = g4.b.a(view, i11);
        if (a13 != null) {
            g0 a14 = g0.a(a13);
            i11 = R$id.movie_list;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.popup_filter_view;
                PopupFilterView popupFilterView = (PopupFilterView) g4.b.a(view, i11);
                if (popupFilterView != null && (a11 = g4.b.a(view, (i11 = R$id.popup_filter_view_linear))) != null && (a12 = g4.b.a(view, (i11 = R$id.sub_movie_header_bg))) != null) {
                    i11 = R$id.swipe_refresh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
                    if (swipeRefreshLayout != null) {
                        return new s((LinearLayout) view, a14, recyclerView, popupFilterView, a11, a12, swipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_movie, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f63957a;
    }
}
