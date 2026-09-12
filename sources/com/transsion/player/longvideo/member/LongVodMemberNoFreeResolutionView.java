package com.transsion.player.longvideo.member;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.OpType;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.R$string;
import com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ok.b;
import zm.a;

@Deprecated
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ!\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/transsion/player/longvideo/member/LongVodMemberNoFreeResolutionView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getClassTag", "()Ljava/lang/String;", "", "c", "()V", "d", "Lgo/a;", "bean", "pageName", "showCover", "(Lgo/a;Ljava/lang/String;)V", "Lzm/b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lzm/b;)V", "a", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lgo/a;", "Lzm/b;", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LongVodMemberNoFreeResolutionView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private go.a bean;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private zm.b listener;

    /* loaded from: classes6.dex */
    public static final class a implements zm.a {

        /* renamed from: com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0638a implements zm.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ LongVodMemberNoFreeResolutionView f48234a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppCompatActivity f48235b;

            /* renamed from: com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public static final class C0639a implements zx.e {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ LongVodMemberNoFreeResolutionView f48236a;

                C0639a(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView) {
                    this.f48236a = longVodMemberNoFreeResolutionView;
                }

                @Override // zx.e
                public void a(boolean z10) {
                    if (z10) {
                        this.f48236a.d();
                    }
                }
            }

            C0638a(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView, AppCompatActivity appCompatActivity) {
                this.f48234a = longVodMemberNoFreeResolutionView;
                this.f48235b = appCompatActivity;
            }

            @Override // zm.b
            public void a() {
                k.f48279a.a(this.f48234a.getClassTag() + " --> llUnlockBtn{} --> ka开通会员失败 --> 商业化逻辑");
                ResolutionMemberManager resolutionMemberManager = ResolutionMemberManager.f48259a;
                FragmentManager supportFragmentManager = this.f48235b.getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                resolutionMemberManager.h(supportFragmentManager, MemberSource.SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR, this.f48234a.bean, this.f48234a.pageName, new C0639a(this.f48234a));
            }

            @Override // zm.b
            public void onSuccess() {
                this.f48234a.d();
                k.f48279a.a(this.f48234a.getClassTag() + " --> llUnlockBtn{} --> ka开通会员成功");
            }
        }

        /* loaded from: classes6.dex */
        public static final class b implements ok.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ LongVodMemberNoFreeResolutionView f48237a;

            b(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView) {
                this.f48237a = longVodMemberNoFreeResolutionView;
            }

            @Override // ok.b
            public void a(boolean z10) {
                b.a.a(this, z10);
            }

            @Override // ok.b
            public void onFail() {
                k.f48279a.a(this.f48237a.getClassTag() + " --> llUnlockBtn{} --> 三合一弹窗 失败");
            }

            @Override // ok.b
            public void onSuccess() {
                this.f48237a.d();
                k.f48279a.a(this.f48237a.getClassTag() + " --> showTreasureDialog() --> 三合一弹窗 成功");
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView, Object obj) {
            ok.c.f71157a.a(longVodMemberNoFreeResolutionView.getClassTag() + " --> checkMemberRights() --> sceneType = MemberSceneType.SCENE_PREDL --> success");
            return Unit.f67184a;
        }

        @Override // zm.a
        public void a(MemberCheckResult memberCheckResult) {
            Context context = LongVodMemberNoFreeResolutionView.this.getContext();
            AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
            if (appCompatActivity != null) {
                LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView = LongVodMemberNoFreeResolutionView.this;
                IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
                if (iMemberApi != null) {
                    IMemberApi.a.c(iMemberApi, appCompatActivity, MemberSource.SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR, new C0638a(longVodMemberNoFreeResolutionView, appCompatActivity), false, null, 24, null);
                }
            }
        }

        @Override // zm.a
        public void b(MemberCheckResult memberCheckResult) {
            a.C1007a.d(this, memberCheckResult);
        }

        @Override // zm.a
        public void c(MemberCheckResult memberCheckResult) {
            a.C1007a.g(this, memberCheckResult);
            ITaskCenterApi iTaskCenterApi = (ITaskCenterApi) TheRouter.d(ITaskCenterApi.class, new Object[0]);
            if (iTaskCenterApi != null) {
                iTaskCenterApi.d("", memberCheckResult, new b(LongVodMemberNoFreeResolutionView.this));
            }
        }

        @Override // zm.a
        public void d(MemberCheckResult memberCheckResult) {
            a.C1007a.e(this, memberCheckResult);
        }

        @Override // zm.a
        public void e() {
            LongVodMemberNoFreeResolutionView.this.d();
            ok.c.f71157a.a(LongVodMemberNoFreeResolutionView.this.getClassTag() + " --> checkMemberRights() --> passed() --> 会员权益通过验证 --> 继续下载任务");
            IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
            if (iMemberApi != null) {
                OpType opType = OpType.OP_DOWNLOAD;
                final LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView = LongVodMemberNoFreeResolutionView.this;
                iMemberApi.n(opType, new Function1() { // from class: com.transsion.player.longvideo.member.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit h11;
                        h11 = LongVodMemberNoFreeResolutionView.a.h(LongVodMemberNoFreeResolutionView.this, obj);
                        return h11;
                    }
                });
            }
        }

        @Override // zm.a
        public void f(MemberCheckResult memberCheckResult) {
            a.C1007a.a(this, memberCheckResult);
            ok.c.f71157a.b(LongVodMemberNoFreeResolutionView.this.getClassTag() + " --> triggerDownload() --> showCheckMemberRights() --> notImplement() --> 当前类型没有实现");
        }

        @Override // zm.a
        public void onFail(String errorMsg) {
            Intrinsics.h(errorMsg, "errorMsg");
            a.C1007a.b(this, errorMsg);
            ok.c.f71157a.b(LongVodMemberNoFreeResolutionView.this.getClassTag() + " --> checkMemberRights() --> showCheckMemberRightsDialog() --> " + errorMsg);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public LongVodMemberNoFreeResolutionView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LongVodMemberNoFreeResolutionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R$layout.long_vod_member_no_free_resolution_view, (ViewGroup) this, false);
        addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R$id.tvUnlockTip);
        if (textView != null) {
            String string = context.getString(R$string.long_vod_unlock_720p_up_quality_with_premium, q.f48287a.d());
            Intrinsics.g(string, "getString(...)");
            textView.setText(string);
        }
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.llUnlockBtn);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongVodMemberNoFreeResolutionView.b(LongVodMemberNoFreeResolutionView.this, view);
                }
            });
        }
    }

    public /* synthetic */ LongVodMemberNoFreeResolutionView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView, View view) {
        ok.c.f71157a.a(longVodMemberNoFreeResolutionView.getClassTag() + " --> llUnlockBtn{} --> 开通会员按钮点击");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "clarity_unlock");
        go.a aVar = longVodMemberNoFreeResolutionView.bean;
        linkedHashMap.put("subject_id", aVar != null ? aVar.o() : null);
        hj.i iVar = hj.i.f64628a;
        String str = longVodMemberNoFreeResolutionView.pageName;
        if (str == null) {
            str = "vip_resolution";
        }
        iVar.p(str, linkedHashMap);
        longVodMemberNoFreeResolutionView.c();
    }

    private final void c() {
        ok.c.f71157a.a(getClassTag() + " --> showDialog() --> 接口校验 --> sceneType = " + MemberSceneType.SCENE_PREDL);
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.z(MemberSceneType.SCENE_START_RESOLUTION, 0, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new LongVodMemberNoFreeResolutionView$unlock$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = LongVodMemberNoFreeResolutionView.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void setListener(zm.b listener) {
        this.listener = listener;
    }

    public final void showCover(go.a bean, String pageName) {
        setVisibility(0);
        this.bean = bean;
        this.pageName = pageName;
        ImageView imageView = (ImageView) findViewById(R$id.ivCover);
        if (imageView != null) {
            f.a aVar = ej.f.f62005a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(bean != null ? bean.c() : null).k(true).a(6).d(imageView);
        }
    }
}
