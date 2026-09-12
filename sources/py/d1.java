package py;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class d1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLFrameLayout f72788a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f72789b;

    private d1(BLFrameLayout bLFrameLayout, RecyclerView recyclerView) {
        this.f72788a = bLFrameLayout;
        this.f72789b = recyclerView;
    }

    public static d1 a(View view) {
        int i11 = R$id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            return new d1((BLFrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLFrameLayout getRoot() {
        return this.f72788a;
    }
}
