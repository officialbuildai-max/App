package com.transsnet.downloader.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.y0;

/* loaded from: classes7.dex */
public final class HistoricalPlayRecordViewModel extends a {

    /* renamed from: n, reason: collision with root package name */
    private int f60200n;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.view.b0 f60188b = new androidx.view.b0();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f60189c = new androidx.view.b0();

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f60190d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.b0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 k02;
            k02 = HistoricalPlayRecordViewModel.k0();
            return k02;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private final androidx.view.b0 f60191e = new androidx.view.b0();

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f60192f = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.c0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            y0 h02;
            h02 = HistoricalPlayRecordViewModel.h0();
            return h02;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f60193g = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.d0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            jj.a y10;
            y10 = HistoricalPlayRecordViewModel.y();
            return y10;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f60194h = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.e0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ShortTVPlayDao j02;
            j02 = HistoricalPlayRecordViewModel.j0();
            return j02;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f60195i = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.f0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoDetailPlayDao m02;
            m02 = HistoricalPlayRecordViewModel.m0();
            return m02;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f60196j = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.g0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UGCVideoDetailPlayDao l02;
            l02 = HistoricalPlayRecordViewModel.l0();
            return l02;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f60197k = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.h0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IAudioApi a02;
            a02 = HistoricalPlayRecordViewModel.a0();
            return a02;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    private final Lazy f60198l = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.i0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IFloatingApi b02;
            b02 = HistoricalPlayRecordViewModel.b0();
            return b02;
        }
    });

    /* renamed from: m, reason: collision with root package name */
    private String f60199m = "lastFormatTime";

    /* renamed from: o, reason: collision with root package name */
    private int f60201o = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List A(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, List list, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        return historicalPlayRecordViewModel.z(list, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(com.transsion.baselib.db.audio.AudioBean r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteAudioRecord$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteAudioRecord$1 r0 = (com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteAudioRecord$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteAudioRecord$1 r0 = new com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteAudioRecord$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            com.transsion.baselib.db.audio.AudioBean r5 = (com.transsion.baselib.db.audio.AudioBean) r5
            kotlin.ResultKt.b(r6)
            goto L49
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            jj.a r6 = r4.H()
            if (r6 == 0) goto L49
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.b(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            com.transsnet.downloader.viewmodel.a0 r6 = com.transsnet.downloader.viewmodel.a0.f60208a
            java.lang.String r5 = r5.getTitle()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "delete --- "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = " ---audio recording"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.t(r5)
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.D(com.transsion.baselib.db.audio.AudioBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(com.transsion.baselib.db.video.VideoDetailPlayBean r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteShortTVRecord$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteShortTVRecord$1 r0 = (com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteShortTVRecord$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteShortTVRecord$1 r0 = new com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteShortTVRecord$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L5d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r7)
            goto L4c
        L38:
            kotlin.ResultKt.b(r7)
            com.transsion.baselib.db.video.ShortTVPlayDao r7 = r5.Q()
            java.lang.String r6 = r6.getSubjectId()
            r0.label = r4
            java.lang.Object r7 = r7.e(r6, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            com.transsion.baselib.db.video.ShortTVPlayBean r7 = (com.transsion.baselib.db.video.ShortTVPlayBean) r7
            if (r7 == 0) goto L5d
            com.transsion.baselib.db.video.ShortTVPlayDao r6 = r5.Q()
            r0.label = r3
            java.lang.Object r6 = r6.j(r7, r0)
            if (r6 != r1) goto L5d
            return r1
        L5d:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.E(com.transsion.baselib.db.video.VideoDetailPlayBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(com.transsion.baselib.db.video.VideoDetailPlayBean r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteStreamRecord$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteStreamRecord$1 r0 = (com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteStreamRecord$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteStreamRecord$1 r0 = new com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteStreamRecord$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.L$0
            com.transsion.baselib.db.video.VideoDetailPlayBean r2 = (com.transsion.baselib.db.video.VideoDetailPlayBean) r2
            kotlin.ResultKt.b(r7)
            goto L69
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$0
            com.transsion.baselib.db.video.VideoDetailPlayBean r6 = (com.transsion.baselib.db.video.VideoDetailPlayBean) r6
            kotlin.ResultKt.b(r7)
            goto L5a
        L44:
            kotlin.ResultKt.b(r7)
            com.transsion.baselib.db.video.VideoDetailPlayDao r7 = r5.V()
            java.lang.String r2 = r6.getSubjectId()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.j(r2, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L63
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L63:
            java.util.Iterator r7 = r7.iterator()
            r2 = r6
            r6 = r7
        L69:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L86
            java.lang.Object r7 = r6.next()
            com.transsion.baselib.db.video.VideoDetailPlayBean r7 = (com.transsion.baselib.db.video.VideoDetailPlayBean) r7
            com.transsion.baselib.db.video.VideoDetailPlayDao r4 = r5.V()
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r4.h(r7, r0)
            if (r7 != r1) goto L69
            return r1
        L86:
            com.transsnet.downloader.viewmodel.a0 r6 = com.transsnet.downloader.viewmodel.a0.f60208a
            java.lang.String r7 = r2.getSubjectId()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "delete --- "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = " --- video recording --> success"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.t(r7)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.F(com.transsion.baselib.db.video.VideoDetailPlayBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(com.transsion.baselib.db.download.DownloadBean r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteVideoRecord$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteVideoRecord$1 r0 = (com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteVideoRecord$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteVideoRecord$1 r0 = new com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteVideoRecord$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7
            kotlin.ResultKt.b(r8)
            goto L54
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            r7.setRead(r3)
            r4 = 0
            r7.setLastPlayTimeStamp(r4)
            r7.setReadProgress(r4)
            com.transsnet.downloader.manager.DownloadEsHelper$a r8 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r8 = r8.a()
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.b0(r7, r0)
            if (r8 != r1) goto L54
            return r1
        L54:
            com.transsnet.downloader.viewmodel.a0 r8 = com.transsnet.downloader.viewmodel.a0.f60208a
            java.lang.String r7 = r7.getName()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "delete --- "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = " --- video recording --> success"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.t(r7)
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.G(com.transsion.baselib.db.download.DownloadBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final jj.a H() {
        return (jj.a) this.f60193g.getValue();
    }

    private final IAudioApi K() {
        return (IAudioApi) this.f60197k.getValue();
    }

    private final IFloatingApi L() {
        return (IFloatingApi) this.f60198l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00f2 -> B:12:0x00fc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0118 -> B:11:0x011b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(java.util.List r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.O(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTVPlayDao Q() {
        return (ShortTVPlayDao) this.f60194h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(java.util.List r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2
            if (r0 == 0) goto L13
            r0 = r9
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2 r0 = (com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2 r0 = new com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$2
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 != r5) goto L37
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r9)
            r6 = r9
            r9 = r8
            r8 = r0
            r0 = r6
            goto L5a
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.b(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            com.transsnet.downloader.manager.DownloadEsHelper$a r2 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r2 = r2.a()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r0 = com.transsnet.downloader.manager.DownloadEsHelper.O(r2, r4, r0, r5, r3)
            if (r0 != r1) goto L5a
            return r1
        L5a:
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L76
            java.util.Iterator r0 = r0.iterator()
        L62:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L76
            java.lang.Object r1 = r0.next()
            com.transsion.baselib.db.download.DownloadBean r1 = (com.transsion.baselib.db.download.DownloadBean) r1
            com.transsnet.downloader.bean.HistoricalPlayRecordBean r1 = r7.c(r1)
            r9.add(r1)
            goto L62
        L76:
            if (r8 == 0) goto L82
            r0 = r9
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r8 = r8.addAll(r0)
            kotlin.coroutines.jvm.internal.Boxing.a(r8)
        L82:
            r8 = 2
            java.util.List r8 = A(r7, r9, r4, r8, r3)
            androidx.lifecycle.b0 r9 = r7.T()
            r9.n(r8)
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.R(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UGCVideoDetailPlayDao U() {
        return (UGCVideoDetailPlayDao) this.f60196j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao V() {
        return (VideoDetailPlayDao) this.f60195i.getValue();
    }

    public static /* synthetic */ void X(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        historicalPlayRecordViewModel.W(z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Z(HistoricalPlayRecordBean historicalPlayRecordBean, Continuation continuation) {
        Object D;
        Object F;
        Object E;
        Object G;
        if (historicalPlayRecordBean.getUgcVideo() != null) {
            UGCVideoDetailPlayDao U = U();
            UGCVideoDetailPlayBean ugcVideo = historicalPlayRecordBean.getUgcVideo();
            Intrinsics.e(ugcVideo);
            Object j11 = U.j(ugcVideo.getUgcVideoId(), continuation);
            return j11 == IntrinsicsKt.f() ? j11 : Unit.f67184a;
        }
        int type = historicalPlayRecordBean.getType();
        if (type == 1) {
            AudioBean audio = historicalPlayRecordBean.getAudio();
            if (audio != null && (D = D(audio, continuation)) == IntrinsicsKt.f()) {
                return D;
            }
        } else if (type == 7) {
            VideoDetailPlayBean streamVideo = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo != null && (F = F(streamVideo, continuation)) == IntrinsicsKt.f()) {
                return F;
            }
        } else if (type != 8) {
            DownloadBean video = historicalPlayRecordBean.getVideo();
            if (video != null && (G = G(video, continuation)) == IntrinsicsKt.f()) {
                return G;
            }
        } else {
            VideoDetailPlayBean streamVideo2 = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo2 != null && (E = E(streamVideo2, continuation)) == IntrinsicsKt.f()) {
                return E;
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAudioApi a0() {
        return (IAudioApi) TheRouter.d(IAudioApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFloatingApi b0() {
        return (IFloatingApi) TheRouter.d(IFloatingApi.class, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r0.f() == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void d0(com.transsnet.downloader.bean.HistoricalPlayRecordBean r5, androidx.fragment.app.FragmentActivity r6) {
        /*
            r4 = this;
            com.transsion.baselib.db.audio.AudioBean r5 = r5.getAudio()
            if (r5 == 0) goto L49
            com.transsion.room.api.IAudioApi r0 = r4.K()
            r1 = 0
            if (r0 == 0) goto L12
            boolean r0 = r0.b(r5)
            goto L13
        L12:
            r0 = r1
        L13:
            if (r0 == 0) goto L30
            com.transsion.room.api.IAudioApi r0 = r4.K()
            if (r0 == 0) goto L23
            boolean r0 = r0.f()
            r2 = 1
            if (r0 != r2) goto L23
            goto L24
        L23:
            r2 = r1
        L24:
            if (r2 == 0) goto L30
            com.transsion.room.api.IAudioApi r5 = r4.K()
            if (r5 == 0) goto L2f
            r5.stop()
        L2f:
            return
        L30:
            com.transsion.room.api.IAudioApi r0 = r4.K()
            if (r0 == 0) goto L3b
            r2 = 2
            r3 = 0
            com.transsion.room.api.IAudioApi.a.a(r0, r5, r1, r2, r3)
        L3b:
            com.transsion.room.api.IFloatingApi r0 = r4.L()
            if (r0 == 0) goto L49
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r6)
            r0.a(r1, r5)
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.d0(com.transsnet.downloader.bean.HistoricalPlayRecordBean, androidx.fragment.app.FragmentActivity):void");
    }

    private final void e0(VideoDetailPlayBean videoDetailPlayBean, FragmentActivity fragmentActivity, String str) {
        Integer subjectType;
        String downloadFilePath = videoDetailPlayBean != null ? videoDetailPlayBean.getDownloadFilePath() : null;
        boolean o11 = a0.f60208a.o(downloadFilePath);
        if (downloadFilePath == null || downloadFilePath.length() == 0 || !o11) {
            if (fragmentActivity != null) {
                Navigator.x(TheRouter.c("/movie/detail").F("subject_type", (videoDetailPlayBean == null || (subjectType = videoDetailPlayBean.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()).K("id", videoDetailPlayBean != null ? videoDetailPlayBean.getSubjectId() : null).K("module_name", HistoricalPlayRecordViewModel.class.getSimpleName()), fragmentActivity, null, 2, null);
            }
        } else if (fragmentActivity != null) {
            DownloadManagerApi.f58521j.a().t0(fragmentActivity, videoDetailPlayBean.getId(), str);
        }
    }

    private final void f0(HistoricalPlayRecordBean historicalPlayRecordBean, FragmentActivity fragmentActivity, String str) {
        String subjectId;
        if (fragmentActivity != null) {
            Navigator F = TheRouter.c("/movie/detail").F("subject_type", SubjectType.MUSIC.getValue());
            VideoDetailPlayBean streamVideo = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo == null || (subjectId = streamVideo.getSubjectId()) == null) {
                DownloadBean video = historicalPlayRecordBean.getVideo();
                subjectId = video != null ? video.getSubjectId() : null;
            }
            Navigator.x(F.K("id", subjectId), fragmentActivity, null, 2, null);
        }
    }

    private final void g0(HistoricalPlayRecordBean historicalPlayRecordBean, FragmentActivity fragmentActivity, String str) {
        DownloadBean video = historicalPlayRecordBean.getVideo();
        if (video == null || fragmentActivity == null) {
            return;
        }
        if (video.isShotTV()) {
            Navigator.x(TheRouter.c(ls.a.f69157a.b()).K("id", video.getSubjectId()).F("ep", video.getEp()).K("ops", video.getOps()).G("ms", video.getReadProgress()), fragmentActivity, null, 2, null);
        } else {
            DownloadManagerApi.f58521j.a().s0(fragmentActivity, video, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y0 h0() {
        return j1.a(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao j0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 k0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideoDetailPlayDao l0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao m0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jj.a y() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).o1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List z(List list, boolean z10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16, 0.75f, true);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HistoricalPlayRecordBean historicalPlayRecordBean = (HistoricalPlayRecordBean) it.next();
            if (linkedHashMap.containsKey(historicalPlayRecordBean.getOriginalFormatTime())) {
                List list2 = (List) linkedHashMap.get(historicalPlayRecordBean.getOriginalFormatTime());
                if (list2 != null) {
                    list2.add(historicalPlayRecordBean);
                }
            } else {
                String originalFormatTime = historicalPlayRecordBean.getOriginalFormatTime();
                if (originalFormatTime == null) {
                    originalFormatTime = "";
                }
                linkedHashMap.put(originalFormatTime, CollectionsKt.q(historicalPlayRecordBean));
            }
        }
        ArrayList arrayList = new ArrayList();
        String str = "lastFormatTime";
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (z10 && !TextUtils.equals(((HistoricalPlayRecordBean) ((List) entry.getValue()).get(0)).getFormatTime(), str)) {
                str = ((HistoricalPlayRecordBean) ((List) entry.getValue()).get(0)).getFormatTime();
                arrayList.add(new HistoricalPlayRecordMultipleEntity(1, null, ((HistoricalPlayRecordBean) ((List) entry.getValue()).get(0)).getFormatTime(), null));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = ((Iterable) entry.getValue()).iterator();
            while (it2.hasNext()) {
                arrayList2.add(new HistoricalPlayRecordMultipleEntity(2, (HistoricalPlayRecordBean) it2.next(), ((HistoricalPlayRecordBean) ((List) entry.getValue()).get(0)).getFormatTime(), null));
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public final void B(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, Function0 callback) {
        Intrinsics.h(callback, "callback");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new HistoricalPlayRecordViewModel$delete$2(historicalPlayRecordMultipleEntity, this, callback, null), 3, null);
    }

    public final void C(Function0 callback) {
        Intrinsics.h(callback, "callback");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new HistoricalPlayRecordViewModel$deleteAll$2(this, callback, null), 3, null);
    }

    public final androidx.view.b0 I() {
        return this.f60188b;
    }

    public final androidx.view.b0 J() {
        return this.f60189c;
    }

    public final int M() {
        return this.f60200n;
    }

    public final void N() {
        kotlinx.coroutines.k.d(u0.a(this), kotlinx.coroutines.y0.b(), null, new HistoricalPlayRecordViewModel$getOutsideLocalFileList$1(this, null), 2, null);
    }

    public final y0 P() {
        return (y0) this.f60192f.getValue();
    }

    public final void S() {
        kotlinx.coroutines.k.d(u0.a(this), kotlinx.coroutines.y0.b(), null, new HistoricalPlayRecordViewModel$getTransferReceivedVideoDataList$1(this, null), 2, null);
    }

    public final androidx.view.b0 T() {
        return (androidx.view.b0) this.f60190d.getValue();
    }

    public final void W(boolean z10, boolean z11) {
        kotlinx.coroutines.k.d(u0.a(this), kotlinx.coroutines.y0.b(), null, new HistoricalPlayRecordViewModel$getVideoPlayHistoricalList$1(z11, this, z10, null), 2, null);
    }

    public final void Y() {
        kotlinx.coroutines.k.d(u0.a(this), kotlinx.coroutines.y0.b(), null, new HistoricalPlayRecordViewModel$loadVideoCover$1(this, null), 2, null);
    }

    public final void c0(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, FragmentActivity fragmentActivity, String str) {
        HistoricalPlayRecordBean historical;
        if (historicalPlayRecordMultipleEntity == null || historicalPlayRecordMultipleEntity.getType() == 1 || (historical = historicalPlayRecordMultipleEntity.getHistorical()) == null) {
            return;
        }
        int type = historical.getType();
        if (type == 1) {
            d0(historical, fragmentActivity);
            return;
        }
        if (type == 2 || type == 3 || type == 5) {
            g0(historical, fragmentActivity, str);
        } else if (type == 6) {
            f0(historical, fragmentActivity, str);
        } else {
            if (type != 7) {
                return;
            }
            e0(historical.getStreamVideo(), fragmentActivity, str);
        }
    }

    public final void i0(int i11) {
        this.f60200n = i11;
    }
}
