package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public interface h {

    /* renamed from: a */
    public static final a f55010a = a.f55011a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        static final /* synthetic */ a f55011a = new a();

        /* renamed from: b */
        private static final Lazy f55012b = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoSubtitleManagerImp c11;
                c11 = h.a.c();
                return c11;
            }
        });

        private a() {
        }

        public static final VideoSubtitleManagerImp c() {
            return new VideoSubtitleManagerImp();
        }

        public final h b() {
            return (h) f55012b.getValue();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ void a(h hVar, DownloadBean downloadBean, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoPageInNet2CheckSubtitle");
            }
            if ((i11 & 2) != 0) {
                function1 = null;
            }
            hVar.e(downloadBean, function1);
        }
    }

    Object a(String str, Continuation continuation);

    void b(com.transsion.subtitle_download.a aVar);

    void c(com.transsion.subtitle_download.a aVar);

    void d(hu.c cVar);

    void destroy();

    void e(DownloadBean downloadBean, Function1 function1);

    void f(hu.c cVar);

    void g(eu.a aVar);

    void h(eu.a aVar);

    void i(DownloadBean downloadBean);

    void init();

    void j(eu.a aVar);

    void reset();
}
