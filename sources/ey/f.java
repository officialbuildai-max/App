package ey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;

/* loaded from: classes7.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62219a;

    /* renamed from: b, reason: collision with root package name */
    public final CardView f62220b;

    /* renamed from: c, reason: collision with root package name */
    public final CardView f62221c;

    /* renamed from: d, reason: collision with root package name */
    public final NativeWrapperAdView f62222d;

    private f(ConstraintLayout constraintLayout, CardView cardView, CardView cardView2, NativeWrapperAdView nativeWrapperAdView) {
        this.f62219a = constraintLayout;
        this.f62220b = cardView;
        this.f62221c = cardView2;
        this.f62222d = nativeWrapperAdView;
    }

    public static f a(View view) {
        int i11 = R$id.ad_detail_arrow;
        CardView cardView = (CardView) g4.b.a(view, i11);
        if (cardView != null) {
            i11 = R$id.ad_detail_btn;
            CardView cardView2 = (CardView) g4.b.a(view, i11);
            if (cardView2 != null) {
                i11 = R$id.adView;
                NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) g4.b.a(view, i11);
                if (nativeWrapperAdView != null) {
                    return new f((ConstraintLayout) view, cardView, cardView2, nativeWrapperAdView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static f c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.second_floor_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62219a;
    }
}
