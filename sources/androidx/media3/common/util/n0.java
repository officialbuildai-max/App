package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.util.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n0 implements p {

    /* renamed from: b, reason: collision with root package name */
    private static final List f10497b = new ArrayList(50);

    /* renamed from: a, reason: collision with root package name */
    private final Handler f10498a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements p.a {

        /* renamed from: a, reason: collision with root package name */
        private Message f10499a;

        /* renamed from: b, reason: collision with root package name */
        private n0 f10500b;

        private b() {
        }

        private void b() {
            this.f10499a = null;
            this.f10500b = null;
            n0.e(this);
        }

        @Override // androidx.media3.common.util.p.a
        public void a() {
            ((Message) androidx.media3.common.util.a.e(this.f10499a)).sendToTarget();
            b();
        }

        public boolean c(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) androidx.media3.common.util.a.e(this.f10499a));
            b();
            return sendMessageAtFrontOfQueue;
        }

        public b d(Message message, n0 n0Var) {
            this.f10499a = message;
            this.f10500b = n0Var;
            return this;
        }
    }

    public n0(Handler handler) {
        this.f10498a = handler;
    }

    private static b d() {
        b bVar;
        List list = f10497b;
        synchronized (list) {
            try {
                bVar = list.isEmpty() ? new b() : (b) list.remove(list.size() - 1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(b bVar) {
        List list = f10497b;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.media3.common.util.p
    public boolean a(int i11) {
        androidx.media3.common.util.a.a(i11 != 0);
        return this.f10498a.hasMessages(i11);
    }

    @Override // androidx.media3.common.util.p
    public boolean b(p.a aVar) {
        return ((b) aVar).c(this.f10498a);
    }

    @Override // androidx.media3.common.util.p
    public Looper getLooper() {
        return this.f10498a.getLooper();
    }

    @Override // androidx.media3.common.util.p
    public p.a obtainMessage(int i11) {
        return d().d(this.f10498a.obtainMessage(i11), this);
    }

    @Override // androidx.media3.common.util.p
    public p.a obtainMessage(int i11, int i12, int i13) {
        return d().d(this.f10498a.obtainMessage(i11, i12, i13), this);
    }

    @Override // androidx.media3.common.util.p
    public p.a obtainMessage(int i11, int i12, int i13, Object obj) {
        return d().d(this.f10498a.obtainMessage(i11, i12, i13, obj), this);
    }

    @Override // androidx.media3.common.util.p
    public p.a obtainMessage(int i11, Object obj) {
        return d().d(this.f10498a.obtainMessage(i11, obj), this);
    }

    @Override // androidx.media3.common.util.p
    public boolean post(Runnable runnable) {
        return this.f10498a.post(runnable);
    }

    @Override // androidx.media3.common.util.p
    public void removeCallbacksAndMessages(Object obj) {
        this.f10498a.removeCallbacksAndMessages(obj);
    }

    @Override // androidx.media3.common.util.p
    public void removeMessages(int i11) {
        androidx.media3.common.util.a.a(i11 != 0);
        this.f10498a.removeMessages(i11);
    }

    @Override // androidx.media3.common.util.p
    public boolean sendEmptyMessage(int i11) {
        return this.f10498a.sendEmptyMessage(i11);
    }

    @Override // androidx.media3.common.util.p
    public boolean sendEmptyMessageAtTime(int i11, long j11) {
        return this.f10498a.sendEmptyMessageAtTime(i11, j11);
    }
}
