package ho;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: classes6.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f64691a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f64692b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f64693c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f64694d;

    private d(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.f64691a = linearLayout;
        this.f64692b = textView;
        this.f64693c = textView2;
        this.f64694d = linearLayout2;
    }

    public static d a(View view) {
        int i11 = R$id.tv_loading;
        TextView textView = (TextView) g4.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.tv_speed;
            TextView textView2 = (TextView) g4.b.a(view, i11);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new d(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f64691a;
    }
}
