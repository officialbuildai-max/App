package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class j0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72893a;

    /* renamed from: b, reason: collision with root package name */
    public final BLConstraintLayout f72894b;

    /* renamed from: c, reason: collision with root package name */
    public final View f72895c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f72896d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f72897e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f72898f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f72899g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f72900h;

    private j0(FrameLayout frameLayout, BLConstraintLayout bLConstraintLayout, View view, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f72893a = frameLayout;
        this.f72894b = bLConstraintLayout;
        this.f72895c = view;
        this.f72896d = frameLayout2;
        this.f72897e = appCompatImageView;
        this.f72898f = recyclerView;
        this.f72899g = appCompatTextView;
        this.f72900h = appCompatTextView2;
    }

    public static j0 a(View view) {
        View a11;
        int i11 = R$id.cl_content;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
        if (bLConstraintLayout != null && (a11 = g4.b.a(view, (i11 = R$id.divider))) != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.f58533rv;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_all_episodes;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            return new j0(frameLayout, bLConstraintLayout, a11, frameLayout, appCompatImageView, recyclerView, appCompatTextView, appCompatTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static j0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_seasons, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72893a;
    }
}
