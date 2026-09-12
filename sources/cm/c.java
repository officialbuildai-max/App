package cm;

import android.util.Log;
import xl.k;

/* loaded from: classes5.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final InterfaceC0176c f17366a = new e();

    /* loaded from: classes5.dex */
    public interface a {
        Object create();
    }

    /* loaded from: classes5.dex */
    public interface b {
        k getVerifier();
    }

    /* renamed from: cm.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0176c {
        void reset(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d implements f {

        /* renamed from: a, reason: collision with root package name */
        private final a f17367a;

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC0176c f17368b;

        /* renamed from: c, reason: collision with root package name */
        private final f f17369c;

        d(f fVar, a aVar, InterfaceC0176c interfaceC0176c) {
            this.f17369c = fVar;
            this.f17367a = aVar;
            this.f17368b = interfaceC0176c;
        }

        @Override // cm.f
        public Object acquire() {
            Object acquire = this.f17369c.acquire();
            if (acquire == null) {
                acquire = this.f17367a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof b) {
                ((b) acquire).getVerifier().a(false);
            }
            return acquire;
        }

        @Override // cm.f
        public boolean release(Object obj) {
            if (obj instanceof b) {
                ((b) obj).getVerifier().a(true);
            }
            this.f17368b.reset(obj);
            return this.f17369c.release(obj);
        }
    }

    /* loaded from: classes5.dex */
    static class e implements InterfaceC0176c {
        e() {
        }

        @Override // cm.c.InterfaceC0176c
        public void reset(Object obj) {
        }
    }

    private static f a(f fVar, a aVar) {
        return b(fVar, aVar, f17366a);
    }

    private static f b(f fVar, a aVar, InterfaceC0176c interfaceC0176c) {
        return new d(fVar, aVar, interfaceC0176c);
    }

    public static f c(int i11, a aVar) {
        return a(new h(i11), aVar);
    }
}
