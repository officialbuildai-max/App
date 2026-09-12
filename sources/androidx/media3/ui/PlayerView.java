package androidx.media3.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.AttachedSurfaceControl;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SurfaceSyncGroup;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.PlayerView;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class PlayerView extends FrameLayout {
    public static final int ARTWORK_DISPLAY_MODE_FILL = 2;
    public static final int ARTWORK_DISPLAY_MODE_FIT = 1;
    public static final int ARTWORK_DISPLAY_MODE_OFF = 0;
    public static final int IMAGE_DISPLAY_MODE_FILL = 1;
    public static final int IMAGE_DISPLAY_MODE_FIT = 0;
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    private CharSequence A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;

    /* renamed from: a, reason: collision with root package name */
    private final c f13649a;

    /* renamed from: b, reason: collision with root package name */
    private final AspectRatioFrameLayout f13650b;

    /* renamed from: c, reason: collision with root package name */
    private final View f13651c;

    /* renamed from: d, reason: collision with root package name */
    private final View f13652d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f13653e;

    /* renamed from: f, reason: collision with root package name */
    private final f f13654f;

    /* renamed from: g, reason: collision with root package name */
    private final ImageView f13655g;

    /* renamed from: h, reason: collision with root package name */
    private final ImageView f13656h;

    /* renamed from: i, reason: collision with root package name */
    private final SubtitleView f13657i;

    /* renamed from: j, reason: collision with root package name */
    private final View f13658j;

    /* renamed from: k, reason: collision with root package name */
    private final TextView f13659k;

    /* renamed from: l, reason: collision with root package name */
    private final PlayerControlView f13660l;

    /* renamed from: m, reason: collision with root package name */
    private final FrameLayout f13661m;

    /* renamed from: n, reason: collision with root package name */
    private final FrameLayout f13662n;

    /* renamed from: o, reason: collision with root package name */
    private final Handler f13663o;

    /* renamed from: p, reason: collision with root package name */
    private final Class f13664p;

    /* renamed from: q, reason: collision with root package name */
    private final Method f13665q;

    /* renamed from: r, reason: collision with root package name */
    private final Object f13666r;

    /* renamed from: s, reason: collision with root package name */
    private androidx.media3.common.a0 f13667s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f13668t;

    /* renamed from: u, reason: collision with root package name */
    private PlayerControlView.m f13669u;

    /* renamed from: v, reason: collision with root package name */
    private int f13670v;

    /* renamed from: w, reason: collision with root package name */
    private int f13671w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f13672x;

    /* renamed from: y, reason: collision with root package name */
    private int f13673y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f13674z;

    /* loaded from: classes2.dex */
    private static class b {
        public static void a(SurfaceView surfaceView) {
            surfaceView.setSurfaceLifecycle(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class c implements a0.d, View.OnClickListener, PlayerControlView.m, PlayerControlView.d {

        /* renamed from: a, reason: collision with root package name */
        private final e0.b f13675a = new e0.b();

        /* renamed from: b, reason: collision with root package name */
        private Object f13676b;

        public c() {
        }

        @Override // androidx.media3.ui.PlayerControlView.m
        public void l(int i11) {
            PlayerView.this.X();
            PlayerView.o(PlayerView.this);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onAudioSessionIdChanged(int i11) {
            androidx.media3.common.b0.b(this, i11);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onAvailableCommandsChanged(a0.b bVar) {
            androidx.media3.common.b0.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView.this.U();
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onCues(List list) {
            androidx.media3.common.b0.d(this, list);
        }

        @Override // androidx.media3.common.a0.d
        public void onCues(u1.b bVar) {
            if (PlayerView.this.f13657i != null) {
                PlayerView.this.f13657i.setCues(bVar.f76718a);
            }
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onDeviceInfoChanged(androidx.media3.common.m mVar) {
            androidx.media3.common.b0.f(this, mVar);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z10) {
            androidx.media3.common.b0.g(this, i11, z10);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onEvents(androidx.media3.common.a0 a0Var, a0.c cVar) {
            androidx.media3.common.b0.h(this, a0Var, cVar);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            androidx.media3.common.b0.i(this, z10);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onIsPlayingChanged(boolean z10) {
            androidx.media3.common.b0.j(this, z10);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            androidx.media3.common.b0.k(this, z10);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onMediaItemTransition(androidx.media3.common.t tVar, int i11) {
            androidx.media3.common.b0.m(this, tVar, i11);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onMediaMetadataChanged(androidx.media3.common.v vVar) {
            androidx.media3.common.b0.n(this, vVar);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onMetadata(androidx.media3.common.x xVar) {
            androidx.media3.common.b0.o(this, xVar);
        }

        @Override // androidx.media3.common.a0.d
        public void onPlayWhenReadyChanged(boolean z10, int i11) {
            PlayerView.this.W();
            PlayerView.this.Y();
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onPlaybackParametersChanged(androidx.media3.common.z zVar) {
            androidx.media3.common.b0.q(this, zVar);
        }

        @Override // androidx.media3.common.a0.d
        public void onPlaybackStateChanged(int i11) {
            PlayerView.this.W();
            PlayerView.this.Z();
            PlayerView.this.Y();
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            androidx.media3.common.b0.s(this, i11);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            androidx.media3.common.b0.t(this, playbackException);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            androidx.media3.common.b0.u(this, playbackException);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i11) {
            androidx.media3.common.b0.v(this, z10, i11);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onPositionDiscontinuity(int i11) {
            androidx.media3.common.b0.x(this, i11);
        }

        @Override // androidx.media3.common.a0.d
        public void onPositionDiscontinuity(a0.e eVar, a0.e eVar2, int i11) {
            if (PlayerView.this.I() && PlayerView.this.D) {
                PlayerView.this.hideController();
            }
        }

        @Override // androidx.media3.common.a0.d
        public void onRenderedFirstFrame() {
            if (PlayerView.this.f13651c != null) {
                PlayerView.this.f13651c.setVisibility(4);
                if (PlayerView.this.B()) {
                    PlayerView.this.F();
                } else {
                    PlayerView.this.D();
                }
            }
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onRepeatModeChanged(int i11) {
            androidx.media3.common.b0.A(this, i11);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            androidx.media3.common.b0.D(this, z10);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
            androidx.media3.common.b0.E(this, z10);
        }

        @Override // androidx.media3.common.a0.d
        public void onSurfaceSizeChanged(int i11, int i12) {
            if (androidx.media3.common.util.a1.f10432a == 34 && (PlayerView.this.f13652d instanceof SurfaceView) && PlayerView.this.F) {
                f fVar = (f) androidx.media3.common.util.a.e(PlayerView.this.f13654f);
                Handler handler = PlayerView.this.f13663o;
                SurfaceView surfaceView = (SurfaceView) PlayerView.this.f13652d;
                final PlayerView playerView = PlayerView.this;
                fVar.f(handler, surfaceView, new Runnable() { // from class: androidx.media3.ui.i0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlayerView.this.invalidate();
                    }
                });
            }
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onTimelineChanged(androidx.media3.common.e0 e0Var, int i11) {
            androidx.media3.common.b0.G(this, e0Var, i11);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onTrackSelectionParametersChanged(androidx.media3.common.h0 h0Var) {
            androidx.media3.common.b0.H(this, h0Var);
        }

        @Override // androidx.media3.common.a0.d
        public void onTracksChanged(androidx.media3.common.i0 i0Var) {
            androidx.media3.common.a0 a0Var = (androidx.media3.common.a0) androidx.media3.common.util.a.e(PlayerView.this.f13667s);
            androidx.media3.common.e0 currentTimeline = a0Var.h(17) ? a0Var.getCurrentTimeline() : androidx.media3.common.e0.f10007a;
            if (currentTimeline.q()) {
                this.f13676b = null;
            } else if (!a0Var.h(30) || a0Var.getCurrentTracks().b()) {
                Object obj = this.f13676b;
                if (obj != null) {
                    int b11 = currentTimeline.b(obj);
                    if (b11 != -1) {
                        if (a0Var.t() == currentTimeline.f(b11, this.f13675a).f10018c) {
                            return;
                        }
                    }
                    this.f13676b = null;
                }
            } else {
                this.f13676b = currentTimeline.g(a0Var.getCurrentPeriodIndex(), this.f13675a, true).f10017b;
            }
            PlayerView.this.a0(false);
        }

        @Override // androidx.media3.common.a0.d
        public void onVideoSizeChanged(androidx.media3.common.m0 m0Var) {
            if (m0Var.equals(androidx.media3.common.m0.f10193e) || PlayerView.this.f13667s == null || PlayerView.this.f13667s.getPlaybackState() == 1) {
                return;
            }
            PlayerView.this.V();
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onVolumeChanged(float f11) {
            androidx.media3.common.b0.K(this, f11);
        }

        @Override // androidx.media3.ui.PlayerControlView.d
        public void q(boolean z10) {
            PlayerView.p(PlayerView.this);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
    }

    /* loaded from: classes2.dex */
    public interface e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        SurfaceSyncGroup f13678a;

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(SurfaceView surfaceView, Runnable runnable) {
            AttachedSurfaceControl rootSurfaceControl;
            boolean add;
            rootSurfaceControl = surfaceView.getRootSurfaceControl();
            if (rootSurfaceControl == null) {
                return;
            }
            SurfaceSyncGroup a11 = j0.a("exo-sync-b-334901521");
            this.f13678a = a11;
            add = a11.add(rootSurfaceControl, new Runnable() { // from class: androidx.media3.ui.q0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerView.f.c();
                }
            });
            androidx.media3.common.util.a.g(add);
            runnable.run();
            rootSurfaceControl.applyTransactionOnDraw(k0.a());
        }

        public void e() {
            SurfaceSyncGroup surfaceSyncGroup = this.f13678a;
            if (surfaceSyncGroup != null) {
                surfaceSyncGroup.markSyncReady();
                this.f13678a = null;
            }
        }

        public void f(Handler handler, final SurfaceView surfaceView, final Runnable runnable) {
            handler.post(new Runnable() { // from class: androidx.media3.ui.p0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerView.f.this.d(surfaceView, runnable);
                }
            });
        }
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int i12;
        int i13;
        boolean z10;
        int i14;
        boolean z11;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z12;
        int i19;
        boolean z13;
        int i20;
        boolean z14;
        boolean z15;
        a aVar;
        boolean z16;
        Class<ExoPlayer> cls;
        Object obj;
        Method method;
        int i21;
        boolean z17;
        c cVar = new c();
        this.f13649a = cVar;
        this.f13663o = new Handler(Looper.getMainLooper());
        if (isInEditMode()) {
            this.f13650b = null;
            this.f13651c = null;
            this.f13652d = null;
            this.f13653e = false;
            this.f13654f = null;
            this.f13655g = null;
            this.f13656h = null;
            this.f13657i = null;
            this.f13658j = null;
            this.f13659k = null;
            this.f13660l = null;
            this.f13661m = null;
            this.f13662n = null;
            this.f13664p = null;
            this.f13665q = null;
            this.f13666r = null;
            ImageView imageView = new ImageView(context);
            if (androidx.media3.common.util.a1.f10432a >= 23) {
                A(context, getResources(), imageView);
            } else {
                z(context, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i22 = R$layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PlayerView, i11, 0);
            try {
                boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.PlayerView_shutter_background_color);
                int color = obtainStyledAttributes.getColor(R$styleable.PlayerView_shutter_background_color, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.PlayerView_player_layout_id, i22);
                boolean z18 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_artwork, true);
                int i23 = obtainStyledAttributes.getInt(R$styleable.PlayerView_artwork_display_mode, 1);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.PlayerView_default_artwork, 0);
                int i24 = obtainStyledAttributes.getInt(R$styleable.PlayerView_image_display_mode, 0);
                boolean z19 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_controller, true);
                int i25 = obtainStyledAttributes.getInt(R$styleable.PlayerView_surface_type, 1);
                int i26 = obtainStyledAttributes.getInt(R$styleable.PlayerView_resize_mode, 0);
                i12 = obtainStyledAttributes.getInt(R$styleable.PlayerView_show_timeout, 5000);
                z11 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_on_touch, true);
                z15 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_auto_show, true);
                int integer = obtainStyledAttributes.getInteger(R$styleable.PlayerView_show_buffering, 0);
                this.f13674z = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_keep_content_on_player_reset, this.f13674z);
                boolean z20 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                i16 = integer;
                i14 = i26;
                z10 = z19;
                i15 = i24;
                i20 = i23;
                i19 = color;
                i18 = i25;
                i13 = resourceId;
                z14 = z20;
                z12 = hasValue;
                i17 = resourceId2;
                z13 = z18;
            } catch (Throwable th2) {
                obtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            i12 = 5000;
            i13 = i22;
            z10 = true;
            i14 = 0;
            z11 = true;
            i15 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 1;
            z12 = false;
            i19 = 0;
            z13 = true;
            i20 = 1;
            z14 = true;
            z15 = true;
        }
        LayoutInflater.from(context).inflate(i13, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.f13650b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            Q(aspectRatioFrameLayout, i14);
        }
        View findViewById = findViewById(R$id.exo_shutter);
        this.f13651c = findViewById;
        if (findViewById != null && z12) {
            findViewById.setBackgroundColor(i19);
        }
        if (aspectRatioFrameLayout == null || i18 == 0) {
            aVar = null;
            this.f13652d = null;
            z16 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i18 == 2) {
                this.f13652d = new TextureView(context);
            } else if (i18 == 3) {
                try {
                    int i27 = SphericalGLSurfaceView.f13303m;
                    this.f13652d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    z17 = true;
                    this.f13652d.setLayoutParams(layoutParams);
                    this.f13652d.setOnClickListener(cVar);
                    this.f13652d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f13652d, 0);
                    z16 = z17;
                    aVar = null;
                } catch (Exception e11) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e11);
                }
            } else if (i18 != 4) {
                SurfaceView surfaceView = new SurfaceView(context);
                if (androidx.media3.common.util.a1.f10432a >= 34) {
                    b.a(surfaceView);
                }
                this.f13652d = surfaceView;
            } else {
                try {
                    int i28 = VideoDecoderGLSurfaceView.f13138b;
                    this.f13652d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e12) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e12);
                }
            }
            z17 = false;
            this.f13652d.setLayoutParams(layoutParams);
            this.f13652d.setOnClickListener(cVar);
            this.f13652d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f13652d, 0);
            z16 = z17;
            aVar = null;
        }
        this.f13653e = z16;
        this.f13654f = androidx.media3.common.util.a1.f10432a == 34 ? new f() : null;
        this.f13661m = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f13662n = (FrameLayout) findViewById(R$id.exo_overlay);
        this.f13655g = (ImageView) findViewById(R$id.exo_image);
        this.f13671w = i15;
        try {
            cls = ExoPlayer.class;
            ImageOutput imageOutput = ImageOutput.f12112a;
            method = cls.getMethod("setImageOutput", ImageOutput.class);
            obj = Proxy.newProxyInstance(ImageOutput.class.getClassLoader(), new Class[]{ImageOutput.class}, new InvocationHandler() { // from class: androidx.media3.ui.f0
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj2, Method method2, Object[] objArr) {
                    Object J;
                    J = PlayerView.this.J(obj2, method2, objArr);
                    return J;
                }
            });
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            obj = null;
            method = null;
        }
        this.f13664p = cls;
        this.f13665q = method;
        this.f13666r = obj;
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f13656h = imageView2;
        this.f13670v = (!z13 || i20 == 0 || imageView2 == null) ? 0 : i20;
        if (i17 != 0) {
            this.f13672x = androidx.core.content.b.getDrawable(getContext(), i17);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f13657i = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View findViewById2 = findViewById(R$id.exo_buffering);
        this.f13658j = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f13673y = i16;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f13659k = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(R$id.exo_controller);
        View findViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f13660l = playerControlView;
            i21 = 0;
        } else if (findViewById3 != null) {
            i21 = 0;
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f13660l = playerControlView2;
            playerControlView2.setId(R$id.exo_controller);
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(playerControlView2, indexOfChild);
        } else {
            i21 = 0;
            this.f13660l = null;
        }
        PlayerControlView playerControlView3 = this.f13660l;
        this.B = playerControlView3 != null ? i12 : i21;
        this.E = z11;
        this.C = z15;
        this.D = z14;
        this.f13668t = (!z10 || playerControlView3 == null) ? i21 : 1;
        if (playerControlView3 != null) {
            playerControlView3.hideImmediately();
            this.f13660l.addVisibilityListener(this.f13649a);
        }
        if (z10) {
            setClickable(true);
        }
        X();
    }

    private static void A(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        androidx.media3.common.a0 a0Var = this.f13667s;
        return a0Var != null && this.f13666r != null && a0Var.h(30) && a0Var.getCurrentTracks().c(4);
    }

    private boolean C() {
        androidx.media3.common.a0 a0Var = this.f13667s;
        return a0Var != null && a0Var.h(30) && a0Var.getCurrentTracks().c(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        F();
        ImageView imageView = this.f13655g;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
        }
    }

    private void E() {
        ImageView imageView = this.f13656h;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f13656h.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        ImageView imageView = this.f13655g;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    private boolean G(int i11) {
        return i11 == 19 || i11 == 270 || i11 == 22 || i11 == 271 || i11 == 20 || i11 == 269 || i11 == 21 || i11 == 268 || i11 == 23;
    }

    private boolean H() {
        Drawable drawable;
        ImageView imageView = this.f13655g;
        return (imageView == null || (drawable = imageView.getDrawable()) == null || drawable.getAlpha() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I() {
        androidx.media3.common.a0 a0Var = this.f13667s;
        return a0Var != null && a0Var.h(16) && this.f13667s.isPlayingAd() && this.f13667s.getPlayWhenReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object J(Object obj, Method method, Object[] objArr) {
        if (!method.getName().equals("onImageAvailable")) {
            return null;
        }
        N((Bitmap) objArr[1]);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(Bitmap bitmap) {
        setImage(new BitmapDrawable(getResources(), bitmap));
        if (C()) {
            return;
        }
        T();
        y();
    }

    private void L(boolean z10) {
        if (!(I() && this.D) && d0()) {
            boolean z11 = this.f13660l.isFullyVisible() && this.f13660l.getShowTimeoutMs() <= 0;
            boolean R = R();
            if (z10 || z11 || R) {
                S(R);
            }
        }
    }

    private void N(final Bitmap bitmap) {
        this.f13663o.post(new Runnable() { // from class: androidx.media3.ui.g0
            @Override // java.lang.Runnable
            public final void run() {
                PlayerView.this.K(bitmap);
            }
        });
    }

    private boolean O(androidx.media3.common.a0 a0Var) {
        byte[] bArr;
        if (a0Var == null || !a0Var.h(18) || (bArr = a0Var.x().f10595i) == null) {
            return false;
        }
        return P(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    private boolean P(Drawable drawable) {
        if (this.f13656h != null && drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f11 = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.f13670v == 2) {
                    f11 = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                M(this.f13650b, f11);
                this.f13656h.setScaleType(scaleType);
                this.f13656h.setImageDrawable(drawable);
                this.f13656h.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void Q(AspectRatioFrameLayout aspectRatioFrameLayout, int i11) {
        aspectRatioFrameLayout.setResizeMode(i11);
    }

    private boolean R() {
        androidx.media3.common.a0 a0Var = this.f13667s;
        if (a0Var == null) {
            return true;
        }
        int playbackState = a0Var.getPlaybackState();
        return this.C && !(this.f13667s.h(17) && this.f13667s.getCurrentTimeline().q()) && (playbackState == 1 || playbackState == 4 || !((androidx.media3.common.a0) androidx.media3.common.util.a.e(this.f13667s)).getPlayWhenReady());
    }

    private void S(boolean z10) {
        if (d0()) {
            this.f13660l.setShowTimeoutMs(z10 ? 0 : this.B);
            this.f13660l.show();
        }
    }

    private void T() {
        ImageView imageView = this.f13655g;
        if (imageView != null) {
            imageView.setVisibility(0);
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!d0() || this.f13667s == null) {
            return;
        }
        if (!this.f13660l.isFullyVisible()) {
            L(true);
        } else if (this.E) {
            this.f13660l.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        androidx.media3.common.a0 a0Var = this.f13667s;
        androidx.media3.common.m0 p11 = a0Var != null ? a0Var.p() : androidx.media3.common.m0.f10193e;
        int i11 = p11.f10197a;
        int i12 = p11.f10198b;
        M(this.f13650b, this.f13653e ? 0.0f : (i12 == 0 || i11 == 0) ? 0.0f : (i11 * p11.f10200d) / i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r4.f13667s.getPlayWhenReady() == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W() {
        /*
            r4 = this;
            android.view.View r0 = r4.f13658j
            if (r0 == 0) goto L2b
            androidx.media3.common.a0 r0 = r4.f13667s
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.f13673y
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            androidx.media3.common.a0 r0 = r4.f13667s
            boolean r0 = r0.getPlayWhenReady()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = r1
        L21:
            android.view.View r0 = r4.f13658j
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r0.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.W():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        PlayerControlView playerControlView = this.f13660l;
        if (playerControlView == null || !this.f13668t) {
            setContentDescription(null);
        } else if (playerControlView.isFullyVisible()) {
            setContentDescription(this.E ? getResources().getString(R$string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$string.exo_controls_show));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (I() && this.D) {
            hideController();
        } else {
            L(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        TextView textView = this.f13659k;
        if (textView != null) {
            CharSequence charSequence = this.A;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f13659k.setVisibility(0);
            } else {
                androidx.media3.common.a0 a0Var = this.f13667s;
                if (a0Var != null) {
                    a0Var.c();
                }
                this.f13659k.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(boolean z10) {
        androidx.media3.common.a0 a0Var = this.f13667s;
        boolean z11 = false;
        boolean z12 = (a0Var == null || !a0Var.h(30) || a0Var.getCurrentTracks().b()) ? false : true;
        if (!this.f13674z && (!z12 || z10)) {
            E();
            y();
            D();
        }
        if (z12) {
            boolean C = C();
            boolean B = B();
            if (!C && !B) {
                y();
                D();
            }
            View view = this.f13651c;
            if (view != null && view.getVisibility() == 4 && H()) {
                z11 = true;
            }
            if (B && !C && z11) {
                y();
                T();
            } else if (C && !B && z11) {
                D();
            }
            if (C || B || !c0() || !(O(a0Var) || P(this.f13672x))) {
                E();
            }
        }
    }

    private void b0() {
        Drawable drawable;
        ImageView imageView = this.f13655g;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        float f11 = intrinsicWidth / intrinsicHeight;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        if (this.f13671w == 1) {
            f11 = getWidth() / getHeight();
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        if (this.f13655g.getVisibility() == 0) {
            M(this.f13650b, f11);
        }
        this.f13655g.setScaleType(scaleType);
    }

    private boolean c0() {
        if (this.f13670v == 0) {
            return false;
        }
        androidx.media3.common.util.a.i(this.f13656h);
        return true;
    }

    private boolean d0() {
        if (!this.f13668t) {
            return false;
        }
        androidx.media3.common.util.a.i(this.f13660l);
        return true;
    }

    static /* synthetic */ d o(PlayerView playerView) {
        playerView.getClass();
        return null;
    }

    static /* synthetic */ e p(PlayerView playerView) {
        playerView.getClass();
        return null;
    }

    private void setImage(Drawable drawable) {
        ImageView imageView = this.f13655g;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        b0();
    }

    private void setImageOutput(androidx.media3.common.a0 a0Var) {
        Class cls = this.f13664p;
        if (cls == null || !cls.isAssignableFrom(a0Var.getClass())) {
            return;
        }
        try {
            ((Method) androidx.media3.common.util.a.e(this.f13665q)).invoke(a0Var, androidx.media3.common.util.a.e(this.f13666r));
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static void switchTargetView(androidx.media3.common.a0 a0Var, @Nullable PlayerView playerView, @Nullable PlayerView playerView2) {
        if (playerView == playerView2) {
            return;
        }
        if (playerView2 != null) {
            playerView2.setPlayer(a0Var);
        }
        if (playerView != null) {
            playerView.setPlayer(null);
        }
    }

    private void x(androidx.media3.common.a0 a0Var) {
        Class cls = this.f13664p;
        if (cls == null || !cls.isAssignableFrom(a0Var.getClass())) {
            return;
        }
        try {
            ((Method) androidx.media3.common.util.a.e(this.f13665q)).invoke(a0Var, null);
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    private void y() {
        View view = this.f13651c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void z(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color));
    }

    protected void M(AspectRatioFrameLayout aspectRatioFrameLayout, float f11) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f fVar;
        super.dispatchDraw(canvas);
        if (androidx.media3.common.util.a1.f10432a == 34 && (fVar = this.f13654f) != null && this.F) {
            fVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        androidx.media3.common.a0 a0Var = this.f13667s;
        if (a0Var != null && a0Var.h(16) && this.f13667s.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean G = G(keyEvent.getKeyCode());
        if (G && d0() && !this.f13660l.isFullyVisible()) {
            L(true);
            return true;
        }
        if (dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            L(true);
            return true;
        }
        if (G && d0()) {
            L(true);
        }
        return false;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        return d0() && this.f13660l.dispatchMediaKeyEvent(keyEvent);
    }

    public List<androidx.media3.common.a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f13662n;
        if (frameLayout != null) {
            arrayList.add(new a.C0095a(frameLayout, 4).b("Transparent overlay does not impact viewability").a());
        }
        PlayerControlView playerControlView = this.f13660l;
        if (playerControlView != null) {
            arrayList.add(new a.C0095a(playerControlView, 1).a());
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) androidx.media3.common.util.a.j(this.f13661m, "exo_ad_overlay must be present for ad playback");
    }

    public int getArtworkDisplayMode() {
        return this.f13670v;
    }

    public boolean getControllerAutoShow() {
        return this.C;
    }

    public boolean getControllerHideOnTouch() {
        return this.E;
    }

    public int getControllerShowTimeoutMs() {
        return this.B;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f13672x;
    }

    public int getImageDisplayMode() {
        return this.f13671w;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f13662n;
    }

    @Nullable
    public androidx.media3.common.a0 getPlayer() {
        return this.f13667s;
    }

    public int getResizeMode() {
        androidx.media3.common.util.a.i(this.f13650b);
        return this.f13650b.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f13657i;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.f13670v != 0;
    }

    public boolean getUseController() {
        return this.f13668t;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f13652d;
    }

    public void hideController() {
        PlayerControlView playerControlView = this.f13660l;
        if (playerControlView != null) {
            playerControlView.hide();
        }
    }

    public boolean isControllerFullyVisible() {
        PlayerControlView playerControlView = this.f13660l;
        return playerControlView != null && playerControlView.isFullyVisible();
    }

    public void onPause() {
        View view = this.f13652d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.f13652d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!d0() || this.f13667s == null) {
            return false;
        }
        L(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        U();
        return super.performClick();
    }

    public void setArtworkDisplayMode(int i11) {
        androidx.media3.common.util.a.g(i11 == 0 || this.f13656h != null);
        if (this.f13670v != i11) {
            this.f13670v = i11;
            a0(false);
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        androidx.media3.common.util.a.i(this.f13650b);
        this.f13650b.setAspectRatioListener(bVar);
    }

    public void setControllerAnimationEnabled(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setAnimationEnabled(z10);
    }

    public void setControllerAutoShow(boolean z10) {
        this.C = z10;
    }

    public void setControllerHideDuringAds(boolean z10) {
        this.D = z10;
    }

    public void setControllerHideOnTouch(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.E = z10;
        X();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(@Nullable PlayerControlView.d dVar) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setOnFullScreenModeChangedListener(dVar);
    }

    public void setControllerShowTimeoutMs(int i11) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.B = i11;
        if (this.f13660l.isFullyVisible()) {
            showController();
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(@Nullable PlayerControlView.m mVar) {
        androidx.media3.common.util.a.i(this.f13660l);
        PlayerControlView.m mVar2 = this.f13669u;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            this.f13660l.removeVisibilityListener(mVar2);
        }
        this.f13669u = mVar;
        if (mVar != null) {
            this.f13660l.addVisibilityListener(mVar);
            setControllerVisibilityListener((d) null);
        }
    }

    public void setControllerVisibilityListener(@Nullable d dVar) {
        if (dVar != null) {
            setControllerVisibilityListener((PlayerControlView.m) null);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        androidx.media3.common.util.a.g(this.f13659k != null);
        this.A = charSequence;
        Z();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f13672x != drawable) {
            this.f13672x = drawable;
            a0(false);
        }
    }

    public void setEnableComposeSurfaceSyncWorkaround(boolean z10) {
        this.F = z10;
    }

    public void setErrorMessageProvider(@Nullable androidx.media3.common.n nVar) {
        if (nVar != null) {
            Z();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setFullscreenButtonClickListener(@Nullable e eVar) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setOnFullScreenModeChangedListener(this.f13649a);
    }

    public void setFullscreenButtonState(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.updateIsFullscreen(z10);
    }

    public void setImageDisplayMode(int i11) {
        androidx.media3.common.util.a.g(this.f13655g != null);
        if (this.f13671w != i11) {
            this.f13671w = i11;
            b0();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z10) {
        if (this.f13674z != z10) {
            this.f13674z = z10;
            a0(false);
        }
    }

    public void setPlayer(@Nullable androidx.media3.common.a0 a0Var) {
        androidx.media3.common.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        androidx.media3.common.util.a.a(a0Var == null || a0Var.k() == Looper.getMainLooper());
        androidx.media3.common.a0 a0Var2 = this.f13667s;
        if (a0Var2 == a0Var) {
            return;
        }
        if (a0Var2 != null) {
            a0Var2.L(this.f13649a);
            if (a0Var2.h(27)) {
                View view = this.f13652d;
                if (view instanceof TextureView) {
                    a0Var2.clearVideoTextureView((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    a0Var2.clearVideoSurfaceView((SurfaceView) view);
                }
            }
            x(a0Var2);
        }
        SubtitleView subtitleView = this.f13657i;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f13667s = a0Var;
        if (d0()) {
            this.f13660l.setPlayer(a0Var);
        }
        W();
        Z();
        a0(true);
        if (a0Var == null) {
            hideController();
            return;
        }
        if (a0Var.h(27)) {
            View view2 = this.f13652d;
            if (view2 instanceof TextureView) {
                a0Var.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                a0Var.setVideoSurfaceView((SurfaceView) view2);
            }
            if (!a0Var.h(30) || a0Var.getCurrentTracks().d(2)) {
                V();
            }
        }
        if (this.f13657i != null && a0Var.h(28)) {
            this.f13657i.setCues(a0Var.K().f76718a);
        }
        a0Var.M(this.f13649a);
        setImageOutput(a0Var);
        L(false);
    }

    public void setRepeatToggleModes(int i11) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setRepeatToggleModes(i11);
    }

    public void setResizeMode(int i11) {
        androidx.media3.common.util.a.i(this.f13650b);
        this.f13650b.setResizeMode(i11);
    }

    public void setShowBuffering(int i11) {
        if (this.f13673y != i11) {
            this.f13673y = i11;
            W();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowFastForwardButton(z10);
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowMultiWindowTimeBar(z10);
    }

    public void setShowNextButton(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowNextButton(z10);
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowPlayButtonIfPlaybackIsSuppressed(z10);
    }

    public void setShowPreviousButton(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowPreviousButton(z10);
    }

    public void setShowRewindButton(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowRewindButton(z10);
    }

    public void setShowShuffleButton(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowShuffleButton(z10);
    }

    public void setShowSubtitleButton(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowSubtitleButton(z10);
    }

    public void setShowVrButton(boolean z10) {
        androidx.media3.common.util.a.i(this.f13660l);
        this.f13660l.setShowVrButton(z10);
    }

    public void setShutterBackgroundColor(int i11) {
        View view = this.f13651c;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    @Deprecated
    public void setUseArtwork(boolean z10) {
        setArtworkDisplayMode(!z10 ? 1 : 0);
    }

    public void setUseController(boolean z10) {
        boolean z11 = true;
        androidx.media3.common.util.a.g((z10 && this.f13660l == null) ? false : true);
        if (!z10 && !hasOnClickListeners()) {
            z11 = false;
        }
        setClickable(z11);
        if (this.f13668t == z10) {
            return;
        }
        this.f13668t = z10;
        if (d0()) {
            this.f13660l.setPlayer(this.f13667s);
        } else {
            PlayerControlView playerControlView = this.f13660l;
            if (playerControlView != null) {
                playerControlView.hide();
                this.f13660l.setPlayer(null);
            }
        }
        X();
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        View view = this.f13652d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i11);
        }
    }

    public void showController() {
        S(R());
    }
}
