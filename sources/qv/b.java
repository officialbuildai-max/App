package qv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: classes7.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f73828a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f73829b;

    /* renamed from: c, reason: collision with root package name */
    public final View f73830c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f73831d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f73832e;

    /* renamed from: f, reason: collision with root package name */
    public final BLTextView f73833f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f73834g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f73835h;

    /* renamed from: i, reason: collision with root package name */
    public final View f73836i;

    /* renamed from: j, reason: collision with root package name */
    public final View f73837j;

    /* renamed from: k, reason: collision with root package name */
    public final View f73838k;

    private b(LinearLayout linearLayout, ConstraintLayout constraintLayout, View view, FrameLayout frameLayout, ImageView imageView, BLTextView bLTextView, TextView textView, TextView textView2, View view2, View view3, View view4) {
        this.f73828a = linearLayout;
        this.f73829b = constraintLayout;
        this.f73830c = view;
        this.f73831d = frameLayout;
        this.f73832e = imageView;
        this.f73833f = bLTextView;
        this.f73834g = textView;
        this.f73835h = textView2;
        this.f73836i = view2;
        this.f73837j = view3;
        this.f73838k = view4;
    }

    public static b a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        int i11 = R$id.clImmCommentContent;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null && (a11 = g4.b.a(view, (i11 = R$id.divider))) != null) {
            i11 = R$id.fl_comment_container;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.iv_close;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.tv_comment;
                    BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                    if (bLTextView != null) {
                        i11 = R$id.tvTitle;
                        TextView textView = (TextView) g4.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.tvTitleCount;
                            TextView textView2 = (TextView) g4.b.a(view, i11);
                            if (textView2 != null && (a12 = g4.b.a(view, (i11 = R$id.v_bottom))) != null && (a13 = g4.b.a(view, (i11 = R$id.vTopLine))) != null && (a14 = g4.b.a(view, (i11 = R$id.vTopSpace))) != null) {
                                return new b((LinearLayout) view, constraintLayout, a11, frameLayout, imageView, bLTextView, textView, textView2, a12, a13, a14);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.dialog_ugc_imm_video_comment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f73828a;
    }
}
