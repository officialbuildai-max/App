package com.mbridge.msdk.dycreator.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static volatile f f34950b;

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.engine.b f34951a;

    private f(Context context) {
        this.f34951a = null;
        com.mbridge.msdk.dycreator.engine.b a11 = com.mbridge.msdk.dycreator.engine.b.a();
        this.f34951a = a11;
        a11.a(context, "");
    }

    public static f a(Context context) {
        if (f34950b == null) {
            synchronized (f.class) {
                try {
                    if (f34950b == null) {
                        f34950b = new f(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f34950b;
    }

    public View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && !TextUtils.isEmpty(str)) {
            if (viewGroup.getId() == str.hashCode()) {
                return viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt.getId() == str.hashCode()) {
                    return childAt;
                }
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, str);
                }
            }
        }
        return null;
    }

    public View a(String str) {
        if (new File(str).exists()) {
            return this.f34951a.e(str);
        }
        return null;
    }
}
