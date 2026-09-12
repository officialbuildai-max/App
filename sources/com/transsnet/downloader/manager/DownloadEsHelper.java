package com.transsnet.downloader.manager;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.e1;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DownloadUtil;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lj.v0;

/* loaded from: classes.dex */
public final class DownloadEsHelper {

    /* renamed from: m, reason: collision with root package name */
    public static final a f59542m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    private static final Lazy f59543n = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadEsHelper U;
            U = DownloadEsHelper.U();
            return U;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap f59544a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap f59545b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap f59546c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap f59547d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap f59548e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap f59549f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private String f59550g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f59551h = "";

    /* renamed from: i, reason: collision with root package name */
    private int f59552i = 1;

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f59553j = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            lj.c n11;
            n11 = DownloadEsHelper.n();
            return n11;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f59554k = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            v0 a02;
            a02 = DownloadEsHelper.a0();
            return a02;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    private final Lazy f59555l = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            e1 j02;
            j02 = DownloadEsHelper.j0();
            return j02;
        }
    });

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadEsHelper a() {
            return (DownloadEsHelper) DownloadEsHelper.f59543n.getValue();
        }
    }

    public static /* synthetic */ Object B(DownloadEsHelper downloadEsHelper, boolean z10, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        return downloadEsHelper.A(z10, continuation);
    }

    public static /* synthetic */ Object F(DownloadEsHelper downloadEsHelper, String str, boolean z10, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return downloadEsHelper.E(str, z10, continuation);
    }

    private final v0 L() {
        return (v0) this.f59554k.getValue();
    }

    public static /* synthetic */ Object O(DownloadEsHelper downloadEsHelper, boolean z10, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        return downloadEsHelper.N(z10, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadEsHelper U() {
        return new DownloadEsHelper();
    }

    private final void V(String str, DownloadBean downloadBean) {
        DownloadBean downloadBean2 = (DownloadBean) this.f59548e.get(str);
        if ((downloadBean2 != null ? downloadBean2.getResolution() : 0) < downloadBean.getResolution()) {
            this.f59548e.put(str + downloadBean.getSe() + (downloadBean2 != null ? Integer.valueOf(downloadBean2.getEp()) : null), downloadBean);
        }
    }

    private final void W(String str, DownloadBean downloadBean) {
        this.f59549f.put(str, downloadBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v0 a0() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).z1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0110 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(com.transsion.baselib.db.download.DownloadBean r8, kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.j(com.transsion.baselib.db.download.DownloadBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 j0() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).E1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lj.c n() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).p1();
        }
        return null;
    }

    private final lj.c r() {
        return (lj.c) this.f59553j.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009a A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0033, B:15:0x0094, B:17:0x009a, B:19:0x00a8, B:20:0x00ac, B:22:0x00b2, B:24:0x00ba, B:25:0x00be, B:26:0x0111, B:32:0x00cb, B:34:0x00d1, B:35:0x00ed, B:37:0x00f3, B:38:0x00f6, B:40:0x00fc, B:41:0x00ff, B:43:0x0107, B:44:0x010b, B:52:0x0044, B:53:0x0080, B:54:0x0083, B:58:0x008d, B:61:0x004a, B:62:0x006b, B:64:0x0051, B:66:0x005a, B:68:0x0060, B:71:0x006f, B:73:0x0075), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(boolean r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.A(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008f A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0033, B:15:0x0089, B:17:0x008f, B:19:0x009d, B:20:0x00a1, B:22:0x00a7, B:24:0x00af, B:25:0x00b3, B:26:0x0104, B:32:0x00be, B:34:0x00c4, B:35:0x00e0, B:37:0x00e6, B:38:0x00e9, B:40:0x00ef, B:41:0x00f2, B:43:0x00fa, B:44:0x00fe, B:51:0x0042, B:52:0x0078, B:53:0x007b, B:55:0x0082, B:57:0x0046, B:58:0x0065, B:60:0x004d, B:62:0x0056, B:64:0x005c, B:67:0x0069, B:69:0x006f), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0082 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0033, B:15:0x0089, B:17:0x008f, B:19:0x009d, B:20:0x00a1, B:22:0x00a7, B:24:0x00af, B:25:0x00b3, B:26:0x0104, B:32:0x00be, B:34:0x00c4, B:35:0x00e0, B:37:0x00e6, B:38:0x00e9, B:40:0x00ef, B:41:0x00f2, B:43:0x00fa, B:44:0x00fe, B:51:0x0042, B:52:0x0078, B:53:0x007b, B:55:0x0082, B:57:0x0046, B:58:0x0065, B:60:0x004d, B:62:0x0056, B:64:0x005c, B:67:0x0069, B:69:0x006f), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.C(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object D(Continuation continuation) {
        lj.c r11 = r();
        if (r11 != null) {
            return r11.C(continuation);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(java.lang.String r6, boolean r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getOutsideVideoHistoricalPlayRecord$3
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.b(r8)
            goto L5c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.ConcurrentHashMap r8 = r5.f59544a
            boolean r8 = r8.containsKey(r6)
            if (r8 == 0) goto L4b
            if (r7 != 0) goto L4b
            java.util.concurrent.ConcurrentHashMap r7 = r5.f59544a
            java.lang.Object r6 = r7.get(r6)
            com.transsion.baselib.db.download.DownloadBean r6 = (com.transsion.baselib.db.download.DownloadBean) r6
            goto L6c
        L4b:
            lj.c r7 = r5.r()
            if (r7 == 0) goto L61
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r7.G(r6, r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8
            r7 = r6
            r6 = r8
            goto L65
        L61:
            r7 = 0
            r4 = r7
            r7 = r6
            r6 = r4
        L65:
            if (r6 == 0) goto L6c
            java.util.concurrent.ConcurrentHashMap r8 = r5.f59544a
            r8.put(r7, r6)
        L6c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.E(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00e5, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c7, B:37:0x00ca, B:39:0x00d0, B:40:0x00d3, B:42:0x00db, B:43:0x00df, B:50:0x003f, B:51:0x0055, B:52:0x0059, B:54:0x0060, B:57:0x0046, B:59:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0060 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00e5, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c7, B:37:0x00ca, B:39:0x00d0, B:40:0x00d3, B:42:0x00db, B:43:0x00df, B:50:0x003f, B:51:0x0055, B:52:0x0059, B:54:0x0060, B:57:0x0046, B:59:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(int r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.G(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00d3, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c9, B:37:0x00cd, B:44:0x003f, B:45:0x0055, B:46:0x0059, B:48:0x0060, B:51:0x0046, B:53:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0060 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00d3, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c9, B:37:0x00cd, B:44:0x003f, B:45:0x0055, B:46:0x0059, B:48:0x0060, B:51:0x0046, B:53:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getSeries$1
            if (r0 == 0) goto L13
            r0 = r10
            com.transsnet.downloader.manager.DownloadEsHelper$getSeries$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getSeries$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getSeries$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getSeries$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r9 = r0.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L34
            goto L68
        L34:
            r9 = move-exception
            goto Le2
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L34
            goto L55
        L43:
            kotlin.ResultKt.b(r10)
            lj.c r10 = r8.r()     // Catch: java.lang.Throwable -> L34
            if (r10 == 0) goto L58
            r0.label = r4     // Catch: java.lang.Throwable -> L34
            java.lang.Object r10 = r10.e(r9, r0)     // Catch: java.lang.Throwable -> L34
            if (r10 != r1) goto L55
            return r1
        L55:
            java.util.List r10 = (java.util.List) r10     // Catch: java.lang.Throwable -> L34
            goto L59
        L58:
            r10 = 0
        L59:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r9.<init>()     // Catch: java.lang.Throwable -> L34
            if (r10 == 0) goto Le1
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch: java.lang.Throwable -> L34
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> L34
            r2 = r9
            r9 = r10
        L68:
            boolean r10 = r9.hasNext()     // Catch: java.lang.Throwable -> L34
            if (r10 == 0) goto Le0
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> L34
            com.transsion.baselib.db.download.DownloadBean r10 = (com.transsion.baselib.db.download.DownloadBean) r10     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.ConcurrentHashMap r4 = r8.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r10.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto L80
            java.lang.String r5 = r10.getUrl()     // Catch: java.lang.Throwable -> L34
        L80:
            boolean r4 = r4.containsKey(r5)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L9f
            java.util.concurrent.ConcurrentHashMap r4 = r8.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r10.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto L92
            java.lang.String r5 = r10.getUrl()     // Catch: java.lang.Throwable -> L34
        L92:
            java.lang.Object r10 = r4.get(r5)     // Catch: java.lang.Throwable -> L34
            kotlin.jvm.internal.Intrinsics.e(r10)     // Catch: java.lang.Throwable -> L34
            com.transsion.baselib.db.download.DownloadBean r10 = (com.transsion.baselib.db.download.DownloadBean) r10     // Catch: java.lang.Throwable -> L34
            r2.add(r10)     // Catch: java.lang.Throwable -> L34
            goto Ld3
        L9f:
            boolean r4 = r10.isShotTV()     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto Lc1
            java.util.concurrent.ConcurrentHashMap r4 = r8.f59547d     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r10.getSubjectId()     // Catch: java.lang.Throwable -> L34
            int r6 = r10.getEp()     // Catch: java.lang.Throwable -> L34
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r7.<init>()     // Catch: java.lang.Throwable -> L34
            r7.append(r5)     // Catch: java.lang.Throwable -> L34
            r7.append(r6)     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L34
            r4.put(r5, r10)     // Catch: java.lang.Throwable -> L34
        Lc1:
            java.util.concurrent.ConcurrentHashMap r4 = r8.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r10.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto Lcd
            java.lang.String r5 = r10.getUrl()     // Catch: java.lang.Throwable -> L34
        Lcd:
            r4.put(r5, r10)     // Catch: java.lang.Throwable -> L34
            r2.add(r10)     // Catch: java.lang.Throwable -> L34
        Ld3:
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L34
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L34
            r0.label = r3     // Catch: java.lang.Throwable -> L34
            java.lang.Object r10 = r8.j(r10, r0)     // Catch: java.lang.Throwable -> L34
            if (r10 != r1) goto L68
            return r1
        Le0:
            r9 = r2
        Le1:
            return r9
        Le2:
            r9.printStackTrace()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.H(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00d3, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c9, B:37:0x00cd, B:44:0x003f, B:45:0x0055, B:46:0x0059, B:48:0x0060, B:51:0x0046, B:53:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0060 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00d3, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c9, B:37:0x00cd, B:44:0x003f, B:45:0x0055, B:46:0x0059, B:48:0x0060, B:51:0x0046, B:53:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getSeriesCompleted$1
            if (r0 == 0) goto L13
            r0 = r10
            com.transsnet.downloader.manager.DownloadEsHelper$getSeriesCompleted$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getSeriesCompleted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getSeriesCompleted$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getSeriesCompleted$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r9 = r0.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L34
            goto L68
        L34:
            r9 = move-exception
            goto Le2
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L34
            goto L55
        L43:
            kotlin.ResultKt.b(r10)
            lj.c r10 = r8.r()     // Catch: java.lang.Throwable -> L34
            if (r10 == 0) goto L58
            r0.label = r4     // Catch: java.lang.Throwable -> L34
            java.lang.Object r10 = r10.g(r9, r0)     // Catch: java.lang.Throwable -> L34
            if (r10 != r1) goto L55
            return r1
        L55:
            java.util.List r10 = (java.util.List) r10     // Catch: java.lang.Throwable -> L34
            goto L59
        L58:
            r10 = 0
        L59:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r9.<init>()     // Catch: java.lang.Throwable -> L34
            if (r10 == 0) goto Le1
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch: java.lang.Throwable -> L34
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> L34
            r2 = r9
            r9 = r10
        L68:
            boolean r10 = r9.hasNext()     // Catch: java.lang.Throwable -> L34
            if (r10 == 0) goto Le0
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> L34
            com.transsion.baselib.db.download.DownloadBean r10 = (com.transsion.baselib.db.download.DownloadBean) r10     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.ConcurrentHashMap r4 = r8.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r10.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto L80
            java.lang.String r5 = r10.getUrl()     // Catch: java.lang.Throwable -> L34
        L80:
            boolean r4 = r4.containsKey(r5)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L9f
            java.util.concurrent.ConcurrentHashMap r4 = r8.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r10.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto L92
            java.lang.String r5 = r10.getUrl()     // Catch: java.lang.Throwable -> L34
        L92:
            java.lang.Object r10 = r4.get(r5)     // Catch: java.lang.Throwable -> L34
            kotlin.jvm.internal.Intrinsics.e(r10)     // Catch: java.lang.Throwable -> L34
            com.transsion.baselib.db.download.DownloadBean r10 = (com.transsion.baselib.db.download.DownloadBean) r10     // Catch: java.lang.Throwable -> L34
            r2.add(r10)     // Catch: java.lang.Throwable -> L34
            goto Ld3
        L9f:
            boolean r4 = r10.isShotTV()     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto Lc1
            java.util.concurrent.ConcurrentHashMap r4 = r8.f59547d     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r10.getSubjectId()     // Catch: java.lang.Throwable -> L34
            int r6 = r10.getEp()     // Catch: java.lang.Throwable -> L34
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r7.<init>()     // Catch: java.lang.Throwable -> L34
            r7.append(r5)     // Catch: java.lang.Throwable -> L34
            r7.append(r6)     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Throwable -> L34
            r4.put(r5, r10)     // Catch: java.lang.Throwable -> L34
        Lc1:
            java.util.concurrent.ConcurrentHashMap r4 = r8.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r10.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto Lcd
            java.lang.String r5 = r10.getUrl()     // Catch: java.lang.Throwable -> L34
        Lcd:
            r4.put(r5, r10)     // Catch: java.lang.Throwable -> L34
            r2.add(r10)     // Catch: java.lang.Throwable -> L34
        Ld3:
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L34
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L34
            r0.label = r3     // Catch: java.lang.Throwable -> L34
            java.lang.Object r10 = r8.j(r10, r0)     // Catch: java.lang.Throwable -> L34
            if (r10 != r1) goto L68
            return r1
        Le0:
            r9 = r2
        Le1:
            return r9
        Le2:
            r9.printStackTrace()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.I(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0046, B:16:0x004b, B:18:0x0053, B:19:0x0057, B:21:0x005d, B:23:0x0065, B:24:0x0069, B:26:0x0071, B:28:0x0079, B:29:0x007d, B:35:0x0037, B:37:0x003d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(java.lang.String r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getSubjectDownloadBean$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsnet.downloader.manager.DownloadEsHelper$getSubjectDownloadBean$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getSubjectDownloadBean$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getSubjectDownloadBean$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getSubjectDownloadBean$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2a
            goto L46
        L2a:
            r6 = move-exception
            goto L83
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r9)
            lj.c r9 = r5.r()     // Catch: java.lang.Throwable -> L2a
            if (r9 == 0) goto L82
            r0.label = r4     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r9 = r9.F(r6, r7, r8, r0)     // Catch: java.lang.Throwable -> L2a
            if (r9 != r1) goto L46
            return r1
        L46:
            com.transsion.baselib.db.download.DownloadBean r9 = (com.transsion.baselib.db.download.DownloadBean) r9     // Catch: java.lang.Throwable -> L2a
            if (r9 != 0) goto L4b
            goto L82
        L4b:
            java.util.concurrent.ConcurrentHashMap r6 = r5.f59544a     // Catch: java.lang.Throwable -> L2a
            java.lang.String r7 = r9.getResourceId()     // Catch: java.lang.Throwable -> L2a
            if (r7 != 0) goto L57
            java.lang.String r7 = r9.getUrl()     // Catch: java.lang.Throwable -> L2a
        L57:
            boolean r6 = r6.containsKey(r7)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L71
            java.util.concurrent.ConcurrentHashMap r6 = r5.f59544a     // Catch: java.lang.Throwable -> L2a
            java.lang.String r7 = r9.getResourceId()     // Catch: java.lang.Throwable -> L2a
            if (r7 != 0) goto L69
            java.lang.String r7 = r9.getUrl()     // Catch: java.lang.Throwable -> L2a
        L69:
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L2a
            com.transsion.baselib.db.download.DownloadBean r6 = (com.transsion.baselib.db.download.DownloadBean) r6     // Catch: java.lang.Throwable -> L2a
            r3 = r6
            goto L86
        L71:
            java.util.concurrent.ConcurrentHashMap r6 = r5.f59544a     // Catch: java.lang.Throwable -> L2a
            java.lang.String r7 = r9.getResourceId()     // Catch: java.lang.Throwable -> L2a
            if (r7 != 0) goto L7d
            java.lang.String r7 = r9.getUrl()     // Catch: java.lang.Throwable -> L2a
        L7d:
            r6.put(r7, r9)     // Catch: java.lang.Throwable -> L2a
            r3 = r9
            goto L86
        L82:
            return r3
        L83:
            r6.printStackTrace()
        L86:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.J(java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DownloadBean K(String subjectId, int i11, int i12) {
        Intrinsics.h(subjectId, "subjectId");
        return (DownloadBean) this.f59548e.get(subjectId + i11 + i12);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00e5, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c7, B:37:0x00ca, B:39:0x00d0, B:40:0x00d3, B:42:0x00db, B:43:0x00df, B:50:0x003f, B:51:0x0055, B:52:0x0059, B:54:0x0060, B:57:0x0046, B:59:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0060 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00e5, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c7, B:37:0x00ca, B:39:0x00d0, B:40:0x00d3, B:42:0x00db, B:43:0x00df, B:50:0x003f, B:51:0x0055, B:52:0x0059, B:54:0x0060, B:57:0x0046, B:59:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M(kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.M(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006d A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:11:0x0030, B:12:0x0062, B:14:0x006d, B:15:0x0073, B:17:0x0079, B:19:0x0087, B:20:0x008b, B:31:0x0093, B:33:0x009b, B:34:0x009f, B:37:0x00a7, B:24:0x00ab, B:26:0x00b3, B:27:0x00b7, B:42:0x00c2, B:43:0x00c4), top: B:10:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N(boolean r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getTransferReceivedList$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$getTransferReceivedList$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getTransferReceivedList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getTransferReceivedList$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getTransferReceivedList$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            boolean r7 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            com.transsnet.downloader.manager.DownloadEsHelper r1 = (com.transsnet.downloader.manager.DownloadEsHelper) r1
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L34
            goto L62
        L34:
            r7 = move-exception
            goto Lc8
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            kotlin.ResultKt.b(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L65
            lj.c r2 = r6.r()     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L68
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L65
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L65
            r0.Z$0 = r7     // Catch: java.lang.Throwable -> L65
            r0.label = r4     // Catch: java.lang.Throwable -> L65
            java.lang.Object r0 = r2.l(r0)     // Catch: java.lang.Throwable -> L65
            if (r0 != r1) goto L5e
            return r1
        L5e:
            r1 = r6
            r5 = r0
            r0 = r8
            r8 = r5
        L62:
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> L34
            goto L6b
        L65:
            r7 = move-exception
            r0 = r8
            goto Lc8
        L68:
            r1 = r6
            r0 = r8
            r8 = r3
        L6b:
            if (r8 == 0) goto Lc4
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L34
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L34
        L73:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto Lc2
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L34
            com.transsion.baselib.db.download.DownloadBean r2 = (com.transsion.baselib.db.download.DownloadBean) r2     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.ConcurrentHashMap r3 = r1.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = r2.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r4 != 0) goto L8b
            java.lang.String r4 = r2.getUrl()     // Catch: java.lang.Throwable -> L34
        L8b:
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L34
            if (r3 == 0) goto Lab
            if (r7 != 0) goto Lab
            java.util.concurrent.ConcurrentHashMap r3 = r1.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = r2.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r4 != 0) goto L9f
            java.lang.String r4 = r2.getUrl()     // Catch: java.lang.Throwable -> L34
        L9f:
            java.lang.Object r2 = r3.get(r4)     // Catch: java.lang.Throwable -> L34
            com.transsion.baselib.db.download.DownloadBean r2 = (com.transsion.baselib.db.download.DownloadBean) r2     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L73
            r0.add(r2)     // Catch: java.lang.Throwable -> L34
            goto L73
        Lab:
            java.util.concurrent.ConcurrentHashMap r3 = r1.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = r2.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r4 != 0) goto Lb7
            java.lang.String r4 = r2.getUrl()     // Catch: java.lang.Throwable -> L34
        Lb7:
            r3.put(r4, r2)     // Catch: java.lang.Throwable -> L34
            boolean r2 = r0.add(r2)     // Catch: java.lang.Throwable -> L34
            kotlin.coroutines.jvm.internal.Boxing.a(r2)     // Catch: java.lang.Throwable -> L34
            goto L73
        Lc2:
            kotlin.Unit r3 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L34
        Lc4:
            kotlin.Result.m1185constructorimpl(r3)     // Catch: java.lang.Throwable -> L34
            goto Ld1
        Lc8:
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.ResultKt.a(r7)
            kotlin.Result.m1185constructorimpl(r7)
        Ld1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.N(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00b1, B:31:0x009f, B:33:0x00a7, B:34:0x00ab, B:41:0x003f, B:42:0x0055, B:43:0x0059, B:45:0x0060, B:48:0x0046, B:50:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0060 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00b1, B:31:0x009f, B:33:0x00a7, B:34:0x00ab, B:41:0x003f, B:42:0x0055, B:43:0x0059, B:45:0x0060, B:48:0x0046, B:50:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P(java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionList$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionList$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionList$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionList$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.L$1
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L34
            goto L68
        L34:
            r7 = move-exception
            goto Lc0
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L34
            goto L55
        L43:
            kotlin.ResultKt.b(r8)
            lj.c r8 = r6.r()     // Catch: java.lang.Throwable -> L34
            if (r8 == 0) goto L58
            r0.label = r4     // Catch: java.lang.Throwable -> L34
            java.lang.Object r8 = r8.A(r7, r0)     // Catch: java.lang.Throwable -> L34
            if (r8 != r1) goto L55
            return r1
        L55:
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> L34
            goto L59
        L58:
            r8 = 0
        L59:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r7.<init>()     // Catch: java.lang.Throwable -> L34
            if (r8 == 0) goto Lbf
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L34
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L34
            r2 = r7
            r7 = r8
        L68:
            boolean r8 = r7.hasNext()     // Catch: java.lang.Throwable -> L34
            if (r8 == 0) goto Lbe
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L34
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.ConcurrentHashMap r4 = r6.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r8.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto L80
            java.lang.String r5 = r8.getUrl()     // Catch: java.lang.Throwable -> L34
        L80:
            boolean r4 = r4.containsKey(r5)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L9f
            java.util.concurrent.ConcurrentHashMap r4 = r6.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r8.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto L92
            java.lang.String r5 = r8.getUrl()     // Catch: java.lang.Throwable -> L34
        L92:
            java.lang.Object r8 = r4.get(r5)     // Catch: java.lang.Throwable -> L34
            kotlin.jvm.internal.Intrinsics.e(r8)     // Catch: java.lang.Throwable -> L34
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8     // Catch: java.lang.Throwable -> L34
            r2.add(r8)     // Catch: java.lang.Throwable -> L34
            goto Lb1
        L9f:
            java.util.concurrent.ConcurrentHashMap r4 = r6.f59544a     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = r8.getResourceId()     // Catch: java.lang.Throwable -> L34
            if (r5 != 0) goto Lab
            java.lang.String r5 = r8.getUrl()     // Catch: java.lang.Throwable -> L34
        Lab:
            r4.put(r5, r8)     // Catch: java.lang.Throwable -> L34
            r2.add(r8)     // Catch: java.lang.Throwable -> L34
        Lb1:
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L34
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L34
            r0.label = r3     // Catch: java.lang.Throwable -> L34
            java.lang.Object r8 = r6.j(r8, r0)     // Catch: java.lang.Throwable -> L34
            if (r8 != r1) goto L68
            return r1
        Lbe:
            r7 = r2
        Lbf:
            return r7
        Lc0:
            r7.printStackTrace()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.P(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:11:0x0029, B:12:0x006a, B:17:0x006f, B:18:0x007a, B:20:0x0080, B:22:0x008e, B:23:0x0092, B:33:0x0098, B:35:0x00a0, B:36:0x00a4, B:39:0x00ac, B:26:0x00b0, B:28:0x00b8, B:29:0x00bc, B:47:0x0038, B:48:0x004e, B:51:0x0054, B:54:0x005b, B:56:0x0061, B:60:0x003f, B:62:0x0045), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q(java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionListByResourceId$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionListByResourceId$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionListByResourceId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionListByResourceId$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getUGCCollectionListByResourceId$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L2d
            goto L6a
        L2d:
            r7 = move-exception
            goto Lc8
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L2d
            goto L4e
        L3c:
            kotlin.ResultKt.b(r8)
            lj.c r8 = r6.r()     // Catch: java.lang.Throwable -> L2d
            if (r8 == 0) goto Lc7
            r0.label = r4     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r8 = r8.f(r7, r0)     // Catch: java.lang.Throwable -> L2d
            if (r8 != r1) goto L4e
            return r1
        L4e:
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8     // Catch: java.lang.Throwable -> L2d
            if (r8 != 0) goto L54
            goto Lc7
        L54:
            java.lang.String r7 = r8.getUgcVideoCollectionId()     // Catch: java.lang.Throwable -> L2d
            if (r7 != 0) goto L5b
            return r5
        L5b:
            lj.c r8 = r6.r()     // Catch: java.lang.Throwable -> L2d
            if (r8 == 0) goto Lc7
            r0.label = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r8 = r8.A(r7, r0)     // Catch: java.lang.Throwable -> L2d
            if (r8 != r1) goto L6a
            return r1
        L6a:
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> L2d
            if (r8 != 0) goto L6f
            goto Lc7
        L6f:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L2d
            r7.<init>()     // Catch: java.lang.Throwable -> L2d
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L2d
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L2d
        L7a:
            boolean r0 = r8.hasNext()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto Ld0
            java.lang.Object r0 = r8.next()     // Catch: java.lang.Throwable -> L2d
            com.transsion.baselib.db.download.DownloadBean r0 = (com.transsion.baselib.db.download.DownloadBean) r0     // Catch: java.lang.Throwable -> L2d
            java.util.concurrent.ConcurrentHashMap r1 = r6.f59544a     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = r0.getResourceId()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L92
            java.lang.String r2 = r0.getUrl()     // Catch: java.lang.Throwable -> L2d
        L92:
            boolean r1 = r1.containsKey(r2)     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto Lb0
            java.util.concurrent.ConcurrentHashMap r1 = r6.f59544a     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = r0.getResourceId()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto La4
            java.lang.String r2 = r0.getUrl()     // Catch: java.lang.Throwable -> L2d
        La4:
            java.lang.Object r0 = r1.get(r2)     // Catch: java.lang.Throwable -> L2d
            com.transsion.baselib.db.download.DownloadBean r0 = (com.transsion.baselib.db.download.DownloadBean) r0     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L7a
            r7.add(r0)     // Catch: java.lang.Throwable -> L2d
            goto L7a
        Lb0:
            java.util.concurrent.ConcurrentHashMap r1 = r6.f59544a     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = r0.getResourceId()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto Lbc
            java.lang.String r2 = r0.getUrl()     // Catch: java.lang.Throwable -> L2d
        Lbc:
            r1.put(r2, r0)     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r7.add(r0)     // Catch: java.lang.Throwable -> L2d
            kotlin.coroutines.jvm.internal.Boxing.a(r0)     // Catch: java.lang.Throwable -> L2d
            goto L7a
        Lc7:
            return r5
        Lc8:
            r7.printStackTrace()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        Ld0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.Q(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0046, B:16:0x004b, B:18:0x0053, B:19:0x0057, B:21:0x005d, B:23:0x0065, B:24:0x0069, B:26:0x0071, B:28:0x0079, B:29:0x007d, B:35:0x0037, B:37:0x003d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getUGCVideoDownloadBean$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsnet.downloader.manager.DownloadEsHelper$getUGCVideoDownloadBean$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getUGCVideoDownloadBean$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getUGCVideoDownloadBean$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getUGCVideoDownloadBean$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L2a
            goto L46
        L2a:
            r6 = move-exception
            goto L83
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r7)
            lj.c r7 = r5.r()     // Catch: java.lang.Throwable -> L2a
            if (r7 == 0) goto L82
            r0.label = r4     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r7 = r7.k(r6, r0)     // Catch: java.lang.Throwable -> L2a
            if (r7 != r1) goto L46
            return r1
        L46:
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7     // Catch: java.lang.Throwable -> L2a
            if (r7 != 0) goto L4b
            goto L82
        L4b:
            java.util.concurrent.ConcurrentHashMap r6 = r5.f59544a     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = r7.getResourceId()     // Catch: java.lang.Throwable -> L2a
            if (r0 != 0) goto L57
            java.lang.String r0 = r7.getUrl()     // Catch: java.lang.Throwable -> L2a
        L57:
            boolean r6 = r6.containsKey(r0)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L71
            java.util.concurrent.ConcurrentHashMap r6 = r5.f59544a     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = r7.getResourceId()     // Catch: java.lang.Throwable -> L2a
            if (r0 != 0) goto L69
            java.lang.String r0 = r7.getUrl()     // Catch: java.lang.Throwable -> L2a
        L69:
            java.lang.Object r6 = r6.get(r0)     // Catch: java.lang.Throwable -> L2a
            com.transsion.baselib.db.download.DownloadBean r6 = (com.transsion.baselib.db.download.DownloadBean) r6     // Catch: java.lang.Throwable -> L2a
            r3 = r6
            goto L86
        L71:
            java.util.concurrent.ConcurrentHashMap r6 = r5.f59544a     // Catch: java.lang.Throwable -> L2a
            java.lang.String r0 = r7.getResourceId()     // Catch: java.lang.Throwable -> L2a
            if (r0 != 0) goto L7d
            java.lang.String r0 = r7.getUrl()     // Catch: java.lang.Throwable -> L2a
        L7d:
            r6.put(r0, r7)     // Catch: java.lang.Throwable -> L2a
            r3 = r7
            goto L86
        L82:
            return r3
        L83:
            r6.printStackTrace()
        L86:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.R(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DownloadBean S(String ugcVideoId) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        return (DownloadBean) this.f59549f.get(ugcVideoId);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T(com.transsion.baselib.db.download.DownloadBean r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$insert$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$insert$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$insert$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$insert$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$insert$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L80
        L29:
            r7 = move-exception
            goto L83
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.b(r8)
            int r8 = r7.getStatus()     // Catch: java.lang.Throwable -> L29
            r2 = 7
            if (r8 != r2) goto L40
            kotlin.Unit r7 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L29
            return r7
        L40:
            boolean r8 = r7.isShotTV()     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L62
            java.util.concurrent.ConcurrentHashMap r8 = r6.f59547d     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = r7.getSubjectId()     // Catch: java.lang.Throwable -> L29
            int r4 = r7.getEp()     // Catch: java.lang.Throwable -> L29
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29
            r5.<init>()     // Catch: java.lang.Throwable -> L29
            r5.append(r2)     // Catch: java.lang.Throwable -> L29
            r5.append(r4)     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L29
            r8.put(r2, r7)     // Catch: java.lang.Throwable -> L29
        L62:
            java.util.concurrent.ConcurrentHashMap r8 = r6.f59544a     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = r7.getResourceId()     // Catch: java.lang.Throwable -> L29
            if (r2 != 0) goto L6e
            java.lang.String r2 = r7.getUrl()     // Catch: java.lang.Throwable -> L29
        L6e:
            r8.put(r2, r7)     // Catch: java.lang.Throwable -> L29
            lj.c r8 = r6.r()     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L80
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r7 = r8.v(r7, r0)     // Catch: java.lang.Throwable -> L29
            if (r7 != r1) goto L80
            return r1
        L80:
            kotlin.Unit r7 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L29
            return r7
        L83:
            r7.printStackTrace()
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.T(com.transsion.baselib.db.download.DownloadBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void X(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f59550g = str;
    }

    public final void Y(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f59551h = str;
    }

    public final void Z(int i11) {
        this.f59552i = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:11:0x0028, B:12:0x00a3, B:18:0x0040, B:21:0x006d, B:23:0x0073, B:26:0x007f, B:32:0x008f, B:34:0x0095, B:38:0x0047, B:40:0x004e, B:42:0x0051, B:44:0x0059, B:45:0x005d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:11:0x0028, B:12:0x00a3, B:18:0x0040, B:21:0x006d, B:23:0x0073, B:26:0x007f, B:32:0x008f, B:34:0x0095, B:38:0x0047, B:40:0x004e, B:42:0x0051, B:44:0x0059, B:45:0x005d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008c -> B:19:0x008d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b0(com.transsion.baselib.db.download.DownloadBean r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.transsnet.downloader.manager.DownloadEsHelper$update$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsnet.downloader.manager.DownloadEsHelper$update$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$update$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$update$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$update$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2d
            goto La3
        L2d:
            r8 = move-exception
            goto La6
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            java.lang.Object r8 = r0.L$1
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r2 = r0.L$0
            com.transsion.baselib.db.download.DownloadBean r2 = (com.transsion.baselib.db.download.DownloadBean) r2
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2d
            goto L8d
        L44:
            kotlin.ResultKt.b(r9)
            int r9 = r8.getStatus()     // Catch: java.lang.Throwable -> L2d
            r2 = 7
            if (r9 != r2) goto L51
            kotlin.Unit r8 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L2d
            return r8
        L51:
            java.util.concurrent.ConcurrentHashMap r9 = r7.f59544a     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = r8.getResourceId()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L5d
            java.lang.String r2 = r8.getUrl()     // Catch: java.lang.Throwable -> L2d
        L5d:
            r9.put(r2, r8)     // Catch: java.lang.Throwable -> L2d
            java.util.List r9 = r8.getSubtitleList()     // Catch: java.lang.Throwable -> L2d
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch: java.lang.Throwable -> L2d
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Throwable -> L2d
            r6 = r9
            r9 = r8
            r8 = r6
        L6d:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L2d
            if (r2 == 0) goto L8f
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L2d
            com.transsion.baselib.db.download.SubtitleBean r2 = (com.transsion.baselib.db.download.SubtitleBean) r2     // Catch: java.lang.Throwable -> L2d
            lj.v0 r5 = r7.L()     // Catch: java.lang.Throwable -> L2d
            if (r5 == 0) goto L6d
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L2d
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L2d
            r0.label = r4     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r2 = r5.a(r2, r0)     // Catch: java.lang.Throwable -> L2d
            if (r2 != r1) goto L8c
            return r1
        L8c:
            r2 = r9
        L8d:
            r9 = r2
            goto L6d
        L8f:
            lj.c r8 = r7.r()     // Catch: java.lang.Throwable -> L2d
            if (r8 == 0) goto La3
            r2 = 0
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L2d
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L2d
            r0.label = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r8 = r8.z(r9, r0)     // Catch: java.lang.Throwable -> L2d
            if (r8 != r1) goto La3
            return r1
        La3:
            kotlin.Unit r8 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L2d
            return r8
        La6:
            r8.printStackTrace()
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.b0(com.transsion.baselib.db.download.DownloadBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c0(java.lang.String r5, long r6, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$updateDuration$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$updateDuration$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$updateDuration$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$updateDuration$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$updateDuration$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L56
        L29:
            r5 = move-exception
            goto L59
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.ConcurrentHashMap r8 = r4.f59544a     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = r8.get(r5)     // Catch: java.lang.Throwable -> L29
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L47
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.e(r6)     // Catch: java.lang.Throwable -> L29
            r8.setDuration(r2)     // Catch: java.lang.Throwable -> L29
        L47:
            lj.c r8 = r4.r()     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L56
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r8.D(r5, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L56
            return r1
        L56:
            kotlin.Unit r5 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L29
            return r5
        L59:
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.c0(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0101 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x002f, B:13:0x010e, B:20:0x0045, B:22:0x00fb, B:24:0x0101, B:28:0x004c, B:29:0x006b, B:30:0x0072, B:32:0x0078, B:34:0x0086, B:35:0x008c, B:38:0x0096, B:40:0x009f, B:41:0x00a6, B:43:0x00d9, B:45:0x00de, B:47:0x00e4, B:49:0x00ea, B:56:0x0053, B:58:0x0059), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x002f, B:13:0x010e, B:20:0x0045, B:22:0x00fb, B:24:0x0101, B:28:0x004c, B:29:0x006b, B:30:0x0072, B:32:0x0078, B:34:0x0086, B:35:0x008c, B:38:0x0096, B:40:0x009f, B:41:0x00a6, B:43:0x00d9, B:45:0x00de, B:47:0x00e4, B:49:0x00ea, B:56:0x0053, B:58:0x0059), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x002f, B:13:0x010e, B:20:0x0045, B:22:0x00fb, B:24:0x0101, B:28:0x004c, B:29:0x006b, B:30:0x0072, B:32:0x0078, B:34:0x0086, B:35:0x008c, B:38:0x0096, B:40:0x009f, B:41:0x00a6, B:43:0x00d9, B:45:0x00de, B:47:0x00e4, B:49:0x00ea, B:56:0x0053, B:58:0x0059), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x002f, B:13:0x010e, B:20:0x0045, B:22:0x00fb, B:24:0x0101, B:28:0x004c, B:29:0x006b, B:30:0x0072, B:32:0x0078, B:34:0x0086, B:35:0x008c, B:38:0x0096, B:40:0x009f, B:41:0x00a6, B:43:0x00d9, B:45:0x00de, B:47:0x00e4, B:49:0x00ea, B:56:0x0053, B:58:0x0059), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ea A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x002f, B:13:0x010e, B:20:0x0045, B:22:0x00fb, B:24:0x0101, B:28:0x004c, B:29:0x006b, B:30:0x0072, B:32:0x0078, B:34:0x0086, B:35:0x008c, B:38:0x0096, B:40:0x009f, B:41:0x00a6, B:43:0x00d9, B:45:0x00de, B:47:0x00e4, B:49:0x00ea, B:56:0x0053, B:58:0x0059), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d0(java.lang.String r25, int r26, long r27, kotlin.coroutines.Continuation r29) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.d0(java.lang.String, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e0(java.lang.String r5, long r6, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$updateReadProgress$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$updateReadProgress$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$updateReadProgress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$updateReadProgress$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$updateReadProgress$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L52
        L29:
            r5 = move-exception
            goto L55
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.ConcurrentHashMap r8 = r4.f59544a     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = r8.get(r5)     // Catch: java.lang.Throwable -> L29
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L43
            r8.setReadProgress(r6)     // Catch: java.lang.Throwable -> L29
        L43:
            lj.c r8 = r4.r()     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L52
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r8.t(r5, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L52
            return r1
        L52:
            kotlin.Unit r5 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L29
            return r5
        L55:
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.e0(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f0(java.lang.String r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.transsnet.downloader.manager.DownloadEsHelper$updateStatus$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsnet.downloader.manager.DownloadEsHelper$updateStatus$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$updateStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$updateStatus$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$updateStatus$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L29
            goto L52
        L29:
            r5 = move-exception
            goto L55
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r7)
            java.util.concurrent.ConcurrentHashMap r7 = r4.f59544a     // Catch: java.lang.Throwable -> L29
            java.lang.Object r7 = r7.get(r5)     // Catch: java.lang.Throwable -> L29
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7     // Catch: java.lang.Throwable -> L29
            if (r7 == 0) goto L43
            r7.setStatus(r6)     // Catch: java.lang.Throwable -> L29
        L43:
            lj.c r7 = r4.r()     // Catch: java.lang.Throwable -> L29
            if (r7 == 0) goto L52
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r7.c(r5, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L52
            return r1
        L52:
            kotlin.Unit r5 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L29
            return r5
        L55:
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.f0(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final File g() {
        File file = new File(lj.b.f68989a.c(), "builtIn");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g0(java.lang.String r12, com.transsion.moviedetailapi.bean.Subject r13, kotlin.coroutines.Continuation r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.transsnet.downloader.manager.DownloadEsHelper$updateSubjectIfo$1
            if (r0 == 0) goto L14
            r0 = r14
            com.transsnet.downloader.manager.DownloadEsHelper$updateSubjectIfo$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$updateSubjectIfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r10 = r0
            goto L1a
        L14:
            com.transsnet.downloader.manager.DownloadEsHelper$updateSubjectIfo$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$updateSubjectIfo$1
            r0.<init>(r11, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r10.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.b(r14)     // Catch: java.lang.Throwable -> L2b
            goto L9f
        L2b:
            r12 = move-exception
            goto La2
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            kotlin.ResultKt.b(r14)
            java.util.concurrent.ConcurrentHashMap r14 = r11.f59544a     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r14 = r14.get(r12)     // Catch: java.lang.Throwable -> L2b
            com.transsion.baselib.db.download.DownloadBean r14 = (com.transsion.baselib.db.download.DownloadBean) r14     // Catch: java.lang.Throwable -> L2b
            if (r14 == 0) goto L73
            java.lang.String r1 = r13.getRestrictLevel()     // Catch: java.lang.Throwable -> L2b
            r14.setRestrictLevel(r1)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r1 = r13.getReleaseDate()     // Catch: java.lang.Throwable -> L2b
            r14.setReleaseDate(r1)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r1 = r13.getCountryName()     // Catch: java.lang.Throwable -> L2b
            r14.setCountryName(r1)     // Catch: java.lang.Throwable -> L2b
            java.lang.Integer r1 = r13.getSeNum()     // Catch: java.lang.Throwable -> L2b
            r14.setSeNum(r1)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r1 = r13.getGenre()     // Catch: java.lang.Throwable -> L2b
            r14.setGenre(r1)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r1 = r13.getSubtitles()     // Catch: java.lang.Throwable -> L2b
            r14.setSubtitles(r1)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r1 = r13.getImdbRate()     // Catch: java.lang.Throwable -> L2b
            r14.setImdbRate(r1)     // Catch: java.lang.Throwable -> L2b
        L73:
            lj.c r1 = r11.r()     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L9f
            java.lang.String r3 = r13.getRestrictLevel()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = r13.getReleaseDate()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r5 = r13.getCountryName()     // Catch: java.lang.Throwable -> L2b
            java.lang.Integer r6 = r13.getSeNum()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r7 = r13.getGenre()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r8 = r13.getSubtitles()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r9 = r13.getImdbRate()     // Catch: java.lang.Throwable -> L2b
            r10.label = r2     // Catch: java.lang.Throwable -> L2b
            r2 = r12
            java.lang.Object r12 = r1.I(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L2b
            if (r12 != r0) goto L9f
            return r0
        L9f:
            kotlin.Unit r12 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L2b
            return r12
        La2:
            r12.printStackTrace()
            kotlin.Unit r12 = kotlin.Unit.f67184a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.g0(java.lang.String, com.transsion.moviedetailapi.bean.Subject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final File h() {
        i();
        File file = new File(lj.b.f68989a.e());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h0(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.transsnet.downloader.manager.DownloadEsHelper$updateSubtitleSelectId$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsnet.downloader.manager.DownloadEsHelper$updateSubtitleSelectId$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$updateSubtitleSelectId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$updateSubtitleSelectId$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$updateSubtitleSelectId$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L29
            goto L52
        L29:
            r5 = move-exception
            goto L55
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r7)
            java.util.concurrent.ConcurrentHashMap r7 = r4.f59544a     // Catch: java.lang.Throwable -> L29
            java.lang.Object r7 = r7.get(r5)     // Catch: java.lang.Throwable -> L29
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7     // Catch: java.lang.Throwable -> L29
            if (r7 == 0) goto L43
            r7.setSubtitleSelectId(r6)     // Catch: java.lang.Throwable -> L29
        L43:
            lj.c r7 = r4.r()     // Catch: java.lang.Throwable -> L29
            if (r7 == 0) goto L52
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r7.b(r5, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L52
            return r1
        L52:
            kotlin.Unit r5 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L29
            return r5
        L55:
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.h0(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void i() {
        String e11 = lj.b.f68989a.e();
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        String string = bVar.b().getString("download_root_path", e11);
        String string2 = bVar.b().getString("download_root_path_name", null);
        if (string2 == null) {
            string2 = Utils.a().getString(R$string.str_download_dialog_path_moviebox_folder);
            Intrinsics.g(string2, "getString(...)");
        }
        int i11 = bVar.b().getInt("download_root_path_type", 1);
        if (!DownloadUtil.f60023a.D()) {
            String string3 = Utils.a().getString(R$string.str_download_dialog_path_moviebox_folder);
            Intrinsics.g(string3, "getString(...)");
            this.f59551h = string3;
            this.f59550g = e11;
            this.f59552i = 1;
            return;
        }
        this.f59551h = string2;
        this.f59552i = i11;
        if (string == null || string.length() == 0) {
            string = e11;
        }
        this.f59550g = string;
        try {
            File file = new File(this.f59550g);
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        } catch (Throwable th2) {
            lg.a.f68962a.i("DownloadEsHelper", "path error, path = " + this.f59551h + ", error = " + th2, true);
            String string4 = Utils.a().getString(R$string.str_download_dialog_path_moviebox_folder);
            Intrinsics.g(string4, "getString(...)");
            this.f59551h = string4;
            this.f59550g = e11;
            this.f59552i = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i0(java.lang.String r5, int r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$updateWH$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$updateWH$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$updateWH$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$updateWH$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$updateWH$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L55
        L29:
            r5 = move-exception
            goto L58
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.ConcurrentHashMap r8 = r4.f59544a     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = r8.get(r5)     // Catch: java.lang.Throwable -> L29
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L46
            r8.setVideoWidth(r6)     // Catch: java.lang.Throwable -> L29
            r8.setVideoHeight(r7)     // Catch: java.lang.Throwable -> L29
        L46:
            lj.c r8 = r4.r()     // Catch: java.lang.Throwable -> L29
            if (r8 == 0) goto L55
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r8.j(r5, r6, r7, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L55
            return r1
        L55:
            kotlin.Unit r5 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L29
            return r5
        L58:
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.i0(java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.transsnet.downloader.manager.DownloadEsHelper$deleteByUrl$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsnet.downloader.manager.DownloadEsHelper$deleteByUrl$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$deleteByUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$deleteByUrl$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$deleteByUrl$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L29
            goto L52
        L29:
            r5 = move-exception
            goto L55
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r7)
            java.util.concurrent.ConcurrentHashMap r7 = r4.f59544a     // Catch: java.lang.Throwable -> L29
            boolean r7 = r7.containsKey(r6)     // Catch: java.lang.Throwable -> L29
            if (r7 == 0) goto L43
            java.util.concurrent.ConcurrentHashMap r7 = r4.f59544a     // Catch: java.lang.Throwable -> L29
            r7.remove(r6)     // Catch: java.lang.Throwable -> L29
        L43:
            lj.c r6 = r4.r()     // Catch: java.lang.Throwable -> L29
            if (r6 == 0) goto L52
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r6.o(r5, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L52
            return r1
        L52:
            kotlin.Unit r5 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L29
            return r5
        L55:
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.k(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:11:0x0028, B:12:0x007d, B:19:0x003a, B:20:0x006b, B:22:0x0071, B:26:0x0041, B:28:0x0049, B:30:0x0050, B:32:0x005a, B:34:0x0060), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.transsnet.downloader.manager.DownloadEsHelper$deleteItem$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsnet.downloader.manager.DownloadEsHelper$deleteItem$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$deleteItem$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$deleteItem$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$deleteItem$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2c
            goto L7d
        L2c:
            r6 = move-exception
            goto L80
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2c
            goto L6b
        L3e:
            kotlin.ResultKt.b(r9)
            java.util.concurrent.ConcurrentHashMap r9 = r5.f59544a     // Catch: java.lang.Throwable -> L2c
            boolean r9 = r9.containsKey(r6)     // Catch: java.lang.Throwable -> L2c
            if (r9 == 0) goto L4e
            java.util.concurrent.ConcurrentHashMap r9 = r5.f59544a     // Catch: java.lang.Throwable -> L2c
            r9.remove(r6)     // Catch: java.lang.Throwable -> L2c
        L4e:
            if (r7 == 0) goto L58
            java.util.concurrent.ConcurrentHashMap r9 = r5.f59549f     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r7 = r9.remove(r7)     // Catch: java.lang.Throwable -> L2c
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7     // Catch: java.lang.Throwable -> L2c
        L58:
            if (r8 == 0) goto L6b
            lj.v0 r7 = r5.L()     // Catch: java.lang.Throwable -> L2c
            if (r7 == 0) goto L6b
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L2c
            r0.label = r4     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r7 = r7.d(r8, r0)     // Catch: java.lang.Throwable -> L2c
            if (r7 != r1) goto L6b
            return r1
        L6b:
            lj.c r7 = r5.r()     // Catch: java.lang.Throwable -> L2c
            if (r7 == 0) goto L7d
            r8 = 0
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L2c
            r0.label = r3     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r6 = r7.d(r6, r0)     // Catch: java.lang.Throwable -> L2c
            if (r6 != r1) goto L7d
            return r1
        L7d:
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L2c
            return r6
        L80:
            r6.printStackTrace()
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.l(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|(1:(2:10|11)(2:27|28))(4:29|(4:31|(2:33|(2:35|(1:37))(3:38|13|14))|15|(3:20|21|22))|17|18)|12|13|14|15|(0)|17|18))|41|6|7|(0)(0)|12|13|14|15|(0)|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x002d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005e, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r6 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r6));
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(com.transsion.baselib.db.download.DownloadBean r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsnet.downloader.manager.DownloadEsHelper$deleteTransferReceived$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsnet.downloader.manager.DownloadEsHelper$deleteTransferReceived$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$deleteTransferReceived$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$deleteTransferReceived$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$deleteTransferReceived$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$0
            com.transsion.baselib.db.download.DownloadBean r5 = (com.transsion.baselib.db.download.DownloadBean) r5
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L55
        L2d:
            r6 = move-exception
            goto L5e
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            if (r5 == 0) goto L93
            java.lang.String r6 = r5.getResourceId()
            if (r6 == 0) goto L6b
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2d
            lj.c r2 = r4.r()     // Catch: java.lang.Throwable -> L2d
            if (r2 == 0) goto L58
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2d
            r0.label = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r6 = r2.n(r6, r0)     // Catch: java.lang.Throwable -> L2d
            if (r6 != r1) goto L55
            return r1
        L55:
            kotlin.Unit r6 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L2d
            goto L59
        L58:
            r6 = 0
        L59:
            java.lang.Object r6 = kotlin.Result.m1185constructorimpl(r6)     // Catch: java.lang.Throwable -> L2d
            goto L68
        L5e:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.m1185constructorimpl(r6)
        L68:
            kotlin.Result.m1184boximpl(r6)
        L6b:
            java.lang.String r5 = r5.getPath()
            if (r5 == 0) goto L93
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L85
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L85
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L85
            boolean r5 = r6.delete()     // Catch: java.lang.Throwable -> L85
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)     // Catch: java.lang.Throwable -> L85
            java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r5)     // Catch: java.lang.Throwable -> L85
            goto L90
        L85:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r5)
        L90:
            kotlin.Result.m1184boximpl(r5)
        L93:
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.m(com.transsion.baselib.db.download.DownloadBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsnet.downloader.manager.DownloadEsHelper$findDownloadBySubjectId$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsnet.downloader.manager.DownloadEsHelper$findDownloadBySubjectId$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$findDownloadBySubjectId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$findDownloadBySubjectId$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$findDownloadBySubjectId$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L46
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            r6 = 0
            if (r5 == 0) goto L48
            lj.c r2 = r4.r()
            if (r2 == 0) goto L48
            r0.label = r3
            java.lang.Object r6 = r2.q(r5, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            java.util.List r6 = (java.util.List) r6
        L48:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            if (r6 == 0) goto L93
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L55:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L93
            java.lang.Object r0 = r6.next()
            com.transsion.baselib.db.download.DownloadBean r0 = (com.transsion.baselib.db.download.DownloadBean) r0
            java.util.concurrent.ConcurrentHashMap r1 = r4.f59544a
            java.lang.String r2 = r0.getResourceId()
            if (r2 != 0) goto L6d
            java.lang.String r2 = r0.getUrl()
        L6d:
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L8b
            java.util.concurrent.ConcurrentHashMap r1 = r4.f59544a
            java.lang.String r2 = r0.getResourceId()
            if (r2 != 0) goto L7f
            java.lang.String r2 = r0.getUrl()
        L7f:
            java.lang.Object r0 = r1.get(r2)
            com.transsion.baselib.db.download.DownloadBean r0 = (com.transsion.baselib.db.download.DownloadBean) r0
            if (r0 == 0) goto L55
            r5.add(r0)
            goto L55
        L8b:
            boolean r0 = r5.add(r0)
            kotlin.coroutines.jvm.internal.Boxing.a(r0)
            goto L55
        L93:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.o(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002d, B:18:0x003f, B:19:0x0068, B:21:0x006e, B:24:0x0076, B:28:0x0046, B:30:0x004e, B:31:0x0057, B:33:0x005d), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002d, B:18:0x003f, B:19:0x0068, B:21:0x006e, B:24:0x0076, B:28:0x0046, B:30:0x004e, B:31:0x0057, B:33:0x005d), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$findDownloadedByResourceId$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$findDownloadedByResourceId$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$findDownloadedByResourceId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$findDownloadedByResourceId$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$findDownloadedByResourceId$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 == r5) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r7 = r0.L$0
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L31
            goto L81
        L31:
            r7 = move-exception
            goto L82
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L31
            goto L68
        L43:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.ConcurrentHashMap r8 = r6.f59544a     // Catch: java.lang.Throwable -> L31
            boolean r8 = r8.containsKey(r7)     // Catch: java.lang.Throwable -> L31
            if (r8 == 0) goto L57
            java.util.concurrent.ConcurrentHashMap r8 = r6.f59544a     // Catch: java.lang.Throwable -> L31
            java.lang.Object r7 = r8.get(r7)     // Catch: java.lang.Throwable -> L31
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7     // Catch: java.lang.Throwable -> L31
            goto L74
        L57:
            lj.c r8 = r6.r()     // Catch: java.lang.Throwable -> L31
            if (r8 == 0) goto L6b
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L31
            r0.label = r5     // Catch: java.lang.Throwable -> L31
            java.lang.Object r8 = r8.f(r7, r0)     // Catch: java.lang.Throwable -> L31
            if (r8 != r1) goto L68
            return r1
        L68:
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8     // Catch: java.lang.Throwable -> L31
            goto L6c
        L6b:
            r8 = r3
        L6c:
            if (r8 == 0) goto L73
            java.util.concurrent.ConcurrentHashMap r2 = r6.f59544a     // Catch: java.lang.Throwable -> L31
            r2.put(r7, r8)     // Catch: java.lang.Throwable -> L31
        L73:
            r7 = r8
        L74:
            if (r7 == 0) goto L81
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L31
            r0.label = r4     // Catch: java.lang.Throwable -> L31
            java.lang.Object r8 = r6.j(r7, r0)     // Catch: java.lang.Throwable -> L31
            if (r8 != r1) goto L81
            return r1
        L81:
            return r7
        L82:
            r7.printStackTrace()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.p(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DownloadBean q(String resourceId) {
        Intrinsics.h(resourceId, "resourceId");
        if (this.f59544a.containsKey(resourceId)) {
            return (DownloadBean) this.f59544a.get(resourceId);
        }
        return null;
    }

    public final File s() {
        i();
        return new File(lj.b.f68989a.e());
    }

    public final String t() {
        return this.f59550g;
    }

    public final int u() {
        return this.f59552i;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:12:0x0034, B:14:0x0072, B:16:0x0078, B:18:0x0086, B:19:0x008a, B:21:0x0090, B:23:0x0098, B:24:0x009c, B:25:0x00d3, B:31:0x00a9, B:33:0x00c9, B:34:0x00cd, B:41:0x0047, B:42:0x005f, B:43:0x0063, B:45:0x006a, B:47:0x004e, B:49:0x0054), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006a A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:12:0x0034, B:14:0x0072, B:16:0x0078, B:18:0x0086, B:19:0x008a, B:21:0x0090, B:23:0x0098, B:24:0x009c, B:25:0x00d3, B:31:0x00a9, B:33:0x00c9, B:34:0x00cd, B:41:0x0047, B:42:0x005f, B:43:0x0063, B:45:0x006a, B:47:0x004e, B:49:0x0054), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.v(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:11:0x002c, B:12:0x0051, B:17:0x0056, B:19:0x005e, B:20:0x0062, B:22:0x0068, B:24:0x0070, B:25:0x0074, B:27:0x007c, B:29:0x0098, B:30:0x009c, B:36:0x003e, B:38:0x0044), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(java.lang.String r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getEpisodeBean$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadEsHelper$getEpisodeBean$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getEpisodeBean$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getEpisodeBean$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getEpisodeBean$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L30
            goto L51
        L30:
            r6 = move-exception
            goto La2
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.b(r8)
            lj.c r8 = r5.r()     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto La1
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L30
            r0.I$0 = r7     // Catch: java.lang.Throwable -> L30
            r0.label = r4     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.h(r6, r7, r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r1) goto L51
            return r1
        L51:
            com.transsion.baselib.db.download.DownloadBean r8 = (com.transsion.baselib.db.download.DownloadBean) r8     // Catch: java.lang.Throwable -> L30
            if (r8 != 0) goto L56
            goto La1
        L56:
            java.util.concurrent.ConcurrentHashMap r0 = r5.f59544a     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = r8.getResourceId()     // Catch: java.lang.Throwable -> L30
            if (r1 != 0) goto L62
            java.lang.String r1 = r8.getUrl()     // Catch: java.lang.Throwable -> L30
        L62:
            boolean r0 = r0.containsKey(r1)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L7c
            java.util.concurrent.ConcurrentHashMap r6 = r5.f59544a     // Catch: java.lang.Throwable -> L30
            java.lang.String r7 = r8.getResourceId()     // Catch: java.lang.Throwable -> L30
            if (r7 != 0) goto L74
            java.lang.String r7 = r8.getUrl()     // Catch: java.lang.Throwable -> L30
        L74:
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L30
            com.transsion.baselib.db.download.DownloadBean r6 = (com.transsion.baselib.db.download.DownloadBean) r6     // Catch: java.lang.Throwable -> L30
            r3 = r6
            goto La5
        L7c:
            java.util.concurrent.ConcurrentHashMap r0 = r5.f59547d     // Catch: java.lang.Throwable -> L30
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r1.<init>()     // Catch: java.lang.Throwable -> L30
            r1.append(r6)     // Catch: java.lang.Throwable -> L30
            r1.append(r7)     // Catch: java.lang.Throwable -> L30
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L30
            r0.put(r6, r8)     // Catch: java.lang.Throwable -> L30
            java.util.concurrent.ConcurrentHashMap r6 = r5.f59544a     // Catch: java.lang.Throwable -> L30
            java.lang.String r7 = r8.getResourceId()     // Catch: java.lang.Throwable -> L30
            if (r7 != 0) goto L9c
            java.lang.String r7 = r8.getUrl()     // Catch: java.lang.Throwable -> L30
        L9c:
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L30
            r3 = r8
            goto La5
        La1:
            return r3
        La2:
            r6.printStackTrace()
        La5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.w(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DownloadBean x(String subjectId, int i11) {
        Intrinsics.h(subjectId, "subjectId");
        return (DownloadBean) this.f59547d.get(subjectId + i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00e5, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c7, B:37:0x00ca, B:39:0x00d0, B:40:0x00d3, B:42:0x00db, B:43:0x00df, B:50:0x003f, B:51:0x0055, B:52:0x0059, B:54:0x0060, B:57:0x0046, B:59:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0060 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x0030, B:14:0x0068, B:16:0x006e, B:18:0x007c, B:19:0x0080, B:21:0x0086, B:23:0x008e, B:24:0x0092, B:25:0x00e5, B:31:0x009f, B:33:0x00a5, B:34:0x00c1, B:36:0x00c7, B:37:0x00ca, B:39:0x00d0, B:40:0x00d3, B:42:0x00db, B:43:0x00df, B:50:0x003f, B:51:0x0055, B:52:0x0059, B:54:0x0060, B:57:0x0046, B:59:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:10:0x0026, B:11:0x0044, B:12:0x0048, B:14:0x004c, B:16:0x005a, B:18:0x0060, B:20:0x0064, B:22:0x0072, B:27:0x006c, B:31:0x0054, B:36:0x0035, B:38:0x003b), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:10:0x0026, B:11:0x0044, B:12:0x0048, B:14:0x004c, B:16:0x005a, B:18:0x0060, B:20:0x0064, B:22:0x0072, B:27:0x006c, B:31:0x0054, B:36:0x0035, B:38:0x003b), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054 A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:10:0x0026, B:11:0x0044, B:12:0x0048, B:14:0x004c, B:16:0x005a, B:18:0x0060, B:20:0x0064, B:22:0x0072, B:27:0x006c, B:31:0x0054, B:36:0x0035, B:38:0x003b), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.transsnet.downloader.manager.DownloadEsHelper$getLatestDownloadVideo$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsnet.downloader.manager.DownloadEsHelper$getLatestDownloadVideo$1 r0 = (com.transsnet.downloader.manager.DownloadEsHelper$getLatestDownloadVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadEsHelper$getLatestDownloadVideo$1 r0 = new com.transsnet.downloader.manager.DownloadEsHelper$getLatestDownloadVideo$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L77
            goto L44
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.ResultKt.b(r6)
            lj.c r6 = r5.r()     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L47
            r0.label = r3     // Catch: java.lang.Throwable -> L77
            java.lang.Object r6 = r6.y(r0)     // Catch: java.lang.Throwable -> L77
            if (r6 != r1) goto L44
            return r1
        L44:
            com.transsion.baselib.db.download.DownloadBean r6 = (com.transsion.baselib.db.download.DownloadBean) r6     // Catch: java.lang.Throwable -> L77
            goto L48
        L47:
            r6 = r4
        L48:
            java.util.concurrent.ConcurrentHashMap r0 = r5.f59544a     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L52
            java.lang.String r1 = r6.getResourceId()     // Catch: java.lang.Throwable -> L77
            if (r1 != 0) goto L5a
        L52:
            if (r6 == 0) goto L59
            java.lang.String r1 = r6.getUrl()     // Catch: java.lang.Throwable -> L77
            goto L5a
        L59:
            r1 = r4
        L5a:
            boolean r0 = r0.containsKey(r1)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L76
            java.util.concurrent.ConcurrentHashMap r0 = r5.f59544a     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L6a
            java.lang.String r1 = r6.getResourceId()     // Catch: java.lang.Throwable -> L77
            if (r1 != 0) goto L72
        L6a:
            if (r6 == 0) goto L71
            java.lang.String r1 = r6.getUrl()     // Catch: java.lang.Throwable -> L77
            goto L72
        L71:
            r1 = r4
        L72:
            java.lang.Object r6 = r0.get(r1)     // Catch: java.lang.Throwable -> L77
        L76:
            return r6
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadEsHelper.z(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
