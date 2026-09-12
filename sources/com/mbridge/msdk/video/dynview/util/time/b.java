package com.mbridge.msdk.video.dynview.util.time;

import android.os.CountDownTimer;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f39169a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f39170b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.util.time.a f39171c;

    /* renamed from: d, reason: collision with root package name */
    private a f39172d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.video.dynview.util.time.a f39173a;

        public a(long j11, long j12) {
            super(j11, j12);
        }

        void a(com.mbridge.msdk.video.dynview.util.time.a aVar) {
            this.f39173a = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.mbridge.msdk.video.dynview.util.time.a aVar = this.f39173a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            com.mbridge.msdk.video.dynview.util.time.a aVar = this.f39173a;
            if (aVar != null) {
                aVar.onTick(j11);
            }
        }
    }

    public b a(long j11) {
        if (j11 < 0) {
            j11 = 1000;
        }
        this.f39170b = j11;
        return this;
    }

    public b a(com.mbridge.msdk.video.dynview.util.time.a aVar) {
        this.f39171c = aVar;
        return this;
    }

    public void a() {
        a aVar = this.f39172d;
        if (aVar != null) {
            aVar.cancel();
            this.f39172d = null;
        }
    }

    public void a(long j11, com.mbridge.msdk.video.dynview.util.time.a aVar) {
        this.f39169a = j11;
        this.f39171c = aVar;
        b();
        a aVar2 = this.f39172d;
        if (aVar2 != null) {
            aVar2.start();
        }
    }

    public b b(long j11) {
        this.f39169a = j11;
        return this;
    }

    public void b() {
        a aVar = this.f39172d;
        if (aVar != null) {
            aVar.cancel();
            this.f39172d = null;
        }
        if (this.f39170b <= 0) {
            this.f39170b = this.f39169a + 1000;
        }
        a aVar2 = new a(this.f39169a, this.f39170b);
        this.f39172d = aVar2;
        aVar2.a(this.f39171c);
    }

    public void c() {
        if (this.f39172d == null) {
            b();
        }
        this.f39172d.start();
    }
}
