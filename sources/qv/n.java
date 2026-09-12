package qv;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;

/* loaded from: classes7.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73926a;

    /* renamed from: b, reason: collision with root package name */
    public final BLTextView f73927b;

    /* renamed from: c, reason: collision with root package name */
    public final BLTextView f73928c;

    /* renamed from: d, reason: collision with root package name */
    public final Group f73929d;

    /* renamed from: e, reason: collision with root package name */
    public final Group f73930e;

    /* renamed from: f, reason: collision with root package name */
    public final ShapeableImageView f73931f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f73932g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f73933h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f73934i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f73935j;

    private n(ConstraintLayout constraintLayout, BLTextView bLTextView, BLTextView bLTextView2, Group group, Group group2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f73926a = constraintLayout;
        this.f73927b = bLTextView;
        this.f73928c = bLTextView2;
        this.f73929d = group;
        this.f73930e = group2;
        this.f73931f = shapeableImageView;
        this.f73932g = appCompatImageView;
        this.f73933h = appCompatTextView;
        this.f73934i = appCompatTextView2;
        this.f73935j = appCompatTextView3;
    }

    public static n a(View view) {
        int i11 = R$id.bgDetails;
        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
        if (bLTextView != null) {
            i11 = R$id.bgDownload;
            BLTextView bLTextView2 = (BLTextView) g4.b.a(view, i11);
            if (bLTextView2 != null) {
                i11 = R$id.groupDetails;
                Group group = (Group) g4.b.a(view, i11);
                if (group != null) {
                    i11 = R$id.groupDownload;
                    Group group2 = (Group) g4.b.a(view, i11);
                    if (group2 != null) {
                        i11 = R$id.ivAvatar;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                        if (shapeableImageView != null) {
                            i11 = R$id.ivDownload;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView != null) {
                                i11 = R$id.tvDetails;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.tvDownload;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tvTitle;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            return new n((ConstraintLayout) view, bLTextView, bLTextView2, group, group2, shapeableImageView, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
        return this.f73926a;
    }
}
