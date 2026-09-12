package com.mbridge.msdk.foundation.same.task;

/* loaded from: classes5.dex */
public abstract class a implements Runnable {

    /* renamed from: id, reason: collision with root package name */
    public static long f35681id;
    public InterfaceC0493a mListener;
    public b mState = b.READY;

    /* renamed from: com.mbridge.msdk.foundation.same.task.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0493a {
        void a(b bVar);
    }

    /* loaded from: classes5.dex */
    public enum b {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    public a() {
        f35681id++;
    }

    private void setState(b bVar) {
        this.mState = bVar;
        InterfaceC0493a interfaceC0493a = this.mListener;
        if (interfaceC0493a != null) {
            interfaceC0493a.a(bVar);
        }
    }

    public final void cancel() {
        b bVar = this.mState;
        b bVar2 = b.CANCEL;
        if (bVar != bVar2) {
            setState(bVar2);
            cancelTask();
        }
    }

    public abstract void cancelTask();

    public final long getId() {
        return f35681id;
    }

    public b getState() {
        return this.mState;
    }

    public abstract void pauseTask(boolean z10);

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mState == b.READY) {
                setState(b.RUNNING);
                runTask();
                setState(b.FINISH);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public abstract void runTask();

    public void setOnStateChangeListener(InterfaceC0493a interfaceC0493a) {
        this.mListener = interfaceC0493a;
    }

    public final void setPause(boolean z10) {
        b bVar = this.mState;
        b bVar2 = b.PAUSE;
        if (bVar == bVar2 || bVar == b.CANCEL || bVar == b.FINISH) {
            return;
        }
        if (z10) {
            setState(bVar2);
        } else {
            setState(b.RUNNING);
        }
        pauseTask(z10);
    }
}
