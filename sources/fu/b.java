package fu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: classes7.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f62598a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f62599b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f62600c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f62601d;

    /* renamed from: e, reason: collision with root package name */
    public final ProgressBar f62602e;

    private b(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, ProgressBar progressBar) {
        this.f62598a = frameLayout;
        this.f62599b = frameLayout2;
        this.f62600c = linearLayoutCompat;
        this.f62601d = recyclerView;
        this.f62602e = progressBar;
    }

    public static b a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i11 = R$id.ll_loading;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
        if (linearLayoutCompat != null) {
            i11 = R$id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.view_load;
                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                if (progressBar != null) {
                    return new b(frameLayout, frameLayout, linearLayoutCompat, recyclerView, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.dialog_subtitle_search_result_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f62598a;
    }
}
