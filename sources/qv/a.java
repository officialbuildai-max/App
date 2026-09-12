package qv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: classes7.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f73825a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f73826b;

    /* renamed from: c, reason: collision with root package name */
    public final ProgressBar f73827c;

    private a(FrameLayout frameLayout, FrameLayout frameLayout2, ProgressBar progressBar) {
        this.f73825a = frameLayout;
        this.f73826b = frameLayout2;
        this.f73827c = progressBar;
    }

    public static a a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i11 = R$id.ugcPbLoading;
        ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
        if (progressBar != null) {
            return new a(frameLayout, frameLayout, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_ugc_video_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f73825a;
    }
}
