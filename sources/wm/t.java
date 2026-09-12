package wm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.view.PremiumContentView;

/* loaded from: classes6.dex */
public final class t implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f77998a;

    /* renamed from: b, reason: collision with root package name */
    public final View f77999b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f78000c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f78001d;

    /* renamed from: e, reason: collision with root package name */
    public final PremiumContentView f78002e;

    /* renamed from: f, reason: collision with root package name */
    public final NestedScrollView f78003f;

    /* renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f78004g;

    private t(FrameLayout frameLayout, View view, ImageView imageView, AppCompatTextView appCompatTextView, PremiumContentView premiumContentView, NestedScrollView nestedScrollView, ConstraintLayout constraintLayout) {
        this.f77998a = frameLayout;
        this.f77999b = view;
        this.f78000c = imageView;
        this.f78001d = appCompatTextView;
        this.f78002e = premiumContentView;
        this.f78003f = nestedScrollView;
        this.f78004g = constraintLayout;
    }

    public static t a(View view) {
        int i11 = R$id.bg_mask;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.iv_member_close;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.iv_premium;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.layout_content;
                    PremiumContentView premiumContentView = (PremiumContentView) g4.b.a(view, i11);
                    if (premiumContentView != null) {
                        i11 = R$id.layout_scroller;
                        NestedScrollView nestedScrollView = (NestedScrollView) g4.b.a(view, i11);
                        if (nestedScrollView != null) {
                            i11 = R$id.titleLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                            if (constraintLayout != null) {
                                return new t((FrameLayout) view, a11, imageView, appCompatTextView, premiumContentView, nestedScrollView, constraintLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static t c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.view_member_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f77998a;
    }
}
