package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;

/* loaded from: classes7.dex */
public final class r implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f70027a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f70028b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f70029c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f70030d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f70031e;

    private r(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, TextView textView2) {
        this.f70027a = linearLayout;
        this.f70028b = appCompatTextView;
        this.f70029c = appCompatTextView2;
        this.f70030d = textView;
        this.f70031e = textView2;
    }

    public static r a(View view) {
        int i11 = R$id.btn_primary;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_secondary;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.tv_message;
                TextView textView = (TextView) g4.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tv_title;
                    TextView textView2 = (TextView) g4.b.a(view, i11);
                    if (textView2 != null) {
                        return new r((LinearLayout) view, appCompatTextView, appCompatTextView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static r c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_dialog_alert, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f70027a;
    }
}
