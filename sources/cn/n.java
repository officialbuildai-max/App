package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: classes5.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17505a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f17506b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f17507c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f17508d;

    private n(ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f17505a = constraintLayout;
        this.f17506b = recyclerView;
        this.f17507c = appCompatTextView;
        this.f17508d = appCompatTextView2;
    }

    public static n a(View view) {
        int i11 = R$id.rvStarring;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.tvStarringCount;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tvStarringTitle;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    return new n((ConstraintLayout) view, recyclerView, appCompatTextView, appCompatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_starring, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17505a;
    }
}
