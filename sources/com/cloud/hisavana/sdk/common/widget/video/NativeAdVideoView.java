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
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.common.widget.video.AdVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.f4;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.hisavana.sdk.q4;

/* loaded from: classes3.dex */
public class NativeAdVideoView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private AdVideoView f22364a;

    /* renamed from: b, reason: collision with root package name */
    private final ImageView f22365b;

    /* renamed from: c, reason: collision with root package name */
    private final ImageView f22366c;

    /* renamed from: d, reason: collision with root package name */
    private final ProgressBar f22367d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22368e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22369f;

    /* renamed from: g, reason: collision with root package name */
    private q4 f22370g;

    /* renamed from: h, reason: collision with root package name */
    private AdsDTO f22371h;

    /* renamed from: i, reason: collision with root package name */
    private String f22372i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f22373j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f22374k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements AdVideoView.d {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.common.widget.video.AdVideoView.d
        public void a() {
            if (NativeAdVideoView.this.f22364a != null) {
                NativeAdVideoView.this.f22364a.releasePlayer();
            }
        }

        @Override // com.cloud.hisavana.sdk.common.widget.video.AdVideoView.d
        public void b() {
            if (NativeAdVideoView.this.f22364a == null || NativeAdVideoView.this.f22371h == null || NativeAdVideoView.this.f22372i == null) {
                return;
            }
            e4.b().d("NativeAdVideoView", "onOnScreen rebuild videoPlayer path=" + NativeAdVideoView.this.f22372i);
            NativeAdVideoView.this.f22364a.setMediaData(NativeAdVideoView.this.f22371h, NativeAdVideoView.this.f22372i, NativeAdVideoView.this.f22373j, NativeAdVideoView.this.f22374k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements q4 {
        b() {
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void a(C1016p c1016p) {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.a(c1016p);
            }
            NativeAdVideoView.this.f22366c.setVisibility(0);
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void b() {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.b();
            }
            if (NativeAdVideoView.this.f22365b.getVisibility() == 8) {
                NativeAdVideoView.this.f22365b.setVisibility(0);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void c(long j11, long j12, int i11) {
            NativeAdVideoView.this.f22367d.setProgress(i11);
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.c(j11, j12, i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void d(boolean z10) {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.d(z10);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void e() {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.e();
            }
            if (NativeAdVideoView.this.f22368e && NativeAdVideoView.this.f22367d.getVisibility() == 8) {
                NativeAdVideoView.this.f22367d.setVisibility(0);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void f(boolean z10) {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.f(z10);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void onComplete() {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.onComplete();
            }
            if (NativeAdVideoView.this.f22369f) {
                if (NativeAdVideoView.this.f22364a != null) {
                    NativeAdVideoView.this.f22364a.repeat();
                }
            } else if (NativeAdVideoView.this.f22364a != null) {
                NativeAdVideoView.this.f22364a.setCompanionViewVisibility(0);
            }
            if (NativeAdVideoView.this.f22368e && !NativeAdVideoView.this.f22369f) {
                if (NativeAdVideoView.this.f22365b.getVisibility() == 0) {
                    NativeAdVideoView.this.f22365b.setVisibility(8);
                }
                NativeAdVideoView.this.f22366c.setVisibility(0);
                if (NativeAdVideoView.this.f22367d.getVisibility() == 0) {
                    NativeAdVideoView.this.f22367d.setVisibility(8);
                }
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void onIsPlayingChanged(boolean z10) {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.onIsPlayingChanged(z10);
            }
            if (NativeAdVideoView.this.f22368e && z10) {
                NativeAdVideoView.this.f22366c.setVisibility(8);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void onVideoSizeChanged(int i11, int i12) {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.onVideoSizeChanged(i11, i12);
            }
        }

        @Override // com.cloud.hisavana.sdk.q4
        public void onVolumeChanged(float f11) {
            if (NativeAdVideoView.this.f22370g != null) {
                NativeAdVideoView.this.f22370g.onVolumeChanged(f11);
            }
            if (NativeAdVideoView.this.f22368e) {
                if (f11 == 0.0f) {
                    NativeAdVideoView.this.f22365b.setImageResource(R$drawable.hisavana_volume_close);
                } else {
                    NativeAdVideoView.this.f22365b.setImageResource(R$drawable.hisavana_volume_open);
                }
            }
        }
    }

    public NativeAdVideoView(@NonNull Context context) {
        this(context, null);
    }

    public NativeAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f22368e = true;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_native_ad_video_view, (ViewGroup) this, false);
        removeAllViews();
        addView(inflate);
        this.f22364a = (AdVideoView) inflate.findViewById(R$id.ad_video);
        this.f22365b = (ImageView) inflate.findViewById(R$id.im_volume);
        this.f22366c = (ImageView) inflate.findViewById(R$id.im_repeat);
        this.f22367d = (ProgressBar) inflate.findViewById(R$id.ad_progress);
        m();
        l();
    }

    private void l() {
        AdVideoView adVideoView = this.f22364a;
        if (adVideoView == null) {
            return;
        }
        adVideoView.setListModeVisibilityCallback(new a());
        this.f22364a.setAdMediaPlayerListener(new b());
    }

    protected void m() {
        this.f22365b.setOnClickListener(this);
        this.f22366c.setOnClickListener(this);
        this.f22366c.setVisibility(8);
        this.f22365b.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdVideoView adVideoView;
        if (view.getId() == R$id.im_repeat) {
            if (this.f22364a == null || !NetStateManager.checkNetworkState(false)) {
                return;
            }
            this.f22364a.repeat();
            return;
        }
        if (view.getId() != R$id.im_volume || (adVideoView = this.f22364a) == null) {
            return;
        }
        adVideoView.openOrCloseVolume();
    }

    public void pause() {
        AdVideoView adVideoView = this.f22364a;
        if (adVideoView != null) {
            adVideoView.pause();
        }
    }

    public void play() {
        AdVideoView adVideoView = this.f22364a;
        if (adVideoView != null) {
            adVideoView.play();
        }
    }

    public void release() {
        AdVideoView adVideoView = this.f22364a;
        if (adVideoView != null) {
            adVideoView.setAdMediaPlayerListener(null);
            this.f22364a.setListModeVisibilityCallback(null);
            this.f22364a.release();
            this.f22364a.removeAllViews();
            removeView(this.f22364a);
            this.f22364a = null;
        }
        this.f22371h = null;
        this.f22372i = null;
        this.f22373j = false;
        this.f22374k = false;
        q4 q4Var = this.f22370g;
        if (q4Var instanceof f4) {
            ((f4) q4Var).j();
        }
        this.f22370g = null;
    }

    public void setAdMediaPlayerListener(q4 q4Var) {
        this.f22370g = q4Var;
    }

    public void setAutoReset(boolean z10) {
        this.f22369f = z10;
    }

    public void setCompanionSize(String str) {
        AdVideoView adVideoView = this.f22364a;
        if (adVideoView != null) {
            adVideoView.setCompanionSize(str);
        }
    }

    public void setMediaData(String str, AdsDTO adsDTO, boolean z10) {
        e4.b().d("NativeAdVideoView", "setMediaData -------------> path = " + str);
        if (this.f22364a != null) {
            boolean r11 = a7.c.r();
            this.f22371h = adsDTO;
            this.f22372i = str;
            this.f22373j = r11;
            this.f22374k = z10;
            this.f22364a.setMediaData(adsDTO, str, r11, z10);
        }
    }

    public void setPlayWhenReady(boolean z10) {
        AdVideoView adVideoView = this.f22364a;
        if (adVideoView != null) {
            adVideoView.setPlayWhenReady(z10);
        }
    }

    public void setShowComponents(boolean z10) {
        this.f22368e = z10;
    }

    public void setUseListMode(boolean z10) {
        AdVideoView adVideoView = this.f22364a;
        if (adVideoView != null) {
            adVideoView.setUseListMode(z10);
        }
    }
}
