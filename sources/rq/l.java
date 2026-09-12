package rq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: classes6.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f74795a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f74796b;

    private l(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.f74795a = frameLayout;
        this.f74796b = recyclerView;
    }

    public static l a(View view) {
        int i11 = R$id.rvSubject;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            return new l((FrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_values_type_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f74795a;
    }
}
