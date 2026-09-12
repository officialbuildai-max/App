package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class y implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16978a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f16979b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f16980c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f16981d;

    /* renamed from: e, reason: collision with root package name */
    public final b0 f16982e;

    /* renamed from: f, reason: collision with root package name */
    public final c0 f16983f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f16984g;

    /* renamed from: h, reason: collision with root package name */
    public final BLTextView f16985h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f16986i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f16987j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f16988k;

    /* renamed from: l, reason: collision with root package name */
    public final RoomJoinAnimationView f16989l;

    /* renamed from: m, reason: collision with root package name */
    public final View f16990m;

    /* renamed from: n, reason: collision with root package name */
    public final BLView f16991n;

    private y(ConstraintLayout constraintLayout, FrameLayout frameLayout, Group group, ShapeableImageView shapeableImageView, b0 b0Var, c0 c0Var, AppCompatTextView appCompatTextView, BLTextView bLTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, RoomJoinAnimationView roomJoinAnimationView, View view, BLView bLView) {
        this.f16978a = constraintLayout;
        this.f16979b = frameLayout;
        this.f16980c = group;
        this.f16981d = shapeableImageView;
        this.f16982e = b0Var;
        this.f16983f = c0Var;
        this.f16984g = appCompatTextView;
        this.f16985h = bLTextView;
        this.f16986i = appCompatTextView2;
        this.f16987j = appCompatTextView3;
        this.f16988k = appCompatTextView4;
        this.f16989l = roomJoinAnimationView;
        this.f16990m = view;
        this.f16991n = bLView;
    }

    public static y a(View view) {
        View a11;
        View a12;
        int i11 = R$id.fl_new_post_cover;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.group_new_post;
            Group group = (Group) g4.b.a(view, i11);
            if (group != null) {
                i11 = R$id.iv_cover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView != null && (a11 = g4.b.a(view, (i11 = R$id.layout_new_post_image))) != null) {
                    b0 a13 = b0.a(a11);
                    i11 = R$id.layout_new_post_video;
                    View a14 = g4.b.a(view, i11);
                    if (a14 != null) {
                        c0 a15 = c0.a(a14);
                        i11 = R$id.tv_member;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_new_count;
                            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                            if (bLTextView != null) {
                                i11 = R$id.tv_new_post_content;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tv_tag;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.tv_title;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView4 != null) {
                                            i11 = R$id.v_join;
                                            RoomJoinAnimationView roomJoinAnimationView = (RoomJoinAnimationView) g4.b.a(view, i11);
                                            if (roomJoinAnimationView != null && (a12 = g4.b.a(view, (i11 = R$id.v_line))) != null) {
                                                i11 = R$id.v_new_post_bg;
                                                BLView bLView = (BLView) g4.b.a(view, i11);
                                                if (bLView != null) {
                                                    return new y((ConstraintLayout) view, frameLayout, group, shapeableImageView, a13, a15, appCompatTextView, bLTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, roomJoinAnimationView, a12, bLView);
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

    public static y c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_room_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16978a;
    }
}
