package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class v implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63977a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f63978b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f63979c;

    private v(ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2) {
        this.f63977a = constraintLayout;
        this.f63978b = recyclerView;
        this.f63979c = constraintLayout2;
    }

    public static v a(View view) {
        int i11 = R$id.rank_all_list_recycler;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.rank_list_loading_frame;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                return new v((ConstraintLayout) view, recyclerView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static v c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static v d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_rank_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63977a;
    }
}
