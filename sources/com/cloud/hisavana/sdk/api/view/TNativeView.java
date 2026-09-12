package com.cloud.hisavana.sdk.api.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.ad.template.TemplateRenderEnum;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.AdDisclaimerView;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.util.f0;
import com.cloud.hisavana.sdk.common.util.i0;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.v2;
import com.cloud.sdk.commonutil.R$id;
import com.cloud.sdk.commonutil.util.h;
import com.cloud.sdk.commonutil.util.k;
import com.cloud.sdk.commonutil.widget.TranCircleImageView;
import java.util.List;

/* loaded from: classes3.dex */
public class TNativeView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private MediaView f21720a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f21721b;

    /* renamed from: c, reason: collision with root package name */
    private AdChoicesView f21722c;

    /* renamed from: d, reason: collision with root package name */
    private AdCloseView f21723d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView.ScaleType f21724e;

    /* renamed from: f, reason: collision with root package name */
    private StoreMarkView f21725f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f21726g;

    /* renamed from: h, reason: collision with root package name */
    private AdBadgeView f21727h;

    /* renamed from: i, reason: collision with root package name */
    private AdDisclaimerView f21728i;

    /* renamed from: j, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f21729j;

    /* renamed from: k, reason: collision with root package name */
    private f7.d f21730k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaNativeInfo f21731b;

        a(TaNativeInfo taNativeInfo) {
            this.f21731b = taNativeInfo;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            e4.b().d("ssp", "download Image failed.");
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            TemplateRenderEnum findStrategyByCode;
            if (!this.f21731b.isMaterialStyleValid() || (findStrategyByCode = TemplateRenderEnum.findStrategyByCode(this.f21731b.getMaterialStyle())) == null) {
                return;
            }
            findStrategyByCode.renderRadius(TNativeView.this.f21720a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaNativeInfo f21733b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageView f21734c;

        b(TaNativeInfo taNativeInfo, ImageView imageView) {
            this.f21733b = taNativeInfo;
            this.f21734c = imageView;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            e4.b().d("TNativeView", "download Image failed.");
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null && adImage.getDrawable() != null) {
                e4.b().d("TNativeView", "download Image Success.");
                AdImage iconImage = this.f21733b.getIconImage();
                if (iconImage != null) {
                    iconImage.setDrawable(adImage.getDrawable());
                } else {
                    this.f21733b.setImage(adImage);
                }
            }
            if (this.f21733b.isMaterialStyleValid() && (this.f21734c instanceof TranCircleImageView)) {
                TemplateRenderEnum findStrategyByCode = TemplateRenderEnum.findStrategyByCode(this.f21733b.getMaterialStyle());
                if (findStrategyByCode != null) {
                    findStrategyByCode.scaleWidthOrTextSize(this.f21734c);
                }
                ((TranCircleImageView) this.f21734c).setCircle(true);
                ((TranCircleImageView) this.f21734c).setRadius(h.a(TextUtils.equals(this.f21733b.getMaterialStyle(), "L91601") ? 16.0f : 4.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f21736a;

        c(AdsDTO adsDTO) {
            this.f21736a = adsDTO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            N0.k(com.cloud.sdk.commonutil.util.e.a(), this.f21736a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f21738a;

        d(AdsDTO adsDTO) {
            this.f21738a = adsDTO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            N0.k(com.cloud.sdk.commonutil.util.e.a(), this.f21738a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaNativeInfo f21740a;

        e(TaNativeInfo taNativeInfo) {
            this.f21740a = taNativeInfo;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (TNativeView.this.f21720a.getHeight() != 0) {
                TNativeView.this.f21720a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                TNativeView.this.f21729j = null;
                TNativeView.this.f21728i.updateHeightWith(f0.e(this.f21740a.getAdItem()), TNativeView.this.f21720a.getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaNativeInfo f21742b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageView.ScaleType f21743c;

        f(TaNativeInfo taNativeInfo, ImageView.ScaleType scaleType) {
            this.f21742b = taNativeInfo;
            this.f21743c = scaleType;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            e4.b().d("ssp", "download Image failed.");
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            TemplateRenderEnum findStrategyByCode;
            if (adImage == null || adImage.getDrawable() == null) {
                return;
            }
            e4.b().d("ssp", "download Image Success.");
            AdImage image = this.f21742b.getImage();
            if (image != null) {
                image.setDrawable(adImage.getDrawable());
            } else {
                this.f21742b.setImage(adImage);
            }
            TNativeView.this.f21720a.setMediaView(adImage, this.f21743c, this.f21742b.isMaterialStyleValid());
            if (!this.f21742b.isMaterialStyleValid() || (findStrategyByCode = TemplateRenderEnum.findStrategyByCode(this.f21742b.getMaterialStyle())) == null) {
                return;
            }
            findStrategyByCode.renderRadius(TNativeView.this.f21720a);
        }
    }

    public TNativeView(@NonNull Context context) {
        this(context, null);
    }

    public TNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f21724e = null;
        this.f21726g = false;
    }

    private void d(TaNativeInfo taNativeInfo) {
        AdBadgeView adBadgeView;
        if (taNativeInfo == null || (adBadgeView = this.f21727h) == null) {
            return;
        }
        adBadgeView.setDisplayStyle(taNativeInfo.getAdItem().getDisplayRule(), f0.c(taNativeInfo.getAdItem()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str, String str2, String str3) {
        f7.d i11 = new f7.d(this).j(str).h(str2).i(str3, null);
        this.f21730k = i11;
        i11.k();
    }

    private void g(TaNativeInfo taNativeInfo) {
        AdsDTO f11;
        if (taNativeInfo == null || this.f21722c == null || (f11 = N0.f(taNativeInfo)) == null) {
            return;
        }
        String adChoiceImageUrl = f11.getAdChoiceImageUrl();
        if (f11.getSource() == 4) {
            DownLoadRequest.n(adChoiceImageUrl, f11, null, this.f21722c);
            this.f21722c.setOnClickListener(new c(f11));
        } else {
            if (f11.getACReady() == null || !f11.getACReady().booleanValue()) {
                return;
            }
            DownLoadRequest.o(adChoiceImageUrl, f11, 3, null, this.f21722c);
            this.f21722c.setOnClickListener(new d(f11));
        }
    }

    private void h(TaNativeInfo taNativeInfo) {
        AdsDTO f11;
        if (taNativeInfo == null || (f11 = N0.f(taNativeInfo)) == null || this.f21723d == null) {
            return;
        }
        AdCloseView.CloseImageType closeImageType = AdCloseView.CloseImageType.CLOSE;
        TemplateRenderEnum templateEnum = taNativeInfo.getTemplateEnum();
        if (templateEnum != null) {
            closeImageType = templateEnum.getCloseImageType();
        }
        this.f21723d.setDisplayStyle(f11.getDisplayRule(), closeImageType);
        this.f21723d.setVisibility(0);
    }

    private void i(TaNativeInfo taNativeInfo) {
        if (taNativeInfo == null || taNativeInfo.getAdItem() == null || this.f21728i == null || this.f21720a == null) {
            return;
        }
        if (taNativeInfo.getAdItem().getDisplayRule() != Constants.AdDisplayRule.RU) {
            if (this.f21728i.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f21728i.getParent()).removeView(this.f21728i);
                return;
            }
            return;
        }
        this.f21728i.setDisplayStyle(taNativeInfo.getAdItem().getDisplayRule(), f0.f(taNativeInfo.getAdItem()));
        this.f21728i.setListener(new AdDisclaimerView.b() { // from class: c7.d
            @Override // com.cloud.hisavana.sdk.api.view.AdDisclaimerView.b
            public final void a(String str, String str2, String str3) {
                TNativeView.this.e(str, str2, str3);
            }
        });
        if (this.f21729j != null) {
            this.f21720a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f21729j);
            this.f21729j = null;
        }
        this.f21729j = new e(taNativeInfo);
        this.f21720a.getViewTreeObserver().addOnGlobalLayoutListener(this.f21729j);
    }

    private void j(TaNativeInfo taNativeInfo) {
        if (this.f21721b == null || taNativeInfo == null) {
            return;
        }
        if (taNativeInfo.getAdItem() != null && taNativeInfo.getAdItem().getSource() == 4) {
            setDefaultLogo(taNativeInfo);
            return;
        }
        ImageView imageView = this.f21721b;
        AdImage iconImage = taNativeInfo.getIconImage();
        if (iconImage != null) {
            if (iconImage.isAdImageRecycled()) {
                if (TextUtils.isEmpty(iconImage.getImgUrl())) {
                    return;
                }
                DownLoadRequest.o(iconImage.getImgUrl(), taNativeInfo.getAdItem(), 1, new b(taNativeInfo, imageView), imageView);
                return;
            }
            imageView.setImageDrawable(l7.c.a(iconImage.getDrawable()));
            if (taNativeInfo.isMaterialStyleValid() && (imageView instanceof TranCircleImageView)) {
                TemplateRenderEnum findStrategyByCode = TemplateRenderEnum.findStrategyByCode(taNativeInfo.getMaterialStyle());
                if (findStrategyByCode != null) {
                    findStrategyByCode.scaleWidthOrTextSize(imageView);
                }
                TranCircleImageView tranCircleImageView = (TranCircleImageView) imageView;
                tranCircleImageView.setCircle(true);
                tranCircleImageView.setRadius(h.a(4.0f));
            }
        }
    }

    private void k(TaNativeInfo taNativeInfo) {
        AdsDTO adItem;
        if (this.f21720a == null || taNativeInfo == null || (adItem = taNativeInfo.getAdItem()) == null) {
            return;
        }
        if (adItem.isInteractiveAd()) {
            setInteractiveMedia(taNativeInfo);
            return;
        }
        int b11 = com.cloud.hisavana.sdk.common.util.b.f22230a.b(taNativeInfo.getAdItem());
        if (b11 == -1) {
            e4.b().e("TNativeView", "setMediaView（）----> adType = -1");
            return;
        }
        if (b11 == 1) {
            setVideoMedia(taNativeInfo);
            return;
        }
        if (taNativeInfo.getAdItem() == null || taNativeInfo.getAdItem().getSource() != 4) {
            setImgMedia(taNativeInfo);
        } else if (taNativeInfo.getAdItem().getDefaultMaterialType() == 1) {
            setDefaultImgMedia(taNativeInfo);
        } else {
            setVideoMedia(taNativeInfo);
        }
    }

    private void l(TaNativeInfo taNativeInfo) {
        if (taNativeInfo == null || this.f21725f == null) {
            return;
        }
        AdsDTO adItem = taNativeInfo.getAdItem();
        this.f21725f.setVisibility(i0.a(adItem) ? 0 : 8);
        if (taNativeInfo.getSdkTypeSetStoreMark() == 0) {
            this.f21725f.setTextColor(TextUtils.equals(adItem.getMaterialStyle(), "L91601") ? -1 : -8882056);
            this.f21725f.setTextSize(6.0f);
        } else {
            try {
                this.f21725f.setTextColor(taNativeInfo.getStoreMarkTextColor());
                this.f21725f.setTextSize(taNativeInfo.getStoreMarkTextSize());
            } catch (Exception unused) {
            }
        }
        this.f21725f.attachInfo(adItem);
    }

    private void setDefaultImgMedia(TaNativeInfo taNativeInfo) {
        AdImage image = taNativeInfo.getImage();
        if (image == null) {
            return;
        }
        this.f21720a.init(image.getMime());
        ImageView.ScaleType scaleType = this.f21724e;
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        ImageView imageView = (ImageView) this.f21720a.findViewById(R$id.native_mediaview_iv_id);
        if (imageView == null) {
            return;
        }
        if (taNativeInfo.isMaterialStyleValid()) {
            imageView.setAdjustViewBounds(true);
            imageView.setMaxWidth(i7.c.k());
            imageView.setMaxHeight(i7.c.j());
        } else {
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(scaleType);
        }
        DownLoadRequest.n(image.getImgUrl(), taNativeInfo.getAdItem(), new a(taNativeInfo), imageView);
    }

    private void setDefaultLogo(TaNativeInfo taNativeInfo) {
        AdImage iconImage = taNativeInfo.getIconImage();
        if (iconImage == null) {
            return;
        }
        if (taNativeInfo.isMaterialStyleValid() && (this.f21721b instanceof TranCircleImageView)) {
            TemplateRenderEnum findStrategyByCode = TemplateRenderEnum.findStrategyByCode(taNativeInfo.getMaterialStyle());
            if (findStrategyByCode != null) {
                findStrategyByCode.scaleWidthOrTextSize(this.f21721b);
            }
            ((TranCircleImageView) this.f21721b).setCircle(true);
            ((TranCircleImageView) this.f21721b).setRadius(h.a(TextUtils.equals(taNativeInfo.getMaterialStyle(), "L91601") ? 16.0f : 4.0f));
        }
        DownLoadRequest.n(iconImage.getImgUrl(), taNativeInfo.getAdItem(), null, this.f21721b);
    }

    private void setImgMedia(TaNativeInfo taNativeInfo) {
        TemplateRenderEnum findStrategyByCode;
        e4.b().d("TNativeView", "start to set img media");
        if (taNativeInfo == null) {
            return;
        }
        AdImage image = taNativeInfo.getImage();
        ImageView.ScaleType scaleType = this.f21724e;
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            image.setNeedBlurBackground(true);
        }
        if (image != null) {
            this.f21720a.init(image.getMime());
            if (image.isAdImageRecycled()) {
                if (TextUtils.isEmpty(image.getImgUrl())) {
                    return;
                }
                DownLoadRequest.o(image.getImgUrl(), taNativeInfo.getAdItem(), 2, new f(taNativeInfo, scaleType), (ImageView) this.f21720a.findViewById(R$id.native_mediaview_iv_id));
            } else {
                if (taNativeInfo.isMaterialStyleValid() && (findStrategyByCode = TemplateRenderEnum.findStrategyByCode(taNativeInfo.getMaterialStyle())) != null) {
                    findStrategyByCode.renderRadius(this.f21720a);
                }
                this.f21720a.setMediaView(image, scaleType, taNativeInfo.isMaterialStyleValid());
            }
        }
    }

    private void setInteractiveMedia(TaNativeInfo taNativeInfo) {
        AdsDTO adItem;
        e4.b().d("TNativeView", "setVideoMedia() ----> start to set interactive media");
        if (taNativeInfo == null || (adItem = taNativeInfo.getAdItem()) == null) {
            return;
        }
        String indexLocation = adItem.getIndexLocation();
        if (TextUtils.isEmpty(indexLocation)) {
            return;
        }
        String scale = adItem.getScale();
        if (TextUtils.isEmpty(scale)) {
            scale = (adItem.getScales() == null || adItem.getScales().isEmpty()) ? "" : adItem.getScales().get(0);
        }
        this.f21720a.setInteractiveView(taNativeInfo, indexLocation, scale);
    }

    private void setVideoMedia(TaNativeInfo taNativeInfo) {
        e4.b().d("TNativeView", "setVideoMedia() ----> start to set video media");
        if (taNativeInfo == null) {
            return;
        }
        String k11 = v2.k(taNativeInfo.getAdItem());
        e4.b().d("TNativeView", "setVideoMedia() ----> mainUrl = " + k11);
        if (TextUtils.isEmpty(k11)) {
            return;
        }
        this.f21720a.init(3);
        this.f21720a.setVideoView(k11, taNativeInfo.isMaterialStyleValid(), taNativeInfo.getMaterialStyle(), taNativeInfo.getAdItem(), this.f21726g);
    }

    public void destroy() {
        MediaView mediaView = this.f21720a;
        if (mediaView != null) {
            if (this.f21729j != null) {
                mediaView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f21729j);
                this.f21729j = null;
            }
            this.f21720a.destroy();
        }
        k.a(this.f21721b);
        k.a(this.f21722c);
        f7.d dVar = this.f21730k;
        if (dVar != null) {
            dVar.f();
            this.f21730k = null;
        }
        removeAllViews();
    }

    public View getIconView() {
        return this.f21721b;
    }

    public void getMarkViews(List<View> list) {
        list.add(this.f21722c);
        list.add(this.f21723d);
        list.add(this.f21725f);
        list.add(this.f21727h);
        list.add(this.f21728i);
    }

    public MediaView getMediaView() {
        return this.f21720a;
    }

    public com.cloud.hisavana.sdk.ad.template.a getTemplateStyle() {
        return null;
    }

    public void inflateAdChoiceView(TaNativeInfo taNativeInfo) {
        g(taNativeInfo);
    }

    public void inflateIconView(TaNativeInfo taNativeInfo) {
        j(taNativeInfo);
    }

    public void inflateMediaView(TaNativeInfo taNativeInfo) {
        k(taNativeInfo);
    }

    public void setAdBagdeView(AdBadgeView adBadgeView) {
        this.f21727h = adBadgeView;
    }

    public void setAdChoiceView(AdChoicesView adChoicesView) {
        if (adChoicesView == null) {
            return;
        }
        this.f21722c = adChoicesView;
    }

    public void setAdCloseView(AdCloseView adCloseView) {
        if (adCloseView == null) {
            return;
        }
        this.f21723d = adCloseView;
    }

    public void setAdDisclaimerView(AdDisclaimerView adDisclaimerView) {
        this.f21728i = adDisclaimerView;
    }

    public final void setIconView(ImageView imageView) {
        this.f21721b = imageView;
    }

    public void setMediaView(MediaView mediaView) {
        setMediaView(mediaView, null);
    }

    public void setMediaView(MediaView mediaView, ImageView.ScaleType scaleType) {
        this.f21720a = mediaView;
        this.f21724e = scaleType;
    }

    public void setPsMarkView(StoreMarkView storeMarkView) {
        if (storeMarkView == null) {
            return;
        }
        this.f21725f = storeMarkView;
    }

    public void setTemplateStyle(com.cloud.hisavana.sdk.ad.template.a aVar) {
    }

    public void setUseListMode(boolean z10) {
        this.f21726g = z10;
    }

    public final void setupViews(TaNativeInfo taNativeInfo) {
        k(taNativeInfo);
        j(taNativeInfo);
        g(taNativeInfo);
        h(taNativeInfo);
        l(taNativeInfo);
        d(taNativeInfo);
        i(taNativeInfo);
    }
}
