package jb;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.c;
import com.google.firebase.l;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile FirebaseAnalytics f66104a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f66105b = new Object();

    public static final FirebaseAnalytics a(c cVar) {
        Intrinsics.h(cVar, "<this>");
        if (f66104a == null) {
            synchronized (f66105b) {
                if (f66104a == null) {
                    f66104a = FirebaseAnalytics.getInstance(l.a(c.f31123a).k());
                }
            }
        }
        FirebaseAnalytics firebaseAnalytics = f66104a;
        Intrinsics.e(firebaseAnalytics);
        return firebaseAnalytics;
    }
}
