package com.google.common.base;

import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private static final k f30298a = c();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements k {
        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if (e(str)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Optional b(Class cls, String str) {
        WeakReference weakReference = (WeakReference) d.a(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.fromNullable((Enum) cls.cast(weakReference.get()));
    }

    private static k c() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str) {
        return str == null || str.isEmpty();
    }
}
