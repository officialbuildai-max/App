package kk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;

/* loaded from: classes6.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f67005a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f67006b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleLayout f67007c;

    private i(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, TitleLayout titleLayout) {
        this.f67005a = linearLayoutCompat;
        this.f67006b = recyclerView;
        this.f67007c = titleLayout;
    }

    public static i a(View view) {
        int i11 = R$id.rv_game_list;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.title_layout;
            TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
            if (titleLayout != null) {
                return new i((LinearLayoutCompat) view, recyclerView, titleLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_game_center, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f67005a;
    }
}
