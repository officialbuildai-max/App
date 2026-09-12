package on;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ninegridview.R$id;

/* loaded from: classes6.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f71185a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f71186b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f71187c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f71188d;

    private d(View view, AppCompatImageView appCompatImageView, FrameLayout frameLayout, ShapeableImageView shapeableImageView) {
        this.f71185a = view;
        this.f71186b = appCompatImageView;
        this.f71187c = frameLayout;
        this.f71188d = shapeableImageView;
    }

    public static d a(View view) {
        int i11 = R$id.label_gif;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.video_container;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.video_cover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView != null) {
                    return new d(view, appCompatImageView, frameLayout, shapeableImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f71185a;
    }
}
