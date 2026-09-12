package com.tn.lib.thread;

import android.os.MessageQueue;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public interface a extends MessageQueue.IdleHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final C0588a f40919a = C0588a.f40920a;

    /* renamed from: com.tn.lib.thread.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0588a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0588a f40920a = new C0588a();

        /* renamed from: b, reason: collision with root package name */
        private static final List f40921b = new CopyOnWriteArrayList();

        private C0588a() {
        }

        public final List a() {
            return f40921b;
        }
    }
}
