package kk;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;

/* loaded from: classes6.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f66999a;

    /* renamed from: b, reason: collision with root package name */
    public final ShapeableImageView f67000b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f67001c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f67002d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f67003e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f67004f;

    private h(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f66999a = constraintLayout;
        this.f67000b = shapeableImageView;
        this.f67001c = constraintLayout2;
        this.f67002d = textView;
        this.f67003e = textView2;
        this.f67004f = textView3;
    }

    public static h a(View view) {
        int i11 = R$id.ivAdIcon;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.tvAdDesc;
            TextView textView = (TextView) g4.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.tvAdTitle;
                TextView textView2 = (TextView) g4.b.a(view, i11);
                if (textView2 != null) {
                    i11 = R$id.tvWatch;
                    TextView textView3 = (TextView) g4.b.a(view, i11);
                    if (textView3 != null) {
                        return new h(constraintLayout, shapeableImageView, constraintLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66999a;
    }
}
