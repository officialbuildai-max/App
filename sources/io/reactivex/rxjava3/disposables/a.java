package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.f;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class a implements c, d {

    /* renamed from: a, reason: collision with root package name */
    f f65439a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f65440b;

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean a(c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean b(c cVar) {
        Objects.requireNonNull(cVar, "disposable is null");
        if (!this.f65440b) {
            synchronized (this) {
                try {
                    if (!this.f65440b) {
                        f fVar = this.f65439a;
                        if (fVar == null) {
                            fVar = new f();
                            this.f65439a = fVar;
                        }
                        fVar.a(cVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean c(c cVar) {
        Objects.requireNonNull(cVar, "disposable is null");
        if (this.f65440b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f65440b) {
                    return false;
                }
                f fVar = this.f65439a;
                if (fVar != null && fVar.e(cVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public void d() {
        if (this.f65440b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f65440b) {
                    return;
                }
                f fVar = this.f65439a;
                this.f65439a = null;
                e(fVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (this.f65440b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f65440b) {
                    return;
                }
                this.f65440b = true;
                f fVar = this.f65439a;
                this.f65439a = null;
                e(fVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    void e(f fVar) {
        if (fVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : fVar.b()) {
            if (obj instanceof c) {
                try {
                    ((c) obj).dispose();
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.g((Throwable) arrayList.get(0));
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.f65440b;
    }
}
