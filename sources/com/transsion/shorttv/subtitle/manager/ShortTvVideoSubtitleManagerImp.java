package com.transsion.shorttv.subtitle.manager;

import com.transsion.shorttv.utils.h;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.bean.SubtitleAppType;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import nh.m;

/* loaded from: classes6.dex */
public final class ShortTvVideoSubtitleManagerImp implements b {

    /* renamed from: g, reason: collision with root package name */
    public static final a f53137g = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private Set f53138b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final String f53139c = ShortTvVideoSubtitleManagerImp.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    private final n0 f53140d = o0.a(y0.c());

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f53141e = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.subtitle.manager.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qs.d r11;
            r11 = ShortTvVideoSubtitleManagerImp.r();
            return r11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final ShortTvVideoSubtitleManagerImp$resDownloadListener$1 f53142f = new ShortTvVideoSubtitleManagerImp$resDownloadListener$1(this);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void m(ts.a aVar, final Function1 function1) {
        String d11 = aVar.d();
        if (d11 == null || d11.length() == 0) {
            a.C0856a.f(lg.a.f68962a, "short_tv_subtitle", this.f53139c + " checkDownloadSubtitle fail， has no shorTvId", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (StringsKt.x(aVar.d()) == null) {
            a.C0856a.z(lg.a.f68962a, "short_tv_subtitle", this.f53139c + " checkDownloadSubtitle ,shorTvId is abnormal", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (!m.f70597a.e()) {
            lg.a.f68962a.x("short_tv_subtitle", this.f53139c + " checkDownloadSubtitle ,无网络不做检测", true);
            return;
        }
        lg.a.f68962a.c("short_tv_subtitle", this.f53139c + " checkDownloadSubtitle, name = " + aVar.h() + " subjectId:" + aVar.e() + " subtitleResId:" + aVar.g(), true);
        SubtitleDownloadManager.f55121a.e(aVar.e(), aVar.g(), null, aVar.d(), aVar.f(), 3, 0, aVar.a(), aVar.c(), aVar.b(), new Function1() { // from class: com.transsion.shorttv.subtitle.manager.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o11;
                o11 = ShortTvVideoSubtitleManagerImp.o(ShortTvVideoSubtitleManagerImp.this, function1, ((Boolean) obj).booleanValue());
                return o11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp, ts.a aVar, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        shortTvVideoSubtitleManagerImp.m(aVar, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp, Function1 function1, boolean z10) {
        k.d(shortTvVideoSubtitleManagerImp.f53140d, null, null, new ShortTvVideoSubtitleManagerImp$checkDownloadSubtitle$1$1(function1, z10, shortTvVideoSubtitleManagerImp, null), 3, null);
        return Unit.f67184a;
    }

    private final qs.d p() {
        return (qs.d) this.f53141e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q() {
        return h.f53707a.e().getString("k_language_short_name", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qs.d r() {
        rs.a c11 = lr.c.f69154a.c();
        if (c11 != null) {
            return c11.b();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.shorttv.subtitle.manager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp$getSubtitleList$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp$getSubtitleList$1 r0 = (com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp$getSubtitleList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp$getSubtitleList$1 r0 = new com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp$getSubtitleList$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.b(r7)
            goto L4d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.b(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.transsion.subtitle_download.SubtitleDownloadManager r2 = com.transsion.subtitle_download.SubtitleDownloadManager.f55121a
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r2.j(r6, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r4 = r7
            r7 = r6
            r6 = r4
        L4d:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L6c
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L57:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L6c
            java.lang.Object r0 = r7.next()
            com.transsion.subtitle_download.db.SubtitleDownloadTable r0 = (com.transsion.subtitle_download.db.SubtitleDownloadTable) r0
            ts.b r1 = new ts.b
            r1.<init>(r0)
            r6.add(r1)
            goto L57
        L6c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void b(com.transsion.subtitle_download.a listener) {
        Intrinsics.h(listener, "listener");
        SubtitleDownloadManager.f55121a.b(listener);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void c(com.transsion.subtitle_download.a listener) {
        Intrinsics.h(listener, "listener");
        SubtitleDownloadManager.f55121a.s(listener);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void d(ts.b bean) {
        Intrinsics.h(bean, "bean");
        SubtitleDownloadManager.f55121a.d(bean.a());
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void e(vs.a listener) {
        Intrinsics.h(listener, "listener");
        this.f53138b.add(listener);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void f(vs.a listener) {
        Intrinsics.h(listener, "listener");
        this.f53138b.remove(listener);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void g(ts.a bean, Function1 function1) {
        Intrinsics.h(bean, "bean");
        m(bean, function1);
    }

    @Override // com.transsion.shorttv.subtitle.manager.b
    public void init() {
        SubtitleAppType subtitleAppType = SubtitleAppType.NOVEL;
        if (!Intrinsics.c("mb", subtitleAppType.getValue())) {
            subtitleAppType = SubtitleAppType.MB;
        }
        SubtitleDownloadManager subtitleDownloadManager = SubtitleDownloadManager.f55121a;
        subtitleDownloadManager.k(subtitleAppType);
        subtitleDownloadManager.l(new Function0() { // from class: com.transsion.shorttv.subtitle.manager.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String q11;
                q11 = ShortTvVideoSubtitleManagerImp.q();
                return q11;
            }
        });
        qs.d p11 = p();
        if (p11 != null) {
            p11.j(this.f53142f);
        }
    }
}
