package com.bykv.vk.openvk.preload.geckox.g;

import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f20778a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static ReentrantLock f20779b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    private String f20780c;

    /* renamed from: d, reason: collision with root package name */
    private FileLock f20781d;

    private b(String str, FileLock fileLock) {
        this.f20780c = str;
        this.f20781d = fileLock;
    }

    public static b a(String str) throws Exception {
        f20779b.lock();
        try {
            FileLock a11 = FileLock.a(str);
            Map<String, Lock> map = f20778a;
            Lock lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
            lock.lock();
            return new b(str, a11);
        } catch (Exception e11) {
            f20779b.unlock();
            throw e11;
        }
    }

    public final void a() {
        try {
            this.f20781d.a();
            this.f20781d.b();
            Lock lock = f20778a.get(this.f20780c);
            if (lock != null) {
                lock.unlock();
            }
        } finally {
            f20779b.unlock();
        }
    }
}
