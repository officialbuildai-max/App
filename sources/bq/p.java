package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f16923a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f16924b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f16925c;

    private p(LinearLayout linearLayout, FrameLayout frameLayout, RecyclerView recyclerView) {
        this.f16923a = linearLayout;
        this.f16924b = frameLayout;
        this.f16925c = recyclerView;
    }

    public static p a(View view) {
        int i11 = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                return new p((LinearLayout) view, frameLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_filter_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f16923a;
    }
}
