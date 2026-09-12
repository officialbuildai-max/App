package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;

/* loaded from: classes7.dex */
public final class v implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f73064a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f73065b;

    /* renamed from: c, reason: collision with root package name */
    public final DownloadPanelForYouFootView f73066c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f73067d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f73068e;

    /* renamed from: f, reason: collision with root package name */
    public final NestedScrollView f73069f;

    private v(LinearLayout linearLayout, FrameLayout frameLayout, DownloadPanelForYouFootView downloadPanelForYouFootView, LinearLayout linearLayout2, RecyclerView recyclerView, NestedScrollView nestedScrollView) {
        this.f73064a = linearLayout;
        this.f73065b = frameLayout;
        this.f73066c = downloadPanelForYouFootView;
        this.f73067d = linearLayout2;
        this.f73068e = recyclerView;
        this.f73069f = nestedScrollView;
    }

    public static v a(View view) {
        int i11 = R$id.fl_empty_root;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.foot_for_you;
            DownloadPanelForYouFootView downloadPanelForYouFootView = (DownloadPanelForYouFootView) g4.b.a(view, i11);
            if (downloadPanelForYouFootView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.sv_empty_root;
                    NestedScrollView nestedScrollView = (NestedScrollView) g4.b.a(view, i11);
                    if (nestedScrollView != null) {
                        return new v(linearLayout, frameLayout, downloadPanelForYouFootView, linearLayout, recyclerView, nestedScrollView);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_download_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f73064a;
    }
}
