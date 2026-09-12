package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class d0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72786a;

    /* renamed from: b, reason: collision with root package name */
    public final z0 f72787b;

    private d0(FrameLayout frameLayout, z0 z0Var) {
        this.f72786a = frameLayout;
        this.f72787b = z0Var;
    }

    public static d0 a(View view) {
        int i11 = R$id.included_content;
        View a11 = g4.b.a(view, i11);
        if (a11 == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new d0((FrameLayout) view, z0.a(a11));
    }

    public static d0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_download_res_path_setting, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72786a;
    }
}
