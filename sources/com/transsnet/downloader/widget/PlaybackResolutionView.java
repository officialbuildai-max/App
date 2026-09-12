package com.transsnet.downloader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$color;
import com.transsion.memberapi.IPremiumApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import py.j1;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/transsnet/downloader/widget/PlaybackResolutionView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "resolution", "", "setResolution", "(Ljava/lang/String;)V", "Lpy/j1;", "a", "Lpy/j1;", "getBinding", "()Lpy/j1;", "binding", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class PlaybackResolutionView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final j1 binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public PlaybackResolutionView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlaybackResolutionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        j1 c11 = j1.c(LayoutInflater.from(context), this, true);
        Intrinsics.g(c11, "inflate(...)");
        this.binding = c11;
        setVisibility(8);
    }

    public /* synthetic */ PlaybackResolutionView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public final j1 getBinding() {
        return this.binding;
    }

    public final void setResolution(String resolution) {
        Intrinsics.h(resolution, "resolution");
        if (resolution.length() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a.C0856a.f(lg.a.f68962a, "premium_p", "PlaybackResolutionView --> setResolution() --> resolution = " + resolution, false, 4, null);
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        int t11 = iPremiumApi != null ? iPremiumApi.t() : 720;
        List S0 = StringsKt.S0(resolution, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = S0.iterator();
        while (it.hasNext()) {
            Integer valueOf = Integer.valueOf(com.transsnet.downloader.util.b0.f60044a.a(StringsKt.n1((String) it.next()).toString()));
            if (valueOf.intValue() <= 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                arrayList.add(valueOf);
            }
        }
        Integer num = (Integer) CollectionsKt.w0(arrayList);
        int intValue = num != null ? num.intValue() : 0;
        this.binding.f72903c.setText(intValue + "P");
        if (intValue >= t11) {
            this.binding.f72902b.setVisibility(0);
            this.binding.f72903c.setTextColor(getContext().getColor(R$color.color_FFDFB0));
        } else {
            this.binding.f72902b.setVisibility(8);
            this.binding.f72903c.setTextColor(getContext().getColor(R$color.white_80));
        }
    }
}
