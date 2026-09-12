package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class f0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66205a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f66206b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f66207c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f66208d;

    /* renamed from: e, reason: collision with root package name */
    public final View f66209e;

    private f0(LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.f66205a = linearLayout;
        this.f66206b = linearLayout2;
        this.f66207c = appCompatTextView;
        this.f66208d = appCompatTextView2;
        this.f66209e = view;
    }

    public static f0 a(View view) {
        View a11;
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R$id.tvCd;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.tvSkip;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null && (a11 = g4.b.a(view, (i11 = R$id.viewLine))) != null) {
                return new f0(linearLayout, linearLayout, appCompatTextView, appCompatTextView2, a11);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static f0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.view_ad_countdown_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f66205a;
    }
}
