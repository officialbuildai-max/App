package th;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;

/* loaded from: classes4.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f76358a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f76359b;

    /* renamed from: c, reason: collision with root package name */
    public final ProgressBar f76360c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f76361d;

    /* renamed from: e, reason: collision with root package name */
    public final Space f76362e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f76363f;

    private e(View view, AppCompatTextView appCompatTextView, ProgressBar progressBar, AppCompatTextView appCompatTextView2, Space space, AppCompatTextView appCompatTextView3) {
        this.f76358a = view;
        this.f76359b = appCompatTextView;
        this.f76360c = progressBar;
        this.f76361d = appCompatTextView2;
        this.f76362e = space;
        this.f76363f = appCompatTextView3;
    }

    public static e a(View view) {
        int i11 = R$id.go_to_setting;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.progress_bar;
            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.retry;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.space;
                    Space space = (Space) g4.b.a(view, i11);
                    if (space != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            return new e(view, appCompatTextView, progressBar, appCompatTextView2, space, appCompatTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static e b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_no_network, viewGroup);
        return a(viewGroup);
    }

    @Override // g4.a
    public View getRoot() {
        return this.f76358a;
    }
}
