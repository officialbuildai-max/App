package py;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class f1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f72835a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f72836b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f72837c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f72838d;

    /* renamed from: e, reason: collision with root package name */
    public final View f72839e;

    private f1(View view, AppCompatImageView appCompatImageView, ImageView imageView, AppCompatTextView appCompatTextView, View view2) {
        this.f72835a = view;
        this.f72836b = appCompatImageView;
        this.f72837c = imageView;
        this.f72838d = appCompatTextView;
        this.f72839e = view2;
    }

    public static f1 a(View view) {
        View a11;
        int i11 = R$id.iv_download_fail;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_download_icon;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.tv_download_status;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null && (a11 = g4.b.a(view, (i11 = R$id.v_download_tips))) != null) {
                    return new f1(view, appCompatImageView, imageView, appCompatTextView, a11);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f72835a;
    }
}
