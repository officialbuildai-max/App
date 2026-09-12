package com.transsion.videodetail.adapter;

import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.integration.event.EventConstants;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u001a\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010!R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010!R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001dR\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001d¨\u0006."}, d2 = {"Lcom/transsion/videodetail/adapter/b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/videodetail/bean/VideoDetailMediaSource;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "subjectType", "", "isDynamicWidth", "layoutResId", "<init>", "(IZI)V", "holder", "isPlaying", "", "G1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Z)V", WebConstants.FIELD_ITEM, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/videodetail/bean/VideoDetailMediaSource;)V", "", "", "payloads", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/videodetail/bean/VideoDetailMediaSource;Ljava/util/List;)V", EventConstants.KEY_SOURCE, "F1", "(Lcom/transsion/videodetail/bean/VideoDetailMediaSource;)V", "H1", "F", "I", "D1", "()I", "G", "Z", "E1", "()Z", "H", "Lcom/transsion/videodetail/bean/VideoDetailMediaSource;", "playingMediaSource", "isMovie", "J", "isEdu", "K", "screenWidth", "L", "dp8", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class b extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final int subjectType;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isDynamicWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private VideoDetailMediaSource playingMediaSource;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isMovie;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isEdu;

    /* renamed from: K, reason: from kotlin metadata */
    private final int screenWidth;

    /* renamed from: L, reason: from kotlin metadata */
    private final int dp8;

    public b(int i11, boolean z10, int i12) {
        super(i12, null, 2, null);
        this.subjectType = i11;
        this.isDynamicWidth = z10;
        this.isMovie = i11 == SubjectType.MOVIE.getValue();
        this.isEdu = i11 == SubjectType.EDUCATION.getValue();
        this.dp8 = dk.a.b(8);
        this.screenWidth = Math.min(y.e(), y.c());
    }

    public /* synthetic */ b(int i11, boolean z10, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? false : z10, (i13 & 4) != 0 ? R$layout.item_video_detail_episode : i12);
    }

    private final void G1(BaseViewHolder holder, boolean isPlaying) {
        holder.itemView.setSelected(isPlaying);
        holder.getView(R$id.tvName).setVisibility(!isPlaying ? 0 : 8);
        holder.getView(R$id.tvNameSelected).setVisibility(isPlaying ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0241  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(com.chad.library.adapter.base.viewholder.BaseViewHolder r8, com.transsion.videodetail.bean.VideoDetailMediaSource r9) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.adapter.b.F(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.videodetail.bean.VideoDetailMediaSource):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, VideoDetailMediaSource item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        if (item.getSe() == 0) {
            item.getEp();
        }
        G1(holder, Intrinsics.c(this.playingMediaSource, item));
    }

    /* renamed from: D1, reason: from getter */
    public final int getSubjectType() {
        return this.subjectType;
    }

    /* renamed from: E1, reason: from getter */
    public final boolean getIsDynamicWidth() {
        return this.isDynamicWidth;
    }

    public final void F1(VideoDetailMediaSource source) {
        this.playingMediaSource = source;
        notifyDataSetChanged();
    }

    public final void H1(VideoDetailMediaSource source) {
        int i11;
        if (Intrinsics.c(this.playingMediaSource, source) || source == null) {
            return;
        }
        int i12 = 0;
        int i13 = -1;
        if (this.playingMediaSource != null) {
            Iterator<Object> it = getData().iterator();
            i11 = 0;
            while (it.hasNext()) {
                if (Intrinsics.c((VideoDetailMediaSource) it.next(), this.playingMediaSource)) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        i11 = -1;
        this.playingMediaSource = source;
        if (i11 >= 0) {
            notifyItemChanged(i11, source);
        }
        Iterator<Object> it2 = getData().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (Intrinsics.c((VideoDetailMediaSource) it2.next(), source)) {
                i13 = i12;
                break;
            }
            i12++;
        }
        if (i13 >= 0) {
            notifyItemChanged(i13, source);
        }
    }
}
