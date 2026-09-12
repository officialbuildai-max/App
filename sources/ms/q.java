package ms;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.noober.background.view.BLTextView;
import com.transsion.shorttv.R$id;

/* loaded from: classes7.dex */
public final class q implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f70016a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f70017b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f70018c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f70019d;

    /* renamed from: e, reason: collision with root package name */
    public final BLTextView f70020e;

    private q(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat2, TextView textView, BLTextView bLTextView) {
        this.f70016a = linearLayoutCompat;
        this.f70017b = appCompatImageView;
        this.f70018c = linearLayoutCompat2;
        this.f70019d = textView;
        this.f70020e = bLTextView;
    }

    public static q a(View view) {
        int i11 = R$id.ivDefaultImage;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            i11 = R$id.tvDesc;
            TextView textView = (TextView) g4.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.tv_retry;
                BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                if (bLTextView != null) {
                    return new q(linearLayoutCompat, appCompatImageView, linearLayoutCompat, textView, bLTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f70016a;
    }
}
