package fw;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;

/* loaded from: classes7.dex */
public final class m1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62929a;

    /* renamed from: b, reason: collision with root package name */
    public final TnTextView f62930b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f62931c;

    /* renamed from: d, reason: collision with root package name */
    public final Group f62932d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f62933e;

    /* renamed from: f, reason: collision with root package name */
    public final ShapeableImageView f62934f;

    /* renamed from: g, reason: collision with root package name */
    public final ShapeableImageView f62935g;

    /* renamed from: h, reason: collision with root package name */
    public final ShapeableImageView f62936h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f62937i;

    /* renamed from: j, reason: collision with root package name */
    public final TnTextView f62938j;

    private m1(ConstraintLayout constraintLayout, TnTextView tnTextView, ConstraintLayout constraintLayout2, Group group, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, ShapeableImageView shapeableImageView4, AppCompatTextView appCompatTextView, TnTextView tnTextView2) {
        this.f62929a = constraintLayout;
        this.f62930b = tnTextView;
        this.f62931c = constraintLayout2;
        this.f62932d = group;
        this.f62933e = shapeableImageView;
        this.f62934f = shapeableImageView2;
        this.f62935g = shapeableImageView3;
        this.f62936h = shapeableImageView4;
        this.f62937i = appCompatTextView;
        this.f62938j = tnTextView2;
    }

    public static m1 a(View view) {
        int i11 = R$id.btnFind;
        TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
        if (tnTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.groupPlaceholder;
            Group group = (Group) g4.b.a(view, i11);
            if (group != null) {
                i11 = R$id.ivPlaceholder1;
                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.ivPlaceholder2;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                    if (shapeableImageView2 != null) {
                        i11 = R$id.ivPlaceholder3;
                        ShapeableImageView shapeableImageView3 = (ShapeableImageView) g4.b.a(view, i11);
                        if (shapeableImageView3 != null) {
                            i11 = R$id.ivPlaceholder4;
                            ShapeableImageView shapeableImageView4 = (ShapeableImageView) g4.b.a(view, i11);
                            if (shapeableImageView4 != null) {
                                i11 = R$id.tvNumber;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.tvTitle;
                                    TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                                    if (tnTextView2 != null) {
                                        return new m1(constraintLayout, tnTextView, constraintLayout, group, shapeableImageView, shapeableImageView2, shapeableImageView3, shapeableImageView4, appCompatTextView, tnTextView2);
                                    }
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
        return this.f62929a;
    }
}
