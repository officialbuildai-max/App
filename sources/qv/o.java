package qv;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.widget.TopCropShapeableImageView;

/* loaded from: classes7.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73936a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f73937b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f73938c;

    /* renamed from: d, reason: collision with root package name */
    public final TopCropShapeableImageView f73939d;

    /* renamed from: e, reason: collision with root package name */
    public final TopCropShapeableImageView f73940e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f73941f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f73942g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f73943h;

    /* renamed from: i, reason: collision with root package name */
    public final BLView f73944i;

    /* renamed from: j, reason: collision with root package name */
    public final BLView f73945j;

    private o(ConstraintLayout constraintLayout, Group group, Group group2, TopCropShapeableImageView topCropShapeableImageView, TopCropShapeableImageView topCropShapeableImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLView bLView, BLView bLView2) {
        this.f73936a = constraintLayout;
        this.f73937b = group;
        this.f73938c = group2;
        this.f73939d = topCropShapeableImageView;
        this.f73940e = topCropShapeableImageView2;
        this.f73941f = appCompatTextView;
        this.f73942g = appCompatTextView2;
        this.f73943h = appCompatTextView3;
        this.f73944i = bLView;
        this.f73945j = bLView2;
    }

    public static o a(View view) {
        int i11 = R$id.groupPreview;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.groupPreviewCollection;
            Group group2 = (Group) g4.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivPreviewImage;
                TopCropShapeableImageView topCropShapeableImageView = (TopCropShapeableImageView) g4.b.a(view, i11);
                if (topCropShapeableImageView != null) {
                    i11 = R$id.ivPreviewImageCollection;
                    TopCropShapeableImageView topCropShapeableImageView2 = (TopCropShapeableImageView) g4.b.a(view, i11);
                    if (topCropShapeableImageView2 != null) {
                        i11 = R$id.tvClickText;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tvClickTextCollection;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView2 != null) {
                                i11 = R$id.tvTitle;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView3 != null) {
                                    i11 = R$id.vGradientOverlay;
                                    BLView bLView = (BLView) g4.b.a(view, i11);
                                    if (bLView != null) {
                                        i11 = R$id.vGradientOverlayCollection;
                                        BLView bLView2 = (BLView) g4.b.a(view, i11);
                                        if (bLView2 != null) {
                                            return new o((ConstraintLayout) view, group, group2, topCropShapeableImageView, topCropShapeableImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3, bLView, bLView2);
                                        }
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
        return this.f73936a;
    }
}
