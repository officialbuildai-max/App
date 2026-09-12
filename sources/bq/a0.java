package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class a0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16797a;

    /* renamed from: b, reason: collision with root package name */
    public final ShapeableImageView f16798b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f16799c;

    /* renamed from: d, reason: collision with root package name */
    public final BLTextView f16800d;

    /* renamed from: e, reason: collision with root package name */
    public final BLView f16801e;

    /* renamed from: f, reason: collision with root package name */
    public final BLView f16802f;

    private a0(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, BLTextView bLTextView, BLView bLView, BLView bLView2) {
        this.f16797a = constraintLayout;
        this.f16798b = shapeableImageView;
        this.f16799c = appCompatTextView;
        this.f16800d = bLTextView;
        this.f16801e = bLView;
        this.f16802f = bLView2;
    }

    public static a0 a(View view) {
        int i11 = R$id.iv_cover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tv_name;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_new_count;
                BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                if (bLTextView != null) {
                    i11 = R$id.v_name_bg;
                    BLView bLView = (BLView) g4.b.a(view, i11);
                    if (bLView != null) {
                        i11 = R$id.v_stroke;
                        BLView bLView2 = (BLView) g4.b.a(view, i11);
                        if (bLView2 != null) {
                            return new a0((ConstraintLayout) view, shapeableImageView, appCompatTextView, bLTextView, bLView, bLView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static a0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_your_rooms, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16797a;
    }
}
