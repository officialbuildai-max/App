package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.AdvRecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f16873a;

    /* renamed from: b, reason: collision with root package name */
    public final AdvRecyclerView f16874b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f16875c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleLayout f16876d;

    private m(LinearLayoutCompat linearLayoutCompat, AdvRecyclerView advRecyclerView, SwipeRefreshLayout swipeRefreshLayout, TitleLayout titleLayout) {
        this.f16873a = linearLayoutCompat;
        this.f16874b = advRecyclerView;
        this.f16875c = swipeRefreshLayout;
        this.f16876d = titleLayout;
    }

    public static m a(View view) {
        int i11 = R$id.rv_room;
        AdvRecyclerView advRecyclerView = (AdvRecyclerView) g4.b.a(view, i11);
        if (advRecyclerView != null) {
            i11 = R$id.swipe_refresh;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
            if (swipeRefreshLayout != null) {
                i11 = R$id.tool_bar;
                TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                if (titleLayout != null) {
                    return new m((LinearLayoutCompat) view, advRecyclerView, swipeRefreshLayout, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f16873a;
    }
}
