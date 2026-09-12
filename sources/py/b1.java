package py;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.GradientTextView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class b1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72744a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f72745b;

    /* renamed from: c, reason: collision with root package name */
    public final CardView f72746c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f72747d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f72748e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f72749f;

    /* renamed from: g, reason: collision with root package name */
    public final GradientTextView f72750g;

    private b1(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, CardView cardView, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2, GradientTextView gradientTextView) {
        this.f72744a = constraintLayout;
        this.f72745b = appCompatImageView;
        this.f72746c = cardView;
        this.f72747d = appCompatTextView;
        this.f72748e = textView;
        this.f72749f = appCompatTextView2;
        this.f72750g = gradientTextView;
    }

    public static b1 a(View view) {
        int i11 = R$id.premiumProBg;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.premiumProTip;
            CardView cardView = (CardView) g4.b.a(view, i11);
            if (cardView != null) {
                i11 = R$id.premiumProTitle;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.premiumProUnlock;
                    TextView textView = (TextView) g4.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tv_transfer;
                            GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                            if (gradientTextView != null) {
                                return new b1((ConstraintLayout) view, appCompatImageView, cardView, appCompatTextView, textView, appCompatTextView2, gradientTextView);
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
        return this.f72744a;
    }
}
