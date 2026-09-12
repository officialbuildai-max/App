package com.transsion.transfer.androidasync;

import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;

/* loaded from: classes6.dex */
class ThreadQueue extends LinkedList<Runnable> {

    /* renamed from: a, reason: collision with root package name */
    private static final WeakHashMap f55296a = new WeakHashMap();
    Semaphore queueSemaphore = new Semaphore(0);
    c waiter;

    ThreadQueue() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadQueue getOrCreateThreadQueue(Thread thread) {
        ThreadQueue threadQueue;
        WeakHashMap weakHashMap = f55296a;
        synchronized (weakHashMap) {
            try {
                threadQueue = (ThreadQueue) weakHashMap.get(thread);
                if (threadQueue == null) {
                    threadQueue = new ThreadQueue();
                    weakHashMap.put(thread, threadQueue);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return threadQueue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void release(c cVar) {
        WeakHashMap weakHashMap = f55296a;
        synchronized (weakHashMap) {
            try {
                for (ThreadQueue threadQueue : weakHashMap.values()) {
                    if (threadQueue.waiter == cVar) {
                        threadQueue.queueSemaphore.release();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(Runnable runnable) {
        boolean add;
        synchronized (this) {
            add = super.add((ThreadQueue) runnable);
        }
        return add;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public Runnable remove() {
        synchronized (this) {
            try {
                if (isEmpty()) {
                    return null;
                }
                return (Runnable) super.remove();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this) {
            remove = super.remove(obj);
        }
        return remove;
    }
}
