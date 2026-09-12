package py;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72875a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f72876b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f72877c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f72878d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f72879e;

    private i(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f72875a = frameLayout;
        this.f72876b = appCompatImageView;
        this.f72877c = appCompatTextView;
        this.f72878d = appCompatTextView2;
        this.f72879e = appCompatTextView3;
    }

    public static i a(View view) {
        int i11 = R$id.iv_navigation;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.tv_desc;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_positive;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        return new i((FrameLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72875a;
    }
}
