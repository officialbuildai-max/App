package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class h0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63835a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f63836b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f63837c;

    /* renamed from: d, reason: collision with root package name */
    public final BLTextView f63838d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f63839e;

    /* renamed from: f, reason: collision with root package name */
    public final BLView f63840f;

    private h0(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ShapeableImageView shapeableImageView, BLTextView bLTextView, AppCompatTextView appCompatTextView, BLView bLView) {
        this.f63835a = constraintLayout;
        this.f63836b = constraintLayout2;
        this.f63837c = shapeableImageView;
        this.f63838d = bLTextView;
        this.f63839e = appCompatTextView;
        this.f63840f = bLView;
    }

    public static h0 a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.ivCover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tvMembers;
            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
            if (bLTextView != null) {
                i11 = R$id.tvTitle;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.v_stroke;
                    BLView bLView = (BLView) g4.b.a(view, i11);
                    if (bLView != null) {
                        return new h0(constraintLayout, constraintLayout, shapeableImageView, bLTextView, appCompatTextView, bLView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static h0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_adapter_room_entrance_group, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63835a;
    }
}
