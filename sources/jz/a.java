package jz;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.Callable;
import lz.h;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile h f66576a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f66577b;

    static Object a(h hVar, Object obj) {
        try {
            return hVar.apply(obj);
        } catch (Throwable th2) {
            throw io.reactivex.rxjava3.exceptions.a.a(th2);
        }
    }

    static Scheduler b(h hVar, Callable callable) {
        Scheduler scheduler = (Scheduler) a(hVar, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static Scheduler c(Callable callable) {
        try {
            Scheduler scheduler = (Scheduler) callable.call();
            if (scheduler != null) {
                return scheduler;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th2) {
            throw io.reactivex.rxjava3.exceptions.a.a(th2);
        }
    }

    public static Scheduler d(Callable callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        h hVar = f66576a;
        return hVar == null ? c(callable) : b(hVar, callable);
    }

    public static Scheduler e(Scheduler scheduler) {
        if (scheduler == null) {
            throw new NullPointerException("scheduler == null");
        }
        h hVar = f66577b;
        return hVar == null ? scheduler : (Scheduler) a(hVar, scheduler);
    }
}
