package com.bykv.vk.openvk.preload.geckox.g;

import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f20775a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private FileLock f20776b;

    /* renamed from: c, reason: collision with root package name */
    private String f20777c;

    private a(String str, FileLock fileLock) {
        this.f20777c = str;
        this.f20776b = fileLock;
    }

    public static a a(String str) throws Exception {
        Map<String, Lock> map = f20775a;
        synchronized (map) {
            try {
                Lock lock = map.get(str);
                if (lock == null) {
                    lock = new ReentrantLock();
                    map.put(str, lock);
                }
                if (!lock.tryLock()) {
                    return null;
                }
                try {
                    FileLock c11 = FileLock.c(str);
                    if (c11 == null) {
                        lock.unlock();
                        return null;
                    }
                    return new a(str, c11);
                } catch (Exception e11) {
                    lock.lock();
                    com.bykv.vk.openvk.preload.geckox.utils.a.a(new RuntimeException(e11));
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void a() {
        Map<String, Lock> map = f20775a;
        synchronized (map) {
            try {
                try {
                    this.f20776b.a();
                    this.f20776b.b();
                    map.get(this.f20777c).unlock();
                } catch (Throwable th2) {
                    f20775a.get(this.f20777c).unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
