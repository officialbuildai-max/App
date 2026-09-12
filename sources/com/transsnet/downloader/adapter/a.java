package com.transsnet.downloader.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baseui.R$string;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.ugcvideodetail.api.UGCPageStyle;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J3\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u00192\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b&\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/transsnet/downloader/adapter/a;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/transsnet/downloader/bean/HistoricalPlayRecordMultipleEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lr6/i;", "", "isOutsideFiles", "<init>", "(Z)V", "holder", WebConstants.FIELD_ITEM, "", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsnet/downloader/bean/HistoricalPlayRecordMultipleEntity;)V", "helper", "H1", "G1", "Lcom/transsnet/downloader/bean/HistoricalPlayRecordBean;", "it", "K1", "(Lcom/transsnet/downloader/bean/HistoricalPlayRecordBean;Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "I1", "bean", "J1", "F1", "", "fileLength", "videoDuration", "readDuration", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "M1", "(JLjava/lang/Long;Ljava/lang/Long;I)Ljava/lang/String;", "pr", "total", "L1", "(Ljava/lang/Long;Ljava/lang/Long;)I", "D1", "G", "Z", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class a extends BaseMultiItemQuickAdapter<HistoricalPlayRecordMultipleEntity, BaseViewHolder> implements r6.i {

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isOutsideFiles;

    public a() {
        this(false, 1, null);
    }

    public a(boolean z10) {
        super(null, 1, null);
        this.isOutsideFiles = z10;
        B1(1, R$layout.item_historical_section_header_layout);
        B1(2, R$layout.item_historical_section_body_layout);
        B1(3, R$layout.item_historical_section_ad_layout);
    }

    public /* synthetic */ a(boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10);
    }

    private final void E1(BaseViewHolder holder, HistoricalPlayRecordMultipleEntity item) {
        cy.b bVar = cy.b.f61063a;
        Context context = getContext();
        BiddingNativeManager nonAdDelegate = item.getNonAdDelegate();
        com.transsion.ad.bidding.base.r a11 = bVar.a(context, nonAdDelegate != null ? nonAdDelegate.getMSceneId() : null);
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R$id.adRoot);
        if (nativeWrapperAdView != null) {
            BiddingNativeManager nonAdDelegate2 = item.getNonAdDelegate();
            BiddingNativeManager nonAdDelegate3 = item.getNonAdDelegate();
            nativeWrapperAdView.bindNativeView(nonAdDelegate2, a11, nonAdDelegate3 != null ? nonAdDelegate3.n0() : null);
        }
    }

    private final void F1(HistoricalPlayRecordBean it, BaseViewHolder holder) {
        String str;
        Long readProcess;
        String str2;
        String subjectTitle;
        String title;
        Long duration;
        Long duration2;
        f.b m11 = ej.f.f62005a.m(getContext());
        AudioBean audio = it.getAudio();
        String str3 = "";
        if (audio == null || (str = audio.getCover()) == null) {
            str = "";
        }
        m11.g(str).d((ImageView) holder.getView(R$id.ivCore));
        holder.setImageResource(R$id.ivCornerMark, R$mipmap.ic_audio_download_historical);
        AudioBean audio2 = it.getAudio();
        if (((audio2 == null || (duration2 = audio2.getDuration()) == null) ? 0L : duration2.longValue()) > 0) {
            int i11 = R$id.tvTime;
            AudioBean audio3 = it.getAudio();
            holder.setText(i11, TimeUtilKt.n((audio3 == null || (duration = audio3.getDuration()) == null) ? 0L : duration.longValue()));
        }
        AudioBean audio4 = it.getAudio();
        Long readProcess2 = audio4 != null ? audio4.getReadProcess() : null;
        AudioBean audio5 = it.getAudio();
        int L1 = L1(readProcess2, audio5 != null ? audio5.getDuration() : null);
        ((ProgressBar) holder.getView(R$id.progressBar)).setProgress(L1);
        if (L1 == 0) {
            AudioBean audio6 = it.getAudio();
            holder.setText(R$id.tvProgress, ((audio6 == null || (readProcess = audio6.getReadProcess()) == null) ? 0L : readProcess.longValue()) > 0 ? it.getType() == 1 ? "1% listened" : "1% watched" : "Not open");
        } else if (L1 != 100) {
            holder.setText(R$id.tvProgress, L1 + "% listened");
        } else {
            holder.setText(R$id.tvProgress, "Finished");
        }
        AudioBean audio7 = it.getAudio();
        int se2 = audio7 != null ? audio7.getSe() : 0;
        AudioBean audio8 = it.getAudio();
        int ep2 = audio8 != null ? audio8.getEp() : 0;
        AudioBean audio9 = it.getAudio();
        if (audio9 == null || (str2 = audio9.getSubjectTitle()) == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            holder.setGone(R$id.tvEpisode, true);
            ((AppCompatTextView) holder.getView(R$id.tvTitle)).setMaxLines(2);
            int i12 = R$id.tvTitle;
            AudioBean audio10 = it.getAudio();
            if (audio10 != null && (title = audio10.getTitle()) != null) {
                str3 = title;
            }
            holder.setText(i12, str3);
            return;
        }
        holder.setGone(R$id.tvEpisode, false);
        holder.setText(R$id.tvEpisode, ak.i.b(ep2, se2, Integer.valueOf(SubjectType.AUDIO.getValue())));
        ((AppCompatTextView) holder.getView(R$id.tvTitle)).setMaxLines(1);
        int i13 = R$id.tvTitle;
        AudioBean audio11 = it.getAudio();
        if (audio11 != null && (subjectTitle = audio11.getSubjectTitle()) != null) {
            str3 = subjectTitle;
        }
        holder.setText(i13, str3);
    }

    private final void G1(BaseViewHolder holder, HistoricalPlayRecordMultipleEntity item) {
        HistoricalPlayRecordBean historical = item.getHistorical();
        if (historical != null) {
            if (historical.getType() == 1) {
                F1(historical, holder);
                return;
            }
            if (historical.getVideo() != null) {
                K1(historical, holder);
            } else if (historical.getStreamVideo() != null) {
                I1(historical, holder);
            } else if (historical.getUgcVideo() != null) {
                J1(historical, holder);
            }
        }
    }

    private final void H1(BaseViewHolder helper, HistoricalPlayRecordMultipleEntity item) {
        helper.setText(R$id.tvHeaderTitle, item.getTitle());
    }

    private final void I1(HistoricalPlayRecordBean it, BaseViewHolder holder) {
        String coverUrl;
        Long totalDuration;
        Long totalDuration2;
        String coverUrl2;
        VideoDetailPlayBean streamVideo = it.getStreamVideo();
        String subjectId = streamVideo != null ? streamVideo.getSubjectId() : null;
        String str = "";
        if (subjectId == null || subjectId.length() == 0) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getView(R$id.ivCore);
            com.transsnet.downloader.viewmodel.a0 a0Var = com.transsnet.downloader.viewmodel.a0.f60208a;
            VideoDetailPlayBean streamVideo2 = it.getStreamVideo();
            if (streamVideo2 != null && (coverUrl = streamVideo2.getCoverUrl()) != null) {
                str = coverUrl;
            }
            shapeableImageView.setImageBitmap(a0Var.d(str));
        } else {
            Context context = getContext();
            ImageView imageView = (ImageView) holder.getView(R$id.ivCore);
            VideoDetailPlayBean streamVideo3 = it.getStreamVideo();
            if (streamVideo3 != null && (coverUrl2 = streamVideo3.getCoverUrl()) != null) {
                str = coverUrl2;
            }
            VideoDetailPlayBean streamVideo4 = it.getStreamVideo();
            DownloadedHolderKt.a(context, imageView, str, streamVideo4 != null ? streamVideo4.getThumbnail() : null);
        }
        VideoDetailPlayBean streamVideo5 = it.getStreamVideo();
        Long totalDuration3 = streamVideo5 != null ? streamVideo5.getTotalDuration() : null;
        VideoDetailPlayBean streamVideo6 = it.getStreamVideo();
        holder.setText(R$id.tvProgress, M1(0L, totalDuration3, streamVideo6 != null ? Long.valueOf(streamVideo6.getProgress()) : null, it.getType()));
        ((AppCompatTextView) holder.getView(R$id.tvTitle)).setMaxLines(1);
        int i11 = R$id.ivCornerMark;
        VideoDetailPlayBean streamVideo7 = it.getStreamVideo();
        holder.setImageResource(i11, com.transsion.moviedetailapi.g.a(streamVideo7 != null ? streamVideo7.getSubjectType() : null));
        int i12 = R$id.tvTitle;
        VideoDetailPlayBean streamVideo8 = it.getStreamVideo();
        holder.setText(i12, streamVideo8 != null ? streamVideo8.getTitle() : null);
        VideoDetailPlayBean streamVideo9 = it.getStreamVideo();
        if ((streamVideo9 != null ? streamVideo9.getEp() : 0) > 0) {
            holder.setGone(R$id.tvEpisode, false);
            int i13 = R$id.tvEpisode;
            VideoDetailPlayBean streamVideo10 = it.getStreamVideo();
            int ep2 = streamVideo10 != null ? streamVideo10.getEp() : 0;
            VideoDetailPlayBean streamVideo11 = it.getStreamVideo();
            int se2 = streamVideo11 != null ? streamVideo11.getSe() : 0;
            VideoDetailPlayBean streamVideo12 = it.getStreamVideo();
            holder.setText(i13, ak.i.b(ep2, se2, streamVideo12 != null ? streamVideo12.getSubjectType() : null));
        } else {
            holder.setGone(R$id.tvEpisode, true);
        }
        VideoDetailPlayBean streamVideo13 = it.getStreamVideo();
        long j11 = 0;
        if (((streamVideo13 == null || (totalDuration2 = streamVideo13.getTotalDuration()) == null) ? 0L : totalDuration2.longValue()) > 0) {
            int i14 = R$id.tvTime;
            VideoDetailPlayBean streamVideo14 = it.getStreamVideo();
            if (streamVideo14 != null && (totalDuration = streamVideo14.getTotalDuration()) != null) {
                j11 = totalDuration.longValue();
            }
            holder.setText(i14, TimeUtilKt.n(j11));
        }
        ProgressBar progressBar = (ProgressBar) holder.getView(R$id.progressBar);
        VideoDetailPlayBean streamVideo15 = it.getStreamVideo();
        Long valueOf = streamVideo15 != null ? Long.valueOf(streamVideo15.getProgress()) : null;
        VideoDetailPlayBean streamVideo16 = it.getStreamVideo();
        progressBar.setProgress(L1(valueOf, streamVideo16 != null ? streamVideo16.getTotalDuration() : null));
        ((ViewStub) holder.getView(R$id.viewStub)).setVisibility(8);
    }

    private final void J1(HistoricalPlayRecordBean bean, BaseViewHolder holder) {
        UGCVideoDetailPlayBean ugcVideo = bean.getUgcVideo();
        Intrinsics.e(ugcVideo);
        f.b m11 = ej.f.f62005a.m(getContext());
        String coverUrl = ugcVideo.getCoverUrl();
        if (coverUrl == null) {
            coverUrl = "";
        }
        m11.g(coverUrl).d((ImageView) holder.getView(R$id.ivCore));
        UGCVideoTypeKt.j((ImageView) holder.getView(R$id.ivCornerMark), ugcVideo.getCateLev1Id(), ugcVideo.getCateLev2Id(), ugcVideo.getCateLev3Id(), ugcVideo.getCateLev4Id(), ugcVideo.getType());
        ((AppCompatTextView) holder.getView(R$id.tvTitle)).setMaxLines(2);
        holder.setText(R$id.tvTitle, ugcVideo.getTitle());
        holder.setGone(R$id.tvEpisode, true);
        Long totalDuration = ugcVideo.getTotalDuration();
        if ((totalDuration != null ? totalDuration.longValue() : 0L) > 0) {
            int i11 = R$id.tvTime;
            Long totalDuration2 = ugcVideo.getTotalDuration();
            holder.setText(i11, TimeUtilKt.n(totalDuration2 != null ? totalDuration2.longValue() : 0L));
        }
        String M1 = M1(0L, ugcVideo.getTotalDuration(), Long.valueOf(ugcVideo.getProgress()), bean.getType());
        if (Intrinsics.c(ugcVideo.getVideoStyle(), UGCPageStyle.UGC_PAGE_STYLE_IMM_VERTICAL_VIDEO.getValue())) {
            holder.setText(R$id.tvProgress, com.transsion.baseui.util.q.e(CollectionsKt.q("special_#shorts_icon", Utils.a().getString(R$string.ugc_video_shorts), M1), getContext()));
        } else {
            holder.setText(R$id.tvProgress, M1);
        }
        ((ProgressBar) holder.getView(R$id.progressBar)).setProgress(L1(Long.valueOf(ugcVideo.getProgress()), ugcVideo.getTotalDuration()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02ae, code lost:
    
        if ((r14 != null && r14.isCompleted()) != false) goto L184;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void K1(com.transsnet.downloader.bean.HistoricalPlayRecordBean r14, com.chad.library.adapter.base.viewholder.BaseViewHolder r15) {
        /*
            Method dump skipped, instructions count: 715
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.adapter.a.K1(com.transsnet.downloader.bean.HistoricalPlayRecordBean, com.chad.library.adapter.base.viewholder.BaseViewHolder):void");
    }

    private final int L1(Long pr2, Long total) {
        try {
            Result.Companion companion = Result.INSTANCE;
            long longValue = pr2 != null ? pr2.longValue() : 0L;
            long longValue2 = total != null ? total.longValue() : 1L;
            return (int) (((((float) longValue) * 1.0f) / ((float) (longValue2 > 0 ? longValue2 : 1L))) * 100);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
            return 0;
        }
    }

    private final String M1(long fileLength, Long videoDuration, Long readDuration, int type) {
        String str;
        int L1 = L1(readDuration, videoDuration);
        if (L1 == 0) {
            str = (readDuration != null ? readDuration.longValue() : 0L) > 0 ? type == 1 ? "1% listened" : "1% watched" : "Not open";
        } else if (L1 != 100) {
            str = L1 + "% watched";
        } else {
            str = "Finished";
        }
        if (this.isOutsideFiles) {
            return fileLength > 0 ? oh.b.a(fileLength, 1) : "";
        }
        if (fileLength <= 0) {
            return str;
        }
        return oh.b.a(fileLength, 1) + " · " + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, HistoricalPlayRecordMultipleEntity item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (holder.getPosition() == getItemCount() - 1) {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = dk.a.b(64);
        }
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            H1(holder, item);
        } else if (itemViewType == 2) {
            G1(holder, item);
        } else {
            if (itemViewType != 3) {
                return;
            }
            E1(holder, item);
        }
    }

    @Override // r6.i
    public /* bridge */ /* synthetic */ r6.f b(BaseQuickAdapter baseQuickAdapter) {
        return r6.h.a(this, baseQuickAdapter);
    }
}
