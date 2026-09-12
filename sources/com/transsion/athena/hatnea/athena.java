package com.transsion.athena.hatnea;

import android.text.TextUtils;
import androidx.core.util.j;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    private static volatile athena f42824a;

    /* renamed from: b, reason: collision with root package name */
    private final Deque<anateh> f42825b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f42826c;

    /* loaded from: classes5.dex */
    private static class aethna implements ThreadFactory {
        private aethna() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Athena Dispatcher");
            thread.setDaemon(false);
            return thread;
        }
    }

    private athena() {
    }

    public static athena a() {
        if (f42824a == null) {
            synchronized (athena.class) {
                try {
                    if (f42824a == null) {
                        f42824a = new athena();
                    }
                } finally {
                }
            }
        }
        return f42824a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(String str, anateh anatehVar) {
        return TextUtils.equals(anatehVar.b(), str);
    }

    private synchronized boolean c() {
        return com.transsion.athena.config.data.model.anehat.a(this.f42825b, new j() { // from class: com.transsion.athena.hatnea.c
            @Override // androidx.core.util.j
            public final boolean a(Object obj) {
                boolean c11;
                c11 = athena.c((anateh) obj);
                return c11;
            }
        }) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(anateh anatehVar) {
        return anatehVar instanceof atenha;
    }

    public synchronized int a(final String str) {
        return com.transsion.athena.config.data.model.anehat.a(this.f42825b, new j() { // from class: com.transsion.athena.hatnea.b
            @Override // androidx.core.util.j
            public final boolean a(Object obj) {
                boolean a11;
                a11 = athena.a(str, (anateh) obj);
                return a11;
            }
        });
    }

    public synchronized void a(anateh anatehVar) {
        if (a(anatehVar.b()) <= 0 && !c()) {
            this.f42825b.add(anatehVar);
            synchronized (this) {
                try {
                    if (this.f42826c == null) {
                        this.f42826c = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aethna());
                    }
                    this.f42826c.execute(anatehVar);
                } finally {
                }
            }
        }
    }

    public void b() {
        enatha enathaVar;
        Thread thread;
        for (anateh anatehVar : this.f42825b) {
            if ((anatehVar instanceof enatha) && (thread = (enathaVar = (enatha) anatehVar).f42816b) != null && !thread.isInterrupted()) {
                enathaVar.f42816b.interrupt();
            }
        }
    }

    public synchronized void b(anateh anatehVar) {
        this.f42825b.remove(anatehVar);
    }
}
