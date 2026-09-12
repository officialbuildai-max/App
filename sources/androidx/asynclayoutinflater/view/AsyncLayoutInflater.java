package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.h;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes.dex */
public final class AsyncLayoutInflater {

    /* renamed from: a, reason: collision with root package name */
    LayoutInflater f2208a;

    /* renamed from: d, reason: collision with root package name */
    private Handler.Callback f2211d = new a();

    /* renamed from: b, reason: collision with root package name */
    Handler f2209b = new Handler(this.f2211d);

    /* renamed from: c, reason: collision with root package name */
    InflateThread f2210c = InflateThread.getInstance();

    /* loaded from: classes.dex */
    private static class InflateThread extends Thread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<c> mQueue = new ArrayBlockingQueue<>(10);
        private h mRequestPool = new h(10);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(c cVar) {
            try {
                this.mQueue.put(cVar);
            } catch (InterruptedException e11) {
                throw new RuntimeException("Failed to enqueue async inflate request", e11);
            }
        }

        public c obtainRequest() {
            c cVar = (c) this.mRequestPool.acquire();
            return cVar == null ? new c() : cVar;
        }

        public void releaseRequest(c cVar) {
            cVar.f2218e = null;
            cVar.f2214a = null;
            cVar.f2215b = null;
            cVar.f2216c = 0;
            cVar.f2217d = null;
            this.mRequestPool.release(cVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                c take = this.mQueue.take();
                try {
                    take.f2217d = take.f2214a.f2208a.inflate(take.f2216c, take.f2215b, false);
                } catch (RuntimeException e11) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e11);
                }
                Message.obtain(take.f2214a.f2209b, 0, take).sendToTarget();
            } catch (InterruptedException e12) {
                Log.w("AsyncLayoutInflater", e12);
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            c cVar = (c) message.obj;
            if (cVar.f2217d == null) {
                cVar.f2217d = AsyncLayoutInflater.this.f2208a.inflate(cVar.f2216c, cVar.f2215b, false);
            }
            cVar.f2218e.a(cVar.f2217d, cVar.f2216c, cVar.f2215b);
            AsyncLayoutInflater.this.f2210c.releaseRequest(cVar);
            return true;
        }
    }

    /* loaded from: classes.dex */
    private static class b extends LayoutInflater {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f2213a = {"android.widget.", "android.webkit.", "android.app."};

        b(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new b(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) {
            View createView;
            for (String str2 : f2213a) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        AsyncLayoutInflater f2214a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f2215b;

        /* renamed from: c, reason: collision with root package name */
        int f2216c;

        /* renamed from: d, reason: collision with root package name */
        View f2217d;

        /* renamed from: e, reason: collision with root package name */
        d f2218e;

        c() {
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(View view, int i11, ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(Context context) {
        this.f2208a = new b(context);
    }

    public void a(int i11, ViewGroup viewGroup, d dVar) {
        if (dVar == null) {
            throw new NullPointerException("callback argument may not be null!");
        }
        c obtainRequest = this.f2210c.obtainRequest();
        obtainRequest.f2214a = this;
        obtainRequest.f2216c = i11;
        obtainRequest.f2215b = viewGroup;
        obtainRequest.f2218e = dVar;
        this.f2210c.enqueue(obtainRequest);
    }
}
