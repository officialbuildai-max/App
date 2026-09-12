package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.base.widget.SafeRecyclerView;

/* loaded from: classes7.dex */
public final class x implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f70070a;

    /* renamed from: b, reason: collision with root package name */
    public final SafeRecyclerView f70071b;

    /* renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f70072c;

    /* renamed from: d, reason: collision with root package name */
    public final View f70073d;

    /* renamed from: e, reason: collision with root package name */
    public final Space f70074e;

    /* renamed from: f, reason: collision with root package name */
    public final View f70075f;

    /* renamed from: g, reason: collision with root package name */
    public final View f70076g;

    private x(ConstraintLayout constraintLayout, SafeRecyclerView safeRecyclerView, SwipeRefreshLayout swipeRefreshLayout, View view, Space space, View view2, View view3) {
        this.f70070a = constraintLayout;
        this.f70071b = safeRecyclerView;
        this.f70072c = swipeRefreshLayout;
        this.f70073d = view;
        this.f70074e = space;
        this.f70075f = view2;
        this.f70076g = view3;
    }

    public static x a(View view) {
        View a11;
        View a12;
        View a13;
        int i11 = R$id.recycler_view;
        SafeRecyclerView safeRecyclerView = (SafeRecyclerView) g4.b.a(view, i11);
        if (safeRecyclerView != null) {
            i11 = R$id.swipe_refresh;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
            if (swipeRefreshLayout != null && (a11 = g4.b.a(view, (i11 = R$id.top_bg))) != null) {
                i11 = R$id.top_guideline;
                Space space = (Space) g4.b.a(view, i11);
                if (space != null && (a12 = g4.b.a(view, (i11 = R$id.v_bar_space))) != null && (a13 = g4.b.a(view, (i11 = R$id.v_top_bg))) != null) {
                    return new x((ConstraintLayout) view, safeRecyclerView, swipeRefreshLayout, a11, space, a12, a13);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static x c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static x d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_fragment_discover, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70070a;
    }
}
