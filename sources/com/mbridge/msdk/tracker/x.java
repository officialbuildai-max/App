package com.mbridge.msdk.tracker;

import android.util.Log;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* loaded from: classes5.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f38794a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38795b;

    /* renamed from: c, reason: collision with root package name */
    public final int f38796c;

    /* renamed from: d, reason: collision with root package name */
    public final int f38797d;

    /* renamed from: e, reason: collision with root package name */
    public final int f38798e;

    /* renamed from: f, reason: collision with root package name */
    public final int f38799f;

    /* renamed from: g, reason: collision with root package name */
    public final p f38800g;

    /* renamed from: h, reason: collision with root package name */
    public final d f38801h;

    /* renamed from: i, reason: collision with root package name */
    public final w f38802i;

    /* renamed from: j, reason: collision with root package name */
    public final f f38803j;

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        private p f38807d;

        /* renamed from: h, reason: collision with root package name */
        private d f38811h;

        /* renamed from: i, reason: collision with root package name */
        private w f38812i;

        /* renamed from: j, reason: collision with root package name */
        private f f38813j;

        /* renamed from: a, reason: collision with root package name */
        private int f38804a = 50;

        /* renamed from: b, reason: collision with root package name */
        private int f38805b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

        /* renamed from: c, reason: collision with root package name */
        private int f38806c = 1;

        /* renamed from: e, reason: collision with root package name */
        private int f38808e = 2;

        /* renamed from: f, reason: collision with root package name */
        private int f38809f = 50;

        /* renamed from: g, reason: collision with root package name */
        private int f38810g = MiniAppConfigHelper.DEFAULT_MINI_SCOPE_REQUEST_DIFF;

        public b a(int i11) {
            if (i11 < 0) {
                this.f38810g = MiniAppConfigHelper.DEFAULT_MINI_SCOPE_REQUEST_DIFF;
            } else {
                this.f38810g = i11;
            }
            return this;
        }

        public b a(int i11, p pVar) {
            this.f38806c = i11;
            this.f38807d = pVar;
            return this;
        }

        public b a(d dVar) {
            this.f38811h = dVar;
            return this;
        }

        public b a(f fVar) {
            this.f38813j = fVar;
            return this;
        }

        public b a(w wVar) {
            this.f38812i = wVar;
            return this;
        }

        public x a() {
            if (y.b(this.f38811h) && com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", "decorate can not be null");
            }
            if (y.b(this.f38812i) && com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", "responseHandler can not be null");
            }
            if ((y.b(this.f38807d) || y.b(this.f38807d.b())) && com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", "networkStackConfig or stack can not be null");
            }
            return new x(this);
        }

        public b b(int i11) {
            if (i11 <= 0) {
                this.f38804a = 50;
            } else {
                this.f38804a = i11;
            }
            return this;
        }

        public b c(int i11) {
            if (i11 < 0) {
                this.f38805b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
            } else {
                this.f38805b = i11;
            }
            return this;
        }

        public b d(int i11) {
            if (i11 < 0) {
                this.f38809f = 50;
            } else {
                this.f38809f = i11;
            }
            return this;
        }

        public b e(int i11) {
            if (i11 <= 0) {
                this.f38808e = 2;
            } else {
                this.f38808e = i11;
            }
            return this;
        }
    }

    private x(b bVar) {
        this.f38794a = bVar.f38804a;
        this.f38795b = bVar.f38805b;
        this.f38796c = bVar.f38806c;
        this.f38797d = bVar.f38808e;
        this.f38798e = bVar.f38809f;
        this.f38799f = bVar.f38810g;
        this.f38800g = bVar.f38807d;
        this.f38801h = bVar.f38811h;
        this.f38802i = bVar.f38812i;
        this.f38803j = bVar.f38813j;
    }
}
