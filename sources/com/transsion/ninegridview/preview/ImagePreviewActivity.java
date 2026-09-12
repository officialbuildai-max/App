package com.transsion.ninegridview.preview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.photoview.PhotoView;
import com.transsion.web.api.WebConstants;
import com.transsion.web.share.ImageShareDialog;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import oh.c;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001`B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u0006JI\u0010*\u001a\u00020\u000728\u0010)\u001a4\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00070\"H\u0002¢\u0006\u0004\b*\u0010+J\u0011\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u000102H\u0015¢\u0006\u0004\b4\u00105J\u0011\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020#H\u0016¢\u0006\u0004\b9\u0010:J-\u0010@\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00182\f\u0010=\u001a\b\u0012\u0004\u0012\u00020,0<2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020#H\u0016¢\u0006\u0004\bB\u0010:J\u000f\u0010C\u001a\u00020\u0007H\u0016¢\u0006\u0004\bC\u0010\u0006J\u000f\u0010D\u001a\u00020#H\u0016¢\u0006\u0004\bD\u0010:J\r\u0010E\u001a\u00020\u0007¢\u0006\u0004\bE\u0010\u0006J\u0017\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00072\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bJ\u0010IJ\u000f\u0010K\u001a\u00020\u0007H\u0016¢\u0006\u0004\bK\u0010\u0006R\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020S0R8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010WR\u0016\u0010Y\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010WR\u0016\u0010Z\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010WR\u0016\u0010[\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010WR\u0014\u0010\\\u001a\u00020,8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]¨\u0006a"}, d2 = {"Lcom/transsion/ninegridview/preview/ImagePreviewActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lon/b;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", "", "imageShareClick", "Landroid/net/Uri;", "imageUri", "shareImage", "(Landroid/net/Uri;)V", "showSettingDialog", "Landroid/widget/ImageView;", "imageView", "computeImageWidthAndHeight", "(Landroid/widget/ImageView;)V", "Landroid/animation/ValueAnimator;", "valueAnimator", "addIntoListener", "(Landroid/animation/ValueAnimator;)V", "", "fraction", "", "startValue", "endValue", "evaluateInt", "(FII)I", "", "evaluateFloat", "(FLjava/lang/Number;Ljava/lang/Number;)F", "evaluateArgb", "downloadImage", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "exit", "Ljava/io/File;", "imgFile", "callback", "saveToAlbum", "(Lkotlin/jvm/functions/Function2;)V", "", "getCurImgUrl", "()Ljava/lang/String;", "startEnterTheAnimation", "getViewBinding", "()Lon/b;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "isTranslucent", "()Z", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "isAttach", "onBackPressed", "onPreDraw", "finishActivityAnim", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "onConnected", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/transsion/ninegridview/preview/q;", "imagePreviewAdapter", "Lcom/transsion/ninegridview/preview/q;", "", "Lcom/transsion/ninegridview/ImageInfo;", "imageInfoList", "Ljava/util/List;", "currentItem", "I", "imageHeight", "imageWidth", "screenWidth", "screenHeight", "PAGE_NAME", "Ljava/lang/String;", "pageFrom", "Companion", "a", "NineGridView_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ImagePreviewActivity extends BaseActivity<on.b> implements ViewTreeObserver.OnPreDrawListener, TRDialogListener {
    public static final int ANIMATE_DURATION = 200;
    public static final String CURRENT_ITEM = "CURRENT_ITEM";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IMAGE_INFO = "IMAGE_INFO";
    private final String PAGE_NAME = "image_preview";
    private int currentItem;
    private int imageHeight;
    private List<? extends ImageInfo> imageInfoList;
    private q imagePreviewAdapter;
    private int imageWidth;
    private String pageFrom;
    private ConstraintLayout rootView;
    private int screenHeight;
    private int screenWidth;

    /* renamed from: com.transsion.ninegridview.preview.ImagePreviewActivity$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i11, List list) {
            Intrinsics.h(context, "context");
            Intent intent = new Intent(context, (Class<?>) ImagePreviewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(ImagePreviewActivity.IMAGE_INFO, (Serializable) list);
            bundle.putInt("CURRENT_ITEM", i11);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.h(animation, "animation");
            ConstraintLayout constraintLayout = ImagePreviewActivity.this.rootView;
            if (constraintLayout == null) {
                Intrinsics.z("rootView");
                constraintLayout = null;
            }
            constraintLayout.setBackgroundColor(0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.h(animation, "animation");
            ImagePreviewActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.h(animation, "animation");
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends ViewPager.k {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f47762b;

        d(TextView textView) {
            this.f47762b = textView;
        }

        @Override // androidx.viewpager.widget.ViewPager.k, androidx.viewpager.widget.ViewPager.h
        public void onPageSelected(int i11) {
            ImagePreviewActivity.this.currentItem = i11;
            TextView textView = this.f47762b;
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            Integer valueOf = Integer.valueOf(ImagePreviewActivity.this.currentItem + 1);
            List list = ImagePreviewActivity.this.imageInfoList;
            if (list == null) {
                Intrinsics.z("imageInfoList");
                list = null;
            }
            String format = String.format("%d/%d", Arrays.copyOf(new Object[]{valueOf, Integer.valueOf(list.size())}, 2));
            Intrinsics.g(format, "format(...)");
            textView.setText(format);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.h(animation, "animation");
            ConstraintLayout constraintLayout = ImagePreviewActivity.this.rootView;
            if (constraintLayout == null) {
                Intrinsics.z("rootView");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.h(animation, "animation");
        }
    }

    private final void addIntoListener(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new b());
    }

    private final void computeImageWidthAndHeight(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (drawable != null) {
            height = drawable.getIntrinsicHeight();
            width = drawable.getIntrinsicWidth();
        }
        float f11 = height;
        float f12 = (this.screenHeight * 1.0f) / f11;
        float f13 = width;
        float f14 = (this.screenWidth * 1.0f) / f13;
        if (f12 > f14) {
            f12 = f14;
        }
        this.imageHeight = (int) (f11 * f12);
        this.imageWidth = (int) (f13 * f12);
    }

    private final void downloadImage() {
        saveToAlbum(new Function2() { // from class: com.transsion.ninegridview.preview.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit downloadImage$lambda$7;
                downloadImage$lambda$7 = ImagePreviewActivity.downloadImage$lambda$7(((Boolean) obj).booleanValue(), (File) obj2);
                return downloadImage$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadImage$lambda$7(boolean z10, File file) {
        if (z10) {
            uh.b.f76876a.d(R$string.has_been_saved);
        } else {
            uh.b.f76876a.d(R$string.image_save_success);
        }
        return Unit.f67184a;
    }

    private final int evaluateArgb(float fraction, int startValue, int endValue) {
        return ((((startValue >> 24) & 255) + ((int) ((((endValue >> 24) & 255) - r0) * fraction))) << 24) | ((((startValue >> 16) & 255) + ((int) ((((endValue >> 16) & 255) - r1) * fraction))) << 16) | ((((startValue >> 8) & 255) + ((int) ((((endValue >> 8) & 255) - r2) * fraction))) << 8) | ((startValue & 255) + ((int) (fraction * ((endValue & 255) - r8))));
    }

    private final float evaluateFloat(float fraction, Number startValue, Number endValue) {
        float floatValue = startValue.floatValue();
        return floatValue + (fraction * (endValue.floatValue() - floatValue));
    }

    private final int evaluateInt(float fraction, int startValue, int endValue) {
        return (int) (startValue + (fraction * (endValue - startValue)));
    }

    private final String getCurImgUrl() {
        int i11 = this.currentItem;
        List<? extends ImageInfo> list = this.imageInfoList;
        List<? extends ImageInfo> list2 = null;
        if (list == null) {
            Intrinsics.z("imageInfoList");
            list = null;
        }
        if (i11 >= list.size() || this.currentItem < 0) {
            return null;
        }
        List<? extends ImageInfo> list3 = this.imageInfoList;
        if (list3 == null) {
            Intrinsics.z("imageInfoList");
        } else {
            list2 = list3;
        }
        return list2.get(this.currentItem).bigImageUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void imageShareClick() {
        ((on.b) getMViewBinding()).f71172c.setEnabled(false);
        final long currentTimeMillis = System.currentTimeMillis();
        saveToAlbum(new Function2() { // from class: com.transsion.ninegridview.preview.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit imageShareClick$lambda$5;
                imageShareClick$lambda$5 = ImagePreviewActivity.imageShareClick$lambda$5(ImagePreviewActivity.this, currentTimeMillis, ((Boolean) obj).booleanValue(), (File) obj2);
                return imageShareClick$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit imageShareClick$lambda$5(ImagePreviewActivity imagePreviewActivity, long j11, boolean z10, File file) {
        if (file != null) {
            Uri uriForFile = FileProvider.getUriForFile(imagePreviewActivity, imagePreviewActivity.getApplication().getPackageName() + ".download.fileprovider", file);
            Intrinsics.e(uriForFile);
            imagePreviewActivity.shareImage(uriForFile);
        } else {
            com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.web.R$string.share_failed_tips);
        }
        ((on.b) imagePreviewActivity.getMViewBinding()).f71172c.setEnabled(true);
        long currentTimeMillis = System.currentTimeMillis() - j11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("share: 耗时=");
        sb2.append(currentTimeMillis);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(final ImagePreviewActivity imagePreviewActivity, View view) {
        com.transsion.baseui.util.d.b(0L, new Function0() { // from class: com.transsion.ninegridview.preview.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onCreate$lambda$2$lambda$1;
                onCreate$lambda$2$lambda$1 = ImagePreviewActivity.onCreate$lambda$2$lambda$1(ImagePreviewActivity.this);
                return onCreate$lambda$2$lambda$1;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2$lambda$1(ImagePreviewActivity imagePreviewActivity) {
        hj.i.f64628a.p(imagePreviewActivity.PAGE_NAME, MapsKt.l(TuplesKt.a("module_name", "save_picture"), TuplesKt.a(WebConstants.PAGE_FROM, imagePreviewActivity.pageFrom)));
        imagePreviewActivity.downloadImage();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(final ImagePreviewActivity imagePreviewActivity, View v11) {
        Intrinsics.h(v11, "v");
        com.transsion.baseui.util.d.b(0L, new Function0() { // from class: com.transsion.ninegridview.preview.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onCreate$lambda$4$lambda$3;
                onCreate$lambda$4$lambda$3 = ImagePreviewActivity.onCreate$lambda$4$lambda$3(ImagePreviewActivity.this);
                return onCreate$lambda$4$lambda$3;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$4$lambda$3(ImagePreviewActivity imagePreviewActivity) {
        com.transsion.baselib.helper.a.f43316a.h(imagePreviewActivity.PAGE_NAME, "share", (r16 & 4) != 0 ? "" : null, (r16 & 8) != 0 ? "" : null, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? null : null);
        imagePreviewActivity.imageShareClick();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreDraw$lambda$6(View view, ImagePreviewActivity imagePreviewActivity, ImageInfo imageInfo, ImageView imageView, float f11, float f12, ValueAnimator animation) {
        Intrinsics.h(animation, "animation");
        long duration = animation.getDuration();
        float currentPlayTime = duration > 0 ? ((float) animation.getCurrentPlayTime()) / ((float) duration) : 1.0f;
        float f13 = currentPlayTime <= 1.0f ? currentPlayTime : 1.0f;
        try {
            view.setTranslationX(imagePreviewActivity.evaluateInt(f13, (imageInfo.imageViewX + (((int) imageInfo.imageViewWidth) / 2)) - (imageView.getWidth() / 2), 0));
            view.setTranslationY(imagePreviewActivity.evaluateInt(f13, (imageInfo.imageViewY + (((int) imageInfo.imageViewHeight) / 2)) - (imageView.getHeight() / 2), 0));
            view.setScaleX(imagePreviewActivity.evaluateFloat(f13, Float.valueOf(f11), 1));
            view.setScaleY(imagePreviewActivity.evaluateFloat(f13, Float.valueOf(f12), 1));
            view.setAlpha(f13);
            ConstraintLayout constraintLayout = imagePreviewActivity.rootView;
            if (constraintLayout == null) {
                Intrinsics.z("rootView");
                constraintLayout = null;
            }
            constraintLayout.setBackgroundColor(imagePreviewActivity.evaluateArgb(f13, 0, ViewCompat.MEASURED_STATE_MASK));
        } catch (Exception e11) {
            String stackTraceString = Log.getStackTraceString(e11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onAnimationUpdate: e = ");
            sb2.append(stackTraceString);
        }
    }

    private final void saveToAlbum(Function2<? super Boolean, ? super File, Unit> callback) {
        FileHelper fileHelper = FileHelper.f47736a;
        c.a aVar = oh.c.f71140a;
        q qVar = this.imagePreviewAdapter;
        if (qVar == null) {
            Intrinsics.z("imagePreviewAdapter");
            qVar = null;
        }
        PhotoView e11 = qVar.e();
        Intrinsics.g(e11, "gePhotoView(...)");
        fileHelper.r(this, aVar.a(e11), fileHelper.j(getCurImgUrl()), callback);
    }

    private final void shareImage(Uri imageUri) {
        try {
            if (getSupportFragmentManager().k0("ImageShareDialog") != null) {
                return;
            }
            ImageShareDialog a11 = ImageShareDialog.INSTANCE.a(imageUri);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
            a11.show(supportFragmentManager, "ImageShareDialog");
        } catch (Exception unused) {
            com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.web.R$string.share_failed_tips);
        }
    }

    private final void showSettingDialog() {
        String string = Utils.a().getString(R$string.permission_deny_down_tip, "\"" + Utils.a().getString(com.transsion.baseui.R$string.base_app_name) + "\"", "\"" + Utils.a().getString(R$string.system_settings) + "\"");
        Intrinsics.g(string, "getString(...)");
        TRDialog.a g11 = new TRDialog.a().g(string);
        String string2 = Utils.a().getString(R$string.cancel);
        Intrinsics.g(string2, "getString(...)");
        TRDialog.a e11 = g11.e(string2);
        String string3 = Utils.a().getString(R$string.system_settings);
        Intrinsics.g(string3, "getString(...)");
        e11.j(string3).f(this).a().show(getSupportFragmentManager(), "settings");
    }

    private final void startEnterTheAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new e());
        alphaAnimation.setFillAfter(true);
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.z("rootView");
            constraintLayout = null;
        }
        constraintLayout.startAnimation(alphaAnimation);
    }

    public final void finishActivityAnim() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new c());
        alphaAnimation.setFillAfter(true);
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.z("rootView");
            constraintLayout = null;
        }
        constraintLayout.startAnimation(alphaAnimation);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public on.b getViewBinding() {
        on.b c11 = on.b.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isAttach() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public hj.b newLogViewConfig() {
        return new hj.b("image_preview", false, 2, null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishActivityAnim();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, nh.n
    public void onConnected() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"DefaultLocale"})
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        this.pageFrom = hj.i.f64628a.i();
        HackyViewPager viewPager = ((on.b) getMViewBinding()).f71179j;
        Intrinsics.g(viewPager, "viewPager");
        TextView tvPager = ((on.b) getMViewBinding()).f71177h;
        Intrinsics.g(tvPager, "tvPager");
        this.rootView = ((on.b) getMViewBinding()).f71174e;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        Intent intent = getIntent();
        Serializable serializableExtra = intent.getSerializableExtra(IMAGE_INFO);
        List<? extends ImageInfo> list = null;
        List<? extends ImageInfo> list2 = serializableExtra instanceof List ? (List) serializableExtra : null;
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        this.imageInfoList = list2;
        this.currentItem = intent.getIntExtra("CURRENT_ITEM", 0);
        List<? extends ImageInfo> list3 = this.imageInfoList;
        if (list3 == null) {
            Intrinsics.z("imageInfoList");
            list3 = null;
        }
        q qVar = new q(this, list3);
        this.imagePreviewAdapter = qVar;
        viewPager.setAdapter(qVar);
        viewPager.setCurrentItem(this.currentItem);
        startEnterTheAnimation();
        viewPager.addOnPageChangeListener(new d(tvPager));
        List<? extends ImageInfo> list4 = this.imageInfoList;
        if (list4 == null) {
            Intrinsics.z("imageInfoList");
            list4 = null;
        }
        if (list4.size() < 2) {
            tvPager.setVisibility(8);
        } else {
            tvPager.setVisibility(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            Integer valueOf = Integer.valueOf(this.currentItem + 1);
            List<? extends ImageInfo> list5 = this.imageInfoList;
            if (list5 == null) {
                Intrinsics.z("imageInfoList");
            } else {
                list = list5;
            }
            String format = String.format("%d/%d", Arrays.copyOf(new Object[]{valueOf, Integer.valueOf(list.size())}, 2));
            Intrinsics.g(format, "format(...)");
            tvPager.setText(format);
        }
        ((on.b) getMViewBinding()).f71173d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePreviewActivity.this.finishActivityAnim();
            }
        });
        ((on.b) getMViewBinding()).f71171b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePreviewActivity.onCreate$lambda$2(ImagePreviewActivity.this, view);
            }
        });
        ((on.b) getMViewBinding()).f71172c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePreviewActivity.onCreate$lambda$4(ImagePreviewActivity.this, view);
            }
        });
        ((on.b) getMViewBinding()).f71175f.getLayoutParams().height = com.blankj.utilcode.util.d.c();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ((on.b) getMViewBinding()).f71174e.getViewTreeObserver().removeOnPreDrawListener(this);
        q qVar = this.imagePreviewAdapter;
        List<? extends ImageInfo> list = null;
        if (qVar == null) {
            Intrinsics.z("imagePreviewAdapter");
            qVar = null;
        }
        final View g11 = qVar.g();
        q qVar2 = this.imagePreviewAdapter;
        if (qVar2 == null) {
            Intrinsics.z("imagePreviewAdapter");
            qVar2 = null;
        }
        final ImageView f11 = qVar2.f();
        Intrinsics.e(f11);
        computeImageWidthAndHeight(f11);
        List<? extends ImageInfo> list2 = this.imageInfoList;
        if (list2 == null) {
            Intrinsics.z("imageInfoList");
        } else {
            list = list2;
        }
        final ImageInfo imageInfo = list.get(this.currentItem);
        final float f12 = (imageInfo.imageViewWidth * 1.0f) / this.imageWidth;
        final float f13 = (imageInfo.imageViewHeight * 1.0f) / this.imageHeight;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.ninegridview.preview.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ImagePreviewActivity.onPreDraw$lambda$6(g11, this, imageInfo, f11, f12, f13, valueAnimator);
            }
        });
        Intrinsics.e(ofFloat);
        addIntoListener(ofFloat);
        ofFloat.setDuration(200L);
        ofFloat.start();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FileHelper.f47736a.l()) {
            if (grantResults.length > 1 && grantResults[0] == 0 && grantResults[1] == 0) {
                downloadImage();
            } else {
                if (ActivityCompat.j(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    return;
                }
                showSettingDialog();
            }
        }
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
        com.transsion.ninegridview.helper.b.f47745a.a(this, 101);
    }
}
