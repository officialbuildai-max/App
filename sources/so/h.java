package so;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f75658a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f75659b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f75660c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f75661d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f75662e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f75663f;

    private h(FrameLayout frameLayout, ImageView imageView, LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3) {
        this.f75658a = frameLayout;
        this.f75659b = imageView;
        this.f75660c = linearLayoutCompat;
        this.f75661d = textView;
        this.f75662e = textView2;
        this.f75663f = textView3;
    }

    public static h a(View view) {
        int i11 = R$id.ivSelect;
        ImageView imageView = (ImageView) g4.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.llSelect;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.tvBtnCancel;
                TextView textView = (TextView) g4.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tvBtnDownload;
                    TextView textView2 = (TextView) g4.b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.tvTip;
                        TextView textView3 = (TextView) g4.b.a(view, i11);
                        if (textView3 != null) {
                            return new h((FrameLayout) view, imageView, linearLayoutCompat, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f75658a;
    }
}
