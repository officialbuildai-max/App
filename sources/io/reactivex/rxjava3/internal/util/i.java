package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.operators.SpscArrayQueue;

/* loaded from: classes7.dex */
public abstract class i {
    public static boolean a(boolean z10, boolean z11, o oVar, boolean z12, io.reactivex.rxjava3.operators.g gVar, io.reactivex.rxjava3.disposables.c cVar, e eVar) {
        if (eVar.cancelled()) {
            gVar.clear();
            cVar.dispose();
            return true;
        }
        if (!z10) {
            return false;
        }
        if (z12) {
            if (!z11) {
                return false;
            }
            if (cVar != null) {
                cVar.dispose();
            }
            Throwable error = eVar.error();
            if (error != null) {
                oVar.onError(error);
            } else {
                oVar.onComplete();
            }
            return true;
        }
        Throwable error2 = eVar.error();
        if (error2 != null) {
            gVar.clear();
            if (cVar != null) {
                cVar.dispose();
            }
            oVar.onError(error2);
            return true;
        }
        if (!z11) {
            return false;
        }
        if (cVar != null) {
            cVar.dispose();
        }
        oVar.onComplete();
        return true;
    }

    public static boolean b(boolean z10, boolean z11, u10.c cVar, boolean z12, io.reactivex.rxjava3.operators.g gVar, h hVar) {
        if (hVar.cancelled()) {
            gVar.clear();
            return true;
        }
        if (!z10) {
            return false;
        }
        if (z12) {
            if (!z11) {
                return false;
            }
            Throwable error = hVar.error();
            if (error != null) {
                cVar.onError(error);
            } else {
                cVar.onComplete();
            }
            return true;
        }
        Throwable error2 = hVar.error();
        if (error2 != null) {
            gVar.clear();
            cVar.onError(error2);
            return true;
        }
        if (!z11) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public static io.reactivex.rxjava3.operators.g c(int i11) {
        return i11 < 0 ? new io.reactivex.rxjava3.operators.h(-i11) : new SpscArrayQueue(i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r1 = r15.leave(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(io.reactivex.rxjava3.operators.f r11, io.reactivex.rxjava3.core.o r12, boolean r13, io.reactivex.rxjava3.disposables.c r14, io.reactivex.rxjava3.internal.util.e r15) {
        /*
            r0 = 1
            r1 = r0
        L2:
            boolean r2 = r15.done()
            boolean r3 = r11.isEmpty()
            r4 = r12
            r5 = r13
            r6 = r11
            r7 = r14
            r8 = r15
            boolean r2 = a(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L16
            return
        L16:
            boolean r3 = r15.done()
            java.lang.Object r2 = r11.poll()
            if (r2 != 0) goto L22
            r10 = r0
            goto L24
        L22:
            r4 = 0
            r10 = r4
        L24:
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r11
            r8 = r14
            r9 = r15
            boolean r3 = a(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L31
            return
        L31:
            if (r10 == 0) goto L3b
            int r1 = -r1
            int r1 = r15.leave(r1)
            if (r1 != 0) goto L2
            return
        L3b:
            r15.accept(r12, r2)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.util.i.d(io.reactivex.rxjava3.operators.f, io.reactivex.rxjava3.core.o, boolean, io.reactivex.rxjava3.disposables.c, io.reactivex.rxjava3.internal.util.e):void");
    }

    public static void e(io.reactivex.rxjava3.operators.f fVar, u10.c cVar, boolean z10, io.reactivex.rxjava3.disposables.c cVar2, h hVar) {
        int i11 = 1;
        while (true) {
            boolean done = hVar.done();
            Object poll = fVar.poll();
            boolean z11 = poll == null;
            if (b(done, z11, cVar, z10, fVar, hVar)) {
                if (cVar2 != null) {
                    cVar2.dispose();
                    return;
                }
                return;
            } else if (z11) {
                i11 = hVar.leave(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                long requested = hVar.requested();
                if (requested == 0) {
                    fVar.clear();
                    if (cVar2 != null) {
                        cVar2.dispose();
                    }
                    cVar.onError(MissingBackpressureException.createDefault());
                    return;
                }
                if (hVar.accept(cVar, poll) && requested != Long.MAX_VALUE) {
                    hVar.produced(1L);
                }
            }
        }
    }

    public static void f(u10.d dVar, int i11) {
        dVar.request(i11 < 0 ? Long.MAX_VALUE : i11);
    }
}
