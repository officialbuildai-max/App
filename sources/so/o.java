package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.PostDetailOperationView;

/* loaded from: classes6.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f75754a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f75755b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f75756c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f75757d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f75758e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f75759f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f75760g;

    /* renamed from: h, reason: collision with root package name */
    public final ShapeableImageView f75761h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f75762i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f75763j;

    /* renamed from: k, reason: collision with root package name */
    public final PostDetailOperationView f75764k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f75765l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f75766m;

    private o(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView3, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView4, AppCompatImageView appCompatImageView2, PostDetailOperationView postDetailOperationView, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.f75754a = constraintLayout;
        this.f75755b = constraintLayout2;
        this.f75756c = group;
        this.f75757d = appCompatTextView;
        this.f75758e = appCompatTextView2;
        this.f75759f = appCompatImageView;
        this.f75760g = appCompatTextView3;
        this.f75761h = shapeableImageView;
        this.f75762i = appCompatTextView4;
        this.f75763j = appCompatImageView2;
        this.f75764k = postDetailOperationView;
        this.f75765l = appCompatTextView5;
        this.f75766m = appCompatTextView6;
    }

    public static o a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.groupNoCommentYet;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.itemCommentContent;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.itemCommentData;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.itemCommentLikeIcon;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.itemCommentReply;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.itemCommentUserAvatar;
                            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                            if (shapeableImageView != null) {
                                i11 = R$id.itemCommentUserName;
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView4 != null) {
                                    i11 = R$id.ivRight;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView2 != null) {
                                        i11 = R$id.postDetailOperationView;
                                        PostDetailOperationView postDetailOperationView = (PostDetailOperationView) g4.b.a(view, i11);
                                        if (postDetailOperationView != null) {
                                            i11 = R$id.tvComments;
                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView5 != null) {
                                                i11 = R$id.tvNoCommentYet;
                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView6 != null) {
                                                    return new o(constraintLayout, constraintLayout, group, appCompatTextView, appCompatTextView2, appCompatImageView, appCompatTextView3, shapeableImageView, appCompatTextView4, appCompatImageView2, postDetailOperationView, appCompatTextView5, appCompatTextView6);
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

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_post_detail_comments_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75754a;
    }
}
