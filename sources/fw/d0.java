package fw;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.usercenter.R$id;

/* loaded from: classes7.dex */
public final class d0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f62733a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f62734b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f62735c;

    private d0(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.f62733a = linearLayoutCompat;
        this.f62734b = recyclerView;
        this.f62735c = appCompatTextView;
    }

    public static d0 a(View view) {
        int i11 = R$id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.tv_cancel;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                return new d0((LinearLayoutCompat) view, recyclerView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f62733a;
    }
}
