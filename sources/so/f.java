package so;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f75632a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f75633b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f75634c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f75635d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f75636e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f75637f;

    /* renamed from: g, reason: collision with root package name */
    public final View f75638g;

    private f(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, View view) {
        this.f75632a = linearLayout;
        this.f75633b = imageView;
        this.f75634c = linearLayout2;
        this.f75635d = textView;
        this.f75636e = textView2;
        this.f75637f = textView3;
        this.f75638g = view;
    }

    public static f a(View view) {
        View a11;
        int i11 = R$id.ivRight;
        ImageView imageView = (ImageView) g4.b.a(view, i11);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i11 = R$id.tvCountDown;
            TextView textView = (TextView) g4.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.tvEnterAd;
                TextView textView2 = (TextView) g4.b.a(view, i11);
                if (textView2 != null) {
                    i11 = R$id.tvGoAdFree;
                    TextView textView3 = (TextView) g4.b.a(view, i11);
                    if (textView3 != null && (a11 = g4.b.a(view, (i11 = R$id.view))) != null) {
                        return new f(linearLayout, imageView, linearLayout, textView, textView2, textView3, a11);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f75632a;
    }
}
