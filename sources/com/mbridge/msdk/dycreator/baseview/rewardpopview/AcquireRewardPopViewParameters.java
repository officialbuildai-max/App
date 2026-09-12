package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class AcquireRewardPopViewParameters {
    public AcquireRewardPopViewBehaviourListener behaviourListener;
    public String failTip;
    public String failTitle;
    public String language;
    public String placementId;
    public List<String> rightAnswerList;
    public String slideSuccessTitle;
    public String slideTip;
    public String slideTitle;
    public String successTip;
    public String successTitle;
    public String tips;
    public String title;
    public String unitId;
    public int viewType;
    public List<String> wrongAnswerList;
    public int autoDismissTime = 5;
    public int reduceTime = 0;
    public boolean canClickMaskArea = true;
    public int viewBackLayerTopColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFC27A;
    public int viewBackLayerBottomColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FF932B;
    public int viewForegroundTopColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBE2;
    public int viewForegroundBottomColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFE0B5;
    public int buttonBackgroundLightColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FF8B00;
    public int buttonBackgroundDarkColor = AcquireRewardPopViewConst.DEFAULT_COLOR_33EF7601;
    public int titleTextColor = AcquireRewardPopViewConst.DEFAULT_COLOR_E56F19;
    public int tipTextColor = AcquireRewardPopViewConst.DEFAULT_COLOR_89664C;
    public int buttonTextLightColor = -1;
    public int buttonTextDarkColor = AcquireRewardPopViewConst.DEFAULT_COLOR_D26700;
    public int successTipTextColor = -1;
    public int failTipTextColor = -1;
    public int containerBackgroundColor = AcquireRewardPopViewConst.DEFAULT_COLOR_50000000;
    public int successTitleGradientStartColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
    public int successTitleGradientEndColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
    public int successTitleShadowColor = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
    public int successTitleTextSize = 40;
    public float successTitleShadowRadius = 3.0f;
    public float successTitleShadowDx = 1.5f;
    public float successTitleShadowDy = 1.8f;
    public int failTitleGradientStartColor = -1;
    public int failTitleGradientEndColor = AcquireRewardPopViewConst.DEFAULT_COLOR_8B6B45;
    public int failTitleShadowColor = AcquireRewardPopViewConst.DEFAULT_COLOR_3B3127;
    public int failTitleTextSize = 40;
    public float failTitleShadowRadius = 3.0f;
    public float failTitleShadowDx = 1.5f;
    public float failTitleShadowDy = 1.8f;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private AcquireRewardPopViewParameters f34735a;

        public Builder(String str, String str2, int i11, String str3) {
            AcquireRewardPopViewParameters acquireRewardPopViewParameters = new AcquireRewardPopViewParameters();
            this.f34735a = acquireRewardPopViewParameters;
            acquireRewardPopViewParameters.placementId = str;
            acquireRewardPopViewParameters.unitId = str2;
            acquireRewardPopViewParameters.viewType = i11;
            acquireRewardPopViewParameters.language = str3;
            a(str3);
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a(java.lang.String r6) {
            /*
                Method dump skipped, instructions count: 266
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters.Builder.a(java.lang.String):void");
        }

        public AcquireRewardPopViewParameters build() {
            return this.f34735a;
        }

        public Builder setAutoDismissTime(int i11) {
            this.f34735a.autoDismissTime = i11;
            return this;
        }

        public Builder setBehaviourListener(AcquireRewardPopViewBehaviourListener acquireRewardPopViewBehaviourListener) {
            this.f34735a.behaviourListener = acquireRewardPopViewBehaviourListener;
            return this;
        }

        public Builder setButtonBackgroundDarkColor(int i11) {
            this.f34735a.buttonBackgroundDarkColor = i11;
            return this;
        }

        public Builder setButtonBackgroundLightColor(int i11) {
            this.f34735a.buttonBackgroundLightColor = i11;
            return this;
        }

        public Builder setButtonTextDarkColor(int i11) {
            this.f34735a.buttonTextDarkColor = i11;
            return this;
        }

        public Builder setButtonTextLightColor(int i11) {
            this.f34735a.buttonTextLightColor = i11;
            return this;
        }

        public Builder setCanClickMaskArea(boolean z10) {
            this.f34735a.canClickMaskArea = z10;
            return this;
        }

        public Builder setContainerBackgroundColor(int i11) {
            this.f34735a.containerBackgroundColor = i11;
            return this;
        }

        public Builder setFailTip(String str) {
            this.f34735a.failTip = str;
            return this;
        }

        public Builder setFailTipTextColor(int i11) {
            this.f34735a.failTipTextColor = i11;
            return this;
        }

        public Builder setFailTitle(String str) {
            this.f34735a.failTitle = str;
            return this;
        }

        public Builder setFailTitleGradientEndColor(int i11) {
            this.f34735a.failTitleGradientEndColor = i11;
            return this;
        }

        public Builder setFailTitleGradientStartColor(int i11) {
            this.f34735a.failTitleGradientStartColor = i11;
            return this;
        }

        public Builder setFailTitleShadowColor(int i11) {
            this.f34735a.failTitleShadowColor = i11;
            return this;
        }

        public Builder setFailTitleShadowDx(float f11) {
            this.f34735a.failTitleShadowDx = f11;
            return this;
        }

        public Builder setFailTitleShadowDy(float f11) {
            this.f34735a.failTitleShadowDy = f11;
            return this;
        }

        public Builder setFailTitleShadowRadius(float f11) {
            this.f34735a.failTitleShadowRadius = f11;
            return this;
        }

        public Builder setFailTitleTextSize(int i11) {
            this.f34735a.failTitleTextSize = i11;
            return this;
        }

        public Builder setReduceTime(int i11) {
            this.f34735a.reduceTime = i11;
            return this;
        }

        public Builder setRightAnswerList(ArrayList<String> arrayList) {
            this.f34735a.rightAnswerList = arrayList;
            return this;
        }

        public Builder setSlideSuccessTitle(String str) {
            this.f34735a.slideSuccessTitle = str;
            return this;
        }

        public Builder setSlideTip(String str) {
            this.f34735a.slideTip = str;
            return this;
        }

        public Builder setSlideTitle(String str) {
            this.f34735a.slideTitle = str;
            return this;
        }

        public Builder setSuccessTip(String str) {
            this.f34735a.successTip = str;
            return this;
        }

        public Builder setSuccessTipTextColor(int i11) {
            this.f34735a.successTipTextColor = i11;
            return this;
        }

        public Builder setSuccessTitle(String str) {
            this.f34735a.successTitle = str;
            return this;
        }

        public Builder setSuccessTitleGradientEndColor(int i11) {
            this.f34735a.successTitleGradientEndColor = i11;
            return this;
        }

        public Builder setSuccessTitleGradientStartColor(int i11) {
            this.f34735a.successTitleGradientStartColor = i11;
            return this;
        }

        public Builder setSuccessTitleShadowColor(int i11) {
            this.f34735a.successTitleShadowColor = i11;
            return this;
        }

        public Builder setSuccessTitleShadowDx(float f11) {
            this.f34735a.successTitleShadowDx = f11;
            return this;
        }

        public Builder setSuccessTitleShadowDy(float f11) {
            this.f34735a.successTitleShadowDy = f11;
            return this;
        }

        public Builder setSuccessTitleShadowRadius(float f11) {
            this.f34735a.successTitleShadowRadius = f11;
            return this;
        }

        public Builder setSuccessTitleTextSize(int i11) {
            this.f34735a.successTitleTextSize = i11;
            return this;
        }

        public Builder setTipTextColor(int i11) {
            this.f34735a.tipTextColor = i11;
            return this;
        }

        public Builder setTips(String str) {
            this.f34735a.tips = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.f34735a.title = str;
            return this;
        }

        public Builder setTitleTextColor(int i11) {
            this.f34735a.titleTextColor = i11;
            return this;
        }

        public Builder setViewBackLayerBottomColor(int i11) {
            this.f34735a.viewBackLayerBottomColor = i11;
            return this;
        }

        public Builder setViewBackLayerTopColor(int i11) {
            this.f34735a.viewBackLayerTopColor = i11;
            return this;
        }

        public Builder setViewForegroundBottomColor(int i11) {
            this.f34735a.viewForegroundBottomColor = i11;
            return this;
        }

        public Builder setViewForegroundTopColor(int i11) {
            this.f34735a.viewForegroundTopColor = i11;
            return this;
        }

        public Builder setWrongAnswerList(ArrayList<String> arrayList) {
            this.f34735a.wrongAnswerList = arrayList;
            return this;
        }
    }

    public static Builder builder(String str, String str2, int i11, String str3) {
        if (TextUtils.isEmpty(str2)) {
            o0.b("AcquireRewardPopViewParameters", "Unit id must not null.");
            return null;
        }
        if (i11 == 0) {
            i11 = 1;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "EN";
        }
        return new Builder(str, str2, i11, str3);
    }
}
