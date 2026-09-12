package androidx.work.impl.utils;

import androidx.view.LiveData;

/* loaded from: classes2.dex */
public abstract class LiveDataUtils {

    /* renamed from: androidx.work.impl.utils.LiveDataUtils$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements androidx.view.c0 {

        /* renamed from: a, reason: collision with root package name */
        Object f16012a = null;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j4.c f16013b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f16014c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l.a f16015d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.view.z f16016e;

        AnonymousClass1(j4.c cVar, Object obj, l.a aVar, androidx.view.z zVar) {
            this.f16013b = cVar;
            this.f16014c = obj;
            this.f16015d = aVar;
            this.f16016e = zVar;
        }

        @Override // androidx.view.c0
        public void onChanged(final Object obj) {
            this.f16013b.d(new Runnable() { // from class: androidx.work.impl.utils.LiveDataUtils.1.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AnonymousClass1.this.f16014c) {
                        try {
                            Object apply = AnonymousClass1.this.f16015d.apply(obj);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            Object obj2 = anonymousClass1.f16012a;
                            if (obj2 == null && apply != null) {
                                anonymousClass1.f16012a = apply;
                                anonymousClass1.f16016e.n(apply);
                            } else if (obj2 != null && !obj2.equals(apply)) {
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                anonymousClass12.f16012a = apply;
                                anonymousClass12.f16016e.n(apply);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            });
        }
    }

    public static LiveData a(LiveData liveData, l.a aVar, j4.c cVar) {
        Object obj = new Object();
        androidx.view.z zVar = new androidx.view.z();
        zVar.r(liveData, new AnonymousClass1(cVar, obj, aVar, zVar));
        return zVar;
    }
}
