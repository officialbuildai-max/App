package so;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f75645a;

    /* renamed from: b, reason: collision with root package name */
    public final View f75646b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f75647c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f75648d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f75649e;

    /* renamed from: f, reason: collision with root package name */
    public final View f75650f;

    private g(ConstraintLayout constraintLayout, View view, FrameLayout frameLayout, ImageView imageView, AppCompatTextView appCompatTextView, View view2) {
        this.f75645a = constraintLayout;
        this.f75646b = view;
        this.f75647c = frameLayout;
        this.f75648d = imageView;
        this.f75649e = appCompatTextView;
        this.f75650f = view2;
    }

    public static g a(View view) {
        View a11;
        int i11 = R$id.divider;
        View a12 = g4.b.a(view, i11);
        if (a12 != null) {
            i11 = R$id.fl_comment_container;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.iv_close;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.tv_comment;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null && (a11 = g4.b.a(view, (i11 = R$id.v_bottom))) != null) {
                        return new g((ConstraintLayout) view, a12, frameLayout, imageView, appCompatTextView, a11);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75645a;
    }
}
