package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetail.R$layout;

/* loaded from: classes5.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView f17432a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f17433b;

    private f(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.f17432a = recyclerView;
        this.f17433b = recyclerView2;
    }

    public static f a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        RecyclerView recyclerView = (RecyclerView) view;
        return new f(recyclerView, recyclerView);
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_for_you, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RecyclerView getRoot() {
        return this.f17432a;
    }
}
