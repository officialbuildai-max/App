package py;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72840a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f72841b;

    /* renamed from: c, reason: collision with root package name */
    public final View f72842c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f72843d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f72844e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f72845f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f72846g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f72847h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f72848i;

    private g(ConstraintLayout constraintLayout, TextView textView, View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f72840a = constraintLayout;
        this.f72841b = textView;
        this.f72842c = view;
        this.f72843d = appCompatImageView;
        this.f72844e = appCompatImageView2;
        this.f72845f = appCompatImageView3;
        this.f72846g = appCompatImageView4;
        this.f72847h = appCompatTextView;
        this.f72848i = appCompatTextView2;
    }

    public static g a(View view) {
        View a11;
        int i11 = R$id.btn_bottom;
        TextView textView = (TextView) g4.b.a(view, i11);
        if (textView != null && (a11 = g4.b.a(view, (i11 = R$id.btn_top))) != null) {
            i11 = R$id.ivAdIcon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ivAdLoading;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.iv_back;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        i11 = R$id.iv_icon;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView4 != null) {
                            i11 = R$id.tvAdWatchAVideo;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_tips;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    return new g((ConstraintLayout) view, textView, a11, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatTextView, appCompatTextView2);
                                }
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
        return this.f72840a;
    }
}
