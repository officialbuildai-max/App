package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16870a;

    /* renamed from: b, reason: collision with root package name */
    public final SwipeRefreshLayout f16871b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f16872c;

    private l(ConstraintLayout constraintLayout, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView) {
        this.f16870a = constraintLayout;
        this.f16871b = swipeRefreshLayout;
        this.f16872c = recyclerView;
    }

    public static l a(View view) {
        int i11 = R$id.swipe_refresh;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
        if (swipeRefreshLayout != null) {
            i11 = R$id.waterfallRecyclerView;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                return new l((ConstraintLayout) view, swipeRefreshLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_likes_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16870a;
    }
}
