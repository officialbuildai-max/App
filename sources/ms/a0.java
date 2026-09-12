package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv._channel.ui.widget.ShortTvPopupFilterView;

/* loaded from: classes7.dex */
public final class a0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f69821a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f69822b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f69823c;

    /* renamed from: d, reason: collision with root package name */
    public final ShortTvPopupFilterView f69824d;

    /* renamed from: e, reason: collision with root package name */
    public final View f69825e;

    /* renamed from: f, reason: collision with root package name */
    public final View f69826f;

    /* renamed from: g, reason: collision with root package name */
    public final SwipeRefreshLayout f69827g;

    private a0(LinearLayout linearLayout, d0 d0Var, RecyclerView recyclerView, ShortTvPopupFilterView shortTvPopupFilterView, View view, View view2, SwipeRefreshLayout swipeRefreshLayout) {
        this.f69821a = linearLayout;
        this.f69822b = d0Var;
        this.f69823c = recyclerView;
        this.f69824d = shortTvPopupFilterView;
        this.f69825e = view;
        this.f69826f = view2;
        this.f69827g = swipeRefreshLayout;
    }

    public static a0 a(View view) {
        View a11;
        View a12;
        int i11 = R$id.ll_tab_movie;
        View a13 = g4.b.a(view, i11);
        if (a13 != null) {
            d0 a14 = d0.a(a13);
            i11 = R$id.movie_list;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.popup_filter_view;
                ShortTvPopupFilterView shortTvPopupFilterView = (ShortTvPopupFilterView) g4.b.a(view, i11);
                if (shortTvPopupFilterView != null && (a11 = g4.b.a(view, (i11 = R$id.popup_filter_view_linear))) != null && (a12 = g4.b.a(view, (i11 = R$id.sub_movie_header_bg))) != null) {
                    i11 = R$id.swipe_refresh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
                    if (swipeRefreshLayout != null) {
                        return new a0((LinearLayout) view, a14, recyclerView, shortTvPopupFilterView, a11, a12, swipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static a0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_fragment_movie, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f69821a;
    }
}
