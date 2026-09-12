package com.transsion.ninegridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.a0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class NineGridView extends ViewGroup {
    public static final int MODE_FILL = 0;
    public static final int MODE_GRID = 1;

    /* renamed from: m, reason: collision with root package name */
    private static pn.b f47682m;

    /* renamed from: a, reason: collision with root package name */
    private int f47683a;

    /* renamed from: b, reason: collision with root package name */
    private float f47684b;

    /* renamed from: c, reason: collision with root package name */
    private int f47685c;

    /* renamed from: d, reason: collision with root package name */
    private int f47686d;

    /* renamed from: e, reason: collision with root package name */
    private int f47687e;

    /* renamed from: f, reason: collision with root package name */
    private int f47688f;

    /* renamed from: g, reason: collision with root package name */
    private int f47689g;

    /* renamed from: h, reason: collision with root package name */
    private int f47690h;

    /* renamed from: i, reason: collision with root package name */
    private int f47691i;

    /* renamed from: j, reason: collision with root package name */
    private List f47692j;

    /* renamed from: k, reason: collision with root package name */
    private List f47693k;

    /* renamed from: l, reason: collision with root package name */
    private NineGridViewAdapter f47694l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f47695a;

        a(int i11) {
            this.f47695a = i11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NineGridViewAdapter nineGridViewAdapter = NineGridView.this.f47694l;
            Context context = NineGridView.this.getContext();
            NineGridView nineGridView = NineGridView.this;
            nineGridViewAdapter.onImageItemClick(context, nineGridView, this.f47695a, nineGridView.f47694l.getImageInfo());
        }
    }

    public NineGridView(Context context) {
        this(context, null);
    }

    public NineGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f47683a = 250;
        this.f47684b = 1.0f;
        this.f47685c = 9;
        this.f47686d = 3;
        this.f47687e = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f47686d = (int) TypedValue.applyDimension(1, this.f47686d, displayMetrics);
        this.f47683a = (int) TypedValue.applyDimension(1, this.f47683a, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        this.f47686d = (int) obtainStyledAttributes.getDimension(R$styleable.NineGridView_ngv_gridSpacing, this.f47686d);
        this.f47683a = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_ngv_singleImageSize, this.f47683a);
        this.f47684b = obtainStyledAttributes.getFloat(R$styleable.NineGridView_ngv_singleImageRatio, this.f47684b);
        this.f47685c = obtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_maxSize, this.f47685c);
        this.f47687e = obtainStyledAttributes.getInt(R$styleable.NineGridView_ngv_mode, this.f47687e);
        obtainStyledAttributes.recycle();
        this.f47692j = new ArrayList();
    }

    private ImageView b(int i11) {
        if (i11 < this.f47692j.size()) {
            return (ImageView) this.f47692j.get(i11);
        }
        ImageView generateImageView = this.f47694l.generateImageView(getContext());
        generateImageView.setOnClickListener(new a(i11));
        this.f47692j.add(generateImageView);
        return generateImageView;
    }

    public static pn.b getImageLoader() {
        return f47682m;
    }

    public static void setImageLoader(pn.b bVar) {
        f47682m = bVar;
    }

    public int getMaxSize() {
        return this.f47685c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        List list = this.f47693k;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i15 = 0; i15 < size; i15++) {
            ImageView imageView = (ImageView) getChildAt(i15);
            int i16 = this.f47688f;
            int paddingLeft = ((this.f47690h + this.f47686d) * (i15 % i16)) + getPaddingLeft();
            int paddingTop = ((this.f47691i + this.f47686d) * (i15 / i16)) + getPaddingTop();
            imageView.layout(paddingLeft, paddingTop, this.f47690h + paddingLeft, this.f47691i + paddingTop);
            pn.b bVar = f47682m;
            if (bVar != null) {
                bVar.a(getContext(), imageView, ((ImageInfo) this.f47693k.get(i15)).bigImageUrl, this.f47690h, this.f47691i, ((ImageInfo) this.f47693k.get(i15)).thumbnailUrl);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        List list = this.f47693k;
        int i13 = 0;
        if (list != null && list.size() > 0) {
            if (this.f47693k.size() == 1) {
                ImageInfo imageInfo = (ImageInfo) this.f47693k.get(0);
                float f11 = imageInfo.imageViewWidth;
                if (f11 > 0.0f) {
                    float f12 = imageInfo.imageViewHeight;
                    if (f12 > 0.0f) {
                        if (f11 > f12) {
                            int min = Math.min(a0.a(216.0f), (int) imageInfo.imageViewWidth);
                            this.f47690h = min;
                            this.f47691i = (min * ((int) imageInfo.imageViewHeight)) / ((int) imageInfo.imageViewWidth);
                        } else {
                            int min2 = Math.min(a0.a(216.0f), (int) imageInfo.imageViewHeight);
                            this.f47691i = min2;
                            this.f47690h = (min2 * ((int) imageInfo.imageViewWidth)) / ((int) imageInfo.imageViewHeight);
                        }
                    }
                }
                int min3 = Math.min(this.f47683a, paddingLeft);
                this.f47690h = min3;
                int i14 = (int) (min3 / this.f47684b);
                this.f47691i = i14;
                int i15 = this.f47683a;
                if (i14 > i15) {
                    this.f47690h = (int) (min3 * ((i15 * 1.0f) / i14));
                    this.f47691i = i15;
                }
            } else {
                int i16 = (paddingLeft - (this.f47686d * 2)) / 3;
                this.f47691i = i16;
                this.f47690h = i16;
            }
            int i17 = this.f47690h;
            int i18 = this.f47688f;
            size = (i17 * i18) + (this.f47686d * (i18 - 1)) + getPaddingLeft() + getPaddingRight();
            int i19 = this.f47691i;
            int i20 = this.f47689g;
            i13 = (i19 * i20) + (this.f47686d * (i20 - 1)) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, i13);
    }

    public void setAdapter(@NonNull NineGridViewAdapter nineGridViewAdapter) {
        this.f47694l = nineGridViewAdapter;
        List<ImageInfo> imageInfo = nineGridViewAdapter.getImageInfo();
        if (imageInfo == null || imageInfo.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int size = imageInfo.size();
        int i11 = this.f47685c;
        if (i11 > 0 && size > i11) {
            imageInfo = imageInfo.subList(0, i11);
            size = imageInfo.size();
        }
        this.f47689g = (size / 3) + (size % 3 == 0 ? 0 : 1);
        this.f47688f = 3;
        if (this.f47687e == 1 && size == 4) {
            this.f47689g = 2;
            this.f47688f = 2;
        }
        List list = this.f47693k;
        if (list == null) {
            for (int i12 = 0; i12 < size; i12++) {
                ImageView b11 = b(i12);
                if (b11 == null) {
                    return;
                }
                addView(b11, generateDefaultLayoutParams());
            }
        } else {
            int size2 = list.size();
            if (size2 > size) {
                removeViews(size, size2 - size);
            } else if (size2 < size) {
                while (size2 < size) {
                    ImageView b12 = b(size2);
                    if (b12 == null) {
                        return;
                    }
                    addView(b12, generateDefaultLayoutParams());
                    size2++;
                }
            }
        }
        int size3 = nineGridViewAdapter.getImageInfo().size();
        int i13 = this.f47685c;
        if (size3 > i13) {
            View childAt = getChildAt(i13 - 1);
            if (childAt instanceof NineGridViewWrapper) {
                ((NineGridViewWrapper) childAt).setMoreNum(nineGridViewAdapter.getImageInfo().size() - this.f47685c);
            }
        }
        this.f47693k = imageInfo;
        requestLayout();
    }

    public void setGridSpacing(int i11) {
        this.f47686d = i11;
    }

    public void setMaxSize(int i11) {
        this.f47685c = i11;
    }

    public void setSingleImageRatio(float f11) {
        this.f47684b = f11;
    }

    public void setSingleImageSize(int i11) {
        this.f47683a = i11;
    }
}
