package tv;

import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import qv.r;

/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final a f76514a;

    /* loaded from: classes6.dex */
    public interface a {
        r a();

        UGCImmVideoDetailViewModel b();

        void c(boolean z10);

        void d();

        n e();

        com.transsion.ugcvideodetail.hepler.a f();

        UGCImmVideo getData();

        String getLogTag();

        com.transsion.player.orplayer.g getOrPlayer();

        void showLoading();
    }

    public h(a host) {
        Intrinsics.h(host, "host");
        this.f76514a = host;
    }

    public final void a(long j11, long j12) {
        UGCImmVideoDetailViewModel b11 = this.f76514a.b();
        if (b11 != null) {
            b11.f1(this.f76514a.getData(), j12, j11);
        }
    }

    public final void b(long j11, boolean z10) {
        com.transsion.player.orplayer.g orPlayer;
        if (z10) {
            return;
        }
        long maxProgress = this.f76514a.a().f74000y.getMaxProgress();
        if (maxProgress <= 0 || maxProgress == 100 || (orPlayer = this.f76514a.getOrPlayer()) == null || maxProgress != orPlayer.getDuration()) {
            com.transsion.player.orplayer.g orPlayer2 = this.f76514a.getOrPlayer();
            long duration = orPlayer2 != null ? orPlayer2.getDuration() : 0L;
            if (duration <= 0) {
                a.C0856a.f(lg.a.f68962a, this.f76514a.getLogTag(), "onProgress- duration <= 0, return", false, 4, null);
                return;
            }
            h(duration);
        }
        com.transsion.ugcvideodetail.hepler.a f11 = this.f76514a.f();
        if (f11 != null) {
            f11.l(j11);
        }
        this.f76514a.e().q(j11);
        g(j11);
        f(false);
    }

    public final void c() {
        com.transsion.ugcvideodetail.hepler.a f11 = this.f76514a.f();
        if (f11 != null) {
            f11.n();
        }
        AppCompatImageView ivUgcImmPlayStatus = this.f76514a.a().f73989n;
        Intrinsics.g(ivUgcImmPlayStatus, "ivUgcImmPlayStatus");
        jg.c.k(ivUgcImmPlayStatus);
        this.f76514a.e().p(false);
        this.f76514a.c(false);
    }

    public final void d() {
        com.transsion.ugcvideodetail.hepler.a f11 = this.f76514a.f();
        if (f11 != null) {
            f11.o();
        }
        this.f76514a.e().p(true);
        f(false);
        this.f76514a.c(true);
        AppCompatImageView ivUgcImmPlayStatus = this.f76514a.a().f73989n;
        Intrinsics.g(ivUgcImmPlayStatus, "ivUgcImmPlayStatus");
        jg.c.g(ivUgcImmPlayStatus);
    }

    public final void e() {
        com.transsion.player.orplayer.g orPlayer;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.f76514a.getLogTag(), "playVideo data:" + this.f76514a.getData() + " orPlayer:" + this.f76514a.getOrPlayer(), false, 4, null);
        UGCImmVideo data = this.f76514a.getData();
        if (data == null || (orPlayer = this.f76514a.getOrPlayer()) == null) {
            return;
        }
        if (!data.isFree()) {
            a.C0856a.f(c0856a, this.f76514a.getLogTag(), "player- no free now, show pay dialog", false, 4, null);
            f(false);
        } else {
            if (orPlayer.isComplete()) {
                orPlayer.seekTo(0L);
            }
            orPlayer.play();
            a.C0856a.f(c0856a, this.f76514a.getLogTag(), "player- startplay", false, 4, null);
        }
    }

    public final void f(boolean z10) {
        if (z10) {
            this.f76514a.showLoading();
        } else {
            this.f76514a.d();
        }
    }

    public final void g(long j11) {
        this.f76514a.a().f74000y.setProgress(j11);
        this.f76514a.a().f73997v.setProgress(j11);
    }

    public final void h(long j11) {
        this.f76514a.a().f74000y.setMax(j11);
        this.f76514a.a().f73997v.setMax(j11);
        a.C0856a.f(lg.a.f68962a, this.f76514a.getLogTag(), "updateProgressMax: " + j11, false, 4, null);
    }
}
