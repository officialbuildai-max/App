package py;

import android.view.View;
import com.noober.background.view.BLView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class g1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f72858a;

    /* renamed from: b, reason: collision with root package name */
    public final GradientTextView f72859b;

    /* renamed from: c, reason: collision with root package name */
    public final BLView f72860c;

    private g1(View view, GradientTextView gradientTextView, BLView bLView) {
        this.f72858a = view;
        this.f72859b = gradientTextView;
        this.f72860c = bLView;
    }

    public static g1 a(View view) {
        int i11 = R$id.tv_title;
        GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
        if (gradientTextView != null) {
            i11 = R$id.v_dot;
            BLView bLView = (BLView) g4.b.a(view, i11);
            if (bLView != null) {
                return new g1(view, gradientTextView, bLView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f72858a;
    }
}
