package com.google.android.exoplayer2;

import java.util.HashSet;

/* loaded from: classes3.dex */
public abstract class m1 {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet f25342a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private static String f25343b = "goog.exo.core";

    public static synchronized void a(String str) {
        synchronized (m1.class) {
            if (f25342a.add(str)) {
                f25343b += ", " + str;
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (m1.class) {
            str = f25343b;
        }
        return str;
    }
}
