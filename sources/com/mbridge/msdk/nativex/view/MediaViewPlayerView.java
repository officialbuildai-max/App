package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.VideoNativePlayer;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.videocommon.view.MyImageView;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes5.dex */
public class MediaViewPlayerView extends LinearLayout implements VideoPlayerStatusListener {
    private static Handler L = new Handler();
    private String A;
    private String B;
    private CampaignEx C;
    private com.mbridge.msdk.nativex.listener.a D;
    private Timer E;
    private com.mbridge.msdk.videocommon.download.a F;
    private VideoNativePlayer G;
    private h H;
    private com.iab.omid.library.mmadbridge.adsession.b I;
    private com.iab.omid.library.mmadbridge.adsession.media.a J;
    private boolean K;

    /* renamed from: a, reason: collision with root package name */
    private boolean f36714a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f36715b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f36716c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f36717d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f36718e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f36719f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f36720g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f36721h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f36722i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f36723j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36724k;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f36725l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f36726m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f36727n;

    /* renamed from: o, reason: collision with root package name */
    private TextureView f36728o;

    /* renamed from: p, reason: collision with root package name */
    private LinearLayout f36729p;

    /* renamed from: q, reason: collision with root package name */
    private Surface f36730q;

    /* renamed from: r, reason: collision with root package name */
    private ProgressBar f36731r;

    /* renamed from: s, reason: collision with root package name */
    private MyImageView f36732s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView f36733t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f36734u;

    /* renamed from: v, reason: collision with root package name */
    private ImageView f36735v;

    /* renamed from: w, reason: collision with root package name */
    private ImageView f36736w;

    /* renamed from: x, reason: collision with root package name */
    private View f36737x;

    /* renamed from: y, reason: collision with root package name */
    private AnimationDrawable f36738y;

