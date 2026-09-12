package th;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R$id;

/* loaded from: classes4.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f76366a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f76367b;

    /* renamed from: c, reason: collision with root package name */
    public final ProgressBar f76368c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f76369d;

    private g(View view, AppCompatImageView appCompatImageView, ProgressBar progressBar, AppCompatTextView appCompatTextView) {
        this.f76366a = view;
        this.f76367b = appCompatImageView;
        this.f76368c = progressBar;
        this.f76369d = appCompatTextView;
    }

    public static g a(View view) {
        int i11 = R$id.iv_join;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.tv_join;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new g(view, appCompatImageView, progressBar, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f76366a;
    }
}
