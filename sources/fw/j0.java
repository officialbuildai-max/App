package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class j0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62834a;

    /* renamed from: b, reason: collision with root package name */
    public final BLLinearLayout f62835b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f62836c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f62837d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f62838e;

    /* renamed from: f, reason: collision with root package name */
    public final ShapeableImageView f62839f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f62840g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearLayout f62841h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f62842i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f62843j;

    /* renamed from: k, reason: collision with root package name */
    public final TnTextView f62844k;

    /* renamed from: l, reason: collision with root package name */
    public final TnTextView f62845l;

    /* renamed from: m, reason: collision with root package name */
    public final BLView f62846m;

    /* renamed from: n, reason: collision with root package name */
    public final BLView f62847n;

    private j0(ConstraintLayout constraintLayout, BLLinearLayout bLLinearLayout, ShapeableImageView shapeableImageView, ImageView imageView, ImageView imageView2, ShapeableImageView shapeableImageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TnTextView tnTextView, TnTextView tnTextView2, BLView bLView, BLView bLView2) {
        this.f62834a = constraintLayout;
        this.f62835b = bLLinearLayout;
        this.f62836c = shapeableImageView;
        this.f62837d = imageView;
        this.f62838e = imageView2;
        this.f62839f = shapeableImageView2;
        this.f62840g = linearLayout;
        this.f62841h = linearLayout2;
        this.f62842i = linearLayout3;
        this.f62843j = linearLayout4;
        this.f62844k = tnTextView;
        this.f62845l = tnTextView2;
        this.f62846m = bLView;
        this.f62847n = bLView2;
    }

    public static j0 a(View view) {
        int i11 = R$id.ivAddKids;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) g4.b.a(view, i11);
        if (bLLinearLayout != null) {
            i11 = R$id.ivAdultAvatar;
            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.ivAdultEditIcon;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.ivEditIcon;
                    ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                    if (imageView2 != null) {
                        i11 = R$id.ivKidsAvatar;
                        ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                        if (shapeableImageView2 != null) {
                            i11 = R$id.layoutAccountsRow;
                            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.layoutAddKids;
                                LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                                if (linearLayout2 != null) {
                                    i11 = R$id.layoutAdultProfile;
                                    LinearLayout linearLayout3 = (LinearLayout) g4.b.a(view, i11);
                                    if (linearLayout3 != null) {
                                        i11 = R$id.layoutKidsProfile;
                                        LinearLayout linearLayout4 = (LinearLayout) g4.b.a(view, i11);
                                        if (linearLayout4 != null) {
                                            i11 = R$id.tvAdultName;
                                            TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                                            if (tnTextView != null) {
                                                i11 = R$id.tvKidsName;
                                                TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                                                if (tnTextView2 != null) {
                                                    i11 = R$id.viewAdultAvatarOverlay;
                                                    BLView bLView = (BLView) g4.b.a(view, i11);
                                                    if (bLView != null) {
                                                        i11 = R$id.viewKidsAvatarOverlay;
                                                        BLView bLView2 = (BLView) g4.b.a(view, i11);
                                                        if (bLView2 != null) {
                                                            return new j0((ConstraintLayout) view, bLLinearLayout, shapeableImageView, imageView, imageView2, shapeableImageView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, tnTextView, tnTextView2, bLView, bLView2);
                                                        }
                                                    }
                                                }
                                            }
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

    public static j0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_manage_profiles, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62834a;
    }
}
