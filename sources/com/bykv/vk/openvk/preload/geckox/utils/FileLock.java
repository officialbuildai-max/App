package com.bykv.vk.openvk.preload.geckox.utils;

import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FileLock {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f20835a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final int f20836b;

    /* renamed from: c, reason: collision with root package name */
    private final String f20837c;

    static {
        System.loadLibrary("file_lock_pgl");
    }

    private FileLock(String str, int i11) {
        this.f20837c = str;
        this.f20836b = i11;
    }

    public static FileLock a(String str) {
        try {
            int d11 = d(str);
            nLockFile(d11);
            return new FileLock(str, d11);
        } catch (Exception e11) {
            throw new RuntimeException("lock failed, file:" + str + ", pid:" + Process.myPid() + " caused by:" + e11.getMessage());
        }
    }

    public static FileLock a(String str, int i11) {
        try {
            int d11 = d(str);
            nLockFileSegment(d11, i11);
            return new FileLock(str, d11);
        } catch (Exception e11) {
            throw new RuntimeException("lock segment failed, file:" + str + " caused by:" + e11.getMessage());
        }
    }

    public static FileLock b(String str) {
        try {
            int d11 = d(str);
            if (nTryLock(d11)) {
                return new FileLock(str, d11);
            }
            return null;
        } catch (Exception e11) {
            throw new RuntimeException("try lock failed, file:" + str + " caused by:" + e11.getMessage());
        }
    }

    public static FileLock c(String str) throws Exception {
        try {
            int d11 = d(str);
            if (nTryLock(d11)) {
                return new FileLock(str, d11);
            }
            new FileLock(str, d11).b();
            return null;
        } catch (Exception e11) {
            throw new RuntimeException("try lock failed, file:" + str + " caused by:" + e11.getMessage());
        }
    }

    private static int d(String str) throws Exception {
        Integer num;
        Map<String, Integer> map = f20835a;
        synchronized (map) {
            try {
                num = map.get(str);
                if (num == null) {
                    new File(str).getParentFile().mkdirs();
                    num = Integer.valueOf(nGetFD(str));
                    map.put(str, num);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return num.intValue();
    }

    private static native int nGetFD(String str) throws Exception;

    private static native void nLockFile(int i11) throws Exception;

    private static native void nLockFileSegment(int i11, int i12) throws Exception;

    private static native void nRelease(int i11) throws Exception;

    private static native boolean nTryLock(int i11) throws Exception;

    private static native void nUnlockFile(int i11) throws Exception;

    public final void a() {
        try {
            nUnlockFile(this.f20836b);
        } catch (Exception unused) {
            throw new RuntimeException("release lock failed，path:" + this.f20837c);
        }
    }

    public final void b() {
        Integer remove;
        Map<String, Integer> map = f20835a;
        synchronized (map) {
            remove = map.remove(this.f20837c);
        }
        try {
            nRelease(remove.intValue());
        } catch (Exception e11) {
            throw new RuntimeException("release lock failed, file:" + this.f20837c + " caused by:" + e11.getMessage());
        }
    }
}
