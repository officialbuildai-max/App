package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.ui.widget.ShortTVBannerView;

/* loaded from: classes7.dex */
public final class q0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f70021a;

    /* renamed from: b, reason: collision with root package name */
    public final ShortTVBannerView f70022b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f70023c;

    /* renamed from: d, reason: collision with root package name */
    public final View f70024d;

    /* renamed from: e, reason: collision with root package name */
    public final View f70025e;

    /* renamed from: f, reason: collision with root package name */
    public final View f70026f;

    private q0(ConstraintLayout constraintLayout, ShortTVBannerView shortTVBannerView, ConstraintLayout constraintLayout2, View view, View view2, View view3) {
        this.f70021a = constraintLayout;
        this.f70022b = shortTVBannerView;
        this.f70023c = constraintLayout2;
        this.f70024d = view;
        this.f70025e = view2;
        this.f70026f = view3;
    }

    public static q0 a(View view) {
        View a11;
        View a12;
        int i11 = R$id.banner;
        ShortTVBannerView shortTVBannerView = (ShortTVBannerView) g4.b.a(view, i11);
        if (shortTVBannerView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.v_banner_bg;
            View a13 = g4.b.a(view, i11);
            if (a13 != null && (a11 = g4.b.a(view, (i11 = R$id.v_bar_space))) != null && (a12 = g4.b.a(view, (i11 = R$id.v_top_space))) != null) {
                return new q0(constraintLayout, shortTVBannerView, constraintLayout, a13, a11, a12);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static q0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_view_banner, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70021a;
    }
}
