package com.transsion.home.fragment.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.tn.lib.widget.R$color;
import com.transsion.mb.config.manager.ConfigBean;
import ej.f;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class v {

    /* renamed from: b, reason: collision with root package name */
    public static final a f45241b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f45242c = 8;

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f45243a;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public v(ImageView ivNovelIcon) {
        Intrinsics.h(ivNovelIcon, "ivNovelIcon");
        this.f45243a = ivNovelIcon;
        b();
    }

    private final void b() {
        ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), "sa_novel_icon_config", false, 2, null);
        String value = d11 != null ? d11.getValue() : null;
        if (value == null || value.length() == 0) {
            jg.c.g(this.f45243a);
            return;
        }
        try {
            final HomeNovelIconBean homeNovelIconBean = (HomeNovelIconBean) com.blankj.utilcode.util.o.d(value, HomeNovelIconBean.class);
            String deeplink = homeNovelIconBean.getDeeplink();
            if (deeplink != null && deeplink.length() != 0) {
                String icUrl = homeNovelIconBean.getIcUrl();
                if (icUrl != null) {
                    f.a aVar = ej.f.f62005a;
                    Context context = this.f45243a.getContext();
                    Intrinsics.g(context, "getContext(...)");
                    aVar.m(context).g(icUrl).i(R$color.transparent).d(this.f45243a);
                }
                jg.c.k(this.f45243a);
                d();
                this.f45243a.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        v.c(v.this, homeNovelIconBean, view);
                    }
                });
                return;
            }
            jg.c.g(this.f45243a);
        } catch (Throwable unused) {
            jg.c.g(this.f45243a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(v vVar, HomeNovelIconBean homeNovelIconBean, View view) {
        vVar.e();
        ak.k.h(homeNovelIconBean.getDeeplink(), null, 1, null);
    }

    private final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", RewardPlus.ICON);
        linkedHashMap.put("item_type", "novel");
        hj.i.f64628a.D("Trending", linkedHashMap);
    }

    private final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", RewardPlus.ICON);
        linkedHashMap.put("item_type", "novel");
        hj.i.f64628a.p("Trending", linkedHashMap);
    }
}
