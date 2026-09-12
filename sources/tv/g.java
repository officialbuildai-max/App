package tv;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.noober.background.view.BLTextView;
import com.tn.lib.pager.PagerLayoutManager;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.widget.f;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import qv.r;

/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final a f76501a;

    /* renamed from: b, reason: collision with root package name */
    private final i f76502b;

    /* renamed from: c, reason: collision with root package name */
    private GestureDetector f76503c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f76504d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f76505e;

    /* renamed from: f, reason: collision with root package name */
    private float f76506f;

    /* loaded from: classes6.dex */
    public interface a {
        r a();

        UGCImmVideoDetailViewModel b();

        PagerLayoutManager c();

        void d();

        void e(boolean z10);

        void f(long j11);

        void g();

        UGCImmVideo getData();

        String getLogTag();

        com.transsion.player.orplayer.g getOrPlayer();

        void h(boolean z10);

        int i();

        boolean isLoading();
    }

    /* loaded from: classes7.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            return super.onDoubleTap(e11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            super.onLongPress(e11);
            int i11 = g.this.f76501a.i() / 3;
            int x10 = (int) e11.getX();
            if ((x10 < 0 || x10 > i11) && x10 <= i11 * 2) {
                g.this.f76501a.d();
            } else {
                g.this.f76504d = true;
                g.this.n();
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            g.this.l();
            return super.onSingleTapUp(e11);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements f.a {

        /* renamed from: a, reason: collision with root package name */
        private long f76508a;

        /* renamed from: b, reason: collision with root package name */
        private long f76509b;

        /* renamed from: c, reason: collision with root package name */
        private int f76510c;

        /* renamed from: d, reason: collision with root package name */
        private String f76511d = "";

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f76513f;

        c(Context context) {
            this.f76513f = context;
        }

        @Override // com.transsion.baseui.widget.f.a
        public void a() {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void b(float f11, float f12) {
            if (!g.this.f76505e) {
                PagerLayoutManager c11 = g.this.f76501a.c();
                if (c11 != null) {
                    c11.X(false);
                }
                this.f76508a = g.this.f76501a.a().f73997v.getCurrentProgress();
                g.this.f76501a.e(false);
                TextView tvUgcImmProgressDes = g.this.f76501a.a().E;
                Intrinsics.g(tvUgcImmProgressDes, "tvUgcImmProgressDes");
                jg.c.k(tvUgcImmProgressDes);
                SecondariesSeekBar seekUgcImmBar = g.this.f76501a.a().f74000y;
                Intrinsics.g(seekUgcImmBar, "seekUgcImmBar");
                jg.c.k(seekUgcImmBar);
                SecondariesSeekBar progressUgcImmBar = g.this.f76501a.a().f73997v;
                Intrinsics.g(progressUgcImmBar, "progressUgcImmBar");
                jg.c.g(progressUgcImmBar);
                this.f76510c = g.this.f76501a.a().f73997v.getWidth();
                long maxProgress = g.this.f76501a.a().f73997v.getMaxProgress();
                this.f76509b = maxProgress;
                this.f76511d = TimeUtilKt.n(maxProgress);
            }
            g.this.f76505e = true;
            long j11 = this.f76509b;
            long j12 = ((float) this.f76508a) + (((f12 - f11) * ((float) j11)) / this.f76510c);
            if (j12 < 0) {
                j11 = 0;
            } else if (j12 <= j11) {
                j11 = j12;
            }
            g.this.f76501a.a().E.setText(ph.c.e().e(j11 <= 0 ? "00:00" : TimeUtilKt.n(j11)).c(androidx.core.content.b.getColor(this.f76513f, R$color.white)).e("  /  " + this.f76511d).c(androidx.core.content.b.getColor(this.f76513f, R$color.white_60)).b());
            g.this.f76501a.f(j11);
        }

        @Override // com.transsion.baseui.widget.f.a
        public void c(float f11, float f12) {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void d(float f11, float f12) {
        }

        @Override // com.transsion.baseui.widget.f.a
        public void e() {
            com.transsion.player.orplayer.g orPlayer;
            PagerLayoutManager c11 = g.this.f76501a.c();
            if (c11 != null) {
                c11.X(true);
            }
            if (g.this.f76505e) {
                g.this.f76505e = false;
                g.this.f76501a.e(true);
                TextView tvUgcImmProgressDes = g.this.f76501a.a().E;
                Intrinsics.g(tvUgcImmProgressDes, "tvUgcImmProgressDes");
                jg.c.g(tvUgcImmProgressDes);
                SecondariesSeekBar seekUgcImmBar = g.this.f76501a.a().f74000y;
                Intrinsics.g(seekUgcImmBar, "seekUgcImmBar");
                jg.c.g(seekUgcImmBar);
                SecondariesSeekBar progressUgcImmBar = g.this.f76501a.a().f73997v;
                Intrinsics.g(progressUgcImmBar, "progressUgcImmBar");
                jg.c.k(progressUgcImmBar);
                long currentProgress = g.this.f76501a.a().f73997v.getCurrentProgress();
                UGCImmVideo data = g.this.f76501a.getData();
                if (data == null || !data.isDataComplete()) {
                    a.C0856a.f(lg.a.f68962a, g.this.f76501a.getLogTag(), "数据还没有拉下来，不进行seek", false, 4, null);
                    return;
                }
                com.transsion.player.orplayer.g orPlayer2 = g.this.f76501a.getOrPlayer();
                if (orPlayer2 != null) {
                    orPlayer2.seekTo(currentProgress);
                }
                com.transsion.player.orplayer.g orPlayer3 = g.this.f76501a.getOrPlayer();
                if (orPlayer3 == null || orPlayer3.isPlaying() || (orPlayer = g.this.f76501a.getOrPlayer()) == null) {
                    return;
                }
                orPlayer.play();
            }
        }

        @Override // com.transsion.baseui.widget.f.a
        public void onDoubleTap(MotionEvent e11) {
            Intrinsics.h(e11, "e");
        }

        @Override // com.transsion.baseui.widget.f.a
        public void onLongPress(MotionEvent e11) {
            Intrinsics.h(e11, "e");
        }
    }

    public g(a host, i reportDelegate) {
        Intrinsics.h(host, "host");
        Intrinsics.h(reportDelegate, "reportDelegate");
        this.f76501a = host;
        this.f76502b = reportDelegate;
    }

    private final void h() {
        if (this.f76506f > 0.0f) {
            a.C0856a.f(lg.a.f68962a, this.f76501a.getLogTag(), "endFastForward speed:" + this.f76506f, false, 4, null);
            com.transsion.player.orplayer.g orPlayer = this.f76501a.getOrPlayer();
            if (orPlayer != null) {
                orPlayer.setSpeed(this.f76506f);
            }
            BLTextView tvUgcImmTopSpeed = this.f76501a.a().F;
            Intrinsics.g(tvUgcImmTopSpeed, "tvUgcImmTopSpeed");
            jg.c.g(tvUgcImmTopSpeed);
            this.f76506f = 0.0f;
            this.f76501a.e(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        if (this.f76501a.isLoading()) {
            return;
        }
        this.f76501a.e(true);
        com.transsion.player.orplayer.g orPlayer = this.f76501a.getOrPlayer();
        if (orPlayer == null || !orPlayer.isPlaying()) {
            this.f76501a.g();
            this.f76501a.h(false);
            return;
        }
        this.f76501a.h(true);
        com.transsion.player.orplayer.g orPlayer2 = this.f76501a.getOrPlayer();
        if (orPlayer2 != null) {
            orPlayer2.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        com.transsion.player.orplayer.g orPlayer = this.f76501a.getOrPlayer();
        if (orPlayer == null || orPlayer.isPlaying()) {
            UGCImmVideoDetailViewModel b11 = this.f76501a.b();
            this.f76506f = b11 != null ? b11.X0() : 1.0f;
            com.transsion.player.orplayer.g orPlayer2 = this.f76501a.getOrPlayer();
            if (orPlayer2 != null) {
                orPlayer2.setSpeed(this.f76506f * 2.0f);
            }
            i iVar = this.f76502b;
            UGCImmVideo data = this.f76501a.getData();
            UGCVideo ugcVideo = data != null ? data.getUgcVideo() : null;
            UGCImmVideoDetailViewModel b12 = this.f76501a.b();
            iVar.a("long_pressed", ugcVideo, (r13 & 4) != 0 ? null : b12 != null ? Boolean.valueOf(b12.Y0()) : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
            a.C0856a.f(lg.a.f68962a, this.f76501a.getLogTag(), "startFastForward speed:" + (this.f76506f * 2.0f), false, 4, null);
            this.f76501a.a().F.setText((this.f76506f * 2.0f) + "x");
            BLTextView tvUgcImmTopSpeed = this.f76501a.a().F;
            Intrinsics.g(tvUgcImmTopSpeed, "tvUgcImmTopSpeed");
            jg.c.k(tvUgcImmTopSpeed);
            this.f76501a.e(false);
        }
    }

    public final void i() {
        Context context = this.f76501a.a().getRoot().getContext();
        this.f76503c = new GestureDetector(context, new b());
        new com.transsion.baseui.widget.f(context, this.f76501a.a().L).s(new c(context));
        this.f76501a.a().f74000y.setOnTouchListener(new View.OnTouchListener() { // from class: tv.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean j11;
                j11 = g.j(view, motionEvent);
                return j11;
            }
        });
    }

    public final boolean k() {
        return this.f76505e;
    }

    public final boolean m(MotionEvent event) {
        Intrinsics.h(event, "event");
        int actionMasked = event.getActionMasked();
        if ((actionMasked == 1 || actionMasked == 3) && this.f76504d) {
            this.f76504d = false;
            h();
        }
        GestureDetector gestureDetector = this.f76503c;
        return gestureDetector != null && gestureDetector.onTouchEvent(event);
    }
}
