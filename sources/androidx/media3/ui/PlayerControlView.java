package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.i0;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class PlayerControlView extends FrameLayout {
    private static final float[] A0;
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private final View A;
    private final View B;
    private final TextView C;
    private final TextView D;
    private final y0 E;
    private final StringBuilder F;
    private final Formatter G;
    private final e0.b H;
    private final e0.c I;
    private final Runnable J;
    private final Drawable K;
    private final Drawable L;
    private final Drawable M;
    private final Drawable N;
    private final Drawable O;
    private final String P;
    private final String Q;
    private final String R;
    private final Drawable S;
    private final Drawable T;
    private final float U;
    private final float V;
    private final String W;

    /* renamed from: a, reason: collision with root package name */
    private final e0 f13575a;

    /* renamed from: a0, reason: collision with root package name */
    private final String f13576a0;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f13577b;

    /* renamed from: b0, reason: collision with root package name */
    private final Drawable f13578b0;

    /* renamed from: c, reason: collision with root package name */
    private final c f13579c;

    /* renamed from: c0, reason: collision with root package name */
    private final Drawable f13580c0;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList f13581d;

    /* renamed from: d0, reason: collision with root package name */
    private final String f13582d0;

    /* renamed from: e, reason: collision with root package name */
    private final RecyclerView f13583e;

    /* renamed from: e0, reason: collision with root package name */
    private final String f13584e0;

    /* renamed from: f, reason: collision with root package name */
    private final h f13585f;

    /* renamed from: f0, reason: collision with root package name */
    private final Drawable f13586f0;

    /* renamed from: g, reason: collision with root package name */
    private final e f13587g;

    /* renamed from: g0, reason: collision with root package name */
    private final Drawable f13588g0;

    /* renamed from: h, reason: collision with root package name */
    private final j f13589h;

    /* renamed from: h0, reason: collision with root package name */
    private final String f13590h0;

    /* renamed from: i, reason: collision with root package name */
    private final b f13591i;

    /* renamed from: i0, reason: collision with root package name */
    private final String f13592i0;

    /* renamed from: j, reason: collision with root package name */
    private final z0 f13593j;

    /* renamed from: j0, reason: collision with root package name */
    private androidx.media3.common.a0 f13594j0;

    /* renamed from: k, reason: collision with root package name */
    private final PopupWindow f13595k;

    /* renamed from: k0, reason: collision with root package name */
    private d f13596k0;

    /* renamed from: l, reason: collision with root package name */
    private final int f13597l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f13598l0;

    /* renamed from: m, reason: collision with root package name */
    private final ImageView f13599m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f13600m0;

    /* renamed from: n, reason: collision with root package name */
    private final ImageView f13601n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f13602n0;

    /* renamed from: o, reason: collision with root package name */
    private final ImageView f13603o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f13604o0;

    /* renamed from: p, reason: collision with root package name */
    private final View f13605p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f13606p0;

    /* renamed from: q, reason: collision with root package name */
    private final View f13607q;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f13608q0;

    /* renamed from: r, reason: collision with root package name */
    private final TextView f13609r;

    /* renamed from: r0, reason: collision with root package name */
    private int f13610r0;

    /* renamed from: s, reason: collision with root package name */
    private final TextView f13611s;

    /* renamed from: s0, reason: collision with root package name */
    private int f13612s0;

    /* renamed from: t, reason: collision with root package name */
    private final ImageView f13613t;

    /* renamed from: t0, reason: collision with root package name */
    private int f13614t0;

    /* renamed from: u, reason: collision with root package name */
    private final ImageView f13615u;

    /* renamed from: u0, reason: collision with root package name */
    private long[] f13616u0;

    /* renamed from: v, reason: collision with root package name */
    private final ImageView f13617v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean[] f13618v0;

    /* renamed from: w, reason: collision with root package name */
    private final ImageView f13619w;

    /* renamed from: w0, reason: collision with root package name */
    private long[] f13620w0;

    /* renamed from: x, reason: collision with root package name */
    private final ImageView f13621x;

    /* renamed from: x0, reason: collision with root package name */
    private boolean[] f13622x0;

    /* renamed from: y, reason: collision with root package name */
    private final ImageView f13623y;

    /* renamed from: y0, reason: collision with root package name */
    private long f13624y0;

    /* renamed from: z, reason: collision with root package name */
    private final View f13625z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f13626z0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b extends l {
        private b() {
            super();
        }

        private boolean o(androidx.media3.common.h0 h0Var) {
            for (int i11 = 0; i11 < this.f13647a.size(); i11++) {
                if (h0Var.D.containsKey(((k) this.f13647a.get(i11)).f13644a.a())) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(View view) {
            if (PlayerControlView.this.f13594j0 == null || !PlayerControlView.this.f13594j0.h(29)) {
                return;
            }
            ((androidx.media3.common.a0) androidx.media3.common.util.a1.i(PlayerControlView.this.f13594j0)).V(PlayerControlView.this.f13594j0.l().a().G(1).P(1, false).F());
            PlayerControlView.this.f13585f.j(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
            PlayerControlView.this.f13595k.dismiss();
        }

        @Override // androidx.media3.ui.PlayerControlView.l
        public void k(i iVar) {
            iVar.f13641a.setText(R$string.exo_track_selection_auto);
            iVar.f13642b.setVisibility(o(((androidx.media3.common.a0) androidx.media3.common.util.a.e(PlayerControlView.this.f13594j0)).l()) ? 4 : 0);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.b.this.q(view);
                }
            });
        }

        @Override // androidx.media3.ui.PlayerControlView.l
        public void m(String str) {
            PlayerControlView.this.f13585f.j(1, str);
        }

        public void p(List list) {
            this.f13647a = list;
            androidx.media3.common.h0 l11 = ((androidx.media3.common.a0) androidx.media3.common.util.a.e(PlayerControlView.this.f13594j0)).l();
            if (list.isEmpty()) {
                PlayerControlView.this.f13585f.j(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_none));
                return;
            }
            if (!o(l11)) {
                PlayerControlView.this.f13585f.j(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
                return;
            }
            for (int i11 = 0; i11 < list.size(); i11++) {
                k kVar = (k) list.get(i11);
                if (kVar.a()) {
                    PlayerControlView.this.f13585f.j(1, kVar.f13646c);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private final class c implements a0.d, y0.a, View.OnClickListener, PopupWindow.OnDismissListener {
        private c() {
        }

        @Override // androidx.media3.ui.y0.a
        public void l(y0 y0Var, long j11) {
            PlayerControlView.this.f13608q0 = true;
            if (PlayerControlView.this.D != null) {
                PlayerControlView.this.D.setText(androidx.media3.common.util.a1.o0(PlayerControlView.this.F, PlayerControlView.this.G, j11));
            }
            PlayerControlView.this.f13575a.W();
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
            androidx.media3.common.a0 a0Var = PlayerControlView.this.f13594j0;
            if (a0Var == null) {
                return;
            }
            PlayerControlView.this.f13575a.X();
            if (PlayerControlView.this.f13601n == view) {
                if (a0Var.h(9)) {
                    a0Var.m();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f13599m == view) {
                if (a0Var.h(7)) {
                    a0Var.f();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f13605p == view) {
                if (a0Var.getPlaybackState() == 4 || !a0Var.h(12)) {
                    return;
                }
                a0Var.v();
                return;
            }
            if (PlayerControlView.this.f13607q == view) {
                if (a0Var.h(11)) {
                    a0Var.w();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f13603o == view) {
                androidx.media3.common.util.a1.x0(a0Var, PlayerControlView.this.f13604o0);
                return;
            }
            if (PlayerControlView.this.f13613t == view) {
                if (a0Var.h(15)) {
                    a0Var.setRepeatMode(androidx.media3.common.util.k0.a(a0Var.getRepeatMode(), PlayerControlView.this.f13614t0));
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f13615u == view) {
                if (a0Var.h(14)) {
                    a0Var.setShuffleModeEnabled(!a0Var.getShuffleModeEnabled());
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f13625z == view) {
                PlayerControlView.this.f13575a.W();
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.T(playerControlView.f13585f, PlayerControlView.this.f13625z);
                return;
            }
            if (PlayerControlView.this.A == view) {
                PlayerControlView.this.f13575a.W();
                PlayerControlView playerControlView2 = PlayerControlView.this;
                playerControlView2.T(playerControlView2.f13587g, PlayerControlView.this.A);
            } else if (PlayerControlView.this.B == view) {
                PlayerControlView.this.f13575a.W();
                PlayerControlView playerControlView3 = PlayerControlView.this;
                playerControlView3.T(playerControlView3.f13591i, PlayerControlView.this.B);
            } else if (PlayerControlView.this.f13619w == view) {
                PlayerControlView.this.f13575a.W();
                PlayerControlView playerControlView4 = PlayerControlView.this;
                playerControlView4.T(playerControlView4.f13589h, PlayerControlView.this.f13619w);
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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (PlayerControlView.this.f13626z0) {
                PlayerControlView.this.f13575a.X();
            }
        }

        @Override // androidx.media3.common.a0.d
        public void onEvents(androidx.media3.common.a0 a0Var, a0.c cVar) {
            if (cVar.b(4, 5, 13)) {
                PlayerControlView.this.l0();
            }
            if (cVar.b(4, 5, 7, 13)) {
                PlayerControlView.this.n0();
            }
            if (cVar.b(8, 13)) {
                PlayerControlView.this.o0();
            }
            if (cVar.b(9, 13)) {
                PlayerControlView.this.s0();
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                PlayerControlView.this.k0();
            }
            if (cVar.b(11, 0, 13)) {
                PlayerControlView.this.t0();
            }
            if (cVar.b(12, 13)) {
                PlayerControlView.this.m0();
            }
            if (cVar.b(2, 13)) {
                PlayerControlView.this.u0();
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
            if (PlayerControlView.this.D != null) {
                PlayerControlView.this.D.setText(androidx.media3.common.util.a1.o0(PlayerControlView.this.F, PlayerControlView.this.G, j11));
            }
        }

        @Override // androidx.media3.ui.y0.a
        public void r(y0 y0Var, long j11, boolean z10) {
            PlayerControlView.this.f13608q0 = false;
            if (!z10 && PlayerControlView.this.f13594j0 != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.e0(playerControlView.f13594j0, j11);
            }
            PlayerControlView.this.f13575a.X();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void q(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class e extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f13629a;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f13630b;

        /* renamed from: c, reason: collision with root package name */
        private int f13631c;

        public e(String[] strArr, float[] fArr) {
            this.f13629a = strArr;
            this.f13630b = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(int i11, View view) {
            if (i11 != this.f13631c) {
                PlayerControlView.this.setPlaybackSpeed(this.f13630b[i11]);
            }
            PlayerControlView.this.f13595k.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f13629a.length;
        }

        public String h() {
            return this.f13629a[this.f13631c];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i11) {
            String[] strArr = this.f13629a;
            if (i11 < strArr.length) {
                iVar.f13641a.setText(strArr[i11]);
            }
            if (i11 == this.f13631c) {
                iVar.itemView.setSelected(true);
                iVar.f13642b.setVisibility(0);
            } else {
                iVar.itemView.setSelected(false);
                iVar.f13642b.setVisibility(4);
            }
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.e.this.i(i11, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new i(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public void l(float f11) {
            int i11 = 0;
            float f12 = Float.MAX_VALUE;
            int i12 = 0;
            while (true) {
                float[] fArr = this.f13630b;
                if (i11 >= fArr.length) {
                    this.f13631c = i12;
                    return;
                }
                float abs = Math.abs(f11 - fArr[i11]);
                if (abs < f12) {
                    i12 = i11;
                    f12 = abs;
                }
                i11++;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class g extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f13633a;

        /* renamed from: b, reason: collision with root package name */
        private final TextView f13634b;

        /* renamed from: c, reason: collision with root package name */
        private final ImageView f13635c;

        public g(View view) {
            super(view);
            if (androidx.media3.common.util.a1.f10432a < 26) {
                view.setFocusable(true);
            }
            this.f13633a = (TextView) view.findViewById(R$id.exo_main_text);
            this.f13634b = (TextView) view.findViewById(R$id.exo_sub_text);
            this.f13635c = (ImageView) view.findViewById(R$id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PlayerControlView.g.this.j(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(View view) {
            PlayerControlView.this.c0(getBindingAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class h extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f13637a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f13638b;

        /* renamed from: c, reason: collision with root package name */
        private final Drawable[] f13639c;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.f13637a = strArr;
            this.f13638b = new String[strArr.length];
            this.f13639c = drawableArr;
        }

        private boolean k(int i11) {
            if (PlayerControlView.this.f13594j0 == null) {
                return false;
            }
            if (i11 == 0) {
                return PlayerControlView.this.f13594j0.h(13);
            }
            if (i11 != 1) {
                return true;
            }
            return PlayerControlView.this.f13594j0.h(30) && PlayerControlView.this.f13594j0.h(29);
        }

        public boolean g() {
            return k(1) || k(0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f13637a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i11) {
            if (k(i11)) {
                gVar.itemView.setLayoutParams(new RecyclerView.n(-1, -2));
            } else {
                gVar.itemView.setLayoutParams(new RecyclerView.n(0, 0));
            }
            gVar.f13633a.setText(this.f13637a[i11]);
            if (this.f13638b[i11] == null) {
                gVar.f13634b.setVisibility(8);
            } else {
                gVar.f13634b.setText(this.f13638b[i11]);
            }
            if (this.f13639c[i11] == null) {
                gVar.f13635c.setVisibility(8);
            } else {
                gVar.f13635c.setImageDrawable(this.f13639c[i11]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new g(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public void j(int i11, String str) {
            this.f13638b[i11] = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f13641a;

        /* renamed from: b, reason: collision with root package name */
        public final View f13642b;

        public i(View view) {
            super(view);
            if (androidx.media3.common.util.a1.f10432a < 26) {
                view.setFocusable(true);
            }
            this.f13641a = (TextView) view.findViewById(R$id.exo_text);
            this.f13642b = view.findViewById(R$id.exo_check);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class j extends l {
        private j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(View view) {
            if (PlayerControlView.this.f13594j0 == null || !PlayerControlView.this.f13594j0.h(29)) {
                return;
            }
            PlayerControlView.this.f13594j0.V(PlayerControlView.this.f13594j0.l().a().G(3).K(-3).M(null).O(0).F());
            PlayerControlView.this.f13595k.dismiss();
        }

        @Override // androidx.media3.ui.PlayerControlView.l, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i11) {
            super.onBindViewHolder(iVar, i11);
            if (i11 > 0) {
                iVar.f13642b.setVisibility(((k) this.f13647a.get(i11 + (-1))).a() ? 0 : 4);
            }
        }

        @Override // androidx.media3.ui.PlayerControlView.l
        public void k(i iVar) {
            boolean z10;
            iVar.f13641a.setText(R$string.exo_track_selection_none);
            int i11 = 0;
            while (true) {
                if (i11 >= this.f13647a.size()) {
                    z10 = true;
                    break;
                } else {
                    if (((k) this.f13647a.get(i11)).a()) {
                        z10 = false;
                        break;
                    }
                    i11++;
                }
            }
            iVar.f13642b.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.j.this.p(view);
                }
            });
        }

        @Override // androidx.media3.ui.PlayerControlView.l
        public void m(String str) {
        }

        public void o(List list) {
            boolean z10 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= list.size()) {
                    break;
                }
                if (((k) list.get(i11)).a()) {
                    z10 = true;
                    break;
                }
                i11++;
            }
            if (PlayerControlView.this.f13619w != null) {
                ImageView imageView = PlayerControlView.this.f13619w;
                PlayerControlView playerControlView = PlayerControlView.this;
                imageView.setImageDrawable(z10 ? playerControlView.f13578b0 : playerControlView.f13580c0);
                PlayerControlView.this.f13619w.setContentDescription(z10 ? PlayerControlView.this.f13582d0 : PlayerControlView.this.f13584e0);
            }
            this.f13647a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        public final i0.a f13644a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13645b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13646c;

        /* JADX WARN: Multi-variable type inference failed */
        public k(androidx.media3.common.i0 i0Var, int i11, int i12, String str) {
            this.f13644a = (i0.a) i0Var.a().get(i11);
            this.f13645b = i12;
            this.f13646c = str;
        }

        public boolean a() {
            return this.f13644a.h(this.f13645b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class l extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        protected List f13647a = new ArrayList();

        protected l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(androidx.media3.common.a0 a0Var, androidx.media3.common.f0 f0Var, k kVar, View view) {
            if (a0Var.h(29)) {
                a0Var.V(a0Var.l().a().L(new androidx.media3.common.g0(f0Var, ImmutableList.of(Integer.valueOf(kVar.f13645b)))).P(kVar.f13644a.d(), false).F());
                m(kVar.f13646c);
                PlayerControlView.this.f13595k.dismiss();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f13647a.isEmpty()) {
                return 0;
            }
            return this.f13647a.size() + 1;
        }

        protected void h() {
            this.f13647a = Collections.emptyList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j */
        public void onBindViewHolder(i iVar, int i11) {
            final androidx.media3.common.a0 a0Var = PlayerControlView.this.f13594j0;
            if (a0Var == null) {
                return;
            }
            if (i11 == 0) {
                k(iVar);
                return;
            }
            final k kVar = (k) this.f13647a.get(i11 - 1);
            final androidx.media3.common.f0 a11 = kVar.f13644a.a();
            boolean z10 = a0Var.l().D.get(a11) != null && kVar.a();
            iVar.f13641a.setText(kVar.f13646c);
            iVar.f13642b.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.l.this.i(a0Var, a11, kVar, view);
                }
            });
        }

        protected abstract void k(i iVar);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new i(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        protected abstract void m(String str);
    }

    /* loaded from: classes2.dex */
    public interface m {
        void l(int i11);
    }

    static {
        androidx.media3.common.u.a("media3.ui");
        A0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
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
        int i12;
        int i13;
        final PlayerControlView playerControlView;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        c cVar;
        final PlayerControlView playerControlView2;
        ImageView imageView;
        boolean z18;
        int i29;
        boolean z19;
        int i30;
        boolean z20;
        int i31;
        ImageView imageView2;
        boolean z21;
        int i32 = R$layout.exo_player_control_view;
        int i33 = R$drawable.exo_styled_controls_play;
        int i34 = R$drawable.exo_styled_controls_pause;
        int i35 = R$drawable.exo_styled_controls_next;
        int i36 = R$drawable.exo_styled_controls_simple_fastforward;
        int i37 = R$drawable.exo_styled_controls_previous;
        int i38 = R$drawable.exo_styled_controls_simple_rewind;
        int i39 = R$drawable.exo_styled_controls_fullscreen_exit;
        int i40 = R$drawable.exo_styled_controls_fullscreen_enter;
        int i41 = R$drawable.exo_styled_controls_repeat_off;
        int i42 = R$drawable.exo_styled_controls_repeat_one;
        int i43 = R$drawable.exo_styled_controls_repeat_all;
        int i44 = R$drawable.exo_styled_controls_shuffle_on;
        int i45 = R$drawable.exo_styled_controls_shuffle_off;
        int i46 = R$drawable.exo_styled_controls_subtitle_on;
        int i47 = R$drawable.exo_styled_controls_subtitle_off;
        int i48 = R$drawable.exo_styled_controls_vr;
        this.f13604o0 = true;
        this.f13610r0 = 5000;
        this.f13614t0 = 0;
        this.f13612s0 = 200;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i11, 0);
            try {
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, i32);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_play_icon, i33);
                int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_pause_icon, i34);
                int resourceId4 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_next_icon, i35);
                i36 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_fastforward_icon, i36);
                int resourceId5 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_previous_icon, i37);
                int resourceId6 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_rewind_icon, i38);
                int resourceId7 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_fullscreen_exit_icon, i39);
                int resourceId8 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_fullscreen_enter_icon, i40);
                int resourceId9 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_repeat_off_icon, i41);
                int resourceId10 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_repeat_one_icon, i42);
                int resourceId11 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_repeat_all_icon, i43);
                int resourceId12 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_shuffle_on_icon, i44);
                int resourceId13 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_shuffle_off_icon, i45);
                int resourceId14 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_subtitle_on_icon, i46);
                int resourceId15 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_subtitle_off_icon, i47);
                int resourceId16 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_vr_icon, i48);
                playerControlView = this;
                try {
                    playerControlView.f13610r0 = obtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, playerControlView.f13610r0);
                    playerControlView.f13614t0 = V(obtainStyledAttributes, playerControlView.f13614t0);
                    boolean z22 = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, true);
                    boolean z23 = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, true);
                    boolean z24 = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, true);
                    boolean z25 = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, true);
                    boolean z26 = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, false);
                    boolean z27 = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_subtitle_button, false);
                    boolean z28 = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_vr_button, false);
                    playerControlView.setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, playerControlView.f13612s0));
                    boolean z29 = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_animation_enabled, true);
                    obtainStyledAttributes.recycle();
                    i27 = resourceId13;
                    i26 = resourceId;
                    z17 = z29;
                    i14 = resourceId6;
                    i15 = resourceId7;
                    i16 = resourceId8;
                    i17 = resourceId9;
                    i18 = resourceId10;
                    i19 = resourceId11;
                    i20 = resourceId12;
                    i21 = resourceId15;
                    i12 = resourceId16;
                    z10 = z22;
                    z11 = z23;
                    z12 = z24;
                    z13 = z25;
                    z14 = z26;
                    z15 = z27;
                    z16 = z28;
                    i22 = resourceId2;
                    i23 = resourceId3;
                    i24 = resourceId5;
                    i25 = resourceId14;
                    i13 = resourceId4;
                } catch (Throwable th2) {
                    th = th2;
                    obtainStyledAttributes.recycle();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            i12 = i48;
            i13 = i35;
            playerControlView = this;
            i14 = i38;
            i15 = i39;
            i16 = i40;
            i17 = i41;
            i18 = i42;
            i19 = i43;
            i20 = i44;
            i21 = i47;
            z10 = true;
            z11 = true;
            z12 = true;
            z13 = true;
            z14 = false;
            z15 = false;
            z16 = false;
            z17 = true;
            i22 = i33;
            i23 = i34;
            i24 = i37;
            i25 = i46;
            i26 = i32;
            i27 = i45;
        }
        LayoutInflater.from(context).inflate(i26, playerControlView);
        playerControlView.setDescendantFocusability(262144);
        c cVar2 = new c();
        playerControlView.f13579c = cVar2;
        playerControlView.f13581d = new CopyOnWriteArrayList();
        playerControlView.H = new e0.b();
        playerControlView.I = new e0.c();
        StringBuilder sb2 = new StringBuilder();
        playerControlView.F = sb2;
        int i49 = i24;
        playerControlView.G = new Formatter(sb2, Locale.getDefault());
        playerControlView.f13616u0 = new long[0];
        playerControlView.f13618v0 = new boolean[0];
        playerControlView.f13620w0 = new long[0];
        playerControlView.f13622x0 = new boolean[0];
        playerControlView.J = new Runnable() { // from class: androidx.media3.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView.this.n0();
            }
        };
        playerControlView.C = (TextView) playerControlView.findViewById(R$id.exo_duration);
        playerControlView.D = (TextView) playerControlView.findViewById(R$id.exo_position);
        ImageView imageView3 = (ImageView) playerControlView.findViewById(R$id.exo_subtitle);
        playerControlView.f13619w = imageView3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(cVar2);
        }
        ImageView imageView4 = (ImageView) playerControlView.findViewById(R$id.exo_fullscreen);
        playerControlView.f13621x = imageView4;
        X(imageView4, new View.OnClickListener() { // from class: androidx.media3.ui.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerControlView.this.a0(view);
            }
        });
        ImageView imageView5 = (ImageView) playerControlView.findViewById(R$id.exo_minimal_fullscreen);
        playerControlView.f13623y = imageView5;
        X(imageView5, new View.OnClickListener() { // from class: androidx.media3.ui.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerControlView.this.a0(view);
            }
        });
        View findViewById = playerControlView.findViewById(R$id.exo_settings);
        playerControlView.f13625z = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(cVar2);
        }
        View findViewById2 = playerControlView.findViewById(R$id.exo_playback_speed);
        playerControlView.A = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(cVar2);
        }
        View findViewById3 = playerControlView.findViewById(R$id.exo_audio_track);
        playerControlView.B = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(cVar2);
        }
        y0 y0Var = (y0) playerControlView.findViewById(R$id.exo_progress);
        View findViewById4 = playerControlView.findViewById(R$id.exo_progress_placeholder);
        if (y0Var != null) {
            playerControlView.E = y0Var;
            i28 = i14;
            cVar = cVar2;
            playerControlView2 = playerControlView;
            imageView = imageView3;
            z18 = z13;
            i29 = i49;
            z19 = z12;
            i30 = i13;
            z20 = z10;
            i31 = i36;
        } else if (findViewById4 != null) {
            i28 = i14;
            cVar = cVar2;
            z18 = z13;
            i29 = i49;
            imageView = imageView3;
            z19 = z12;
            i30 = i13;
            z20 = z10;
            i31 = i36;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById4.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById4);
            viewGroup.removeView(findViewById4);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            playerControlView2 = this;
            playerControlView2.E = defaultTimeBar;
        } else {
            i28 = i14;
            cVar = cVar2;
            playerControlView2 = playerControlView;
            imageView = imageView3;
            z18 = z13;
            i29 = i49;
            z19 = z12;
            i30 = i13;
            z20 = z10;
            i31 = i36;
            playerControlView2.E = null;
        }
        y0 y0Var2 = playerControlView2.E;
        c cVar3 = cVar;
        if (y0Var2 != null) {
            y0Var2.addListener(cVar3);
        }
        Resources resources = context.getResources();
        playerControlView2.f13577b = resources;
        ImageView imageView6 = (ImageView) playerControlView2.findViewById(R$id.exo_play_pause);
        playerControlView2.f13603o = imageView6;
        if (imageView6 != null) {
            imageView6.setOnClickListener(cVar3);
        }
        ImageView imageView7 = (ImageView) playerControlView2.findViewById(R$id.exo_prev);
        playerControlView2.f13599m = imageView7;
        if (imageView7 != null) {
            imageView7.setImageDrawable(androidx.media3.common.util.a1.a0(context, resources, i29));
            imageView7.setOnClickListener(cVar3);
        }
        ImageView imageView8 = (ImageView) playerControlView2.findViewById(R$id.exo_next);
        playerControlView2.f13601n = imageView8;
        if (imageView8 != null) {
            imageView8.setImageDrawable(androidx.media3.common.util.a1.a0(context, resources, i30));
            imageView8.setOnClickListener(cVar3);
        }
        Typeface g11 = y0.h.g(context, R$font.roboto_medium_numbers);
        ImageView imageView9 = (ImageView) playerControlView2.findViewById(R$id.exo_rew);
        TextView textView = (TextView) playerControlView2.findViewById(R$id.exo_rew_with_amount);
        if (imageView9 != null) {
            imageView2 = imageView7;
            imageView9.setImageDrawable(androidx.media3.common.util.a1.a0(context, resources, i28));
            playerControlView2.f13607q = imageView9;
            playerControlView2.f13611s = null;
        } else {
            imageView2 = imageView7;
            if (textView != null) {
                textView.setTypeface(g11);
                playerControlView2.f13611s = textView;
                playerControlView2.f13607q = textView;
            } else {
                playerControlView2.f13611s = null;
                playerControlView2.f13607q = null;
            }
        }
        View view = playerControlView2.f13607q;
        if (view != null) {
            view.setOnClickListener(cVar3);
        }
        ImageView imageView10 = (ImageView) playerControlView2.findViewById(R$id.exo_ffwd);
        TextView textView2 = (TextView) playerControlView2.findViewById(R$id.exo_ffwd_with_amount);
        if (imageView10 != null) {
            imageView10.setImageDrawable(androidx.media3.common.util.a1.a0(context, resources, i31));
            playerControlView2.f13605p = imageView10;
            playerControlView2.f13609r = null;
        } else if (textView2 != null) {
            textView2.setTypeface(g11);
            playerControlView2.f13609r = textView2;
            playerControlView2.f13605p = textView2;
        } else {
            playerControlView2.f13609r = null;
            playerControlView2.f13605p = null;
        }
        View view2 = playerControlView2.f13605p;
        if (view2 != null) {
            view2.setOnClickListener(cVar3);
        }
        ImageView imageView11 = (ImageView) playerControlView2.findViewById(R$id.exo_repeat_toggle);
        playerControlView2.f13613t = imageView11;
        if (imageView11 != null) {
            imageView11.setOnClickListener(cVar3);
        }
        ImageView imageView12 = (ImageView) playerControlView2.findViewById(R$id.exo_shuffle);
        playerControlView2.f13615u = imageView12;
        if (imageView12 != null) {
            imageView12.setOnClickListener(cVar3);
        }
        playerControlView2.U = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        playerControlView2.V = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        ImageView imageView13 = (ImageView) playerControlView2.findViewById(R$id.exo_vr);
        playerControlView2.f13617v = imageView13;
        if (imageView13 != null) {
            imageView13.setImageDrawable(androidx.media3.common.util.a1.a0(context, resources, i12));
            playerControlView2.g0(false, imageView13);
        }
        e0 e0Var = new e0(playerControlView2);
        playerControlView2.f13575a = e0Var;
        e0Var.Y(z17);
        h hVar = new h(new String[]{resources.getString(R$string.exo_controls_playback_speed), resources.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_styled_controls_speed), androidx.media3.common.util.a1.a0(context, resources, R$drawable.exo_styled_controls_audiotrack)});
        playerControlView2.f13585f = hVar;
        playerControlView2.f13597l = resources.getDimensionPixelSize(R$dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.exo_styled_settings_list, (ViewGroup) null);
        playerControlView2.f13583e = recyclerView;
        recyclerView.setAdapter(hVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        playerControlView2.f13595k = popupWindow;
        if (androidx.media3.common.util.a1.f10432a < 23) {
            z21 = false;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            z21 = false;
        }
        popupWindow.setOnDismissListener(cVar3);
        playerControlView2.f13626z0 = true;
        playerControlView2.f13593j = new androidx.media3.ui.f(getResources());
        playerControlView2.f13578b0 = androidx.media3.common.util.a1.a0(context, resources, i25);
        playerControlView2.f13580c0 = androidx.media3.common.util.a1.a0(context, resources, i21);
        playerControlView2.f13582d0 = resources.getString(R$string.exo_controls_cc_enabled_description);
        playerControlView2.f13584e0 = resources.getString(R$string.exo_controls_cc_disabled_description);
        playerControlView2.f13589h = new j();
        playerControlView2.f13591i = new b();
        playerControlView2.f13587g = new e(resources.getStringArray(R$array.exo_controls_playback_speeds), A0);
        playerControlView2.K = androidx.media3.common.util.a1.a0(context, resources, i22);
        playerControlView2.L = androidx.media3.common.util.a1.a0(context, resources, i23);
        playerControlView2.f13586f0 = androidx.media3.common.util.a1.a0(context, resources, i15);
        playerControlView2.f13588g0 = androidx.media3.common.util.a1.a0(context, resources, i16);
        playerControlView2.M = androidx.media3.common.util.a1.a0(context, resources, i17);
        playerControlView2.N = androidx.media3.common.util.a1.a0(context, resources, i18);
        playerControlView2.O = androidx.media3.common.util.a1.a0(context, resources, i19);
        playerControlView2.S = androidx.media3.common.util.a1.a0(context, resources, i20);
        playerControlView2.T = androidx.media3.common.util.a1.a0(context, resources, i27);
        playerControlView2.f13590h0 = resources.getString(R$string.exo_controls_fullscreen_exit_description);
        playerControlView2.f13592i0 = resources.getString(R$string.exo_controls_fullscreen_enter_description);
        playerControlView2.P = resources.getString(R$string.exo_controls_repeat_off_description);
        playerControlView2.Q = resources.getString(R$string.exo_controls_repeat_one_description);
        playerControlView2.R = resources.getString(R$string.exo_controls_repeat_all_description);
        playerControlView2.W = resources.getString(R$string.exo_controls_shuffle_on_description);
        playerControlView2.f13576a0 = resources.getString(R$string.exo_controls_shuffle_off_description);
        e0Var.Z((ViewGroup) playerControlView2.findViewById(R$id.exo_bottom_bar), true);
        e0Var.Z(playerControlView2.f13605p, z11);
        e0Var.Z(playerControlView2.f13607q, z20);
        e0Var.Z(imageView2, z19);
        e0Var.Z(imageView8, z18);
        e0Var.Z(imageView12, z14);
        e0Var.Z(imageView, z15);
        e0Var.Z(imageView13, z16);
        e0Var.Z(imageView11, playerControlView2.f13614t0 != 0 ? true : z21);
        playerControlView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.media3.ui.l
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view3, int i50, int i51, int i52, int i53, int i54, int i55, int i56, int i57) {
                PlayerControlView.this.b0(view3, i50, i51, i52, i53, i54, i55, i56, i57);
            }
        });
    }

    private static boolean S(androidx.media3.common.a0 a0Var, e0.c cVar) {
        androidx.media3.common.e0 currentTimeline;
        int p11;
        if (!a0Var.h(17) || (p11 = (currentTimeline = a0Var.getCurrentTimeline()).p()) <= 1 || p11 > 100) {
            return false;
        }
        for (int i11 = 0; i11 < p11; i11++) {
            if (currentTimeline.n(i11, cVar).f10045m == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(RecyclerView.Adapter adapter, View view) {
        this.f13583e.setAdapter(adapter);
        r0();
        this.f13626z0 = false;
        this.f13595k.dismiss();
        this.f13626z0 = true;
        this.f13595k.showAsDropDown(view, (getWidth() - this.f13595k.getWidth()) - this.f13597l, (-this.f13595k.getHeight()) - this.f13597l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableList U(androidx.media3.common.i0 i0Var, int i11) {
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList a11 = i0Var.a();
        for (int i12 = 0; i12 < a11.size(); i12++) {
            i0.a aVar2 = (i0.a) a11.get(i12);
            if (aVar2.d() == i11) {
                for (int i13 = 0; i13 < aVar2.f10173a; i13++) {
                    if (aVar2.i(i13)) {
                        androidx.media3.common.r b11 = aVar2.b(i13);
                        if ((b11.f10233e & 2) == 0) {
                            aVar.a(new k(i0Var, i12, i13, this.f13593j.a(b11)));
                        }
                    }
                }
            }
        }
        return aVar.e();
    }

    private static int V(TypedArray typedArray, int i11) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i11);
    }

    private void W() {
        this.f13589h.h();
        this.f13591i.h();
        androidx.media3.common.a0 a0Var = this.f13594j0;
        if (a0Var != null && a0Var.h(30) && this.f13594j0.h(29)) {
            androidx.media3.common.i0 currentTracks = this.f13594j0.getCurrentTracks();
            this.f13591i.p(U(currentTracks, 1));
            if (this.f13575a.A(this.f13619w)) {
                this.f13589h.o(U(currentTracks, 3));
            } else {
                this.f13589h.o(ImmutableList.of());
            }
        }
    }

    private static void X(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    private static boolean Y(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(View view) {
        updateIsFullscreen(!this.f13598l0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19 = i14 - i12;
        int i20 = i18 - i16;
        if (!(i13 - i11 == i17 - i15 && i19 == i20) && this.f13595k.isShowing()) {
            r0();
            this.f13595k.update(view, (getWidth() - this.f13595k.getWidth()) - this.f13597l, (-this.f13595k.getHeight()) - this.f13597l, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(int i11) {
        if (i11 == 0) {
            T(this.f13587g, (View) androidx.media3.common.util.a.e(this.f13625z));
        } else if (i11 == 1) {
            T(this.f13591i, (View) androidx.media3.common.util.a.e(this.f13625z));
        } else {
            this.f13595k.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(androidx.media3.common.a0 a0Var, long j11) {
        if (this.f13606p0) {
            if (a0Var.h(17) && a0Var.h(10)) {
                androidx.media3.common.e0 currentTimeline = a0Var.getCurrentTimeline();
                int p11 = currentTimeline.p();
                int i11 = 0;
                while (true) {
                    long d11 = currentTimeline.n(i11, this.I).d();
                    if (j11 < d11) {
                        break;
                    }
                    if (i11 == p11 - 1) {
                        j11 = d11;
                        break;
                    } else {
                        j11 -= d11;
                        i11++;
                    }
                }
                a0Var.seekTo(i11, j11);
            }
        } else if (a0Var.h(5)) {
            a0Var.seekTo(j11);
        }
        n0();
    }

    private void g0(boolean z10, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? this.U : this.V);
    }

    private void h0() {
        androidx.media3.common.a0 a0Var = this.f13594j0;
        int r11 = (int) ((a0Var != null ? a0Var.r() : MBInterstitialActivity.WEB_LOAD_TIME) / 1000);
        TextView textView = this.f13609r;
        if (textView != null) {
            textView.setText(String.valueOf(r11));
        }
        View view = this.f13605p;
        if (view != null) {
            view.setContentDescription(this.f13577b.getQuantityString(R$plurals.exo_controls_fastforward_by_amount_description, r11, Integer.valueOf(r11)));
        }
    }

    private void i0(ImageView imageView, boolean z10) {
        if (imageView == null) {
            return;
        }
        if (z10) {
            imageView.setImageDrawable(this.f13586f0);
            imageView.setContentDescription(this.f13590h0);
        } else {
            imageView.setImageDrawable(this.f13588g0);
            imageView.setContentDescription(this.f13592i0);
        }
    }

    private static void j0(View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (isVisible() && this.f13600m0) {
            androidx.media3.common.a0 a0Var = this.f13594j0;
            if (a0Var != null) {
                z10 = (this.f13602n0 && S(a0Var, this.I)) ? a0Var.h(10) : a0Var.h(5);
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
            if (z13) {
                p0();
            }
            if (z14) {
                h0();
            }
            g0(z12, this.f13599m);
            g0(z13, this.f13607q);
            g0(z14, this.f13605p);
            g0(z11, this.f13601n);
            y0 y0Var = this.E;
            if (y0Var != null) {
                y0Var.setEnabled(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        if (isVisible() && this.f13600m0 && this.f13603o != null) {
            boolean l12 = androidx.media3.common.util.a1.l1(this.f13594j0, this.f13604o0);
            Drawable drawable = l12 ? this.K : this.L;
            int i11 = l12 ? R$string.exo_controls_play_description : R$string.exo_controls_pause_description;
            this.f13603o.setImageDrawable(drawable);
            this.f13603o.setContentDescription(this.f13577b.getString(i11));
            g0(androidx.media3.common.util.a1.k1(this.f13594j0), this.f13603o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        androidx.media3.common.a0 a0Var = this.f13594j0;
        if (a0Var == null) {
            return;
        }
        this.f13587g.l(a0Var.getPlaybackParameters().f10648a);
        this.f13585f.j(0, this.f13587g.h());
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        long j11;
        long j12;
        if (isVisible() && this.f13600m0) {
            androidx.media3.common.a0 a0Var = this.f13594j0;
            if (a0Var == null || !a0Var.h(16)) {
                j11 = 0;
                j12 = 0;
            } else {
                j11 = this.f13624y0 + a0Var.getContentPosition();
                j12 = this.f13624y0 + a0Var.u();
            }
            TextView textView = this.D;
            if (textView != null && !this.f13608q0) {
                textView.setText(androidx.media3.common.util.a1.o0(this.F, this.G, j11));
            }
            y0 y0Var = this.E;
            if (y0Var != null) {
                y0Var.setPosition(j11);
                this.E.setBufferedPosition(j12);
            }
            removeCallbacks(this.J);
            int playbackState = a0Var == null ? 1 : a0Var.getPlaybackState();
            if (a0Var == null || !a0Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.J, 1000L);
                return;
            }
            y0 y0Var2 = this.E;
            long min = Math.min(y0Var2 != null ? y0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (j11 % 1000));
            postDelayed(this.J, androidx.media3.common.util.a1.q(a0Var.getPlaybackParameters().f10648a > 0.0f ? ((float) min) / r0 : 1000L, this.f13612s0, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        ImageView imageView;
        if (isVisible() && this.f13600m0 && (imageView = this.f13613t) != null) {
            if (this.f13614t0 == 0) {
                g0(false, imageView);
                return;
            }
            androidx.media3.common.a0 a0Var = this.f13594j0;
            if (a0Var == null || !a0Var.h(15)) {
                g0(false, this.f13613t);
                this.f13613t.setImageDrawable(this.M);
                this.f13613t.setContentDescription(this.P);
                return;
            }
            g0(true, this.f13613t);
            int repeatMode = a0Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f13613t.setImageDrawable(this.M);
                this.f13613t.setContentDescription(this.P);
            } else if (repeatMode == 1) {
                this.f13613t.setImageDrawable(this.N);
                this.f13613t.setContentDescription(this.Q);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.f13613t.setImageDrawable(this.O);
                this.f13613t.setContentDescription(this.R);
            }
        }
    }

    private void p0() {
        androidx.media3.common.a0 a0Var = this.f13594j0;
        int y10 = (int) ((a0Var != null ? a0Var.y() : 5000L) / 1000);
        TextView textView = this.f13611s;
        if (textView != null) {
            textView.setText(String.valueOf(y10));
        }
        View view = this.f13607q;
        if (view != null) {
            view.setContentDescription(this.f13577b.getQuantityString(R$plurals.exo_controls_rewind_by_amount_description, y10, Integer.valueOf(y10)));
        }
    }

    private void q0() {
        g0(this.f13585f.g(), this.f13625z);
    }

    private void r0() {
        this.f13583e.measure(0, 0);
        this.f13595k.setWidth(Math.min(this.f13583e.getMeasuredWidth(), getWidth() - (this.f13597l * 2)));
        this.f13595k.setHeight(Math.min(getHeight() - (this.f13597l * 2), this.f13583e.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        ImageView imageView;
        if (isVisible() && this.f13600m0 && (imageView = this.f13615u) != null) {
            androidx.media3.common.a0 a0Var = this.f13594j0;
            if (!this.f13575a.A(imageView)) {
                g0(false, this.f13615u);
                return;
            }
            if (a0Var == null || !a0Var.h(14)) {
                g0(false, this.f13615u);
                this.f13615u.setImageDrawable(this.T);
                this.f13615u.setContentDescription(this.f13576a0);
            } else {
                g0(true, this.f13615u);
                this.f13615u.setImageDrawable(a0Var.getShuffleModeEnabled() ? this.S : this.T);
                this.f13615u.setContentDescription(a0Var.getShuffleModeEnabled() ? this.W : this.f13576a0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f11) {
        androidx.media3.common.a0 a0Var = this.f13594j0;
        if (a0Var == null || !a0Var.h(13)) {
            return;
        }
        androidx.media3.common.a0 a0Var2 = this.f13594j0;
        a0Var2.b(a0Var2.getPlaybackParameters().b(f11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        long j11;
        int i11;
        e0.c cVar;
        androidx.media3.common.a0 a0Var = this.f13594j0;
        if (a0Var == null) {
            return;
        }
        boolean z10 = true;
        this.f13606p0 = this.f13602n0 && S(a0Var, this.I);
        this.f13624y0 = 0L;
        androidx.media3.common.e0 currentTimeline = a0Var.h(17) ? a0Var.getCurrentTimeline() : androidx.media3.common.e0.f10007a;
        if (currentTimeline.q()) {
            if (a0Var.h(16)) {
                long Q = a0Var.Q();
                if (Q != C.TIME_UNSET) {
                    j11 = androidx.media3.common.util.a1.R0(Q);
                    i11 = 0;
                }
            }
            j11 = 0;
            i11 = 0;
        } else {
            int t11 = a0Var.t();
            boolean z11 = this.f13606p0;
            int i12 = z11 ? 0 : t11;
            int p11 = z11 ? currentTimeline.p() - 1 : t11;
            long j12 = 0;
            i11 = 0;
            while (true) {
                if (i12 > p11) {
                    break;
                }
                if (i12 == t11) {
                    this.f13624y0 = androidx.media3.common.util.a1.y1(j12);
                }
                currentTimeline.n(i12, this.I);
                e0.c cVar2 = this.I;
                if (cVar2.f10045m == C.TIME_UNSET) {
                    androidx.media3.common.util.a.g(this.f13606p0 ^ z10);
                    break;
                }
                int i13 = cVar2.f10046n;
                while (true) {
                    cVar = this.I;
                    if (i13 <= cVar.f10047o) {
                        currentTimeline.f(i13, this.H);
                        int c11 = this.H.c();
                        for (int p12 = this.H.p(); p12 < c11; p12++) {
                            long f11 = this.H.f(p12);
                            if (f11 == Long.MIN_VALUE) {
                                long j13 = this.H.f10019d;
                                if (j13 != C.TIME_UNSET) {
                                    f11 = j13;
                                }
                            }
                            long o11 = f11 + this.H.o();
                            if (o11 >= 0) {
                                long[] jArr = this.f13616u0;
                                if (i11 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.f13616u0 = Arrays.copyOf(jArr, length);
                                    this.f13618v0 = Arrays.copyOf(this.f13618v0, length);
                                }
                                this.f13616u0[i11] = androidx.media3.common.util.a1.y1(j12 + o11);
                                this.f13618v0[i11] = this.H.q(p12);
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
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(androidx.media3.common.util.a1.o0(this.F, this.G, y12));
        }
        y0 y0Var = this.E;
        if (y0Var != null) {
            y0Var.setDuration(y12);
            int length2 = this.f13620w0.length;
            int i14 = i11 + length2;
            long[] jArr2 = this.f13616u0;
            if (i14 > jArr2.length) {
                this.f13616u0 = Arrays.copyOf(jArr2, i14);
                this.f13618v0 = Arrays.copyOf(this.f13618v0, i14);
            }
            System.arraycopy(this.f13620w0, 0, this.f13616u0, i11, length2);
            System.arraycopy(this.f13622x0, 0, this.f13618v0, i11, length2);
            this.E.setAdGroupTimesMs(this.f13616u0, this.f13618v0, i14);
        }
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        W();
        g0(this.f13589h.getItemCount() > 0, this.f13619w);
        q0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        Iterator it = this.f13581d.iterator();
        while (it.hasNext()) {
            ((m) it.next()).l(getVisibility());
        }
    }

    @Deprecated
    public void addVisibilityListener(m mVar) {
        androidx.media3.common.util.a.e(mVar);
        this.f13581d.add(mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0() {
        ImageView imageView = this.f13603o;
        if (imageView != null) {
            imageView.requestFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.media3.common.a0 a0Var = this.f13594j0;
        if (a0Var == null || !Y(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (a0Var.getPlaybackState() == 4 || !a0Var.h(12)) {
                return true;
            }
            a0Var.v();
            return true;
        }
        if (keyCode == 89 && a0Var.h(11)) {
            a0Var.w();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            androidx.media3.common.util.a1.x0(a0Var, this.f13604o0);
            return true;
        }
        if (keyCode == 87) {
            if (!a0Var.h(9)) {
                return true;
            }
            a0Var.m();
            return true;
        }
        if (keyCode == 88) {
            if (!a0Var.h(7)) {
                return true;
            }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0() {
        l0();
        k0();
        o0();
        s0();
        u0();
        m0();
        t0();
    }

    @Nullable
    public androidx.media3.common.a0 getPlayer() {
        return this.f13594j0;
    }

    public int getRepeatToggleModes() {
        return this.f13614t0;
    }

    public boolean getShowShuffleButton() {
        return this.f13575a.A(this.f13615u);
    }

    public boolean getShowSubtitleButton() {
        return this.f13575a.A(this.f13619w);
    }

    public int getShowTimeoutMs() {
        return this.f13610r0;
    }

    public boolean getShowVrButton() {
        return this.f13575a.A(this.f13617v);
    }

    public void hide() {
        this.f13575a.C();
    }

    public void hideImmediately() {
        this.f13575a.F();
    }

    public boolean isAnimationEnabled() {
        return this.f13575a.I();
    }

    public boolean isFullyVisible() {
        return this.f13575a.J();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f13575a.P();
        this.f13600m0 = true;
        if (isFullyVisible()) {
            this.f13575a.X();
        }
        f0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13575a.Q();
        this.f13600m0 = false;
        removeCallbacks(this.J);
        this.f13575a.W();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        this.f13575a.R(z10, i11, i12, i13, i14);
    }

    @Deprecated
    public void removeVisibilityListener(m mVar) {
        this.f13581d.remove(mVar);
    }

    public void setAnimationEnabled(boolean z10) {
        this.f13575a.Y(z10);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f13620w0 = new long[0];
            this.f13622x0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) androidx.media3.common.util.a.e(zArr);
            androidx.media3.common.util.a.a(jArr.length == zArr2.length);
            this.f13620w0 = jArr;
            this.f13622x0 = zArr2;
        }
        t0();
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        this.f13596k0 = dVar;
        j0(this.f13621x, dVar != null);
        j0(this.f13623y, dVar != null);
    }

    public void setPlayer(@Nullable androidx.media3.common.a0 a0Var) {
        androidx.media3.common.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        androidx.media3.common.util.a.a(a0Var == null || a0Var.k() == Looper.getMainLooper());
        androidx.media3.common.a0 a0Var2 = this.f13594j0;
        if (a0Var2 == a0Var) {
            return;
        }
        if (a0Var2 != null) {
            a0Var2.L(this.f13579c);
        }
        this.f13594j0 = a0Var;
        if (a0Var != null) {
            a0Var.M(this.f13579c);
        }
        f0();
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
    }

    public void setRepeatToggleModes(int i11) {
        this.f13614t0 = i11;
        androidx.media3.common.a0 a0Var = this.f13594j0;
        if (a0Var != null && a0Var.h(15)) {
            int repeatMode = this.f13594j0.getRepeatMode();
            if (i11 == 0 && repeatMode != 0) {
                this.f13594j0.setRepeatMode(0);
            } else if (i11 == 1 && repeatMode == 2) {
                this.f13594j0.setRepeatMode(1);
            } else if (i11 == 2 && repeatMode == 1) {
                this.f13594j0.setRepeatMode(2);
            }
        }
        this.f13575a.Z(this.f13613t, i11 != 0);
        o0();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.f13575a.Z(this.f13605p, z10);
        k0();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z10) {
        this.f13602n0 = z10;
        t0();
    }

    public void setShowNextButton(boolean z10) {
        this.f13575a.Z(this.f13601n, z10);
        k0();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z10) {
        this.f13604o0 = z10;
        l0();
    }

    public void setShowPreviousButton(boolean z10) {
        this.f13575a.Z(this.f13599m, z10);
        k0();
    }

    public void setShowRewindButton(boolean z10) {
        this.f13575a.Z(this.f13607q, z10);
        k0();
    }

    public void setShowShuffleButton(boolean z10) {
        this.f13575a.Z(this.f13615u, z10);
        s0();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.f13575a.Z(this.f13619w, z10);
    }

    public void setShowTimeoutMs(int i11) {
        this.f13610r0 = i11;
        if (isFullyVisible()) {
            this.f13575a.X();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.f13575a.Z(this.f13617v, z10);
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.f13612s0 = androidx.media3.common.util.a1.p(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        ImageView imageView = this.f13617v;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
            g0(onClickListener != null, this.f13617v);
        }
    }

    public void show() {
        this.f13575a.c0();
    }

    public void updateIsFullscreen(boolean z10) {
        if (this.f13598l0 == z10) {
            return;
        }
        this.f13598l0 = z10;
        i0(this.f13621x, z10);
        i0(this.f13623y, z10);
        d dVar = this.f13596k0;
        if (dVar != null) {
            dVar.q(z10);
        }
    }
}
