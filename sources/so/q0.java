package so;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class q0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f75808a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f75809b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f75810c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f75811d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f75812e;

    /* renamed from: f, reason: collision with root package name */
    public final View f75813f;

    private q0(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
        this.f75808a = linearLayout;
        this.f75809b = imageView;
        this.f75810c = linearLayout2;
        this.f75811d = textView;
        this.f75812e = textView2;
        this.f75813f = view;
    }

    public static q0 a(View view) {
        View a11;
        int i11 = R$id.ivRight;
        ImageView imageView = (ImageView) g4.b.a(view, i11);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i11 = R$id.tvCountDown;
            TextView textView = (TextView) g4.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.tvGetAdFree;
                TextView textView2 = (TextView) g4.b.a(view, i11);
                if (textView2 != null && (a11 = g4.b.a(view, (i11 = R$id.view))) != null) {
                    return new q0(linearLayout, imageView, linearLayout, textView, textView2, a11);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f75808a;
    }
}
