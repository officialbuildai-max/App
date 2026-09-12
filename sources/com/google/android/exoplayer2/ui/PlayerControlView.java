package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.p3;
import com.google.android.exoplayer2.q2;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ui.n0;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class PlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private final Drawable A;
    private final Drawable B;
    private final float C;
    private final float D;
    private final String E;
    private final String F;
    private o2 G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private long T;
    private long[] U;
    private boolean[] V;
    private long[] W;

    /* renamed from: a, reason: collision with root package name */
    private final c f26967a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean[] f26968a0;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f26969b;

    /* renamed from: b0, reason: collision with root package name */
    private long f26970b0;

    /* renamed from: c, reason: collision with root package name */
    private final View f26971c;

    /* renamed from: c0, reason: collision with root package name */
    private long f26972c0;

    /* renamed from: d, reason: collision with root package name */
    private final View f26973d;

    /* renamed from: d0, reason: collision with root package name */
    private long f26974d0;

    /* renamed from: e, reason: collision with root package name */
    private final View f26975e;

    /* renamed from: f, reason: collision with root package name */
    private final View f26976f;

    /* renamed from: g, reason: collision with root package name */
    private final View f26977g;

    /* renamed from: h, reason: collision with root package name */
    private final View f26978h;

    /* renamed from: i, reason: collision with root package name */
    private final ImageView f26979i;

    /* renamed from: j, reason: collision with root package name */
    private final ImageView f26980j;

    /* renamed from: k, reason: collision with root package name */
    private final View f26981k;

    /* renamed from: l, reason: collision with root package name */
    private final TextView f26982l;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f26983m;

    /* renamed from: n, reason: collision with root package name */
    private final n0 f26984n;

    /* renamed from: o, reason: collision with root package name */
    private final StringBuilder f26985o;

    /* renamed from: p, reason: collision with root package name */
    private final Formatter f26986p;

    /* renamed from: q, reason: collision with root package name */
    private final k3.b f26987q;

    /* renamed from: r, reason: collision with root package name */
    private final k3.d f26988r;

    /* renamed from: s, reason: collision with root package name */
    private final Runnable f26989s;

    /* renamed from: t, reason: collision with root package name */
    private final Runnable f26990t;

    /* renamed from: u, reason: collision with root package name */
    private final Drawable f26991u;

    /* renamed from: v, reason: collision with root package name */
    private final Drawable f26992v;

    /* renamed from: w, reason: collision with root package name */
    private final Drawable f26993w;

    /* renamed from: x, reason: collision with root package name */
    private final String f26994x;

    /* renamed from: y, reason: collision with root package name */
    private final String f26995y;

    /* renamed from: z, reason: collision with root package name */
    private final String f26996z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* loaded from: classes3.dex */
    private final class c implements o2.d, n0.a, View.OnClickListener {
        private c() {
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void l(n0 n0Var, long j11) {
            if (PlayerControlView.this.f26983m != null) {
                PlayerControlView.this.f26983m.setText(com.google.android.exoplayer2.util.p0.h0(PlayerControlView.this.f26985o, PlayerControlView.this.f26986p, j11));
            }
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onAvailableCommandsChanged(o2.b bVar) {
            q2.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o2 o2Var = PlayerControlView.this.G;
            if (o2Var == null) {
                return;
            }
            if (PlayerControlView.this.f26973d == view) {
                o2Var.m();
                return;
            }
            if (PlayerControlView.this.f26971c == view) {
                o2Var.f();
                return;
            }
            if (PlayerControlView.this.f26977g == view) {
                if (o2Var.getPlaybackState() != 4) {
                    o2Var.v();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f26978h == view) {
                o2Var.w();
                return;
            }
            if (PlayerControlView.this.f26975e == view) {
                PlayerControlView.this.A(o2Var);
                return;
            }
            if (PlayerControlView.this.f26976f == view) {
                PlayerControlView.this.z(o2Var);
            } else if (PlayerControlView.this.f26979i == view) {
                o2Var.setRepeatMode(com.google.android.exoplayer2.util.f0.a(o2Var.getRepeatMode(), PlayerControlView.this.N));
            } else if (PlayerControlView.this.f26980j == view) {
                o2Var.setShuffleModeEnabled(!o2Var.getShuffleModeEnabled());
            }
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onCues(ba.f fVar) {
            q2.d(this, fVar);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onCues(List list) {
            q2.e(this, list);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onDeviceInfoChanged(com.google.android.exoplayer2.r rVar) {
            q2.f(this, rVar);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z10) {
            q2.g(this, i11, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public void onEvents(o2 o2Var, o2.c cVar) {
            if (cVar.b(4, 5)) {
                PlayerControlView.this.N();
            }
            if (cVar.b(4, 5, 7)) {
                PlayerControlView.this.O();
            }
            if (cVar.a(8)) {
                PlayerControlView.this.P();
            }
            if (cVar.a(9)) {
                PlayerControlView.this.Q();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                PlayerControlView.this.M();
            }
            if (cVar.b(11, 0)) {
                PlayerControlView.this.R();
            }
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            q2.i(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onIsPlayingChanged(boolean z10) {
            q2.j(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            q2.k(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onMediaItemTransition(v1 v1Var, int i11) {
            q2.m(this, v1Var, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onMediaMetadataChanged(a2 a2Var) {
            q2.n(this, a2Var);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onMetadata(Metadata metadata) {
            q2.o(this, metadata);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i11) {
            q2.p(this, z10, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlaybackParametersChanged(n2 n2Var) {
            q2.q(this, n2Var);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlaybackStateChanged(int i11) {
            q2.r(this, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            q2.s(this, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            q2.t(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            q2.u(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i11) {
            q2.v(this, z10, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPositionDiscontinuity(int i11) {
            q2.x(this, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPositionDiscontinuity(o2.e eVar, o2.e eVar2, int i11) {
            q2.y(this, eVar, eVar2, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onRenderedFirstFrame() {
            q2.z(this);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onRepeatModeChanged(int i11) {
            q2.A(this, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onSeekProcessed() {
            q2.D(this);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            q2.E(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
            q2.F(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
            q2.G(this, i11, i12);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onTimelineChanged(k3 k3Var, int i11) {
            q2.H(this, k3Var, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            q2.I(this, trackSelectionParameters);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onTracksChanged(p3 p3Var) {
            q2.J(this, p3Var);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onVideoSizeChanged(com.google.android.exoplayer2.video.y yVar) {
            q2.K(this, yVar);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onVolumeChanged(float f11) {
            q2.L(this, f11);
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void p(n0 n0Var, long j11, boolean z10) {
            PlayerControlView.this.K = false;
            if (z10 || PlayerControlView.this.G == null) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.I(playerControlView.G, j11);
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void r(n0 n0Var, long j11) {
            PlayerControlView.this.K = true;
            if (PlayerControlView.this.f26983m != null) {
                PlayerControlView.this.f26983m.setText(com.google.android.exoplayer2.util.p0.h0(PlayerControlView.this.f26985o, PlayerControlView.this.f26986p, j11));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
    }

    /* loaded from: classes3.dex */
    public interface e {
        void l(int i11);
    }

    static {
        m1.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, attributeSet);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i11);
        int i12 = R$layout.exo_player_control_view;
        this.L = 5000;
        this.N = 0;
        this.M = 200;
        this.T = C.TIME_UNSET;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i11, 0);
            try {
                this.L = obtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.L);
                i12 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, i12);
                this.N = C(obtainStyledAttributes, this.N);
                this.O = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, this.O);
                this.P = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, this.P);
                this.Q = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, this.Q);
                this.R = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, this.R);
                this.S = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, this.S);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, this.M));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f26969b = new CopyOnWriteArrayList();
        this.f26987q = new k3.b();
        this.f26988r = new k3.d();
        StringBuilder sb2 = new StringBuilder();
        this.f26985o = sb2;
        this.f26986p = new Formatter(sb2, Locale.getDefault());
        this.U = new long[0];
        this.V = new boolean[0];
        this.W = new long[0];
        this.f26968a0 = new boolean[0];
        c cVar = new c();
        this.f26967a = cVar;
        this.f26989s = new Runnable() { // from class: com.google.android.exoplayer2.ui.i
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView.this.O();
            }
        };
        this.f26990t = new Runnable() { // from class: com.google.android.exoplayer2.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView.this.hide();
            }
        };
        LayoutInflater.from(context).inflate(i12, this);
        setDescendantFocusability(262144);
        n0 n0Var = (n0) findViewById(R$id.exo_progress);
        View findViewById = findViewById(R$id.exo_progress_placeholder);
        if (n0Var != null) {
            this.f26984n = n0Var;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f26984n = defaultTimeBar;
        } else {
            this.f26984n = null;
        }
        this.f26982l = (TextView) findViewById(R$id.exo_duration);
        this.f26983m = (TextView) findViewById(R$id.exo_position);
        n0 n0Var2 = this.f26984n;
        if (n0Var2 != null) {
            n0Var2.addListener(cVar);
        }
        View findViewById2 = findViewById(R$id.exo_play);
        this.f26975e = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(cVar);
        }
        View findViewById3 = findViewById(R$id.exo_pause);
        this.f26976f = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(cVar);
        }
        View findViewById4 = findViewById(R$id.exo_prev);
        this.f26971c = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(cVar);
        }
        View findViewById5 = findViewById(R$id.exo_next);
        this.f26973d = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(cVar);
        }
        View findViewById6 = findViewById(R$id.exo_rew);
        this.f26978h = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(cVar);
        }
        View findViewById7 = findViewById(R$id.exo_ffwd);
        this.f26977g = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f26979i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f26980j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View findViewById8 = findViewById(R$id.exo_vr);
        this.f26981k = findViewById8;
        setShowVrButton(false);
        L(false, false, findViewById8);
        Resources resources = context.getResources();
        this.C = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f26991u = resources.getDrawable(R$drawable.exo_controls_repeat_off);
        this.f26992v = resources.getDrawable(R$drawable.exo_controls_repeat_one);
        this.f26993w = resources.getDrawable(R$drawable.exo_controls_repeat_all);
        this.A = resources.getDrawable(R$drawable.exo_controls_shuffle_on);
        this.B = resources.getDrawable(R$drawable.exo_controls_shuffle_off);
        this.f26994x = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f26995y = resources.getString(R$string.exo_controls_repeat_one_description);
        this.f26996z = resources.getString(R$string.exo_controls_repeat_all_description);
        this.E = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.F = resources.getString(R$string.exo_controls_shuffle_off_description);
        this.f26972c0 = C.TIME_UNSET;
        this.f26974d0 = C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(o2 o2Var) {
        int playbackState = o2Var.getPlaybackState();
        if (playbackState == 1) {
            o2Var.prepare();
        } else if (playbackState == 4) {
            H(o2Var, o2Var.t(), C.TIME_UNSET);
        }
        o2Var.play();
    }

    private void B(o2 o2Var) {
        int playbackState = o2Var.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !o2Var.getPlayWhenReady()) {
            A(o2Var);
        } else {
            z(o2Var);
        }
    }

    private static int C(TypedArray typedArray, int i11) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i11);
    }

    private void D() {
        removeCallbacks(this.f26990t);
        if (this.L <= 0) {
            this.T = C.TIME_UNSET;
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int i11 = this.L;
        this.T = uptimeMillis + i11;
        if (this.H) {
            postDelayed(this.f26990t, i11);
        }
    }

    private static boolean E(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    private void F() {
        View view;
        View view2;
        boolean J = J();
        if (!J && (view2 = this.f26975e) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!J || (view = this.f26976f) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    private void G() {
        View view;
        View view2;
        boolean J = J();
        if (!J && (view2 = this.f26975e) != null) {
            view2.requestFocus();
        } else {
            if (!J || (view = this.f26976f) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private void H(o2 o2Var, int i11, long j11) {
        o2Var.seekTo(i11, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(o2 o2Var, long j11) {
        int t11;
        k3 currentTimeline = o2Var.getCurrentTimeline();
        if (this.J && !currentTimeline.u()) {
            int t12 = currentTimeline.t();
            t11 = 0;
            while (true) {
                long g11 = currentTimeline.r(t11, this.f26988r).g();
                if (j11 < g11) {
                    break;
                }
                if (t11 == t12 - 1) {
                    j11 = g11;
                    break;
                } else {
                    j11 -= g11;
                    t11++;
                }
            }
        } else {
            t11 = o2Var.t();
        }
        H(o2Var, t11, j11);
        O();
    }

    private boolean J() {
        o2 o2Var = this.G;
        return (o2Var == null || o2Var.getPlaybackState() == 4 || this.G.getPlaybackState() == 1 || !this.G.getPlayWhenReady()) ? false : true;
    }

    private void K() {
        N();
        M();
        P();
        Q();
        R();
    }

    private void L(boolean z10, boolean z11, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z11);
        view.setAlpha(z11 ? this.C : this.D);
        view.setVisibility(z10 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (isVisible() && this.H) {
            o2 o2Var = this.G;
            if (o2Var != null) {
                z10 = o2Var.h(5);
                z12 = o2Var.h(7);
                z13 = o2Var.h(11);
                z14 = o2Var.h(12);
                z11 = o2Var.h(9);
            } else {
                z10 = false;
                z11 = false;
                z12 = false;
                z13 = false;
                z14 = false;
            }
            L(this.Q, z12, this.f26971c);
            L(this.O, z13, this.f26978h);
            L(this.P, z14, this.f26977g);
            L(this.R, z11, this.f26973d);
            n0 n0Var = this.f26984n;
            if (n0Var != null) {
                n0Var.setEnabled(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        boolean z10;
        boolean z11;
        if (isVisible() && this.H) {
            boolean J = J();
            View view = this.f26975e;
            boolean z12 = true;
            if (view != null) {
                z10 = J && view.isFocused();
                z11 = com.google.android.exoplayer2.util.p0.f27680a < 21 ? z10 : J && b.a(this.f26975e);
                this.f26975e.setVisibility(J ? 8 : 0);
            } else {
                z10 = false;
                z11 = false;
            }
            View view2 = this.f26976f;
            if (view2 != null) {
                z10 |= !J && view2.isFocused();
                if (com.google.android.exoplayer2.util.p0.f27680a < 21) {
                    z12 = z10;
                } else if (J || !b.a(this.f26976f)) {
                    z12 = false;
                }
                z11 |= z12;
                this.f26976f.setVisibility(J ? 0 : 8);
            }
            if (z10) {
                G();
            }
            if (z11) {
                F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        long j11;
        long j12;
        if (isVisible() && this.H) {
            o2 o2Var = this.G;
            if (o2Var != null) {
                j11 = this.f26970b0 + o2Var.getContentPosition();
                j12 = this.f26970b0 + o2Var.u();
            } else {
                j11 = 0;
                j12 = 0;
            }
            boolean z10 = j11 != this.f26972c0;
            this.f26972c0 = j11;
            this.f26974d0 = j12;
            TextView textView = this.f26983m;
            if (textView != null && !this.K && z10) {
                textView.setText(com.google.android.exoplayer2.util.p0.h0(this.f26985o, this.f26986p, j11));
            }
            n0 n0Var = this.f26984n;
            if (n0Var != null) {
                n0Var.setPosition(j11);
                this.f26984n.setBufferedPosition(j12);
            }
            removeCallbacks(this.f26989s);
            int playbackState = o2Var == null ? 1 : o2Var.getPlaybackState();
            if (o2Var == null || !o2Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f26989s, 1000L);
                return;
            }
            n0 n0Var2 = this.f26984n;
            long min = Math.min(n0Var2 != null ? n0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (j11 % 1000));
            postDelayed(this.f26989s, com.google.android.exoplayer2.util.p0.r(o2Var.getPlaybackParameters().f25529a > 0.0f ? ((float) min) / r0 : 1000L, this.M, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        ImageView imageView;
        if (isVisible() && this.H && (imageView = this.f26979i) != null) {
            if (this.N == 0) {
                L(false, false, imageView);
                return;
            }
            o2 o2Var = this.G;
            if (o2Var == null) {
                L(true, false, imageView);
                this.f26979i.setImageDrawable(this.f26991u);
                this.f26979i.setContentDescription(this.f26994x);
                return;
            }
            L(true, true, imageView);
            int repeatMode = o2Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f26979i.setImageDrawable(this.f26991u);
                this.f26979i.setContentDescription(this.f26994x);
            } else if (repeatMode == 1) {
                this.f26979i.setImageDrawable(this.f26992v);
                this.f26979i.setContentDescription(this.f26995y);
            } else if (repeatMode == 2) {
                this.f26979i.setImageDrawable(this.f26993w);
                this.f26979i.setContentDescription(this.f26996z);
            }
            this.f26979i.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        ImageView imageView;
        if (isVisible() && this.H && (imageView = this.f26980j) != null) {
            o2 o2Var = this.G;
            if (!this.S) {
                L(false, false, imageView);
                return;
            }
            if (o2Var == null) {
                L(true, false, imageView);
                this.f26980j.setImageDrawable(this.B);
                this.f26980j.setContentDescription(this.F);
            } else {
                L(true, true, imageView);
                this.f26980j.setImageDrawable(o2Var.getShuffleModeEnabled() ? this.A : this.B);
                this.f26980j.setContentDescription(o2Var.getShuffleModeEnabled() ? this.E : this.F);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        int i11;
        k3.d dVar;
        o2 o2Var = this.G;
        if (o2Var == null) {
            return;
        }
        boolean z10 = true;
        this.J = this.I && y(o2Var.getCurrentTimeline(), this.f26988r);
        long j11 = 0;
        this.f26970b0 = 0L;
        k3 currentTimeline = o2Var.getCurrentTimeline();
        if (currentTimeline.u()) {
            i11 = 0;
        } else {
            int t11 = o2Var.t();
            boolean z11 = this.J;
            int i12 = z11 ? 0 : t11;
            int t12 = z11 ? currentTimeline.t() - 1 : t11;
            long j12 = 0;
            i11 = 0;
            while (true) {
                if (i12 > t12) {
                    break;
                }
                if (i12 == t11) {
                    this.f26970b0 = com.google.android.exoplayer2.util.p0.e1(j12);
                }
                currentTimeline.r(i12, this.f26988r);
                k3.d dVar2 = this.f26988r;
                if (dVar2.f25236n == C.TIME_UNSET) {
                    com.google.android.exoplayer2.util.a.g(this.J ^ z10);
                    break;
                }
                int i13 = dVar2.f25237o;
                while (true) {
                    dVar = this.f26988r;
                    if (i13 <= dVar.f25238p) {
                        currentTimeline.j(i13, this.f26987q);
                        int f11 = this.f26987q.f();
                        for (int r11 = this.f26987q.r(); r11 < f11; r11++) {
                            long i14 = this.f26987q.i(r11);
                            if (i14 == Long.MIN_VALUE) {
                                long j13 = this.f26987q.f25211d;
                                if (j13 != C.TIME_UNSET) {
                                    i14 = j13;
                                }
                            }
                            long q11 = i14 + this.f26987q.q();
                            if (q11 >= 0) {
                                long[] jArr = this.U;
                                if (i11 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.U = Arrays.copyOf(jArr, length);
                                    this.V = Arrays.copyOf(this.V, length);
                                }
                                this.U[i11] = com.google.android.exoplayer2.util.p0.e1(j12 + q11);
                                this.V[i11] = this.f26987q.s(r11);
                                i11++;
                            }
                        }
                        i13++;
                    }
                }
                j12 += dVar.f25236n;
                i12++;
                z10 = true;
            }
            j11 = j12;
        }
        long e12 = com.google.android.exoplayer2.util.p0.e1(j11);
        TextView textView = this.f26982l;
        if (textView != null) {
            textView.setText(com.google.android.exoplayer2.util.p0.h0(this.f26985o, this.f26986p, e12));
        }
        n0 n0Var = this.f26984n;
        if (n0Var != null) {
            n0Var.setDuration(e12);
            int length2 = this.W.length;
            int i15 = i11 + length2;
            long[] jArr2 = this.U;
            if (i15 > jArr2.length) {
                this.U = Arrays.copyOf(jArr2, i15);
                this.V = Arrays.copyOf(this.V, i15);
            }
            System.arraycopy(this.W, 0, this.U, i11, length2);
            System.arraycopy(this.f26968a0, 0, this.V, i11, length2);
            this.f26984n.setAdGroupTimesMs(this.U, this.V, i15);
        }
        O();
    }

    private static boolean y(k3 k3Var, k3.d dVar) {
        if (k3Var.t() > 100) {
            return false;
        }
        int t11 = k3Var.t();
        for (int i11 = 0; i11 < t11; i11++) {
            if (k3Var.r(i11, dVar).f25236n == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(o2 o2Var) {
        o2Var.pause();
    }

    public void addVisibilityListener(e eVar) {
        com.google.android.exoplayer2.util.a.e(eVar);
        this.f26969b.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        o2 o2Var = this.G;
        if (o2Var == null || !E(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (o2Var.getPlaybackState() == 4) {
                return true;
            }
            o2Var.v();
            return true;
        }
        if (keyCode == 89) {
            o2Var.w();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            B(o2Var);
            return true;
        }
        if (keyCode == 87) {
            o2Var.m();
            return true;
        }
        if (keyCode == 88) {
            o2Var.f();
            return true;
        }
        if (keyCode == 126) {
            A(o2Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        z(o2Var);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f26990t);
        } else if (motionEvent.getAction() == 1) {
            D();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public o2 getPlayer() {
        return this.G;
    }

    public int getRepeatToggleModes() {
        return this.N;
    }

    public boolean getShowShuffleButton() {
        return this.S;
    }

    public int getShowTimeoutMs() {
        return this.L;
    }

    public boolean getShowVrButton() {
        View view = this.f26981k;
        return view != null && view.getVisibility() == 0;
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator it = this.f26969b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).l(getVisibility());
            }
            removeCallbacks(this.f26989s);
            removeCallbacks(this.f26990t);
            this.T = C.TIME_UNSET;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = true;
        long j11 = this.T;
        if (j11 != C.TIME_UNSET) {
            long uptimeMillis = j11 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.f26990t, uptimeMillis);
            }
        } else if (isVisible()) {
            D();
        }
        K();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.H = false;
        removeCallbacks(this.f26989s);
        removeCallbacks(this.f26990t);
    }

    public void removeVisibilityListener(e eVar) {
        this.f26969b.remove(eVar);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.W = new long[0];
            this.f26968a0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.a.e(zArr);
            com.google.android.exoplayer2.util.a.a(jArr.length == zArr2.length);
            this.W = jArr;
            this.f26968a0 = zArr2;
        }
        R();
    }

    public void setPlayer(@Nullable o2 o2Var) {
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.util.a.a(o2Var == null || o2Var.k() == Looper.getMainLooper());
        o2 o2Var2 = this.G;
        if (o2Var2 == o2Var) {
            return;
        }
        if (o2Var2 != null) {
            o2Var2.A(this.f26967a);
        }
        this.G = o2Var;
        if (o2Var != null) {
            o2Var.C(this.f26967a);
        }
        K();
    }

    public void setProgressUpdateListener(@Nullable d dVar) {
    }

    public void setRepeatToggleModes(int i11) {
        this.N = i11;
        o2 o2Var = this.G;
        if (o2Var != null) {
            int repeatMode = o2Var.getRepeatMode();
            if (i11 == 0 && repeatMode != 0) {
                this.G.setRepeatMode(0);
            } else if (i11 == 1 && repeatMode == 2) {
                this.G.setRepeatMode(1);
            } else if (i11 == 2 && repeatMode == 1) {
                this.G.setRepeatMode(2);
            }
        }
        P();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.P = z10;
        M();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.I = z10;
        R();
    }

    public void setShowNextButton(boolean z10) {
        this.R = z10;
        M();
    }

    public void setShowPreviousButton(boolean z10) {
        this.Q = z10;
        M();
    }

    public void setShowRewindButton(boolean z10) {
        this.O = z10;
        M();
    }

    public void setShowShuffleButton(boolean z10) {
        this.S = z10;
        Q();
    }

    public void setShowTimeoutMs(int i11) {
        this.L = i11;
        if (isVisible()) {
            D();
        }
    }

    public void setShowVrButton(boolean z10) {
        View view = this.f26981k;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.M = com.google.android.exoplayer2.util.p0.q(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f26981k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            L(getShowVrButton(), onClickListener != null, this.f26981k);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator it = this.f26969b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).l(getVisibility());
            }
            K();
            G();
            F();
        }
        D();
    }
}
