package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class i1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f72885a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f72886b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f72887c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f72888d;

    private i1(LinearLayout linearLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, TextView textView) {
        this.f72885a = linearLayout;
        this.f72886b = appCompatImageView;
        this.f72887c = linearLayout2;
        this.f72888d = textView;
    }

    public static i1 a(View view) {
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i12 = R$id.tvTip;
            TextView textView = (TextView) g4.b.a(view, i12);
            if (textView != null) {
                return new i1(linearLayout, appCompatImageView, linearLayout, textView);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.view_lottery_tip_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f72885a;
    }
}
