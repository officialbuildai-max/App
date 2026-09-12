package yk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.fission.R$id;
import com.transsion.fission.R$layout;

/* loaded from: classes6.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f79151a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f79152b;

    private b(LinearLayout linearLayout, AppCompatTextView appCompatTextView) {
        this.f79151a = linearLayout;
        this.f79152b = appCompatTextView;
    }

    public static b a(View view) {
        int i11 = R$id.btn_ok;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            return new b((LinearLayout) view, appCompatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fission_dialog_invite_code_help, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f79151a;
    }
}
