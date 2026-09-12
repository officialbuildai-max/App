package com.transsnet.downloader.viewmodel;

import android.text.TextUtils;
import androidx.view.t0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Settings;

/* loaded from: classes7.dex */
public class a extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f60207a = new CopyOnWriteArrayList();

    public final DownloadBean b(j0 video) {
        Intrinsics.h(video, "video");
        a0 a0Var = a0.f60208a;
        String j11 = a0Var.j(video);
        if (TextUtils.isEmpty(j11)) {
            this.f60207a.add(video);
        }
        String e11 = video.e();
        String str = e11 == null ? "" : e11;
        String e12 = video.e();
        String d11 = video.d();
        String e13 = video.e();
        if (e13 == null) {
            e13 = "";
        }
        long f11 = a0Var.f(e13);
        String e14 = video.e();
        Long a11 = video.a();
        String e15 = video.e();
        return new DownloadBean(str, e12, d11, j11, Long.valueOf(f11), null, null, e14, a11, Long.valueOf(a0Var.e(e15 != null ? e15 : "")), 0L, 0, 0, 2, 0L, 0L, 1, 0, 0, 0, 0, 0, 0, video.f(), video.b(), 0, 0, null, null, null, null, 0L, 2, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, SubjectType.OUTSIDE_FILE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 108789760, -65538, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    public final HistoricalPlayRecordBean c(DownloadBean createDownload) {
        Intrinsics.h(createDownload, "createDownload");
        Long updateTimeStamp = createDownload.getUpdateTimeStamp();
        Long updateTimeStamp2 = createDownload.getUpdateTimeStamp();
        String m11 = TimeUtilKt.m(updateTimeStamp2 != null ? updateTimeStamp2.longValue() : 0L);
        a0 a0Var = a0.f60208a;
        Long updateTimeStamp3 = createDownload.getUpdateTimeStamp();
        return new HistoricalPlayRecordBean(2, updateTimeStamp, m11, a0Var.z(updateTimeStamp3 != null ? updateTimeStamp3.longValue() : 0L), null, createDownload, null, null, null, 448, null);
    }

    public final CopyOnWriteArrayList d() {
        return this.f60207a;
    }
}
