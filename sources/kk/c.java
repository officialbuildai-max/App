package kk;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Guideline;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;

/* loaded from: classes6.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f66936a;

    /* renamed from: b, reason: collision with root package name */
    public final Guideline f66937b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f66938c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f66939d;

    /* renamed from: e, reason: collision with root package name */
    public final Barrier f66940e;

    /* renamed from: f, reason: collision with root package name */
    public final Barrier f66941f;

    /* renamed from: g, reason: collision with root package name */
    public final Guideline f66942g;

    private c(View view, Guideline guideline, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, Barrier barrier, Barrier barrier2, Guideline guideline2) {
        this.f66936a = view;
        this.f66937b = guideline;
        this.f66938c = shapeableImageView;
        this.f66939d = appCompatImageView;
        this.f66940e = barrier;
        this.f66941f = barrier2;
        this.f66942g = guideline2;
    }

    public static c a(View view) {
        Guideline guideline = (Guideline) g4.b.a(view, R$id.bottomGuideline);
        int i11 = R$id.f43789iv;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.ivClose;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                return new c(view, guideline, shapeableImageView, appCompatImageView, (Barrier) g4.b.a(view, R$id.leftBarrier), (Barrier) g4.b.a(view, R$id.rightBarrier), (Guideline) g4.b.a(view, R$id.topGuideline));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f66936a;
    }
}
