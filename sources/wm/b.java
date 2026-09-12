package wm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;

/* loaded from: classes6.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f77834a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f77835b;

    /* renamed from: c, reason: collision with root package name */
    public final p f77836c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f77837d;

    private b(LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout, p pVar, AppCompatTextView appCompatTextView) {
        this.f77834a = linearLayoutCompat;
        this.f77835b = frameLayout;
        this.f77836c = pVar;
        this.f77837d = appCompatTextView;
    }

    public static b a(View view) {
        View a11;
        int i11 = R$id.container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null && (a11 = g4.b.a(view, (i11 = R$id.titleLayout))) != null) {
            p a12 = p.a(a11);
            int i12 = R$id.tvTotalCoin;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i12);
            if (appCompatTextView != null) {
                return new b((LinearLayoutCompat) view, frameLayout, a12, appCompatTextView);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_points_history_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f77834a;
    }
}
