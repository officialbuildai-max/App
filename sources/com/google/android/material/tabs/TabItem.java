package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.j0;
import com.google.android.material.R$styleable;

/* loaded from: classes4.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j0 u11 = j0.u(context, attributeSet, R$styleable.TabItem);
        this.text = u11.p(R$styleable.TabItem_android_text);
        this.icon = u11.g(R$styleable.TabItem_android_icon);
        this.customLayout = u11.n(R$styleable.TabItem_android_layout, 0);
        u11.x();
    }
}
