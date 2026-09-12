package py;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72904a;

    /* renamed from: b, reason: collision with root package name */
    public final CircleProgressBar f72905b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f72906c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f72907d;

    /* renamed from: e, reason: collision with root package name */
    public final View f72908e;

    private k(FrameLayout frameLayout, CircleProgressBar circleProgressBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.f72904a = frameLayout;
        this.f72905b = circleProgressBar;
        this.f72906c = appCompatTextView;
        this.f72907d = appCompatTextView2;
        this.f72908e = view;
    }

    public static k a(View view) {
        View a11;
        int i11 = R$id.progress_bar;
        CircleProgressBar circleProgressBar = (CircleProgressBar) g4.b.a(view, i11);
        if (circleProgressBar != null) {
            i11 = R$id.tv_progress;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_tips;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null && (a11 = g4.b.a(view, (i11 = R$id.v_bg))) != null) {
                    return new k((FrameLayout) view, circleProgressBar, appCompatTextView, appCompatTextView2, a11);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72904a;
    }
}
