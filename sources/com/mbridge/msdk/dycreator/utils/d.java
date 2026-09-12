package com.mbridge.msdk.dycreator.utils;

import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class d {
    public static Object a(Object obj, String str) {
        Method method;
        try {
            try {
                method = obj.getClass().getMethod(str, null);
                if (method != null) {
                    try {
                        return method.invoke(obj, null);
                    } catch (NoSuchMethodException unused) {
                        if (obj instanceof com.mbridge.msdk.dycreator.viewdata.base.a) {
                            method = ((com.mbridge.msdk.dycreator.viewdata.base.a) obj).getBindData().getClass().getMethod(str, null);
                        }
                        if (method != null) {
                            return method.invoke(((com.mbridge.msdk.dycreator.viewdata.base.a) obj).getBindData(), null);
                        }
                        return null;
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        return null;
    }

    public static String a(boolean z10, int i11, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2) || !str2.contains("zh")) {
            return str + " " + i11 + "s";
        }
        if (z10) {
            return str + i11 + "s";
        }
        return i11 + "s " + str;
    }

    public static void a(String str, View view, boolean z10) {
        if (view == null || !(view instanceof InterBase) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("\\|");
            if (split == null || split.length < 2 || TextUtils.isEmpty(split[0]) || !split[0].startsWith("visible") || TextUtils.isEmpty(split[1]) || !split[1].equals("parent") || !z10) {
                return;
            }
            view.setVisibility(8);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(View view, com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        String[] split;
        if (view == 0) {
            return true;
        }
        try {
            if (!(view instanceof InterBase) || aVar == null) {
                return true;
            }
            String actionDes = ((InterBase) view).getActionDes();
            if (TextUtils.isEmpty(actionDes) || (split = actionDes.split("\\|")) == null || split.length < 2 || TextUtils.isEmpty(split[0]) || !split[0].startsWith("click") || TextUtils.isEmpty(split[1]) || !split[1].equals("alecfc") || aVar.getEffectData() == null) {
                return true;
            }
            return aVar.getEffectData().isClickScreen();
        } catch (Exception e11) {
            e11.printStackTrace();
            return true;
        }
    }
}
