package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: classes7.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f70006a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f70007b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f70008c;

    /* renamed from: d, reason: collision with root package name */
    public final SwipeRefreshLayout f70009d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f70010e;

    /* renamed from: f, reason: collision with root package name */
    public final TnTextView f70011f;

    private p(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, TnTextView tnTextView) {
        this.f70006a = constraintLayout;
        this.f70007b = constraintLayout2;
        this.f70008c = appCompatImageView;
        this.f70009d = swipeRefreshLayout;
        this.f70010e = recyclerView;
        this.f70011f = tnTextView;
    }

    public static p a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.mRefreshLayout;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
            if (swipeRefreshLayout != null) {
                i11 = R$id.mRv;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_title;
                    TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                    if (tnTextView != null) {
                        return new p(constraintLayout, constraintLayout, appCompatImageView, swipeRefreshLayout, recyclerView, tnTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_base_list_fragment_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70006a;
    }
}
