package com.google.firebase.sessions;

import android.util.Base64;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f32746a = new r();

    /* renamed from: b, reason: collision with root package name */
    private static final String f32747b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f32748c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f32749d;

    static {
        String encodeToString = Base64.encodeToString(StringsKt.E(q.f32745a.e()), 10);
        f32747b = encodeToString;
        f32748c = "firebase_session_" + encodeToString + "_data";
        f32749d = "firebase_session_" + encodeToString + "_settings";
    }

    private r() {
    }

    public final String a() {
        return f32748c;
    }

    public final String b() {
        return f32749d;
    }
}
