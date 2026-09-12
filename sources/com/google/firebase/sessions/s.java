package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public interface s {

    /* renamed from: a, reason: collision with root package name */
    public static final a f32750a = a.f32751a;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f32751a = new a();

        private a() {
        }

        public final s a() {
            Object j11 = com.google.firebase.l.a(com.google.firebase.c.f31123a).j(s.class);
            Intrinsics.g(j11, "Firebase.app[SessionDatastore::class.java]");
            return (s) j11;
        }
    }

    String a();

    void b(String str);
}
