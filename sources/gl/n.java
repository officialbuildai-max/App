package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63909a;

    /* renamed from: b, reason: collision with root package name */
    public final View f63910b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f63911c;

    /* renamed from: d, reason: collision with root package name */
    public final View f63912d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f63913e;

    /* renamed from: f, reason: collision with root package name */
    public final SwipeRefreshLayout f63914f;

    /* renamed from: g, reason: collision with root package name */
    public final TitleLayout f63915g;

    private n(ConstraintLayout constraintLayout, View view, ImageView imageView, View view2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TitleLayout titleLayout) {
        this.f63909a = constraintLayout;
        this.f63910b = view;
        this.f63911c = imageView;
        this.f63912d = view2;
        this.f63913e = recyclerView;
        this.f63914f = swipeRefreshLayout;
        this.f63915g = titleLayout;
    }

    public static n a(View view) {
        View a11;
        int i11 = R$id.film_list_color_mask;
        View a12 = g4.b.a(view, i11);
        if (a12 != null) {
            i11 = R$id.film_list_cover;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null && (a11 = g4.b.a(view, (i11 = R$id.film_list_gradient))) != null) {
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.swipe_refresh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
                    if (swipeRefreshLayout != null) {
                        i11 = R$id.tool_bar;
                        TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                        if (titleLayout != null) {
                            return new n((ConstraintLayout) view, a12, imageView, a11, recyclerView, swipeRefreshLayout, titleLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_film_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63909a;
    }
}
