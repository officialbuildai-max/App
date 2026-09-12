package com.transsion.ad.bidding.base;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private final Context f41946a;

    public u(Context context) {
        Intrinsics.h(context, "context");
        this.f41946a = context;
    }

    public abstract AdChoicesView a();

    public abstract AdCloseView b();

    public abstract TextView c();

    public final List d(TNativeView nativeView, TaNativeInfo nativeInfo) {
        Intrinsics.h(nativeView, "nativeView");
        Intrinsics.h(nativeInfo, "nativeInfo");
        ArrayList arrayList = new ArrayList();
        MediaView g11 = g();
        if (g11 != null) {
            nativeView.setMediaView(g11, ImageView.ScaleType.FIT_XY);
            arrayList.add(g11);
        }
        ImageView f11 = f();
        if (f11 != null) {
            nativeView.setIconView(f11);
            arrayList.add(f11);
        }
        AdChoicesView a11 = a();
        if (a11 != null) {
            nativeView.setAdChoiceView(a11);
            arrayList.add(a11);
        }
        AdCloseView b11 = b();
        if (b11 != null) {
            nativeView.setAdCloseView(b11);
            arrayList.add(b11);
        }
        StoreMarkView h11 = h();
        if (h11 != null) {
            nativeView.setPsMarkView(h11);
            arrayList.add(h11);
        }
        TextView j11 = j();
        if (j11 != null) {
            j11.setText(nativeInfo.getTitle());
            arrayList.add(j11);
        }
        TextView e11 = e();
        if (e11 != null) {
            e11.setText(nativeInfo.getDescription());
            arrayList.add(e11);
        }
        TextView c11 = c();
        if (c11 != null) {
            c11.setText(nativeInfo.getCtatext());
            arrayList.add(c11);
        }
        nativeView.addView(i());
        return arrayList;
    }

    public abstract TextView e();

    public abstract ImageView f();

    public abstract MediaView g();

    public abstract StoreMarkView h();

    public abstract View i();

    public abstract TextView j();
}
