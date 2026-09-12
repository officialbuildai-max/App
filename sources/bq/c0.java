package bq;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.room.R$id;

/* loaded from: classes5.dex */
public final class c0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f16811a;

    /* renamed from: b, reason: collision with root package name */
    public final ShapeableImageView f16812b;

    private c0(FrameLayout frameLayout, ShapeableImageView shapeableImageView) {
        this.f16811a = frameLayout;
        this.f16812b = shapeableImageView;
    }

    public static c0 a(View view) {
        int i11 = R$id.iv_post_cover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            return new c0((FrameLayout) view, shapeableImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f16811a;
    }
}
