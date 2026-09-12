package kotlinx.coroutines.sync;

import kotlin.coroutines.Continuation;

/* loaded from: classes7.dex */
public interface a {

    /* renamed from: kotlinx.coroutines.sync.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0842a {
        public static /* synthetic */ Object a(a aVar, Object obj, Continuation continuation, int i11, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if ((i11 & 1) != 0) {
                obj = null;
            }
            return aVar.h(obj, continuation);
        }

        public static /* synthetic */ boolean b(a aVar, Object obj, int i11, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i11 & 1) != 0) {
                obj = null;
            }
            return aVar.b(obj);
        }

        public static /* synthetic */ void c(a aVar, Object obj, int i11, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i11 & 1) != 0) {
                obj = null;
            }
            aVar.unlock(obj);
        }
    }

    boolean b(Object obj);

    boolean d();

    Object h(Object obj, Continuation continuation);

    void unlock(Object obj);
}
