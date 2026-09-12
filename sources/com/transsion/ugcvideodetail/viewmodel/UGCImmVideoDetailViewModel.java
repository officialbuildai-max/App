package com.transsion.ugcvideodetail.viewmodel;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.u0;
import com.blankj.utilcode.util.y;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class UGCImmVideoDetailViewModel extends UGCVideoDetailViewModel {

    /* renamed from: d0, reason: collision with root package name */
    public static final a f56532d0 = new a(null);
    private String I;
    private String J;
    private String M;
    private int N;
    private int O;
    private String P;
    private final b0 W;
    private final LiveData X;
    private final b0 Y;
    private final LiveData Z;

    /* renamed from: a0, reason: collision with root package name */
    private final b0 f56533a0;

    /* renamed from: b0, reason: collision with root package name */
    private final b0 f56534b0;

    /* renamed from: c0, reason: collision with root package name */
    private final LiveData f56535c0;
    private final Lazy K = LazyKt.b(new Function0() { // from class: com.transsion.ugcvideodetail.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            rv.a x10;
            x10 = UGCImmVideoDetailViewModel.x();
            return x10;
        }
    });
    private final int L = y.e();
    private boolean Q = true;
    private boolean R = true;
    private float S = 1.0f;
    private final b0 T = new b0();
    private final b0 U = new b0();
    private final b0 V = new b0();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UGCImmVideoDetailViewModel() {
        b0 b0Var = new b0();
        this.W = b0Var;
        this.X = b0Var;
        b0 b0Var2 = new b0();
        this.Y = b0Var2;
        this.Z = b0Var2;
        this.f56533a0 = new b0();
        b0 b0Var3 = new b0();
        this.f56534b0 = b0Var3;
        this.f56535c0 = b0Var3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rv.a F() {
        return (rv.a) this.K.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(boolean z10, UGCVideoList uGCVideoList, int i11, boolean z11, Pager pager) {
        k.d(u0.a(this), null, null, new UGCImmVideoDetailViewModel$fetchPlayInfoList$1(this, uGCVideoList, i11, z10, z11, pager, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void G0(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, boolean z10, UGCVideoList uGCVideoList, int i11, boolean z11, Pager pager, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            z11 = true;
        }
        boolean z12 = z11;
        if ((i12 & 16) != 0) {
            pager = null;
        }
        uGCImmVideoDetailViewModel.F0(z10, uGCVideoList, i13, z12, pager);
    }

    public static /* synthetic */ void Q0(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, int i11, int i12, boolean z10, boolean z11, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z11 = false;
        }
        uGCImmVideoDetailViewModel.P0(str, i11, i12, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x014d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a1(com.transsion.ugcvideodetail.api.bean.UGCVideo r11, com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo r12, kotlin.coroutines.Continuation r13) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel.a1(com.transsion.ugcvideodetail.api.bean.UGCVideo, com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rv.a x() {
        return (rv.a) zg.c.f79537e.a().h(rv.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #0 {all -> 0x003b, blocks: (B:13:0x0037, B:14:0x007c, B:17:0x0088, B:18:0x008e, B:21:0x0093, B:23:0x0099, B:26:0x00a0, B:28:0x00a7, B:30:0x00af, B:34:0x00be, B:37:0x00c7, B:40:0x00eb, B:43:0x00f8, B:48:0x0105, B:55:0x004a, B:56:0x0062, B:61:0x0051), top: B:8:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(java.lang.String r23, kotlin.coroutines.Continuation r24) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel.y(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void E0(List list, boolean z10) {
        String ugcVideoId;
        String ugcVideoId2;
        String ugcVideoId3;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Iterable<UGCImmVideo> iterable = (List) this.f56533a0.f();
        if (iterable == null) {
            iterable = new ArrayList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (UGCImmVideo uGCImmVideo : iterable) {
            UGCVideo ugcVideo = uGCImmVideo.getUgcVideo();
            if (ugcVideo != null && (ugcVideoId3 = ugcVideo.getUgcVideoId()) != null) {
                linkedHashMap.put(ugcVideoId3, uGCImmVideo);
            }
        }
        if (z10) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                UGCImmVideo uGCImmVideo2 = (UGCImmVideo) it.next();
                UGCVideo ugcVideo2 = uGCImmVideo2.getUgcVideo();
                if (ugcVideo2 != null && (ugcVideoId2 = ugcVideo2.getUgcVideoId()) != null) {
                    linkedHashMap.put(ugcVideoId2, uGCImmVideo2);
                }
            }
        } else {
            for (UGCImmVideo uGCImmVideo3 : CollectionsKt.U(list)) {
                UGCVideo ugcVideo3 = uGCImmVideo3.getUgcVideo();
                if (ugcVideo3 != null && (ugcVideoId = ugcVideo3.getUgcVideoId()) != null && !linkedHashMap.containsKey(ugcVideoId)) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put(ugcVideoId, uGCImmVideo3);
                    linkedHashMap2.putAll(linkedHashMap);
                    linkedHashMap.clear();
                    linkedHashMap.putAll(linkedHashMap2);
                }
            }
        }
        b0 b0Var = this.f56533a0;
        Collection values = linkedHashMap.values();
        Intrinsics.g(values, "<get-values>(...)");
        b0Var.q(CollectionsKt.U0(values));
    }

    public final b0 H0() {
        return this.f56533a0;
    }

    public final LiveData I0() {
        return this.f56535c0;
    }

    public final void J0(String ugcVideoId, String str) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        a.C0856a.r(lg.a.f68962a, "UGCImmVideoDetailViewModel", new String[]{"getFirstVideoDetail--getFirstVideoDetail id:" + ugcVideoId + ",collectionId:" + str}, false, 4, null);
        k.d(u0.a(this), null, null, new UGCImmVideoDetailViewModel$getFirstVideoDetail$1(this, ugcVideoId, str, null), 3, null);
    }

    public final void K0(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        a.C0856a.r(lg.a.f68962a, "UGCImmVideoDetailViewModel", new String[]{"getFirstVideoDetailBySubject id:" + subjectId}, false, 4, null);
        k.d(u0.a(this), null, null, new UGCImmVideoDetailViewModel$getFirstVideoDetailBySubject$1(this, subjectId, null), 3, null);
    }

    public final b0 L0() {
        return this.U;
    }

    public final b0 M0() {
        return this.V;
    }

    public final LiveData N0() {
        return this.X;
    }

    public final b0 O0() {
        return this.T;
    }

    public final void P0(String collectionId, int i11, int i12, boolean z10, boolean z11) {
        Intrinsics.h(collectionId, "collectionId");
        k.d(u0.a(this), null, null, new UGCImmVideoDetailViewModel$getImmVideoList$1(this, collectionId, i11, i12, z10, z11, null), 3, null);
    }

    public final LiveData R0() {
        return this.Z;
    }

    public final void S0(boolean z10, String str) {
        k.d(u0.a(this), null, null, new UGCImmVideoDetailViewModel$getImmVideoRecommentList$1(z10, this, str, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T0(String ugcVideoId, String str) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        a.C0856a.r(lg.a.f68962a, "UGCImmVideoDetailViewModel", new String[]{"getLocalDataWithoutNet id:" + ugcVideoId + ",collectionId:" + str}, false, 4, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = ugcVideoId;
        k.d(u0.a(this), null, null, new UGCImmVideoDetailViewModel$getLocalDataWithoutNet$1(str, this, ugcVideoId, objectRef, null), 3, null);
    }

    public final boolean U0() {
        return this.Q;
    }

    public final String V0() {
        return this.J;
    }

    public final String W0() {
        return this.P;
    }

    public final float X0() {
        return this.S;
    }

    public final boolean Y0() {
        return this.R;
    }

    public final void Z0(String ugcVideoId, boolean z10) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        k.d(u0.a(this), null, null, new UGCImmVideoDetailViewModel$loadImmHistory$1(this, ugcVideoId, z10, null), 3, null);
    }

    public final void b1(boolean z10) {
        this.R = z10;
    }

    public final void c1(boolean z10) {
        this.Q = z10;
    }

    public final void d1(String str) {
        this.P = str;
    }

    public final void e1(float f11) {
        this.S = f11;
    }

    public final void f1(UGCImmVideo uGCImmVideo, long j11, long j12) {
        k.d(o0.a(y0.b()), null, null, new UGCImmVideoDetailViewModel$updateHistory$1(uGCImmVideo, j12, j11, this, null), 3, null);
    }
}
