package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tn.lib.view.TitleLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f72790a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f72791b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleLayout f72792c;

    private e(LinearLayout linearLayout, FrameLayout frameLayout, TitleLayout titleLayout) {
        this.f72790a = linearLayout;
        this.f72791b = frameLayout;
        this.f72792c = titleLayout;
    }

    public static e a(View view) {
        int i11 = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.tool_bar;
            TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
            if (titleLayout != null) {
                return new e((LinearLayout) view, frameLayout, titleLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_transfer, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f72790a;
    }
}
