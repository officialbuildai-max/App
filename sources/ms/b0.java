package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;

/* loaded from: classes7.dex */
public final class b0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final CoordinatorLayout f69834a;

    /* renamed from: b, reason: collision with root package name */
    public final AppBarLayout f69835b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f69836c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f69837d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f69838e;

    /* renamed from: f, reason: collision with root package name */
    public final Toolbar f69839f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f69840g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f69841h;

    private b0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, Toolbar toolbar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f69834a = coordinatorLayout;
        this.f69835b = appBarLayout;
        this.f69836c = appCompatImageView;
        this.f69837d = appCompatImageView2;
        this.f69838e = recyclerView;
        this.f69839f = toolbar;
        this.f69840g = appCompatTextView;
        this.f69841h = appCompatTextView2;
    }

    public static b0 a(View view) {
        int i11 = R$id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) g4.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.ivBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_cover;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                    if (recyclerView != null) {
                        i11 = R$id.toolbar;
                        Toolbar toolbar = (Toolbar) g4.b.a(view, i11);
                        if (toolbar != null) {
                            i11 = R$id.tvTitle;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tvTitle_expand;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    return new b0((CoordinatorLayout) view, appBarLayout, appCompatImageView, appCompatImageView2, recyclerView, toolbar, appCompatTextView, appCompatTextView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_fragment_play_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.f69834a;
    }
}
