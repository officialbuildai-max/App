package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.ProgressData;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastTracking;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class f4 implements q4 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f22529d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private boolean f22530a;

    /* renamed from: b, reason: collision with root package name */
    private int f22531b;

    /* renamed from: c, reason: collision with root package name */
    private AdsDTO f22532c;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f4() {
    }

    public f4(AdsDTO adsDTO) {
        this();
        this.f22532c = adsDTO;
    }

    private final void g() {
        AdsDTO adsDTO = this.f22532c;
        if (adsDTO != null) {
            VastData videoInfo = adsDTO.getVideoInfo();
            ProgressData progressData = videoInfo != null ? videoInfo.getProgressData() : null;
            if (progressData == null) {
                progressData = new ProgressData(null, null, null, false, 15, null);
                if (videoInfo != null) {
                    videoInfo.setProgressData(progressData);
                }
            }
            Integer duration = videoInfo != null ? videoInfo.getDuration() : null;
            if (duration == null) {
                duration = 0;
            }
            progressData.setDuration(duration);
        }
    }

    private final void h(int i11) {
        i(i11, -1);
    }

    private final void i(int i11, int i12) {
        VastData videoInfo;
        AdsDTO adsDTO = this.f22532c;
        if (adsDTO == null || adsDTO.getSource() == 4) {
            return;
        }
        AdsDTO adsDTO2 = this.f22532c;
        ProgressData progressData = (adsDTO2 == null || (videoInfo = adsDTO2.getVideoInfo()) == null) ? null : videoInfo.getProgressData();
        if (progressData != null) {
            progressData.setVideoPlayTimeType(Integer.valueOf(i11));
        }
        ProgressData copy$default = progressData != null ? ProgressData.copy$default(progressData, null, null, null, false, 15, null) : null;
        if (i12 > 0 && copy$default != null) {
            copy$default.setProgress(Integer.valueOf(i12));
        }
        AthenaTracker.m0(this.f22532c, copy$default);
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void a(C1016p error) {
        Intrinsics.h(error, "error");
        AdsDTO adsDTO = this.f22532c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            String valueOf = String.valueOf(error.a());
            AthenaTracker.l0(this.f22532c, new TaErrorCode(TaErrorCode.VAST_VIDEO_PLAY_ERROR, valueOf + error.b()));
        }
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void b() {
        VastData videoInfo;
        VastTracking vastTrack;
        AdsDTO adsDTO = this.f22532c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            AdsDTO adsDTO2 = this.f22532c;
            c1.l((adsDTO2 == null || (videoInfo = adsDTO2.getVideoInfo()) == null || (vastTrack = videoInfo.getVastTrack()) == null) ? null : vastTrack.getStartTrack(), this.f22532c);
            h(2);
        }
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void c(long j11, long j12, int i11) {
        AdsDTO adsDTO = this.f22532c;
        if (adsDTO == null || adsDTO.getSource() == 4) {
            return;
        }
        AdsDTO adsDTO2 = this.f22532c;
        VastData videoInfo = adsDTO2 != null ? adsDTO2.getVideoInfo() : null;
        if (videoInfo == null) {
            return;
        }
        ProgressData progressData = videoInfo.getProgressData();
        if (progressData == null) {
            g();
        }
        if (progressData != null) {
            progressData.setProgress(Integer.valueOf(i11));
        }
        VastTracking vastTrack = videoInfo.getVastTrack();
        if (vastTrack == null) {
            return;
        }
        e4.b().i("Rewarded", "progress : " + i11);
        if (25 <= i11 && i11 < 50) {
            if (this.f22531b < 25) {
                this.f22531b = 25;
                i(5, 25);
                c1.l(vastTrack.getQuarter(), this.f22532c);
                return;
            }
            return;
        }
        if (50 <= i11 && i11 < 75) {
            if (this.f22531b < 50) {
                this.f22531b = 50;
                i(5, 50);
                c1.l(vastTrack.getMidpoint(), this.f22532c);
                return;
            }
            return;
        }
        if (i11 < 75 || this.f22531b >= 75) {
            return;
        }
        this.f22531b = 75;
        i(5, 75);
        c1.l(vastTrack.getThirdQuarter(), this.f22532c);
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void d(boolean z10) {
        e4.b().d("AdMediaPlayerListener", "onVideoClickToPauseOrPlay isPlay " + z10);
        AdsDTO adsDTO = this.f22532c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            g();
            h(4);
        }
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void e() {
        g();
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void f(boolean z10) {
        e4.b().d("AdMediaPlayerListener", "onCompanion ");
        AdsDTO adsDTO = this.f22532c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            g();
            if (z10) {
                h(1);
            }
        }
    }

    public final void j() {
        h(6);
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void onComplete() {
        VastData videoInfo;
        VastTracking vastTrack;
        AdsDTO adsDTO = this.f22532c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            h(7);
            AdsDTO adsDTO2 = this.f22532c;
            c1.l((adsDTO2 == null || (videoInfo = adsDTO2.getVideoInfo()) == null || (vastTrack = videoInfo.getVastTrack()) == null) ? null : vastTrack.getComplete(), this.f22532c);
        }
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void onIsPlayingChanged(boolean z10) {
        this.f22530a = z10;
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void onVideoSizeChanged(int i11, int i12) {
    }

    @Override // com.cloud.hisavana.sdk.q4
    public void onVolumeChanged(float f11) {
    }
}
