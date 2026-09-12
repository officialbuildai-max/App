package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class x implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f63984a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f63985b;

    /* renamed from: c, reason: collision with root package name */
    public final View f63986c;

    private x(FrameLayout frameLayout, FrameLayout frameLayout2, View view) {
        this.f63984a = frameLayout;
        this.f63985b = frameLayout2;
        this.f63986c = view;
    }

    public static x a(View view) {
        View a11;
        int i11 = R$id.sub_shor_tv_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout == null || (a11 = g4.b.a(view, (i11 = R$id.sub_shor_tv_header_bg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new x((FrameLayout) view, frameLayout, a11);
    }

    public static x c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static x d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_short_tv, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f63984a;
    }
}
