package wm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* loaded from: classes6.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f77857a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f77858b;

    /* renamed from: c, reason: collision with root package name */
    public final GradientBorderView f77859c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f77860d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f77861e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f77862f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f77863g;

    private e(FrameLayout frameLayout, ConstraintLayout constraintLayout, GradientBorderView gradientBorderView, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2, TextView textView2) {
        this.f77857a = frameLayout;
        this.f77858b = constraintLayout;
        this.f77859c = gradientBorderView;
        this.f77860d = appCompatTextView;
        this.f77861e = textView;
        this.f77862f = appCompatTextView2;
        this.f77863g = textView2;
    }

    public static e a(View view) {
        int i11 = R$id.clRoot;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.iv_confirm_container;
            GradientBorderView gradientBorderView = (GradientBorderView) g4.b.a(view, i11);
            if (gradientBorderView != null) {
                i11 = R$id.tv_confirm;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tvDesc;
                    TextView textView = (TextView) g4.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.tv_later;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tvTitle;
                            TextView textView2 = (TextView) g4.b.a(view, i11);
                            if (textView2 != null) {
                                return new e((FrameLayout) view, constraintLayout, gradientBorderView, appCompatTextView, textView, appCompatTextView2, textView2);
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
    public FrameLayout getRoot() {
        return this.f77857a;
    }
}
