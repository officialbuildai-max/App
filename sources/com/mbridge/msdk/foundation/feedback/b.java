package com.mbridge.msdk.foundation.feedback;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.feedback.bean.a;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static int f35341d = -2;

    /* renamed from: e, reason: collision with root package name */
    public static int f35342e = -2;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f35343f;

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout.LayoutParams f35344a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.feedback.bean.a> f35345b;

    /* renamed from: c, reason: collision with root package name */
    private g f35346c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.foundation.feedback.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0486b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f35347a = new b();
    }

    private b() {
        this.f35344a = new RelativeLayout.LayoutParams(f35342e, f35341d);
        this.f35345b = new ConcurrentHashMap<>();
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity a11 = a(context);
        if (a11 == null || mBFeedBackDialog == null || a11.isDestroyed()) {
            return false;
        }
        try {
            if (mBFeedBackDialog.isShowing() || a11.isFinishing()) {
                return false;
            }
            mBFeedBackDialog.show();
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static b b() {
        return C0486b.f35347a;
    }

    private com.mbridge.msdk.foundation.feedback.bean.a c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c.m().b();
        }
        if (this.f35345b.containsKey(str)) {
            return this.f35345b.get(str);
        }
        return null;
    }

    public Activity a(Context context) {
        Activity activity;
        Activity activity2;
        Context f11 = c.m().f();
        Activity activity3 = null;
        try {
            activity = f11 instanceof Activity ? (Activity) f11 : null;
        } catch (Exception e11) {
            e = e11;
        }
        try {
            if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                activity = (Activity) context;
            }
            WeakReference<Activity> a11 = c.m().a();
            if (a11 != null && (activity2 = a11.get()) != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
                activity = activity2;
            }
            if (activity == null || activity.isFinishing()) {
                return null;
            }
            if (activity.isDestroyed()) {
                return null;
            }
            return activity;
        } catch (Exception e12) {
            e = e12;
            activity3 = activity;
            e.printStackTrace();
            return activity3;
        }
    }

    public FeedBackButton a(String str) {
        return b(str).i();
    }

    public void a(String str, int i11) {
        b(str).b(i11);
    }

    public void a(String str, int i11, int i12, int i13, float f11, float f12, float f13, String str2, String str3, float f14, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.feedback.bean.a b11 = b(str);
        Context d11 = c.m().d();
        b11.a(t0.a(d11, f11), t0.a(d11, f12), t0.a(d11, i11), t0.a(d11, i12), t0.a(d11, i13), f13, str2, str3, f14, jSONArray);
    }

    public void a(String str, int i11, int i12, String str2, String str3) {
        com.mbridge.msdk.foundation.feedback.bean.a c11 = c(str + "_1");
        if (c11 == null) {
            c11 = c(str + "_2");
            if (c11 == null) {
                c11 = c(str + "_3");
                if (c11 == null) {
                    c11 = c(str + "_4");
                    if (c11 == null) {
                        c11 = b(str);
                    }
                }
            }
            c11.c(0);
        }
        if (c11 != null) {
            CampaignEx h11 = c11.h();
            j.a(h11, h11 != null ? h11.getCampaignUnitId() : "", c11.k(), c11.j(), !TextUtils.isEmpty(str2) ? str2 : "", i11, h11 != null ? h11.getAdType() : 0, i12, str3);
        }
    }

    public void a(String str, int i11, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.feedback.bean.a b11 = b(str);
        if (b11.i() != null) {
            b11.d(i11);
            if (i11 == 0) {
                a(str, c.m().d(), viewGroup, (ViewGroup.LayoutParams) null, (com.mbridge.msdk.foundation.feedback.a) null);
            }
        }
    }

    public void a(String str, int i11, com.mbridge.msdk.foundation.feedback.a aVar) {
        com.mbridge.msdk.foundation.feedback.bean.a b11 = b(str);
        b11.a(new a.g(str, aVar));
        if (i11 == 1) {
            b11.g();
        } else {
            b11.p();
        }
    }

    public void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.mbridge.msdk.foundation.feedback.a aVar) {
        if (a()) {
            com.mbridge.msdk.foundation.feedback.bean.a b11 = b(str);
            if (aVar != null) {
                b11.a(new a.g(str, aVar));
            }
            FeedBackButton i11 = b11.i();
            if (i11 != null) {
                if (layoutParams == null) {
                    int a11 = t0.a(c.m().d(), 10.0f);
                    this.f35344a.setMargins(a11, a11, a11, a11);
                    layoutParams = this.f35344a;
                }
                ViewGroup viewGroup2 = (ViewGroup) i11.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(i11);
                }
                Activity a12 = a(context);
                if (a12 != null && viewGroup == null) {
                    viewGroup = (ViewGroup) a12.findViewById(R.id.content);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(i11);
                    viewGroup.addView(i11, layoutParams);
                }
            }
        }
    }

    public void a(String str, CampaignEx campaignEx) {
        b(str).a(campaignEx);
    }

    public void a(String str, com.mbridge.msdk.foundation.feedback.a aVar) {
        com.mbridge.msdk.foundation.feedback.bean.a b11 = b(str);
        if (aVar != null) {
            b11.a(new a.g(str, aVar));
        }
    }

    public void a(String str, FeedBackButton feedBackButton) {
        b(str).a(feedBackButton);
    }

    public void a(String str, String str2) {
        b(str).b(str2);
    }

    public boolean a() {
        g d11 = h.b().d(c.m().b());
        this.f35346c = d11;
        if (d11 != null) {
            return false;
        }
        this.f35346c = h.b().a();
        return false;
    }

    public boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog != null) {
            return a(context, mBFeedBackDialog);
        }
        o0.c("", "mbAlertDialog  is null");
        return false;
    }

    public com.mbridge.msdk.foundation.feedback.bean.a b(String str) {
        com.mbridge.msdk.foundation.feedback.bean.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = c.m().b();
        }
        if (this.f35345b.containsKey(str)) {
            aVar = this.f35345b.get(str);
        } else {
            aVar = new com.mbridge.msdk.foundation.feedback.bean.a(str);
            this.f35345b.put(str, aVar);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.feedback.bean.a aVar2 = new com.mbridge.msdk.foundation.feedback.bean.a(str);
        this.f35345b.put(str, aVar2);
        return aVar2;
    }

    public void b(String str, int i11) {
        b(str).c(i11);
    }

    public void d(String str) {
        try {
            com.mbridge.msdk.foundation.feedback.bean.a c11 = c(str);
            if (c11 != null) {
                c11.f();
            }
            this.f35345b.remove(str);
            f35343f = false;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
