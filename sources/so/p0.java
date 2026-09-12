package so;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class p0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f75795a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f75796b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f75797c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f75798d;

    private p0(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.f75795a = linearLayout;
        this.f75796b = textView;
        this.f75797c = textView2;
        this.f75798d = linearLayout2;
    }

    public static p0 a(View view) {
        int i11 = R$id.tv_loading;
        TextView textView = (TextView) g4.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.tv_speed;
            TextView textView2 = (TextView) g4.b.a(view, i11);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new p0(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f75795a;
    }
}
