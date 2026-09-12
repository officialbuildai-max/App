package com.google.android.exoplayer2.ui;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.p3;
import com.google.android.exoplayer2.q2;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverrides;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.n0;
import com.google.android.exoplayer2.v1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class StyledPlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;

    /* renamed from: v0, reason: collision with root package name */
    private static final float[] f27026v0;
    private final Drawable A;
    private final Drawable B;
    private final float C;
    private final float D;
    private final String E;
    private final String F;
    private final Drawable G;
    private final Drawable H;
    private final String I;
    private final String J;
    private final Drawable K;
    private final Drawable L;
    private final String M;
    private final String N;
    private o2 O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    private int U;
    private int V;
    private long[] W;

    /* renamed from: a, reason: collision with root package name */
    private final c f27027a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean[] f27028a0;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f27029b;

    /* renamed from: b0, reason: collision with root package name */
    private long[] f27030b0;

    /* renamed from: c, reason: collision with root package name */
    private final View f27031c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean[] f27032c0;

    /* renamed from: d, reason: collision with root package name */
    private final View f27033d;

    /* renamed from: d0, reason: collision with root package name */
    private long f27034d0;

    /* renamed from: e, reason: collision with root package name */
    private final View f27035e;

    /* renamed from: e0, reason: collision with root package name */
    private i0 f27036e0;

    /* renamed from: f, reason: collision with root package name */
    private final View f27037f;

    /* renamed from: f0, reason: collision with root package name */
    private Resources f27038f0;

    /* renamed from: g, reason: collision with root package name */
    private final View f27039g;

    /* renamed from: g0, reason: collision with root package name */
    private RecyclerView f27040g0;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f27041h;

    /* renamed from: h0, reason: collision with root package name */
    private h f27042h0;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f27043i;

    /* renamed from: i0, reason: collision with root package name */
    private e f27044i0;

    /* renamed from: j, reason: collision with root package name */
    private final ImageView f27045j;

    /* renamed from: j0, reason: collision with root package name */
    private PopupWindow f27046j0;

    /* renamed from: k, reason: collision with root package name */
    private final ImageView f27047k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f27048k0;

    /* renamed from: l, reason: collision with root package name */
    private final View f27049l;

    /* renamed from: l0, reason: collision with root package name */
    private int f27050l0;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f27051m;

    /* renamed from: m0, reason: collision with root package name */
    private j f27052m0;

    /* renamed from: n, reason: collision with root package name */
    private final TextView f27053n;

    /* renamed from: n0, reason: collision with root package name */
    private b f27054n0;

    /* renamed from: o, reason: collision with root package name */
    private final n0 f27055o;

    /* renamed from: o0, reason: collision with root package name */
    private o0 f27056o0;

    /* renamed from: p, reason: collision with root package name */
    private final StringBuilder f27057p;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f27058p0;

    /* renamed from: q, reason: collision with root package name */
    private final Formatter f27059q;

    /* renamed from: q0, reason: collision with root package name */
    private ImageView f27060q0;

    /* renamed from: r, reason: collision with root package name */
    private final k3.b f27061r;

    /* renamed from: r0, reason: collision with root package name */
    private ImageView f27062r0;

    /* renamed from: s, reason: collision with root package name */
    private final k3.d f27063s;

    /* renamed from: s0, reason: collision with root package name */
    private View f27064s0;

    /* renamed from: t, reason: collision with root package name */
    private final Runnable f27065t;

    /* renamed from: t0, reason: collision with root package name */
    private View f27066t0;

    /* renamed from: u, reason: collision with root package name */
    private final Drawable f27067u;

    /* renamed from: u0, reason: collision with root package name */
    private View f27068u0;

    /* renamed from: v, reason: collision with root package name */
    private final Drawable f27069v;

    /* renamed from: w, reason: collision with root package name */
    private final Drawable f27070w;

    /* renamed from: x, reason: collision with root package name */
    private final String f27071x;

    /* renamed from: y, reason: collision with root package name */
    private final String f27072y;

    /* renamed from: z, reason: collision with root package name */
    private final String f27073z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class b extends l {
        private b() {
            super();
        }

        private boolean o(TrackSelectionOverrides trackSelectionOverrides) {
            for (int i11 = 0; i11 < this.f27094a.size(); i11++) {
                if (trackSelectionOverrides.getOverride(((k) this.f27094a.get(i11)).f27091a.getTrackGroup()) != null) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(View view) {
            if (StyledPlayerControlView.this.O == null) {
                return;
            }
            TrackSelectionParameters l11 = StyledPlayerControlView.this.O.l();
            TrackSelectionOverrides build = l11.trackSelectionOverrides.buildUpon().clearOverridesOfType(1).build();
            HashSet hashSet = new HashSet(l11.f26807z);
            hashSet.remove(1);
            ((o2) com.google.android.exoplayer2.util.p0.j(StyledPlayerControlView.this.O)).D(l11.a().setTrackSelectionOverrides(build).E(hashSet).A());
            StyledPlayerControlView.this.f27042h0.i(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
            StyledPlayerControlView.this.f27046j0.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void k(i iVar) {
            iVar.f27088a.setText(R$string.exo_track_selection_auto);
            iVar.f27089b.setVisibility(o(((o2) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.O)).l().trackSelectionOverrides) ? 4 : 0);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.b.this.q(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void m(String str) {
            StyledPlayerControlView.this.f27042h0.i(1, str);
        }

        public void p(List list) {
            this.f27094a = list;
            TrackSelectionParameters l11 = ((o2) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.O)).l();
            if (list.isEmpty()) {
                StyledPlayerControlView.this.f27042h0.i(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_none));
                return;
            }
            if (!o(l11.trackSelectionOverrides)) {
                StyledPlayerControlView.this.f27042h0.i(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
                return;
            }
            for (int i11 = 0; i11 < list.size(); i11++) {
                k kVar = (k) list.get(i11);
                if (kVar.a()) {
                    StyledPlayerControlView.this.f27042h0.i(1, kVar.f27093c);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private final class c implements o2.d, n0.a, View.OnClickListener, PopupWindow.OnDismissListener {
        private c() {
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void l(n0 n0Var, long j11) {
            if (StyledPlayerControlView.this.f27053n != null) {
                StyledPlayerControlView.this.f27053n.setText(com.google.android.exoplayer2.util.p0.h0(StyledPlayerControlView.this.f27057p, StyledPlayerControlView.this.f27059q, j11));
            }
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onAvailableCommandsChanged(o2.b bVar) {
            q2.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o2 o2Var = StyledPlayerControlView.this.O;
            if (o2Var == null) {
                return;
            }
            StyledPlayerControlView.this.f27036e0.X();
            if (StyledPlayerControlView.this.f27033d == view) {
                o2Var.m();
                return;
            }
            if (StyledPlayerControlView.this.f27031c == view) {
                o2Var.f();
                return;
            }
            if (StyledPlayerControlView.this.f27037f == view) {
                if (o2Var.getPlaybackState() != 4) {
                    o2Var.v();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.f27039g == view) {
                o2Var.w();
                return;
            }
            if (StyledPlayerControlView.this.f27035e == view) {
                StyledPlayerControlView.this.V(o2Var);
                return;
            }
            if (StyledPlayerControlView.this.f27045j == view) {
                o2Var.setRepeatMode(com.google.android.exoplayer2.util.f0.a(o2Var.getRepeatMode(), StyledPlayerControlView.this.V));
                return;
            }
            if (StyledPlayerControlView.this.f27047k == view) {
                o2Var.setShuffleModeEnabled(!o2Var.getShuffleModeEnabled());
                return;
            }
            if (StyledPlayerControlView.this.f27064s0 == view) {
                StyledPlayerControlView.this.f27036e0.W();
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.W(styledPlayerControlView.f27042h0);
                return;
            }
            if (StyledPlayerControlView.this.f27066t0 == view) {
                StyledPlayerControlView.this.f27036e0.W();
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                styledPlayerControlView2.W(styledPlayerControlView2.f27044i0);
            } else if (StyledPlayerControlView.this.f27068u0 == view) {
                StyledPlayerControlView.this.f27036e0.W();
                StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                styledPlayerControlView3.W(styledPlayerControlView3.f27054n0);
            } else if (StyledPlayerControlView.this.f27058p0 == view) {
                StyledPlayerControlView.this.f27036e0.W();
                StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                styledPlayerControlView4.W(styledPlayerControlView4.f27052m0);
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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (StyledPlayerControlView.this.f27048k0) {
                StyledPlayerControlView.this.f27036e0.X();
            }
        }

        @Override // com.google.android.exoplayer2.o2.d
        public void onEvents(o2 o2Var, o2.c cVar) {
            if (cVar.b(4, 5)) {
                StyledPlayerControlView.this.p0();
            }
            if (cVar.b(4, 5, 7)) {
                StyledPlayerControlView.this.r0();
            }
            if (cVar.a(8)) {
                StyledPlayerControlView.this.s0();
            }
            if (cVar.a(9)) {
                StyledPlayerControlView.this.v0();
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                StyledPlayerControlView.this.o0();
            }
            if (cVar.b(11, 0)) {
                StyledPlayerControlView.this.w0();
            }
            if (cVar.a(12)) {
                StyledPlayerControlView.this.q0();
            }
            if (cVar.a(2)) {
                StyledPlayerControlView.this.x0();
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
            StyledPlayerControlView.this.S = false;
            if (!z10 && StyledPlayerControlView.this.O != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.i0(styledPlayerControlView.O, j11);
            }
            StyledPlayerControlView.this.f27036e0.X();
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void r(n0 n0Var, long j11) {
            StyledPlayerControlView.this.S = true;
            if (StyledPlayerControlView.this.f27053n != null) {
                StyledPlayerControlView.this.f27053n.setText(com.google.android.exoplayer2.util.p0.h0(StyledPlayerControlView.this.f27057p, StyledPlayerControlView.this.f27059q, j11));
            }
            StyledPlayerControlView.this.f27036e0.W();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class e extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f27076a;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f27077b;

        /* renamed from: c, reason: collision with root package name */
        private int f27078c;

        public e(String[] strArr, float[] fArr) {
            this.f27076a = strArr;
            this.f27077b = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(int i11, View view) {
            if (i11 != this.f27078c) {
                StyledPlayerControlView.this.setPlaybackSpeed(this.f27077b[i11]);
            }
            StyledPlayerControlView.this.f27046j0.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f27076a.length;
        }

        public String h() {
            return this.f27076a[this.f27078c];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i11) {
            String[] strArr = this.f27076a;
            if (i11 < strArr.length) {
                iVar.f27088a.setText(strArr[i11]);
            }
            iVar.f27089b.setVisibility(i11 == this.f27078c ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.e.this.i(i11, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public void l(float f11) {
            int i11 = 0;
            float f12 = Float.MAX_VALUE;
            int i12 = 0;
            while (true) {
                float[] fArr = this.f27077b;
                if (i11 >= fArr.length) {
                    this.f27078c = i12;
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

    /* loaded from: classes3.dex */
    public interface f {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class g extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f27080a;

        /* renamed from: b, reason: collision with root package name */
        private final TextView f27081b;

        /* renamed from: c, reason: collision with root package name */
        private final ImageView f27082c;

        public g(View view) {
            super(view);
            if (com.google.android.exoplayer2.util.p0.f27680a < 26) {
                view.setFocusable(true);
            }
            this.f27080a = (TextView) view.findViewById(R$id.exo_main_text);
            this.f27081b = (TextView) view.findViewById(R$id.exo_sub_text);
            this.f27082c = (ImageView) view.findViewById(R$id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StyledPlayerControlView.g.this.j(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(View view) {
            StyledPlayerControlView.this.f0(getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class h extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f27084a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f27085b;

        /* renamed from: c, reason: collision with root package name */
        private final Drawable[] f27086c;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.f27084a = strArr;
            this.f27085b = new String[strArr.length];
            this.f27086c = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i11) {
            gVar.f27080a.setText(this.f27084a[i11]);
            if (this.f27085b[i11] == null) {
                gVar.f27081b.setVisibility(8);
            } else {
                gVar.f27081b.setText(this.f27085b[i11]);
            }
            if (this.f27086c[i11] == null) {
                gVar.f27082c.setVisibility(8);
            } else {
                gVar.f27082c.setImageDrawable(this.f27086c[i11]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f27084a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public void i(int i11, String str) {
            this.f27085b[i11] = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class i extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f27088a;

        /* renamed from: b, reason: collision with root package name */
        public final View f27089b;

        public i(View view) {
            super(view);
            if (com.google.android.exoplayer2.util.p0.f27680a < 26) {
                view.setFocusable(true);
            }
            this.f27088a = (TextView) view.findViewById(R$id.exo_text);
            this.f27089b = view.findViewById(R$id.exo_check);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class j extends l {
        private j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(View view) {
            if (StyledPlayerControlView.this.O != null) {
                TrackSelectionParameters l11 = StyledPlayerControlView.this.O.l();
                StyledPlayerControlView.this.O.D(l11.a().E(new ImmutableSet.a().l(l11.f26807z).a(3).e()).A());
                StyledPlayerControlView.this.f27046j0.dismiss();
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i11) {
            super.onBindViewHolder(iVar, i11);
            if (i11 > 0) {
                iVar.f27089b.setVisibility(((k) this.f27094a.get(i11 + (-1))).a() ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void k(i iVar) {
            boolean z10;
            iVar.f27088a.setText(R$string.exo_track_selection_none);
            int i11 = 0;
            while (true) {
                if (i11 >= this.f27094a.size()) {
                    z10 = true;
                    break;
                } else {
                    if (((k) this.f27094a.get(i11)).a()) {
                        z10 = false;
                        break;
                    }
                    i11++;
                }
            }
            iVar.f27089b.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.j.this.p(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
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
            if (StyledPlayerControlView.this.f27058p0 != null) {
                ImageView imageView = StyledPlayerControlView.this.f27058p0;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                imageView.setImageDrawable(z10 ? styledPlayerControlView.G : styledPlayerControlView.H);
                StyledPlayerControlView.this.f27058p0.setContentDescription(z10 ? StyledPlayerControlView.this.I : StyledPlayerControlView.this.J);
            }
            this.f27094a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        public final TracksInfo.TrackGroupInfo f27091a;

        /* renamed from: b, reason: collision with root package name */
        public final int f27092b;

        /* renamed from: c, reason: collision with root package name */
        public final String f27093c;

        public k(TracksInfo tracksInfo, int i11, int i12, String str) {
            this.f27091a = (TracksInfo.TrackGroupInfo) tracksInfo.getTrackGroupInfos().get(i11);
            this.f27092b = i12;
            this.f27093c = str;
        }

        public boolean a() {
            return this.f27091a.isTrackSelected(this.f27092b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public abstract class l extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        protected List f27094a = new ArrayList();

        protected l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(TrackGroup trackGroup, k kVar, View view) {
            if (StyledPlayerControlView.this.O == null) {
                return;
            }
            TrackSelectionParameters l11 = StyledPlayerControlView.this.O.l();
            TrackSelectionOverrides build = l11.trackSelectionOverrides.buildUpon().setOverrideForType(new TrackSelectionOverrides.TrackSelectionOverride(trackGroup, ImmutableList.of(Integer.valueOf(kVar.f27092b)))).build();
            HashSet hashSet = new HashSet(l11.f26807z);
            hashSet.remove(Integer.valueOf(kVar.f27091a.getTrackType()));
            ((o2) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.O)).D(l11.a().setTrackSelectionOverrides(build).E(hashSet).A());
            m(kVar.f27093c);
            StyledPlayerControlView.this.f27046j0.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f27094a.isEmpty()) {
                return 0;
            }
            return this.f27094a.size() + 1;
        }

        protected void h() {
            this.f27094a = Collections.emptyList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j */
        public void onBindViewHolder(i iVar, int i11) {
            if (StyledPlayerControlView.this.O == null) {
                return;
            }
            if (i11 == 0) {
                k(iVar);
                return;
            }
            final k kVar = (k) this.f27094a.get(i11 - 1);
            final TrackGroup trackGroup = kVar.f27091a.getTrackGroup();
            boolean z10 = ((o2) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.O)).l().trackSelectionOverrides.getOverride(trackGroup) != null && kVar.a();
            iVar.f27088a.setText(kVar.f27093c);
            iVar.f27089b.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.l.this.i(trackGroup, kVar, view);
                }
            });
        }

        protected abstract void k(i iVar);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        protected abstract void m(String str);
    }

    /* loaded from: classes3.dex */
    public interface m {
        void l(int i11);
    }

    static {
        m1.a("goog.exo.ui");
        f27026v0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, attributeSet);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i11);
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        c cVar;
        boolean z18;
        boolean z19;
        TextView textView;
        boolean z20;
        ImageView imageView;
        boolean z21;
        int i12 = R$layout.exo_styled_player_control_view;
        this.T = 5000;
        this.V = 0;
        this.U = 200;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.StyledPlayerControlView, i11, 0);
            try {
                i12 = obtainStyledAttributes.getResourceId(R$styleable.StyledPlayerControlView_controller_layout_id, i12);
                this.T = obtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_show_timeout, this.T);
                this.V = Y(obtainStyledAttributes, this.V);
                boolean z22 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z23 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z24 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z25 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_next_button, true);
                boolean z26 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z27 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z28 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_time_bar_min_update_interval, this.U));
                boolean z29 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_animation_enabled, true);
                obtainStyledAttributes.recycle();
                z11 = z26;
                z12 = z27;
                z14 = z22;
                z15 = z23;
                z16 = z24;
                z13 = z29;
                z17 = z25;
                z10 = z28;
            } catch (Throwable th2) {
                obtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = true;
            z14 = true;
            z15 = true;
            z16 = true;
            z17 = true;
        }
        LayoutInflater.from(context).inflate(i12, this);
        setDescendantFocusability(262144);
        c cVar2 = new c();
        this.f27027a = cVar2;
        this.f27029b = new CopyOnWriteArrayList();
        this.f27061r = new k3.b();
        this.f27063s = new k3.d();
        StringBuilder sb2 = new StringBuilder();
        this.f27057p = sb2;
        this.f27059q = new Formatter(sb2, Locale.getDefault());
        this.W = new long[0];
        this.f27028a0 = new boolean[0];
        this.f27030b0 = new long[0];
        this.f27032c0 = new boolean[0];
        this.f27065t = new Runnable() { // from class: com.google.android.exoplayer2.ui.n
            @Override // java.lang.Runnable
            public final void run() {
                StyledPlayerControlView.this.r0();
            }
        };
        this.f27051m = (TextView) findViewById(R$id.exo_duration);
        this.f27053n = (TextView) findViewById(R$id.exo_position);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_subtitle);
        this.f27058p0 = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar2);
        }
        ImageView imageView3 = (ImageView) findViewById(R$id.exo_fullscreen);
        this.f27060q0 = imageView3;
        a0(imageView3, new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StyledPlayerControlView.this.d0(view);
            }
        });
        ImageView imageView4 = (ImageView) findViewById(R$id.exo_minimal_fullscreen);
        this.f27062r0 = imageView4;
        a0(imageView4, new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StyledPlayerControlView.this.d0(view);
            }
        });
        View findViewById = findViewById(R$id.exo_settings);
        this.f27064s0 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(cVar2);
        }
        View findViewById2 = findViewById(R$id.exo_playback_speed);
        this.f27066t0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(cVar2);
        }
        View findViewById3 = findViewById(R$id.exo_audio_track);
        this.f27068u0 = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(cVar2);
        }
        n0 n0Var = (n0) findViewById(R$id.exo_progress);
        View findViewById4 = findViewById(R$id.exo_progress_placeholder);
        if (n0Var != null) {
            this.f27055o = n0Var;
            cVar = cVar2;
            z18 = z13;
            z19 = z10;
            textView = null;
        } else if (findViewById4 != null) {
            textView = null;
            cVar = cVar2;
            z18 = z13;
            z19 = z10;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById4.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById4);
            viewGroup.removeView(findViewById4);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f27055o = defaultTimeBar;
        } else {
            cVar = cVar2;
            z18 = z13;
            z19 = z10;
            textView = null;
            this.f27055o = null;
        }
        n0 n0Var2 = this.f27055o;
        c cVar3 = cVar;
        if (n0Var2 != null) {
            n0Var2.addListener(cVar3);
        }
        View findViewById5 = findViewById(R$id.exo_play_pause);
        this.f27035e = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(cVar3);
        }
        View findViewById6 = findViewById(R$id.exo_prev);
        this.f27031c = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(cVar3);
        }
        View findViewById7 = findViewById(R$id.exo_next);
        this.f27033d = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(cVar3);
        }
        Typeface g11 = y0.h.g(context, R$font.roboto_medium_numbers);
        View findViewById8 = findViewById(R$id.exo_rew);
        TextView textView2 = findViewById8 == null ? (TextView) findViewById(R$id.exo_rew_with_amount) : textView;
        this.f27043i = textView2;
        if (textView2 != null) {
            textView2.setTypeface(g11);
        }
        findViewById8 = findViewById8 == null ? textView2 : findViewById8;
        this.f27039g = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(cVar3);
        }
        View findViewById9 = findViewById(R$id.exo_ffwd);
        TextView textView3 = findViewById9 == null ? (TextView) findViewById(R$id.exo_ffwd_with_amount) : null;
        this.f27041h = textView3;
        if (textView3 != null) {
            textView3.setTypeface(g11);
        }
        findViewById9 = findViewById9 == null ? textView3 : findViewById9;
        this.f27037f = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(cVar3);
        }
        ImageView imageView5 = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f27045j = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar3);
        }
        ImageView imageView6 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f27047k = imageView6;
        if (imageView6 != null) {
            imageView6.setOnClickListener(cVar3);
        }
        this.f27038f0 = context.getResources();
        this.C = r6.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = this.f27038f0.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View findViewById10 = findViewById(R$id.exo_vr);
        this.f27049l = findViewById10;
        if (findViewById10 != null) {
            l0(false, findViewById10);
        }
        i0 i0Var = new i0(this);
        this.f27036e0 = i0Var;
        boolean z30 = z19;
        i0Var.Y(z18);
        boolean z31 = z12;
        this.f27042h0 = new h(new String[]{this.f27038f0.getString(R$string.exo_controls_playback_speed), this.f27038f0.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{this.f27038f0.getDrawable(R$drawable.exo_styled_controls_speed), this.f27038f0.getDrawable(R$drawable.exo_styled_controls_audiotrack)});
        this.f27050l0 = this.f27038f0.getDimensionPixelSize(R$dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.exo_styled_settings_list, (ViewGroup) null);
        this.f27040g0 = recyclerView;
        recyclerView.setAdapter(this.f27042h0);
        this.f27040g0.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) this.f27040g0, -2, -2, true);
        this.f27046j0 = popupWindow;
        if (com.google.android.exoplayer2.util.p0.f27680a < 23) {
            z20 = false;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            z20 = false;
        }
        this.f27046j0.setOnDismissListener(cVar3);
        this.f27048k0 = true;
        this.f27056o0 = new com.google.android.exoplayer2.ui.g(getResources());
        this.G = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_subtitle_on);
        this.H = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_subtitle_off);
        this.I = this.f27038f0.getString(R$string.exo_controls_cc_enabled_description);
        this.J = this.f27038f0.getString(R$string.exo_controls_cc_disabled_description);
        this.f27052m0 = new j();
        this.f27054n0 = new b();
        this.f27044i0 = new e(this.f27038f0.getStringArray(R$array.exo_controls_playback_speeds), f27026v0);
        this.K = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_fullscreen_exit);
        this.L = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_fullscreen_enter);
        this.f27067u = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_repeat_off);
        this.f27069v = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_repeat_one);
        this.f27070w = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_repeat_all);
        this.A = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_shuffle_on);
        this.B = this.f27038f0.getDrawable(R$drawable.exo_styled_controls_shuffle_off);
        this.M = this.f27038f0.getString(R$string.exo_controls_fullscreen_exit_description);
        this.N = this.f27038f0.getString(R$string.exo_controls_fullscreen_enter_description);
        this.f27071x = this.f27038f0.getString(R$string.exo_controls_repeat_off_description);
        this.f27072y = this.f27038f0.getString(R$string.exo_controls_repeat_one_description);
        this.f27073z = this.f27038f0.getString(R$string.exo_controls_repeat_all_description);
        this.E = this.f27038f0.getString(R$string.exo_controls_shuffle_on_description);
        this.F = this.f27038f0.getString(R$string.exo_controls_shuffle_off_description);
        this.f27036e0.Z((ViewGroup) findViewById(R$id.exo_bottom_bar), true);
        this.f27036e0.Z(findViewById9, z15);
        this.f27036e0.Z(findViewById8, z14);
        this.f27036e0.Z(findViewById6, z16);
        this.f27036e0.Z(findViewById7, z17);
        this.f27036e0.Z(imageView6, z11);
        this.f27036e0.Z(this.f27058p0, z31);
        this.f27036e0.Z(findViewById10, z30);
        i0 i0Var2 = this.f27036e0;
        if (this.V != 0) {
            z21 = true;
            imageView = imageView5;
        } else {
            imageView = imageView5;
            z21 = z20;
        }
        i0Var2.Z(imageView, z21);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.p
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
                StyledPlayerControlView.this.e0(view, i13, i14, i15, i16, i17, i18, i19, i20);
            }
        });
    }

    private static boolean S(k3 k3Var, k3.d dVar) {
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

    private void T(o2 o2Var) {
        o2Var.pause();
    }

    private void U(o2 o2Var) {
        int playbackState = o2Var.getPlaybackState();
        if (playbackState == 1) {
            o2Var.prepare();
        } else if (playbackState == 4) {
            h0(o2Var, o2Var.t(), C.TIME_UNSET);
        }
        o2Var.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(o2 o2Var) {
        int playbackState = o2Var.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !o2Var.getPlayWhenReady()) {
            U(o2Var);
        } else {
            T(o2Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(RecyclerView.Adapter adapter) {
        this.f27040g0.setAdapter(adapter);
        u0();
        this.f27048k0 = false;
        this.f27046j0.dismiss();
        this.f27048k0 = true;
        this.f27046j0.showAsDropDown(this, (getWidth() - this.f27046j0.getWidth()) - this.f27050l0, (-this.f27046j0.getHeight()) - this.f27050l0);
    }

    private ImmutableList X(TracksInfo tracksInfo, int i11) {
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList trackGroupInfos = tracksInfo.getTrackGroupInfos();
        for (int i12 = 0; i12 < trackGroupInfos.size(); i12++) {
            TracksInfo.TrackGroupInfo trackGroupInfo = (TracksInfo.TrackGroupInfo) trackGroupInfos.get(i12);
            if (trackGroupInfo.getTrackType() == i11) {
                TrackGroup trackGroup = trackGroupInfo.getTrackGroup();
                for (int i13 = 0; i13 < trackGroup.f25727a; i13++) {
                    if (trackGroupInfo.isTrackSupported(i13)) {
                        aVar.a(new k(tracksInfo, i12, i13, this.f27056o0.a(trackGroup.c(i13))));
                    }
                }
            }
        }
        return aVar.e();
    }

    private static int Y(TypedArray typedArray, int i11) {
        return typedArray.getInt(R$styleable.StyledPlayerControlView_repeat_toggle_modes, i11);
    }

    private void Z() {
        this.f27052m0.h();
        this.f27054n0.h();
        o2 o2Var = this.O;
        if (o2Var != null && o2Var.h(30) && this.O.h(29)) {
            TracksInfo currentTracksInfo = this.O.getCurrentTracksInfo();
            this.f27054n0.p(X(currentTracksInfo, 1));
            if (this.f27036e0.A(this.f27058p0)) {
                this.f27052m0.o(X(currentTracksInfo, 3));
            } else {
                this.f27052m0.o(ImmutableList.of());
            }
        }
    }

    private static void a0(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    private static boolean b0(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19 = i14 - i12;
        int i20 = i18 - i16;
        if (!(i13 - i11 == i17 - i15 && i19 == i20) && this.f27046j0.isShowing()) {
            u0();
            this.f27046j0.update(view, (getWidth() - this.f27046j0.getWidth()) - this.f27050l0, (-this.f27046j0.getHeight()) - this.f27050l0, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i11) {
        if (i11 == 0) {
            W(this.f27044i0);
        } else if (i11 == 1) {
            W(this.f27054n0);
        } else {
            this.f27046j0.dismiss();
        }
    }

    private void h0(o2 o2Var, int i11, long j11) {
        o2Var.seekTo(i11, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(o2 o2Var, long j11) {
        int t11;
        k3 currentTimeline = o2Var.getCurrentTimeline();
        if (this.R && !currentTimeline.u()) {
            int t12 = currentTimeline.t();
            t11 = 0;
            while (true) {
                long g11 = currentTimeline.r(t11, this.f27063s).g();
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
        h0(o2Var, t11, j11);
        r0();
    }

    private boolean j0() {
        o2 o2Var = this.O;
        return (o2Var == null || o2Var.getPlaybackState() == 4 || this.O.getPlaybackState() == 1 || !this.O.getPlayWhenReady()) ? false : true;
    }

    private void l0(boolean z10, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? this.C : this.D);
    }

    private void m0() {
        o2 o2Var = this.O;
        int r11 = (int) ((o2Var != null ? o2Var.r() : MBInterstitialActivity.WEB_LOAD_TIME) / 1000);
        TextView textView = this.f27041h;
        if (textView != null) {
            textView.setText(String.valueOf(r11));
        }
        View view = this.f27037f;
        if (view != null) {
            view.setContentDescription(this.f27038f0.getQuantityString(R$plurals.exo_controls_fastforward_by_amount_description, r11, Integer.valueOf(r11)));
        }
    }

    private static void n0(View view, boolean z10) {
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
    public void o0() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (isVisible() && this.P) {
            o2 o2Var = this.O;
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
            if (z13) {
                t0();
            }
            if (z14) {
                m0();
            }
            l0(z12, this.f27031c);
            l0(z13, this.f27039g);
            l0(z14, this.f27037f);
            l0(z11, this.f27033d);
            n0 n0Var = this.f27055o;
            if (n0Var != null) {
                n0Var.setEnabled(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        if (isVisible() && this.P && this.f27035e != null) {
            if (j0()) {
                ((ImageView) this.f27035e).setImageDrawable(this.f27038f0.getDrawable(R$drawable.exo_styled_controls_pause));
                this.f27035e.setContentDescription(this.f27038f0.getString(R$string.exo_controls_pause_description));
            } else {
                ((ImageView) this.f27035e).setImageDrawable(this.f27038f0.getDrawable(R$drawable.exo_styled_controls_play));
                this.f27035e.setContentDescription(this.f27038f0.getString(R$string.exo_controls_play_description));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        o2 o2Var = this.O;
        if (o2Var == null) {
            return;
        }
        this.f27044i0.l(o2Var.getPlaybackParameters().f25529a);
        this.f27042h0.i(0, this.f27044i0.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        long j11;
        long j12;
        if (isVisible() && this.P) {
            o2 o2Var = this.O;
            if (o2Var != null) {
                j11 = this.f27034d0 + o2Var.getContentPosition();
                j12 = this.f27034d0 + o2Var.u();
            } else {
                j11 = 0;
                j12 = 0;
            }
            TextView textView = this.f27053n;
            if (textView != null && !this.S) {
                textView.setText(com.google.android.exoplayer2.util.p0.h0(this.f27057p, this.f27059q, j11));
            }
            n0 n0Var = this.f27055o;
            if (n0Var != null) {
                n0Var.setPosition(j11);
                this.f27055o.setBufferedPosition(j12);
            }
            removeCallbacks(this.f27065t);
            int playbackState = o2Var == null ? 1 : o2Var.getPlaybackState();
            if (o2Var == null || !o2Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f27065t, 1000L);
                return;
            }
            n0 n0Var2 = this.f27055o;
            long min = Math.min(n0Var2 != null ? n0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (j11 % 1000));
            postDelayed(this.f27065t, com.google.android.exoplayer2.util.p0.r(o2Var.getPlaybackParameters().f25529a > 0.0f ? ((float) min) / r0 : 1000L, this.U, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        ImageView imageView;
        if (isVisible() && this.P && (imageView = this.f27045j) != null) {
            if (this.V == 0) {
                l0(false, imageView);
                return;
            }
            o2 o2Var = this.O;
            if (o2Var == null) {
                l0(false, imageView);
                this.f27045j.setImageDrawable(this.f27067u);
                this.f27045j.setContentDescription(this.f27071x);
                return;
            }
            l0(true, imageView);
            int repeatMode = o2Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f27045j.setImageDrawable(this.f27067u);
                this.f27045j.setContentDescription(this.f27071x);
            } else if (repeatMode == 1) {
                this.f27045j.setImageDrawable(this.f27069v);
                this.f27045j.setContentDescription(this.f27072y);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.f27045j.setImageDrawable(this.f27070w);
                this.f27045j.setContentDescription(this.f27073z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f11) {
        o2 o2Var = this.O;
        if (o2Var == null) {
            return;
        }
        o2Var.b(o2Var.getPlaybackParameters().e(f11));
    }

    private void t0() {
        o2 o2Var = this.O;
        int y10 = (int) ((o2Var != null ? o2Var.y() : 5000L) / 1000);
        TextView textView = this.f27043i;
        if (textView != null) {
            textView.setText(String.valueOf(y10));
        }
        View view = this.f27039g;
        if (view != null) {
            view.setContentDescription(this.f27038f0.getQuantityString(R$plurals.exo_controls_rewind_by_amount_description, y10, Integer.valueOf(y10)));
        }
    }

    private void u0() {
        this.f27040g0.measure(0, 0);
        this.f27046j0.setWidth(Math.min(this.f27040g0.getMeasuredWidth(), getWidth() - (this.f27050l0 * 2)));
        this.f27046j0.setHeight(Math.min(getHeight() - (this.f27050l0 * 2), this.f27040g0.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        ImageView imageView;
        if (isVisible() && this.P && (imageView = this.f27047k) != null) {
            o2 o2Var = this.O;
            if (!this.f27036e0.A(imageView)) {
                l0(false, this.f27047k);
                return;
            }
            if (o2Var == null) {
                l0(false, this.f27047k);
                this.f27047k.setImageDrawable(this.B);
                this.f27047k.setContentDescription(this.F);
            } else {
                l0(true, this.f27047k);
                this.f27047k.setImageDrawable(o2Var.getShuffleModeEnabled() ? this.A : this.B);
                this.f27047k.setContentDescription(o2Var.getShuffleModeEnabled() ? this.E : this.F);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        int i11;
        k3.d dVar;
        o2 o2Var = this.O;
        if (o2Var == null) {
            return;
        }
        boolean z10 = true;
        this.R = this.Q && S(o2Var.getCurrentTimeline(), this.f27063s);
        long j11 = 0;
        this.f27034d0 = 0L;
        k3 currentTimeline = o2Var.getCurrentTimeline();
        if (currentTimeline.u()) {
            i11 = 0;
        } else {
            int t11 = o2Var.t();
            boolean z11 = this.R;
            int i12 = z11 ? 0 : t11;
            int t12 = z11 ? currentTimeline.t() - 1 : t11;
            long j12 = 0;
            i11 = 0;
            while (true) {
                if (i12 > t12) {
                    break;
                }
                if (i12 == t11) {
                    this.f27034d0 = com.google.android.exoplayer2.util.p0.e1(j12);
                }
                currentTimeline.r(i12, this.f27063s);
                k3.d dVar2 = this.f27063s;
                if (dVar2.f25236n == C.TIME_UNSET) {
                    com.google.android.exoplayer2.util.a.g(this.R ^ z10);
                    break;
                }
                int i13 = dVar2.f25237o;
                while (true) {
                    dVar = this.f27063s;
                    if (i13 <= dVar.f25238p) {
                        currentTimeline.j(i13, this.f27061r);
                        int f11 = this.f27061r.f();
                        for (int r11 = this.f27061r.r(); r11 < f11; r11++) {
                            long i14 = this.f27061r.i(r11);
                            if (i14 == Long.MIN_VALUE) {
                                long j13 = this.f27061r.f25211d;
                                if (j13 != C.TIME_UNSET) {
                                    i14 = j13;
                                }
                            }
                            long q11 = i14 + this.f27061r.q();
                            if (q11 >= 0) {
                                long[] jArr = this.W;
                                if (i11 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.W = Arrays.copyOf(jArr, length);
                                    this.f27028a0 = Arrays.copyOf(this.f27028a0, length);
                                }
                                this.W[i11] = com.google.android.exoplayer2.util.p0.e1(j12 + q11);
                                this.f27028a0[i11] = this.f27061r.s(r11);
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
        TextView textView = this.f27051m;
        if (textView != null) {
            textView.setText(com.google.android.exoplayer2.util.p0.h0(this.f27057p, this.f27059q, e12));
        }
        n0 n0Var = this.f27055o;
        if (n0Var != null) {
            n0Var.setDuration(e12);
            int length2 = this.f27030b0.length;
            int i15 = i11 + length2;
            long[] jArr2 = this.W;
            if (i15 > jArr2.length) {
                this.W = Arrays.copyOf(jArr2, i15);
                this.f27028a0 = Arrays.copyOf(this.f27028a0, i15);
            }
            System.arraycopy(this.f27030b0, 0, this.W, i11, length2);
            System.arraycopy(this.f27032c0, 0, this.f27028a0, i11, length2);
            this.f27055o.setAdGroupTimesMs(this.W, this.f27028a0, i15);
        }
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        Z();
        l0(this.f27052m0.getItemCount() > 0, this.f27058p0);
    }

    public void addVisibilityListener(m mVar) {
        com.google.android.exoplayer2.util.a.e(mVar);
        this.f27029b.add(mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0() {
        Iterator it = this.f27029b.iterator();
        while (it.hasNext()) {
            ((m) it.next()).l(getVisibility());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        o2 o2Var = this.O;
        if (o2Var == null || !b0(keyCode)) {
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
            V(o2Var);
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
            U(o2Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        T(o2Var);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0() {
        View view = this.f27035e;
        if (view != null) {
            view.requestFocus();
        }
    }

    @Nullable
    public o2 getPlayer() {
        return this.O;
    }

    public int getRepeatToggleModes() {
        return this.V;
    }

    public boolean getShowShuffleButton() {
        return this.f27036e0.A(this.f27047k);
    }

    public boolean getShowSubtitleButton() {
        return this.f27036e0.A(this.f27058p0);
    }

    public int getShowTimeoutMs() {
        return this.T;
    }

    public boolean getShowVrButton() {
        return this.f27036e0.A(this.f27049l);
    }

    public void hide() {
        this.f27036e0.C();
    }

    public void hideImmediately() {
        this.f27036e0.F();
    }

    public boolean isAnimationEnabled() {
        return this.f27036e0.I();
    }

    public boolean isFullyVisible() {
        return this.f27036e0.J();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0() {
        p0();
        o0();
        s0();
        v0();
        x0();
        q0();
        w0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f27036e0.P();
        this.P = true;
        if (isFullyVisible()) {
            this.f27036e0.X();
        }
        k0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f27036e0.Q();
        this.P = false;
        removeCallbacks(this.f27065t);
        this.f27036e0.W();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        this.f27036e0.R(z10, i11, i12, i13, i14);
    }

    public void removeVisibilityListener(m mVar) {
        this.f27029b.remove(mVar);
    }

    public void setAnimationEnabled(boolean z10) {
        this.f27036e0.Y(z10);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f27030b0 = new long[0];
            this.f27032c0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.a.e(zArr);
            com.google.android.exoplayer2.util.a.a(jArr.length == zArr2.length);
            this.f27030b0 = jArr;
            this.f27032c0 = zArr2;
        }
        w0();
    }

    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        n0(this.f27060q0, dVar != null);
        n0(this.f27062r0, dVar != null);
    }

    public void setPlayer(@Nullable o2 o2Var) {
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.util.a.a(o2Var == null || o2Var.k() == Looper.getMainLooper());
        o2 o2Var2 = this.O;
        if (o2Var2 == o2Var) {
            return;
        }
        if (o2Var2 != null) {
            o2Var2.A(this.f27027a);
        }
        this.O = o2Var;
        if (o2Var != null) {
            o2Var.C(this.f27027a);
        }
        k0();
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
    }

    public void setRepeatToggleModes(int i11) {
        this.V = i11;
        o2 o2Var = this.O;
        if (o2Var != null) {
            int repeatMode = o2Var.getRepeatMode();
            if (i11 == 0 && repeatMode != 0) {
                this.O.setRepeatMode(0);
            } else if (i11 == 1 && repeatMode == 2) {
                this.O.setRepeatMode(1);
            } else if (i11 == 2 && repeatMode == 1) {
                this.O.setRepeatMode(2);
            }
        }
        this.f27036e0.Z(this.f27045j, i11 != 0);
        s0();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.f27036e0.Z(this.f27037f, z10);
        o0();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.Q = z10;
        w0();
    }

    public void setShowNextButton(boolean z10) {
        this.f27036e0.Z(this.f27033d, z10);
        o0();
    }

    public void setShowPreviousButton(boolean z10) {
        this.f27036e0.Z(this.f27031c, z10);
        o0();
    }

    public void setShowRewindButton(boolean z10) {
        this.f27036e0.Z(this.f27039g, z10);
        o0();
    }

    public void setShowShuffleButton(boolean z10) {
        this.f27036e0.Z(this.f27047k, z10);
        v0();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.f27036e0.Z(this.f27058p0, z10);
    }

    public void setShowTimeoutMs(int i11) {
        this.T = i11;
        if (isFullyVisible()) {
            this.f27036e0.X();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.f27036e0.Z(this.f27049l, z10);
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.U = com.google.android.exoplayer2.util.p0.q(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f27049l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            l0(onClickListener != null, this.f27049l);
        }
    }

    public void show() {
        this.f27036e0.c0();
    }
}
