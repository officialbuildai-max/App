package qv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: classes7.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f73848a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f73849b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f73850c;

    /* renamed from: d, reason: collision with root package name */
    public final m f73851d;

    /* renamed from: e, reason: collision with root package name */
    public final ProgressBar f73852e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f73853f;

    private f(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, m mVar, ProgressBar progressBar, RecyclerView recyclerView) {
        this.f73848a = frameLayout;
        this.f73849b = frameLayout2;
        this.f73850c = appCompatImageView;
        this.f73851d = mVar;
        this.f73852e = progressBar;
        this.f73853f = recyclerView;
    }

    public static f a(View view) {
        View a11;
        int i11 = R$id.flUgcImmBack;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.ivUgcImmBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null && (a11 = g4.b.a(view, (i11 = R$id.layoutImmDownloadingPop))) != null) {
                m a12 = m.a(a11);
                i11 = R$id.ugcImmPbLoading;
                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.ugcImmRecyclerView;
                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                    if (recyclerView != null) {
                        return new f((FrameLayout) view, frameLayout, appCompatImageView, a12, progressBar, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_imm_video_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f73848a;
    }
}
