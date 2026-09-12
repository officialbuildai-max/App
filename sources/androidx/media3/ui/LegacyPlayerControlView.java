package androidx.media3.ui;

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
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.ui.y0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class LegacyPlayerControlView extends FrameLayout {
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
    private androidx.media3.common.a0 G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private long U;
    private long[] V;
    private boolean[] W;

    /* renamed from: a, reason: collision with root package name */
    private final b f13543a;

    /* renamed from: a0, reason: collision with root package name */
    private long[] f13544a0;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f13545b;

    /* renamed from: b0, reason: collision with root package name */
    private boolean[] f13546b0;

    /* renamed from: c, reason: collision with root package name */
    private final View f13547c;

    /* renamed from: c0, reason: collision with root package name */
    private long f13548c0;

    /* renamed from: d, reason: collision with root package name */
    private final View f13549d;

    /* renamed from: d0, reason: collision with root package name */
    private long f13550d0;

    /* renamed from: e, reason: collision with root package name */
    private final View f13551e;

    /* renamed from: e0, reason: collision with root package name */
    private long f13552e0;

    /* renamed from: f, reason: collision with root package name */
    private final View f13553f;

    /* renamed from: g, reason: collision with root package name */
    private final View f13554g;

    /* renamed from: h, reason: collision with root package name */
    private final View f13555h;

    /* renamed from: i, reason: collision with root package name */
    private final ImageView f13556i;

    /* renamed from: j, reason: collision with root package name */
    private final ImageView f13557j;

    /* renamed from: k, reason: collision with root package name */
    private final View f13558k;

    /* renamed from: l, reason: collision with root package name */
    private final TextView f13559l;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f13560m;

    /* renamed from: n, reason: collision with root package name */
    private final y0 f13561n;

    /* renamed from: o, reason: collision with root package name */
    private final StringBuilder f13562o;

    /* renamed from: p, reason: collision with root package name */
    private final Formatter f13563p;

    /* renamed from: q, reason: collision with root package name */
    private final e0.b f13564q;

    /* renamed from: r, reason: collision with root package name */
    private final e0.c f13565r;

    /* renamed from: s, reason: collision with root package name */
    private final Runnable f13566s;

    /* renamed from: t, reason: collision with root package name */
    private final Runnable f13567t;

    /* renamed from: u, reason: collision with root package name */
    private final Drawable f13568u;

    /* renamed from: v, reason: collision with root package name */
    private final Drawable f13569v;

    /* renamed from: w, reason: collision with root package name */
    private final Drawable f13570w;

    /* renamed from: x, reason: collision with root package name */
    private final String f13571x;

    /* renamed from: y, reason: collision with root package name */
    private final String f13572y;

    /* renamed from: z, reason: collision with root package name */
    private final String f13573z;

    /* loaded from: classes2.dex */
    private final class b implements a0.d, y0.a, View.OnClickListener {
        private b() {
        }

        @Override // androidx.media3.ui.y0.a
        public void l(y0 y0Var, long j11) {
            LegacyPlayerControlView.this.L = true;
            if (LegacyPlayerControlView.this.f13560m != null) {
                LegacyPlayerControlView.this.f13560m.setText(androidx.media3.common.util.a1.o0(LegacyPlayerControlView.this.f13562o, LegacyPlayerControlView.this.f13563p, j11));
            }
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
            androidx.media3.common.a0 a0Var = LegacyPlayerControlView.this.G;
            if (a0Var == null) {
                return;
            }
            if (LegacyPlayerControlView.this.f13549d == view) {
                a0Var.m();
                return;
            }
            if (LegacyPlayerControlView.this.f13547c == view) {
                a0Var.f();
                return;
            }
            if (LegacyPlayerControlView.this.f13554g == view) {
                if (a0Var.getPlaybackState() != 4) {
                    a0Var.v();
                    return;
                }
                return;
            }
            if (LegacyPlayerControlView.this.f13555h == view) {
                a0Var.w();
                return;
            }
            if (LegacyPlayerControlView.this.f13551e == view) {
                androidx.media3.common.util.a1.w0(a0Var);
                return;
            }
            if (LegacyPlayerControlView.this.f13553f == view) {
                androidx.media3.common.util.a1.v0(a0Var);
            } else if (LegacyPlayerControlView.this.f13556i == view) {
                a0Var.setRepeatMode(androidx.media3.common.util.k0.a(a0Var.getRepeatMode(), LegacyPlayerControlView.this.O));
            } else if (LegacyPlayerControlView.this.f13557j == view) {
                a0Var.setShuffleModeEnabled(!a0Var.getShuffleModeEnabled());
            }
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onCues(List list) {
            androidx.media3.common.b0.d(this, list);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onCues(u1.b bVar) {
            androidx.media3.common.b0.e(this, bVar);
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
        public void onEvents(androidx.media3.common.a0 a0Var, a0.c cVar) {
            if (cVar.b(4, 5)) {
                LegacyPlayerControlView.this.H();
            }
            if (cVar.b(4, 5, 7)) {
                LegacyPlayerControlView.this.I();
            }
            if (cVar.a(8)) {
                LegacyPlayerControlView.this.J();
            }
            if (cVar.a(9)) {
                LegacyPlayerControlView.this.K();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                LegacyPlayerControlView.this.G();
            }
            if (cVar.b(11, 0)) {
                LegacyPlayerControlView.this.L();
            }
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
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i11) {
            androidx.media3.common.b0.p(this, z10, i11);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onPlaybackParametersChanged(androidx.media3.common.z zVar) {
            androidx.media3.common.b0.q(this, zVar);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onPlaybackStateChanged(int i11) {
            androidx.media3.common.b0.r(this, i11);
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
        public /* synthetic */ void onPositionDiscontinuity(a0.e eVar, a0.e eVar2, int i11) {
            androidx.media3.common.b0.y(this, eVar, eVar2, i11);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onRenderedFirstFrame() {
            androidx.media3.common.b0.z(this);
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
        public /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
            androidx.media3.common.b0.F(this, i11, i12);
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
        public /* synthetic */ void onTracksChanged(androidx.media3.common.i0 i0Var) {
            androidx.media3.common.b0.I(this, i0Var);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onVideoSizeChanged(androidx.media3.common.m0 m0Var) {
            androidx.media3.common.b0.J(this, m0Var);
        }

        @Override // androidx.media3.common.a0.d
        public /* synthetic */ void onVolumeChanged(float f11) {
            androidx.media3.common.b0.K(this, f11);
        }

        @Override // androidx.media3.ui.y0.a
        public void q(y0 y0Var, long j11) {
            if (LegacyPlayerControlView.this.f13560m != null) {
                LegacyPlayerControlView.this.f13560m.setText(androidx.media3.common.util.a1.o0(LegacyPlayerControlView.this.f13562o, LegacyPlayerControlView.this.f13563p, j11));
            }
        }

        @Override // androidx.media3.ui.y0.a
        public void r(y0 y0Var, long j11, boolean z10) {
            LegacyPlayerControlView.this.L = false;
            if (z10 || LegacyPlayerControlView.this.G == null) {
                return;
            }
            LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
            legacyPlayerControlView.D(legacyPlayerControlView.G, j11);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
    }

    /* loaded from: classes2.dex */
    public interface d {
    }

    static {
        androidx.media3.common.u.a("media3.ui");
    }

    public LegacyPlayerControlView(Context context) {
        this(context, null);
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, attributeSet);
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i11);
        int i12 = R$layout.exo_legacy_player_control_view;
        this.J = true;
        this.M = 5000;
        this.O = 0;
        this.N = 200;
        this.U = C.TIME_UNSET;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.LegacyPlayerControlView, i11, 0);
            try {
                this.M = obtainStyledAttributes.getInt(R$styleable.LegacyPlayerControlView_show_timeout, this.M);
                i12 = obtainStyledAttributes.getResourceId(R$styleable.LegacyPlayerControlView_controller_layout_id, i12);
                this.O = x(obtainStyledAttributes, this.O);
                this.P = obtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_rewind_button, this.P);
                this.Q = obtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_fastforward_button, this.Q);
                this.R = obtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_previous_button, this.R);
                this.S = obtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_next_button, this.S);
                this.T = obtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_shuffle_button, this.T);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.LegacyPlayerControlView_time_bar_min_update_interval, this.N));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f13545b = new CopyOnWriteArrayList();
        this.f13564q = new e0.b();
        this.f13565r = new e0.c();
        StringBuilder sb2 = new StringBuilder();
        this.f13562o = sb2;
        this.f13563p = new Formatter(sb2, Locale.getDefault());
        this.V = new long[0];
        this.W = new boolean[0];
        this.f13544a0 = new long[0];
        this.f13546b0 = new boolean[0];
        b bVar = new b();
        this.f13543a = bVar;
        this.f13566s = new Runnable() { // from class: androidx.media3.ui.h
            @Override // java.lang.Runnable
            public final void run() {
                LegacyPlayerControlView.this.I();
            }
        };
        this.f13567t = new Runnable() { // from class: androidx.media3.ui.i
            @Override // java.lang.Runnable
            public final void run() {
                LegacyPlayerControlView.this.hide();
            }
        };
        LayoutInflater.from(context).inflate(i12, this);
        setDescendantFocusability(262144);
        y0 y0Var = (y0) findViewById(R$id.exo_progress);
        View findViewById = findViewById(R$id.exo_progress_placeholder);
        if (y0Var != null) {
            this.f13561n = y0Var;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f13561n = defaultTimeBar;
        } else {
            this.f13561n = null;
        }
        this.f13559l = (TextView) findViewById(R$id.exo_duration);
        this.f13560m = (TextView) findViewById(R$id.exo_position);
        y0 y0Var2 = this.f13561n;
        if (y0Var2 != null) {
            y0Var2.addListener(bVar);
        }
        View findViewById2 = findViewById(R$id.exo_play);
        this.f13551e = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(bVar);
        }
        View findViewById3 = findViewById(R$id.exo_pause);
        this.f13553f = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(bVar);
        }
        View findViewById4 = findViewById(R$id.exo_prev);
        this.f13547c = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(bVar);
        }
        View findViewById5 = findViewById(R$id.exo_next);
        this.f13549d = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(bVar);
        }
        View findViewById6 = findViewById(R$id.exo_rew);
        this.f13555h = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(bVar);
        }
        View findViewById7 = findViewById(R$id.exo_ffwd);
        this.f13554g = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(bVar);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f13556i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(bVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f13557j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(bVar);
        }
        View findViewById8 = findViewById(R$id.exo_vr);
        this.f13558k = findViewById8;
        setShowVrButton(false);
        F(false, false, findViewById8);
        Resources resources = context.getResources();
        this.C = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f13568u = androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_legacy_controls_repeat_off);
        this.f13569v = androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_legacy_controls_repeat_one);
        this.f13570w = androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_legacy_controls_repeat_all);
        this.A = androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_legacy_controls_shuffle_on);
        this.B = androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_legacy_controls_shuffle_off);
        this.f13571x = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f13572y = resources.getString(R$string.exo_controls_repeat_one_description);
        this.f13573z = resources.getString(R$string.exo_controls_repeat_all_description);
        this.E = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.F = resources.getString(R$string.exo_controls_shuffle_off_description);
        this.f13550d0 = C.TIME_UNSET;
        this.f13552e0 = C.TIME_UNSET;
    }

    private void A() {
        View view;
        View view2;
        boolean l12 = androidx.media3.common.util.a1.l1(this.G, this.J);
        if (l12 && (view2 = this.f13551e) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (l12 || (view = this.f13553f) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    private void B() {
        View view;
        View view2;
        boolean l12 = androidx.media3.common.util.a1.l1(this.G, this.J);
        if (l12 && (view2 = this.f13551e) != null) {
            view2.requestFocus();
        } else {
            if (l12 || (view = this.f13553f) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private void C(androidx.media3.common.a0 a0Var, int i11, long j11) {
        a0Var.seekTo(i11, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(androidx.media3.common.a0 a0Var, long j11) {
        int t11;
        androidx.media3.common.e0 currentTimeline = a0Var.getCurrentTimeline();
        if (this.K && !currentTimeline.q()) {
            int p11 = currentTimeline.p();
            t11 = 0;
            while (true) {
                long d11 = currentTimeline.n(t11, this.f13565r).d();
                if (j11 < d11) {
                    break;
                }
                if (t11 == p11 - 1) {
                    j11 = d11;
                    break;
                } else {
                    j11 -= d11;
                    t11++;
                }
            }
        } else {
            t11 = a0Var.t();
        }
        C(a0Var, t11, j11);
        I();
    }

    private void E() {
        H();
        G();
        J();
        K();
        L();
    }

    private void F(boolean z10, boolean z11, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z11);
        view.setAlpha(z11 ? this.C : this.D);
        view.setVisibility(z10 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (isVisible() && this.H) {
            androidx.media3.common.a0 a0Var = this.G;
            if (a0Var != null) {
                z10 = a0Var.h(5);
                z12 = a0Var.h(7);
                z13 = a0Var.h(11);
                z14 = a0Var.h(12);
                z11 = a0Var.h(9);
            } else {
                z10 = false;
                z11 = false;
                z12 = false;
                z13 = false;
                z14 = false;
            }
            F(this.R, z12, this.f13547c);
            F(this.P, z13, this.f13555h);
            F(this.Q, z14, this.f13554g);
            F(this.S, z11, this.f13549d);
            y0 y0Var = this.f13561n;
            if (y0Var != null) {
                y0Var.setEnabled(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        boolean z10;
        boolean z11;
        if (isVisible() && this.H) {
            boolean l12 = androidx.media3.common.util.a1.l1(this.G, this.J);
            View view = this.f13551e;
            if (view != null) {
                z10 = !l12 && view.isFocused();
                z11 = !l12 && this.f13551e.isAccessibilityFocused();
                this.f13551e.setVisibility(l12 ? 0 : 8);
            } else {
                z10 = false;
                z11 = false;
            }
            View view2 = this.f13553f;
            if (view2 != null) {
                z10 |= l12 && view2.isFocused();
                z11 |= l12 && this.f13553f.isAccessibilityFocused();
                this.f13553f.setVisibility(l12 ? 8 : 0);
            }
            if (z10) {
                B();
            }
            if (z11) {
                A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        long j11;
        long j12;
        if (isVisible() && this.H) {
            androidx.media3.common.a0 a0Var = this.G;
            if (a0Var != null) {
                j11 = this.f13548c0 + a0Var.getContentPosition();
                j12 = this.f13548c0 + a0Var.u();
            } else {
                j11 = 0;
                j12 = 0;
            }
            boolean z10 = j11 != this.f13550d0;
            this.f13550d0 = j11;
            this.f13552e0 = j12;
            TextView textView = this.f13560m;
            if (textView != null && !this.L && z10) {
                textView.setText(androidx.media3.common.util.a1.o0(this.f13562o, this.f13563p, j11));
            }
            y0 y0Var = this.f13561n;
            if (y0Var != null) {
                y0Var.setPosition(j11);
                this.f13561n.setBufferedPosition(j12);
            }
            removeCallbacks(this.f13566s);
            int playbackState = a0Var == null ? 1 : a0Var.getPlaybackState();
            if (a0Var == null || !a0Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f13566s, 1000L);
                return;
            }
            y0 y0Var2 = this.f13561n;
            long min = Math.min(y0Var2 != null ? y0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (j11 % 1000));
            postDelayed(this.f13566s, androidx.media3.common.util.a1.q(a0Var.getPlaybackParameters().f10648a > 0.0f ? ((float) min) / r0 : 1000L, this.N, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        ImageView imageView;
        if (isVisible() && this.H && (imageView = this.f13556i) != null) {
            if (this.O == 0) {
                F(false, false, imageView);
                return;
            }
            androidx.media3.common.a0 a0Var = this.G;
            if (a0Var == null) {
                F(true, false, imageView);
                this.f13556i.setImageDrawable(this.f13568u);
                this.f13556i.setContentDescription(this.f13571x);
                return;
            }
            F(true, true, imageView);
            int repeatMode = a0Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f13556i.setImageDrawable(this.f13568u);
                this.f13556i.setContentDescription(this.f13571x);
            } else if (repeatMode == 1) {
                this.f13556i.setImageDrawable(this.f13569v);
                this.f13556i.setContentDescription(this.f13572y);
            } else if (repeatMode == 2) {
                this.f13556i.setImageDrawable(this.f13570w);
                this.f13556i.setContentDescription(this.f13573z);
            }
            this.f13556i.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ImageView imageView;
        if (isVisible() && this.H && (imageView = this.f13557j) != null) {
            androidx.media3.common.a0 a0Var = this.G;
            if (!this.T) {
                F(false, false, imageView);
                return;
            }
            if (a0Var == null) {
                F(true, false, imageView);
                this.f13557j.setImageDrawable(this.B);
                this.f13557j.setContentDescription(this.F);
            } else {
                F(true, true, imageView);
                this.f13557j.setImageDrawable(a0Var.getShuffleModeEnabled() ? this.A : this.B);
                this.f13557j.setContentDescription(a0Var.getShuffleModeEnabled() ? this.E : this.F);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        int i11;
        e0.c cVar;
        androidx.media3.common.a0 a0Var = this.G;
        if (a0Var == null) {
            return;
        }
        boolean z10 = true;
        this.K = this.I && w(a0Var.getCurrentTimeline(), this.f13565r);
        long j11 = 0;
        this.f13548c0 = 0L;
        androidx.media3.common.e0 currentTimeline = a0Var.getCurrentTimeline();
        if (currentTimeline.q()) {
            i11 = 0;
        } else {
            int t11 = a0Var.t();
            boolean z11 = this.K;
            int i12 = z11 ? 0 : t11;
            int p11 = z11 ? currentTimeline.p() - 1 : t11;
            long j12 = 0;
            i11 = 0;
            while (true) {
                if (i12 > p11) {
                    break;
                }
                if (i12 == t11) {
                    this.f13548c0 = androidx.media3.common.util.a1.y1(j12);
                }
                currentTimeline.n(i12, this.f13565r);
                e0.c cVar2 = this.f13565r;
                if (cVar2.f10045m == C.TIME_UNSET) {
                    androidx.media3.common.util.a.g(this.K ^ z10);
                    break;
                }
                int i13 = cVar2.f10046n;
                while (true) {
                    cVar = this.f13565r;
                    if (i13 <= cVar.f10047o) {
                        currentTimeline.f(i13, this.f13564q);
                        int c11 = this.f13564q.c();
                        for (int p12 = this.f13564q.p(); p12 < c11; p12++) {
                            long f11 = this.f13564q.f(p12);
                            if (f11 == Long.MIN_VALUE) {
                                long j13 = this.f13564q.f10019d;
                                if (j13 != C.TIME_UNSET) {
                                    f11 = j13;
                                }
                            }
                            long o11 = f11 + this.f13564q.o();
                            if (o11 >= 0) {
                                long[] jArr = this.V;
                                if (i11 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.V = Arrays.copyOf(jArr, length);
                                    this.W = Arrays.copyOf(this.W, length);
                                }
                                this.V[i11] = androidx.media3.common.util.a1.y1(j12 + o11);
                                this.W[i11] = this.f13564q.q(p12);
                                i11++;
                            }
                        }
                        i13++;
                    }
                }
                j12 += cVar.f10045m;
                i12++;
                z10 = true;
            }
            j11 = j12;
        }
        long y12 = androidx.media3.common.util.a1.y1(j11);
        TextView textView = this.f13559l;
        if (textView != null) {
            textView.setText(androidx.media3.common.util.a1.o0(this.f13562o, this.f13563p, y12));
        }
        y0 y0Var = this.f13561n;
        if (y0Var != null) {
            y0Var.setDuration(y12);
            int length2 = this.f13544a0.length;
            int i14 = i11 + length2;
            long[] jArr2 = this.V;
            if (i14 > jArr2.length) {
                this.V = Arrays.copyOf(jArr2, i14);
                this.W = Arrays.copyOf(this.W, i14);
            }
            System.arraycopy(this.f13544a0, 0, this.V, i11, length2);
            System.arraycopy(this.f13546b0, 0, this.W, i11, length2);
            this.f13561n.setAdGroupTimesMs(this.V, this.W, i14);
        }
        I();
    }

    private static boolean w(androidx.media3.common.e0 e0Var, e0.c cVar) {
        if (e0Var.p() > 100) {
            return false;
        }
        int p11 = e0Var.p();
        for (int i11 = 0; i11 < p11; i11++) {
            if (e0Var.n(i11, cVar).f10045m == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    private static int x(TypedArray typedArray, int i11) {
        return typedArray.getInt(R$styleable.LegacyPlayerControlView_repeat_toggle_modes, i11);
    }

    private void y() {
        removeCallbacks(this.f13567t);
        if (this.M <= 0) {
            this.U = C.TIME_UNSET;
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int i11 = this.M;
        this.U = uptimeMillis + i11;
        if (this.H) {
            postDelayed(this.f13567t, i11);
        }
    }

    private static boolean z(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    public void addVisibilityListener(d dVar) {
        androidx.media3.common.util.a.e(dVar);
        this.f13545b.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.media3.common.a0 a0Var = this.G;
        if (a0Var == null || !z(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (a0Var.getPlaybackState() == 4) {
                return true;
            }
            a0Var.v();
            return true;
        }
        if (keyCode == 89) {
            a0Var.w();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            androidx.media3.common.util.a1.x0(a0Var, this.J);
            return true;
        }
        if (keyCode == 87) {
            a0Var.m();
            return true;
        }
        if (keyCode == 88) {
            a0Var.f();
            return true;
        }
        if (keyCode == 126) {
            androidx.media3.common.util.a1.w0(a0Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        androidx.media3.common.util.a1.v0(a0Var);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f13567t);
        } else if (motionEvent.getAction() == 1) {
            y();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public androidx.media3.common.a0 getPlayer() {
        return this.G;
    }

    public int getRepeatToggleModes() {
        return this.O;
    }

    public boolean getShowShuffleButton() {
        return this.T;
    }

    public int getShowTimeoutMs() {
        return this.M;
    }

    public boolean getShowVrButton() {
        View view = this.f13558k;
        return view != null && view.getVisibility() == 0;
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator it = this.f13545b.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                getVisibility();
                throw null;
            }
            removeCallbacks(this.f13566s);
            removeCallbacks(this.f13567t);
            this.U = C.TIME_UNSET;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = true;
        long j11 = this.U;
        if (j11 != C.TIME_UNSET) {
            long uptimeMillis = j11 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.f13567t, uptimeMillis);
            }
        } else if (isVisible()) {
            y();
        }
        E();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.H = false;
        removeCallbacks(this.f13566s);
        removeCallbacks(this.f13567t);
    }

    public void removeVisibilityListener(d dVar) {
        this.f13545b.remove(dVar);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f13544a0 = new long[0];
            this.f13546b0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) androidx.media3.common.util.a.e(zArr);
            androidx.media3.common.util.a.a(jArr.length == zArr2.length);
            this.f13544a0 = jArr;
            this.f13546b0 = zArr2;
        }
        L();
    }

    public void setPlayer(@Nullable androidx.media3.common.a0 a0Var) {
        androidx.media3.common.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        androidx.media3.common.util.a.a(a0Var == null || a0Var.k() == Looper.getMainLooper());
        androidx.media3.common.a0 a0Var2 = this.G;
        if (a0Var2 == a0Var) {
            return;
        }
        if (a0Var2 != null) {
            a0Var2.L(this.f13543a);
        }
        this.G = a0Var;
        if (a0Var != null) {
            a0Var.M(this.f13543a);
        }
        E();
    }

    public void setProgressUpdateListener(@Nullable c cVar) {
    }

    public void setRepeatToggleModes(int i11) {
        this.O = i11;
        androidx.media3.common.a0 a0Var = this.G;
        if (a0Var != null) {
            int repeatMode = a0Var.getRepeatMode();
            if (i11 == 0 && repeatMode != 0) {
                this.G.setRepeatMode(0);
            } else if (i11 == 1 && repeatMode == 2) {
                this.G.setRepeatMode(1);
            } else if (i11 == 2 && repeatMode == 1) {
                this.G.setRepeatMode(2);
            }
        }
        J();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.Q = z10;
        G();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z10) {
        this.I = z10;
        L();
    }

    public void setShowNextButton(boolean z10) {
        this.S = z10;
        G();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z10) {
        this.J = z10;
        H();
    }

    public void setShowPreviousButton(boolean z10) {
        this.R = z10;
        G();
    }

    public void setShowRewindButton(boolean z10) {
        this.P = z10;
        G();
    }

    public void setShowShuffleButton(boolean z10) {
        this.T = z10;
        K();
    }

    public void setShowTimeoutMs(int i11) {
        this.M = i11;
        if (isVisible()) {
            y();
        }
    }

    public void setShowVrButton(boolean z10) {
        View view = this.f13558k;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.N = androidx.media3.common.util.a1.p(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f13558k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            F(getShowVrButton(), onClickListener != null, this.f13558k);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator it = this.f13545b.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                getVisibility();
                throw null;
            }
            E();
            B();
            A();
        }
        y();
    }
}
