package com.tn.lib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001f\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0013¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0013¢\u0006\u0004\b&\u0010\"J\u0015\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0013¢\u0006\u0004\b(\u0010%J\r\u0010)\u001a\u00020\u0013¢\u0006\u0004\b)\u0010\"J\u0015\u0010+\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0013¢\u0006\u0004\b+\u0010%J\r\u0010,\u001a\u00020\u0013¢\u0006\u0004\b,\u0010\"J\u0015\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0013¢\u0006\u0004\b.\u0010%J\r\u0010/\u001a\u00020\u0013¢\u0006\u0004\b/\u0010\"J\u0015\u00101\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u0013¢\u0006\u0004\b1\u0010%J\r\u00102\u001a\u00020\n¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\n¢\u0006\u0004\b5\u0010\u0019J\u000f\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b:\u0010;J%\u0010?\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\bB\u0010CJ\u0015\u0010E\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020A¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u0004\u0018\u00010A¢\u0006\u0004\bG\u0010CJ\u0015\u0010I\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020A¢\u0006\u0004\bI\u0010FR\u001a\u0010M\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u00103R\u001a\u0010P\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bN\u0010K\u001a\u0004\bO\u00103R\u001a\u0010S\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bQ\u0010K\u001a\u0004\bR\u00103R\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010KR\u0016\u0010X\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010WR\u0016\u0010]\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010\\R\u0016\u0010c\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010\\R\u0016\u0010e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010\\R\u0016\u0010h\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u001e\u0010k\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010n\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010q¨\u0006s"}, d2 = {"Lcom/tn/lib/view/GradientLinePagerIndicator;", "Landroid/view/View;", "Lj00/c;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", RequestParameters.POSITION, "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "", "Lk00/a;", "dataList", "onPositionDataProvide", "(Ljava/util/List;)V", "getYOffset", "()F", "yOffset", "setYOffset", "(F)V", "getXOffset", "xOffset", "setXOffset", "getLineHeight", "lineHeight", "setLineHeight", "getLineWidth", "lineWidth", "setLineWidth", "getRoundRadius", "roundRadius", "setRoundRadius", "getMode", "()I", "mode", "setMode", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "", "getColors", "()[I", "startColor", "centerColor", "endColor", "setColors", "(III)V", "Landroid/view/animation/Interpolator;", "getStartInterpolator", "()Landroid/view/animation/Interpolator;", "startInterpolator", "setStartInterpolator", "(Landroid/view/animation/Interpolator;)V", "getEndInterpolator", "endInterpolator", "setEndInterpolator", "a", "I", "getMODE_MATCH_EDGE", "MODE_MATCH_EDGE", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getMODE_WRAP_CONTENT", "MODE_WRAP_CONTENT", "c", "getMODE_EXACTLY", "MODE_EXACTLY", "d", "mMode", "e", "Landroid/view/animation/Interpolator;", "mStartInterpolator", "f", "mEndInterpolator", be.g.f16474b, "F", "mYOffset", "h", "mLineHeight", "i", "mXOffset", com.mbridge.msdk.foundation.same.report.j.f35620b, "mLineWidth", CampaignEx.JSON_KEY_AD_K, "mRoundRadius", "l", "Landroid/graphics/Paint;", "mPaint", "m", "Ljava/util/List;", "mPositionDataList", "n", "[I", "mColors", "Landroid/graphics/RectF;", "o", "Landroid/graphics/RectF;", "mLineRect", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class GradientLinePagerIndicator extends View implements j00.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int MODE_MATCH_EDGE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int MODE_WRAP_CONTENT;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int MODE_EXACTLY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Interpolator mStartInterpolator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Interpolator mEndInterpolator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mYOffset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mLineHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mXOffset;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float mLineWidth;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float mRoundRadius;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Paint mPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List mPositionDataList;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int[] mColors;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final RectF mLineRect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GradientLinePagerIndicator(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GradientLinePagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradientLinePagerIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.MODE_WRAP_CONTENT = 1;
        this.MODE_EXACTLY = 2;
        this.mStartInterpolator = new LinearInterpolator();
        this.mEndInterpolator = new LinearInterpolator();
        this.mPaint = new Paint(1);
        this.mLineRect = new RectF();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mLineHeight = i00.b.a(context, 3.0d);
        this.mLineWidth = i00.b.a(context, 10.0d);
    }

    /* renamed from: getColors, reason: from getter */
    public final int[] getMColors() {
        return this.mColors;
    }

    /* renamed from: getEndInterpolator, reason: from getter */
    public final Interpolator getMEndInterpolator() {
        return this.mEndInterpolator;
    }

    /* renamed from: getLineHeight, reason: from getter */
    public final float getMLineHeight() {
        return this.mLineHeight;
    }

    /* renamed from: getLineWidth, reason: from getter */
    public final float getMLineWidth() {
        return this.mLineWidth;
    }

    public final int getMODE_EXACTLY() {
        return this.MODE_EXACTLY;
    }

    public final int getMODE_MATCH_EDGE() {
        return this.MODE_MATCH_EDGE;
    }

    public final int getMODE_WRAP_CONTENT() {
        return this.MODE_WRAP_CONTENT;
    }

    /* renamed from: getMode, reason: from getter */
    public final int getMMode() {
        return this.mMode;
    }

    /* renamed from: getPaint, reason: from getter */
    public final Paint getMPaint() {
        return this.mPaint;
    }

    /* renamed from: getRoundRadius, reason: from getter */
    public final float getMRoundRadius() {
        return this.mRoundRadius;
    }

    /* renamed from: getStartInterpolator, reason: from getter */
    public final Interpolator getMStartInterpolator() {
        return this.mStartInterpolator;
    }

    /* renamed from: getXOffset, reason: from getter */
    public final float getMXOffset() {
        return this.mXOffset;
    }

    /* renamed from: getYOffset, reason: from getter */
    public final float getMYOffset() {
        return this.mYOffset;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        RectF rectF = this.mLineRect;
        float f11 = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f11, f11, this.mPaint);
    }

    @Override // j00.c
    public void onPageScrollStateChanged(int state) {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b6  */
    @Override // j00.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPageScrolled(int r10, float r11, int r12) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.lib.view.GradientLinePagerIndicator.onPageScrolled(int, float, int):void");
    }

    @Override // j00.c
    public void onPageSelected(int position) {
    }

    @Override // j00.c
    public void onPositionDataProvide(List<? extends k00.a> dataList) {
        Intrinsics.h(dataList, "dataList");
        this.mPositionDataList = dataList;
    }

    public final void setColors(int startColor, int centerColor, int endColor) {
        this.mColors = new int[]{startColor, centerColor, endColor};
    }

    public final void setEndInterpolator(Interpolator endInterpolator) {
        Intrinsics.h(endInterpolator, "endInterpolator");
        this.mEndInterpolator = endInterpolator;
        if (endInterpolator == null) {
            this.mEndInterpolator = new LinearInterpolator();
        }
    }

    public final void setLineHeight(float lineHeight) {
        this.mLineHeight = lineHeight;
    }

    public final void setLineWidth(float lineWidth) {
        this.mLineWidth = lineWidth;
    }

    public final void setMode(int mode) {
        if (mode == 0 || mode == 1 || mode == 2) {
            this.mMode = mode;
            return;
        }
        throw new IllegalArgumentException("mode " + mode + " not supported.");
    }

    public final void setRoundRadius(float roundRadius) {
        this.mRoundRadius = roundRadius;
    }

    public final void setStartInterpolator(Interpolator startInterpolator) {
        Intrinsics.h(startInterpolator, "startInterpolator");
        this.mStartInterpolator = startInterpolator;
        if (startInterpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public final void setXOffset(float xOffset) {
        this.mXOffset = xOffset;
    }

    public final void setYOffset(float yOffset) {
        this.mYOffset = yOffset;
    }
}
