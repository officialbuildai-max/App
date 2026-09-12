package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class t implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f73041a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f73042b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f73043c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f73044d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f73045e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f73046f;

    private t(FrameLayout frameLayout, RecyclerView recyclerView, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f73041a = frameLayout;
        this.f73042b = recyclerView;
        this.f73043c = frameLayout2;
        this.f73044d = appCompatTextView;
        this.f73045e = appCompatTextView2;
        this.f73046f = appCompatTextView3;
    }

    public static t a(View view) {
        int i11 = R$id.appRv;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i11 = R$id.tvApp;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tvAppNum;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tvTitle;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        return new t(frameLayout, recyclerView, frameLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_app_download_ad_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f73041a;
    }
}
