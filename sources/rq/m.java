package rq;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.transsion.search.R$id;
import com.transsnet.downloader.widget.DownloadView;

/* loaded from: classes6.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f74797a;

    /* renamed from: b, reason: collision with root package name */
    public final ShapeableImageView f74798b;

    /* renamed from: c, reason: collision with root package name */
    public final CornerTextView f74799c;

    /* renamed from: d, reason: collision with root package name */
    public final View f74800d;

    /* renamed from: e, reason: collision with root package name */
    public final DownloadView f74801e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f74802f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f74803g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f74804h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f74805i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f74806j;

    private m(View view, ShapeableImageView shapeableImageView, CornerTextView cornerTextView, View view2, DownloadView downloadView, RecyclerView recyclerView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f74797a = view;
        this.f74798b = shapeableImageView;
        this.f74799c = cornerTextView;
        this.f74800d = view2;
        this.f74801e = downloadView;
        this.f74802f = recyclerView;
        this.f74803g = linearLayout;
        this.f74804h = appCompatTextView;
        this.f74805i = appCompatTextView2;
        this.f74806j = appCompatTextView3;
    }

    public static m a(View view) {
        View a11;
        int i11 = R$id.ivCover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.ivSearchCorner;
            CornerTextView cornerTextView = (CornerTextView) g4.b.a(view, i11);
            if (cornerTextView != null && (a11 = g4.b.a(view, (i11 = R$id.line))) != null) {
                i11 = R$id.llDownload;
                DownloadView downloadView = (DownloadView) g4.b.a(view, i11);
                if (downloadView != null) {
                    i11 = R$id.rvSeasons;
                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                    if (recyclerView != null) {
                        i11 = R$id.tagContentLL;
                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.tvSubject;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tvSubjectScore;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tvSubjectYear;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        return new m(view, shapeableImageView, cornerTextView, a11, downloadView, recyclerView, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f74797a;
    }
}
