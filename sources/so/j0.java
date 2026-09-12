package so;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class j0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f75683a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f75684b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f75685c;

    /* renamed from: d, reason: collision with root package name */
    public final TnTextView f75686d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f75687e;

    private j0(View view, RecyclerView recyclerView, AppCompatTextView appCompatTextView, TnTextView tnTextView, AppCompatTextView appCompatTextView2) {
        this.f75683a = view;
        this.f75684b = recyclerView;
        this.f75685c = appCompatTextView;
        this.f75686d = tnTextView;
        this.f75687e = appCompatTextView2;
    }

    public static j0 a(View view) {
        int i11 = R$id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.tv_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_title_trending;
                TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                if (tnTextView != null) {
                    i11 = R$id.tv_view_all;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new j0(view, recyclerView, appCompatTextView, tnTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f75683a;
    }
}
