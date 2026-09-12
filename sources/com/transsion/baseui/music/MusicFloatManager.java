package com.transsion.baseui.music;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.g0;
import com.google.android.material.card.MaterialCardView;
import com.transsion.baseui.activity.BaseMusicFloatActivity;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import ko.f0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class MusicFloatManager implements com.transsion.player.orplayer.f {

    /* renamed from: h, reason: collision with root package name */
    public static final a f43508h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f43509i = 8;

    /* renamed from: j, reason: collision with root package name */
    private static final Lazy f43510j = LazyKt.b(new Function0() { // from class: com.transsion.baseui.music.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MusicFloatManager c11;
            c11 = MusicFloatManager.c();
            return c11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private MediaItem f43512b;

    /* renamed from: c, reason: collision with root package name */
    private String f43513c;

    /* renamed from: e, reason: collision with root package name */
    private com.transsion.player.orplayer.g f43515e;

    /* renamed from: g, reason: collision with root package name */
    private final Map f43517g;

    /* renamed from: a, reason: collision with root package name */
    private boolean f43511a = true;

    /* renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList f43514d = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List f43516f = new ArrayList();

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final MusicFloatManager a() {
            return (MusicFloatManager) MusicFloatManager.f43510j.getValue();
        }

        public final MusicFloatManager b() {
            return a();
        }
    }

    public MusicFloatManager() {
        g0.f9674i.a().getLifecycle().a(com.transsion.baseui.music.a.f43533a);
        MusicReport.f43527a.c();
        this.f43517g = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MusicFloatManager c() {
        return new MusicFloatManager();
    }

    private final void j(long j11, long j12, int i11, int i12, ao.e eVar) {
        MediaItem i13;
        MediaItem i14;
        MediaItem i15;
        MediaItem i16;
        MediaItem i17;
        MediaItem i18;
        MediaItem i19;
        MediaItem i20;
        MediaItem i21;
        MediaItem i22;
        MediaItem i23;
        MediaItem i24;
        MediaItem i25;
        boolean z10 = false;
        if ((eVar == null || (i25 = eVar.i()) == null) ? false : Intrinsics.c(i25.isMusic(), Boolean.FALSE)) {
            return;
        }
        n nVar = (n) this.f43517g.get((eVar == null || (i24 = eVar.i()) == null) ? null : i24.getMediaId());
        if (!TextUtils.equals((eVar == null || (i23 = eVar.i()) == null) ? null : i23.getPageName(), "music_float")) {
            if (!((eVar == null || (i22 = eVar.i()) == null) ? false : Intrinsics.c(i22.getInBackground(), Boolean.TRUE))) {
                if (nVar != null) {
                    MusicReport.f43527a.d(nVar);
                    this.f43517g.put((eVar == null || (i21 = eVar.i()) == null) ? null : i21.getMediaId(), null);
                    return;
                }
                return;
            }
        }
        if (nVar == null) {
            nVar = new n((eVar == null || (i20 = eVar.i()) == null) ? null : i20.getMediaId(), (eVar == null || (i19 = eVar.i()) == null) ? null : i19.getOps(), (eVar == null || (i18 = eVar.i()) == null) ? null : i18.getSubjectId(), 0L, 0L, j12, 0L, 0L, i11, i12);
        }
        long g11 = j11 - nVar.g();
        if (!(1 <= g11 && g11 < 2000)) {
            g11 = 0;
        }
        if (eVar != null && (i17 = eVar.i()) != null) {
            z10 = Intrinsics.c(i17.getInBackground(), Boolean.TRUE);
        }
        if (z10) {
            nVar.m(nVar.c() + g11);
        } else {
            nVar.l(nVar.b() + g11);
        }
        nVar.n((eVar == null || (i16 = eVar.i()) == null) ? null : i16.getOps());
        nVar.r(j12);
        nVar.s(i11);
        nVar.k(i12);
        nVar.q((eVar == null || (i15 = eVar.i()) == null) ? null : i15.getSubjectId());
        nVar.p(j11);
        nVar.o(nVar.f() + g11);
        this.f43517g.put((eVar == null || (i14 = eVar.i()) == null) ? null : i14.getMediaId(), nVar);
        if (nVar.f() > 10000) {
            MusicReport.f43527a.d(nVar);
            this.f43517g.put((eVar == null || (i13 = eVar.i()) == null) ? null : i13.getMediaId(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean m(MusicFloatManager musicFloatManager, Ref.ObjectRef objectRef, View view, MotionEvent motionEvent) {
        View view2 = (View) objectRef.element;
        Intrinsics.e(motionEvent);
        if (!musicFloatManager.y(view2, motionEvent)) {
            ((MusicFloatView) objectRef.element).setExpand(false);
        }
        return false;
    }

    private final FrameLayout o(AppCompatActivity appCompatActivity) {
        Object m1185constructorimpl;
        Window window;
        View decorView;
        try {
            Result.Companion companion = Result.INSTANCE;
            FrameLayout frameLayout = (appCompatActivity == null || (window = appCompatActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : (FrameLayout) decorView.findViewById(R.id.content);
            if (!(frameLayout instanceof FrameLayout)) {
                frameLayout = null;
            }
            m1185constructorimpl = Result.m1185constructorimpl(frameLayout);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return (FrameLayout) (Result.m1188exceptionOrNullimpl(m1185constructorimpl) == null ? m1185constructorimpl : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p() {
        String simpleName = MusicFloatManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final boolean y(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (rawX <= iArr[0] || rawX >= r3 + view.getWidth()) {
            return false;
        }
        int i11 = iArr[1];
        return rawY > ((float) i11) && rawY < ((float) (i11 + view.getHeight()));
    }

    public final void A(boolean z10) {
        this.f43511a = z10;
    }

    public final void B(MediaItem mediaItem) {
        com.transsion.player.mediasession.i.f48462a.a(p() + " --> setMediaItem() --> musicFloatBean = " + mediaItem);
        if (!(mediaItem != null ? Intrinsics.c(mediaItem.isMusic(), Boolean.TRUE) : false)) {
            mediaItem = null;
        }
        this.f43512b = mediaItem;
    }

    public final void C(String str) {
        this.f43513c = str;
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    public final void i(Activity activity, MotionEvent event) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(event, "event");
        MusicFloatView musicFloatView = (MusicFloatView) activity.findViewById(activity.hashCode());
        if (musicFloatView != null && musicFloatView.getVisibility() == 0 && this.f43511a && !y(musicFloatView, event)) {
            musicFloatView.setExpand(false);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    public final void k(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        if (this.f43514d.contains(listener)) {
            return;
        }
        this.f43514d.add(listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, android.view.View, com.transsion.baseui.music.MusicFloatView] */
    public final void l(AppCompatActivity appCompatActivity, int i11) {
        if (appCompatActivity == null) {
            com.transsion.player.mediasession.i.f48462a.a(p() + " --> attach() --> activity == null");
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = appCompatActivity.findViewById(appCompatActivity.hashCode());
        if (q() == null) {
            MusicFloatView musicFloatView = (MusicFloatView) objectRef.element;
            if (musicFloatView != null) {
                musicFloatView.setVisibility(8);
                return;
            }
            return;
        }
        MusicFloatView musicFloatView2 = (MusicFloatView) objectRef.element;
        if (musicFloatView2 != null) {
            musicFloatView2.setVisibility(0);
        }
        if (objectRef.element == 0) {
            ?? musicFloatView3 = new MusicFloatView(appCompatActivity);
            objectRef.element = musicFloatView3;
            musicFloatView3.setId(appCompatActivity.hashCode());
            FrameLayout o11 = o(appCompatActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (o11 != null) {
                o11.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.baseui.music.b
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean m11;
                        m11 = MusicFloatManager.m(MusicFloatManager.this, objectRef, view, motionEvent);
                        return m11;
                    }
                });
            }
            layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            layoutParams.bottomMargin = dk.a.b(Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
            if (o11 != null) {
                o11.addView((View) objectRef.element, layoutParams);
            }
        }
        ((MusicFloatView) objectRef.element).refresh();
    }

    public final void n() {
        com.transsion.player.orplayer.g s11 = s();
        if (s11 != null) {
            s11.stop();
        }
        if (s11 != null) {
            s11.release();
        }
        f43508h.b().B(null);
        com.transsion.player.mediasession.h.f48453a.p();
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        f.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e eVar) {
        f.a.e(this, eVar);
        MediaItem mediaItem = this.f43512b;
        if (mediaItem != null) {
            mediaItem.setState(MediaItem.MUSIC_FLOAT_STATE_COMPLETION);
        }
        Iterator it = this.f43514d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onCompletion(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        f.a.h(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e eVar) {
        f.a.i(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e eVar) {
        f.a.k(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        f.a.o(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e eVar) {
        MediaItem i11;
        Intrinsics.h(errorInfo, "errorInfo");
        f.a.q(this, errorInfo, eVar);
        com.transsion.player.mediasession.i.f48462a.a(p() + " --> onPlayError() --> subjectId = " + ((eVar == null || (i11 = eVar.i()) == null) ? null : i11.getSubjectId()));
        MediaItem mediaItem = this.f43512b;
        if (mediaItem != null) {
            mediaItem.setState("error");
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        f.a.t(this, eVar);
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new MusicFloatManager$onPlayerRelease$1(this, eVar, null), 3, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        f.a.v(this);
        com.transsion.player.mediasession.i.f48462a.a(p() + " --> onPlayerReset()");
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e eVar) {
        f.a.w(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long j11, ao.e eVar) {
        f.a.y(this, j11, eVar);
        Iterator it = this.f43514d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onProgress(j11, eVar);
        }
        com.transsion.player.orplayer.g s11 = s();
        long duration = s11 != null ? s11.getDuration() : 0L;
        com.transsion.player.orplayer.g s12 = s();
        Pair bitrate = s12 != null ? s12.getBitrate() : null;
        j(j11, duration, bitrate != null ? ((Number) bitrate.getFirst()).intValue() : 0, bitrate != null ? ((Number) bitrate.getSecond()).intValue() : 0, eVar);
        MediaItem q11 = q();
        if (q11 != null) {
            q11.setPosition(Long.valueOf(j11));
        }
        MediaItem q12 = q();
        if (q12 != null) {
            q12.setState(MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        MediaItem q13 = q();
        if (q13 != null) {
            q13.setDuration(Long.valueOf(duration));
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        f.a.A(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
        com.transsion.player.mediasession.i.f48462a.a(p() + " --> onSetDataSource()");
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        f.a.C(this, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c cVar) {
        f.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        f.a.E(this, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(ao.e eVar) {
        MediaItem i11;
        f.a.F(this, eVar);
        com.transsion.player.mediasession.i.f48462a.a(p() + " --> onVideoPause() --> subjectId = " + ((eVar == null || (i11 = eVar.i()) == null) ? null : i11.getSubjectId()));
        MediaItem mediaItem = this.f43512b;
        if (mediaItem != null) {
            mediaItem.setState("pause");
        }
        Iterator it = this.f43514d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onVideoPause(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        MediaItem i11;
        f.a.I(this, eVar);
        com.transsion.player.mediasession.i.f48462a.a(p() + " --> onVideoStart() --> subjectId = " + ((eVar == null || (i11 = eVar.i()) == null) ? null : i11.getSubjectId()));
        MediaItem mediaItem = this.f43512b;
        if (mediaItem != null) {
            mediaItem.setState(MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        Iterator it = this.f43514d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onVideoStart(eVar);
        }
    }

    public final MediaItem q() {
        return this.f43512b;
    }

    public final String r() {
        return this.f43513c;
    }

    public final com.transsion.player.orplayer.g s() {
        if (this.f43515e == null) {
            f0 f0Var = new f0();
            f0Var.addPlayerListener(this);
            this.f43515e = f0Var;
        }
        return this.f43515e;
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }

    public final String t(String str) {
        return str + "_" + o.f43554a.a(6);
    }

    public final void u() {
        f43508h.b().B(null);
        com.transsion.player.mediasession.h.f48453a.p();
        List<Activity> a11 = com.blankj.utilcode.util.a.a();
        if (a11 != null) {
            for (Activity activity : a11) {
                BaseMusicFloatActivity baseMusicFloatActivity = activity instanceof BaseMusicFloatActivity ? (BaseMusicFloatActivity) activity : null;
                if (baseMusicFloatActivity != null) {
                    MusicFloatView musicFloatView = (MusicFloatView) baseMusicFloatActivity.findViewById(baseMusicFloatActivity.hashCode());
                    if (musicFloatView != null) {
                        musicFloatView.setVisibility(8);
                    }
                    baseMusicFloatActivity.onCloseMusicFloating();
                }
            }
        }
    }

    public final boolean v() {
        return this.f43511a;
    }

    public final List w() {
        return this.f43516f;
    }

    public final boolean x(AppCompatActivity appCompatActivity) {
        MusicFloatView musicFloatView = appCompatActivity != null ? (MusicFloatView) appCompatActivity.findViewById(appCompatActivity.hashCode()) : null;
        return musicFloatView != null && musicFloatView.getVisibility() == 0;
    }

    public final void z(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        if (this.f43514d.contains(listener)) {
            this.f43514d.remove(listener);
        }
    }
}
