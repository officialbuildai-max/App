package com.mbridge.msdk.video.dynview.shape;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* loaded from: classes5.dex */
public class a extends ShapeDrawable {

    /* renamed from: a, reason: collision with root package name */
    private int f39124a;

    /* renamed from: b, reason: collision with root package name */
    private float f39125b;

    /* renamed from: c, reason: collision with root package name */
    private float f39126c;

    /* renamed from: d, reason: collision with root package name */
    private int f39127d;

    /* renamed from: e, reason: collision with root package name */
    private int f39128e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f39129f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f39130g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f39131h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f39132i;

    /* renamed from: j, reason: collision with root package name */
    private Matrix f39133j;

    /* loaded from: classes5.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private RectShape f39134a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f39135b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap f39136c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f39137d;

        /* renamed from: e, reason: collision with root package name */
        private int f39138e;

        /* renamed from: f, reason: collision with root package name */
        private int f39139f;

        /* renamed from: g, reason: collision with root package name */
        private int f39140g;

        /* renamed from: h, reason: collision with root package name */
        private float f39141h;

        /* renamed from: i, reason: collision with root package name */
        private float f39142i;

        private b() {
            this.f39139f = 100;
            this.f39140g = 10;
            this.f39134a = new RectShape();
        }

        @Override // com.mbridge.msdk.video.dynview.shape.a.c
        public c a(float f11) {
            this.f39142i = f11;
            return this;
        }

        public c a(int i11) {
            this.f39138e = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.shape.a.c
        public c a(Bitmap bitmap) {
            this.f39136c = bitmap;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.shape.a.c
        public c a(boolean z10) {
            this.f39137d = z10;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public c b(float f11) {
            this.f39141h = f11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.shape.a.c
        public c b(Bitmap bitmap) {
            this.f39135b = bitmap;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        c a(float f11);

        c a(Bitmap bitmap);

        c a(boolean z10);

        c b(Bitmap bitmap);
    }

    private a(b bVar) {
        super(bVar.f39134a);
        this.f39131h = false;
        this.f39129f = bVar.f39135b;
        this.f39130g = bVar.f39136c;
        this.f39131h = bVar.f39137d;
        this.f39124a = bVar.f39138e;
        this.f39127d = bVar.f39139f;
        this.f39128e = bVar.f39140g;
        this.f39125b = bVar.f39141h;
        this.f39126c = bVar.f39142i;
        Paint paint = new Paint();
        this.f39132i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f39132i.setAntiAlias(true);
        this.f39133j = new Matrix();
    }

    public static b a() {
        return new b();
    }

    private void a(Canvas canvas) {
        float f11 = this.f39125b / 2.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, this.f39126c);
        path.lineTo((f11 - this.f39127d) - this.f39128e, this.f39126c);
        path.lineTo((this.f39127d + f11) - this.f39128e, 0.0f);
        if (this.f39131h) {
            try {
                a(canvas, path);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            Bitmap bitmap = this.f39129f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f39129f);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
        Path path2 = new Path();
        path2.moveTo(this.f39127d + f11 + this.f39128e, 0.0f);
        path2.lineTo(this.f39125b, 0.0f);
        path2.lineTo(this.f39125b, this.f39126c);
        path2.lineTo((f11 - this.f39127d) + this.f39128e, this.f39126c);
        if (this.f39131h) {
            try {
                a(canvas, path2);
                return;
            } catch (Exception e13) {
                e13.printStackTrace();
                return;
            }
        }
        Bitmap bitmap2 = this.f39130g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.f39130g);
        } catch (Exception e14) {
            e14.printStackTrace();
        }
    }

    private void a(Canvas canvas, Path path) {
        this.f39132i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.f39132i);
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        if (canvas == null || path == null || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            float max = Math.max(this.f39125b / bitmap.getWidth(), this.f39126c / bitmap.getHeight());
            if (this.f39133j == null) {
                this.f39133j = new Matrix();
            }
            this.f39133j.reset();
            this.f39133j.preScale(max, max);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(this.f39133j);
        this.f39132i.setShader(bitmapShader);
        canvas.drawPath(path, this.f39132i);
    }

    private void b(Canvas canvas) {
        float f11 = this.f39126c / 2.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, (this.f39127d + f11) - this.f39128e);
        path.lineTo(this.f39125b, (f11 - this.f39127d) - this.f39128e);
        path.lineTo(this.f39125b, 0.0f);
        if (this.f39131h) {
            try {
                a(canvas, path);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            Bitmap bitmap = this.f39129f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f39129f);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
        Path path2 = new Path();
        path2.moveTo(0.0f, this.f39127d + f11 + this.f39128e);
        path2.lineTo(0.0f, this.f39126c);
        path2.lineTo(this.f39125b, this.f39126c);
        path2.lineTo(this.f39125b, (f11 - this.f39127d) + this.f39128e);
        if (this.f39131h) {
            try {
                a(canvas, path2);
                return;
            } catch (Exception e13) {
                e13.printStackTrace();
                return;
            }
        }
        Bitmap bitmap2 = this.f39130g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.f39130g);
        } catch (Exception e14) {
            e14.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f39124a == 1) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
