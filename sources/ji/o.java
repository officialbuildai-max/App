package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.native_ad.BiddingFloatingIrregularAnimationView;

/* loaded from: classes6.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f66272a;

    /* renamed from: b, reason: collision with root package name */
    public final BiddingFloatingIrregularAnimationView f66273b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f66274c;

    private o(FrameLayout frameLayout, BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, RecyclerView recyclerView) {
        this.f66272a = frameLayout;
        this.f66273b = biddingFloatingIrregularAnimationView;
        this.f66274c = recyclerView;
    }

    public static o a(View view) {
        int i11 = R$id.irregularView;
        BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView = (BiddingFloatingIrregularAnimationView) g4.b.a(view, i11);
        if (biddingFloatingIrregularAnimationView != null) {
            i11 = R$id.f41832rv;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                return new o((FrameLayout) view, biddingFloatingIrregularAnimationView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_irregular_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f66272a;
    }
}
