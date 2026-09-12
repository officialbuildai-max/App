package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import com.transsnet.downloader.widget.TransferSelectSeriesListView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class l0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72951a;

    /* renamed from: b, reason: collision with root package name */
    public final MagicIndicator f72952b;

    /* renamed from: c, reason: collision with root package name */
    public final NestedScrollableHost f72953c;

    /* renamed from: d, reason: collision with root package name */
    public final TransferBottomToolsView f72954d;

    /* renamed from: e, reason: collision with root package name */
    public final TransferSelectSeriesListView f72955e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f72956f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewPager2 f72957g;

    private l0(ConstraintLayout constraintLayout, MagicIndicator magicIndicator, NestedScrollableHost nestedScrollableHost, TransferBottomToolsView transferBottomToolsView, TransferSelectSeriesListView transferSelectSeriesListView, AppCompatImageView appCompatImageView, ViewPager2 viewPager2) {
        this.f72951a = constraintLayout;
        this.f72952b = magicIndicator;
        this.f72953c = nestedScrollableHost;
        this.f72954d = transferBottomToolsView;
        this.f72955e = transferSelectSeriesListView;
        this.f72956f = appCompatImageView;
        this.f72957g = viewPager2;
    }

    public static l0 a(View view) {
        int i11 = R$id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
        if (magicIndicator != null) {
            i11 = R$id.nsh_view_pager;
            NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) g4.b.a(view, i11);
            if (nestedScrollableHost != null) {
                i11 = R$id.v_bottom_tools;
                TransferBottomToolsView transferBottomToolsView = (TransferBottomToolsView) g4.b.a(view, i11);
                if (transferBottomToolsView != null) {
                    i11 = R$id.v_series_list;
                    TransferSelectSeriesListView transferSelectSeriesListView = (TransferSelectSeriesListView) g4.b.a(view, i11);
                    if (transferSelectSeriesListView != null) {
                        i11 = R$id.v_top_bg;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.view_pager;
                            ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                            if (viewPager2 != null) {
                                return new l0((ConstraintLayout) view, magicIndicator, nestedScrollableHost, transferBottomToolsView, transferSelectSeriesListView, appCompatImageView, viewPager2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static l0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_transfer_main, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f72951a;
    }
}
