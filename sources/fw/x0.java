package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class x0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f63106a;

    /* renamed from: b, reason: collision with root package name */
    public final BLTextView f63107b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f63108c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f63109d;

    /* renamed from: e, reason: collision with root package name */
    public final BLView f63110e;

    /* renamed from: f, reason: collision with root package name */
    public final TnTextView f63111f;

    /* renamed from: g, reason: collision with root package name */
    public final TnTextView f63112g;

    private x0(BLConstraintLayout bLConstraintLayout, BLTextView bLTextView, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, BLView bLView, TnTextView tnTextView, TnTextView tnTextView2) {
        this.f63106a = bLConstraintLayout;
        this.f63107b = bLTextView;
        this.f63108c = appCompatImageView;
        this.f63109d = shapeableImageView;
        this.f63110e = bLView;
        this.f63111f = tnTextView;
        this.f63112g = tnTextView2;
    }

    public static x0 a(View view) {
        int i11 = R$id.memberBadge;
        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
        if (bLTextView != null) {
            i11 = R$id.memberBadgeIcon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.userAvatar;
                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.userAvatarBorder;
                    BLView bLView = (BLView) g4.b.a(view, i11);
                    if (bLView != null) {
                        i11 = R$id.userName;
                        TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                        if (tnTextView != null) {
                            i11 = R$id.validUntil;
                            TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                            if (tnTextView2 != null) {
                                return new x0((BLConstraintLayout) view, bLTextView, appCompatImageView, shapeableImageView, bLView, tnTextView, tnTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static x0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_device_management_user, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f63106a;
    }
}
