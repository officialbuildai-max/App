package com.hisavana.mediation.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import be.o;
import com.cloud.hisavana.sdk.R$dimen;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.sdk.commonutil.R$id;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.adxlibrary.holder.NativeAdViewHolder;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.CommonViewBinder;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.utils.AdLogUtil;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes4.dex */
public class TAdNativeView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public BaseNativeViewHolder f33229a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f33230b;

    /* renamed from: c, reason: collision with root package name */
    public TAdNativeInfo f33231c;

    /* renamed from: d, reason: collision with root package name */
    public int f33232d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f33233e;

    /* renamed from: f, reason: collision with root package name */
    public final SparseArray<BaseNativeViewHolder> f33234f;

    public TAdNativeView(Context context) {
        this(context, null);
    }

    public TAdNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TAdNativeView(Context context, AttributeSet attributeSet, int i11) {
        super(context.getApplicationContext(), attributeSet, i11);
        this.f33230b = false;
        this.f33232d = 0;
        this.f33233e = true;
        this.f33234f = new SparseArray<>();
    }

    private final void setBodyView(View view) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.setBodyView(view);
        }
    }

    private final void setCallToActionOtherView(View view) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.setCallToActionOtherView(view);
        }
    }

    private final void setCallToActionView(View view) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.setCallToActionView(view);
        }
    }

    private void setDomain(View view) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.setDomain(view);
        }
    }

    private void setFeedback(View view) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.setFeedback(view);
        }
    }

    private final void setHeadlineView(View view) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.setHeadlineView(view);
        }
    }

    private final void setMaxNativeAdViewBinder(ViewBinder viewBinder) {
        if (this.f33229a != null) {
            CommonViewBinder commonViewBinder = new CommonViewBinder();
            commonViewBinder.titleId = viewBinder.titleId;
            commonViewBinder.iconId = viewBinder.iconId;
            commonViewBinder.callToActionId = viewBinder.callToActionId;
            commonViewBinder.mediaId = viewBinder.mediaId;
            commonViewBinder.adChoicesView = viewBinder.adChoicesView;
            commonViewBinder.descriptionId = viewBinder.descriptionId;
            commonViewBinder.layoutId = viewBinder.layoutId;
            if (viewBinder.layout != null) {
                commonViewBinder.layoutReference = new WeakReference<>(viewBinder.layout);
            }
            this.f33229a.setBinderLayoutId(commonViewBinder);
        }
    }

    private void setNativeAd(TAdNativeInfo tAdNativeInfo) {
        BaseNativeViewHolder baseNativeViewHolder;
        if (tAdNativeInfo == null || (baseNativeViewHolder = this.f33229a) == null) {
            return;
        }
        baseNativeViewHolder.setNativeAd(tAdNativeInfo);
    }

    private void setPrice(View view) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.setPrice(view);
        }
    }

    private void setSponsored(View view) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.setSponsored(view);
        }
    }

    public final BaseNativeViewHolder a(int i11) {
        BaseNativeViewHolder baseNativeViewHolder = this.f33234f.get(i11);
        if (baseNativeViewHolder == null) {
            IBaseAdSummary f11 = o.a().f(i11);
            baseNativeViewHolder = f11 != null ? f11.getNativeViewHolder() : null;
            if (baseNativeViewHolder != null && this.f33232d == 1) {
                this.f33234f.append(i11, baseNativeViewHolder);
            }
        }
        return baseNativeViewHolder;
    }

    public final String a(String str) {
        long j11;
        if (str == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            j11 = Long.parseLong(str);
        } catch (Throwable unused) {
            j11 = 0;
        }
        float f11 = (float) j11;
        return f11 >= 1.07374182E9f ? String.format("%.1f GB", Float.valueOf(f11 / 1.07374182E9f)) : f11 >= 1048576.0f ? String.format("%.1f MB", Float.valueOf(f11 / 1048576.0f)) : String.format("%.1f MB", Float.valueOf(f11 / 1048576.0f));
    }

    public final void a(View view) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public final void a(View view, TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        View adBadgeView;
        if (this.f33229a == null || view == null || viewBinder == null || tAdNativeInfo == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(viewBinder.adBadgeView);
            if (viewGroup == null || (adBadgeView = this.f33229a.getAdBadgeView(getContext(), tAdNativeInfo)) == null) {
                return;
            }
            viewGroup.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.f33229a instanceof NativeAdViewHolder) {
                layoutParams = new FrameLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelOffset(R$dimen.ad_badge_height));
            }
            viewGroup.addView(adBadgeView, layoutParams);
        } catch (Exception e11) {
            AdLogUtil.Log().e("TAdNativeView", Log.getStackTraceString(e11));
        }
    }

    public final void a(TAdNativeInfo tAdNativeInfo) {
        TAdNativeInfo tAdNativeInfo2;
        if (!this.f33230b || (tAdNativeInfo2 = this.f33231c) == tAdNativeInfo) {
            return;
        }
        if (tAdNativeInfo2 != null) {
            tAdNativeInfo2.release();
        }
        this.f33231c = tAdNativeInfo;
    }

    public void a(@NonNull TAdNativeInfo tAdNativeInfo, @NonNull ViewBinder viewBinder) {
        if (tAdNativeInfo == null) {
            throw new IllegalStateException("AdNativeInfo is null");
        }
        if (tAdNativeInfo.isRelease()) {
            AdLogUtil.Log().w("TAdNativeView", "make sure nativeInfo is valid");
            return;
        }
        this.f33232d = viewBinder.mode;
        if (c(tAdNativeInfo, viewBinder)) {
            b(tAdNativeInfo, viewBinder);
        }
    }

    public final void a(TIconView tIconView, TAdNativeInfo tAdNativeInfo) {
        BaseNativeViewHolder baseNativeViewHolder;
        if (tIconView == null || tAdNativeInfo == null || (baseNativeViewHolder = this.f33229a) == null) {
            return;
        }
        if (this.f33233e) {
            tIconView.attachLayout(baseNativeViewHolder);
        }
        TAdNativeInfo.Image icon = tAdNativeInfo.getIcon();
        if (icon != null) {
            if (icon.canUse()) {
                this.f33229a.setIconDrawable(icon.getDrawable());
            }
            if (this.f33229a != null) {
                View iconView = tIconView.getIconView();
                if (iconView == null) {
                    AdLogUtil.Log().i("TAdNativeView", "TAdIconView's child is null");
                } else {
                    this.f33229a.setIconView(iconView);
                }
            }
        }
    }

    public final void a(TMediaView tMediaView, TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        if (tMediaView == null || tAdNativeInfo == null || tAdNativeInfo.getAdType() != 1) {
            return;
        }
        b(tMediaView, tAdNativeInfo, viewBinder);
    }

    public final void a(ViewBinder viewBinder, TAdNativeInfo tAdNativeInfo) {
        removeAllViews();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        View d11 = d(tAdNativeInfo, viewBinder);
        if (d11 != null) {
            a(d11);
            addView(d11, layoutParams);
            a(d11, tAdNativeInfo, viewBinder);
            d(d11, tAdNativeInfo, viewBinder);
            b(d11, tAdNativeInfo, viewBinder);
            e(d11, tAdNativeInfo, viewBinder);
            c(d11, tAdNativeInfo, viewBinder);
        }
        if (this.f33229a == null || this.f33232d != 1) {
            return;
        }
        AdLogUtil.Log().i("TAdNativeView", "set tag to AdViewHolder in List Mode");
        this.f33229a.setTag(tAdNativeInfo.getAdId());
    }

    public final void a(@NonNull List<View> list, View view) {
        if (view == null) {
            return;
        }
        list.add(view);
    }

    public final void b(View view, TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        View closeView;
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder == null || viewBinder == null || tAdNativeInfo == null || (closeView = baseNativeViewHolder.getCloseView(getContext(), tAdNativeInfo)) == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(viewBinder.adCloseView);
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                if (this.f33229a instanceof NativeAdViewHolder) {
                    int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R$dimen.ad_badge_height);
                    layoutParams = new FrameLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset);
                }
                viewGroup.addView(closeView, layoutParams);
            }
        } catch (Exception e11) {
            AdLogUtil.Log().e("TAdNativeView", Log.getStackTraceString(e11));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.hisavana.common.bean.TAdNativeInfo r20, com.hisavana.mediation.ad.ViewBinder r21) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisavana.mediation.ad.TAdNativeView.b(com.hisavana.common.bean.TAdNativeInfo, com.hisavana.mediation.ad.ViewBinder):void");
    }

    public final void b(TMediaView tMediaView, TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        TAdNativeInfo.Image image;
        if (this.f33233e) {
            tMediaView.attachLayout(this.f33229a, tAdNativeInfo);
        }
        List<TAdNativeInfo.Image> imageList = tAdNativeInfo.getImageList();
        if (imageList != null && imageList.size() > 0 && (image = imageList.get(0)) != null && image.canUse()) {
            tMediaView.setMediaView(new AdImage(image.getDrawable(), null));
        }
        if (this.f33229a != null) {
            View mediaView = tMediaView.getMediaView();
            if (mediaView == null) {
                AdLogUtil.Log().w("TAdNativeView", "TMediaView's child is null");
            } else {
                this.f33229a.setMediaView(mediaView, tMediaView.getScaleType());
            }
        }
    }

    public final void c(View view, TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        View adDisclaimerView;
        if (this.f33229a == null || view == null || viewBinder == null || tAdNativeInfo == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(viewBinder.adDisclaimerView);
            if (viewGroup == null || (adDisclaimerView = this.f33229a.getAdDisclaimerView(getContext(), tAdNativeInfo)) == null) {
                return;
            }
            viewGroup.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.f33229a instanceof NativeAdViewHolder) {
                layoutParams = new FrameLayout.LayoutParams(-1, 0);
            }
            viewGroup.addView(adDisclaimerView, layoutParams);
        } catch (Exception e11) {
            AdLogUtil.Log().e("TAdNativeView", Log.getStackTraceString(e11));
        }
    }

    public final boolean c(TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        if (tAdNativeInfo == null) {
            return false;
        }
        AdLogUtil.Log().d("TAdNativeView", "buildNativeView nativeInfo:" + tAdNativeInfo);
        a(tAdNativeInfo);
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null && this.f33232d == 0) {
            baseNativeViewHolder.destroy();
            this.f33229a = null;
        }
        this.f33229a = a(tAdNativeInfo.getAdSource());
        boolean z10 = (this.f33232d == 1 && getChildCount() > 0 && (getTag(R$id.native_view_id) == null || TextUtils.equals(tAdNativeInfo.getAdId(), getTag(R$id.native_view_id).toString()))) ? false : true;
        this.f33233e = z10;
        if (!z10) {
            AdLogUtil.Log().d("TAdNativeView", "the same ad scroll back");
            return false;
        }
        if (this.f33229a == null) {
            AdLogUtil.Log().d("TAdNativeView", "cant create the AdViewHolder instance");
            return false;
        }
        setTag(R$id.native_view_id, tAdNativeInfo.getAdId());
        setTag(R$id.native_view_source, Integer.valueOf(tAdNativeInfo.getAdSource()));
        setMaxNativeAdViewBinder(viewBinder);
        a(viewBinder, tAdNativeInfo);
        return true;
    }

    public final View d(TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        if (viewBinder == null) {
            return null;
        }
        View view = viewBinder.layout;
        if (view == null) {
            view = LayoutInflater.from(e.a()).inflate(viewBinder.layoutId, (ViewGroup) null);
        }
        if (view == null) {
            AdLogUtil.Log().w("TAdNativeView", "make sure ViewBinder correct");
            return null;
        }
        try {
            a(view);
            View container = this.f33229a.getContainer(tAdNativeInfo, this);
            if (container != null) {
                if ((container instanceof TNativeView) && this.f33232d == 1) {
                    ((TNativeView) container).setUseListMode(true);
                }
                this.f33229a.addContentView(view);
                return container;
            }
        } catch (Throwable th2) {
            AdLogUtil.Log().d("TAdNativeView", "result view is null" + Log.getStackTraceString(th2));
        }
        return view;
    }

    public final void d(View view, TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        View choicesView;
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder == null || viewBinder == null || tAdNativeInfo == null || (choicesView = baseNativeViewHolder.getChoicesView(getContext(), tAdNativeInfo)) == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(viewBinder.adChoicesView);
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                if (this.f33229a instanceof NativeAdViewHolder) {
                    int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R$dimen.ad_badge_height);
                    layoutParams = new FrameLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset);
                }
                viewGroup.addView(choicesView, layoutParams);
            }
        } catch (Exception e11) {
            AdLogUtil.Log().e("TAdNativeView", Log.getStackTraceString(e11));
        }
    }

    public final void e(View view, TAdNativeInfo tAdNativeInfo, ViewBinder viewBinder) {
        View storeMarkView;
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder == null || viewBinder == null || tAdNativeInfo == null || (storeMarkView = baseNativeViewHolder.getStoreMarkView(getContext(), tAdNativeInfo)) == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(viewBinder.adStoreMarkView);
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                if ((viewGroup instanceof TStoreMarkView) && (storeMarkView instanceof StoreMarkView)) {
                    int sdkTypeSetStoreMark = ((TStoreMarkView) viewGroup).getSdkTypeSetStoreMark();
                    int textColor = ((TStoreMarkView) viewGroup).getTextColor();
                    int textSize = ((TStoreMarkView) viewGroup).getTextSize();
                    if (tAdNativeInfo instanceof AdNativeInfo) {
                        ((AdNativeInfo) tAdNativeInfo).setSdkTypeSetStoreMark(sdkTypeSetStoreMark);
                        ((AdNativeInfo) tAdNativeInfo).setStoreMarkTextColor(textColor);
                        ((AdNativeInfo) tAdNativeInfo).setStoreMarkTextSize(textSize);
                    }
                }
                viewGroup.addView(storeMarkView, layoutParams);
            }
        } catch (Exception e11) {
            AdLogUtil.Log().e("TAdNativeView", Log.getStackTraceString(e11));
        }
    }

    public View getIconView(ViewBinder viewBinder) {
        View childAt = getChildCount() > 0 ? getChildAt(0) : null;
        if (childAt == null) {
            return null;
        }
        return childAt.findViewById(viewBinder.iconId);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f33230b) {
            a((TAdNativeInfo) null);
            release();
        }
    }

    public final void release() {
        removeAllViews();
        BaseNativeViewHolder baseNativeViewHolder = this.f33229a;
        if (baseNativeViewHolder != null) {
            baseNativeViewHolder.destroy();
            this.f33229a = null;
        }
        for (int i11 = 0; i11 < this.f33234f.size(); i11++) {
            BaseNativeViewHolder valueAt = this.f33234f.valueAt(i11);
            if (valueAt != null) {
                valueAt.destroy();
            }
        }
        this.f33234f.clear();
    }
}
