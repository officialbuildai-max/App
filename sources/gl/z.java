package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.wrapperad.view.BiddingFloatingIrregularView;
import com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout;

/* loaded from: classes6.dex */
public final class z implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f63993a;

    /* renamed from: b, reason: collision with root package name */
    public final BiddingFloatingIrregularView f63994b;

    /* renamed from: c, reason: collision with root package name */
    public final m0 f63995c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f63996d;

    /* renamed from: e, reason: collision with root package name */
    public final CustomSwipeRefreshLayout f63997e;

    /* renamed from: f, reason: collision with root package name */
    public final View f63998f;

    private z(FrameLayout frameLayout, BiddingFloatingIrregularView biddingFloatingIrregularView, m0 m0Var, RecyclerView recyclerView, CustomSwipeRefreshLayout customSwipeRefreshLayout, View view) {
        this.f63993a = frameLayout;
        this.f63994b = biddingFloatingIrregularView;
        this.f63995c = m0Var;
        this.f63996d = recyclerView;
        this.f63997e = customSwipeRefreshLayout;
        this.f63998f = view;
    }

    public static z a(View view) {
        View a11;
        View a12;
        int i11 = R$id.floatingIrregularView;
        BiddingFloatingIrregularView biddingFloatingIrregularView = (BiddingFloatingIrregularView) g4.b.a(view, i11);
        if (biddingFloatingIrregularView != null && (a11 = g4.b.a(view, (i11 = R$id.loading_bg))) != null) {
            m0 a13 = m0.a(a11);
            i11 = R$id.recycleView;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.swipe_refresh;
                CustomSwipeRefreshLayout customSwipeRefreshLayout = (CustomSwipeRefreshLayout) g4.b.a(view, i11);
                if (customSwipeRefreshLayout != null && (a12 = g4.b.a(view, (i11 = R$id.trending_header_bg))) != null) {
                    return new z((FrameLayout) view, biddingFloatingIrregularView, a13, recyclerView, customSwipeRefreshLayout, a12);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static z c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static z d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_trending, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f63993a;
    }
}
