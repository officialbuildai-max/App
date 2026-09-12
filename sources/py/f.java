package py;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72804a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f72805b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f72806c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f72807d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f72808e;

    private f(FrameLayout frameLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.f72804a = frameLayout;
        this.f72805b = appCompatTextView;
        this.f72806c = appCompatTextView2;
        this.f72807d = appCompatTextView3;
        this.f72808e = appCompatTextView4;
    }

    public static f a(View view) {
        int i11 = R$id.btn_no;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_yes;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.tv_tips;
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView3 != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView4 != null) {
                        return new f((FrameLayout) view, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72804a;
    }
}
