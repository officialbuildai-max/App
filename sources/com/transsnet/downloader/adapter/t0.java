package com.transsnet.downloader.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.SubjectType;
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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000bJ#\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/transsnet/downloader/adapter/t0;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsnet/downloader/bean/HistoricalPlayRecordMultipleEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "Lcom/transsnet/downloader/bean/HistoricalPlayRecordBean;", "it", "holder", "", "E1", "(Lcom/transsnet/downloader/bean/HistoricalPlayRecordBean;Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "D1", "C1", "", "pr", "total", "", "F1", "(Ljava/lang/Long;Ljava/lang/Long;)I", WebConstants.FIELD_ITEM, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsnet/downloader/bean/HistoricalPlayRecordMultipleEntity;)V", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class t0 extends BaseQuickAdapter {
    public t0() {
        super(R$layout.adapter_historical_play_record_layout, null, 2, null);
    }

    private final void C1(HistoricalPlayRecordBean it, BaseViewHolder holder) {
        String str;
        String title;
        String subjectTitle;
        Long duration;
        Long duration2;
        f.b m11 = ej.f.f62005a.m(getContext());
        AudioBean audio = it.getAudio();
        String str2 = "";
        if (audio == null || (str = audio.getCover()) == null) {
            str = "";
        }
        m11.g(str).d((ImageView) holder.getView(R$id.ivCore));
        holder.setImageResource(R$id.ivCornerMark, R$mipmap.ic_audio_download_historical);
        AudioBean audio2 = it.getAudio();
        long j11 = 0;
        if (((audio2 == null || (duration2 = audio2.getDuration()) == null) ? 0L : duration2.longValue()) > 0) {
            int i11 = R$id.tvTime;
            AudioBean audio3 = it.getAudio();
            if (audio3 != null && (duration = audio3.getDuration()) != null) {
                j11 = duration.longValue();
            }
            holder.setText(i11, TimeUtilKt.n(j11));
        }
        ProgressBar progressBar = (ProgressBar) holder.getView(R$id.progressBar);
        AudioBean audio4 = it.getAudio();
        Long readProcess = audio4 != null ? audio4.getReadProcess() : null;
        AudioBean audio5 = it.getAudio();
        progressBar.setProgress(F1(readProcess, audio5 != null ? audio5.getDuration() : null));
        AudioBean audio6 = it.getAudio();
        int se2 = audio6 != null ? audio6.getSe() : 0;
        AudioBean audio7 = it.getAudio();
        int ep2 = audio7 != null ? audio7.getEp() : 0;
        if (se2 == 0 && ep2 == 0) {
            holder.setGone(R$id.tvEpisode, true);
        } else {
            holder.setGone(R$id.tvEpisode, false);
            holder.setText(R$id.tvEpisode, ak.i.b(ep2, se2, Integer.valueOf(SubjectType.AUDIO.getValue())));
        }
        AudioBean audio8 = it.getAudio();
        if (TextUtils.isEmpty(audio8 != null ? audio8.getSubjectTitle() : null)) {
            int i12 = R$id.tvTitle;
            AudioBean audio9 = it.getAudio();
            if (audio9 != null && (title = audio9.getTitle()) != null) {
                str2 = title;
            }
            holder.setText(i12, str2);
            return;
        }
        int i13 = R$id.tvTitle;
        AudioBean audio10 = it.getAudio();
        if (audio10 != null && (subjectTitle = audio10.getSubjectTitle()) != null) {
            str2 = subjectTitle;
        }
        holder.setText(i13, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void D1(com.transsnet.downloader.bean.HistoricalPlayRecordBean r7, com.chad.library.adapter.base.viewholder.BaseViewHolder r8) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.adapter.t0.D1(com.transsnet.downloader.bean.HistoricalPlayRecordBean, com.chad.library.adapter.base.viewholder.BaseViewHolder):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void E1(com.transsnet.downloader.bean.HistoricalPlayRecordBean r10, com.chad.library.adapter.base.viewholder.BaseViewHolder r11) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.adapter.t0.E1(com.transsnet.downloader.bean.HistoricalPlayRecordBean, com.chad.library.adapter.base.viewholder.BaseViewHolder):void");
    }

    private final int F1(Long pr2, Long total) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (pr2 != null && total != null) {
                return (int) ((pr2.longValue() * 100) / total.longValue());
            }
            Result.m1185constructorimpl(Unit.f67184a);
            return 0;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, HistoricalPlayRecordMultipleEntity item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        HistoricalPlayRecordBean historical = item.getHistorical();
        if (historical != null) {
            if (historical.getType() == 1) {
                C1(historical, holder);
            } else if (historical.getStreamVideo() != null) {
                D1(historical, holder);
            }
        }
    }
}