    /* renamed from: z, reason: collision with root package name */
    private AlphaAnimation f36739z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (MediaViewPlayerView.this.f36724k) {
                    MediaViewPlayerView.this.closeSound();
                    if (MediaViewPlayerView.this.D != null) {
                        MediaViewPlayerView.this.D.b();
                    }
                } else {
                    MediaViewPlayerView.this.openSound();
                    if (MediaViewPlayerView.this.D != null) {
                        MediaViewPlayerView.this.D.a();
                    }
                }
            } catch (Throwable th2) {
                o0.b("MediaViewPlayerView", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                MediaViewPlayerView.this.pause();
                MediaViewPlayerView.this.f36733t.setVisibility(0);
                MediaViewPlayerView.this.n();
                MediaViewPlayerView.this.c();
                if (MediaViewPlayerView.this.D != null) {
                    MediaViewPlayerView.this.D.c();
                }
                MediaViewPlayerView.this.f36718e = true;
            } catch (Throwable th2) {
                o0.b("MediaViewPlayerView", th2.getMessage(), th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaViewPlayerView.this.onClickPlayButton();
        }
    }

    /* loaded from: classes5.dex */
    class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            MediaViewPlayerView.this.f36734u.setVisibility(0);
            MediaViewPlayerView.this.p();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MediaViewPlayerView.this.c();
                MediaViewPlayerView.this.f();
            } catch (Exception e11) {
                o0.b("MediaViewPlayerView", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements com.mbridge.msdk.foundation.same.image.c {
        f() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (MediaViewPlayerView.this.f36732s == null || bitmap == null) {
                return;
            }
            MediaViewPlayerView.this.f36732s.setImageUrl(str);
            MediaViewPlayerView.this.f36732s.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g extends TimerTask {
        g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                MediaViewPlayerView.this.gonePauseView();
            } catch (Throwable th2) {
                o0.b("MediaViewPlayerView", th2.getMessage(), th2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private MediaViewPlayerView f36747a;

        public h(MediaViewPlayerView mediaViewPlayerView) {
            this.f36747a = mediaViewPlayerView;
        }

        public void a() {
            try {
                MediaViewPlayerView mediaViewPlayerView = this.f36747a;
                if (mediaViewPlayerView == null || mediaViewPlayerView.f36723j) {
                    return;
                }
                o0.c("MediaViewPlayerView", "play end and display endcardView");
                this.f36747a.m();
            } catch (Exception e11) {
                o0.b("MediaViewPlayerView", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class i implements TextureView.SurfaceTextureListener {
        private i() {
        }

        /* synthetic */ i(MediaViewPlayerView mediaViewPlayerView, a aVar) {
            this();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            try {
                MediaViewPlayerView.this.f36730q = new Surface(surfaceTexture);
                MediaViewPlayerView.this.f36720g = true;
                MediaViewPlayerView.this.f36722i = true;
                if (MediaViewPlayerView.this.f36717d) {
                    if (MediaViewPlayerView.this.f36721h) {
                        MediaViewPlayerView.this.f36716c = false;
                        MediaViewPlayerView.this.f36721h = false;
                    }
                    if (!MediaViewPlayerView.this.isComplete() && !MediaViewPlayerView.this.f36718e) {
                        MediaViewPlayerView.this.startOrPlayVideo();
                        return;
                    }
                    MediaViewPlayerView.this.m();
                    return;
                }
                if (MediaViewPlayerView.this.f36715b) {
                    if (MediaViewPlayerView.this.hasPrepare() && MediaViewPlayerView.this.isComplete()) {
                        MediaViewPlayerView.this.m();
                        return;
                    }
                    MediaViewPlayerView.this.startOrPlayVideo();
                    return;
                }
                if (MediaViewPlayerView.this.hasPrepare() && !MediaViewPlayerView.this.isComplete()) {
                    MediaViewPlayerView.this.startOrPlayVideo();
                    return;
                }
                MediaViewPlayerView.this.m();
            } catch (Exception e11) {
                o0.b("MediaViewPlayerView", e11.getMessage());
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            try {
                if (MediaViewPlayerView.this.G != null && MediaViewPlayerView.this.G.isPlayIng()) {
                    MediaViewPlayerView.this.pause();
                }
                MediaViewPlayerView.this.f36716c = true;
                MediaViewPlayerView.this.f36720g = false;
            } catch (Throwable th2) {
                o0.b("MediaViewPlayerView", th2.getMessage());
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            o0.c("MediaViewPlayerView", "onSurfaceTextureSizeChanged ");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public MediaViewPlayerView(Context context) {
        super(context);
        this.f36714a = false;
        this.f36715b = false;
        this.f36716c = false;
        this.f36717d = false;
        this.f36718e = false;
        this.f36719f = false;
        this.f36720g = false;
        this.f36721h = true;
        this.f36722i = false;
        this.f36723j = true;
        this.f36724k = false;
        this.f36725l = -1;
        this.f36726m = true;
        this.f36727n = true;
        this.I = null;
        this.J = null;
        this.K = false;
        g();
    }

    public MediaViewPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36714a = false;
        this.f36715b = false;
        this.f36716c = false;
        this.f36717d = false;
        this.f36718e = false;
        this.f36719f = false;
        this.f36720g = false;
        this.f36721h = true;
        this.f36722i = false;
        this.f36723j = true;
        this.f36724k = false;
        this.f36725l = -1;
        this.f36726m = true;
        this.f36727n = true;
        this.I = null;
        this.J = null;
        this.K = false;
        g();
    }

    private void a() {
        try {
            Handler handler = L;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Timer timer = this.E;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    private void a(int i11, int i12) {
        try {
            ProgressBar progressBar = this.f36731r;
            if (progressBar == null || progressBar.getVisibility() != 0) {
                return;
            }
            if (i12 > 0) {
                this.f36731r.setMax(i12);
            }
            if (i11 >= 0) {
                this.f36731r.setProgress(i11 + 1);
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    private void b() {
        try {
            if (URLUtil.isNetworkUrl(this.B)) {
                return;
            }
            String videoUrlEncode = this.C.getVideoUrlEncode();
            if (y0.b(videoUrlEncode)) {
                this.B = videoUrlEncode;
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f36734u.setVisibility(8);
    }

    private void d() {
        if (this.f36736w.getVisibility() == 0) {
            this.f36736w.setVisibility(8);
        }
    }

    private void e() {
        try {
            this.f36732s.setVisibility(8);
            this.f36733t.setVisibility(8);
            f();
            showProgressView(this.f36727n);
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f36733t.getVisibility() != 0) {
            this.f36737x.setVisibility(8);
        }
    }

    private void g() {
        try {
            j();
            i();
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    private String getPlayUrl() {
        CampaignEx campaignEx;
        String str;
        try {
            campaignEx = this.C;
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
        }
        if (campaignEx == null) {
            return null;
        }
        try {
            if (this.F == null) {
                if (campaignEx.getAdType() != 287 && this.C.getAdType() != 94) {
                    str = this.C.getId() + this.C.getVideoUrlEncode() + this.C.getBidToken();
                    this.F = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.A, str);
                }
                str = this.C.getRequestId() + this.C.getId() + this.C.getVideoUrlEncode();
                this.F = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.A, str);
            }
        } catch (Exception e12) {
            o0.b("MediaViewPlayerView", e12.getMessage());
        }
        com.mbridge.msdk.videocommon.download.a aVar = this.F;
        if (aVar != null && aVar.j() == 5) {
            String k11 = this.F.k();
            if (new File(k11).exists()) {
                return k11;
            }
        }
        String videoUrlEncode = this.C.getVideoUrlEncode();
        if (y0.b(videoUrlEncode)) {
            return videoUrlEncode;
        }
        return null;
    }

    private void h() {
        try {
            CampaignEx campaignEx = this.C;
            if (campaignEx == null) {
                return;
            }
            String imageUrl = campaignEx.getImageUrl();
            if (y0.a(imageUrl) || getContext() == null) {
                return;
            }
            if (com.mbridge.msdk.foundation.same.image.b.a(getContext()).c(imageUrl)) {
                Bitmap b11 = com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).b(imageUrl);
                MyImageView myImageView = this.f36732s;
                if (myImageView != null && b11 != null) {
                    myImageView.setImageUrl(imageUrl);
                    this.f36732s.setImageBitmap(b11);
                    this.f36732s.setVisibility(0);
                }
            } else {
                com.mbridge.msdk.foundation.same.image.b.a(getContext()).a(imageUrl, new f());
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    private void i() {
        VideoNativePlayer videoNativePlayer = new VideoNativePlayer();
        this.G = videoNativePlayer;
        videoNativePlayer.setSelfVideoFeedsPlayerListener(this);
    }

    private void j() {
        try {
            a aVar = null;
            View inflate = LayoutInflater.from(getContext()).inflate(g0.a(getContext(), "mbridge_nativex_playerview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
            if (inflate != null) {
                this.f36729p = (LinearLayout) inflate.findViewById(g0.a(getContext(), "mbridge_ll_loading", "id"));
                TextureView textureView = (TextureView) inflate.findViewById(g0.a(getContext(), "mbridge_textureview", "id"));
                this.f36728o = textureView;
                textureView.setKeepScreenOn(true);
                this.f36728o.setSurfaceTextureListener(new i(this, aVar));
                this.f36731r = (ProgressBar) inflate.findViewById(g0.a(getContext(), "mbridge_progress", "id"));
                this.f36732s = (MyImageView) inflate.findViewById(g0.a(getContext(), "mbridge_iv_playend_pic", "id"));
                this.f36733t = (ImageView) inflate.findViewById(g0.a(getContext(), "mbridge_iv_play", "id"));
                this.f36734u = (ImageView) inflate.findViewById(g0.a(getContext(), "mbridge_iv_pause", "id"));
                this.f36735v = (ImageView) inflate.findViewById(g0.a(getContext(), "mbridge_iv_sound", "id"));
                this.f36737x = inflate.findViewById(g0.a(getContext(), "mbridge_view_cover", "id"));
                ImageView imageView = (ImageView) inflate.findViewById(g0.a(getContext(), "mbridge_iv_sound_animation", "id"));
                this.f36736w = imageView;
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
                this.f36738y = animationDrawable;
                animationDrawable.start();
                k();
                addView(inflate, -1, -1);
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    private void k() {
        this.f36735v.setOnClickListener(new a());
        this.f36734u.setOnClickListener(new b());
        this.f36733t.setOnClickListener(new c());
    }

    private void l() {
        ImageView imageView;
        if (this.f36717d || (imageView = this.f36736w) == null || imageView.getVisibility() == 0 || !this.f36726m) {
            return;
        }
        this.f36736w.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            this.f36732s.setVisibility(0);
            this.f36733t.setVisibility(0);
            n();
            c();
            this.f36731r.setVisibility(8);
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f36737x.setVisibility(0);
    }

    private void o() {
        com.iab.omid.library.mmadbridge.adsession.media.a aVar;
        try {
            if (this.G == null) {
                return;
            }
            e();
            if (this.f36722i) {
                this.G.start(this.f36730q);
                this.f36722i = false;
            } else {
                this.G.start();
            }
            if ((this.f36719f || this.f36718e) && (aVar = this.J) != null) {
                this.f36719f = false;
                aVar.l();
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        a();
        this.E = new Timer();
        this.E.schedule(new g(), 2000L);
    }

    public void closeSound() {
        this.f36724k = false;
        try {
            if (this.G != null) {
                this.f36735v.setImageResource(g0.a(getContext(), "mbridge_nativex_sound_close", "drawable"));
                this.G.closeSound();
            }
            try {
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.J;
                if (aVar != null) {
                    aVar.p(0.0f);
                }
            } catch (IllegalArgumentException e11) {
                o0.a("OMSDK", e11.getMessage());
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public boolean curIsFullScreen() {
        return this.f36717d;
    }

    public Campaign getCampaign() {
        return this.C;
    }

    public boolean getIsActiviePause() {
        return this.f36718e;
    }

    public void gonePauseView() {
        Handler handler = L;
        if (handler != null) {
            handler.post(new e());
        }
    }

    public boolean halfLoadingViewisVisible() {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                return videoNativePlayer.loadingViewIsVisible();
            }
            return false;
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
            return false;
        }
    }

    public boolean hasPrepare() {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                return videoNativePlayer.hasPrepare();
            }
            return false;
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
            return false;
        }
    }

    public boolean initPlayerViewData(String str, CampaignEx campaignEx, boolean z10, VideoPlayerStatusListener videoPlayerStatusListener, com.mbridge.msdk.videocommon.download.a aVar, String str2) {
        try {
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
            this.f36714a = false;
        }
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return false;
        }
        this.B = str;
        this.f36715b = z10;
        this.C = campaignEx;
        this.F = aVar;
        this.A = str2;
        this.G.initParameter(campaignEx.getVideoUrlEncode(), true, this.f36723j, this.f36732s, videoPlayerStatusListener);
        h();
        this.f36714a = true;
        return true;
    }

    public boolean isComplete() {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                return videoNativePlayer.isComplete();
            }
            return false;
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
            return false;
        }
    }

    public boolean isPlaying() {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                return videoNativePlayer.isPlaying();
            }
            return false;
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
            return false;
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingEnd() {
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingStart(String str) {
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingTimeOut(String str) {
    }

    public void onClickPlayButton() {
        com.mbridge.msdk.nativex.listener.a aVar;
        try {
            e();
            f();
            setIsComplete(false);
            if (this.f36719f) {
                this.G.play();
            } else if (!hasPrepare() || this.f36716c) {
                o0.c("MediaViewPlayerView", "点击播放 playVideo()");
                this.G.replaySameSource(getContext(), this.B, this.f36730q);
            } else {
                o0.c("MediaViewPlayerView", "startOrPlayVideo() hasPrepare():" + hasPrepare() + " mIsNeedToRepeatPrepare:" + this.f36716c);
                startOrPlayVideo();
            }
            if (this.f36718e && (aVar = this.D) != null) {
                aVar.d();
            }
            this.f36718e = false;
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    public void onClickPlayerView() {
        ImageView imageView;
        try {
            MyImageView myImageView = this.f36732s;
            if ((myImageView == null || myImageView.getVisibility() != 0) && isPlaying() && (imageView = this.f36734u) != null) {
                if (imageView.getVisibility() == 0) {
                    gonePauseView();
                    a();
                    return;
                }
                AlphaAnimation alphaAnimation = this.f36739z;
                if (alphaAnimation != null) {
                    alphaAnimation.cancel();
                }
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                this.f36739z = alphaAnimation2;
                alphaAnimation2.setDuration(300L);
                this.f36739z.setInterpolator(new DecelerateInterpolator());
                this.f36739z.setAnimationListener(new d());
                n();
                this.f36737x.startAnimation(this.f36739z);
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        if (this.D != null && !TextUtils.isEmpty(this.B)) {
            this.D.a(this.B);
        }
        h hVar = this.H;
        if (hVar != null) {
            hVar.a();
            return;
        }
        try {
            if (this.f36723j) {
                return;
            }
            this.f36716c = true;
            m();
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayError(String str) {
        try {
            this.f36716c = true;
            m();
            if (this.K) {
                return;
            }
            this.G.play(getContext(), this.B, this.f36730q);
            this.K = true;
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i11, int i12) {
        try {
            e();
            l();
            this.f36718e = false;
            this.f36716c = false;
            this.f36725l = i11;
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgressMS(int i11, int i12) {
        a(i11, i12);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlaySetDataSourceError(String str) {
        try {
            this.f36716c = true;
            b();
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i11) {
        if (this.D == null || TextUtils.isEmpty(this.B)) {
            return;
        }
        this.D.b(this.B);
    }

    public void openSound() {
        this.f36724k = true;
        try {
            if (this.G != null) {
                this.f36735v.setImageResource(g0.a(getContext(), "mbridge_nativex_sound_open", "drawable"));
                this.G.openSound();
            }
            try {
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.J;
                if (aVar != null) {
                    aVar.p(1.0f);
                }
            } catch (IllegalArgumentException e11) {
                o0.a("OMSDK", e11.getMessage());
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void pause() {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                videoNativePlayer.pause();
                this.f36719f = true;
            }
            if (this.J != null) {
                o0.b("omsdk", "mediaviewplayerview pause");
                this.J.j();
            }
            d();
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void playVideo() {
        com.iab.omid.library.mmadbridge.adsession.media.a aVar;
        try {
            if (this.f36714a && this.G != null) {
                if (!this.f36720g) {
                    m();
                    return;
                }
                if ((!TextUtils.isEmpty(this.B) && this.B.startsWith("http")) || this.B.startsWith("https")) {
                    this.B = getPlayUrl();
                }
                e();
                this.G.play(getContext(), this.B, this.f36730q);
                if ((this.f36719f || this.f36718e) && (aVar = this.J) != null) {
                    this.f36719f = false;
                    aVar.l();
                }
                if (this.f36724k) {
                    this.G.openSound();
                } else {
                    this.G.closeSound();
                }
                this.f36716c = false;
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void registerView(com.iab.omid.library.mmadbridge.adsession.b bVar) {
        this.I = bVar;
        if (bVar != null) {
            bVar.d(this);
            LinearLayout linearLayout = this.f36729p;
            FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
            bVar.a(linearLayout, friendlyObstructionPurpose, null);
            bVar.a(this.f36731r, friendlyObstructionPurpose, null);
            MyImageView myImageView = this.f36732s;
            FriendlyObstructionPurpose friendlyObstructionPurpose2 = FriendlyObstructionPurpose.VIDEO_CONTROLS;
            bVar.a(myImageView, friendlyObstructionPurpose2, null);
            bVar.a(this.f36733t, friendlyObstructionPurpose2, null);
            bVar.a(this.f36734u, friendlyObstructionPurpose2, null);
            bVar.a(this.f36735v, friendlyObstructionPurpose, null);
        }
    }

    public void release() {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                videoNativePlayer.releasePlayer();
                this.G = null;
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void setAllowLoopPlay(boolean z10) {
        this.f36723j = z10;
    }

    public void setEnterFullScreen() {
        try {
            o0.c("MediaViewPlayerView", "setEnterFullScreen");
            this.f36717d = true;
            this.f36721h = true;
            this.f36735v.setVisibility(0);
            d();
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    public void setExitFullScreen() {
        try {
            this.f36717d = false;
            this.f36716c = false;
            this.f36735v.setVisibility(8);
            l();
            e();
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    public void setIsActivePause(boolean z10) {
        this.f36718e = z10;
    }

    public void setIsComplete(boolean z10) {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                videoNativePlayer.setIsComplete(z10);
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void setIsFrontDesk(boolean z10) {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                videoNativePlayer.setIsFrontDesk(z10);
            }
        } catch (Throwable th2) {
            o0.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void setMediaViewPlayListener(h hVar) {
        this.H = hVar;
    }

    public void setOnMediaViewPlayerViewListener(com.mbridge.msdk.nativex.listener.a aVar) {
        this.D = aVar;
    }

    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.J = aVar;
    }

    public void showPlayView() {
        this.f36733t.setVisibility(0);
    }

    public void showProgressView(boolean z10) {
        this.f36727n = z10;
        ProgressBar progressBar = this.f36731r;
        if (progressBar != null) {
            progressBar.setVisibility(z10 ? 0 : 4);
        }
    }

    public void showSoundIndicator(boolean z10) {
        this.f36726m = z10;
        if (z10) {
            l();
        } else {
            d();
        }
    }

    public void startOrPlayVideo() {
        try {
            if (!this.f36720g) {
                m();
            } else if (hasPrepare()) {
                o();
            } else {
                playVideo();
            }
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    public void stop() {
        try {
            VideoNativePlayer videoNativePlayer = this.G;
            if (videoNativePlayer != null) {
                videoNativePlayer.stop();
            }
            d();
        } catch (Exception e11) {
            o0.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    public void unregisterView() {
        com.iab.omid.library.mmadbridge.adsession.b bVar = this.I;
        if (bVar != null) {
            bVar.e();
        }
    }
}
