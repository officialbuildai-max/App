package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class u implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63972a;

    /* renamed from: b, reason: collision with root package name */
    public final ComposeView f63973b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f63974c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f63975d;

    /* renamed from: e, reason: collision with root package name */
    public final TitleLayout f63976e;

    private u(ConstraintLayout constraintLayout, ComposeView composeView, FrameLayout frameLayout, ConstraintLayout constraintLayout2, TitleLayout titleLayout) {
        this.f63972a = constraintLayout;
        this.f63973b = composeView;
        this.f63974c = frameLayout;
        this.f63975d = constraintLayout2;
        this.f63976e = titleLayout;
    }

    public static u a(View view) {
        int i11 = R$id.rank_all_category_container;
        ComposeView composeView = (ComposeView) g4.b.a(view, i11);
        if (composeView != null) {
            i11 = R$id.rank_all_error;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.rank_all_loading_frame;
                ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                if (constraintLayout != null) {
                    i11 = R$id.rank_all_title;
                    TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                    if (titleLayout != null) {
                        return new u((ConstraintLayout) view, composeView, frameLayout, constraintLayout, titleLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_rank_all, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63972a;
    }
}
