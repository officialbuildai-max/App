package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f62852a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f62853b;

    /* renamed from: c, reason: collision with root package name */
    public final ProgressBar f62854c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleLayout f62855d;

    private k(RelativeLayout relativeLayout, FrameLayout frameLayout, ProgressBar progressBar, TitleLayout titleLayout) {
        this.f62852a = relativeLayout;
        this.f62853b = frameLayout;
        this.f62854c = progressBar;
        this.f62855d = titleLayout;
    }

    public static k a(View view) {
        int i11 = R$id.fl_content;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.load_view;
            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.toolbar;
                TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                if (titleLayout != null) {
                    return new k((RelativeLayout) view, frameLayout, progressBar, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_profile_center_edit, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f62852a;
    }
}
