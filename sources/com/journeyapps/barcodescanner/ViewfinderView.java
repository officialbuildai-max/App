package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.client.android.R$color;
import com.google.zxing.client.android.R$styleable;
import com.google.zxing.k;
import com.journeyapps.barcodescanner.CameraPreview;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.ArrayList;
import java.util.List;
import xe.q;

/* loaded from: classes4.dex */
public class ViewfinderView extends View {

    /* renamed from: n, reason: collision with root package name */
    protected static final int[] f33970n = {0, 64, 128, PsExtractor.AUDIO_STREAM, 255, PsExtractor.AUDIO_STREAM, 128, 64};

    /* renamed from: a, reason: collision with root package name */
    protected final Paint f33971a;

    /* renamed from: b, reason: collision with root package name */
    protected Bitmap f33972b;

    /* renamed from: c, reason: collision with root package name */
    protected int f33973c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f33974d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f33975e;

    /* renamed from: f, reason: collision with root package name */
    protected final int f33976f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f33977g;

    /* renamed from: h, reason: collision with root package name */
    protected int f33978h;

    /* renamed from: i, reason: collision with root package name */
    protected List f33979i;

    /* renamed from: j, reason: collision with root package name */
    protected List f33980j;

    /* renamed from: k, reason: collision with root package name */
    protected CameraPreview f33981k;

    /* renamed from: l, reason: collision with root package name */
    protected Rect f33982l;

    /* renamed from: m, reason: collision with root package name */
    protected q f33983m;

    /* loaded from: classes4.dex */
    class a implements CameraPreview.f {
        a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
            ViewfinderView.this.a();
            ViewfinderView.this.invalidate();
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c(Exception exc) {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33971a = new Paint(1);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_finder);
        this.f33973c = obtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R$color.zxing_viewfinder_mask));
        this.f33974d = obtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_result_view, resources.getColor(R$color.zxing_result_view));
        this.f33975e = obtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R$color.zxing_viewfinder_laser));
        this.f33976f = obtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R$color.zxing_possible_result_points));
        this.f33977g = obtainStyledAttributes.getBoolean(R$styleable.zxing_finder_zxing_viewfinder_laser_visibility, true);
        obtainStyledAttributes.recycle();
        this.f33978h = 0;
        this.f33979i = new ArrayList(20);
        this.f33980j = new ArrayList(20);
    }

    protected void a() {
        CameraPreview cameraPreview = this.f33981k;
        if (cameraPreview == null) {
            return;
        }
        Rect framingRect = cameraPreview.getFramingRect();
        q previewSize = this.f33981k.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f33982l = framingRect;
        this.f33983m = previewSize;
    }

    public void addPossibleResultPoint(k kVar) {
        if (this.f33979i.size() < 20) {
            this.f33979i.add(kVar);
        }
    }

    public void drawResultBitmap(Bitmap bitmap) {
        this.f33972b = bitmap;
        invalidate();
    }

    public void drawViewfinder() {
        Bitmap bitmap = this.f33972b;
        this.f33972b = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        q qVar;
        a();
        Rect rect = this.f33982l;
        if (rect == null || (qVar = this.f33983m) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f33971a.setColor(this.f33972b != null ? this.f33974d : this.f33973c);
        float f11 = width;
        canvas.drawRect(0.0f, 0.0f, f11, rect.top, this.f33971a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f33971a);
        canvas.drawRect(rect.right + 1, rect.top, f11, rect.bottom + 1, this.f33971a);
        canvas.drawRect(0.0f, rect.bottom + 1, f11, height, this.f33971a);
        if (this.f33972b != null) {
            this.f33971a.setAlpha(160);
            canvas.drawBitmap(this.f33972b, (Rect) null, rect, this.f33971a);
            return;
        }
        if (this.f33977g) {
            this.f33971a.setColor(this.f33975e);
            Paint paint = this.f33971a;
            int[] iArr = f33970n;
            paint.setAlpha(iArr[this.f33978h]);
            this.f33978h = (this.f33978h + 1) % iArr.length;
            int height2 = (rect.height() / 2) + rect.top;
            canvas.drawRect(rect.left + 2, height2 - 1, rect.right - 1, height2 + 2, this.f33971a);
        }
        float width2 = getWidth() / qVar.f78357a;
        float height3 = getHeight() / qVar.f78358b;
        if (!this.f33980j.isEmpty()) {
            this.f33971a.setAlpha(80);
            this.f33971a.setColor(this.f33976f);
            for (k kVar : this.f33980j) {
                canvas.drawCircle((int) (kVar.c() * width2), (int) (kVar.d() * height3), 3.0f, this.f33971a);
            }
            this.f33980j.clear();
        }
        if (!this.f33979i.isEmpty()) {
            this.f33971a.setAlpha(160);
            this.f33971a.setColor(this.f33976f);
            for (k kVar2 : this.f33979i) {
                canvas.drawCircle((int) (kVar2.c() * width2), (int) (kVar2.d() * height3), 6.0f, this.f33971a);
            }
            List list = this.f33979i;
            List list2 = this.f33980j;
            this.f33979i = list2;
            this.f33980j = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }

    public void setCameraPreview(CameraPreview cameraPreview) {
        this.f33981k = cameraPreview;
        cameraPreview.addStateListener(new a());
    }

    public void setLaserVisibility(boolean z10) {
        this.f33977g = z10;
    }

    public void setMaskColor(int i11) {
        this.f33973c = i11;
    }
}
