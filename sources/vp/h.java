package vp;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.rewardscenter.R$id;

/* loaded from: classes6.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f77530a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f77531b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f77532c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f77533d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f77534e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f77535f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f77536g;

    private h(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f77530a = constraintLayout;
        this.f77531b = appCompatImageView;
        this.f77532c = shapeableImageView;
        this.f77533d = constraintLayout2;
        this.f77534e = appCompatTextView;
        this.f77535f = appCompatTextView2;
        this.f77536g = appCompatTextView3;
    }

    public static h a(View view) {
        int i11 = R$id.ic_points;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_avatar;
            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
            if (shapeableImageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R$id.tv_earn;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_name;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.tv_points;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            return new h(constraintLayout, appCompatImageView, shapeableImageView, constraintLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
        return this.f77530a;
    }
}
