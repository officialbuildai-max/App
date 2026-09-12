package com.transsion.usercenter.setting.labelsfeedback.sender;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import bh.b;
import com.cloud.config.utils.CommonUtils;
import com.google.android.material.timepicker.TimeModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.upload.log.UploadLoggerManager;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.RequestBody;
import zg.c;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\bH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ:\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/transsion/usercenter/setting/labelsfeedback/sender/FbSenderWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "", "imagePath", "Lkotlin/Pair;", "s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imageUrl", "logId", "Lcom/transsion/usercenter/setting/labelsfeedback/model/FbDataModel;", "model", "tempBucket", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/usercenter/setting/feedback/bean/FeedbackEntity;", CampaignEx.JSON_KEY_AD_R, "(Ljava/lang/String;Ljava/lang/String;Lcom/transsion/usercenter/setting/labelsfeedback/model/FbDataModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/s$a;", "n", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class FbSenderWorker extends CoroutineWorker {

    /* loaded from: classes7.dex */
    public static final class a implements cw.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f57588a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation f57589b;

        a(Continuation continuation) {
            this.f57589b = continuation;
        }

        @Override // cw.a
        public void a(String localFilePath, long j11, long j12) {
            Intrinsics.h(localFilePath, "localFilePath");
        }

        @Override // cw.a
        public void b(String localFilePath, String url, String bucket) {
            Intrinsics.h(localFilePath, "localFilePath");
            Intrinsics.h(url, "url");
            Intrinsics.h(bucket, "bucket");
            if (this.f57588a) {
                return;
            }
            Continuation continuation = this.f57589b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m1185constructorimpl(new Pair(url, bucket)));
            this.f57588a = true;
        }

        @Override // cw.a
        public void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType) {
            if (this.f57588a) {
                return;
            }
            Continuation continuation = this.f57589b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m1185constructorimpl(ResultKt.a(new Error("unable to upload log"))));
            this.f57588a = true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements cw.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f57590a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation f57591b;

        b(Continuation continuation) {
            this.f57591b = continuation;
        }

        @Override // cw.a
        public void a(String uploadKey, long j11, long j12) {
            Intrinsics.h(uploadKey, "uploadKey");
        }

        @Override // cw.a
        public void b(String uploadKey, String url, String bucket) {
            Intrinsics.h(uploadKey, "uploadKey");
            Intrinsics.h(url, "url");
            Intrinsics.h(bucket, "bucket");
            if (this.f57590a) {
                return;
            }
            this.f57591b.resumeWith(Result.m1185constructorimpl(uploadKey));
            this.f57590a = true;
        }

        @Override // cw.a
        public void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType) {
            if (this.f57590a) {
                return;
            }
            Continuation continuation = this.f57591b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m1185constructorimpl(ResultKt.a(new Error("unable to upload log"))));
            this.f57590a = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FbSenderWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.h(appContext, "appContext");
        Intrinsics.h(workerParams, "workerParams");
    }

    private final Object r(String str, String str2, FbDataModel fbDataModel, String str3, Continuation continuation) {
        UserInfo i11;
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        String userId = (iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId();
        JsonObject jsonObject = new JsonObject();
        if (userId == null) {
            userId = "0";
        }
        jsonObject.addProperty(CommonUtils.PARAM_UID, userId);
        jsonObject.addProperty("content", fbDataModel.getContent());
        if (str != null) {
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(str);
            jsonObject.add("imageUrl", jsonArray);
        }
        jsonObject.addProperty("email", "");
        String whole = fbDataModel.getContact().getWhole();
        if (whole != null) {
            jsonObject.addProperty("whatsApp", whole);
        }
        jsonObject.addProperty("pageName", fbDataModel.getPageName());
        String ugcVideoId = fbDataModel.getUgcVideoId();
        if (ugcVideoId != null) {
            jsonObject.addProperty("ugcVideoId", ugcVideoId);
        }
        String subjectId = fbDataModel.getSubjectId();
        if (subjectId != null) {
            jsonObject.addProperty("subjectId", subjectId);
        }
        FbTvData tv2 = fbDataModel.getTv();
        if (tv2 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Boxing.d(tv2.getSeason())}, 1));
            Intrinsics.g(format, "format(...)");
            String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Boxing.d(tv2.getEpisode())}, 1));
            Intrinsics.g(format2, "format(...)");
            jsonObject.addProperty("season", "S" + format + "  E" + format2);
        }
        jsonObject.addProperty("logId", str2);
        Integer selectedId = fbDataModel.getSelectedId();
        jsonObject.addProperty("label", Boxing.d(selectedId != null ? selectedId.intValue() : -1));
        jsonObject.addProperty("tempBucket", str3);
        b.a aVar = bh.b.f16553a;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        RequestBody a11 = aVar.a(jsonElement);
        if (a11 != null) {
            return ((yw.a) c.f79537e.a().h(yw.a.class)).c(vg.a.f77447a.a(), a11, continuation);
        }
        throw new Error("can not find feedback body");
    }

    private final Object s(String str, Continuation continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(continuation));
        cw.c.f61054a.f(str, UploadFileType.OBJECT_NAME_IMAGE, true, new a(safeContinuation));
        Object a11 = safeContinuation.a();
        if (a11 == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return a11;
    }

    private final Object t(Continuation continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(continuation));
        UploadLoggerManager.f56759a.k(new b(safeContinuation));
        Object a11 = safeContinuation.a();
        if (a11 == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return a11;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|(1:(1:(1:(1:(5:14|15|(2:19|20)|23|24)(2:25|26))(8:27|28|29|(1:31)|15|(3:17|19|20)|23|24))(5:32|33|34|35|(1:37)(7:38|29|(0)|15|(0)|23|24)))(3:39|40|41))(2:46|(2:48|49)(2:50|(2:52|(1:54)(1:55))(3:56|35|(0)(0))))|42|(1:44)(4:45|34|35|(0)(0))))|59|6|7|8|(0)(0)|42|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0038, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0142, code lost:
    
        r15.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0132 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:14:0x0033, B:15:0x0128, B:17:0x0132, B:19:0x0138, B:28:0x004f, B:29:0x010a, B:33:0x0064, B:34:0x00e8, B:35:0x00f6, B:40:0x007d, B:42:0x00c9, B:50:0x00a3, B:52:0x00b3), top: B:8:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Type inference failed for: r15v12, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v18, types: [T, java.lang.Object] */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.setting.labelsfeedback.sender.FbSenderWorker.n(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
