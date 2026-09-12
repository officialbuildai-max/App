package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class s0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73033a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f73034b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f73035c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f73036d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f73037e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f73038f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f73039g;

    /* renamed from: h, reason: collision with root package name */
    public final View f73040h;

    private s0(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view) {
        this.f73033a = constraintLayout;
        this.f73034b = appCompatImageView;
        this.f73035c = appCompatImageView2;
        this.f73036d = appCompatTextView;
        this.f73037e = appCompatTextView2;
        this.f73038f = appCompatTextView3;
        this.f73039g = appCompatTextView4;
        this.f73040h = view;
    }

    public static s0 a(View view) {
        View a11;
        int i11 = R$id.iv_check;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivPremium;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.tv_ep;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_size;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.tv_time;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.tv_title;
                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView4 != null && (a11 = g4.b.a(view, (i11 = R$id.v_size_line))) != null) {
                                return new s0((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, a11);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73033a;
    }
}
