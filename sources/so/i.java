package so;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f75668a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f75669b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f75670c;

    private i(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f75668a = linearLayout;
        this.f75669b = appCompatTextView;
        this.f75670c = appCompatTextView2;
    }

    public static i a(View view) {
        int i11 = R$id.post_cancel;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.post_confirm;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                return new i((LinearLayout) view, appCompatTextView, appCompatTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f75668a;
    }
}
