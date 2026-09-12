package py;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class v0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f73070a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f73071b;

    private v0(View view, RecyclerView recyclerView) {
        this.f73070a = view;
        this.f73071b = recyclerView;
    }

    public static v0 a(View view) {
        int i11 = R$id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            return new v0(view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f73070a;
    }
}
