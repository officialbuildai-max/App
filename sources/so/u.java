package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: classes6.dex */
public final class u implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f75848a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f75849b;

    /* renamed from: c, reason: collision with root package name */
    public final ProgressBar f75850c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f75851d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f75852e;

    /* renamed from: f, reason: collision with root package name */
    public final TnTextView f75853f;

    private u(FrameLayout frameLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, ConstraintLayout constraintLayout, TnTextView tnTextView) {
        this.f75848a = frameLayout;
        this.f75849b = appCompatImageView;
        this.f75850c = progressBar;
        this.f75851d = recyclerView;
        this.f75852e = constraintLayout;
        this.f75853f = tnTextView;
    }

    public static u a(View view) {
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tool_bar;
                    ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                    if (constraintLayout != null) {
                        i11 = R$id.tv_title;
                        TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                        if (tnTextView != null) {
                            return new u((FrameLayout) view, appCompatImageView, progressBar, recyclerView, constraintLayout, tnTextView);
                        }
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
        View inflate = layoutInflater.inflate(R$layout.fragment_short_tv_immersion_video_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f75848a;
    }
}
