package com.bytedance.sdk.component;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.Sj;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class sP {
    private static volatile Handler sP;
    private static final Object Sj = new Object();
    private static final LinkedList<Runnable> TKC = new LinkedList<>();
    private static Object EjP = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Sj extends Handler {
        Sj(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    sP.TKC();
                } catch (OutOfMemoryError unused) {
                }
            }
        }
    }

    public static void Sj(Runnable runnable, boolean z10) {
        try {
            Handler sP2 = sP();
            synchronized (Sj) {
                try {
                    TKC.add(runnable);
                    if (z10) {
                        sP2.sendEmptyMessageDelayed(1, 100L);
                    } else {
                        sP2.sendEmptyMessage(1);
                    }
                } finally {
                }
            }
        } catch (OutOfMemoryError unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void TKC() {
        LinkedList linkedList;
        synchronized (EjP) {
            try {
                synchronized (Sj) {
                    LinkedList<Runnable> linkedList2 = TKC;
                    linkedList = (LinkedList) linkedList2.clone();
                    linkedList2.clear();
                    sP().removeMessages(1);
                }
                if (linkedList.size() > 0) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static Handler sP() {
        Handler handler;
        if (sP != null) {
            return sP;
        }
        synchronized (Sj) {
            try {
                if (sP == null) {
                    Sj.InterfaceC0224Sj interfaceC0224Sj = com.bytedance.sdk.component.Sj.Sj;
                    HandlerThread safeHandlerThread = interfaceC0224Sj != null ? interfaceC0224Sj.getSafeHandlerThread("queued-work-looper", -2) : null;
                    if (safeHandlerThread == null) {
                        safeHandlerThread = new HandlerThread("queued-work-looper", -2);
                        safeHandlerThread.start();
                    }
                    sP = new Sj(safeHandlerThread.getLooper());
                }
                handler = sP;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }
}
