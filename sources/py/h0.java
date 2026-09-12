package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class h0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72864a;

    /* renamed from: b, reason: collision with root package name */
    public final CoordinatorLayout f72865b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f72866c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f72867d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f72868e;

    /* renamed from: f, reason: collision with root package name */
    public final MagicIndicator f72869f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f72870g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewPager2 f72871h;

    private h0(ConstraintLayout constraintLayout, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, MagicIndicator magicIndicator, AppCompatTextView appCompatTextView, ViewPager2 viewPager2) {
        this.f72864a = constraintLayout;
        this.f72865b = coordinatorLayout;
        this.f72866c = frameLayout;
        this.f72867d = frameLayout2;
        this.f72868e = frameLayout3;
        this.f72869f = magicIndicator;
        this.f72870g = appCompatTextView;
        this.f72871h = viewPager2;
    }

    public static h0 a(View view) {
        int i11 = R$id.cl_root;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
        if (coordinatorLayout != null) {
            i11 = R$id.flAppDownloadAd;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.flDownloadingContainer;
                FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout2 != null) {
                    i11 = R$id.flTopCardAd;
                    FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout3 != null) {
                        i11 = R$id.magic_indicator;
                        MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                        if (magicIndicator != null) {
                            i11 = R$id.tv_available_size;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.view_pager;
                                ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                if (viewPager2 != null) {
                                    return new h0((ConstraintLayout) view, coordinatorLayout, frameLayout, frameLayout2, frameLayout3, magicIndicator, appCompatTextView, viewPager2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static h0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_file_manager, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f72864a;
    }
}
