package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class z implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f73118a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f73119b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f73120c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f73121d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f73122e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f73123f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f73124g;

    /* renamed from: h, reason: collision with root package name */
    public final ProgressBar f73125h;

    private z(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ProgressBar progressBar) {
        this.f73118a = frameLayout;
        this.f73119b = linearLayout;
        this.f73120c = linearLayout2;
        this.f73121d = recyclerView;
        this.f73122e = appCompatTextView;
        this.f73123f = appCompatTextView2;
        this.f73124g = appCompatTextView3;
        this.f73125h = progressBar;
    }

    public static z a(View view) {
        int i11 = R$id.ll_loading;
        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
        if (linearLayout != null) {
            i11 = R$id.ll_not_net;
            LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
            if (linearLayout2 != null) {
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_loading;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_no_network_content;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tv_retry;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView3 != null) {
                                i11 = R$id.view_load;
                                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                if (progressBar != null) {
                                    return new z((FrameLayout) view, linearLayout, linearLayout2, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3, progressBar);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static z c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static z d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_download_res_group, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f73118a;
    }
}
