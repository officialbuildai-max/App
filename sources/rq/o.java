package rq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: classes6.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f74828a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f74829b;

    /* renamed from: c, reason: collision with root package name */
    public final NativeWrapperAdView f74830c;

    /* renamed from: d, reason: collision with root package name */
    public final NativeWrapperAdView f74831d;

    /* renamed from: e, reason: collision with root package name */
    public final NativeWrapperAdView f74832e;

    private o(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, NativeWrapperAdView nativeWrapperAdView, NativeWrapperAdView nativeWrapperAdView2, NativeWrapperAdView nativeWrapperAdView3) {
        this.f74828a = constraintLayout;
        this.f74829b = appCompatTextView;
        this.f74830c = nativeWrapperAdView;
        this.f74831d = nativeWrapperAdView2;
        this.f74832e = nativeWrapperAdView3;
    }

    public static o a(View view) {
        int i11 = R$id.ad_group_title;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.native_ad_view_1;
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) g4.b.a(view, i11);
            if (nativeWrapperAdView != null) {
                i11 = R$id.native_ad_view_2;
                NativeWrapperAdView nativeWrapperAdView2 = (NativeWrapperAdView) g4.b.a(view, i11);
                if (nativeWrapperAdView2 != null) {
                    i11 = R$id.native_ad_view_3;
                    NativeWrapperAdView nativeWrapperAdView3 = (NativeWrapperAdView) g4.b.a(view, i11);
                    if (nativeWrapperAdView3 != null) {
                        return new o((ConstraintLayout) view, appCompatTextView, nativeWrapperAdView, nativeWrapperAdView2, nativeWrapperAdView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static o c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.search_hot_hi_native_group_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f74828a;
    }
}
