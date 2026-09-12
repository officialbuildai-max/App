package androidx.media3.common;

import java.util.HashSet;

/* loaded from: classes2.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet f10425a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private static String f10426b = "media3.common";

    public static synchronized void a(String str) {
        synchronized (u.class) {
            if (f10425a.add(str)) {
                f10426b += ", " + str;
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (u.class) {
            str = f10426b;
        }
        return str;
    }
}
