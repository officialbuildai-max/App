package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.engine.b;
import com.mbridge.msdk.dycreator.engine.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.transsion.gslb.Utils;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class MBCusRoundImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private int f34601a;

    /* renamed from: b, reason: collision with root package name */
    private int f34602b;

    /* renamed from: c, reason: collision with root package name */
    private int f34603c;

    /* renamed from: d, reason: collision with root package name */
    private int f34604d;

    /* renamed from: e, reason: collision with root package name */
    private Xfermode f34605e;

    /* renamed from: f, reason: collision with root package name */
    private int f34606f;

    /* renamed from: g, reason: collision with root package name */
    private int f34607g;

    /* renamed from: h, reason: collision with root package name */
    private int f34608h;

    /* renamed from: i, reason: collision with root package name */
    private int f34609i;

    /* renamed from: j, reason: collision with root package name */
    private int f34610j;

    /* renamed from: k, reason: collision with root package name */
    private int f34611k;

    /* renamed from: l, reason: collision with root package name */
    private int f34612l;

    /* renamed from: m, reason: collision with root package name */
    private int f34613m;

    /* renamed from: n, reason: collision with root package name */
    private int f34614n;

    /* renamed from: o, reason: collision with root package name */
    private float[] f34615o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f34616p;

    /* renamed from: q, reason: collision with root package name */
    private RectF f34617q;

    /* renamed from: r, reason: collision with root package name */
    private RectF f34618r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f34619s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f34620t;

    /* renamed from: u, reason: collision with root package name */
    private Path f34621u;

    /* renamed from: v, reason: collision with root package name */
    private Paint f34622v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34623a;

        static {
            int[] iArr = new int[c.values().length];
            f34623a = iArr;
            try {
                iArr[c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34623a[c.src.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34623a[c.background.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34623a[c.contentDescription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34623a[c.tag.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34623a[c.visibility.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34623a[c.scaleType.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34623a[c.padding.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34623a[c.paddingTop.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34623a[c.paddingBottom.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f34623a[c.paddingLeft.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f34623a[c.paddingRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f34623a[c.layout_width.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f34623a[c.layout_height.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f34623a[c.gravity.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f34623a[c.layout_gravity.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public MBCusRoundImageView(Context context) {
        this(context, null);
    }

    public MBCusRoundImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
        try {
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(context, attributeSet));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public MBCusRoundImageView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34621u = new Path();
        this.f34622v = new Paint();
        this.f34615o = new float[8];
        this.f34616p = new float[8];
        this.f34618r = new RectF();
        this.f34617q = new RectF();
        this.f34605e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    private void a() {
        if (this.f34615o == null || this.f34616p == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            try {
                float[] fArr = this.f34615o;
                if (i11 >= fArr.length) {
                    return;
                }
                float f11 = this.f34608h;
                fArr[i11] = f11;
                this.f34616p[i11] = f11 - (this.f34613m / 2.0f);
                i11++;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
    }

    private void a(int i11, int i12) {
        Path path = this.f34621u;
        if (path != null) {
            path.reset();
        }
        Paint paint = this.f34622v;
        if (paint != null) {
            paint.setStrokeWidth(i11);
            this.f34622v.setColor(i12);
            this.f34622v.setStyle(Paint.Style.STROKE);
        }
    }

    private void a(Canvas canvas) {
        a(canvas, this.f34613m, this.f34614n, this.f34618r, this.f34615o);
    }

    private void a(Canvas canvas, int i11, int i12, RectF rectF, float[] fArr) {
        try {
            a(i11, i12);
            Path path = this.f34621u;
            if (path != null) {
                path.addRoundRect(rectF, fArr, Path.Direction.CCW);
            }
            if (canvas != null) {
                canvas.drawPath(this.f34621u, this.f34622v);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void b() {
        int i11;
        int i12;
        int i13;
        try {
            if (this.f34615o == null || this.f34616p == null) {
                return;
            }
            int i14 = 0;
            while (true) {
                i11 = 2;
                if (i14 >= 2) {
                    break;
                }
                float[] fArr = this.f34615o;
                float f11 = this.f34609i;
                fArr[i14] = f11;
                this.f34616p[i14] = f11 - (this.f34613m / 2.0f);
                i14++;
            }
            while (true) {
                i12 = 4;
                if (i11 >= 4) {
                    break;
                }
                float[] fArr2 = this.f34615o;
                float f12 = this.f34610j;
                fArr2[i11] = f12;
                this.f34616p[i11] = f12 - (this.f34613m / 2.0f);
                i11++;
            }
            while (true) {
                if (i12 >= 6) {
                    break;
                }
                float[] fArr3 = this.f34615o;
                float f13 = this.f34611k;
                fArr3[i12] = f13;
                this.f34616p[i12] = f13 - (this.f34613m / 2.0f);
                i12++;
            }
            for (i13 = 6; i13 < 8; i13++) {
                float[] fArr4 = this.f34615o;
                float f14 = this.f34612l;
                fArr4[i13] = f14;
                this.f34616p[i13] = f14 - (this.f34613m / 2.0f);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void c() {
        RectF rectF = this.f34618r;
        if (rectF != null) {
            float f11 = this.f34613m / 2.0f;
            rectF.set(f11, f11, this.f34606f - f11, this.f34607g - f11);
        }
    }

    private void d() {
        RectF rectF = this.f34617q;
        if (rectF != null) {
            rectF.set(0.0f, 0.0f, this.f34606f, this.f34607g);
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HashMap<String, c> c11 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            c cVar = c11.get(attributeSet.getAttributeName(i11));
            if (cVar != null) {
                int i12 = AnonymousClass1.f34623a[cVar.ordinal()];
                if (i12 == 6) {
                    String attributeValue = attributeSet.getAttributeValue(i11);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                } else if (i12 == 13) {
                    String attributeValue2 = attributeSet.getAttributeValue(i11);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().a(attributeValue2);
                    }
                } else if (i12 == 14) {
                    String attributeValue3 = attributeSet.getAttributeValue(i11);
                    if (attributeValue3.startsWith("f") || attributeValue3.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue3.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().a(attributeValue3);
                    }
                }
            }
        }
        return layoutParams;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            canvas.saveLayer(this.f34617q, null, 31);
            int i11 = this.f34606f;
            int i12 = this.f34613m * 2;
            float f11 = (i11 - i12) * 1.0f;
            float f12 = i11;
            float f13 = this.f34607g;
            canvas.scale(f11 / f12, ((r5 - i12) * 1.0f) / f13, f12 / 2.0f, f13 / 2.0f);
            super.onDraw(canvas);
            Paint paint = this.f34622v;
            if (paint != null) {
                paint.reset();
                this.f34622v.setAntiAlias(true);
                this.f34622v.setStyle(Paint.Style.FILL);
                this.f34622v.setXfermode(this.f34605e);
            }
            Path path = this.f34621u;
            if (path != null) {
                path.reset();
                this.f34621u.addRoundRect(this.f34617q, this.f34616p, Path.Direction.CCW);
            }
            canvas.drawPath(this.f34621u, this.f34622v);
            Paint paint2 = this.f34622v;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restore();
            if (this.f34619s) {
                a(canvas);
            }
        } catch (Exception e11) {
            o0.a("MBridgeImageView", e11.getMessage());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        try {
            this.f34606f = i11;
            this.f34607g = i12;
            if (this.f34620t) {
                b();
            } else {
                a();
            }
            c();
            d();
        } catch (Exception e11) {
            o0.b("MBridgeImageView", e11.getMessage());
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, c> c11 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            c cVar = c11.get(attributeSet.getAttributeName(i11));
            if (cVar != null) {
                switch (AnonymousClass1.f34623a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i11);
                        if (attributeValue.startsWith("@+id/")) {
                            setId(attributeValue.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        b.a().a(attributeSet.getAttributeValue(i11), this);
                        break;
                    case 3:
                        String attributeValue2 = attributeSet.getAttributeValue(i11);
                        if (attributeValue2.startsWith(Utils.SEPARATOR)) {
                            try {
                                strArr = attributeValue2.split("-");
                            } catch (Exception unused) {
                                strArr = null;
                            }
                            if (strArr == null || strArr.length > 2) {
                                if (strArr == null || strArr.length != 3) {
                                    setBackgroundColor(b.a().d(attributeSet.getAttributeValue(i11)));
                                    break;
                                } else {
                                    try {
                                        GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
                                        gradientDrawable.setGradientType(0);
                                        setBackground(gradientDrawable);
                                        break;
                                    } catch (Exception unused2) {
                                        setBackgroundColor(b.a().d(attributeSet.getAttributeValue(i11)));
                                        break;
                                    }
                                }
                            } else {
                                setBackgroundColor(b.a().d(attributeSet.getAttributeValue(i11)));
                                break;
                            }
                        } else {
                            if (attributeValue2.startsWith("@drawable/")) {
                                attributeValue2 = attributeValue2.substring(10);
                            }
                            setBackgroundResource(getResources().getIdentifier(attributeValue2, "drawable", getContext().getPackageName()));
                            break;
                        }
                        break;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i11);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            break;
                        } else {
                            CharSequence charSequence = (String) com.mbridge.msdk.dycreator.utils.b.f34949a.get(attributeValue3.substring(8));
                            if (TextUtils.isEmpty(charSequence)) {
                                break;
                            } else {
                                setContentDescription(charSequence);
                                break;
                            }
                        }
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i11);
                        if (TextUtils.isEmpty(attributeValue4)) {
                            break;
                        } else {
                            String str = com.mbridge.msdk.dycreator.utils.b.f34949a.get(attributeValue4.substring(8));
                            if (TextUtils.isEmpty(str)) {
                                break;
                            } else {
                                setTag(str);
                                break;
                            }
                        }
                    case 6:
                        String attributeValue5 = attributeSet.getAttributeValue(i11);
                        if (TextUtils.isEmpty(attributeValue5)) {
                            break;
                        } else if (attributeValue5.equals("invisible")) {
                            setVisibility(4);
                            break;
                        } else if (attributeValue5.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        String attributeValue6 = attributeSet.getAttributeValue(i11);
                        if (TextUtils.isEmpty(attributeValue6)) {
                            break;
                        } else if (attributeValue6.equals("fitXY")) {
                            setScaleType(ImageView.ScaleType.FIT_XY);
                            break;
                        } else if (attributeValue6.equals("centerInside")) {
                            setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            break;
                        } else if (attributeValue6.equals("centerCrop")) {
                            setScaleType(ImageView.ScaleType.CENTER_CROP);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        int a11 = b.a().a(attributeSet.getAttributeValue(i11));
                        this.f34604d = a11;
                        this.f34603c = a11;
                        this.f34602b = a11;
                        this.f34601a = a11;
                        setPadding(a11, a11, a11, a11);
                        break;
                    case 9:
                        int a12 = b.a().a(attributeSet.getAttributeValue(i11));
                        this.f34602b = a12;
                        setPadding(this.f34601a, a12, this.f34603c, this.f34604d);
                        break;
                    case 10:
                        int a13 = b.a().a(attributeSet.getAttributeValue(i11));
                        this.f34604d = a13;
                        setPadding(this.f34601a, this.f34602b, this.f34603c, a13);
                        break;
                    case 11:
                        int a14 = b.a().a(attributeSet.getAttributeValue(i11));
                        this.f34601a = a14;
                        setPadding(a14, this.f34602b, this.f34603c, this.f34604d);
                        break;
                    case 12:
                        int a15 = b.a().a(attributeSet.getAttributeValue(i11));
                        this.f34603c = a15;
                        setPadding(this.f34601a, this.f34602b, a15, this.f34604d);
                        break;
                }
            }
        }
    }

    public void setBorder(int i11, int i12, int i13) {
        this.f34619s = true;
        this.f34613m = i12;
        this.f34614n = i13;
        this.f34608h = i11;
    }

    public void setCornerRadius(int i11) {
        this.f34608h = i11;
    }

    public void setCustomBorder(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f34619s = true;
        this.f34620t = true;
        this.f34613m = i15;
        this.f34614n = i16;
        this.f34609i = i11;
        this.f34611k = i13;
        this.f34610j = i12;
        this.f34612l = i14;
    }
}
