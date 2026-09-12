package rq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: classes6.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f74764a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f74765b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f74766c;

    private f(RelativeLayout relativeLayout, RecyclerView recyclerView, ImageView imageView) {
        this.f74764a = relativeLayout;
        this.f74765b = recyclerView;
        this.f74766c = imageView;
    }

    public static f a(View view) {
        int i11 = R$id.search_rank_pager_recycler;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.search_rank_pager_type;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null) {
                return new f((RelativeLayout) view, recyclerView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_rank_pager, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f74764a;
    }
}
