package com.hisavana.mediation.ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.sdk.commonutil.util.h;
import com.hisavana.mediation.R$styleable;

/* loaded from: classes4.dex */
public class TStoreMarkView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f33238a;

    /* renamed from: b, reason: collision with root package name */
    public int f33239b;

    /* renamed from: c, reason: collision with root package name */
    public int f33240c;

    public TStoreMarkView(@NonNull Context context) {
        this(context, null);
    }

    public TStoreMarkView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TStoreMarkView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TStoreMarkView);
            this.f33238a = obtainStyledAttributes.getInt(R$styleable.TStoreMarkView_sdkTypeSetStoreMark, 0);
            this.f33240c = obtainStyledAttributes.getColor(R$styleable.TStoreMarkView_storeTextColor, -1);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TStoreMarkView_storeTextSize, 0);
            this.f33239b = dimensionPixelSize == 0 ? 8 : h.h(dimensionPixelSize);
            obtainStyledAttributes.recycle();
        }
    }

    public int getSdkTypeSetStoreMark() {
        return this.f33238a;
    }

    public int getTextColor() {
        return this.f33240c;
    }

    public int getTextSize() {
        return this.f33239b;
    }
}
