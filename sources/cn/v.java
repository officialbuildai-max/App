package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: classes5.dex */
public final class v implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17595a;

    /* renamed from: b, reason: collision with root package name */
    public final View f17596b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f17597c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f17598d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f17599e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f17600f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f17601g;

    private v(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f17595a = constraintLayout;
        this.f17596b = view;
        this.f17597c = constraintLayout2;
        this.f17598d = appCompatImageView;
        this.f17599e = recyclerView;
        this.f17600f = appCompatTextView;
        this.f17601g = appCompatTextView2;
    }

    public static v a(View view) {
        int i11 = R$id.divider;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.f46969rv;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_all_episodes;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            return new v(constraintLayout, a11, constraintLayout, appCompatImageView, recyclerView, appCompatTextView, appCompatTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static v c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static v d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_video_detail_seasons, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17595a;
    }
}
