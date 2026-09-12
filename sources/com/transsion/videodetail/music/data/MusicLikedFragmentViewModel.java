package com.transsion.videodetail.music.data;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.music.bean.LikeListActionEnum;
import com.transsion.videodetail.music.bean.MusicLikedRemoteItemBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;

/* loaded from: classes7.dex */
public final class MusicLikedFragmentViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private String f57848a = "0";

    /* renamed from: b, reason: collision with root package name */
    private final List f57849b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f57850c = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.music.data.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            oj.a K;
            K = MusicLikedFragmentViewModel.K();
            return K;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f57851d = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.music.data.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            lj.c s11;
            s11 = MusicLikedFragmentViewModel.s();
            return s11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f57852e = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.music.data.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a J;
            J = MusicLikedFragmentViewModel.J();
            return J;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final b0 f57853f = new b0();

    /* renamed from: g, reason: collision with root package name */
    private final b0 f57854g = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public final oj.a A() {
        return (oj.a) this.f57850c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(MusicLikedRemoteItemBean musicLikedRemoteItemBean, Continuation continuation) {
        Object f11;
        return (musicLikedRemoteItemBean == null || (f11 = A().f(q(musicLikedRemoteItemBean), continuation)) != IntrinsicsKt.f()) ? Unit.f67184a : f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0090 -> B:11:0x0093). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$loadLocalData$1
            if (r0 == 0) goto L13
            r0 = r13
            com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$loadLocalData$1 r0 = (com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$loadLocalData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$loadLocalData$1 r0 = new com.transsion.videodetail.music.data.MusicLikedFragmentViewModel$loadLocalData$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r2 = r0.L$3
            com.transsion.baselib.db.music.MusicLikedDbBean r2 = (com.transsion.baselib.db.music.MusicLikedDbBean) r2
            java.lang.Object r4 = r0.L$2
            com.transsion.baselib.db.music.MusicLikedDbBean r4 = (com.transsion.baselib.db.music.MusicLikedDbBean) r4
            java.lang.Object r5 = r0.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.b(r13)
            r10 = r5
            r11 = r6
            r5 = r4
            goto L93
        L3f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L47:
            kotlin.ResultKt.b(r13)
            goto L5b
        L4b:
            kotlin.ResultKt.b(r13)
            oj.a r13 = r12.A()
            r0.label = r4
            java.lang.Object r13 = r13.c(r0)
            if (r13 != r1) goto L5b
            return r1
        L5b:
            java.util.List r13 = (java.util.List) r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
            r5 = r13
            r6 = r2
        L6a:
            boolean r13 = r5.hasNext()
            if (r13 == 0) goto Lb0
            java.lang.Object r13 = r5.next()
            r2 = r13
            com.transsion.baselib.db.music.MusicLikedDbBean r2 = (com.transsion.baselib.db.music.MusicLikedDbBean) r2
            lj.c r13 = r12.u()
            java.lang.String r4 = r2.getSubjectId()
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r13 = r13.E(r4, r0)
            if (r13 != r1) goto L90
            return r1
        L90:
            r10 = r5
            r11 = r6
            r5 = r2
        L93:
            com.transsion.baselib.db.download.DownloadBean r13 = (com.transsion.baselib.db.download.DownloadBean) r13
            if (r13 == 0) goto L9c
            java.lang.String r13 = r13.getPath()
            goto L9d
        L9c:
            r13 = 0
        L9d:
            r2.setPath(r13)
            com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity r13 = new com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r11.add(r13)
            r5 = r10
            r6 = r11
            goto L6a
        Lb0:
            androidx.lifecycle.b0 r13 = r12.f57854g
            r13.n(r6)
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.music.data.MusicLikedFragmentViewModel.H(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(2:3|(14:5|6|7|(1:(7:(1:(1:(2:13|14))(9:16|17|18|(1:20)|21|22|(1:24)|25|26))|28|21|22|(0)|25|26)(1:29))(3:62|63|(1:65))|30|(1:34)|35|(1:61)(1:39)|(4:41|(1:49)(1:45)|46|(1:48))(5:50|(2:53|51)|54|55|(4:57|(1:59)|18|(0))(1:60))|21|22|(0)|25|26))|68|6|7|(0)(0)|30|(2:32|34)|35|(1:37)|61|(0)(0)|21|22|(0)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0034, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016e, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r15 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r15));
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0147 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:17:0x0043, B:18:0x011c, B:21:0x0167, B:28:0x002f, B:29:0x0048, B:30:0x0084, B:32:0x008e, B:34:0x0094, B:35:0x009f, B:37:0x00a7, B:39:0x00ad, B:41:0x00bd, B:43:0x00c5, B:45:0x00cb, B:46:0x00d1, B:50:0x00e0, B:51:0x00f3, B:53:0x00f9, B:55:0x0107, B:57:0x010d, B:60:0x0148, B:63:0x004f), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:17:0x0043, B:18:0x011c, B:21:0x0167, B:28:0x002f, B:29:0x0048, B:30:0x0084, B:32:0x008e, B:34:0x0094, B:35:0x009f, B:37:0x00a7, B:39:0x00ad, B:41:0x00bd, B:43:0x00c5, B:45:0x00cb, B:46:0x00d1, B:50:0x00e0, B:51:0x00f3, B:53:0x00f9, B:55:0x0107, B:57:0x010d, B:60:0x0148, B:63:0x004f), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I(kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.music.data.MusicLikedFragmentViewModel.I(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a J() {
        return (a) zg.c.f79537e.a().h(a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final oj.a K() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).t1();
    }

    private final MusicLikedDbBean q(MusicLikedRemoteItemBean musicLikedRemoteItemBean) {
        String subjectId = musicLikedRemoteItemBean.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        String str = subjectId;
        String title = musicLikedRemoteItemBean.getTitle();
        Cover cover = musicLikedRemoteItemBean.getCover();
        String url = cover != null ? cover.getUrl() : null;
        String countryName = musicLikedRemoteItemBean.getCountryName();
        String genre = musicLikedRemoteItemBean.getGenre();
        String releaseDate = musicLikedRemoteItemBean.getReleaseDate();
        Integer durationSeconds = musicLikedRemoteItemBean.getDurationSeconds();
        int intValue = durationSeconds != null ? durationSeconds.intValue() : 0;
        String singerName = musicLikedRemoteItemBean.getSingerName();
        String singerAvatar = musicLikedRemoteItemBean.getSingerAvatar();
        Long likeTime = musicLikedRemoteItemBean.getLikeTime();
        return new MusicLikedDbBean(str, title, url, countryName, genre, releaseDate, intValue, singerName, singerAvatar, "", likeTime != null ? likeTime.longValue() : System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(MusicLikedRemoteItemBean musicLikedRemoteItemBean, Continuation continuation) {
        if (musicLikedRemoteItemBean != null) {
            oj.a A = A();
            String subjectId = musicLikedRemoteItemBean.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            Object d11 = A.d(subjectId, continuation);
            if (d11 == IntrinsicsKt.f()) {
                return d11;
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lj.c s() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t() {
        String simpleName = MusicLikedFragmentViewModel.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final lj.c u() {
        return (lj.c) this.f57851d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        k.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$getLocalMusicLiked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a z() {
        return (a) this.f57852e.getValue();
    }

    public final void B(String str, Function1 callback) {
        Intrinsics.h(callback, "callback");
        k.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$getMusicLikedEntity$1(this, str, callback, null), 3, null);
    }

    public final LiveData C() {
        return this.f57854g;
    }

    public final void E(String str, Function1 callback) {
        Intrinsics.h(callback, "callback");
        k.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$isDownload$1(this, str, callback, null), 3, null);
    }

    public final void F(String str, Function1 callback) {
        Intrinsics.h(callback, "callback");
        k.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$isLiked$1(this, str, callback, null), 3, null);
    }

    public final void G(String str, LikeListActionEnum action) {
        Intrinsics.h(action, "action");
        k.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$likedMusic$1(str, action, this, null), 3, null);
    }

    public final void p(Subject subject) {
        Intrinsics.h(subject, "subject");
        k.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$clickLikedMusic$1(subject, this, null), 3, null);
    }

    public final void v(String str, Function1 callback) {
        Intrinsics.h(callback, "callback");
        k.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$getDownloadEntity$1(this, str, callback, null), 3, null);
    }

    public final LiveData w() {
        return this.f57853f;
    }

    public final void y(String from) {
        Intrinsics.h(from, "from");
        k.d(u0.a(this), null, null, new MusicLikedFragmentViewModel$getMusicLiked$1(this, from, null), 3, null);
    }
}
