package com.transsion.athena.data;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    private static int f42753a;

    /* renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<Integer> f42754b = new CopyOnWriteArrayList<>();

    public static CopyOnWriteArrayList<Integer> a() {
        return f42754b;
    }

    public static boolean a(int i11) {
        if (f42754b.contains(Integer.valueOf(i11))) {
            return false;
        }
        return f42754b.add(Integer.valueOf(i11));
    }

    public static boolean a(long j11) {
        return f42754b.contains(Integer.valueOf(com.transsion.athena.taaneh.anehat.a(j11)));
    }

    public static int b() {
        return f42753a;
    }

    public static void b(int i11) {
        if (f42753a != 0) {
            com.transsion.athena.taaneh.aethna.a("The host appId has been set 2 times");
        }
        f42753a = i11;
    }
}
