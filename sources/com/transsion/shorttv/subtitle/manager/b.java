package com.transsion.shorttv.subtitle.manager;

import com.transsion.shorttv.subtitle.manager.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f53144a = a.f53145a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f53145a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Lazy f53146b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.subtitle.manager.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortTvVideoSubtitleManagerImp c11;
                c11 = b.a.c();
                return c11;
            }
        });

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ShortTvVideoSubtitleManagerImp c() {
            return new ShortTvVideoSubtitleManagerImp();
        }

        public final b b() {
            return (b) f53146b.getValue();
        }
    }

    /* renamed from: com.transsion.shorttv.subtitle.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0658b {
        public static /* synthetic */ void a(b bVar, ts.a aVar, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoPageInNet2CheckSubtitle");
            }
            if ((i11 & 2) != 0) {
                function1 = null;
            }
            bVar.g(aVar, function1);
        }
    }

    Object a(String str, Continuation continuation);

    void b(com.transsion.subtitle_download.a aVar);

    void c(com.transsion.subtitle_download.a aVar);

    void d(ts.b bVar);

    void e(vs.a aVar);

    void f(vs.a aVar);

    void g(ts.a aVar, Function1 function1);

    void init();
}
