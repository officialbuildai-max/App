package hp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.clip.ClipImageView;
import com.transsion.publish.view.clip.ClipView;

/* loaded from: classes6.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f64841a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageButton f64842b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f64843c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressBar f64844d;

    /* renamed from: e, reason: collision with root package name */
    public final ClipView f64845e;

    /* renamed from: f, reason: collision with root package name */
    public final ClipImageView f64846f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f64847g;

    private a(RelativeLayout relativeLayout, AppCompatImageButton appCompatImageButton, RelativeLayout relativeLayout2, ProgressBar progressBar, ClipView clipView, ClipImageView clipImageView, TextView textView) {
        this.f64841a = relativeLayout;
        this.f64842b = appCompatImageButton;
        this.f64843c = relativeLayout2;
        this.f64844d = progressBar;
        this.f64845e = clipView;
        this.f64846f = clipImageView;
        this.f64847g = textView;
    }

    public static a a(View view) {
        int i11 = R$id.btn_back;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) g4.b.a(view, i11);
        if (appCompatImageButton != null) {
            i11 = R$id.clTitle;
            RelativeLayout relativeLayout = (RelativeLayout) g4.b.a(view, i11);
            if (relativeLayout != null) {
                i11 = R$id.clip_loading;
                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.clipview;
                    ClipView clipView = (ClipView) g4.b.a(view, i11);
                    if (clipView != null) {
                        i11 = R$id.src_pic;
                        ClipImageView clipImageView = (ClipImageView) g4.b.a(view, i11);
                        if (clipImageView != null) {
                            i11 = R$id.tvDone;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null) {
                                return new a((RelativeLayout) view, appCompatImageButton, relativeLayout, progressBar, clipView, clipImageView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_clip_image, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f64841a;
    }
}
