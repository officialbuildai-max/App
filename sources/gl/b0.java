package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class b0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63766a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f63767b;

    /* renamed from: c, reason: collision with root package name */
    public final View f63768c;

    private b0(LinearLayout linearLayout, FrameLayout frameLayout, View view) {
        this.f63766a = linearLayout;
        this.f63767b = frameLayout;
        this.f63768c = view;
    }

    public static b0 a(View view) {
        View a11;
        int i11 = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout == null || (a11 = g4.b.a(view, (i11 = R$id.tv_channel_header_bg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new b0((LinearLayout) view, frameLayout, a11);
    }

    public static b0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_tv_channel_tab, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f63766a;
    }
}
