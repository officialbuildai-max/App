package com.mbridge.msdk.dycreator.bridge;

import com.mbridge.msdk.dycreator.viewdata.base.a;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes5.dex */
public class MBSplashData implements a {

    /* renamed from: a, reason: collision with root package name */
    private DyOption f34817a;

    /* renamed from: b, reason: collision with root package name */
    private String f34818b;

    /* renamed from: c, reason: collision with root package name */
    private String f34819c;

    /* renamed from: d, reason: collision with root package name */
    private String f34820d;

    /* renamed from: e, reason: collision with root package name */
    private String f34821e;

    /* renamed from: f, reason: collision with root package name */
    private CampaignEx f34822f;

    /* renamed from: g, reason: collision with root package name */
    private int f34823g;

    /* renamed from: h, reason: collision with root package name */
    private int f34824h;

    /* renamed from: i, reason: collision with root package name */
    private float f34825i;

    /* renamed from: j, reason: collision with root package name */
    private float f34826j;

    /* renamed from: k, reason: collision with root package name */
    private int f34827k = 0;

    public MBSplashData(DyOption dyOption) {
        this.f34817a = dyOption;
        this.f34822f = dyOption.getCampaignEx();
    }

    public String getAdClickText() {
        return this.f34819c;
    }

    public String getAppInfo() {
        return this.f34818b;
    }

    @Override // com.mbridge.msdk.dycreator.viewdata.base.a
    public CampaignEx getBindData() {
        return this.f34822f;
    }

    public int getClickType() {
        return this.f34827k;
    }

    public String getCountDownText() {
        return this.f34820d;
    }

    public DyOption getDyOption() {
        return this.f34817a;
    }

    @Override // com.mbridge.msdk.dycreator.viewdata.base.a
    public DyOption getEffectData() {
        return this.f34817a;
    }

    public int getLogoImage() {
        return this.f34824h;
    }

    public String getLogoText() {
        return this.f34821e;
    }

    public int getNoticeImage() {
        return this.f34823g;
    }

    public float getxInScreen() {
        return this.f34825i;
    }

    public float getyInScreen() {
        return this.f34826j;
    }

    public void setAdClickText(String str) {
        this.f34819c = str;
    }

    public void setAppInfo(String str) {
        this.f34818b = str;
    }

    public void setClickType(int i11) {
        this.f34827k = i11;
    }

    public void setCountDownText(String str) {
        this.f34820d = str;
    }

    public void setLogoImage(int i11) {
        this.f34824h = i11;
    }

    public void setLogoText(String str) {
        this.f34821e = str;
    }

    public void setNoticeImage(int i11) {
        this.f34823g = i11;
    }

    public void setxInScreen(float f11) {
        this.f34825i = f11;
    }

    public void setyInScreen(float f11) {
        this.f34826j = f11;
    }
}
