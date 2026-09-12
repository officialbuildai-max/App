package com.pgl.ssdk;

import com.pgl.ssdk.z0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes5.dex */
public class a1<T extends z0> {

    /* renamed from: a, reason: collision with root package name */
    private int f40136a;

    /* renamed from: b, reason: collision with root package name */
    private BlockingQueue<T> f40137b = new LinkedBlockingQueue();

    private a1(int i11) {
        this.f40136a = i11;
    }

    public static a1 a(int i11) {
        return new a1(i11);
    }

    public T a() {
        return this.f40137b.poll();
    }
}
