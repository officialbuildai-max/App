package rq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes6.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f74767a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f74768b;

    /* renamed from: c, reason: collision with root package name */
    public final MagicIndicator f74769c;

    /* renamed from: d, reason: collision with root package name */
    public final View f74770d;

    /* renamed from: e, reason: collision with root package name */
    public final ProgressBar f74771e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewPager2 f74772f;

    private g(ConstraintLayout constraintLayout, FrameLayout frameLayout, MagicIndicator magicIndicator, View view, ProgressBar progressBar, ViewPager2 viewPager2) {
        this.f74767a = constraintLayout;
        this.f74768b = frameLayout;
        this.f74769c = magicIndicator;
        this.f74770d = view;
        this.f74771e = progressBar;
        this.f74772f = viewPager2;
    }

    public static g a(View view) {
        View a11;
        int i11 = R$id.search_result_empty_view;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.search_result_magic_indicator;
            MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
            if (magicIndicator != null && (a11 = g4.b.a(view, (i11 = R$id.search_result_magic_indicator_divider))) != null) {
                i11 = R$id.search_result_progress_bar;
                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.search_result_view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                    if (viewPager2 != null) {
                        return new g((ConstraintLayout) view, frameLayout, magicIndicator, a11, progressBar, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_result, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f74767a;
    }
}
