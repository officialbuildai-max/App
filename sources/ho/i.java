package ho;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: classes6.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64724a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64725b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f64726c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f64727d;

    /* renamed from: e, reason: collision with root package name */
    public final GradientTextView f64728e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f64729f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f64730g;

    /* renamed from: h, reason: collision with root package name */
    public final View f64731h;

    /* renamed from: i, reason: collision with root package name */
    public final View f64732i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f64733j;

    private i(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, GradientTextView gradientTextView, AppCompatTextView appCompatTextView3, TextView textView, View view, View view2, AppCompatTextView appCompatTextView4) {
        this.f64724a = constraintLayout;
        this.f64725b = appCompatImageView;
        this.f64726c = appCompatTextView;
        this.f64727d = appCompatTextView2;
        this.f64728e = gradientTextView;
        this.f64729f = appCompatTextView3;
        this.f64730g = textView;
        this.f64731h = view;
        this.f64732i = view2;
        this.f64733j = appCompatTextView4;
    }

    public static i a(View view) {
        View a11;
        View a12;
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.tvDownloadView;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tvFeedback;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tvPro;
                    GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                    if (gradientTextView != null) {
                        i11 = R$id.tvSubtitleSetting;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.tvUnlockHD;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null && (a11 = g4.b.a(view, (i11 = R$id.v_space_end))) != null && (a12 = g4.b.a(view, (i11 = R$id.v_space_start))) != null) {
                                i11 = R$id.vd_title;
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView4 != null) {
                                    return new i((ConstraintLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2, gradientTextView, appCompatTextView3, textView, a11, a12, appCompatTextView4);
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
        return this.f64724a;
    }
}
