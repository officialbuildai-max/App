package com.transsion.postdetail.shorttv_pugc.factory;

import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.manager.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lj.m0;

/* loaded from: classes6.dex */
public final class PugcShortTvDownloadProvider implements st.c {

    /* renamed from: b, reason: collision with root package name */
    private st.j f49352b;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f49351a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv_pugc.factory.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g h11;
            h11 = PugcShortTvDownloadProvider.h();
            return h11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final m0 f49353c = new a();

    /* loaded from: classes6.dex */
    public static final class a extends lj.a {
        a() {
        }

        @Override // lj.a, lj.m0
        public void e(DownloadBean bean, String str) {
            Intrinsics.h(bean, "bean");
            st.j jVar = PugcShortTvDownloadProvider.this.f49352b;
            if (jVar != null) {
                String ugcVideoId = bean.getUgcVideoId();
                Integer ugcVideoPosition = bean.getUgcVideoPosition();
                jVar.a(ugcVideoId, ugcVideoPosition != null ? ugcVideoPosition.intValue() : bean.getEp());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g h() {
        return p.f59623a.a(Utils.a());
    }

    private final com.transsnet.downloader.manager.g i() {
        return (com.transsnet.downloader.manager.g) this.f49351a.getValue();
    }

    private final ShorttvModel.UGCVideo j(DownloadBean downloadBean) {
        ShorttvModel.UGCVideo uGCVideo = new ShorttvModel.UGCVideo(downloadBean.videoUGCId(), downloadBean.getTitleName(), null, null, new Cover(null, null, null, downloadBean.getUrl(), null, downloadBean.getThumbnail(), null, null, null, 471, null), null, downloadBean.getDuration(), null, null, null, downloadBean.getUgcVideoType(), null, new ShorttvModel.UGCVideoCreator(null, null, null, null, 15, null), new ShorttvModel.UGCVideoInteractiveInfo(null, null, null, null, null, null, null, 127, null), new ShorttvModel.UGCVideoCollection(downloadBean.getUgcVideoCollectionId(), null, Integer.valueOf(downloadBean.videoUGCPosition()), null, 10, null), downloadBean.getOps(), null, null, null, null, 0, false, null, false, 16714668, null);
        uGCVideo.setPlayUrl(downloadBean.getPath());
        return uGCVideo;
    }

    @Override // st.c
    public void a(FragmentActivity activity, String collectionId, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(collectionId, "collectionId");
        DownloadManagerApi.f58521j.a().f0(activity, (r27 & 2) != 0 ? null : collectionId, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? null : str, (r27 & 16) != 0 ? null : UGCVideoType.SHORT_TV.getValue(), (r27 & 32) != 0 ? null : str3, (r27 & 64) != 0 ? null : str4, (r27 & 128) != 0 ? null : str5, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? false : false, (r27 & 4096) == 0 ? null : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // st.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$fetchDownloadList$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$fetchDownloadList$1 r0 = (com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$fetchDownloadList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$fetchDownloadList$1 r0 = new com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$fetchDownloadList$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.ResultKt.b(r7)
            goto L47
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.b(r7)
            if (r6 != 0) goto L38
            return r3
        L38:
            com.transsnet.downloader.manager.DownloadEsHelper$a r7 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r7 = r7.a()
            r0.label = r4
            java.lang.Object r7 = r7.P(r6, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L90
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r7 = r7.iterator()
        L56:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L6d
            java.lang.Object r0 = r7.next()
            r1 = r0
            com.transsion.baselib.db.download.DownloadBean r1 = (com.transsion.baselib.db.download.DownloadBean) r1
            boolean r1 = r1.isCompleted()
            if (r1 == 0) goto L56
            r6.add(r0)
            goto L56
        L6d:
            java.util.ArrayList r3 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.v(r6, r7)
            r3.<init>(r7)
            java.util.Iterator r6 = r6.iterator()
        L7c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L90
            java.lang.Object r7 = r6.next()
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7
            com.transsion.shorttv_pugc.ShorttvModel$UGCVideo r7 = r5.j(r7)
            r3.add(r7)
            goto L7c
        L90:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider.b(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // st.c
    public void c() {
        i().x(this.f49353c);
        this.f49352b = null;
    }

    @Override // st.c
    public void d(st.j listener) {
        Intrinsics.h(listener, "listener");
        this.f49352b = listener;
        i().e(this.f49353c);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // st.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$getDownloadUGCVideo$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$getDownloadUGCVideo$1 r0 = (com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$getDownloadUGCVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$getDownloadUGCVideo$1 r0 = new com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider$getDownloadUGCVideo$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.ResultKt.b(r7)
            goto L47
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.b(r7)
            if (r6 != 0) goto L38
            return r3
        L38:
            com.transsnet.downloader.manager.DownloadEsHelper$a r7 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r7 = r7.a()
            r0.label = r4
            java.lang.Object r7 = r7.R(r6, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            com.transsion.baselib.db.download.DownloadBean r7 = (com.transsion.baselib.db.download.DownloadBean) r7
            if (r7 == 0) goto L4f
            com.transsion.shorttv_pugc.ShorttvModel$UGCVideo r3 = r5.j(r7)
        L4f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider.e(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
