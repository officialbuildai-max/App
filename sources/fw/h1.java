package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.TnButton;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class h1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f62804a;

    /* renamed from: b, reason: collision with root package name */
    public final TnButton f62805b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f62806c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f62807d;

    /* renamed from: e, reason: collision with root package name */
    public final TitleLayout f62808e;

    private h1(LinearLayout linearLayout, TnButton tnButton, TextView textView, RecyclerView recyclerView, TitleLayout titleLayout) {
        this.f62804a = linearLayout;
        this.f62805b = tnButton;
        this.f62806c = textView;
        this.f62807d = recyclerView;
        this.f62808e = titleLayout;
    }

    public static h1 a(View view) {
        int i11 = R$id.btn_login;
        TnButton tnButton = (TnButton) g4.b.a(view, i11);
        if (tnButton != null) {
            i11 = R$id.deviceInfoTv;
            TextView textView = (TextView) g4.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.f56789rv;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tool_bar;
                    TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                    if (titleLayout != null) {
                        return new h1((LinearLayout) view, tnButton, textView, recyclerView, titleLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static h1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_setting, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f62804a;
    }
}
