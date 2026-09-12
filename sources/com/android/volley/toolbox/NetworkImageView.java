package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.h;

/* loaded from: classes2.dex */
public class NetworkImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private String f19356a;

    /* renamed from: b, reason: collision with root package name */
    private int f19357b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f19358c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f19359d;

    /* renamed from: e, reason: collision with root package name */
    private int f19360e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f19361f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f19362g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.android.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements h.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f19363a;

        AnonymousClass1(boolean z10) {
            this.f19363a = z10;
        }

        public void a(h.b bVar, boolean z10) {
            if (!z10 || !this.f19363a) {
                throw null;
            }
            NetworkImageView.this.post(new Runnable(bVar) { // from class: com.android.volley.toolbox.NetworkImageView.1.1
                final /* synthetic */ h.b val$response;

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1.this.a(null, false);
                }
            });
        }

        @Override // com.android.volley.i.a
        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageView.this.f19360e != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f19360e);
            } else if (NetworkImageView.this.f19361f != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(networkImageView2.f19361f);
            } else if (NetworkImageView.this.f19362g != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(networkImageView3.f19362g);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    private void e() {
        int i11 = this.f19357b;
        if (i11 != 0) {
            setImageResource(i11);
            return;
        }
        Drawable drawable = this.f19358c;
        if (drawable != null) {
            setImageDrawable(drawable);
            return;
        }
        Bitmap bitmap = this.f19359d;
        if (bitmap != null) {
            setImageBitmap(bitmap);
        } else {
            setImageBitmap(null);
        }
    }

    void d(boolean z10) {
        boolean z11;
        boolean z12;
        int width = getWidth();
        int height = getHeight();
        getScaleType();
        if (getLayoutParams() != null) {
            z11 = getLayoutParams().width == -2;
            z12 = getLayoutParams().height == -2;
        } else {
            z11 = false;
            z12 = false;
        }
        boolean z13 = z11 && z12;
        if (width == 0 && height == 0 && !z13) {
            return;
        }
        if (TextUtils.isEmpty(this.f19356a)) {
            e();
        } else {
            new AnonymousClass1(z10);
            throw null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        d(true);
    }

    public void setDefaultImageBitmap(Bitmap bitmap) {
        this.f19357b = 0;
        this.f19358c = null;
        this.f19359d = bitmap;
    }

    public void setDefaultImageDrawable(@Nullable Drawable drawable) {
        this.f19357b = 0;
        this.f19359d = null;
        this.f19358c = drawable;
    }

    public void setDefaultImageResId(int i11) {
        this.f19359d = null;
        this.f19358c = null;
        this.f19357b = i11;
    }

    public void setErrorImageBitmap(Bitmap bitmap) {
        this.f19360e = 0;
        this.f19361f = null;
        this.f19362g = bitmap;
    }

    public void setErrorImageDrawable(@Nullable Drawable drawable) {
        this.f19360e = 0;
        this.f19362g = null;
        this.f19361f = drawable;
    }

    public void setErrorImageResId(int i11) {
        this.f19362g = null;
        this.f19361f = null;
        this.f19360e = i11;
    }

    public void setImageUrl(String str, h hVar) {
        n.a();
        this.f19356a = str;
        d(false);
    }
}
