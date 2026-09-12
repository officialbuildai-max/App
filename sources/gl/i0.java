package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class i0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f63851a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f63852b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f63853c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f63854d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f63855e;

    /* renamed from: f, reason: collision with root package name */
    public final TnTextView f63856f;

    /* renamed from: g, reason: collision with root package name */
    public final View f63857g;

    private i0(BLConstraintLayout bLConstraintLayout, Group group, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, TnTextView tnTextView, View view) {
        this.f63851a = bLConstraintLayout;
        this.f63852b = group;
        this.f63853c = shapeableImageView;
        this.f63854d = shapeableImageView2;
        this.f63855e = appCompatImageView;
        this.f63856f = tnTextView;
        this.f63857g = view;
    }

    public static i0 a(View view) {
        View a11;
        int i11 = R$id.group_room_info;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.ivCover;
            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.iv_room_cover;
                ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView2 != null) {
                    i11 = R$id.ivVideoPlay;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.tv_room_title;
                        TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                        if (tnTextView != null && (a11 = g4.b.a(view, (i11 = R$id.v_room_info))) != null) {
                            return new i0((BLConstraintLayout) view, group, shapeableImageView, shapeableImageView2, appCompatImageView, tnTextView, a11);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_adapter_room_entrance_post, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f63851a;
    }
}
