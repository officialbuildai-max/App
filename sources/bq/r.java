package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class r implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final SwipeRefreshLayout f16937a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f16938b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f16939c;

    private r(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2) {
        this.f16937a = swipeRefreshLayout;
        this.f16938b = recyclerView;
        this.f16939c = swipeRefreshLayout2;
    }

    public static r a(View view) {
        int i11 = R$id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        return new r(swipeRefreshLayout, recyclerView, swipeRefreshLayout);
    }

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SwipeRefreshLayout getRoot() {
        return this.f16937a;
    }
}
