package wm;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.member.R$id;

/* loaded from: classes6.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f77935a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f77936b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f77937c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f77938d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f77939e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f77940f;

    private m(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f77935a = linearLayout;
        this.f77936b = imageView;
        this.f77937c = textView;
        this.f77938d = textView2;
        this.f77939e = textView3;
        this.f77940f = textView4;
    }

    public static m a(View view) {
        int i11 = R$id.iv_close;
        ImageView imageView = (ImageView) g4.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.tv_pay_btn;
            TextView textView = (TextView) g4.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.tv_pay_cancel_btn;
                TextView textView2 = (TextView) g4.b.a(view, i11);
                if (textView2 != null) {
                    i11 = R$id.tv_pay_failed_content;
                    TextView textView3 = (TextView) g4.b.a(view, i11);
                    if (textView3 != null) {
                        i11 = R$id.tv_pay_failed_title;
                        TextView textView4 = (TextView) g4.b.a(view, i11);
                        if (textView4 != null) {
                            return new m((LinearLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f77935a;
    }
}
