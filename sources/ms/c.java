package ms;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsion.shorttv.R$id;

/* loaded from: classes7.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f69842a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f69843b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f69844c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressBar f69845d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f69846e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f69847f;

    /* renamed from: g, reason: collision with root package name */
    public final View f69848g;

    private c(BLConstraintLayout bLConstraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView, View view) {
        this.f69842a = bLConstraintLayout;
        this.f69843b = frameLayout;
        this.f69844c = appCompatImageView;
        this.f69845d = progressBar;
        this.f69846e = recyclerView;
        this.f69847f = appCompatTextView;
        this.f69848g = view;
    }

    public static c a(View view) {
        View a11;
        int i11 = R$id.content_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.pb_loading;
                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.tabs_rv;
                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                    if (recyclerView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null && (a11 = g4.b.a(view, (i11 = R$id.view_line))) != null) {
                            return new c((BLConstraintLayout) view, frameLayout, appCompatImageView, progressBar, recyclerView, appCompatTextView, a11);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f69842a;
    }
}
