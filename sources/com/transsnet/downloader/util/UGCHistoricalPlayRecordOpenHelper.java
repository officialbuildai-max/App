package com.transsnet.downloader.util;

import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class UGCHistoricalPlayRecordOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final UGCHistoricalPlayRecordOpenHelper f60029a = new UGCHistoricalPlayRecordOpenHelper();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f60030a;

        /* renamed from: b, reason: collision with root package name */
        private final Integer f60031b;

        /* renamed from: c, reason: collision with root package name */
        private final String f60032c;

        /* renamed from: d, reason: collision with root package name */
        private final String f60033d;

        /* renamed from: e, reason: collision with root package name */
        private final String f60034e;

        /* renamed from: f, reason: collision with root package name */
        private final String f60035f;

        /* renamed from: g, reason: collision with root package name */
        private final String f60036g;

        /* renamed from: h, reason: collision with root package name */
        private final String f60037h;

        public a(String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f60030a = str;
            this.f60031b = num;
            this.f60032c = str2;
            this.f60033d = str3;
            this.f60034e = str4;
            this.f60035f = str5;
            this.f60036g = str6;
            this.f60037h = str7;
        }

        public final String a() {
            return this.f60030a;
        }

        public final Integer b() {
            return this.f60031b;
        }

        public final String c() {
            return this.f60032c;
        }

        public final String d() {
            return this.f60033d;
        }

        public final String e() {
            return this.f60034e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f60030a, aVar.f60030a) && Intrinsics.c(this.f60031b, aVar.f60031b) && Intrinsics.c(this.f60032c, aVar.f60032c) && Intrinsics.c(this.f60033d, aVar.f60033d) && Intrinsics.c(this.f60034e, aVar.f60034e) && Intrinsics.c(this.f60035f, aVar.f60035f) && Intrinsics.c(this.f60036g, aVar.f60036g) && Intrinsics.c(this.f60037h, aVar.f60037h);
        }

        public final String f() {
            return this.f60035f;
        }

        public final String g() {
            return this.f60036g;
        }

        public final String h() {
            return this.f60037h;
        }

        public int hashCode() {
            String str = this.f60030a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.f60031b;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.f60032c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f60033d;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f60034e;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f60035f;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f60036g;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.f60037h;
            return hashCode7 + (str7 != null ? str7.hashCode() : 0);
        }

        public String toString() {
            return "VideoParams(subjectId=" + this.f60030a + ", subjectType=" + this.f60031b + ", queryVideoId=" + this.f60032c + ", ugcVideoId=" + this.f60033d + ", collectionId=" + this.f60034e + ", ugcVideoType=" + this.f60035f + ", ops=" + this.f60036g + ", videoStyle=" + this.f60037h + ")";
        }
    }

    private UGCHistoricalPlayRecordOpenHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0229 A[PHI: r9
      0x0229: PHI (r9v22 java.lang.Object) = (r9v15 java.lang.Object), (r9v1 java.lang.Object) binds: [B:33:0x0226, B:13:0x0043] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0228 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.String r33, java.lang.Integer r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, kotlin.coroutines.Continuation r42) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.util.UGCHistoricalPlayRecordOpenHelper.f(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str, String str2, String str3, DownloadBean downloadBean) {
        ak.k.p(TheRouter.c("/ugc_video/local_detail").K("id", str).K("resource_id", downloadBean.getResourceId()).K("collection_id", str2).K("ops", str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String str, String str2, String str3, String str4, String str5, String str6) {
        ak.k.p(TheRouter.c("/ugc_video/detail").K("id", str2).K("subject_id", str).K("collection_id", str3).K("ugcCategory", str5).K("videoStyle", str6).K("ops", str4));
    }

    public final Object d(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, VideoDetailPlayBean videoDetailPlayBean, String str, Continuation continuation) {
        Object g11 = kotlinx.coroutines.i.g(y0.b(), new UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$4(uGCVideoDetailPlayBean, videoDetailPlayBean, str, null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }

    public final Object e(Object obj, String str, Continuation continuation) {
        Object g11 = kotlinx.coroutines.i.g(y0.b(), new UGCHistoricalPlayRecordOpenHelper$gotoUGCVideoDetail$2(obj, str, null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }
}
