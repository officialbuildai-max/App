package com.transsnet.login;

import com.transsnet.loginapi.ILoginApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;

/* loaded from: classes7.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f60690a = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.login.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            r c11;
            c11 = t.c();
            return c11;
        }
    });

    private static final ILoginApi b() {
        return (ILoginApi) f60690a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r c() {
        return new r();
    }

    public static final ILoginApi d() {
        ILoginApi b11 = b();
        lg.a.f68962a.c("LoginProvider", "provide instance=" + System.identityHashCode(b11) + ", thread=" + Thread.currentThread().getName(), true);
        return b11;
    }
}
