package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.view.bubbleview.BubbleFrameLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class k0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62856a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f62857b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f62858c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f62859d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f62860e;

    /* renamed from: f, reason: collision with root package name */
    public final BLConstraintLayout f62861f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f62862g;

    /* renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f62863h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f62864i;

    /* renamed from: j, reason: collision with root package name */
    public final TnTextView f62865j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f62866k;

    /* renamed from: l, reason: collision with root package name */
    public final BubbleFrameLayout f62867l;

    /* renamed from: m, reason: collision with root package name */
    public final TnTextView f62868m;

    private k0(ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView2, BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView4, TnTextView tnTextView, AppCompatImageView appCompatImageView5, BubbleFrameLayout bubbleFrameLayout, TnTextView tnTextView2) {
        this.f62856a = constraintLayout;
        this.f62857b = recyclerView;
        this.f62858c = appCompatImageView;
        this.f62859d = constraintLayout2;
        this.f62860e = appCompatImageView2;
        this.f62861f = bLConstraintLayout;
        this.f62862g = appCompatImageView3;
        this.f62863h = constraintLayout3;
        this.f62864i = appCompatImageView4;
        this.f62865j = tnTextView;
        this.f62866k = appCompatImageView5;
        this.f62867l = bubbleFrameLayout;
        this.f62868m = tnTextView2;
    }

    public static k0 a(View view) {
        int i11 = R$id.contentList;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.iv_qr_code;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R$id.loginPremiumTipArrow;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.loginPremiumTipBody;
                    BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
                    if (bLConstraintLayout != null) {
                        i11 = R$id.loginPremiumTipClose;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.loginPremiumTipContainer;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                            if (constraintLayout2 != null) {
                                i11 = R$id.loginPremiumTipIcon;
                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView4 != null) {
                                    i11 = R$id.loginPremiumTipText;
                                    TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                                    if (tnTextView != null) {
                                        i11 = R$id.myActivityTipClose;
                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView5 != null) {
                                            i11 = R$id.myActivityTipContainer;
                                            BubbleFrameLayout bubbleFrameLayout = (BubbleFrameLayout) g4.b.a(view, i11);
                                            if (bubbleFrameLayout != null) {
                                                i11 = R$id.myActivityTipText;
                                                TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                                                if (tnTextView2 != null) {
                                                    return new k0(constraintLayout, recyclerView, appCompatImageView, constraintLayout, appCompatImageView2, bLConstraintLayout, appCompatImageView3, constraintLayout2, appCompatImageView4, tnTextView, appCompatImageView5, bubbleFrameLayout, tnTextView2);
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

    public static k0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_me, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62856a;
    }
}
