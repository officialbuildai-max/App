package com.cloud.hisavana.sdk.common.widget.expandmenu;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$string;

/* loaded from: classes3.dex */
public class AdExpandMenuItemView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f22329a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f22330b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f22331c;

    /* loaded from: classes3.dex */
    public enum Type {
        PERSONALISE_CLOSE,
        ADVERTISER_INFO,
        COPY_LINK
    }

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f22332a;

        static {
            int[] iArr = new int[Type.values().length];
            f22332a = iArr;
            try {
                iArr[Type.PERSONALISE_CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22332a[Type.ADVERTISER_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22332a[Type.COPY_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AdExpandMenuItemView(Context context) {
        this(context, null, 0);
    }

    public AdExpandMenuItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdExpandMenuItemView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.ad_expand_menu_item_layout, this);
        a();
    }

    private void a() {
        this.f22329a = (ImageView) findViewById(R$id.left_image_view);
        this.f22330b = (TextView) findViewById(R$id.message_text_view);
        this.f22331c = (ImageView) findViewById(R$id.right_image_view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setBackgroundColor(Color.parseColor("#F7F7F8"));
        } else if (action == 1 || action == 3) {
            setBackgroundColor(-1);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setData(Type type) {
        if (this.f22329a == null || this.f22330b == null || this.f22331c == null) {
            return;
        }
        int i11 = a.f22332a[type.ordinal()];
        if (i11 == 1) {
            this.f22329a.setImageResource(R$drawable.hs_ad_heart);
            this.f22330b.setText(R$string.interstitial_close);
            this.f22331c.setVisibility(0);
        } else if (i11 == 2) {
            this.f22329a.setImageResource(R$drawable.hs_ad_info);
            this.f22330b.setText(R$string.about_the_advertiser);
            this.f22331c.setVisibility(0);
        } else {
            if (i11 != 3) {
                return;
            }
            this.f22329a.setImageResource(R$drawable.hs_ad_link);
            this.f22330b.setText(R$string.copy_link);
            this.f22331c.setVisibility(8);
        }
    }
}
