package com.google.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.Constructor;

/* loaded from: classes7.dex */
public class VungleAdActivity {

    /* renamed from: ̅, reason: not valid java name and contains not printable characters */
    public static boolean f41;

    /* renamed from: ̅, reason: not valid java name and contains not printable characters */
    public static ApplicationInfo m803(Object obj) {
        return ((Context) obj).getApplicationInfo();
    }

    /* renamed from: ̍, reason: not valid java name and contains not printable characters */
    public static Constructor m804(Object obj, Object obj2) {
        return ((Class) obj).getConstructor((Class[]) obj2);
    }

    /* renamed from: ̎, reason: not valid java name and contains not printable characters */
    public static boolean m805(Object obj, Object obj2) {
        return ((String) obj).startsWith((String) obj2);
    }

    /* renamed from: ̐, reason: not valid java name and contains not printable characters */
    public static boolean m806() {
        return true;
    }

    /* renamed from: ̒, reason: not valid java name and contains not printable characters */
    public static String m807(Object obj, int i11) {
        return ((String) obj).substring(i11);
    }

    /* renamed from: ̓, reason: not valid java name and contains not printable characters */
    public static Class m808(Object obj) {
        return Class.forName((String) obj);
    }

    /* renamed from: ̔, reason: not valid java name and contains not printable characters */
    public static int m809(Object obj, Object obj2) {
        return ((String) obj).indexOf((String) obj2);
    }
}
