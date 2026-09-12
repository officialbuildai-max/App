package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f66268a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f66269b;

    private m(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.f66268a = frameLayout;
        this.f66269b = recyclerView;
    }

    public static m a(View view) {
        int i11 = R$id.rvIcon;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            return new m((FrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_icon_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f66268a;
    }
}
