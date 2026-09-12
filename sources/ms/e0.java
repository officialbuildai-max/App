package ms;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.shorttv.R$id;

/* loaded from: classes7.dex */
public final class e0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f69886a;

    /* renamed from: b, reason: collision with root package name */
    public final ShapeableImageView f69887b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f69888c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f69889d;

    private e0(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.f69886a = constraintLayout;
        this.f69887b = shapeableImageView;
        this.f69888c = appCompatImageView;
        this.f69889d = appCompatTextView;
    }

    public static e0 a(View view) {
        int i11 = R$id.iv_cover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.iv_play;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tv_title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new e0((ConstraintLayout) view, shapeableImageView, appCompatImageView, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f69886a;
    }
}
