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
public final class r implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f75814a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f75815b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f75816c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressBar f75817d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f75818e;

    /* renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f75819f;

    /* renamed from: g, reason: collision with root package name */
    public final TnTextView f75820g;

    private r(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ProgressBar progressBar, RecyclerView recyclerView, ConstraintLayout constraintLayout, TnTextView tnTextView) {
        this.f75814a = frameLayout;
        this.f75815b = appCompatImageView;
        this.f75816c = appCompatImageView2;
        this.f75817d = progressBar;
        this.f75818e = recyclerView;
        this.f75819f = constraintLayout;
        this.f75820g = tnTextView;
    }

    public static r a(View view) {
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivNegativeFeedback;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
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
                                return new r((FrameLayout) view, appCompatImageView, appCompatImageView2, progressBar, recyclerView, constraintLayout, tnTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_post_immersion_video_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f75814a;
    }
}
