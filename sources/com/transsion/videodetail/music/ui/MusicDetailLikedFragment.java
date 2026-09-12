package com.transsion.videodetail.music.ui;

import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.videodetail.music.bean.MusicLikedUITypeEnum;
import com.transsion.videodetail.music.widget.MusicLikedListEmptyView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0016\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001e\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\"\u0010!J\u0019\u0010#\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b#\u0010!J\u0019\u0010$\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b$\u0010!J\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0003J\u0015\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*JM\u0010/\u001a\u00020\b2>\b\u0002\u0010.\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b\u0018\u00010+¢\u0006\u0004\b/\u00100JQ\u00103\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000628\u00102\u001a4\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\b\u0018\u00010+¢\u0006\u0004\b3\u00104RH\u00107\u001a4\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\b\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109RL\u0010<\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00106R\u0018\u0010?\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/transsion/videodetail/music/ui/MusicDetailLikedFragment;", "Lcom/transsion/videodetail/music/ui/BaseMusicLikedFragment;", "<init>", "()V", "Lao/e;", "mediaSource", "", "from", "", "M0", "(Lao/e;Ljava/lang/String;)V", "Lcom/transsion/videodetail/music/bean/MusicLikedUITypeEnum;", "x0", "()Lcom/transsion/videodetail/music/bean/MusicLikedUITypeEnum;", "initViewData", "loadDefaultData", "getPageName", "()Ljava/lang/String;", "subjectId", "path", "", "fromItemClick", "G0", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", RequestParameters.POSITION, "F0", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V", "onVideoPause", "(Lao/e;)V", "onVideoStart", "onCompletion", "H0", "E0", "showEmpty", "Lcom/transsion/player/orplayer/f;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "P0", "(Lcom/transsion/player/orplayer/f;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "onItemCLick", "N0", "(Lkotlin/jvm/functions/Function2;)V", "total", "onPlayInfoCallback", "O0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "d", "Lkotlin/jvm/functions/Function2;", "mOnPlayInfoCallback", "e", "Lcom/transsion/player/orplayer/f;", "mPlayerListener", "f", "mOnItemCLick", be.g.f16474b, "Ljava/lang/String;", "mSubjectId", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class MusicDetailLikedFragment extends BaseMusicLikedFragment {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function2 mOnPlayInfoCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.transsion.player.orplayer.f mPlayerListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function2 mOnItemCLick;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String mSubjectId;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0082, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if (r4 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void M0(ao.e r4, java.lang.String r5) {
        /*
            r3 = this;
            com.transsion.videodetail.music.adapter.a r4 = r3.getMMusicAdapter()
            r0 = 0
            if (r4 == 0) goto L2c
            java.util.List r4 = r4.getData()
            if (r4 == 0) goto L2c
            kotlin.jvm.functions.Function2 r1 = r3.mOnPlayInfoCallback
            if (r1 == 0) goto L29
            int r2 = r3.p0()
            int r2 = r2 + 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.invoke(r2, r4)
            kotlin.Unit r4 = kotlin.Unit.f67184a
            goto L2a
        L29:
            r4 = r0
        L2a:
            if (r4 != 0) goto L49
        L2c:
            kx.a r4 = kx.a.f68524a
            java.lang.String r1 = r3.getClassTag()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " --> onDataSet() --> 这个时候列表还没有数据展示 --> from = "
            r2.append(r1)
            r2.append(r5)
            java.lang.String r1 = r2.toString()
            r4.c(r1)
        L49:
            java.lang.String r4 = r3.mSubjectId
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto La2
            java.lang.String r4 = "onMusicChange()"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 != 0) goto La2
            com.transsion.videodetail.music.adapter.a r4 = r3.getMMusicAdapter()
            if (r4 == 0) goto L84
            java.util.List r4 = r4.getData()
            if (r4 == 0) goto L84
            java.lang.String r5 = r3.mSubjectId
            int r5 = r3.q0(r5)
            kotlin.jvm.functions.Function2 r1 = r3.mOnPlayInfoCallback
            if (r1 == 0) goto L82
            int r5 = r5 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.invoke(r5, r4)
            kotlin.Unit r0 = kotlin.Unit.f67184a
        L82:
            if (r0 != 0) goto L9e
        L84:
            kx.a r4 = kx.a.f68524a
            java.lang.String r5 = r3.getClassTag()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = " --> onDataSet() --> 这个时候列表还没有数据展示"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.c(r5)
        L9e:
            java.lang.String r4 = ""
            r3.mSubjectId = r4
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.music.ui.MusicDetailLikedFragment.M0(ao.e, java.lang.String):void");
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void E0() {
        M0(getMCurrentMediaSource(), "onDataSet()");
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void F0(BaseQuickAdapter adapter, View view, int position) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        kx.a.f68524a.b(getClassTag() + " --> onItemChildClick() --> position = " + position + " --> 内部处理排序");
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void G0(String subjectId, String path, boolean fromItemClick) {
        MediaItem i11;
        ao.e mCurrentMediaSource = getMCurrentMediaSource();
        if (TextUtils.equals((mCurrentMediaSource == null || (i11 = mCurrentMediaSource.i()) == null) ? null : i11.getSubjectId(), subjectId)) {
            kx.a.f68524a.b(getClassTag() + " --> onItemChildClick() --> subjectId = " + subjectId + " --> path = " + path + " --> 当前正在播放");
            return;
        }
        K0(getPageName(), fromItemClick);
        kx.a.f68524a.b(getClassTag() + " --> onItemChildClick() --> subjectId = " + subjectId + " --> path = " + path + " --> 当前页面刷新");
        Function2 function2 = this.mOnItemCLick;
        if (function2 != null) {
            function2.invoke(subjectId, path);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void H0(ao.e mediaSource) {
        M0(mediaSource, "onMusicChange()");
    }

    public final void N0(Function2 onItemCLick) {
        this.mOnItemCLick = onItemCLick;
    }

    public final void O0(String subjectId, Function2 onPlayInfoCallback) {
        this.mSubjectId = subjectId;
        this.mOnPlayInfoCallback = onPlayInfoCallback;
    }

    public final void P0(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.mPlayerListener = listener;
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public String getPageName() {
        return "music_detail_liked_fragment";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        MusicLikedListEmptyView musicLikedListEmptyView;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        super.initViewData();
        jx.e eVar = (jx.e) getMViewBinding();
        if (eVar != null && (appCompatTextView2 = eVar.f66488g) != null) {
            appCompatTextView2.setVisibility(8);
        }
        jx.e eVar2 = (jx.e) getMViewBinding();
        if (eVar2 != null && (appCompatTextView = eVar2.f66487f) != null) {
            appCompatTextView.setVisibility(8);
        }
        jx.e eVar3 = (jx.e) getMViewBinding();
        if (eVar3 == null || (musicLikedListEmptyView = eVar3.f66483b) == null) {
            return;
        }
        musicLikedListEmptyView.setMusicLikedUIType(MusicLikedUITypeEnum.MUSIC_DETAIL);
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        super.loadDefaultData();
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.player.orplayer.f
    public void onCompletion(ao.e mediaSource) {
        super.onCompletion(mediaSource);
        com.transsion.player.orplayer.f fVar = this.mPlayerListener;
        if (fVar != null) {
            fVar.onCompletion(mediaSource);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.player.orplayer.f
    public void onVideoPause(ao.e mediaSource) {
        super.onVideoPause(mediaSource);
        com.transsion.player.orplayer.f fVar = this.mPlayerListener;
        if (fVar != null) {
            fVar.onVideoPause(mediaSource);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.player.orplayer.f
    public void onVideoStart(ao.e mediaSource) {
        super.onVideoStart(mediaSource);
        com.transsion.player.orplayer.f fVar = this.mPlayerListener;
        if (fVar != null) {
            fVar.onVideoStart(mediaSource);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void showEmpty() {
        super.showEmpty();
        Function2 function2 = this.mOnPlayInfoCallback;
        if (function2 != null) {
            function2.invoke(0, 0);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public MusicLikedUITypeEnum x0() {
        return MusicLikedUITypeEnum.MUSIC_DETAIL;
    }
}
