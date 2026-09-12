package com.cloud.hisavana.net.disklrucache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class DiskCacheWriteLocker {

    /* renamed from: a, reason: collision with root package name */
    private final Map f21431a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final WriteLockPool f21432b = new WriteLockPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class WriteLock {

        /* renamed from: a, reason: collision with root package name */
        final Lock f21433a;

        /* renamed from: b, reason: collision with root package name */
        int f21434b;

        private WriteLock() {
            this.f21433a = new ReentrantLock();
        }
    }

    /* loaded from: classes3.dex */
    private static class WriteLockPool {

        /* renamed from: a, reason: collision with root package name */
        private final Queue f21435a;

        private WriteLockPool() {
            this.f21435a = new ArrayDeque();
        }

        WriteLock a() {
            WriteLock writeLock;
            synchronized (this.f21435a) {
                writeLock = (WriteLock) this.f21435a.poll();
            }
            return writeLock == null ? new WriteLock() : writeLock;
        }

        void b(WriteLock writeLock) {
            synchronized (this.f21435a) {
                try {
                    if (this.f21435a.size() < 10) {
                        this.f21435a.offer(writeLock);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void a(ImageCacheURL imageCacheURL) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = (WriteLock) this.f21431a.get(imageCacheURL);
                if (writeLock == null) {
                    writeLock = this.f21432b.a();
                    this.f21431a.put(imageCacheURL, writeLock);
                }
                writeLock.f21434b++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        writeLock.f21433a.lock();
    }

    public void b(ImageCacheURL imageCacheURL) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = (WriteLock) this.f21431a.get(imageCacheURL);
                int i11 = writeLock.f21434b;
                if (i11 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, key: " + imageCacheURL + ", interestedThreads: " + writeLock.f21434b);
                }
                int i12 = i11 - 1;
                writeLock.f21434b = i12;
                if (i12 == 0) {
                    WriteLock writeLock2 = (WriteLock) this.f21431a.remove(imageCacheURL);
                    if (!writeLock2.equals(writeLock)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLock2 + ", key: " + imageCacheURL);
                    }
                    this.f21432b.b(writeLock2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        writeLock.f21433a.unlock();
    }
}
