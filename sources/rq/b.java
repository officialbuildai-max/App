package rq;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.search.R$id;
import com.transsion.search_pugc.speech.SpeechRecognizerVolumeCircleView;

/* loaded from: classes6.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f74721a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f74722b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f74723c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f74724d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f74725e;

    /* renamed from: f, reason: collision with root package name */
    public final View f74726f;

    /* renamed from: g, reason: collision with root package name */
    public final SpeechRecognizerVolumeCircleView f74727g;

    private b(FrameLayout frameLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view, SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView) {
        this.f74721a = frameLayout;
        this.f74722b = appCompatImageView;
        this.f74723c = frameLayout2;
        this.f74724d = appCompatTextView;
        this.f74725e = appCompatTextView2;
        this.f74726f = view;
        this.f74727g = speechRecognizerVolumeCircleView;
    }

    public static b a(View view) {
        View a11;
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.llTop;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.tvResult;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tvTip;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null && (a11 = g4.b.a(view, (i11 = R$id.viewBg))) != null) {
                        i11 = R$id.volumeCircleView;
                        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView = (SpeechRecognizerVolumeCircleView) g4.b.a(view, i11);
                        if (speechRecognizerVolumeCircleView != null) {
                            return new b((FrameLayout) view, appCompatImageView, frameLayout, appCompatTextView, appCompatTextView2, a11, speechRecognizerVolumeCircleView);
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
        return this.f74721a;
    }
}
