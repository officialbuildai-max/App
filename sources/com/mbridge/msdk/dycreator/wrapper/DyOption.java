package com.mbridge.msdk.dycreator.wrapper;

import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.List;

/* loaded from: classes5.dex */
public class DyOption {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f34976a;

    /* renamed from: b, reason: collision with root package name */
    private File f34977b;

    /* renamed from: c, reason: collision with root package name */
    private CampaignEx f34978c;

    /* renamed from: d, reason: collision with root package name */
    private DyAdType f34979d;

    /* renamed from: e, reason: collision with root package name */
    private String f34980e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f34981f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34982g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f34983h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f34984i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f34985j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f34986k;

    /* renamed from: l, reason: collision with root package name */
    private int f34987l;

    /* renamed from: m, reason: collision with root package name */
    private int f34988m;

    /* renamed from: n, reason: collision with root package name */
    private int f34989n;

    /* renamed from: o, reason: collision with root package name */
    private int f34990o;

    /* renamed from: p, reason: collision with root package name */
    private int f34991p;

    /* renamed from: q, reason: collision with root package name */
    private int f34992q;

    /* renamed from: r, reason: collision with root package name */
    private DyCountDownListenerWrapper f34993r;

    /* loaded from: classes5.dex */
    public static class Builder implements IViewOptionBuilder {

        /* renamed from: a, reason: collision with root package name */
        private List<String> f34994a;

        /* renamed from: b, reason: collision with root package name */
        private File f34995b;

        /* renamed from: c, reason: collision with root package name */
        private CampaignEx f34996c;

        /* renamed from: d, reason: collision with root package name */
        private DyAdType f34997d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f34998e;

        /* renamed from: f, reason: collision with root package name */
        private String f34999f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f35000g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f35001h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f35002i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f35003j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f35004k;

        /* renamed from: l, reason: collision with root package name */
        private int f35005l;

        /* renamed from: m, reason: collision with root package name */
        private int f35006m;

        /* renamed from: n, reason: collision with root package name */
        private int f35007n;

        /* renamed from: o, reason: collision with root package name */
        private int f35008o;

        /* renamed from: p, reason: collision with root package name */
        private int f35009p;

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder adChoiceLink(String str) {
            this.f34999f = str;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public DyOption build() {
            return new DyOption(this);
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder campaignEx(CampaignEx campaignEx) {
            this.f34996c = campaignEx;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder canSkip(boolean z10) {
            this.f34998e = z10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder countDownTime(int i11) {
            this.f35008o = i11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder dyAdType(DyAdType dyAdType) {
            this.f34997d = dyAdType;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder file(File file) {
            this.f34995b = file;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder fileDirs(List<String> list) {
            this.f34994a = list;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isApkInfoVisible(boolean z10) {
            this.f35003j = z10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isClickButtonVisible(boolean z10) {
            this.f35001h = z10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isLogoVisible(boolean z10) {
            this.f35004k = z10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isScreenClick(boolean z10) {
            this.f35000g = z10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isShakeVisible(boolean z10) {
            this.f35002i = z10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder orientation(int i11) {
            this.f35007n = i11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder shakeStrenght(int i11) {
            this.f35005l = i11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder shakeTime(int i11) {
            this.f35006m = i11;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder templateType(int i11) {
            this.f35009p = i11;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public interface IViewOptionBuilder {
        IViewOptionBuilder adChoiceLink(String str);

        DyOption build();

        IViewOptionBuilder campaignEx(CampaignEx campaignEx);

        IViewOptionBuilder canSkip(boolean z10);

        IViewOptionBuilder countDownTime(int i11);

        IViewOptionBuilder dyAdType(DyAdType dyAdType);

        IViewOptionBuilder file(File file);

        IViewOptionBuilder fileDirs(List<String> list);

        IViewOptionBuilder isApkInfoVisible(boolean z10);

        IViewOptionBuilder isClickButtonVisible(boolean z10);

        IViewOptionBuilder isLogoVisible(boolean z10);

        IViewOptionBuilder isScreenClick(boolean z10);

        IViewOptionBuilder isShakeVisible(boolean z10);

        IViewOptionBuilder orientation(int i11);

        IViewOptionBuilder shakeStrenght(int i11);

        IViewOptionBuilder shakeTime(int i11);

        IViewOptionBuilder templateType(int i11);
    }

    public DyOption(Builder builder) {
        this.f34976a = builder.f34994a;
        this.f34977b = builder.f34995b;
        this.f34978c = builder.f34996c;
        this.f34979d = builder.f34997d;
        this.f34982g = builder.f34998e;
        this.f34980e = builder.f34999f;
        this.f34981f = builder.f35000g;
        this.f34983h = builder.f35001h;
        this.f34985j = builder.f35003j;
        this.f34984i = builder.f35002i;
        this.f34986k = builder.f35004k;
        this.f34987l = builder.f35005l;
        this.f34988m = builder.f35006m;
        this.f34989n = builder.f35007n;
        this.f34990o = builder.f35008o;
        this.f34992q = builder.f35009p;
    }

    public String getAdChoiceLink() {
        return this.f34980e;
    }

    public CampaignEx getCampaignEx() {
        return this.f34978c;
    }

    public int getCountDownTime() {
        return this.f34990o;
    }

    public int getCurrentCountDown() {
        return this.f34991p;
    }

    public DyAdType getDyAdType() {
        return this.f34979d;
    }

    public File getFile() {
        return this.f34977b;
    }

    public List<String> getFileDirs() {
        return this.f34976a;
    }

    public int getOrientation() {
        return this.f34989n;
    }

    public int getShakeStrenght() {
        return this.f34987l;
    }

    public int getShakeTime() {
        return this.f34988m;
    }

    public int getTemplateType() {
        return this.f34992q;
    }

    public boolean isApkInfoVisible() {
        return this.f34985j;
    }

    public boolean isCanSkip() {
        return this.f34982g;
    }

    public boolean isClickButtonVisible() {
        return this.f34983h;
    }

    public boolean isClickScreen() {
        return this.f34981f;
    }

    public boolean isLogoVisible() {
        return this.f34986k;
    }

    public boolean isShakeVisible() {
        return this.f34984i;
    }

    public void setDyCountDownListener(int i11) {
        DyCountDownListenerWrapper dyCountDownListenerWrapper = this.f34993r;
        if (dyCountDownListenerWrapper != null) {
            dyCountDownListenerWrapper.getCountDownValue(i11);
        }
        this.f34991p = i11;
    }

    public void setDyCountDownListenerWrapper(DyCountDownListenerWrapper dyCountDownListenerWrapper) {
        this.f34993r = dyCountDownListenerWrapper;
    }
}
