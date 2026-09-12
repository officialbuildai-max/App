package com.transsion.upload.auth;

import com.transsion.upload.bean.TstTokenEntity;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class AuthCheckManager {

    /* renamed from: b, reason: collision with root package name */
    private static TstTokenEntity f56756b;

    /* renamed from: a, reason: collision with root package name */
    public static final AuthCheckManager f56755a = new AuthCheckManager();

    /* renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArrayList f56757c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f56758d = new AtomicBoolean(false);

    private AuthCheckManager() {
    }

    private final boolean e() {
        Object m1185constructorimpl;
        Long expireTime;
        try {
            Result.Companion companion = Result.INSTANCE;
            TstTokenEntity tstTokenEntity = f56756b;
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(((tstTokenEntity == null || (expireTime = tstTokenEntity.getExpireTime()) == null) ? 0L : expireTime.longValue()) - ((long) 60) > System.currentTimeMillis() / ((long) 1000)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g() {
        String simpleName = AuthCheckManager.class.getSimpleName();
        Intrinsics.g(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final boolean h(a aVar) {
        AtomicBoolean atomicBoolean = f56758d;
        if (!atomicBoolean.get()) {
            atomicBoolean.set(true);
            return false;
        }
        f56757c.add(aVar);
        ew.a.f62155a.b(g() + " --> 正在请求中...");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        f56758d.set(false);
        for (a aVar : f56757c) {
            TstTokenEntity tstTokenEntity = f56756b;
            if (tstTokenEntity == null) {
                aVar.onFail("tstToken is empty");
            } else {
                aVar.a(tstTokenEntity);
            }
        }
        f56757c.clear();
        ew.a.f62155a.b(g() + " --> notifyCallback() --> clear()");
    }

    private final void j(a aVar) {
        if (h(aVar)) {
            return;
        }
        k.d(o0.a(y0.b()), null, null, new AuthCheckManager$requestAuth$1(aVar, null), 3, null);
    }

    public final void f(a aVar) {
        if (!e()) {
            j(aVar);
        } else if (aVar != null) {
            aVar.a(f56756b);
        }
    }
}
