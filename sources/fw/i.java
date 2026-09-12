package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f62809a;

    /* renamed from: b, reason: collision with root package name */
    public final View f62810b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f62811c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f62812d;

    private i(LinearLayout linearLayout, View view, FrameLayout frameLayout, ImageView imageView) {
        this.f62809a = linearLayout;
        this.f62810b = view;
        this.f62811c = frameLayout;
        this.f62812d = imageView;
    }

    public static i a(View view) {
        int i11 = R$id.divider_line;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.flContainer;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.ivBack;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    return new i((LinearLayout) view, a11, frameLayout, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_pin_management, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f62809a;
    }
}
