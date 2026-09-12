package com.mbridge.msdk.video.module.listener.impl;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes5.dex */
public class m extends o {
    private Timer A;
    private Handler B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private MBridgeVideoView.u H;

    /* renamed from: x, reason: collision with root package name */
    private MBridgeVideoView f39531x;

    /* renamed from: y, reason: collision with root package name */
    private MBridgeContainerView f39532y;

    /* renamed from: z, reason: collision with root package name */
    private int f39533z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends TimerTask {

        /* renamed from: com.mbridge.msdk.video.module.listener.impl.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0570a implements Runnable {
            RunnableC0570a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m.this.f39532y.showVideoClickView(-1);
                m.this.f39531x.soundOperate(0, 2);
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                m.this.B.post(new RunnableC0570a());
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
        }
    }

    public m(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, int i11, int i12, com.mbridge.msdk.video.module.listener.a aVar2, int i13, boolean z10, int i14) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i13, z10);
        this.B = new Handler();
        this.C = false;
        this.D = false;
        this.E = false;
        this.f39531x = mBridgeVideoView;
        this.f39532y = mBridgeContainerView;
        this.G = i11;
        this.f39533z = i12;
        this.F = i14;
        if (mBridgeVideoView != null) {
            this.C = mBridgeVideoView.getVideoSkipTime() == 0;
        }
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f39514a = false;
        }
    }

    private void a(int i11, int i12) {
        CampaignEx campaignEx;
        if (this.C || this.f39531x == null || (campaignEx = this.f39515b) == null) {
            return;
        }
        int i13 = this.f39533z;
        int i14 = (i13 < 0 || i11 < i13) ? 1 : 2;
        if (i14 != 2 && (campaignEx.getVideoCompleteTime() != 0 ? i11 > this.f39515b.getVideoCompleteTime() : this.f39531x.mCurrPlayNum > 1)) {
            i14 = 2;
        }
        if (i14 != 2 && this.f39531x.mCurrPlayNum > 1 && i11 == i12) {
            i14 = 2;
        }
        if (i14 == 2) {
            this.f39531x.closeVideoOperate(0, i14);
            this.C = true;
        }
    }

    private void n() {
        try {
            Timer timer = this.A;
            if (timer != null) {
                timer.cancel();
                this.A = null;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void o() {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r4.f39515b
            if (r0 == 0) goto L70
            int r0 = r0.getDynamicTempCode()
            r1 = 5
            if (r0 != r1) goto L70
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r4.f39531x
            if (r0 == 0) goto L5c
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r0.mCampOrderViewData
            if (r0 == 0) goto L5c
            r0 = 0
            r1 = r0
        L15:
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f39531x
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            int r2 = r2.size()
            if (r1 >= r2) goto L45
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f39531x
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            java.lang.Object r2 = r2.get(r1)
            if (r2 == 0) goto L42
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f39531x
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            java.lang.Object r2 = r2.get(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2
            java.lang.String r2 = r2.getId()
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r4.f39515b
            java.lang.String r3 = r3.getId()
            if (r2 != r3) goto L42
            int r0 = r1 + (-1)
            goto L45
        L42:
            int r1 = r1 + 1
            goto L15
        L45:
            if (r0 < 0) goto L5c
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f39531x
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r1.mCampOrderViewData
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L5c
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f39531x
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r1.mCampOrderViewData
            java.lang.Object r0 = r1.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            goto L5d
        L5c:
            r0 = 0
        L5d:
            if (r0 == 0) goto L70
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f39531x
            if (r1 == 0) goto L66
            r1.setCampaign(r0)
        L66:
            com.mbridge.msdk.video.module.MBridgeContainerView r1 = r4.f39532y
            if (r1 == 0) goto L6d
            r1.setCampaign(r0)
        L6d:
            r4.a(r0)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.listener.impl.m.o():void");
    }

    private void p() {
        try {
            n();
            this.A = new Timer();
            this.A.schedule(new a(), 3000L);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.o, com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i11, Object obj) {
        int i12;
        String str;
        int i13;
        if (this.f39514a) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 5) {
                        if (i11 != 6) {
                            if (i11 == 8) {
                                MBridgeContainerView mBridgeContainerView = this.f39532y;
                                if (mBridgeContainerView == null) {
                                    MBridgeVideoView mBridgeVideoView = this.f39531x;
                                    if (mBridgeVideoView != null) {
                                        mBridgeVideoView.showAlertView();
                                    }
                                } else if (mBridgeContainerView.showAlertWebView()) {
                                    MBridgeVideoView mBridgeVideoView2 = this.f39531x;
                                    if (mBridgeVideoView2 != null) {
                                        mBridgeVideoView2.alertWebViewShowed();
                                    }
                                } else {
                                    MBridgeVideoView mBridgeVideoView3 = this.f39531x;
                                    if (mBridgeVideoView3 != null) {
                                        mBridgeVideoView3.showAlertView();
                                    }
                                }
                            } else if (i11 != 20) {
                                switch (i11) {
                                    case 10:
                                        this.D = true;
                                        this.f39531x.soundOperate(0, 2);
                                        this.f39531x.progressOperate(0, 2);
                                        break;
                                    case 11:
                                        this.f39531x.videoOperate(3);
                                        this.f39531x.dismissAllAlert();
                                        CampaignEx campaignEx = this.f39515b;
                                        if (campaignEx == null || campaignEx.getVideo_end_type() == 3 || this.f39515b.getRewardTemplateMode() == null || this.f39515b.getRewardTemplateMode().f() == 5002010) {
                                            this.f39531x.setVisibility(0);
                                        } else if (this.f39515b.getAdSpaceT() != 2) {
                                            this.f39531x.setVisibility(8);
                                        }
                                        CampaignEx campaignEx2 = this.f39515b;
                                        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5) {
                                            MBridgeVideoView mBridgeVideoView4 = this.f39531x;
                                            if (mBridgeVideoView4.mCurrPlayNum == mBridgeVideoView4.mCampaignSize) {
                                                MBridgeContainerView mBridgeContainerView2 = this.f39532y;
                                                if (mBridgeContainerView2 != null) {
                                                    mBridgeContainerView2.setRewardStatus(true);
                                                    this.f39532y.showOrderCampView();
                                                    break;
                                                }
                                            }
                                        }
                                        CampaignEx campaignEx3 = this.f39515b;
                                        if (campaignEx3 == null || campaignEx3.getRewardTemplateMode() == null || this.f39515b.getRewardTemplateMode().f() != 5002010) {
                                            if (this.f39515b.getAdSpaceT() != 2) {
                                                this.f39532y.showEndcard(this.f39515b.getVideo_end_type());
                                                break;
                                            } else {
                                                this.f39532y.showVideoEndCover();
                                                break;
                                            }
                                        }
                                        break;
                                    case 12:
                                        k();
                                        this.f39531x.videoOperate(3);
                                        this.f39531x.dismissAllAlert();
                                        if (this.f39515b.getVideo_end_type() != 3) {
                                            this.f39531x.setVisibility(8);
                                        } else {
                                            this.f39531x.setVisibility(0);
                                        }
                                        if (this.D || this.F != 0) {
                                            if (this.f39515b.isDynamicView() && this.f39515b.getDynamicTempCode() == 5 && TextUtils.isEmpty(this.f39515b.getendcard_url())) {
                                                o();
                                                this.F = 0;
                                            }
                                            if (!this.D && this.F == 1) {
                                                j();
                                                h();
                                                i();
                                                if (q0.a().a("i_l_s_t_r_i", false) && !this.E) {
                                                    this.E = true;
                                                    MBridgeVideoView.u uVar = this.H;
                                                    if (uVar != null) {
                                                        uVar.a();
                                                    }
                                                }
                                            }
                                            if (this.f39515b.getAdSpaceT() == 2) {
                                                this.f39532y.showVideoEndCover();
                                                break;
                                            } else {
                                                this.f39532y.showEndcard(this.f39515b.getVideo_end_type());
                                                break;
                                            }
                                        }
                                        break;
                                    case 13:
                                        MBridgeVideoView mBridgeVideoView5 = this.f39531x;
                                        if (mBridgeVideoView5 != null) {
                                            mBridgeVideoView5.closeVideoOperate(0, 2);
                                            str = this.f39531x.getPlayURL();
                                            i12 = this.f39531x.getBufferTimeout();
                                        } else {
                                            i12 = -1;
                                            str = "";
                                        }
                                        CampaignEx campaignEx4 = this.f39515b;
                                        String videoUrlEncode = campaignEx4 != null ? campaignEx4.getVideoUrlEncode() : "";
                                        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                                        eVar.a("play_url", str);
                                        eVar.a(CampaignEx.JSON_KEY_VIDEO_URL, videoUrlEncode);
                                        eVar.a("timeout", Integer.valueOf(i12));
                                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_video_buffer_timeout", this.f39515b, eVar);
                                        break;
                                    case 14:
                                        if (!this.C) {
                                            this.f39531x.closeVideoOperate(0, 1);
                                            break;
                                        }
                                        break;
                                    case 15:
                                        if (obj != null && (obj instanceof MBridgeVideoView.v)) {
                                            MBridgeVideoView.v vVar = (MBridgeVideoView.v) obj;
                                            int videoInteractiveType = this.f39532y.getVideoInteractiveType();
                                            if (this.f39515b.getAdSpaceT() == 2) {
                                                SoundImageView soundImageView = this.f39531x.mSoundImageView;
                                                if (soundImageView != null && (soundImageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f39531x.mSoundImageView.getLayoutParams();
                                                    layoutParams.setMargins(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f), 0, 0, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 85.0f));
                                                    this.f39531x.mSoundImageView.setLayoutParams(layoutParams);
                                                }
                                                TextView textView = this.f39531x.tvFlag;
                                                if (textView != null && (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f39531x.tvFlag.getLayoutParams();
                                                    layoutParams2.setMargins(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f), 0, 0, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 85.0f));
                                                    this.f39531x.tvFlag.setVisibility(0);
                                                    this.f39531x.tvFlag.setLayoutParams(layoutParams2);
                                                }
                                                this.f39532y.showVideoClickView(1);
                                            } else if (videoInteractiveType >= 0 && vVar.f39482a >= videoInteractiveType) {
                                                this.f39532y.showVideoClickView(1);
                                                this.f39531x.soundOperate(0, 1);
                                            }
                                            this.C = vVar.f39484c;
                                            if (this.f39515b.getDynamicTempCode() != 5) {
                                                int i14 = this.f39533z;
                                                if (((i14 >= 0 && ((i13 = vVar.f39482a) >= i14 || i13 == vVar.f39483b)) || (this.f39515b.getVideoCompleteTime() > 0 && (vVar.f39482a > this.f39515b.getVideoCompleteTime() || vVar.f39482a == vVar.f39483b))) && !this.C) {
                                                    this.f39531x.closeVideoOperate(0, 2);
                                                    this.C = true;
                                                    break;
                                                }
                                            } else {
                                                a(vVar.f39482a, vVar.f39483b);
                                                break;
                                            }
                                        }
                                        break;
                                }
                            } else if (q0.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.u)) {
                                this.H = (MBridgeVideoView.u) obj;
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        this.f39531x.soundOperate((((Integer) obj).intValue() == 1 ? 2 : 1).intValue(), -1);
                    }
                }
                this.f39531x.dismissAllAlert();
                this.f39531x.videoOperate(3);
                CampaignEx campaignEx5 = this.f39515b;
                if (campaignEx5 != null && campaignEx5.isDynamicView() && this.f39515b.getDynamicTempCode() == 5) {
                    if (this.f39532y != null) {
                        MBridgeVideoView mBridgeVideoView6 = this.f39531x;
                        if (mBridgeVideoView6.mCurrPlayNum == mBridgeVideoView6.mCampaignSize) {
                            if (this.f39515b.getAdSpaceT() != 2) {
                                this.f39532y.setRewardStatus(true);
                                this.f39532y.showOrderCampView();
                            }
                            i11 = 16;
                        }
                    }
                    com.mbridge.msdk.video.bt.module.orglistener.f.a(this.f39515b, this.f39520g, this.f39531x.mCurrentPlayProgressTime);
                }
                if (this.G == 2 && !this.f39532y.endCardShowing() && this.f39515b.getAdSpaceT() != 2) {
                    this.f39532y.showEndcard(this.f39515b.getVideo_end_type());
                }
                i11 = 16;
            } else if (!this.f39532y.endCardShowing()) {
                int videoInteractiveType2 = this.f39532y.getVideoInteractiveType();
                if (videoInteractiveType2 != -2) {
                    if (videoInteractiveType2 == -1) {
                        if (this.f39532y.isLast()) {
                            this.f39532y.showVideoClickView(1);
                            this.f39531x.soundOperate(0, 1);
                            p();
                        } else {
                            this.f39532y.showVideoClickView(-1);
                            this.f39531x.soundOperate(0, 2);
                            n();
                        }
                    }
                } else if (this.f39532y.miniCardLoaded()) {
                    this.f39532y.showVideoClickView(2);
                }
            }
        }
        super.a(i11, obj);
    }
}
