package com.transsion.ugcvideodetail.hepler.subtitle.manager;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.ugcvideodetail.hepler.subtitle.manager.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f56525a = a.f56526a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f56526a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final String f56527b = "UGCVideoSubtitleManager";

        /* renamed from: c, reason: collision with root package name */
        private static final Lazy f56528c = LazyKt.b(new Function0() { // from class: com.transsion.ugcvideodetail.hepler.subtitle.manager.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UGCVideoSubtitleManagerImp d11;
                d11 = b.a.d();
                return d11;
            }
        });

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final UGCVideoSubtitleManagerImp d() {
            return new UGCVideoSubtitleManagerImp();
        }

        public final b b() {
            return (b) f56528c.getValue();
        }

        public final String c() {
            return f56527b;
        }
    }

    /* renamed from: com.transsion.ugcvideodetail.hepler.subtitle.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0708b {
        public static /* synthetic */ void a(b bVar, DownloadBean downloadBean, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoPageInNet2CheckSubtitle");
            }
            if ((i11 & 2) != 0) {
                function1 = null;
            }
            bVar.e(downloadBean, function1);
        }
    }

    Object a(String str, Continuation continuation);

    void b(com.transsion.subtitle_download.a aVar);

    void c(com.transsion.subtitle_download.a aVar);

    void d(hu.c cVar);

    void e(DownloadBean downloadBean, Function1 function1);

    void f(hu.c cVar);

    void h(eu.a aVar);
}
