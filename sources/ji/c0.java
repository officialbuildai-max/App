package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class c0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f66159a;

    /* renamed from: b, reason: collision with root package name */
    public final View f66160b;

    /* renamed from: c, reason: collision with root package name */
    public final View f66161c;

    private c0(FrameLayout frameLayout, View view, View view2) {
        this.f66159a = frameLayout;
        this.f66160b = view;
        this.f66161c = view2;
    }

    public static c0 a(View view) {
        View a11;
        int i11 = R$id.viewBottom;
        View a12 = g4.b.a(view, i11);
        if (a12 == null || (a11 = g4.b.a(view, (i11 = R$id.viewTop))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new c0((FrameLayout) view, a12, a11);
    }

    public static c0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_view_measure_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f66159a;
    }
}
