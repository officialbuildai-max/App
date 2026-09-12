package com.cloud.hisavana.sdk.common.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.C1016p;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.f4;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.hisavana.sdk.q4;

/* loaded from: classes3.dex */
public class InterstitialAdVideoView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f22354a;

    /* renamed from: b, reason: collision with root package name */
    private AdVideoView f22355b;

    /* renamed from: c, reason: collision with root package name */
    private final ImageView f22356c;

    /* renamed from: d, reason: collision with root package name */
    private ProgressBar f22357d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22358e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22359f;

    /* renamed from: g, reason: collision with root package name */
    private q4 f22360g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements q4 {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void a(C1016p c1016p) {
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.a(c1016p);
            }
            InterstitialAdVideoView.this.f22356c.setVisibility(0);
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void b() {
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.b();
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void c(long j11, long j12, int i11) {
            InterstitialAdVideoView.this.f22357d.setProgress(i11);
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.c(j11, j12, i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void d(boolean z10) {
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void e() {
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.e();
            }
            if (InterstitialAdVideoView.this.f22357d.getVisibility() == 8 && InterstitialAdVideoView.this.f22359f) {
                InterstitialAdVideoView.this.f22357d.setVisibility(0);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void f(boolean z10) {
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.f(z10);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void onComplete() {
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.onComplete();
            }
            if (InterstitialAdVideoView.this.f22355b != null && InterstitialAdVideoView.this.f22358e) {
                InterstitialAdVideoView.this.f22355b.repeat();
            }
            if (InterstitialAdVideoView.this.f22357d.getVisibility() == 0) {
                InterstitialAdVideoView.this.f22357d.setVisibility(8);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void onIsPlayingChanged(boolean z10) {
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.onIsPlayingChanged(z10);
            }
            if (z10) {
                InterstitialAdVideoView.this.f22356c.setVisibility(8);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void onVideoSizeChanged(int i11, int i12) {
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.onVideoSizeChanged(i11, i12);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void onVolumeChanged(float f11) {
            if (InterstitialAdVideoView.this.f22360g != null) {
                InterstitialAdVideoView.this.f22360g.onVolumeChanged(f11);
            }
        }
    }

    public InterstitialAdVideoView(@NonNull Context context) {
        this(context, null);
    }

    public InterstitialAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f22354a = "NativeAdVideoView";
        this.f22359f = true;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_interstitial_ad_video_view, (ViewGroup) this, false);
        this.f22356c = (ImageView) inflate.findViewById(R$id.repeat_btn);
        removeAllViews();
        addView(inflate);
        this.f22355b = (AdVideoView) inflate.findViewById(R$id.ad_video);
        this.f22357d = (ProgressBar) inflate.findViewById(R$id.ad_progress);
        i();
    }

    private void i() {
        if (this.f22355b == null) {
            return;
        }
        this.f22356c.setVisibility(8);
        this.f22356c.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.widget.video.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterstitialAdVideoView.this.j(view);
            }
        });
        this.f22355b.setAdMediaPlayerListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        if (this.f22355b == null || !NetStateManager.checkNetworkState(false)) {
            return;
        }
        this.f22355b.repeat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        AdVideoView adVideoView = this.f22355b;
        if (adVideoView != null) {
            adVideoView.openOrCloseVolume();
        }
    }

    public long getDuration() {
        AdVideoView adVideoView = this.f22355b;
        if (adVideoView != null) {
            return adVideoView.getDuration();
        }
        return 0L;
    }

    public void release() {
        AdVideoView adVideoView = this.f22355b;
        if (adVideoView != null) {
            adVideoView.setAdMediaPlayerListener(null);
            this.f22355b.release();
            this.f22355b.removeAllViews();
            removeView(this.f22355b);
            this.f22355b = null;
        }
        q4 q4Var = this.f22360g;
        if (q4Var instanceof f4) {
            ((f4) q4Var).j();
        }
        this.f22360g = null;
    }

    public void seekToPosition(long j11) {
        AdVideoView adVideoView = this.f22355b;
        if (adVideoView != null) {
            adVideoView.seekTo(j11);
        }
    }

    public void setAdMediaPlayerListener(q4 q4Var) {
        this.f22360g = q4Var;
    }

    public void setAutoReset(boolean z10) {
        this.f22358e = z10;
    }

    public void setCompanionSize(String str) {
        AdVideoView adVideoView = this.f22355b;
        if (adVideoView != null) {
            adVideoView.setCompanionSize(str);
        }
    }

    public void setMediaData(String str, AdsDTO adsDTO, boolean z10, boolean z11) {
        e4.b().d("NativeAdVideoView", "setMediaData -------------> path = " + str);
        AdVideoView adVideoView = this.f22355b;
        if (adVideoView != null) {
            adVideoView.setMediaData(adsDTO, str, z10, z11);
        }
    }

    public void setProgressBarVisibility(int i11) {
        ProgressBar progressBar = this.f22357d;
        if (progressBar == null) {
            return;
        }
        this.f22359f = i11 == 0;
        progressBar.setVisibility(i11 != 0 ? 8 : 0);
    }

    public void setVideoSize(int i11, int i12) {
        AdVideoView adVideoView = this.f22355b;
        if (adVideoView != null) {
            adVideoView.setVideoSize(i11, i12);
        }
    }

    public void setVolumeView(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.widget.video.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    InterstitialAdVideoView.this.k(view2);
                }
            });
        }
    }
}
