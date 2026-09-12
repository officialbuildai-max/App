package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class d0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63795a;

    /* renamed from: b, reason: collision with root package name */
    public final View f63796b;

    /* renamed from: c, reason: collision with root package name */
    public final View f63797c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f63798d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f63799e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f63800f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f63801g;

    /* renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f63802h;

    /* renamed from: i, reason: collision with root package name */
    public final TitleLayout f63803i;

    /* renamed from: j, reason: collision with root package name */
    public final TnTextView f63804j;

    private d0(ConstraintLayout constraintLayout, View view, View view2, RecyclerView recyclerView, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ConstraintLayout constraintLayout2, TitleLayout titleLayout, TnTextView tnTextView) {
        this.f63795a = constraintLayout;
        this.f63796b = view;
        this.f63797c = view2;
        this.f63798d = recyclerView;
        this.f63799e = frameLayout;
        this.f63800f = frameLayout2;
        this.f63801g = imageView;
        this.f63802h = constraintLayout2;
        this.f63803i = titleLayout;
        this.f63804j = tnTextView;
    }

    public static d0 a(View view) {
        View a11;
        int i11 = R$id.film_list_color_mask;
        View a12 = g4.b.a(view, i11);
        if (a12 != null && (a11 = g4.b.a(view, (i11 = R$id.film_list_gradient))) != null) {
            i11 = R$id.ranking_category_recycler;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.ranking_error;
                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.ranking_list_container;
                    FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.ranking_list_cover;
                        ImageView imageView = (ImageView) g4.b.a(view, i11);
                        if (imageView != null) {
                            i11 = R$id.ranking_loading_frame;
                            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.ranking_title;
                                TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                                if (titleLayout != null) {
                                    i11 = R$id.tv_titleText;
                                    TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                                    if (tnTextView != null) {
                                        return new d0((ConstraintLayout) view, a12, a11, recyclerView, frameLayout, frameLayout2, imageView, constraintLayout, titleLayout, tnTextView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static d0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_ranking, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63795a;
    }
}
