package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tn.lib.view.TitleLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72783a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f72784b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleLayout f72785c;

    private d(FrameLayout frameLayout, FrameLayout frameLayout2, TitleLayout titleLayout) {
        this.f72783a = frameLayout;
        this.f72784b = frameLayout2;
        this.f72785c = titleLayout;
    }

    public static d a(View view) {
        int i11 = R$id.container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.title_layout;
            TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
            if (titleLayout != null) {
                return new d((FrameLayout) view, frameLayout, titleLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_my_downloads, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72783a;
    }
}
