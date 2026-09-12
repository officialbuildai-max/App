package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f62797a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f62798b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f62799c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatEditText f62800d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f62801e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f62802f;

    private h(LinearLayout linearLayout, Button button, Button button2, AppCompatEditText appCompatEditText, LinearLayout linearLayout2, RecyclerView recyclerView) {
        this.f62797a = linearLayout;
        this.f62798b = button;
        this.f62799c = button2;
        this.f62800d = appCompatEditText;
        this.f62801e = linearLayout2;
        this.f62802f = recyclerView;
    }

    public static h a(View view) {
        int i11 = R$id.btnCustomInformation;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnReset;
            Button button2 = (Button) g4.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.f56786et;
                AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
                if (appCompatEditText != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i11 = R$id.f56789rv;
                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                    if (recyclerView != null) {
                        return new h(linearLayout, button, button2, appCompatEditText, linearLayout, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_mcc, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f62797a;
    }
}
