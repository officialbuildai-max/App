package com.mbridge.msdk.util.timer;

import android.os.CountDownTimer;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.util.timer.a f38819a;

    /* renamed from: b, reason: collision with root package name */
    private long f38820b;

    /* renamed from: c, reason: collision with root package name */
    private a f38821c;

    /* renamed from: d, reason: collision with root package name */
    private long f38822d = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.util.timer.a f38823a;

        public a(long j11, long j12) {
            super(j11, j12);
        }

        void a(com.mbridge.msdk.util.timer.a aVar) {
            this.f38823a = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.mbridge.msdk.util.timer.a aVar = this.f38823a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            com.mbridge.msdk.util.timer.a aVar = this.f38823a;
            if (aVar != null) {
                aVar.onTick(j11);
            }
        }
    }

    public b a(long j11) {
        if (j11 < 0) {
            j11 = 1000;
        }
        this.f38820b = j11;
        return this;
    }

    public b a(com.mbridge.msdk.util.timer.a aVar) {
        this.f38819a = aVar;
        return this;
    }

    public void a() {
        a aVar = this.f38821c;
        if (aVar != null) {
            aVar.cancel();
            this.f38821c = null;
        }
    }

    public b b(long j11) {
        this.f38822d = j11;
        return this;
    }

    public void b() {
        a aVar = this.f38821c;
        if (aVar != null) {
            aVar.cancel();
            this.f38821c = null;
        }
        if (this.f38820b <= 0) {
            this.f38820b = this.f38822d + 1000;
        }
        a aVar2 = new a(this.f38822d, this.f38820b);
        this.f38821c = aVar2;
        aVar2.a(this.f38819a);
    }

    public void c() {
        if (this.f38821c == null) {
            b();
        }
        this.f38821c.start();
    }
}
