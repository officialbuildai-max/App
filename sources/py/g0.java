package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadPathEntranceView;
import com.transsnet.downloader.widget.DownloadView;

/* loaded from: classes7.dex */
public final class g0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72849a;

    /* renamed from: b, reason: collision with root package name */
    public final s0 f72850b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f72851c;

    /* renamed from: d, reason: collision with root package name */
    public final View f72852d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayoutCompat f72853e;

    /* renamed from: f, reason: collision with root package name */
    public final DownloadView f72854f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f72855g;

    /* renamed from: h, reason: collision with root package name */
    public final View f72856h;

    /* renamed from: i, reason: collision with root package name */
    public final DownloadPathEntranceView f72857i;

    private g0(FrameLayout frameLayout, s0 s0Var, ImageView imageView, View view, LinearLayoutCompat linearLayoutCompat, DownloadView downloadView, AppCompatTextView appCompatTextView, View view2, DownloadPathEntranceView downloadPathEntranceView) {
        this.f72849a = frameLayout;
        this.f72850b = s0Var;
        this.f72851c = imageView;
        this.f72852d = view;
        this.f72853e = linearLayoutCompat;
        this.f72854f = downloadView;
        this.f72855g = appCompatTextView;
        this.f72856h = view2;
        this.f72857i = downloadPathEntranceView;
    }

    public static g0 a(View view) {
        View a11;
        View a12;
        int i11 = R$id.included_content;
        View a13 = g4.b.a(view, i11);
        if (a13 != null) {
            s0 a14 = s0.a(a13);
            i11 = R$id.iv_close;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null && (a11 = g4.b.a(view, (i11 = R$id.line))) != null) {
                i11 = R$id.ll_content;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                if (linearLayoutCompat != null) {
                    i11 = R$id.tv_download;
                    DownloadView downloadView = (DownloadView) g4.b.a(view, i11);
                    if (downloadView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null && (a12 = g4.b.a(view, (i11 = R$id.v_bottom))) != null) {
                            i11 = R$id.v_path_entrance;
                            DownloadPathEntranceView downloadPathEntranceView = (DownloadPathEntranceView) g4.b.a(view, i11);
                            if (downloadPathEntranceView != null) {
                                return new g0((FrameLayout) view, a14, imageView, a11, linearLayoutCompat, downloadView, appCompatTextView, a12, downloadPathEntranceView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static g0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_download_res_single_res, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72849a;
    }
}
