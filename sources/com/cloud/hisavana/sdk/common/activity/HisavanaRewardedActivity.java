package com.cloud.hisavana.sdk.common.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.hisavana.sdk.C1016p;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.P;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.Z;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.AdDisclaimerView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.b2;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.common.bean.RewardedState;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.common.bean.VideoMask;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.util.HSChronometer;
import com.cloud.hisavana.sdk.common.util.i0;
import com.cloud.hisavana.sdk.common.util.v;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.common.widget.video.RewardedVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.f4;
import com.cloud.hisavana.sdk.g4;
import com.cloud.hisavana.sdk.m0;
import com.cloud.hisavana.sdk.o0;
import com.cloud.hisavana.sdk.t2;
import com.cloud.hisavana.sdk.u1;
import com.cloud.hisavana.sdk.v2;
import com.cloud.hisavana.sdk.x1;
import com.cloud.hisavana.sdk.x3;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import e7.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0003TQYB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020!H\u0002¢\u0006\u0004\b&\u0010$J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0004J'\u0010-\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001dH\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0004\b0\u0010\u0004J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u00103J\u0019\u00106\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0004\b6\u00107J!\u0010;\u001a\u00020\u00052\u0006\u00108\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\rH\u0002¢\u0006\u0004\b>\u00103J\u0017\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001dH\u0002¢\u0006\u0004\b@\u0010 J!\u0010C\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001d2\b\u0010B\u001a\u0004\u0018\u00010AH\u0002¢\u0006\u0004\bC\u0010DJ\u0019\u0010G\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010EH\u0014¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020\u00052\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0005H\u0014¢\u0006\u0004\bM\u0010\u0004J\u000f\u0010N\u001a\u00020\u0005H\u0014¢\u0006\u0004\bN\u0010\u0004J\u000f\u0010O\u001a\u00020\u0005H\u0017¢\u0006\u0004\bO\u0010\u0004J\u000f\u0010P\u001a\u00020\u0005H\u0014¢\u0006\u0004\bP\u0010\u0004J!\u0010Q\u001a\u00020\u00052\u0006\u00108\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\bQ\u0010<J\u0017\u0010T\u001a\u00020\u00052\u0006\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bT\u0010UJ\u0011\u0010W\u001a\u0004\u0018\u00010VH\u0016¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\rH\u0016¢\u0006\u0004\bY\u0010\u000fJ\u0017\u0010T\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\rH\u0016¢\u0006\u0004\bT\u00103J\u000f\u0010[\u001a\u00020\u0005H\u0016¢\u0006\u0004\b[\u0010\u0004J\u000f\u0010T\u001a\u00020\u0005H\u0016¢\u0006\u0004\bT\u0010\u0004J\u000f\u0010\\\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\\\u0010\u0004J\u0019\u0010T\u001a\u00020\u00052\b\u0010]\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\bT\u0010^J\u000f\u0010Q\u001a\u00020\u0005H\u0016¢\u0006\u0004\bQ\u0010\u0004R\u0014\u0010`\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\bT\u0010_R\u0014\u0010b\u001a\u00020R8\u0002X\u0082D¢\u0006\u0006\n\u0004\bQ\u0010aR\u0016\u0010d\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010eR\u0016\u0010g\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010_R\u0016\u0010h\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010cR\u0016\u0010j\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010aR\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010xR\u0018\u0010{\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010rR\u0018\u0010}\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010rR\u0018\u0010\u007f\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010rR\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b6\u0010\u0096\u0001R\u0018\u0010\u009a\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001f\u0010\u0099\u0001R\u0018\u0010\u009b\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bC\u0010\u0099\u0001R\u0017\u0010\u009c\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010cR\u0018\u0010\u009e\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010cR\u001a\u0010¢\u0001\u001a\u00030\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0017\u0010£\u0001\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010aR,\u0010«\u0001\u001a\u0005\u0018\u00010¤\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R,\u0010³\u0001\u001a\u0005\u0018\u00010¬\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R\u0018\u0010µ\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b´\u0001\u0010@R\u0017\u0010¶\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010@R\u0017\u0010·\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010@R\u0017\u0010¸\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010@¨\u0006¹\u0001"}, d2 = {"Lcom/cloud/hisavana/sdk/common/activity/HisavanaRewardedActivity;", "Landroid/app/Activity;", "Lcom/cloud/hisavana/sdk/g4;", "<init>", "()V", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "Y", "S", "U", "n0", "g0", "p0", "", "q0", "()Z", "c0", "i0", "j0", "t0", "l0", "", "volume", CampaignEx.JSON_KEY_AD_K, "(F)V", "s0", "a0", "r0", "e0", "", "videoUrl", "w", "(Ljava/lang/String;)V", "", "duration", "B", "(J)V", "remainingDuration", "l", "h", "w0", "i", CampaignEx.JSON_KEY_TITLE, "message", "buttonText", "y", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "u0", "v0", "isShowToast", "L", "(Z)V", "Lcom/cloud/hisavana/sdk/common/constant/TaErrorCode;", "adErrorCode", "v", "(Lcom/cloud/hisavana/sdk/common/constant/TaErrorCode;)V", "isClose", "Lcom/cloud/hisavana/sdk/common/tracking/DownUpPointBean;", "downUpPointBean", "H", "(ZLcom/cloud/hisavana/sdk/common/tracking/DownUpPointBean;)V", "isSentEvent", "G", NotificationCompat.CATEGORY_EVENT, "F", "", "params", "x", "(Ljava/lang/String;Ljava/lang/Object;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onResume", "onPause", "onBackPressed", "onDestroy", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "psClickType", "a", "(I)V", "Lcom/cloud/hisavana/sdk/data/bean/response/AdsDTO;", "f", "()Lcom/cloud/hisavana/sdk/data/bean/response/AdsDTO;", "c", NotificationCompat.CATEGORY_STATUS, "d", "e", "pointBean", "(Lcom/cloud/hisavana/sdk/common/tracking/DownUpPointBean;)V", "Ljava/lang/String;", "tag", "I", "defaultDuration", "J", "rewardDuration", "Lcom/cloud/hisavana/sdk/data/bean/response/AdsDTO;", "adBean", RequestParameters.PREFIX, "observerId", be.g.f16474b, "adMediaType", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "adMainLayout", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "adContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "adVolume", "Lcom/cloud/hisavana/sdk/common/util/HSChronometer;", "Lcom/cloud/hisavana/sdk/common/util/HSChronometer;", "adChronometer", "Lcom/cloud/hisavana/sdk/common/widget/video/RewardedVideoView;", "Lcom/cloud/hisavana/sdk/common/widget/video/RewardedVideoView;", "adVideoView", "m", "adImageView", "n", "adIcon", "o", "adChoicesView", "Lcom/cloud/hisavana/sdk/api/view/AdBadgeView;", TtmlNode.TAG_P, "Lcom/cloud/hisavana/sdk/api/view/AdBadgeView;", "adBadgeView", "Lcom/cloud/hisavana/sdk/api/view/AdCloseView;", CampaignEx.JSON_KEY_AD_Q, "Lcom/cloud/hisavana/sdk/api/view/AdCloseView;", "adCloseView", "Lcom/cloud/hisavana/sdk/api/view/StoreMarkView;", CampaignEx.JSON_KEY_AD_R, "Lcom/cloud/hisavana/sdk/api/view/StoreMarkView;", "storeMarkView", "Lcom/cloud/hisavana/sdk/api/view/AdDisclaimerView;", "s", "Lcom/cloud/hisavana/sdk/api/view/AdDisclaimerView;", "adDisclaimerView", "Lcom/cloud/hisavana/sdk/common/widget/InteractiveWebView;", "t", "Lcom/cloud/hisavana/sdk/common/widget/InteractiveWebView;", "interactiveWebView", "Lcom/cloud/hisavana/sdk/common/util/v;", TmcStartParams.KEY_URL_SHORT, "Lcom/cloud/hisavana/sdk/common/util/v;", "retainDialog", "ruDialog", "Z", "isLandscape", "isNeedRuMargin", "lastClickTime", "z", "triggerMillis", "Lcom/cloud/hisavana/sdk/common/bean/RewardedState;", "A", "Lcom/cloud/hisavana/sdk/common/bean/RewardedState;", "state", "closeDelayTimeDuration", "Lcom/cloud/hisavana/sdk/o0;", "C", "Lcom/cloud/hisavana/sdk/o0;", "V", "()Lcom/cloud/hisavana/sdk/o0;", "setRewardStyle", "(Lcom/cloud/hisavana/sdk/o0;)V", "rewardStyle", "Le7/i;", "D", "Le7/i;", "getHsConfirmPopUpWindow", "()Le7/i;", "setHsConfirmPopUpWindow", "(Le7/i;)V", "hsConfirmPopUpWindow", "E", "downX", "downY", "upX", "upY", "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public class HisavanaRewardedActivity extends Activity implements g4 {

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference J;

    /* renamed from: B, reason: from kotlin metadata */
    private int closeDelayTimeDuration;

    /* renamed from: C, reason: from kotlin metadata */
    private o0 rewardStyle;

    /* renamed from: D, reason: from kotlin metadata */
    private e7.i hsConfirmPopUpWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AdsDTO adBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long observerId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int adMediaType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout adMainLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout adContainer;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ImageView adVolume;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private HSChronometer adChronometer;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private RewardedVideoView adVideoView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView adImageView;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ImageView adIcon;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private ImageView adChoicesView;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private AdBadgeView adBadgeView;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private AdCloseView adCloseView;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private StoreMarkView storeMarkView;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private AdDisclaimerView adDisclaimerView;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private InteractiveWebView interactiveWebView;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.cloud.hisavana.sdk.common.util.v retainDialog;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private com.cloud.hisavana.sdk.common.util.v ruDialog;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedRuMargin;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private long triggerMillis;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String tag = "Rewarded";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int defaultDuration = 5;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long rewardDuration = 5 * 1000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String prefix = "";

    /* renamed from: A, reason: from kotlin metadata */
    private RewardedState state = new RewardedState(0, 0.0f, false, false, false, false, false, false, false, 511, null);

    /* renamed from: E, reason: from kotlin metadata */
    private float downX = -1.0f;

    /* renamed from: F, reason: from kotlin metadata */
    private float downY = -1.0f;

    /* renamed from: G, reason: from kotlin metadata */
    private float upX = -1.0f;

    /* renamed from: H, reason: from kotlin metadata */
    private float upY = -1.0f;

    /* renamed from: com.cloud.hisavana.sdk.common.activity.HisavanaRewardedActivity$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(WeakReference weakReference) {
            HisavanaRewardedActivity.J = weakReference;
        }
    }

    /* loaded from: classes3.dex */
    public final class b extends com.cloud.hisavana.sdk.common.tranmeasure.a {

        /* renamed from: b, reason: collision with root package name */
        private WeakReference f21843b;

        public b(HisavanaRewardedActivity hisavanaRewardedActivity) {
            this.f21843b = new WeakReference(hisavanaRewardedActivity);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            super.a(adsDTO);
            if (((HisavanaRewardedActivity) this.f21843b.get()) != null) {
                HisavanaRewardedActivity hisavanaRewardedActivity = HisavanaRewardedActivity.this;
                hisavanaRewardedActivity.u0();
                hisavanaRewardedActivity.v0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f21845a;

        public c(boolean z10) {
            this.f21845a = z10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v11, MotionEvent event) {
            Intrinsics.h(v11, "v");
            Intrinsics.h(event, "event");
            int action = event.getAction();
            if (action == 0) {
                HisavanaRewardedActivity.this.downX = event.getX();
                HisavanaRewardedActivity.this.downY = event.getY();
            } else if (action == 1) {
                HisavanaRewardedActivity.this.upX = event.getX();
                HisavanaRewardedActivity.this.upY = event.getY();
                if (Math.hypot(HisavanaRewardedActivity.this.upX - HisavanaRewardedActivity.this.downX, HisavanaRewardedActivity.this.upY - HisavanaRewardedActivity.this.downY) < 50.0d && this.f21845a) {
                    v11.performClick();
                    o0 rewardStyle = HisavanaRewardedActivity.this.getRewardStyle();
                    if (rewardStyle != null) {
                        rewardStyle.e(false, new DownUpPointBean(HisavanaRewardedActivity.this.downX, HisavanaRewardedActivity.this.downY, HisavanaRewardedActivity.this.upX, HisavanaRewardedActivity.this.upY, v11.getMeasuredWidth(), v11.getMeasuredHeight()), null);
                    }
                }
            }
            return this.f21845a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements InteractiveWebView.c {
        d() {
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void a(String str) {
            e4.b().d(HisavanaRewardedActivity.this.tag, "interactiveEvent, eventId is " + str);
            AthenaTracker.y(HisavanaRewardedActivity.this.adBean, str);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void b() {
            e4.b().d(HisavanaRewardedActivity.this.tag, "handleClick");
            o0 rewardStyle = HisavanaRewardedActivity.this.getRewardStyle();
            if (rewardStyle != null) {
                float f11 = HisavanaRewardedActivity.this.downX;
                float f12 = HisavanaRewardedActivity.this.downY;
                float f13 = HisavanaRewardedActivity.this.upX;
                float f14 = HisavanaRewardedActivity.this.upY;
                InteractiveWebView interactiveWebView = HisavanaRewardedActivity.this.interactiveWebView;
                int measuredWidth = interactiveWebView != null ? interactiveWebView.getMeasuredWidth() : 0;
                InteractiveWebView interactiveWebView2 = HisavanaRewardedActivity.this.interactiveWebView;
                rewardStyle.e(false, new DownUpPointBean(f11, f12, f13, f14, measuredWidth, interactiveWebView2 != null ? interactiveWebView2.getMeasuredHeight() : 0), HisavanaRewardedActivity.this.interactiveWebView);
            }
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void c() {
            e4.b().d(HisavanaRewardedActivity.this.tag, "timeoutShutdown");
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends f4 {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RewardedVideoView f21848e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ HisavanaRewardedActivity f21849f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(RewardedVideoView rewardedVideoView, HisavanaRewardedActivity hisavanaRewardedActivity, AdsDTO adsDTO) {
            super(adsDTO);
            this.f21848e = rewardedVideoView;
            this.f21849f = hisavanaRewardedActivity;
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void a(C1016p error) {
            Intrinsics.h(error, "error");
            super.a(error);
            this.f21848e.showRepeatButton(true);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void b() {
            if (!this.f21849f.state.isPlayStart()) {
                super.b();
            }
            this.f21849f.state.setPlayStart(true);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onComplete() {
            if (!this.f21849f.state.isPlayComplete()) {
                super.onComplete();
            }
            this.f21849f.state.setPlayComplete(true);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onIsPlayingChanged(boolean z10) {
            super.onIsPlayingChanged(z10);
            if (z10) {
                this.f21848e.showRepeatButton(false);
            }
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onVolumeChanged(float f11) {
            super.onVolumeChanged(f11);
            this.f21849f.state.setVideoVolume(f11);
            this.f21849f.k(f11);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends DrawableResponseListener {
        f() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                HisavanaRewardedActivity.this.v(taErrorCode);
            }
            HisavanaRewardedActivity.this.G(false);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null && adImage.isAdImageRecycled()) {
                HisavanaRewardedActivity.this.v(new TaErrorCode(i11, "bitmap is null"));
                HisavanaRewardedActivity.this.G(false);
                return;
            }
            ImageView imageView = HisavanaRewardedActivity.this.adImageView;
            if ((imageView != null ? imageView.getParent() : null) != null) {
                ImageView imageView2 = HisavanaRewardedActivity.this.adImageView;
                ViewParent parent = imageView2 != null ? imageView2.getParent() : null;
                Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(HisavanaRewardedActivity.this.adImageView);
            }
            FrameLayout frameLayout = HisavanaRewardedActivity.this.adContainer;
            if (frameLayout != null) {
                frameLayout.addView(HisavanaRewardedActivity.this.adImageView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements i.a {
        g() {
        }

        @Override // e7.i.a
        public void a() {
            try {
                if (Build.VERSION.SDK_INT <= 29) {
                    HisavanaRewardedActivity.this.U();
                }
            } catch (Throwable unused) {
            }
            HisavanaRewardedActivity.this.h();
        }

        @Override // e7.i.a
        public void onClick(View view) {
            HisavanaRewardedActivity.this.a(2);
            HisavanaRewardedActivity.this.d();
            AdsDTO adsDTO = HisavanaRewardedActivity.this.adBean;
            if (adsDTO != null) {
                adsDTO.setAdClickTracking(false);
            }
            HisavanaRewardedActivity.this.b(false, null);
            HisavanaRewardedActivity.this.G(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements v.a {
        h() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void a() {
            HSChronometer hSChronometer = HisavanaRewardedActivity.this.adChronometer;
            if (hSChronometer != null) {
                hSChronometer.stop();
            }
            com.cloud.hisavana.sdk.common.util.v vVar = HisavanaRewardedActivity.this.retainDialog;
            if (vVar != null) {
                vVar.dismiss();
            }
            HisavanaRewardedActivity.this.state.setShowRetainDialog(false);
            HisavanaRewardedActivity.this.H(true, null);
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void b() {
            RewardedVideoView rewardedVideoView;
            com.cloud.hisavana.sdk.common.util.v vVar = HisavanaRewardedActivity.this.retainDialog;
            if (vVar != null) {
                vVar.dismiss();
            }
            HSChronometer hSChronometer = HisavanaRewardedActivity.this.adChronometer;
            if (hSChronometer != null) {
                hSChronometer.resumeCountdown(HisavanaRewardedActivity.this.state.getCountdownRemainDuration());
            }
            if (!HisavanaRewardedActivity.this.state.isPlayComplete() && (rewardedVideoView = HisavanaRewardedActivity.this.adVideoView) != null) {
                rewardedVideoView.resume();
            }
            HisavanaRewardedActivity.this.state.setShowRetainDialog(false);
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void c() {
            v.a.C0313a.a(this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements v.a {
        i() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void a() {
            v.a.C0313a.b(this);
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void b() {
            v.a.C0313a.c(this);
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void c() {
            RewardedVideoView rewardedVideoView;
            com.cloud.hisavana.sdk.common.util.v vVar = HisavanaRewardedActivity.this.ruDialog;
            if (vVar != null) {
                vVar.dismiss();
            }
            HSChronometer hSChronometer = HisavanaRewardedActivity.this.adChronometer;
            if (hSChronometer != null) {
                hSChronometer.resumeCountdown(HisavanaRewardedActivity.this.state.getCountdownRemainDuration());
            }
            if (!HisavanaRewardedActivity.this.state.isPlayComplete() && (rewardedVideoView = HisavanaRewardedActivity.this.adVideoView) != null) {
                rewardedVideoView.resume();
            }
            HisavanaRewardedActivity.this.state.setShowRuDialog(false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements HSChronometer.a {
        j() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.HSChronometer.a
        public void onFinish() {
            o0 rewardStyle = HisavanaRewardedActivity.this.getRewardStyle();
            if (rewardStyle != null) {
                rewardStyle.j();
            }
            HisavanaRewardedActivity.this.L(false);
        }

        @Override // com.cloud.hisavana.sdk.common.util.HSChronometer.a
        public void onTick(long j11) {
            HisavanaRewardedActivity.this.l(j11);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements HSChronometer.a {
        k() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.HSChronometer.a
        public void onFinish() {
            o0 rewardStyle = HisavanaRewardedActivity.this.getRewardStyle();
            if (rewardStyle != null) {
                rewardStyle.j();
            }
            HisavanaRewardedActivity.this.L(false);
        }

        @Override // com.cloud.hisavana.sdk.common.util.HSChronometer.a
        public void onTick(long j11) {
            HisavanaRewardedActivity.this.l(j11);
        }
    }

    private final void B(long duration) {
        if (e4.c()) {
            e4.b().i(this.tag, "-----------> startCountdown " + this.state);
        }
        o0 o0Var = this.rewardStyle;
        if (o0Var != null) {
            o0Var.c(this.adChronometer);
        }
        if (this.state.isShowRetainDialog()) {
            i();
        }
        if (this.state.isShowRuDialog()) {
            String string = getResources().getString(R$string.disclaimer);
            Intrinsics.g(string, "getString(...)");
            String f11 = com.cloud.hisavana.sdk.common.util.f0.f(this.adBean);
            Intrinsics.g(f11, "getDisclaimerText(...)");
            String string2 = getResources().getString(R$string.f21616ok);
            Intrinsics.g(string2, "getString(...)");
            y(string, f11, string2);
        }
        l(duration);
        boolean z10 = this.state.isShowRetainDialog() || this.state.isShowRuDialog() || this.state.isPaused();
        if (this.state.isRewarded()) {
            HSChronometer hSChronometer = this.adChronometer;
            if (hSChronometer != null) {
                o0 o0Var2 = this.rewardStyle;
                if (o0Var2 != null) {
                    o0Var2.j();
                }
                hSChronometer.setText(hSChronometer.getFinishedString());
                return;
            }
            return;
        }
        if (!z10) {
            HSChronometer hSChronometer2 = this.adChronometer;
            if (hSChronometer2 != null) {
                hSChronometer2.startCountdown(duration, new j());
                return;
            }
            return;
        }
        HSChronometer hSChronometer3 = this.adChronometer;
        if (hSChronometer3 != null) {
            hSChronometer3.setText(hSChronometer3.countdownText(this.state.getCountdownRemainDuration()));
            hSChronometer3.setTickListener(new k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(HisavanaRewardedActivity this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        RewardedVideoView rewardedVideoView = this$0.adVideoView;
        if (rewardedVideoView != null) {
            rewardedVideoView.toggleVolume();
        }
    }

    private final void F(String event) {
        x(event, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(boolean isSentEvent) {
        if (isSentEvent) {
            F("_close");
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(boolean isClose, DownUpPointBean downUpPointBean) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime < 1000) {
            return;
        }
        this.lastClickTime = currentTimeMillis;
        if (isClose) {
            G(true);
        } else {
            x("_click", new Pair(this.adBean, downUpPointBean));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(HisavanaRewardedActivity this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        HSChronometer hSChronometer = this$0.adChronometer;
        if ((hSChronometer != null && hSChronometer.getIsTimeUp()) || this$0.state.isRewarded()) {
            this$0.G(true);
            return;
        }
        RewardedState rewardedState = this$0.state;
        HSChronometer hSChronometer2 = this$0.adChronometer;
        rewardedState.setCountdownRemainDuration(hSChronometer2 != null ? hSChronometer2.pauseCountdown() : 0L);
        RewardedVideoView rewardedVideoView = this$0.adVideoView;
        if (rewardedVideoView != null) {
            rewardedVideoView.pause();
        }
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(boolean isShowToast) {
        o0 o0Var;
        if (this.state.isRewarded()) {
            return;
        }
        if (isShowToast && (o0Var = this.rewardStyle) != null) {
            o0Var.l();
        }
        AdsDTO adsDTO = this.adBean;
        x("_rewarded", adsDTO != null ? Long.valueOf(adsDTO.getTriggerShowSpend()) : null);
        this.state.setRewarded(true);
        this.state.setCountdownRemainDuration(0L);
    }

    private final void S() {
        try {
            try {
                AdsDTO adsDTO = this.adBean;
                String materialStyle = adsDTO != null ? adsDTO.getMaterialStyle() : null;
                if (Intrinsics.c(materialStyle, "R02")) {
                    View decorView = getWindow().getDecorView();
                    Intrinsics.g(decorView, "getDecorView(...)");
                    this.rewardStyle = new x1(this, decorView, this);
                } else if (Intrinsics.c(materialStyle, "R01")) {
                    View decorView2 = getWindow().getDecorView();
                    Intrinsics.g(decorView2, "getDecorView(...)");
                    this.rewardStyle = new u1(this, decorView2, this);
                } else {
                    View decorView3 = getWindow().getDecorView();
                    Intrinsics.g(decorView3, "getDecorView(...)");
                    this.rewardStyle = new u1(this, decorView3, this);
                }
                o0 o0Var = this.rewardStyle;
                if (o0Var != null) {
                    o0Var.k();
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            v(TaErrorCode.ERROR_SHOW_LAYOUT_ERROR);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
    }

    private final void Y() {
        this.isLandscape = getResources().getConfiguration().orientation == 2;
        S();
        n0();
    }

    private final void a0() {
        if (this.adImageView == null) {
            ImageView imageView = new ImageView(this);
            imageView.setAdjustViewBounds(true);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            this.adImageView = imageView;
        }
    }

    private final void c0() {
        NativeBean nativeObject;
        ImageView imageView = (ImageView) findViewById(R$id.ad_icon);
        AdsDTO adsDTO = this.adBean;
        String str = null;
        if (adsDTO != null) {
            if (adsDTO.getSource() == 4) {
                DownLoadRequest.n(adsDTO.getLogoUrl(), adsDTO, null, imageView);
            } else {
                DownLoadRequest.o(adsDTO.getLogoUrl(), this.adBean, 1, null, imageView);
            }
        }
        TextView textView = (TextView) findViewById(R$id.ad_name);
        if (textView != null) {
            AdsDTO adsDTO2 = this.adBean;
            if (adsDTO2 != null && (nativeObject = adsDTO2.getNativeObject()) != null) {
                str = nativeObject.getTitleTxt();
            }
            textView.setText(str);
        }
        o0 o0Var = this.rewardStyle;
        if (o0Var != null) {
            o0Var.d(this.adBean);
        }
    }

    private final void e0() {
        if (this.interactiveWebView == null) {
            InteractiveWebView interactiveWebView = new InteractiveWebView(this);
            interactiveWebView.setWebClientCallback(this.adBean);
            interactiveWebView.setInteractiveListener(new d());
            this.interactiveWebView = interactiveWebView;
        }
    }

    private final void g0() {
        View view;
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R$id.main_layout);
        this.adMainLayout = constraintLayout;
        if (constraintLayout != null) {
            constraintLayout.setOnTouchListener(new c(true));
        }
        this.adContainer = (FrameLayout) findViewById(R$id.ad_container);
        AdsDTO adsDTO = this.adBean;
        boolean z10 = adsDTO != null && (adsDTO.isVastTypeAd() || (adsDTO.getSource() == 4 && adsDTO.getDefaultMaterialType() == 2));
        AdsDTO adsDTO2 = this.adBean;
        if (adsDTO2 != null && adsDTO2.isInteractiveAd()) {
            r0();
        } else if (z10) {
            t0();
        } else {
            AdsDTO adsDTO3 = this.adBean;
            if ((adsDTO3 != null ? adsDTO3.getNativeObject() : null) != null) {
                s0();
            }
        }
        if (this.adBean == null || this.state.isAlreadyMeasure()) {
            return;
        }
        AthenaTracker.A(this.adBean);
        if (z10) {
            view = this.adVideoView;
        } else {
            AdsDTO adsDTO4 = this.adBean;
            view = (adsDTO4 == null || !adsDTO4.isInteractiveAd()) ? this.adImageView : this.interactiveWebView;
        }
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.adBean, view, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        e7.i iVar;
        RewardedVideoView rewardedVideoView;
        if (e4.c()) {
            e4.b().i(this.tag, "-----------> onResume " + this.state);
        }
        if (!this.state.isShowRetainDialog() && !this.state.isShowRuDialog()) {
            HSChronometer hSChronometer = this.adChronometer;
            if (hSChronometer != null) {
                hSChronometer.resumeCountdown(this.state.getCountdownRemainDuration());
            }
            if (!this.state.isPlayComplete() && (rewardedVideoView = this.adVideoView) != null) {
                rewardedVideoView.resume();
            }
        }
        this.state.setPaused(false);
        try {
            e7.i iVar2 = this.hsConfirmPopUpWindow;
            if (iVar2 != null && iVar2.isShowing() && (iVar = this.hsConfirmPopUpWindow) != null) {
                iVar.dismiss();
            }
        } catch (Throwable unused) {
        }
        o0 o0Var = this.rewardStyle;
        if (o0Var != null) {
            o0Var.i();
        }
    }

    private final void i() {
        if (this.retainDialog == null) {
            com.cloud.hisavana.sdk.common.util.v vVar = new com.cloud.hisavana.sdk.common.util.v(this, new h());
            this.retainDialog = vVar;
            String string = getResources().getString(R$string.not_reward_title);
            Intrinsics.g(string, "getString(...)");
            vVar.k(string);
            String string2 = getResources().getString(R$string.not_reward_content);
            Intrinsics.g(string2, "getString(...)");
            vVar.h(string2);
            String string3 = getResources().getString(R$string.continue_txt);
            Intrinsics.g(string3, "getString(...)");
            vVar.i(string3);
        }
        try {
            com.cloud.hisavana.sdk.common.util.v vVar2 = this.retainDialog;
            if (vVar2 != null) {
                vVar2.show();
            }
            this.state.setShowRetainDialog(true);
        } catch (Exception e11) {
            e4.b().e(this.tag, "showRetainDialog error: " + e11.getMessage());
        }
    }

    private final void i0() {
        ImageView imageView = (ImageView) findViewById(R$id.ad_choices_view);
        this.adChoicesView = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HisavanaRewardedActivity.q(HisavanaRewardedActivity.this, view);
                }
            });
        }
        AdsDTO adsDTO = this.adBean;
        if (adsDTO != null) {
            if (adsDTO.getSource() == 4) {
                DownLoadRequest.n(adsDTO.getAdChoiceImageUrl(), adsDTO, null, this.adChoicesView);
            } else {
                DownLoadRequest.o(adsDTO.getAdChoiceImageUrl(), this.adBean, 3, null, this.adChoicesView);
            }
        }
        AdBadgeView adBadgeView = (AdBadgeView) findViewById(R$id.ad_badge_view);
        this.adBadgeView = adBadgeView;
        if (adBadgeView != null) {
            AdsDTO adsDTO2 = this.adBean;
            adBadgeView.setDisplayStyle(adsDTO2 != null ? adsDTO2.getDisplayRule() : null, com.cloud.hisavana.sdk.common.util.f0.c(this.adBean));
        }
        AdCloseView adCloseView = (AdCloseView) findViewById(R$id.ad_close_view);
        this.adCloseView = adCloseView;
        if (adCloseView != null) {
            AdsDTO adsDTO3 = this.adBean;
            adCloseView.setDisplayStyle(adsDTO3 != null ? adsDTO3.getDisplayRule() : null, AdCloseView.CloseImageType.EXPAND);
        }
        t2.p().f(this, this.adCloseView, this, this.adBean);
        this.storeMarkView = (StoreMarkView) findViewById(R$id.ps_mark_view);
        boolean a11 = i0.a(this.adBean);
        StoreMarkView storeMarkView = this.storeMarkView;
        if (storeMarkView != null) {
            storeMarkView.setVisibility(a11 ? 0 : 8);
        }
        StoreMarkView storeMarkView2 = this.storeMarkView;
        if (storeMarkView2 != null) {
            storeMarkView2.setTextSize(6.0f);
        }
        StoreMarkView storeMarkView3 = this.storeMarkView;
        if (storeMarkView3 != null) {
            storeMarkView3.setTextColor(-8882056);
        }
        StoreMarkView storeMarkView4 = this.storeMarkView;
        if (storeMarkView4 != null) {
            storeMarkView4.attachInfo(this.adBean);
        }
    }

    private final void j() {
        AdsDTO adsDTO;
        Object parcelableExtra;
        Intent intent = getIntent();
        if (intent != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelableExtra = intent.getParcelableExtra("adBean", AdsDTO.class);
                adsDTO = (AdsDTO) parcelableExtra;
            } else {
                adsDTO = (AdsDTO) intent.getParcelableExtra("adBean");
            }
            this.adBean = adsDTO;
            String stringExtra = intent.getStringExtra(RequestParameters.PREFIX);
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                Intrinsics.e(stringExtra);
            }
            this.prefix = stringExtra;
            this.observerId = intent.getLongExtra("observerId", 0L);
            this.triggerMillis = intent.getLongExtra("triggerTs", System.currentTimeMillis());
        }
        AdsDTO adsDTO2 = this.adBean;
        if (adsDTO2 == null || adsDTO2.getMaterialStyle() == null) {
            AdsDTO adsDTO3 = this.adBean;
            if (adsDTO3 == null) {
                v(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            } else if (adsDTO3.getMaterialStyle() == null) {
                v(TaErrorCode.ERROR_SHOW_MATERIAL_STYLE_NULL);
            }
            G(true);
            return;
        }
        int b11 = com.cloud.hisavana.sdk.common.util.b.f22230a.b(this.adBean);
        this.adMediaType = b11;
        if (b11 != -1) {
            U();
            Y();
        } else {
            e4.b().w(this.tag, "adMediaType is INVALID_TYPE");
            v(TaErrorCode.ERROR_SHOW_ADMEDIATYPE_INVALID);
            G(true);
        }
    }

    private final void j0() {
        final AdsDTO adsDTO = this.adBean;
        if (adsDTO != null) {
            if (adsDTO.getDisplayRule() != Constants.AdDisplayRule.RU) {
                adsDTO = null;
            }
            if (adsDTO != null) {
                final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R$id.main_layout);
                AdDisclaimerView adDisclaimerView = (AdDisclaimerView) findViewById(R$id.ad_disclaimer_view);
                this.adDisclaimerView = adDisclaimerView;
                if (adDisclaimerView != null) {
                    adDisclaimerView.setListener(new AdDisclaimerView.b() { // from class: com.cloud.hisavana.sdk.common.activity.e
                        @Override // com.cloud.hisavana.sdk.api.view.AdDisclaimerView.b
                        public final void a(String str, String str2, String str3) {
                            HisavanaRewardedActivity.s(HisavanaRewardedActivity.this, str, str2, str3);
                        }
                    });
                }
                if (constraintLayout != null) {
                    Intrinsics.e(constraintLayout);
                    constraintLayout.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            HisavanaRewardedActivity.m(ConstraintLayout.this, this, adsDTO);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(float volume) {
        o0 o0Var = this.rewardStyle;
        if (o0Var != null) {
            o0Var.b(this.adVolume, volume);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(long remainingDuration) {
        View findViewById = findViewById(R$id.ad_close);
        int i11 = this.closeDelayTimeDuration;
        if (i11 <= 0 || remainingDuration <= 0) {
            if (findViewById == null) {
                return;
            }
            findViewById.setVisibility(0);
        } else {
            if (((float) (this.rewardDuration - remainingDuration)) / 1000.0f < i11 || findViewById == null) {
                return;
            }
            findViewById.setVisibility(0);
        }
    }

    private final void l0() {
        if (this.adVideoView != null) {
            return;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        RewardedVideoView rewardedVideoView = new RewardedVideoView(applicationContext, null, 0, 6, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        rewardedVideoView.setLayoutParams(layoutParams);
        rewardedVideoView.setAdMediaPlayerListener(new e(rewardedVideoView, this, this.adBean));
        this.adVideoView = rewardedVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ConstraintLayout container, HisavanaRewardedActivity this$0, AdsDTO bean) {
        Intrinsics.h(container, "$container");
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(bean, "$bean");
        int measuredHeight = container.getMeasuredHeight();
        AdDisclaimerView adDisclaimerView = this$0.adDisclaimerView;
        if (adDisclaimerView != null) {
            adDisclaimerView.setDisplayStyle(bean.getDisplayRule(), com.cloud.hisavana.sdk.common.util.f0.f(bean), com.cloud.hisavana.sdk.common.util.f0.e(bean), measuredHeight);
        }
        AdDisclaimerView adDisclaimerView2 = this$0.adDisclaimerView;
        if (adDisclaimerView2 == null) {
            return;
        }
        adDisclaimerView2.setVisibility(0);
    }

    private final void n0() {
        if (this.adBean == null) {
            e4.b().w(this.tag, "rewarded adBean is null");
            v(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            G(true);
            return;
        }
        g0();
        p0();
        c0();
        i0();
        j0();
        try {
            com.cloud.hisavana.sdk.manager.a aVar = com.cloud.hisavana.sdk.manager.a.f22735a;
            Context applicationContext = getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            aVar.s(applicationContext, this.adBean, false);
        } catch (Throwable unused) {
        }
    }

    private final void p0() {
        VastData videoInfo;
        Integer duration;
        ImageView imageView = (ImageView) findViewById(R$id.ad_volume);
        this.adVolume = imageView;
        if (imageView != null) {
            k(this.state.getVideoVolume());
            AdsDTO adsDTO = this.adBean;
            imageView.setVisibility((adsDTO == null || !adsDTO.isVastTypeAd()) ? 8 : 0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HisavanaRewardedActivity.D(HisavanaRewardedActivity.this, view);
                }
            });
        }
        HSChronometer hSChronometer = (HSChronometer) findViewById(R$id.ad_chronometer);
        this.adChronometer = hSChronometer;
        if (hSChronometer != null && this.state.isAlreadyMeasure()) {
            B(this.state.getCountdownRemainDuration());
        }
        View findViewById = findViewById(R$id.ad_close);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HisavanaRewardedActivity.K(HisavanaRewardedActivity.this, view);
                }
            });
        }
        AdsDTO adsDTO2 = this.adBean;
        int closeDelayTime = adsDTO2 != null ? adsDTO2.getCloseDelayTime() : 0;
        AdsDTO adsDTO3 = this.adBean;
        if (adsDTO3 != null && adsDTO3.isVastTypeAd()) {
            AdsDTO adsDTO4 = this.adBean;
            closeDelayTime = Math.min(closeDelayTime, (adsDTO4 == null || (videoInfo = adsDTO4.getVideoInfo()) == null || (duration = videoInfo.getDuration()) == null) ? closeDelayTime : duration.intValue());
        }
        e4.b().d(this.tag, "current close delay time duration is: " + closeDelayTime);
        this.closeDelayTimeDuration = closeDelayTime;
        if (closeDelayTime > 0) {
            try {
                if (!q0()) {
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    if (this.state.isAlreadyMeasure()) {
                        l(this.state.getCountdownRemainDuration());
                        return;
                    }
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        e4.b().d(this.tag, "current close delay time is 0 or video or image is null, do not count down.");
        if (findViewById == null) {
            return;
        }
        findViewById.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(HisavanaRewardedActivity this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        N0.k(com.cloud.sdk.commonutil.util.e.a(), this$0.adBean);
    }

    private final boolean q0() {
        VastData videoInfo;
        VastMedia mainAd;
        AdsDTO adsDTO = this.adBean;
        if (adsDTO == null || !adsDTO.isVastTypeAd()) {
            AdsDTO adsDTO2 = this.adBean;
            r1 = adsDTO2 != null ? adsDTO2.getAdImgUrl() : null;
            if (r1 == null || r1.length() == 0) {
                return true;
            }
        } else {
            AdsDTO adsDTO3 = this.adBean;
            if (adsDTO3 != null && (videoInfo = adsDTO3.getVideoInfo()) != null && (mainAd = videoInfo.getMainAd()) != null) {
                r1 = mainAd.getMediaResource();
            }
            if (r1 == null || r1.length() == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0003, B:5:0x0008, B:7:0x000e, B:12:0x0032, B:14:0x0036, B:15:0x0039, B:17:0x003d, B:18:0x0043, B:20:0x0047, B:22:0x004d, B:23:0x0051, B:25:0x0058, B:26:0x0063, B:28:0x0067, B:29:0x006b, B:32:0x0071, B:35:0x0078, B:38:0x0084, B:41:0x008c, B:43:0x0090, B:47:0x0089, B:48:0x00a5, B:52:0x001c, B:54:0x0020, B:56:0x0026), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0003, B:5:0x0008, B:7:0x000e, B:12:0x0032, B:14:0x0036, B:15:0x0039, B:17:0x003d, B:18:0x0043, B:20:0x0047, B:22:0x004d, B:23:0x0051, B:25:0x0058, B:26:0x0063, B:28:0x0067, B:29:0x006b, B:32:0x0071, B:35:0x0078, B:38:0x0084, B:41:0x008c, B:43:0x0090, B:47:0x0089, B:48:0x00a5, B:52:0x001c, B:54:0x0020, B:56:0x0026), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0003, B:5:0x0008, B:7:0x000e, B:12:0x0032, B:14:0x0036, B:15:0x0039, B:17:0x003d, B:18:0x0043, B:20:0x0047, B:22:0x004d, B:23:0x0051, B:25:0x0058, B:26:0x0063, B:28:0x0067, B:29:0x006b, B:32:0x0071, B:35:0x0078, B:38:0x0084, B:41:0x008c, B:43:0x0090, B:47:0x0089, B:48:0x00a5, B:52:0x001c, B:54:0x0020, B:56:0x0026), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0003, B:5:0x0008, B:7:0x000e, B:12:0x0032, B:14:0x0036, B:15:0x0039, B:17:0x003d, B:18:0x0043, B:20:0x0047, B:22:0x004d, B:23:0x0051, B:25:0x0058, B:26:0x0063, B:28:0x0067, B:29:0x006b, B:32:0x0071, B:35:0x0078, B:38:0x0084, B:41:0x008c, B:43:0x0090, B:47:0x0089, B:48:0x00a5, B:52:0x001c, B:54:0x0020, B:56:0x0026), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0090 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0003, B:5:0x0008, B:7:0x000e, B:12:0x0032, B:14:0x0036, B:15:0x0039, B:17:0x003d, B:18:0x0043, B:20:0x0047, B:22:0x004d, B:23:0x0051, B:25:0x0058, B:26:0x0063, B:28:0x0067, B:29:0x006b, B:32:0x0071, B:35:0x0078, B:38:0x0084, B:41:0x008c, B:43:0x0090, B:47:0x0089, B:48:0x00a5, B:52:0x001c, B:54:0x0020, B:56:0x0026), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0003, B:5:0x0008, B:7:0x000e, B:12:0x0032, B:14:0x0036, B:15:0x0039, B:17:0x003d, B:18:0x0043, B:20:0x0047, B:22:0x004d, B:23:0x0051, B:25:0x0058, B:26:0x0063, B:28:0x0067, B:29:0x006b, B:32:0x0071, B:35:0x0078, B:38:0x0084, B:41:0x008c, B:43:0x0090, B:47:0x0089, B:48:0x00a5, B:52:0x001c, B:54:0x0020, B:56:0x0026), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void r0() {
        /*
            r7 = this;
            r0 = 3005(0xbbd, float:4.211E-42)
            r1 = 0
            com.cloud.hisavana.sdk.data.bean.response.AdsDTO r2 = r7.adBean     // Catch: java.lang.Throwable -> L19
            r3 = 0
            if (r2 == 0) goto L1c
            java.lang.String r2 = r2.getScale()     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L1c
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L19
            if (r4 <= 0) goto L15
            goto L16
        L15:
            r2 = r3
        L16:
            if (r2 != 0) goto L32
            goto L1c
        L19:
            r2 = move-exception
            goto Lb3
        L1c:
            com.cloud.hisavana.sdk.data.bean.response.AdsDTO r2 = r7.adBean     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L2d
            java.util.List r2 = r2.getScales()     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L2d
            java.lang.Object r2 = kotlin.collections.CollectionsKt.k0(r2)     // Catch: java.lang.Throwable -> L19
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L19
            goto L2e
        L2d:
            r2 = r3
        L2e:
            if (r2 != 0) goto L32
            java.lang.String r2 = ""
        L32:
            android.widget.FrameLayout r4 = r7.adContainer     // Catch: java.lang.Throwable -> L19
            if (r4 == 0) goto L39
            r4.removeAllViews()     // Catch: java.lang.Throwable -> L19
        L39:
            android.widget.FrameLayout r4 = r7.adContainer     // Catch: java.lang.Throwable -> L19
            if (r4 == 0) goto L42
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()     // Catch: java.lang.Throwable -> L19
            goto L43
        L42:
            r4 = r3
        L43:
            boolean r5 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.b     // Catch: java.lang.Throwable -> L19
            if (r5 == 0) goto L51
            int r5 = r2.length()     // Catch: java.lang.Throwable -> L19
            if (r5 <= 0) goto L51
            androidx.constraintlayout.widget.ConstraintLayout$b r4 = (androidx.constraintlayout.widget.ConstraintLayout.b) r4     // Catch: java.lang.Throwable -> L19
            r4.I = r2     // Catch: java.lang.Throwable -> L19
        L51:
            r7.e0()     // Catch: java.lang.Throwable -> L19
            android.widget.FrameLayout r2 = r7.adContainer     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L63
            com.cloud.hisavana.sdk.common.widget.InteractiveWebView r4 = r7.interactiveWebView     // Catch: java.lang.Throwable -> L19
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams     // Catch: java.lang.Throwable -> L19
            r6 = -1
            r5.<init>(r6, r6)     // Catch: java.lang.Throwable -> L19
            r2.addView(r4, r5)     // Catch: java.lang.Throwable -> L19
        L63:
            com.cloud.hisavana.sdk.data.bean.response.AdsDTO r2 = r7.adBean     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L6b
            java.lang.String r3 = r2.getIndexLocation()     // Catch: java.lang.Throwable -> L19
        L6b:
            com.cloud.hisavana.sdk.common.widget.InteractiveWebView r2 = r7.interactiveWebView     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto La5
            if (r3 == 0) goto La5
            int r2 = r3.length()     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L78
            goto La5
        L78:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L19
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L19
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L84
            goto La5
        L84:
            com.cloud.hisavana.sdk.common.widget.InteractiveWebView r2 = r7.interactiveWebView     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L89
            goto L8c
        L89:
            r2.setVisibility(r1)     // Catch: java.lang.Throwable -> L19
        L8c:
            com.cloud.hisavana.sdk.common.widget.InteractiveWebView r2 = r7.interactiveWebView     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto Lc2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19
            r4.<init>()     // Catch: java.lang.Throwable -> L19
            java.lang.String r5 = "file://"
            r4.append(r5)     // Catch: java.lang.Throwable -> L19
            r4.append(r3)     // Catch: java.lang.Throwable -> L19
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L19
            r2.loadUrl(r3)     // Catch: java.lang.Throwable -> L19
            goto Lc2
        La5:
            r7.G(r1)     // Catch: java.lang.Throwable -> L19
            com.cloud.hisavana.sdk.common.constant.TaErrorCode r2 = new com.cloud.hisavana.sdk.common.constant.TaErrorCode     // Catch: java.lang.Throwable -> L19
            java.lang.String r3 = "interactive file not exists "
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L19
            r7.v(r2)     // Catch: java.lang.Throwable -> L19
            return
        Lb3:
            r7.G(r1)
            com.cloud.hisavana.sdk.common.constant.TaErrorCode r1 = new com.cloud.hisavana.sdk.common.constant.TaErrorCode
            java.lang.String r2 = r2.getMessage()
            r1.<init>(r0, r2)
            r7.v(r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.activity.HisavanaRewardedActivity.r0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(HisavanaRewardedActivity this$0, String str, String str2, String str3) {
        Intrinsics.h(this$0, "this$0");
        HSChronometer hSChronometer = this$0.adChronometer;
        if ((hSChronometer == null || !hSChronometer.getIsTimeUp()) && !this$0.state.isRewarded()) {
            RewardedState rewardedState = this$0.state;
            HSChronometer hSChronometer2 = this$0.adChronometer;
            rewardedState.setCountdownRemainDuration(hSChronometer2 != null ? hSChronometer2.pauseCountdown() : 0L);
            RewardedVideoView rewardedVideoView = this$0.adVideoView;
            if (rewardedVideoView != null) {
                rewardedVideoView.pause();
            }
        }
        Intrinsics.e(str);
        Intrinsics.e(str2);
        Intrinsics.e(str3);
        this$0.y(str, str2, str3);
    }

    private final void s0() {
        Unit unit;
        String adImgUrl;
        a0();
        AdsDTO adsDTO = this.adBean;
        if (adsDTO == null || (adImgUrl = adsDTO.getAdImgUrl()) == null) {
            unit = null;
        } else {
            f fVar = new f();
            AdsDTO adsDTO2 = this.adBean;
            if (adsDTO2 == null || adsDTO2.getSource() != 4) {
                DownLoadRequest.o(adImgUrl, this.adBean, 2, fVar, this.adImageView);
            } else {
                DownLoadRequest.n(adImgUrl, this.adBean, fVar, this.adImageView);
            }
            unit = Unit.f67184a;
        }
        if (unit == null) {
            v(TaErrorCode.NO_MAIN_IMG_DATA_ERROR);
            G(false);
        }
    }

    private final void t0() {
        String l11 = v2.f23109a.l(this.adBean);
        if (l11 != null) {
            if (l11.length() <= 0) {
                l11 = null;
            }
            if (l11 != null) {
                l0();
                w(l11);
                RewardedVideoView rewardedVideoView = this.adVideoView;
                if ((rewardedVideoView != null ? rewardedVideoView.getParent() : null) != null) {
                    RewardedVideoView rewardedVideoView2 = this.adVideoView;
                    ViewParent parent = rewardedVideoView2 != null ? rewardedVideoView2.getParent() : null;
                    Intrinsics.f(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(this.adVideoView);
                }
                FrameLayout frameLayout = this.adContainer;
                if (frameLayout != null) {
                    frameLayout.addView(this.adVideoView);
                    return;
                }
                return;
            }
        }
        v(TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR);
        G(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        this.state.setAlreadyMeasure(true);
        long currentTimeMillis = System.currentTimeMillis() - this.triggerMillis;
        AdsDTO adsDTO = this.adBean;
        if (adsDTO != null) {
            adsDTO.setTriggerShowSpend(currentTimeMillis);
        }
        F("_show");
        AdsDTO adsDTO2 = this.adBean;
        long max = Math.max((adsDTO2 != null ? adsDTO2.getRewardDuration() : null) == null ? this.defaultDuration : r0.intValue(), this.defaultDuration) * 1000;
        this.rewardDuration = max;
        this.state.setCountdownRemainDuration(max);
        B(max);
        AdsDTO adsDTO3 = this.adBean;
        if (adsDTO3 != null) {
            P.g().k(adsDTO3.getCodeSeatId());
            if (adsDTO3.getSource() == 4) {
                Z z10 = Z.f21623a;
                String adCreativeId = adsDTO3.getAdCreativeId();
                Intrinsics.g(adCreativeId, "getAdCreativeId(...)");
                String codeSeatId = adsDTO3.getCodeSeatId();
                Intrinsics.g(codeSeatId, "getCodeSeatId(...)");
                z10.q(adCreativeId, codeSeatId);
            } else if (adsDTO3.isOfflineAd()) {
                adsDTO3.setShowNum(Integer.valueOf(adsDTO3.getShowNum().intValue() + 1));
                com.cloud.hisavana.sdk.c0.F().q(adsDTO3);
            }
        }
        View findViewById = findViewById(R$id.ad_close_container);
        if (findViewById == null) {
            return;
        }
        findViewById.setBackground(androidx.core.content.b.getDrawable(com.cloud.sdk.commonutil.util.e.a(), R$drawable.hisavana_hollow_rounded_rect));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(TaErrorCode adErrorCode) {
        x("_error", adErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        x3 x3Var;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.adChoicesView);
        arrayList.add(this.adDisclaimerView);
        arrayList.add(this.adCloseView);
        arrayList.add(this.storeMarkView);
        arrayList.add(this.adChoicesView);
        arrayList.add(this.adChronometer);
        m0.a aVar = m0.f22726a;
        WeakReference weakReference = J;
        aVar.a((weakReference == null || (x3Var = (x3) weakReference.get()) == null) ? null : x3Var.v(), this.adBean, (ViewGroup) findViewById(R$id.main_layout), arrayList);
    }

    private final void w(String videoUrl) {
        VastData videoInfo;
        VideoMask videoMask;
        String resource;
        RewardedVideoView rewardedVideoView;
        if (this.state.isPlayComplete()) {
            RewardedVideoView rewardedVideoView2 = this.adVideoView;
            if (rewardedVideoView2 != null) {
                rewardedVideoView2.seekTo(rewardedVideoView2.getDuration());
                return;
            }
            return;
        }
        if (this.state.isPlayStart()) {
            return;
        }
        if (e4.c()) {
            e4.b().i(this.tag, "-----------> video set media data.");
        }
        boolean W = StringsKt.W(videoUrl, "http", false, 2, null);
        RewardedVideoView rewardedVideoView3 = this.adVideoView;
        if (rewardedVideoView3 != null) {
            rewardedVideoView3.setMediaData(videoUrl, this.adBean, this.state.getVideoVolume() == 0.0f, W);
        }
        AdsDTO adsDTO = this.adBean;
        if (adsDTO == null || (videoInfo = adsDTO.getVideoInfo()) == null || (videoMask = videoInfo.getVideoMask()) == null || (resource = videoMask.getResource()) == null || (rewardedVideoView = this.adVideoView) == null) {
            return;
        }
        rewardedVideoView.setCompanionUrl(resource);
    }

    private final void w0() {
        RewardedVideoView rewardedVideoView;
        if (!this.state.isShowRetainDialog() && !this.state.isShowRuDialog() && !this.state.isPaused()) {
            RewardedState rewardedState = this.state;
            HSChronometer hSChronometer = this.adChronometer;
            rewardedState.setCountdownRemainDuration(hSChronometer != null ? hSChronometer.pauseCountdown() : 0L);
            if (!this.state.isPlayComplete() && (rewardedVideoView = this.adVideoView) != null) {
                rewardedVideoView.pause();
            }
        }
        this.state.setPaused(true);
        if (e4.c()) {
            e4.b().i(this.tag, "----------> onPause " + this.state);
        }
        o0 o0Var = this.rewardStyle;
        if (o0Var != null) {
            o0Var.h();
        }
    }

    private final void x(String event, Object params) {
        b2.f21767a.d(this.observerId, this.prefix + event, params);
    }

    private final void y(String title, String message, String buttonText) {
        if (this.ruDialog == null) {
            com.cloud.hisavana.sdk.common.util.v vVar = new com.cloud.hisavana.sdk.common.util.v(this, new i());
            this.ruDialog = vVar;
            vVar.k(title);
            vVar.h(message);
            vVar.g(buttonText);
            vVar.j(true);
        }
        try {
            com.cloud.hisavana.sdk.common.util.v vVar2 = this.ruDialog;
            if (vVar2 != null) {
                vVar2.show();
            }
            this.state.setShowRuDialog(true);
        } catch (Exception e11) {
            e4.b().e(this.tag, "showRuDialog error: " + e11.getMessage());
        }
    }

    /* renamed from: V, reason: from getter */
    public final o0 getRewardStyle() {
        return this.rewardStyle;
    }

    @Override // com.cloud.hisavana.sdk.g4
    public void a() {
        HSChronometer hSChronometer = this.adChronometer;
        if (hSChronometer != null) {
            hSChronometer.tickComplete(hSChronometer);
        }
        o0 o0Var = this.rewardStyle;
        if (o0Var != null) {
            o0Var.l();
        }
        G(true);
    }

    @Override // com.cloud.hisavana.sdk.g4
    public void a(int psClickType) {
        PslinkInfo pslinkInfo;
        AdsDTO adsDTO = this.adBean;
        if ((adsDTO != null ? adsDTO.getPslinkInfo() : null) != null) {
            if (psClickType == 2) {
                AdsDTO adsDTO2 = this.adBean;
                pslinkInfo = adsDTO2 != null ? adsDTO2.getPslinkInfo() : null;
                if (pslinkInfo != null) {
                    pslinkInfo.setClickType(2);
                }
                AdsDTO adsDTO3 = this.adBean;
                if (adsDTO3 != null) {
                    adsDTO3.setTrackUserClickArea(2);
                }
                e4.b().d(this.tag, "pslink half setClickType, click_install");
                return;
            }
            AdsDTO adsDTO4 = this.adBean;
            pslinkInfo = adsDTO4 != null ? adsDTO4.getPslinkInfo() : null;
            if (pslinkInfo != null) {
                pslinkInfo.setClickType(1);
            }
            AdsDTO adsDTO5 = this.adBean;
            if (adsDTO5 != null) {
                adsDTO5.setTrackUserClickArea(1);
            }
            e4.b().d(this.tag, "pslink half setClickType, click_img");
        }
    }

    @Override // com.cloud.hisavana.sdk.g4
    public void a(DownUpPointBean pointBean) {
        try {
            com.cloud.hisavana.sdk.common.util.r.f22275a.o(this.adBean, pointBean);
        } catch (Throwable unused) {
        }
        try {
            if (this.hsConfirmPopUpWindow == null) {
                e7.i iVar = new e7.i(this, this.adBean, false, 4, null);
                this.hsConfirmPopUpWindow = iVar;
                iVar.h(new g());
                e7.i iVar2 = this.hsConfirmPopUpWindow;
                if (iVar2 != null) {
                    iVar2.k(this.adBean);
                }
            }
            e7.i iVar3 = this.hsConfirmPopUpWindow;
            if (iVar3 != null) {
                AdsDTO adsDTO = this.adBean;
                View decorView = getWindow().getDecorView();
                Intrinsics.g(decorView, "getDecorView(...)");
                iVar3.j(this, adsDTO, decorView, pointBean != null ? (int) pointBean.getDownX() : 0, pointBean != null ? (int) pointBean.getDownY() : 0);
            }
            w0();
        } catch (Throwable unused2) {
        }
    }

    @Override // com.cloud.hisavana.sdk.g4
    public void a(boolean status) {
        this.isNeedRuMargin = status;
    }

    @Override // com.cloud.hisavana.sdk.g4
    public void b() {
        InteractiveWebView interactiveWebView;
        try {
            AdsDTO adsDTO = this.adBean;
            if (adsDTO == null || !adsDTO.isInteractiveAd() || (interactiveWebView = this.interactiveWebView) == null) {
                return;
            }
            interactiveWebView.setOnTouchListener(new c(false));
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.hisavana.sdk.g4
    public void b(boolean isClose, DownUpPointBean downUpPointBean) {
        H(isClose, downUpPointBean);
    }

    @Override // com.cloud.hisavana.sdk.g4
    /* renamed from: c, reason: from getter */
    public boolean getIsLandscape() {
        return this.isLandscape;
    }

    @Override // com.cloud.hisavana.sdk.g4
    public void d() {
        L(true);
    }

    @Override // com.cloud.hisavana.sdk.g4
    public void e() {
        G(true);
    }

    @Override // com.cloud.hisavana.sdk.g4
    /* renamed from: f, reason: from getter */
    public AdsDTO getAdBean() {
        return this.adBean;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        com.cloud.hisavana.sdk.common.util.v vVar;
        com.cloud.hisavana.sdk.common.util.v vVar2;
        Intrinsics.h(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        HSChronometer hSChronometer = this.adChronometer;
        if (hSChronometer != null) {
            this.state.setCountdownRemainDuration(hSChronometer.pauseCountdown());
            hSChronometer.stop();
        }
        FrameLayout frameLayout = this.adContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        Y();
        if (this.state.isShowRuDialog() && (vVar2 = this.ruDialog) != null) {
            vVar2.l();
        }
        if (!this.state.isShowRetainDialog() || (vVar = this.retainDialog) == null) {
            return;
        }
        vVar.l();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        j();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        RewardedVideoView rewardedVideoView = this.adVideoView;
        if (rewardedVideoView != null) {
            rewardedVideoView.release();
        }
        HSChronometer hSChronometer = this.adChronometer;
        if (hSChronometer != null) {
            hSChronometer.stop();
        }
        FrameLayout frameLayout = this.adContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        com.cloud.hisavana.sdk.common.util.v vVar = this.retainDialog;
        if (vVar != null) {
            vVar.dismiss();
        }
        com.cloud.hisavana.sdk.common.util.v vVar2 = this.ruDialog;
        if (vVar2 != null) {
            vVar2.dismiss();
        }
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(this.adBean);
        com.cloud.sdk.commonutil.util.k.a(this.adImageView);
        com.cloud.sdk.commonutil.util.k.a(this.adIcon);
        com.cloud.sdk.commonutil.util.k.a(this.adChoicesView);
        try {
            e7.i iVar = this.hsConfirmPopUpWindow;
            if (iVar == null || !iVar.isShowing()) {
                return;
            }
            e7.i iVar2 = this.hsConfirmPopUpWindow;
            if (iVar2 != null) {
                iVar2.dismiss();
            }
            this.hsConfirmPopUpWindow = null;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        w0();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        h();
    }
}
