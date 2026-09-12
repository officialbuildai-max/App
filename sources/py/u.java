package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class u implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f73051a;

    /* renamed from: b, reason: collision with root package name */
    public final BLConstraintLayout f73052b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f73053c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f73054d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f73055e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f73056f;

    private u(FrameLayout frameLayout, BLConstraintLayout bLConstraintLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.f73051a = frameLayout;
        this.f73052b = bLConstraintLayout;
        this.f73053c = frameLayout2;
        this.f73054d = appCompatImageView;
        this.f73055e = recyclerView;
        this.f73056f = appCompatTextView;
    }

    public static u a(View view) {
        int i11 = R$id.cl_content;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
        if (bLConstraintLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.f58533rv;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        return new u(frameLayout, bLConstraintLayout, frameLayout, appCompatImageView, recyclerView, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_download_audio_track, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f73051a;
    }
}
