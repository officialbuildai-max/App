package com.transsion.share.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.c0;
import androidx.view.v0;
import be.g;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.PermissionUtils;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.push.PushConstants;
import com.transsion.share.R$id;
import com.transsion.share.R$layout;
import com.transsion.share.R$mipmap;
import com.transsion.share.R$string;
import com.transsion.share.R$style;
import com.transsion.share.bean.PostType;
import com.transsion.share.bean.ShareBean;
import com.transsion.share.bean.ShareType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import hj.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kr.o;
import kr.p;
import lg.a;
import nh.m;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u008a\u00012\u00020\u0001:\u0001WB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J;\u0010\"\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0016H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0016H\u0002¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u0016H\u0002¢\u0006\u0004\b+\u0010)J#\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00162\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0016H\u0002¢\u0006\u0004\b0\u0010)J!\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0006H\u0003¢\u0006\u0004\b6\u0010\u0003J\u0015\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0019\u0010=\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J!\u0010?\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b?\u0010@J\u0019\u0010B\u001a\u00020A2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0006H\u0016¢\u0006\u0004\bD\u0010\u0003J/\u0010I\u001a\u00020\u00062\u0006\u0010F\u001a\u00020E2\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\u0006H\u0016¢\u0006\u0004\bL\u0010\u0003J\u0017\u0010O\u001a\u00020\u00062\u0006\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bO\u0010PJ!\u0010S\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u00103\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0006H\u0016¢\u0006\u0004\bU\u0010\u0003R\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010h\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010cR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010nR\u0018\u0010u\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010nR\u0018\u0010x\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u001d\u0010~\u001a\u0004\u0018\u00010y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010nR\u0018\u0010\u0085\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010nR\u0018\u0010\u0087\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010nR\u0018\u0010\u0089\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010n¨\u0006\u008b\u0001"}, d2 = {"Lcom/transsion/share/share/ShareDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "B0", "(Landroid/view/View;)V", "", "Ljr/a;", "q0", "()Ljava/util/List;", "initViewModel", "shareData", "w0", "(Ljr/a;)V", "Lcom/transsion/share/bean/ShareBean;", "shareBean", "A0", "(Lcom/transsion/share/bean/ShareBean;)V", "", "", "permissions", "", "r0", "([Ljava/lang/String;)Z", "M0", PushConstants.PROVIDER_FIELD_PKG, "Landroid/app/Activity;", "activity", "shortUrl", CampaignEx.JSON_KEY_DESC, CampaignEx.JSON_KEY_TITLE, "H0", "(Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/transsion/share/bean/ShareType;", "shareType", "u0", "(Lcom/transsion/share/bean/ShareType;)Lcom/transsion/share/bean/ShareBean;", "o0", "()Ljava/lang/String;", "p0", "n0", EventConstants.KEY_ACTION, "failMsg", "s0", "(Ljava/lang/String;Ljava/lang/String;)V", "v0", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "tag", "L0", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "x0", "Lcom/transsion/share/share/a;", "callback", "G0", "(Lcom/transsion/share/share/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroy", "", "requestCode", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onPause", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/content/Context;", "context", "K0", "(Landroid/content/Context;Ljava/lang/String;)V", TmcConstants.NAVIGATION_ON_START, "Lir/b;", "a", "Lir/b;", "actionViewModel", "Landroidx/recyclerview/widget/RecyclerView;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroidx/recyclerview/widget/RecyclerView;", "shareList", "", "c", "J", "shareDataStartTime", "d", "Z", "isDelete", "e", "isDownload", "f", "isCheckOut", "Lcom/transsion/share/bean/PostType;", g.f16474b, "Lcom/transsion/share/bean/PostType;", "postType", "h", "Ljava/lang/String;", "authorId", "i", "reportType", j.f35620b, "ops", CampaignEx.JSON_KEY_AD_K, "downloadName", "l", "Lcom/transsion/share/share/a;", "shareItemCallback", "Lhj/b;", "m", "Lkotlin/Lazy;", "getLogViewConfig", "()Lhj/b;", "logViewConfig", "n", "Ljr/a;", "mShareData", "o", "mSubjectId", TtmlNode.TAG_P, "mShareTitle", CampaignEx.JSON_KEY_AD_Q, "mShareScore", CampaignEx.JSON_KEY_AD_R, "mSource", "s", "ShareLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShareDialogFragment extends DialogFragment {

    /* renamed from: s, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private ir.b actionViewModel;

    /* renamed from: b */
    private RecyclerView shareList;

    /* renamed from: c, reason: from kotlin metadata */
    private long shareDataStartTime;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isDelete;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isDownload;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean isCheckOut;

    /* renamed from: g */
    private PostType postType;

    /* renamed from: h, reason: from kotlin metadata */
    private String authorId;

    /* renamed from: i, reason: from kotlin metadata */
    private String reportType;

    /* renamed from: j */
    private String ops;

    /* renamed from: k */
    private String downloadName;

    /* renamed from: l, reason: from kotlin metadata */
    private a shareItemCallback;

    /* renamed from: m, reason: from kotlin metadata */
    private final Lazy logViewConfig;

    /* renamed from: n, reason: from kotlin metadata */
    private jr.a mShareData;

    /* renamed from: o, reason: from kotlin metadata */
    private String mSubjectId;

    /* renamed from: p */
    private String mShareTitle;

    /* renamed from: q */
    private String mShareScore;

    /* renamed from: r */
    private String mSource;

    /* renamed from: com.transsion.share.share.ShareDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ShareDialogFragment b(Companion companion, PostType postType, String str, String str2, String str3, String str4, String str5, boolean z10, boolean z11, boolean z12, String str6, String str7, String str8, int i11, Object obj) {
            return companion.a(postType, str, str2, str3, (i11 & 16) != 0 ? "" : str4, (i11 & 32) != 0 ? "" : str5, (i11 & 64) != 0 ? false : z10, (i11 & 128) != 0 ? false : z11, (i11 & 256) != 0 ? false : z12, str6, (i11 & 1024) != 0 ? "" : str7, (i11 & 2048) != 0 ? "" : str8);
        }

        public final ShareDialogFragment a(PostType postType, String str, String str2, String reportType, String str3, String str4, boolean z10, boolean z11, boolean z12, String source, String str5, String str6) {
            Intrinsics.h(postType, "postType");
            Intrinsics.h(reportType, "reportType");
            Intrinsics.h(source, "source");
            ShareDialogFragment shareDialogFragment = new ShareDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("postType", postType);
            bundle.putString("subjectId", str);
            bundle.putBoolean("subject_delete", z11);
            bundle.putBoolean("subject_download", z10);
            bundle.putBoolean("subject_checkout", z12);
            bundle.putString("share_title", str3);
            bundle.putString("share_score", str4);
            bundle.putString(EventConstants.KEY_SOURCE, source);
            bundle.putString("author_id", str2);
            bundle.putString("report_type", reportType);
            bundle.putString("ops", str5);
            bundle.putString("download_name", str6);
            shareDialogFragment.setArguments(bundle);
            return shareDialogFragment;
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f52619a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f52620b;

        static {
            int[] iArr = new int[ShareType.values().length];
            try {
                iArr[ShareType.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShareType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShareType.COPY_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShareType.WHATSAPP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ShareType.TELEGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ShareType.CHECKOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f52619a = iArr;
            int[] iArr2 = new int[PostType.values().length];
            try {
                iArr2[PostType.POST_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PostType.SUBJECT_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[PostType.GROUP_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[PostType.STAFF_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[PostType.SHORT_TV_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[PostType.LIVE_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[PostType.UGC_VIDEO.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[PostType.UGC_SHORT_TV.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            f52620b = iArr2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements kr.a {
        c() {
        }

        @Override // kr.a
        public void a(jr.a shareData) {
            Intrinsics.h(shareData, "shareData");
            ShareDialogFragment.this.mShareData = shareData;
            if (shareData.c() == ShareType.DELETE) {
                if (!m.f70597a.e()) {
                    hr.a aVar = hr.a.f64948a;
                    String string = ShareDialogFragment.this.getString(R$string.player_no_network_tip2);
                    Intrinsics.g(string, "getString(...)");
                    aVar.f(string);
                    return;
                }
                a aVar2 = ShareDialogFragment.this.shareItemCallback;
                if (aVar2 != null) {
                    aVar2.a(ShareDialogFragment.this.mSubjectId, ShareDialogFragment.this.postType);
                }
                ShareDialogFragment.t0(ShareDialogFragment.this, RequestParameters.SUBRESOURCE_DELETE, null, 2, null);
                ShareDialogFragment.this.dismiss();
                return;
            }
            if (shareData.c() == ShareType.DOWNLOAD) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ShareDialogFragment.this.w0(shareData);
                    return;
                }
                ShareDialogFragment shareDialogFragment = ShareDialogFragment.this;
                o oVar = o.f68507a;
                if (shareDialogFragment.r0(oVar.c())) {
                    ShareDialogFragment.this.w0(shareData);
                    return;
                } else {
                    ShareDialogFragment.this.requestPermissions(oVar.c(), 11);
                    return;
                }
            }
            if (shareData.c() == ShareType.CHECKOUT) {
                a aVar3 = ShareDialogFragment.this.shareItemCallback;
                if (aVar3 != null) {
                    aVar3.d(ShareDialogFragment.this.mSubjectId);
                }
                ShareDialogFragment.t0(ShareDialogFragment.this, "checkout", null, 2, null);
                ShareDialogFragment.this.dismiss();
                return;
            }
            if (shareData.c() != ShareType.REPORT) {
                ShareDialogFragment.this.w0(shareData);
                return;
            }
            ShareDialogFragment.t0(ShareDialogFragment.this, "report", null, 2, null);
            hr.a aVar4 = hr.a.f64948a;
            Context requireContext = ShareDialogFragment.this.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            aVar4.e(requireContext, ShareDialogFragment.this.reportType, ShareDialogFragment.this.mSubjectId, ShareDialogFragment.this.shareItemCallback);
            ShareDialogFragment.this.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements c0, FunctionAdapter {

        /* renamed from: a */
        private final /* synthetic */ Function1 f52622a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f52622a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f52622a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f52622a.invoke(obj);
        }
    }

    public ShareDialogFragment() {
        super(R$layout.player_share_dialog);
        this.logViewConfig = LazyKt.b(new Function0() { // from class: kr.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                hj.b E0;
                E0 = ShareDialogFragment.E0();
                return E0;
            }
        });
        this.mSubjectId = "";
        this.mShareTitle = "";
        this.mShareScore = "";
        this.mSource = "";
    }

    private final void A0(ShareBean shareBean) {
        FragmentActivity activity;
        FragmentActivity activity2;
        ShareType shareType = shareBean != null ? shareBean.getShareType() : null;
        switch (shareType == null ? -1 : b.f52619a[shareType.ordinal()]) {
            case 1:
                a aVar = this.shareItemCallback;
                if (aVar != null) {
                    a.C0650a.a(aVar, this.mSubjectId, null, 2, null);
                }
                t0(this, "delete ", null, 2, null);
                dismiss();
                return;
            case 2:
                a aVar2 = this.shareItemCallback;
                if (aVar2 != null) {
                    aVar2.c(shareBean.getDownUrl(), shareBean.getTitle(), "", shareBean.getCoverUrl());
                }
                t0(this, "download", null, 2, null);
                dismiss();
                return;
            case 3:
                String shortUrl = shareBean.getShortUrl();
                if (shortUrl != null) {
                    ClipData newPlainText = ClipData.newPlainText("Simple test", shortUrl);
                    Context context = getContext();
                    Object systemService = context != null ? context.getSystemService("clipboard") : null;
                    Intrinsics.f(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(newPlainText);
                    hr.a aVar3 = hr.a.f64948a;
                    String string = getString(R$string.player_copy_link_success);
                    Intrinsics.g(string, "getString(...)");
                    aVar3.f(string);
                    dismiss();
                }
                a aVar4 = this.shareItemCallback;
                if (aVar4 != null) {
                    aVar4.e(this.mSubjectId);
                }
                t0(this, "copylink", null, 2, null);
                return;
            case 4:
                String shortUrl2 = shareBean.getShortUrl();
                if (shortUrl2 != null && (activity = getActivity()) != null) {
                    H0("com.whatsapp", activity, shortUrl2, shareBean.getDesc(), shareBean.getTitle());
                }
                a aVar5 = this.shareItemCallback;
                if (aVar5 != null) {
                    aVar5.e(this.mSubjectId);
                }
                t0(this, "whatsup", null, 2, null);
                return;
            case 5:
                String shortUrl3 = shareBean.getShortUrl();
                if (shortUrl3 != null && (activity2 = getActivity()) != null) {
                    H0("org.telegram.messenger", activity2, shortUrl3, shareBean.getDesc(), shareBean.getTitle());
                }
                a aVar6 = this.shareItemCallback;
                if (aVar6 != null) {
                    aVar6.e(this.mSubjectId);
                }
                t0(this, "Telegram", null, 2, null);
                return;
            case 6:
                a aVar7 = this.shareItemCallback;
                if (aVar7 != null) {
                    aVar7.d(this.mSubjectId);
                }
                t0(this, "checkout", null, 2, null);
                return;
            default:
                return;
        }
    }

    private final void B0(View r52) {
        View findViewById = r52.findViewById(R$id.iv_close);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: kr.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareDialogFragment.C0(ShareDialogFragment.this, view);
                }
            });
        }
        this.shareList = (RecyclerView) r52.findViewById(R$id.share_list);
        kr.c cVar = new kr.c(q0());
        RecyclerView recyclerView = this.shareList;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(r52.getContext(), 0, false));
            recyclerView.setAdapter(cVar);
        }
        cVar.k(new c());
    }

    public static final void C0(ShareDialogFragment shareDialogFragment, View view) {
        shareDialogFragment.dismiss();
    }

    public static final Unit D0(ShareDialogFragment shareDialogFragment, ShareBean shareBean) {
        ShareType c11;
        if (shareBean != null) {
            shareDialogFragment.A0(shareBean);
            return Unit.f67184a;
        }
        jr.a aVar = shareDialogFragment.mShareData;
        shareDialogFragment.A0((aVar == null || (c11 = aVar.c()) == null) ? null : shareDialogFragment.u0(c11));
        return Unit.f67184a;
    }

    public static final hj.b E0() {
        return new hj.b("share_panel", false, 2, null);
    }

    public static final void F0(ShareDialogFragment shareDialogFragment) {
        shareDialogFragment.x0();
    }

    private final void H0(String r32, Activity activity, String shortUrl, String r62, String r72) {
        if (!TextUtils.isEmpty(r62)) {
            shortUrl = r62 + "\n" + shortUrl;
        }
        if (!TextUtils.isEmpty(r72)) {
            shortUrl = r72 + "\n" + shortUrl;
        }
        if (TextUtils.equals(r32, "com.whatsapp")) {
            p.f68511a.d(activity, shortUrl, new Function1() { // from class: kr.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit I0;
                    I0 = ShareDialogFragment.I0(ShareDialogFragment.this, ((Boolean) obj).booleanValue());
                    return I0;
                }
            });
        } else if (TextUtils.equals(r32, "org.telegram.messenger")) {
            p.f68511a.c(activity, shortUrl, new Function1() { // from class: kr.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit J0;
                    J0 = ShareDialogFragment.J0(ShareDialogFragment.this, ((Boolean) obj).booleanValue());
                    return J0;
                }
            });
        }
    }

    public static final Unit I0(ShareDialogFragment shareDialogFragment, boolean z10) {
        if (z10) {
            shareDialogFragment.dismissAllowingStateLoss();
        } else {
            hr.a aVar = hr.a.f64948a;
            String string = shareDialogFragment.getString(R$string.tip_app_not_install);
            Intrinsics.g(string, "getString(...)");
            aVar.f(string);
        }
        return Unit.f67184a;
    }

    public static final Unit J0(ShareDialogFragment shareDialogFragment, boolean z10) {
        if (z10) {
            shareDialogFragment.dismissAllowingStateLoss();
        } else {
            hr.a aVar = hr.a.f64948a;
            String string = shareDialogFragment.getString(R$string.tip_app_not_install);
            Intrinsics.g(string, "getString(...)");
            aVar.f(string);
        }
        return Unit.f67184a;
    }

    private final void L0(FragmentManager fragmentManager, String tag) {
        try {
            fragmentManager.g0();
            if (!isAdded() && fragmentManager.k0(tag) == null) {
                show(fragmentManager, tag);
            }
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    private final void M0() {
        String string = getString(R$string.permission_deny_down_tip, "\"" + hr.a.f64948a.b() + "\"", "\"" + getString(R$string.system_settings) + "\"");
        Intrinsics.g(string, "getString(...)");
        o oVar = o.f68507a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        oVar.f(requireContext, "", string, new Function0() { // from class: kr.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit N0;
                N0 = ShareDialogFragment.N0(ShareDialogFragment.this);
                return N0;
            }
        });
    }

    public static final Unit N0(ShareDialogFragment shareDialogFragment) {
        o oVar = o.f68507a;
        FragmentActivity activity = shareDialogFragment.getActivity();
        if (activity == null) {
            return Unit.f67184a;
        }
        o.j(oVar, activity, 0, 2, null);
        return Unit.f67184a;
    }

    private final hj.b getLogViewConfig() {
        return (hj.b) this.logViewConfig.getValue();
    }

    private final void initViewModel() {
        ir.b bVar = (ir.b) new v0(this).a(ir.b.class);
        bVar.g().j(getViewLifecycleOwner(), new d(new Function1() { // from class: kr.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D0;
                D0 = ShareDialogFragment.D0(ShareDialogFragment.this, (ShareBean) obj);
                return D0;
            }
        }));
        this.actionViewModel = bVar;
    }

    private final String n0() {
        PostType postType = this.postType;
        switch (postType == null ? -1 : b.f52620b[postType.ordinal()]) {
            case 1:
                return "/post/detail";
            case 2:
                return "/movie/detail";
            case 3:
                return "/room/detail";
            case 4:
                return "/movie/staff";
            case 5:
                return "/shorts/detail";
            case 6:
                return "/live/detail";
            case 7:
                return "/ugc_video/detail";
            case 8:
                return "/ugc_shorts/detail";
            default:
                return "";
        }
    }

    private final String o0() {
        String string;
        PostType postType = this.postType;
        int i11 = postType == null ? -1 : b.f52620b[postType.ordinal()];
        if (i11 == 1) {
            Context context = getContext();
            string = context != null ? context.getString(R$string.share_long_link_post_s) : null;
            Intrinsics.e(string);
            return string;
        }
        if (i11 == 2) {
            Context context2 = getContext();
            string = context2 != null ? context2.getString(R$string.share_long_link_sub_no_duration, this.mShareTitle, this.mShareScore) : null;
            Intrinsics.e(string);
            return string;
        }
        if (i11 != 3) {
            return "";
        }
        Context context3 = getContext();
        string = context3 != null ? context3.getString(R$string.share_long_link_group_s) : null;
        Intrinsics.e(string);
        return string;
    }

    private final String p0() {
        String c11 = hr.a.f64948a.c();
        if (TextUtils.isEmpty(c11)) {
            c11 = "0";
        }
        String b11 = vg.a.f77447a.b();
        String n02 = n0();
        Context context = getContext();
        String packageName = context != null ? context.getPackageName() : null;
        String str = b11 + "?type=" + n02 + "&package_name=" + packageName + "&id=" + this.mSubjectId + "&uid=" + c11;
        a.C0856a.f(lg.a.f68962a, "ShareDialogFragment", "share long link:" + str, false, 4, null);
        return str;
    }

    private final List q0() {
        String str;
        String string;
        ArrayList arrayList = new ArrayList();
        ShareType shareType = ShareType.WHATSAPP;
        int i11 = R$mipmap.share_ic_whatsapp;
        String string2 = getString(R$string.player_whatsapp);
        Intrinsics.g(string2, "getString(...)");
        arrayList.add(new jr.a(shareType, i11, string2));
        ShareType shareType2 = ShareType.TELEGRAM;
        int i12 = R$mipmap.share_ic_telegram;
        String string3 = getString(R$string.player_telegram);
        Intrinsics.g(string3, "getString(...)");
        arrayList.add(new jr.a(shareType2, i12, string3));
        ShareType shareType3 = ShareType.COPY_LINK;
        int i13 = R$mipmap.share_ic_copy_link;
        String string4 = getString(R$string.share_copy_link);
        Intrinsics.g(string4, "getString(...)");
        arrayList.add(new jr.a(shareType3, i13, string4));
        if (this.isDownload) {
            String str2 = this.downloadName;
            if (str2 == null || str2.length() == 0) {
                string = getString(R$string.player_download);
            } else {
                string = this.downloadName;
                if (string == null) {
                    string = getString(R$string.player_download);
                    Intrinsics.g(string, "getString(...)");
                }
            }
            Intrinsics.e(string);
            arrayList.add(new jr.a(ShareType.DOWNLOAD, R$mipmap.share_ic_download, string));
        }
        if (this.isDelete) {
            ShareType shareType4 = ShareType.DELETE;
            int i14 = R$mipmap.share_ic_delete;
            String string5 = getString(R$string.player_delete);
            Intrinsics.g(string5, "getString(...)");
            arrayList.add(new jr.a(shareType4, i14, string5));
        }
        if (this.isCheckOut) {
            ShareType shareType5 = ShareType.CHECKOUT;
            int i15 = R$mipmap.share_ic_checkout;
            String string6 = getString(R$string.player_check_out);
            Intrinsics.g(string6, "getString(...)");
            arrayList.add(new jr.a(shareType5, i15, string6));
        }
        if (!Intrinsics.c(hr.a.f64948a.c(), this.authorId) && (str = this.reportType) != null && str.length() != 0) {
            ShareType shareType6 = ShareType.REPORT;
            int i16 = R$mipmap.share_ic_report;
            String string7 = getString(R$string.player_report);
            Intrinsics.g(string7, "getString(...)");
            arrayList.add(new jr.a(shareType6, i16, string7));
        }
        return arrayList;
    }

    public final boolean r0(String[] permissions) {
        return PermissionUtils.s((String[]) Arrays.copyOf(permissions, permissions.length));
    }

    private final void s0(String r32, String failMsg) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", r32);
        if (failMsg != null) {
        }
        hashMap.put(v0(), this.mSubjectId);
        String str = this.ops;
        if (str == null) {
            str = "";
        }
        hashMap.put("ops", str);
        i.f64628a.p("share_panel", hashMap);
    }

    static /* synthetic */ void t0(ShareDialogFragment shareDialogFragment, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        shareDialogFragment.s0(str, str2);
    }

    private final ShareBean u0(ShareType shareType) {
        ShareBean shareBean = new ShareBean();
        shareBean.setShareType(shareType);
        shareBean.setShortUrl(p0());
        shareBean.setDesc(o0());
        return shareBean;
    }

    private final String v0() {
        String str = this.mSource;
        switch (str.hashCode()) {
            case -1348386821:
                return !str.equals("UGCVideoDetail") ? "post_id" : "ugc_video_id";
            case 584244349:
                return !str.equals("subjectdetail") ? "post_id" : "subject_id";
            case 1232204688:
                return !str.equals("groupdetail") ? "post_id" : "group_id";
            case 2036233184:
                return !str.equals("usercenter") ? "post_id" : "host_uid";
            case 2092022001:
                str.equals("postdetail");
                return "post_id";
            default:
                return "post_id";
        }
    }

    public final void w0(jr.a shareData) {
        String str;
        if (shareData == null) {
            return;
        }
        m mVar = m.f70597a;
        if (!mVar.e() && (shareData.c() == ShareType.DELETE || shareData.c() == ShareType.DOWNLOAD)) {
            hr.a aVar = hr.a.f64948a;
            String string = getString(R$string.player_no_network_tip2);
            Intrinsics.g(string, "getString(...)");
            aVar.f(string);
            return;
        }
        if (!mVar.e()) {
            A0(u0(shareData.c()));
            return;
        }
        this.shareDataStartTime = System.currentTimeMillis();
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = arguments.getString("subjectId")) == null) {
            str = "";
        }
        this.mSubjectId = str;
        String c11 = hr.a.f64948a.c();
        if (TextUtils.isEmpty(c11)) {
            c11 = "0";
        }
        if (shareData.c() == ShareType.TELEGRAM) {
            str2 = "Telegram";
        } else if (shareData.c() == ShareType.WHATSAPP) {
            str2 = "WhatsApp";
        }
        String str3 = str2;
        ir.b bVar = this.actionViewModel;
        if (bVar != null) {
            bVar.h(shareData.c(), n0(), this.mSubjectId, c11 == null ? "0" : c11, str3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void x0() {
        /*
            r11 = this;
            android.app.Dialog r0 = r11.getDialog()
            if (r0 == 0) goto Lc8
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto Le
            goto Lc8
        Le:
            android.view.View r0 = r0.getDecorView()
            if (r0 != 0) goto L15
            return
        L15:
            android.view.View r1 = r11.getView()
            if (r1 != 0) goto L1c
            return
        L1c:
            android.content.Context r2 = r11.requireContext()
            java.lang.String r3 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)
            int r2 = com.blankj.utilcode.util.d.a()
            boolean r3 = r1 instanceof android.view.ViewGroup
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L56
            r6 = r1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r6.setFitsSystemWindows(r5)
            android.graphics.drawable.Drawable r7 = r6.getBackground()
            if (r7 != 0) goto L56
            int r7 = r6.getChildCount()
            if (r7 <= 0) goto L46
            android.view.View r7 = r6.getChildAt(r5)
            goto L47
        L46:
            r7 = r4
        L47:
            if (r7 == 0) goto L53
            android.graphics.drawable.Drawable r7 = r7.getBackground()
            if (r7 == 0) goto L53
            r6.setBackground(r7)
            goto L56
        L53:
            r1.setBackgroundColor(r5)
        L56:
            kr.k r6 = new kr.k
            r6.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r0, r6)
            if (r2 <= 0) goto Lbb
            if (r3 == 0) goto L78
            r6 = r1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            int r7 = r6.getChildCount()
            if (r7 <= 0) goto L78
            android.view.View r6 = r6.getChildAt(r5)
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L76
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            goto L7d
        L76:
            r6 = r4
            goto L7d
        L78:
            if (r3 == 0) goto L76
            r6 = r1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
        L7d:
            if (r6 == 0) goto L9c
            int r7 = r6.getPaddingLeft()
            int r8 = r6.getPaddingTop()
            int r9 = r6.getPaddingRight()
            int r10 = r6.getPaddingBottom()
            if (r10 >= r2) goto L92
            goto L93
        L92:
            r2 = r10
        L93:
            int r10 = r6.getPaddingBottom()
            if (r10 == r2) goto L9c
            r6.setPadding(r7, r8, r9, r2)
        L9c:
            if (r3 == 0) goto Lbb
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            android.graphics.drawable.Drawable r2 = r1.getBackground()
            if (r2 != 0) goto Lbb
            int r2 = r1.getChildCount()
            if (r2 <= 0) goto Lb0
            android.view.View r4 = r1.getChildAt(r5)
        Lb0:
            if (r4 == 0) goto Lbb
            android.graphics.drawable.Drawable r2 = r4.getBackground()
            if (r2 == 0) goto Lbb
            r1.setBackground(r2)
        Lbb:
            androidx.core.view.ViewCompat.requestApplyInsets(r0)
            kr.l r1 = new kr.l
            r1.<init>()
            r2 = 100
            r0.postDelayed(r1, r2)
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.share.share.ShareDialogFragment.x0():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.core.view.WindowInsetsCompat y0(int r4, android.view.View r5, android.view.View r6, androidx.core.view.WindowInsetsCompat r7) {
        /*
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.h(r6, r0)
            java.lang.String r0 = "insets"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            int r0 = androidx.core.view.WindowInsetsCompat.Type.navigationBars()
            z0.c r0 = r7.getInsets(r0)
            java.lang.String r1 = "getInsets(...)"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            int r2 = androidx.core.view.WindowInsetsCompat.Type.systemGestures()
            z0.c r2 = r7.getInsets(r2)
            kotlin.jvm.internal.Intrinsics.g(r2, r1)
            int r0 = r0.f79251d
            r1 = 0
            if (r0 <= 0) goto L29
        L27:
            r4 = r0
            goto L32
        L29:
            int r0 = r2.f79251d
            if (r0 <= 0) goto L2e
            goto L27
        L2e:
            if (r4 <= 0) goto L31
            goto L32
        L31:
            r4 = r1
        L32:
            r6.setPadding(r1, r1, r1, r1)
            if (r4 <= 0) goto L75
            boolean r6 = r5 instanceof android.view.ViewGroup
            r0 = 0
            if (r6 == 0) goto L51
            r2 = r5
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r3 = r2.getChildCount()
            if (r3 <= 0) goto L51
            android.view.View r5 = r2.getChildAt(r1)
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto L56
            r0 = r5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L56
        L51:
            if (r6 == 0) goto L56
            r0 = r5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L56:
            if (r0 == 0) goto L75
            int r5 = r0.getPaddingLeft()
            int r6 = r0.getPaddingTop()
            int r1 = r0.getPaddingRight()
            int r2 = r0.getPaddingBottom()
            if (r2 >= r4) goto L6b
            goto L6c
        L6b:
            r4 = r2
        L6c:
            int r2 = r0.getPaddingBottom()
            if (r2 == r4) goto L75
            r0.setPadding(r5, r6, r1, r4)
        L75:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.share.share.ShareDialogFragment.y0(int, android.view.View, android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
    }

    public static final void z0(View view) {
        ViewCompat.requestApplyInsets(view);
    }

    public final void G0(a callback) {
        Intrinsics.h(callback, "callback");
        this.shareItemCallback = callback;
    }

    public final void K0(Context context, String tag) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                L0(supportFragmentManager, tag);
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.shareDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.share_dialog_animations);
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = -1;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || !logViewConfig.d()) {
            return;
        }
        i.f64628a.B(logViewConfig);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 11) {
            if (!o.f68507a.k(grantResults)) {
                M0();
                return;
            }
            jr.a aVar = this.mShareData;
            if (aVar != null) {
                w0(aVar);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.o(SystemClock.elapsedRealtime());
            if (logViewConfig.c()) {
                i.f64628a.C(logViewConfig);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog;
        Window window;
        super.onStart();
        if (Build.VERSION.SDK_INT < 35 || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setNavigationBarColor(0);
        window.setStatusBarColor(0);
        window.getDecorView().post(new Runnable() { // from class: kr.i
            @Override // java.lang.Runnable
            public final void run() {
                ShareDialogFragment.F0(ShareDialogFragment.this);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r52, Bundle savedInstanceState) {
        String str;
        Intrinsics.h(r52, "view");
        super.onViewCreated(r52, savedInstanceState);
        Bundle arguments = getArguments();
        this.isDelete = arguments != null && arguments.getBoolean("subject_delete");
        Bundle arguments2 = getArguments();
        this.isDownload = arguments2 != null && arguments2.getBoolean("subject_download");
        Bundle arguments3 = getArguments();
        this.isCheckOut = arguments3 != null && arguments3.getBoolean("subject_checkout");
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str = arguments4.getString("subjectId")) == null) {
            str = "";
        }
        this.mSubjectId = str;
        Bundle arguments5 = getArguments();
        this.postType = (PostType) (arguments5 != null ? arguments5.getSerializable("postType") : null);
        Bundle arguments6 = getArguments();
        this.mShareTitle = String.valueOf(arguments6 != null ? arguments6.getString("share_title") : null);
        Bundle arguments7 = getArguments();
        this.mShareScore = String.valueOf(arguments7 != null ? arguments7.getString("share_score") : null);
        Bundle arguments8 = getArguments();
        this.mSource = String.valueOf(arguments8 != null ? arguments8.getString(EventConstants.KEY_SOURCE) : null);
        Bundle arguments9 = getArguments();
        this.authorId = arguments9 != null ? arguments9.getString("author_id") : null;
        Bundle arguments10 = getArguments();
        this.reportType = arguments10 != null ? arguments10.getString("report_type") : null;
        Bundle arguments11 = getArguments();
        this.ops = arguments11 != null ? arguments11.getString("ops") : null;
        Bundle arguments12 = getArguments();
        this.downloadName = arguments12 != null ? arguments12.getString("download_name") : null;
        B0(r52);
        initViewModel();
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.l(false);
        }
    }
}
