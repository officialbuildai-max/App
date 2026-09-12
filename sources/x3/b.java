package x3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f78165c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Map f78166d = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final ReentrantLock f78167a;

    /* renamed from: b, reason: collision with root package name */
    private final c f78168b;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final c c(String str) {
            return new c(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock d(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map map = b.f78166d;
                    Object obj = map.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        map.put(str, obj);
                    }
                    reentrantLock = (ReentrantLock) obj;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return reentrantLock;
        }
    }

    public b(String filename, boolean z10) {
        Intrinsics.h(filename, "filename");
        a aVar = f78165c;
        this.f78167a = aVar.d(filename);
        this.f78168b = z10 ? aVar.c(filename) : null;
    }

    public final Object b(Function0 onLocked, Function1 onLockError) {
        Intrinsics.h(onLocked, "onLocked");
        Intrinsics.h(onLockError, "onLockError");
        this.f78167a.lock();
        boolean z10 = false;
        try {
            c cVar = this.f78168b;
            if (cVar != null) {
                cVar.a();
            }
            z10 = true;
            try {
                Object invoke = onLocked.invoke();
                this.f78167a.unlock();
                return invoke;
            } finally {
                c cVar2 = this.f78168b;
                if (cVar2 != null) {
                    cVar2.b();
                }
            }
        } catch (Throwable th2) {
            try {
                if (z10) {
                    throw th2;
                }
                onLockError.invoke(th2);
                throw new KotlinNothingValueException();
            } catch (Throwable th3) {
                this.f78167a.unlock();
                throw th3;
            }
        }
    }
}
