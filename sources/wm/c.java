package wm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.member.R$id;

/* loaded from: classes6.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f77838a;

    /* renamed from: b, reason: collision with root package name */
    public final View f77839b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f77840c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f77841d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f77842e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f77843f;

    /* renamed from: g, reason: collision with root package name */
    public final RecyclerView f77844g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f77845h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f77846i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f77847j;

    /* renamed from: k, reason: collision with root package name */
    public final View f77848k;

    private c(FrameLayout frameLayout, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, View view2) {
        this.f77838a = frameLayout;
        this.f77839b = view;
        this.f77840c = constraintLayout;
        this.f77841d = constraintLayout2;
        this.f77842e = appCompatImageView;
        this.f77843f = appCompatImageView2;
        this.f77844g = recyclerView;
        this.f77845h = textView;
        this.f77846i = textView2;
        this.f77847j = textView3;
        this.f77848k = view2;
    }

    public static c a(View view) {
        View a11;
        int i11 = R$id.MeBg1;
        View a12 = g4.b.a(view, i11);
        if (a12 != null) {
            i11 = R$id.MeBg2;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.clRoot;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                if (constraintLayout2 != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ivPremium;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.rvMemberRights;
                            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                            if (recyclerView != null) {
                                i11 = R$id.tvGetAd;
                                TextView textView = (TextView) g4.b.a(view, i11);
                                if (textView != null) {
                                    i11 = R$id.tvPay;
                                    TextView textView2 = (TextView) g4.b.a(view, i11);
                                    if (textView2 != null) {
                                        i11 = R$id.tvTitle;
                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                        if (textView3 != null && (a11 = g4.b.a(view, (i11 = R$id.viewBtnBg))) != null) {
                                            return new c((FrameLayout) view, a12, constraintLayout, constraintLayout2, appCompatImageView, appCompatImageView2, recyclerView, textView, textView2, textView3, a11);
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
    public FrameLayout getRoot() {
        return this.f77838a;
    }
}
